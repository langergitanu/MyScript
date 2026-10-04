package com.myscript.nebo.p022ai.presentation;

import android.content.ComponentCallbacks2;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.media3.extractor.p007ts.TsExtractor;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.LaunchActivity;
import com.myscript.nebo.analytics.firebase.NeboFirebaseEvent;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.p022ai.AISummarizeTrigger;
import com.myscript.nebo.p022ai.AnalyticsParametersKt;
import com.myscript.nebo.p022ai.data.AIClient;
import com.myscript.nebo.p022ai.data.AIClientError;
import com.myscript.nebo.p022ai.data.NeboAIClient;
import com.myscript.nebo.p022ai.presentation.AISummarizeViewModel;
import com.myscript.nebo.p022ai.presentation.compose.AIError;
import com.myscript.nebo.p022ai.presentation.compose.AiTextSelection;
import com.myscript.nebo.p022ai.presentation.compose.TextSelectionProvider;
import com.myscript.snt.core.PageKey;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
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

/* JADX INFO: compiled from: AISummarizeViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000b\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001BB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0013H\u0002J\u0010\u0010*\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020+H\u0002J8\u0010,\u001a\u00020(2\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0.2\u0006\u00100\u001a\u00020\r2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u00104\u001a\u00020(2\n\b\u0002\u00101\u001a\u0004\u0018\u000102J\u0012\u00105\u001a\u00020(2\n\b\u0002\u00101\u001a\u0004\u0018\u000102J$\u00106\u001a\u00020(2\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001082\n\b\u0002\u00101\u001a\u0004\u0018\u000102J\u0006\u00109\u001a\u00020(J\u0010\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020#H\u0002J\u0010\u0010<\u001a\u00020(2\b\u0010=\u001a\u0004\u0018\u00010!J\u000e\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020#J\u0006\u0010@\u001a\u00020(J\u0006\u0010A\u001a\u00020(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u001c\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006C"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/AISummarizeViewModel;", "Landroidx/lifecycle/ViewModel;", "aiClient", "Lcom/myscript/nebo/ai/data/AIClient;", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "uiDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "<init>", "(Lcom/myscript/nebo/ai/data/AIClient;Lcom/myscript/nebo/dms/core/LibraryRepository;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_isLoading", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "isLoading", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "_aiGeneratedText", "", "aiGeneratedText", "getAiGeneratedText", "_error", "Lcom/myscript/nebo/ai/presentation/compose/AIError;", "error", "getError", "()Landroidx/lifecycle/MutableLiveData;", "_isStreamingComplete", "isStreamingComplete", "_chooseNoteInput", "chooseNoteInput", "getChooseNoteInput", "textSelectionProvider", "Lcom/myscript/nebo/ai/presentation/compose/TextSelectionProvider;", "pagesCount", "", LaunchActivity.LaunchRoute.Language, "getLanguage", "()Ljava/lang/String;", "appendText", "", "text", "handleAIError", "Lcom/myscript/nebo/ai/data/AIClientError;", "performTextOperation", "retrieveText", "Lkotlin/Function0;", "Lcom/myscript/nebo/ai/presentation/compose/AiTextSelection;", "shorten", "trigger", "Lcom/myscript/nebo/ai/AISummarizeTrigger;", "selectionType", "summarizeText", "summarizeCurrentPage", "summarizeAllPages", "childPageIds", "", "shortenText", "canSummarize", "contentCount", "setTextSelectionProvider", "provider", "updatePagesCount", "count", "closeNoteInput", "closeSummarize", "Companion", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AISummarizeViewModel extends ViewModel {
    private static final ViewModelProvider.Factory Factory;
    private final MutableLiveData<String> _aiGeneratedText;
    private final MutableLiveData<Boolean> _chooseNoteInput;
    private final MutableLiveData<AIError> _error;
    private final MutableLiveData<Boolean> _isLoading;
    private final MutableLiveData<Boolean> _isStreamingComplete;
    private final AIClient aiClient;
    private final LiveData<String> aiGeneratedText;
    private final LiveData<Boolean> chooseNoteInput;
    private final MutableLiveData<AIError> error;
    private final CoroutineDispatcher ioDispatcher;
    private final LiveData<Boolean> isLoading;
    private final LiveData<Boolean> isStreamingComplete;
    private final LibraryRepository libraryRepository;
    private int pagesCount;
    private TextSelectionProvider textSelectionProvider;
    private final CoroutineDispatcher uiDispatcher;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public AISummarizeViewModel(AIClient aiClient, LibraryRepository libraryRepository, CoroutineDispatcher uiDispatcher, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(aiClient, "aiClient");
        Intrinsics.checkNotNullParameter(libraryRepository, "libraryRepository");
        Intrinsics.checkNotNullParameter(uiDispatcher, "uiDispatcher");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.aiClient = aiClient;
        this.libraryRepository = libraryRepository;
        this.uiDispatcher = uiDispatcher;
        this.ioDispatcher = ioDispatcher;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(false);
        this._isLoading = mutableLiveData;
        this.isLoading = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this._aiGeneratedText = mutableLiveData2;
        this.aiGeneratedText = mutableLiveData2;
        MutableLiveData<AIError> mutableLiveData3 = new MutableLiveData<>();
        this._error = mutableLiveData3;
        this.error = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>(false);
        this._isStreamingComplete = mutableLiveData4;
        this.isStreamingComplete = mutableLiveData4;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>(false);
        this._chooseNoteInput = mutableLiveData5;
        this.chooseNoteInput = mutableLiveData5;
    }

    public /* synthetic */ AISummarizeViewModel(AIClient aIClient, LibraryRepository libraryRepository, MainCoroutineDispatcher mainCoroutineDispatcher, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(aIClient, libraryRepository, (i & 4) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher, (i & 8) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    public final LiveData<Boolean> isLoading() {
        return this.isLoading;
    }

    public final LiveData<String> getAiGeneratedText() {
        return this.aiGeneratedText;
    }

    public final MutableLiveData<AIError> getError() {
        return this.error;
    }

    public final LiveData<Boolean> isStreamingComplete() {
        return this.isStreamingComplete;
    }

    public final LiveData<Boolean> getChooseNoteInput() {
        return this.chooseNoteInput;
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void appendText(String text) {
        MutableLiveData<String> mutableLiveData = this._aiGeneratedText;
        String value = mutableLiveData.getValue();
        if (value == null) {
            value = "";
        }
        mutableLiveData.setValue(value + text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAIError(AIClientError error) {
        AIError.NetworkError networkError;
        MutableLiveData<AIError> mutableLiveData = this._error;
        if (error instanceof AIClientError.QuotaError) {
            networkError = AIError.QuotaError.INSTANCE;
        } else if (error instanceof AIClientError.ContextLimitError) {
            networkError = AIError.ContextLimit.INSTANCE;
        } else if (error instanceof AIClientError.ServerError) {
            networkError = AIError.ServerError.INSTANCE;
        } else {
            if (!(error instanceof AIClientError.NetworkError)) {
                if (!Intrinsics.areEqual(error, AIClientError.UnknownError.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new NotImplementedError(null, 1, null);
            }
            networkError = AIError.NetworkError.INSTANCE;
        }
        mutableLiveData.setValue(networkError);
    }

    static /* synthetic */ void performTextOperation$default(AISummarizeViewModel aISummarizeViewModel, Function0 function0, boolean z, AISummarizeTrigger aISummarizeTrigger, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            aISummarizeTrigger = null;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        aISummarizeViewModel.performTextOperation(function0, z, aISummarizeTrigger, str);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AISummarizeViewModel$performTextOperation$1 */
    /* JADX INFO: compiled from: AISummarizeViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AISummarizeViewModel$performTextOperation$1", m1609f = "AISummarizeViewModel.kt", m1610i = {0, 0, 1, 1, 2, 2}, m1611l = {PDFACompliance.e_PDFA9_4, 101, 101}, m1612m = "invokeSuspend", m1613n = {"aiTextSelection", "text", "aiTextSelection", "text", "aiTextSelection", "text"}, m1614nl = {101, 101, 114}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"}, m1616v = 2)
    static final class C61251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<AiTextSelection> $retrieveText;
        final /* synthetic */ String $selectionType;
        final /* synthetic */ boolean $shorten;
        final /* synthetic */ AISummarizeTrigger $trigger;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ AISummarizeViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C61251(Function0<AiTextSelection> function0, AISummarizeViewModel aISummarizeViewModel, boolean z, String str, AISummarizeTrigger aISummarizeTrigger, Continuation<? super C61251> continuation) {
            super(2, continuation);
            this.$retrieveText = function0;
            this.this$0 = aISummarizeViewModel;
            this.$shorten = z;
            this.$selectionType = str;
            this.$trigger = aISummarizeTrigger;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C61251(this.$retrieveText, this.this$0, this.$shorten, this.$selectionType, this.$trigger, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x00e3, code lost:
        
            if (((kotlinx.coroutines.flow.Flow) r11).collect(new com.myscript.nebo.p022ai.presentation.AISummarizeViewModel.C61251.AnonymousClass3(), r10) != r0) goto L36;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00c0  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            final AiTextSelection aiTextSelectionInvoke;
            String str;
            AiTextSelection aiTextSelection;
            Object objSummarize;
            AiTextSelection aiTextSelection2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                aiTextSelectionInvoke = this.$retrieveText.invoke();
                if (aiTextSelectionInvoke != null) {
                    final String str2 = this.$selectionType;
                    final AISummarizeTrigger aISummarizeTrigger = this.$trigger;
                    NeboFirebaseEvent.aiSummarize.log(new Function1() { // from class: com.myscript.nebo.ai.presentation.AISummarizeViewModel$performTextOperation$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return AISummarizeViewModel.C61251.invokeSuspend$lambda$0$0(aiTextSelectionInvoke, str2, aiTextSelectionInvoke, aISummarizeTrigger, (Bundle) obj2);
                        }
                    });
                }
                String selectedText = aiTextSelectionInvoke != null ? aiTextSelectionInvoke.getSelectedText() : null;
                if (selectedText == null) {
                    selectedText = "";
                }
                if (selectedText.length() == 0) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelectionInvoke);
                    this.L$1 = selectedText;
                    this.label = 1;
                    if (BuildersKt.withContext(this.this$0.uiDispatcher, new AnonymousClass2(this.this$0, null), this) != coroutine_suspended) {
                        aiTextSelection = aiTextSelectionInvoke;
                        str = selectedText;
                    }
                    return coroutine_suspended;
                }
                str = selectedText;
                this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelectionInvoke);
                this.L$1 = SpillingKt.nullOutSpilledVariable(str);
                this.label = 2;
                objSummarize = this.this$0.aiClient.summarize(str, this.$shorten, this.this$0.getLanguage(), this);
                if (objSummarize != coroutine_suspended) {
                    aiTextSelection2 = aiTextSelectionInvoke;
                    obj = objSummarize;
                    final AISummarizeViewModel aISummarizeViewModel = this.this$0;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelection2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    this.label = 3;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                str = (String) this.L$1;
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
                str = (String) this.L$1;
                aiTextSelection2 = (AiTextSelection) this.L$0;
                ResultKt.throwOnFailure(obj);
                final AISummarizeViewModel aISummarizeViewModel2 = this.this$0;
                this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelection2);
                this.L$1 = SpillingKt.nullOutSpilledVariable(str);
                this.label = 3;
            }
            aiTextSelectionInvoke = aiTextSelection;
            this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelectionInvoke);
            this.L$1 = SpillingKt.nullOutSpilledVariable(str);
            this.label = 2;
            objSummarize = this.this$0.aiClient.summarize(str, this.$shorten, this.this$0.getLanguage(), this);
            if (objSummarize != coroutine_suspended) {
            }
            return coroutine_suspended;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$0(AiTextSelection aiTextSelection, String str, AiTextSelection aiTextSelection2, AISummarizeTrigger aISummarizeTrigger, Bundle bundle) {
            AnalyticsParametersKt.origin(bundle, aiTextSelection.getPageType());
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                str = aiTextSelection2.getSelectionType();
            }
            AnalyticsParametersKt.selected(bundle, str);
            AnalyticsParametersKt.trigger(bundle, aISummarizeTrigger);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AISummarizeViewModel$performTextOperation$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: AISummarizeViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AISummarizeViewModel$performTextOperation$1$2", m1609f = "AISummarizeViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AISummarizeViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(AISummarizeViewModel aISummarizeViewModel, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = aISummarizeViewModel;
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
                    this.this$0._isLoading.setValue(Boxing.boxBoolean(false));
                    this.this$0._error.postValue(AIError.NotEnoughText.INSTANCE);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void performTextOperation(Function0<AiTextSelection> retrieveText, boolean shorten, AISummarizeTrigger trigger, String selectionType) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.ioDispatcher, null, new C61251(retrieveText, this, shorten, selectionType, trigger, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AISummarizeViewModel$summarizeText$1 */
    /* JADX INFO: compiled from: AISummarizeViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AISummarizeViewModel$summarizeText$1", m1609f = "AISummarizeViewModel.kt", m1610i = {0, 0, 1, 1, 2, 2, 2}, m1611l = {PDFACompliance.e_PDFA1_2_2, 134, 144}, m1612m = "invokeSuspend", m1613n = {FirebaseAnalytics.Param.CONTENT, "contentCount", FirebaseAnalytics.Param.CONTENT, "contentCount", FirebaseAnalytics.Param.CONTENT, "textRetriever", "contentCount"}, m1614nl = {TsExtractor.TS_STREAM_TYPE_AC3, 137, 152}, m1615s = {"L$0", "I$0", "L$0", "I$0", "L$0", "L$1", "I$0"}, m1616v = 2)
    static final class C61321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AISummarizeTrigger $trigger;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C61321(AISummarizeTrigger aISummarizeTrigger, Continuation<? super C61321> continuation) {
            super(2, continuation);
            this.$trigger = aISummarizeTrigger;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AISummarizeViewModel.this.new C61321(this.$trigger, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61321) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00cc, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r11.this$0.uiDispatcher, new com.myscript.nebo.p022ai.presentation.AISummarizeViewModel$summarizeText$1$textRetriever$2(r11.this$0, null), r11) == r0) goto L39;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AiTextSelection aiTextSelectionAvailableTextInCurrentPage;
            int length;
            Function0 function0;
            Function0 function02;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TextSelectionProvider textSelectionProvider = AISummarizeViewModel.this.textSelectionProvider;
                aiTextSelectionAvailableTextInCurrentPage = textSelectionProvider != null ? textSelectionProvider.availableTextInCurrentPage() : null;
                String selectedText = aiTextSelectionAvailableTextInCurrentPage != null ? aiTextSelectionAvailableTextInCurrentPage.getSelectedText() : null;
                if (selectedText == null) {
                    selectedText = "";
                }
                length = StringsKt.trim((CharSequence) selectedText).toString().length();
                this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelectionAvailableTextInCurrentPage);
                this.I$0 = length;
                this.label = 1;
                if (BuildersKt.withContext(AISummarizeViewModel.this.uiDispatcher, new AnonymousClass1(AISummarizeViewModel.this, length, null), this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Function0 function03 = (Function0) this.L$1;
                ResultKt.throwOnFailure(obj);
                function02 = function03;
                AISummarizeViewModel.performTextOperation$default(AISummarizeViewModel.this, function02, false, this.$trigger, null, 8, null);
                return Unit.INSTANCE;
            }
            length = this.I$0;
            aiTextSelectionAvailableTextInCurrentPage = (AiTextSelection) this.L$0;
            ResultKt.throwOnFailure(obj);
            TextSelectionProvider textSelectionProvider2 = AISummarizeViewModel.this.textSelectionProvider;
            if (textSelectionProvider2 == null || !textSelectionProvider2.hasSelection()) {
                if (AISummarizeViewModel.this.pagesCount > 1) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelectionAvailableTextInCurrentPage);
                    this.I$0 = length;
                    this.label = 2;
                } else {
                    final AISummarizeViewModel aISummarizeViewModel = AISummarizeViewModel.this;
                    function0 = new Function0() { // from class: com.myscript.nebo.ai.presentation.AISummarizeViewModel$summarizeText$1$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AISummarizeViewModel.C61321.invokeSuspend$lambda$1(aISummarizeViewModel);
                        }
                    };
                }
            } else {
                final AISummarizeViewModel aISummarizeViewModel2 = AISummarizeViewModel.this;
                function0 = new Function0() { // from class: com.myscript.nebo.ai.presentation.AISummarizeViewModel$summarizeText$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AISummarizeViewModel.C61321.invokeSuspend$lambda$0(aISummarizeViewModel2);
                    }
                };
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelectionAvailableTextInCurrentPage);
            this.L$1 = function0;
            this.I$0 = length;
            this.label = 3;
            if (BuildersKt.withContext(AISummarizeViewModel.this.uiDispatcher, new AnonymousClass2(AISummarizeViewModel.this, null), this) != coroutine_suspended) {
                function02 = function0;
                AISummarizeViewModel.performTextOperation$default(AISummarizeViewModel.this, function02, false, this.$trigger, null, 8, null);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AISummarizeViewModel$summarizeText$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: AISummarizeViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AISummarizeViewModel$summarizeText$1$1", m1609f = "AISummarizeViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $contentCount;
            int label;
            final /* synthetic */ AISummarizeViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AISummarizeViewModel aISummarizeViewModel, int i, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = aISummarizeViewModel;
                this.$contentCount = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$contentCount, continuation);
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
                    if (!this.this$0.canSummarize(this.$contentCount)) {
                        this.this$0._error.setValue(AIError.NotEnoughText.INSTANCE);
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AiTextSelection invokeSuspend$lambda$0(AISummarizeViewModel aISummarizeViewModel) {
            TextSelectionProvider textSelectionProvider = aISummarizeViewModel.textSelectionProvider;
            if (textSelectionProvider != null) {
                return textSelectionProvider.getPageTextSelection();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AiTextSelection invokeSuspend$lambda$1(AISummarizeViewModel aISummarizeViewModel) {
            TextSelectionProvider textSelectionProvider = aISummarizeViewModel.textSelectionProvider;
            if (textSelectionProvider != null) {
                return textSelectionProvider.availableTextInCurrentPage();
            }
            return null;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AISummarizeViewModel$summarizeText$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: AISummarizeViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AISummarizeViewModel$summarizeText$1$2", m1609f = "AISummarizeViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AISummarizeViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(AISummarizeViewModel aISummarizeViewModel, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = aISummarizeViewModel;
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
                    this.this$0._chooseNoteInput.setValue(Boxing.boxBoolean(false));
                    this.this$0._error.setValue(null);
                    this.this$0._isStreamingComplete.setValue(Boxing.boxBoolean(false));
                    this.this$0._aiGeneratedText.setValue("");
                    this.this$0._isLoading.setValue(Boxing.boxBoolean(true));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static /* synthetic */ void summarizeText$default(AISummarizeViewModel aISummarizeViewModel, AISummarizeTrigger aISummarizeTrigger, int i, Object obj) {
        if ((i & 1) != 0) {
            aISummarizeTrigger = null;
        }
        aISummarizeViewModel.summarizeText(aISummarizeTrigger);
    }

    public final void summarizeText(AISummarizeTrigger trigger) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.ioDispatcher, null, new C61321(trigger, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AISummarizeViewModel$summarizeCurrentPage$1 */
    /* JADX INFO: compiled from: AISummarizeViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AISummarizeViewModel$summarizeCurrentPage$1", m1609f = "AISummarizeViewModel.kt", m1610i = {0, 0}, m1611l = {165}, m1612m = "invokeSuspend", m1613n = {FirebaseAnalytics.Param.CONTENT, "contentCount"}, m1614nl = {178}, m1615s = {"L$0", "I$0"}, m1616v = 2)
    static final class C61301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AISummarizeTrigger $trigger;
        int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C61301(AISummarizeTrigger aISummarizeTrigger, Continuation<? super C61301> continuation) {
            super(2, continuation);
            this.$trigger = aISummarizeTrigger;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AISummarizeViewModel.this.new C61301(this.$trigger, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TextSelectionProvider textSelectionProvider = AISummarizeViewModel.this.textSelectionProvider;
                AiTextSelection aiTextSelectionAvailableTextInCurrentPage = textSelectionProvider != null ? textSelectionProvider.availableTextInCurrentPage() : null;
                String selectedText = aiTextSelectionAvailableTextInCurrentPage != null ? aiTextSelectionAvailableTextInCurrentPage.getSelectedText() : null;
                if (selectedText == null) {
                    selectedText = "";
                }
                int length = StringsKt.trim((CharSequence) selectedText).toString().length();
                this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelectionAvailableTextInCurrentPage);
                this.I$0 = length;
                this.label = 1;
                if (BuildersKt.withContext(AISummarizeViewModel.this.uiDispatcher, new AnonymousClass1(AISummarizeViewModel.this, length, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            final AISummarizeViewModel aISummarizeViewModel = AISummarizeViewModel.this;
            AISummarizeViewModel.performTextOperation$default(aISummarizeViewModel, new Function0() { // from class: com.myscript.nebo.ai.presentation.AISummarizeViewModel$summarizeCurrentPage$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AISummarizeViewModel.C61301.invokeSuspend$lambda$0(aISummarizeViewModel);
                }
            }, false, this.$trigger, null, 8, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AISummarizeViewModel$summarizeCurrentPage$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: AISummarizeViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AISummarizeViewModel$summarizeCurrentPage$1$1", m1609f = "AISummarizeViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $contentCount;
            int label;
            final /* synthetic */ AISummarizeViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AISummarizeViewModel aISummarizeViewModel, int i, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = aISummarizeViewModel;
                this.$contentCount = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$contentCount, continuation);
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
                    this.this$0._chooseNoteInput.setValue(Boxing.boxBoolean(false));
                    if (!this.this$0.canSummarize(this.$contentCount)) {
                        this.this$0._error.setValue(AIError.NotEnoughText.INSTANCE);
                        return Unit.INSTANCE;
                    }
                    this.this$0._error.setValue(null);
                    this.this$0._isStreamingComplete.setValue(Boxing.boxBoolean(false));
                    this.this$0._aiGeneratedText.setValue("");
                    this.this$0._isLoading.setValue(Boxing.boxBoolean(true));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AiTextSelection invokeSuspend$lambda$0(AISummarizeViewModel aISummarizeViewModel) {
            TextSelectionProvider textSelectionProvider = aISummarizeViewModel.textSelectionProvider;
            if (textSelectionProvider != null) {
                return textSelectionProvider.availableTextInCurrentPage();
            }
            return null;
        }
    }

    public static /* synthetic */ void summarizeCurrentPage$default(AISummarizeViewModel aISummarizeViewModel, AISummarizeTrigger aISummarizeTrigger, int i, Object obj) {
        if ((i & 1) != 0) {
            aISummarizeTrigger = null;
        }
        aISummarizeViewModel.summarizeCurrentPage(aISummarizeTrigger);
    }

    public final void summarizeCurrentPage(AISummarizeTrigger trigger) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.ioDispatcher, null, new C61301(trigger, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AISummarizeViewModel$summarizeAllPages$1 */
    /* JADX INFO: compiled from: AISummarizeViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AISummarizeViewModel$summarizeAllPages$1", m1609f = "AISummarizeViewModel.kt", m1610i = {0, 0}, m1611l = {191}, m1612m = "invokeSuspend", m1613n = {FirebaseAnalytics.Param.CONTENT, "contentCount"}, m1614nl = {204}, m1615s = {"L$0", "I$0"}, m1616v = 2)
    static final class C61281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $childPageIds;
        final /* synthetic */ AISummarizeTrigger $trigger;
        int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C61281(AISummarizeTrigger aISummarizeTrigger, List<String> list, Continuation<? super C61281> continuation) {
            super(2, continuation);
            this.$trigger = aISummarizeTrigger;
            this.$childPageIds = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AISummarizeViewModel.this.new C61281(this.$trigger, this.$childPageIds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TextSelectionProvider textSelectionProvider = AISummarizeViewModel.this.textSelectionProvider;
                AiTextSelection aiTextSelectionAvailableTextInCurrentPage = textSelectionProvider != null ? textSelectionProvider.availableTextInCurrentPage() : null;
                String selectedText = aiTextSelectionAvailableTextInCurrentPage != null ? aiTextSelectionAvailableTextInCurrentPage.getSelectedText() : null;
                if (selectedText == null) {
                    selectedText = "";
                }
                int length = StringsKt.trim((CharSequence) selectedText).toString().length();
                this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelectionAvailableTextInCurrentPage);
                this.I$0 = length;
                this.label = 1;
                if (BuildersKt.withContext(AISummarizeViewModel.this.uiDispatcher, new AnonymousClass1(AISummarizeViewModel.this, length, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            final AISummarizeViewModel aISummarizeViewModel = AISummarizeViewModel.this;
            final List<String> list = this.$childPageIds;
            AISummarizeViewModel.performTextOperation$default(aISummarizeViewModel, new Function0() { // from class: com.myscript.nebo.ai.presentation.AISummarizeViewModel$summarizeAllPages$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AISummarizeViewModel.C61281.invokeSuspend$lambda$0(aISummarizeViewModel, list);
                }
            }, false, this.$trigger, null, 8, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AISummarizeViewModel$summarizeAllPages$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: AISummarizeViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AISummarizeViewModel$summarizeAllPages$1$1", m1609f = "AISummarizeViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $contentCount;
            int label;
            final /* synthetic */ AISummarizeViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AISummarizeViewModel aISummarizeViewModel, int i, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = aISummarizeViewModel;
                this.$contentCount = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$contentCount, continuation);
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
                    this.this$0._chooseNoteInput.setValue(Boxing.boxBoolean(false));
                    if (!this.this$0.canSummarize(this.$contentCount)) {
                        this.this$0._error.setValue(AIError.NotEnoughText.INSTANCE);
                        return Unit.INSTANCE;
                    }
                    this.this$0._error.setValue(null);
                    this.this$0._isStreamingComplete.setValue(Boxing.boxBoolean(false));
                    this.this$0._aiGeneratedText.setValue("");
                    this.this$0._isLoading.setValue(Boxing.boxBoolean(true));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AiTextSelection invokeSuspend$lambda$0(AISummarizeViewModel aISummarizeViewModel, List list) {
            TextSelectionProvider textSelectionProvider = aISummarizeViewModel.textSelectionProvider;
            if (textSelectionProvider != null) {
                return textSelectionProvider.getAllPagesText(list);
            }
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void summarizeAllPages$default(AISummarizeViewModel aISummarizeViewModel, List list, AISummarizeTrigger aISummarizeTrigger, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        if ((i & 2) != 0) {
            aISummarizeTrigger = null;
        }
        aISummarizeViewModel.summarizeAllPages(list, aISummarizeTrigger);
    }

    public final void summarizeAllPages(List<String> childPageIds, AISummarizeTrigger trigger) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.ioDispatcher, null, new C61281(trigger, childPageIds, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AISummarizeViewModel$shortenText$1 */
    /* JADX INFO: compiled from: AISummarizeViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AISummarizeViewModel$shortenText$1", m1609f = "AISummarizeViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61271(Continuation<? super C61271> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AISummarizeViewModel.this.new C61271(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61271) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                final String str = (String) AISummarizeViewModel.this._aiGeneratedText.getValue();
                if (str == null) {
                    str = "";
                }
                if (AISummarizeViewModel.this.canSummarize(str.length())) {
                    AISummarizeViewModel.this._error.setValue(null);
                    AISummarizeViewModel.this._isStreamingComplete.setValue(Boxing.boxBoolean(false));
                    AISummarizeViewModel.this._aiGeneratedText.setValue("");
                    AISummarizeViewModel.this._isLoading.setValue(Boxing.boxBoolean(true));
                    AISummarizeViewModel.performTextOperation$default(AISummarizeViewModel.this, new Function0() { // from class: com.myscript.nebo.ai.presentation.AISummarizeViewModel$shortenText$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AISummarizeViewModel.C61271.invokeSuspend$lambda$0(str);
                        }
                    }, true, null, null, 12, null);
                } else {
                    AISummarizeViewModel.this._error.setValue(AIError.NotEnoughText.INSTANCE);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AiTextSelection invokeSuspend$lambda$0(String str) {
            return new AiTextSelection(str, null, null, null, 14, null);
        }
    }

    public final void shortenText() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C61271(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canSummarize(int contentCount) {
        return this.pagesCount > 0 || contentCount > 299;
    }

    public final void setTextSelectionProvider(TextSelectionProvider provider) {
        this.textSelectionProvider = provider;
    }

    public final void updatePagesCount(int count) {
        this.pagesCount = count;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AISummarizeViewModel$closeNoteInput$1 */
    /* JADX INFO: compiled from: AISummarizeViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AISummarizeViewModel$closeNoteInput$1", m1609f = "AISummarizeViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61231(Continuation<? super C61231> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AISummarizeViewModel.this.new C61231(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61231) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AISummarizeViewModel.this._chooseNoteInput.setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void closeNoteInput() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C61231(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AISummarizeViewModel$closeSummarize$1 */
    /* JADX INFO: compiled from: AISummarizeViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AISummarizeViewModel$closeSummarize$1", m1609f = "AISummarizeViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61241(Continuation<? super C61241> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AISummarizeViewModel.this.new C61241(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AISummarizeViewModel.this._error.setValue(null);
                AISummarizeViewModel.this._chooseNoteInput.setValue(Boxing.boxBoolean(false));
                AISummarizeViewModel.this._aiGeneratedText.setValue("");
                AISummarizeViewModel.this._isStreamingComplete.setValue(Boxing.boxBoolean(false));
                AISummarizeViewModel.this._isLoading.setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void closeSummarize() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C61241(null), 2, null);
    }

    /* JADX INFO: compiled from: AISummarizeViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/AISummarizeViewModel$Companion;", "", "<init>", "()V", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewModelProvider.Factory getFactory() {
            return AISummarizeViewModel.Factory;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AISummarizeViewModel Factory$lambda$0$0(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        ComponentCallbacks2 componentCallbacks2RequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
        Intrinsics.checkNotNull(componentCallbacks2RequireApplication, "null cannot be cast to non-null type com.myscript.nebo.ai.data.NeboAIClient.Provider");
        return new AISummarizeViewModel(((NeboAIClient.Provider) componentCallbacks2RequireApplication).provideNeboAIClient(), ((LibraryRepository.Provider) componentCallbacks2RequireApplication).provideLibraryRepository(), null, null, 12, null);
    }

    static {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(AISummarizeViewModel.class), new Function1() { // from class: com.myscript.nebo.ai.presentation.AISummarizeViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AISummarizeViewModel.Factory$lambda$0$0((CreationExtras) obj);
            }
        });
        Factory = initializerViewModelFactoryBuilder.build();
    }
}
