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
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.LaunchActivity;
import com.myscript.nebo.analytics.firebase.NeboFirebaseEvent;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.p022ai.AIExplainTrigger;
import com.myscript.nebo.p022ai.AnalyticsParametersKt;
import com.myscript.nebo.p022ai.data.AIClient;
import com.myscript.nebo.p022ai.data.AIClientError;
import com.myscript.nebo.p022ai.data.NeboAIClient;
import com.myscript.nebo.p022ai.presentation.AIExplainViewModel;
import com.myscript.nebo.p022ai.presentation.compose.AIError;
import com.myscript.nebo.p022ai.presentation.compose.AiTextSelection;
import com.myscript.nebo.p022ai.presentation.compose.TextSelectionProvider;
import com.myscript.snt.core.PageKey;
import com.pdftron.pdf.pdfa.PDFACompliance;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.apache.commons.codec.binary.BaseNCodec;

/* JADX INFO: compiled from: AIExplainViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0013H\u0002J\u0010\u0010'\u001a\u00020#2\b\b\u0002\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020#J\u0016\u0010+\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020#2\b\u0010.\u001a\u0004\u0018\u00010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u00060"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/AIExplainViewModel;", "Landroidx/lifecycle/ViewModel;", "aiClient", "Lcom/myscript/nebo/ai/data/AIClient;", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "uiDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "<init>", "(Lcom/myscript/nebo/ai/data/AIClient;Lcom/myscript/nebo/dms/core/LibraryRepository;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_isLoading", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "isLoading", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "_aiGeneratedText", "", "aiGeneratedText", "getAiGeneratedText", "_error", "Lcom/myscript/nebo/ai/presentation/compose/AIError;", "error", "getError", "()Landroidx/lifecycle/MutableLiveData;", "_isStreamingComplete", "isStreamingComplete", "textSelectionProvider", "Lcom/myscript/nebo/ai/presentation/compose/TextSelectionProvider;", LaunchActivity.LaunchRoute.Language, "getLanguage", "()Ljava/lang/String;", "handleAIError", "", "Lcom/myscript/nebo/ai/data/AIClientError;", "appendText", "text", "explainText", "trigger", "Lcom/myscript/nebo/ai/AIExplainTrigger;", "closeExplain", "setError", "(Lcom/myscript/nebo/ai/presentation/compose/AIError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTextSelectionProvider", "provider", "Companion", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AIExplainViewModel extends ViewModel {
    private static final ViewModelProvider.Factory Factory;
    private static final String TAG = "AIExplainViewModel";
    private final MutableLiveData<String> _aiGeneratedText;
    private final MutableLiveData<AIError> _error;
    private final MutableLiveData<Boolean> _isLoading;
    private final MutableLiveData<Boolean> _isStreamingComplete;
    private final AIClient aiClient;
    private final LiveData<String> aiGeneratedText;
    private final MutableLiveData<AIError> error;
    private final CoroutineDispatcher ioDispatcher;
    private final LiveData<Boolean> isLoading;
    private final LiveData<Boolean> isStreamingComplete;
    private final LibraryRepository libraryRepository;
    private TextSelectionProvider textSelectionProvider;
    private final CoroutineDispatcher uiDispatcher;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public AIExplainViewModel(AIClient aiClient, LibraryRepository libraryRepository, CoroutineDispatcher uiDispatcher, CoroutineDispatcher ioDispatcher) {
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
    }

    public /* synthetic */ AIExplainViewModel(AIClient aIClient, LibraryRepository libraryRepository, MainCoroutineDispatcher mainCoroutineDispatcher, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void appendText(String text) {
        MutableLiveData<String> mutableLiveData = this._aiGeneratedText;
        String value = mutableLiveData.getValue();
        if (value == null) {
            value = "";
        }
        mutableLiveData.setValue(value + text);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIExplainViewModel$explainText$1 */
    /* JADX INFO: compiled from: AIExplainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIExplainViewModel$explainText$1", m1609f = "AIExplainViewModel.kt", m1610i = {0, 1, 2, 3, 4}, m1611l = {BaseNCodec.MIME_CHUNK_SIZE, PDFACompliance.e_PDFA8_1, PDFACompliance.e_PDFA9_1, 98, 98}, m1612m = "invokeSuspend", m1613n = {"textSelection", "textSelection", "textSelection", "textSelection", "textSelection"}, m1614nl = {77, 82, 98, 98, 111}, m1615s = {"L$0", "L$0", "L$0", "L$0", "L$0"}, m1616v = 2)
    static final class C61021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AIExplainTrigger $trigger;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C61021(AIExplainTrigger aIExplainTrigger, Continuation<? super C61021> continuation) {
            super(2, continuation);
            this.$trigger = aIExplainTrigger;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIExplainViewModel.this.new C61021(this.$trigger, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x008e, code lost:
        
            if (r9.this$0.setError(com.myscript.nebo.ai.presentation.compose.AIError.ContextLimit.INSTANCE, r9) == r0) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0101, code lost:
        
            if (((kotlinx.coroutines.flow.Flow) r10).collect(new com.myscript.nebo.p022ai.presentation.AIExplainViewModel.C61021.AnonymousClass3(), r9) != r0) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x011c, code lost:
        
            if (r9.this$0.setError(com.myscript.nebo.ai.presentation.compose.AIError.NotEnoughText.INSTANCE, r9) == r0) goto L45;
         */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00e7 A[PHI: r1 r10
          0x00e7: PHI (r1v9 com.myscript.nebo.ai.presentation.compose.AiTextSelection) = 
          (r1v8 com.myscript.nebo.ai.presentation.compose.AiTextSelection)
          (r1v14 com.myscript.nebo.ai.presentation.compose.AiTextSelection)
         binds: [B:36:0x00e4, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]
          0x00e7: PHI (r10v15 java.lang.Object) = (r10v14 java.lang.Object), (r10v0 java.lang.Object) binds: [B:36:0x00e4, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AiTextSelection aiTextSelection;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TextSelectionProvider textSelectionProvider = AIExplainViewModel.this.textSelectionProvider;
                final AiTextSelection aiTextSelectionTextSelectionWithContext = textSelectionProvider != null ? textSelectionProvider.textSelectionWithContext() : null;
                if (aiTextSelectionTextSelectionWithContext == null || aiTextSelectionTextSelectionWithContext.getSelectedText().length() == 0) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelectionTextSelectionWithContext);
                    this.label = 1;
                } else if (aiTextSelectionTextSelectionWithContext.getSelectedText().length() > 300) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelectionTextSelectionWithContext);
                    this.label = 2;
                } else {
                    NeboFirebaseEvent neboFirebaseEvent = NeboFirebaseEvent.aiExplain;
                    final AIExplainTrigger aIExplainTrigger = this.$trigger;
                    neboFirebaseEvent.log(new Function1() { // from class: com.myscript.nebo.ai.presentation.AIExplainViewModel$explainText$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return AIExplainViewModel.C61021.invokeSuspend$lambda$0(aiTextSelectionTextSelectionWithContext, aIExplainTrigger, (Bundle) obj2);
                        }
                    });
                    this.L$0 = aiTextSelectionTextSelectionWithContext;
                    this.label = 3;
                    if (BuildersKt.withContext(AIExplainViewModel.this.uiDispatcher, new AnonymousClass2(AIExplainViewModel.this, null), this) != coroutine_suspended) {
                        aiTextSelection = aiTextSelectionTextSelectionWithContext;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelection);
                        this.label = 4;
                        obj = AIExplainViewModel.this.aiClient.explain(aiTextSelection.getSelectedText(), aiTextSelection.getContext(), AIExplainViewModel.this.getLanguage(), this);
                        if (obj != coroutine_suspended) {
                        }
                    }
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i == 3) {
                aiTextSelection = (AiTextSelection) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelection);
                this.label = 4;
                obj = AIExplainViewModel.this.aiClient.explain(aiTextSelection.getSelectedText(), aiTextSelection.getContext(), AIExplainViewModel.this.getLanguage(), this);
                if (obj != coroutine_suspended) {
                    final AIExplainViewModel aIExplainViewModel = AIExplainViewModel.this;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelection);
                    this.label = 5;
                }
                return coroutine_suspended;
            }
            if (i != 4) {
                if (i != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            aiTextSelection = (AiTextSelection) this.L$0;
            ResultKt.throwOnFailure(obj);
            final AIExplainViewModel aIExplainViewModel2 = AIExplainViewModel.this;
            this.L$0 = SpillingKt.nullOutSpilledVariable(aiTextSelection);
            this.label = 5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(AiTextSelection aiTextSelection, AIExplainTrigger aIExplainTrigger, Bundle bundle) {
            AnalyticsParametersKt.origin(bundle, aiTextSelection.getPageType());
            AnalyticsParametersKt.selected(bundle, aiTextSelection.getSelectionType());
            AnalyticsParametersKt.trigger(bundle, aIExplainTrigger);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIExplainViewModel$explainText$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: AIExplainViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIExplainViewModel$explainText$1$2", m1609f = "AIExplainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AIExplainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(AIExplainViewModel aIExplainViewModel, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = aIExplainViewModel;
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

    public static /* synthetic */ void explainText$default(AIExplainViewModel aIExplainViewModel, AIExplainTrigger aIExplainTrigger, int i, Object obj) {
        if ((i & 1) != 0) {
            aIExplainTrigger = AIExplainTrigger.BUTTON;
        }
        aIExplainViewModel.explainText(aIExplainTrigger);
    }

    public final void explainText(AIExplainTrigger trigger) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.ioDispatcher, null, new C61021(trigger, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIExplainViewModel$closeExplain$1 */
    /* JADX INFO: compiled from: AIExplainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIExplainViewModel$closeExplain$1", m1609f = "AIExplainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61011(Continuation<? super C61011> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIExplainViewModel.this.new C61011(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AIExplainViewModel.this._error.setValue(null);
                AIExplainViewModel.this._aiGeneratedText.setValue("");
                AIExplainViewModel.this._isStreamingComplete.setValue(Boxing.boxBoolean(false));
                AIExplainViewModel.this._isLoading.setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void closeExplain() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C61011(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.presentation.AIExplainViewModel$setError$2 */
    /* JADX INFO: compiled from: AIExplainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIExplainViewModel$setError$2", m1609f = "AIExplainViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61032 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AIError $error;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C61032(AIError aIError, Continuation<? super C61032> continuation) {
            super(2, continuation);
            this.$error = aIError;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AIExplainViewModel.this.new C61032(this.$error, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61032) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AIExplainViewModel.this._error.setValue(this.$error);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object setError(AIError aIError, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.uiDispatcher, new C61032(aIError, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final void setTextSelectionProvider(TextSelectionProvider provider) {
        this.textSelectionProvider = provider;
    }

    /* JADX INFO: compiled from: AIExplainViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/AIExplainViewModel$Companion;", "", "<init>", "()V", "TAG", "", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewModelProvider.Factory getFactory() {
            return AIExplainViewModel.Factory;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AIExplainViewModel Factory$lambda$0$0(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        ComponentCallbacks2 componentCallbacks2RequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
        Intrinsics.checkNotNull(componentCallbacks2RequireApplication, "null cannot be cast to non-null type com.myscript.nebo.ai.data.NeboAIClient.Provider");
        return new AIExplainViewModel(((NeboAIClient.Provider) componentCallbacks2RequireApplication).provideNeboAIClient(), ((LibraryRepository.Provider) componentCallbacks2RequireApplication).provideLibraryRepository(), null, null, 12, null);
    }

    static {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(AIExplainViewModel.class), new Function1() { // from class: com.myscript.nebo.ai.presentation.AIExplainViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AIExplainViewModel.Factory$lambda$0$0((CreationExtras) obj);
            }
        });
        Factory = initializerViewModelFactoryBuilder.build();
    }
}
