package com.survicate.surveys;

import android.content.Context;
import android.util.Log;
import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.core.utils.Executor;
import com.survicate.surveys.core.utils.WorkspaceUtils;
import com.survicate.surveys.entities.survey.Workspace;
import com.survicate.surveys.helpers.LogTags;
import com.survicate.surveys.helpers.UserTraitUtils;
import com.survicate.surveys.infrastructure.environment.WorkspaceKeyStore;
import com.survicate.surveys.infrastructure.storage.contacts.ContactAttributesThrottle;
import com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository;
import com.survicate.surveys.infrastructure.storage.contacts.LogoutUtils;
import com.survicate.surveys.infrastructure.storage.interfaces.LocaleStore;
import com.survicate.surveys.infrastructure.storage.interfaces.SurvicateFontSystemStore;
import com.survicate.surveys.infrastructure.storage.respondent.RespondentRepository;
import com.survicate.surveys.presentation.base.DisplayEngine;
import com.survicate.surveys.targeting.TargetingEngine;
import com.survicate.surveys.traits.UserTrait;
import com.survicate.surveys.utils.DateUtils;
import com.survicate.surveys.utils.ThemeModeStore;
import com.survicate.surveys.utils.TimestampProvider;
import com.survicate.surveys.utils.UserTraitsValidator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes8.dex */
public class Survicate {
    private static final String LOG_TAG = "SurvicateSDK/8.3.0";
    public static final int WORKSPACE_REFRESH_PERIOD_MINUTES = 10;
    static Survicate instance;
    private static String workspaceKey;
    private final ContactAttributesThrottle attributesThrottle;
    private final ContactsRepository contactsRepository;
    final DisplayEngine displayEngine;
    private final EventManager eventManager;
    private final SurvicateFontSystemStore fontSystemStore;
    private final LocaleStore localeStore;
    private final SdkLogger logger;
    private final PersistenceManager persistenceManager;
    private final RespondentRepository respondentRepository;
    private final Executor sdkExecutor;
    private final TargetingEngine targetingEngine;
    private final ThemeModeStore themeModeStore;
    private final TimestampProvider timestampProvider;
    private final WorkspaceLoader workspaceLoader;

    private Survicate(SurvicateComponent survicateComponent) {
        this.persistenceManager = survicateComponent.obtainPersistenceManager();
        this.eventManager = survicateComponent.obtainEventManager();
        DisplayEngine displayEngineObtainDisplayEngine = survicateComponent.obtainDisplayEngine();
        this.displayEngine = displayEngineObtainDisplayEngine;
        this.targetingEngine = survicateComponent.obtainTargetingEngine();
        WorkspaceLoader workspaceLoaderObtainWorkspaceLoader = survicateComponent.obtainWorkspaceLoader();
        this.workspaceLoader = workspaceLoaderObtainWorkspaceLoader;
        displayEngineObtainDisplayEngine.setWorkspaceReloadAction(workspaceLoaderObtainWorkspaceLoader);
        this.localeStore = survicateComponent.provideLocaleStore();
        this.themeModeStore = survicateComponent.provideThemeModeStore();
        this.fontSystemStore = survicateComponent.provideFontSystemStore();
        this.respondentRepository = survicateComponent.provideRespondentRepository();
        this.contactsRepository = survicateComponent.provideContactsRepository();
        this.attributesThrottle = survicateComponent.provideContactAttributesThrottle();
        this.timestampProvider = survicateComponent.provideTimestampProvider();
        this.sdkExecutor = survicateComponent.provideSdkExecutor();
        this.logger = survicateComponent.provideLogger();
    }

    public static void init(Context context) {
        init(context, false);
    }

    public static void init(Context context, boolean z) {
        if (instance == null) {
            SurvicateComponent survicateComponent = new SurvicateComponent(context.getApplicationContext(), z);
            WorkspaceKeyStore workspaceKeyStoreObtainWorkspaceKeyStore = survicateComponent.obtainWorkspaceKeyStore();
            String str = workspaceKey;
            if (str != null) {
                workspaceKeyStoreObtainWorkspaceKeyStore.setWorkspaceKey(str);
            }
            if (!WorkspaceUtils.INSTANCE.isWorkspaceKeyValid(workspaceKeyStoreObtainWorkspaceKeyStore.getWorkspaceKey())) {
                Log.e(LOG_TAG, "Workspace Key is not valid. Please double check the key provided in AndroidManifest.xml meta-data or by setWorkspaceKey method");
                return;
            }
            Survicate survicate = new Survicate(survicateComponent);
            survicate.respondentRepository.init();
            survicate.contactsRepository.init();
            survicate.workspaceLoader.loadWorkspace(true);
            instance = survicate;
        }
    }

    public static void setLocale(String str) {
        if (!isInitialized()) {
            logNotInitialized();
        } else {
            instance.localeStore.saveLocale(str);
        }
    }

    public static void setUserTraits(final List<UserTrait> list) {
        if (!isInitialized()) {
            logNotInitialized();
        } else {
            instance.sdkExecutor.post(new Function0() { // from class: com.survicate.surveys.Survicate$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Survicate.lambda$setUserTraits$0(list);
                }
            });
        }
    }

    static /* synthetic */ Unit lambda$setUserTraits$0(List list) {
        instance.setUserTraitsInternal(list);
        return Unit.INSTANCE;
    }

    public static void setUserTrait(UserTrait userTrait) {
        if (!isInitialized()) {
            logNotInitialized();
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(userTrait);
        setUserTraits(arrayList);
    }

    private void setUserTraitsInternal(List<UserTrait> list) {
        List<UserTrait> listFilterOutInvalidTraits = UserTraitsValidator.filterOutInvalidTraits(list);
        List<UserTrait> listProvideUserTraits = this.persistenceManager.provideUserTraits();
        if (LogoutUtils.INSTANCE.shouldClearUserData(listFilterOutInvalidTraits, listProvideUserTraits)) {
            this.attributesThrottle.flush();
        }
        long jCurrentTimeMillis = this.timestampProvider.currentTimeMillis();
        Iterator<UserTrait> it = listFilterOutInvalidTraits.iterator();
        while (it.hasNext()) {
            UserTraitUtils.updateTimestamp(it.next(), jCurrentTimeMillis);
        }
        List<UserTrait> listUpdateThrottleTimestamps = this.attributesThrottle.updateThrottleTimestamps(listFilterOutInvalidTraits, listProvideUserTraits);
        this.contactsRepository.updateUserTraits(this.attributesThrottle.getTraitsReadyToSend(listUpdateThrottleTimestamps), listProvideUserTraits);
        this.persistenceManager.saveTraits(listUpdateThrottleTimestamps);
    }

    public static void setResponseAttribute(ResponseAttribute responseAttribute) {
        if (!isInitialized()) {
            logNotInitialized();
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(responseAttribute);
        instance.persistenceManager.saveResponseAttributes(arrayList);
    }

    public static void setResponseAttributes(List<ResponseAttribute> list) {
        if (!isInitialized()) {
            logNotInitialized();
        } else {
            instance.persistenceManager.saveResponseAttributes(list);
        }
    }

    public static void setThemeMode(ThemeMode themeMode) {
        if (!isInitialized()) {
            logNotInitialized();
        } else {
            instance.themeModeStore.saveThemeMode(themeMode);
        }
    }

    public static void setFonts(SurvicateFontSystem survicateFontSystem) {
        if (!isInitialized()) {
            logNotInitialized();
        } else {
            instance.fontSystemStore.saveFontSystem(survicateFontSystem);
        }
    }

    public static void enterScreen(String str) {
        if (!isInitialized()) {
            logNotInitialized();
        } else {
            instance.resetIfOutdated();
            instance.targetingEngine.userEntersScreen(str);
        }
    }

    public static void leaveScreen(String str) {
        if (!isInitialized()) {
            logNotInitialized();
        } else {
            instance.resetIfOutdated();
            instance.targetingEngine.userLeavesScreen(str);
        }
    }

    public static void invokeEvent(String str) {
        invokeEvent(str, Collections.emptyMap());
    }

    public static void invokeEvent(String str, Map<String, String> map) {
        if (!isInitialized()) {
            logNotInitialized();
        } else if (str.isEmpty()) {
            instance.logger.warn(LogTags.EVENTS, "Event name cannot be empty.", null);
        } else {
            instance.resetIfOutdated();
            instance.targetingEngine.invokeEvent(str, map);
        }
    }

    public static void addEventListener(SurvicateEventListener survicateEventListener) {
        if (!isInitialized()) {
            logNotInitialized();
        } else {
            instance.eventManager.addListener(survicateEventListener);
        }
    }

    public static void removeEventListener(SurvicateEventListener survicateEventListener) {
        if (!isInitialized()) {
            logNotInitialized();
        } else {
            instance.eventManager.removeListener(survicateEventListener);
        }
    }

    public static void clearListeners() {
        if (!isInitialized()) {
            logNotInitialized();
        } else {
            instance.eventManager.clearListeners();
        }
    }

    public static void reset() {
        if (!isInitialized()) {
            logNotInitialized();
            return;
        }
        instance.displayEngine.forceClose();
        instance.persistenceManager.clearAll();
        instance.respondentRepository.clear();
        instance.targetingEngine.clearAll();
        instance.localeStore.reset();
        instance.themeModeStore.reset();
        instance.workspaceLoader.loadWorkspace(true);
    }

    public static void setWorkspaceKey(String str) {
        if (isInitialized()) {
            instance.logger.error(LogTags.WORKSPACE, "Workspace key cannot be set after the SDK initialization.", new IllegalStateException("Workspace key cannot be set after the SDK initialization."));
        } else {
            workspaceKey = str;
        }
    }

    private static boolean isInitialized() {
        return instance != null;
    }

    private static void logNotInitialized() {
        Log.e(LOG_TAG, "You need to initialize the SDK before using its methods.");
    }

    private void resetIfOutdated() {
        Workspace workspace = this.persistenceManager.getWorkspace();
        if (workspace == null || DateUtils.differenceBetweenDates(workspace.getLastUpdatedAt(), new Date(), TimeUnit.MINUTES) > 10) {
            this.workspaceLoader.loadWorkspace(false);
        }
    }
}
