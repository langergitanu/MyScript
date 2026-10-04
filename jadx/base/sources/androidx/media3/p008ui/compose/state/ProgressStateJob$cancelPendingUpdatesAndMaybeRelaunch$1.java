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
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: ProgressStateJob.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.media3.ui.compose.state.ProgressStateJob$cancelPendingUpdatesAndMaybeRelaunch$1", m1609f = "ProgressStateJob.kt", m1610i = {0}, m1611l = {79}, m1612m = "invokeSuspend", m1613n = {"$this$launch"}, m1615s = {"L$0"})
final class ProgressStateJob$cancelPendingUpdatesAndMaybeRelaunch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProgressStateJob this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProgressStateJob$cancelPendingUpdatesAndMaybeRelaunch$1(ProgressStateJob progressStateJob, Continuation<? super ProgressStateJob$cancelPendingUpdatesAndMaybeRelaunch$1> continuation) {
        super(2, continuation);
        this.this$0 = progressStateJob;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProgressStateJob$cancelPendingUpdatesAndMaybeRelaunch$1 progressStateJob$cancelPendingUpdatesAndMaybeRelaunch$1 = new ProgressStateJob$cancelPendingUpdatesAndMaybeRelaunch$1(this.this$0, continuation);
        progressStateJob$cancelPendingUpdatesAndMaybeRelaunch$1.L$0 = obj;
        return progressStateJob$cancelPendingUpdatesAndMaybeRelaunch$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProgressStateJob$cancelPendingUpdatesAndMaybeRelaunch$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0036 -> B:14:0x0039). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            if (CoroutineScopeKt.isActive(coroutineScope)) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.this$0.scheduledTask.invoke();
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                this.L$0 = coroutineScope;
                this.label = 1;
                if (this.this$0.smartDelay(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.this$0.scheduledTask.invoke();
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
