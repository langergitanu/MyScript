package androidx.media3.p008ui.compose.state;

import androidx.compose.p004ui.spatial.RectListKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: androidx.media3.ui.compose.state.ProgressStateWithTickIntervalKt$rememberProgressStateWithTickInterval$1$1 */
/* JADX INFO: compiled from: ProgressStateWithTickInterval.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.media3.ui.compose.state.ProgressStateWithTickIntervalKt$rememberProgressStateWithTickInterval$1$1", m1609f = "ProgressStateWithTickInterval.kt", m1610i = {}, m1611l = {RectListKt.BitOffsetForGesturable}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class C2488x8c4c4f2a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProgressStateWithTickInterval $progressStateWithTickInterval;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2488x8c4c4f2a(ProgressStateWithTickInterval progressStateWithTickInterval, Continuation<? super C2488x8c4c4f2a> continuation) {
        super(2, continuation);
        this.$progressStateWithTickInterval = progressStateWithTickInterval;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C2488x8c4c4f2a(this.$progressStateWithTickInterval, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C2488x8c4c4f2a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$progressStateWithTickInterval.observe(this) == coroutine_suspended) {
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
