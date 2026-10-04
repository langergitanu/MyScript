package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.TransferableContent_androidKt;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursor_androidKt;
import androidx.compose.foundation.text.TextLayoutHelperKt;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequester;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.MathUtilsKt;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SelectionLayout;
import androidx.compose.foundation.text.selection.SelectionLayoutKt;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.foundation.text.selection.TextSelectionDelegateKt;
import androidx.compose.p004ui.focus.FocusProperties;
import androidx.compose.p004ui.geometry.InlineClassHelperKt;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.geometry.RectKt;
import androidx.compose.p004ui.hapticfeedback.HapticFeedback;
import androidx.compose.p004ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.p004ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p004ui.input.pointer.PointerInputChange;
import androidx.compose.p004ui.input.pointer.PointerInputScope;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.layout.LayoutCoordinatesKt;
import androidx.compose.p004ui.platform.ClipEntry;
import androidx.compose.p004ui.platform.Clipboard;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.TextLayoutInput;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextRange;
import androidx.compose.p004ui.text.TextRangeKt;
import androidx.compose.p004ui.text.style.ResolvedTextDirection;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.KotlinNothingValueException;
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
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: TextFieldSelectionState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u0001:\u0006å\u0001æ\u0001ç\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020\tH\u0000¢\u0006\u0002\bzJ\b\u0010{\u001a\u00020\tH\u0002J\u0006\u0010|\u001a\u00020}J\u0006\u0010~\u001a\u00020}J\u001c\u0010\u007f\u001a\u00020}2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J\u001d\u0010\u0084\u0001\u001a\u00020}2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J@\u0010\u0085\u0001\u001a\u0002022\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\u00142\u0007\u0010\u0086\u0001\u001a\u00020*2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ\u0015\u0010\u0087\u0001\u001a\u000202*\u00030\u0088\u0001H\u0086@¢\u0006\u0003\u0010\u0089\u0001J\u001e\u0010\u008a\u0001\u001a\u000202*\u00030\u0088\u00012\u0007\u0010\u008b\u0001\u001a\u00020\tH\u0086@¢\u0006\u0003\u0010\u008c\u0001J\u0010\u0010\u008d\u0001\u001a\u000202H\u0086@¢\u0006\u0003\u0010\u008e\u0001J\u000f\u0010\u008f\u0001\u001a\u0002022\u0006\u0010]\u001a\u00020\\J\u0007\u0010\u0090\u0001\u001a\u000202J\u0015\u0010\u0091\u0001\u001a\u000202*\u00030\u0088\u0001H\u0086@¢\u0006\u0003\u0010\u0089\u0001J?\u0010\u0092\u0001\u001a\u000202*\u00030\u0088\u00012\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u00012\r\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u000202012\r\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00020201H\u0086@¢\u0006\u0003\u0010\u0097\u0001J\u0019\u0010\u0098\u0001\u001a\u00020\t2\u0007\u0010\u0099\u0001\u001a\u00020;¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u0015\u0010\u009c\u0001\u001a\u000202*\u00030\u0088\u0001H\u0082@¢\u0006\u0003\u0010\u0089\u0001J$\u0010\u009d\u0001\u001a\u000202*\u00030\u0088\u00012\r\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020201H\u0086@¢\u0006\u0003\u0010\u009e\u0001J\u0007\u0010\u009f\u0001\u001a\u000202J\u001e\u0010 \u0001\u001a\u000202*\u00030\u0088\u00012\u0007\u0010\u008b\u0001\u001a\u00020\tH\u0082@¢\u0006\u0003\u0010\u008c\u0001J\u0010\u0010¡\u0001\u001a\u000202H\u0082@¢\u0006\u0003\u0010\u008e\u0001J\u0010\u0010¢\u0001\u001a\u000202H\u0082@¢\u0006\u0003\u0010\u008e\u0001J\t\u0010¨\u0001\u001a\u00020}H\u0002J \u0010©\u0001\u001a\u00020x2\u0007\u0010\u008b\u0001\u001a\u00020\t2\u0006\u0010y\u001a\u00020\tH\u0000¢\u0006\u0003\bª\u0001J\u001b\u0010«\u0001\u001a\u00020;2\u0007\u0010\u008b\u0001\u001a\u00020\tH\u0002¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001J\"\u0010®\u0001\u001a\u0002022\u0007\u0010¯\u0001\u001a\u00020J2\u0007\u0010°\u0001\u001a\u00020;¢\u0006\u0006\b±\u0001\u0010²\u0001J\t\u0010³\u0001\u001a\u000202H\u0002J\u0007\u0010´\u0001\u001a\u000202J\u0007\u0010µ\u0001\u001a\u00020\tJ\n\u0010¶\u0001\u001a\u00020\tH\u0086\bJ\u0010\u0010·\u0001\u001a\u000202H\u0086@¢\u0006\u0003\u0010\u008e\u0001J\n\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001J\u0007\u0010º\u0001\u001a\u00020\tJ\n\u0010»\u0001\u001a\u00020\tH\u0086\bJ\u001b\u0010¼\u0001\u001a\u0002022\t\b\u0002\u0010½\u0001\u001a\u00020\tH\u0086@¢\u0006\u0003\u0010¾\u0001J\u001d\u0010¿\u0001\u001a\u0005\u0018\u00010¹\u00012\t\b\u0002\u0010½\u0001\u001a\u00020\tH\u0000¢\u0006\u0003\bÀ\u0001J\u0010\u0010Ã\u0001\u001a\u000202H\u0086@¢\u0006\u0003\u0010\u008e\u0001J\u0007\u0010Ä\u0001\u001a\u00020\tJ\n\u0010Å\u0001\u001a\u00020\tH\u0086\bJ\u0010\u0010Æ\u0001\u001a\u000202H\u0086@¢\u0006\u0003\u0010\u008e\u0001J\u0010\u0010Ç\u0001\u001a\u000202H\u0082@¢\u0006\u0003\u0010\u008e\u0001J\u0018\u0010È\u0001\u001a\u0002022\u0007\u0010 \u001a\u00030¹\u0001H\u0000¢\u0006\u0003\bÉ\u0001J\u0007\u0010Ê\u0001\u001a\u00020\tJ\u0007\u0010Ë\u0001\u001a\u000202J\u0007\u0010Ì\u0001\u001a\u00020\tJ\u0007\u0010Í\u0001\u001a\u000202J\u0019\u0010\u0086\u0001\u001a\u0002022\u0007\u0010Î\u0001\u001a\u00020}H\u0082@¢\u0006\u0003\u0010Ï\u0001J\u0007\u0010Ð\u0001\u001a\u000202J\t\u0010Ñ\u0001\u001a\u000202H\u0002Jd\u0010Ò\u0001\u001a\u00030Ó\u00012\b\u0010Ô\u0001\u001a\u00030\u0083\u00012\u0007\u0010Õ\u0001\u001a\u00020p2\u0007\u0010Ö\u0001\u001a\u00020p2\u0007\u0010\u008b\u0001\u001a\u00020\t2\b\u0010×\u0001\u001a\u00030Ø\u00012\t\b\u0002\u0010Ù\u0001\u001a\u00020\t2\t\b\u0002\u0010Ú\u0001\u001a\u00020\t2\n\u0010Û\u0001\u001a\u0005\u0018\u00010Ü\u0001H\u0000¢\u0006\u0006\bÝ\u0001\u0010Þ\u0001JD\u0010ß\u0001\u001a\u00030Ó\u00012\u0007\u0010à\u0001\u001a\u00020p2\u0007\u0010á\u0001\u001a\u00020p2\n\u0010â\u0001\u001a\u0005\u0018\u00010Ó\u00012\u0007\u0010\u008b\u0001\u001a\u00020\t2\b\u0010×\u0001\u001a\u00030Ø\u0001H\u0002¢\u0006\u0006\bã\u0001\u0010ä\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u001e\u0010\n\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR\"\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u000108\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00104\"\u0004\b:\u00106R+\u0010<\u001a\u00020;2\u0006\u0010+\u001a\u00020;8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bA\u0010/\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020;8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010>R+\u0010D\u001a\u00020;2\u0006\u0010+\u001a\u00020;8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bG\u0010/\u001a\u0004\bE\u0010>\"\u0004\bF\u0010@R\u0011\u0010H\u001a\u00020;8F¢\u0006\u0006\u001a\u0004\bI\u0010>R/\u0010K\u001a\u0004\u0018\u00010J2\b\u0010+\u001a\u0004\u0018\u00010J8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bP\u0010/\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR+\u0010R\u001a\u00020Q2\u0006\u0010+\u001a\u00020Q8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bW\u0010/\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR+\u0010X\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b[\u0010/\u001a\u0004\bY\u0010\u001b\"\u0004\bZ\u0010\u001dR+\u0010]\u001a\u00020\\2\u0006\u0010+\u001a\u00020\\8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bb\u0010/\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR+\u0010c\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t8F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bf\u0010/\u001a\u0004\bd\u0010\u001b\"\u0004\be\u0010\u001dR\u0016\u0010g\u001a\u0004\u0018\u00010h8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bi\u0010jR\u0014\u0010k\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bl\u0010\u001bR\u0010\u0010m\u001a\u0004\u0018\u00010nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020pX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010q\u001a\u0004\u0018\u00010rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\"\u0010£\u0001\u001a\u0004\u0018\u00010}8@X\u0080\u0084\u0002¢\u0006\u0010\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001R\u0010\u0010Á\u0001\u001a\u00030Â\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006è\u0001"}, m1599d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "density", "Landroidx/compose/ui/unit/Density;", "enabled", "", "readOnly", "isFocused", "isPassword", "toolbarRequester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "platformSelectionBehaviors", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "clipboard", "Landroidx/compose/ui/platform/Clipboard;", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/unit/Density;ZZZZLandroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;Landroidx/compose/ui/platform/Clipboard;)V", "getTextFieldState$foundation", "()Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "getTextLayoutState$foundation", "()Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "()Z", "setFocused", "(Z)V", "getPlatformSelectionBehaviors$foundation", "()Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "value", "getEnabled", "getReadOnly", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "textToolbarHandler", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarHandler;", "<set-?>", "isInTouchMode", "setInTouchMode", "isInTouchMode$delegate", "Landroidx/compose/runtime/MutableState;", "requestAutofillAction", "Lkotlin/Function0;", "", "getRequestAutofillAction", "()Lkotlin/jvm/functions/Function0;", "setRequestAutofillAction", "(Lkotlin/jvm/functions/Function0;)V", "receiveContentConfiguration", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "getReceiveContentConfiguration", "setReceiveContentConfiguration", "Landroidx/compose/ui/geometry/Offset;", "startTextLayoutPositionInWindow", "getStartTextLayoutPositionInWindow-F1C5BW0", "()J", "setStartTextLayoutPositionInWindow-k-4lQ0M", "(J)V", "startTextLayoutPositionInWindow$delegate", "currentTextLayoutPositionInWindow", "getCurrentTextLayoutPositionInWindow-F1C5BW0", "rawHandleDragPosition", "getRawHandleDragPosition-F1C5BW0", "setRawHandleDragPosition-k-4lQ0M", "rawHandleDragPosition$delegate", "handleDragPosition", "getHandleDragPosition-F1C5BW0", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "directDragGestureInitiator", "getDirectDragGestureInitiator", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "setDirectDragGestureInitiator", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;)V", "directDragGestureInitiator$delegate", "showCursorHandle", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle$delegate", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "textToolbarState", "getTextToolbarState", "()Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "setTextToolbarState", "(Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;)V", "textToolbarState$delegate", "textToolbarShown", "getTextToolbarShown", "setTextToolbarShown$foundation", "textToolbarShown$delegate", "textLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getTextLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "editable", "getEditable$foundation", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "previousRawDragOffset", "", "pressInteraction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "getPressInteraction", "()Landroidx/compose/foundation/interaction/PressInteraction$Press;", "setPressInteraction", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;)V", "getCursorHandleState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "includePosition", "getCursorHandleState$foundation", "isCursorHandleInVisibleBounds", "getCursorRect", "Landroidx/compose/ui/geometry/Rect;", "getFocusRect", "calculateCursorRect", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "visualText", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "calculateSelectionRect", "update", "showTextToolbar", "cursorHandleGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectionHandleGestures", "isStartHandle", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startToolbarAndHandlesVisibilityObserver", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTextToolbarState", "dispose", "detectTouchMode", "detectTextFieldTapGestures", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "requestFocus", "showKeyboard", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "placeCursorAtNearestOffset", TypedValues.CycleType.S_WAVE_OFFSET, "placeCursorAtNearestOffset-k-4lQ0M", "(J)Z", "detectCursorHandleDragGestures", "textFieldSelectionGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "maybeSuggestSelectionRange", "detectSelectionHandleDragGestures", "observeTextChanges", "observeTextToolbarVisibility", "derivedVisibleContentBounds", "getDerivedVisibleContentBounds$foundation", "()Landroidx/compose/ui/geometry/Rect;", "derivedVisibleContentBounds$delegate", "Landroidx/compose/runtime/State;", "getContentRect", "getSelectionHandleState", "getSelectionHandleState$foundation", "getHandlePosition", "getHandlePosition-tuRUvjQ", "(Z)J", "updateHandleDragging", "handle", "position", "updateHandleDragging-Uv8p0NA", "(Landroidx/compose/foundation/text/Handle;J)V", "markStartContentVisibleOffset", "clearHandleDragging", "canShowCutMenuItem", "isCutAllowed", "cut", "cutWithResult", "Landroidx/compose/ui/text/AnnotatedString;", "canShowCopyMenuItem", "isCopyAllowed", "copy", "cancelSelection", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyWithResult", "copyWithResult$foundation", "clipboardPasteState", "Landroidx/compose/foundation/text/input/internal/selection/ClipboardPasteState;", "updateClipboardEntry", "canShowPasteMenuItem", "isPasteAllowed", "paste", "pasteAsPlainText", "onPasteEvent", "onPasteEvent$foundation", "canShowSelectAllMenuItem", "selectAll", "canShowAutofillMenuItem", "autofill", "contentRect", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deselect", "hideTextToolbar", "updateSelection", "Landroidx/compose/ui/text/TextRange;", "textFieldCharSequence", "startOffset", "endOffset", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "allowPreviousSelectionCollapsed", "isStartOfSelection", "hapticFeedbackType", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "updateSelection-QkiN0lo$foundation", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;IIZLandroidx/compose/foundation/text/selection/SelectionAdjustment;ZZLandroidx/compose/ui/hapticfeedback/HapticFeedbackType;)J", "getTextFieldSelection", "rawStartOffset", "rawEndOffset", "previousSelection", "getTextFieldSelection-qeG_v_k", "(IILandroidx/compose/ui/text/TextRange;ZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)J", "InputType", "TextFieldMouseSelectionObserver", "TextFieldTextDragObserver", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TextFieldSelectionState {
    public static final int $stable = 8;
    private Clipboard clipboard;
    private ClipboardPasteState clipboardPasteState;
    private final CoroutineScope coroutineScope;
    private Density density;
    private boolean enabled;
    private HapticFeedback hapticFeedBack;
    private boolean isFocused;
    private boolean isPassword;
    private final PlatformSelectionBehaviors platformSelectionBehaviors;
    private PressInteraction.Press pressInteraction;
    private SelectionLayout previousSelectionLayout;
    private boolean readOnly;
    private Function0<? extends ReceiveContentConfiguration> receiveContentConfiguration;
    private Function0<Unit> requestAutofillAction;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;
    private TextToolbarHandler textToolbarHandler;
    private final ToolbarRequester toolbarRequester;

    /* JADX INFO: renamed from: isInTouchMode$delegate, reason: from kotlin metadata */
    private final MutableState isInTouchMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);

    /* JADX INFO: renamed from: startTextLayoutPositionInWindow$delegate, reason: from kotlin metadata */
    private final MutableState startTextLayoutPositionInWindow = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m7892boximpl(Offset.INSTANCE.m7918getUnspecifiedF1C5BW0()), null, 2, null);

    /* JADX INFO: renamed from: rawHandleDragPosition$delegate, reason: from kotlin metadata */
    private final MutableState rawHandleDragPosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m7892boximpl(Offset.INSTANCE.m7918getUnspecifiedF1C5BW0()), null, 2, null);

    /* JADX INFO: renamed from: draggingHandle$delegate, reason: from kotlin metadata */
    private final MutableState draggingHandle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* JADX INFO: renamed from: directDragGestureInitiator$delegate, reason: from kotlin metadata */
    private final MutableState directDragGestureInitiator = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(InputType.None, null, 2, null);

    /* JADX INFO: renamed from: showCursorHandle$delegate, reason: from kotlin metadata */
    private final MutableState showCursorHandle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* JADX INFO: renamed from: textToolbarState$delegate, reason: from kotlin metadata */
    private final MutableState textToolbarState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextToolbarState.None, null, 2, null);

    /* JADX INFO: renamed from: textToolbarShown$delegate, reason: from kotlin metadata */
    private final MutableState textToolbarShown = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    private int previousRawDragOffset = -1;

    /* JADX INFO: renamed from: derivedVisibleContentBounds$delegate, reason: from kotlin metadata */
    private final State derivedVisibleContentBounds = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return TextFieldSelectionState.derivedVisibleContentBounds_delegate$lambda$0(this.f$0);
        }
    });

    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IndexTransformationType.values().length];
            try {
                iArr[IndexTransformationType.Untransformed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IndexTransformationType.Deletion.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IndexTransformationType.Insertion.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IndexTransformationType.Replacement.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", m1609f = "TextFieldSelectionState.kt", m1610i = {0, 0}, m1611l = {676}, m1612m = "detectCursorHandleDragGestures", m1613n = {"cursorDragStart", "cursorDragDelta"}, m1615s = {"L$0", "L$1"}, m1616v = 1)
    static final class C07641 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C07641(Continuation<? super C07641> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextFieldSelectionState.this.detectCursorHandleDragGestures(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$1 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", m1609f = "TextFieldSelectionState.kt", m1610i = {0, 0, 0}, m1611l = {1162}, m1612m = "detectSelectionHandleDragGestures", m1613n = {"dragBeginPosition", "dragTotalDistance", "handle"}, m1615s = {"L$0", "L$1", "L$2"}, m1616v = 1)
    static final class C07651 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C07651(Continuation<? super C07651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextFieldSelectionState.this.detectSelectionHandleDragGestures(null, false, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$paste$1 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", m1609f = "TextFieldSelectionState.kt", m1610i = {1}, m1611l = {1570, 1572, 1572}, m1612m = "paste", m1613n = {"receiveContentConfiguration"}, m1615s = {"L$0"}, m1616v = 1)
    static final class C07711 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C07711(Continuation<? super C07711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextFieldSelectionState.this.paste(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$pasteAsPlainText$1 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", m1609f = "TextFieldSelectionState.kt", m1610i = {}, m1611l = {1603, 1603}, m1612m = "pasteAsPlainText", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C07721 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07721(Continuation<? super C07721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextFieldSelectionState.this.pasteAsPlainText(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", m1609f = "TextFieldSelectionState.kt", m1610i = {}, m1611l = {537}, m1612m = "startToolbarAndHandlesVisibilityObserver", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C07761 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07761(Continuation<? super C07761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextFieldSelectionState.this.startToolbarAndHandlesVisibilityObserver(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean observeTextToolbarVisibility$lambda$1$0(Rect rect) {
        return rect == null;
    }

    public TextFieldSelectionState(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, Density density, boolean z, boolean z2, boolean z3, boolean z4, ToolbarRequester toolbarRequester, CoroutineScope coroutineScope, PlatformSelectionBehaviors platformSelectionBehaviors, Clipboard clipboard) {
        this.textFieldState = transformedTextFieldState;
        this.textLayoutState = textLayoutState;
        this.density = density;
        this.isFocused = z3;
        this.isPassword = z4;
        this.toolbarRequester = toolbarRequester;
        this.coroutineScope = coroutineScope;
        this.platformSelectionBehaviors = platformSelectionBehaviors;
        this.clipboard = clipboard;
        this.enabled = z;
        this.readOnly = z2;
        this.clipboardPasteState = new ClipboardPasteState(this.clipboard);
    }

    /* JADX INFO: renamed from: getTextFieldState$foundation, reason: from getter */
    public final TransformedTextFieldState getTextFieldState() {
        return this.textFieldState;
    }

    /* JADX INFO: renamed from: getTextLayoutState$foundation, reason: from getter */
    public final TextLayoutState getTextLayoutState() {
        return this.textLayoutState;
    }

    /* JADX INFO: renamed from: isFocused, reason: from getter */
    public final boolean getIsFocused() {
        return this.isFocused;
    }

    public final void setFocused(boolean z) {
        this.isFocused = z;
    }

    /* JADX INFO: renamed from: getPlatformSelectionBehaviors$foundation, reason: from getter */
    public final PlatformSelectionBehaviors getPlatformSelectionBehaviors() {
        return this.platformSelectionBehaviors;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isInTouchMode() {
        return ((Boolean) this.isInTouchMode.getValue()).booleanValue();
    }

    public final void setInTouchMode(boolean z) {
        this.isInTouchMode.setValue(Boolean.valueOf(z));
    }

    public final Function0<Unit> getRequestAutofillAction() {
        return this.requestAutofillAction;
    }

    public final void setRequestAutofillAction(Function0<Unit> function0) {
        this.requestAutofillAction = function0;
    }

    public final Function0<ReceiveContentConfiguration> getReceiveContentConfiguration() {
        return this.receiveContentConfiguration;
    }

    public final void setReceiveContentConfiguration(Function0<? extends ReceiveContentConfiguration> function0) {
        this.receiveContentConfiguration = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getStartTextLayoutPositionInWindow-F1C5BW0, reason: not valid java name */
    private final long m3877getStartTextLayoutPositionInWindowF1C5BW0() {
        return ((Offset) this.startTextLayoutPositionInWindow.getValue()).m7913unboximpl();
    }

    /* JADX INFO: renamed from: setStartTextLayoutPositionInWindow-k-4lQ0M, reason: not valid java name */
    private final void m3880setStartTextLayoutPositionInWindowk4lQ0M(long j) {
        this.startTextLayoutPositionInWindow.setValue(Offset.m7892boximpl(j));
    }

    /* JADX INFO: renamed from: getCurrentTextLayoutPositionInWindow-F1C5BW0, reason: not valid java name */
    private final long m3874getCurrentTextLayoutPositionInWindowF1C5BW0() {
        LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
        return textLayoutCoordinates != null ? LayoutCoordinatesKt.positionInWindow(textLayoutCoordinates) : Offset.INSTANCE.m7918getUnspecifiedF1C5BW0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getRawHandleDragPosition-F1C5BW0, reason: not valid java name */
    private final long m3876getRawHandleDragPositionF1C5BW0() {
        return ((Offset) this.rawHandleDragPosition.getValue()).m7913unboximpl();
    }

    /* JADX INFO: renamed from: setRawHandleDragPosition-k-4lQ0M, reason: not valid java name */
    private final void m3879setRawHandleDragPositionk4lQ0M(long j) {
        this.rawHandleDragPosition.setValue(Offset.m7892boximpl(j));
    }

    /* JADX INFO: renamed from: getHandleDragPosition-F1C5BW0, reason: not valid java name */
    public final long m3882getHandleDragPositionF1C5BW0() {
        if ((m3876getRawHandleDragPositionF1C5BW0() & 9223372034707292159L) == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return Offset.INSTANCE.m7918getUnspecifiedF1C5BW0();
        }
        if ((m3877getStartTextLayoutPositionInWindowF1C5BW0() & 9223372034707292159L) == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return TextLayoutStateKt.m3820fromDecorationToTextLayoutUv8p0NA(this.textLayoutState, m3876getRawHandleDragPositionF1C5BW0());
        }
        return Offset.m7908plusMKHz9U(m3876getRawHandleDragPositionF1C5BW0(), Offset.m7907minusMKHz9U(m3877getStartTextLayoutPositionInWindowF1C5BW0(), m3874getCurrentTextLayoutPositionInWindowF1C5BW0()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle.getValue();
    }

    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle.setValue(handle);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Touch", "Mouse", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class InputType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ InputType[] $VALUES;
        public static final InputType None = new InputType("None", 0);
        public static final InputType Touch = new InputType("Touch", 1);
        public static final InputType Mouse = new InputType("Mouse", 2);

        private static final /* synthetic */ InputType[] $values() {
            return new InputType[]{None, Touch, Mouse};
        }

        public static EnumEntries<InputType> getEntries() {
            return $ENTRIES;
        }

        public static InputType valueOf(String str) {
            return (InputType) Enum.valueOf(InputType.class, str);
        }

        public static InputType[] values() {
            return (InputType[]) $VALUES.clone();
        }

        private InputType(String str, int i) {
        }

        static {
            InputType[] inputTypeArr$values = $values();
            $VALUES = inputTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(inputTypeArr$values);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final InputType getDirectDragGestureInitiator() {
        return (InputType) this.directDragGestureInitiator.getValue();
    }

    public final void setDirectDragGestureInitiator(InputType inputType) {
        this.directDragGestureInitiator.setValue(inputType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getShowCursorHandle() {
        return ((Boolean) this.showCursorHandle.getValue()).booleanValue();
    }

    public final void setShowCursorHandle(boolean z) {
        this.showCursorHandle.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final TextToolbarState getTextToolbarState() {
        return (TextToolbarState) this.textToolbarState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextToolbarState(TextToolbarState textToolbarState) {
        this.textToolbarState.setValue(textToolbarState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getTextToolbarShown() {
        return ((Boolean) this.textToolbarShown.getValue()).booleanValue();
    }

    public final void setTextToolbarShown$foundation(boolean z) {
        this.textToolbarShown.setValue(Boolean.valueOf(z));
    }

    private final LayoutCoordinates getTextLayoutCoordinates() {
        LayoutCoordinates textLayoutNodeCoordinates = this.textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates == null || !textLayoutNodeCoordinates.isAttached()) {
            return null;
        }
        return textLayoutNodeCoordinates;
    }

    public final boolean getEditable$foundation() {
        return this.enabled && !this.readOnly;
    }

    public final PressInteraction.Press getPressInteraction() {
        return this.pressInteraction;
    }

    public final void setPressInteraction(PressInteraction.Press press) {
        this.pressInteraction = press;
    }

    public final TextFieldHandleState getCursorHandleState$foundation(boolean includePosition) {
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        boolean showCursorHandle = getShowCursorHandle();
        boolean z = getDirectDragGestureInitiator() == InputType.None;
        Handle draggingHandle = getDraggingHandle();
        if (!showCursorHandle || !z || !TextRange.m10447getCollapsedimpl(visualText.getSelection()) || !visualText.shouldShowSelection() || visualText.length() <= 0 || (draggingHandle != Handle.Cursor && !isCursorHandleInVisibleBounds())) {
            return TextFieldHandleState.INSTANCE.getHidden();
        }
        return new TextFieldHandleState(true, includePosition ? getCursorRect().m7930getBottomCenterF1C5BW0() : Offset.INSTANCE.m7918getUnspecifiedF1C5BW0(), 0.0f, ResolvedTextDirection.Ltr, false, null);
    }

    private final boolean isCursorHandleInVisibleBounds() {
        Rect rectVisibleBounds;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            long jM7930getBottomCenterF1C5BW0 = getCursorRect().m7930getBottomCenterF1C5BW0();
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            if (textLayoutCoordinates == null || (rectVisibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) {
                return false;
            }
            return SelectionManagerKt.m4043containsInclusiveUv8p0NA(rectVisibleBounds, jM7930getBottomCenterF1C5BW0);
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    public final Rect getCursorRect() {
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        return layoutResult == null ? Rect.INSTANCE.getZero() : calculateCursorRect(layoutResult, this.textFieldState.getVisualText());
    }

    public final Rect getFocusRect() {
        Rect rectCalculateSelectionRect;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Rect.INSTANCE.getZero();
        }
        if (!this.isFocused) {
            return FocusProperties.INSTANCE.getUnsetFocusRect();
        }
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (TextRange.m10447getCollapsedimpl(visualText.getSelection())) {
            rectCalculateSelectionRect = calculateCursorRect(layoutResult, visualText);
        } else {
            rectCalculateSelectionRect = calculateSelectionRect(layoutResult, visualText);
        }
        return TextLayoutStateKt.fromTextLayoutToDecoration(this.textLayoutState, rectCalculateSelectionRect);
    }

    private final Rect calculateCursorRect(TextLayoutResult layoutResult, TextFieldCharSequence visualText) {
        float right;
        float fRint;
        if (!TextRange.m10447getCollapsedimpl(visualText.getSelection())) {
            return Rect.INSTANCE.getZero();
        }
        Rect cursorRect = layoutResult.getCursorRect(TextRange.m10453getStartimpl(visualText.getSelection()));
        float fCoerceAtLeast = RangesKt.coerceAtLeast((float) Math.floor(this.density.mo2191toPx0680j_4(TextFieldCursor_androidKt.getDefaultCursorThickness())), 1.0f);
        if (layoutResult.getLayoutInput().getLayoutDirection() == LayoutDirection.Ltr) {
            right = cursorRect.getLeft() + (fCoerceAtLeast / 2);
        } else {
            right = cursorRect.getRight() - (fCoerceAtLeast / 2);
        }
        float f = fCoerceAtLeast / 2;
        float fCoerceAtLeast2 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(right, ((int) (layoutResult.getSize() >> 32)) - f), f);
        if (((int) fCoerceAtLeast) % 2 == 1) {
            fRint = ((float) Math.floor(fCoerceAtLeast2)) + 0.5f;
        } else {
            fRint = (float) Math.rint(fCoerceAtLeast2);
        }
        return new Rect(fRint - f, cursorRect.getTop(), fRint + f, cursorRect.getBottom());
    }

    private final Rect calculateSelectionRect(TextLayoutResult layoutResult, TextFieldCharSequence visualText) {
        if (TextRange.m10447getCollapsedimpl(visualText.getSelection())) {
            return Rect.INSTANCE.getZero();
        }
        int lineForOffset = layoutResult.getLineForOffset(TextRange.m10453getStartimpl(visualText.getSelection()));
        int lineForOffset2 = layoutResult.getLineForOffset(TextRange.m10448getEndimpl(visualText.getSelection()));
        if (lineForOffset == lineForOffset2) {
            float horizontalPosition = layoutResult.getHorizontalPosition(TextRange.m10453getStartimpl(visualText.getSelection()), true);
            float horizontalPosition2 = layoutResult.getHorizontalPosition(TextRange.m10448getEndimpl(visualText.getSelection()), true);
            return new Rect(Math.min(horizontalPosition, horizontalPosition2), layoutResult.getLineTop(lineForOffset), Math.max(horizontalPosition, horizontalPosition2), layoutResult.getLineBottom(lineForOffset2));
        }
        return layoutResult.getPathForRange(TextRange.m10451getMinimpl(visualText.getSelection()), TextRange.m10450getMaximpl(visualText.getSelection())).getBounds();
    }

    public final void update(HapticFeedback hapticFeedBack, Clipboard clipboard, TextToolbarHandler showTextToolbar, Density density, boolean enabled, boolean readOnly, boolean isPassword) {
        if (!enabled) {
            hideTextToolbar();
        }
        this.hapticFeedBack = hapticFeedBack;
        this.clipboard = clipboard;
        this.textToolbarHandler = showTextToolbar;
        this.density = density;
        this.enabled = enabled;
        this.readOnly = readOnly;
        this.isPassword = isPassword;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2", m1609f = "TextFieldSelectionState.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C07622 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07622(PointerInputScope pointerInputScope, Continuation<? super C07622> continuation) {
            super(2, continuation);
            this.$this_cursorHandleGestures = pointerInputScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07622 c07622 = TextFieldSelectionState.this.new C07622(this.$this_cursorHandleGestures, continuation);
            c07622.L$0 = obj;
            return c07622;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((C07622) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldSelectionState.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$1", m1609f = "TextFieldSelectionState.kt", m1610i = {}, m1611l = {493}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
                this.$this_cursorHandleGestures = pointerInputScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$this_cursorHandleGestures, continuation);
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
                    this.label = 1;
                    if (this.this$0.detectTouchMode(this.$this_cursorHandleGestures, this) == coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(TextFieldSelectionState.this, this.$this_cursorHandleGestures, null), 1, null);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(TextFieldSelectionState.this, this.$this_cursorHandleGestures, null), 1, null);
                return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass3(this.$this_cursorHandleGestures, TextFieldSelectionState.this, null), 1, null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldSelectionState.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$2", m1609f = "TextFieldSelectionState.kt", m1610i = {}, m1611l = {494}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
                this.$this_cursorHandleGestures = pointerInputScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$this_cursorHandleGestures, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.this$0.detectCursorHandleDragGestures(this.$this_cursorHandleGestures, this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldSelectionState.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$3", m1609f = "TextFieldSelectionState.kt", m1610i = {}, m1611l = {496}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(PointerInputScope pointerInputScope, TextFieldSelectionState textFieldSelectionState, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$this_cursorHandleGestures = pointerInputScope;
                this.this$0 = textFieldSelectionState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.$this_cursorHandleGestures, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PointerInputScope pointerInputScope = this.$this_cursorHandleGestures;
                    final TextFieldSelectionState textFieldSelectionState = this.this$0;
                    this.label = 1;
                    if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, new Function1() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$3$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSelectionState.C07622.AnonymousClass3.invokeSuspend$lambda$0(textFieldSelectionState, (Offset) obj2);
                        }
                    }, this, 7, null) == coroutine_suspended) {
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

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$0(TextFieldSelectionState textFieldSelectionState, Offset offset) {
                textFieldSelectionState.setTextToolbarState(textFieldSelectionState.getTextToolbarState() == TextToolbarState.Cursor ? TextToolbarState.None : TextToolbarState.Cursor);
                return Unit.INSTANCE;
            }
        }
    }

    public final Object cursorHandleGestures(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C07622(pointerInputScope, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2", m1609f = "TextFieldSelectionState.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C07732 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ boolean $isStartHandle;
        final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07732(PointerInputScope pointerInputScope, boolean z, Continuation<? super C07732> continuation) {
            super(2, continuation);
            this.$this_selectionHandleGestures = pointerInputScope;
            this.$isStartHandle = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07732 c07732 = TextFieldSelectionState.this.new C07732(this.$this_selectionHandleGestures, this.$isStartHandle, continuation);
            c07732.L$0 = obj;
            return c07732;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((C07732) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldSelectionState.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$1", m1609f = "TextFieldSelectionState.kt", m1610i = {}, m1611l = {TypedValues.PositionType.TYPE_PERCENT_X}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
                this.$this_selectionHandleGestures = pointerInputScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$this_selectionHandleGestures, continuation);
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
                    this.label = 1;
                    if (this.this$0.detectTouchMode(this.$this_selectionHandleGestures, this) == coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(TextFieldSelectionState.this, this.$this_selectionHandleGestures, null), 1, null);
                Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(this.$this_selectionHandleGestures, TextFieldSelectionState.this, this.$isStartHandle, null), 1, null);
                final TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
                jobLaunch$default.invokeOnCompletion(new Function1() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSelectionState.C07732.invokeSuspend$lambda$0(textFieldSelectionState, (Throwable) obj2);
                    }
                });
                return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass4(TextFieldSelectionState.this, this.$this_selectionHandleGestures, this.$isStartHandle, null), 1, null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldSelectionState.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$2", m1609f = "TextFieldSelectionState.kt", m1610i = {}, m1611l = {TypedValues.PositionType.TYPE_CURVE_FIT}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $isStartHandle;
            final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(PointerInputScope pointerInputScope, TextFieldSelectionState textFieldSelectionState, boolean z, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$this_selectionHandleGestures = pointerInputScope;
                this.this$0 = textFieldSelectionState;
                this.$isStartHandle = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$this_selectionHandleGestures, this.this$0, this.$isStartHandle, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PointerInputScope pointerInputScope = this.$this_selectionHandleGestures;
                    final TextFieldSelectionState textFieldSelectionState = this.this$0;
                    final boolean z = this.$isStartHandle;
                    TapOnPosition tapOnPosition = new TapOnPosition() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.selectionHandleGestures.2.2.1
                        @Override // androidx.compose.foundation.text.input.internal.selection.TapOnPosition
                        /* JADX INFO: renamed from: onEvent-k-4lQ0M */
                        public final void mo3857onEventk4lQ0M(long j) {
                            Handle handle;
                            textFieldSelectionState.markStartContentVisibleOffset();
                            TextFieldSelectionState textFieldSelectionState2 = textFieldSelectionState;
                            if (z) {
                                handle = Handle.SelectionStart;
                            } else {
                                handle = Handle.SelectionEnd;
                            }
                            textFieldSelectionState2.m3884updateHandleDraggingUv8p0NA(handle, SelectionHandlesKt.m4009getAdjustedCoordinatesk4lQ0M(textFieldSelectionState.m3875getHandlePositiontuRUvjQ(z)));
                        }
                    };
                    final TextFieldSelectionState textFieldSelectionState2 = this.this$0;
                    this.label = 1;
                    if (PressDownGestureKt.detectPressDownGesture(pointerInputScope, tapOnPosition, new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$2$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TextFieldSelectionState.C07732.AnonymousClass2.invokeSuspend$lambda$0(textFieldSelectionState2);
                        }
                    }, this) == coroutine_suspended) {
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

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$0(TextFieldSelectionState textFieldSelectionState) {
                textFieldSelectionState.clearHandleDragging();
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldSelectionState.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$4", m1609f = "TextFieldSelectionState.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA5_2_6}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
        static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $isStartHandle;
            final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, boolean z, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
                this.$this_selectionHandleGestures = pointerInputScope;
                this.$isStartHandle = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass4(this.this$0, this.$this_selectionHandleGestures, this.$isStartHandle, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.this$0.detectSelectionHandleDragGestures(this.$this_selectionHandleGestures, this.$isStartHandle, this) == coroutine_suspended) {
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
        public static final Unit invokeSuspend$lambda$0(TextFieldSelectionState textFieldSelectionState, Throwable th) {
            textFieldSelectionState.clearHandleDragging();
            return Unit.INSTANCE;
        }
    }

    public final Object selectionHandleGestures(PointerInputScope pointerInputScope, boolean z, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C07732(pointerInputScope, z, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startToolbarAndHandlesVisibilityObserver(Continuation<? super Unit> continuation) {
        C07761 c07761;
        if (continuation instanceof C07761) {
            c07761 = (C07761) continuation;
            if ((c07761.label & Integer.MIN_VALUE) != 0) {
                c07761.label -= Integer.MIN_VALUE;
            } else {
                c07761 = new C07761(continuation);
            }
        }
        Object objCoroutineScope = c07761.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07761.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objCoroutineScope);
                C07772 c07772 = new C07772(null);
                c07761.label = 1;
                objCoroutineScope = CoroutineScopeKt.coroutineScope(c07772, c07761);
                if (objCoroutineScope == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objCoroutineScope);
            }
            return Unit.INSTANCE;
        } finally {
            setShowCursorHandle(false);
            if (getTextToolbarState() != TextToolbarState.None) {
                hideTextToolbar();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$2 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$2", m1609f = "TextFieldSelectionState.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C07772 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C07772(Continuation<? super C07772> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07772 c07772 = TextFieldSelectionState.this.new C07772(continuation);
            c07772.L$0 = obj;
            return c07772;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((C07772) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldSelectionState.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$2$1", m1609f = "TextFieldSelectionState.kt", m1610i = {}, m1611l = {538}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TextFieldSelectionState textFieldSelectionState, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
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
                    this.label = 1;
                    if (this.this$0.observeTextChanges(this) == coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(TextFieldSelectionState.this, null), 3, null);
                return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(TextFieldSelectionState.this, null), 3, null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldSelectionState.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$2$2", m1609f = "TextFieldSelectionState.kt", m1610i = {}, m1611l = {539}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(TextFieldSelectionState textFieldSelectionState, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.this$0.observeTextToolbarVisibility(this) == coroutine_suspended) {
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

    public final void updateTextToolbarState(TextToolbarState textToolbarState) {
        setTextToolbarState(textToolbarState);
    }

    public final void dispose() {
        hideTextToolbar();
        this.hapticFeedBack = null;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTouchMode$2 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTouchMode$2", m1609f = "TextFieldSelectionState.kt", m1610i = {0}, m1611l = {566}, m1612m = "invokeSuspend", m1613n = {"$this$awaitPointerEventScope"}, m1615s = {"L$0"}, m1616v = 1)
    static final class C07662 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C07662(Continuation<? super C07662> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07662 c07662 = TextFieldSelectionState.this.new C07662(continuation);
            c07662.L$0 = obj;
            return c07662;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C07662) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0032 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0030 -> B:12:0x0033). Please report as a decompilation issue!!! */
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
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r1 = r4.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.p004ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r5)
                goto L33
            L13:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1b:
                kotlin.ResultKt.throwOnFailure(r5)
                java.lang.Object r5 = r4.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.p004ui.input.pointer.AwaitPointerEventScope) r5
                r1 = r5
            L23:
                androidx.compose.ui.input.pointer.PointerEventPass r5 = androidx.compose.p004ui.input.pointer.PointerEventPass.Initial
                r3 = r4
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r4.L$0 = r1
                r4.label = r2
                java.lang.Object r5 = r1.awaitPointerEvent(r5, r3)
                if (r5 != r0) goto L33
                return r0
            L33:
                androidx.compose.ui.input.pointer.PointerEvent r5 = (androidx.compose.p004ui.input.pointer.PointerEvent) r5
                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r3 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.this
                boolean r5 = androidx.compose.foundation.text.selection.SelectionGestures_androidKt.isMouseOrTouchPad(r5)
                r5 = r5 ^ r2
                r3.setInTouchMode(r5)
                goto L23
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.C07662.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object detectTouchMode(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        Object objAwaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new C07662(null), continuation);
        return objAwaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitPointerEventScope : Unit.INSTANCE;
    }

    public final Object detectTextFieldTapGestures(PointerInputScope pointerInputScope, MutableInteractionSource mutableInteractionSource, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super Unit> continuation) {
        Object objDetectTextFieldTapGestures = TextFieldSelectionState_androidKt.detectTextFieldTapGestures(this, pointerInputScope, mutableInteractionSource, function0, function02, continuation);
        return objDetectTextFieldTapGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTextFieldTapGestures : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: placeCursorAtNearestOffset-k-4lQ0M, reason: not valid java name */
    public final boolean m3883placeCursorAtNearestOffsetk4lQ0M(long offset) {
        int iM10423getOffsetForPositionk4lQ0M;
        IndexTransformationType indexTransformationType;
        int iM10453getStartimpl;
        SelectionWedgeAffinity selectionWedgeAffinity;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null || (iM10423getOffsetForPositionk4lQ0M = layoutResult.m10423getOffsetForPositionk4lQ0M(offset)) == -1) {
            return false;
        }
        TransformedTextFieldState transformedTextFieldState = this.textFieldState;
        long jM3830mapFromTransformedjx7JFs = transformedTextFieldState.m3830mapFromTransformedjx7JFs(iM10423getOffsetForPositionk4lQ0M);
        long jM3833mapToTransformedGEjPoXI = transformedTextFieldState.m3833mapToTransformedGEjPoXI(jM3830mapFromTransformedjx7JFs);
        if (TextRange.m10447getCollapsedimpl(jM3830mapFromTransformedjx7JFs) && TextRange.m10447getCollapsedimpl(jM3833mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Untransformed;
        } else if (!TextRange.m10447getCollapsedimpl(jM3830mapFromTransformedjx7JFs) && !TextRange.m10447getCollapsedimpl(jM3833mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Replacement;
        } else if (TextRange.m10447getCollapsedimpl(jM3830mapFromTransformedjx7JFs) && !TextRange.m10447getCollapsedimpl(jM3833mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Insertion;
        } else {
            indexTransformationType = IndexTransformationType.Deletion;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[indexTransformationType.ordinal()];
        SelectionWedgeAffinity selectionWedgeAffinity2 = null;
        if (i == 1 || i == 2) {
            iM10453getStartimpl = TextRange.m10453getStartimpl(jM3830mapFromTransformedjx7JFs);
        } else if (i == 3) {
            if (MathUtilsKt.m3751findClosestRect9KIMszo(offset, layoutResult.getCursorRect(TextRange.m10453getStartimpl(jM3833mapToTransformedGEjPoXI)), layoutResult.getCursorRect(TextRange.m10448getEndimpl(jM3833mapToTransformedGEjPoXI))) < 0) {
                selectionWedgeAffinity = new SelectionWedgeAffinity(WedgeAffinity.Start);
            } else {
                selectionWedgeAffinity = new SelectionWedgeAffinity(WedgeAffinity.End);
            }
            selectionWedgeAffinity2 = selectionWedgeAffinity;
            iM10453getStartimpl = TextRange.m10453getStartimpl(jM3830mapFromTransformedjx7JFs);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            if (MathUtilsKt.m3751findClosestRect9KIMszo(offset, layoutResult.getCursorRect(TextRange.m10453getStartimpl(jM3833mapToTransformedGEjPoXI)), layoutResult.getCursorRect(TextRange.m10448getEndimpl(jM3833mapToTransformedGEjPoXI))) < 0) {
                iM10453getStartimpl = TextRange.m10453getStartimpl(jM3830mapFromTransformedjx7JFs);
            } else {
                iM10453getStartimpl = TextRange.m10448getEndimpl(jM3830mapFromTransformedjx7JFs);
            }
        }
        long jTextRange = TextRangeKt.TextRange(iM10453getStartimpl);
        if (TextRange.m10446equalsimpl0(jTextRange, this.textFieldState.getUntransformedText().getSelection()) && (selectionWedgeAffinity2 == null || Intrinsics.areEqual(selectionWedgeAffinity2, this.textFieldState.getSelectionWedgeAffinity()))) {
            return false;
        }
        this.textFieldState.m3836selectUntransformedCharsIn5zctL8(jTextRange);
        if (selectionWedgeAffinity2 != null) {
            this.textFieldState.setSelectionWedgeAffinity(selectionWedgeAffinity2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object detectCursorHandleDragGestures(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) throws Throwable {
        C07641 c07641;
        Ref.LongRef longRef;
        Throwable th;
        Ref.LongRef longRef2;
        if (continuation instanceof C07641) {
            c07641 = (C07641) continuation;
            if ((c07641.label & Integer.MIN_VALUE) != 0) {
                c07641.label -= Integer.MIN_VALUE;
            } else {
                c07641 = new C07641(continuation);
            }
        }
        C07641 c076412 = c07641;
        Object obj = c076412.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c076412.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            longRef2 = (Ref.LongRef) c076412.L$1;
            longRef = (Ref.LongRef) c076412.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                detectCursorHandleDragGestures$onDragStop(longRef, longRef2, this);
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                detectCursorHandleDragGestures$onDragStop(longRef, longRef2, this);
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        final Ref.LongRef longRef3 = new Ref.LongRef();
        longRef3.element = Offset.INSTANCE.m7918getUnspecifiedF1C5BW0();
        final Ref.LongRef longRef4 = new Ref.LongRef();
        longRef4.element = Offset.INSTANCE.m7918getUnspecifiedF1C5BW0();
        try {
            Function1 function1 = new Function1() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TextFieldSelectionState.detectCursorHandleDragGestures$lambda$0(longRef3, this, longRef4, (Offset) obj2);
                }
            };
            Function0 function0 = new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TextFieldSelectionState.detectCursorHandleDragGestures$lambda$1(longRef3, longRef4, this);
                }
            };
            Function0 function02 = new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TextFieldSelectionState.detectCursorHandleDragGestures$lambda$2(longRef3, longRef4, this);
                }
            };
            Function2 function2 = new Function2() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return TextFieldSelectionState.detectCursorHandleDragGestures$lambda$3(longRef4, this, longRef3, (PointerInputChange) obj2, (Offset) obj3);
                }
            };
            c076412.L$0 = longRef3;
            c076412.L$1 = longRef4;
            c076412.label = 1;
            if (DragGestureDetectorKt.detectDragGestures(pointerInputScope, function1, function0, function02, function2, c076412) == coroutine_suspended) {
                return coroutine_suspended;
            }
            longRef = longRef3;
            longRef2 = longRef4;
            detectCursorHandleDragGestures$onDragStop(longRef, longRef2, this);
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            longRef = longRef3;
            th = th3;
            longRef2 = longRef4;
            detectCursorHandleDragGestures$onDragStop(longRef, longRef2, this);
            throw th;
        }
    }

    private static final void detectCursorHandleDragGestures$onDragStop(Ref.LongRef longRef, Ref.LongRef longRef2, TextFieldSelectionState textFieldSelectionState) {
        if ((longRef.element & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) {
            longRef.element = Offset.INSTANCE.m7918getUnspecifiedF1C5BW0();
            longRef2.element = Offset.INSTANCE.m7918getUnspecifiedF1C5BW0();
            textFieldSelectionState.clearHandleDragging();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit detectCursorHandleDragGestures$lambda$0(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.LongRef longRef2, Offset offset) {
        longRef.element = SelectionHandlesKt.m4009getAdjustedCoordinatesk4lQ0M(textFieldSelectionState.getCursorRect().m7930getBottomCenterF1C5BW0());
        longRef2.element = Offset.INSTANCE.m7919getZeroF1C5BW0();
        textFieldSelectionState.setInTouchMode(true);
        textFieldSelectionState.markStartContentVisibleOffset();
        textFieldSelectionState.m3884updateHandleDraggingUv8p0NA(Handle.Cursor, longRef.element);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit detectCursorHandleDragGestures$lambda$1(Ref.LongRef longRef, Ref.LongRef longRef2, TextFieldSelectionState textFieldSelectionState) {
        detectCursorHandleDragGestures$onDragStop(longRef, longRef2, textFieldSelectionState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit detectCursorHandleDragGestures$lambda$2(Ref.LongRef longRef, Ref.LongRef longRef2, TextFieldSelectionState textFieldSelectionState) {
        detectCursorHandleDragGestures$onDragStop(longRef, longRef2, textFieldSelectionState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit detectCursorHandleDragGestures$lambda$3(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.LongRef longRef2, PointerInputChange pointerInputChange, Offset offset) {
        longRef.element = Offset.m7908plusMKHz9U(longRef.element, offset.m7913unboximpl());
        textFieldSelectionState.m3884updateHandleDraggingUv8p0NA(Handle.Cursor, Offset.m7908plusMKHz9U(longRef2.element, longRef.element));
        if (textFieldSelectionState.m3883placeCursorAtNearestOffsetk4lQ0M(textFieldSelectionState.m3882getHandleDragPositionF1C5BW0())) {
            pointerInputChange.consume();
            HapticFeedback hapticFeedback = textFieldSelectionState.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.mo8924performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m8941getTextHandleMove5zf0vsI());
            }
        }
        return Unit.INSTANCE;
    }

    public final Object textFieldSelectionGestures(PointerInputScope pointerInputScope, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        Object objTextFieldSelectionGestures = TextFieldSelectionState_androidKt.textFieldSelectionGestures(this, pointerInputScope, new TextFieldMouseSelectionObserver(function0), new TextFieldTextDragObserver(function0), continuation);
        return objTextFieldSelectionGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTextFieldSelectionGestures : Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010 \u001a\u00020\u0004H\u0016J\u0017\u0010!\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b%\u0010#R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, m1599d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldMouseSelectionObserver;", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "requestFocus", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function0;)V", "dragBeginOffsetInText", "", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "isDoubleOrTripleClickOnly", "", "onStart", "downPosition", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "clickCount", "onStart-9KIMszo", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;I)Z", "onDrag", "dragPosition", "onDrag-3MmeM6k", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "updateSelection", "Landroidx/compose/ui/text/TextRange;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "isStartOfSelection", "updateSelection-12glfjA", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Landroidx/compose/ui/text/TextLayoutResult;Z)J", "onDragDone", "onExtend", "onExtend-k-4lQ0M", "(J)Z", "onExtendDrag", "onExtendDrag-k-4lQ0M", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    private final class TextFieldMouseSelectionObserver implements MouseSelectionObserver {
        private int dragBeginOffsetInText = -1;
        private long dragBeginPosition = Offset.INSTANCE.m7918getUnspecifiedF1C5BW0();
        private boolean isDoubleOrTripleClickOnly = true;
        private final Function0<Unit> requestFocus;

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* JADX INFO: renamed from: onExtendDrag-k-4lQ0M, reason: not valid java name */
        public boolean mo3889onExtendDragk4lQ0M(long dragPosition) {
            return true;
        }

        public TextFieldMouseSelectionObserver(Function0<Unit> function0) {
            this.requestFocus = function0;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* JADX INFO: renamed from: onStart-9KIMszo, reason: not valid java name */
        public boolean mo3890onStart9KIMszo(long downPosition, SelectionAdjustment adjustment, int clickCount) {
            TextLayoutResult layoutResult = TextFieldSelectionState.this.getTextLayoutState().getLayoutResult();
            if (!TextFieldSelectionState.this.getEnabled() || layoutResult == null || TextFieldSelectionState.this.getTextFieldState().getVisualText().length() == 0) {
                return false;
            }
            this.isDoubleOrTripleClickOnly = clickCount >= 2;
            TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.Mouse);
            this.requestFocus.invoke();
            TextFieldSelectionState.this.previousRawDragOffset = -1;
            this.dragBeginOffsetInText = -1;
            this.dragBeginPosition = downPosition;
            this.dragBeginOffsetInText = TextRange.m10453getStartimpl(m3886updateSelection12glfjA(downPosition, adjustment, layoutResult, true));
            return true;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* JADX INFO: renamed from: onDrag-3MmeM6k, reason: not valid java name */
        public boolean mo3887onDrag3MmeM6k(long dragPosition, SelectionAdjustment adjustment) {
            TextLayoutResult layoutResult = TextFieldSelectionState.this.getTextLayoutState().getLayoutResult();
            if (!TextFieldSelectionState.this.getEnabled() || layoutResult == null || TextFieldSelectionState.this.getTextFieldState().getVisualText().length() == 0) {
                return false;
            }
            if (TextRange.m10446equalsimpl0(TextFieldSelectionState.this.getTextFieldState().getVisualText().getSelection(), m3886updateSelection12glfjA(dragPosition, adjustment, layoutResult, false))) {
                return true;
            }
            this.isDoubleOrTripleClickOnly = false;
            return true;
        }

        /* JADX INFO: renamed from: updateSelection-12glfjA, reason: not valid java name */
        private final long m3886updateSelection12glfjA(long dragPosition, SelectionAdjustment adjustment, TextLayoutResult layoutResult, boolean isStartOfSelection) {
            int length = layoutResult.getLayoutInput().getText().length();
            int iM3815getOffsetForPosition3MmeM6k = this.dragBeginOffsetInText;
            if (iM3815getOffsetForPosition3MmeM6k < 0 || iM3815getOffsetForPosition3MmeM6k > length) {
                iM3815getOffsetForPosition3MmeM6k = TextFieldSelectionState.this.getTextLayoutState().m3815getOffsetForPosition3MmeM6k(this.dragBeginPosition, false);
            }
            int iM3815getOffsetForPosition3MmeM6k2 = TextFieldSelectionState.this.getTextLayoutState().m3815getOffsetForPosition3MmeM6k(dragPosition, false);
            TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
            long jM3885updateSelectionQkiN0lo$foundation = textFieldSelectionState.m3885updateSelectionQkiN0lo$foundation(textFieldSelectionState.getTextFieldState().getVisualText(), iM3815getOffsetForPosition3MmeM6k, iM3815getOffsetForPosition3MmeM6k2, false, adjustment, false, isStartOfSelection, null);
            if (this.dragBeginOffsetInText == -1 && !TextRange.m10447getCollapsedimpl(jM3885updateSelectionQkiN0lo$foundation)) {
                this.dragBeginOffsetInText = TextRange.m10453getStartimpl(jM3885updateSelectionQkiN0lo$foundation);
            }
            if (TextRange.m10452getReversedimpl(jM3885updateSelectionQkiN0lo$foundation)) {
                jM3885updateSelectionQkiN0lo$foundation = TextFieldSelectionStateKt.m3894reverse5zctL8(jM3885updateSelectionQkiN0lo$foundation);
            }
            TextFieldSelectionState.this.getTextFieldState().m3835selectCharsIn5zctL8(jM3885updateSelectionQkiN0lo$foundation);
            TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
            return jM3885updateSelectionQkiN0lo$foundation;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        public void onDragDone() {
            TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.None);
            if (this.isDoubleOrTripleClickOnly) {
                TextFieldSelectionState.this.maybeSuggestSelectionRange();
            }
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* JADX INFO: renamed from: onExtend-k-4lQ0M, reason: not valid java name */
        public boolean mo3888onExtendk4lQ0M(long downPosition) {
            TextLayoutResult layoutResult = TextFieldSelectionState.this.getTextLayoutState().getLayoutResult();
            if (!TextFieldSelectionState.this.getEnabled() || layoutResult == null || TextFieldSelectionState.this.getTextFieldState().getVisualText().length() == 0) {
                return false;
            }
            this.isDoubleOrTripleClickOnly = false;
            this.requestFocus.invoke();
            m3886updateSelection12glfjA(downPosition, SelectionAdjustment.INSTANCE.getNone(), layoutResult, false);
            return true;
        }
    }

    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\u001f\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\nH\u0016¢\u0006\u0004\b\"\u0010\u0017R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m1599d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldTextDragObserver;", "Landroidx/compose/foundation/text/TextDragObserver;", "requestFocus", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function0;)V", "dragBeginOffsetInText", "", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "dragTotalDistance", "actingHandle", "Landroidx/compose/foundation/text/Handle;", "isLongPressSelectionOnly", "", "selectionAdjustmentMode", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "onDragStop", "onDown", "point", "onDown-k-4lQ0M", "(J)V", "onUp", "onStop", "onCancel", "onStart", "startPoint", "selectionAdjustment", "onStart-3MmeM6k", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;)V", "onDrag", "delta", "onDrag-k-4lQ0M", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    private final class TextFieldTextDragObserver implements TextDragObserver {
        private final Function0<Unit> requestFocus;
        private int dragBeginOffsetInText = -1;
        private long dragBeginPosition = Offset.INSTANCE.m7918getUnspecifiedF1C5BW0();
        private long dragTotalDistance = Offset.INSTANCE.m7919getZeroF1C5BW0();
        private Handle actingHandle = Handle.SelectionEnd;
        private boolean isLongPressSelectionOnly = true;
        private SelectionAdjustment selectionAdjustmentMode = SelectionAdjustment.INSTANCE.getNone();

        @Override // androidx.compose.foundation.text.TextDragObserver
        /* JADX INFO: renamed from: onDown-k-4lQ0M */
        public void mo3521onDownk4lQ0M(long point) {
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onUp() {
        }

        public TextFieldTextDragObserver(Function0<Unit> function0) {
            this.requestFocus = function0;
        }

        private final void onDragStop() {
            if ((this.dragBeginPosition & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                TextFieldSelectionState.this.clearHandleDragging();
                this.dragBeginOffsetInText = -1;
                this.dragBeginPosition = Offset.INSTANCE.m7918getUnspecifiedF1C5BW0();
                this.dragTotalDistance = Offset.INSTANCE.m7919getZeroF1C5BW0();
                TextFieldSelectionState.this.previousRawDragOffset = -1;
                this.selectionAdjustmentMode = SelectionAdjustment.INSTANCE.getNone();
                TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.None);
                this.requestFocus.invoke();
                if (this.isLongPressSelectionOnly) {
                    TextFieldSelectionState.this.maybeSuggestSelectionRange();
                }
            }
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onStop() {
            onDragStop();
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onCancel() {
            onDragStop();
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        /* JADX INFO: renamed from: onStart-3MmeM6k */
        public void mo3523onStart3MmeM6k(long startPoint, SelectionAdjustment selectionAdjustment) {
            if (TextFieldSelectionState.this.getEnabled()) {
                TextFieldSelectionState.this.m3884updateHandleDraggingUv8p0NA(this.actingHandle, startPoint);
                TextFieldSelectionState.this.setShowCursorHandle(false);
                TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.Touch);
                this.dragBeginPosition = startPoint;
                this.dragTotalDistance = Offset.INSTANCE.m7919getZeroF1C5BW0();
                TextFieldSelectionState.this.previousRawDragOffset = -1;
                this.isLongPressSelectionOnly = true;
                this.selectionAdjustmentMode = selectionAdjustment;
                if (TextFieldSelectionState.this.getTextLayoutState().getLayoutResult() == null) {
                    return;
                }
                if (!TextFieldSelectionState.this.getTextLayoutState().m3816isPositionOnTextk4lQ0M(startPoint)) {
                    int iM3812getOffsetForPosition3MmeM6k$default = TextLayoutState.m3812getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.getTextLayoutState(), startPoint, false, 2, null);
                    HapticFeedback hapticFeedBack = TextFieldSelectionState.this.getHapticFeedBack();
                    if (hapticFeedBack != null) {
                        hapticFeedBack.mo8924performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m8937getLongPress5zf0vsI());
                    }
                    TextFieldSelectionState.this.getTextFieldState().placeCursorBeforeCharAt(iM3812getOffsetForPosition3MmeM6k$default);
                    TextFieldSelectionState.this.setShowCursorHandle(true);
                    this.isLongPressSelectionOnly = false;
                    TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Cursor);
                    return;
                }
                if (TextFieldSelectionState.this.getTextFieldState().getVisualText().length() == 0) {
                    return;
                }
                int iM3812getOffsetForPosition3MmeM6k$default2 = TextLayoutState.m3812getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.getTextLayoutState(), startPoint, false, 2, null);
                long jM3881updateSelectionQkiN0lo$foundation$default = TextFieldSelectionState.m3881updateSelectionQkiN0lo$foundation$default(TextFieldSelectionState.this, new TextFieldCharSequence(TextFieldSelectionState.this.getTextFieldState().getVisualText(), TextRange.INSTANCE.m10458getZerod9O1mEE(), null, null, null, null, 60, null), iM3812getOffsetForPosition3MmeM6k$default2, iM3812getOffsetForPosition3MmeM6k$default2, false, this.selectionAdjustmentMode, false, false, HapticFeedbackType.m8925boximpl(HapticFeedbackType.INSTANCE.m8937getLongPress5zf0vsI()), 96, null);
                TextFieldSelectionState.this.getTextFieldState().m3835selectCharsIn5zctL8(jM3881updateSelectionQkiN0lo$foundation$default);
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
                this.dragBeginOffsetInText = TextRange.m10453getStartimpl(jM3881updateSelectionQkiN0lo$foundation$default);
            }
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        /* JADX INFO: renamed from: onDrag-k-4lQ0M */
        public void mo3522onDragk4lQ0M(long delta) {
            int iIntValue;
            int iM3815getOffsetForPosition3MmeM6k;
            SelectionAdjustment none;
            TextLayoutInput layoutInput;
            AnnotatedString text;
            Handle handle;
            if (!TextFieldSelectionState.this.getEnabled() || TextFieldSelectionState.this.getTextLayoutState().getLayoutResult() == null || TextFieldSelectionState.this.getTextFieldState().getVisualText().length() == 0) {
                return;
            }
            long jM7908plusMKHz9U = Offset.m7908plusMKHz9U(this.dragTotalDistance, delta);
            this.dragTotalDistance = jM7908plusMKHz9U;
            long jM7908plusMKHz9U2 = Offset.m7908plusMKHz9U(this.dragBeginPosition, jM7908plusMKHz9U);
            if (this.dragBeginOffsetInText < 0 && !TextFieldSelectionState.this.getTextLayoutState().m3816isPositionOnTextk4lQ0M(jM7908plusMKHz9U2)) {
                iIntValue = TextLayoutState.m3812getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.getTextLayoutState(), this.dragBeginPosition, false, 2, null);
                iM3815getOffsetForPosition3MmeM6k = TextLayoutState.m3812getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.getTextLayoutState(), jM7908plusMKHz9U2, false, 2, null);
                if (iIntValue == iM3815getOffsetForPosition3MmeM6k) {
                    none = SelectionAdjustment.INSTANCE.getNone();
                } else {
                    none = this.selectionAdjustmentMode;
                }
            } else {
                if (ComposeFoundationFlags.isConcurrentTextFieldSelectionFixEnabled) {
                    TextLayoutResult layoutResult = TextFieldSelectionState.this.getTextLayoutState().getLayoutResult();
                    int length = (layoutResult == null || (layoutInput = layoutResult.getLayoutInput()) == null || (text = layoutInput.getText()) == null) ? 0 : text.length();
                    Integer numValueOf = Integer.valueOf(this.dragBeginOffsetInText);
                    int iIntValue2 = numValueOf.intValue();
                    if (iIntValue2 >= 0 && iIntValue2 <= length) {
                        num = numValueOf;
                    }
                    iIntValue = num != null ? num.intValue() : TextFieldSelectionState.this.getTextLayoutState().m3815getOffsetForPosition3MmeM6k(this.dragBeginPosition, false);
                } else {
                    Integer numValueOf2 = Integer.valueOf(this.dragBeginOffsetInText);
                    num = numValueOf2.intValue() >= 0 ? numValueOf2 : null;
                    iIntValue = num != null ? num.intValue() : TextFieldSelectionState.this.getTextLayoutState().m3815getOffsetForPosition3MmeM6k(this.dragBeginPosition, false);
                }
                iM3815getOffsetForPosition3MmeM6k = TextFieldSelectionState.this.getTextLayoutState().m3815getOffsetForPosition3MmeM6k(jM7908plusMKHz9U2, false);
                if (this.dragBeginOffsetInText < 0 && iIntValue == iM3815getOffsetForPosition3MmeM6k) {
                    return;
                }
                none = this.selectionAdjustmentMode;
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
            }
            int i = iIntValue;
            int i2 = iM3815getOffsetForPosition3MmeM6k;
            SelectionAdjustment selectionAdjustment = none;
            long selection = TextFieldSelectionState.this.getTextFieldState().getVisualText().getSelection();
            TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
            long jM3881updateSelectionQkiN0lo$foundation$default = TextFieldSelectionState.m3881updateSelectionQkiN0lo$foundation$default(textFieldSelectionState, textFieldSelectionState.getTextFieldState().getVisualText(), i, i2, false, selectionAdjustment, false, false, HapticFeedbackType.m8925boximpl(HapticFeedbackType.INSTANCE.m8941getTextHandleMove5zf0vsI()), 64, null);
            if (this.dragBeginOffsetInText == -1 && !TextRange.m10447getCollapsedimpl(jM3881updateSelectionQkiN0lo$foundation$default)) {
                this.dragBeginOffsetInText = TextRange.m10453getStartimpl(jM3881updateSelectionQkiN0lo$foundation$default);
            }
            if (TextRange.m10452getReversedimpl(jM3881updateSelectionQkiN0lo$foundation$default)) {
                jM3881updateSelectionQkiN0lo$foundation$default = TextFieldSelectionStateKt.m3894reverse5zctL8(jM3881updateSelectionQkiN0lo$foundation$default);
            }
            if (!TextRange.m10446equalsimpl0(jM3881updateSelectionQkiN0lo$foundation$default, selection)) {
                if (TextRange.m10453getStartimpl(jM3881updateSelectionQkiN0lo$foundation$default) != TextRange.m10453getStartimpl(selection) && TextRange.m10448getEndimpl(jM3881updateSelectionQkiN0lo$foundation$default) == TextRange.m10448getEndimpl(selection)) {
                    handle = Handle.SelectionStart;
                } else if ((TextRange.m10453getStartimpl(jM3881updateSelectionQkiN0lo$foundation$default) == TextRange.m10453getStartimpl(selection) && TextRange.m10448getEndimpl(jM3881updateSelectionQkiN0lo$foundation$default) != TextRange.m10448getEndimpl(selection)) || (TextRange.m10453getStartimpl(jM3881updateSelectionQkiN0lo$foundation$default) + TextRange.m10448getEndimpl(jM3881updateSelectionQkiN0lo$foundation$default)) / 2.0f > (TextRange.m10453getStartimpl(selection) + TextRange.m10448getEndimpl(selection)) / 2.0f) {
                    handle = Handle.SelectionEnd;
                } else {
                    handle = Handle.SelectionStart;
                }
                this.actingHandle = handle;
                this.isLongPressSelectionOnly = false;
            }
            if (TextRange.m10447getCollapsedimpl(selection) || !TextRange.m10447getCollapsedimpl(jM3881updateSelectionQkiN0lo$foundation$default)) {
                TextFieldSelectionState.this.getTextFieldState().m3835selectCharsIn5zctL8(jM3881updateSelectionQkiN0lo$foundation$default);
            }
            TextFieldSelectionState.this.m3884updateHandleDraggingUv8p0NA(this.actingHandle, jM7908plusMKHz9U2);
        }
    }

    public final void maybeSuggestSelectionRange() {
        PlatformSelectionBehaviors platformSelectionBehaviors = this.platformSelectionBehaviors;
        if (platformSelectionBehaviors == null) {
            return;
        }
        CharSequence text = this.textFieldState.getVisualText().getText();
        long selection = this.textFieldState.getVisualText().getSelection();
        if (text.length() <= 0 || TextRange.m10447getCollapsedimpl(selection)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, CoroutineStart.UNDISPATCHED, new C07671(platformSelectionBehaviors, text, selection, this, null), 1, null);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$maybeSuggestSelectionRange$1 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$maybeSuggestSelectionRange$1", m1609f = "TextFieldSelectionState.kt", m1610i = {}, m1611l = {1120}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C07671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PlatformSelectionBehaviors $platformSelectionBehaviors;
        final /* synthetic */ long $selection;
        final /* synthetic */ CharSequence $text;
        int label;
        final /* synthetic */ TextFieldSelectionState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07671(PlatformSelectionBehaviors platformSelectionBehaviors, CharSequence charSequence, long j, TextFieldSelectionState textFieldSelectionState, Continuation<? super C07671> continuation) {
            super(2, continuation);
            this.$platformSelectionBehaviors = platformSelectionBehaviors;
            this.$text = charSequence;
            this.$selection = j;
            this.this$0 = textFieldSelectionState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07671(this.$platformSelectionBehaviors, this.$text, this.$selection, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = this.$platformSelectionBehaviors.mo3987suggestSelectionForLongPressOrDoubleClickpYaCww(this.$text, this.$selection, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            TextRange textRange = (TextRange) obj;
            if (!this.this$0.isPassword && textRange != null && Intrinsics.areEqual(this.this$0.getTextFieldState().getVisualText().getText(), this.$text) && TextRange.m10446equalsimpl0(this.this$0.getTextFieldState().getVisualText().getSelection(), this.$selection)) {
                if (!TextRange.m10446equalsimpl0(textRange.getPackedValue(), this.this$0.getTextFieldState().getVisualText().getSelection())) {
                    this.this$0.getTextFieldState().m3835selectCharsIn5zctL8(textRange.getPackedValue());
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object detectSelectionHandleDragGestures(PointerInputScope pointerInputScope, final boolean z, Continuation<? super Unit> continuation) throws Throwable {
        C07651 c07651;
        Handle handle;
        Ref.LongRef longRef;
        Ref.LongRef longRef2;
        Function1 function1;
        Function0 function0;
        Function0 function02;
        if (continuation instanceof C07651) {
            c07651 = (C07651) continuation;
            if ((c07651.label & Integer.MIN_VALUE) != 0) {
                c07651.label -= Integer.MIN_VALUE;
            } else {
                c07651 = new C07651(continuation);
            }
        }
        C07651 c076512 = c07651;
        Object obj = c076512.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c076512.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            handle = (Handle) c076512.L$2;
            longRef2 = (Ref.LongRef) c076512.L$1;
            longRef = (Ref.LongRef) c076512.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                if (getDraggingHandle() == handle) {
                    detectSelectionHandleDragGestures$onDragStop(longRef, this, longRef2);
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                th = th;
                if (getDraggingHandle() == handle) {
                    detectSelectionHandleDragGestures$onDragStop(longRef, this, longRef2);
                }
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        final Ref.LongRef longRef3 = new Ref.LongRef();
        longRef3.element = Offset.INSTANCE.m7918getUnspecifiedF1C5BW0();
        final Ref.LongRef longRef4 = new Ref.LongRef();
        longRef4.element = Offset.INSTANCE.m7919getZeroF1C5BW0();
        final Handle handle2 = z ? Handle.SelectionStart : Handle.SelectionEnd;
        try {
            try {
                function1 = new Function1() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSelectionState.detectSelectionHandleDragGestures$lambda$0(longRef3, this, z, handle2, longRef4, (Offset) obj2);
                    }
                };
                handle2 = handle2;
                longRef3 = longRef3;
                function0 = new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TextFieldSelectionState.detectSelectionHandleDragGestures$lambda$1(longRef3, this, longRef4);
                    }
                };
                function02 = new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TextFieldSelectionState.detectSelectionHandleDragGestures$lambda$2(longRef3, this, longRef4);
                    }
                };
            } catch (Throwable th2) {
                th = th2;
                handle2 = handle2;
                longRef3 = longRef3;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            Function2 function2 = new Function2() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return TextFieldSelectionState.detectSelectionHandleDragGestures$lambda$3(longRef4, this, handle2, longRef3, z, (PointerInputChange) obj2, (Offset) obj3);
                }
            };
            longRef4 = longRef4;
            c076512.L$0 = longRef3;
            c076512.L$1 = longRef4;
            c076512.L$2 = handle2;
            c076512.label = 1;
            if (DragGestureDetectorKt.detectDragGestures(pointerInputScope, function1, function0, function02, function2, c076512) == coroutine_suspended) {
                return coroutine_suspended;
            }
            handle = handle2;
            longRef = longRef3;
            longRef2 = longRef4;
            if (getDraggingHandle() == handle) {
            }
            return Unit.INSTANCE;
        } catch (Throwable th4) {
            th = th4;
            longRef4 = longRef4;
            handle = handle2;
            longRef = longRef3;
            longRef2 = longRef4;
            if (getDraggingHandle() == handle) {
            }
            throw th;
        }
    }

    private static final void detectSelectionHandleDragGestures$onDragStop(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.LongRef longRef2) {
        if ((longRef.element & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) {
            textFieldSelectionState.clearHandleDragging();
            longRef.element = Offset.INSTANCE.m7918getUnspecifiedF1C5BW0();
            longRef2.element = Offset.INSTANCE.m7919getZeroF1C5BW0();
            textFieldSelectionState.previousRawDragOffset = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit detectSelectionHandleDragGestures$lambda$0(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, boolean z, Handle handle, Ref.LongRef longRef2, Offset offset) {
        longRef.element = SelectionHandlesKt.m4009getAdjustedCoordinatesk4lQ0M(textFieldSelectionState.m3875getHandlePositiontuRUvjQ(z));
        textFieldSelectionState.m3884updateHandleDraggingUv8p0NA(handle, longRef.element);
        longRef2.element = Offset.INSTANCE.m7919getZeroF1C5BW0();
        textFieldSelectionState.previousRawDragOffset = -1;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit detectSelectionHandleDragGestures$lambda$1(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.LongRef longRef2) {
        detectSelectionHandleDragGestures$onDragStop(longRef, textFieldSelectionState, longRef2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit detectSelectionHandleDragGestures$lambda$2(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.LongRef longRef2) {
        detectSelectionHandleDragGestures$onDragStop(longRef, textFieldSelectionState, longRef2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit detectSelectionHandleDragGestures$lambda$3(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Handle handle, Ref.LongRef longRef2, boolean z, PointerInputChange pointerInputChange, Offset offset) {
        int iM10453getStartimpl;
        int iM10423getOffsetForPositionk4lQ0M;
        longRef.element = Offset.m7908plusMKHz9U(longRef.element, offset.m7913unboximpl());
        TextLayoutResult layoutResult = textFieldSelectionState.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Unit.INSTANCE;
        }
        textFieldSelectionState.m3884updateHandleDraggingUv8p0NA(handle, Offset.m7908plusMKHz9U(longRef2.element, longRef.element));
        if (z) {
            iM10453getStartimpl = layoutResult.m10423getOffsetForPositionk4lQ0M(textFieldSelectionState.m3882getHandleDragPositionF1C5BW0());
        } else {
            iM10453getStartimpl = TextRange.m10453getStartimpl(textFieldSelectionState.textFieldState.getVisualText().getSelection());
        }
        if (z) {
            iM10423getOffsetForPositionk4lQ0M = TextRange.m10448getEndimpl(textFieldSelectionState.textFieldState.getVisualText().getSelection());
        } else {
            iM10423getOffsetForPositionk4lQ0M = layoutResult.m10423getOffsetForPositionk4lQ0M(textFieldSelectionState.m3882getHandleDragPositionF1C5BW0());
        }
        int i = iM10423getOffsetForPositionk4lQ0M;
        long selection = textFieldSelectionState.textFieldState.getVisualText().getSelection();
        long jM3881updateSelectionQkiN0lo$foundation$default = m3881updateSelectionQkiN0lo$foundation$default(textFieldSelectionState, textFieldSelectionState.textFieldState.getVisualText(), iM10453getStartimpl, i, z, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate(), false, false, HapticFeedbackType.m8925boximpl(HapticFeedbackType.INSTANCE.m8941getTextHandleMove5zf0vsI()), 96, null);
        if (TextRange.m10447getCollapsedimpl(selection) || !TextRange.m10447getCollapsedimpl(jM3881updateSelectionQkiN0lo$foundation$default)) {
            textFieldSelectionState.textFieldState.m3835selectCharsIn5zctL8(jM3881updateSelectionQkiN0lo$foundation$default);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextChanges$3 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    static final /* synthetic */ class C07683 extends FunctionReferenceImpl implements Function2<TextFieldCharSequence, CharSequence, Boolean> {
        public static final C07683 INSTANCE = new C07683();

        C07683() {
            super(2, TextFieldCharSequence.class, "contentEquals", "contentEquals(Ljava/lang/CharSequence;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Boolean invoke(TextFieldCharSequence textFieldCharSequence, CharSequence charSequence) {
            return Boolean.valueOf(textFieldCharSequence.contentEquals(charSequence));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object observeTextChanges(Continuation<? super Unit> continuation) {
        Object objCollect = FlowKt.drop(FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TextFieldSelectionState.observeTextChanges$lambda$0(this.f$0);
            }
        }), C07683.INSTANCE), 1).collect(new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.observeTextChanges.4
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((TextFieldCharSequence) obj, (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(TextFieldCharSequence textFieldCharSequence, Continuation<? super Unit> continuation2) {
                TextFieldSelectionState.this.setShowCursorHandle(false);
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.None);
                return Unit.INSTANCE;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldCharSequence observeTextChanges$lambda$0(TextFieldSelectionState textFieldSelectionState) {
        return textFieldSelectionState.textFieldState.getVisualText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object observeTextToolbarVisibility(Continuation<? super Unit> continuation) {
        Flow flowSnapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.getDerivedVisibleContentBounds$foundation();
            }
        });
        if (ComposeFoundationFlags.isNewContextMenuEnabled) {
            flowSnapshotFlow = FlowKt.distinctUntilChangedBy(flowSnapshotFlow, new Function1() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(TextFieldSelectionState.observeTextToolbarVisibility$lambda$1$0((Rect) obj));
                }
            });
        }
        Object objCollect = flowSnapshotFlow.collect(new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.observeTextToolbarVisibility.4
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((Rect) obj, (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(Rect rect, Continuation<? super Unit> continuation2) {
                if (rect != null) {
                    Object objShowTextToolbar = TextFieldSelectionState.this.showTextToolbar(rect, continuation2);
                    return objShowTextToolbar == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objShowTextToolbar : Unit.INSTANCE;
                }
                TextFieldSelectionState.this.hideTextToolbar();
                return Unit.INSTANCE;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    public final Rect getDerivedVisibleContentBounds$foundation() {
        return (Rect) this.derivedVisibleContentBounds.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect derivedVisibleContentBounds_delegate$lambda$0(TextFieldSelectionState textFieldSelectionState) {
        LayoutCoordinates textLayoutCoordinates;
        boolean zM10447getCollapsedimpl = TextRange.m10447getCollapsedimpl(textFieldSelectionState.textFieldState.getVisualText().getSelection());
        if ((!(zM10447getCollapsedimpl && textFieldSelectionState.getTextToolbarState() == TextToolbarState.Cursor) && (zM10447getCollapsedimpl || textFieldSelectionState.getTextToolbarState() != TextToolbarState.Selection)) || textFieldSelectionState.getDraggingHandle() != null || !textFieldSelectionState.isInTouchMode() || (textLayoutCoordinates = textFieldSelectionState.getTextLayoutCoordinates()) == null) {
            return null;
        }
        Rect rectVisibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates);
        Rect rectM7943Recttz77jQw = RectKt.m7943Recttz77jQw(textLayoutCoordinates.mo9636localToRootMKHz9U(rectVisibleBounds.m7938getTopLeftF1C5BW0()), rectVisibleBounds.m7936getSizeNHjbRc());
        Rect contentRect = textFieldSelectionState.getContentRect();
        if (contentRect.overlaps(rectM7943Recttz77jQw)) {
            return contentRect.intersect(rectM7943Recttz77jQw);
        }
        return null;
    }

    private final Rect getContentRect() {
        LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
        if (textLayoutCoordinates != null) {
            TextFieldCharSequence visualText = this.textFieldState.getVisualText();
            if (TextRange.m10447getCollapsedimpl(visualText.getSelection())) {
                Rect cursorRect = getCursorRect();
                return RectKt.m7943Recttz77jQw(textLayoutCoordinates.mo9636localToRootMKHz9U(cursorRect.m7938getTopLeftF1C5BW0()), cursorRect.m7936getSizeNHjbRc());
            }
            long jMo9636localToRootMKHz9U = textLayoutCoordinates.mo9636localToRootMKHz9U(m3875getHandlePositiontuRUvjQ(true));
            long jMo9636localToRootMKHz9U2 = textLayoutCoordinates.mo9636localToRootMKHz9U(m3875getHandlePositiontuRUvjQ(false));
            TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
            if (layoutResult == null) {
                return Rect.INSTANCE.getZero();
            }
            float fIntBitsToFloat = Float.intBitsToFloat((int) (textLayoutCoordinates.mo9636localToRootMKHz9U(Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(layoutResult.getCursorRect(TextRange.m10453getStartimpl(visualText.getSelection())).getTop())) & 4294967295L))) & 4294967295L));
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (textLayoutCoordinates.mo9636localToRootMKHz9U(Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(layoutResult.getCursorRect(TextRange.m10448getEndimpl(visualText.getSelection())).getTop())) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32))) & 4294967295L));
            int i = (int) (jMo9636localToRootMKHz9U >> 32);
            int i2 = (int) (jMo9636localToRootMKHz9U2 >> 32);
            return new Rect(Math.min(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.min(fIntBitsToFloat, fIntBitsToFloat2), Math.max(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.max(Float.intBitsToFloat((int) (jMo9636localToRootMKHz9U & 4294967295L)), Float.intBitsToFloat((int) (jMo9636localToRootMKHz9U2 & 4294967295L))));
        }
        androidx.compose.foundation.internal.InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("textLayoutCoordinates should not be null.");
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
    
        if (((r0 == null || (r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r0)) == null) ? false : androidx.compose.foundation.text.selection.SelectionManagerKt.m4043containsInclusiveUv8p0NA(r0, r4)) != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final TextFieldHandleState getSelectionHandleState$foundation(boolean isStartHandle, boolean includePosition) {
        Rect rectVisibleBounds;
        Handle handle = isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextFieldHandleState.INSTANCE.getHidden();
        }
        long selection = this.textFieldState.getVisualText().getSelection();
        if (TextRange.m10447getCollapsedimpl(selection)) {
            return TextFieldHandleState.INSTANCE.getHidden();
        }
        long jM3875getHandlePositiontuRUvjQ = m3875getHandlePositiontuRUvjQ(isStartHandle);
        if (getDirectDragGestureInitiator() == InputType.None) {
            if (getDraggingHandle() != handle) {
                LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            }
            if (!this.textFieldState.getVisualText().shouldShowSelection()) {
                return TextFieldHandleState.INSTANCE.getHidden();
            }
            ResolvedTextDirection bidiRunDirection = layoutResult.getBidiRunDirection(isStartHandle ? TextRange.m10453getStartimpl(selection) : Math.max(TextRange.m10448getEndimpl(selection) - 1, 0));
            boolean zM10452getReversedimpl = TextRange.m10452getReversedimpl(selection);
            if (includePosition) {
                LayoutCoordinates textLayoutCoordinates2 = getTextLayoutCoordinates();
                if (textLayoutCoordinates2 != null && (rectVisibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates2)) != null) {
                    jM3875getHandlePositiontuRUvjQ = TextLayoutStateKt.m3819coerceIn3MmeM6k(jM3875getHandlePositiontuRUvjQ, rectVisibleBounds);
                }
            } else {
                jM3875getHandlePositiontuRUvjQ = Offset.INSTANCE.m7918getUnspecifiedF1C5BW0();
            }
            return new TextFieldHandleState(true, jM3875getHandlePositiontuRUvjQ, TextLayoutHelperKt.getLineHeight(layoutResult, isStartHandle ? TextRange.m10453getStartimpl(selection) : TextRange.m10448getEndimpl(selection)), bidiRunDirection, zM10452getReversedimpl, null);
        }
        return TextFieldHandleState.INSTANCE.getHidden();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getHandlePosition-tuRUvjQ, reason: not valid java name */
    public final long m3875getHandlePositiontuRUvjQ(boolean isStartHandle) {
        int iM10448getEndimpl;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Offset.INSTANCE.m7919getZeroF1C5BW0();
        }
        long selection = this.textFieldState.getVisualText().getSelection();
        if (isStartHandle) {
            iM10448getEndimpl = TextRange.m10453getStartimpl(selection);
        } else {
            iM10448getEndimpl = TextRange.m10448getEndimpl(selection);
        }
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(layoutResult, iM10448getEndimpl, isStartHandle, TextRange.m10452getReversedimpl(selection));
    }

    /* JADX INFO: renamed from: updateHandleDragging-Uv8p0NA, reason: not valid java name */
    public final void m3884updateHandleDraggingUv8p0NA(Handle handle, long position) {
        setDraggingHandle(handle);
        m3879setRawHandleDragPositionk4lQ0M(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markStartContentVisibleOffset() {
        m3880setStartTextLayoutPositionInWindowk4lQ0M(m3874getCurrentTextLayoutPositionInWindowF1C5BW0());
    }

    public final void clearHandleDragging() {
        setDraggingHandle(null);
        m3879setRawHandleDragPositionk4lQ0M(Offset.INSTANCE.m7918getUnspecifiedF1C5BW0());
        m3880setStartTextLayoutPositionInWindowk4lQ0M(Offset.INSTANCE.m7918getUnspecifiedF1C5BW0());
    }

    public final boolean isCutAllowed() {
        return (TextRange.m10447getCollapsedimpl(getTextFieldState().getVisualText().getSelection()) || !getEditable$foundation() || this.isPassword) ? false : true;
    }

    public final Object cut(Continuation<? super Unit> continuation) {
        Object clipEntry;
        AnnotatedString annotatedStringCutWithResult = cutWithResult();
        return (annotatedStringCutWithResult != null && (clipEntry = this.clipboard.setClipEntry(ClipboardUtils_androidKt.toClipEntry(annotatedStringCutWithResult), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? clipEntry : Unit.INSTANCE;
    }

    public final boolean isCopyAllowed() {
        return (TextRange.m10447getCollapsedimpl(getTextFieldState().getVisualText().getSelection()) || this.isPassword) ? false : true;
    }

    public static /* synthetic */ Object copy$default(TextFieldSelectionState textFieldSelectionState, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return textFieldSelectionState.copy(z, continuation);
    }

    public final Object copy(boolean z, Continuation<? super Unit> continuation) {
        Object clipEntry;
        AnnotatedString annotatedStringCopyWithResult$foundation = copyWithResult$foundation(z);
        return (annotatedStringCopyWithResult$foundation != null && (clipEntry = this.clipboard.setClipEntry(ClipboardUtils_androidKt.toClipEntry(annotatedStringCopyWithResult$foundation), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? clipEntry : Unit.INSTANCE;
    }

    public static /* synthetic */ AnnotatedString copyWithResult$foundation$default(TextFieldSelectionState textFieldSelectionState, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return textFieldSelectionState.copyWithResult$foundation(z);
    }

    public final Object updateClipboardEntry(Continuation<? super Unit> continuation) {
        Object objUpdate = this.clipboardPasteState.update(continuation);
        return objUpdate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdate : Unit.INSTANCE;
    }

    public final boolean isPasteAllowed() {
        return getEditable$foundation();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
    
        if (pasteAsPlainText(r0) == r1) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b8, code lost:
    
        if (pasteAsPlainText(r0) == r1) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object paste(Continuation<? super Unit> continuation) {
        C07711 c07711;
        ReceiveContentConfiguration receiveContentConfigurationInvoke;
        ClipEntry clipEntry;
        ClipEntry clipEntry2;
        String plainText;
        if (continuation instanceof C07711) {
            c07711 = (C07711) continuation;
            if ((c07711.label & Integer.MIN_VALUE) != 0) {
                c07711.label -= Integer.MIN_VALUE;
            } else {
                c07711 = new C07711(continuation);
            }
        }
        Object clipEntry3 = c07711.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07711.label;
        if (i == 0) {
            ResultKt.throwOnFailure(clipEntry3);
            Function0<? extends ReceiveContentConfiguration> function0 = this.receiveContentConfiguration;
            if (function0 == null || (receiveContentConfigurationInvoke = function0.invoke()) == null) {
                c07711.label = 1;
            } else {
                Clipboard clipboard = this.clipboard;
                c07711.L$0 = receiveContentConfigurationInvoke;
                c07711.label = 2;
                clipEntry3 = clipboard.getClipEntry(c07711);
                if (clipEntry3 != coroutine_suspended) {
                    clipEntry = (ClipEntry) clipEntry3;
                    if (clipEntry == null) {
                    }
                }
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(clipEntry3);
            return Unit.INSTANCE;
        }
        if (i != 2) {
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(clipEntry3);
            return Unit.INSTANCE;
        }
        receiveContentConfigurationInvoke = (ReceiveContentConfiguration) c07711.L$0;
        ResultKt.throwOnFailure(clipEntry3);
        clipEntry = (ClipEntry) clipEntry3;
        if (clipEntry == null) {
            TransferableContent transferableContentOnReceive = receiveContentConfigurationInvoke.getReceiveContentListener().onReceive(new TransferableContent(clipEntry, clipEntry.getClipMetadata(), TransferableContent.Source.INSTANCE.m2142getClipboardkB6V9T0(), null, 8, null));
            if (transferableContentOnReceive != null && (clipEntry2 = transferableContentOnReceive.getClipEntry()) != null && (plainText = TransferableContent_androidKt.readPlainText(clipEntry2)) != null) {
                TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, plainText, false, TextFieldEditUndoBehavior.NeverMerge, false, 10, null);
            }
            return Unit.INSTANCE;
        }
        c07711.L$0 = null;
        c07711.label = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        if (r8 == r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object pasteAsPlainText(Continuation<? super Unit> continuation) {
        C07721 c07721;
        if (continuation instanceof C07721) {
            c07721 = (C07721) continuation;
            if ((c07721.label & Integer.MIN_VALUE) != 0) {
                c07721.label -= Integer.MIN_VALUE;
            } else {
                c07721 = new C07721(continuation);
            }
        }
        Object clipEntry = c07721.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07721.label;
        if (i == 0) {
            ResultKt.throwOnFailure(clipEntry);
            Clipboard clipboard = this.clipboard;
            c07721.label = 1;
            clipEntry = clipboard.getClipEntry(c07721);
            if (clipEntry != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(clipEntry);
            String str = (String) clipEntry;
            if (str != null) {
                TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, str, false, TextFieldEditUndoBehavior.NeverMerge, false, 10, null);
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(clipEntry);
        ClipEntry clipEntry2 = (ClipEntry) clipEntry;
        if (clipEntry2 != null) {
            c07721.label = 2;
            clipEntry = ClipboardUtils_androidKt.readText(clipEntry2, c07721);
        }
        return Unit.INSTANCE;
    }

    public final boolean canShowSelectAllMenuItem() {
        return TextRange.m10449getLengthimpl(this.textFieldState.getVisualText().getSelection()) != this.textFieldState.getVisualText().length();
    }

    public final void selectAll() {
        this.textFieldState.selectAll();
    }

    public final boolean canShowAutofillMenuItem() {
        return getEditable$foundation() && TextRange.m10447getCollapsedimpl(this.textFieldState.getVisualText().getSelection());
    }

    public final void autofill() {
        Function0<Unit> function0 = this.requestAutofillAction;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showTextToolbar(Rect rect, Continuation<? super Unit> continuation) {
        if (ComposeFoundationFlags.isNewContextMenuEnabled) {
            this.toolbarRequester.show();
        } else {
            TextToolbarHandler textToolbarHandler = this.textToolbarHandler;
            if (textToolbarHandler != null) {
                Object objShowTextToolbar = textToolbarHandler.showTextToolbar(this, rect, continuation);
                return objShowTextToolbar == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objShowTextToolbar : Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    public final void deselect() {
        if (!TextRange.m10447getCollapsedimpl(this.textFieldState.getVisualText().getSelection())) {
            this.textFieldState.collapseSelectionToEnd();
        }
        setShowCursorHandle(false);
        updateTextToolbarState(TextToolbarState.None);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideTextToolbar() {
        if (ComposeFoundationFlags.isNewContextMenuEnabled) {
            this.toolbarRequester.hide();
            return;
        }
        TextToolbarHandler textToolbarHandler = this.textToolbarHandler;
        if (textToolbarHandler != null) {
            textToolbarHandler.hideTextToolbar();
        }
    }

    /* JADX INFO: renamed from: updateSelection-QkiN0lo$foundation$default, reason: not valid java name */
    public static /* synthetic */ long m3881updateSelectionQkiN0lo$foundation$default(TextFieldSelectionState textFieldSelectionState, TextFieldCharSequence textFieldCharSequence, int i, int i2, boolean z, SelectionAdjustment selectionAdjustment, boolean z2, boolean z3, HapticFeedbackType hapticFeedbackType, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            z2 = false;
        }
        if ((i3 & 64) != 0) {
            z3 = false;
        }
        return textFieldSelectionState.m3885updateSelectionQkiN0lo$foundation(textFieldCharSequence, i, i2, z, selectionAdjustment, z2, z3, hapticFeedbackType);
    }

    /* JADX INFO: renamed from: updateSelection-QkiN0lo$foundation, reason: not valid java name */
    public final long m3885updateSelectionQkiN0lo$foundation(TextFieldCharSequence textFieldCharSequence, int startOffset, int endOffset, boolean isStartHandle, SelectionAdjustment adjustment, boolean allowPreviousSelectionCollapsed, boolean isStartOfSelection, HapticFeedbackType hapticFeedbackType) {
        HapticFeedback hapticFeedback;
        TextRange textRangeM10441boximpl = TextRange.m10441boximpl(textFieldCharSequence.getSelection());
        long packedValue = textRangeM10441boximpl.getPackedValue();
        if (isStartOfSelection || (!allowPreviousSelectionCollapsed && TextRange.m10447getCollapsedimpl(packedValue))) {
            textRangeM10441boximpl = null;
        }
        long jM3878getTextFieldSelectionqeG_v_k = m3878getTextFieldSelectionqeG_v_k(startOffset, endOffset, textRangeM10441boximpl, isStartHandle, adjustment);
        if (hapticFeedbackType != null && ((TextRange.m10451getMinimpl(jM3878getTextFieldSelectionqeG_v_k) != TextRange.m10451getMinimpl(textFieldCharSequence.getSelection()) || TextRange.m10450getMaximpl(jM3878getTextFieldSelectionqeG_v_k) != TextRange.m10450getMaximpl(textFieldCharSequence.getSelection())) && (hapticFeedback = this.hapticFeedBack) != null)) {
            hapticFeedback.mo8924performHapticFeedbackCdsT49E(hapticFeedbackType.getValue());
        }
        return jM3878getTextFieldSelectionqeG_v_k;
    }

    /* JADX INFO: renamed from: getTextFieldSelection-qeG_v_k, reason: not valid java name */
    private final long m3878getTextFieldSelectionqeG_v_k(int rawStartOffset, int rawEndOffset, TextRange previousSelection, boolean isStartHandle, SelectionAdjustment adjustment) {
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextRange.INSTANCE.m10458getZerod9O1mEE();
        }
        if (previousSelection == null && Intrinsics.areEqual(adjustment, SelectionAdjustment.INSTANCE.getCharacter())) {
            return TextRangeKt.TextRange(rawStartOffset, rawEndOffset);
        }
        SelectionLayout selectionLayoutM4013getTextFieldSelectionLayoutRcvTLA = SelectionLayoutKt.m4013getTextFieldSelectionLayoutRcvTLA(layoutResult, rawStartOffset, rawEndOffset, this.previousRawDragOffset, previousSelection != null ? previousSelection.getPackedValue() : TextRange.INSTANCE.m10458getZerod9O1mEE(), previousSelection == null, isStartHandle);
        if (previousSelection != null && !selectionLayoutM4013getTextFieldSelectionLayoutRcvTLA.shouldRecomputeSelection(this.previousSelectionLayout)) {
            return previousSelection.getPackedValue();
        }
        long jM3999toTextRanged9O1mEE = adjustment.adjust(selectionLayoutM4013getTextFieldSelectionLayoutRcvTLA).m3999toTextRanged9O1mEE();
        this.previousSelectionLayout = selectionLayoutM4013getTextFieldSelectionLayoutRcvTLA;
        this.previousRawDragOffset = isStartHandle ? rawStartOffset : rawEndOffset;
        return jM3999toTextRanged9O1mEE;
    }

    public final boolean canShowCutMenuItem() {
        return !TextRange.m10447getCollapsedimpl(getTextFieldState().getVisualText().getSelection()) && getEditable$foundation() && !this.isPassword && ClipboardUtils_androidKt.isWriteSupported(this.clipboard);
    }

    public final AnnotatedString cutWithResult() {
        if (TextRange.m10447getCollapsedimpl(getTextFieldState().getVisualText().getSelection()) || !getEditable$foundation() || this.isPassword) {
            return null;
        }
        AnnotatedString annotatedString = new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(this.textFieldState.getVisualText()).toString(), null, 2, null);
        this.textFieldState.deleteSelectedText();
        return annotatedString;
    }

    public final boolean canShowCopyMenuItem() {
        return (TextRange.m10447getCollapsedimpl(getTextFieldState().getVisualText().getSelection()) || this.isPassword || !ClipboardUtils_androidKt.isWriteSupported(this.clipboard)) ? false : true;
    }

    public final AnnotatedString copyWithResult$foundation(boolean cancelSelection) {
        if (TextRange.m10447getCollapsedimpl(getTextFieldState().getVisualText().getSelection()) || this.isPassword) {
            return null;
        }
        AnnotatedString annotatedString = new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(this.textFieldState.getVisualText()).toString(), null, 2, null);
        if (cancelSelection) {
            this.textFieldState.collapseSelectionToMax();
        }
        return annotatedString;
    }

    public final boolean canShowPasteMenuItem() {
        if (getEditable$foundation() && ClipboardUtils_androidKt.isReadSupported(this.clipboard)) {
            if (this.clipboardPasteState.get_hasText()) {
                return true;
            }
            Function0<? extends ReceiveContentConfiguration> function0 = this.receiveContentConfiguration;
            if ((function0 != null ? function0.invoke() : null) != null && this.clipboardPasteState.get_hasClip()) {
                return true;
            }
        }
        return false;
    }

    public final void onPasteEvent$foundation(AnnotatedString value) {
        if (getEditable$foundation()) {
            TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, value.getText(), false, TextFieldEditUndoBehavior.NeverMerge, false, 10, null);
        }
    }
}
