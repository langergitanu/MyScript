package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.GestureConnection;
import androidx.compose.foundation.GestureNodeKt;
import androidx.compose.foundation.gestures.DragDetectionState;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p004ui.geometry.InlineClassHelperKt;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.indirect.IndirectPointerEvent;
import androidx.compose.p004ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.p004ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.p004ui.input.pointer.PointerEvent;
import androidx.compose.p004ui.input.pointer.PointerEventKt;
import androidx.compose.p004ui.input.pointer.PointerEventPass;
import androidx.compose.p004ui.input.pointer.PointerId;
import androidx.compose.p004ui.input.pointer.PointerInputChange;
import androidx.compose.p004ui.input.pointer.PointerType;
import androidx.compose.p004ui.input.pointer.util.VelocityTracker;
import androidx.compose.p004ui.input.pointer.util.VelocityTrackerKt;
import androidx.compose.p004ui.layout.LayoutCoordinatesKt;
import androidx.compose.p004ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.p004ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.p004ui.node.DelegatableNode;
import androidx.compose.p004ui.node.DelegatableNodeKt;
import androidx.compose.p004ui.node.DelegatingNode;
import androidx.compose.p004ui.node.PointerInputModifierNode;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.platform.ViewConfiguration;
import androidx.compose.p004ui.unit.Velocity;
import androidx.compose.p004ui.unit.VelocityKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: Draggable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001e\b!\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B7\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010JM\u0010K\u001a\u00020L2=\u0010M\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110O¢\u0006\f\bP\u0012\b\bQ\u0012\u0004\b\b(R\u0012\u0004\u0012\u00020L0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0S\u0012\u0006\u0012\u0004\u0018\u00010T0NH¦@¢\u0006\u0002\u0010UJ\u0017\u0010V\u001a\u00020L2\u0006\u0010W\u001a\u00020DH&¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020L2\u0006\u0010[\u001a\u00020\\H&J\b\u0010]\u001a\u00020\tH&J\b\u0010^\u001a\u00020BH\u0002J\u000e\u0010_\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\b\u0010`\u001a\u00020GH\u0002J\b\u0010a\u001a\u00020LH\u0002J\b\u0010b\u001a\u00020LH\u0016J\b\u0010c\u001a\u00020LH\u0004J\u0010\u0010d\u001a\u00020\t2\u0006\u0010[\u001a\u00020eH\u0016J'\u0010f\u001a\u00020L2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020lH\u0016¢\u0006\u0004\bm\u0010nJ\u0018\u0010o\u001a\u00020L2\u0006\u0010[\u001a\u00020p2\u0006\u0010i\u001a\u00020jH\u0016J\b\u0010q\u001a\u00020LH\u0016J\u0010\u0010d\u001a\u00020\t2\u0006\u0010[\u001a\u00020rH\u0016J\b\u0010s\u001a\u00020LH\u0016J\u0016\u0010t\u001a\u00020L2\u0006\u0010[\u001a\u00020uH\u0082@¢\u0006\u0002\u0010vJ\u0016\u0010w\u001a\u00020L2\u0006\u0010[\u001a\u00020\\H\u0082@¢\u0006\u0002\u0010xJ\u000e\u0010y\u001a\u00020LH\u0082@¢\u0006\u0002\u0010zJ\u0006\u0010{\u001a\u00020LJH\u0010|\u001a\u00020L2\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010}\u001a\u00020\tJ\u0018\u0010~\u001a\u00020L2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020jH\u0002J\b\u0010\u007f\u001a\u00020LH\u0002J;\u0010\u0080\u0001\u001a\u00020L2\u0007\u0010\u0081\u0001\u001a\u00020r2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\t\b\u0002\u0010\u0084\u0001\u001a\u00020D2\t\b\u0002\u0010\u0085\u0001\u001a\u00020\tH\u0002¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u001b\u0010\u0088\u0001\u001a\u00020L2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002¢\u0006\u0005\b\u0089\u0001\u0010YJ\t\u0010\u008a\u0001\u001a\u00020LH\u0002J-\u0010\u008b\u0001\u001a\u00020L2\u0007\u0010\u0081\u0001\u001a\u00020r2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0006\u0010F\u001a\u00020GH\u0002¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\"\u0010\u008e\u0001\u001a\u00020L2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020j2\u0007\u0010\u008f\u0001\u001a\u00020,H\u0002J\"\u0010\u0090\u0001\u001a\u00020L2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020j2\u0007\u0010\u008f\u0001\u001a\u000206H\u0002J\"\u0010\u0091\u0001\u001a\u00020L2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020j2\u0007\u0010\u008f\u0001\u001a\u00020;H\u0002J\"\u0010\u0092\u0001\u001a\u00020L2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020j2\u0007\u0010\u008f\u0001\u001a\u000201H\u0002J-\u0010\u0093\u0001\u001a\u00020L2\u0007\u0010\u0094\u0001\u001a\u00020r2\u0007\u0010\u0095\u0001\u001a\u00020r2\u0007\u0010\u0096\u0001\u001a\u00020DH\u0002¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J$\u0010\u0099\u0001\u001a\u00020L2\u0007\u0010\u009a\u0001\u001a\u00020r2\u0007\u0010\u009b\u0001\u001a\u00020DH\u0002¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u0012\u0010\u009e\u0001\u001a\u00020L2\u0007\u0010\u009a\u0001\u001a\u00020rH\u0002J\t\u0010\u009f\u0001\u001a\u00020LH\u0002J\u000f\u0010 \u0001\u001a\u00020L2\u0006\u0010[\u001a\u00020!R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R6\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\f@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010'R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u0002018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\u0002068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u00020;8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u00020DX\u0082\u000e¢\u0006\u0004\n\u0002\u0010ER\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u00020DX\u0082\u000e¢\u0006\u0004\n\u0002\u0010E¨\u0006¡\u0001"}, m1599d2 = {"Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/indirect/IndirectPointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/foundation/GestureConnection;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerType;", "", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "orientationLock", "Landroidx/compose/foundation/gestures/Orientation;", "<init>", "(Lkotlin/jvm/functions/Function1;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/Orientation;)V", "getOrientationLock", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientationLock", "(Landroidx/compose/foundation/gestures/Orientation;)V", "value", "getCanDrag", "()Lkotlin/jvm/functions/Function1;", "getEnabled", "()Z", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "gestureNode", "Landroidx/compose/ui/node/DelegatableNode;", "_canDrag", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/DragEvent;", "dragInteraction", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "isListeningForEvents", "isListeningForEvents$foundation", "setListeningForEvents$foundation", "(Z)V", "isListeningForPointerInputEvents", "isListeningForPointerInputEvents$foundation", "setListeningForPointerInputEvents$foundation", "_awaitDownState", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown;", "awaitDownState", "getAwaitDownState", "()Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown;", "_draggingState", "Landroidx/compose/foundation/gestures/DragDetectionState$Dragging;", "draggingState", "getDraggingState", "()Landroidx/compose/foundation/gestures/DragDetectionState$Dragging;", "_awaitTouchSlopState", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitTouchSlop;", "awaitTouchSlopState", "getAwaitTouchSlopState", "()Landroidx/compose/foundation/gestures/DragDetectionState$AwaitTouchSlop;", "_awaitGesturePickupState", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitGesturePickup;", "awaitGesturePickupState", "getAwaitGesturePickupState", "()Landroidx/compose/foundation/gestures/DragDetectionState$AwaitGesturePickup;", "currentDragState", "Landroidx/compose/foundation/gestures/DragDetectionState;", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "previousPositionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "J", "touchSlopDetector", "Landroidx/compose/foundation/gestures/TouchSlopDetector;", "indirectPointerInputDragCycleDetector", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector;", "nodeOffset", "drag", "", "forEachDelta", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "startedPosition", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "startDragImmediately", "requireVelocityTracker", "requireChannel", "requireTouchSlopDetector", "startListeningForEvents", "onDetach", "initializeGestureCoordination", "isInterested", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onIndirectPointerEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "onCancelIndirectPointerInput", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "onCancelPointerInput", "processDragStart", "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "(Landroidx/compose/foundation/gestures/DragEvent$DragStarted;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStop", "(Landroidx/compose/foundation/gestures/DragEvent$DragStopped;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragCancel", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disposeInteractionSource", "update", "shouldResetPointerInputHandling", "processRawPointerEvent", "resetDragDetectionState", "moveToAwaitTouchSlopState", "initialDown", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "initialTouchSlopPositionChange", "verifyConsumptionInFinalPass", "moveToAwaitTouchSlopState-aWI9W7U", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JJZ)V", "moveToDraggingState", "moveToDraggingState-0FcD4WY", "moveToAwaitDownState", "moveToAwaitGesturePickupState", "moveToAwaitGesturePickupState-rnUCldI", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JLandroidx/compose/foundation/gestures/TouchSlopDetector;)V", "processInitialDownState", "state", "processAwaitTouchSlop", "processAwaitGesturePickup", "processDraggingState", "sendDragStart", "down", "slopTriggerChange", "overSlopOffset", "sendDragStart-0AR0LA0", "(Landroidx/compose/ui/input/pointer/PointerInputChange;Landroidx/compose/ui/input/pointer/PointerInputChange;J)V", "sendDragEvent", "change", "dragAmount", "sendDragEvent-Uv8p0NA", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)V", "sendDragStopped", "sendDragCancelled", "onDragEvent", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public abstract class DragGestureNode extends DelegatingNode implements PointerInputModifierNode, IndirectPointerInputModifierNode, CompositionLocalConsumerModifierNode, GestureConnection {
    public static final int $stable = 8;
    private DragDetectionState.AwaitDown _awaitDownState;
    private DragDetectionState.AwaitGesturePickup _awaitGesturePickupState;
    private DragDetectionState.AwaitTouchSlop _awaitTouchSlopState;
    private DragDetectionState.Dragging _draggingState;
    private Function1<? super PointerType, Boolean> canDrag;
    private Channel<DragEvent> channel;
    private DragDetectionState currentDragState;
    private DragInteraction.Start dragInteraction;
    private boolean enabled;
    private DelegatableNode gestureNode;
    private IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector;
    private MutableInteractionSource interactionSource;
    private boolean isListeningForEvents;
    private boolean isListeningForPointerInputEvents;
    private Orientation orientationLock;
    private TouchSlopDetector touchSlopDetector;
    private VelocityTracker velocityTracker;
    private final Function1<PointerType, Boolean> _canDrag = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureNode$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return Boolean.valueOf(DragGestureNode._canDrag$lambda$0(this.f$0, (PointerType) obj));
        }
    };
    private long previousPositionOnScreen = Offset.INSTANCE.m7918getUnspecifiedF1C5BW0();
    private long nodeOffset = Offset.INSTANCE.m7919getZeroF1C5BW0();

    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DragDetectionState.AwaitDown.AwaitTouchSlop.values().length];
            try {
                iArr[DragDetectionState.AwaitDown.AwaitTouchSlop.NotInitialized.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1 */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.DragGestureNode", m1609f = "Draggable.kt", m1610i = {}, m1611l = {634}, m1612m = "processDragCancel", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C03911 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C03911(Continuation<? super C03911> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragCancel(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1 */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.DragGestureNode", m1609f = "Draggable.kt", m1610i = {0, 1, 1}, m1611l = {616, 619}, m1612m = "processDragStart", m1613n = {NotificationCompat.CATEGORY_EVENT, NotificationCompat.CATEGORY_EVENT, "interaction"}, m1615s = {"L$0", "L$0", "L$1"}, m1616v = 1)
    static final class C03921 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C03921(Continuation<? super C03921> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragStart(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1 */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.DragGestureNode", m1609f = "Draggable.kt", m1610i = {0}, m1611l = {626}, m1612m = "processDragStop", m1613n = {NotificationCompat.CATEGORY_EVENT}, m1615s = {"L$0"}, m1616v = 1)
    static final class C03931 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C03931(Continuation<? super C03931> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragStop(null, this);
        }
    }

    public abstract Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation);

    /* JADX INFO: renamed from: onDragStarted-k-4lQ0M */
    public abstract void mo2212onDragStartedk4lQ0M(long startedPosition);

    public abstract void onDragStopped(DragEvent.DragStopped event);

    /* JADX INFO: renamed from: startDragImmediately */
    public abstract boolean getStartDragImmediately();

    public DragGestureNode(Function1<? super PointerType, Boolean> function1, boolean z, MutableInteractionSource mutableInteractionSource, Orientation orientation) {
        this.orientationLock = orientation;
        this.canDrag = function1;
        this.enabled = z;
        this.interactionSource = mutableInteractionSource;
    }

    public final Orientation getOrientationLock() {
        return this.orientationLock;
    }

    public final void setOrientationLock(Orientation orientation) {
        this.orientationLock = orientation;
    }

    public final Function1<PointerType, Boolean> getCanDrag() {
        return this.canDrag;
    }

    protected final boolean getEnabled() {
        return this.enabled;
    }

    protected final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _canDrag$lambda$0(DragGestureNode dragGestureNode, PointerType pointerType) {
        return dragGestureNode.canDrag.invoke(pointerType).booleanValue();
    }

    /* JADX INFO: renamed from: isListeningForEvents$foundation, reason: from getter */
    public final boolean getIsListeningForEvents() {
        return this.isListeningForEvents;
    }

    public final void setListeningForEvents$foundation(boolean z) {
        this.isListeningForEvents = z;
    }

    /* JADX INFO: renamed from: isListeningForPointerInputEvents$foundation, reason: from getter */
    public final boolean getIsListeningForPointerInputEvents() {
        return this.isListeningForPointerInputEvents;
    }

    public final void setListeningForPointerInputEvents$foundation(boolean z) {
        this.isListeningForPointerInputEvents = z;
    }

    private final DragDetectionState.AwaitDown getAwaitDownState() {
        DragDetectionState.AwaitDown awaitDown = this._awaitDownState;
        if (awaitDown != null) {
            return awaitDown;
        }
        DragDetectionState.AwaitDown awaitDown2 = new DragDetectionState.AwaitDown(null, false, 3, null);
        this._awaitDownState = awaitDown2;
        return awaitDown2;
    }

    private final DragDetectionState.Dragging getDraggingState() {
        DragDetectionState.Dragging dragging = this._draggingState;
        if (dragging != null) {
            return dragging;
        }
        DragDetectionState.Dragging dragging2 = new DragDetectionState.Dragging(0L, 1, null);
        this._draggingState = dragging2;
        return dragging2;
    }

    private final DragDetectionState.AwaitTouchSlop getAwaitTouchSlopState() {
        DragDetectionState.AwaitTouchSlop awaitTouchSlop = this._awaitTouchSlopState;
        if (awaitTouchSlop != null) {
            return awaitTouchSlop;
        }
        DragDetectionState.AwaitTouchSlop awaitTouchSlop2 = new DragDetectionState.AwaitTouchSlop(null, 0L, false, 7, null);
        this._awaitTouchSlopState = awaitTouchSlop2;
        return awaitTouchSlop2;
    }

    private final DragDetectionState.AwaitGesturePickup getAwaitGesturePickupState() {
        DragDetectionState.AwaitGesturePickup awaitGesturePickup = this._awaitGesturePickupState;
        if (awaitGesturePickup != null) {
            return awaitGesturePickup;
        }
        DragDetectionState.AwaitGesturePickup awaitGesturePickup2 = new DragDetectionState.AwaitGesturePickup(null, 0L, null, 7, null);
        this._awaitGesturePickupState = awaitGesturePickup2;
        return awaitGesturePickup2;
    }

    private final VelocityTracker requireVelocityTracker() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            return velocityTracker;
        }
        throw new IllegalArgumentException("Velocity Tracker not initialized.".toString());
    }

    private final Channel<DragEvent> requireChannel() {
        Channel<DragEvent> channel = this.channel;
        if (channel != null) {
            return channel;
        }
        throw new IllegalArgumentException("Events channel not initialized.".toString());
    }

    private final TouchSlopDetector requireTouchSlopDetector() {
        TouchSlopDetector touchSlopDetector = this.touchSlopDetector;
        if (touchSlopDetector != null) {
            return touchSlopDetector;
        }
        throw new IllegalArgumentException("Touch slop detector not initialized.".toString());
    }

    private final void startListeningForEvents() {
        this.isListeningForEvents = true;
        if (this.channel == null) {
            this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        }
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C03941(null), 3, null);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1 */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1", m1609f = "Draggable.kt", m1610i = {0, 0, 1, 1, 2, 2, 3, 4, 5}, m1611l = {TypedValues.PositionType.TYPE_CURVE_FIT, TypedValues.PositionType.TYPE_POSITION_TYPE, 512, 519, PDFACompliance.e_PDFA5_2_1, PDFACompliance.e_PDFA5_2_4}, m1612m = "invokeSuspend", m1613n = {"$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", "$this$launch", "$this$launch"}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$0"}, m1616v = 1)
    static final class C03941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        C03941(Continuation<? super C03941> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03941 c03941 = DragGestureNode.this.new C03941(continuation);
            c03941.L$0 = obj;
            return c03941;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03941) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:50:0x0118, code lost:
        
            if (r7.this$0.processDragCancel(r7) != r0) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:43:0x00ee, B:40:0x00d2], limit reached: 56 */
        /* JADX WARN: Path cross not found for [B:45:0x00f4, B:19:0x005f], limit reached: 56 */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0034 A[PHI: r1 r3
          0x0034: PHI (r1v14 kotlin.jvm.internal.Ref$ObjectRef) = (r1v6 kotlin.jvm.internal.Ref$ObjectRef), (r1v20 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:13:0x0031, B:36:0x00c9] A[DONT_GENERATE, DONT_INLINE]
          0x0034: PHI (r3v9 kotlinx.coroutines.CoroutineScope) = (r3v5 kotlinx.coroutines.CoroutineScope), (r3v14 kotlinx.coroutines.CoroutineScope) binds: [B:13:0x0031, B:36:0x00c9] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x005f A[PHI: r4
          0x005f: PHI (r4v9 kotlinx.coroutines.CoroutineScope) = 
          (r4v0 kotlinx.coroutines.CoroutineScope)
          (r4v4 kotlinx.coroutines.CoroutineScope)
          (r4v4 kotlinx.coroutines.CoroutineScope)
          (r4v4 kotlinx.coroutines.CoroutineScope)
          (r4v7 kotlinx.coroutines.CoroutineScope)
          (r4v10 kotlinx.coroutines.CoroutineScope)
         binds: [B:18:0x0057, B:44:0x00f2, B:46:0x0104, B:41:0x00eb, B:30:0x0092, B:11:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00d2 A[Catch: CancellationException -> 0x0107, TryCatch #0 {CancellationException -> 0x0107, blocks: (B:38:0x00cc, B:40:0x00d2, B:43:0x00ee, B:45:0x00f4), top: B:55:0x00cc }] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00ee A[Catch: CancellationException -> 0x0107, TryCatch #0 {CancellationException -> 0x0107, blocks: (B:38:0x00cc, B:40:0x00d2, B:43:0x00ee, B:45:0x00f4), top: B:55:0x00cc }] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x011b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0092 -> B:19:0x005f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00eb -> B:19:0x005f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00f2 -> B:19:0x005f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0104 -> B:19:0x005f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0118 -> B:11:0x0027). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Ref.ObjectRef objectRef;
            Ref.ObjectRef objectRef2;
            Ref.ObjectRef objectRef3;
            CoroutineScope coroutineScope2;
            CoroutineScope coroutineScope3;
            T t;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = (CoroutineScope) this.L$0;
                    if (!CoroutineScopeKt.isActive(coroutineScope)) {
                        objectRef = new Ref.ObjectRef();
                        Channel channel = DragGestureNode.this.channel;
                        if (channel == null) {
                            objectRef2 = objectRef;
                            t = 0;
                            objectRef.element = t;
                            if (objectRef2.element instanceof DragEvent.DragStarted) {
                            }
                            return coroutine_suspended;
                        }
                        this.L$0 = coroutineScope;
                        this.L$1 = objectRef;
                        this.L$2 = objectRef;
                        this.label = 1;
                        obj = channel.receive(this);
                        if (obj != coroutine_suspended) {
                            objectRef2 = objectRef;
                            t = (DragEvent) obj;
                            objectRef.element = t;
                            if (objectRef2.element instanceof DragEvent.DragStarted) {
                                this.L$0 = coroutineScope;
                                this.L$1 = objectRef2;
                                this.L$2 = null;
                                this.label = 2;
                                if (DragGestureNode.this.processDragStart((DragEvent.DragStarted) objectRef2.element, this) != coroutine_suspended) {
                                    objectRef3 = objectRef2;
                                    coroutineScope2 = coroutineScope;
                                    this.L$0 = coroutineScope2;
                                    this.L$1 = objectRef3;
                                    this.label = 3;
                                    if (DragGestureNode.this.drag(new AnonymousClass1(objectRef3, DragGestureNode.this, null), this) != coroutine_suspended) {
                                        coroutineScope = coroutineScope2;
                                        try {
                                        } catch (CancellationException unused) {
                                            coroutineScope3 = coroutineScope;
                                            this.L$0 = coroutineScope3;
                                            this.L$1 = null;
                                            this.label = 6;
                                            break;
                                        }
                                        if (objectRef3.element instanceof DragEvent.DragStopped) {
                                            DragGestureNode dragGestureNode = DragGestureNode.this;
                                            T t2 = objectRef3.element;
                                            Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type androidx.compose.foundation.gestures.DragEvent.DragStopped");
                                            this.L$0 = coroutineScope;
                                            this.L$1 = null;
                                            this.label = 4;
                                            if (dragGestureNode.processDragStop((DragEvent.DragStopped) t2, this) != coroutine_suspended) {
                                                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                                                }
                                            }
                                        } else {
                                            if (objectRef3.element instanceof DragEvent.DragCancelled) {
                                                this.L$0 = coroutineScope;
                                                this.L$1 = null;
                                                this.label = 5;
                                                if (DragGestureNode.this.processDragCancel(this) != coroutine_suspended) {
                                                }
                                            }
                                            if (!CoroutineScopeKt.isActive(coroutineScope)) {
                                                return Unit.INSTANCE;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    objectRef = (Ref.ObjectRef) this.L$2;
                    objectRef2 = (Ref.ObjectRef) this.L$1;
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    t = (DragEvent) obj;
                    objectRef.element = t;
                    if (objectRef2.element instanceof DragEvent.DragStarted) {
                    }
                    return coroutine_suspended;
                case 2:
                    objectRef3 = (Ref.ObjectRef) this.L$1;
                    coroutineScope2 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = coroutineScope2;
                    this.L$1 = objectRef3;
                    this.label = 3;
                    if (DragGestureNode.this.drag(new AnonymousClass1(objectRef3, DragGestureNode.this, null), this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 3:
                    objectRef3 = (Ref.ObjectRef) this.L$1;
                    coroutineScope2 = (CoroutineScope) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (CancellationException unused2) {
                        coroutineScope3 = coroutineScope2;
                        this.L$0 = coroutineScope3;
                        this.L$1 = null;
                        this.label = 6;
                    }
                    coroutineScope = coroutineScope2;
                    if (objectRef3.element instanceof DragEvent.DragStopped) {
                    }
                    break;
                case 4:
                    coroutineScope3 = (CoroutineScope) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (CancellationException unused3) {
                        this.L$0 = coroutineScope3;
                        this.L$1 = null;
                        this.label = 6;
                    }
                    coroutineScope = coroutineScope3;
                    if (!CoroutineScopeKt.isActive(coroutineScope)) {
                    }
                    break;
                case 5:
                    coroutineScope3 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = coroutineScope3;
                    if (!CoroutineScopeKt.isActive(coroutineScope)) {
                    }
                    break;
                case 6:
                    coroutineScope3 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = coroutineScope3;
                    if (!CoroutineScopeKt.isActive(coroutineScope)) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: Draggable.kt */
        @Metadata(m1598d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0003H\n"}, m1599d2 = {"<anonymous>", "", "processDelta", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1", m1609f = "Draggable.kt", m1610i = {0}, m1611l = {515}, m1612m = "invokeSuspend", m1613n = {"processDelta"}, m1615s = {"L$0"}, m1616v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Function1<? super DragEvent.DragDelta, ? extends Unit>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<DragEvent> $event;
            /* synthetic */ Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ DragGestureNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Ref.ObjectRef<DragEvent> objectRef, DragGestureNode dragGestureNode, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$event = objectRef;
                this.this$0 = dragGestureNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$event, this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Function1<? super DragEvent.DragDelta, ? extends Unit> function1, Continuation<? super Unit> continuation) {
                return invoke2((Function1<? super DragEvent.DragDelta, Unit>) function1, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Function1<? super DragEvent.DragDelta, Unit> function1, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(function1, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0051 -> B:25:0x0066). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0060 -> B:24:0x0063). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Function1 function1;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    function1 = (Function1) this.L$0;
                    if (this.$event.element instanceof DragEvent.DragStopped) {
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Ref.ObjectRef<DragEvent> objectRef = (Ref.ObjectRef) this.L$1;
                function1 = (Function1) this.L$0;
                ResultKt.throwOnFailure(obj);
                T t = (DragEvent) obj;
                objectRef.element = t;
                if ((this.$event.element instanceof DragEvent.DragStopped) && !(this.$event.element instanceof DragEvent.DragCancelled)) {
                    DragEvent dragEvent = this.$event.element;
                    t = 0;
                    DragEvent.DragDelta dragDelta = dragEvent instanceof DragEvent.DragDelta ? (DragEvent.DragDelta) dragEvent : null;
                    if (dragDelta != null) {
                        function1.invoke(dragDelta);
                    }
                    objectRef = this.$event;
                    Channel channel = this.this$0.channel;
                    if (channel != null) {
                        this.L$0 = function1;
                        this.L$1 = objectRef;
                        this.label = 1;
                        obj = channel.receive(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        T t2 = (DragEvent) obj;
                    }
                    objectRef.element = t2;
                    if (this.$event.element instanceof DragEvent.DragStopped) {
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.isListeningForEvents = false;
        disposeInteractionSource();
        this.nodeOffset = Offset.INSTANCE.m7919getZeroF1C5BW0();
        DelegatableNode delegatableNode = this.gestureNode;
        if (delegatableNode != null) {
            undelegate(delegatableNode);
        }
        this.gestureNode = null;
    }

    protected final void initializeGestureCoordination() {
        if (ComposeFoundationFlags.isDelayPressesUsingGestureConsumptionEnabled && this.gestureNode == null) {
            this.gestureNode = delegate(GestureNodeKt.gestureNode(this));
        }
    }

    @Override // androidx.compose.foundation.GestureConnection
    public boolean isInterested(IndirectPointerInputChange event) {
        return IndirectPointerInputDragCycleDetectorKt.changedToDownIgnoreConsumed(event) && this.enabled;
    }

    @Override // androidx.compose.p004ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo1983onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        this.isListeningForPointerInputEvents = true;
        initializeGestureCoordination();
        if (this.enabled) {
            if (this.currentDragState == null) {
                this.currentDragState = getAwaitDownState();
            }
            processRawPointerEvent(pointerEvent, pass);
        }
    }

    @Override // androidx.compose.p004ui.input.indirect.IndirectPointerInputModifierNode
    public void onIndirectPointerEvent(IndirectPointerEvent event, PointerEventPass pass) {
        initializeGestureCoordination();
        if (this.enabled) {
            if (this.indirectPointerInputDragCycleDetector == null) {
                this.indirectPointerInputDragCycleDetector = new IndirectPointerInputDragCycleDetector(this);
            }
            IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector = this.indirectPointerInputDragCycleDetector;
            if (indirectPointerInputDragCycleDetector != null) {
                indirectPointerInputDragCycleDetector.processIndirectPointerInputEvent(event, pass);
            }
        }
    }

    @Override // androidx.compose.p004ui.input.indirect.IndirectPointerInputModifierNode
    public void onCancelIndirectPointerInput() {
        IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector = this.indirectPointerInputDragCycleDetector;
        if (indirectPointerInputDragCycleDetector != null) {
            indirectPointerInputDragCycleDetector.resetDragDetectionState();
        }
    }

    @Override // androidx.compose.foundation.GestureConnection
    public boolean isInterested(PointerInputChange event) {
        if (PointerEventKt.changedToDownIgnoreConsumed(event)) {
            return this.enabled;
        }
        if (!ComposeFoundationFlags.isNestedDraggablesTouchConflictFixEnabled || PointerEventKt.changedToUpIgnoreConsumed(event)) {
            return false;
        }
        if (this.touchSlopDetector == null) {
            this.touchSlopDetector = new TouchSlopDetector(this.orientationLock, 0L, 2, null);
        }
        float touchSlop = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration())).getTouchSlop();
        long jPositionChange = PointerEventKt.positionChange(event);
        TouchSlopDetector touchSlopDetectorRequireTouchSlopDetector = requireTouchSlopDetector();
        return !Offset.m7900equalsimpl0(touchSlopDetectorRequireTouchSlopDetector.m2417getPostSlopOffsetqto3Fdw(jPositionChange, touchSlop, false), Offset.INSTANCE.m7918getUnspecifiedF1C5BW0()) && touchSlopDetectorRequireTouchSlopDetector.m2418isDeltaAtAngleOfInterestk4lQ0M(jPositionChange);
    }

    @Override // androidx.compose.p004ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        if (this.isListeningForPointerInputEvents) {
            resetDragDetectionState();
        }
        this.isListeningForPointerInputEvents = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processDragStart(DragEvent.DragStarted dragStarted, Continuation<? super Unit> continuation) {
        C03921 c03921;
        MutableInteractionSource mutableInteractionSource;
        DragInteraction.Start start;
        DragEvent.DragStarted dragStarted2;
        DragInteraction.Start start2;
        if (continuation instanceof C03921) {
            c03921 = (C03921) continuation;
            if ((c03921.label & Integer.MIN_VALUE) != 0) {
                c03921.label -= Integer.MIN_VALUE;
            } else {
                c03921 = new C03921(continuation);
            }
        }
        Object obj = c03921.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c03921.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DragInteraction.Start start3 = this.dragInteraction;
            if (start3 != null && (mutableInteractionSource = this.interactionSource) != null) {
                DragInteraction.Cancel cancel = new DragInteraction.Cancel(start3);
                c03921.L$0 = dragStarted;
                c03921.label = 1;
                if (mutableInteractionSource.emit(cancel, c03921) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            this.dragInteraction = start;
            mo2212onDragStartedk4lQ0M(dragStarted.getStartPoint());
            return Unit.INSTANCE;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            start2 = (DragInteraction.Start) c03921.L$1;
            dragStarted2 = (DragEvent.DragStarted) c03921.L$0;
            ResultKt.throwOnFailure(obj);
            start = start2;
            dragStarted = dragStarted2;
            this.dragInteraction = start;
            mo2212onDragStartedk4lQ0M(dragStarted.getStartPoint());
            return Unit.INSTANCE;
        }
        dragStarted = (DragEvent.DragStarted) c03921.L$0;
        ResultKt.throwOnFailure(obj);
        start = new DragInteraction.Start();
        MutableInteractionSource mutableInteractionSource2 = this.interactionSource;
        if (mutableInteractionSource2 != null) {
            c03921.L$0 = dragStarted;
            c03921.L$1 = start;
            c03921.label = 2;
            if (mutableInteractionSource2.emit(start, c03921) != coroutine_suspended) {
                dragStarted2 = dragStarted;
                start2 = start;
                start = start2;
                dragStarted = dragStarted2;
            }
            return coroutine_suspended;
        }
        this.dragInteraction = start;
        mo2212onDragStartedk4lQ0M(dragStarted.getStartPoint());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processDragStop(DragEvent.DragStopped dragStopped, Continuation<? super Unit> continuation) {
        C03931 c03931;
        if (continuation instanceof C03931) {
            c03931 = (C03931) continuation;
            if ((c03931.label & Integer.MIN_VALUE) != 0) {
                c03931.label -= Integer.MIN_VALUE;
            } else {
                c03931 = new C03931(continuation);
            }
        }
        Object obj = c03931.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c03931.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DragInteraction.Start start = this.dragInteraction;
            if (start != null) {
                MutableInteractionSource mutableInteractionSource = this.interactionSource;
                if (mutableInteractionSource != null) {
                    DragInteraction.Stop stop = new DragInteraction.Stop(start);
                    c03931.L$0 = dragStopped;
                    c03931.label = 1;
                    if (mutableInteractionSource.emit(stop, c03931) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            onDragStopped(dragStopped);
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        dragStopped = (DragEvent.DragStopped) c03931.L$0;
        ResultKt.throwOnFailure(obj);
        this.dragInteraction = null;
        onDragStopped(dragStopped);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processDragCancel(Continuation<? super Unit> continuation) {
        C03911 c03911;
        if (continuation instanceof C03911) {
            c03911 = (C03911) continuation;
            if ((c03911.label & Integer.MIN_VALUE) != 0) {
                c03911.label -= Integer.MIN_VALUE;
            } else {
                c03911 = new C03911(continuation);
            }
        }
        Object obj = c03911.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c03911.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DragInteraction.Start start = this.dragInteraction;
            if (start != null) {
                MutableInteractionSource mutableInteractionSource = this.interactionSource;
                if (mutableInteractionSource != null) {
                    DragInteraction.Cancel cancel = new DragInteraction.Cancel(start);
                    c03911.label = 1;
                    if (mutableInteractionSource.emit(cancel, c03911) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            onDragStopped(new DragEvent.DragStopped(Velocity.INSTANCE.m11266getZero9UxMQ8M(), false, null));
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.dragInteraction = null;
        onDragStopped(new DragEvent.DragStopped(Velocity.INSTANCE.m11266getZero9UxMQ8M(), false, null));
        return Unit.INSTANCE;
    }

    public final void disposeInteractionSource() {
        DragInteraction.Start start = this.dragInteraction;
        if (start != null) {
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                mutableInteractionSource.tryEmit(new DragInteraction.Cancel(start));
            }
            this.dragInteraction = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void update$default(DragGestureNode dragGestureNode, Function1 function1, boolean z, MutableInteractionSource mutableInteractionSource, Orientation orientation, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
        }
        if ((i & 1) != 0) {
            function1 = dragGestureNode.canDrag;
        }
        if ((i & 2) != 0) {
            z = dragGestureNode.enabled;
        }
        if ((i & 4) != 0) {
            mutableInteractionSource = dragGestureNode.interactionSource;
        }
        if ((i & 8) != 0) {
            orientation = dragGestureNode.orientationLock;
        }
        if ((i & 16) != 0) {
            z2 = false;
        }
        boolean z3 = z2;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        Function1 function12 = function1;
        dragGestureNode.update(function12, z, mutableInteractionSource2, orientation, z3);
    }

    public final void update(Function1<? super PointerType, Boolean> canDrag, boolean enabled, MutableInteractionSource interactionSource, Orientation orientationLock, boolean shouldResetPointerInputHandling) {
        this.canDrag = canDrag;
        boolean z = true;
        if (this.enabled != enabled) {
            this.enabled = enabled;
            if (!enabled) {
                disposeInteractionSource();
                this.indirectPointerInputDragCycleDetector = null;
            }
            shouldResetPointerInputHandling = true;
        }
        if (!Intrinsics.areEqual(this.interactionSource, interactionSource)) {
            disposeInteractionSource();
            this.interactionSource = interactionSource;
        }
        if (this.orientationLock != orientationLock) {
            this.orientationLock = orientationLock;
        } else {
            z = shouldResetPointerInputHandling;
        }
        if (z) {
            if (this.isListeningForPointerInputEvents) {
                resetDragDetectionState();
            }
            IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector = this.indirectPointerInputDragCycleDetector;
            if (indirectPointerInputDragCycleDetector != null) {
                indirectPointerInputDragCycleDetector.resetDragDetectionState();
            }
        }
    }

    private final void processRawPointerEvent(PointerEvent pointerEvent, PointerEventPass pass) {
        DragDetectionState dragDetectionState = this.currentDragState;
        if (dragDetectionState == null) {
            throw new IllegalArgumentException("currentDragState should not be null".toString());
        }
        if (dragDetectionState instanceof DragDetectionState.AwaitDown) {
            processInitialDownState(pointerEvent, pass, (DragDetectionState.AwaitDown) dragDetectionState);
            return;
        }
        if (dragDetectionState instanceof DragDetectionState.AwaitTouchSlop) {
            processAwaitTouchSlop(pointerEvent, pass, (DragDetectionState.AwaitTouchSlop) dragDetectionState);
        } else if (dragDetectionState instanceof DragDetectionState.AwaitGesturePickup) {
            processAwaitGesturePickup(pointerEvent, pass, (DragDetectionState.AwaitGesturePickup) dragDetectionState);
        } else {
            if (!(dragDetectionState instanceof DragDetectionState.Dragging)) {
                throw new NoWhenBranchMatchedException();
            }
            processDraggingState(pointerEvent, pass, (DragDetectionState.Dragging) dragDetectionState);
        }
    }

    private final void resetDragDetectionState() {
        moveToAwaitDownState();
        if (this.isListeningForEvents) {
            sendDragCancelled();
        }
        this.velocityTracker = null;
    }

    /* JADX INFO: renamed from: moveToAwaitTouchSlopState-aWI9W7U$default, reason: not valid java name */
    static /* synthetic */ void m2287moveToAwaitTouchSlopStateaWI9W7U$default(DragGestureNode dragGestureNode, PointerInputChange pointerInputChange, long j, long j2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveToAwaitTouchSlopState-aWI9W7U");
        }
        if ((i & 4) != 0) {
            j2 = Offset.INSTANCE.m7919getZeroF1C5BW0();
        }
        long j3 = j2;
        if ((i & 8) != 0) {
            z = false;
        }
        dragGestureNode.m2286moveToAwaitTouchSlopStateaWI9W7U(pointerInputChange, j, j3, z);
    }

    /* JADX INFO: renamed from: moveToAwaitTouchSlopState-aWI9W7U, reason: not valid java name */
    private final void m2286moveToAwaitTouchSlopStateaWI9W7U(PointerInputChange initialDown, long pointerId, long initialTouchSlopPositionChange, boolean verifyConsumptionInFinalPass) {
        DragDetectionState.AwaitTouchSlop awaitTouchSlopState = getAwaitTouchSlopState();
        awaitTouchSlopState.setInitialDown(initialDown);
        awaitTouchSlopState.m2251setPointerId0FcD4WY(pointerId);
        TouchSlopDetector touchSlopDetector = this.touchSlopDetector;
        if (touchSlopDetector == null) {
            this.touchSlopDetector = new TouchSlopDetector(this.orientationLock, 0L, 2, null);
        } else {
            if (touchSlopDetector != null) {
                touchSlopDetector.setOrientation(this.orientationLock);
            }
            TouchSlopDetector touchSlopDetector2 = this.touchSlopDetector;
            if (touchSlopDetector2 != null) {
                touchSlopDetector2.m2420resetk4lQ0M(initialTouchSlopPositionChange);
            }
        }
        awaitTouchSlopState.setVerifyConsumptionInFinalPass(verifyConsumptionInFinalPass);
        this.currentDragState = awaitTouchSlopState;
    }

    /* JADX INFO: renamed from: moveToDraggingState-0FcD4WY, reason: not valid java name */
    private final void m2288moveToDraggingState0FcD4WY(long pointerId) {
        DragDetectionState.Dragging draggingState = getDraggingState();
        draggingState.m2253setPointerId0FcD4WY(pointerId);
        this.currentDragState = draggingState;
    }

    private final void moveToAwaitDownState() {
        DragDetectionState.AwaitDown awaitDownState = getAwaitDownState();
        awaitDownState.setAwaitTouchSlop(DragDetectionState.AwaitDown.AwaitTouchSlop.NotInitialized);
        awaitDownState.setConsumedOnInitial(false);
        this.currentDragState = awaitDownState;
    }

    /* JADX INFO: renamed from: moveToAwaitGesturePickupState-rnUCldI, reason: not valid java name */
    private final void m2285moveToAwaitGesturePickupStaternUCldI(PointerInputChange initialDown, long pointerId, TouchSlopDetector touchSlopDetector) {
        DragDetectionState.AwaitGesturePickup awaitGesturePickupState = getAwaitGesturePickupState();
        awaitGesturePickupState.setInitialDown(initialDown);
        awaitGesturePickupState.m2249setPointerId0FcD4WY(pointerId);
        TouchSlopDetector.m2415resetk4lQ0M$default(touchSlopDetector, 0L, 1, null);
        awaitGesturePickupState.setTouchSlopDetector(touchSlopDetector);
        this.currentDragState = awaitGesturePickupState;
    }

    private final void processInitialDownState(PointerEvent pointerEvent, PointerEventPass pass, DragDetectionState.AwaitDown state) {
        DragDetectionState.AwaitDown.AwaitTouchSlop awaitTouchSlop;
        if (!pointerEvent.getChanges().isEmpty() && TapGestureDetectorKt.isChangedToDown$default(pointerEvent, false, false, 2, null)) {
            PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.first((List) pointerEvent.getChanges());
            if (WhenMappings.$EnumSwitchMapping$0[state.getAwaitTouchSlop().ordinal()] == 1) {
                if (!getStartDragImmediately()) {
                    awaitTouchSlop = DragDetectionState.AwaitDown.AwaitTouchSlop.Yes;
                } else {
                    awaitTouchSlop = DragDetectionState.AwaitDown.AwaitTouchSlop.f47No;
                }
            } else {
                awaitTouchSlop = state.getAwaitTouchSlop();
            }
            state.setAwaitTouchSlop(awaitTouchSlop);
            if (pass == PointerEventPass.Initial && awaitTouchSlop == DragDetectionState.AwaitDown.AwaitTouchSlop.f47No) {
                pointerInputChange.consume();
                state.setConsumedOnInitial(true);
            }
            if (pass == PointerEventPass.Main) {
                if (awaitTouchSlop == DragDetectionState.AwaitDown.AwaitTouchSlop.Yes) {
                    m2287moveToAwaitTouchSlopStateaWI9W7U$default(this, pointerInputChange, pointerInputChange.getId(), 0L, false, 12, null);
                } else if (state.getConsumedOnInitial()) {
                    m2290sendDragStart0AR0LA0(pointerInputChange, pointerInputChange, Offset.INSTANCE.m7919getZeroF1C5BW0());
                    m2289sendDragEventUv8p0NA(pointerInputChange, Offset.INSTANCE.m7919getZeroF1C5BW0());
                    m2288moveToDraggingState0FcD4WY(pointerInputChange.getId());
                }
            }
        }
    }

    private final void processAwaitTouchSlop(PointerEvent pointerEvent, PointerEventPass pass, DragDetectionState.AwaitTouchSlop state) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        if (pass == PointerEventPass.Initial) {
            return;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        while (true) {
            pointerInputChange = null;
            if (i >= size) {
                pointerInputChange2 = null;
                break;
            }
            pointerInputChange2 = changes.get(i);
            if (PointerId.m9471equalsimpl0(pointerInputChange2.getId(), state.getPointerId())) {
                break;
            } else {
                i++;
            }
        }
        PointerInputChange pointerInputChange4 = pointerInputChange2;
        if (pointerInputChange4 == null) {
            List<PointerInputChange> changes2 = pointerEvent.getChanges();
            int size2 = changes2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size2) {
                    pointerInputChange3 = null;
                    break;
                }
                pointerInputChange3 = changes2.get(i2);
                if (pointerInputChange3.getPressed()) {
                    break;
                } else {
                    i2++;
                }
            }
            pointerInputChange4 = pointerInputChange3;
            if (pointerInputChange4 == null) {
                moveToAwaitDownState();
                return;
            }
            state.m2251setPointerId0FcD4WY(pointerInputChange4.getId());
        }
        if (pass == PointerEventPass.Main) {
            if (!pointerInputChange4.isConsumed()) {
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange4)) {
                    List<PointerInputChange> changes3 = pointerEvent.getChanges();
                    int size3 = changes3.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size3) {
                            break;
                        }
                        PointerInputChange pointerInputChange5 = changes3.get(i3);
                        if (pointerInputChange5.getPressed()) {
                            pointerInputChange = pointerInputChange5;
                            break;
                        }
                        i3++;
                    }
                    PointerInputChange pointerInputChange6 = pointerInputChange;
                    if (pointerInputChange6 == null) {
                        moveToAwaitDownState();
                    } else {
                        state.m2251setPointerId0FcD4WY(pointerInputChange6.getId());
                    }
                } else {
                    long jM2414getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m2414getPostSlopOffsetqto3Fdw$default(requireTouchSlopDetector(), PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange4), DragGestureDetectorKt.m2281pointerSlopE8SPZFQ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration()), pointerInputChange4.getType()), false, 4, null);
                    if (ComposeFoundationFlags.isNestedDraggablesTouchConflictFixEnabled) {
                        if ((9223372034707292159L & jM2414getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                            boolean zIsInterested = isInterested(pointerInputChange4);
                            GestureConnection parentGestureConnection = GestureNodeKt.getParentGestureConnection(this);
                            boolean z = parentGestureConnection != null && parentGestureConnection.isInterested(pointerInputChange4);
                            if (!zIsInterested && z) {
                                state.setVerifyConsumptionInFinalPass(true);
                            } else {
                                pointerInputChange4.consume();
                                PointerInputChange initialDown = state.getInitialDown();
                                Intrinsics.checkNotNull(initialDown);
                                m2290sendDragStart0AR0LA0(initialDown, pointerInputChange4, jM2414getPostSlopOffsetqto3Fdw$default);
                                m2289sendDragEventUv8p0NA(pointerInputChange4, jM2414getPostSlopOffsetqto3Fdw$default);
                                m2288moveToDraggingState0FcD4WY(pointerInputChange4.getId());
                            }
                        } else {
                            state.setVerifyConsumptionInFinalPass(true);
                        }
                    } else if ((9223372034707292159L & jM2414getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                        pointerInputChange4.consume();
                        PointerInputChange initialDown2 = state.getInitialDown();
                        Intrinsics.checkNotNull(initialDown2);
                        m2290sendDragStart0AR0LA0(initialDown2, pointerInputChange4, jM2414getPostSlopOffsetqto3Fdw$default);
                        m2289sendDragEventUv8p0NA(pointerInputChange4, jM2414getPostSlopOffsetqto3Fdw$default);
                        m2288moveToDraggingState0FcD4WY(pointerInputChange4.getId());
                    } else {
                        state.setVerifyConsumptionInFinalPass(true);
                    }
                }
            } else {
                PointerInputChange initialDown3 = state.getInitialDown();
                if (initialDown3 == null) {
                    throw new IllegalArgumentException("AwaitTouchSlop.initialDown was not initialized".toString());
                }
                long pointerId = state.getPointerId();
                TouchSlopDetector touchSlopDetector = this.touchSlopDetector;
                if (touchSlopDetector != null) {
                    m2285moveToAwaitGesturePickupStaternUCldI(initialDown3, pointerId, touchSlopDetector);
                } else {
                    throw new IllegalArgumentException("AwaitTouchSlop.touchSlopDetector was not initialized".toString());
                }
            }
        }
        if (pass == PointerEventPass.Final && state.getVerifyConsumptionInFinalPass()) {
            if (pointerInputChange4.isConsumed()) {
                PointerInputChange initialDown4 = state.getInitialDown();
                if (initialDown4 == null) {
                    throw new IllegalArgumentException("AwaitTouchSlop.initialDown was not initialized".toString());
                }
                long pointerId2 = state.getPointerId();
                TouchSlopDetector touchSlopDetector2 = this.touchSlopDetector;
                if (touchSlopDetector2 != null) {
                    m2285moveToAwaitGesturePickupStaternUCldI(initialDown4, pointerId2, touchSlopDetector2);
                    return;
                }
                throw new IllegalArgumentException("AwaitTouchSlop.touchSlopDetector was not initialized".toString());
            }
            state.setVerifyConsumptionInFinalPass(false);
        }
    }

    private final void processAwaitGesturePickup(PointerEvent pointerEvent, PointerEventPass pass, DragDetectionState.AwaitGesturePickup state) {
        boolean z;
        if (pass != PointerEventPass.Final) {
            return;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                z = true;
                break;
            } else {
                if (changes.get(i2).isConsumed()) {
                    z = false;
                    break;
                }
                i2++;
            }
        }
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        while (true) {
            if (i >= size2) {
                break;
            }
            if (!changes2.get(i).getPressed()) {
                i++;
            } else if (!pointerEvent.getChanges().isEmpty()) {
                if (z) {
                    long position = ((PointerInputChange) CollectionsKt.first((List) pointerEvent.getChanges())).getPosition();
                    PointerInputChange initialDown = state.getInitialDown();
                    Intrinsics.checkNotNull(initialDown);
                    long jM7907minusMKHz9U = Offset.m7907minusMKHz9U(position, initialDown.getPosition());
                    PointerInputChange initialDown2 = state.getInitialDown();
                    if (initialDown2 != null) {
                        m2287moveToAwaitTouchSlopStateaWI9W7U$default(this, initialDown2, state.getPointerId(), jM7907minusMKHz9U, false, 8, null);
                        return;
                    }
                    throw new IllegalArgumentException("AwaitGesturePickup.initialDown was not initialized.".toString());
                }
                return;
            }
        }
        moveToAwaitDownState();
    }

    private final void processDraggingState(PointerEvent pointerEvent, PointerEventPass pass, DragDetectionState.Dragging state) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (pass != PointerEventPass.Main) {
            return;
        }
        long pointerId = state.getPointerId();
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            pointerInputChange = null;
            if (i2 >= size) {
                pointerInputChange2 = null;
                break;
            }
            pointerInputChange2 = changes.get(i2);
            if (PointerId.m9471equalsimpl0(pointerInputChange2.getId(), pointerId)) {
                break;
            } else {
                i2++;
            }
        }
        PointerInputChange pointerInputChange3 = pointerInputChange2;
        if (pointerInputChange3 == null) {
            return;
        }
        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
            List<PointerInputChange> changes2 = pointerEvent.getChanges();
            int size2 = changes2.size();
            while (true) {
                if (i >= size2) {
                    break;
                }
                PointerInputChange pointerInputChange4 = changes2.get(i);
                if (pointerInputChange4.getPressed()) {
                    pointerInputChange = pointerInputChange4;
                    break;
                }
                i++;
            }
            PointerInputChange pointerInputChange5 = pointerInputChange;
            if (pointerInputChange5 == null) {
                if (!pointerInputChange3.isConsumed() && PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                    sendDragStopped(pointerInputChange3);
                } else {
                    sendDragCancelled();
                }
                moveToAwaitDownState();
                return;
            }
            state.m2253setPointerId0FcD4WY(pointerInputChange5.getId());
            return;
        }
        if (pointerInputChange3.isConsumed()) {
            sendDragCancelled();
        } else {
            if (Offset.m7901getDistanceimpl(PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange3)) == 0.0f) {
                return;
            }
            m2289sendDragEventUv8p0NA(pointerInputChange3, PointerEventKt.positionChange(pointerInputChange3));
            pointerInputChange3.consume();
        }
    }

    /* JADX INFO: renamed from: sendDragStart-0AR0LA0, reason: not valid java name */
    private final void m2290sendDragStart0AR0LA0(PointerInputChange down, PointerInputChange slopTriggerChange, long overSlopOffset) {
        if (this.velocityTracker == null) {
            this.velocityTracker = new VelocityTracker();
        }
        VelocityTrackerKt.addPointerInputChange(requireVelocityTracker(), down);
        long jM7907minusMKHz9U = Offset.m7907minusMKHz9U(slopTriggerChange.getPosition(), overSlopOffset);
        this.nodeOffset = Offset.INSTANCE.m7919getZeroF1C5BW0();
        if (this.canDrag.invoke(PointerType.m9562boximpl(down.getType())).booleanValue()) {
            if (!this.isListeningForEvents) {
                if (this.channel == null) {
                    this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
                }
                startListeningForEvents();
            }
            this.previousPositionOnScreen = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(this));
            requireChannel().mo16021trySendJP2dKIU(new DragEvent.DragStarted(jM7907minusMKHz9U, null));
        }
    }

    /* JADX INFO: renamed from: sendDragEvent-Uv8p0NA, reason: not valid java name */
    private final void m2289sendDragEventUv8p0NA(PointerInputChange change, long dragAmount) {
        long jPositionOnScreen = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(getNode()));
        if (!Offset.m7900equalsimpl0(this.previousPositionOnScreen, Offset.INSTANCE.m7918getUnspecifiedF1C5BW0()) && !Offset.m7900equalsimpl0(jPositionOnScreen, this.previousPositionOnScreen)) {
            this.nodeOffset = Offset.m7908plusMKHz9U(this.nodeOffset, Offset.m7907minusMKHz9U(jPositionOnScreen, this.previousPositionOnScreen));
        }
        this.previousPositionOnScreen = jPositionOnScreen;
        VelocityTrackerKt.m9601addPointerInputChange0AR0LA0(requireVelocityTracker(), change, this.nodeOffset);
        requireChannel().mo16021trySendJP2dKIU(new DragEvent.DragDelta(dragAmount, false, null));
    }

    private final void sendDragStopped(PointerInputChange change) {
        VelocityTrackerKt.addPointerInputChange(requireVelocityTracker(), change);
        float maximumFlingVelocity = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration())).getMaximumFlingVelocity();
        long jM9600calculateVelocityAH228Gc = requireVelocityTracker().m9600calculateVelocityAH228Gc(VelocityKt.Velocity(maximumFlingVelocity, maximumFlingVelocity));
        requireVelocityTracker().resetTracking();
        requireChannel().mo16021trySendJP2dKIU(new DragEvent.DragStopped(DraggableKt.m2295toValidVelocityTH1AsA0(jM9600calculateVelocityAH228Gc), false, null));
        this.isListeningForPointerInputEvents = false;
    }

    private final void sendDragCancelled() {
        requireChannel().mo16021trySendJP2dKIU(DragEvent.DragCancelled.INSTANCE);
    }

    public final void onDragEvent(DragEvent event) {
        if ((event instanceof DragEvent.DragStarted) && !this.isListeningForEvents) {
            this.isListeningForEvents = true;
            startListeningForEvents();
        }
        requireChannel().mo16021trySendJP2dKIU(event);
    }
}
