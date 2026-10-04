package androidx.compose.foundation.gestures;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.MouseWheelScrollingLogic;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p004ui.input.pointer.PointerEvent;
import androidx.compose.p004ui.input.pointer.PointerEventPass;
import androidx.compose.p004ui.input.pointer.PointerEventType;
import androidx.compose.p004ui.input.pointer.PointerInputChange;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.Velocity;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: compiled from: MouseWheelScrollingLogic.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001ABR\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00121\u0010\u0006\u001a-\b\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H\u0016J\u001f\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0004\b&\u0010'J\u0014\u0010(\u001a\u0004\u0018\u00010\u001e*\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\u001b\u0010)\u001a\u00020%*\u00020\u00032\u0006\u0010*\u001a\u00020+H\u0002¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u001eH\u0002J*\u0010/\u001a\u00020\r*\u00020\u00032\u0006\u0010*\u001a\u00020\u001e2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0082@¢\u0006\u0002\u00103JY\u00104\u001a\u00020\r*\u0002052\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000208072\u0006\u00109\u001a\u0002012\u0006\u0010:\u001a\u00020;2!\u0010<\u001a\u001d\u0012\u0013\u0012\u001101¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020%0=H\u0082@¢\u0006\u0002\u0010?J\u0014\u0010/\u001a\u000201*\u0002052\u0006\u0010@\u001a\u000201H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, m1599d2 = {"Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic;", "Landroidx/compose/foundation/gestures/NonTouchScrollingLogic;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "mouseWheelScrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "onScrollStopped", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Velocity;", "Lkotlin/ParameterName;", "name", "velocity", "Lkotlin/coroutines/Continuation;", "", "", "density", "Landroidx/compose/ui/unit/Density;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Landroidx/compose/foundation/gestures/ScrollConfig;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/unit/Density;)V", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;", "receivingMouseWheelEventsJob", "Lkotlinx/coroutines/Job;", "startReceivingEvents", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "onMouseWheel", "", "onMouseWheel-O0kMr_c", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "sumOrNull", "canConsumeDelta", "scrollDelta", "Landroidx/compose/ui/geometry/Offset;", "canConsumeDelta-Uv8p0NA", "(Landroidx/compose/foundation/gestures/ScrollingLogic;J)Z", "trackVelocity", "dispatchMouseWheelScroll", "threshold", "", "speed", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateMouseWheelScroll", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "animationState", "Landroidx/compose/animation/core/AnimationState;", "Landroidx/compose/animation/core/AnimationVector1D;", "targetValue", "durationMillis", "", "shouldCancelAnimation", "Lkotlin/Function1;", "lastValue", "(Landroidx/compose/foundation/gestures/NestedScrollScope;Landroidx/compose/animation/core/AnimationState;FILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delta", "MouseWheelScrollDelta", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MouseWheelScrollingLogic extends NonTouchScrollingLogic {
    public static final int $stable = 8;
    private final Channel<MouseWheelScrollDelta> channel;
    private final ScrollConfig mouseWheelScrollConfig;
    private Job receivingMouseWheelEventsJob;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$1 */
    /* JADX INFO: compiled from: MouseWheelScrollingLogic.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic", m1609f = "MouseWheelScrollingLogic.kt", m1610i = {0, 0, 0}, m1611l = {219, 273}, m1612m = "dispatchMouseWheelScroll", m1613n = {"$this$dispatchMouseWheelScroll", "targetValue", "speed"}, m1615s = {"L$0", "L$1", "F$0"}, m1616v = 1)
    static final class C04021 extends ContinuationImpl {
        float F$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C04021(Continuation<? super C04021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MouseWheelScrollingLogic.this.dispatchMouseWheelScroll(null, null, 0.0f, 0.0f, this);
        }
    }

    public MouseWheelScrollingLogic(ScrollingLogic scrollingLogic, ScrollConfig scrollConfig, Function2<? super Velocity, ? super Continuation<? super Unit>, ? extends Object> function2, Density density) {
        super(scrollingLogic, function2, density);
        this.mouseWheelScrollConfig = scrollConfig;
        this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    }

    @Override // androidx.compose.foundation.gestures.NonTouchScrollingLogic
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void mo2330onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        if (PointerEventType.m9432equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m9447getScroll7fucELk())) {
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            for (int i = 0; i < size; i++) {
                if (changes.get(i).isConsumed()) {
                    return;
                }
            }
            if (pass == PointerEventPass.Initial && getIsScrolling()) {
                m2329onMouseWheelO0kMr_c(pointerEvent, bounds);
                consume$foundation(pointerEvent);
            }
            if (pass == PointerEventPass.Main && !getIsScrolling() && m2329onMouseWheelO0kMr_c(pointerEvent, bounds)) {
                consume$foundation(pointerEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: MouseWheelScrollingLogic.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0086\u0002J\u0010\u0010\u0012\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J.\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, m1599d2 = {"Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;", "", "value", "Landroidx/compose/ui/geometry/Offset;", "timeMillis", "", "shouldApplyImmediately", "", "<init>", "(JJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-F1C5BW0", "()J", "J", "getTimeMillis", "getShouldApplyImmediately", "()Z", "plus", "other", "component1", "component1-F1C5BW0", "component2", "component3", "copy", "copy-9KIMszo", "(JJZ)Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;", "equals", "hashCode", "", "toString", "", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    static final /* data */ class MouseWheelScrollDelta {
        private final boolean shouldApplyImmediately;
        private final long timeMillis;
        private final long value;

        public /* synthetic */ MouseWheelScrollDelta(long j, long j2, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, z);
        }

        /* JADX INFO: renamed from: copy-9KIMszo$default, reason: not valid java name */
        public static /* synthetic */ MouseWheelScrollDelta m2331copy9KIMszo$default(MouseWheelScrollDelta mouseWheelScrollDelta, long j, long j2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                j = mouseWheelScrollDelta.value;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                j2 = mouseWheelScrollDelta.timeMillis;
            }
            long j4 = j2;
            if ((i & 4) != 0) {
                z = mouseWheelScrollDelta.shouldApplyImmediately;
            }
            return mouseWheelScrollDelta.m2333copy9KIMszo(j3, j4, z);
        }

        /* JADX INFO: renamed from: component1-F1C5BW0, reason: not valid java name and from getter */
        public final long getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getTimeMillis() {
            return this.timeMillis;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getShouldApplyImmediately() {
            return this.shouldApplyImmediately;
        }

        /* JADX INFO: renamed from: copy-9KIMszo, reason: not valid java name */
        public final MouseWheelScrollDelta m2333copy9KIMszo(long value, long timeMillis, boolean shouldApplyImmediately) {
            return new MouseWheelScrollDelta(value, timeMillis, shouldApplyImmediately, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MouseWheelScrollDelta)) {
                return false;
            }
            MouseWheelScrollDelta mouseWheelScrollDelta = (MouseWheelScrollDelta) other;
            return Offset.m7900equalsimpl0(this.value, mouseWheelScrollDelta.value) && this.timeMillis == mouseWheelScrollDelta.timeMillis && this.shouldApplyImmediately == mouseWheelScrollDelta.shouldApplyImmediately;
        }

        public int hashCode() {
            return (((Offset.m7905hashCodeimpl(this.value) * 31) + Long.hashCode(this.timeMillis)) * 31) + Boolean.hashCode(this.shouldApplyImmediately);
        }

        public String toString() {
            return "MouseWheelScrollDelta(value=" + ((Object) Offset.m7911toStringimpl(this.value)) + ", timeMillis=" + this.timeMillis + ", shouldApplyImmediately=" + this.shouldApplyImmediately + ')';
        }

        private MouseWheelScrollDelta(long j, long j2, boolean z) {
            this.value = j;
            this.timeMillis = j2;
            this.shouldApplyImmediately = z;
        }

        /* JADX INFO: renamed from: getValue-F1C5BW0, reason: not valid java name */
        public final long m2334getValueF1C5BW0() {
            return this.value;
        }

        public final long getTimeMillis() {
            return this.timeMillis;
        }

        public final boolean getShouldApplyImmediately() {
            return this.shouldApplyImmediately;
        }

        public final MouseWheelScrollDelta plus(MouseWheelScrollDelta other) {
            return new MouseWheelScrollDelta(Offset.m7908plusMKHz9U(this.value, other.value), Math.max(this.timeMillis, other.timeMillis), this.shouldApplyImmediately, null);
        }
    }

    @Override // androidx.compose.foundation.gestures.NonTouchScrollingLogic
    public void startReceivingEvents(CoroutineScope coroutineScope) {
        if (this.receivingMouseWheelEventsJob == null) {
            this.receivingMouseWheelEventsJob = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C04071(null), 3, null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$startReceivingEvents$1 */
    /* JADX INFO: compiled from: MouseWheelScrollingLogic.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic$startReceivingEvents$1", m1609f = "MouseWheelScrollingLogic.kt", m1610i = {0, 1}, m1611l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 112}, m1612m = "invokeSuspend", m1613n = {"$this$launch", "$this$launch"}, m1615s = {"L$0", "L$0"}, m1616v = 1)
    static final class C04071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C04071(Continuation<? super C04071> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04071 c04071 = MouseWheelScrollingLogic.this.new C04071(continuation);
            c04071.L$0 = obj;
            return c04071;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0083, code lost:
        
            if (r5.dispatchMouseWheelScroll(r5.getScrollingLogic(), r7, r8, r9, r12) != r0) goto L8;
         */
        /* JADX WARN: Removed duplicated region for block: B:19:0x003c A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:7:0x0013, B:17:0x0032, B:19:0x003c, B:23:0x0053, B:12:0x0024), top: B:30:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0083 -> B:8:0x0016). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            CoroutineScope coroutineScope2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = (CoroutineScope) this.L$0;
                    if (!JobKt.isActive(coroutineScope.getCoroutineContext())) {
                    }
                } else if (i == 1) {
                    coroutineScope2 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    MouseWheelScrollDelta mouseWheelScrollDelta = (MouseWheelScrollDelta) obj;
                    float fMo2191toPx0680j_4 = MouseWheelScrollingLogic.this.getDensity().mo2191toPx0680j_4(MouseWheelScrollingLogicKt.AnimationThreshold);
                    float fMo2191toPx0680j_42 = MouseWheelScrollingLogic.this.getDensity().mo2191toPx0680j_4(MouseWheelScrollingLogicKt.AnimationSpeed);
                    MouseWheelScrollingLogic mouseWheelScrollingLogic = MouseWheelScrollingLogic.this;
                    this.L$0 = coroutineScope2;
                    this.label = 2;
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    coroutineScope2 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = coroutineScope2;
                    if (!JobKt.isActive(coroutineScope.getCoroutineContext())) {
                        this.L$0 = coroutineScope;
                        this.label = 1;
                        Object objReceive = MouseWheelScrollingLogic.this.channel.receive(this);
                        if (objReceive == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        coroutineScope2 = coroutineScope;
                        obj = objReceive;
                        MouseWheelScrollDelta mouseWheelScrollDelta2 = (MouseWheelScrollDelta) obj;
                        float fMo2191toPx0680j_43 = MouseWheelScrollingLogic.this.getDensity().mo2191toPx0680j_4(MouseWheelScrollingLogicKt.AnimationThreshold);
                        float fMo2191toPx0680j_422 = MouseWheelScrollingLogic.this.getDensity().mo2191toPx0680j_4(MouseWheelScrollingLogicKt.AnimationSpeed);
                        MouseWheelScrollingLogic mouseWheelScrollingLogic2 = MouseWheelScrollingLogic.this;
                        this.L$0 = coroutineScope2;
                        this.label = 2;
                    } else {
                        MouseWheelScrollingLogic.this.receivingMouseWheelEventsJob = null;
                        return Unit.INSTANCE;
                    }
                }
            } catch (Throwable th) {
                MouseWheelScrollingLogic.this.receivingMouseWheelEventsJob = null;
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: onMouseWheel-O0kMr_c, reason: not valid java name */
    private final boolean m2329onMouseWheelO0kMr_c(PointerEvent pointerEvent, long bounds) {
        long jMo2220calculateMouseWheelScroll8xgXZGE = this.mouseWheelScrollConfig.mo2220calculateMouseWheelScroll8xgXZGE(getDensity(), pointerEvent, bounds);
        if (m2328canConsumeDeltaUv8p0NA(getScrollingLogic(), jMo2220calculateMouseWheelScroll8xgXZGE)) {
            return ChannelResult.m16046isSuccessimpl(this.channel.mo16021trySendJP2dKIU(new MouseWheelScrollDelta(jMo2220calculateMouseWheelScroll8xgXZGE, ((PointerInputChange) CollectionsKt.first((List) pointerEvent.getChanges())).getUptimeMillis(), !this.mouseWheelScrollConfig.isSmoothScrollingEnabled() || this.mouseWheelScrollConfig.isPreciseWheelScroll(pointerEvent), null)));
        }
        return getIsScrolling();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MouseWheelScrollDelta sumOrNull(final Channel<MouseWheelScrollDelta> channel) {
        MouseWheelScrollDelta mouseWheelScrollDeltaPlus = null;
        for (MouseWheelScrollDelta mouseWheelScrollDelta : NonTouchScrollingLogicKt.untilNull(new Function0() { // from class: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MouseWheelScrollingLogic.sumOrNull$lambda$0(channel);
            }
        })) {
            mouseWheelScrollDeltaPlus = mouseWheelScrollDeltaPlus == null ? mouseWheelScrollDelta : mouseWheelScrollDeltaPlus.plus(mouseWheelScrollDelta);
        }
        return mouseWheelScrollDeltaPlus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MouseWheelScrollDelta sumOrNull$lambda$0(Channel channel) {
        return (MouseWheelScrollDelta) ChannelResult.m16041getOrNullimpl(channel.mo16029tryReceivePtdJZtk());
    }

    /* JADX INFO: renamed from: canConsumeDelta-Uv8p0NA, reason: not valid java name */
    private final boolean m2328canConsumeDeltaUv8p0NA(ScrollingLogic scrollingLogic, long j) {
        float fM2400toSingleAxisDeltaFromAnglek4lQ0M = scrollingLogic.m2400toSingleAxisDeltaFromAnglek4lQ0M(scrollingLogic.m2396reverseIfNeededMKHz9U(j));
        if (fM2400toSingleAxisDeltaFromAnglek4lQ0M == 0.0f) {
            return false;
        }
        if (fM2400toSingleAxisDeltaFromAnglek4lQ0M > 0.0f) {
            return scrollingLogic.getScrollableState().getCanScrollForward();
        }
        return scrollingLogic.getScrollableState().getCanScrollBackward();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackVelocity(MouseWheelScrollDelta scrollDelta) {
        getVelocityTracker().m2246addDeltaUv8p0NA(scrollDelta.getTimeMillis(), scrollDelta.m2334getValueF1C5BW0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x010f, code lost:
    
        if (r0.invoke(r1, r9) == r10) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /* JADX WARN: Type inference failed for: r0v14, types: [T, androidx.compose.foundation.gestures.MouseWheelScrollingLogic$MouseWheelScrollDelta] */
    /* JADX WARN: Type inference failed for: r0v8, types: [T, androidx.compose.animation.core.AnimationState] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object dispatchMouseWheelScroll(ScrollingLogic scrollingLogic, MouseWheelScrollDelta mouseWheelScrollDelta, float f, float f2, Continuation<? super Unit> continuation) {
        C04021 c04021;
        Ref.FloatRef floatRef;
        float f3;
        ScrollingLogic scrollingLogic2;
        if (continuation instanceof C04021) {
            c04021 = (C04021) continuation;
            if ((c04021.label & Integer.MIN_VALUE) != 0) {
                c04021.label -= Integer.MIN_VALUE;
            } else {
                c04021 = new C04021(continuation);
            }
        }
        C04021 c040212 = c04021;
        Object obj = c040212.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c040212.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = mouseWheelScrollDelta;
            trackVelocity(mouseWheelScrollDelta);
            MouseWheelScrollDelta mouseWheelScrollDeltaSumOrNull = sumOrNull(this.channel);
            if (mouseWheelScrollDeltaSumOrNull != null) {
                trackVelocity(mouseWheelScrollDeltaSumOrNull);
                objectRef.element = ((MouseWheelScrollDelta) objectRef.element).plus(mouseWheelScrollDeltaSumOrNull);
            }
            Ref.FloatRef floatRef2 = new Ref.FloatRef();
            floatRef2.element = scrollingLogic.m2398toFloatk4lQ0M(scrollingLogic.m2396reverseIfNeededMKHz9U(((MouseWheelScrollDelta) objectRef.element).m2334getValueF1C5BW0()));
            if (MouseWheelScrollingLogicKt.isLowScrollingDelta(floatRef2.element)) {
                return Unit.INSTANCE;
            }
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = AnimationStateKt.AnimationState$default(0.0f, 0.0f, 0L, 0L, false, 30, null);
            Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> c04033 = new C04033(floatRef2, objectRef2, objectRef, f, this, f2, scrollingLogic, null);
            c040212.L$0 = scrollingLogic;
            c040212.L$1 = floatRef2;
            c040212.F$0 = f2;
            c040212.label = 1;
            if (userScroll$foundation(c04033, c040212) != coroutine_suspended) {
                floatRef = floatRef2;
                f3 = f2;
                scrollingLogic2 = scrollingLogic;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        f3 = c040212.F$0;
        floatRef = (Ref.FloatRef) c040212.L$1;
        scrollingLogic2 = (ScrollingLogic) c040212.L$0;
        ResultKt.throwOnFailure(obj);
        long jM2247calculateVelocity9UxMQ8M = getVelocityTracker().m2247calculateVelocity9UxMQ8M();
        if (Velocity.m11254equalsimpl0(jM2247calculateVelocity9UxMQ8M, Velocity.INSTANCE.m11266getZero9UxMQ8M())) {
            jM2247calculateVelocity9UxMQ8M = scrollingLogic2.m2401toVelocityadjELrA(scrollingLogic2.reverseIfNeeded(Math.signum(floatRef.element)) * Math.min(Math.abs(floatRef.element) / 100, f3) * 1000);
        }
        Function2<Velocity, Continuation<? super Unit>, Object> onScrollStopped = getOnScrollStopped();
        Velocity velocityM11246boximpl = Velocity.m11246boximpl(jM2247calculateVelocity9UxMQ8M);
        c040212.L$0 = null;
        c040212.L$1 = null;
        c040212.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Type inference failed for: r1v10, types: [T, androidx.compose.animation.core.AnimationState] */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, androidx.compose.foundation.gestures.MouseWheelScrollingLogic$MouseWheelScrollDelta] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object dispatchMouseWheelScroll$waitNextScrollDelta(MouseWheelScrollingLogic mouseWheelScrollingLogic, Ref.ObjectRef<MouseWheelScrollDelta> objectRef, Ref.FloatRef floatRef, ScrollingLogic scrollingLogic, Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> objectRef2, long j, Continuation<? super Boolean> continuation) {
        C0405x7147264e c0405x7147264e;
        Ref.FloatRef floatRef2;
        ScrollingLogic scrollingLogic2;
        Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> objectRef3;
        Ref.ObjectRef<MouseWheelScrollDelta> objectRef4;
        MouseWheelScrollingLogic mouseWheelScrollingLogic2 = mouseWheelScrollingLogic;
        if (continuation instanceof C0405x7147264e) {
            c0405x7147264e = (C0405x7147264e) continuation;
            if ((c0405x7147264e.label & Integer.MIN_VALUE) != 0) {
                c0405x7147264e.label -= Integer.MIN_VALUE;
            } else {
                c0405x7147264e = new C0405x7147264e(continuation);
            }
        }
        Object objWithTimeoutOrNull = c0405x7147264e.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c0405x7147264e.label;
        boolean z = false;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithTimeoutOrNull);
            if (j < 0) {
                return Boxing.boxBoolean(false);
            }
            C0406x7147264f c0406x7147264f = new C0406x7147264f(mouseWheelScrollingLogic2, null);
            c0405x7147264e.L$0 = mouseWheelScrollingLogic2;
            c0405x7147264e.L$1 = objectRef;
            floatRef2 = floatRef;
            c0405x7147264e.L$2 = floatRef2;
            scrollingLogic2 = scrollingLogic;
            c0405x7147264e.L$3 = scrollingLogic2;
            objectRef3 = objectRef2;
            c0405x7147264e.L$4 = objectRef3;
            c0405x7147264e.label = 1;
            objWithTimeoutOrNull = TimeoutKt.withTimeoutOrNull(j, c0406x7147264f, c0405x7147264e);
            if (objWithTimeoutOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef4 = objectRef;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> objectRef5 = (Ref.ObjectRef) c0405x7147264e.L$4;
            ScrollingLogic scrollingLogic3 = (ScrollingLogic) c0405x7147264e.L$3;
            Ref.FloatRef floatRef3 = (Ref.FloatRef) c0405x7147264e.L$2;
            objectRef4 = (Ref.ObjectRef) c0405x7147264e.L$1;
            MouseWheelScrollingLogic mouseWheelScrollingLogic3 = (MouseWheelScrollingLogic) c0405x7147264e.L$0;
            ResultKt.throwOnFailure(objWithTimeoutOrNull);
            objectRef3 = objectRef5;
            scrollingLogic2 = scrollingLogic3;
            floatRef2 = floatRef3;
            mouseWheelScrollingLogic2 = mouseWheelScrollingLogic3;
        }
        MouseWheelScrollDelta mouseWheelScrollDelta = (MouseWheelScrollDelta) objWithTimeoutOrNull;
        if (mouseWheelScrollDelta != null) {
            objectRef4.element = MouseWheelScrollDelta.m2331copy9KIMszo$default(mouseWheelScrollDelta, 0L, 0L, objectRef4.element.getShouldApplyImmediately(), 3, null);
            floatRef2.element = scrollingLogic2.m2400toSingleAxisDeltaFromAnglek4lQ0M(scrollingLogic2.m2396reverseIfNeededMKHz9U(objectRef4.element.m2334getValueF1C5BW0()));
            objectRef3.element = AnimationStateKt.AnimationState$default(0.0f, 0.0f, 0L, 0L, false, 30, null);
            mouseWheelScrollingLogic2.trackVelocity(mouseWheelScrollDelta);
            z = !MouseWheelScrollingLogicKt.isLowScrollingDelta(floatRef2.element);
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$3 */
    /* JADX INFO: compiled from: MouseWheelScrollingLogic.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$3", m1609f = "MouseWheelScrollingLogic.kt", m1610i = {0, 0, 1, 1, 1, 2, 2}, m1611l = {228, PDFACompliance.e_PDFA2_4_1, PDFACompliance.e_PDFA2_6_1}, m1612m = "invokeSuspend", m1613n = {"$this$userScroll", "requiredAnimation", "$this$userScroll", "requiredAnimation", "durationMillis", "$this$userScroll", "requiredAnimation"}, m1615s = {"L$0", "L$1", "L$0", "L$1", "I$0", "L$0", "L$1"}, m1616v = 1)
    static final class C04033 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> $animationState;
        final /* synthetic */ float $speed;
        final /* synthetic */ Ref.ObjectRef<MouseWheelScrollDelta> $targetScrollDelta;
        final /* synthetic */ Ref.FloatRef $targetValue;
        final /* synthetic */ ScrollingLogic $this_dispatchMouseWheelScroll;
        final /* synthetic */ float $threshold;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ MouseWheelScrollingLogic this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04033(Ref.FloatRef floatRef, Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> objectRef, Ref.ObjectRef<MouseWheelScrollDelta> objectRef2, float f, MouseWheelScrollingLogic mouseWheelScrollingLogic, float f2, ScrollingLogic scrollingLogic, Continuation<? super C04033> continuation) {
            super(2, continuation);
            this.$targetValue = floatRef;
            this.$animationState = objectRef;
            this.$targetScrollDelta = objectRef2;
            this.$threshold = f;
            this.this$0 = mouseWheelScrollingLogic;
            this.$speed = f2;
            this.$this_dispatchMouseWheelScroll = scrollingLogic;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04033 c04033 = new C04033(this.$targetValue, this.$animationState, this.$targetScrollDelta, this.$threshold, this.this$0, this.$speed, this.$this_dispatchMouseWheelScroll, continuation);
            c04033.L$0 = obj;
            return c04033;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(NestedScrollScope nestedScrollScope, Continuation<? super Unit> continuation) {
            return ((C04033) create(nestedScrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0066 A[PHI: r8 r14
          0x0066: PHI (r8v2 androidx.compose.foundation.gestures.NestedScrollScope) = 
          (r8v1 androidx.compose.foundation.gestures.NestedScrollScope)
          (r8v3 androidx.compose.foundation.gestures.NestedScrollScope)
         binds: [B:26:0x012c, B:13:0x0065] A[DONT_GENERATE, DONT_INLINE]
          0x0066: PHI (r14v1 kotlin.jvm.internal.Ref$BooleanRef) = (r14v0 kotlin.jvm.internal.Ref$BooleanRef), (r14v2 kotlin.jvm.internal.Ref$BooleanRef) binds: [B:26:0x012c, B:13:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x012e  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x019a  */
        /* JADX WARN: Type inference failed for: r2v16, types: [T, androidx.compose.animation.core.AnimationState] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x012c -> B:14:0x0066). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0158 -> B:31:0x0159). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Ref.BooleanRef booleanRef;
            NestedScrollScope nestedScrollScope;
            final Ref.BooleanRef booleanRef2;
            Object objDispatchMouseWheelScroll$waitNextScrollDelta;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                NestedScrollScope nestedScrollScope2 = (NestedScrollScope) this.L$0;
                booleanRef = new Ref.BooleanRef();
                booleanRef.element = true;
                nestedScrollScope = nestedScrollScope2;
            } else if (i == 1) {
                Ref.BooleanRef booleanRef3 = (Ref.BooleanRef) this.L$2;
                booleanRef = (Ref.BooleanRef) this.L$1;
                NestedScrollScope nestedScrollScope3 = (NestedScrollScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                nestedScrollScope = nestedScrollScope3;
                booleanRef3.element = ((Boolean) obj).booleanValue();
            } else {
                if (i == 2) {
                    int i2 = this.I$0;
                    Ref.BooleanRef booleanRef4 = (Ref.BooleanRef) this.L$1;
                    NestedScrollScope nestedScrollScope4 = (NestedScrollScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    booleanRef2 = booleanRef4;
                    nestedScrollScope = nestedScrollScope4;
                    if (booleanRef2.element) {
                        this.L$0 = nestedScrollScope;
                        this.L$1 = booleanRef2;
                        this.L$2 = booleanRef2;
                        this.label = 3;
                        objDispatchMouseWheelScroll$waitNextScrollDelta = MouseWheelScrollingLogic.dispatchMouseWheelScroll$waitNextScrollDelta(this.this$0, this.$targetScrollDelta, this.$targetValue, this.$this_dispatchMouseWheelScroll, this.$animationState, 50 - ((long) i2), this);
                        if (objDispatchMouseWheelScroll$waitNextScrollDelta != coroutine_suspended) {
                            booleanRef = booleanRef2;
                            booleanRef2.element = ((Boolean) objDispatchMouseWheelScroll$waitNextScrollDelta).booleanValue();
                        }
                    } else if (!booleanRef2.element) {
                        booleanRef2.element = false;
                        float fFloatValue = this.$targetValue.element - this.$animationState.element.getValue().floatValue();
                        if (this.$targetScrollDelta.element.getShouldApplyImmediately() || Math.abs(fFloatValue) < this.$threshold) {
                            this.this$0.dispatchMouseWheelScroll(nestedScrollScope, fFloatValue);
                            this.L$0 = nestedScrollScope;
                            this.L$1 = booleanRef2;
                            this.L$2 = booleanRef2;
                            this.label = 1;
                            Object objDispatchMouseWheelScroll$waitNextScrollDelta2 = MouseWheelScrollingLogic.dispatchMouseWheelScroll$waitNextScrollDelta(this.this$0, this.$targetScrollDelta, this.$targetValue, this.$this_dispatchMouseWheelScroll, this.$animationState, 50L, this);
                            if (objDispatchMouseWheelScroll$waitNextScrollDelta2 != coroutine_suspended) {
                                booleanRef = booleanRef2;
                                booleanRef2.element = ((Boolean) objDispatchMouseWheelScroll$waitNextScrollDelta2).booleanValue();
                            }
                        } else {
                            float fSignum = Math.signum(fFloatValue) * this.$threshold;
                            this.this$0.dispatchMouseWheelScroll(nestedScrollScope, fSignum);
                            Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> objectRef = this.$animationState;
                            objectRef.element = AnimationStateKt.copy$default((AnimationState) objectRef.element, this.$animationState.element.getValue().floatValue() + fSignum, 0.0f, 0L, 0L, false, 30, (Object) null);
                            int iCoerceAtMost = RangesKt.coerceAtMost(MathKt.roundToInt(Math.abs(this.$targetValue.element - this.$animationState.element.getValue().floatValue()) / this.$speed), 100);
                            MouseWheelScrollingLogic mouseWheelScrollingLogic = this.this$0;
                            AnimationState<Float, AnimationVector1D> animationState = this.$animationState.element;
                            float f = this.$targetValue.element;
                            final MouseWheelScrollingLogic mouseWheelScrollingLogic2 = this.this$0;
                            final Ref.ObjectRef<MouseWheelScrollDelta> objectRef2 = this.$targetScrollDelta;
                            final Ref.FloatRef floatRef = this.$targetValue;
                            final ScrollingLogic scrollingLogic = this.$this_dispatchMouseWheelScroll;
                            this.L$0 = nestedScrollScope;
                            this.L$1 = booleanRef2;
                            this.L$2 = null;
                            this.I$0 = iCoerceAtMost;
                            this.label = 2;
                            if (mouseWheelScrollingLogic.animateMouseWheelScroll(nestedScrollScope, animationState, f, iCoerceAtMost, new Function1() { // from class: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$3$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return Boolean.valueOf(MouseWheelScrollingLogic.C04033.invokeSuspend$lambda$0(mouseWheelScrollingLogic2, objectRef2, floatRef, scrollingLogic, booleanRef2, ((Float) obj2).floatValue()));
                                }
                            }, this) != coroutine_suspended) {
                                i2 = iCoerceAtMost;
                                if (booleanRef2.element) {
                                }
                            }
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Ref.BooleanRef booleanRef5 = (Ref.BooleanRef) this.L$2;
                booleanRef = (Ref.BooleanRef) this.L$1;
                NestedScrollScope nestedScrollScope5 = (NestedScrollScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                booleanRef2 = booleanRef5;
                nestedScrollScope = nestedScrollScope5;
                objDispatchMouseWheelScroll$waitNextScrollDelta = obj;
                booleanRef2.element = ((Boolean) objDispatchMouseWheelScroll$waitNextScrollDelta).booleanValue();
            }
            booleanRef2 = booleanRef;
            if (!booleanRef2.element) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v4, types: [T, androidx.compose.foundation.gestures.MouseWheelScrollingLogic$MouseWheelScrollDelta] */
        public static final boolean invokeSuspend$lambda$0(MouseWheelScrollingLogic mouseWheelScrollingLogic, Ref.ObjectRef objectRef, Ref.FloatRef floatRef, ScrollingLogic scrollingLogic, Ref.BooleanRef booleanRef, float f) {
            MouseWheelScrollDelta mouseWheelScrollDeltaSumOrNull = mouseWheelScrollingLogic.sumOrNull(mouseWheelScrollingLogic.channel);
            if (mouseWheelScrollDeltaSumOrNull != null) {
                mouseWheelScrollingLogic.trackVelocity(mouseWheelScrollDeltaSumOrNull);
                objectRef.element = ((MouseWheelScrollDelta) objectRef.element).plus(mouseWheelScrollDeltaSumOrNull);
                floatRef.element = scrollingLogic.m2400toSingleAxisDeltaFromAnglek4lQ0M(scrollingLogic.m2396reverseIfNeededMKHz9U(((MouseWheelScrollDelta) objectRef.element).m2334getValueF1C5BW0()));
                booleanRef.element = !MouseWheelScrollingLogicKt.isLowScrollingDelta(floatRef.element - f);
            }
            return mouseWheelScrollDeltaSumOrNull != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateMouseWheelScroll(final NestedScrollScope nestedScrollScope, AnimationState<Float, AnimationVector1D> animationState, float f, int i, final Function1<? super Float, Boolean> function1, Continuation<? super Unit> continuation) {
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = animationState.getValue().floatValue();
        Object objAnimateTo = SuspendAnimationKt.animateTo(animationState, Boxing.boxFloat(f), AnimationSpecKt.tween$default(i, 0, EasingKt.getLinearEasing(), 2, null), true, new Function1() { // from class: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MouseWheelScrollingLogic.animateMouseWheelScroll$lambda$0(floatRef, this, nestedScrollScope, function1, (AnimationScope) obj);
            }
        }, continuation);
        return objAnimateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit animateMouseWheelScroll$lambda$0(Ref.FloatRef floatRef, MouseWheelScrollingLogic mouseWheelScrollingLogic, NestedScrollScope nestedScrollScope, Function1 function1, AnimationScope animationScope) {
        float fFloatValue = ((Number) animationScope.getValue()).floatValue() - floatRef.element;
        if (!MouseWheelScrollingLogicKt.isLowScrollingDelta(fFloatValue)) {
            if (!MouseWheelScrollingLogicKt.isLowScrollingDelta(fFloatValue - mouseWheelScrollingLogic.dispatchMouseWheelScroll(nestedScrollScope, fFloatValue))) {
                animationScope.cancelAnimation();
                return Unit.INSTANCE;
            }
            floatRef.element += fFloatValue;
        }
        if (((Boolean) function1.invoke(Float.valueOf(floatRef.element))).booleanValue()) {
            animationScope.cancelAnimation();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float dispatchMouseWheelScroll(NestedScrollScope nestedScrollScope, float f) {
        ScrollingLogic scrollingLogic = getScrollingLogic();
        return scrollingLogic.m2398toFloatk4lQ0M(scrollingLogic.m2396reverseIfNeededMKHz9U(nestedScrollScope.mo2335scrollByOzD1aCk(scrollingLogic.m2399toOffsettuRUvjQ(scrollingLogic.reverseIfNeeded(f)), NestedScrollSource.INSTANCE.m9361getUserInputWNlRxjI())));
    }
}
