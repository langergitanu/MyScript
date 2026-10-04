package androidx.media3.p008ui.compose.state;

import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.media3.common.Player;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ProgressStateWithTickInterval.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0086@¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J$\u0010\"\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050$H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR+\u0010\u0016\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m1599d2 = {"Landroidx/media3/ui/compose/state/ProgressStateWithTickInterval;", "", "player", "Landroidx/media3/common/Player;", "tickIntervalMs", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroidx/media3/common/Player;JLkotlinx/coroutines/CoroutineScope;)V", "<set-?>", "currentPositionMs", "getCurrentPositionMs", "()J", "setCurrentPositionMs", "(J)V", "currentPositionMs$delegate", "Landroidx/compose/runtime/MutableLongState;", "bufferedPositionMs", "getBufferedPositionMs", "setBufferedPositionMs", "bufferedPositionMs$delegate", "durationMs", "getDurationMs", "setDurationMs", "durationMs$delegate", "updateJob", "Landroidx/media3/ui/compose/state/ProgressStateJob;", "observe", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nextMediaWakeUpPositionMs", "updateProgress", "", "snapPositionToNearestTick", "positionSupplier", "Lkotlin/Function1;", "lib-ui-compose_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ProgressStateWithTickInterval {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: bufferedPositionMs$delegate, reason: from kotlin metadata */
    private final MutableLongState bufferedPositionMs;

    /* JADX INFO: renamed from: currentPositionMs$delegate, reason: from kotlin metadata */
    private final MutableLongState currentPositionMs;

    /* JADX INFO: renamed from: durationMs$delegate, reason: from kotlin metadata */
    private final MutableLongState durationMs;
    private final Player player;
    private final long tickIntervalMs;
    private final ProgressStateJob updateJob;

    /* JADX INFO: renamed from: androidx.media3.ui.compose.state.ProgressStateWithTickInterval$observe$1 */
    /* JADX INFO: compiled from: ProgressStateWithTickInterval.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.media3.ui.compose.state.ProgressStateWithTickInterval", m1609f = "ProgressStateWithTickInterval.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_3_1}, m1612m = "observe", m1613n = {}, m1615s = {})
    static final class C24851 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C24851(Continuation<? super C24851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProgressStateWithTickInterval.this.observe(this);
        }
    }

    public ProgressStateWithTickInterval(final Player player, long j, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.player = player;
        this.tickIntervalMs = j;
        this.currentPositionMs = SnapshotLongStateKt.mutableLongStateOf(0L);
        this.bufferedPositionMs = SnapshotLongStateKt.mutableLongStateOf(0L);
        this.durationMs = SnapshotLongStateKt.mutableLongStateOf(0L);
        this.updateJob = player != null ? new ProgressStateJob(player, scope, new Function0() { // from class: androidx.media3.ui.compose.state.ProgressStateWithTickInterval$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(this.f$0.nextMediaWakeUpPositionMs(player));
            }
        }, new Function0() { // from class: androidx.media3.ui.compose.state.ProgressStateWithTickInterval$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ProgressStateJobKt.isReadyOrBuffering(player));
            }
        }, new Function0() { // from class: androidx.media3.ui.compose.state.ProgressStateWithTickInterval$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProgressStateWithTickInterval.updateJob$lambda$3$lambda$2(this.f$0, player);
            }
        }) : null;
        if (j < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public /* synthetic */ ProgressStateWithTickInterval(Player player, long j, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(player, (i & 2) != 0 ? 0L : j, coroutineScope);
    }

    private final void setCurrentPositionMs(long j) {
        this.currentPositionMs.setLongValue(j);
    }

    public final long getCurrentPositionMs() {
        return this.currentPositionMs.getLongValue();
    }

    private final void setBufferedPositionMs(long j) {
        this.bufferedPositionMs.setLongValue(j);
    }

    public final long getBufferedPositionMs() {
        return this.bufferedPositionMs.getLongValue();
    }

    private final void setDurationMs(long j) {
        this.durationMs.setLongValue(j);
    }

    public final long getDurationMs() {
        return this.durationMs.getLongValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateJob$lambda$3$lambda$2(ProgressStateWithTickInterval progressStateWithTickInterval, Player player) {
        progressStateWithTickInterval.updateProgress(player);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object observe(Continuation continuation) {
        C24851 c24851;
        if (continuation instanceof C24851) {
            c24851 = (C24851) continuation;
            if ((c24851.label & Integer.MIN_VALUE) != 0) {
                c24851.label -= Integer.MIN_VALUE;
            } else {
                c24851 = new C24851(continuation);
            }
        }
        Object obj = c24851.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c24851.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProgressStateJob progressStateJob = this.updateJob;
            if (progressStateJob == null) {
                return null;
            }
            c24851.label = 1;
            if (progressStateJob.observeProgress$lib_ui_compose_release(c24851) == coroutine_suspended) {
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
        if (this.tickIntervalMs == 0) {
            return 0L;
        }
        long currentPositionMsOrDefault = ProgressStateJobKt.getCurrentPositionMsOrDefault(player);
        long j = this.tickIntervalMs;
        long j2 = currentPositionMsOrDefault / j;
        long j3 = (1 + j2) * j;
        return j3 - currentPositionMsOrDefault < 8 ? (j2 + 2) * j : j3;
    }

    /* JADX INFO: renamed from: androidx.media3.ui.compose.state.ProgressStateWithTickInterval$updateProgress$1 */
    /* JADX INFO: compiled from: ProgressStateWithTickInterval.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    /* synthetic */ class C24861 extends FunctionReferenceImpl implements Function1<Player, Long> {
        public static final C24861 INSTANCE = new C24861();

        C24861() {
            super(1, ProgressStateJobKt.class, "getCurrentPositionMsOrDefault", "getCurrentPositionMsOrDefault(Landroidx/media3/common/Player;)J", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Long invoke(Player p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return Long.valueOf(ProgressStateJobKt.getCurrentPositionMsOrDefault(p0));
        }
    }

    /* JADX INFO: renamed from: androidx.media3.ui.compose.state.ProgressStateWithTickInterval$updateProgress$2 */
    /* JADX INFO: compiled from: ProgressStateWithTickInterval.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    /* synthetic */ class C24872 extends FunctionReferenceImpl implements Function1<Player, Long> {
        public static final C24872 INSTANCE = new C24872();

        C24872() {
            super(1, ProgressStateJobKt.class, "getBufferedPositionMsOrDefault", "getBufferedPositionMsOrDefault(Landroidx/media3/common/Player;)J", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Long invoke(Player p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return Long.valueOf(ProgressStateJobKt.getBufferedPositionMsOrDefault(p0));
        }
    }

    private final void updateProgress(Player player) {
        setCurrentPositionMs(snapPositionToNearestTick(player, C24861.INSTANCE));
        setBufferedPositionMs(snapPositionToNearestTick(player, C24872.INSTANCE));
        setDurationMs(ProgressStateJobKt.getDurationMsOrDefault(player));
    }

    private final long snapPositionToNearestTick(Player player, Function1<? super Player, Long> positionSupplier) {
        long jLongValue = positionSupplier.invoke(player).longValue();
        long j = this.tickIntervalMs;
        return (j == 0 || jLongValue % j == 0) ? jLongValue : ((jLongValue + ((long) 10)) / j) * j;
    }
}
