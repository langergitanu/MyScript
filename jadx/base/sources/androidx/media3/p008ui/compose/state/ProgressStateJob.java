package androidx.media3.p008ui.compose.state;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.media3.common.Player;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: ProgressStateJob.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0014\u001a\u00020\u0015H\u0080@¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m1599d2 = {"Landroidx/media3/ui/compose/state/ProgressStateJob;", "", "player", "Landroidx/media3/common/Player;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "nextMediaTickMsSupplier", "Lkotlin/Function0;", "", "shouldScheduleTask", "", "scheduledTask", "", "<init>", "(Landroidx/media3/common/Player;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "updateJob", "Lkotlinx/coroutines/Job;", "isObserving", "playerStateObserver", "Landroidx/media3/ui/compose/state/PlayerStateObserver;", "observeProgress", "", "observeProgress$lib_ui_compose_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelPendingUpdatesAndMaybeRelaunch", "cancelPendingUpdatesAndMaybeRelaunch$lib_ui_compose_release", "smartDelay", "lib-ui-compose_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ProgressStateJob {
    public static final int $stable = 8;
    private boolean isObserving;
    private final Function0<Long> nextMediaTickMsSupplier;
    private final Player player;
    private final PlayerStateObserver playerStateObserver;
    private final Function0<Unit> scheduledTask;
    private final CoroutineScope scope;
    private final Function0<Boolean> shouldScheduleTask;
    private Job updateJob;

    public ProgressStateJob(Player player, CoroutineScope scope, Function0<Long> nextMediaTickMsSupplier, Function0<Boolean> shouldScheduleTask, Function0<Unit> scheduledTask) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(nextMediaTickMsSupplier, "nextMediaTickMsSupplier");
        Intrinsics.checkNotNullParameter(shouldScheduleTask, "shouldScheduleTask");
        Intrinsics.checkNotNullParameter(scheduledTask, "scheduledTask");
        this.player = player;
        this.scope = scope;
        this.nextMediaTickMsSupplier = nextMediaTickMsSupplier;
        this.shouldScheduleTask = shouldScheduleTask;
        this.scheduledTask = scheduledTask;
        this.playerStateObserver = PlayerStateObserverKt.observeState(player, 7, new int[]{11, 0, 12, 13}, new Function1() { // from class: androidx.media3.ui.compose.state.ProgressStateJob$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProgressStateJob.playerStateObserver$lambda$0(this.f$0, (Player) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playerStateObserver$lambda$0(ProgressStateJob progressStateJob, Player it) {
        Intrinsics.checkNotNullParameter(it, "it");
        progressStateJob.cancelPendingUpdatesAndMaybeRelaunch$lib_ui_compose_release();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object observeProgress$lib_ui_compose_release(Continuation<?> continuation) {
        ProgressStateJob$observeProgress$1 progressStateJob$observeProgress$1;
        if (continuation instanceof ProgressStateJob$observeProgress$1) {
            progressStateJob$observeProgress$1 = (ProgressStateJob$observeProgress$1) continuation;
            if ((progressStateJob$observeProgress$1.label & Integer.MIN_VALUE) != 0) {
                progressStateJob$observeProgress$1.label -= Integer.MIN_VALUE;
            } else {
                progressStateJob$observeProgress$1 = new ProgressStateJob$observeProgress$1(this, continuation);
            }
        }
        Object obj = progressStateJob$observeProgress$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = progressStateJob$observeProgress$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProgressStateJob$observeProgress$2 progressStateJob$observeProgress$2 = new ProgressStateJob$observeProgress$2(this, null);
            progressStateJob$observeProgress$1.label = 1;
            if (CoroutineScopeKt.coroutineScope(progressStateJob$observeProgress$2, progressStateJob$observeProgress$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    public final void cancelPendingUpdatesAndMaybeRelaunch$lib_ui_compose_release() {
        this.scheduledTask.invoke();
        if (this.isObserving) {
            Job job = this.updateJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            if (this.player.isCommandAvailable(16) && this.shouldScheduleTask.invoke().booleanValue()) {
                this.updateJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new ProgressStateJob$cancelPendingUpdatesAndMaybeRelaunch$1(this, null), 3, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object smartDelay(Continuation<? super Unit> continuation) {
        if (this.player.isPlaying()) {
            float fLongValue = (this.nextMediaTickMsSupplier.invoke().longValue() - ProgressStateJobKt.getCurrentPositionMsOrDefault(this.player)) / this.player.getPlaybackParameters().speed;
            if (fLongValue < 8.0f) {
                Object objWithFrameMillis = MonotonicFrameClockKt.withFrameMillis(new Function1() { // from class: androidx.media3.ui.compose.state.ProgressStateJob$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProgressStateJob.smartDelay$lambda$1(((Long) obj).longValue());
                    }
                }, continuation);
                return objWithFrameMillis == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithFrameMillis : Unit.INSTANCE;
            }
            Object objDelay = DelayKt.delay(RangesKt.coerceAtLeast((long) fLongValue, 1L), continuation);
            return objDelay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDelay : Unit.INSTANCE;
        }
        Object objDelay2 = DelayKt.delay(1000L, continuation);
        return objDelay2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDelay2 : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smartDelay$lambda$1(long j) {
        return Unit.INSTANCE;
    }
}
