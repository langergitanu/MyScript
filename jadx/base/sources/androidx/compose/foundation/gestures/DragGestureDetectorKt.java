package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.p004ui.geometry.InlineClassHelperKt;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p004ui.input.pointer.PointerEvent;
import androidx.compose.p004ui.input.pointer.PointerEventKt;
import androidx.compose.p004ui.input.pointer.PointerEventPass;
import androidx.compose.p004ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.p004ui.input.pointer.PointerId;
import androidx.compose.p004ui.input.pointer.PointerInputChange;
import androidx.compose.p004ui.input.pointer.PointerInputScope;
import androidx.compose.p004ui.input.pointer.PointerType;
import androidx.compose.p004ui.platform.ViewConfiguration;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: DragGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001aV\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000426\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b\r\u0010\u000e\u001a0\u0010\u000f\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0012H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0080\u0001\u0010\u0018\u001a\u00020\f*\u00020\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00122\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\u001f\u001aè\u0001\u0010\u0018\u001a\u00020\f*\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!2M\b\u0002\u0010\u001a\u001aG\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\f0\"2#\b\u0002\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f0\u00122\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010'\u001a\u008e\u0001\u0010(\u001a\u00020\f*\u00020\u00022\u0006\u0010)\u001a\u00020\u00012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c2\b\u0010 \u001a\u0004\u0018\u00010!2\u001e\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\"2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0012H\u0080@¢\u0006\u0002\u0010*\u001a\u0080\u0001\u0010+\u001a\u00020\f*\u00020\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00122\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\u001f\u001aV\u0010,\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000426\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110-¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b.\u0010\u000e\u001a^\u0010/\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00100\u001a\u00020126\u00102\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110-¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b3\u00104\u001a0\u00105\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0012H\u0086@¢\u0006\u0004\b6\u0010\u0014\u001a\u001e\u00107\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b8\u0010\u0017\u001a\u0080\u0001\u00109\u001a\u00020\f*\u00020\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00122\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c26\u0010:\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110-¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\u001f\u001aV\u0010;\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000426\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110-¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b<\u0010\u000e\u001a^\u0010=\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00100\u001a\u00020126\u00102\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110-¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b>\u00104\u001a0\u0010?\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0012H\u0086@¢\u0006\u0004\b@\u0010\u0014\u001a\u001e\u0010A\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bB\u0010\u0017\u001a\u0080\u0001\u0010C\u001a\u00020\f*\u00020\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00122\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c26\u0010D\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110-¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\u001f\u001aP\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u00122\b\u0010E\u001a\u0004\u0018\u00010!2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u0012H\u0080H¢\u0006\u0004\bG\u0010H\u001a2\u0010I\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u0012H\u0082H¢\u0006\u0004\bK\u0010\u0014\u001aT\u0010L\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00100\u001a\u0002012\b\u0010E\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010M\u001a\u00020\n2\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u0006H\u0080H¢\u0006\u0004\bN\u0010O\u001a$\u0010P\u001a\u00020\u0010*\u00020\u00022\u0006\u0010M\u001a\u00020\u00012\b\b\u0002\u0010Q\u001a\u00020RH\u0080@¢\u0006\u0002\u0010S\u001a\u001e\u0010T\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bU\u0010\u0017\u001a\u001b\u0010V\u001a\u00020\u0010*\u00020W2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0004\bX\u0010Y\u001a\u001b\u0010_\u001a\u00020-*\u00020`2\u0006\u00100\u001a\u000201H\u0000¢\u0006\u0004\ba\u0010b\"\u0010\u0010Z\u001a\u00020[X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\\\"\u0010\u0010]\u001a\u00020[X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\\\"\u000e\u0010^\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010c\u001a\u00020dX\u0082T¢\u0006\u0002\n\u0000¨\u0006e"}, m1599d2 = {"awaitTouchSlopOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "onTouchSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "Landroidx/compose/ui/geometry/Offset;", "overSlop", "", "awaitTouchSlopOrCancellation-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "drag", "", "onDrag", "Lkotlin/Function1;", "drag-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrCancellation", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "orientationLock", "Landroidx/compose/foundation/gestures/Orientation;", "Lkotlin/Function3;", "down", "slopTriggerChange", "overSlopOffset", "shouldAwaitTouchSlop", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragGesture", "initialDown", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPress", "awaitVerticalTouchSlopOrCancellation", "", "awaitVerticalTouchSlopOrCancellation-jO51t88", "awaitVerticalPointerSlopOrCancellation", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "awaitVerticalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verticalDrag", "verticalDrag-jO51t88", "awaitVerticalDragOrCancellation", "awaitVerticalDragOrCancellation-rnUCldI", "detectVerticalDragGestures", "onVerticalDrag", "awaitHorizontalTouchSlopOrCancellation", "awaitHorizontalTouchSlopOrCancellation-jO51t88", "awaitHorizontalPointerSlopOrCancellation", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "horizontalDrag", "horizontalDrag-jO51t88", "awaitHorizontalDragOrCancellation", "awaitHorizontalDragOrCancellation-rnUCldI", "detectHorizontalDragGestures", "onHorizontalDrag", "orientation", "motionConsumed", "drag-VnAYq1g", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrUp", "hasDragged", "awaitDragOrUp-jO51t88", "awaitPointerSlopOrCancellation", "initialPositionChange", "awaitPointerSlopOrCancellation-6ksA65w", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILandroidx/compose/foundation/gestures/Orientation;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitAllPointersUpWithSlopDetection", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLongPressOrCancellation", "awaitLongPressOrCancellation-rnUCldI", "isPointerUp", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "mouseSlop", "Landroidx/compose/ui/unit/Dp;", "F", "defaultTouchSlop", "mouseToTouchSlopRatio", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "GestureAngleThreshold", "", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DragGestureDetectorKt {
    private static final int GestureAngleThreshold = 30;
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1 */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", m1609f = "DragGestureDetector.kt", m1610i = {0, 0, 0, 0, 0, 0}, m1611l = {921}, m1612m = "awaitAllPointersUpWithSlopDetection", m1613n = {"$this$awaitAllPointersUpWithSlopDetection", "pass", "pointer", "touchSlopDetector", "pointerSlopReached", "touchSlop"}, m1615s = {"L$0", "L$1", "L$2", "L$3", "I$0", "F$0"}, m1616v = 1)
    static final class C03801 extends ContinuationImpl {
        float F$0;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C03801(Continuation<? super C03801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureDetectorKt.awaitAllPointersUpWithSlopDetection(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$processDragGesture$1 */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", m1609f = "DragGestureDetector.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6}, m1611l = {284, 1172, 1213, 307, 1252, 1294, 1306}, m1612m = "processDragGesture", m1613n = {"$this$processDragGesture", "initialDown", "orientationLock", "onDragStart", "onDrag", "onDragCancel", "onDragEnd", "awaitTouchSlop", "$this$processDragGesture", "orientationLock", "onDragStart", "onDrag", "onDragCancel", "onDragEnd", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w_u24default$iv", "pointer$iv", "touchSlopDetector$iv", "touchSlop$iv", "$this$processDragGesture", "orientationLock", "onDragStart", "onDrag", "onDragCancel", "onDragEnd", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w_u24default$iv", "pointer$iv", "touchSlopDetector$iv", "dragEvent$iv", "touchSlop$iv", "$this$processDragGesture", "orientationLock", "onDragStart", "onDrag", "onDragCancel", "onDragEnd", "down", "drag", "overSlop", "$this$processDragGesture", "orientationLock", "onDragStart", "onDrag", "onDragCancel", "onDragEnd", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w$iv", "pointer$iv", "touchSlopDetector$iv", "touchSlop$iv", "$this$processDragGesture", "orientationLock", "onDragStart", "onDrag", "onDragCancel", "onDragEnd", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w$iv", "pointer$iv", "touchSlopDetector$iv", "dragEvent$iv", "touchSlop$iv", "onDrag", "onDragCancel", "onDragEnd", "$this$drag_u2dVnAYq1g$iv", "$this$awaitDragOrUp_u2djO51t88$iv$iv", "pointer$iv$iv"}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "F$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "F$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "F$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "F$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, m1616v = 1)
    static final class C03901 extends ContinuationImpl {
        float F$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C03901(Continuation<? super C03901> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureDetectorKt.processDragGesture(null, null, null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean detectDragGestures$lambda$5() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean detectDragGestures$lambda$9() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ef A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x017f -> B:61:0x0184). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m2272awaitTouchSlopOrCancellationjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
        float fM2281pointerSlopE8SPZFQ;
        Function2<? super PointerInputChange, ? super Offset, Unit> function22;
        Ref.LongRef longRef;
        DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitTouchSlopOrCancellation$12;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        float f;
        TouchSlopDetector touchSlopDetector2;
        int size;
        int i;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        int i2;
        Object objAwaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitTouchSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$1 = (DragGestureDetectorKt$awaitTouchSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitTouchSlopOrCancellation$1 = new DragGestureDetectorKt$awaitTouchSlopOrCancellation$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.label;
        int i4 = 1;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            int iM9572getTouchT8wyACA = PointerType.INSTANCE.m9572getTouchT8wyACA();
            long jM7919getZeroF1C5BW0 = Offset.INSTANCE.m7919getZeroF1C5BW0();
            if (m2280isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                return null;
            }
            fM2281pointerSlopE8SPZFQ = m2281pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), iM9572getTouchT8wyACA);
            Ref.LongRef longRef2 = new Ref.LongRef();
            longRef2.element = j;
            TouchSlopDetector touchSlopDetector3 = new TouchSlopDetector(null, jM7919getZeroF1C5BW0, null);
            function22 = function2;
            longRef = longRef2;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
            touchSlopDetector = touchSlopDetector3;
            awaitPointerEventScope2 = awaitPointerEventScope;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = null;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = fM2281pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = i4;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, i4, null);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i3 == 1) {
            float f2 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.F$0;
            TouchSlopDetector touchSlopDetector4 = (TouchSlopDetector) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$3;
            Ref.LongRef longRef3 = (Ref.LongRef) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$2;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$1;
            Function2<? super PointerInputChange, ? super Offset, Unit> function23 = (Function2) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj);
            f = f2;
            touchSlopDetector2 = touchSlopDetector4;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            function22 = function23;
            longRef = longRef3;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
            PointerEvent pointerEvent = (PointerEvent) obj;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            i = 0;
            while (true) {
                if (i < size) {
                }
                i = i2 + 1;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 != null) {
                return null;
            }
            if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
            }
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = null;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = fM2281pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = i4;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, i4, null);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i3 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        float f3 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.F$0;
        PointerInputChange pointerInputChange4 = (PointerInputChange) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$4;
        TouchSlopDetector touchSlopDetector5 = (TouchSlopDetector) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$3;
        longRef = (Ref.LongRef) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$1;
        Function2<? super PointerInputChange, ? super Offset, Unit> function24 = (Function2) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$0;
        ResultKt.throwOnFailure(obj);
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
        touchSlopDetector = touchSlopDetector5;
        char c = 2;
        int i5 = 1;
        fM2281pointerSlopE8SPZFQ = f3;
        awaitPointerEventScope2 = awaitPointerEventScope4;
        if (!pointerInputChange4.isConsumed()) {
            return null;
        }
        i4 = i5;
        function22 = function24;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = longRef;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = null;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = fM2281pointerSlopE8SPZFQ;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = i4;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, i4, null);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
            f = fM2281pointerSlopE8SPZFQ;
            touchSlopDetector2 = touchSlopDetector;
            obj = objAwaitPointerEvent$default;
            PointerEvent pointerEvent2 = (PointerEvent) obj;
            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
            size = changes2.size();
            i = 0;
            while (true) {
                if (i < size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes2.get(i);
                i2 = i;
                if (PointerId.m9471equalsimpl0(pointerInputChange.getId(), longRef.element)) {
                    break;
                }
                i = i2 + 1;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 != null || pointerInputChange2.isConsumed()) {
                return null;
            }
            if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size2 = changes3.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size2) {
                        pointerInputChange3 = null;
                        break;
                    }
                    pointerInputChange3 = changes3.get(i6);
                    if (pointerInputChange3.getPressed()) {
                        break;
                    }
                    i6++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange3;
                if (pointerInputChange5 == null) {
                    return null;
                }
                longRef.element = pointerInputChange5.getId();
                i4 = 1;
                touchSlopDetector = touchSlopDetector2;
                fM2281pointerSlopE8SPZFQ = f;
            } else {
                long jM2414getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m2414getPostSlopOffsetqto3Fdw$default(touchSlopDetector2, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange2), f, false, 4, null);
                if ((9223372034707292159L & jM2414getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    function22.invoke(pointerInputChange2, Offset.m7892boximpl(jM2414getPostSlopOffsetqto3Fdw$default));
                    if (pointerInputChange2.isConsumed()) {
                        return pointerInputChange2;
                    }
                    TouchSlopDetector.m2415resetk4lQ0M$default(touchSlopDetector2, 0L, 1, null);
                    i4 = 1;
                    touchSlopDetector = touchSlopDetector2;
                    fM2281pointerSlopE8SPZFQ = f;
                } else {
                    i5 = 1;
                    PointerEventPass pointerEventPass = PointerEventPass.Final;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = longRef;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = touchSlopDetector2;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = pointerInputChange2;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = f;
                    c = 2;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = 2;
                    if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12) != coroutine_suspended) {
                        TouchSlopDetector touchSlopDetector6 = touchSlopDetector2;
                        function24 = function22;
                        pointerInputChange4 = pointerInputChange2;
                        touchSlopDetector = touchSlopDetector6;
                        fM2281pointerSlopE8SPZFQ = f;
                        if (!pointerInputChange4.isConsumed()) {
                        }
                    }
                }
            }
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = null;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = fM2281pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = i4;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, i4, null);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0049 -> B:18:0x004c). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: drag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m2278dragjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Continuation<? super Boolean> continuation) {
        DragGestureDetectorKt$drag$1 dragGestureDetectorKt$drag$1;
        PointerInputChange pointerInputChange;
        if (continuation instanceof DragGestureDetectorKt$drag$1) {
            dragGestureDetectorKt$drag$1 = (DragGestureDetectorKt$drag$1) continuation;
            if ((dragGestureDetectorKt$drag$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$drag$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$drag$1 = new DragGestureDetectorKt$drag$1(continuation);
            }
        }
        Object objM2263awaitDragOrCancellationrnUCldI = dragGestureDetectorKt$drag$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = dragGestureDetectorKt$drag$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objM2263awaitDragOrCancellationrnUCldI);
            dragGestureDetectorKt$drag$1.L$0 = awaitPointerEventScope;
            dragGestureDetectorKt$drag$1.L$1 = function1;
            dragGestureDetectorKt$drag$1.label = 1;
            objM2263awaitDragOrCancellationrnUCldI = m2263awaitDragOrCancellationrnUCldI(awaitPointerEventScope, j, dragGestureDetectorKt$drag$1);
            if (objM2263awaitDragOrCancellationrnUCldI == coroutine_suspended) {
            }
            pointerInputChange = (PointerInputChange) objM2263awaitDragOrCancellationrnUCldI;
            if (pointerInputChange == null) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Function1<? super PointerInputChange, Unit> function12 = (Function1) dragGestureDetectorKt$drag$1.L$1;
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) dragGestureDetectorKt$drag$1.L$0;
            ResultKt.throwOnFailure(objM2263awaitDragOrCancellationrnUCldI);
            function1 = function12;
            awaitPointerEventScope = awaitPointerEventScope2;
            pointerInputChange = (PointerInputChange) objM2263awaitDragOrCancellationrnUCldI;
            if (pointerInputChange == null) {
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                    return Boxing.boxBoolean(true);
                }
                function1.invoke(pointerInputChange);
                j = pointerInputChange.getId();
                dragGestureDetectorKt$drag$1.L$0 = awaitPointerEventScope;
                dragGestureDetectorKt$drag$1.L$1 = function1;
                dragGestureDetectorKt$drag$1.label = 1;
                objM2263awaitDragOrCancellationrnUCldI = m2263awaitDragOrCancellationrnUCldI(awaitPointerEventScope, j, dragGestureDetectorKt$drag$1);
                if (objM2263awaitDragOrCancellationrnUCldI == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pointerInputChange = (PointerInputChange) objM2263awaitDragOrCancellationrnUCldI;
                if (pointerInputChange == null) {
                    return Boxing.boxBoolean(false);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d1, code lost:
    
        if (androidx.compose.p004ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r11) != false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:22:0x006d). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m2263awaitDragOrCancellationrnUCldI(AwaitPointerEventScope awaitPointerEventScope, long j, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitDragOrCancellation$1 dragGestureDetectorKt$awaitDragOrCancellation$1;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope2;
        Object objAwaitPointerEvent$default;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$awaitDragOrCancellation$1) {
            dragGestureDetectorKt$awaitDragOrCancellation$1 = (DragGestureDetectorKt$awaitDragOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitDragOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitDragOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitDragOrCancellation$1 = new DragGestureDetectorKt$awaitDragOrCancellation$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$awaitDragOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = dragGestureDetectorKt$awaitDragOrCancellation$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitDragOrCancellation$1.L$1;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitDragOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj);
            Ref.LongRef longRef3 = longRef2;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            PointerEvent pointerEvent = (PointerEvent) obj;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 < size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i3);
                if (PointerId.m9471equalsimpl0(pointerInputChange.getId(), longRef3.element)) {
                    break;
                }
                i3++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null) {
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i2 >= size2) {
                            pointerInputChange2 = null;
                            break;
                        }
                        pointerInputChange2 = changes2.get(i2);
                        if (pointerInputChange2.getPressed()) {
                            break;
                        }
                        i2++;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange2;
                    if (pointerInputChange4 != null) {
                        longRef3.element = pointerInputChange4.getId();
                        longRef = longRef3;
                    }
                }
                dragGestureDetectorKt$awaitDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                dragGestureDetectorKt$awaitDragOrCancellation$1.L$1 = longRef;
                dragGestureDetectorKt$awaitDragOrCancellation$1.label = 1;
                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitDragOrCancellation$1, 1, null);
                if (objAwaitPointerEvent$default != coroutine_suspended) {
                    return coroutine_suspended;
                }
                Ref.LongRef longRef4 = longRef;
                obj = objAwaitPointerEvent$default;
                longRef3 = longRef4;
                PointerEvent pointerEvent2 = (PointerEvent) obj;
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size3 = changes3.size();
                int i22 = 0;
                int i32 = 0;
                while (true) {
                    if (i32 < size3) {
                    }
                    i32++;
                }
                PointerInputChange pointerInputChange32 = pointerInputChange;
                if (pointerInputChange32 == null) {
                    pointerInputChange32 = null;
                }
            }
            if (pointerInputChange32 == null || pointerInputChange32.isConsumed()) {
                return null;
            }
            return pointerInputChange32;
        }
        ResultKt.throwOnFailure(obj);
        if (m2280isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        longRef = new Ref.LongRef();
        longRef.element = j;
        awaitPointerEventScope2 = awaitPointerEventScope;
        dragGestureDetectorKt$awaitDragOrCancellation$1.L$0 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitDragOrCancellation$1.L$1 = longRef;
        dragGestureDetectorKt$awaitDragOrCancellation$1.label = 1;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitDragOrCancellation$1, 1, null);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
        }
    }

    public static /* synthetic */ Object detectDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return DragGestureDetectorKt.detectDragGestures$lambda$0((Offset) obj2);
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function02;
        return detectDragGestures(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit detectDragGestures$lambda$0(Offset offset) {
        return Unit.INSTANCE;
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, final Function1<? super Offset, Unit> function1, final Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object objDetectDragGestures = detectDragGestures(pointerInputScope, null, new Function3() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return DragGestureDetectorKt.detectDragGestures$lambda$3(function1, (PointerInputChange) obj, (PointerInputChange) obj2, (Offset) obj3);
            }
        }, new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DragGestureDetectorKt.detectDragGestures$lambda$4(function0, (PointerInputChange) obj);
            }
        }, function02, new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DragGestureDetectorKt.detectDragGestures$lambda$5());
            }
        }, function2, continuation);
        return objDetectDragGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectDragGestures : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit detectDragGestures$lambda$3(Function1 function1, PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, Offset offset) {
        function1.invoke(Offset.m7892boximpl(pointerInputChange2.getPosition()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit detectDragGestures$lambda$4(Function0 function0, PointerInputChange pointerInputChange) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectDragGestures$default(PointerInputScope pointerInputScope, Orientation orientation, Function3 function3, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function3 = new Function3() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return DragGestureDetectorKt.detectDragGestures$lambda$6((PointerInputChange) obj2, (PointerInputChange) obj3, (Offset) obj4);
                }
            };
        }
        Function3 function32 = function3;
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return DragGestureDetectorKt.detectDragGestures$lambda$7((PointerInputChange) obj2);
                }
            };
        }
        Function1 function12 = function1;
        if ((i & 8) != 0) {
            function0 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function0;
        if ((i & 16) != 0) {
            function02 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(DragGestureDetectorKt.detectDragGestures$lambda$9());
                }
            };
        }
        return detectDragGestures(pointerInputScope, orientation, function32, function12, function03, function02, function2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit detectDragGestures$lambda$6(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, Offset offset) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit detectDragGestures$lambda$7(PointerInputChange pointerInputChange) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$13 */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$13", m1609f = "DragGestureDetector.kt", m1610i = {0}, m1611l = {248, 249}, m1612m = "invokeSuspend", m1613n = {"$this$awaitEachGesture"}, m1615s = {"L$0"}, m1616v = 1)
    static final class C038113 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function1<PointerInputChange, Unit> $onDragEnd;
        final /* synthetic */ Function3<PointerInputChange, PointerInputChange, Offset, Unit> $onDragStart;
        final /* synthetic */ Orientation $orientationLock;
        final /* synthetic */ Function0<Boolean> $shouldAwaitTouchSlop;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C038113(Function0<Boolean> function0, Orientation orientation, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function02, Function1<? super PointerInputChange, Unit> function1, Continuation<? super C038113> continuation) {
            super(2, continuation);
            this.$shouldAwaitTouchSlop = function0;
            this.$orientationLock = orientation;
            this.$onDragStart = function3;
            this.$onDrag = function2;
            this.$onDragCancel = function02;
            this.$onDragEnd = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C038113 c038113 = new C038113(this.$shouldAwaitTouchSlop, this.$orientationLock, this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
            c038113.L$0 = obj;
            return c038113;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C038113) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0057, code lost:
        
            if (androidx.compose.foundation.gestures.DragGestureDetectorKt.processDragGesture(r1, (androidx.compose.p004ui.input.pointer.PointerInputChange) r13, r12.$shouldAwaitTouchSlop, r12.$orientationLock, r12.$onDragStart, r12.$onDrag, r12.$onDragCancel, r12.$onDragEnd, r12) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AwaitPointerEventScope awaitPointerEventScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                this.L$0 = awaitPointerEventScope;
                this.label = 1;
                obj = TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, false, PointerEventPass.Initial, this);
                if (obj != coroutine_suspended) {
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
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.L$0 = null;
            this.label = 2;
        }
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, Orientation orientation, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function1<? super PointerInputChange, Unit> function1, Function0<Unit> function0, Function0<Boolean> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C038113(function02, orientation, function3, function2, function0, function1, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:211:0x0723, code lost:
    
        if (r1 == false) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x023b, code lost:
    
        if (r2 == false) goto L84;
     */
    /* JADX WARN: Path cross not found for [B:129:0x0531, B:131:0x053f], limit reached: 238 */
    /* JADX WARN: Path cross not found for [B:134:0x0546, B:129:0x0531], limit reached: 238 */
    /* JADX WARN: Path cross not found for [B:188:0x06d0, B:199:0x06fd], limit reached: 238 */
    /* JADX WARN: Removed duplicated region for block: B:106:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x054c  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x057c  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0615  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0636  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x069c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x06c8  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x06ca  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x072b  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0738  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x073d  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0741  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0745  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x06be A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x044f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0525 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x02e4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:250:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:252:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:255:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0422  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x0446 -> B:90:0x03ec). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:0x049a -> B:161:0x0610). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:157:0x05fa -> B:158:0x0602). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:165:0x0621 -> B:84:0x03c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:174:0x0689 -> B:176:0x068c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0257 -> B:77:0x03a8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x02ed -> B:76:0x03a7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x0359 -> B:77:0x03a8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x039e -> B:73:0x03a0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object processDragGesture(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, Function0<Boolean> function0, Orientation orientation, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function02, Function1<? super PointerInputChange, Unit> function1, Continuation<? super Unit> continuation) {
        C03901 c03901;
        long j;
        long j2;
        PointerInputChange pointerInputChange2;
        Orientation orientation2;
        Function2<? super PointerInputChange, ? super Offset, Unit> function22;
        Function0<Unit> function03;
        Function1<? super PointerInputChange, Unit> function12;
        boolean z;
        Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function32;
        AwaitPointerEventScope awaitPointerEventScope2;
        PointerInputChange pointerInputChange3;
        Ref.LongRef longRef;
        float fM2281pointerSlopE8SPZFQ;
        Ref.LongRef longRef2;
        Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function33;
        Ref.LongRef longRef3;
        AwaitPointerEventScope awaitPointerEventScope3;
        Function1<? super PointerInputChange, Unit> function13;
        Function0<Unit> function04;
        Object obj;
        TouchSlopDetector touchSlopDetector;
        PointerInputChange pointerInputChange4;
        PointerInputChange pointerInputChange5;
        TouchSlopDetector touchSlopDetector2;
        Ref.LongRef longRef4;
        PointerInputChange pointerInputChange6;
        int i;
        int i2;
        Ref.LongRef longRef5;
        PointerInputChange pointerInputChange7;
        PointerInputChange pointerInputChange8;
        Function1<? super PointerInputChange, Unit> function14;
        Function0<Unit> function05;
        Function2<? super PointerInputChange, ? super Offset, Unit> function23;
        Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function34;
        Orientation orientation3;
        AwaitPointerEventScope awaitPointerEventScope4;
        float f;
        Ref.LongRef longRef6;
        Function0<Unit> function06;
        Orientation orientation4;
        TouchSlopDetector touchSlopDetector3;
        Ref.LongRef longRef7;
        AwaitPointerEventScope awaitPointerEventScope5;
        List<PointerInputChange> changes;
        int size;
        int i3;
        Object obj2;
        TouchSlopDetector touchSlopDetector4;
        PointerInputChange pointerInputChange9;
        PointerInputChange pointerInputChange10;
        TouchSlopDetector touchSlopDetector5;
        Object obj3;
        PointerInputChange pointerInputChange11;
        float fM2281pointerSlopE8SPZFQ2;
        AwaitPointerEventScope awaitPointerEventScope6;
        PointerInputChange pointerInputChange12;
        PointerInputChange pointerInputChange13;
        List<PointerInputChange> list;
        int i4;
        int size2;
        int i5;
        int size3;
        int i6;
        Function2<? super PointerInputChange, ? super Offset, Unit> function24;
        Function0<Unit> function07;
        Function1<? super PointerInputChange, Unit> function15;
        AwaitPointerEventScope awaitPointerEventScope7;
        AwaitPointerEventScope awaitPointerEventScope8;
        Orientation orientation5;
        Ref.LongRef longRef8;
        PointerInputChange pointerInputChange14;
        PointerEvent pointerEvent;
        int size4;
        int i7;
        PointerEvent pointerEvent2;
        Object obj4;
        PointerInputChange pointerInputChange15;
        PointerInputChange pointerInputChange16;
        PointerInputChange pointerInputChange17;
        if (continuation instanceof C03901) {
            c03901 = (C03901) continuation;
            if ((c03901.label & Integer.MIN_VALUE) != 0) {
                c03901.label -= Integer.MIN_VALUE;
            } else {
                c03901 = new C03901(continuation);
            }
        }
        C03901 c039012 = c03901;
        Object objAwaitPointerEvent$default = c039012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c039012.label) {
            case 0:
                j = InlineClassHelperKt.UnspecifiedPackedFloats;
                j2 = 9223372034707292159L;
                ResultKt.throwOnFailure(objAwaitPointerEvent$default);
                boolean zBooleanValue = function0.invoke().booleanValue();
                if (!zBooleanValue) {
                    pointerInputChange.consume();
                }
                c039012.L$0 = awaitPointerEventScope;
                pointerInputChange2 = pointerInputChange;
                c039012.L$1 = pointerInputChange2;
                orientation2 = orientation;
                c039012.L$2 = orientation2;
                c039012.L$3 = function3;
                function22 = function2;
                c039012.L$4 = function22;
                function03 = function02;
                c039012.L$5 = function03;
                function12 = function1;
                c039012.L$6 = function12;
                c039012.Z$0 = zBooleanValue;
                c039012.label = 1;
                Object objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, c039012, 2, null);
                if (objAwaitFirstDown$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                z = zBooleanValue;
                objAwaitPointerEvent$default = objAwaitFirstDown$default;
                function32 = function3;
                awaitPointerEventScope2 = awaitPointerEventScope;
                pointerInputChange3 = (PointerInputChange) objAwaitPointerEvent$default;
                longRef = new Ref.LongRef();
                longRef.element = Offset.INSTANCE.m7919getZeroF1C5BW0();
                break;
                break;
            case 1:
                j = InlineClassHelperKt.UnspecifiedPackedFloats;
                j2 = 9223372034707292159L;
                z = c039012.Z$0;
                Function1<? super PointerInputChange, Unit> function16 = (Function1) c039012.L$6;
                Function0<Unit> function08 = (Function0) c039012.L$5;
                Function2<? super PointerInputChange, ? super Offset, Unit> function25 = (Function2) c039012.L$4;
                function32 = (Function3) c039012.L$3;
                Orientation orientation6 = (Orientation) c039012.L$2;
                PointerInputChange pointerInputChange18 = (PointerInputChange) c039012.L$1;
                awaitPointerEventScope2 = (AwaitPointerEventScope) c039012.L$0;
                ResultKt.throwOnFailure(objAwaitPointerEvent$default);
                orientation2 = orientation6;
                pointerInputChange2 = pointerInputChange18;
                function12 = function16;
                function03 = function08;
                function22 = function25;
                pointerInputChange3 = (PointerInputChange) objAwaitPointerEvent$default;
                longRef = new Ref.LongRef();
                longRef.element = Offset.INSTANCE.m7919getZeroF1C5BW0();
                break;
            case 2:
                j = InlineClassHelperKt.UnspecifiedPackedFloats;
                j2 = 9223372034707292159L;
                fM2281pointerSlopE8SPZFQ = c039012.F$0;
                TouchSlopDetector touchSlopDetector6 = (TouchSlopDetector) c039012.L$10;
                Ref.LongRef longRef9 = (Ref.LongRef) c039012.L$9;
                AwaitPointerEventScope awaitPointerEventScope9 = (AwaitPointerEventScope) c039012.L$8;
                longRef2 = (Ref.LongRef) c039012.L$7;
                PointerInputChange pointerInputChange19 = (PointerInputChange) c039012.L$6;
                Function1<? super PointerInputChange, Unit> function17 = (Function1) c039012.L$5;
                Function0<Unit> function09 = (Function0) c039012.L$4;
                function22 = (Function2) c039012.L$3;
                function33 = (Function3) c039012.L$2;
                Orientation orientation7 = (Orientation) c039012.L$1;
                AwaitPointerEventScope awaitPointerEventScope10 = (AwaitPointerEventScope) c039012.L$0;
                ResultKt.throwOnFailure(objAwaitPointerEvent$default);
                longRef3 = longRef9;
                awaitPointerEventScope3 = awaitPointerEventScope10;
                function13 = function17;
                orientation2 = orientation7;
                function04 = function09;
                awaitPointerEventScope2 = awaitPointerEventScope9;
                PointerEvent pointerEvent3 = (PointerEvent) objAwaitPointerEvent$default;
                List<PointerInputChange> changes2 = pointerEvent3.getChanges();
                int size5 = changes2.size();
                float f2 = fM2281pointerSlopE8SPZFQ;
                int i8 = 0;
                while (true) {
                    if (i8 >= size5) {
                        PointerInputChange pointerInputChange20 = changes2.get(i8);
                        i = i8;
                        touchSlopDetector = touchSlopDetector6;
                        i2 = size5;
                        obj = coroutine_suspended;
                        if (PointerId.m9471equalsimpl0(pointerInputChange20.getId(), longRef3.element)) {
                            pointerInputChange4 = pointerInputChange20;
                        } else {
                            i8 = i + 1;
                            touchSlopDetector6 = touchSlopDetector;
                            size5 = i2;
                            coroutine_suspended = obj;
                        }
                    } else {
                        obj = coroutine_suspended;
                        touchSlopDetector = touchSlopDetector6;
                        pointerInputChange4 = null;
                    }
                }
                pointerInputChange5 = pointerInputChange4;
                if (pointerInputChange5 != null && !pointerInputChange5.isConsumed()) {
                    if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange5)) {
                        TouchSlopDetector touchSlopDetector7 = touchSlopDetector;
                        long jM2414getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m2414getPostSlopOffsetqto3Fdw$default(touchSlopDetector7, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange5), f2, false, 4, null);
                        fM2281pointerSlopE8SPZFQ = f2;
                        if ((jM2414getPostSlopOffsetqto3Fdw$default & j2) != j) {
                            pointerInputChange5.consume();
                            longRef2.element = jM2414getPostSlopOffsetqto3Fdw$default;
                            if (pointerInputChange5.isConsumed()) {
                                awaitPointerEventScope2 = awaitPointerEventScope3;
                                pointerInputChange3 = pointerInputChange19;
                                coroutine_suspended = obj;
                                if (pointerInputChange5 != null || pointerInputChange5.isConsumed()) {
                                    pointerInputChange2 = pointerInputChange5;
                                    longRef = longRef2;
                                    function32 = function33;
                                    function03 = function04;
                                    function12 = function13;
                                    if (pointerInputChange2 == null) {
                                        List<PointerInputChange> changes3 = awaitPointerEventScope2.getCurrentEvent().getChanges();
                                        int size6 = changes3.size();
                                        for (int i9 = 0; i9 < size6; i9++) {
                                            if (changes3.get(i9).getPressed()) {
                                                pointerInputChange8 = pointerInputChange3;
                                                longRef5 = longRef;
                                                pointerInputChange7 = pointerInputChange2;
                                                function23 = function22;
                                                function14 = function12;
                                                awaitPointerEventScope4 = awaitPointerEventScope2;
                                                orientation3 = orientation2;
                                                function34 = function32;
                                                function05 = function03;
                                                PointerEventPass pointerEventPass = PointerEventPass.Final;
                                                c039012.L$0 = awaitPointerEventScope4;
                                                c039012.L$1 = orientation3;
                                                c039012.L$2 = function34;
                                                c039012.L$3 = function23;
                                                c039012.L$4 = function05;
                                                c039012.L$5 = function14;
                                                c039012.L$6 = pointerInputChange8;
                                                c039012.L$7 = pointerInputChange7;
                                                c039012.L$8 = longRef5;
                                                c039012.L$9 = null;
                                                c039012.L$10 = null;
                                                c039012.L$11 = null;
                                                c039012.label = 4;
                                                objAwaitPointerEvent$default = awaitPointerEventScope4.awaitPointerEvent(pointerEventPass, c039012);
                                                if (objAwaitPointerEvent$default == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                PointerEvent pointerEvent4 = (PointerEvent) objAwaitPointerEvent$default;
                                                List<PointerInputChange> changes4 = pointerEvent4.getChanges();
                                                size2 = changes4.size();
                                                i5 = 0;
                                                while (true) {
                                                    if (i5 < size2) {
                                                        if (changes4.get(i5).isConsumed()) {
                                                            List<PointerInputChange> changes5 = pointerEvent4.getChanges();
                                                            int size7 = changes5.size();
                                                            for (int i10 = 0; i10 < size7; i10++) {
                                                                if (!changes5.get(i10).getPressed()) {
                                                                }
                                                            }
                                                        } else {
                                                            i5++;
                                                        }
                                                    }
                                                }
                                                List<PointerInputChange> changes6 = pointerEvent4.getChanges();
                                                size3 = changes6.size();
                                                for (i6 = 0; i6 < size3; i6++) {
                                                    if (changes6.get(i6).getPressed()) {
                                                        PointerInputChange pointerInputChange21 = (PointerInputChange) CollectionsKt.firstOrNull((List) pointerEvent4.getChanges());
                                                        long jM7907minusMKHz9U = Offset.m7907minusMKHz9U(pointerInputChange21 != null ? pointerInputChange21.getPosition() : Offset.INSTANCE.m7919getZeroF1C5BW0(), pointerInputChange8.getPosition());
                                                        long id = pointerInputChange8.getId();
                                                        int type = pointerInputChange8.getType();
                                                        if (m2280isPointerUpDmW0f2w(awaitPointerEventScope4.getCurrentEvent(), id)) {
                                                            obj3 = coroutine_suspended;
                                                            longRef = longRef5;
                                                            pointerInputChange3 = pointerInputChange8;
                                                            function12 = function14;
                                                            function03 = function05;
                                                            function32 = function34;
                                                            orientation2 = orientation3;
                                                            awaitPointerEventScope2 = awaitPointerEventScope4;
                                                            function22 = function23;
                                                            pointerInputChange2 = null;
                                                            coroutine_suspended = obj3;
                                                            if (pointerInputChange2 == null) {
                                                            }
                                                        } else {
                                                            fM2281pointerSlopE8SPZFQ2 = m2281pointerSlopE8SPZFQ(awaitPointerEventScope4.getViewConfiguration(), type);
                                                            longRef7 = new Ref.LongRef();
                                                            longRef7.element = id;
                                                            touchSlopDetector3 = new TouchSlopDetector(orientation3, jM7907minusMKHz9U, null);
                                                            awaitPointerEventScope5 = awaitPointerEventScope4;
                                                            c039012.L$0 = awaitPointerEventScope5;
                                                            c039012.L$1 = orientation3;
                                                            c039012.L$2 = function34;
                                                            c039012.L$3 = function23;
                                                            c039012.L$4 = function05;
                                                            c039012.L$5 = function14;
                                                            c039012.L$6 = pointerInputChange8;
                                                            c039012.L$7 = longRef5;
                                                            c039012.L$8 = awaitPointerEventScope4;
                                                            c039012.L$9 = longRef7;
                                                            c039012.L$10 = touchSlopDetector3;
                                                            c039012.L$11 = null;
                                                            c039012.F$0 = fM2281pointerSlopE8SPZFQ2;
                                                            c039012.label = 5;
                                                            float f3 = fM2281pointerSlopE8SPZFQ2;
                                                            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope4, null, c039012, 1, null);
                                                            if (objAwaitPointerEvent$default == coroutine_suspended) {
                                                                return coroutine_suspended;
                                                            }
                                                            orientation4 = orientation3;
                                                            function06 = function05;
                                                            longRef6 = longRef5;
                                                            f = f3;
                                                            PointerEvent pointerEvent5 = (PointerEvent) objAwaitPointerEvent$default;
                                                            changes = pointerEvent5.getChanges();
                                                            size = changes.size();
                                                            float f4 = f;
                                                            i3 = 0;
                                                            while (true) {
                                                                if (i3 >= size) {
                                                                    pointerInputChange9 = changes.get(i3);
                                                                    touchSlopDetector4 = touchSlopDetector3;
                                                                    list = changes;
                                                                    i4 = size;
                                                                    obj2 = coroutine_suspended;
                                                                    if (!PointerId.m9471equalsimpl0(pointerInputChange9.getId(), longRef7.element)) {
                                                                        i3++;
                                                                        touchSlopDetector3 = touchSlopDetector4;
                                                                        changes = list;
                                                                        size = i4;
                                                                        coroutine_suspended = obj2;
                                                                    }
                                                                } else {
                                                                    obj2 = coroutine_suspended;
                                                                    touchSlopDetector4 = touchSlopDetector3;
                                                                    pointerInputChange9 = null;
                                                                }
                                                            }
                                                            pointerInputChange10 = pointerInputChange9;
                                                            if (pointerInputChange10 != null && !pointerInputChange10.isConsumed()) {
                                                                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange10)) {
                                                                    TouchSlopDetector touchSlopDetector8 = touchSlopDetector4;
                                                                    touchSlopDetector5 = touchSlopDetector8;
                                                                    if ((TouchSlopDetector.m2414getPostSlopOffsetqto3Fdw$default(touchSlopDetector8, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange10), f4, false, 4, null) & j2) != j) {
                                                                        pointerInputChange10.consume();
                                                                        longRef6.element = PointerEventKt.positionChange(pointerInputChange10);
                                                                        if (pointerInputChange10.isConsumed()) {
                                                                            AwaitPointerEventScope awaitPointerEventScope11 = awaitPointerEventScope5;
                                                                            function03 = function06;
                                                                            awaitPointerEventScope2 = awaitPointerEventScope11;
                                                                            longRef = longRef6;
                                                                            function22 = function23;
                                                                            function32 = function34;
                                                                            orientation2 = orientation4;
                                                                            obj3 = obj2;
                                                                            pointerInputChange2 = pointerInputChange10;
                                                                            pointerInputChange3 = pointerInputChange8;
                                                                            function12 = function14;
                                                                            coroutine_suspended = obj3;
                                                                            if (pointerInputChange2 == null) {
                                                                            }
                                                                        } else {
                                                                            TouchSlopDetector.m2415resetk4lQ0M$default(touchSlopDetector5, 0L, 1, null);
                                                                            fM2281pointerSlopE8SPZFQ2 = f4;
                                                                            longRef5 = longRef6;
                                                                            function05 = function06;
                                                                            orientation3 = orientation4;
                                                                            touchSlopDetector3 = touchSlopDetector5;
                                                                            coroutine_suspended = obj2;
                                                                        }
                                                                    } else {
                                                                        PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                                                                        c039012.L$0 = awaitPointerEventScope5;
                                                                        c039012.L$1 = orientation4;
                                                                        c039012.L$2 = function34;
                                                                        c039012.L$3 = function23;
                                                                        c039012.L$4 = function06;
                                                                        c039012.L$5 = function14;
                                                                        c039012.L$6 = pointerInputChange8;
                                                                        c039012.L$7 = longRef6;
                                                                        c039012.L$8 = awaitPointerEventScope4;
                                                                        c039012.L$9 = longRef7;
                                                                        c039012.L$10 = touchSlopDetector5;
                                                                        c039012.L$11 = pointerInputChange10;
                                                                        c039012.F$0 = f4;
                                                                        c039012.label = 6;
                                                                        Object objAwaitPointerEvent = awaitPointerEventScope4.awaitPointerEvent(pointerEventPass2, c039012);
                                                                        obj3 = obj2;
                                                                        if (objAwaitPointerEvent == obj3) {
                                                                            return obj3;
                                                                        }
                                                                        PointerInputChange pointerInputChange22 = pointerInputChange8;
                                                                        pointerInputChange11 = pointerInputChange10;
                                                                        fM2281pointerSlopE8SPZFQ2 = f4;
                                                                        awaitPointerEventScope6 = awaitPointerEventScope4;
                                                                        pointerInputChange12 = pointerInputChange22;
                                                                        longRef5 = longRef6;
                                                                        function05 = function06;
                                                                        orientation3 = orientation4;
                                                                        if (pointerInputChange11.isConsumed()) {
                                                                            pointerInputChange8 = pointerInputChange12;
                                                                            awaitPointerEventScope4 = awaitPointerEventScope6;
                                                                            coroutine_suspended = obj3;
                                                                            touchSlopDetector3 = touchSlopDetector5;
                                                                        } else {
                                                                            AwaitPointerEventScope awaitPointerEventScope12 = awaitPointerEventScope5;
                                                                            function03 = function05;
                                                                            function32 = function34;
                                                                            orientation2 = orientation3;
                                                                            awaitPointerEventScope2 = awaitPointerEventScope12;
                                                                            longRef = longRef5;
                                                                            function12 = function14;
                                                                            pointerInputChange3 = pointerInputChange12;
                                                                            function22 = function23;
                                                                            pointerInputChange2 = null;
                                                                            coroutine_suspended = obj3;
                                                                            if (pointerInputChange2 == null) {
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    List<PointerInputChange> changes7 = pointerEvent5.getChanges();
                                                                    int size8 = changes7.size();
                                                                    int i11 = 0;
                                                                    while (true) {
                                                                        if (i11 < size8) {
                                                                            pointerInputChange13 = changes7.get(i11);
                                                                            if (!pointerInputChange13.getPressed()) {
                                                                                i11++;
                                                                            }
                                                                        } else {
                                                                            pointerInputChange13 = null;
                                                                        }
                                                                    }
                                                                    PointerInputChange pointerInputChange23 = pointerInputChange13;
                                                                    if (pointerInputChange23 != null) {
                                                                        longRef7.element = pointerInputChange23.getId();
                                                                        fM2281pointerSlopE8SPZFQ2 = f4;
                                                                        longRef5 = longRef6;
                                                                        function05 = function06;
                                                                        orientation3 = orientation4;
                                                                        touchSlopDetector3 = touchSlopDetector4;
                                                                        coroutine_suspended = obj2;
                                                                    }
                                                                }
                                                                c039012.L$0 = awaitPointerEventScope5;
                                                                c039012.L$1 = orientation3;
                                                                c039012.L$2 = function34;
                                                                c039012.L$3 = function23;
                                                                c039012.L$4 = function05;
                                                                c039012.L$5 = function14;
                                                                c039012.L$6 = pointerInputChange8;
                                                                c039012.L$7 = longRef5;
                                                                c039012.L$8 = awaitPointerEventScope4;
                                                                c039012.L$9 = longRef7;
                                                                c039012.L$10 = touchSlopDetector3;
                                                                c039012.L$11 = null;
                                                                c039012.F$0 = fM2281pointerSlopE8SPZFQ2;
                                                                c039012.label = 5;
                                                                float f32 = fM2281pointerSlopE8SPZFQ2;
                                                                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope4, null, c039012, 1, null);
                                                                if (objAwaitPointerEvent$default == coroutine_suspended) {
                                                                }
                                                            }
                                                            AwaitPointerEventScope awaitPointerEventScope13 = awaitPointerEventScope5;
                                                            function03 = function06;
                                                            awaitPointerEventScope2 = awaitPointerEventScope13;
                                                            pointerInputChange3 = pointerInputChange8;
                                                            longRef = longRef6;
                                                            function22 = function23;
                                                            function32 = function34;
                                                            orientation2 = orientation4;
                                                            obj3 = obj2;
                                                            pointerInputChange2 = null;
                                                            function12 = function14;
                                                            coroutine_suspended = obj3;
                                                            if (pointerInputChange2 == null) {
                                                            }
                                                        }
                                                    }
                                                }
                                                pointerInputChange3 = pointerInputChange8;
                                                function12 = function14;
                                                function03 = function05;
                                                function32 = function34;
                                                orientation2 = orientation3;
                                                awaitPointerEventScope2 = awaitPointerEventScope4;
                                                function22 = function23;
                                                pointerInputChange2 = pointerInputChange7;
                                                longRef = longRef5;
                                                if (pointerInputChange2 == null) {
                                                }
                                            }
                                        }
                                    }
                                    if (pointerInputChange2 != null) {
                                        function32.invoke(pointerInputChange3, pointerInputChange2, Offset.m7892boximpl(longRef.element));
                                        function22.invoke(pointerInputChange2, Offset.m7892boximpl(longRef.element));
                                        long id2 = pointerInputChange2.getId();
                                        if (!m2280isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), id2)) {
                                            Orientation orientation8 = null;
                                            Ref.LongRef longRef10 = new Ref.LongRef();
                                            longRef10.element = id2;
                                            orientation5 = orientation8;
                                            longRef8 = longRef10;
                                            awaitPointerEventScope8 = awaitPointerEventScope2;
                                            awaitPointerEventScope7 = awaitPointerEventScope8;
                                            function24 = function22;
                                            function07 = function03;
                                            function15 = function12;
                                            c039012.L$0 = function24;
                                            c039012.L$1 = function07;
                                            c039012.L$2 = function15;
                                            c039012.L$3 = awaitPointerEventScope7;
                                            c039012.L$4 = awaitPointerEventScope8;
                                            c039012.L$5 = longRef8;
                                            c039012.L$6 = null;
                                            c039012.L$7 = null;
                                            c039012.L$8 = null;
                                            c039012.L$9 = null;
                                            c039012.L$10 = null;
                                            c039012.L$11 = null;
                                            c039012.label = 7;
                                            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope8, null, c039012, 1, null);
                                            if (objAwaitPointerEvent$default == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
                                            List<PointerInputChange> changes8 = pointerEvent.getChanges();
                                            size4 = changes8.size();
                                            i7 = 0;
                                            while (true) {
                                                if (i7 >= size4) {
                                                    pointerInputChange15 = changes8.get(i7);
                                                    pointerEvent2 = pointerEvent;
                                                    obj4 = coroutine_suspended;
                                                    if (!PointerId.m9471equalsimpl0(pointerInputChange15.getId(), longRef8.element)) {
                                                        i7++;
                                                        pointerEvent = pointerEvent2;
                                                        coroutine_suspended = obj4;
                                                    }
                                                } else {
                                                    pointerEvent2 = pointerEvent;
                                                    obj4 = coroutine_suspended;
                                                    pointerInputChange15 = null;
                                                }
                                            }
                                            pointerInputChange16 = pointerInputChange15;
                                            if (pointerInputChange16 == null) {
                                                if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange16)) {
                                                    long jPositionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange16);
                                                    break;
                                                } else {
                                                    List<PointerInputChange> changes9 = pointerEvent2.getChanges();
                                                    int size9 = changes9.size();
                                                    int i12 = 0;
                                                    while (true) {
                                                        if (i12 < size9) {
                                                            pointerInputChange17 = changes9.get(i12);
                                                            if (!pointerInputChange17.getPressed()) {
                                                                i12++;
                                                            }
                                                        } else {
                                                            pointerInputChange17 = null;
                                                        }
                                                    }
                                                    PointerInputChange pointerInputChange24 = pointerInputChange17;
                                                    if (pointerInputChange24 != null) {
                                                        longRef8.element = pointerInputChange24.getId();
                                                        coroutine_suspended = obj4;
                                                        c039012.L$0 = function24;
                                                        c039012.L$1 = function07;
                                                        c039012.L$2 = function15;
                                                        c039012.L$3 = awaitPointerEventScope7;
                                                        c039012.L$4 = awaitPointerEventScope8;
                                                        c039012.L$5 = longRef8;
                                                        c039012.L$6 = null;
                                                        c039012.L$7 = null;
                                                        c039012.L$8 = null;
                                                        c039012.L$9 = null;
                                                        c039012.L$10 = null;
                                                        c039012.L$11 = null;
                                                        c039012.label = 7;
                                                        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope8, null, c039012, 1, null);
                                                        if (objAwaitPointerEvent$default == coroutine_suspended) {
                                                        }
                                                        pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
                                                        List<PointerInputChange> changes82 = pointerEvent.getChanges();
                                                        size4 = changes82.size();
                                                        i7 = 0;
                                                        while (true) {
                                                            if (i7 >= size4) {
                                                            }
                                                            i7++;
                                                            pointerEvent = pointerEvent2;
                                                            coroutine_suspended = obj4;
                                                        }
                                                        pointerInputChange16 = pointerInputChange15;
                                                        if (pointerInputChange16 == null) {
                                                            pointerInputChange16 = null;
                                                        }
                                                    }
                                                }
                                            }
                                            if (pointerInputChange16 == null || pointerInputChange16.isConsumed()) {
                                                function12 = function15;
                                                function03 = function07;
                                            } else if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange16)) {
                                                function24.invoke(pointerInputChange16, Offset.m7892boximpl(PointerEventKt.positionChange(pointerInputChange16)));
                                                pointerInputChange16.consume();
                                                long id3 = pointerInputChange16.getId();
                                                orientation8 = orientation5;
                                                id2 = id3;
                                                awaitPointerEventScope2 = awaitPointerEventScope7;
                                                function12 = function15;
                                                function03 = function07;
                                                function22 = function24;
                                                coroutine_suspended = obj4;
                                                Ref.LongRef longRef102 = new Ref.LongRef();
                                                longRef102.element = id2;
                                                orientation5 = orientation8;
                                                longRef8 = longRef102;
                                                awaitPointerEventScope8 = awaitPointerEventScope2;
                                                awaitPointerEventScope7 = awaitPointerEventScope8;
                                                function24 = function22;
                                                function07 = function03;
                                                function15 = function12;
                                                c039012.L$0 = function24;
                                                c039012.L$1 = function07;
                                                c039012.L$2 = function15;
                                                c039012.L$3 = awaitPointerEventScope7;
                                                c039012.L$4 = awaitPointerEventScope8;
                                                c039012.L$5 = longRef8;
                                                c039012.L$6 = null;
                                                c039012.L$7 = null;
                                                c039012.L$8 = null;
                                                c039012.L$9 = null;
                                                c039012.L$10 = null;
                                                c039012.L$11 = null;
                                                c039012.label = 7;
                                                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope8, null, c039012, 1, null);
                                                if (objAwaitPointerEvent$default == coroutine_suspended) {
                                                }
                                                pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
                                                List<PointerInputChange> changes822 = pointerEvent.getChanges();
                                                size4 = changes822.size();
                                                i7 = 0;
                                                while (true) {
                                                    if (i7 >= size4) {
                                                    }
                                                    i7++;
                                                    pointerEvent = pointerEvent2;
                                                    coroutine_suspended = obj4;
                                                }
                                                pointerInputChange16 = pointerInputChange15;
                                                if (pointerInputChange16 == null) {
                                                }
                                                if (pointerInputChange16 == null) {
                                                    if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange16)) {
                                                    }
                                                }
                                                function12 = function15;
                                                function03 = function07;
                                            } else {
                                                pointerInputChange14 = pointerInputChange16;
                                                function12 = function15;
                                                function03 = function07;
                                                if (pointerInputChange14 == null) {
                                                    function03.invoke();
                                                } else {
                                                    function12.invoke(pointerInputChange14);
                                                }
                                            }
                                        }
                                        pointerInputChange14 = null;
                                        if (pointerInputChange14 == null) {
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                                longRef = longRef2;
                                function32 = function33;
                                function03 = function04;
                                function12 = function13;
                                long id4 = pointerInputChange3.getId();
                                int type2 = pointerInputChange3.getType();
                                Ref.LongRef longRef11 = longRef;
                                long jM7919getZeroF1C5BW0 = Offset.INSTANCE.m7919getZeroF1C5BW0();
                                if (m2280isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), id4)) {
                                    function13 = function12;
                                    pointerInputChange5 = null;
                                    function04 = function03;
                                    function33 = function32;
                                    longRef2 = longRef11;
                                    if (pointerInputChange5 != null) {
                                    }
                                    pointerInputChange2 = pointerInputChange5;
                                    longRef = longRef2;
                                    function32 = function33;
                                    function03 = function04;
                                    function12 = function13;
                                    if (pointerInputChange2 == null) {
                                    }
                                    if (pointerInputChange2 != null) {
                                    }
                                    return Unit.INSTANCE;
                                }
                                fM2281pointerSlopE8SPZFQ = m2281pointerSlopE8SPZFQ(awaitPointerEventScope2.getViewConfiguration(), type2);
                                longRef3 = new Ref.LongRef();
                                longRef3.element = id4;
                                touchSlopDetector2 = new TouchSlopDetector(orientation2, jM7919getZeroF1C5BW0, null);
                                longRef4 = longRef11;
                                awaitPointerEventScope3 = awaitPointerEventScope2;
                            } else {
                                TouchSlopDetector.m2415resetk4lQ0M$default(touchSlopDetector7, 0L, 1, null);
                                fM2281pointerSlopE8SPZFQ = fM2281pointerSlopE8SPZFQ;
                                longRef4 = longRef2;
                                pointerInputChange3 = pointerInputChange19;
                                function32 = function33;
                                function03 = function04;
                                function12 = function13;
                                touchSlopDetector2 = touchSlopDetector7;
                                coroutine_suspended = obj;
                            }
                        } else {
                            PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                            c039012.L$0 = awaitPointerEventScope3;
                            c039012.L$1 = orientation2;
                            c039012.L$2 = function33;
                            c039012.L$3 = function22;
                            c039012.L$4 = function04;
                            c039012.L$5 = function13;
                            c039012.L$6 = pointerInputChange19;
                            c039012.L$7 = longRef2;
                            c039012.L$8 = awaitPointerEventScope2;
                            c039012.L$9 = longRef3;
                            c039012.L$10 = touchSlopDetector7;
                            c039012.L$11 = pointerInputChange5;
                            c039012.F$0 = fM2281pointerSlopE8SPZFQ;
                            c039012.label = 3;
                            coroutine_suspended = obj;
                            if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, c039012) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            pointerInputChange3 = pointerInputChange19;
                            touchSlopDetector2 = touchSlopDetector7;
                            if (!pointerInputChange5.isConsumed()) {
                                awaitPointerEventScope2 = awaitPointerEventScope3;
                                pointerInputChange5 = null;
                                if (pointerInputChange5 != null) {
                                }
                                pointerInputChange2 = pointerInputChange5;
                                longRef = longRef2;
                                function32 = function33;
                                function03 = function04;
                                function12 = function13;
                                if (pointerInputChange2 == null) {
                                }
                                if (pointerInputChange2 != null) {
                                }
                                return Unit.INSTANCE;
                            }
                            longRef4 = longRef2;
                            function32 = function33;
                            function03 = function04;
                            function12 = function13;
                        }
                    } else {
                        List<PointerInputChange> changes10 = pointerEvent3.getChanges();
                        int size10 = changes10.size();
                        int i13 = 0;
                        while (true) {
                            if (i13 < size10) {
                                pointerInputChange6 = changes10.get(i13);
                                if (!pointerInputChange6.getPressed()) {
                                    i13++;
                                }
                            } else {
                                pointerInputChange6 = null;
                            }
                        }
                        PointerInputChange pointerInputChange25 = pointerInputChange6;
                        if (pointerInputChange25 != null) {
                            longRef3.element = pointerInputChange25.getId();
                            fM2281pointerSlopE8SPZFQ = f2;
                            longRef4 = longRef2;
                            pointerInputChange3 = pointerInputChange19;
                            function32 = function33;
                            function03 = function04;
                            function12 = function13;
                            touchSlopDetector2 = touchSlopDetector;
                            coroutine_suspended = obj;
                        }
                    }
                    c039012.L$0 = awaitPointerEventScope3;
                    c039012.L$1 = orientation2;
                    c039012.L$2 = function32;
                    c039012.L$3 = function22;
                    c039012.L$4 = function03;
                    c039012.L$5 = function12;
                    c039012.L$6 = pointerInputChange3;
                    c039012.L$7 = longRef4;
                    c039012.L$8 = awaitPointerEventScope2;
                    c039012.L$9 = longRef3;
                    c039012.L$10 = touchSlopDetector2;
                    c039012.L$11 = null;
                    c039012.F$0 = fM2281pointerSlopE8SPZFQ;
                    c039012.label = 2;
                    PointerInputChange pointerInputChange26 = pointerInputChange3;
                    objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, c039012, 1, null);
                    if (objAwaitPointerEvent$default != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function13 = function12;
                    function04 = function03;
                    function33 = function32;
                    longRef2 = longRef4;
                    touchSlopDetector6 = touchSlopDetector2;
                    pointerInputChange19 = pointerInputChange26;
                    PointerEvent pointerEvent32 = (PointerEvent) objAwaitPointerEvent$default;
                    List<PointerInputChange> changes22 = pointerEvent32.getChanges();
                    int size52 = changes22.size();
                    float f22 = fM2281pointerSlopE8SPZFQ;
                    int i82 = 0;
                    while (true) {
                        if (i82 >= size52) {
                        }
                        i82 = i + 1;
                        touchSlopDetector6 = touchSlopDetector;
                        size52 = i2;
                        coroutine_suspended = obj;
                    }
                    pointerInputChange5 = pointerInputChange4;
                    if (pointerInputChange5 != null) {
                        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange5)) {
                        }
                        c039012.L$0 = awaitPointerEventScope3;
                        c039012.L$1 = orientation2;
                        c039012.L$2 = function32;
                        c039012.L$3 = function22;
                        c039012.L$4 = function03;
                        c039012.L$5 = function12;
                        c039012.L$6 = pointerInputChange3;
                        c039012.L$7 = longRef4;
                        c039012.L$8 = awaitPointerEventScope2;
                        c039012.L$9 = longRef3;
                        c039012.L$10 = touchSlopDetector2;
                        c039012.L$11 = null;
                        c039012.F$0 = fM2281pointerSlopE8SPZFQ;
                        c039012.label = 2;
                        PointerInputChange pointerInputChange262 = pointerInputChange3;
                        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, c039012, 1, null);
                        if (objAwaitPointerEvent$default != coroutine_suspended) {
                        }
                    }
                }
                awaitPointerEventScope2 = awaitPointerEventScope3;
                pointerInputChange3 = pointerInputChange19;
                coroutine_suspended = obj;
                pointerInputChange5 = null;
                if (pointerInputChange5 != null) {
                }
                pointerInputChange2 = pointerInputChange5;
                longRef = longRef2;
                function32 = function33;
                function03 = function04;
                function12 = function13;
                if (pointerInputChange2 == null) {
                }
                if (pointerInputChange2 != null) {
                }
                return Unit.INSTANCE;
            case 3:
                j = InlineClassHelperKt.UnspecifiedPackedFloats;
                j2 = 9223372034707292159L;
                fM2281pointerSlopE8SPZFQ = c039012.F$0;
                pointerInputChange5 = (PointerInputChange) c039012.L$11;
                TouchSlopDetector touchSlopDetector9 = (TouchSlopDetector) c039012.L$10;
                longRef3 = (Ref.LongRef) c039012.L$9;
                AwaitPointerEventScope awaitPointerEventScope14 = (AwaitPointerEventScope) c039012.L$8;
                Ref.LongRef longRef12 = (Ref.LongRef) c039012.L$7;
                PointerInputChange pointerInputChange27 = (PointerInputChange) c039012.L$6;
                Function1<? super PointerInputChange, Unit> function18 = (Function1) c039012.L$5;
                Function0<Unit> function010 = (Function0) c039012.L$4;
                Function2<? super PointerInputChange, ? super Offset, Unit> function26 = (Function2) c039012.L$3;
                Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function35 = (Function3) c039012.L$2;
                Orientation orientation9 = (Orientation) c039012.L$1;
                AwaitPointerEventScope awaitPointerEventScope15 = (AwaitPointerEventScope) c039012.L$0;
                ResultKt.throwOnFailure(objAwaitPointerEvent$default);
                function04 = function010;
                function22 = function26;
                function33 = function35;
                pointerInputChange3 = pointerInputChange27;
                orientation2 = orientation9;
                function13 = function18;
                awaitPointerEventScope2 = awaitPointerEventScope14;
                longRef2 = longRef12;
                touchSlopDetector2 = touchSlopDetector9;
                awaitPointerEventScope3 = awaitPointerEventScope15;
                if (!pointerInputChange5.isConsumed()) {
                }
                break;
            case 4:
                j = InlineClassHelperKt.UnspecifiedPackedFloats;
                j2 = 9223372034707292159L;
                longRef5 = (Ref.LongRef) c039012.L$8;
                pointerInputChange7 = (PointerInputChange) c039012.L$7;
                pointerInputChange8 = (PointerInputChange) c039012.L$6;
                function14 = (Function1) c039012.L$5;
                function05 = (Function0) c039012.L$4;
                function23 = (Function2) c039012.L$3;
                function34 = (Function3) c039012.L$2;
                orientation3 = (Orientation) c039012.L$1;
                awaitPointerEventScope4 = (AwaitPointerEventScope) c039012.L$0;
                ResultKt.throwOnFailure(objAwaitPointerEvent$default);
                PointerEvent pointerEvent42 = (PointerEvent) objAwaitPointerEvent$default;
                List<PointerInputChange> changes42 = pointerEvent42.getChanges();
                size2 = changes42.size();
                i5 = 0;
                while (true) {
                    if (i5 < size2) {
                    }
                    i5++;
                }
                List<PointerInputChange> changes62 = pointerEvent42.getChanges();
                size3 = changes62.size();
                while (i6 < size3) {
                }
                pointerInputChange3 = pointerInputChange8;
                function12 = function14;
                function03 = function05;
                function32 = function34;
                orientation2 = orientation3;
                awaitPointerEventScope2 = awaitPointerEventScope4;
                function22 = function23;
                pointerInputChange2 = pointerInputChange7;
                longRef = longRef5;
                if (pointerInputChange2 == null) {
                }
                if (pointerInputChange2 != null) {
                }
                return Unit.INSTANCE;
            case 5:
                j = InlineClassHelperKt.UnspecifiedPackedFloats;
                j2 = 9223372034707292159L;
                f = c039012.F$0;
                TouchSlopDetector touchSlopDetector10 = (TouchSlopDetector) c039012.L$10;
                Ref.LongRef longRef13 = (Ref.LongRef) c039012.L$9;
                AwaitPointerEventScope awaitPointerEventScope16 = (AwaitPointerEventScope) c039012.L$8;
                longRef6 = (Ref.LongRef) c039012.L$7;
                PointerInputChange pointerInputChange28 = (PointerInputChange) c039012.L$6;
                Function1<? super PointerInputChange, Unit> function19 = (Function1) c039012.L$5;
                function06 = (Function0) c039012.L$4;
                Function2<? super PointerInputChange, ? super Offset, Unit> function27 = (Function2) c039012.L$3;
                Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function36 = (Function3) c039012.L$2;
                orientation4 = (Orientation) c039012.L$1;
                AwaitPointerEventScope awaitPointerEventScope17 = (AwaitPointerEventScope) c039012.L$0;
                ResultKt.throwOnFailure(objAwaitPointerEvent$default);
                touchSlopDetector3 = touchSlopDetector10;
                longRef7 = longRef13;
                pointerInputChange8 = pointerInputChange28;
                function23 = function27;
                awaitPointerEventScope4 = awaitPointerEventScope16;
                function14 = function19;
                function34 = function36;
                awaitPointerEventScope5 = awaitPointerEventScope17;
                PointerEvent pointerEvent52 = (PointerEvent) objAwaitPointerEvent$default;
                changes = pointerEvent52.getChanges();
                size = changes.size();
                float f42 = f;
                i3 = 0;
                while (true) {
                    if (i3 >= size) {
                    }
                    i3++;
                    touchSlopDetector3 = touchSlopDetector4;
                    changes = list;
                    size = i4;
                    coroutine_suspended = obj2;
                }
                pointerInputChange10 = pointerInputChange9;
                if (pointerInputChange10 != null) {
                    if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange10)) {
                    }
                    c039012.L$0 = awaitPointerEventScope5;
                    c039012.L$1 = orientation3;
                    c039012.L$2 = function34;
                    c039012.L$3 = function23;
                    c039012.L$4 = function05;
                    c039012.L$5 = function14;
                    c039012.L$6 = pointerInputChange8;
                    c039012.L$7 = longRef5;
                    c039012.L$8 = awaitPointerEventScope4;
                    c039012.L$9 = longRef7;
                    c039012.L$10 = touchSlopDetector3;
                    c039012.L$11 = null;
                    c039012.F$0 = fM2281pointerSlopE8SPZFQ2;
                    c039012.label = 5;
                    float f322 = fM2281pointerSlopE8SPZFQ2;
                    objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope4, null, c039012, 1, null);
                    if (objAwaitPointerEvent$default == coroutine_suspended) {
                    }
                }
                AwaitPointerEventScope awaitPointerEventScope132 = awaitPointerEventScope5;
                function03 = function06;
                awaitPointerEventScope2 = awaitPointerEventScope132;
                pointerInputChange3 = pointerInputChange8;
                longRef = longRef6;
                function22 = function23;
                function32 = function34;
                orientation2 = orientation4;
                obj3 = obj2;
                pointerInputChange2 = null;
                function12 = function14;
                coroutine_suspended = obj3;
                if (pointerInputChange2 == null) {
                }
                if (pointerInputChange2 != null) {
                }
                return Unit.INSTANCE;
            case 6:
                float f5 = c039012.F$0;
                pointerInputChange11 = (PointerInputChange) c039012.L$11;
                TouchSlopDetector touchSlopDetector11 = (TouchSlopDetector) c039012.L$10;
                Ref.LongRef longRef14 = (Ref.LongRef) c039012.L$9;
                AwaitPointerEventScope awaitPointerEventScope18 = (AwaitPointerEventScope) c039012.L$8;
                j = InlineClassHelperKt.UnspecifiedPackedFloats;
                Ref.LongRef longRef15 = (Ref.LongRef) c039012.L$7;
                pointerInputChange12 = (PointerInputChange) c039012.L$6;
                j2 = 9223372034707292159L;
                Function1<? super PointerInputChange, Unit> function110 = (Function1) c039012.L$5;
                Function0<Unit> function011 = (Function0) c039012.L$4;
                Function2<? super PointerInputChange, ? super Offset, Unit> function28 = (Function2) c039012.L$3;
                Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function37 = (Function3) c039012.L$2;
                Orientation orientation10 = (Orientation) c039012.L$1;
                AwaitPointerEventScope awaitPointerEventScope19 = (AwaitPointerEventScope) c039012.L$0;
                ResultKt.throwOnFailure(objAwaitPointerEvent$default);
                touchSlopDetector5 = touchSlopDetector11;
                function14 = function110;
                awaitPointerEventScope5 = awaitPointerEventScope19;
                fM2281pointerSlopE8SPZFQ2 = f5;
                longRef5 = longRef15;
                orientation3 = orientation10;
                function34 = function37;
                function23 = function28;
                obj3 = coroutine_suspended;
                awaitPointerEventScope6 = awaitPointerEventScope18;
                longRef7 = longRef14;
                function05 = function011;
                if (pointerInputChange11.isConsumed()) {
                }
                break;
            case 7:
                longRef8 = (Ref.LongRef) c039012.L$5;
                awaitPointerEventScope8 = (AwaitPointerEventScope) c039012.L$4;
                awaitPointerEventScope7 = (AwaitPointerEventScope) c039012.L$3;
                function15 = (Function1) c039012.L$2;
                function07 = (Function0) c039012.L$1;
                function24 = (Function2) c039012.L$0;
                ResultKt.throwOnFailure(objAwaitPointerEvent$default);
                orientation5 = null;
                pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
                List<PointerInputChange> changes8222 = pointerEvent.getChanges();
                size4 = changes8222.size();
                i7 = 0;
                while (true) {
                    if (i7 >= size4) {
                    }
                    i7++;
                    pointerEvent = pointerEvent2;
                    coroutine_suspended = obj4;
                }
                pointerInputChange16 = pointerInputChange15;
                if (pointerInputChange16 == null) {
                }
                if (pointerInputChange16 == null) {
                }
                function12 = function15;
                function03 = function07;
                pointerInputChange14 = null;
                if (pointerInputChange14 == null) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ Object detectDragGesturesAfterLongPress$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return DragGestureDetectorKt.detectDragGesturesAfterLongPress$lambda$0((Offset) obj2);
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function02;
        return detectDragGesturesAfterLongPress(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit detectDragGesturesAfterLongPress$lambda$0(Offset offset) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5", m1609f = "DragGestureDetector.kt", m1610i = {0, 1, 2}, m1611l = {RendererCapabilities.DECODER_SUPPORT_MASK, 385, 390}, m1612m = "invokeSuspend", m1613n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "$this$awaitEachGesture"}, m1615s = {"L$0", "L$0", "L$0"}, m1616v = 1)
    static final class C03825 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03825(Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super C03825> continuation) {
            super(2, continuation);
            this.$onDragStart = function1;
            this.$onDragEnd = function0;
            this.$onDragCancel = function02;
            this.$onDrag = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03825 c03825 = new C03825(this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$onDrag, continuation);
            c03825.L$0 = obj;
            return c03825;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C03825) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0065 A[Catch: CancellationException -> 0x00c6, TryCatch #0 {CancellationException -> 0x00c6, blocks: (B:8:0x0015, B:32:0x008c, B:34:0x0094, B:36:0x00a6, B:38:0x00b2, B:39:0x00b5, B:40:0x00b8, B:41:0x00be, B:13:0x0026, B:26:0x0061, B:28:0x0065, B:16:0x002e, B:23:0x004d, B:19:0x003a), top: B:47:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0094 A[Catch: CancellationException -> 0x00c6, TryCatch #0 {CancellationException -> 0x00c6, blocks: (B:8:0x0015, B:32:0x008c, B:34:0x0094, B:36:0x00a6, B:38:0x00b2, B:39:0x00b5, B:40:0x00b8, B:41:0x00be, B:13:0x0026, B:26:0x0061, B:28:0x0065, B:16:0x002e, B:23:0x004d, B:19:0x003a), top: B:47:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00be A[Catch: CancellationException -> 0x00c6, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x00c6, blocks: (B:8:0x0015, B:32:0x008c, B:34:0x0094, B:36:0x00a6, B:38:0x00b2, B:39:0x00b5, B:40:0x00b8, B:41:0x00be, B:13:0x0026, B:26:0x0061, B:28:0x0065, B:16:0x002e, B:23:0x004d, B:19:0x003a), top: B:47:0x0009 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AwaitPointerEventScope awaitPointerEventScope;
            PointerInputChange pointerInputChange;
            AwaitPointerEventScope awaitPointerEventScope2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                    this.L$0 = awaitPointerEventScope3;
                    this.label = 1;
                    obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope3, false, null, this, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    awaitPointerEventScope = awaitPointerEventScope3;
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            pointerInputChange = (PointerInputChange) obj;
                            if (pointerInputChange != null) {
                                this.$onDragStart.invoke(Offset.m7892boximpl(pointerInputChange.getPosition()));
                                long id = pointerInputChange.getId();
                                final Function2<PointerInputChange, Offset, Unit> function2 = this.$onDrag;
                                this.L$0 = awaitPointerEventScope;
                                this.label = 3;
                                obj = DragGestureDetectorKt.m2278dragjO51t88(awaitPointerEventScope, id, new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return DragGestureDetectorKt.C03825.invokeSuspend$lambda$0(function2, (PointerInputChange) obj2);
                                    }
                                }, this);
                                if (obj != coroutine_suspended) {
                                    awaitPointerEventScope2 = awaitPointerEventScope;
                                    if (!((Boolean) obj).booleanValue()) {
                                    }
                                }
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            List<PointerInputChange> changes = awaitPointerEventScope2.getCurrentEvent().getChanges();
                            int size = changes.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                PointerInputChange pointerInputChange2 = changes.get(i2);
                                if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                    pointerInputChange2.consume();
                                }
                            }
                            this.$onDragEnd.invoke();
                        } else {
                            this.$onDragCancel.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                this.L$0 = awaitPointerEventScope;
                this.label = 2;
                obj = DragGestureDetectorKt.m2268awaitLongPressOrCancellationrnUCldI(awaitPointerEventScope, ((PointerInputChange) obj).getId(), this);
                if (obj != coroutine_suspended) {
                    pointerInputChange = (PointerInputChange) obj;
                    if (pointerInputChange != null) {
                    }
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (CancellationException e) {
                this.$onDragCancel.invoke();
                throw e;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(Function2 function2, PointerInputChange pointerInputChange) {
            function2.invoke(pointerInputChange, Offset.m7892boximpl(PointerEventKt.positionChange(pointerInputChange)));
            pointerInputChange.consume();
            return Unit.INSTANCE;
        }
    }

    public static final Object detectDragGesturesAfterLongPress(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C03825(function1, function0, function02, function2, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0199 -> B:61:0x019e). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitVerticalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m2275awaitVerticalTouchSlopOrCancellationjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
        float fM2281pointerSlopE8SPZFQ;
        Ref.LongRef longRef;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        float f;
        TouchSlopDetector touchSlopDetector2;
        int size;
        int i;
        PointerEventPass pointerEventPass;
        Object obj;
        PointerInputChange pointerInputChange;
        Object obj2;
        int i2;
        Object objAwaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 = (DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 = new DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1(continuation);
            }
        }
        Object obj3 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.label;
        int i4 = 1;
        PointerEventPass pointerEventPass2 = null;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj3);
            int iM9572getTouchT8wyACA = PointerType.INSTANCE.m9572getTouchT8wyACA();
            Orientation orientation = Orientation.Vertical;
            long jM7919getZeroF1C5BW0 = Offset.INSTANCE.m7919getZeroF1C5BW0();
            if (m2280isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                return null;
            }
            fM2281pointerSlopE8SPZFQ = m2281pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), iM9572getTouchT8wyACA);
            longRef = new Ref.LongRef();
            longRef.element = j;
            TouchSlopDetector touchSlopDetector3 = new TouchSlopDetector(orientation, jM7919getZeroF1C5BW0, null);
            function22 = function2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
            touchSlopDetector = touchSlopDetector3;
            awaitPointerEventScope2 = awaitPointerEventScope;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = fM2281pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = i4;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, i4, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i3 == 1) {
            float f2 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.F$0;
            TouchSlopDetector touchSlopDetector4 = (TouchSlopDetector) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$3;
            Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$2;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$1;
            Function2<? super PointerInputChange, ? super Float, Unit> function23 = (Function2) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj3);
            f = f2;
            touchSlopDetector2 = touchSlopDetector4;
            longRef = longRef2;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            function22 = function23;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
            PointerEvent pointerEvent = (PointerEvent) obj3;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            int i5 = 0;
            i = 0;
            while (true) {
                if (i < size) {
                }
                i++;
                size = i2;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null) {
                return pointerEventPass;
            }
            if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
            }
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = fM2281pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = i4;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, i4, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i3 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        float f3 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.F$0;
        PointerInputChange pointerInputChange2 = (PointerInputChange) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$4;
        TouchSlopDetector touchSlopDetector5 = (TouchSlopDetector) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$3;
        Ref.LongRef longRef3 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> function24 = (Function2) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$0;
        ResultKt.throwOnFailure(obj3);
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
        touchSlopDetector = touchSlopDetector5;
        char c = 2;
        int i6 = 1;
        fM2281pointerSlopE8SPZFQ = f3;
        awaitPointerEventScope2 = awaitPointerEventScope4;
        if (!pointerInputChange2.isConsumed()) {
            return null;
        }
        i4 = i6;
        function22 = function24;
        pointerEventPass2 = null;
        longRef = longRef3;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = longRef;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = fM2281pointerSlopE8SPZFQ;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = i4;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, i4, pointerEventPass2);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
            f = fM2281pointerSlopE8SPZFQ;
            touchSlopDetector2 = touchSlopDetector;
            obj3 = objAwaitPointerEvent$default;
            PointerEvent pointerEvent2 = (PointerEvent) obj3;
            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
            size = changes2.size();
            int i52 = 0;
            i = 0;
            while (true) {
                if (i < size) {
                    pointerEventPass = pointerEventPass2;
                    obj = pointerEventPass;
                    break;
                }
                obj = changes2.get(i);
                pointerEventPass = pointerEventPass2;
                i2 = size;
                if (PointerId.m9471equalsimpl0(((PointerInputChange) obj).getId(), longRef.element)) {
                    break;
                }
                i++;
                size = i2;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                return pointerEventPass;
            }
            if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size2 = changes3.size();
                while (true) {
                    if (i52 >= size2) {
                        obj2 = pointerEventPass;
                        break;
                    }
                    obj2 = changes3.get(i52);
                    if (((PointerInputChange) obj2).getPressed()) {
                        break;
                    }
                    i52++;
                }
                PointerInputChange pointerInputChange3 = (PointerInputChange) obj2;
                if (pointerInputChange3 == null) {
                    return pointerEventPass;
                }
                longRef.element = pointerInputChange3.getId();
                i4 = 1;
                touchSlopDetector = touchSlopDetector2;
                fM2281pointerSlopE8SPZFQ = f;
                pointerEventPass2 = null;
            } else {
                long jM2414getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m2414getPostSlopOffsetqto3Fdw$default(touchSlopDetector2, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange), f, false, 4, null);
                if ((9223372034707292159L & jM2414getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    function22.invoke(pointerInputChange, Boxing.boxFloat(Float.intBitsToFloat((int) (jM2414getPostSlopOffsetqto3Fdw$default & 4294967295L))));
                    if (pointerInputChange.isConsumed()) {
                        return pointerInputChange;
                    }
                    TouchSlopDetector.m2415resetk4lQ0M$default(touchSlopDetector2, 0L, 1, pointerEventPass);
                    i4 = 1;
                    touchSlopDetector = touchSlopDetector2;
                    fM2281pointerSlopE8SPZFQ = f;
                    pointerEventPass2 = null;
                } else {
                    i6 = 1;
                    PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = longRef;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = touchSlopDetector2;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerInputChange;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = f;
                    c = 2;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = 2;
                    if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12) != coroutine_suspended) {
                        longRef3 = longRef;
                        fM2281pointerSlopE8SPZFQ = f;
                        function24 = function22;
                        pointerInputChange2 = pointerInputChange;
                        touchSlopDetector = touchSlopDetector2;
                        if (!pointerInputChange2.isConsumed()) {
                        }
                    }
                }
            }
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = fM2281pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = i4;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, i4, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0190 -> B:61:0x0194). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitVerticalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m2274awaitVerticalPointerSlopOrCancellationgDDlDlE(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1;
        float fM2281pointerSlopE8SPZFQ;
        Ref.LongRef longRef;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        float f;
        TouchSlopDetector touchSlopDetector2;
        int size;
        int i2;
        PointerEventPass pointerEventPass;
        Object obj;
        PointerInputChange pointerInputChange;
        Object obj2;
        int i3;
        Object objAwaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 = (DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 = new DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1(continuation);
            }
        }
        Object obj3 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label;
        int i5 = 1;
        PointerEventPass pointerEventPass2 = null;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj3);
            Orientation orientation = Orientation.Vertical;
            long jM7919getZeroF1C5BW0 = Offset.INSTANCE.m7919getZeroF1C5BW0();
            if (m2280isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                return null;
            }
            fM2281pointerSlopE8SPZFQ = m2281pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
            longRef = new Ref.LongRef();
            longRef.element = j;
            function22 = function2;
            touchSlopDetector = new TouchSlopDetector(orientation, jM7919getZeroF1C5BW0, null);
            awaitPointerEventScope2 = awaitPointerEventScope;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0 = function22;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2 = longRef;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0 = fM2281pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = i5;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1, i5, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i4 == 1) {
            float f2 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0;
            TouchSlopDetector touchSlopDetector3 = (TouchSlopDetector) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3;
            Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1;
            Function2<? super PointerInputChange, ? super Float, Unit> function23 = (Function2) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj3);
            f = f2;
            touchSlopDetector2 = touchSlopDetector3;
            longRef = longRef2;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            function22 = function23;
            PointerEvent pointerEvent = (PointerEvent) obj3;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            int i6 = 0;
            i2 = 0;
            while (true) {
                if (i2 < size) {
                }
                i2++;
                size = i3;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null) {
                return pointerEventPass;
            }
            if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
            }
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0 = function22;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2 = longRef;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0 = fM2281pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = i5;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1, i5, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i4 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        float f3 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0;
        PointerInputChange pointerInputChange2 = (PointerInputChange) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4;
        TouchSlopDetector touchSlopDetector4 = (TouchSlopDetector) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3;
        Ref.LongRef longRef3 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> function24 = (Function2) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0;
        ResultKt.throwOnFailure(obj3);
        touchSlopDetector2 = touchSlopDetector4;
        int i7 = 1;
        fM2281pointerSlopE8SPZFQ = f3;
        char c = 2;
        awaitPointerEventScope2 = awaitPointerEventScope4;
        if (!pointerInputChange2.isConsumed()) {
            return null;
        }
        function22 = function24;
        pointerEventPass2 = null;
        i5 = i7;
        longRef = longRef3;
        touchSlopDetector = touchSlopDetector2;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0 = function22;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2 = longRef;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4 = pointerEventPass2;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0 = fM2281pointerSlopE8SPZFQ;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = i5;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1, i5, pointerEventPass2);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
            touchSlopDetector2 = touchSlopDetector;
            f = fM2281pointerSlopE8SPZFQ;
            obj3 = objAwaitPointerEvent$default;
            PointerEvent pointerEvent2 = (PointerEvent) obj3;
            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
            size = changes2.size();
            int i62 = 0;
            i2 = 0;
            while (true) {
                if (i2 < size) {
                    pointerEventPass = pointerEventPass2;
                    obj = pointerEventPass;
                    break;
                }
                obj = changes2.get(i2);
                pointerEventPass = pointerEventPass2;
                i3 = size;
                if (PointerId.m9471equalsimpl0(((PointerInputChange) obj).getId(), longRef.element)) {
                    break;
                }
                i2++;
                size = i3;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                return pointerEventPass;
            }
            if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size2 = changes3.size();
                while (true) {
                    if (i62 >= size2) {
                        obj2 = pointerEventPass;
                        break;
                    }
                    obj2 = changes3.get(i62);
                    if (((PointerInputChange) obj2).getPressed()) {
                        break;
                    }
                    i62++;
                }
                PointerInputChange pointerInputChange3 = (PointerInputChange) obj2;
                if (pointerInputChange3 == null) {
                    return pointerEventPass;
                }
                longRef.element = pointerInputChange3.getId();
                i5 = 1;
                touchSlopDetector = touchSlopDetector2;
                fM2281pointerSlopE8SPZFQ = f;
                pointerEventPass2 = null;
            } else {
                long jM2414getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m2414getPostSlopOffsetqto3Fdw$default(touchSlopDetector2, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange), f, false, 4, null);
                if ((9223372034707292159L & jM2414getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    function22.invoke(pointerInputChange, Boxing.boxFloat(Float.intBitsToFloat((int) (jM2414getPostSlopOffsetqto3Fdw$default & 4294967295L))));
                    if (pointerInputChange.isConsumed()) {
                        return pointerInputChange;
                    }
                    TouchSlopDetector.m2415resetk4lQ0M$default(touchSlopDetector2, 0L, 1, pointerEventPass);
                    i5 = 1;
                    touchSlopDetector = touchSlopDetector2;
                    fM2281pointerSlopE8SPZFQ = f;
                    pointerEventPass2 = null;
                } else {
                    i7 = 1;
                    PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0 = function22;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2 = longRef;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3 = touchSlopDetector2;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4 = pointerInputChange;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0 = f;
                    c = 2;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = 2;
                    if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) != coroutine_suspended) {
                        longRef3 = longRef;
                        function24 = function22;
                        pointerInputChange2 = pointerInputChange;
                        fM2281pointerSlopE8SPZFQ = f;
                        if (!pointerInputChange2.isConsumed()) {
                        }
                    }
                }
            }
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0 = function22;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2 = longRef;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0 = fM2281pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = i5;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1, i5, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0118, code lost:
    
        if ((r0 == 0.0f) == false) goto L59;
     */
    /* JADX WARN: Path cross not found for [B:35:0x00c6, B:46:0x00f2], limit reached: 73 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0084 -> B:23:0x008a). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: verticalDrag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m2282verticalDragjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Continuation<? super Boolean> continuation) {
        DragGestureDetectorKt$verticalDrag$1 dragGestureDetectorKt$verticalDrag$1;
        long id;
        Orientation orientation;
        DragGestureDetectorKt$verticalDrag$1 dragGestureDetectorKt$verticalDrag$12;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function1<? super PointerInputChange, Unit> function12;
        Orientation orientation2;
        AwaitPointerEventScope awaitPointerEventScope3;
        Ref.LongRef longRef;
        Object objAwaitPointerEvent$default;
        AwaitPointerEventScope awaitPointerEventScope4;
        PointerInputChange pointerInputChange;
        float fIntBitsToFloat;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$verticalDrag$1) {
            dragGestureDetectorKt$verticalDrag$1 = (DragGestureDetectorKt$verticalDrag$1) continuation;
            if ((dragGestureDetectorKt$verticalDrag$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$verticalDrag$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$verticalDrag$1 = new DragGestureDetectorKt$verticalDrag$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$verticalDrag$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = dragGestureDetectorKt$verticalDrag$1.label;
        int i2 = 1;
        PointerInputChange pointerInputChange3 = null;
        PointerEventPass pointerEventPass = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Orientation orientation3 = Orientation.Vertical;
            id = j;
            if (!m2280isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), id)) {
                orientation = orientation3;
                dragGestureDetectorKt$verticalDrag$12 = dragGestureDetectorKt$verticalDrag$1;
                awaitPointerEventScope2 = awaitPointerEventScope;
                function12 = function1;
                Ref.LongRef longRef2 = new Ref.LongRef();
                longRef2.element = id;
                awaitPointerEventScope3 = awaitPointerEventScope2;
                orientation2 = orientation;
                longRef = longRef2;
                dragGestureDetectorKt$verticalDrag$12.L$0 = function12;
                dragGestureDetectorKt$verticalDrag$12.L$1 = awaitPointerEventScope2;
                dragGestureDetectorKt$verticalDrag$12.L$2 = orientation2;
                dragGestureDetectorKt$verticalDrag$12.L$3 = awaitPointerEventScope3;
                dragGestureDetectorKt$verticalDrag$12.L$4 = longRef;
                dragGestureDetectorKt$verticalDrag$12.label = i2;
                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$verticalDrag$12, i2, pointerEventPass);
                if (objAwaitPointerEvent$default == coroutine_suspended) {
                }
            }
            return Boxing.boxBoolean(pointerInputChange3 == null);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        longRef = (Ref.LongRef) dragGestureDetectorKt$verticalDrag$1.L$4;
        awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$verticalDrag$1.L$3;
        orientation2 = (Orientation) dragGestureDetectorKt$verticalDrag$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) dragGestureDetectorKt$verticalDrag$1.L$1;
        Function1<? super PointerInputChange, Unit> function13 = (Function1) dragGestureDetectorKt$verticalDrag$1.L$0;
        ResultKt.throwOnFailure(obj);
        DragGestureDetectorKt$verticalDrag$1 dragGestureDetectorKt$verticalDrag$13 = dragGestureDetectorKt$verticalDrag$1;
        function12 = function13;
        PointerEvent pointerEvent = (PointerEvent) obj;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                awaitPointerEventScope4 = awaitPointerEventScope3;
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i3);
            awaitPointerEventScope4 = awaitPointerEventScope3;
            if (PointerId.m9471equalsimpl0(pointerInputChange.getId(), longRef.element)) {
                break;
            }
            i3++;
            awaitPointerEventScope3 = awaitPointerEventScope4;
        }
        PointerInputChange pointerInputChange4 = pointerInputChange;
        if (pointerInputChange4 == null) {
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange4)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i4);
                    if (pointerInputChange2.getPressed()) {
                        break;
                    }
                    i4++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange2;
                if (pointerInputChange5 != null) {
                    longRef.element = pointerInputChange5.getId();
                    awaitPointerEventScope3 = awaitPointerEventScope4;
                    awaitPointerEventScope2 = awaitPointerEventScope5;
                    dragGestureDetectorKt$verticalDrag$12 = dragGestureDetectorKt$verticalDrag$13;
                    i2 = 1;
                    pointerEventPass = null;
                    dragGestureDetectorKt$verticalDrag$12.L$0 = function12;
                    dragGestureDetectorKt$verticalDrag$12.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$verticalDrag$12.L$2 = orientation2;
                    dragGestureDetectorKt$verticalDrag$12.L$3 = awaitPointerEventScope3;
                    dragGestureDetectorKt$verticalDrag$12.L$4 = longRef;
                    dragGestureDetectorKt$verticalDrag$12.label = i2;
                    objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$verticalDrag$12, i2, pointerEventPass);
                    if (objAwaitPointerEvent$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    DragGestureDetectorKt$verticalDrag$1 dragGestureDetectorKt$verticalDrag$14 = dragGestureDetectorKt$verticalDrag$12;
                    awaitPointerEventScope5 = awaitPointerEventScope2;
                    obj = objAwaitPointerEvent$default;
                    dragGestureDetectorKt$verticalDrag$13 = dragGestureDetectorKt$verticalDrag$14;
                    PointerEvent pointerEvent2 = (PointerEvent) obj;
                    List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                    int size3 = changes3.size();
                    int i32 = 0;
                    while (true) {
                        if (i32 < size3) {
                        }
                        i32++;
                        awaitPointerEventScope3 = awaitPointerEventScope4;
                    }
                    PointerInputChange pointerInputChange42 = pointerInputChange;
                    if (pointerInputChange42 == null) {
                        pointerInputChange42 = null;
                    }
                }
            } else {
                long jPositionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange42);
                if (orientation2 == null) {
                    fIntBitsToFloat = Offset.m7901getDistanceimpl(jPositionChangeIgnoreConsumed);
                } else {
                    fIntBitsToFloat = Float.intBitsToFloat((int) (orientation2 == Orientation.Vertical ? jPositionChangeIgnoreConsumed & 4294967295L : jPositionChangeIgnoreConsumed >> 32));
                }
            }
        }
        if (pointerInputChange42 == null || pointerInputChange42.isConsumed()) {
            pointerInputChange3 = null;
        } else if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange42)) {
            pointerInputChange3 = pointerInputChange42;
        } else {
            function12.invoke(pointerInputChange42);
            orientation = orientation2;
            id = pointerInputChange42.getId();
            awaitPointerEventScope2 = awaitPointerEventScope5;
            dragGestureDetectorKt$verticalDrag$12 = dragGestureDetectorKt$verticalDrag$13;
            i2 = 1;
            pointerEventPass = null;
            Ref.LongRef longRef22 = new Ref.LongRef();
            longRef22.element = id;
            awaitPointerEventScope3 = awaitPointerEventScope2;
            orientation2 = orientation;
            longRef = longRef22;
            dragGestureDetectorKt$verticalDrag$12.L$0 = function12;
            dragGestureDetectorKt$verticalDrag$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$verticalDrag$12.L$2 = orientation2;
            dragGestureDetectorKt$verticalDrag$12.L$3 = awaitPointerEventScope3;
            dragGestureDetectorKt$verticalDrag$12.L$4 = longRef;
            dragGestureDetectorKt$verticalDrag$12.label = i2;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$verticalDrag$12, i2, pointerEventPass);
            if (objAwaitPointerEvent$default == coroutine_suspended) {
            }
        }
        return Boxing.boxBoolean(pointerInputChange3 == null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e2, code lost:
    
        if ((java.lang.Float.intBitsToFloat((int) (androidx.compose.p004ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11) & 4294967295L)) == 0.0f ? 1 : 0) == 0) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:22:0x006d). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitVerticalDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m2273awaitVerticalDragOrCancellationrnUCldI(AwaitPointerEventScope awaitPointerEventScope, long j, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitVerticalDragOrCancellation$1 dragGestureDetectorKt$awaitVerticalDragOrCancellation$1;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope2;
        Object objAwaitPointerEvent$default;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$awaitVerticalDragOrCancellation$1) {
            dragGestureDetectorKt$awaitVerticalDragOrCancellation$1 = (DragGestureDetectorKt$awaitVerticalDragOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1 = new DragGestureDetectorKt$awaitVerticalDragOrCancellation$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$1;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj);
            Ref.LongRef longRef3 = longRef2;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            PointerEvent pointerEvent = (PointerEvent) obj;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                if (PointerId.m9471equalsimpl0(pointerInputChange.getId(), longRef3.element)) {
                    break;
                }
                i2++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null) {
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i >= size2) {
                            pointerInputChange2 = null;
                            break;
                        }
                        pointerInputChange2 = changes2.get(i);
                        if (pointerInputChange2.getPressed()) {
                            break;
                        }
                        i++;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange2;
                    if (pointerInputChange4 != null) {
                        longRef3.element = pointerInputChange4.getId();
                        longRef = longRef3;
                    }
                }
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$1 = longRef;
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label = 1;
                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitVerticalDragOrCancellation$1, 1, null);
                if (objAwaitPointerEvent$default != coroutine_suspended) {
                    return coroutine_suspended;
                }
                Ref.LongRef longRef4 = longRef;
                obj = objAwaitPointerEvent$default;
                longRef3 = longRef4;
                PointerEvent pointerEvent2 = (PointerEvent) obj;
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size3 = changes3.size();
                int i22 = 0;
                while (true) {
                    if (i22 < size3) {
                    }
                    i22++;
                }
                PointerInputChange pointerInputChange32 = pointerInputChange;
                if (pointerInputChange32 == null) {
                    pointerInputChange32 = null;
                }
            }
            if (pointerInputChange32 == null || pointerInputChange32.isConsumed()) {
                return null;
            }
            return pointerInputChange32;
        }
        ResultKt.throwOnFailure(obj);
        if (m2280isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        longRef = new Ref.LongRef();
        longRef.element = j;
        awaitPointerEventScope2 = awaitPointerEventScope;
        dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$0 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$1 = longRef;
        dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label = 1;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitVerticalDragOrCancellation$1, 1, null);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
        }
    }

    public static /* synthetic */ Object detectVerticalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return DragGestureDetectorKt.detectVerticalDragGestures$lambda$0((Offset) obj2);
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function02;
        return detectVerticalDragGestures(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit detectVerticalDragGestures$lambda$0(Offset offset) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5 */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5", m1609f = "DragGestureDetector.kt", m1610i = {0, 1, 1}, m1611l = {558, 561, 569}, m1612m = "invokeSuspend", m1613n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "overSlop"}, m1615s = {"L$0", "L$0", "L$1"}, m1616v = 1)
    static final class C03875 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        final /* synthetic */ Function2<PointerInputChange, Float, Unit> $onVerticalDrag;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03875(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super C03875> continuation) {
            super(2, continuation);
            this.$onDragStart = function1;
            this.$onVerticalDrag = function2;
            this.$onDragEnd = function0;
            this.$onDragCancel = function02;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03875 c03875 = new C03875(this.$onDragStart, this.$onVerticalDrag, this.$onDragEnd, this.$onDragCancel, continuation);
            c03875.L$0 = obj;
            return c03875;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C03875) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x00a8, code lost:
        
            if (r12 == r0) goto L24;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AwaitPointerEventScope awaitPointerEventScope;
            final Ref.FloatRef floatRef;
            AwaitPointerEventScope awaitPointerEventScope2;
            PointerInputChange pointerInputChange;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                this.L$0 = awaitPointerEventScope3;
                this.label = 1;
                obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope3, false, null, this, 2, null);
                if (obj != coroutine_suspended) {
                    awaitPointerEventScope = awaitPointerEventScope3;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) obj).booleanValue()) {
                        this.$onDragEnd.invoke();
                    } else {
                        this.$onDragCancel.invoke();
                    }
                    return Unit.INSTANCE;
                }
                floatRef = (Ref.FloatRef) this.L$1;
                awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                    this.$onDragStart.invoke(Offset.m7892boximpl(pointerInputChange.getPosition()));
                    this.$onVerticalDrag.invoke(pointerInputChange, Boxing.boxFloat(floatRef.element));
                    long id = pointerInputChange.getId();
                    final Function2<PointerInputChange, Float, Unit> function2 = this.$onVerticalDrag;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 3;
                    obj = DragGestureDetectorKt.m2282verticalDragjO51t88(awaitPointerEventScope2, id, new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return DragGestureDetectorKt.C03875.invokeSuspend$lambda$1(function2, (PointerInputChange) obj2);
                        }
                    }, this);
                }
                return Unit.INSTANCE;
            }
            AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            awaitPointerEventScope = awaitPointerEventScope4;
            PointerInputChange pointerInputChange2 = (PointerInputChange) obj;
            floatRef = new Ref.FloatRef();
            this.L$0 = awaitPointerEventScope;
            this.L$1 = floatRef;
            this.label = 2;
            obj = DragGestureDetectorKt.m2274awaitVerticalPointerSlopOrCancellationgDDlDlE(awaitPointerEventScope, pointerInputChange2.getId(), pointerInputChange2.getType(), new Function2() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return DragGestureDetectorKt.C03875.invokeSuspend$lambda$0(floatRef, (PointerInputChange) obj2, ((Float) obj3).floatValue());
                }
            }, this);
            if (obj != coroutine_suspended) {
                awaitPointerEventScope2 = awaitPointerEventScope;
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(Ref.FloatRef floatRef, PointerInputChange pointerInputChange, float f) {
            pointerInputChange.consume();
            floatRef.element = f;
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(Function2 function2, PointerInputChange pointerInputChange) {
            function2.invoke(pointerInputChange, Float.valueOf(Float.intBitsToFloat((int) (PointerEventKt.positionChange(pointerInputChange) & 4294967295L))));
            pointerInputChange.consume();
            return Unit.INSTANCE;
        }
    }

    public static final Object detectVerticalDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C03875(function1, function2, function0, function02, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0196 -> B:61:0x019b). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitHorizontalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m2267awaitHorizontalTouchSlopOrCancellationjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
        float fM2281pointerSlopE8SPZFQ;
        Ref.LongRef longRef;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        float f;
        TouchSlopDetector touchSlopDetector2;
        int size;
        int i;
        PointerEventPass pointerEventPass;
        Object obj;
        PointerInputChange pointerInputChange;
        Object obj2;
        int i2;
        Object objAwaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 = (DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 = new DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1(continuation);
            }
        }
        Object obj3 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.label;
        int i4 = 1;
        PointerEventPass pointerEventPass2 = null;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj3);
            int iM9572getTouchT8wyACA = PointerType.INSTANCE.m9572getTouchT8wyACA();
            Orientation orientation = Orientation.Horizontal;
            long jM7919getZeroF1C5BW0 = Offset.INSTANCE.m7919getZeroF1C5BW0();
            if (m2280isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                return null;
            }
            fM2281pointerSlopE8SPZFQ = m2281pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), iM9572getTouchT8wyACA);
            longRef = new Ref.LongRef();
            longRef.element = j;
            TouchSlopDetector touchSlopDetector3 = new TouchSlopDetector(orientation, jM7919getZeroF1C5BW0, null);
            function22 = function2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
            touchSlopDetector = touchSlopDetector3;
            awaitPointerEventScope2 = awaitPointerEventScope;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = fM2281pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = i4;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, i4, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i3 == 1) {
            float f2 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.F$0;
            TouchSlopDetector touchSlopDetector4 = (TouchSlopDetector) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$3;
            Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$2;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$1;
            Function2<? super PointerInputChange, ? super Float, Unit> function23 = (Function2) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj3);
            f = f2;
            touchSlopDetector2 = touchSlopDetector4;
            longRef = longRef2;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            function22 = function23;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
            PointerEvent pointerEvent = (PointerEvent) obj3;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            int i5 = 0;
            i = 0;
            while (true) {
                if (i < size) {
                }
                i++;
                size = i2;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null) {
                return pointerEventPass;
            }
            if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
            }
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = fM2281pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = i4;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, i4, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i3 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        float f3 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.F$0;
        PointerInputChange pointerInputChange2 = (PointerInputChange) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$4;
        TouchSlopDetector touchSlopDetector5 = (TouchSlopDetector) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$3;
        Ref.LongRef longRef3 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> function24 = (Function2) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$0;
        ResultKt.throwOnFailure(obj3);
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
        touchSlopDetector = touchSlopDetector5;
        char c = 2;
        int i6 = 1;
        fM2281pointerSlopE8SPZFQ = f3;
        awaitPointerEventScope2 = awaitPointerEventScope4;
        if (!pointerInputChange2.isConsumed()) {
            return null;
        }
        i4 = i6;
        function22 = function24;
        pointerEventPass2 = null;
        longRef = longRef3;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = longRef;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = fM2281pointerSlopE8SPZFQ;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = i4;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, i4, pointerEventPass2);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
            f = fM2281pointerSlopE8SPZFQ;
            touchSlopDetector2 = touchSlopDetector;
            obj3 = objAwaitPointerEvent$default;
            PointerEvent pointerEvent2 = (PointerEvent) obj3;
            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
            size = changes2.size();
            int i52 = 0;
            i = 0;
            while (true) {
                if (i < size) {
                    pointerEventPass = pointerEventPass2;
                    obj = pointerEventPass;
                    break;
                }
                obj = changes2.get(i);
                pointerEventPass = pointerEventPass2;
                i2 = size;
                if (PointerId.m9471equalsimpl0(((PointerInputChange) obj).getId(), longRef.element)) {
                    break;
                }
                i++;
                size = i2;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                return pointerEventPass;
            }
            if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size2 = changes3.size();
                while (true) {
                    if (i52 >= size2) {
                        obj2 = pointerEventPass;
                        break;
                    }
                    obj2 = changes3.get(i52);
                    if (((PointerInputChange) obj2).getPressed()) {
                        break;
                    }
                    i52++;
                }
                PointerInputChange pointerInputChange3 = (PointerInputChange) obj2;
                if (pointerInputChange3 == null) {
                    return pointerEventPass;
                }
                longRef.element = pointerInputChange3.getId();
                i4 = 1;
                touchSlopDetector = touchSlopDetector2;
                fM2281pointerSlopE8SPZFQ = f;
                pointerEventPass2 = null;
            } else {
                long jM2414getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m2414getPostSlopOffsetqto3Fdw$default(touchSlopDetector2, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange), f, false, 4, null);
                if ((9223372034707292159L & jM2414getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    function22.invoke(pointerInputChange, Boxing.boxFloat(Float.intBitsToFloat((int) (jM2414getPostSlopOffsetqto3Fdw$default >> 32))));
                    if (pointerInputChange.isConsumed()) {
                        return pointerInputChange;
                    }
                    TouchSlopDetector.m2415resetk4lQ0M$default(touchSlopDetector2, 0L, 1, pointerEventPass);
                    i4 = 1;
                    touchSlopDetector = touchSlopDetector2;
                    fM2281pointerSlopE8SPZFQ = f;
                    pointerEventPass2 = null;
                } else {
                    i6 = 1;
                    PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = longRef;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = touchSlopDetector2;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerInputChange;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = f;
                    c = 2;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = 2;
                    if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12) != coroutine_suspended) {
                        longRef3 = longRef;
                        fM2281pointerSlopE8SPZFQ = f;
                        function24 = function22;
                        pointerInputChange2 = pointerInputChange;
                        touchSlopDetector = touchSlopDetector2;
                        if (!pointerInputChange2.isConsumed()) {
                        }
                    }
                }
            }
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = fM2281pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = i4;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, i4, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0199 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x018d -> B:61:0x0191). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m2266awaitHorizontalPointerSlopOrCancellationgDDlDlE(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1;
        float fM2281pointerSlopE8SPZFQ;
        Ref.LongRef longRef;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        float f;
        TouchSlopDetector touchSlopDetector2;
        int size;
        int i2;
        PointerEventPass pointerEventPass;
        Object obj;
        PointerInputChange pointerInputChange;
        Object obj2;
        int i3;
        Object objAwaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 = (DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 = new DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1(continuation);
            }
        }
        Object obj3 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label;
        int i5 = 1;
        PointerEventPass pointerEventPass2 = null;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj3);
            Orientation orientation = Orientation.Horizontal;
            long jM7919getZeroF1C5BW0 = Offset.INSTANCE.m7919getZeroF1C5BW0();
            if (m2280isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                return null;
            }
            fM2281pointerSlopE8SPZFQ = m2281pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
            longRef = new Ref.LongRef();
            longRef.element = j;
            function22 = function2;
            touchSlopDetector = new TouchSlopDetector(orientation, jM7919getZeroF1C5BW0, null);
            awaitPointerEventScope2 = awaitPointerEventScope;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0 = function22;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2 = longRef;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0 = fM2281pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = i5;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1, i5, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i4 == 1) {
            float f2 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0;
            TouchSlopDetector touchSlopDetector3 = (TouchSlopDetector) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3;
            Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1;
            Function2<? super PointerInputChange, ? super Float, Unit> function23 = (Function2) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj3);
            f = f2;
            touchSlopDetector2 = touchSlopDetector3;
            longRef = longRef2;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            function22 = function23;
            PointerEvent pointerEvent = (PointerEvent) obj3;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            int i6 = 0;
            i2 = 0;
            while (true) {
                if (i2 < size) {
                }
                i2++;
                size = i3;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null) {
                return pointerEventPass;
            }
            if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
            }
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0 = function22;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2 = longRef;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0 = fM2281pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = i5;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1, i5, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i4 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        float f3 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0;
        PointerInputChange pointerInputChange2 = (PointerInputChange) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4;
        TouchSlopDetector touchSlopDetector4 = (TouchSlopDetector) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3;
        Ref.LongRef longRef3 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> function24 = (Function2) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0;
        ResultKt.throwOnFailure(obj3);
        touchSlopDetector2 = touchSlopDetector4;
        int i7 = 1;
        fM2281pointerSlopE8SPZFQ = f3;
        char c = 2;
        awaitPointerEventScope2 = awaitPointerEventScope4;
        if (!pointerInputChange2.isConsumed()) {
            return null;
        }
        function22 = function24;
        pointerEventPass2 = null;
        i5 = i7;
        longRef = longRef3;
        touchSlopDetector = touchSlopDetector2;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0 = function22;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2 = longRef;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4 = pointerEventPass2;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0 = fM2281pointerSlopE8SPZFQ;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = i5;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1, i5, pointerEventPass2);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
            touchSlopDetector2 = touchSlopDetector;
            f = fM2281pointerSlopE8SPZFQ;
            obj3 = objAwaitPointerEvent$default;
            PointerEvent pointerEvent2 = (PointerEvent) obj3;
            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
            size = changes2.size();
            int i62 = 0;
            i2 = 0;
            while (true) {
                if (i2 < size) {
                    pointerEventPass = pointerEventPass2;
                    obj = pointerEventPass;
                    break;
                }
                obj = changes2.get(i2);
                pointerEventPass = pointerEventPass2;
                i3 = size;
                if (PointerId.m9471equalsimpl0(((PointerInputChange) obj).getId(), longRef.element)) {
                    break;
                }
                i2++;
                size = i3;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                return pointerEventPass;
            }
            if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size2 = changes3.size();
                while (true) {
                    if (i62 >= size2) {
                        obj2 = pointerEventPass;
                        break;
                    }
                    obj2 = changes3.get(i62);
                    if (((PointerInputChange) obj2).getPressed()) {
                        break;
                    }
                    i62++;
                }
                PointerInputChange pointerInputChange3 = (PointerInputChange) obj2;
                if (pointerInputChange3 == null) {
                    return pointerEventPass;
                }
                longRef.element = pointerInputChange3.getId();
                i5 = 1;
                touchSlopDetector = touchSlopDetector2;
                fM2281pointerSlopE8SPZFQ = f;
                pointerEventPass2 = null;
            } else {
                long jM2414getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m2414getPostSlopOffsetqto3Fdw$default(touchSlopDetector2, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange), f, false, 4, null);
                if ((9223372034707292159L & jM2414getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    function22.invoke(pointerInputChange, Boxing.boxFloat(Float.intBitsToFloat((int) (jM2414getPostSlopOffsetqto3Fdw$default >> 32))));
                    if (pointerInputChange.isConsumed()) {
                        return pointerInputChange;
                    }
                    TouchSlopDetector.m2415resetk4lQ0M$default(touchSlopDetector2, 0L, 1, pointerEventPass);
                    i5 = 1;
                    touchSlopDetector = touchSlopDetector2;
                    fM2281pointerSlopE8SPZFQ = f;
                    pointerEventPass2 = null;
                } else {
                    i7 = 1;
                    PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0 = function22;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2 = longRef;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3 = touchSlopDetector2;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4 = pointerInputChange;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0 = f;
                    c = 2;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = 2;
                    if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) != coroutine_suspended) {
                        longRef3 = longRef;
                        function24 = function22;
                        pointerInputChange2 = pointerInputChange;
                        fM2281pointerSlopE8SPZFQ = f;
                        if (!pointerInputChange2.isConsumed()) {
                        }
                    }
                }
            }
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0 = function22;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2 = longRef;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0 = fM2281pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = i5;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1, i5, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0118, code lost:
    
        if ((r0 == 0.0f) == false) goto L59;
     */
    /* JADX WARN: Path cross not found for [B:35:0x00c6, B:46:0x00f2], limit reached: 73 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0084 -> B:23:0x008a). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: horizontalDrag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m2279horizontalDragjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Continuation<? super Boolean> continuation) {
        DragGestureDetectorKt$horizontalDrag$1 dragGestureDetectorKt$horizontalDrag$1;
        long id;
        Orientation orientation;
        DragGestureDetectorKt$horizontalDrag$1 dragGestureDetectorKt$horizontalDrag$12;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function1<? super PointerInputChange, Unit> function12;
        Orientation orientation2;
        AwaitPointerEventScope awaitPointerEventScope3;
        Ref.LongRef longRef;
        Object objAwaitPointerEvent$default;
        AwaitPointerEventScope awaitPointerEventScope4;
        PointerInputChange pointerInputChange;
        float fIntBitsToFloat;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$horizontalDrag$1) {
            dragGestureDetectorKt$horizontalDrag$1 = (DragGestureDetectorKt$horizontalDrag$1) continuation;
            if ((dragGestureDetectorKt$horizontalDrag$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$horizontalDrag$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$horizontalDrag$1 = new DragGestureDetectorKt$horizontalDrag$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$horizontalDrag$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = dragGestureDetectorKt$horizontalDrag$1.label;
        int i2 = 1;
        PointerInputChange pointerInputChange3 = null;
        PointerEventPass pointerEventPass = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Orientation orientation3 = Orientation.Horizontal;
            id = j;
            if (!m2280isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), id)) {
                orientation = orientation3;
                dragGestureDetectorKt$horizontalDrag$12 = dragGestureDetectorKt$horizontalDrag$1;
                awaitPointerEventScope2 = awaitPointerEventScope;
                function12 = function1;
                Ref.LongRef longRef2 = new Ref.LongRef();
                longRef2.element = id;
                awaitPointerEventScope3 = awaitPointerEventScope2;
                orientation2 = orientation;
                longRef = longRef2;
                dragGestureDetectorKt$horizontalDrag$12.L$0 = function12;
                dragGestureDetectorKt$horizontalDrag$12.L$1 = awaitPointerEventScope2;
                dragGestureDetectorKt$horizontalDrag$12.L$2 = orientation2;
                dragGestureDetectorKt$horizontalDrag$12.L$3 = awaitPointerEventScope3;
                dragGestureDetectorKt$horizontalDrag$12.L$4 = longRef;
                dragGestureDetectorKt$horizontalDrag$12.label = i2;
                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$horizontalDrag$12, i2, pointerEventPass);
                if (objAwaitPointerEvent$default == coroutine_suspended) {
                }
            }
            return Boxing.boxBoolean(pointerInputChange3 == null);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        longRef = (Ref.LongRef) dragGestureDetectorKt$horizontalDrag$1.L$4;
        awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$horizontalDrag$1.L$3;
        orientation2 = (Orientation) dragGestureDetectorKt$horizontalDrag$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) dragGestureDetectorKt$horizontalDrag$1.L$1;
        Function1<? super PointerInputChange, Unit> function13 = (Function1) dragGestureDetectorKt$horizontalDrag$1.L$0;
        ResultKt.throwOnFailure(obj);
        DragGestureDetectorKt$horizontalDrag$1 dragGestureDetectorKt$horizontalDrag$13 = dragGestureDetectorKt$horizontalDrag$1;
        function12 = function13;
        PointerEvent pointerEvent = (PointerEvent) obj;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                awaitPointerEventScope4 = awaitPointerEventScope3;
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i3);
            awaitPointerEventScope4 = awaitPointerEventScope3;
            if (PointerId.m9471equalsimpl0(pointerInputChange.getId(), longRef.element)) {
                break;
            }
            i3++;
            awaitPointerEventScope3 = awaitPointerEventScope4;
        }
        PointerInputChange pointerInputChange4 = pointerInputChange;
        if (pointerInputChange4 == null) {
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange4)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i4);
                    if (pointerInputChange2.getPressed()) {
                        break;
                    }
                    i4++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange2;
                if (pointerInputChange5 != null) {
                    longRef.element = pointerInputChange5.getId();
                    awaitPointerEventScope3 = awaitPointerEventScope4;
                    awaitPointerEventScope2 = awaitPointerEventScope5;
                    dragGestureDetectorKt$horizontalDrag$12 = dragGestureDetectorKt$horizontalDrag$13;
                    i2 = 1;
                    pointerEventPass = null;
                    dragGestureDetectorKt$horizontalDrag$12.L$0 = function12;
                    dragGestureDetectorKt$horizontalDrag$12.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$horizontalDrag$12.L$2 = orientation2;
                    dragGestureDetectorKt$horizontalDrag$12.L$3 = awaitPointerEventScope3;
                    dragGestureDetectorKt$horizontalDrag$12.L$4 = longRef;
                    dragGestureDetectorKt$horizontalDrag$12.label = i2;
                    objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$horizontalDrag$12, i2, pointerEventPass);
                    if (objAwaitPointerEvent$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    DragGestureDetectorKt$horizontalDrag$1 dragGestureDetectorKt$horizontalDrag$14 = dragGestureDetectorKt$horizontalDrag$12;
                    awaitPointerEventScope5 = awaitPointerEventScope2;
                    obj = objAwaitPointerEvent$default;
                    dragGestureDetectorKt$horizontalDrag$13 = dragGestureDetectorKt$horizontalDrag$14;
                    PointerEvent pointerEvent2 = (PointerEvent) obj;
                    List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                    int size3 = changes3.size();
                    int i32 = 0;
                    while (true) {
                        if (i32 < size3) {
                        }
                        i32++;
                        awaitPointerEventScope3 = awaitPointerEventScope4;
                    }
                    PointerInputChange pointerInputChange42 = pointerInputChange;
                    if (pointerInputChange42 == null) {
                        pointerInputChange42 = null;
                    }
                }
            } else {
                long jPositionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange42);
                if (orientation2 == null) {
                    fIntBitsToFloat = Offset.m7901getDistanceimpl(jPositionChangeIgnoreConsumed);
                } else {
                    fIntBitsToFloat = Float.intBitsToFloat((int) (orientation2 == Orientation.Vertical ? jPositionChangeIgnoreConsumed & 4294967295L : jPositionChangeIgnoreConsumed >> 32));
                }
            }
        }
        if (pointerInputChange42 == null || pointerInputChange42.isConsumed()) {
            pointerInputChange3 = null;
        } else if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange42)) {
            pointerInputChange3 = pointerInputChange42;
        } else {
            function12.invoke(pointerInputChange42);
            orientation = orientation2;
            id = pointerInputChange42.getId();
            awaitPointerEventScope2 = awaitPointerEventScope5;
            dragGestureDetectorKt$horizontalDrag$12 = dragGestureDetectorKt$horizontalDrag$13;
            i2 = 1;
            pointerEventPass = null;
            Ref.LongRef longRef22 = new Ref.LongRef();
            longRef22.element = id;
            awaitPointerEventScope3 = awaitPointerEventScope2;
            orientation2 = orientation;
            longRef = longRef22;
            dragGestureDetectorKt$horizontalDrag$12.L$0 = function12;
            dragGestureDetectorKt$horizontalDrag$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$horizontalDrag$12.L$2 = orientation2;
            dragGestureDetectorKt$horizontalDrag$12.L$3 = awaitPointerEventScope3;
            dragGestureDetectorKt$horizontalDrag$12.L$4 = longRef;
            dragGestureDetectorKt$horizontalDrag$12.label = i2;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$horizontalDrag$12, i2, pointerEventPass);
            if (objAwaitPointerEvent$default == coroutine_suspended) {
            }
        }
        return Boxing.boxBoolean(pointerInputChange3 == null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00df, code lost:
    
        if ((java.lang.Float.intBitsToFloat((int) (androidx.compose.p004ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11) >> 32)) == 0.0f ? 1 : 0) == 0) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:22:0x006d). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitHorizontalDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m2265awaitHorizontalDragOrCancellationrnUCldI(AwaitPointerEventScope awaitPointerEventScope, long j, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope2;
        Object objAwaitPointerEvent$default;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1) {
            dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 = (DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 = new DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$1;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj);
            Ref.LongRef longRef3 = longRef2;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            PointerEvent pointerEvent = (PointerEvent) obj;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                if (PointerId.m9471equalsimpl0(pointerInputChange.getId(), longRef3.element)) {
                    break;
                }
                i2++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null) {
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i >= size2) {
                            pointerInputChange2 = null;
                            break;
                        }
                        pointerInputChange2 = changes2.get(i);
                        if (pointerInputChange2.getPressed()) {
                            break;
                        }
                        i++;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange2;
                    if (pointerInputChange4 != null) {
                        longRef3.element = pointerInputChange4.getId();
                        longRef = longRef3;
                    }
                }
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$1 = longRef;
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label = 1;
                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1, 1, null);
                if (objAwaitPointerEvent$default != coroutine_suspended) {
                    return coroutine_suspended;
                }
                Ref.LongRef longRef4 = longRef;
                obj = objAwaitPointerEvent$default;
                longRef3 = longRef4;
                PointerEvent pointerEvent2 = (PointerEvent) obj;
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size3 = changes3.size();
                int i22 = 0;
                while (true) {
                    if (i22 < size3) {
                    }
                    i22++;
                }
                PointerInputChange pointerInputChange32 = pointerInputChange;
                if (pointerInputChange32 == null) {
                    pointerInputChange32 = null;
                }
            }
            if (pointerInputChange32 == null || pointerInputChange32.isConsumed()) {
                return null;
            }
            return pointerInputChange32;
        }
        ResultKt.throwOnFailure(obj);
        if (m2280isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        longRef = new Ref.LongRef();
        longRef.element = j;
        awaitPointerEventScope2 = awaitPointerEventScope;
        dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$0 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$1 = longRef;
        dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label = 1;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1, 1, null);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
        }
    }

    public static /* synthetic */ Object detectHorizontalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return DragGestureDetectorKt.detectHorizontalDragGestures$lambda$0((Offset) obj2);
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function02;
        return detectHorizontalDragGestures(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit detectHorizontalDragGestures$lambda$0(Offset offset) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5 */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5", m1609f = "DragGestureDetector.kt", m1610i = {0, 1, 1}, m1611l = {727, 730, PDFACompliance.e_PDFA7_3_8}, m1612m = "invokeSuspend", m1613n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "overSlop"}, m1615s = {"L$0", "L$0", "L$1"}, m1616v = 1)
    static final class C03845 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        final /* synthetic */ Function2<PointerInputChange, Float, Unit> $onHorizontalDrag;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03845(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super C03845> continuation) {
            super(2, continuation);
            this.$onDragStart = function1;
            this.$onHorizontalDrag = function2;
            this.$onDragEnd = function0;
            this.$onDragCancel = function02;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03845 c03845 = new C03845(this.$onDragStart, this.$onHorizontalDrag, this.$onDragEnd, this.$onDragCancel, continuation);
            c03845.L$0 = obj;
            return c03845;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C03845) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x00a8, code lost:
        
            if (r12 == r0) goto L24;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AwaitPointerEventScope awaitPointerEventScope;
            final Ref.FloatRef floatRef;
            AwaitPointerEventScope awaitPointerEventScope2;
            PointerInputChange pointerInputChange;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                this.L$0 = awaitPointerEventScope3;
                this.label = 1;
                obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope3, false, null, this, 2, null);
                if (obj != coroutine_suspended) {
                    awaitPointerEventScope = awaitPointerEventScope3;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) obj).booleanValue()) {
                        this.$onDragEnd.invoke();
                    } else {
                        this.$onDragCancel.invoke();
                    }
                    return Unit.INSTANCE;
                }
                floatRef = (Ref.FloatRef) this.L$1;
                awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                    this.$onDragStart.invoke(Offset.m7892boximpl(pointerInputChange.getPosition()));
                    this.$onHorizontalDrag.invoke(pointerInputChange, Boxing.boxFloat(floatRef.element));
                    long id = pointerInputChange.getId();
                    final Function2<PointerInputChange, Float, Unit> function2 = this.$onHorizontalDrag;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 3;
                    obj = DragGestureDetectorKt.m2279horizontalDragjO51t88(awaitPointerEventScope2, id, new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return DragGestureDetectorKt.C03845.invokeSuspend$lambda$1(function2, (PointerInputChange) obj2);
                        }
                    }, this);
                }
                return Unit.INSTANCE;
            }
            AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            awaitPointerEventScope = awaitPointerEventScope4;
            PointerInputChange pointerInputChange2 = (PointerInputChange) obj;
            floatRef = new Ref.FloatRef();
            this.L$0 = awaitPointerEventScope;
            this.L$1 = floatRef;
            this.label = 2;
            obj = DragGestureDetectorKt.m2266awaitHorizontalPointerSlopOrCancellationgDDlDlE(awaitPointerEventScope, pointerInputChange2.getId(), pointerInputChange2.getType(), new Function2() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return DragGestureDetectorKt.C03845.invokeSuspend$lambda$0(floatRef, (PointerInputChange) obj2, ((Float) obj3).floatValue());
                }
            }, this);
            if (obj != coroutine_suspended) {
                awaitPointerEventScope2 = awaitPointerEventScope;
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(Ref.FloatRef floatRef, PointerInputChange pointerInputChange, float f) {
            pointerInputChange.consume();
            floatRef.element = f;
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(Function2 function2, PointerInputChange pointerInputChange) {
            function2.invoke(pointerInputChange, Float.valueOf(Float.intBitsToFloat((int) (PointerEventKt.positionChange(pointerInputChange) >> 32))));
            pointerInputChange.consume();
            return Unit.INSTANCE;
        }
    }

    public static final Object detectHorizontalDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C03845(function1, function2, function0, function02, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x012c, code lost:
    
        if ((r0 == 0.0f) == false) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:35:0x00d4, B:46:0x0101], limit reached: 69 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x008e -> B:23:0x0094). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: drag-VnAYq1g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m2276dragVnAYq1g(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Orientation orientation, Function1<? super PointerInputChange, Boolean> function12, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$drag$2 dragGestureDetectorKt$drag$2;
        long id;
        AwaitPointerEventScope awaitPointerEventScope2;
        Orientation orientation2;
        Function1<? super PointerInputChange, Boolean> function13;
        DragGestureDetectorKt$drag$2 dragGestureDetectorKt$drag$22;
        Function1<? super PointerInputChange, Unit> function14;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope3;
        Object objAwaitPointerEvent$default;
        PointerEventPass pointerEventPass;
        Object obj;
        float fIntBitsToFloat;
        Object obj2;
        int i;
        if (continuation instanceof DragGestureDetectorKt$drag$2) {
            dragGestureDetectorKt$drag$2 = (DragGestureDetectorKt$drag$2) continuation;
            if ((dragGestureDetectorKt$drag$2.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$drag$2.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$drag$2 = new DragGestureDetectorKt$drag$2(continuation);
            }
        }
        Object obj3 = dragGestureDetectorKt$drag$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dragGestureDetectorKt$drag$2.label;
        int i3 = 1;
        PointerEventPass pointerEventPass2 = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj3);
            id = j;
            if (m2280isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), id)) {
                return null;
            }
            awaitPointerEventScope2 = awaitPointerEventScope;
            orientation2 = orientation;
            function13 = function12;
            dragGestureDetectorKt$drag$22 = dragGestureDetectorKt$drag$2;
            function14 = function1;
            longRef = new Ref.LongRef();
            longRef.element = id;
            awaitPointerEventScope3 = awaitPointerEventScope2;
            dragGestureDetectorKt$drag$22.L$0 = awaitPointerEventScope2;
            dragGestureDetectorKt$drag$22.L$1 = function14;
            dragGestureDetectorKt$drag$22.L$2 = orientation2;
            dragGestureDetectorKt$drag$22.L$3 = function13;
            dragGestureDetectorKt$drag$22.L$4 = awaitPointerEventScope3;
            dragGestureDetectorKt$drag$22.L$5 = longRef;
            dragGestureDetectorKt$drag$22.label = i3;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass2, dragGestureDetectorKt$drag$22, i3, pointerEventPass2);
            if (objAwaitPointerEvent$default == coroutine_suspended) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$drag$2.L$5;
            awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$drag$2.L$4;
            Function1<? super PointerInputChange, Boolean> function15 = (Function1) dragGestureDetectorKt$drag$2.L$3;
            Orientation orientation3 = (Orientation) dragGestureDetectorKt$drag$2.L$2;
            Function1<? super PointerInputChange, Unit> function16 = (Function1) dragGestureDetectorKt$drag$2.L$1;
            AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$drag$2.L$0;
            ResultKt.throwOnFailure(obj3);
            dragGestureDetectorKt$drag$22 = dragGestureDetectorKt$drag$2;
            function14 = function16;
            Ref.LongRef longRef3 = longRef2;
            orientation2 = orientation3;
            function13 = function15;
            PointerEvent pointerEvent = (PointerEvent) obj3;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i4 = 0;
            while (true) {
                if (i4 < size) {
                    pointerEventPass = pointerEventPass2;
                    obj = pointerEventPass;
                    break;
                }
                obj = changes.get(i4);
                pointerEventPass = pointerEventPass2;
                i = i4;
                if (PointerId.m9471equalsimpl0(((PointerInputChange) obj).getId(), longRef3.element)) {
                    break;
                }
                i4 = i + 1;
                pointerEventPass2 = pointerEventPass;
            }
            PointerInputChange pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange == 0) {
                if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                    long jPositionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange);
                    if (orientation2 == null) {
                        fIntBitsToFloat = Offset.m7901getDistanceimpl(jPositionChangeIgnoreConsumed);
                    } else if (orientation2 == Orientation.Vertical) {
                        fIntBitsToFloat = Float.intBitsToFloat((int) (jPositionChangeIgnoreConsumed & 4294967295L));
                    } else {
                        fIntBitsToFloat = Float.intBitsToFloat((int) (jPositionChangeIgnoreConsumed >> 32));
                    }
                } else {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size2) {
                            obj2 = pointerEventPass;
                            break;
                        }
                        obj2 = changes2.get(i5);
                        if (((PointerInputChange) obj2).getPressed()) {
                            break;
                        }
                        i5++;
                    }
                    PointerInputChange pointerInputChange2 = (PointerInputChange) obj2;
                    if (pointerInputChange2 != null) {
                        longRef3.element = pointerInputChange2.getId();
                        awaitPointerEventScope2 = awaitPointerEventScope4;
                        pointerEventPass2 = pointerEventPass;
                        i3 = 1;
                        longRef = longRef3;
                        dragGestureDetectorKt$drag$22.L$0 = awaitPointerEventScope2;
                        dragGestureDetectorKt$drag$22.L$1 = function14;
                        dragGestureDetectorKt$drag$22.L$2 = orientation2;
                        dragGestureDetectorKt$drag$22.L$3 = function13;
                        dragGestureDetectorKt$drag$22.L$4 = awaitPointerEventScope3;
                        dragGestureDetectorKt$drag$22.L$5 = longRef;
                        dragGestureDetectorKt$drag$22.label = i3;
                        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass2, dragGestureDetectorKt$drag$22, i3, pointerEventPass2);
                        if (objAwaitPointerEvent$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Ref.LongRef longRef4 = longRef;
                        awaitPointerEventScope4 = awaitPointerEventScope2;
                        obj3 = objAwaitPointerEvent$default;
                        longRef3 = longRef4;
                        PointerEvent pointerEvent2 = (PointerEvent) obj3;
                        List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                        int size3 = changes3.size();
                        int i42 = 0;
                        while (true) {
                            if (i42 < size3) {
                            }
                            i42 = i + 1;
                            pointerEventPass2 = pointerEventPass;
                        }
                        PointerInputChange pointerInputChange3 = (PointerInputChange) obj;
                        if (pointerInputChange3 == 0) {
                            pointerInputChange3 = pointerEventPass;
                        }
                    }
                }
            }
            if (pointerInputChange3 == 0 || function13.invoke(pointerInputChange3).booleanValue()) {
                return pointerEventPass;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                return pointerInputChange3;
            }
            function14.invoke(pointerInputChange3);
            id = pointerInputChange3.getId();
            awaitPointerEventScope2 = awaitPointerEventScope4;
            pointerEventPass2 = pointerEventPass;
            i3 = 1;
            longRef = new Ref.LongRef();
            longRef.element = id;
            awaitPointerEventScope3 = awaitPointerEventScope2;
            dragGestureDetectorKt$drag$22.L$0 = awaitPointerEventScope2;
            dragGestureDetectorKt$drag$22.L$1 = function14;
            dragGestureDetectorKt$drag$22.L$2 = orientation2;
            dragGestureDetectorKt$drag$22.L$3 = function13;
            dragGestureDetectorKt$drag$22.L$4 = awaitPointerEventScope3;
            dragGestureDetectorKt$drag$22.L$5 = longRef;
            dragGestureDetectorKt$drag$22.label = i3;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass2, dragGestureDetectorKt$drag$22, i3, pointerEventPass2);
            if (objAwaitPointerEvent$default == coroutine_suspended) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: drag-VnAYq1g$$forInline, reason: not valid java name */
    private static final Object m2277dragVnAYq1g$$forInline(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Orientation orientation, Function1<? super PointerInputChange, Boolean> function12, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        long id = j;
        if (m2280isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), id)) {
            return null;
        }
        while (true) {
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = id;
            while (true) {
                PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        pointerInputChange = null;
                        break;
                    }
                    pointerInputChange = changes.get(i);
                    if (Boolean.valueOf(PointerId.m9471equalsimpl0(pointerInputChange.getId(), longRef.element)).booleanValue()) {
                        break;
                    }
                    i++;
                }
                pointerInputChange2 = pointerInputChange;
                if (pointerInputChange2 == null) {
                    pointerInputChange2 = null;
                    break;
                }
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i >= size2) {
                            pointerInputChange3 = null;
                            break;
                        }
                        pointerInputChange3 = changes2.get(i);
                        if (Boolean.valueOf(pointerInputChange3.getPressed()).booleanValue()) {
                            break;
                        }
                        i++;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange3;
                    if (pointerInputChange4 == null) {
                        break;
                    }
                    longRef.element = pointerInputChange4.getId();
                } else {
                    long jPositionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange2);
                    if (Boolean.valueOf(1 ^ ((orientation == null ? Offset.m7901getDistanceimpl(jPositionChangeIgnoreConsumed) : orientation == Orientation.Vertical ? Float.intBitsToFloat((int) (jPositionChangeIgnoreConsumed & 4294967295L)) : Float.intBitsToFloat((int) (jPositionChangeIgnoreConsumed >> 32))) == 0.0f ? 1 : 0)).booleanValue()) {
                        break;
                    }
                }
            }
            if (pointerInputChange2 == null || function12.invoke(pointerInputChange2).booleanValue()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                return pointerInputChange2;
            }
            function1.invoke(pointerInputChange2);
            id = pointerInputChange2.getId();
        }
    }

    /* JADX INFO: renamed from: awaitDragOrUp-jO51t88, reason: not valid java name */
    private static final Object m2264awaitDragOrUpjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Boolean> function1, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j;
        while (true) {
            PointerInputChange pointerInputChange3 = null;
            PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                if (Boolean.valueOf(PointerId.m9471equalsimpl0(pointerInputChange.getId(), longRef.element)).booleanValue()) {
                    break;
                }
                i2++;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 == null) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i >= size2) {
                        break;
                    }
                    PointerInputChange pointerInputChange4 = changes2.get(i);
                    if (Boolean.valueOf(pointerInputChange4.getPressed()).booleanValue()) {
                        pointerInputChange3 = pointerInputChange4;
                        break;
                    }
                    i++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange3;
                if (pointerInputChange5 == null) {
                    break;
                }
                longRef.element = pointerInputChange5.getId();
            } else if (function1.invoke(pointerInputChange2).booleanValue()) {
                break;
            }
        }
        return pointerInputChange2;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0193 -> B:62:0x0197). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-6ksA65w, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m2269awaitPointerSlopOrCancellation6ksA65w(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Orientation orientation, long j2, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitPointerSlopOrCancellation$1;
        float fM2281pointerSlopE8SPZFQ;
        Function2<? super PointerInputChange, ? super Offset, Unit> function22;
        Ref.LongRef longRef;
        DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitPointerSlopOrCancellation$12;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        Ref.LongRef longRef2;
        AwaitPointerEventScope awaitPointerEventScope3;
        Function2<? super PointerInputChange, ? super Offset, Unit> function23;
        TouchSlopDetector touchSlopDetector2;
        float f;
        int size;
        int i2;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        int i3;
        PointerInputChange pointerInputChange3;
        int i4;
        Object objAwaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitPointerSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$1 = (DragGestureDetectorKt$awaitPointerSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitPointerSlopOrCancellation$1 = new DragGestureDetectorKt$awaitPointerSlopOrCancellation$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.label;
        int i6 = 1;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            if (m2280isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                return null;
            }
            fM2281pointerSlopE8SPZFQ = m2281pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
            Ref.LongRef longRef3 = new Ref.LongRef();
            longRef3.element = j;
            function22 = function2;
            longRef = longRef3;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1;
            touchSlopDetector = new TouchSlopDetector(orientation, j2, null);
            awaitPointerEventScope2 = awaitPointerEventScope;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = function22;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = null;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = fM2281pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = i6;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12, i6, null);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i5 == 1) {
            f = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.F$0;
            touchSlopDetector2 = (TouchSlopDetector) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$3;
            Ref.LongRef longRef4 = (Ref.LongRef) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$2;
            function23 = (Function2) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$1;
            awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj);
            longRef2 = longRef4;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1;
            Ref.LongRef longRef5 = longRef2;
            PointerEvent pointerEvent = (PointerEvent) obj;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            i2 = 0;
            while (true) {
                if (i2 < size) {
                }
                i2 = i4 + 1;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 != null) {
                return null;
            }
            if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
            }
            i6 = i3;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = function22;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = null;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = fM2281pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = i6;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12, i6, null);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i5 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        float f2 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.F$0;
        PointerInputChange pointerInputChange4 = (PointerInputChange) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$4;
        TouchSlopDetector touchSlopDetector3 = (TouchSlopDetector) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$3;
        Ref.LongRef longRef6 = (Ref.LongRef) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$2;
        Function2<? super PointerInputChange, ? super Offset, Unit> function24 = (Function2) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$1;
        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$0;
        ResultKt.throwOnFailure(obj);
        pointerInputChange2 = pointerInputChange4;
        char c = 2;
        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1;
        touchSlopDetector = touchSlopDetector3;
        fM2281pointerSlopE8SPZFQ = f2;
        awaitPointerEventScope2 = awaitPointerEventScope4;
        i3 = 1;
        Ref.LongRef longRef7 = longRef6;
        function23 = function24;
        if (!pointerInputChange2.isConsumed()) {
            return null;
        }
        function22 = function23;
        longRef = longRef7;
        i6 = i3;
        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = function22;
        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = longRef;
        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = touchSlopDetector;
        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = null;
        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = fM2281pointerSlopE8SPZFQ;
        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = i6;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12, i6, null);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
            awaitPointerEventScope3 = awaitPointerEventScope2;
            f = fM2281pointerSlopE8SPZFQ;
            obj = objAwaitPointerEvent$default;
            longRef2 = longRef;
            function23 = function22;
            touchSlopDetector2 = touchSlopDetector;
            Ref.LongRef longRef52 = longRef2;
            PointerEvent pointerEvent2 = (PointerEvent) obj;
            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
            size = changes2.size();
            i2 = 0;
            while (true) {
                if (i2 < size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes2.get(i2);
                i4 = i2;
                if (PointerId.m9471equalsimpl0(pointerInputChange.getId(), longRef52.element)) {
                    break;
                }
                i2 = i4 + 1;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 != null || pointerInputChange2.isConsumed()) {
                return null;
            }
            if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size2 = changes3.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size2) {
                        pointerInputChange3 = null;
                        break;
                    }
                    pointerInputChange3 = changes3.get(i7);
                    if (pointerInputChange3.getPressed()) {
                        break;
                    }
                    i7++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange3;
                if (pointerInputChange5 == null) {
                    return null;
                }
                longRef52.element = pointerInputChange5.getId();
                fM2281pointerSlopE8SPZFQ = f;
                TouchSlopDetector touchSlopDetector4 = touchSlopDetector2;
                i3 = 1;
                function22 = function23;
                awaitPointerEventScope2 = awaitPointerEventScope3;
                longRef = longRef52;
                touchSlopDetector = touchSlopDetector4;
            } else {
                float f3 = f;
                TouchSlopDetector touchSlopDetector5 = touchSlopDetector2;
                long jM2414getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m2414getPostSlopOffsetqto3Fdw$default(touchSlopDetector5, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange2), f3, false, 4, null);
                fM2281pointerSlopE8SPZFQ = f3;
                if ((9223372034707292159L & jM2414getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    function23.invoke(pointerInputChange2, Offset.m7892boximpl(jM2414getPostSlopOffsetqto3Fdw$default));
                    if (pointerInputChange2.isConsumed()) {
                        return pointerInputChange2;
                    }
                    i3 = 1;
                    TouchSlopDetector.m2415resetk4lQ0M$default(touchSlopDetector5, 0L, 1, null);
                    function22 = function23;
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    longRef = longRef52;
                    touchSlopDetector = touchSlopDetector5;
                } else {
                    i3 = 1;
                    PointerEventPass pointerEventPass = PointerEventPass.Final;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = awaitPointerEventScope3;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = function23;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = longRef52;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = touchSlopDetector5;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = pointerInputChange2;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = fM2281pointerSlopE8SPZFQ;
                    c = 2;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = 2;
                    if (awaitPointerEventScope3.awaitPointerEvent(pointerEventPass, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12) != coroutine_suspended) {
                        longRef7 = longRef52;
                        touchSlopDetector = touchSlopDetector5;
                        awaitPointerEventScope2 = awaitPointerEventScope3;
                        if (!pointerInputChange2.isConsumed()) {
                        }
                    }
                }
            }
            i6 = i3;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = function22;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = null;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = fM2281pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = i6;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12, i6, null);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-6ksA65w$default, reason: not valid java name */
    public static /* synthetic */ Object m2271awaitPointerSlopOrCancellation6ksA65w$default(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Orientation orientation, long j2, Function2 function2, Continuation continuation, int i2, Object obj) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        long jM7919getZeroF1C5BW0 = (i2 & 8) != 0 ? Offset.INSTANCE.m7919getZeroF1C5BW0() : j2;
        long id = j;
        if (m2280isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), id)) {
            return null;
        }
        float fM2281pointerSlopE8SPZFQ = m2281pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
        TouchSlopDetector touchSlopDetector = new TouchSlopDetector(orientation, jM7919getZeroF1C5BW0, null);
        while (true) {
            PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i4);
                if (PointerId.m9471equalsimpl0(pointerInputChange.getId(), id)) {
                    break;
                }
                i4++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null || pointerInputChange3.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i3 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i3);
                    if (pointerInputChange2.getPressed()) {
                        break;
                    }
                    i3++;
                }
                PointerInputChange pointerInputChange4 = pointerInputChange2;
                if (pointerInputChange4 == null) {
                    return null;
                }
                id = pointerInputChange4.getId();
            } else {
                long jM2414getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m2414getPostSlopOffsetqto3Fdw$default(touchSlopDetector, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange3), fM2281pointerSlopE8SPZFQ, false, 4, null);
                if ((9223372034707292159L & jM2414getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    function2.invoke(pointerInputChange3, Offset.m7892boximpl(jM2414getPostSlopOffsetqto3Fdw$default));
                    if (pointerInputChange3.isConsumed()) {
                        return pointerInputChange3;
                    }
                    TouchSlopDetector.m2415resetk4lQ0M$default(touchSlopDetector, 0L, 1, null);
                } else {
                    awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Final, continuation);
                    if (pointerInputChange3.isConsumed()) {
                        break;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-6ksA65w$$forInline, reason: not valid java name */
    private static final Object m2270awaitPointerSlopOrCancellation6ksA65w$$forInline(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Orientation orientation, long j2, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (m2280isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        float fM2281pointerSlopE8SPZFQ = m2281pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j;
        TouchSlopDetector touchSlopDetector = new TouchSlopDetector(orientation, j2, null);
        while (true) {
            PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                int i3 = i2;
                if (Boolean.valueOf(PointerId.m9471equalsimpl0(pointerInputChange.getId(), longRef.element)).booleanValue()) {
                    break;
                }
                i2 = i3 + 1;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null || pointerInputChange3.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i4);
                    if (Boolean.valueOf(pointerInputChange2.getPressed()).booleanValue()) {
                        break;
                    }
                    i4++;
                }
                PointerInputChange pointerInputChange4 = pointerInputChange2;
                if (pointerInputChange4 == null) {
                    return null;
                }
                longRef.element = pointerInputChange4.getId();
            } else {
                long jM2414getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m2414getPostSlopOffsetqto3Fdw$default(touchSlopDetector, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange3), fM2281pointerSlopE8SPZFQ, false, 4, null);
                if ((9223372034707292159L & jM2414getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    function2.invoke(pointerInputChange3, Offset.m7892boximpl(jM2414getPostSlopOffsetqto3Fdw$default));
                    if (pointerInputChange3.isConsumed()) {
                        return pointerInputChange3;
                    }
                    TouchSlopDetector.m2415resetk4lQ0M$default(touchSlopDetector, 0L, 1, null);
                } else {
                    awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Final, continuation);
                    if (pointerInputChange3.isConsumed()) {
                        break;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Path cross not found for [B:32:0x00d6, B:38:0x00fd], limit reached: 69 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00cf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x009b -> B:23:0x00a1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitAllPointersUpWithSlopDetection(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, PointerEventPass pointerEventPass, Continuation<? super Boolean> continuation) {
        C03801 c03801;
        Ref.LongRef longRef;
        int i;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        float f;
        C03801 c038012;
        PointerEventPass pointerEventPass2;
        Object objAwaitPointerEvent;
        float f2;
        PointerInputChange pointerInputChange2;
        float f3;
        int size;
        int i2;
        PointerInputChange pointerInputChange3;
        PointerInputChange pointerInputChange4;
        int size2;
        int i3;
        if (continuation instanceof C03801) {
            c03801 = (C03801) continuation;
            if ((c03801.label & Integer.MIN_VALUE) != 0) {
                c03801.label -= Integer.MIN_VALUE;
            } else {
                c03801 = new C03801(continuation);
            }
        }
        Object obj = c03801.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c03801.label;
        int i5 = 0;
        int i6 = 1;
        if (i4 != 0) {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            float f4 = c03801.F$0;
            int i7 = c03801.I$0;
            TouchSlopDetector touchSlopDetector2 = (TouchSlopDetector) c03801.L$3;
            Ref.LongRef longRef2 = (Ref.LongRef) c03801.L$2;
            PointerEventPass pointerEventPass3 = (PointerEventPass) c03801.L$1;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) c03801.L$0;
            ResultKt.throwOnFailure(obj);
            float f5 = f4;
            TouchSlopDetector touchSlopDetector3 = touchSlopDetector2;
            c038012 = c03801;
            pointerEventPass2 = pointerEventPass3;
            longRef = longRef2;
            PointerEvent pointerEvent = (PointerEvent) obj;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size3 = changes.size();
            int i8 = i5;
            while (true) {
                if (i8 < size3) {
                    f2 = f5;
                    pointerInputChange2 = null;
                    break;
                }
                pointerInputChange2 = changes.get(i8);
                f2 = f5;
                if (PointerId.m9471equalsimpl0(pointerInputChange2.getId(), longRef.element)) {
                    break;
                }
                i8++;
                f5 = f2;
            }
            PointerInputChange pointerInputChange5 = pointerInputChange2;
            if (pointerInputChange5 != null || PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange5)) {
                f3 = f2;
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                size = changes2.size();
                i2 = 0;
                while (true) {
                    if (i2 < size) {
                        pointerInputChange3 = null;
                        break;
                    }
                    PointerInputChange pointerInputChange6 = changes2.get(i2);
                    if (pointerInputChange6.getPressed()) {
                        pointerInputChange3 = pointerInputChange6;
                        break;
                    }
                    i2++;
                }
                pointerInputChange4 = pointerInputChange3;
                if (pointerInputChange4 != null) {
                    return Boxing.boxBoolean(i7 != 0);
                }
                longRef.element = pointerInputChange4.getId();
            } else {
                f3 = f2;
                if ((TouchSlopDetector.m2414getPostSlopOffsetqto3Fdw$default(touchSlopDetector3, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange5), f3, false, 4, null) & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    i = 1;
                }
                List<PointerInputChange> changes3 = pointerEvent.getChanges();
                size2 = changes3.size();
                for (i3 = 0; i3 < size2; i3++) {
                    if (changes3.get(i3).getPressed()) {
                        awaitPointerEventScope2 = awaitPointerEventScope3;
                        touchSlopDetector = touchSlopDetector3;
                        f = f3;
                        i5 = 0;
                        i6 = 1;
                        c038012.L$0 = awaitPointerEventScope2;
                        c038012.L$1 = pointerEventPass2;
                        c038012.L$2 = longRef;
                        c038012.L$3 = touchSlopDetector;
                        c038012.I$0 = i;
                        c038012.F$0 = f;
                        c038012.label = i6;
                        objAwaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass2, c038012);
                        if (objAwaitPointerEvent != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        awaitPointerEventScope3 = awaitPointerEventScope2;
                        obj = objAwaitPointerEvent;
                        f5 = f;
                        i7 = i;
                        touchSlopDetector3 = touchSlopDetector;
                        PointerEvent pointerEvent2 = (PointerEvent) obj;
                        List<PointerInputChange> changes4 = pointerEvent2.getChanges();
                        int size32 = changes4.size();
                        int i82 = i5;
                        while (true) {
                            if (i82 < size32) {
                            }
                            i82++;
                            f5 = f2;
                        }
                        PointerInputChange pointerInputChange52 = pointerInputChange2;
                        if (pointerInputChange52 != null) {
                        }
                        f3 = f2;
                        List<PointerInputChange> changes22 = pointerEvent2.getChanges();
                        size = changes22.size();
                        i2 = 0;
                        while (true) {
                            if (i2 < size) {
                            }
                            i2++;
                        }
                        pointerInputChange4 = pointerInputChange3;
                        if (pointerInputChange4 != null) {
                        }
                    }
                }
                return Boxing.boxBoolean(i == 0);
            }
            i = i7;
            List<PointerInputChange> changes32 = pointerEvent2.getChanges();
            size2 = changes32.size();
            while (i3 < size2) {
            }
            return Boxing.boxBoolean(i == 0);
        }
        ResultKt.throwOnFailure(obj);
        if (ForEachGestureKt.allPointersUp(awaitPointerEventScope)) {
            return Boxing.boxBoolean(false);
        }
        Ref.LongRef longRef3 = new Ref.LongRef();
        longRef3.element = pointerInputChange.getId();
        float fM2281pointerSlopE8SPZFQ = m2281pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), pointerInputChange.getType());
        longRef = longRef3;
        i = 0;
        touchSlopDetector = new TouchSlopDetector(null, 0L, 3, null);
        awaitPointerEventScope2 = awaitPointerEventScope;
        f = fM2281pointerSlopE8SPZFQ;
        c038012 = c03801;
        pointerEventPass2 = pointerEventPass;
        c038012.L$0 = awaitPointerEventScope2;
        c038012.L$1 = pointerEventPass2;
        c038012.L$2 = longRef;
        c038012.L$3 = touchSlopDetector;
        c038012.I$0 = i;
        c038012.F$0 = f;
        c038012.label = i6;
        objAwaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass2, c038012);
        if (objAwaitPointerEvent != coroutine_suspended) {
        }
    }

    public static /* synthetic */ Object awaitAllPointersUpWithSlopDetection$default(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return awaitAllPointersUpWithSlopDetection(awaitPointerEventScope, pointerInputChange, pointerEventPass, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r10v3, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r11v3, types: [T, androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Object] */
    /* JADX INFO: renamed from: awaitLongPressOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m2268awaitLongPressOrCancellationrnUCldI(AwaitPointerEventScope awaitPointerEventScope, long j, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$1 dragGestureDetectorKt$awaitLongPressOrCancellation$1;
        PointerInputChange pointerInputChange;
        Ref.BooleanRef booleanRef;
        Object obj;
        if (continuation instanceof DragGestureDetectorKt$awaitLongPressOrCancellation$1) {
            dragGestureDetectorKt$awaitLongPressOrCancellation$1 = (DragGestureDetectorKt$awaitLongPressOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitLongPressOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitLongPressOrCancellation$1 = new DragGestureDetectorKt$awaitLongPressOrCancellation$1(continuation);
            }
        }
        Object obj2 = dragGestureDetectorKt$awaitLongPressOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = dragGestureDetectorKt$awaitLongPressOrCancellation$1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj2);
                if (m2280isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                    return null;
                }
                List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                int size = changes.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        pointerInputChange = null;
                        break;
                    }
                    pointerInputChange = changes.get(i2);
                    if (PointerId.m9471equalsimpl0(pointerInputChange.getId(), j)) {
                        break;
                    }
                    i2++;
                }
                PointerInputChange pointerInputChange2 = pointerInputChange;
                if (pointerInputChange2 == 0) {
                    return null;
                }
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = pointerInputChange2;
                long longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
                Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$2 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(booleanRef2, objectRef2, objectRef, null);
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0 = pointerInputChange2;
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1 = objectRef;
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$2 = booleanRef2;
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.label = 1;
                if (awaitPointerEventScope.withTimeout(longPressTimeoutMillis, dragGestureDetectorKt$awaitLongPressOrCancellation$2, dragGestureDetectorKt$awaitLongPressOrCancellation$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                booleanRef = booleanRef2;
                j = objectRef;
                obj = pointerInputChange2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                booleanRef = (Ref.BooleanRef) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$2;
                Ref.ObjectRef objectRef3 = (Ref.ObjectRef) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1;
                PointerInputChange pointerInputChange3 = (PointerInputChange) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0;
                ResultKt.throwOnFailure(obj2);
                j = objectRef3;
                obj = pointerInputChange3;
            }
            if (!booleanRef.element) {
                return null;
            }
            PointerInputChange pointerInputChange4 = (PointerInputChange) j.element;
            return pointerInputChange4 == null ? obj : pointerInputChange4;
        } catch (PointerEventTimeoutCancellationException unused) {
            PointerInputChange pointerInputChange5 = (PointerInputChange) j.element;
            return pointerInputChange5 == null ? obj : pointerInputChange5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    public static final boolean m2280isPointerUpDmW0f2w(PointerEvent pointerEvent, long j) {
        PointerInputChange pointerInputChange;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i);
            if (PointerId.m9471equalsimpl0(pointerInputChange.getId(), j)) {
                break;
            }
            i++;
        }
        PointerInputChange pointerInputChange2 = pointerInputChange;
        if (pointerInputChange2 != null && pointerInputChange2.getPressed()) {
            z = true;
        }
        return true ^ z;
    }

    /* JADX INFO: renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m2281pointerSlopE8SPZFQ(ViewConfiguration viewConfiguration, int i) {
        return PointerType.m9565equalsimpl0(i, PointerType.INSTANCE.m9570getMouseT8wyACA()) ? viewConfiguration.getTouchSlop() * mouseToTouchSlopRatio : viewConfiguration.getTouchSlop();
    }

    static {
        float fM11017constructorimpl = C1486Dp.m11017constructorimpl((float) 0.125d);
        mouseSlop = fM11017constructorimpl;
        float fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(18);
        defaultTouchSlop = fM11017constructorimpl2;
        mouseToTouchSlopRatio = fM11017constructorimpl / fM11017constructorimpl2;
    }
}
