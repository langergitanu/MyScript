package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p004ui.input.pointer.HistoricalChange;
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
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: compiled from: TrackpadScrollingLogic.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u00010BJ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00121\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010$\u001a\u0004\u0018\u00010\u001c*\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u001b\u0010%\u001a\u00020#*\u00020\u00032\u0006\u0010&\u001a\u00020'H\u0002¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u001cH\u0002J\u001a\u0010+\u001a\u00020\u000b*\u00020\u00032\u0006\u0010&\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010,J\u0014\u0010+\u001a\u00020-*\u00020.2\u0006\u0010/\u001a\u00020-H\u0002R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, m1599d2 = {"Landroidx/compose/foundation/gestures/TrackpadScrollingLogic;", "Landroidx/compose/foundation/gestures/NonTouchScrollingLogic;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "onScrollStopped", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Velocity;", "Lkotlin/ParameterName;", "name", "velocity", "Lkotlin/coroutines/Continuation;", "", "", "density", "Landroidx/compose/ui/unit/Density;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/unit/Density;)V", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TrackpadScrollingLogic$TrackpadScrollDelta;", "receivingPanEventsJob", "Lkotlinx/coroutines/Job;", "startReceivingEvents", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "onPan", "", "sumOrNull", "canConsumeDelta", "scrollDelta", "Landroidx/compose/ui/geometry/Offset;", "canConsumeDelta-Uv8p0NA", "(Landroidx/compose/foundation/gestures/ScrollingLogic;J)Z", "trackVelocity", "dispatchTrackpadScroll", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Landroidx/compose/foundation/gestures/TrackpadScrollingLogic$TrackpadScrollDelta;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "delta", "TrackpadScrollDelta", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TrackpadScrollingLogic extends NonTouchScrollingLogic {
    public static final int $stable = 8;
    private final Channel<TrackpadScrollDelta> channel;
    private Job receivingPanEventsJob;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TrackpadScrollingLogic$dispatchTrackpadScroll$1 */
    /* JADX INFO: compiled from: TrackpadScrollingLogic.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TrackpadScrollingLogic", m1609f = "TrackpadScrollingLogic.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_7_3, 190}, m1612m = "dispatchTrackpadScroll", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C04521 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C04521(Continuation<? super C04521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TrackpadScrollingLogic.this.dispatchTrackpadScroll(null, null, this);
        }
    }

    public TrackpadScrollingLogic(ScrollingLogic scrollingLogic, Function2<? super Velocity, ? super Continuation<? super Unit>, ? extends Object> function2, Density density) {
        super(scrollingLogic, function2, density);
        this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    }

    @Override // androidx.compose.foundation.gestures.NonTouchScrollingLogic
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo2330onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        if (ComposeFoundationFlags.isTrackpadGestureHandlingEnabled) {
            if (PointerEventType.m9432equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m9441getPanStart7fucELk()) || PointerEventType.m9432equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m9440getPanMove7fucELk()) || PointerEventType.m9432equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m9439getPanEnd7fucELk())) {
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                for (int i = 0; i < size; i++) {
                    if (changes.get(i).isConsumed()) {
                        return;
                    }
                }
                if (pass == PointerEventPass.Initial && getIsScrolling()) {
                    onPan(pointerEvent);
                    consume$foundation(pointerEvent);
                }
                if (pass == PointerEventPass.Main && !getIsScrolling() && onPan(pointerEvent)) {
                    consume$foundation(pointerEvent);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: TrackpadScrollingLogic.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0086\u0002R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0011"}, m1599d2 = {"Landroidx/compose/foundation/gestures/TrackpadScrollingLogic$TrackpadScrollDelta;", "", "value", "Landroidx/compose/ui/geometry/Offset;", "timeMillis", "", "isEnd", "", "<init>", "(JJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-F1C5BW0", "()J", "J", "getTimeMillis", "()Z", "plus", "other", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    static final class TrackpadScrollDelta {
        private final boolean isEnd;
        private final long timeMillis;
        private final long value;

        public /* synthetic */ TrackpadScrollDelta(long j, long j2, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, z);
        }

        private TrackpadScrollDelta(long j, long j2, boolean z) {
            this.value = j;
            this.timeMillis = j2;
            this.isEnd = z;
        }

        public final long getTimeMillis() {
            return this.timeMillis;
        }

        /* JADX INFO: renamed from: getValue-F1C5BW0, reason: not valid java name and from getter */
        public final long getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: isEnd, reason: from getter */
        public final boolean getIsEnd() {
            return this.isEnd;
        }

        public final TrackpadScrollDelta plus(TrackpadScrollDelta other) {
            return new TrackpadScrollDelta(Offset.m7908plusMKHz9U(this.value, other.value), Math.max(this.timeMillis, other.timeMillis), this.isEnd || other.isEnd, null);
        }
    }

    @Override // androidx.compose.foundation.gestures.NonTouchScrollingLogic
    public void startReceivingEvents(CoroutineScope coroutineScope) {
        if (this.receivingPanEventsJob == null) {
            this.receivingPanEventsJob = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C04541(null), 3, null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TrackpadScrollingLogic$startReceivingEvents$1 */
    /* JADX INFO: compiled from: TrackpadScrollingLogic.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TrackpadScrollingLogic$startReceivingEvents$1", m1609f = "TrackpadScrollingLogic.kt", m1610i = {0, 1}, m1611l = {99, 99}, m1612m = "invokeSuspend", m1613n = {"$this$launch", "$this$launch"}, m1615s = {"L$0", "L$0"}, m1616v = 1)
    static final class C04541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        C04541(Continuation<? super C04541> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04541 c04541 = TrackpadScrollingLogic.this.new C04541(continuation);
            c04541.L$0 = obj;
            return c04541;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0078 -> B:17:0x0039). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            CoroutineScope coroutineScope2;
            TrackpadScrollingLogic trackpadScrollingLogic;
            ScrollingLogic scrollingLogic;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = (CoroutineScope) this.L$0;
                } else {
                    if (i == 1) {
                        scrollingLogic = (ScrollingLogic) this.L$2;
                        trackpadScrollingLogic = (TrackpadScrollingLogic) this.L$1;
                        coroutineScope2 = (CoroutineScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        this.L$0 = coroutineScope2;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 2;
                        if (trackpadScrollingLogic.dispatchTrackpadScroll(scrollingLogic, (TrackpadScrollDelta) obj, this) != coroutine_suspended) {
                            coroutineScope = coroutineScope2;
                        }
                        return coroutine_suspended;
                    }
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = coroutineScope3;
                }
                if (!JobKt.isActive(coroutineScope.getCoroutineContext())) {
                    TrackpadScrollingLogic.this.receivingPanEventsJob = null;
                    return Unit.INSTANCE;
                }
                trackpadScrollingLogic = TrackpadScrollingLogic.this;
                scrollingLogic = trackpadScrollingLogic.getScrollingLogic();
                this.L$0 = coroutineScope;
                this.L$1 = trackpadScrollingLogic;
                this.L$2 = scrollingLogic;
                this.label = 1;
                Object objReceive = TrackpadScrollingLogic.this.channel.receive(this);
                if (objReceive == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope2 = coroutineScope;
                obj = objReceive;
                this.L$0 = coroutineScope2;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 2;
                if (trackpadScrollingLogic.dispatchTrackpadScroll(scrollingLogic, (TrackpadScrollDelta) obj, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            } catch (Throwable th) {
                TrackpadScrollingLogic.this.receivingPanEventsJob = null;
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean onPan(PointerEvent pointerEvent) {
        boolean z;
        if (!ComposeFoundationFlags.isTrackpadGestureHandlingEnabled) {
            return false;
        }
        PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.firstOrNull((List) pointerEvent.getChanges());
        if (pointerInputChange != null) {
            List<HistoricalChange> historical = pointerInputChange.getHistorical();
            int size = historical.size();
            z = false;
            for (int i = 0; i < size; i++) {
                HistoricalChange historicalChange = historical.get(i);
                long jM7895constructorimpl = Offset.m7895constructorimpl((-9223372034707292160L) ^ historicalChange.getPanOffset());
                if (m2421canConsumeDeltaUv8p0NA(getScrollingLogic(), jM7895constructorimpl)) {
                    z = ChannelResult.m16046isSuccessimpl(this.channel.mo16021trySendJP2dKIU(new TrackpadScrollDelta(jM7895constructorimpl, historicalChange.getUptimeMillis(), false, null))) || z;
                }
            }
            long jM7895constructorimpl2 = Offset.m7895constructorimpl(pointerInputChange.getPanOffset() ^ (-9223372034707292160L));
            boolean zM9432equalsimpl0 = PointerEventType.m9432equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m9439getPanEnd7fucELk());
            if (m2421canConsumeDeltaUv8p0NA(getScrollingLogic(), jM7895constructorimpl2) || zM9432equalsimpl0) {
                z = ChannelResult.m16046isSuccessimpl(this.channel.mo16021trySendJP2dKIU(new TrackpadScrollDelta(jM7895constructorimpl2, pointerInputChange.getUptimeMillis(), zM9432equalsimpl0, null))) || z;
            }
        }
        return z || getIsScrolling();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TrackpadScrollDelta sumOrNull(final Channel<TrackpadScrollDelta> channel) {
        TrackpadScrollDelta trackpadScrollDeltaPlus = null;
        for (TrackpadScrollDelta trackpadScrollDelta : NonTouchScrollingLogicKt.untilNull(new Function0() { // from class: androidx.compose.foundation.gestures.TrackpadScrollingLogic$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TrackpadScrollingLogic.sumOrNull$lambda$0(channel);
            }
        })) {
            trackpadScrollDeltaPlus = trackpadScrollDeltaPlus == null ? trackpadScrollDelta : trackpadScrollDeltaPlus.plus(trackpadScrollDelta);
        }
        return trackpadScrollDeltaPlus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TrackpadScrollDelta sumOrNull$lambda$0(Channel channel) {
        return (TrackpadScrollDelta) ChannelResult.m16041getOrNullimpl(channel.mo16029tryReceivePtdJZtk());
    }

    /* JADX INFO: renamed from: canConsumeDelta-Uv8p0NA, reason: not valid java name */
    private final boolean m2421canConsumeDeltaUv8p0NA(ScrollingLogic scrollingLogic, long j) {
        return !(scrollingLogic.m2400toSingleAxisDeltaFromAnglek4lQ0M(scrollingLogic.m2396reverseIfNeededMKHz9U(j)) == 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackVelocity(TrackpadScrollDelta scrollDelta) {
        getVelocityTracker().m2246addDeltaUv8p0NA(scrollDelta.getTimeMillis(), scrollDelta.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0082, code lost:
    
        if (r6.invoke(r7, r0) == r1) goto L24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r7v5, types: [T, androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object dispatchTrackpadScroll(ScrollingLogic scrollingLogic, TrackpadScrollDelta trackpadScrollDelta, Continuation<? super Unit> continuation) {
        C04521 c04521;
        if (continuation instanceof C04521) {
            c04521 = (C04521) continuation;
            if ((c04521.label & Integer.MIN_VALUE) != 0) {
                c04521.label -= Integer.MIN_VALUE;
            } else {
                c04521 = new C04521(continuation);
            }
        }
        Object obj = c04521.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c04521.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = trackpadScrollDelta;
            trackVelocity(trackpadScrollDelta);
            TrackpadScrollDelta trackpadScrollDeltaSumOrNull = sumOrNull(this.channel);
            if (trackpadScrollDeltaSumOrNull != null) {
                trackVelocity(trackpadScrollDeltaSumOrNull);
                objectRef.element = ((TrackpadScrollDelta) objectRef.element).plus(trackpadScrollDeltaSumOrNull);
            }
            Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> c04533 = new C04533(scrollingLogic, objectRef, null);
            c04521.label = 1;
            if (userScroll$foundation(c04533, c04521) != coroutine_suspended) {
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
        ResultKt.throwOnFailure(obj);
        Function2<Velocity, Continuation<? super Unit>, Object> onScrollStopped = getOnScrollStopped();
        Velocity velocityM11246boximpl = Velocity.m11246boximpl(getVelocityTracker().m2247calculateVelocity9UxMQ8M());
        c04521.label = 2;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TrackpadScrollingLogic$dispatchTrackpadScroll$3 */
    /* JADX INFO: compiled from: TrackpadScrollingLogic.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TrackpadScrollingLogic$dispatchTrackpadScroll$3", m1609f = "TrackpadScrollingLogic.kt", m1610i = {0}, m1611l = {178}, m1612m = "invokeSuspend", m1613n = {"$this$userScroll"}, m1615s = {"L$0"}, m1616v = 1)
    static final class C04533 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<TrackpadScrollDelta> $targetScrollDelta;
        final /* synthetic */ ScrollingLogic $this_dispatchTrackpadScroll;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04533(ScrollingLogic scrollingLogic, Ref.ObjectRef<TrackpadScrollDelta> objectRef, Continuation<? super C04533> continuation) {
            super(2, continuation);
            this.$this_dispatchTrackpadScroll = scrollingLogic;
            this.$targetScrollDelta = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04533 c04533 = TrackpadScrollingLogic.this.new C04533(this.$this_dispatchTrackpadScroll, this.$targetScrollDelta, continuation);
            c04533.L$0 = obj;
            return c04533;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(NestedScrollScope nestedScrollScope, Continuation<? super Unit> continuation) {
            return ((C04533) create(nestedScrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:11:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00a8  */
        /* JADX WARN: Type inference failed for: r7v16, types: [T, androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0061 -> B:14:0x0064). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            NestedScrollScope nestedScrollScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                NestedScrollScope nestedScrollScope2 = (NestedScrollScope) this.L$0;
                TrackpadScrollingLogic trackpadScrollingLogic = TrackpadScrollingLogic.this;
                ScrollingLogic scrollingLogic = this.$this_dispatchTrackpadScroll;
                trackpadScrollingLogic.dispatchTrackpadScroll(nestedScrollScope2, scrollingLogic.m2400toSingleAxisDeltaFromAnglek4lQ0M(scrollingLogic.m2396reverseIfNeededMKHz9U(this.$targetScrollDelta.element.getValue())));
                nestedScrollScope = nestedScrollScope2;
                if (!this.$targetScrollDelta.element.getIsEnd()) {
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Ref.ObjectRef<TrackpadScrollDelta> objectRef = (Ref.ObjectRef) this.L$1;
                nestedScrollScope = (NestedScrollScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                T t = obj;
                objectRef.element = t;
                TrackpadScrollingLogic.this.trackVelocity(this.$targetScrollDelta.element);
                TrackpadScrollingLogic trackpadScrollingLogic2 = TrackpadScrollingLogic.this;
                TrackpadScrollDelta trackpadScrollDeltaSumOrNull = trackpadScrollingLogic2.sumOrNull(trackpadScrollingLogic2.channel);
                if (trackpadScrollDeltaSumOrNull != null) {
                    TrackpadScrollingLogic trackpadScrollingLogic3 = TrackpadScrollingLogic.this;
                    Ref.ObjectRef<TrackpadScrollDelta> objectRef2 = this.$targetScrollDelta;
                    trackpadScrollingLogic3.trackVelocity(trackpadScrollDeltaSumOrNull);
                    objectRef2.element = objectRef2.element.plus(trackpadScrollDeltaSumOrNull);
                }
                TrackpadScrollingLogic trackpadScrollingLogic4 = TrackpadScrollingLogic.this;
                ScrollingLogic scrollingLogic2 = this.$this_dispatchTrackpadScroll;
                trackpadScrollingLogic4.dispatchTrackpadScroll(nestedScrollScope, scrollingLogic2.m2400toSingleAxisDeltaFromAnglek4lQ0M(scrollingLogic2.m2396reverseIfNeededMKHz9U(this.$targetScrollDelta.element.getValue())));
                if (!this.$targetScrollDelta.element.getIsEnd()) {
                    objectRef = this.$targetScrollDelta;
                    this.L$0 = nestedScrollScope;
                    this.L$1 = objectRef;
                    this.label = 1;
                    Object objBusyReceive = NonTouchScrollingLogicKt.busyReceive(TrackpadScrollingLogic.this.channel, this);
                    t = objBusyReceive;
                    if (objBusyReceive == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef.element = t;
                    TrackpadScrollingLogic.this.trackVelocity(this.$targetScrollDelta.element);
                    TrackpadScrollingLogic trackpadScrollingLogic22 = TrackpadScrollingLogic.this;
                    TrackpadScrollDelta trackpadScrollDeltaSumOrNull2 = trackpadScrollingLogic22.sumOrNull(trackpadScrollingLogic22.channel);
                    if (trackpadScrollDeltaSumOrNull2 != null) {
                    }
                    TrackpadScrollingLogic trackpadScrollingLogic42 = TrackpadScrollingLogic.this;
                    ScrollingLogic scrollingLogic22 = this.$this_dispatchTrackpadScroll;
                    trackpadScrollingLogic42.dispatchTrackpadScroll(nestedScrollScope, scrollingLogic22.m2400toSingleAxisDeltaFromAnglek4lQ0M(scrollingLogic22.m2396reverseIfNeededMKHz9U(this.$targetScrollDelta.element.getValue())));
                    if (!this.$targetScrollDelta.element.getIsEnd()) {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float dispatchTrackpadScroll(NestedScrollScope nestedScrollScope, float f) {
        ScrollingLogic scrollingLogic = getScrollingLogic();
        return scrollingLogic.m2398toFloatk4lQ0M(scrollingLogic.m2396reverseIfNeededMKHz9U(nestedScrollScope.mo2336scrollByWithOverscrollOzD1aCk(scrollingLogic.m2399toOffsettuRUvjQ(scrollingLogic.reverseIfNeeded(f)), NestedScrollSource.INSTANCE.m9361getUserInputWNlRxjI())));
    }
}
