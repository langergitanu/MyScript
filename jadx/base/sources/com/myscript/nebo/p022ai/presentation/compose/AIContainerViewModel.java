package com.myscript.nebo.p022ai.presentation.compose;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.preference.PreferenceManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.LaunchActivity;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.snt.core.PageKey;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: AIContainerViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\b\u0007\u0018\u0000 I2\u00020\u0001:\u0001IB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u0013J\u0006\u00103\u001a\u00020\"J\u0006\u00104\u001a\u00020\"J\u000e\u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020\rJ\u0016\u00107\u001a\u00020\"2\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\"0!J\u0010\u00109\u001a\u00020\"2\b\u0010:\u001a\u0004\u0018\u00010(J\u000e\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020/J\u0010\u0010=\u001a\u00020\"2\b\u0010:\u001a\u0004\u0018\u00010-J\u0014\u0010>\u001a\u00020\"2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\"0!J\u0006\u0010@\u001a\u00020\"J\u0006\u0010A\u001a\u00020\"J\u0006\u0010B\u001a\u00020\"J\u0014\u0010C\u001a\u00020\"2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\"0!J\u0006\u0010E\u001a\u00020\"J\u0006\u0010F\u001a\u00020\"J\u000e\u0010G\u001a\u00020\"2\u0006\u0010H\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0011R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00130\u00130\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u001c\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00130\u00130\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0011R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00100\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/compose/AIContainerViewModel;", "Landroidx/lifecycle/ViewModel;", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "sharedPreferences", "Landroid/content/SharedPreferences;", "uiDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "<init>", "(Lcom/myscript/nebo/dms/core/LibraryRepository;Landroid/content/SharedPreferences;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_isAIEnabled", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "isAIEnabled", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "_mode", "Lcom/myscript/nebo/ai/presentation/compose/AIMode;", "mode", "getMode", "_showMenu", "showMenu", "getShowMenu", "_actionsAvailability", "Lcom/myscript/nebo/ai/presentation/compose/ActionsAvailability;", "actionsAvailability", "getActionsAvailability", "_showSignInDialog", "showSignInDialog", "getShowSignInDialog", "pendingSignInAction", "Lkotlin/Function0;", "", LaunchActivity.LaunchRoute.Language, "", "getLanguage", "()Ljava/lang/String;", "textSelectionProvider", "Lcom/myscript/nebo/ai/presentation/compose/TextSelectionProvider;", "_lastActiveMode", "lastActiveMode", "getLastActiveMode", "userDataProvider", "Lcom/myscript/nebo/ai/presentation/compose/UserDataProvider;", "pagesCount", "", "lastOperation", "setMode", "newMode", "restoreLastMode", "toggleMenuVisibility", "setMenuVisibility", "visible", "updateAvailableActions", "onActionsUpdated", "setTextSelectionProvider", "provider", "updatePagesCount", "count", "setUserDataProvider", "runIfSignedIn", "action", "dismissSignInDialog", "onSignInSuccess", "onSignInCancelled", "saveLastOperation", "operation", "triggerLastOperation", "clearLastOperation", "setAIEnabled", "enabled", "Companion", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AIContainerViewModel extends ViewModel {
    public static final String AI_ENABLED_PREFS = "PREF_AI_ENABLED";
    public static final int EXPLAIN_MAX_LIMIT = 300;
    private static final ViewModelProvider.Factory Factory;
    public static final int QUIZ_MIN_LIMIT = 300;
    public static final int SUMMARIZE_MIN_LIMIT = 299;
    public static final String TAG = "AIContainerViewModel";
    private final MutableLiveData<ActionsAvailability> _actionsAvailability;
    private final MutableLiveData<Boolean> _isAIEnabled;
    private final MutableLiveData<AIMode> _lastActiveMode;
    private final MutableLiveData<AIMode> _mode;
    private final MutableLiveData<Boolean> _showMenu;
    private final MutableLiveData<Boolean> _showSignInDialog;
    private final LiveData<ActionsAvailability> actionsAvailability;
    private final CoroutineDispatcher ioDispatcher;
    private final LiveData<Boolean> isAIEnabled;
    private final LiveData<AIMode> lastActiveMode;
    private Function0<Unit> lastOperation;
    private final LibraryRepository libraryRepository;
    private final LiveData<AIMode> mode;
    private int pagesCount;
    private Function0<Unit> pendingSignInAction;
    private final SharedPreferences sharedPreferences;
    private final LiveData<Boolean> showMenu;
    private final LiveData<Boolean> showSignInDialog;
    private TextSelectionProvider textSelectionProvider;
    private final CoroutineDispatcher uiDispatcher;
    private UserDataProvider userDataProvider;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public AIContainerViewModel(LibraryRepository libraryRepository, SharedPreferences sharedPreferences, CoroutineDispatcher uiDispatcher, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(libraryRepository, "libraryRepository");
        Intrinsics.checkNotNullParameter(uiDispatcher, "uiDispatcher");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.libraryRepository = libraryRepository;
        this.sharedPreferences = sharedPreferences;
        this.uiDispatcher = uiDispatcher;
        this.ioDispatcher = ioDispatcher;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(false);
        this._isAIEnabled = mutableLiveData;
        this.isAIEnabled = mutableLiveData;
        MutableLiveData<AIMode> mutableLiveData2 = new MutableLiveData<>(AIMode.NONE);
        this._mode = mutableLiveData2;
        this.mode = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(false);
        this._showMenu = mutableLiveData3;
        this.showMenu = mutableLiveData3;
        MutableLiveData<ActionsAvailability> mutableLiveData4 = new MutableLiveData<>();
        this._actionsAvailability = mutableLiveData4;
        this.actionsAvailability = mutableLiveData4;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>(false);
        this._showSignInDialog = mutableLiveData5;
        this.showSignInDialog = mutableLiveData5;
        MutableLiveData<AIMode> mutableLiveData6 = new MutableLiveData<>(AIMode.NONE);
        this._lastActiveMode = mutableLiveData6;
        this.lastActiveMode = mutableLiveData6;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), uiDispatcher, null, new C61331(null), 2, null);
    }

    public /* synthetic */ AIContainerViewModel(LibraryRepository libraryRepository, SharedPreferences sharedPreferences, MainCoroutineDispatcher mainCoroutineDispatcher, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(libraryRepository, (i & 2) != 0 ? null : sharedPreferences, (i & 4) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher, (i & 8) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    public final LiveData<Boolean> isAIEnabled() {
        return this.isAIEnabled;
    }

    public final LiveData<AIMode> getMode() {
        return this.mode;
    }

    public final LiveData<Boolean> getShowMenu() {
        return this.showMenu;
    }

    public final LiveData<ActionsAvailability> getActionsAvailability() {
        return this.actionsAvailability;
    }

    public final LiveData<Boolean> getShowSignInDialog() {
        return this.showSignInDialog;
    }

    public final String getLanguage() {
        PageKey lastOpenedNoteKey = this.libraryRepository.getLastOpenedNoteKey();
        if (lastOpenedNoteKey != null) {
            PageModel page = this.libraryRepository.getPage(lastOpenedNoteKey);
            String languageTag = page != null ? page.getLanguageTag() : null;
            return languageTag != null ? languageTag : "en_US";
        }
        return "en_US";
    }

    public final LiveData<AIMode> getLastActiveMode() {
        return this.lastActiveMode;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.compose.AIContainerViewModel$1 */
    /* JADX INFO: compiled from: AIContainerViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.compose.AIContainerViewModel$1", m1609f = "AIContainerViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61331(Continuation<? super C61331> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIContainerViewModel.this.new C61331(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61331) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SharedPreferences sharedPreferences = AIContainerViewModel.this.sharedPreferences;
                AIContainerViewModel.this._isAIEnabled.setValue(Boxing.boxBoolean(Intrinsics.areEqual(sharedPreferences != null ? Boxing.boxBoolean(sharedPreferences.getBoolean(AIContainerViewModel.AI_ENABLED_PREFS, true)) : null, Boxing.boxBoolean(true))));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.compose.AIContainerViewModel$setMode$1 */
    /* JADX INFO: compiled from: AIContainerViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.compose.AIContainerViewModel$setMode$1", m1609f = "AIContainerViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AIMode $newMode;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C61361(AIMode aIMode, Continuation<? super C61361> continuation) {
            super(2, continuation);
            this.$newMode = aIMode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIContainerViewModel.this.new C61361(this.$newMode, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61361) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AIMode aIMode = (AIMode) AIContainerViewModel.this._mode.getValue();
                if (aIMode == null) {
                    aIMode = AIMode.NONE;
                }
                if (this.$newMode == AIMode.MINIMIZED) {
                    AIContainerViewModel.this._lastActiveMode.setValue(aIMode);
                }
                AIContainerViewModel.this._mode.setValue(this.$newMode);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void setMode(AIMode newMode) {
        Intrinsics.checkNotNullParameter(newMode, "newMode");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C61361(newMode, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.compose.AIContainerViewModel$restoreLastMode$1 */
    /* JADX INFO: compiled from: AIContainerViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.compose.AIContainerViewModel$restoreLastMode$1", m1609f = "AIContainerViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61341(Continuation<? super C61341> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIContainerViewModel.this.new C61341(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData = AIContainerViewModel.this._mode;
                AIMode aIMode = (AIMode) AIContainerViewModel.this._lastActiveMode.getValue();
                if (aIMode == null) {
                    aIMode = AIMode.NONE;
                }
                mutableLiveData.setValue(aIMode);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void restoreLastMode() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C61341(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.compose.AIContainerViewModel$toggleMenuVisibility$1 */
    /* JADX INFO: compiled from: AIContainerViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.compose.AIContainerViewModel$toggleMenuVisibility$1", m1609f = "AIContainerViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61371(Continuation<? super C61371> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIContainerViewModel.this.new C61371(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AIContainerViewModel.this._showMenu.setValue(((Boolean) AIContainerViewModel.this._showMenu.getValue()) != null ? Boxing.boxBoolean(!r0.booleanValue()) : null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void toggleMenuVisibility() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C61371(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.compose.AIContainerViewModel$setMenuVisibility$1 */
    /* JADX INFO: compiled from: AIContainerViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.compose.AIContainerViewModel$setMenuVisibility$1", m1609f = "AIContainerViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $visible;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C61351(boolean z, Continuation<? super C61351> continuation) {
            super(2, continuation);
            this.$visible = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIContainerViewModel.this.new C61351(this.$visible, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AIContainerViewModel.this._showMenu.setValue(Boxing.boxBoolean(this.$visible));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void setMenuVisibility(boolean visible) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C61351(visible, null), 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateAvailableActions$default(AIContainerViewModel aIContainerViewModel, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerViewModel$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        aIContainerViewModel.updateAvailableActions(function0);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.compose.AIContainerViewModel$updateAvailableActions$2 */
    /* JADX INFO: compiled from: AIContainerViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.compose.AIContainerViewModel$updateAvailableActions$2", m1609f = "AIContainerViewModel.kt", m1610i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, m1611l = {172, PDFACompliance.e_PDFA1_8_6}, m1612m = "invokeSuspend", m1613n = {FirebaseAnalytics.Param.CONTENT, "contentCount", "isExplainAvailable", "isInNotebookOrPDF", "isSummarizeAvailable", FirebaseAnalytics.Param.CONTENT, "wholeContent", "contentCount", "isExplainAvailable", "isInNotebookOrPDF", "isSummarizeAvailable", "wholeContentCount"}, m1614nl = {PDFACompliance.e_PDFA1_8_2, 194}, m1615s = {"L$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "I$0", "I$1", "I$2", "I$3", "I$4"}, m1616v = 2)
    static final class C61382 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onActionsUpdated;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C61382(Function0<Unit> function0, Continuation<? super C61382> continuation) {
            super(2, continuation);
            this.$onActionsUpdated = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIContainerViewModel.this.new C61382(this.$onActionsUpdated, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61382) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:51:0x010d, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r17.this$0.uiDispatcher, new com.myscript.nebo.p022ai.presentation.compose.AIContainerViewModel.C61382.AnonymousClass2(r17.this$0, r3, null), r17) == r1) goto L52;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v0 */
        /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r13v2 */
        /* JADX WARN: Type inference failed for: r14v0 */
        /* JADX WARN: Type inference failed for: r14v1, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r14v2 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v18, types: [int] */
        /* JADX WARN: Type inference failed for: r2v21 */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r8v4, types: [int] */
        /* JADX WARN: Type inference failed for: r8v6 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AiTextSelection aiTextSelectionAvailableTextInCurrentPage;
            int i;
            ?? r2;
            ?? r8;
            int i2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                TextSelectionProvider textSelectionProvider = AIContainerViewModel.this.textSelectionProvider;
                aiTextSelectionAvailableTextInCurrentPage = textSelectionProvider != null ? textSelectionProvider.availableTextInCurrentPage() : null;
                String selectedText = aiTextSelectionAvailableTextInCurrentPage != null ? aiTextSelectionAvailableTextInCurrentPage.getSelectedText() : null;
                if (selectedText == null) {
                    selectedText = "";
                }
                int length = StringsKt.trim((CharSequence) selectedText).toString().length();
                ?? r14 = (1 > length || length >= 301) ? 0 : 1;
                i = AIContainerViewModel.this.pagesCount > 0 ? 1 : 0;
                ?? r13 = (i == 0 && length <= 299) ? 0 : 1;
                this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelectionAvailableTextInCurrentPage);
                this.I$0 = length;
                this.I$1 = r14;
                this.I$2 = i;
                this.I$3 = r13;
                this.label = 1;
                if (BuildersKt.withContext(AIContainerViewModel.this.uiDispatcher, new AnonymousClass1(AIContainerViewModel.this, r13, r14, length, null), this) != coroutine_suspended) {
                    r2 = r13;
                    r8 = r14;
                    i2 = length;
                }
                return coroutine_suspended;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$onActionsUpdated.invoke();
                return Unit.INSTANCE;
            }
            int i4 = this.I$3;
            i = this.I$2;
            int i5 = this.I$1;
            i2 = this.I$0;
            aiTextSelectionAvailableTextInCurrentPage = (AiTextSelection) this.L$0;
            ResultKt.throwOnFailure(obj);
            r2 = i4;
            r8 = i5;
            if (i != 0) {
                TextSelectionProvider textSelectionProvider2 = AIContainerViewModel.this.textSelectionProvider;
                AiTextSelection allPagesText$default = textSelectionProvider2 != null ? TextSelectionProvider.getAllPagesText$default(textSelectionProvider2, null, 1, null) : null;
                String selectedText2 = allPagesText$default != null ? allPagesText$default.getSelectedText() : null;
                int length2 = StringsKt.trim((CharSequence) (selectedText2 != null ? selectedText2 : "")).toString().length();
                this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelectionAvailableTextInCurrentPage);
                this.L$1 = SpillingKt.nullOutSpilledVariable(allPagesText$default);
                this.I$0 = i2;
                this.I$1 = r8;
                this.I$2 = i;
                this.I$3 = r2;
                this.I$4 = length2;
                this.label = 2;
            }
            this.$onActionsUpdated.invoke();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.compose.AIContainerViewModel$updateAvailableActions$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: AIContainerViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.compose.AIContainerViewModel$updateAvailableActions$2$1", m1609f = "AIContainerViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $contentCount;
            final /* synthetic */ boolean $isExplainAvailable;
            final /* synthetic */ boolean $isSummarizeAvailable;
            int label;
            final /* synthetic */ AIContainerViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AIContainerViewModel aIContainerViewModel, boolean z, boolean z2, int i, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = aIContainerViewModel;
                this.$isSummarizeAvailable = z;
                this.$isExplainAvailable = z2;
                this.$contentCount = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$isSummarizeAvailable, this.$isExplainAvailable, this.$contentCount, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                boolean quiz;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ActionsAvailability actionsAvailability = (ActionsAvailability) this.this$0._actionsAvailability.getValue();
                    MutableLiveData mutableLiveData = this.this$0._actionsAvailability;
                    boolean z = this.$isSummarizeAvailable;
                    boolean z2 = this.$isExplainAvailable;
                    if (actionsAvailability != null) {
                        quiz = actionsAvailability.getQuiz();
                    } else {
                        quiz = this.$contentCount >= 300;
                    }
                    mutableLiveData.setValue(new ActionsAvailability(z, z2, quiz));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.compose.AIContainerViewModel$updateAvailableActions$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: AIContainerViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.compose.AIContainerViewModel$updateAvailableActions$2$2", m1609f = "AIContainerViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $wholeContentCount;
            int label;
            final /* synthetic */ AIContainerViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(AIContainerViewModel aIContainerViewModel, int i, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = aIContainerViewModel;
                this.$wholeContentCount = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$wholeContentCount, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                ActionsAvailability actionsAvailabilityCopy$default;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    MutableLiveData mutableLiveData = this.this$0._actionsAvailability;
                    ActionsAvailability actionsAvailability = (ActionsAvailability) this.this$0._actionsAvailability.getValue();
                    if (actionsAvailability != null) {
                        actionsAvailabilityCopy$default = ActionsAvailability.copy$default(actionsAvailability, false, false, this.$wholeContentCount >= 300, 3, null);
                    } else {
                        actionsAvailabilityCopy$default = null;
                    }
                    mutableLiveData.setValue(actionsAvailabilityCopy$default);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void updateAvailableActions(Function0<Unit> onActionsUpdated) {
        Intrinsics.checkNotNullParameter(onActionsUpdated, "onActionsUpdated");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.ioDispatcher, null, new C61382(onActionsUpdated, null), 2, null);
    }

    public final void setTextSelectionProvider(TextSelectionProvider provider) {
        this.textSelectionProvider = provider;
    }

    public final void updatePagesCount(int count) {
        this.pagesCount = count;
    }

    public final void setUserDataProvider(UserDataProvider provider) {
        this.userDataProvider = provider;
    }

    public final void runIfSignedIn(Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        UserDataProvider userDataProvider = this.userDataProvider;
        if (userDataProvider != null && (!userDataProvider.requiresSignIn() || userDataProvider.hasUser())) {
            action.invoke();
        } else {
            this.pendingSignInAction = action;
            this._showSignInDialog.setValue(true);
        }
    }

    public final void dismissSignInDialog() {
        this._showSignInDialog.setValue(false);
    }

    public final void onSignInSuccess() {
        this._showSignInDialog.setValue(false);
        Function0<Unit> function0 = this.pendingSignInAction;
        this.pendingSignInAction = null;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void onSignInCancelled() {
        this._showSignInDialog.setValue(false);
        this.pendingSignInAction = null;
    }

    public final void saveLastOperation(Function0<Unit> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        this.lastOperation = operation;
    }

    public final void triggerLastOperation() {
        Function0<Unit> function0 = this.lastOperation;
        if (function0 != null) {
            function0.invoke();
        }
        this.lastOperation = null;
    }

    public final void clearLastOperation() {
        this.lastOperation = null;
    }

    public final void setAIEnabled(boolean enabled) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutBoolean;
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences != null && (editorEdit = sharedPreferences.edit()) != null && (editorPutBoolean = editorEdit.putBoolean(AI_ENABLED_PREFS, enabled)) != null) {
            editorPutBoolean.apply();
        }
        this._isAIEnabled.setValue(Boolean.valueOf(enabled));
    }

    /* JADX INFO: compiled from: AIContainerViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/compose/AIContainerViewModel$Companion;", "", "<init>", "()V", "TAG", "", "AI_ENABLED_PREFS", "EXPLAIN_MAX_LIMIT", "", "SUMMARIZE_MIN_LIMIT", "QUIZ_MIN_LIMIT", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewModelProvider.Factory getFactory() {
            return AIContainerViewModel.Factory;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AIContainerViewModel Factory$lambda$0$0(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        Object objRequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context) objRequireApplication);
        Intrinsics.checkNotNull(objRequireApplication, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
        return new AIContainerViewModel(((LibraryRepository.Provider) objRequireApplication).provideLibraryRepository(), defaultSharedPreferences, null, null, 12, null);
    }

    static {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(AIContainerViewModel.class), new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AIContainerViewModel.Factory$lambda$0$0((CreationExtras) obj);
            }
        });
        Factory = initializerViewModelFactoryBuilder.build();
    }
}
