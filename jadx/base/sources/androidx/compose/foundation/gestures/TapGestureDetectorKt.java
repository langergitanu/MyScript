package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.LongPressResult;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p004ui.input.pointer.PointerEvent;
import androidx.compose.p004ui.input.pointer.PointerEventKt;
import androidx.compose.p004ui.input.pointer.PointerEventPass;
import androidx.compose.p004ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.p004ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.p004ui.input.pointer.PointerInputChange;
import androidx.compose.p004ui.input.pointer.PointerInputScope;
import androidx.compose.p004ui.input.pointer.PointerType;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.p007ts.TsExtractor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.location.LocationRequest;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.apache.http.HttpStatus;

/* JADX INFO: compiled from: TapGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u008b\u0001\u0010\t\u001a\u00020\u0005*\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2/\b\u0002\u0010\u000e\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0086@¢\u0006\u0002\u0010\u0010\u001a\u0093\u0001\u0010\u0011\u001a\u00020\u0005*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2-\u0010\u000e\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0080@¢\u0006\u0002\u0010\u0017\u001a\u0012\u0010\u0018\u001a\u00020\u0005*\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001d\u001a[\u0010\u001e\u001a\u00020\u0005*\u00020\n2/\b\u0002\u0010\u000e\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0080@¢\u0006\u0002\u0010\u001f\u001a\u001c\u0010 \u001a\u00020\u001b*\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\"H\u0087@¢\u0006\u0002\u0010#\u001a&\u0010 \u001a\u00020\u001b*\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020%H\u0086@¢\u0006\u0002\u0010&\u001a&\u0010'\u001a\u00020\u001b*\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020%H\u0080@¢\u0006\u0002\u0010&\u001a\u001e\u0010(\u001a\u00020\"*\u00020)2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010*\u001a\u00020\"H\u0000\u001a\u0014\u0010+\u001a\u0004\u0018\u00010\u001b*\u00020\u0012H\u0087@¢\u0006\u0002\u0010\u0019\u001a\u001e\u0010+\u001a\u0004\u0018\u00010\u001b*\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%H\u0086@¢\u0006\u0002\u0010,\u001a\u001c\u0010-\u001a\u00020.*\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%H\u0080@¢\u0006\u0002\u0010,\u001aL\u0010/\u001a\u000200*\u00020\u00142\u0006\u00101\u001a\u0002002\b\b\u0002\u00102\u001a\u0002032'\u00104\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000605¢\u0006\u0002\b\u0007H\u0002¢\u0006\u0002\u00106\"7\u0010\u0000\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u00067"}, m1599d2 = {"NoPressGesture", "Lkotlin/Function3;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "detectTapGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDoubleTap", "Lkotlin/Function1;", "onLongPress", "onPress", "onTap", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processTapGesture", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "pressScope", "Landroidx/compose/foundation/gestures/PressGestureScopeImpl;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/PressGestureScopeImpl;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeUntilUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSecondDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "firstUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapAndPress", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstDown", "requireUnconsumed", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLandroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPrimaryFirstDown", "isChangedToDown", "Landroidx/compose/ui/input/pointer/PointerEvent;", "onlyPrimaryMouseButton", "waitForUpOrCancellation", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForLongPress", "Landroidx/compose/foundation/gestures/LongPressResult;", "launchAwaitingReset", "Lkotlinx/coroutines/Job;", "resetJob", TtmlNode.START, "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/Job;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TapGestureDetectorKt {
    private static final Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> NoPressGesture = new TapGestureDetectorKt$NoPressGesture$1(null);

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", m1609f = "TapGestureDetector.kt", m1610i = {0, 0, 0}, m1611l = {TypedValues.AttributesType.TYPE_EASING}, m1612m = "awaitFirstDown", m1613n = {"$this$awaitFirstDown", "pass", "requireUnconsumed"}, m1615s = {"L$0", "L$1", "Z$0"}, m1616v = 1)
    static final class C04332 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C04332(Continuation<? super C04332> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.awaitFirstDown(null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", m1609f = "TapGestureDetector.kt", m1610i = {0, 0, 0}, m1611l = {330}, m1612m = "awaitPrimaryFirstDown", m1613n = {"$this$awaitPrimaryFirstDown", "pass", "requireUnconsumed"}, m1615s = {"L$0", "L$1", "Z$0"}, m1616v = 1)
    static final class C04341 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C04341(Continuation<? super C04341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.awaitPrimaryFirstDown(null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", m1609f = "TapGestureDetector.kt", m1610i = {0}, m1611l = {236}, m1612m = "consumeUntilUp", m1613n = {"$this$consumeUntilUp"}, m1615s = {"L$0"}, m1616v = 1)
    static final class C04361 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04361(Continuation<? super C04361> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.consumeUntilUp(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$1 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", m1609f = "TapGestureDetector.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7}, m1611l = {PDFACompliance.e_PDFA1_3_1, PDFACompliance.e_PDFA1_4_2, 145, 148, 176, 194, 196, 207}, m1612m = "processTapGesture", m1613n = {"$this$processTapGesture", "scope", "pressScope", "onDoubleTap", "onLongPress", "onPress", "onTap", "$this$processTapGesture", "scope", "pressScope", "onDoubleTap", "onLongPress", "onPress", "onTap", "resetJob", "$this$processTapGesture", "scope", "pressScope", "onDoubleTap", "onLongPress", "onPress", "onTap", "down", "resetJob", "scope", "pressScope", "resetJob", "$this$processTapGesture", "scope", "pressScope", "onDoubleTap", "onLongPress", "onPress", "onTap", "upOrCancel", "cancelOrReleaseJob", "scope", "pressScope", "onDoubleTap", "onTap", "resetJob", "upOrCancel", "$this$processTapGesture", "scope", "pressScope", "onDoubleTap", "onLongPress", "onTap", "resetJob", "upOrCancel", "secondDown", "scope", "pressScope", "resetJob"}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2"}, m1616v = 1)
    static final class C04401 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C04401(Continuation<? super C04401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.processTapGesture(null, null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$1 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", m1609f = "TapGestureDetector.kt", m1610i = {0}, m1611l = {HttpStatus.SC_GONE}, m1612m = "waitForLongPress", m1613n = {"result"}, m1615s = {"L$0"}, m1616v = 1)
    static final class C04491 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04491(Continuation<? super C04491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.waitForLongPress(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", m1609f = "TapGestureDetector.kt", m1610i = {0, 0, 1, 1}, m1611l = {378, 392}, m1612m = "waitForUpOrCancellation", m1613n = {"$this$waitForUpOrCancellation", "pass", "$this$waitForUpOrCancellation", "pass"}, m1615s = {"L$0", "L$1", "L$0", "L$1"}, m1616v = 1)
    static final class C04512 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C04512(Continuation<? super C04512> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.waitForUpOrCancellation(null, null, this);
        }
    }

    public static /* synthetic */ Object detectTapGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function1 function12, Function3 function3, Function1 function13, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function12 = null;
        }
        if ((i & 4) != 0) {
            function3 = NoPressGesture;
        }
        if ((i & 8) != 0) {
            function13 = null;
        }
        return detectTapGestures(pointerInputScope, function1, function12, function3, function13, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2", m1609f = "TapGestureDetector.kt", m1610i = {}, m1611l = {104}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C04382 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
        final /* synthetic */ Function1<Offset, Unit> $onLongPress;
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ Function1<Offset, Unit> $onTap;
        final /* synthetic */ PointerInputScope $this_detectTapGestures;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C04382(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function13, Continuation<? super C04382> continuation) {
            super(2, continuation);
            this.$this_detectTapGestures = pointerInputScope;
            this.$onDoubleTap = function1;
            this.$onLongPress = function12;
            this.$onPress = function3;
            this.$onTap = function13;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04382 c04382 = new C04382(this.$this_detectTapGestures, this.$onDoubleTap, this.$onLongPress, this.$onPress, this.$onTap, continuation);
            c04382.L$0 = obj;
            return c04382;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04382) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                PressGestureScopeImpl pressGestureScopeImpl = new PressGestureScopeImpl(this.$this_detectTapGestures);
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(this.$this_detectTapGestures, new AnonymousClass1(coroutineScope, pressGestureScopeImpl, this.$onDoubleTap, this.$onLongPress, this.$onPress, this.$onTap, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TapGestureDetector.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1", m1609f = "TapGestureDetector.kt", m1610i = {}, m1611l = {LocationRequest.PRIORITY_NO_POWER}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
        static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
            final /* synthetic */ Function1<Offset, Unit> $onLongPress;
            final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ Function1<Offset, Unit> $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(CoroutineScope coroutineScope, PressGestureScopeImpl pressGestureScopeImpl, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function13, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.$pressScope = pressGestureScopeImpl;
                this.$onDoubleTap = function1;
                this.$onLongPress = function12;
                this.$onPress = function3;
                this.$onTap = function13;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$coroutineScope, this.$pressScope, this.$onDoubleTap, this.$onLongPress, this.$onPress, this.$onTap, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (TapGestureDetectorKt.processTapGesture((AwaitPointerEventScope) this.L$0, this.$$this$coroutineScope, this.$pressScope, this.$onDoubleTap, this.$onLongPress, this.$onPress, this.$onTap, this) == coroutine_suspended) {
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

    public static final Object detectTapGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function13, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C04382(pointerInputScope, function1, function12, function3, function13, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x041f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object processTapGesture(AwaitPointerEventScope awaitPointerEventScope, CoroutineScope coroutineScope, PressGestureScopeImpl pressGestureScopeImpl, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function13, Continuation<? super Unit> continuation) {
        C04401 c04401;
        Function1<? super Offset, Unit> function14;
        Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function32;
        Function1<? super Offset, Unit> function15;
        PressGestureScopeImpl pressGestureScopeImpl2;
        Function1<? super Offset, Unit> function16;
        AwaitPointerEventScope awaitPointerEventScope2;
        CoroutineScope coroutineScope2;
        PointerInputChange pointerInputChange;
        Job job;
        Function1<? super Offset, Unit> function17;
        Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function33;
        AwaitPointerEventScope awaitPointerEventScope3;
        PressGestureScopeImpl pressGestureScopeImpl3;
        Function1<? super Offset, Unit> function18;
        Function1<? super Offset, Unit> function19;
        Function1<? super Offset, Unit> function110;
        Function1<? super Offset, Unit> function111;
        AwaitPointerEventScope awaitPointerEventScope4;
        CoroutineScope coroutineScope3;
        PressGestureScopeImpl pressGestureScopeImpl4;
        Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function34;
        Function1<? super Offset, Unit> function112;
        PointerInputChange finalUpChange;
        Job jobLaunchAwaitingReset$default;
        PointerInputChange pointerInputChange2;
        AwaitPointerEventScope awaitPointerEventScope5;
        CoroutineScope coroutineScope4;
        Function1<? super Offset, Unit> function113;
        Function1<? super Offset, Unit> function114;
        Function1<? super Offset, Unit> function115;
        PressGestureScopeImpl pressGestureScopeImpl5;
        LongPressResult longPressResult;
        Job job2;
        CoroutineScope coroutineScope5;
        PressGestureScopeImpl pressGestureScopeImpl6;
        PointerInputChange pointerInputChange3;
        Job jobLaunch$default;
        PointerInputChange pointerInputChange4;
        PointerInputChange pointerInputChange5;
        PressGestureScopeImpl pressGestureScopeImpl7;
        Function1<? super Offset, Unit> function116;
        Function1<? super Offset, Unit> function117;
        Function1<? super Offset, Unit> function118;
        CoroutineScope coroutineScope6;
        AwaitPointerEventScope awaitPointerEventScope6;
        PointerInputChange pointerInputChange6;
        Function1<? super Offset, Unit> function119;
        Function1<? super Offset, Unit> function120;
        CoroutineScope coroutineScope7;
        PointerInputChange finalUpChange2;
        LongPressResult longPressResult2;
        Job job3;
        PressGestureScopeImpl pressGestureScopeImpl8;
        CoroutineScope coroutineScope8;
        if (continuation instanceof C04401) {
            c04401 = (C04401) continuation;
            if ((c04401.label & Integer.MIN_VALUE) != 0) {
                c04401.label -= Integer.MIN_VALUE;
            } else {
                c04401 = new C04401(continuation);
            }
        }
        C04401 c044012 = c04401;
        Object objWaitForLongPress$default = c044012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c044012.label) {
            case 0:
                ResultKt.throwOnFailure(objWaitForLongPress$default);
                c044012.L$0 = awaitPointerEventScope;
                c044012.L$1 = coroutineScope;
                c044012.L$2 = pressGestureScopeImpl;
                c044012.L$3 = function1;
                function14 = function12;
                c044012.L$4 = function14;
                function32 = function3;
                c044012.L$5 = function32;
                function15 = function13;
                c044012.L$6 = function15;
                c044012.label = 1;
                Object objAwaitFirstDown$default = awaitFirstDown$default(awaitPointerEventScope, false, null, c044012, 3, null);
                if (objAwaitFirstDown$default != coroutine_suspended) {
                    pressGestureScopeImpl2 = pressGestureScopeImpl;
                    function16 = function1;
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    coroutineScope2 = coroutineScope;
                    objWaitForLongPress$default = objAwaitFirstDown$default;
                    pointerInputChange = (PointerInputChange) objWaitForLongPress$default;
                    pointerInputChange.consume();
                    Job jobLaunch$default2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, CoroutineStart.UNDISPATCHED, new TapGestureDetectorKt$processTapGesture$resetJob$1(pressGestureScopeImpl2, null), 1, null);
                    if (function32 == NoPressGesture) {
                        launchAwaitingReset$default(coroutineScope2, jobLaunch$default2, null, new C04412(function32, pressGestureScopeImpl2, pointerInputChange, null), 2, null);
                        job = jobLaunch$default2;
                    } else {
                        job = jobLaunch$default2;
                    }
                    if (function14 != null) {
                        c044012.L$0 = awaitPointerEventScope2;
                        c044012.L$1 = coroutineScope2;
                        c044012.L$2 = pressGestureScopeImpl2;
                        c044012.L$3 = function16;
                        c044012.L$4 = function14;
                        c044012.L$5 = function32;
                        c044012.L$6 = function15;
                        c044012.L$7 = job;
                        c044012.label = 2;
                        objWaitForLongPress$default = waitForUpOrCancellation$default(awaitPointerEventScope2, null, c044012, 1, null);
                        if (objWaitForLongPress$default != coroutine_suspended) {
                            PressGestureScopeImpl pressGestureScopeImpl9 = pressGestureScopeImpl2;
                            function110 = function16;
                            function111 = function14;
                            awaitPointerEventScope4 = awaitPointerEventScope2;
                            coroutineScope3 = coroutineScope2;
                            pressGestureScopeImpl4 = pressGestureScopeImpl9;
                            function34 = function32;
                            function112 = function15;
                            finalUpChange = (PointerInputChange) objWaitForLongPress$default;
                            if (finalUpChange == null) {
                                jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope3, job, null, new C04434(pressGestureScopeImpl4, null), 2, null);
                            } else {
                                finalUpChange.consume();
                                jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope3, job, null, new C04445(pressGestureScopeImpl4, null), 2, null);
                            }
                            if (finalUpChange != null) {
                                if (function110 != null) {
                                    c044012.L$0 = awaitPointerEventScope4;
                                    c044012.L$1 = coroutineScope3;
                                    c044012.L$2 = pressGestureScopeImpl4;
                                    c044012.L$3 = function110;
                                    c044012.L$4 = function111;
                                    c044012.L$5 = function34;
                                    c044012.L$6 = function112;
                                    c044012.L$7 = finalUpChange;
                                    c044012.L$8 = jobLaunchAwaitingReset$default;
                                    c044012.label = 5;
                                    Object objAwaitSecondDown = awaitSecondDown(awaitPointerEventScope4, finalUpChange, c044012);
                                    if (objAwaitSecondDown != coroutine_suspended) {
                                        Function1<? super Offset, Unit> function121 = function112;
                                        pointerInputChange2 = finalUpChange;
                                        objWaitForLongPress$default = objAwaitSecondDown;
                                        awaitPointerEventScope5 = awaitPointerEventScope4;
                                        coroutineScope4 = coroutineScope3;
                                        function113 = function110;
                                        function114 = function121;
                                        PressGestureScopeImpl pressGestureScopeImpl10 = pressGestureScopeImpl4;
                                        function115 = function111;
                                        pressGestureScopeImpl5 = pressGestureScopeImpl10;
                                        pointerInputChange3 = (PointerInputChange) objWaitForLongPress$default;
                                        if (pointerInputChange3 == null) {
                                            jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, CoroutineStart.UNDISPATCHED, new C04456(jobLaunchAwaitingReset$default, pressGestureScopeImpl5, null), 1, null);
                                            if (function34 != NoPressGesture) {
                                                launchAwaitingReset$default(coroutineScope4, jobLaunch$default, null, new C04467(function34, pressGestureScopeImpl5, pointerInputChange3, null), 2, null);
                                            }
                                            if (function115 == null) {
                                                c044012.L$0 = coroutineScope4;
                                                c044012.L$1 = pressGestureScopeImpl5;
                                                c044012.L$2 = function113;
                                                c044012.L$3 = function114;
                                                c044012.L$4 = jobLaunch$default;
                                                c044012.L$5 = pointerInputChange2;
                                                c044012.L$6 = null;
                                                c044012.L$7 = null;
                                                c044012.L$8 = null;
                                                c044012.label = 6;
                                                objWaitForLongPress$default = waitForUpOrCancellation$default(awaitPointerEventScope5, null, c044012, 1, null);
                                                if (objWaitForLongPress$default != coroutine_suspended) {
                                                    pointerInputChange6 = pointerInputChange2;
                                                    function119 = function114;
                                                    function120 = function113;
                                                    coroutineScope7 = coroutineScope4;
                                                    finalUpChange2 = (PointerInputChange) objWaitForLongPress$default;
                                                    if (finalUpChange2 != null) {
                                                        finalUpChange2.consume();
                                                        launchAwaitingReset$default(coroutineScope7, jobLaunch$default, null, new C04478(pressGestureScopeImpl5, null), 2, null);
                                                        function120.invoke(Offset.m7892boximpl(finalUpChange2.getPosition()));
                                                    } else {
                                                        launchAwaitingReset$default(coroutineScope7, jobLaunch$default, null, new C04489(pressGestureScopeImpl5, null), 2, null);
                                                        if (function119 != null) {
                                                            function119.invoke(Offset.m7892boximpl(pointerInputChange6.getPosition()));
                                                        }
                                                    }
                                                }
                                            } else {
                                                c044012.L$0 = awaitPointerEventScope5;
                                                c044012.L$1 = coroutineScope4;
                                                c044012.L$2 = pressGestureScopeImpl5;
                                                c044012.L$3 = function113;
                                                c044012.L$4 = function115;
                                                c044012.L$5 = function114;
                                                c044012.L$6 = jobLaunch$default;
                                                c044012.L$7 = pointerInputChange2;
                                                c044012.L$8 = pointerInputChange3;
                                                c044012.label = 7;
                                                Object objWaitForLongPress$default2 = waitForLongPress$default(awaitPointerEventScope5, null, c044012, 1, null);
                                                if (objWaitForLongPress$default2 != coroutine_suspended) {
                                                    PointerInputChange pointerInputChange7 = pointerInputChange2;
                                                    pointerInputChange4 = pointerInputChange3;
                                                    objWaitForLongPress$default = objWaitForLongPress$default2;
                                                    pointerInputChange5 = pointerInputChange7;
                                                    Function1<? super Offset, Unit> function122 = function115;
                                                    pressGestureScopeImpl7 = pressGestureScopeImpl5;
                                                    function116 = function114;
                                                    function117 = function122;
                                                    function118 = function113;
                                                    coroutineScope6 = coroutineScope4;
                                                    awaitPointerEventScope6 = awaitPointerEventScope5;
                                                    longPressResult2 = (LongPressResult) objWaitForLongPress$default;
                                                    if (Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                                                        if (longPressResult2 instanceof LongPressResult.Released) {
                                                            finalUpChange2 = ((LongPressResult.Released) longPressResult2).getFinalUpChange();
                                                            pointerInputChange6 = pointerInputChange5;
                                                            function119 = function116;
                                                            function120 = function118;
                                                        } else {
                                                            if (!(longPressResult2 instanceof LongPressResult.Canceled)) {
                                                                throw new NoWhenBranchMatchedException();
                                                            }
                                                            pointerInputChange6 = pointerInputChange5;
                                                            function119 = function116;
                                                            function120 = function118;
                                                            finalUpChange2 = null;
                                                        }
                                                        pressGestureScopeImpl5 = pressGestureScopeImpl7;
                                                        coroutineScope7 = coroutineScope6;
                                                        if (finalUpChange2 != null) {
                                                        }
                                                    } else {
                                                        function117.invoke(Offset.m7892boximpl(pointerInputChange4.getPosition()));
                                                        c044012.L$0 = coroutineScope6;
                                                        c044012.L$1 = pressGestureScopeImpl7;
                                                        c044012.L$2 = jobLaunch$default;
                                                        c044012.L$3 = null;
                                                        c044012.L$4 = null;
                                                        c044012.L$5 = null;
                                                        c044012.L$6 = null;
                                                        c044012.L$7 = null;
                                                        c044012.L$8 = null;
                                                        c044012.label = 8;
                                                        if (consumeUntilUp(awaitPointerEventScope6, c044012) != coroutine_suspended) {
                                                            job3 = jobLaunch$default;
                                                            pressGestureScopeImpl8 = pressGestureScopeImpl7;
                                                            coroutineScope8 = coroutineScope6;
                                                            launchAwaitingReset$default(coroutineScope8, job3, null, new TapGestureDetectorKt$processTapGesture$secondUp$1(pressGestureScopeImpl8, null), 2, null);
                                                            return Unit.INSTANCE;
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (function114 != null) {
                                            function114.invoke(Offset.m7892boximpl(pointerInputChange2.getPosition()));
                                        }
                                    }
                                } else if (function112 != null) {
                                    function112.invoke(Offset.m7892boximpl(finalUpChange.getPosition()));
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    } else {
                        c044012.L$0 = awaitPointerEventScope2;
                        c044012.L$1 = coroutineScope2;
                        c044012.L$2 = pressGestureScopeImpl2;
                        c044012.L$3 = function16;
                        c044012.L$4 = function14;
                        c044012.L$5 = function32;
                        c044012.L$6 = function15;
                        c044012.L$7 = pointerInputChange;
                        c044012.L$8 = job;
                        c044012.label = 3;
                        objWaitForLongPress$default = waitForLongPress$default(awaitPointerEventScope2, null, c044012, 1, null);
                        if (objWaitForLongPress$default != coroutine_suspended) {
                            Function1<? super Offset, Unit> function123 = function14;
                            function17 = function16;
                            function33 = function32;
                            awaitPointerEventScope3 = awaitPointerEventScope2;
                            pressGestureScopeImpl3 = pressGestureScopeImpl2;
                            function18 = function123;
                            function19 = function15;
                            longPressResult = (LongPressResult) objWaitForLongPress$default;
                            if (Intrinsics.areEqual(longPressResult, LongPressResult.Success.INSTANCE)) {
                                if (longPressResult instanceof LongPressResult.Released) {
                                    finalUpChange = ((LongPressResult.Released) longPressResult).getFinalUpChange();
                                } else {
                                    if (!(longPressResult instanceof LongPressResult.Canceled)) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    finalUpChange = null;
                                }
                                PressGestureScopeImpl pressGestureScopeImpl11 = pressGestureScopeImpl3;
                                coroutineScope3 = coroutineScope2;
                                pressGestureScopeImpl4 = pressGestureScopeImpl11;
                                function112 = function19;
                                function34 = function33;
                                function111 = function18;
                                function110 = function17;
                                awaitPointerEventScope4 = awaitPointerEventScope3;
                                if (finalUpChange == null) {
                                }
                                if (finalUpChange != null) {
                                }
                                return Unit.INSTANCE;
                            }
                            function18.invoke(Offset.m7892boximpl(pointerInputChange.getPosition()));
                            c044012.L$0 = coroutineScope2;
                            c044012.L$1 = pressGestureScopeImpl3;
                            c044012.L$2 = job;
                            c044012.L$3 = null;
                            c044012.L$4 = null;
                            c044012.L$5 = null;
                            c044012.L$6 = null;
                            c044012.L$7 = null;
                            c044012.L$8 = null;
                            c044012.label = 4;
                            if (consumeUntilUp(awaitPointerEventScope3, c044012) != coroutine_suspended) {
                                job2 = job;
                                coroutineScope5 = coroutineScope2;
                                pressGestureScopeImpl6 = pressGestureScopeImpl3;
                                launchAwaitingReset$default(coroutineScope5, job2, null, new C04423(pressGestureScopeImpl6, null), 2, null);
                                return Unit.INSTANCE;
                            }
                        }
                    }
                }
                return coroutine_suspended;
            case 1:
                Function1<? super Offset, Unit> function124 = (Function1) c044012.L$6;
                Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function35 = (Function3) c044012.L$5;
                Function1<? super Offset, Unit> function125 = (Function1) c044012.L$4;
                function16 = (Function1) c044012.L$3;
                pressGestureScopeImpl2 = (PressGestureScopeImpl) c044012.L$2;
                coroutineScope2 = (CoroutineScope) c044012.L$1;
                awaitPointerEventScope2 = (AwaitPointerEventScope) c044012.L$0;
                ResultKt.throwOnFailure(objWaitForLongPress$default);
                function15 = function124;
                function32 = function35;
                function14 = function125;
                pointerInputChange = (PointerInputChange) objWaitForLongPress$default;
                pointerInputChange.consume();
                Job jobLaunch$default22 = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, CoroutineStart.UNDISPATCHED, new TapGestureDetectorKt$processTapGesture$resetJob$1(pressGestureScopeImpl2, null), 1, null);
                if (function32 == NoPressGesture) {
                }
                if (function14 != null) {
                }
                return coroutine_suspended;
            case 2:
                job = (Job) c044012.L$7;
                function112 = (Function1) c044012.L$6;
                function34 = (Function3) c044012.L$5;
                function111 = (Function1) c044012.L$4;
                function110 = (Function1) c044012.L$3;
                pressGestureScopeImpl4 = (PressGestureScopeImpl) c044012.L$2;
                coroutineScope3 = (CoroutineScope) c044012.L$1;
                awaitPointerEventScope4 = (AwaitPointerEventScope) c044012.L$0;
                ResultKt.throwOnFailure(objWaitForLongPress$default);
                finalUpChange = (PointerInputChange) objWaitForLongPress$default;
                if (finalUpChange == null) {
                }
                if (finalUpChange != null) {
                }
                return Unit.INSTANCE;
            case 3:
                job = (Job) c044012.L$8;
                pointerInputChange = (PointerInputChange) c044012.L$7;
                function19 = (Function1) c044012.L$6;
                function33 = (Function3) c044012.L$5;
                function18 = (Function1) c044012.L$4;
                Function1<? super Offset, Unit> function126 = (Function1) c044012.L$3;
                pressGestureScopeImpl3 = (PressGestureScopeImpl) c044012.L$2;
                CoroutineScope coroutineScope9 = (CoroutineScope) c044012.L$1;
                awaitPointerEventScope3 = (AwaitPointerEventScope) c044012.L$0;
                ResultKt.throwOnFailure(objWaitForLongPress$default);
                function17 = function126;
                coroutineScope2 = coroutineScope9;
                longPressResult = (LongPressResult) objWaitForLongPress$default;
                if (Intrinsics.areEqual(longPressResult, LongPressResult.Success.INSTANCE)) {
                }
                break;
            case 4:
                job2 = (Job) c044012.L$2;
                pressGestureScopeImpl6 = (PressGestureScopeImpl) c044012.L$1;
                coroutineScope5 = (CoroutineScope) c044012.L$0;
                ResultKt.throwOnFailure(objWaitForLongPress$default);
                launchAwaitingReset$default(coroutineScope5, job2, null, new C04423(pressGestureScopeImpl6, null), 2, null);
                return Unit.INSTANCE;
            case 5:
                jobLaunchAwaitingReset$default = (Job) c044012.L$8;
                pointerInputChange2 = (PointerInputChange) c044012.L$7;
                Function1<? super Offset, Unit> function127 = (Function1) c044012.L$6;
                Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function36 = (Function3) c044012.L$5;
                Function1<? super Offset, Unit> function128 = (Function1) c044012.L$4;
                Function1<? super Offset, Unit> function129 = (Function1) c044012.L$3;
                PressGestureScopeImpl pressGestureScopeImpl12 = (PressGestureScopeImpl) c044012.L$2;
                coroutineScope4 = (CoroutineScope) c044012.L$1;
                awaitPointerEventScope5 = (AwaitPointerEventScope) c044012.L$0;
                ResultKt.throwOnFailure(objWaitForLongPress$default);
                function114 = function127;
                function34 = function36;
                pressGestureScopeImpl5 = pressGestureScopeImpl12;
                function113 = function129;
                function115 = function128;
                pointerInputChange3 = (PointerInputChange) objWaitForLongPress$default;
                if (pointerInputChange3 == null) {
                }
                break;
            case 6:
                pointerInputChange6 = (PointerInputChange) c044012.L$5;
                jobLaunch$default = (Job) c044012.L$4;
                function119 = (Function1) c044012.L$3;
                function120 = (Function1) c044012.L$2;
                pressGestureScopeImpl5 = (PressGestureScopeImpl) c044012.L$1;
                coroutineScope7 = (CoroutineScope) c044012.L$0;
                ResultKt.throwOnFailure(objWaitForLongPress$default);
                finalUpChange2 = (PointerInputChange) objWaitForLongPress$default;
                if (finalUpChange2 != null) {
                }
                return Unit.INSTANCE;
            case 7:
                PointerInputChange pointerInputChange8 = (PointerInputChange) c044012.L$8;
                PointerInputChange pointerInputChange9 = (PointerInputChange) c044012.L$7;
                Job job4 = (Job) c044012.L$6;
                function116 = (Function1) c044012.L$5;
                function117 = (Function1) c044012.L$4;
                function118 = (Function1) c044012.L$3;
                pressGestureScopeImpl7 = (PressGestureScopeImpl) c044012.L$2;
                coroutineScope6 = (CoroutineScope) c044012.L$1;
                awaitPointerEventScope6 = (AwaitPointerEventScope) c044012.L$0;
                ResultKt.throwOnFailure(objWaitForLongPress$default);
                pointerInputChange4 = pointerInputChange8;
                jobLaunch$default = job4;
                pointerInputChange5 = pointerInputChange9;
                longPressResult2 = (LongPressResult) objWaitForLongPress$default;
                if (Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                }
                break;
            case 8:
                job3 = (Job) c044012.L$2;
                pressGestureScopeImpl8 = (PressGestureScopeImpl) c044012.L$1;
                coroutineScope8 = (CoroutineScope) c044012.L$0;
                ResultKt.throwOnFailure(objWaitForLongPress$default);
                launchAwaitingReset$default(coroutineScope8, job3, null, new TapGestureDetectorKt$processTapGesture$secondUp$1(pressGestureScopeImpl8, null), 2, null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$2 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$2", m1609f = "TapGestureDetector.kt", m1610i = {}, m1611l = {TsExtractor.TS_STREAM_TYPE_DTS_HD}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C04412 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputChange $down;
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C04412(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super C04412> continuation) {
            super(2, continuation);
            this.$onPress = function3;
            this.$pressScope = pressGestureScopeImpl;
            this.$down = pointerInputChange;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04412(this.$onPress, this.$pressScope, this.$down, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04412) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                Offset offsetM7892boximpl = Offset.m7892boximpl(this.$down.getPosition());
                this.label = 1;
                if (function3.invoke(pressGestureScopeImpl, offsetM7892boximpl, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$3 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$3", m1609f = "TapGestureDetector.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C04423 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04423(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C04423> continuation) {
            super(2, continuation);
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04423(this.$pressScope, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04423) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$pressScope.release();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$4 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$4", m1609f = "TapGestureDetector.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C04434 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04434(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C04434> continuation) {
            super(2, continuation);
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04434(this.$pressScope, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04434) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$pressScope.cancel();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$5 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$5", m1609f = "TapGestureDetector.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C04445 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04445(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C04445> continuation) {
            super(2, continuation);
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04445(this.$pressScope, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04445) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$pressScope.release();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$6 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$6", m1609f = "TapGestureDetector.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_8_4, 185}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C04456 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $cancelOrReleaseJob;
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04456(Job job, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C04456> continuation) {
            super(2, continuation);
            this.$cancelOrReleaseJob = job;
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04456(this.$cancelOrReleaseJob, this.$pressScope, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04456) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        
            if (r4.$pressScope.reset(r4) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$cancelOrReleaseJob.join(this) != coroutine_suspended) {
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
            this.label = 2;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$7 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$7", m1609f = "TapGestureDetector.kt", m1610i = {}, m1611l = {TsExtractor.TS_PACKET_SIZE}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C04467 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        final /* synthetic */ PointerInputChange $secondDown;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C04467(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super C04467> continuation) {
            super(2, continuation);
            this.$onPress = function3;
            this.$pressScope = pressGestureScopeImpl;
            this.$secondDown = pointerInputChange;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04467(this.$onPress, this.$pressScope, this.$secondDown, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04467) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                Offset offsetM7892boximpl = Offset.m7892boximpl(this.$secondDown.getPosition());
                this.label = 1;
                if (function3.invoke(pressGestureScopeImpl, offsetM7892boximpl, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$8 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$8", m1609f = "TapGestureDetector.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C04478 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04478(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C04478> continuation) {
            super(2, continuation);
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04478(this.$pressScope, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04478) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$pressScope.release();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$9 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$9", m1609f = "TapGestureDetector.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C04489 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04489(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C04489> continuation) {
            super(2, continuation);
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04489(this.$pressScope, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04489) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$pressScope.cancel();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056 A[LOOP:0: B:19:0x0054->B:20:0x0056, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0042 -> B:18:0x0045). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object consumeUntilUp(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        C04361 c04361;
        int size;
        int i;
        int i2;
        int size2;
        if (continuation instanceof C04361) {
            c04361 = (C04361) continuation;
            if ((c04361.label & Integer.MIN_VALUE) != 0) {
                c04361.label -= Integer.MIN_VALUE;
            } else {
                c04361 = new C04361(continuation);
            }
        }
        Object objAwaitPointerEvent$default = c04361.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c04361.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objAwaitPointerEvent$default);
            c04361.L$0 = awaitPointerEventScope;
            c04361.label = 1;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, c04361, 1, null);
            if (objAwaitPointerEvent$default == coroutine_suspended) {
            }
            PointerEvent pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            i = 0;
            while (i2 < size) {
            }
            List<PointerInputChange> changes2 = pointerEvent.getChanges();
            size2 = changes2.size();
            while (i < size2) {
            }
            return Unit.INSTANCE;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        awaitPointerEventScope = (AwaitPointerEventScope) c04361.L$0;
        ResultKt.throwOnFailure(objAwaitPointerEvent$default);
        PointerEvent pointerEvent2 = (PointerEvent) objAwaitPointerEvent$default;
        List<PointerInputChange> changes3 = pointerEvent2.getChanges();
        size = changes3.size();
        i = 0;
        for (i2 = 0; i2 < size; i2++) {
            changes3.get(i2).consume();
        }
        List<PointerInputChange> changes22 = pointerEvent2.getChanges();
        size2 = changes22.size();
        while (i < size2) {
            if (changes22.get(i).getPressed()) {
                c04361.L$0 = awaitPointerEventScope;
                c04361.label = 1;
                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, c04361, 1, null);
                if (objAwaitPointerEvent$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                PointerEvent pointerEvent22 = (PointerEvent) objAwaitPointerEvent$default;
                List<PointerInputChange> changes32 = pointerEvent22.getChanges();
                size = changes32.size();
                i = 0;
                while (i2 < size) {
                }
                List<PointerInputChange> changes222 = pointerEvent22.getChanges();
                size2 = changes222.size();
                while (i < size2) {
                }
            } else {
                i++;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2", m1609f = "TapGestureDetector.kt", m1610i = {0, 0}, m1611l = {254}, m1612m = "invokeSuspend", m1613n = {"$this$withTimeoutOrNull", "minUptime"}, m1615s = {"L$0", "J$0"}, m1616v = 1)
    static final class C04352 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
        final /* synthetic */ PointerInputChange $firstUp;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04352(PointerInputChange pointerInputChange, Continuation<? super C04352> continuation) {
            super(2, continuation);
            this.$firstUp = pointerInputChange;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04352 c04352 = new C04352(this.$firstUp, continuation);
            c04352.L$0 = obj;
            return c04352;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
            return ((C04352) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0048 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0053 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0046 -> B:12:0x0049). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                r2 = 1
                if (r1 == 0) goto L1e
                if (r1 != r2) goto L16
                long r3 = r11.J$0
                java.lang.Object r1 = r11.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.p004ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r12)
                r5 = r1
                goto L49
            L16:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L1e:
                kotlin.ResultKt.throwOnFailure(r12)
                java.lang.Object r12 = r11.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.p004ui.input.pointer.AwaitPointerEventScope) r12
                androidx.compose.ui.input.pointer.PointerInputChange r1 = r11.$firstUp
                long r3 = r1.getUptimeMillis()
                androidx.compose.ui.platform.ViewConfiguration r1 = r12.getViewConfiguration()
                long r5 = r1.getDoubleTapMinTimeMillis()
                long r3 = r3 + r5
                r5 = r12
            L35:
                r8 = r11
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r11.L$0 = r5
                r11.J$0 = r3
                r11.label = r2
                r6 = 0
                r7 = 0
                r9 = 3
                r10 = 0
                java.lang.Object r12 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)
                if (r12 != r0) goto L49
                return r0
            L49:
                androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.p004ui.input.pointer.PointerInputChange) r12
                long r6 = r12.getUptimeMillis()
                int r1 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                if (r1 < 0) goto L35
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.C04352.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object awaitSecondDown(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, Continuation<? super PointerInputChange> continuation) {
        return awaitPointerEventScope.withTimeoutOrNull(awaitPointerEventScope.getViewConfiguration().getDoubleTapTimeoutMillis(), new C04352(pointerInputChange, null), continuation);
    }

    public static /* synthetic */ Object detectTapAndPress$default(PointerInputScope pointerInputScope, Function3 function3, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function3 = NoPressGesture;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        return detectTapAndPress(pointerInputScope, function3, function1, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2", m1609f = "TapGestureDetector.kt", m1610i = {}, m1611l = {274}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C04372 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ Function1<Offset, Unit> $onTap;
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        final /* synthetic */ PointerInputScope $this_detectTapAndPress;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C04372(PointerInputScope pointerInputScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C04372> continuation) {
            super(2, continuation);
            this.$this_detectTapAndPress = pointerInputScope;
            this.$onPress = function3;
            this.$onTap = function1;
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04372 c04372 = new C04372(this.$this_detectTapAndPress, this.$onPress, this.$onTap, this.$pressScope, continuation);
            c04372.L$0 = obj;
            return c04372;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04372) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TapGestureDetector.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1", m1609f = "TapGestureDetector.kt", m1610i = {0, 0, 1}, m1611l = {277, 283}, m1612m = "invokeSuspend", m1613n = {"$this$awaitEachGesture", "resetJob", "resetJob"}, m1615s = {"L$0", "L$1", "L$0"}, m1616v = 1)
        static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ Function1<Offset, Unit> $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(CoroutineScope coroutineScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.$onPress = function3;
                this.$onTap = function1;
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$coroutineScope, this.$onPress, this.$onTap, this.$pressScope, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:17:0x008d, code lost:
            
                if (r13 == r0) goto L18;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                AwaitPointerEventScope awaitPointerEventScope;
                Job jobLaunch$default;
                Job job;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new TapGestureDetectorKt$detectTapAndPress$2$1$resetJob$1(this.$pressScope, null), 1, null);
                    this.L$0 = awaitPointerEventScope;
                    this.L$1 = jobLaunch$default;
                    this.label = 1;
                    obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, this, 3, null);
                    if (obj != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Job job2 = (Job) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    job = job2;
                    PointerInputChange pointerInputChange = (PointerInputChange) obj;
                    if (pointerInputChange == null) {
                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job, null, new AnonymousClass2(this.$pressScope, null), 2, null);
                    } else {
                        pointerInputChange.consume();
                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job, null, new AnonymousClass3(this.$pressScope, null), 2, null);
                        Function1<Offset, Unit> function1 = this.$onTap;
                        if (function1 != null) {
                            function1.invoke(Offset.m7892boximpl(pointerInputChange.getPosition()));
                        }
                    }
                    return Unit.INSTANCE;
                }
                jobLaunch$default = (Job) this.L$1;
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                job = jobLaunch$default;
                AwaitPointerEventScope awaitPointerEventScope2 = awaitPointerEventScope;
                PointerInputChange pointerInputChange2 = (PointerInputChange) obj;
                pointerInputChange2.consume();
                if (this.$onPress != TapGestureDetectorKt.NoPressGesture) {
                    TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job, null, new C91721(this.$onPress, this.$pressScope, pointerInputChange2, null), 2, null);
                }
                this.L$0 = job;
                this.L$1 = null;
                this.label = 2;
                obj = TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope2, null, this, 1, null);
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
            @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1", m1609f = "TapGestureDetector.kt", m1610i = {}, m1611l = {280}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
            static final class C91721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PointerInputChange $down;
                final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C91721(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super C91721> continuation) {
                    super(2, continuation);
                    this.$onPress = function3;
                    this.$pressScope = pressGestureScopeImpl;
                    this.$down = pointerInputChange;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C91721(this.$onPress, this.$pressScope, this.$down, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C91721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                        PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                        Offset offsetM7892boximpl = Offset.m7892boximpl(this.$down.getPosition());
                        this.label = 1;
                        if (function3.invoke(pressGestureScopeImpl, offsetM7892boximpl, this) == coroutine_suspended) {
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
            @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$2", m1609f = "TapGestureDetector.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.cancel();
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: TapGestureDetector.kt */
            @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
            @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$3", m1609f = "TapGestureDetector.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
            static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass3(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass3(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.release();
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
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(this.$this_detectTapAndPress, new AnonymousClass1(coroutineScope, this.$onPress, this.$onTap, this.$pressScope, null), this) == coroutine_suspended) {
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

    public static final Object detectTapAndPress(PointerInputScope pointerInputScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C04372(pointerInputScope, function3, function1, new PressGestureScopeImpl(pointerInputScope), null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return awaitFirstDown(awaitPointerEventScope, z, continuation);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with PointerEventPass instead.")
    public static final /* synthetic */ Object awaitFirstDown(AwaitPointerEventScope awaitPointerEventScope, boolean z, Continuation continuation) {
        return awaitFirstDown(awaitPointerEventScope, z, PointerEventPass.Main, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004f -> B:18:0x0052). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final java.lang.Object awaitFirstDown(androidx.compose.p004ui.input.pointer.AwaitPointerEventScope r7, boolean r8, androidx.compose.p004ui.input.pointer.PointerEventPass r9, kotlin.coroutines.Continuation<? super androidx.compose.p004ui.input.pointer.PointerInputChange> r10) {
        /*
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt.C04332
            if (r0 == 0) goto L14
            r0 = r10
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt.C04332) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            boolean r7 = r0.Z$0
            java.lang.Object r8 = r0.L$1
            androidx.compose.ui.input.pointer.PointerEventPass r8 = (androidx.compose.p004ui.input.pointer.PointerEventPass) r8
            java.lang.Object r9 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.p004ui.input.pointer.AwaitPointerEventScope) r9
            kotlin.ResultKt.throwOnFailure(r10)
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
            goto L52
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L40:
            kotlin.ResultKt.throwOnFailure(r10)
        L43:
            r0.L$0 = r7
            r0.L$1 = r9
            r0.Z$0 = r8
            r0.label = r3
            java.lang.Object r10 = r7.awaitPointerEvent(r9, r0)
            if (r10 != r1) goto L52
            return r1
        L52:
            androidx.compose.ui.input.pointer.PointerEvent r10 = (androidx.compose.p004ui.input.pointer.PointerEvent) r10
            r2 = 2
            r4 = 0
            r5 = 0
            boolean r2 = isChangedToDown$default(r10, r8, r5, r2, r4)
            if (r2 == 0) goto L43
            java.util.List r7 = r10.getChanges()
            java.lang.Object r7 = r7.get(r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return awaitFirstDown(awaitPointerEventScope, z, pointerEventPass, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004f -> B:18:0x0052). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final java.lang.Object awaitPrimaryFirstDown(androidx.compose.p004ui.input.pointer.AwaitPointerEventScope r5, boolean r6, androidx.compose.p004ui.input.pointer.PointerEventPass r7, kotlin.coroutines.Continuation<? super androidx.compose.p004ui.input.pointer.PointerInputChange> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt.C04341
            if (r0 == 0) goto L14
            r0 = r8
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt.C04341) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            boolean r5 = r0.Z$0
            java.lang.Object r6 = r0.L$1
            androidx.compose.ui.input.pointer.PointerEventPass r6 = (androidx.compose.p004ui.input.pointer.PointerEventPass) r6
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.p004ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r8)
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
            goto L52
        L38:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L40:
            kotlin.ResultKt.throwOnFailure(r8)
        L43:
            r0.L$0 = r5
            r0.L$1 = r7
            r0.Z$0 = r6
            r0.label = r3
            java.lang.Object r8 = r5.awaitPointerEvent(r7, r0)
            if (r8 != r1) goto L52
            return r1
        L52:
            androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.p004ui.input.pointer.PointerEvent) r8
            boolean r2 = isChangedToDown(r8, r6, r3)
            if (r2 == 0) goto L43
            java.util.List r5 = r8.getChanges()
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitPrimaryFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object awaitPrimaryFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return awaitPrimaryFirstDown(awaitPointerEventScope, z, pointerEventPass, continuation);
    }

    public static /* synthetic */ boolean isChangedToDown$default(PointerEvent pointerEvent, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = TapGestureDetector_androidKt.firstDownRefersToPrimaryMouseButtonOnly();
        }
        return isChangedToDown(pointerEvent, z, z2);
    }

    public static final boolean isChangedToDown(PointerEvent pointerEvent, boolean z, boolean z2) {
        if (z2) {
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    if (!PointerType.m9565equalsimpl0(changes.get(i).getType(), PointerType.INSTANCE.m9570getMouseT8wyACA())) {
                        break;
                    }
                    i++;
                } else if (!PointerEvent_androidKt.m9462isPrimaryPressedaHzCxE(pointerEvent.getButtons())) {
                    return false;
                }
            }
        }
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            PointerInputChange pointerInputChange = changes2.get(i2);
            if (!(z ? PointerEventKt.changedToDown(pointerInputChange) : PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ba, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c7, code lost:
    
        if (r0 == r2) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c7 -> B:13:0x0038). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object waitForUpOrCancellation(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation<? super PointerInputChange> continuation) {
        C04512 c04512;
        AwaitPointerEventScope awaitPointerEventScope2;
        C04512 c045122;
        PointerEventPass pointerEventPass2;
        AwaitPointerEventScope awaitPointerEventScope3;
        PointerEventPass pointerEventPass3;
        int size;
        int i;
        Object objAwaitPointerEvent;
        if (continuation instanceof C04512) {
            c04512 = (C04512) continuation;
            if ((c04512.label & Integer.MIN_VALUE) != 0) {
                c04512.label -= Integer.MIN_VALUE;
            } else {
                c04512 = new C04512(continuation);
            }
        }
        Object objAwaitPointerEvent2 = c04512.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c04512.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAwaitPointerEvent2);
            awaitPointerEventScope2 = awaitPointerEventScope;
            c045122 = c04512;
            pointerEventPass2 = pointerEventPass;
            c045122.L$0 = awaitPointerEventScope2;
            c045122.L$1 = pointerEventPass2;
            c045122.label = 1;
            objAwaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass2, c045122);
            if (objAwaitPointerEvent != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            pointerEventPass3 = (PointerEventPass) c04512.L$1;
            awaitPointerEventScope3 = (AwaitPointerEventScope) c04512.L$0;
            ResultKt.throwOnFailure(objAwaitPointerEvent2);
            PointerEvent pointerEvent = (PointerEvent) objAwaitPointerEvent2;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            while (i < size) {
            }
            return pointerEvent.getChanges().get(0);
        }
        if (i2 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        pointerEventPass3 = (PointerEventPass) c04512.L$1;
        awaitPointerEventScope3 = (AwaitPointerEventScope) c04512.L$0;
        ResultKt.throwOnFailure(objAwaitPointerEvent2);
        PointerEventPass pointerEventPass4 = pointerEventPass3;
        c045122 = c04512;
        pointerEventPass2 = pointerEventPass4;
        List<PointerInputChange> changes2 = ((PointerEvent) objAwaitPointerEvent2).getChanges();
        int size2 = changes2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            if (changes2.get(i3).isConsumed()) {
                return null;
            }
        }
        awaitPointerEventScope2 = awaitPointerEventScope3;
        c045122.L$0 = awaitPointerEventScope2;
        c045122.L$1 = pointerEventPass2;
        c045122.label = 1;
        objAwaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass2, c045122);
        if (objAwaitPointerEvent != coroutine_suspended) {
            awaitPointerEventScope3 = awaitPointerEventScope2;
            objAwaitPointerEvent2 = objAwaitPointerEvent;
            C04512 c045123 = c045122;
            pointerEventPass3 = pointerEventPass2;
            c04512 = c045123;
            PointerEvent pointerEvent2 = (PointerEvent) objAwaitPointerEvent2;
            List<PointerInputChange> changes3 = pointerEvent2.getChanges();
            size = changes3.size();
            for (i = 0; i < size; i++) {
                if (!PointerEventKt.changedToUp(changes3.get(i))) {
                    List<PointerInputChange> changes4 = pointerEvent2.getChanges();
                    int size3 = changes4.size();
                    for (int i4 = 0; i4 < size3; i4++) {
                        PointerInputChange pointerInputChange = changes4.get(i4);
                        if (pointerInputChange.isConsumed() || PointerEventKt.m9428isOutOfBoundsjwHxaWs(pointerInputChange, awaitPointerEventScope3.mo9377getSizeYbymL2g(), awaitPointerEventScope3.mo9376getExtendedTouchPaddingNHjbRc())) {
                            break;
                        }
                    }
                    PointerEventPass pointerEventPass5 = PointerEventPass.Final;
                    c04512.L$0 = awaitPointerEventScope3;
                    c04512.L$1 = pointerEventPass3;
                    c04512.label = 2;
                    objAwaitPointerEvent2 = awaitPointerEventScope3.awaitPointerEvent(pointerEventPass5, c04512);
                }
            }
            return pointerEvent2.getChanges().get(0);
        }
        return coroutine_suspended;
    }

    public static /* synthetic */ Object waitForUpOrCancellation$default(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return waitForUpOrCancellation(awaitPointerEventScope, pointerEventPass, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, androidx.compose.foundation.gestures.LongPressResult$Canceled] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object waitForLongPress(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation<? super LongPressResult> continuation) {
        C04491 c04491;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C04491) {
            c04491 = (C04491) continuation;
            if ((c04491.label & Integer.MIN_VALUE) != 0) {
                c04491.label -= Integer.MIN_VALUE;
            } else {
                c04491 = new C04491(continuation);
            }
        }
        Object obj = c04491.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c04491.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = LongPressResult.Canceled.INSTANCE;
                long longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
                C04502 c04502 = new C04502(pointerEventPass, objectRef2, null);
                c04491.L$0 = objectRef2;
                c04491.label = 1;
                if (awaitPointerEventScope.withTimeout(longPressTimeoutMillis, c04502, c04491) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) c04491.L$0;
                ResultKt.throwOnFailure(obj);
            }
            return objectRef.element;
        } catch (PointerEventTimeoutCancellationException unused) {
            return LongPressResult.Success.INSTANCE;
        }
    }

    public static /* synthetic */ Object waitForLongPress$default(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return waitForLongPress(awaitPointerEventScope, pointerEventPass, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$2 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$2", m1609f = "TapGestureDetector.kt", m1610i = {0, 1}, m1611l = {412, 435}, m1612m = "invokeSuspend", m1613n = {"$this$withTimeout", "$this$withTimeout"}, m1615s = {"L$0", "L$0"}, m1616v = 1)
    static final class C04502 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerEventPass $pass;
        final /* synthetic */ Ref.ObjectRef<LongPressResult> $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04502(PointerEventPass pointerEventPass, Ref.ObjectRef<LongPressResult> objectRef, Continuation<? super C04502> continuation) {
            super(2, continuation);
            this.$pass = pointerEventPass;
            this.$result = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04502 c04502 = new C04502(this.$pass, this.$result, continuation);
            c04502.L$0 = obj;
            return c04502;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C04502) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0063, code lost:
        
            if (androidx.compose.foundation.gestures.TapGestureDetector_androidKt.isDeepPress(r14) == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0065, code lost:
        
            r13.$result.element = androidx.compose.foundation.gestures.LongPressResult.Success.INSTANCE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
        
            r14 = r14.getChanges();
            r5 = r14.size();
            r6 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0079, code lost:
        
            if (r6 >= r5) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x007b, code lost:
        
            r7 = r14.get(r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0085, code lost:
        
            if (r7.isConsumed() != false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0093, code lost:
        
            if (androidx.compose.p004ui.input.pointer.PointerEventKt.m9428isOutOfBoundsjwHxaWs(r7, r1.mo9377getSizeYbymL2g(), r1.mo9376getExtendedTouchPaddingNHjbRc()) == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0096, code lost:
        
            r6 = r6 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0099, code lost:
        
            r13.$result.element = androidx.compose.foundation.gestures.LongPressResult.Canceled.INSTANCE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a0, code lost:
        
            r13.L$0 = r1;
            r13.label = 2;
            r14 = r1.awaitPointerEvent(androidx.compose.p004ui.input.pointer.PointerEventPass.Final, r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00ad, code lost:
        
            if (r14 != r0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00cc, code lost:
        
            r13.$result.element = androidx.compose.foundation.gestures.LongPressResult.Canceled.INSTANCE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00f2, code lost:
        
            return kotlin.Unit.INSTANCE;
         */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00dd A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r0v2, types: [T, androidx.compose.foundation.gestures.LongPressResult$Canceled] */
        /* JADX WARN: Type inference failed for: r0v3, types: [T, androidx.compose.foundation.gestures.LongPressResult$Success] */
        /* JADX WARN: Type inference failed for: r0v4, types: [T, androidx.compose.foundation.gestures.LongPressResult$Canceled] */
        /* JADX WARN: Type inference failed for: r1v2, types: [T, androidx.compose.foundation.gestures.LongPressResult$Released] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00ad -> B:34:0x00b0). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AwaitPointerEventScope awaitPointerEventScope;
            AwaitPointerEventScope awaitPointerEventScope2;
            int size;
            int i;
            Object objAwaitPointerEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                this.L$0 = awaitPointerEventScope;
                this.label = 1;
                objAwaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(this.$pass, this);
                if (objAwaitPointerEvent != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                PointerEvent pointerEvent = (PointerEvent) obj;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                size = changes.size();
                i = 0;
                while (true) {
                    if (i < size) {
                    }
                    i++;
                }
                return coroutine_suspended;
            }
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            List<PointerInputChange> changes2 = ((PointerEvent) obj).getChanges();
            int size2 = changes2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                if (changes2.get(i3).isConsumed()) {
                    break;
                }
            }
            awaitPointerEventScope = awaitPointerEventScope2;
            this.L$0 = awaitPointerEventScope;
            this.label = 1;
            objAwaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(this.$pass, this);
            if (objAwaitPointerEvent != coroutine_suspended) {
                awaitPointerEventScope2 = awaitPointerEventScope;
                obj = objAwaitPointerEvent;
                PointerEvent pointerEvent2 = (PointerEvent) obj;
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                size = changes3.size();
                i = 0;
                while (true) {
                    if (i < size) {
                        if (!PointerEventKt.changedToUp(changes3.get(i))) {
                            break;
                        }
                        i++;
                    } else {
                        this.$result.element = new LongPressResult.Released(pointerEvent2.getChanges().get(0));
                        break;
                    }
                }
            }
            return coroutine_suspended;
        }
    }

    static /* synthetic */ Job launchAwaitingReset$default(CoroutineScope coroutineScope, Job job, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.UNDISPATCHED;
        }
        return launchAwaitingReset(coroutineScope, job, coroutineStart, function2);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$launchAwaitingReset$1 */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$launchAwaitingReset$1", m1609f = "TapGestureDetector.kt", m1610i = {0}, m1611l = {474, 475}, m1612m = "invokeSuspend", m1613n = {"$this$launch"}, m1615s = {"L$0"}, m1616v = 1)
    static final class C04391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Job $resetJob;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C04391(Job job, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C04391> continuation) {
            super(2, continuation);
            this.$resetJob = job;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04391 c04391 = new C04391(this.$resetJob, this.$block, continuation);
            c04391.L$0 = obj;
            return c04391;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
        
            if (r6.invoke(r1, r5) == r0) goto L15;
         */
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
                this.L$0 = coroutineScope;
                this.label = 1;
                if (this.$resetJob.join(this) != coroutine_suspended) {
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
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            Function2<CoroutineScope, Continuation<? super Unit>, Object> function2 = this.$block;
            this.L$0 = null;
            this.label = 2;
        }
    }

    private static final Job launchAwaitingReset(CoroutineScope coroutineScope, Job job, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, coroutineStart, new C04391(job, function2, null), 1, null);
    }
}
