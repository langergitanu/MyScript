package androidx.media3.p008ui.compose.state;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C2181C;
import androidx.media3.common.Player;
import com.google.common.base.Preconditions;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ProgressStateWithTickCount.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0005J\u000e\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u000bJ\u000e\u0010&\u001a\u00020'2\u0006\u0010%\u001a\u00020\u000bJ\u0010\u0010(\u001a\u0004\u0018\u00010)H\u0086@¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020'2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010,\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J \u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020'2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J \u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020'2\u0006\u00102\u001a\u00020'2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u00103\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00102\u001a\u00020'H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R+\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u00178F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, m1599d2 = {"Landroidx/media3/ui/compose/state/ProgressStateWithTickCount;", "", "player", "Landroidx/media3/common/Player;", "totalTickCount", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroidx/media3/common/Player;ILkotlinx/coroutines/CoroutineScope;)V", "<set-?>", "", "currentPositionProgress", "getCurrentPositionProgress", "()F", "setCurrentPositionProgress", "(F)V", "currentPositionProgress$delegate", "Landroidx/compose/runtime/MutableFloatState;", "bufferedPositionProgress", "getBufferedPositionProgress", "setBufferedPositionProgress", "bufferedPositionProgress$delegate", "", "changingProgressEnabled", "getChangingProgressEnabled", "()Z", "setChangingProgressEnabled", "(Z)V", "changingProgressEnabled$delegate", "Landroidx/compose/runtime/MutableState;", "updateJob", "Landroidx/media3/ui/compose/state/ProgressStateJob;", "updateTotalTickCount", "", "newTotalTickCount", "updateCurrentPositionProgress", "progress", "progressToPosition", "", "observe", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nextMediaWakeUpPositionMs", "updateProgress", "getPositionTick", "position", TypedValues.TransitionType.S_DURATION, "positionToProgress", "positionMs", "durationMs", "canCalculateTicks", "lib-ui-compose_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ProgressStateWithTickCount {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: bufferedPositionProgress$delegate, reason: from kotlin metadata */
    private final MutableFloatState bufferedPositionProgress;

    /* JADX INFO: renamed from: changingProgressEnabled$delegate, reason: from kotlin metadata */
    private final MutableState changingProgressEnabled;

    /* JADX INFO: renamed from: currentPositionProgress$delegate, reason: from kotlin metadata */
    private final MutableFloatState currentPositionProgress;
    private final Player player;
    private int totalTickCount;
    private final ProgressStateJob updateJob;

    /* JADX INFO: renamed from: androidx.media3.ui.compose.state.ProgressStateWithTickCount$observe$1 */
    /* JADX INFO: compiled from: ProgressStateWithTickCount.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.media3.ui.compose.state.ProgressStateWithTickCount", m1609f = "ProgressStateWithTickCount.kt", m1610i = {}, m1611l = {185}, m1612m = "observe", m1613n = {}, m1615s = {})
    static final class C24821 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C24821(Continuation<? super C24821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProgressStateWithTickCount.this.observe(this);
        }
    }

    private final boolean canCalculateTicks(int totalTickCount, long durationMs) {
        return (totalTickCount == 0 || durationMs == C2181C.TIME_UNSET || durationMs <= 0) ? false : true;
    }

    public ProgressStateWithTickCount(final Player player, int i, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.player = player;
        this.totalTickCount = i;
        this.currentPositionProgress = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.bufferedPositionProgress = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.changingProgressEnabled = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.updateJob = player != null ? new ProgressStateJob(player, scope, new Function0() { // from class: androidx.media3.ui.compose.state.ProgressStateWithTickCount$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(this.f$0.nextMediaWakeUpPositionMs(player));
            }
        }, new Function0() { // from class: androidx.media3.ui.compose.state.ProgressStateWithTickCount$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ProgressStateWithTickCount.updateJob$lambda$3$lambda$1(player, this));
            }
        }, new Function0() { // from class: androidx.media3.ui.compose.state.ProgressStateWithTickCount$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProgressStateWithTickCount.updateJob$lambda$3$lambda$2(this.f$0, player);
            }
        }) : null;
        if (this.totalTickCount < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public /* synthetic */ ProgressStateWithTickCount(Player player, int i, CoroutineScope coroutineScope, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(player, (i2 & 2) != 0 ? 0 : i, coroutineScope);
    }

    private final void setCurrentPositionProgress(float f) {
        this.currentPositionProgress.setFloatValue(f);
    }

    public final float getCurrentPositionProgress() {
        return this.currentPositionProgress.getFloatValue();
    }

    private final void setBufferedPositionProgress(float f) {
        this.bufferedPositionProgress.setFloatValue(f);
    }

    public final float getBufferedPositionProgress() {
        return this.bufferedPositionProgress.getFloatValue();
    }

    private final void setChangingProgressEnabled(boolean z) {
        this.changingProgressEnabled.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getChangingProgressEnabled() {
        return ((Boolean) this.changingProgressEnabled.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateJob$lambda$3$lambda$1(Player player, ProgressStateWithTickCount progressStateWithTickCount) {
        return ProgressStateJobKt.isReadyOrBuffering(player) && progressStateWithTickCount.canCalculateTicks(progressStateWithTickCount.totalTickCount, ProgressStateJobKt.getDurationMsOrDefault(player));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateJob$lambda$3$lambda$2(ProgressStateWithTickCount progressStateWithTickCount, Player player) {
        progressStateWithTickCount.updateProgress(player);
        return Unit.INSTANCE;
    }

    public final void updateTotalTickCount(int newTotalTickCount) {
        if (this.totalTickCount != newTotalTickCount) {
            this.totalTickCount = newTotalTickCount;
            ProgressStateJob progressStateJob = this.updateJob;
            if (progressStateJob != null) {
                progressStateJob.cancelPendingUpdatesAndMaybeRelaunch$lib_ui_compose_release();
            }
        }
    }

    public final void updateCurrentPositionProgress(float progress) {
        Player player = this.player;
        if (player == null) {
            return;
        }
        long durationMsOrDefault = ProgressStateJobKt.getDurationMsOrDefault(player);
        if (durationMsOrDefault == C2181C.TIME_UNSET || durationMsOrDefault <= 0 || !player.isCommandAvailable(5)) {
            return;
        }
        player.seekTo((long) (progress * durationMsOrDefault));
    }

    public final long progressToPosition(float progress) {
        Player player = this.player;
        if (player == null) {
            return 0L;
        }
        long durationMsOrDefault = ProgressStateJobKt.getDurationMsOrDefault(player);
        if (durationMsOrDefault == C2181C.TIME_UNSET || durationMsOrDefault <= 0) {
            return 0L;
        }
        return (long) (progress * durationMsOrDefault);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object observe(Continuation continuation) {
        C24821 c24821;
        if (continuation instanceof C24821) {
            c24821 = (C24821) continuation;
            if ((c24821.label & Integer.MIN_VALUE) != 0) {
                c24821.label -= Integer.MIN_VALUE;
            } else {
                c24821 = new C24821(continuation);
            }
        }
        Object obj = c24821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c24821.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProgressStateJob progressStateJob = this.updateJob;
            if (progressStateJob == null) {
                return null;
            }
            c24821.label = 1;
            if (progressStateJob.observeProgress$lib_ui_compose_release(c24821) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final long nextMediaWakeUpPositionMs(Player player) {
        Preconditions.checkState(this.totalTickCount != 0);
        long durationMsOrDefault = ProgressStateJobKt.getDurationMsOrDefault(player);
        Preconditions.checkState(durationMsOrDefault != C2181C.TIME_UNSET);
        int positionTick = getPositionTick(ProgressStateJobKt.getCurrentPositionMsOrDefault(player), durationMsOrDefault, this.totalTickCount) + 1;
        int i = this.totalTickCount;
        return ((((long) positionTick) * durationMsOrDefault) / ((long) i)) - (durationMsOrDefault / ((long) (i * 2)));
    }

    private final void updateProgress(Player player) {
        long durationMsOrDefault = ProgressStateJobKt.getDurationMsOrDefault(player);
        setCurrentPositionProgress(positionToProgress(ProgressStateJobKt.getCurrentPositionMsOrDefault(player), durationMsOrDefault, this.totalTickCount));
        setBufferedPositionProgress(positionToProgress(ProgressStateJobKt.getBufferedPositionMsOrDefault(player), durationMsOrDefault, this.totalTickCount));
        setChangingProgressEnabled(player.isCommandAvailable(5) && ProgressStateJobKt.getDurationMsOrDefault(player) != C2181C.TIME_UNSET);
    }

    private final int getPositionTick(long position, long duration, int totalTickCount) {
        return RangesKt.coerceIn((int) ((((position + ((long) 10)) + (duration / ((long) (totalTickCount * 2)))) * ((long) totalTickCount)) / duration), 0, totalTickCount);
    }

    private final float positionToProgress(long positionMs, long durationMs, int totalTickCount) {
        if (canCalculateTicks(totalTickCount, durationMs)) {
            return getPositionTick(positionMs, durationMs, totalTickCount) / totalTickCount;
        }
        return 0.0f;
    }
}
