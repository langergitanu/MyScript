package com.myscript.nebo.rating.feedback;

import android.content.ComponentCallbacks2;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider;
import com.myscript.nebo.rating.feedback.FeedbackResult;
import com.myscript.nebo.rating.feedback.FeedbackState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FeedbackViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0018J\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0018J\b\u0010\"\u001a\u00020\u001fH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000eR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, m1599d2 = {"Lcom/myscript/nebo/rating/feedback/FeedbackViewModel;", "Landroidx/lifecycle/ViewModel;", "feedbackRepository", "Lcom/myscript/nebo/rating/feedback/FeedbackRepository;", "neboNetworkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "<init>", "(Lcom/myscript/nebo/rating/feedback/FeedbackRepository;Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;)V", "_feedbackState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/rating/feedback/FeedbackState;", "feedbackState", "Landroidx/lifecycle/LiveData;", "getFeedbackState", "()Landroidx/lifecycle/LiveData;", "_connected", "", "kotlin.jvm.PlatformType", "connected", "getConnected", "_progressBarVisible", "progressBarVisible", "getProgressBarVisible", "_feedbackText", "", "feedbackText", "getFeedbackText", "networkObserver", "Landroidx/lifecycle/Observer;", "Lcom/myscript/nebo/common/network/NeboNetworkState;", "sendFeedback", "", "text", "onFeedbackTextChanged", "onCleared", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FeedbackViewModel extends ViewModel {
    private static final ViewModelProvider.Factory Factory;
    private final MutableLiveData<Boolean> _connected;
    private final MutableLiveData<FeedbackState> _feedbackState;
    private final MutableLiveData<String> _feedbackText;
    private final MutableLiveData<Boolean> _progressBarVisible;
    private final LiveData<Boolean> connected;
    private final FeedbackRepository feedbackRepository;
    private final LiveData<FeedbackState> feedbackState;
    private final LiveData<String> feedbackText;
    private final NeboNetworkStateRepository neboNetworkStateRepository;
    private final Observer<NeboNetworkState> networkObserver;
    private final LiveData<Boolean> progressBarVisible;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public FeedbackViewModel(FeedbackRepository feedbackRepository, NeboNetworkStateRepository neboNetworkStateRepository) {
        Intrinsics.checkNotNullParameter(feedbackRepository, "feedbackRepository");
        Intrinsics.checkNotNullParameter(neboNetworkStateRepository, "neboNetworkStateRepository");
        this.feedbackRepository = feedbackRepository;
        this.neboNetworkStateRepository = neboNetworkStateRepository;
        MutableLiveData<FeedbackState> mutableLiveData = new MutableLiveData<>();
        this._feedbackState = mutableLiveData;
        this.feedbackState = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(true);
        this._connected = mutableLiveData2;
        this.connected = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(false);
        this._progressBarVisible = mutableLiveData3;
        this.progressBarVisible = mutableLiveData3;
        MutableLiveData<String> mutableLiveData4 = new MutableLiveData<>();
        this._feedbackText = mutableLiveData4;
        this.feedbackText = mutableLiveData4;
        Observer<NeboNetworkState> observer = new Observer() { // from class: com.myscript.nebo.rating.feedback.FeedbackViewModel$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedbackViewModel.networkObserver$lambda$0(this.f$0, (NeboNetworkState) obj);
            }
        };
        this.networkObserver = observer;
        neboNetworkStateRepository.getNeboNetworkState().observeForever(observer);
    }

    public final LiveData<FeedbackState> getFeedbackState() {
        return this.feedbackState;
    }

    public final LiveData<Boolean> getConnected() {
        return this.connected;
    }

    public final LiveData<Boolean> getProgressBarVisible() {
        return this.progressBarVisible;
    }

    public final LiveData<String> getFeedbackText() {
        return this.feedbackText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void networkObserver$lambda$0(FeedbackViewModel feedbackViewModel, NeboNetworkState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        feedbackViewModel._connected.setValue(it instanceof NeboNetworkState.Connected ? Boolean.valueOf(((NeboNetworkState.Connected) it).isEnabled()) : false);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.rating.feedback.FeedbackViewModel$sendFeedback$1 */
    /* JADX INFO: compiled from: FeedbackViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.rating.feedback.FeedbackViewModel$sendFeedback$1", m1609f = "FeedbackViewModel.kt", m1610i = {}, m1611l = {ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m1615s = {}, m1616v = 2)
    static final class C67511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $text;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67511(String str, Continuation<? super C67511> continuation) {
            super(2, continuation);
            this.$text = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedbackViewModel.this.new C67511(this.$text, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FeedbackViewModel.this._progressBarVisible.setValue(Boxing.boxBoolean(true));
                this.label = 1;
                obj = FeedbackViewModel.this.feedbackRepository.sendFeedback(this.$text, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            FeedbackResult feedbackResult = (FeedbackResult) obj;
            if (feedbackResult instanceof FeedbackResult.Error) {
                FeedbackViewModel.this._feedbackState.setValue(new FeedbackState.Error(((FeedbackResult.Error) feedbackResult).getMessage()));
                FeedbackViewModel.this._progressBarVisible.setValue(Boxing.boxBoolean(false));
            } else if (Intrinsics.areEqual(feedbackResult, FeedbackResult.Success.INSTANCE)) {
                FeedbackViewModel.this._feedbackState.setValue(FeedbackState.Success.INSTANCE);
                FeedbackViewModel.this._progressBarVisible.setValue(Boxing.boxBoolean(false));
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return Unit.INSTANCE;
        }
    }

    public final void sendFeedback(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C67511(text, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.rating.feedback.FeedbackViewModel$onFeedbackTextChanged$1 */
    /* JADX INFO: compiled from: FeedbackViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.rating.feedback.FeedbackViewModel$onFeedbackTextChanged$1", m1609f = "FeedbackViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $text;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67501(String str, Continuation<? super C67501> continuation) {
            super(2, continuation);
            this.$text = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedbackViewModel.this.new C67501(this.$text, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FeedbackViewModel.this._feedbackText.setValue(this.$text);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void onFeedbackTextChanged(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C67501(text, null), 3, null);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.neboNetworkStateRepository.getNeboNetworkState().removeObserver(this.networkObserver);
    }

    /* JADX INFO: compiled from: FeedbackViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/rating/feedback/FeedbackViewModel$Companion;", "", "<init>", "()V", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewModelProvider.Factory getFactory() {
            return FeedbackViewModel.Factory;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewModel Factory$lambda$0$0(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        ComponentCallbacks2 componentCallbacks2RequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
        FeedbackRepositoryImpl feedbackRepositoryImpl = new FeedbackRepositoryImpl(FreshDeskApiKt.buildFreshDeskApi());
        Intrinsics.checkNotNull(componentCallbacks2RequireApplication, "null cannot be cast to non-null type com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider");
        return new FeedbackViewModel(feedbackRepositoryImpl, ((NeboNetworkStateRepositoryProvider) componentCallbacks2RequireApplication).provideNeboNetworkStateRepository());
    }

    static {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(FeedbackViewModel.class), new Function1() { // from class: com.myscript.nebo.rating.feedback.FeedbackViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedbackViewModel.Factory$lambda$0$0((CreationExtras) obj);
            }
        });
        Factory = initializerViewModelFactoryBuilder.build();
    }
}
