package com.myscript.nebo.p022ai.presentation;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import androidx.credentials.provider.CredentialEntry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.preference.PreferenceManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.LaunchActivity;
import com.myscript.nebo.analytics.firebase.AIQuizConstants;
import com.myscript.nebo.analytics.firebase.NeboFirebaseEvent;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.p022ai.AIAnalyticsOrigin;
import com.myscript.nebo.p022ai.AIQuizTrigger;
import com.myscript.nebo.p022ai.AnalyticsParametersKt;
import com.myscript.nebo.p022ai.C6091R;
import com.myscript.nebo.p022ai.data.AIClient;
import com.myscript.nebo.p022ai.data.NeboAIClient;
import com.myscript.nebo.p022ai.data.model.quiz.QuestionHistory;
import com.myscript.nebo.p022ai.data.model.quiz.QuizContent;
import com.myscript.nebo.p022ai.data.model.quiz.QuizPage;
import com.myscript.nebo.p022ai.data.model.quiz.QuizUserInfo;
import com.myscript.nebo.p022ai.presentation.AIQuizViewModel;
import com.myscript.nebo.p022ai.presentation.QuizSourceAction;
import com.myscript.nebo.p022ai.presentation.compose.AIError;
import com.myscript.nebo.p022ai.presentation.compose.AiTextSelection;
import com.myscript.nebo.p022ai.presentation.compose.TextSelectionProvider;
import com.myscript.snt.core.PageKey;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
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
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: AIQuizViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 b2\u00020\u0001:\u0001bBG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u000209J\u0010\u0010@\u001a\u00020>2\b\u0010A\u001a\u0004\u0018\u000104J\u0006\u0010B\u001a\u00020>J\u0006\u0010C\u001a\u00020>J\u000e\u0010D\u001a\u00020>H\u0082@¢\u0006\u0002\u0010EJ\u0006\u0010F\u001a\u00020>J\b\u0010G\u001a\u00020>H\u0002J\b\u0010H\u001a\u00020\u0018H\u0002J\u0006\u0010I\u001a\u00020>J\u0006\u0010J\u001a\u00020>J\u0006\u0010K\u001a\u00020>J\u0006\u0010L\u001a\u00020>J\u0014\u0010M\u001a\u00020>2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00070OJ\u000e\u0010P\u001a\u00020>2\u0006\u0010Q\u001a\u00020%J$\u0010R\u001a\u00020>2\u0010\b\u0002\u0010S\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010O2\b\b\u0002\u0010U\u001a\u00020\u0018H\u0002J\u0006\u0010V\u001a\u00020>J\u0006\u0010W\u001a\u00020>J\u000e\u0010X\u001a\u00020>2\u0006\u0010Y\u001a\u00020\u0007J\u0006\u0010Z\u001a\u00020>J\u0006\u0010[\u001a\u00020>J\u0006\u0010\\\u001a\u00020>J\u0010\u0010]\u001a\u0002092\u0006\u0010^\u001a\u00020\u0007H\u0002J\f\u0010_\u001a\b\u0012\u0004\u0012\u00020`0OJ\b\u0010a\u001a\u00020>H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180\u001b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u001c\u0010!\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180\u001b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0016\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u0012¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0016R\u001c\u0010(\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00180\u001b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u001c\u0010*\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00180\u001b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0016\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0\u001b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00105\u001a\f\u0012\u0006\u0012\u0004\u0018\u000107\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006c"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/AIQuizViewModel;", "Landroidx/lifecycle/ViewModel;", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "aiClient", "Lcom/myscript/nebo/ai/data/AIClient;", "appVersion", "", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "sharedPreferences", "Landroid/content/SharedPreferences;", "uiDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "<init>", "(Lcom/myscript/nebo/dms/core/LibraryRepository;Lcom/myscript/nebo/ai/data/AIClient;Ljava/lang/String;Landroidx/lifecycle/SavedStateHandle;Landroid/content/SharedPreferences;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_error", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/ai/presentation/compose/AIError;", "error", "getError", "()Landroidx/lifecycle/MutableLiveData;", "_showAIQuizDisclaimer", "", "kotlin.jvm.PlatformType", "showAIQuizDisclaimer", "Landroidx/lifecycle/LiveData;", "getShowAIQuizDisclaimer", "()Landroidx/lifecycle/LiveData;", "_showAIQuizPrompt", "showAIQuizPrompt", "getShowAIQuizPrompt", "_chooseNoteInput", "chooseNoteInput", "getChooseNoteInput", "_currentQuizMode", "Lcom/myscript/nebo/ai/presentation/QuizMode;", "currentQuizMode", "getCurrentQuizMode", "_isQuizLoading", "isQuizLoading", "_noteHidden", "noteHidden", "getNoteHidden", "_quizState", "Lcom/myscript/nebo/ai/presentation/QuizState;", "quizState", "getQuizState", "quizGenerationJob", "Lkotlinx/coroutines/Job;", "textSelectionProvider", "Lcom/myscript/nebo/ai/presentation/compose/TextSelectionProvider;", "textRetriever", "Lkotlin/Function0;", "Lcom/myscript/nebo/ai/presentation/compose/AiTextSelection;", "pagesCount", "", LaunchActivity.LaunchRoute.Language, "getLanguage", "()Ljava/lang/String;", "updatePagesCount", "", "count", "setTextSelectionProvider", "provider", "toggleHideNote", "startQuizGeneration", "decideOnContentSource", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startQuizFromSelection", "promptForQuizMode", "shouldShowDisclaimer", "onDisclaimerAccepted", "onDisclaimerDismissed", "onSourceSelectedCurrentPage", "onSourceSelectedAllPages", "onSourceSelectedChoosePages", "childPageIds", "", "onQuizModeSelected", "quizMode", "executeQuizGeneration", "history", "Lcom/myscript/nebo/ai/presentation/QuizQuestion;", "loadingNextQuestions", "closeNoteInput", "closeQuiz", "answerQuestion", "answer", "nextQuestion", "nextQuestions", "tryAgain", "computeMaxExpectedQuestions", "text", "getQuizSourceActions", "Lcom/myscript/nebo/ai/presentation/QuizSourceAction;", "onCleared", "Companion", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AIQuizViewModel extends ViewModel {
    private static final String AI_QUIZ_DISCLAIMER_ACCEPTED = "AI_QUIZ_DISCLAIMER_ACCEPTED";
    private static final String AI_QUIZ_DISCLAIMER_SHOWN = "AI_QUIZ_DISCLAIMER_SHOWN";
    private static final ViewModelProvider.Factory Factory;
    private static final String QUIZ_ANALYTICS_PAGE_TYPE_KEY = "QUIZ_ANALYTICS_PAGE_TYPE_KEY";
    private static final String QUIZ_ANALYTICS_SOURCE_KEY = "QUIZ_ANALYTICS_SOURCE_KEY";
    private static final String QUIZ_ANALYTICS_TRIGGER_KEY = "QUIZ_ANALYTICS_TRIGGER_KEY";
    private static final String QUIZ_CONTENT_ID = "generated-from-selection";
    private static final String QUIZ_CONTENT_NAME = "User Selection";
    private static final String TAG = "AIQuizViewModel";
    private final MutableLiveData<Boolean> _chooseNoteInput;
    private final MutableLiveData<QuizMode> _currentQuizMode;
    private final MutableLiveData<AIError> _error;
    private final MutableLiveData<Boolean> _isQuizLoading;
    private final MutableLiveData<Boolean> _noteHidden;
    private final MutableLiveData<QuizState> _quizState;
    private final MutableLiveData<Boolean> _showAIQuizDisclaimer;
    private final MutableLiveData<Boolean> _showAIQuizPrompt;
    private final AIClient aiClient;
    private final String appVersion;
    private final LiveData<Boolean> chooseNoteInput;
    private final MutableLiveData<QuizMode> currentQuizMode;
    private final MutableLiveData<AIError> error;
    private final CoroutineDispatcher ioDispatcher;
    private final LiveData<Boolean> isQuizLoading;
    private final LibraryRepository libraryRepository;
    private final LiveData<Boolean> noteHidden;
    private int pagesCount;
    private Job quizGenerationJob;
    private final LiveData<QuizState> quizState;
    private final SavedStateHandle savedStateHandle;
    private final SharedPreferences sharedPreferences;
    private final LiveData<Boolean> showAIQuizDisclaimer;
    private final LiveData<Boolean> showAIQuizPrompt;
    private Function0<AiTextSelection> textRetriever;
    private TextSelectionProvider textSelectionProvider;
    private final CoroutineDispatcher uiDispatcher;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIQuizViewModel$decideOnContentSource$1 */
    /* JADX INFO: compiled from: AIQuizViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIQuizViewModel", m1609f = "AIQuizViewModel.kt", m1610i = {}, m1611l = {206, 210}, m1612m = "decideOnContentSource", m1613n = {}, m1614nl = {210, PDFACompliance.e_PDFA2_3_3}, m1615s = {}, m1616v = 2)
    static final class C61061 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C61061(Continuation<? super C61061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AIQuizViewModel.this.decideOnContentSource(this);
        }
    }

    public AIQuizViewModel(LibraryRepository libraryRepository, AIClient aiClient, String appVersion, SavedStateHandle savedStateHandle, SharedPreferences sharedPreferences, CoroutineDispatcher uiDispatcher, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(libraryRepository, "libraryRepository");
        Intrinsics.checkNotNullParameter(aiClient, "aiClient");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(uiDispatcher, "uiDispatcher");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.libraryRepository = libraryRepository;
        this.aiClient = aiClient;
        this.appVersion = appVersion;
        this.savedStateHandle = savedStateHandle;
        this.sharedPreferences = sharedPreferences;
        this.uiDispatcher = uiDispatcher;
        this.ioDispatcher = ioDispatcher;
        aiClient.addNetworkStateObserver();
        MutableLiveData<AIError> mutableLiveData = new MutableLiveData<>();
        this._error = mutableLiveData;
        this.error = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(false);
        this._showAIQuizDisclaimer = mutableLiveData2;
        this.showAIQuizDisclaimer = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(false);
        this._showAIQuizPrompt = mutableLiveData3;
        this.showAIQuizPrompt = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>(false);
        this._chooseNoteInput = mutableLiveData4;
        this.chooseNoteInput = mutableLiveData4;
        MutableLiveData<QuizMode> mutableLiveData5 = new MutableLiveData<>();
        this._currentQuizMode = mutableLiveData5;
        this.currentQuizMode = mutableLiveData5;
        MutableLiveData<Boolean> mutableLiveData6 = new MutableLiveData<>(false);
        this._isQuizLoading = mutableLiveData6;
        this.isQuizLoading = mutableLiveData6;
        MutableLiveData<Boolean> mutableLiveData7 = new MutableLiveData<>(false);
        this._noteHidden = mutableLiveData7;
        this.noteHidden = mutableLiveData7;
        MutableLiveData<QuizState> mutableLiveData8 = new MutableLiveData<>(null);
        this._quizState = mutableLiveData8;
        this.quizState = mutableLiveData8;
    }

    public /* synthetic */ AIQuizViewModel(LibraryRepository libraryRepository, AIClient aIClient, String str, SavedStateHandle savedStateHandle, SharedPreferences sharedPreferences, MainCoroutineDispatcher mainCoroutineDispatcher, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(libraryRepository, aIClient, str, savedStateHandle, (i & 16) != 0 ? null : sharedPreferences, (i & 32) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher, (i & 64) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    public final MutableLiveData<AIError> getError() {
        return this.error;
    }

    public final LiveData<Boolean> getShowAIQuizDisclaimer() {
        return this.showAIQuizDisclaimer;
    }

    public final LiveData<Boolean> getShowAIQuizPrompt() {
        return this.showAIQuizPrompt;
    }

    public final LiveData<Boolean> getChooseNoteInput() {
        return this.chooseNoteInput;
    }

    public final MutableLiveData<QuizMode> getCurrentQuizMode() {
        return this.currentQuizMode;
    }

    public final LiveData<Boolean> isQuizLoading() {
        return this.isQuizLoading;
    }

    public final LiveData<Boolean> getNoteHidden() {
        return this.noteHidden;
    }

    public final LiveData<QuizState> getQuizState() {
        return this.quizState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getLanguage() {
        PageKey lastOpenedNoteKey = this.libraryRepository.getLastOpenedNoteKey();
        if (lastOpenedNoteKey != null) {
            PageModel page = this.libraryRepository.getPage(lastOpenedNoteKey);
            String languageTag = page != null ? page.getLanguageTag() : null;
            return languageTag != null ? languageTag : "en_US";
        }
        return "en_US";
    }

    public final void updatePagesCount(int count) {
        this.pagesCount = count;
    }

    public final void setTextSelectionProvider(TextSelectionProvider provider) {
        this.textSelectionProvider = provider;
    }

    public final void toggleHideNote() {
        if (Intrinsics.areEqual((Object) this._noteHidden.getValue(), (Object) false)) {
            String str = (String) this.savedStateHandle.get(QUIZ_ANALYTICS_PAGE_TYPE_KEY);
            final AIAnalyticsOrigin aIAnalyticsOriginValueOf = str != null ? AIAnalyticsOrigin.valueOf(str) : null;
            QuizState value = this._quizState.getValue();
            final String str2 = (value != null ? value.getQuizMode() : null) == QuizMode.TRUE_FALSE ? AIQuizConstants.TRUE_FALSE : "multiple_choice";
            NeboFirebaseEvent.aiQuizHide.log(new Function1() { // from class: com.myscript.nebo.ai.presentation.AIQuizViewModel$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AIQuizViewModel.toggleHideNote$lambda$1(aIAnalyticsOriginValueOf, str2, (Bundle) obj);
                }
            });
        }
        MutableLiveData<Boolean> mutableLiveData = this._noteHidden;
        mutableLiveData.setValue(mutableLiveData.getValue() != null ? Boolean.valueOf(!r2.booleanValue()) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toggleHideNote$lambda$1(AIAnalyticsOrigin aIAnalyticsOrigin, String str, Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        AnalyticsParametersKt.origin(log, aIAnalyticsOrigin);
        AnalyticsParametersKt.type(log, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIQuizViewModel$startQuizGeneration$1 */
    /* JADX INFO: compiled from: AIQuizViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIQuizViewModel$startQuizGeneration$1", m1609f = "AIQuizViewModel.kt", m1610i = {}, m1611l = {201}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {202}, m1615s = {}, m1616v = 2)
    static final class C61221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61221(Continuation<? super C61221> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIQuizViewModel.this.new C61221(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61221) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (AIQuizViewModel.this.shouldShowDisclaimer()) {
                    AIQuizViewModel.this._showAIQuizDisclaimer.setValue(Boxing.boxBoolean(true));
                    return Unit.INSTANCE;
                }
                AIQuizViewModel.this._showAIQuizDisclaimer.setValue(Boxing.boxBoolean(false));
                this.label = 1;
                if (AIQuizViewModel.this.decideOnContentSource(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void startQuizGeneration() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C61221(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIQuizViewModel$decideOnContentSource$2 */
    /* JADX INFO: compiled from: AIQuizViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIQuizViewModel$decideOnContentSource$2", m1609f = "AIQuizViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61072 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61072(Continuation<? super C61072> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIQuizViewModel.this.new C61072(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61072) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AIQuizViewModel.this._chooseNoteInput.setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object decideOnContentSource(Continuation<? super Unit> continuation) {
        C61061 c61061;
        if (continuation instanceof C61061) {
            c61061 = (C61061) continuation;
            if ((c61061.label & Integer.MIN_VALUE) != 0) {
                c61061.label -= Integer.MIN_VALUE;
            } else {
                c61061 = new C61061(continuation);
            }
        }
        Object obj = c61061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c61061.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher coroutineDispatcher = this.uiDispatcher;
            C61072 c61072 = new C61072(null);
            c61061.label = 1;
            if (BuildersKt.withContext(coroutineDispatcher, c61072, c61061) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        CoroutineDispatcher coroutineDispatcher2 = this.ioDispatcher;
        C61083 c61083 = new C61083(null);
        c61061.label = 2;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIQuizViewModel$decideOnContentSource$3 */
    /* JADX INFO: compiled from: AIQuizViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIQuizViewModel$decideOnContentSource$3", m1609f = "AIQuizViewModel.kt", m1610i = {}, m1611l = {219, 225}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {225, 228}, m1615s = {}, m1616v = 2)
    static final class C61083 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61083(Continuation<? super C61083> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIQuizViewModel.this.new C61083(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61083) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r5.this$0.uiDispatcher, new com.myscript.nebo.p022ai.presentation.AIQuizViewModel.C61083.AnonymousClass2(r5.this$0, null), r5) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x007f, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r5.this$0.uiDispatcher, new com.myscript.nebo.p022ai.presentation.AIQuizViewModel.C61083.AnonymousClass3(r5.this$0, null), r5) == r0) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TextSelectionProvider textSelectionProvider = AIQuizViewModel.this.textSelectionProvider;
                if (textSelectionProvider == null || !textSelectionProvider.hasSelection()) {
                    if (AIQuizViewModel.this.pagesCount > 1) {
                        this.label = 1;
                    } else {
                        this.label = 2;
                    }
                    return coroutine_suspended;
                }
                final AIQuizViewModel aIQuizViewModel = AIQuizViewModel.this;
                aIQuizViewModel.textRetriever = new Function0() { // from class: com.myscript.nebo.ai.presentation.AIQuizViewModel$decideOnContentSource$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AIQuizViewModel.C61083.invokeSuspend$lambda$0(aIQuizViewModel);
                    }
                };
                AIQuizViewModel.this.promptForQuizMode();
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                final AIQuizViewModel aIQuizViewModel2 = AIQuizViewModel.this;
                aIQuizViewModel2.textRetriever = new Function0() { // from class: com.myscript.nebo.ai.presentation.AIQuizViewModel$decideOnContentSource$3$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AIQuizViewModel.C61083.invokeSuspend$lambda$1(aIQuizViewModel2);
                    }
                };
                AIQuizViewModel.this.promptForQuizMode();
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AiTextSelection invokeSuspend$lambda$0(AIQuizViewModel aIQuizViewModel) {
            TextSelectionProvider textSelectionProvider = aIQuizViewModel.textSelectionProvider;
            if (textSelectionProvider != null) {
                return textSelectionProvider.getPageTextSelection();
            }
            return null;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIQuizViewModel$decideOnContentSource$3$2, reason: invalid class name */
        /* JADX INFO: compiled from: AIQuizViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIQuizViewModel$decideOnContentSource$3$2", m1609f = "AIQuizViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AIQuizViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(AIQuizViewModel aIQuizViewModel, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = aIQuizViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0._chooseNoteInput.setValue(Boxing.boxBoolean(true));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIQuizViewModel$decideOnContentSource$3$3, reason: invalid class name */
        /* JADX INFO: compiled from: AIQuizViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIQuizViewModel$decideOnContentSource$3$3", m1609f = "AIQuizViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AIQuizViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(AIQuizViewModel aIQuizViewModel, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = aIQuizViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0._chooseNoteInput.setValue(Boxing.boxBoolean(false));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AiTextSelection invokeSuspend$lambda$1(AIQuizViewModel aIQuizViewModel) {
            TextSelectionProvider textSelectionProvider = aIQuizViewModel.textSelectionProvider;
            if (textSelectionProvider != null) {
                return textSelectionProvider.availableTextInCurrentPage();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AiTextSelection startQuizFromSelection$lambda$0(AIQuizViewModel aIQuizViewModel) {
        TextSelectionProvider textSelectionProvider = aIQuizViewModel.textSelectionProvider;
        if (textSelectionProvider != null) {
            return textSelectionProvider.getPageTextSelection();
        }
        return null;
    }

    public final void startQuizFromSelection() {
        this.textRetriever = new Function0() { // from class: com.myscript.nebo.ai.presentation.AIQuizViewModel$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AIQuizViewModel.startQuizFromSelection$lambda$0(this.f$0);
            }
        };
        this.savedStateHandle.set(QUIZ_ANALYTICS_TRIGGER_KEY, "CONTEXTUAL_MENU");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C61212(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIQuizViewModel$startQuizFromSelection$2 */
    /* JADX INFO: compiled from: AIQuizViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIQuizViewModel$startQuizFromSelection$2", m1609f = "AIQuizViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61212 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61212(Continuation<? super C61212> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIQuizViewModel.this.new C61212(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61212) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AIQuizViewModel.this._chooseNoteInput.setValue(Boxing.boxBoolean(false));
                AIQuizViewModel.this.promptForQuizMode();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIQuizViewModel$promptForQuizMode$1 */
    /* JADX INFO: compiled from: AIQuizViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIQuizViewModel$promptForQuizMode$1", m1609f = "AIQuizViewModel.kt", m1610i = {}, m1611l = {246}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA2_5_1}, m1615s = {}, m1616v = 2)
    static final class C61201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61201(Continuation<? super C61201> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIQuizViewModel.this.new C61201(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61201) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = BuildersKt.withContext(AIQuizViewModel.this.ioDispatcher, new AIQuizViewModel$promptForQuizMode$1$content$1(AIQuizViewModel.this, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((String) obj).length() < 300) {
                AIQuizViewModel.this._error.setValue(AIError.NotEnoughText.INSTANCE);
            } else {
                AIQuizViewModel.this._showAIQuizPrompt.setValue(Boxing.boxBoolean(true));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void promptForQuizMode() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C61201(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldShowDisclaimer() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        return (sharedPreferences == null || sharedPreferences.getBoolean(AI_QUIZ_DISCLAIMER_ACCEPTED, false)) ? false : true;
    }

    public final void onDisclaimerAccepted() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean(AI_QUIZ_DISCLAIMER_ACCEPTED, true);
            editorEdit.apply();
        }
        this._showAIQuizDisclaimer.setValue(false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C61152(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIQuizViewModel$onDisclaimerAccepted$2 */
    /* JADX INFO: compiled from: AIQuizViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIQuizViewModel$onDisclaimerAccepted$2", m1609f = "AIQuizViewModel.kt", m1610i = {}, m1611l = {268}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {269}, m1615s = {}, m1616v = 2)
    static final class C61152 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61152(Continuation<? super C61152> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIQuizViewModel.this.new C61152(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61152) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (AIQuizViewModel.this.decideOnContentSource(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void onDisclaimerDismissed() {
        this._showAIQuizDisclaimer.setValue(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AiTextSelection onSourceSelectedCurrentPage$lambda$0(AIQuizViewModel aIQuizViewModel) {
        TextSelectionProvider textSelectionProvider = aIQuizViewModel.textSelectionProvider;
        if (textSelectionProvider != null) {
            return textSelectionProvider.availableTextInCurrentPage();
        }
        return null;
    }

    public final void onSourceSelectedCurrentPage() {
        this.textRetriever = new Function0() { // from class: com.myscript.nebo.ai.presentation.AIQuizViewModel$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AIQuizViewModel.onSourceSelectedCurrentPage$lambda$0(this.f$0);
            }
        };
        SavedStateHandle savedStateHandle = this.savedStateHandle;
        savedStateHandle.set(QUIZ_ANALYTICS_TRIGGER_KEY, "QUIZ_MODAL");
        savedStateHandle.set(QUIZ_ANALYTICS_SOURCE_KEY, AIQuizConstants.CURRENT_PAGE);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C61193(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIQuizViewModel$onSourceSelectedCurrentPage$3 */
    /* JADX INFO: compiled from: AIQuizViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIQuizViewModel$onSourceSelectedCurrentPage$3", m1609f = "AIQuizViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61193 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61193(Continuation<? super C61193> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIQuizViewModel.this.new C61193(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61193) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AIQuizViewModel.this._chooseNoteInput.setValue(Boxing.boxBoolean(false));
                AIQuizViewModel.this._showAIQuizPrompt.setValue(Boxing.boxBoolean(true));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AiTextSelection onSourceSelectedAllPages$lambda$0(AIQuizViewModel aIQuizViewModel) {
        TextSelectionProvider textSelectionProvider = aIQuizViewModel.textSelectionProvider;
        if (textSelectionProvider != null) {
            return TextSelectionProvider.getAllPagesText$default(textSelectionProvider, null, 1, null);
        }
        return null;
    }

    public final void onSourceSelectedAllPages() {
        this.textRetriever = new Function0() { // from class: com.myscript.nebo.ai.presentation.AIQuizViewModel$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AIQuizViewModel.onSourceSelectedAllPages$lambda$0(this.f$0);
            }
        };
        SavedStateHandle savedStateHandle = this.savedStateHandle;
        savedStateHandle.set(QUIZ_ANALYTICS_TRIGGER_KEY, "QUIZ_MODAL");
        savedStateHandle.set(QUIZ_ANALYTICS_SOURCE_KEY, AIQuizConstants.ALL_PAGES);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C61173(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIQuizViewModel$onSourceSelectedAllPages$3 */
    /* JADX INFO: compiled from: AIQuizViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIQuizViewModel$onSourceSelectedAllPages$3", m1609f = "AIQuizViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61173 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61173(Continuation<? super C61173> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIQuizViewModel.this.new C61173(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61173) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AIQuizViewModel.this._chooseNoteInput.setValue(Boxing.boxBoolean(false));
                AIQuizViewModel.this._showAIQuizPrompt.setValue(Boxing.boxBoolean(true));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void onSourceSelectedChoosePages(final List<String> childPageIds) {
        Intrinsics.checkNotNullParameter(childPageIds, "childPageIds");
        this.textRetriever = new Function0() { // from class: com.myscript.nebo.ai.presentation.AIQuizViewModel$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AIQuizViewModel.onSourceSelectedChoosePages$lambda$0(this.f$0, childPageIds);
            }
        };
        SavedStateHandle savedStateHandle = this.savedStateHandle;
        savedStateHandle.set(QUIZ_ANALYTICS_TRIGGER_KEY, "QUIZ_MODAL");
        savedStateHandle.set(QUIZ_ANALYTICS_SOURCE_KEY, AIQuizConstants.MULTIPLE_PAGES);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C61183(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AiTextSelection onSourceSelectedChoosePages$lambda$0(AIQuizViewModel aIQuizViewModel, List list) {
        TextSelectionProvider textSelectionProvider = aIQuizViewModel.textSelectionProvider;
        if (textSelectionProvider != null) {
            return textSelectionProvider.getAllPagesText(list);
        }
        return null;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIQuizViewModel$onSourceSelectedChoosePages$3 */
    /* JADX INFO: compiled from: AIQuizViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIQuizViewModel$onSourceSelectedChoosePages$3", m1609f = "AIQuizViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61183 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61183(Continuation<? super C61183> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIQuizViewModel.this.new C61183(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61183) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AIQuizViewModel.this._chooseNoteInput.setValue(Boxing.boxBoolean(false));
                AIQuizViewModel.this._showAIQuizPrompt.setValue(Boxing.boxBoolean(true));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIQuizViewModel$onQuizModeSelected$1 */
    /* JADX INFO: compiled from: AIQuizViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIQuizViewModel$onQuizModeSelected$1", m1609f = "AIQuizViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ QuizMode $quizMode;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C61161(QuizMode quizMode, Continuation<? super C61161> continuation) {
            super(2, continuation);
            this.$quizMode = quizMode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIQuizViewModel.this.new C61161(this.$quizMode, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AIQuizViewModel.this._showAIQuizPrompt.setValue(Boxing.boxBoolean(false));
                AIQuizViewModel.this._currentQuizMode.setValue(this.$quizMode);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void onQuizModeSelected(QuizMode quizMode) {
        Intrinsics.checkNotNullParameter(quizMode, "quizMode");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C61161(quizMode, null), 2, null);
        executeQuizGeneration$default(this, null, false, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void executeQuizGeneration$default(AIQuizViewModel aIQuizViewModel, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        aIQuizViewModel.executeQuizGeneration(list, z);
    }

    private final void executeQuizGeneration(List<? extends QuizQuestion> history, boolean loadingNextQuestions) {
        Job job = this.quizGenerationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.quizGenerationJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.ioDispatcher, null, new C61111(loadingNextQuestions, history, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIQuizViewModel$executeQuizGeneration$1 */
    /* JADX INFO: compiled from: AIQuizViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIQuizViewModel$executeQuizGeneration$1", m1609f = "AIQuizViewModel.kt", m1610i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, m1611l = {335, 459, 474}, m1612m = "invokeSuspend", m1613n = {"contentToQuiz", "contentToQuiz", "questionTypes", "pageType", "trigger", FirebaseAnalytics.Param.SOURCE, "pages", "quizContent", "questionsHistory", "contentToQuiz", "questionTypes", "pageType", "trigger", FirebaseAnalytics.Param.SOURCE, "pages", "quizContent", "questionsHistory"}, m1614nl = {340, 474, 582}, m1615s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, m1616v = 2)
    static final class C61111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<QuizQuestion> $history;
        final /* synthetic */ boolean $loadingNextQuestions;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIQuizViewModel$executeQuizGeneration$1$WhenMappings */
        /* JADX INFO: compiled from: AIQuizViewModel.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[QuizMode.values().length];
                try {
                    iArr[QuizMode.TRUE_FALSE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[QuizMode.MULTIPLE_CHOICE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[AIAnalyticsOrigin.values().length];
                try {
                    iArr2[AIAnalyticsOrigin.PDF.ordinal()] = 1;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr2[AIAnalyticsOrigin.NOTEBOOK.ordinal()] = 2;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr2[AIAnalyticsOrigin.RAW_CONTENT.ordinal()] = 3;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr2[AIAnalyticsOrigin.TEXT_DOCUMENT.ordinal()] = 4;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C61111(boolean z, List<? extends QuizQuestion> list, Continuation<? super C61111> continuation) {
            super(2, continuation);
            this.$loadingNextQuestions = z;
            this.$history = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIQuizViewModel.this.new C61111(this.$loadingNextQuestions, this.$history, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:125:0x0412, code lost:
        
            if (((kotlinx.coroutines.flow.Flow) r2).collect(new com.myscript.nebo.p022ai.presentation.AIQuizViewModel.C61111.AnonymousClass3(), r35) != r1) goto L127;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AiTextSelection aiTextSelection;
            final AiTextSelection aiTextSelection2;
            List<String> listListOf;
            String str;
            final AIQuizTrigger aIQuizTriggerValueOf;
            final String selectionType;
            List list;
            List<QuizContent> listListOf2;
            AIQuizTrigger aIQuizTrigger;
            List<QuestionHistory> list2;
            Object objGenerateQuiz;
            String str2;
            String str3;
            List<String> list3;
            List<QuizContent> list4;
            AIQuizTrigger aIQuizTrigger2;
            Iterator it;
            String str4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function0 function0 = AIQuizViewModel.this.textRetriever;
                if (function0 == null || (aiTextSelection = (AiTextSelection) function0.invoke()) == null) {
                    return Unit.INSTANCE;
                }
                if (StringsKt.trim((CharSequence) aiTextSelection.getSelectedText()).toString().length() < 300) {
                    AIQuizViewModel.this._error.postValue(AIError.NotEnoughText.INSTANCE);
                    return Unit.INSTANCE;
                }
                if (!this.$loadingNextQuestions) {
                    this.L$0 = aiTextSelection;
                    this.label = 1;
                    if (BuildersKt.withContext(AIQuizViewModel.this.uiDispatcher, new AnonymousClass1(AIQuizViewModel.this, null), this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                aiTextSelection = (AiTextSelection) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                List<QuestionHistory> list5 = (List) this.L$7;
                list4 = (List) this.L$6;
                list = (List) this.L$5;
                str2 = (String) this.L$4;
                aIQuizTrigger2 = (AIQuizTrigger) this.L$3;
                str3 = (String) this.L$2;
                list3 = (List) this.L$1;
                aiTextSelection2 = (AiTextSelection) this.L$0;
                ResultKt.throwOnFailure(obj);
                list2 = list5;
                objGenerateQuiz = obj;
                final AIQuizViewModel aIQuizViewModel = AIQuizViewModel.this;
                final boolean z = this.$loadingNextQuestions;
                this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelection2);
                this.L$1 = SpillingKt.nullOutSpilledVariable(list3);
                this.L$2 = SpillingKt.nullOutSpilledVariable(str3);
                this.L$3 = SpillingKt.nullOutSpilledVariable(aIQuizTrigger2);
                this.L$4 = SpillingKt.nullOutSpilledVariable(str2);
                this.L$5 = SpillingKt.nullOutSpilledVariable(list);
                this.L$6 = SpillingKt.nullOutSpilledVariable(list4);
                this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                this.label = 3;
            }
            aiTextSelection2 = aiTextSelection;
            QuizMode quizMode = (QuizMode) AIQuizViewModel.this._currentQuizMode.getValue();
            int i2 = quizMode == null ? -1 : WhenMappings.$EnumSwitchMapping$0[quizMode.ordinal()];
            if (i2 == 1) {
                listListOf = CollectionsKt.listOf(AIQuizConstants.TRUE_OR_FALSE);
            } else if (i2 == 2) {
                listListOf = CollectionsKt.listOf("multiple_choice");
            } else {
                listListOf = CollectionsKt.listOf((Object[]) new String[]{"multiple_choice", AIQuizConstants.TRUE_OR_FALSE});
            }
            List<String> list6 = listListOf;
            AIAnalyticsOrigin pageType = aiTextSelection2.getPageType();
            int i3 = pageType != null ? WhenMappings.$EnumSwitchMapping$1[pageType.ordinal()] : -1;
            if (i3 == 1) {
                str = AIQuizConstants.PDF;
            } else if (i3 != 2) {
                str = i3 != 3 ? AIQuizConstants.DOCUMENT : AIQuizConstants.BOARD;
            } else {
                str = AIQuizConstants.NOTEBOOK;
            }
            SavedStateHandle savedStateHandle = AIQuizViewModel.this.savedStateHandle;
            AIAnalyticsOrigin pageType2 = aiTextSelection2.getPageType();
            savedStateHandle.set(AIQuizViewModel.QUIZ_ANALYTICS_PAGE_TYPE_KEY, pageType2 != null ? pageType2.name() : null);
            if (!this.$loadingNextQuestions) {
                String str5 = (String) AIQuizViewModel.this.savedStateHandle.get(AIQuizViewModel.QUIZ_ANALYTICS_TRIGGER_KEY);
                if (str5 == null || (aIQuizTriggerValueOf = AIQuizTrigger.valueOf(str5)) == null) {
                    aIQuizTriggerValueOf = AIQuizTrigger.QUIZ_MODAL;
                }
            } else {
                aIQuizTriggerValueOf = AIQuizTrigger.NEW_QUESTIONS;
            }
            String str6 = (String) AIQuizViewModel.this.savedStateHandle.get(AIQuizViewModel.QUIZ_ANALYTICS_SOURCE_KEY);
            if (str6 == null) {
                selectionType = (Intrinsics.areEqual(aiTextSelection2.getSelectionType(), AIQuizConstants.WHOLE_PAGE) && CollectionsKt.contains(CollectionsKt.listOf((Object[]) new AIAnalyticsOrigin[]{AIAnalyticsOrigin.PDF, AIAnalyticsOrigin.NOTEBOOK}), aiTextSelection2.getPageType())) ? AIQuizConstants.CURRENT_PAGE : aiTextSelection2.getSelectionType();
            } else {
                selectionType = str6;
            }
            AIQuizViewModel.this.savedStateHandle.set(AIQuizViewModel.QUIZ_ANALYTICS_SOURCE_KEY, selectionType);
            NeboFirebaseEvent neboFirebaseEvent = NeboFirebaseEvent.aiQuizStart;
            final AIQuizViewModel aIQuizViewModel2 = AIQuizViewModel.this;
            neboFirebaseEvent.log(new Function1() { // from class: com.myscript.nebo.ai.presentation.AIQuizViewModel$executeQuizGeneration$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return AIQuizViewModel.C61111.invokeSuspend$lambda$1(aiTextSelection2, aIQuizViewModel2, aIQuizTriggerValueOf, selectionType, (Bundle) obj2);
                }
            });
            List listSplit$default = StringsKt.split$default((CharSequence) aiTextSelection2.getSelectedText(), new String[]{"\n\n"}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : listSplit$default) {
                if (!StringsKt.isBlank((String) obj2)) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = arrayList;
            List arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            int i4 = 0;
            for (Object obj3 : arrayList2) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList3.add(new QuizPage(i5, StringsKt.trim((CharSequence) obj3).toString()));
                i4 = i5;
            }
            list = arrayList3;
            if (Intrinsics.areEqual(str, AIQuizConstants.BOARD)) {
                listListOf2 = CollectionsKt.listOf(new QuizContent(str, AIQuizViewModel.QUIZ_CONTENT_ID, AIQuizViewModel.QUIZ_CONTENT_NAME, null, aiTextSelection2.getSelectedText(), 8, null));
            } else if (Intrinsics.areEqual(str, AIQuizConstants.DOCUMENT)) {
                listListOf2 = CollectionsKt.listOf(new QuizContent(str, AIQuizViewModel.QUIZ_CONTENT_ID, AIQuizViewModel.QUIZ_CONTENT_NAME, list, aiTextSelection2.getSelectedText()));
            } else {
                listListOf2 = CollectionsKt.listOf(new QuizContent(str, AIQuizViewModel.QUIZ_CONTENT_ID, AIQuizViewModel.QUIZ_CONTENT_NAME, list, null, 16, null));
            }
            List<QuizContent> list7 = listListOf2;
            List<QuizQuestion> list8 = this.$history;
            if (list8 != null) {
                List<QuizQuestion> list9 = list8;
                AIQuizViewModel aIQuizViewModel3 = AIQuizViewModel.this;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list9, 10));
                Iterator it2 = list9.iterator();
                while (it2.hasNext()) {
                    QuizQuestion quizQuestion = (QuizQuestion) it2.next();
                    ArrayList arrayList5 = new ArrayList();
                    boolean z2 = quizQuestion instanceof QuizMultipleChoiceQuestion;
                    if (z2) {
                        it = it2;
                        str4 = "multiple_choice";
                    } else {
                        it = it2;
                        boolean z3 = quizQuestion instanceof QuizTrueFalseQuestion;
                        str4 = AIQuizConstants.TRUE_OR_FALSE;
                    }
                    if (z2) {
                        QuizMultipleChoiceQuestion quizMultipleChoiceQuestion = (QuizMultipleChoiceQuestion) quizQuestion;
                        arrayList5.add(quizMultipleChoiceQuestion.getA());
                        arrayList5.add(quizMultipleChoiceQuestion.getB());
                        arrayList5.add(quizMultipleChoiceQuestion.getC());
                    }
                    String language = aIQuizViewModel3.getLanguage();
                    String question = quizQuestion.getQuestion();
                    String language2 = aIQuizViewModel3.getLanguage();
                    Object obj4 = "";
                    String str7 = (String) (arrayList5.size() > 0 ? arrayList5.get(0) : "");
                    AIQuizTrigger aIQuizTrigger3 = aIQuizTriggerValueOf;
                    String str8 = (String) (1 < arrayList5.size() ? arrayList5.get(1) : "");
                    if (2 < arrayList5.size()) {
                        obj4 = arrayList5.get(2);
                    }
                    arrayList4.add(new QuestionHistory(language, question, null, null, language2, str4, str7, str8, (String) obj4, quizQuestion.getAnswer()));
                    it2 = it;
                    aIQuizTriggerValueOf = aIQuizTrigger3;
                }
                aIQuizTrigger = aIQuizTriggerValueOf;
                list2 = arrayList4;
            } else {
                aIQuizTrigger = aIQuizTriggerValueOf;
                list2 = null;
            }
            AIClient aIClient = AIQuizViewModel.this.aiClient;
            String RELEASE = Build.VERSION.RELEASE;
            Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
            QuizUserInfo quizUserInfo = new QuizUserInfo("Android", RELEASE, "MyScript Notes", AIQuizViewModel.this.appVersion);
            String language3 = AIQuizViewModel.this.getLanguage();
            boolean z4 = AIQuizViewModel.this._currentQuizMode.getValue() == QuizMode.TRUE_FALSE;
            this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelection2);
            this.L$1 = SpillingKt.nullOutSpilledVariable(list6);
            this.L$2 = SpillingKt.nullOutSpilledVariable(str);
            this.L$3 = SpillingKt.nullOutSpilledVariable(aIQuizTrigger);
            this.L$4 = SpillingKt.nullOutSpilledVariable(selectionType);
            this.L$5 = SpillingKt.nullOutSpilledVariable(list);
            this.L$6 = SpillingKt.nullOutSpilledVariable(list7);
            this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
            this.label = 2;
            objGenerateQuiz = aIClient.generateQuiz(quizUserInfo, language3, list6, 10, 3, z4, false, list7, list2, this);
            if (objGenerateQuiz != coroutine_suspended) {
                str2 = selectionType;
                str3 = str;
                list3 = list6;
                list4 = list7;
                aIQuizTrigger2 = aIQuizTrigger;
                final AIQuizViewModel aIQuizViewModel4 = AIQuizViewModel.this;
                final boolean z5 = this.$loadingNextQuestions;
                this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelection2);
                this.L$1 = SpillingKt.nullOutSpilledVariable(list3);
                this.L$2 = SpillingKt.nullOutSpilledVariable(str3);
                this.L$3 = SpillingKt.nullOutSpilledVariable(aIQuizTrigger2);
                this.L$4 = SpillingKt.nullOutSpilledVariable(str2);
                this.L$5 = SpillingKt.nullOutSpilledVariable(list);
                this.L$6 = SpillingKt.nullOutSpilledVariable(list4);
                this.L$7 = SpillingKt.nullOutSpilledVariable(list2);
                this.label = 3;
            }
            return coroutine_suspended;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIQuizViewModel$executeQuizGeneration$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: AIQuizViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIQuizViewModel$executeQuizGeneration$1$1", m1609f = "AIQuizViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AIQuizViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AIQuizViewModel aIQuizViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = aIQuizViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0._isQuizLoading.setValue(Boxing.boxBoolean(true));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(AiTextSelection aiTextSelection, AIQuizViewModel aIQuizViewModel, AIQuizTrigger aIQuizTrigger, String str, Bundle bundle) {
            AnalyticsParametersKt.origin(bundle, aiTextSelection.getPageType());
            AnalyticsParametersKt.type(bundle, aIQuizViewModel._currentQuizMode.getValue() == QuizMode.TRUE_FALSE ? AIQuizConstants.TRUE_FALSE : "multiple_choice");
            AnalyticsParametersKt.trigger(bundle, aIQuizTrigger);
            AnalyticsParametersKt.aiQuizSelected(bundle, str);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIQuizViewModel$closeNoteInput$1 */
    /* JADX INFO: compiled from: AIQuizViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIQuizViewModel$closeNoteInput$1", m1609f = "AIQuizViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61041(Continuation<? super C61041> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIQuizViewModel.this.new C61041(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AIQuizViewModel.this._chooseNoteInput.setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void closeNoteInput() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C61041(null), 2, null);
    }

    public final void closeQuiz() {
        Job job = this.quizGenerationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.savedStateHandle.remove(QUIZ_ANALYTICS_TRIGGER_KEY);
        this.savedStateHandle.remove(QUIZ_ANALYTICS_SOURCE_KEY);
        this.savedStateHandle.remove(QUIZ_ANALYTICS_PAGE_TYPE_KEY);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C61051(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIQuizViewModel$closeQuiz$1 */
    /* JADX INFO: compiled from: AIQuizViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIQuizViewModel$closeQuiz$1", m1609f = "AIQuizViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61051(Continuation<? super C61051> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIQuizViewModel.this.new C61051(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AIQuizViewModel.this._error.setValue(null);
                AIQuizViewModel.this._showAIQuizDisclaimer.setValue(Boxing.boxBoolean(false));
                AIQuizViewModel.this._showAIQuizPrompt.setValue(Boxing.boxBoolean(false));
                AIQuizViewModel.this._currentQuizMode.setValue(null);
                AIQuizViewModel.this._isQuizLoading.setValue(Boxing.boxBoolean(false));
                AIQuizViewModel.this._quizState.setValue(null);
                AIQuizViewModel.this._noteHidden.setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void answerQuestion(String answer) {
        boolean z;
        int i;
        Intrinsics.checkNotNullParameter(answer, "answer");
        QuizState value = this._quizState.getValue();
        if (value == null || value.getQuizEnded() || value.getCurrentQuestion() == null) {
            return;
        }
        if (value.getQuizMode() == QuizMode.MULTIPLE_CHOICE) {
            QuizQuestion currentQuestion = value.getCurrentQuestion();
            QuizMultipleChoiceQuestion quizMultipleChoiceQuestion = currentQuestion instanceof QuizMultipleChoiceQuestion ? (QuizMultipleChoiceQuestion) currentQuestion : null;
            String answer2 = quizMultipleChoiceQuestion != null ? quizMultipleChoiceQuestion.getAnswer() : null;
            if (!Intrinsics.areEqual(answer, quizMultipleChoiceQuestion != null ? quizMultipleChoiceQuestion.getA() : null) || !Intrinsics.areEqual(answer2, CmcdData.OBJECT_TYPE_AUDIO_ONLY)) {
                if (!Intrinsics.areEqual(answer, quizMultipleChoiceQuestion != null ? quizMultipleChoiceQuestion.getB() : null) || !Intrinsics.areEqual(answer2, "b")) {
                    if (!Intrinsics.areEqual(answer, quizMultipleChoiceQuestion != null ? quizMultipleChoiceQuestion.getC() : null) || !Intrinsics.areEqual(answer2, "c")) {
                        z = false;
                    }
                }
            }
            z = true;
        } else {
            QuizQuestion currentQuestion2 = value.getCurrentQuestion();
            QuizTrueFalseQuestion quizTrueFalseQuestion = currentQuestion2 instanceof QuizTrueFalseQuestion ? (QuizTrueFalseQuestion) currentQuestion2 : null;
            String answer3 = quizTrueFalseQuestion != null ? quizTrueFalseQuestion.getAnswer() : null;
            if ((Intrinsics.areEqual(answer, CredentialEntry.TRUE_STRING) && StringsKt.equals(answer3, "1", true)) || (Intrinsics.areEqual(answer, CredentialEntry.FALSE_STRING) && StringsKt.equals(answer3, "0", true))) {
                z = true;
            }
        }
        if (z) {
            i = C6091R.string.ai_quiz_right_answer;
        } else {
            i = C6091R.string.ai_quiz_wrong_answer;
        }
        this._quizState.setValue(QuizState.copy$default(value, 0, null, null, z ? value.getScore() + 1 : value.getScore(), false, null, new QuestionResult(value.getCurrentQuestion().getExplanation(), i), answer, false, false, false, value.getQuestions().indexOf(value.getCurrentQuestion()) + 1 == value.getExpectedQuestionCount(), 1847, null));
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIQuizViewModel$nextQuestion$1 */
    /* JADX INFO: compiled from: AIQuizViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIQuizViewModel$nextQuestion$1", m1609f = "AIQuizViewModel.kt", m1610i = {0, 0, 0}, m1611l = {661}, m1612m = "invokeSuspend", m1613n = {"currentState", "currentIndex", "nextIndex"}, m1614nl = {668}, m1615s = {"L$0", "I$0", "I$1"}, m1616v = 2)
    static final class C61131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        int label;

        C61131(Continuation<? super C61131> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIQuizViewModel.this.new C61131(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objWithContext;
            QuizState quizState;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                QuizState quizState2 = (QuizState) AIQuizViewModel.this._quizState.getValue();
                if (quizState2 == null) {
                    return Unit.INSTANCE;
                }
                if (quizState2.getQuizEnded() || quizState2.getCurrentQuestion() == null) {
                    return Unit.INSTANCE;
                }
                int iIndexOf = quizState2.getQuestions().indexOf(quizState2.getCurrentQuestion());
                int i2 = iIndexOf + 1;
                if (i2 >= quizState2.getExpectedQuestionCount()) {
                    this.L$0 = quizState2;
                    this.I$0 = iIndexOf;
                    this.I$1 = i2;
                    this.label = 1;
                    objWithContext = BuildersKt.withContext(AIQuizViewModel.this.ioDispatcher, new AIQuizViewModel$nextQuestion$1$shouldShowButton$1(AIQuizViewModel.this, quizState2, null), this);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    quizState = quizState2;
                } else {
                    QuizQuestion quizQuestion = (QuizQuestion) CollectionsKt.getOrNull(quizState2.getQuestions(), i2);
                    if (quizQuestion != null) {
                        AIQuizViewModel.this._quizState.setValue(QuizState.copy$default(quizState2, 0, null, quizQuestion, 0, false, null, null, null, false, false, false, false, 3131, null));
                    } else {
                        AIQuizViewModel.this._quizState.setValue(QuizState.copy$default(quizState2, 0, null, null, 0, false, null, null, null, false, true, false, false, 3131, null));
                    }
                    return Unit.INSTANCE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                QuizState quizState3 = (QuizState) this.L$0;
                ResultKt.throwOnFailure(obj);
                objWithContext = obj;
                quizState = quizState3;
            }
            boolean zBooleanValue = ((Boolean) objWithContext).booleanValue();
            String str = (String) AIQuizViewModel.this.savedStateHandle.get(AIQuizViewModel.QUIZ_ANALYTICS_PAGE_TYPE_KEY);
            final AIAnalyticsOrigin aIAnalyticsOriginValueOf = str != null ? AIAnalyticsOrigin.valueOf(str) : null;
            final String str2 = quizState.getQuizMode() == QuizMode.TRUE_FALSE ? AIQuizConstants.TRUE_FALSE : "multiple_choice";
            NeboFirebaseEvent.aiQuizCompleted.log(new Function1() { // from class: com.myscript.nebo.ai.presentation.AIQuizViewModel$nextQuestion$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return AIQuizViewModel.C61131.invokeSuspend$lambda$1(aIAnalyticsOriginValueOf, str2, (Bundle) obj2);
                }
            });
            AIQuizViewModel.this._quizState.setValue(QuizState.copy$default(quizState, 0, null, null, 0, true, null, null, null, zBooleanValue, false, false, false, 3627, null));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(AIAnalyticsOrigin aIAnalyticsOrigin, String str, Bundle bundle) {
            AnalyticsParametersKt.origin(bundle, aIAnalyticsOrigin);
            AnalyticsParametersKt.type(bundle, str);
            return Unit.INSTANCE;
        }
    }

    public final void nextQuestion() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C61131(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIQuizViewModel$nextQuestions$1 */
    /* JADX INFO: compiled from: AIQuizViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIQuizViewModel$nextQuestions$1", m1609f = "AIQuizViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61141(Continuation<? super C61141> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIQuizViewModel.this.new C61141(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData = AIQuizViewModel.this._quizState;
                QuizState quizState = (QuizState) AIQuizViewModel.this._quizState.getValue();
                mutableLiveData.setValue(quizState != null ? QuizState.copy$default(quizState, 0, null, null, 0, false, null, null, null, false, false, true, false, 3071, null) : null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void nextQuestions() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C61141(null), 2, null);
        executeQuizGeneration$default(this, null, true, 1, null);
    }

    public final void tryAgain() {
        QuizState value = this._quizState.getValue();
        if (value == null || !value.getQuizEnded() || value.getQuestions().isEmpty()) {
            return;
        }
        String str = (String) this.savedStateHandle.get(QUIZ_ANALYTICS_PAGE_TYPE_KEY);
        final AIAnalyticsOrigin aIAnalyticsOriginValueOf = str != null ? AIAnalyticsOrigin.valueOf(str) : null;
        final String str2 = (String) this.savedStateHandle.get(QUIZ_ANALYTICS_SOURCE_KEY);
        final AIQuizTrigger aIQuizTrigger = AIQuizTrigger.TRY_AGAIN;
        final String str3 = value.getQuizMode() == QuizMode.TRUE_FALSE ? AIQuizConstants.TRUE_FALSE : "multiple_choice";
        NeboFirebaseEvent.aiQuizStart.log(new Function1() { // from class: com.myscript.nebo.ai.presentation.AIQuizViewModel$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AIQuizViewModel.tryAgain$lambda$1(aIAnalyticsOriginValueOf, str3, aIQuizTrigger, str2, (Bundle) obj);
            }
        });
        List listShuffled = CollectionsKt.shuffled(value.getQuestions());
        this._quizState.setValue(QuizState.copy$default(value, 0, listShuffled, (QuizQuestion) CollectionsKt.first(listShuffled), 0, false, null, null, null, false, false, false, false, 1569, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tryAgain$lambda$1(AIAnalyticsOrigin aIAnalyticsOrigin, String str, AIQuizTrigger aIQuizTrigger, String str2, Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        AnalyticsParametersKt.origin(log, aIAnalyticsOrigin);
        AnalyticsParametersKt.type(log, str);
        AnalyticsParametersKt.trigger(log, aIQuizTrigger);
        AnalyticsParametersKt.aiQuizSelected(log, str2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int computeMaxExpectedQuestions(String text) {
        return (int) Math.min(Math.ceil(((double) text.length()) / 150.0d), 50.0d);
    }

    public final List<QuizSourceAction> getQuizSourceActions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QuizSourceAction.CurrentPage.INSTANCE);
        if (this.pagesCount > 1) {
            arrayList.add(QuizSourceAction.AllPages.INSTANCE);
            arrayList.add(QuizSourceAction.ChoosePages.INSTANCE);
        }
        return arrayList;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.aiClient.removeNetworkStateObserver();
    }

    /* JADX INFO: compiled from: AIQuizViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/AIQuizViewModel$Companion;", "", "<init>", "()V", "TAG", "", AIQuizViewModel.AI_QUIZ_DISCLAIMER_SHOWN, AIQuizViewModel.AI_QUIZ_DISCLAIMER_ACCEPTED, AIQuizViewModel.QUIZ_ANALYTICS_TRIGGER_KEY, AIQuizViewModel.QUIZ_ANALYTICS_SOURCE_KEY, AIQuizViewModel.QUIZ_ANALYTICS_PAGE_TYPE_KEY, "QUIZ_CONTENT_ID", "QUIZ_CONTENT_NAME", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewModelProvider.Factory getFactory() {
            return AIQuizViewModel.Factory;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AIQuizViewModel Factory$lambda$0$0(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        Object objRequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
        Intrinsics.checkNotNull(objRequireApplication, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
        LibraryRepository libraryRepositoryProvideLibraryRepository = ((LibraryRepository.Provider) objRequireApplication).provideLibraryRepository();
        NeboAIClient neboAIClientProvideNeboAIClient = ((NeboAIClient.Provider) objRequireApplication).provideNeboAIClient();
        ContextWrapper contextWrapper = (ContextWrapper) objRequireApplication;
        String str = contextWrapper.getPackageManager().getPackageInfo(contextWrapper.getPackageName(), 0).versionName;
        if (str == null) {
            str = "";
        }
        return new AIQuizViewModel(libraryRepositoryProvideLibraryRepository, neboAIClientProvideNeboAIClient, str, SavedStateHandleSupport.createSavedStateHandle(initializer), PreferenceManager.getDefaultSharedPreferences((Context) objRequireApplication), null, null, 96, null);
    }

    static {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(AIQuizViewModel.class), new Function1() { // from class: com.myscript.nebo.ai.presentation.AIQuizViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AIQuizViewModel.Factory$lambda$0$0((CreationExtras) obj);
            }
        });
        Factory = initializerViewModelFactoryBuilder.build();
    }
}
