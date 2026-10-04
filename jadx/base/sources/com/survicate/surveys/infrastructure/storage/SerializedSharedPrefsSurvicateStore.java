package com.survicate.surveys.infrastructure.storage;

import android.content.SharedPreferences;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.entities.models.ActiveEventHistory;
import com.survicate.surveys.entities.models.ContactAction;
import com.survicate.surveys.helpers.LogTags;
import com.survicate.surveys.infrastructure.serialization.SurvicateSerializer;
import com.survicate.surveys.infrastructure.storage.contacts.ContactActionSerializer;
import com.survicate.surveys.traits.UserTrait;
import com.survicate.surveys.utils.MiscUtilsKt;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SerializedSharedPrefsSurvicateStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001BB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0016\u0010\u0015\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000fH\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000fH\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0013H\u0016J\u0016\u0010\u001e\u001a\u00020\r2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130 H\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130 H\u0016J\u001c\u0010\"\u001a\u00020\r2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%0$H\u0016J\u0014\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%0$H\u0016J\u001c\u0010'\u001a\u00020\r2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%0$H\u0016J\u0014\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%0$H\u0016J\u001c\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%0$2\u0006\u0010*\u001a\u00020\u0013H\u0002J\u0016\u0010+\u001a\u00020\r2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u000fH\u0016J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u000fH\u0016J\u0016\u0010/\u001a\u00020\r2\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u000fH\u0016J\u000e\u00102\u001a\b\u0012\u0004\u0012\u0002010\u000fH\u0016J\u0017\u00103\u001a\u00020\r2\b\u00104\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0002\u00105J\u000f\u00106\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0002\u00107J\b\u00108\u001a\u00020\rH\u0016J\b\u00109\u001a\u00020\rH\u0016J\b\u0010:\u001a\u00020\rH\u0002J\u000f\u0010;\u001a\u0004\u0018\u00010<H\u0002¢\u0006\u0002\u0010=J\u001e\u0010>\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010?\u001a\u00020<H\u0002J \u0010@\u001a\u0004\u0018\u00010\u00102\u0006\u0010A\u001a\u00020<2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/SerializedSharedPrefsSurvicateStore;", "Lcom/survicate/surveys/infrastructure/storage/SurvicateStore;", "preferences", "Landroid/content/SharedPreferences;", "serializer", "Lcom/survicate/surveys/infrastructure/serialization/SurvicateSerializer;", "contactActionSerializer", "Lcom/survicate/surveys/infrastructure/storage/contacts/ContactActionSerializer;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "<init>", "(Landroid/content/SharedPreferences;Lcom/survicate/surveys/infrastructure/serialization/SurvicateSerializer;Lcom/survicate/surveys/infrastructure/storage/contacts/ContactActionSerializer;Lcom/survicate/surveys/core/logging/SdkLogger;)V", "migrateSchemaIfNeeded", "", "migrations", "", "Lcom/survicate/surveys/infrastructure/storage/SurvicateStoreMigration;", "saveCurrentSdkVersion", "versionName", "", "loadSavedSdkVersion", "saveUserTraits", "traits", "Lcom/survicate/surveys/traits/UserTrait;", "loadTraits", "findUserTrait", "attribute", "saveVisitorUuid", SerializedSharedPrefsSurvicateStore.VISITOR_UUID_KEY, "loadVisitorUuid", "saveSeenSurveyIds", SerializedSharedPrefsSurvicateStore.SEEN_SURVEY_IDS_KEY, "", "loadSeenSurveyIds", "saveSurveysFirstPresentationTimes", "presentationTimes", "", "", "loadFirstPresentationTimes", "saveSurveysLastPresentationTimes", "loadLastPresentationTimes", "loadPresentationTimes", SubscriberAttributeKt.JSON_NAME_KEY, "saveEventsHistory", "eventsHistory", "Lcom/survicate/surveys/entities/models/ActiveEventHistory;", "loadEventsHistory", "saveContactActions", "actions", "Lcom/survicate/surveys/entities/models/ContactAction;", "loadContactActions", "saveRespondentVerificationTimeMs", "timeMs", "(Ljava/lang/Long;)V", "loadRespondentVerificationTimeMs", "()Ljava/lang/Long;", "clearUserData", "clear", "saveCurrentSchemaVersion", "loadSavedSchemaVersion", "", "()Ljava/lang/Integer;", "runMigrations", "savedSchemaVersion", "findMatchingMigration", "targetSchemaVersion", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SerializedSharedPrefsSurvicateStore implements SurvicateStore {
    private static final String CONTACT_ACTIONS_KEY = "contactActionsKey";
    private static final String EVENTS_HISTORY_KEY = "eventsHistoryKey";
    private static final String FIRST_PRESENTATION_TIMES_KEY = "firstPresentationTimesKey";
    private static final String LAST_PRESENTATION_TIMES_KEY = "lastPresentationTimesKey";
    private static final String RESPONDENT_VERIFICATION_TIME_KEY = "respondentVerificationTimeKey";
    public static final int SCHEMA_VERSION = 4;
    private static final String SCHEMA_VERSION_KEY = "persistenceSchemaVersion";
    private static final String SDK_VERSION_KEY = "sdkVersionKey";
    private static final String SEEN_SURVEY_IDS_KEY = "seenSurveyIds";
    private static final String USER_TRAITS_KEY = "userTraits";
    private static final String VISITOR_UUID_KEY = "visitorUuid";
    private final ContactActionSerializer contactActionSerializer;
    private final SdkLogger logger;
    private final SharedPreferences preferences;
    private final SurvicateSerializer serializer;

    public SerializedSharedPrefsSurvicateStore(SharedPreferences preferences, SurvicateSerializer serializer, ContactActionSerializer contactActionSerializer, SdkLogger logger) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(contactActionSerializer, "contactActionSerializer");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.preferences = preferences;
        this.serializer = serializer;
        this.contactActionSerializer = contactActionSerializer;
        this.logger = logger;
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public void migrateSchemaIfNeeded(List<? extends SurvicateStoreMigration> migrations) {
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        Integer numLoadSavedSchemaVersion = loadSavedSchemaVersion();
        if (numLoadSavedSchemaVersion == null) {
            saveCurrentSchemaVersion();
            return;
        }
        if (numLoadSavedSchemaVersion.intValue() > 4) {
            clear();
        }
        if (numLoadSavedSchemaVersion.intValue() < 4) {
            runMigrations(migrations, numLoadSavedSchemaVersion.intValue());
        }
        if (numLoadSavedSchemaVersion.intValue() != 4) {
            saveCurrentSchemaVersion();
        }
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public void saveCurrentSdkVersion(String versionName) {
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        this.preferences.edit().putString(SDK_VERSION_KEY, versionName).apply();
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public String loadSavedSdkVersion() {
        try {
            String string = this.preferences.getString(SDK_VERSION_KEY, "");
            Intrinsics.checkNotNull(string);
            return string;
        } catch (Exception e) {
            this.logger.error(LogTags.PERSISTENCE, "Failed to load SDK version", e);
            return "";
        }
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public void saveUserTraits(List<? extends UserTrait> traits) {
        Intrinsics.checkNotNullParameter(traits, "traits");
        this.preferences.edit().putString(USER_TRAITS_KEY, this.serializer.serializeTraits(traits)).apply();
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public List<UserTrait> loadTraits() {
        if (!this.preferences.contains(USER_TRAITS_KEY)) {
            return CollectionsKt.emptyList();
        }
        try {
            SurvicateSerializer survicateSerializer = this.serializer;
            String string = this.preferences.getString(USER_TRAITS_KEY, "");
            Intrinsics.checkNotNull(string);
            return survicateSerializer.deserializeUserTraits(string);
        } catch (Exception e) {
            this.logger.error(LogTags.PERSISTENCE, "Failed to deserialize user traits", e);
            return CollectionsKt.emptyList();
        }
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public UserTrait findUserTrait(String attribute) {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        for (UserTrait userTrait : loadTraits()) {
            if (Intrinsics.areEqual(userTrait.key, attribute)) {
                return userTrait;
            }
        }
        return null;
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public void saveVisitorUuid(String visitorUuid) {
        Intrinsics.checkNotNullParameter(visitorUuid, "visitorUuid");
        this.preferences.edit().putString(VISITOR_UUID_KEY, visitorUuid).apply();
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public String loadVisitorUuid() {
        try {
            return this.preferences.getString(VISITOR_UUID_KEY, null);
        } catch (Exception e) {
            this.logger.error(LogTags.PERSISTENCE, "Failed to load visitor uuid", e);
            return null;
        }
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public void saveSeenSurveyIds(Set<String> seenSurveyIds) {
        Intrinsics.checkNotNullParameter(seenSurveyIds, "seenSurveyIds");
        this.preferences.edit().putStringSet(SEEN_SURVEY_IDS_KEY, seenSurveyIds).apply();
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public Set<String> loadSeenSurveyIds() {
        try {
            Set<String> stringSet = this.preferences.getStringSet(SEEN_SURVEY_IDS_KEY, SetsKt.emptySet());
            Intrinsics.checkNotNull(stringSet);
            return stringSet;
        } catch (Exception e) {
            this.logger.error(LogTags.PERSISTENCE, "Failed to load seen survey ids", e);
            return SetsKt.emptySet();
        }
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public void saveSurveysFirstPresentationTimes(Map<String, Long> presentationTimes) {
        Intrinsics.checkNotNullParameter(presentationTimes, "presentationTimes");
        this.preferences.edit().putString(FIRST_PRESENTATION_TIMES_KEY, this.serializer.serializePresentationTimesMap(presentationTimes)).apply();
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public Map<String, Long> loadFirstPresentationTimes() {
        return loadPresentationTimes(FIRST_PRESENTATION_TIMES_KEY);
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public void saveSurveysLastPresentationTimes(Map<String, Long> presentationTimes) {
        Intrinsics.checkNotNullParameter(presentationTimes, "presentationTimes");
        this.preferences.edit().putString(LAST_PRESENTATION_TIMES_KEY, this.serializer.serializePresentationTimesMap(presentationTimes)).apply();
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public Map<String, Long> loadLastPresentationTimes() {
        return loadPresentationTimes(LAST_PRESENTATION_TIMES_KEY);
    }

    private final Map<String, Long> loadPresentationTimes(String key) {
        if (!this.preferences.contains(key)) {
            return MapsKt.emptyMap();
        }
        try {
            String string = this.preferences.getString(key, "");
            Intrinsics.checkNotNull(string);
            return MiscUtilsKt.filterOutNullValues(this.serializer.deserializePresentationTimesMap(string));
        } catch (Exception e) {
            this.logger.error(LogTags.PERSISTENCE, "Failed to deserialize presentation times", e);
            return MapsKt.emptyMap();
        }
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public void saveEventsHistory(List<ActiveEventHistory> eventsHistory) {
        Intrinsics.checkNotNullParameter(eventsHistory, "eventsHistory");
        this.preferences.edit().putString(EVENTS_HISTORY_KEY, this.serializer.serializeEventsHistory(eventsHistory)).apply();
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public List<ActiveEventHistory> loadEventsHistory() {
        if (!this.preferences.contains(EVENTS_HISTORY_KEY)) {
            return CollectionsKt.emptyList();
        }
        try {
            SurvicateSerializer survicateSerializer = this.serializer;
            String string = this.preferences.getString(EVENTS_HISTORY_KEY, "");
            Intrinsics.checkNotNull(string);
            return survicateSerializer.deserializeEventsHistory(string);
        } catch (Exception e) {
            this.logger.error(LogTags.PERSISTENCE, "Failed to deserialize events history", e);
            return CollectionsKt.emptyList();
        }
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public void saveContactActions(List<? extends ContactAction> actions) {
        Intrinsics.checkNotNullParameter(actions, "actions");
        this.preferences.edit().putString(CONTACT_ACTIONS_KEY, this.contactActionSerializer.serializeContactActions(actions)).apply();
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public List<ContactAction> loadContactActions() {
        if (!this.preferences.contains(CONTACT_ACTIONS_KEY)) {
            return CollectionsKt.emptyList();
        }
        try {
            ContactActionSerializer contactActionSerializer = this.contactActionSerializer;
            String string = this.preferences.getString(CONTACT_ACTIONS_KEY, "");
            Intrinsics.checkNotNull(string);
            return contactActionSerializer.deserializeContactActions(string);
        } catch (Exception e) {
            this.logger.error(LogTags.PERSISTENCE, "Failed to deserialize contact actions", e);
            return CollectionsKt.emptyList();
        }
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public void saveRespondentVerificationTimeMs(Long timeMs) {
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        if (timeMs != null) {
            editorEdit.putLong(RESPONDENT_VERIFICATION_TIME_KEY, timeMs.longValue());
        } else {
            editorEdit.remove(RESPONDENT_VERIFICATION_TIME_KEY);
        }
        editorEdit.apply();
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public Long loadRespondentVerificationTimeMs() {
        try {
            long j = this.preferences.getLong(RESPONDENT_VERIFICATION_TIME_KEY, -1L);
            if (j == -1) {
                return null;
            }
            return Long.valueOf(j);
        } catch (Exception e) {
            this.logger.error(LogTags.PERSISTENCE, "Failed to load respondent verification time", e);
            return null;
        }
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public void clearUserData() {
        List<ContactAction> listLoadContactActions = loadContactActions();
        clear();
        saveContactActions(listLoadContactActions);
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStore
    public void clear() {
        int i = this.preferences.getInt(SCHEMA_VERSION_KEY, -1);
        String string = this.preferences.getString(SDK_VERSION_KEY, null);
        this.preferences.edit().clear().apply();
        if (i != -1) {
            this.preferences.edit().putInt(SCHEMA_VERSION_KEY, i).apply();
        }
        if (string != null) {
            this.preferences.edit().putString(SDK_VERSION_KEY, string).apply();
        }
    }

    private final void saveCurrentSchemaVersion() {
        this.preferences.edit().putInt(SCHEMA_VERSION_KEY, 4).apply();
    }

    private final Integer loadSavedSchemaVersion() {
        int i = this.preferences.getInt(SCHEMA_VERSION_KEY, -1);
        if (i != -1) {
            return Integer.valueOf(i);
        }
        return null;
    }

    private final void runMigrations(List<? extends SurvicateStoreMigration> migrations, int savedSchemaVersion) {
        while (true) {
            savedSchemaVersion++;
            if (savedSchemaVersion >= 5) {
                return;
            }
            SurvicateStoreMigration survicateStoreMigrationFindMatchingMigration = findMatchingMigration(savedSchemaVersion, migrations);
            if (survicateStoreMigrationFindMatchingMigration == null) {
                throw new IllegalArgumentException(("Missing migration for schema version: " + savedSchemaVersion).toString());
            }
            survicateStoreMigrationFindMatchingMigration.migrate(this.preferences);
        }
    }

    private final SurvicateStoreMigration findMatchingMigration(int targetSchemaVersion, List<? extends SurvicateStoreMigration> migrations) {
        for (SurvicateStoreMigration survicateStoreMigration : migrations) {
            if (survicateStoreMigration.getTargetSchemaVersion() == targetSchemaVersion) {
                return survicateStoreMigration;
            }
        }
        return null;
    }
}
