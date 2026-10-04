package androidx.compose.animation.core;

import androidx.collection.MutableObjectList;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 a*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002`aB\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010D\u001a\u00020\u001fH\u0002J\u000e\u0010E\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010FJ\u000e\u0010G\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010FJ\u000e\u0010H\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010FJ\u0018\u0010I\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020\u0018H\u0002J\u0016\u0010L\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010MJ\"\u0010N\u001a\u00020\u001f2\b\b\u0001\u0010(\u001a\u00020'2\b\b\u0002\u0010\u0007\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010OJ\u000e\u0010P\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010FJ\u000e\u0010Q\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010FJ\b\u0010R\u001a\u00020\u001fH\u0002J*\u0010S\u001a\u00020\u001f2\b\b\u0002\u0010\u0007\u001a\u00028\u00002\u0010\b\u0002\u0010T\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010UH\u0086@¢\u0006\u0002\u0010VJ\u001b\u0010W\u001a\u00020\u001f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0010¢\u0006\u0002\bXJ\r\u0010Y\u001a\u00020\u001fH\u0010¢\u0006\u0002\bZJ\r\u0010[\u001a\u00020\u001fH\u0000¢\u0006\u0002\b\\J\r\u0010]\u001a\u00020\u001fH\u0000¢\u0006\u0002\b^J\b\u0010_\u001a\u00020\u001fH\u0002R+\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005R+\u0010\r\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u0005R\u001c\u0010\u0011\u001a\u00028\u0000X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u0005R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R+\u0010(\u001a\u00020'2\u0006\u0010\u0006\u001a\u00020'8G@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010/\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u000100X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u00105\u001a\u000206X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001f0AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001f0AX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006b"}, m1599d2 = {"Landroidx/compose/animation/core/SeekableTransitionState;", ExifInterface.LATITUDE_SOUTH, "Landroidx/compose/animation/core/TransitionState;", "initialState", "<init>", "(Ljava/lang/Object;)V", "<set-?>", "targetState", "getTargetState", "()Ljava/lang/Object;", "setTargetState$animation_core", "targetState$delegate", "Landroidx/compose/runtime/MutableState;", "currentState", "getCurrentState", "setCurrentState$animation_core", "currentState$delegate", "composedTargetState", "getComposedTargetState$animation_core", "setComposedTargetState$animation_core", "Ljava/lang/Object;", "transition", "Landroidx/compose/animation/core/Transition;", "totalDurationNanos", "", "getTotalDurationNanos$animation_core", "()J", "setTotalDurationNanos$animation_core", "(J)V", "recalculateTotalDurationNanos", "Lkotlin/Function0;", "", "value", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "snapshotStateObserver", "getSnapshotStateObserver$animation_core", "()Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "setSnapshotStateObserver$animation_core", "(Landroidx/compose/runtime/snapshots/SnapshotStateObserver;)V", "", "fraction", "getFraction", "()F", "setFraction", "(F)V", "fraction$delegate", "Landroidx/compose/runtime/MutableFloatState;", "compositionContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "getCompositionContinuation$animation_core", "()Lkotlinx/coroutines/CancellableContinuation;", "setCompositionContinuation$animation_core", "(Lkotlinx/coroutines/CancellableContinuation;)V", "compositionContinuationMutex", "Lkotlinx/coroutines/sync/Mutex;", "getCompositionContinuationMutex$animation_core", "()Lkotlinx/coroutines/sync/Mutex;", "mutatorMutex", "Landroidx/compose/animation/core/MutatorMutex;", "lastFrameTimeNanos", "initialValueAnimations", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "currentAnimation", "firstFrameLambda", "Lkotlin/Function1;", "durationScale", "animateOneFrameLambda", "endAllAnimations", "runAnimations", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doOneFrame", "animateOneFrame", "recalculateAnimationValue", "animation", "deltaPlayTimeNanos", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "seekTo", "(FLjava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForCompositionAfterTargetStateChange", "waitForComposition", "moveAnimationToInitialState", "animateTo", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "(Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transitionConfigured", "transitionConfigured$animation_core", "transitionRemoved", "transitionRemoved$animation_core", "observeTotalDuration", "observeTotalDuration$animation_core", "onTotalDurationChanged", "onTotalDurationChanged$animation_core", "seekToFraction", "SeekingAnimationState", "Companion", "animation-core"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SeekableTransitionState<S> extends TransitionState<S> {
    private final Function1<Long, Unit> animateOneFrameLambda;
    private S composedTargetState;
    private CancellableContinuation<? super S> compositionContinuation;
    private final Mutex compositionContinuationMutex;
    private SeekingAnimationState currentAnimation;

    /* JADX INFO: renamed from: currentState$delegate, reason: from kotlin metadata */
    private final MutableState currentState;
    private float durationScale;
    private final Function1<Long, Unit> firstFrameLambda;

    /* JADX INFO: renamed from: fraction$delegate, reason: from kotlin metadata */
    private final MutableFloatState fraction;
    private final MutableObjectList<SeekingAnimationState> initialValueAnimations;
    private long lastFrameTimeNanos;
    private final MutatorMutex mutatorMutex;
    private final Function0<Unit> recalculateTotalDurationNanos;
    private SnapshotStateObserver snapshotStateObserver;

    /* JADX INFO: renamed from: targetState$delegate, reason: from kotlin metadata */
    private final MutableState targetState;
    private long totalDurationNanos;
    private Transition<S> transition;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final AnimationVector1D ZeroVelocity = new AnimationVector1D(0.0f);
    private static final AnimationVector1D Target1 = new AnimationVector1D(1.0f);

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$runAnimations$1 */
    /* JADX INFO: compiled from: Transition.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.animation.core.SeekableTransitionState", m1609f = "Transition.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA3_6_1, 364}, m1612m = "runAnimations", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C02881 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02881(SeekableTransitionState<S> seekableTransitionState, Continuation<? super C02881> continuation) {
            super(continuation);
            this.this$0 = seekableTransitionState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.runAnimations(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1 */
    /* JADX INFO: compiled from: Transition.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.animation.core.SeekableTransitionState", m1609f = "Transition.kt", m1610i = {0, 1}, m1611l = {551, 2189}, m1612m = "waitForComposition", m1613n = {"expectedState", "expectedState"}, m1615s = {"L$0", "L$0"}, m1616v = 1)
    static final class C02911 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02911(SeekableTransitionState<S> seekableTransitionState, Continuation<? super C02911> continuation) {
            super(continuation);
            this.this$0 = seekableTransitionState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.waitForComposition(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$waitForCompositionAfterTargetStateChange$1 */
    /* JADX INFO: compiled from: Transition.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.animation.core.SeekableTransitionState", m1609f = "Transition.kt", m1610i = {0, 1}, m1611l = {PDFACompliance.e_PDFA5_2_7, 2189}, m1612m = "waitForCompositionAfterTargetStateChange", m1613n = {"expectedState", "expectedState"}, m1615s = {"L$0", "L$0"}, m1616v = 1)
    static final class C02921 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02921(SeekableTransitionState<S> seekableTransitionState, Continuation<? super C02921> continuation) {
            super(continuation);
            this.this$0 = seekableTransitionState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.waitForCompositionAfterTargetStateChange(this);
        }
    }

    public SeekableTransitionState(S s) {
        super(null);
        this.targetState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(s, null, 2, null);
        this.currentState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(s, null, 2, null);
        this.composedTargetState = s;
        this.recalculateTotalDurationNanos = new Function0() { // from class: androidx.compose.animation.core.SeekableTransitionState$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SeekableTransitionState.recalculateTotalDurationNanos$lambda$0(this.f$0);
            }
        };
        this.fraction = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.compositionContinuationMutex = MutexKt.Mutex$default(false, 1, null);
        this.mutatorMutex = new MutatorMutex();
        this.lastFrameTimeNanos = Long.MIN_VALUE;
        this.initialValueAnimations = new MutableObjectList<>(0, 1, null);
        this.firstFrameLambda = new Function1() { // from class: androidx.compose.animation.core.SeekableTransitionState$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SeekableTransitionState.firstFrameLambda$lambda$0(this.f$0, ((Long) obj).longValue());
            }
        };
        this.animateOneFrameLambda = new Function1() { // from class: androidx.compose.animation.core.SeekableTransitionState$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SeekableTransitionState.animateOneFrameLambda$lambda$0(this.f$0, ((Long) obj).longValue());
            }
        };
    }

    @Override // androidx.compose.animation.core.TransitionState
    public S getTargetState() {
        return (S) this.targetState.getValue();
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void setTargetState$animation_core(S s) {
        this.targetState.setValue(s);
    }

    @Override // androidx.compose.animation.core.TransitionState
    public S getCurrentState() {
        return (S) this.currentState.getValue();
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void setCurrentState$animation_core(S s) {
        this.currentState.setValue(s);
    }

    public final S getComposedTargetState$animation_core() {
        return this.composedTargetState;
    }

    public final void setComposedTargetState$animation_core(S s) {
        this.composedTargetState = s;
    }

    /* JADX INFO: renamed from: getTotalDurationNanos$animation_core, reason: from getter */
    public final long getTotalDurationNanos() {
        return this.totalDurationNanos;
    }

    public final void setTotalDurationNanos$animation_core(long j) {
        this.totalDurationNanos = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit recalculateTotalDurationNanos$lambda$0(SeekableTransitionState seekableTransitionState) {
        Transition<S> transition = seekableTransitionState.transition;
        seekableTransitionState.totalDurationNanos = transition != null ? transition.getTotalDurationNanos() : 0L;
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: getSnapshotStateObserver$animation_core, reason: from getter */
    public final SnapshotStateObserver getSnapshotStateObserver() {
        return this.snapshotStateObserver;
    }

    public final void setSnapshotStateObserver$animation_core(SnapshotStateObserver snapshotStateObserver) {
        if (Intrinsics.areEqual(this.snapshotStateObserver, snapshotStateObserver)) {
            return;
        }
        SnapshotStateObserver snapshotStateObserver2 = this.snapshotStateObserver;
        if (snapshotStateObserver2 != null) {
            snapshotStateObserver2.clear(this);
        }
        SnapshotStateObserver snapshotStateObserver3 = this.snapshotStateObserver;
        if (snapshotStateObserver3 != null) {
            snapshotStateObserver3.stop();
        }
        this.snapshotStateObserver = snapshotStateObserver;
        if (snapshotStateObserver != null) {
            snapshotStateObserver.start();
        }
        observeTotalDuration$animation_core();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFraction(float f) {
        this.fraction.setFloatValue(f);
    }

    public final float getFraction() {
        return this.fraction.getFloatValue();
    }

    public final CancellableContinuation<S> getCompositionContinuation$animation_core() {
        return this.compositionContinuation;
    }

    public final void setCompositionContinuation$animation_core(CancellableContinuation<? super S> cancellableContinuation) {
        this.compositionContinuation = cancellableContinuation;
    }

    /* JADX INFO: renamed from: getCompositionContinuationMutex$animation_core, reason: from getter */
    public final Mutex getCompositionContinuationMutex() {
        return this.compositionContinuationMutex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit firstFrameLambda$lambda$0(SeekableTransitionState seekableTransitionState, long j) {
        seekableTransitionState.lastFrameTimeNanos = j;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit animateOneFrameLambda$lambda$0(SeekableTransitionState seekableTransitionState, long j) {
        long j2 = j - seekableTransitionState.lastFrameTimeNanos;
        seekableTransitionState.lastFrameTimeNanos = j;
        long jRoundToLong = MathKt.roundToLong(j2 / ((double) seekableTransitionState.durationScale));
        if (seekableTransitionState.initialValueAnimations.isNotEmpty()) {
            MutableObjectList<SeekingAnimationState> mutableObjectList = seekableTransitionState.initialValueAnimations;
            Object[] objArr = mutableObjectList.content;
            int i = mutableObjectList._size;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                SeekingAnimationState seekingAnimationState = (SeekingAnimationState) objArr[i3];
                seekableTransitionState.recalculateAnimationValue(seekingAnimationState, jRoundToLong);
                seekingAnimationState.setComplete(true);
            }
            Transition<S> transition = seekableTransitionState.transition;
            if (transition != null) {
                transition.updateInitialValues$animation_core();
            }
            MutableObjectList<SeekingAnimationState> mutableObjectList2 = seekableTransitionState.initialValueAnimations;
            int i4 = mutableObjectList2._size;
            Object[] objArr2 = mutableObjectList2.content;
            IntRange intRangeUntil = RangesKt.until(0, mutableObjectList2._size);
            int first = intRangeUntil.getFirst();
            int last = intRangeUntil.getLast();
            if (first <= last) {
                while (true) {
                    objArr2[first - i2] = objArr2[first];
                    if (((SeekingAnimationState) objArr2[first]).getIsComplete()) {
                        i2++;
                    }
                    if (first == last) {
                        break;
                    }
                    first++;
                }
            }
            ArraysKt.fill(objArr2, (Object) null, i4 - i2, i4);
            mutableObjectList2._size -= i2;
        }
        SeekingAnimationState seekingAnimationState2 = seekableTransitionState.currentAnimation;
        if (seekingAnimationState2 != null) {
            seekingAnimationState2.setDurationNanos(seekableTransitionState.totalDurationNanos);
            seekableTransitionState.recalculateAnimationValue(seekingAnimationState2, jRoundToLong);
            seekableTransitionState.setFraction(seekingAnimationState2.getValue());
            if (seekingAnimationState2.getValue() == 1.0f) {
                seekableTransitionState.currentAnimation = null;
            }
            seekableTransitionState.seekToFraction();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endAllAnimations() {
        Transition<S> transition = this.transition;
        if (transition != null) {
            transition.clearInitialAnimations$animation_core();
        }
        this.initialValueAnimations.clear();
        if (this.currentAnimation != null) {
            this.currentAnimation = null;
            setFraction(1.0f);
            seekToFraction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runAnimations(Continuation<? super Unit> continuation) {
        C02881 c02881;
        if (continuation instanceof C02881) {
            c02881 = (C02881) continuation;
            if ((c02881.label & Integer.MIN_VALUE) != 0) {
                c02881.label -= Integer.MIN_VALUE;
            } else {
                c02881 = new C02881(this, continuation);
            }
        }
        Object obj = c02881.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02881.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.initialValueAnimations.isEmpty() && this.currentAnimation == null) {
                return Unit.INSTANCE;
            }
            if (SuspendAnimationKt.getDurationScale(c02881.getContext()) == 0.0f) {
                endAllAnimations();
                this.lastFrameTimeNanos = Long.MIN_VALUE;
                return Unit.INSTANCE;
            }
            if (this.lastFrameTimeNanos == Long.MIN_VALUE) {
                Function1<Long, Unit> function1 = this.firstFrameLambda;
                c02881.label = 1;
                if (MonotonicFrameClockKt.withFrameNanos(function1, c02881) != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }
        if (i != 1 && i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        do {
            if (this.initialValueAnimations.isNotEmpty() || this.currentAnimation != null) {
                c02881.label = 2;
            } else {
                this.lastFrameTimeNanos = Long.MIN_VALUE;
                return Unit.INSTANCE;
            }
        } while (animateOneFrame(c02881) != coroutine_suspended);
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doOneFrame(Continuation<? super Unit> continuation) {
        if (this.lastFrameTimeNanos == Long.MIN_VALUE) {
            Object objWithFrameNanos = MonotonicFrameClockKt.withFrameNanos(this.firstFrameLambda, continuation);
            return objWithFrameNanos == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithFrameNanos : Unit.INSTANCE;
        }
        Object objAnimateOneFrame = animateOneFrame(continuation);
        return objAnimateOneFrame == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateOneFrame : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateOneFrame(Continuation<? super Unit> continuation) {
        float durationScale = SuspendAnimationKt.getDurationScale(continuation.getContext());
        if (durationScale <= 0.0f) {
            endAllAnimations();
            return Unit.INSTANCE;
        }
        this.durationScale = durationScale;
        Object objWithFrameNanos = MonotonicFrameClockKt.withFrameNanos(this.animateOneFrameLambda, continuation);
        return objWithFrameNanos == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithFrameNanos : Unit.INSTANCE;
    }

    private final void recalculateAnimationValue(SeekingAnimationState animation, long deltaPlayTimeNanos) {
        long progressNanos = animation.getProgressNanos() + deltaPlayTimeNanos;
        animation.setProgressNanos(progressNanos);
        long animationSpecDuration = animation.getAnimationSpecDuration();
        if (progressNanos >= animationSpecDuration) {
            animation.setValue(1.0f);
            return;
        }
        VectorizedAnimationSpec<AnimationVector1D> animationSpec = animation.getAnimationSpec();
        if (animationSpec != null) {
            AnimationVector1D start = animation.getStart();
            AnimationVector1D animationVector1D = Target1;
            AnimationVector1D initialVelocity = animation.getInitialVelocity();
            if (initialVelocity == null) {
                initialVelocity = ZeroVelocity;
            }
            animation.setValue(RangesKt.coerceIn(((AnimationVector1D) animationSpec.getValueFromNanos(progressNanos, start, animationVector1D, initialVelocity)).get$animation_core(0), 0.0f, 1.0f));
            return;
        }
        float f = progressNanos / animationSpecDuration;
        animation.setValue((animation.getStart().get$animation_core(0) * (1 - f)) + (f * 1.0f));
    }

    public final Object snapTo(S s, Continuation<? super Unit> continuation) {
        Transition<S> transition = this.transition;
        if (transition == null) {
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(getCurrentState(), s) && Intrinsics.areEqual(getTargetState(), s)) {
            return Unit.INSTANCE;
        }
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new C02902(this, s, transition, null), continuation, 1, null);
        return objMutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$snapTo$2 */
    /* JADX INFO: compiled from: Transition.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", ""}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.animation.core.SeekableTransitionState$snapTo$2", m1609f = "Transition.kt", m1610i = {}, m1611l = {465}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C02902 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ S $targetState;
        final /* synthetic */ Transition<S> $transition;
        int label;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02902(SeekableTransitionState<S> seekableTransitionState, S s, Transition<S> transition, Continuation<? super C02902> continuation) {
            super(1, continuation);
            this.this$0 = seekableTransitionState;
            this.$targetState = s;
            this.$transition = transition;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C02902(this.this$0, this.$targetState, this.$transition, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C02902) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            float f;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.endAllAnimations();
                ((SeekableTransitionState) this.this$0).lastFrameTimeNanos = Long.MIN_VALUE;
                this.this$0.setFraction(0.0f);
                S s = this.$targetState;
                if (Intrinsics.areEqual(s, this.this$0.getCurrentState())) {
                    f = -4.0f;
                } else {
                    f = Intrinsics.areEqual(s, this.this$0.getTargetState()) ? -5.0f : -3.0f;
                }
                this.$transition.updateTarget$animation_core(this.$targetState);
                this.$transition.setPlayTimeNanos(0L);
                this.this$0.setTargetState$animation_core(this.$targetState);
                this.this$0.setFraction(0.0f);
                this.this$0.setCurrentState$animation_core(this.$targetState);
                this.$transition.resetAnimationFraction$animation_core(f);
                if (f == -3.0f) {
                    this.label = 1;
                    if (this.this$0.waitForCompositionAfterTargetStateChange(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$transition.onTransitionEnd$animation_core();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object seekTo$default(SeekableTransitionState seekableTransitionState, float f, Object obj, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = seekableTransitionState.getTargetState();
        }
        return seekableTransitionState.seekTo(f, obj, continuation);
    }

    public final Object seekTo(float f, S s, Continuation<? super Unit> continuation) {
        boolean z = false;
        if (0.0f <= f && f <= 1.0f) {
            z = true;
        }
        if (!z) {
            PreconditionsKt.throwIllegalArgumentException("Expecting fraction between 0 and 1. Got " + f);
        }
        Transition<S> transition = this.transition;
        if (transition == null) {
            return Unit.INSTANCE;
        }
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new C02893(s, getTargetState(), this, transition, f, null), continuation, 1, null);
        return objMutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3 */
    /* JADX INFO: compiled from: Transition.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", ""}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3", m1609f = "Transition.kt", m1610i = {}, m1611l = {496}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C02893 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ float $fraction;
        final /* synthetic */ S $oldTargetState;
        final /* synthetic */ S $targetState;
        final /* synthetic */ Transition<S> $transition;
        int label;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02893(S s, S s2, SeekableTransitionState<S> seekableTransitionState, Transition<S> transition, float f, Continuation<? super C02893> continuation) {
            super(1, continuation);
            this.$targetState = s;
            this.$oldTargetState = s2;
            this.this$0 = seekableTransitionState;
            this.$transition = transition;
            this.$fraction = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C02893(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C02893) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: Transition.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1", m1609f = "Transition.kt", m1610i = {}, m1611l = {518}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ float $fraction;
            final /* synthetic */ S $oldTargetState;
            final /* synthetic */ S $targetState;
            final /* synthetic */ Transition<S> $transition;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(S s, S s2, SeekableTransitionState<S> seekableTransitionState, Transition<S> transition, float f, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$targetState = s;
                this.$oldTargetState = s2;
                this.this$0 = seekableTransitionState;
                this.$transition = transition;
                this.$fraction = f;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    if (!Intrinsics.areEqual(this.$targetState, this.$oldTargetState)) {
                        this.this$0.moveAnimationToInitialState();
                    } else {
                        ((SeekableTransitionState) this.this$0).currentAnimation = null;
                        if (Intrinsics.areEqual(this.this$0.getCurrentState(), this.$targetState)) {
                            return Unit.INSTANCE;
                        }
                    }
                    if (!Intrinsics.areEqual(this.$targetState, this.$oldTargetState)) {
                        this.$transition.updateTarget$animation_core(this.$targetState);
                        this.$transition.setPlayTimeNanos(0L);
                        this.this$0.setTargetState$animation_core(this.$targetState);
                        this.$transition.resetAnimationFraction$animation_core(this.$fraction);
                    }
                    this.this$0.setFraction(this.$fraction);
                    if (((SeekableTransitionState) this.this$0).initialValueAnimations.isNotEmpty()) {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C91671(this.this$0, null), 3, null);
                    } else {
                        ((SeekableTransitionState) this.this$0).lastFrameTimeNanos = Long.MIN_VALUE;
                    }
                    this.label = 1;
                    if (this.this$0.waitForCompositionAfterTargetStateChange(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.this$0.seekToFraction();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Transition.kt */
            @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
            @DebugMetadata(m1608c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1$1", m1609f = "Transition.kt", m1610i = {}, m1611l = {514}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
            static final class C91671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ SeekableTransitionState<S> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C91671(SeekableTransitionState<S> seekableTransitionState, Continuation<? super C91671> continuation) {
                    super(2, continuation);
                    this.this$0 = seekableTransitionState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C91671(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C91671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (this.this$0.runAnimations(this) == coroutine_suspended) {
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
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, null), this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object waitForCompositionAfterTargetStateChange(Continuation<? super Unit> continuation) {
        C02921 c02921;
        Object targetState;
        Object obj;
        if (continuation instanceof C02921) {
            c02921 = (C02921) continuation;
            if ((c02921.label & Integer.MIN_VALUE) != 0) {
                c02921.label -= Integer.MIN_VALUE;
            } else {
                c02921 = new C02921(this, continuation);
            }
        }
        Object obj2 = c02921.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02921.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj2);
            targetState = getTargetState();
            Mutex mutex = this.compositionContinuationMutex;
            c02921.L$0 = targetState;
            c02921.label = 1;
            if (Mutex.DefaultImpls.lock$default(mutex, null, c02921, 1, null) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = c02921.L$0;
            ResultKt.throwOnFailure(obj2);
            if (!Intrinsics.areEqual(obj2, obj)) {
                this.lastFrameTimeNanos = Long.MIN_VALUE;
                throw new CancellationException("snapTo() was canceled because state was changed to " + obj2 + " instead of " + obj);
            }
            return Unit.INSTANCE;
        }
        Object obj3 = c02921.L$0;
        ResultKt.throwOnFailure(obj2);
        targetState = obj3;
        if (Intrinsics.areEqual(targetState, this.composedTargetState)) {
            Mutex.DefaultImpls.unlock$default(this.compositionContinuationMutex, null, 1, null);
            return Unit.INSTANCE;
        }
        c02921.L$0 = targetState;
        c02921.label = 2;
        C02921 c029212 = c02921;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c029212), 1);
        cancellableContinuationImpl.initCancellability();
        setCompositionContinuation$animation_core(cancellableContinuationImpl);
        Mutex.DefaultImpls.unlock$default(getCompositionContinuationMutex(), null, 1, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(c029212);
        }
        if (result != coroutine_suspended) {
            obj = targetState;
            obj2 = result;
            if (!Intrinsics.areEqual(obj2, obj)) {
            }
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object waitForComposition(Continuation<? super Unit> continuation) {
        C02911 c02911;
        Object targetState;
        Object obj;
        if (continuation instanceof C02911) {
            c02911 = (C02911) continuation;
            if ((c02911.label & Integer.MIN_VALUE) != 0) {
                c02911.label -= Integer.MIN_VALUE;
            } else {
                c02911 = new C02911(this, continuation);
            }
        }
        Object obj2 = c02911.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02911.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj2);
            targetState = getTargetState();
            Mutex mutex = this.compositionContinuationMutex;
            c02911.L$0 = targetState;
            c02911.label = 1;
            if (Mutex.DefaultImpls.lock$default(mutex, null, c02911, 1, null) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = c02911.L$0;
            ResultKt.throwOnFailure(obj2);
            if (Intrinsics.areEqual(obj2, obj)) {
                this.lastFrameTimeNanos = Long.MIN_VALUE;
                throw new CancellationException("targetState while waiting for composition");
            }
            return Unit.INSTANCE;
        }
        Object obj3 = c02911.L$0;
        ResultKt.throwOnFailure(obj2);
        targetState = obj3;
        c02911.L$0 = targetState;
        c02911.label = 2;
        C02911 c029112 = c02911;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c029112), 1);
        cancellableContinuationImpl.initCancellability();
        setCompositionContinuation$animation_core(cancellableContinuationImpl);
        Mutex.DefaultImpls.unlock$default(getCompositionContinuationMutex(), null, 1, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(c029112);
        }
        if (result != coroutine_suspended) {
            obj = targetState;
            obj2 = result;
            if (Intrinsics.areEqual(obj2, obj)) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveAnimationToInitialState() {
        Transition<S> transition = this.transition;
        if (transition == null) {
            return;
        }
        SeekingAnimationState seekingAnimationState = this.currentAnimation;
        if (seekingAnimationState == null) {
            if (this.totalDurationNanos <= 0 || getFraction() == 1.0f || Intrinsics.areEqual(getCurrentState(), getTargetState())) {
                seekingAnimationState = null;
            } else {
                seekingAnimationState = new SeekingAnimationState();
                seekingAnimationState.setValue(getFraction());
                long j = this.totalDurationNanos;
                seekingAnimationState.setDurationNanos(j);
                seekingAnimationState.setAnimationSpecDuration(MathKt.roundToLong(j * (1.0d - ((double) getFraction()))));
                seekingAnimationState.getStart().set$animation_core(0, getFraction());
            }
        }
        if (seekingAnimationState != null) {
            seekingAnimationState.setDurationNanos(this.totalDurationNanos);
            this.initialValueAnimations.add(seekingAnimationState);
            transition.setInitialAnimations$animation_core(seekingAnimationState);
        }
        this.currentAnimation = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(SeekableTransitionState seekableTransitionState, Object obj, FiniteAnimationSpec finiteAnimationSpec, Continuation continuation, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = seekableTransitionState.getTargetState();
        }
        if ((i & 2) != 0) {
            finiteAnimationSpec = null;
        }
        return seekableTransitionState.animateTo(obj, finiteAnimationSpec, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$animateTo$2 */
    /* JADX INFO: compiled from: Transition.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", ""}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.animation.core.SeekableTransitionState$animateTo$2", m1609f = "Transition.kt", m1610i = {}, m1611l = {TypedValues.MotionType.TYPE_PATHMOTION_ARC}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C02872 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
        final /* synthetic */ S $targetState;
        final /* synthetic */ Transition<S> $transition;
        int label;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02872(Transition<S> transition, SeekableTransitionState<S> seekableTransitionState, S s, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super C02872> continuation) {
            super(1, continuation);
            this.$transition = transition;
            this.this$0 = seekableTransitionState;
            this.$targetState = s;
            this.$animationSpec = finiteAnimationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C02872(this.$transition, this.this$0, this.$targetState, this.$animationSpec, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C02872) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$animateTo$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Transition.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "androidx.compose.animation.core.SeekableTransitionState$animateTo$2$1", m1609f = "Transition.kt", m1610i = {0}, m1611l = {2194, 620, PDFACompliance.e_PDFA6_2_2, 676, 678}, m1612m = "invokeSuspend", m1613n = {"$this$withLock_u24default$iv"}, m1615s = {"L$0"}, m1616v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
            final /* synthetic */ S $targetState;
            final /* synthetic */ Transition<S> $transition;
            Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SeekableTransitionState<S> seekableTransitionState, S s, Transition<S> transition, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = seekableTransitionState;
                this.$targetState = s;
                this.$transition = transition;
                this.$animationSpec = finiteAnimationSpec;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$targetState, this.$transition, this.$animationSpec, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:74:0x0209, code lost:
            
                if (r18.this$0.waitForComposition(r18) != r0) goto L76;
             */
            /* JADX WARN: Removed duplicated region for block: B:32:0x00c4  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x00d2  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Mutex mutex;
                SeekableTransitionState<S> seekableTransitionState;
                AnimationVector1D zeroVelocity;
                long jRoundToLong;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        S targetState = this.this$0.getTargetState();
                        if (!Intrinsics.areEqual(this.$targetState, targetState)) {
                            this.this$0.moveAnimationToInitialState();
                            this.this$0.setFraction(0.0f);
                            this.$transition.updateTarget$animation_core(this.$targetState);
                            this.$transition.setPlayTimeNanos(0L);
                            this.this$0.setCurrentState$animation_core(targetState);
                            this.this$0.setTargetState$animation_core(this.$targetState);
                        }
                        Mutex compositionContinuationMutex = this.this$0.getCompositionContinuationMutex();
                        SeekableTransitionState<S> seekableTransitionState2 = this.this$0;
                        this.L$0 = compositionContinuationMutex;
                        this.L$1 = seekableTransitionState2;
                        this.label = 1;
                        if (compositionContinuationMutex.lock(null, this) != coroutine_suspended) {
                            mutex = compositionContinuationMutex;
                            seekableTransitionState = seekableTransitionState2;
                        }
                        return coroutine_suspended;
                    }
                    if (i == 1) {
                        seekableTransitionState = (SeekableTransitionState) this.L$1;
                        mutex = (Mutex) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 3;
                            if (this.this$0.waitForCompositionAfterTargetStateChange(this) != coroutine_suspended) {
                                if (!Intrinsics.areEqual(this.this$0.getCurrentState(), this.$targetState)) {
                                }
                                return Unit.INSTANCE;
                            }
                            return coroutine_suspended;
                        }
                        if (i == 3) {
                            ResultKt.throwOnFailure(obj);
                            if (!Intrinsics.areEqual(this.this$0.getCurrentState(), this.$targetState)) {
                                if (this.this$0.getFraction() < 1.0f) {
                                    SeekingAnimationState seekingAnimationState = ((SeekableTransitionState) this.this$0).currentAnimation;
                                    FiniteAnimationSpec<Float> finiteAnimationSpec = this.$animationSpec;
                                    VectorizedAnimationSpec<AnimationVector1D> vectorizedAnimationSpecVectorize = finiteAnimationSpec != null ? finiteAnimationSpec.vectorize((TwoWayConverter<Float, V>) VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE)) : null;
                                    if (seekingAnimationState == null || !Intrinsics.areEqual(vectorizedAnimationSpecVectorize, seekingAnimationState.getAnimationSpec())) {
                                        VectorizedAnimationSpec<AnimationVector1D> animationSpec = seekingAnimationState != null ? seekingAnimationState.getAnimationSpec() : null;
                                        if (animationSpec != null) {
                                            long progressNanos = seekingAnimationState.getProgressNanos();
                                            AnimationVector1D start = seekingAnimationState.getStart();
                                            AnimationVector1D target1 = SeekableTransitionState.Companion.getTarget1();
                                            AnimationVector1D initialVelocity = seekingAnimationState.getInitialVelocity();
                                            if (initialVelocity == null) {
                                                initialVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                            }
                                            zeroVelocity = (AnimationVector1D) animationSpec.getVelocityFromNanos(progressNanos, start, target1, initialVelocity);
                                        } else if (seekingAnimationState == null || seekingAnimationState.getProgressNanos() == 0) {
                                            zeroVelocity = SeekableTransitionState.Companion.getZeroVelocity();
                                        } else {
                                            long durationNanos = seekingAnimationState.getDurationNanos();
                                            if (durationNanos == Long.MIN_VALUE) {
                                                durationNanos = this.this$0.getTotalDurationNanos();
                                            }
                                            float f = durationNanos / 1.0E9f;
                                            zeroVelocity = f <= 0.0f ? SeekableTransitionState.Companion.getZeroVelocity() : new AnimationVector1D(1.0f / f);
                                        }
                                        if (seekingAnimationState == null) {
                                            seekingAnimationState = new SeekingAnimationState();
                                        }
                                        seekingAnimationState.setAnimationSpec(vectorizedAnimationSpecVectorize);
                                        seekingAnimationState.setComplete(false);
                                        seekingAnimationState.setValue(this.this$0.getFraction());
                                        seekingAnimationState.getStart().set$animation_core(0, this.this$0.getFraction());
                                        seekingAnimationState.setDurationNanos(this.this$0.getTotalDurationNanos());
                                        seekingAnimationState.setProgressNanos(0L);
                                        seekingAnimationState.setInitialVelocity(zeroVelocity);
                                        if (vectorizedAnimationSpecVectorize != null) {
                                            jRoundToLong = vectorizedAnimationSpecVectorize.getDurationNanos(seekingAnimationState.getStart(), SeekableTransitionState.Companion.getTarget1(), zeroVelocity);
                                        } else {
                                            jRoundToLong = MathKt.roundToLong(this.this$0.getTotalDurationNanos() * (1.0d - ((double) this.this$0.getFraction())));
                                        }
                                        seekingAnimationState.setAnimationSpecDuration(jRoundToLong);
                                        ((SeekableTransitionState) this.this$0).currentAnimation = seekingAnimationState;
                                    }
                                }
                                this.L$0 = null;
                                this.L$1 = null;
                                this.label = 4;
                                if (this.this$0.runAnimations(this) != coroutine_suspended) {
                                    this.this$0.setCurrentState$animation_core(this.$targetState);
                                    this.label = 5;
                                }
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        if (i != 4) {
                            if (i != 5) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            this.this$0.setFraction(0.0f);
                            return Unit.INSTANCE;
                        }
                        ResultKt.throwOnFailure(obj);
                        this.this$0.setCurrentState$animation_core(this.$targetState);
                        this.label = 5;
                    }
                    S composedTargetState$animation_core = seekableTransitionState.getComposedTargetState$animation_core();
                    mutex.unlock(null);
                    if (!Intrinsics.areEqual(this.$targetState, composedTargetState$animation_core)) {
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 2;
                        if (this.this$0.doOneFrame(this) != coroutine_suspended) {
                            this.label = 3;
                            if (this.this$0.waitForCompositionAfterTargetStateChange(this) != coroutine_suspended) {
                            }
                        }
                    }
                    return coroutine_suspended;
                } catch (Throwable th) {
                    mutex.unlock(null);
                    throw th;
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(this.this$0, this.$targetState, this.$transition, this.$animationSpec, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$transition.onTransitionEnd$animation_core();
            return Unit.INSTANCE;
        }
    }

    public final Object animateTo(S s, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super Unit> continuation) {
        Transition<S> transition = this.transition;
        if (transition == null) {
            return Unit.INSTANCE;
        }
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new C02872(transition, this, s, finiteAnimationSpec, null), continuation, 1, null);
        return objMutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate$default : Unit.INSTANCE;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void transitionConfigured$animation_core(Transition<S> transition) {
        Transition<S> transition2 = this.transition;
        if (!(transition2 == null || Intrinsics.areEqual(transition, transition2))) {
            PreconditionsKt.throwIllegalStateException("An instance of SeekableTransitionState has been used in different Transitions. Previous instance: " + this.transition + ", new instance: " + transition);
        }
        this.transition = transition;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void transitionRemoved$animation_core() {
        this.transition = null;
        SnapshotStateObserver snapshotStateObserver = this.snapshotStateObserver;
        if (snapshotStateObserver != null) {
            snapshotStateObserver.clear(this);
        }
    }

    public final void observeTotalDuration$animation_core() {
        SnapshotStateObserver snapshotStateObserver = this.snapshotStateObserver;
        if (snapshotStateObserver != null) {
            snapshotStateObserver.observeReads(this, TransitionKt.SeekableTransitionStateTotalDurationChanged, this.recalculateTotalDurationNanos);
        }
    }

    public final void onTotalDurationChanged$animation_core() {
        long j = this.totalDurationNanos;
        observeTotalDuration$animation_core();
        long j2 = this.totalDurationNanos;
        if (j != j2) {
            SeekingAnimationState seekingAnimationState = this.currentAnimation;
            if (seekingAnimationState == null) {
                if (j2 != 0) {
                    seekToFraction();
                    return;
                }
                return;
            }
            long progressNanos = seekingAnimationState.getProgressNanos();
            long j3 = this.totalDurationNanos;
            if (progressNanos > j3) {
                endAllAnimations();
                return;
            }
            seekingAnimationState.setDurationNanos(j3);
            if (seekingAnimationState.getAnimationSpec() == null) {
                seekingAnimationState.setAnimationSpecDuration(MathKt.roundToLong((1.0d - ((double) seekingAnimationState.getStart().get$animation_core(0))) * this.totalDurationNanos));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void seekToFraction() {
        Transition<S> transition = this.transition;
        if (transition == null) {
            return;
        }
        transition.seekAnimations$animation_core(MathKt.roundToLong(((double) getFraction()) * transition.getTotalDurationNanos()));
    }

    /* JADX INFO: compiled from: Transition.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010*\u001a\u00020+H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001a\u0010$\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR\u001a\u0010'\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\t¨\u0006,"}, m1599d2 = {"Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "", "<init>", "()V", "progressNanos", "", "getProgressNanos", "()J", "setProgressNanos", "(J)V", "animationSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "Landroidx/compose/animation/core/AnimationVector1D;", "getAnimationSpec", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;)V", "isComplete", "", "()Z", "setComplete", "(Z)V", "value", "", "getValue", "()F", "setValue", "(F)V", TtmlNode.START, "getStart", "()Landroidx/compose/animation/core/AnimationVector1D;", "setStart", "(Landroidx/compose/animation/core/AnimationVector1D;)V", "initialVelocity", "getInitialVelocity", "setInitialVelocity", "durationNanos", "getDurationNanos", "setDurationNanos", "animationSpecDuration", "getAnimationSpecDuration", "setAnimationSpecDuration", "toString", "", "animation-core"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class SeekingAnimationState {
        public static final int $stable = 8;
        private VectorizedAnimationSpec<AnimationVector1D> animationSpec;
        private long animationSpecDuration;
        private long durationNanos;
        private AnimationVector1D initialVelocity;
        private boolean isComplete;
        private long progressNanos;
        private AnimationVector1D start = new AnimationVector1D(0.0f);
        private float value;

        public final long getProgressNanos() {
            return this.progressNanos;
        }

        public final void setProgressNanos(long j) {
            this.progressNanos = j;
        }

        public final VectorizedAnimationSpec<AnimationVector1D> getAnimationSpec() {
            return this.animationSpec;
        }

        public final void setAnimationSpec(VectorizedAnimationSpec<AnimationVector1D> vectorizedAnimationSpec) {
            this.animationSpec = vectorizedAnimationSpec;
        }

        /* JADX INFO: renamed from: isComplete, reason: from getter */
        public final boolean getIsComplete() {
            return this.isComplete;
        }

        public final void setComplete(boolean z) {
            this.isComplete = z;
        }

        public final float getValue() {
            return this.value;
        }

        public final void setValue(float f) {
            this.value = f;
        }

        public final AnimationVector1D getStart() {
            return this.start;
        }

        public final void setStart(AnimationVector1D animationVector1D) {
            this.start = animationVector1D;
        }

        public final AnimationVector1D getInitialVelocity() {
            return this.initialVelocity;
        }

        public final void setInitialVelocity(AnimationVector1D animationVector1D) {
            this.initialVelocity = animationVector1D;
        }

        public final long getDurationNanos() {
            return this.durationNanos;
        }

        public final void setDurationNanos(long j) {
            this.durationNanos = j;
        }

        public final long getAnimationSpecDuration() {
            return this.animationSpecDuration;
        }

        public final void setAnimationSpecDuration(long j) {
            this.animationSpecDuration = j;
        }

        public String toString() {
            return "progress nanos: " + this.progressNanos + ", animationSpec: " + this.animationSpec + ", isComplete: " + this.isComplete + ", value: " + this.value + ", start: " + this.start + ", initialVelocity: " + this.initialVelocity + ", durationNanos: " + this.durationNanos + ", animationSpecDuration: " + this.animationSpecDuration;
        }
    }

    /* JADX INFO: compiled from: Transition.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, m1599d2 = {"Landroidx/compose/animation/core/SeekableTransitionState$Companion;", "", "<init>", "()V", "ZeroVelocity", "Landroidx/compose/animation/core/AnimationVector1D;", "getZeroVelocity", "()Landroidx/compose/animation/core/AnimationVector1D;", "Target1", "getTarget1", "animation-core"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnimationVector1D getZeroVelocity() {
            return SeekableTransitionState.ZeroVelocity;
        }

        public final AnimationVector1D getTarget1() {
            return SeekableTransitionState.Target1;
        }
    }
}
