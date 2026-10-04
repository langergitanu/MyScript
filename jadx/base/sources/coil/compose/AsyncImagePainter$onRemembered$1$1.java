package coil.compose;

import androidx.compose.runtime.SnapshotStateKt;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: AsyncImagePainter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "coil.compose.AsyncImagePainter$onRemembered$1$1", m1609f = "AsyncImagePainter.kt", m1610i = {}, m1611l = {308}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class AsyncImagePainter$onRemembered$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AsyncImagePainter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncImagePainter$onRemembered$1$1(AsyncImagePainter asyncImagePainter, Continuation<? super AsyncImagePainter$onRemembered$1$1> continuation) {
        super(2, continuation);
        this.this$0 = asyncImagePainter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AsyncImagePainter$onRemembered$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AsyncImagePainter$onRemembered$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final AsyncImagePainter asyncImagePainter = this.this$0;
            this.label = 1;
            if (FlowKt.mapLatest(SnapshotStateKt.snapshotFlow(new Function0() { // from class: coil.compose.AsyncImagePainter$onRemembered$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return asyncImagePainter.getRequest();
                }
            }), new C38122(this.this$0, null)).collect(new C38133(this.this$0), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: coil.compose.AsyncImagePainter$onRemembered$1$1$2 */
    /* JADX INFO: compiled from: AsyncImagePainter.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006H\n"}, m1599d2 = {"<anonymous>", "Lcoil/compose/AsyncImagePainter$State;", "it", "Lcoil/request/ImageRequest;", "Lkotlin/ParameterName;", "name", "value"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "coil.compose.AsyncImagePainter$onRemembered$1$1$2", m1609f = "AsyncImagePainter.kt", m1610i = {}, m1611l = {307}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C38122 extends SuspendLambda implements Function2<ImageRequest, Continuation<? super AsyncImagePainter.State>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AsyncImagePainter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C38122(AsyncImagePainter asyncImagePainter, Continuation<? super C38122> continuation) {
            super(2, continuation);
            this.this$0 = asyncImagePainter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C38122 c38122 = new C38122(this.this$0, continuation);
            c38122.L$0 = obj;
            return c38122;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ImageRequest imageRequest, Continuation<? super AsyncImagePainter.State> continuation) {
            return ((C38122) create(imageRequest, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AsyncImagePainter asyncImagePainter;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ImageRequest imageRequest = (ImageRequest) this.L$0;
                AsyncImagePainter asyncImagePainter2 = this.this$0;
                this.L$0 = asyncImagePainter2;
                this.label = 1;
                obj = asyncImagePainter2.getImageLoader().execute(this.this$0.updateRequest(imageRequest), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                asyncImagePainter = asyncImagePainter2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                asyncImagePainter = (AsyncImagePainter) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            return asyncImagePainter.toState((ImageResult) obj);
        }
    }

    /* JADX INFO: renamed from: coil.compose.AsyncImagePainter$onRemembered$1$1$3 */
    /* JADX INFO: compiled from: AsyncImagePainter.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    /* synthetic */ class C38133 implements FlowCollector, FunctionAdapter {
        final /* synthetic */ AsyncImagePainter $tmp0;

        C38133(AsyncImagePainter asyncImagePainter) {
            this.$tmp0 = asyncImagePainter;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return new AdaptedFunctionReference(2, this.$tmp0, AsyncImagePainter.class, "updateState", "updateState(Lcoil/compose/AsyncImagePainter$State;)V", 4);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final Object emit(AsyncImagePainter.State state, Continuation<? super Unit> continuation) {
            Object objInvokeSuspend$updateState = AsyncImagePainter$onRemembered$1$1.invokeSuspend$updateState(this.$tmp0, state, continuation);
            return objInvokeSuspend$updateState == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvokeSuspend$updateState : Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((AsyncImagePainter.State) obj, (Continuation<? super Unit>) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object invokeSuspend$updateState(AsyncImagePainter asyncImagePainter, AsyncImagePainter.State state, Continuation continuation) {
        asyncImagePainter.updateState(state);
        return Unit.INSTANCE;
    }
}
