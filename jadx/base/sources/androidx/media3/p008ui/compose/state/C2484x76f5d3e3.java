package androidx.media3.p008ui.compose.state;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: androidx.media3.ui.compose.state.ProgressStateWithTickCountKt$rememberProgressStateWithTickCount$2$1 */
/* JADX INFO: compiled from: ProgressStateWithTickCount.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.media3.ui.compose.state.ProgressStateWithTickCountKt$rememberProgressStateWithTickCount$2$1", m1609f = "ProgressStateWithTickCount.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class C2484x76f5d3e3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProgressStateWithTickCount $progressState;
    final /* synthetic */ int $totalTickCount;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2484x76f5d3e3(ProgressStateWithTickCount progressStateWithTickCount, int i, Continuation<? super C2484x76f5d3e3> continuation) {
        super(2, continuation);
        this.$progressState = progressStateWithTickCount;
        this.$totalTickCount = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C2484x76f5d3e3(this.$progressState, this.$totalTickCount, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C2484x76f5d3e3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$progressState.updateTotalTickCount(this.$totalTickCount);
        return Unit.INSTANCE;
    }
}
