package androidx.compose.foundation.text;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.handwriting.StylusHandwritingKt;
import androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifier;
import androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNodeKt;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter_androidKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors_androidKt;
import androidx.compose.foundation.text.selection.SelectedTextType;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.DrawModifierKt;
import androidx.compose.p004ui.focus.FocusManager;
import androidx.compose.p004ui.focus.FocusRequester;
import androidx.compose.p004ui.focus.FocusState;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.SolidColor;
import androidx.compose.p004ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.hapticfeedback.HapticFeedback;
import androidx.compose.p004ui.input.key.KeyEvent;
import androidx.compose.p004ui.input.key.KeyInputModifierKt;
import androidx.compose.p004ui.input.pointer.PointerInputEventHandler;
import androidx.compose.p004ui.input.pointer.PointerInputScope;
import androidx.compose.p004ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.Clipboard;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.platform.SoftwareKeyboardController;
import androidx.compose.p004ui.platform.TextToolbar;
import androidx.compose.p004ui.platform.WindowInfo;
import androidx.compose.p004ui.semantics.SemanticsModifierKt;
import androidx.compose.p004ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextRange;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.input.ImeOptions;
import androidx.compose.p004ui.text.input.KeyboardType;
import androidx.compose.p004ui.text.input.OffsetMapping;
import androidx.compose.p004ui.text.input.PasswordVisualTransformation;
import androidx.compose.p004ui.text.input.TextFieldValue;
import androidx.compose.p004ui.text.input.TextInputService;
import androidx.compose.p004ui.text.input.TextInputSession;
import androidx.compose.p004ui.text.input.TransformedText;
import androidx.compose.p004ui.text.input.VisualTransformation;
import androidx.compose.p004ui.text.style.ResolvedTextDirection;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aú\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001323\b\u0002\u0010\u001d\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0001¢\u0006\u0002\u0010%\u001a0\u0010&\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001fH\u0003¢\u0006\u0002\u0010*\u001a\u001c\u0010+\u001a\u00020\u0007*\u00020\u00072\u0006\u0010,\u001a\u00020-2\u0006\u0010'\u001a\u00020(H\u0002\u001a \u0010.\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0013H\u0000\u001a0\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u0002042\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00105\u001a\u000206H\u0002\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-H\u0002\u001a2\u00108\u001a\u00020\u0001*\u0002092\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\r2\u0006\u00105\u001a\u000206H\u0080@¢\u0006\u0002\u0010=\u001a\u001d\u0010>\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(2\u0006\u0010?\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010@\u001a\u0015\u0010A\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\u0010B\u001a$\u0010C\u001a\u00020\u0007*\u00020\u00072\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00105\u001a\u000206H\u0000\u001a \u0010D\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00105\u001a\u000206H\u0002\u001a\u001c\u0010E\u001a\u00020\u0007*\u00020\u00072\u0006\u0010F\u001a\u00020(2\u0006\u0010G\u001a\u00020HH\u0002¨\u0006I²\u0006\n\u0010J\u001a\u00020\u0013X\u008a\u0084\u0002"}, m1599d2 = {"CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "minLines", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "textScrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/text/TextFieldScrollerPosition;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", FirebaseAnalytics.Param.CONTENT, "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "previewKeyEventToDeselectOnBack", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "requestFocusAndShowKeyboardIfNeeded", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "startInputSession", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "endInputSession", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "defaultTextFieldDraw", "notifyFocusedRect", "addContextMenuComponents", "textFieldSelectionManager", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "foundation", "writeable"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class CoreTextFieldKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$23(TextFieldValue textFieldValue, Function1 function1, Modifier modifier, TextStyle textStyle, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, boolean z, int i, int i2, ImeOptions imeOptions, KeyboardActions keyboardActions, boolean z2, boolean z3, Function3 function3, TextFieldScrollerPosition textFieldScrollerPosition, int i3, int i4, int i5, Composer composer, int i6) {
        CoreTextField(textFieldValue, function1, modifier, textStyle, visualTransformation, function12, mutableInteractionSource, brush, z, i, i2, imeOptions, keyboardActions, z2, z3, function3, textFieldScrollerPosition, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextFieldRootBox$lambda$1(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, Function2 function2, int i, Composer composer, int i2) {
        CoreTextFieldRootBox(modifier, textFieldSelectionManager, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionToolbarAndHandles$lambda$1(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Composer composer, int i2) {
        SelectionToolbarAndHandles(textFieldSelectionManager, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextFieldCursorHandle$lambda$4(TextFieldSelectionManager textFieldSelectionManager, int i, Composer composer, int i2) {
        TextFieldCursorHandle(textFieldSelectionManager, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$0$0(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x07a8  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x07e3  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x081f  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0827  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x082f  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x083e  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x08c9  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x08cb  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x08e1  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x08e3  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x08f4  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0902  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x0946 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0957  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x098b  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0996  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x09bb  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x09bd  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x09c3  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x09c9  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x09d7  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x09df  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x0a01  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x0a04  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x0a48  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x0a73  */
    /* JADX WARN: Removed duplicated region for block: B:447:0x0ae0  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x0b53  */
    /* JADX WARN: Removed duplicated region for block: B:459:0x0b56  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x0b5f  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x0baa  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x0bc8  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x0bea  */
    /* JADX WARN: Removed duplicated region for block: B:470:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CoreTextField(final TextFieldValue textFieldValue, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, TextStyle textStyle, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function12, MutableInteractionSource mutableInteractionSource, Brush brush, boolean z, int i, int i2, ImeOptions imeOptions, KeyboardActions keyboardActions, boolean z2, boolean z3, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, TextFieldScrollerPosition textFieldScrollerPosition, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        TextStyle textStyle2;
        int i8;
        VisualTransformation none;
        int i9;
        Function1<? super TextLayoutResult, Unit> function13;
        int i10;
        MutableInteractionSource mutableInteractionSource2;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        Composer composer2;
        final int i27;
        final ImeOptions imeOptions2;
        KeyboardActions keyboardActions2;
        final boolean z4;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function32;
        final TextFieldScrollerPosition textFieldScrollerPosition2;
        final MutableInteractionSource mutableInteractionSource3;
        final Function1<? super TextLayoutResult, Unit> function14;
        final TextStyle textStyle3;
        final VisualTransformation visualTransformation2;
        final Brush brush2;
        final boolean z5;
        final int i28;
        final boolean z6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function1<? super TextLayoutResult, Unit> function15;
        MutableInteractionSource mutableInteractionSource4;
        SolidColor solidColor;
        ImeOptions imeOptions3;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> lambda$559628295$foundation;
        TextFieldScrollerPosition textFieldScrollerPosition3;
        boolean z7;
        boolean z8;
        int i29;
        final Function1<? super TextLayoutResult, Unit> function16;
        Modifier modifier3;
        int i30;
        boolean z9;
        VisualTransformation visualTransformation3;
        KeyboardActions keyboardActions3;
        ImeOptions imeOptions4;
        int i31;
        Brush brush3;
        MutableInteractionSource mutableInteractionSource5;
        Brush brush4;
        LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter;
        WindowInfo windowInfo;
        int i32;
        TextFieldScrollerPosition textFieldScrollerPosition4;
        TextFieldScrollerPosition textFieldScrollerPosition5;
        AnnotatedString annotatedString;
        TextStyle textStyle4;
        boolean z10;
        FontFamily.Resolver resolver;
        FocusManager focusManager;
        UndoManager undoManager;
        final TextInputService textInputService;
        boolean z11;
        boolean zChangedInstance;
        Object objRememberedValue;
        final OffsetMapping offsetMapping;
        boolean z12;
        boolean z13;
        TextInputService textInputService2;
        TextFieldValue textFieldValue2;
        ImeOptions imeOptions5;
        TextFieldSelectionManager textFieldSelectionManager;
        CoroutineScope coroutineScope;
        BringIntoViewRequester bringIntoViewRequester;
        ImeOptions imeOptions6;
        boolean z14;
        boolean z15;
        final TextInputService textInputService3;
        ImeOptions imeOptions7;
        CoreTextFieldKt$CoreTextField$5$1 coreTextFieldKt$CoreTextField$5$1;
        boolean zChangedInstance2;
        final WindowInfo windowInfo2;
        WindowInfo windowInfo3;
        boolean zChangedInstance3;
        Modifier modifier4;
        boolean zChangedInstance4;
        Object objRememberedValue2;
        final boolean z16;
        final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter2;
        boolean zChanged;
        Object objRememberedValue3;
        final Brush brushM3341resolveAutofillHighlightWkMShQ;
        boolean zChangedInstance5;
        Object objRememberedValue4;
        final boolean z17;
        Modifier.Companion companionTextFieldMagnifier;
        String str;
        Composer composerStartRestartGroup = composer.startRestartGroup(31062401);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CoreTextField)N(value,onValueChange,modifier,textStyle,visualTransformation,onTextLayout,interactionSource,cursorBrush,softWrap,maxLines,minLines,imeOptions,keyboardActions,enabled,readOnly,decorationBox,textScrollerPosition)209@11803L29,210@11873L58,211@11977L72,216@12107L7,217@12168L7,218@12236L7,219@12301L7,220@12346L7,221@12415L7,242@13257L277,254@13839L21,256@13885L453,285@14738L26,288@14831L24,289@14889L37,291@14946L51,297@15235L7,299@15330L7,300@15387L7,310@15761L206,323@16184L1514,358@17805L42,359@17873L971,359@17852L992,385@18889L196,398@19232L1606,452@21467L48,452@21441L74,454@21550L503,454@21521L532,486@22727L987,505@23831L7,506@23888L7,510@24026L327,519@24382L35,547@25644L5409,547@25591L5462:CoreTextField.kt#423gt5");
        if ((i3 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(textFieldValue) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i33 = i5 & 4;
        if (i33 != 0) {
            i6 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i7 = i5 & 8;
            if (i7 == 0) {
                i6 |= 3072;
            } else {
                if ((i3 & 3072) == 0) {
                    textStyle2 = textStyle;
                    i6 |= composerStartRestartGroup.changed(textStyle2) ? 2048 : 1024;
                }
                i8 = i5 & 16;
                if (i8 != 0) {
                    i6 |= 24576;
                } else {
                    if ((i3 & 24576) == 0) {
                        none = visualTransformation;
                        i6 |= composerStartRestartGroup.changed(none) ? 16384 : 8192;
                    }
                    i9 = i5 & 32;
                    if (i9 == 0) {
                        i6 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                        function13 = function12;
                    } else {
                        function13 = function12;
                        if ((i3 & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                            i6 |= composerStartRestartGroup.changedInstance(function13) ? 131072 : 65536;
                        }
                    }
                    i10 = i5 & 64;
                    if (i10 == 0) {
                        i6 |= 1572864;
                        mutableInteractionSource2 = mutableInteractionSource;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if ((i3 & 1572864) == 0) {
                            i6 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                        }
                    }
                    i11 = i5 & 128;
                    if (i11 == 0) {
                        i6 |= 12582912;
                    } else if ((i3 & 12582912) == 0) {
                        i6 |= composerStartRestartGroup.changed(brush) ? 8388608 : 4194304;
                    }
                    i12 = i5 & 256;
                    if (i12 == 0) {
                        i6 |= 100663296;
                    } else {
                        if ((i3 & 100663296) == 0) {
                            i13 = i12;
                            i6 |= composerStartRestartGroup.changed(z) ? 67108864 : 33554432;
                        }
                        i14 = i5 & 512;
                        if (i14 == 0) {
                            if ((i3 & 805306368) == 0) {
                                i15 = i14;
                                i6 |= composerStartRestartGroup.changed(i) ? 536870912 : 268435456;
                            }
                            i16 = i5 & 1024;
                            if (i16 == 0) {
                                i18 = i4 | 6;
                                i17 = i16;
                            } else if ((i4 & 6) == 0) {
                                i17 = i16;
                                i18 = i4 | (composerStartRestartGroup.changed(i2) ? 4 : 2);
                            } else {
                                i17 = i16;
                                i18 = i4;
                            }
                            if ((i4 & 48) == 0) {
                                i18 |= ((i5 & 2048) == 0 && composerStartRestartGroup.changed(imeOptions)) ? 32 : 16;
                            }
                            int i34 = i18;
                            i19 = i5 & 4096;
                            if (i19 == 0) {
                                i20 = i34 | RendererCapabilities.DECODER_SUPPORT_MASK;
                            } else if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                i20 = i34 | (composerStartRestartGroup.changed(keyboardActions) ? 256 : 128);
                            } else {
                                i20 = i34;
                            }
                            i21 = i5 & 8192;
                            if (i21 == 0) {
                                i22 = i20 | 3072;
                            } else {
                                int i35 = i20;
                                if ((i4 & 3072) == 0) {
                                    i35 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                                }
                                i22 = i35;
                            }
                            i23 = i5 & 16384;
                            if (i23 == 0) {
                                i24 = i22 | 24576;
                            } else {
                                int i36 = i22;
                                if ((i4 & 24576) == 0) {
                                    i24 = i36 | (composerStartRestartGroup.changed(z3) ? 16384 : 8192);
                                } else {
                                    i24 = i36;
                                }
                            }
                            i25 = i5 & 32768;
                            if (i25 == 0) {
                                i24 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                            } else if ((i4 & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                                i24 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
                            }
                            i26 = i5 & 65536;
                            if (i26 == 0) {
                                i24 |= 1572864;
                            } else if ((i4 & 1572864) == 0) {
                                i24 |= composerStartRestartGroup.changed(textFieldScrollerPosition) ? 1048576 : 524288;
                            }
                            if (!composerStartRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i24 & 599187) != 599186, i6 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "194@11128L2");
                                if ((i3 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i5 & 2048) != 0) {
                                        i24 &= -113;
                                    }
                                    z9 = z;
                                    i31 = i;
                                    imeOptions4 = imeOptions;
                                    z7 = z2;
                                    z8 = z3;
                                    lambda$559628295$foundation = function3;
                                    textFieldScrollerPosition3 = textFieldScrollerPosition;
                                    mutableInteractionSource5 = mutableInteractionSource2;
                                    function16 = function13;
                                    modifier3 = modifier2;
                                    visualTransformation3 = none;
                                    i29 = i24;
                                    brush3 = brush;
                                    i30 = i2;
                                    keyboardActions3 = keyboardActions;
                                } else {
                                    if (i33 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i7 != 0) {
                                        textStyle2 = TextStyle.INSTANCE.getDefault();
                                    }
                                    if (i8 != 0) {
                                        none = VisualTransformation.INSTANCE.getNone();
                                    }
                                    if (i9 != 0) {
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213794269, "CC(remember):CoreTextField.kt#9igjgp");
                                        Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue5 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda11
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj) {
                                                    return CoreTextFieldKt.CoreTextField$lambda$0$0((TextLayoutResult) obj);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                        }
                                        function15 = (Function1) objRememberedValue5;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    } else {
                                        function15 = function13;
                                    }
                                    if (i10 != 0) {
                                        mutableInteractionSource2 = null;
                                    }
                                    if (i11 != 0) {
                                        mutableInteractionSource4 = mutableInteractionSource2;
                                        solidColor = new SolidColor(Color.INSTANCE.m8184getUnspecified0d7_KjU(), null);
                                    } else {
                                        mutableInteractionSource4 = mutableInteractionSource2;
                                        solidColor = brush;
                                    }
                                    boolean z18 = i13 != 0 ? true : z;
                                    int i37 = i15 != 0 ? Integer.MAX_VALUE : i;
                                    int i38 = i17 != 0 ? 1 : i2;
                                    if ((i5 & 2048) != 0) {
                                        imeOptions3 = ImeOptions.INSTANCE.getDefault();
                                        i24 &= -113;
                                    } else {
                                        imeOptions3 = imeOptions;
                                    }
                                    KeyboardActions keyboardActions4 = i19 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                    boolean z19 = i21 != 0 ? true : z2;
                                    boolean z20 = i23 != 0 ? false : z3;
                                    lambda$559628295$foundation = i25 != 0 ? ComposableSingletons$CoreTextFieldKt.INSTANCE.getLambda$559628295$foundation() : function3;
                                    textFieldScrollerPosition3 = i26 != 0 ? null : textFieldScrollerPosition;
                                    z7 = z19;
                                    z8 = z20;
                                    i29 = i24;
                                    function16 = function15;
                                    modifier3 = modifier2;
                                    i30 = i38;
                                    z9 = z18;
                                    visualTransformation3 = none;
                                    keyboardActions3 = keyboardActions4;
                                    imeOptions4 = imeOptions3;
                                    i31 = i37;
                                    brush3 = solidColor;
                                    mutableInteractionSource5 = mutableInteractionSource4;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    brush4 = brush3;
                                    ComposerKt.traceEventStart(31062401, i6, i29, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:208)");
                                } else {
                                    brush4 = brush3;
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213772642, "CC(remember):CoreTextField.kt#9igjgp");
                                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue6 = new FocusRequester();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                }
                                FocusRequester focusRequester = (FocusRequester) objRememberedValue6;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213770373, "CC(remember):CoreTextField.kt#9igjgp");
                                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                                int i39 = i6;
                                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue7 = LegacyPlatformTextInputServiceAdapter_androidKt.createLegacyPlatformTextInputServiceAdapter();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                                }
                                LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter3 = (LegacyPlatformTextInputServiceAdapter) objRememberedValue7;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213767031, "CC(remember):CoreTextField.kt#9igjgp");
                                Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                boolean z21 = z9;
                                if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue8 = new TextInputService(legacyPlatformTextInputServiceAdapter3);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                                }
                                TextInputService textInputService4 = (TextInputService) objRememberedValue8;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                TextStyle textStyle5 = textStyle2;
                                final int i40 = i30;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume = composerStartRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                final Density density = (Density) objConsume;
                                ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composerStartRestartGroup.consume(localFontFamilyResolver);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                FontFamily.Resolver resolver2 = (FontFamily.Resolver) objConsume2;
                                ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume3 = composerStartRestartGroup.consume(localTextSelectionColors);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long backgroundColor = ((TextSelectionColors) objConsume3).getBackgroundColor();
                                ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume4 = composerStartRestartGroup.consume(localFocusManager);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                FocusManager focusManager2 = (FocusManager) objConsume4;
                                ProvidableCompositionLocal<WindowInfo> localWindowInfo = CompositionLocalsKt.getLocalWindowInfo();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume5 = composerStartRestartGroup.consume(localWindowInfo);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                WindowInfo windowInfo4 = (WindowInfo) objConsume5;
                                keyboardActions2 = keyboardActions3;
                                ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume6 = composerStartRestartGroup.consume(localSoftwareKeyboardController);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) objConsume6;
                                final Orientation orientation = (i31 == 1 && !z21 && imeOptions4.getSingleLine()) ? Orientation.Horizontal : Orientation.Vertical;
                                Modifier modifier5 = modifier3;
                                if (textFieldScrollerPosition3 != null) {
                                    legacyPlatformTextInputServiceAdapter = legacyPlatformTextInputServiceAdapter3;
                                    windowInfo = windowInfo4;
                                    i32 = i31;
                                    composerStartRestartGroup.startReplaceGroup(-213745742);
                                    composerStartRestartGroup.endReplaceGroup();
                                    textFieldScrollerPosition4 = textFieldScrollerPosition3;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-213744626);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "228@12746L70,228@12675L141");
                                    Object[] objArr = {orientation};
                                    legacyPlatformTextInputServiceAdapter = legacyPlatformTextInputServiceAdapter3;
                                    Saver<TextFieldScrollerPosition, Object> saver = TextFieldScrollerPosition.INSTANCE.getSaver();
                                    i32 = i31;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213742425, "CC(remember):CoreTextField.kt#9igjgp");
                                    boolean zChanged2 = composerStartRestartGroup.changed(orientation.ordinal());
                                    Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged2) {
                                        windowInfo = windowInfo4;
                                    } else {
                                        windowInfo = windowInfo4;
                                        if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        textFieldScrollerPosition4 = (TextFieldScrollerPosition) RememberSaveableKt.m7531rememberSaveable(objArr, (Saver) saver, (Function0) objRememberedValue9, composerStartRestartGroup, 0);
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                    objRememberedValue9 = new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda18
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return CoreTextFieldKt.CoreTextField$lambda$4$0(orientation);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    textFieldScrollerPosition4 = (TextFieldScrollerPosition) RememberSaveableKt.m7531rememberSaveable(objArr, (Saver) saver, (Function0) objRememberedValue9, composerStartRestartGroup, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                                if (textFieldScrollerPosition4.getOrientation() != orientation) {
                                    if (orientation == Orientation.Vertical) {
                                        str = "only single-line, non-wrap text fields can scroll horizontally";
                                    } else {
                                        str = "single-line, non-wrap text fields can only scroll horizontally";
                                    }
                                    throw new IllegalArgumentException("Mismatching scroller orientation; ".concat(str));
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213725866, "CC(remember):CoreTextField.kt#9igjgp");
                                int i41 = i39 & 14;
                                boolean z22 = (i41 == 4) | ((i39 & 57344) == 16384);
                                Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                                if (z22 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                    TransformedText transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation3, textFieldValue.getAnnotatedString());
                                    TextRange composition = textFieldValue.getComposition();
                                    if (composition != null) {
                                        textFieldScrollerPosition5 = textFieldScrollerPosition4;
                                        TransformedText transformedTextM3529applyCompositionDecoration72CqOWE = TextFieldDelegate.INSTANCE.m3529applyCompositionDecoration72CqOWE(composition.getPackedValue(), transformedTextFilterWithValidation);
                                        if (transformedTextM3529applyCompositionDecoration72CqOWE != null) {
                                            objRememberedValue10 = transformedTextM3529applyCompositionDecoration72CqOWE;
                                        }
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                                    } else {
                                        textFieldScrollerPosition5 = textFieldScrollerPosition4;
                                    }
                                    objRememberedValue10 = transformedTextFilterWithValidation;
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                                } else {
                                    textFieldScrollerPosition5 = textFieldScrollerPosition4;
                                }
                                TransformedText transformedText = (TransformedText) objRememberedValue10;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                AnnotatedString text = transformedText.getText();
                                OffsetMapping offsetMapping2 = transformedText.getOffsetMapping();
                                RecomposeScope currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213705594, "CC(remember):CoreTextField.kt#9igjgp");
                                boolean zChanged3 = composerStartRestartGroup.changed(softwareKeyboardController);
                                Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                                if (zChanged3 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                    annotatedString = text;
                                    textStyle4 = textStyle5;
                                    z10 = z21;
                                    resolver = resolver2;
                                    objRememberedValue11 = new LegacyTextFieldState(new TextDelegate(text, textStyle5, 0, 0, z21, 0, density, resolver2, null, 300, null), currentRecomposeScope, softwareKeyboardController);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                                } else {
                                    annotatedString = text;
                                    textStyle4 = textStyle5;
                                    z10 = z21;
                                    resolver = resolver2;
                                }
                                final LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) objRememberedValue11;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                legacyTextFieldState.m3493updatefnh65Uc(textFieldValue.getAnnotatedString(), annotatedString, textStyle4, z10, density, resolver, function1, keyboardActions2, focusManager2, backgroundColor);
                                final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function33 = lambda$559628295$foundation;
                                legacyTextFieldState.getProcessor().reset(textFieldValue, legacyTextFieldState.getInputSession());
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213678725, "CC(remember):CoreTextField.kt#9igjgp");
                                Object objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                    focusManager = focusManager2;
                                    objRememberedValue12 = new UndoManager(0, 1, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                                } else {
                                    focusManager = focusManager2;
                                }
                                UndoManager undoManager2 = (UndoManager) objRememberedValue12;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                UndoManager.snapshotIfNeeded$default(undoManager2, textFieldValue, 0L, 2, null);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                                Object objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue13 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                                }
                                final CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue13;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213673882, "CC(remember):CoreTextField.kt#9igjgp");
                                Object objRememberedValue14 = composerStartRestartGroup.rememberedValue();
                                MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                                if (objRememberedValue14 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue14 = BringIntoViewRequesterKt.BringIntoViewRequester();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue14);
                                }
                                final BringIntoViewRequester bringIntoViewRequester2 = (BringIntoViewRequester) objRememberedValue14;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213672044, "CC(remember):CoreTextField.kt#9igjgp");
                                Object objRememberedValue15 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue15 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue15 = new TextFieldSelectionManager(undoManager2);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue15);
                                }
                                final TextFieldSelectionManager textFieldSelectionManager2 = (TextFieldSelectionManager) objRememberedValue15;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textFieldSelectionManager2.setOffsetMapping$foundation(offsetMapping2);
                                textFieldSelectionManager2.setVisualTransformation$foundation(visualTransformation3);
                                textFieldSelectionManager2.setOnValueChange$foundation(legacyTextFieldState.getOnValueChange());
                                textFieldSelectionManager2.setState$foundation(legacyTextFieldState);
                                textFieldSelectionManager2.setValue$foundation(textFieldValue);
                                ProvidableCompositionLocal<Clipboard> localClipboard = CompositionLocalsKt.getLocalClipboard();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume7 = composerStartRestartGroup.consume(localClipboard);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textFieldSelectionManager2.setClipboard$foundation((Clipboard) objConsume7);
                                textFieldSelectionManager2.setCoroutineScope$foundation(coroutineScope2);
                                ProvidableCompositionLocal<TextToolbar> localTextToolbar = CompositionLocalsKt.getLocalTextToolbar();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume8 = composerStartRestartGroup.consume(localTextToolbar);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textFieldSelectionManager2.setTextToolbar((TextToolbar) objConsume8);
                                ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume9 = composerStartRestartGroup.consume(localHapticFeedback);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                textFieldSelectionManager2.setHapticFeedBack((HapticFeedback) objConsume9);
                                textFieldSelectionManager2.setFocusRequester(focusRequester);
                                textFieldSelectionManager2.setEditable(!z8);
                                final boolean z23 = z7;
                                textFieldSelectionManager2.setEnabled(z23);
                                if (ComposeFoundationFlags.isSmartSelectionEnabled) {
                                    composerStartRestartGroup.startReplaceGroup(1966756105);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "307@15662L87");
                                    undoManager = undoManager2;
                                    textFieldSelectionManager2.setPlatformSelectionBehaviors$foundation(PlatformSelectionBehaviors_androidKt.rememberPlatformSelectionBehaviors(SelectedTextType.EditableText, textStyle4.getLocaleList(), composerStartRestartGroup, 6));
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    undoManager = undoManager2;
                                    composerStartRestartGroup.startReplaceGroup(1966902177);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                                legacyTextFieldState.getHasFocus();
                                new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda19
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CoreTextFieldKt.CoreTextField$lambda$10(textFieldSelectionManager2, (AnnotatedString) obj);
                                    }
                                };
                                new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda20
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CoreTextFieldKt.CoreTextField$lambda$11(textFieldSelectionManager2);
                                    }
                                };
                                new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda21
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return textFieldSelectionManager2.cutWithResult$foundation();
                                    }
                                };
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1264411026, "CC(rememberClipboardEventsHandler)N(onPaste,onCopy,onCut,isEnabled):ClipboardEventsHandler.jvmAndAndroid.kt#423gt5");
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                Modifier.Companion companion = Modifier.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213630965, "CC(remember):CoreTextField.kt#9igjgp");
                                int i42 = i29 & 7168;
                                int i43 = i29;
                                boolean zChangedInstance6 = (i42 == 2048) | composerStartRestartGroup.changedInstance(legacyTextFieldState) | ((i43 & 57344) == 16384) | composerStartRestartGroup.changedInstance(textInputService4) | (i41 == 4);
                                int i44 = (i43 & 112) ^ 48;
                                if (i44 <= 32 || !composerStartRestartGroup.changed(imeOptions4)) {
                                    textInputService = textInputService4;
                                    if ((i43 & 48) != 32) {
                                        z11 = false;
                                    }
                                    zChangedInstance = zChangedInstance6 | z11 | composerStartRestartGroup.changedInstance(offsetMapping2) | composerStartRestartGroup.changedInstance(coroutineScope2) | composerStartRestartGroup.changedInstance(bringIntoViewRequester2) | composerStartRestartGroup.changedInstance(textFieldSelectionManager2);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        offsetMapping = offsetMapping2;
                                        final ImeOptions imeOptions8 = imeOptions4;
                                        final boolean z24 = z8;
                                        objRememberedValue = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return CoreTextFieldKt.CoreTextField$lambda$13$0(legacyTextFieldState, z23, z24, textInputService, textFieldValue, imeOptions8, offsetMapping, textFieldSelectionManager2, coroutineScope2, bringIntoViewRequester2, (FocusState) obj);
                                            }
                                        };
                                        z12 = z23;
                                        z13 = z24;
                                        textInputService2 = textInputService;
                                        textFieldValue2 = textFieldValue;
                                        imeOptions5 = imeOptions8;
                                        textFieldSelectionManager = textFieldSelectionManager2;
                                        coroutineScope = coroutineScope2;
                                        bringIntoViewRequester = bringIntoViewRequester2;
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    } else {
                                        coroutineScope = coroutineScope2;
                                        offsetMapping = offsetMapping2;
                                        imeOptions5 = imeOptions4;
                                        z13 = z8;
                                        z12 = z23;
                                        bringIntoViewRequester = bringIntoViewRequester2;
                                        textFieldSelectionManager = textFieldSelectionManager2;
                                        textFieldValue2 = textFieldValue;
                                        textInputService2 = textInputService;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    Modifier modifierTextFieldFocusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(companion, z12, focusRequester, mutableInteractionSource6, (Function1) objRememberedValue);
                                    State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z12 || z13) ? false : true), composerStartRestartGroup, 0);
                                    Unit unit = Unit.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213577460, "CC(remember):CoreTextField.kt#9igjgp");
                                    boolean zChanged4 = composerStartRestartGroup.changed(stateRememberUpdatedState) | composerStartRestartGroup.changedInstance(legacyTextFieldState) | composerStartRestartGroup.changedInstance(textInputService2) | composerStartRestartGroup.changedInstance(textFieldSelectionManager);
                                    TextInputService textInputService5 = textInputService2;
                                    if (i44 > 32 || !composerStartRestartGroup.changed(imeOptions5)) {
                                        imeOptions6 = imeOptions5;
                                        if ((i43 & 48) != 32) {
                                            z14 = false;
                                        }
                                        z15 = z14 | zChanged4;
                                        Object objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                                        if (z15 || objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                                            ImeOptions imeOptions9 = imeOptions6;
                                            textInputService3 = textInputService5;
                                            imeOptions7 = imeOptions9;
                                            coreTextFieldKt$CoreTextField$5$1 = new CoreTextFieldKt$CoreTextField$5$1(legacyTextFieldState, stateRememberUpdatedState, textInputService5, textFieldSelectionManager, imeOptions9, null);
                                            composerStartRestartGroup.updateRememberedValue(coreTextFieldKt$CoreTextField$5$1);
                                        } else {
                                            imeOptions7 = imeOptions6;
                                            coreTextFieldKt$CoreTextField$5$1 = objRememberedValue16;
                                            textInputService3 = textInputService5;
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        final ImeOptions imeOptions10 = imeOptions7;
                                        EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) coreTextFieldKt$CoreTextField$5$1, composerStartRestartGroup, 6);
                                        int i45 = i43 >> 3;
                                        final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager;
                                        final boolean z25 = z12;
                                        Modifier modifierTextFieldPointer = TextFieldPointerModifier_androidKt.textFieldPointer(Modifier.INSTANCE, textFieldSelectionManager3, z25, mutableInteractionSource6, legacyTextFieldState, focusRequester, z13, offsetMapping, composerStartRestartGroup, ((i39 >> 9) & 7168) | (i45 & 896) | 196614 | ((i43 << 6) & 3670016));
                                        final OffsetMapping offsetMapping3 = offsetMapping;
                                        final Modifier modifierTextFieldDraw = CoreTextField_androidKt.textFieldDraw(Modifier.INSTANCE, legacyTextFieldState, textFieldValue2, offsetMapping3);
                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213533337, "CC(remember):CoreTextField.kt#9igjgp");
                                        WindowInfo windowInfo5 = windowInfo;
                                        zChangedInstance2 = composerStartRestartGroup.changedInstance(legacyTextFieldState) | (i42 != 2048) | composerStartRestartGroup.changed(windowInfo5) | composerStartRestartGroup.changedInstance(textFieldSelectionManager3) | (i41 != 4) | composerStartRestartGroup.changedInstance(offsetMapping3);
                                        Object objRememberedValue17 = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance2) {
                                            windowInfo2 = windowInfo5;
                                            if (objRememberedValue17 != Composer.INSTANCE.getEmpty()) {
                                                windowInfo3 = windowInfo2;
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            final Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) objRememberedValue17);
                                            CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier = new CoreTextFieldSemanticsModifier(transformedText, textFieldValue, legacyTextFieldState, z13, z25, visualTransformation3 instanceof PasswordVisualTransformation, offsetMapping3, textFieldSelectionManager3, imeOptions10, focusRequester);
                                            Brush brush5 = brush4;
                                            Modifier modifierTextFieldCursor = CoreTextField_androidKt.textFieldCursor(Modifier.INSTANCE, legacyTextFieldState, textFieldValue, offsetMapping3, brush5, z25 && !z13 && windowInfo3.isWindowFocused() && !legacyTextFieldState.hasHighlight());
                                            final VisualTransformation visualTransformation4 = visualTransformation3;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213463375, "CC(remember):CoreTextField.kt#9igjgp");
                                            zChangedInstance3 = composerStartRestartGroup.changedInstance(textFieldSelectionManager3);
                                            Object objRememberedValue18 = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance3) {
                                                modifier4 = modifierTextFieldCursor;
                                                if (objRememberedValue18 == Composer.INSTANCE.getEmpty()) {
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                EffectsKt.DisposableEffect(textFieldSelectionManager3, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue18, composerStartRestartGroup, 0);
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213460264, "CC(remember):CoreTextField.kt#9igjgp");
                                                zChangedInstance4 = composerStartRestartGroup.changedInstance(legacyTextFieldState) | composerStartRestartGroup.changedInstance(textInputService3) | (i41 == 4) | ((i44 > 32 && composerStartRestartGroup.changed(imeOptions10)) || (i43 & 48) == 32);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance4 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda4
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj) {
                                                            return CoreTextFieldKt.CoreTextField$lambda$18$0(legacyTextFieldState, textInputService3, textFieldValue, imeOptions10, (DisposableEffectScope) obj);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                EffectsKt.DisposableEffect(imeOptions10, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, i45 & 14);
                                                final int i46 = i32;
                                                Modifier modifierM3546textFieldKeyInput2WJ9YEU = TextFieldKeyInputKt.m3546textFieldKeyInput2WJ9YEU(Modifier.INSTANCE, legacyTextFieldState, textFieldSelectionManager3, textFieldValue, legacyTextFieldState.getOnValueChange(), !z13, i46 != 1, offsetMapping3, undoManager, imeOptions10.getImeAction());
                                                z16 = KeyboardType.m10685equalsimpl0(imeOptions10.getKeyboardType(), KeyboardType.INSTANCE.m10704getPasswordPjHm6EE()) && !KeyboardType.m10685equalsimpl0(imeOptions10.getKeyboardType(), KeyboardType.INSTANCE.m10703getNumberPasswordPjHm6EE());
                                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                                boolean zCoreTextField$lambda$14 = CoreTextField$lambda$14(stateRememberUpdatedState);
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213422116, "CC(remember):CoreTextField.kt#9igjgp");
                                                legacyPlatformTextInputServiceAdapter2 = legacyPlatformTextInputServiceAdapter;
                                                zChanged = composerStartRestartGroup.changed(z16) | composerStartRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter2);
                                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                                if (!zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue3 = new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda5
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Object invoke() {
                                                            return CoreTextFieldKt.CoreTextField$lambda$19$0(z16, legacyPlatformTextInputServiceAdapter2);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                Modifier modifierStylusHandwriting = StylusHandwritingKt.stylusHandwriting(companion3, zCoreTextField$lambda$14, z16, (Function0) objRememberedValue3);
                                                ProvidableCompositionLocal<Brush> localAutofillHighlightBrush = AutofillHighlightKt.getLocalAutofillHighlightBrush();
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                                Object objConsume10 = composerStartRestartGroup.consume(localAutofillHighlightBrush);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                ProvidableCompositionLocal<Color> localAutofillHighlightColor = AutofillHighlightKt.getLocalAutofillHighlightColor();
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                                Object objConsume11 = composerStartRestartGroup.consume(localAutofillHighlightColor);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                brushM3341resolveAutofillHighlightWkMShQ = AutofillHighlightKt.m3341resolveAutofillHighlightWkMShQ((Brush) objConsume10, ((Color) objConsume11).m8158unboximpl(), AutofillHighlight_androidKt.autofillHighlightColor());
                                                Modifier.Companion companion4 = Modifier.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213381208, "CC(remember):CoreTextField.kt#9igjgp");
                                                zChangedInstance5 = composerStartRestartGroup.changedInstance(legacyTextFieldState) | composerStartRestartGroup.changed(brushM3341resolveAutofillHighlightWkMShQ);
                                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                                if (!zChangedInstance5 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue4 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda14
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj) {
                                                            return CoreTextFieldKt.CoreTextField$lambda$20$0(legacyTextFieldState, brushM3341resolveAutofillHighlightWkMShQ, (ContentDrawScope) obj);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                Modifier modifierDrawWithContent = DrawModifierKt.drawWithContent(companion4, (Function1) objRememberedValue4);
                                                OverscrollEffect overscrollEffectRememberTextFieldOverscrollEffect = TextFieldScroll_androidKt.rememberTextFieldOverscrollEffect(composerStartRestartGroup, 0);
                                                Modifier modifierThen = previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier5.then(modifierDrawWithContent), legacyPlatformTextInputServiceAdapter2, legacyTextFieldState, textFieldSelectionManager3).then(modifierStylusHandwriting).then(modifierTextFieldFocusModifier), legacyTextFieldState, focusManager), legacyTextFieldState, textFieldSelectionManager3).then(modifierM3546textFieldKeyInput2WJ9YEU);
                                                final TextFieldScrollerPosition textFieldScrollerPosition6 = textFieldScrollerPosition5;
                                                Modifier modifierAddContextMenuComponents = addContextMenuComponents(OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(modifierThen, textFieldScrollerPosition6, mutableInteractionSource6, z25, overscrollEffectRememberTextFieldOverscrollEffect).then(modifierTextFieldPointer).then(coreTextFieldSemanticsModifier), new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda15
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj) {
                                                        return CoreTextFieldKt.CoreTextField$lambda$21(legacyTextFieldState, (LayoutCoordinates) obj);
                                                    }
                                                }), textFieldSelectionManager3, coroutineScope);
                                                z17 = !z25 && legacyTextFieldState.getHasFocus() && legacyTextFieldState.isInTouchMode() && windowInfo3.isWindowFocused();
                                                if (!z17) {
                                                    companionTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(Modifier.INSTANCE, textFieldSelectionManager3);
                                                } else {
                                                    companionTextFieldMagnifier = Modifier.INSTANCE;
                                                }
                                                final Modifier modifier6 = companionTextFieldMagnifier;
                                                final Modifier modifier7 = modifier4;
                                                final BringIntoViewRequester bringIntoViewRequester3 = bringIntoViewRequester;
                                                final boolean z26 = z13;
                                                final TextStyle textStyle6 = textStyle4;
                                                Function2 function2 = new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda16
                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(Object obj, Object obj2) {
                                                        return CoreTextFieldKt.CoreTextField$lambda$22(function33, legacyTextFieldState, textStyle6, i40, i46, textFieldScrollerPosition6, textFieldValue, visualTransformation4, modifier7, modifierTextFieldDraw, modifierOnGloballyPositioned, modifier6, bringIntoViewRequester3, textFieldSelectionManager3, z17, z26, function16, offsetMapping3, density, (Composer) obj, ((Integer) obj2).intValue());
                                                    }
                                                };
                                                composer2 = composerStartRestartGroup;
                                                CoreTextFieldRootBox(modifierAddContextMenuComponents, textFieldSelectionManager3, ComposableLambdaKt.rememberComposableLambda(-814563849, true, function2, composer2, 54), composer2, RendererCapabilities.DECODER_SUPPORT_MASK);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                i28 = i40;
                                                visualTransformation2 = visualTransformation4;
                                                function32 = function33;
                                                function14 = function16;
                                                textFieldScrollerPosition2 = textFieldScrollerPosition3;
                                                z4 = z25;
                                                mutableInteractionSource3 = mutableInteractionSource6;
                                                z6 = z13;
                                                modifier2 = modifier5;
                                                i27 = i46;
                                                brush2 = brush5;
                                                z5 = z10;
                                                textStyle3 = textStyle4;
                                                imeOptions2 = imeOptions10;
                                            } else {
                                                modifier4 = modifierTextFieldCursor;
                                            }
                                            objRememberedValue18 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda3
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj) {
                                                    return CoreTextFieldKt.CoreTextField$lambda$17$0(textFieldSelectionManager3, (DisposableEffectScope) obj);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue18);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            EffectsKt.DisposableEffect(textFieldSelectionManager3, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue18, composerStartRestartGroup, 0);
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213460264, "CC(remember):CoreTextField.kt#9igjgp");
                                            if (i44 > 32) {
                                                zChangedInstance4 = composerStartRestartGroup.changedInstance(legacyTextFieldState) | composerStartRestartGroup.changedInstance(textInputService3) | (i41 == 4) | ((i44 > 32 && composerStartRestartGroup.changed(imeOptions10)) || (i43 & 48) == 32);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance4) {
                                                    objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda4
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj) {
                                                            return CoreTextFieldKt.CoreTextField$lambda$18$0(legacyTextFieldState, textInputService3, textFieldValue, imeOptions10, (DisposableEffectScope) obj);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    EffectsKt.DisposableEffect(imeOptions10, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, i45 & 14);
                                                    final int i462 = i32;
                                                    Modifier modifierM3546textFieldKeyInput2WJ9YEU2 = TextFieldKeyInputKt.m3546textFieldKeyInput2WJ9YEU(Modifier.INSTANCE, legacyTextFieldState, textFieldSelectionManager3, textFieldValue, legacyTextFieldState.getOnValueChange(), !z13, i462 != 1, offsetMapping3, undoManager, imeOptions10.getImeAction());
                                                    if (KeyboardType.m10685equalsimpl0(imeOptions10.getKeyboardType(), KeyboardType.INSTANCE.m10704getPasswordPjHm6EE())) {
                                                        Modifier.Companion companion32 = Modifier.INSTANCE;
                                                        boolean zCoreTextField$lambda$142 = CoreTextField$lambda$14(stateRememberUpdatedState);
                                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213422116, "CC(remember):CoreTextField.kt#9igjgp");
                                                        legacyPlatformTextInputServiceAdapter2 = legacyPlatformTextInputServiceAdapter;
                                                        zChanged = composerStartRestartGroup.changed(z16) | composerStartRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter2);
                                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                                        if (!zChanged) {
                                                            objRememberedValue3 = new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda5
                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final Object invoke() {
                                                                    return CoreTextFieldKt.CoreTextField$lambda$19$0(z16, legacyPlatformTextInputServiceAdapter2);
                                                                }
                                                            };
                                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            Modifier modifierStylusHandwriting2 = StylusHandwritingKt.stylusHandwriting(companion32, zCoreTextField$lambda$142, z16, (Function0) objRememberedValue3);
                                                            ProvidableCompositionLocal<Brush> localAutofillHighlightBrush2 = AutofillHighlightKt.getLocalAutofillHighlightBrush();
                                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                                            Object objConsume102 = composerStartRestartGroup.consume(localAutofillHighlightBrush2);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            ProvidableCompositionLocal<Color> localAutofillHighlightColor2 = AutofillHighlightKt.getLocalAutofillHighlightColor();
                                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                                            Object objConsume112 = composerStartRestartGroup.consume(localAutofillHighlightColor2);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            brushM3341resolveAutofillHighlightWkMShQ = AutofillHighlightKt.m3341resolveAutofillHighlightWkMShQ((Brush) objConsume102, ((Color) objConsume112).m8158unboximpl(), AutofillHighlight_androidKt.autofillHighlightColor());
                                                            Modifier.Companion companion42 = Modifier.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213381208, "CC(remember):CoreTextField.kt#9igjgp");
                                                            zChangedInstance5 = composerStartRestartGroup.changedInstance(legacyTextFieldState) | composerStartRestartGroup.changed(brushM3341resolveAutofillHighlightWkMShQ);
                                                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                                            if (!zChangedInstance5) {
                                                                objRememberedValue4 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda14
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Object invoke(Object obj) {
                                                                        return CoreTextFieldKt.CoreTextField$lambda$20$0(legacyTextFieldState, brushM3341resolveAutofillHighlightWkMShQ, (ContentDrawScope) obj);
                                                                    }
                                                                };
                                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                                Modifier modifierDrawWithContent2 = DrawModifierKt.drawWithContent(companion42, (Function1) objRememberedValue4);
                                                                OverscrollEffect overscrollEffectRememberTextFieldOverscrollEffect2 = TextFieldScroll_androidKt.rememberTextFieldOverscrollEffect(composerStartRestartGroup, 0);
                                                                Modifier modifierThen2 = previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier5.then(modifierDrawWithContent2), legacyPlatformTextInputServiceAdapter2, legacyTextFieldState, textFieldSelectionManager3).then(modifierStylusHandwriting2).then(modifierTextFieldFocusModifier), legacyTextFieldState, focusManager), legacyTextFieldState, textFieldSelectionManager3).then(modifierM3546textFieldKeyInput2WJ9YEU2);
                                                                final TextFieldScrollerPosition textFieldScrollerPosition62 = textFieldScrollerPosition5;
                                                                Modifier modifierAddContextMenuComponents2 = addContextMenuComponents(OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(modifierThen2, textFieldScrollerPosition62, mutableInteractionSource6, z25, overscrollEffectRememberTextFieldOverscrollEffect2).then(modifierTextFieldPointer).then(coreTextFieldSemanticsModifier), new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda15
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Object invoke(Object obj) {
                                                                        return CoreTextFieldKt.CoreTextField$lambda$21(legacyTextFieldState, (LayoutCoordinates) obj);
                                                                    }
                                                                }), textFieldSelectionManager3, coroutineScope);
                                                                if (z25) {
                                                                    if (!z17) {
                                                                    }
                                                                    final Modifier modifier62 = companionTextFieldMagnifier;
                                                                    final Modifier modifier72 = modifier4;
                                                                    final BringIntoViewRequester bringIntoViewRequester32 = bringIntoViewRequester;
                                                                    final boolean z262 = z13;
                                                                    final TextStyle textStyle62 = textStyle4;
                                                                    Function2 function22 = new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda16
                                                                        @Override // kotlin.jvm.functions.Function2
                                                                        public final Object invoke(Object obj, Object obj2) {
                                                                            return CoreTextFieldKt.CoreTextField$lambda$22(function33, legacyTextFieldState, textStyle62, i40, i462, textFieldScrollerPosition62, textFieldValue, visualTransformation4, modifier72, modifierTextFieldDraw, modifierOnGloballyPositioned, modifier62, bringIntoViewRequester32, textFieldSelectionManager3, z17, z262, function16, offsetMapping3, density, (Composer) obj, ((Integer) obj2).intValue());
                                                                        }
                                                                    };
                                                                    composer2 = composerStartRestartGroup;
                                                                    CoreTextFieldRootBox(modifierAddContextMenuComponents2, textFieldSelectionManager3, ComposableLambdaKt.rememberComposableLambda(-814563849, true, function22, composer2, 54), composer2, RendererCapabilities.DECODER_SUPPORT_MASK);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                    }
                                                                    i28 = i40;
                                                                    visualTransformation2 = visualTransformation4;
                                                                    function32 = function33;
                                                                    function14 = function16;
                                                                    textFieldScrollerPosition2 = textFieldScrollerPosition3;
                                                                    z4 = z25;
                                                                    mutableInteractionSource3 = mutableInteractionSource6;
                                                                    z6 = z13;
                                                                    modifier2 = modifier5;
                                                                    i27 = i462;
                                                                    brush2 = brush5;
                                                                    z5 = z10;
                                                                    textStyle3 = textStyle4;
                                                                    imeOptions2 = imeOptions10;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                zChangedInstance4 = composerStartRestartGroup.changedInstance(legacyTextFieldState) | composerStartRestartGroup.changedInstance(textInputService3) | (i41 == 4) | ((i44 > 32 && composerStartRestartGroup.changed(imeOptions10)) || (i43 & 48) == 32);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance4) {
                                                }
                                            }
                                        } else {
                                            windowInfo2 = windowInfo5;
                                        }
                                        objRememberedValue17 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return CoreTextFieldKt.CoreTextField$lambda$16$0(legacyTextFieldState, z25, windowInfo2, textFieldSelectionManager3, textFieldValue, offsetMapping3, (LayoutCoordinates) obj);
                                            }
                                        };
                                        windowInfo3 = windowInfo2;
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue17);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        final Modifier modifierOnGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) objRememberedValue17);
                                        CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier2 = new CoreTextFieldSemanticsModifier(transformedText, textFieldValue, legacyTextFieldState, z13, z25, visualTransformation3 instanceof PasswordVisualTransformation, offsetMapping3, textFieldSelectionManager3, imeOptions10, focusRequester);
                                        if (z25) {
                                            Brush brush52 = brush4;
                                            Modifier modifierTextFieldCursor2 = CoreTextField_androidKt.textFieldCursor(Modifier.INSTANCE, legacyTextFieldState, textFieldValue, offsetMapping3, brush52, z25 && !z13 && windowInfo3.isWindowFocused() && !legacyTextFieldState.hasHighlight());
                                            final VisualTransformation visualTransformation42 = visualTransformation3;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213463375, "CC(remember):CoreTextField.kt#9igjgp");
                                            zChangedInstance3 = composerStartRestartGroup.changedInstance(textFieldSelectionManager3);
                                            Object objRememberedValue182 = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance3) {
                                            }
                                            objRememberedValue182 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda3
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj) {
                                                    return CoreTextFieldKt.CoreTextField$lambda$17$0(textFieldSelectionManager3, (DisposableEffectScope) obj);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue182);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            EffectsKt.DisposableEffect(textFieldSelectionManager3, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue182, composerStartRestartGroup, 0);
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213460264, "CC(remember):CoreTextField.kt#9igjgp");
                                        }
                                    } else {
                                        imeOptions6 = imeOptions5;
                                    }
                                    z14 = true;
                                    z15 = z14 | zChanged4;
                                    Object objRememberedValue162 = composerStartRestartGroup.rememberedValue();
                                    if (z15) {
                                        ImeOptions imeOptions92 = imeOptions6;
                                        textInputService3 = textInputService5;
                                        imeOptions7 = imeOptions92;
                                        coreTextFieldKt$CoreTextField$5$1 = new CoreTextFieldKt$CoreTextField$5$1(legacyTextFieldState, stateRememberUpdatedState, textInputService5, textFieldSelectionManager, imeOptions92, null);
                                        composerStartRestartGroup.updateRememberedValue(coreTextFieldKt$CoreTextField$5$1);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        final ImeOptions imeOptions102 = imeOptions7;
                                        EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) coreTextFieldKt$CoreTextField$5$1, composerStartRestartGroup, 6);
                                        int i452 = i43 >> 3;
                                        final TextFieldSelectionManager textFieldSelectionManager32 = textFieldSelectionManager;
                                        final boolean z252 = z12;
                                        Modifier modifierTextFieldPointer2 = TextFieldPointerModifier_androidKt.textFieldPointer(Modifier.INSTANCE, textFieldSelectionManager32, z252, mutableInteractionSource6, legacyTextFieldState, focusRequester, z13, offsetMapping, composerStartRestartGroup, ((i39 >> 9) & 7168) | (i452 & 896) | 196614 | ((i43 << 6) & 3670016));
                                        final OffsetMapping offsetMapping32 = offsetMapping;
                                        final Modifier modifierTextFieldDraw2 = CoreTextField_androidKt.textFieldDraw(Modifier.INSTANCE, legacyTextFieldState, textFieldValue2, offsetMapping32);
                                        Modifier.Companion companion22 = Modifier.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213533337, "CC(remember):CoreTextField.kt#9igjgp");
                                        WindowInfo windowInfo52 = windowInfo;
                                        zChangedInstance2 = composerStartRestartGroup.changedInstance(legacyTextFieldState) | (i42 != 2048) | composerStartRestartGroup.changed(windowInfo52) | composerStartRestartGroup.changedInstance(textFieldSelectionManager32) | (i41 != 4) | composerStartRestartGroup.changedInstance(offsetMapping32);
                                        Object objRememberedValue172 = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance2) {
                                        }
                                        objRememberedValue172 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return CoreTextFieldKt.CoreTextField$lambda$16$0(legacyTextFieldState, z252, windowInfo2, textFieldSelectionManager32, textFieldValue, offsetMapping32, (LayoutCoordinates) obj);
                                            }
                                        };
                                        windowInfo3 = windowInfo2;
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue172);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        final Modifier modifierOnGloballyPositioned22 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion22, (Function1) objRememberedValue172);
                                        CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier22 = new CoreTextFieldSemanticsModifier(transformedText, textFieldValue, legacyTextFieldState, z13, z252, visualTransformation3 instanceof PasswordVisualTransformation, offsetMapping32, textFieldSelectionManager32, imeOptions102, focusRequester);
                                    }
                                } else {
                                    textInputService = textInputService4;
                                }
                                z11 = true;
                                zChangedInstance = zChangedInstance6 | z11 | composerStartRestartGroup.changedInstance(offsetMapping2) | composerStartRestartGroup.changedInstance(coroutineScope2) | composerStartRestartGroup.changedInstance(bringIntoViewRequester2) | composerStartRestartGroup.changedInstance(textFieldSelectionManager2);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (zChangedInstance) {
                                    offsetMapping = offsetMapping2;
                                    final ImeOptions imeOptions82 = imeOptions4;
                                    final boolean z242 = z8;
                                    objRememberedValue = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CoreTextFieldKt.CoreTextField$lambda$13$0(legacyTextFieldState, z23, z242, textInputService, textFieldValue, imeOptions82, offsetMapping, textFieldSelectionManager2, coroutineScope2, bringIntoViewRequester2, (FocusState) obj);
                                        }
                                    };
                                    z12 = z23;
                                    z13 = z242;
                                    textInputService2 = textInputService;
                                    textFieldValue2 = textFieldValue;
                                    imeOptions5 = imeOptions82;
                                    textFieldSelectionManager = textFieldSelectionManager2;
                                    coroutineScope = coroutineScope2;
                                    bringIntoViewRequester = bringIntoViewRequester2;
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    Modifier modifierTextFieldFocusModifier2 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion, z12, focusRequester, mutableInteractionSource6, (Function1) objRememberedValue);
                                    if (z12) {
                                        State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z12 || z13) ? false : true), composerStartRestartGroup, 0);
                                        Unit unit2 = Unit.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213577460, "CC(remember):CoreTextField.kt#9igjgp");
                                        boolean zChanged42 = composerStartRestartGroup.changed(stateRememberUpdatedState2) | composerStartRestartGroup.changedInstance(legacyTextFieldState) | composerStartRestartGroup.changedInstance(textInputService2) | composerStartRestartGroup.changedInstance(textFieldSelectionManager);
                                        TextInputService textInputService52 = textInputService2;
                                        if (i44 > 32) {
                                            imeOptions6 = imeOptions5;
                                            if ((i43 & 48) != 32) {
                                                z14 = true;
                                            }
                                            z15 = z14 | zChanged42;
                                            Object objRememberedValue1622 = composerStartRestartGroup.rememberedValue();
                                            if (z15) {
                                            }
                                        }
                                    }
                                }
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                i27 = i;
                                imeOptions2 = imeOptions;
                                keyboardActions2 = keyboardActions;
                                z4 = z2;
                                function32 = function3;
                                textFieldScrollerPosition2 = textFieldScrollerPosition;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                function14 = function13;
                                textStyle3 = textStyle2;
                                visualTransformation2 = none;
                                brush2 = brush;
                                z5 = z;
                                i28 = i2;
                                z6 = z3;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                final Modifier modifier8 = modifier2;
                                final KeyboardActions keyboardActions5 = keyboardActions2;
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda17
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CoreTextFieldKt.CoreTextField$lambda$23(textFieldValue, function1, modifier8, textStyle3, visualTransformation2, function14, mutableInteractionSource3, brush2, z5, i27, i28, imeOptions2, keyboardActions5, z4, z6, function32, textFieldScrollerPosition2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i6 |= 805306368;
                        i15 = i14;
                        i16 = i5 & 1024;
                        if (i16 == 0) {
                        }
                        if ((i4 & 48) == 0) {
                        }
                        int i342 = i18;
                        i19 = i5 & 4096;
                        if (i19 == 0) {
                        }
                        i21 = i5 & 8192;
                        if (i21 == 0) {
                        }
                        i23 = i5 & 16384;
                        if (i23 == 0) {
                        }
                        i25 = i5 & 32768;
                        if (i25 == 0) {
                        }
                        i26 = i5 & 65536;
                        if (i26 == 0) {
                        }
                        if (!composerStartRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i24 & 599187) != 599186, i6 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i13 = i12;
                    i14 = i5 & 512;
                    if (i14 == 0) {
                    }
                    i15 = i14;
                    i16 = i5 & 1024;
                    if (i16 == 0) {
                    }
                    if ((i4 & 48) == 0) {
                    }
                    int i3422 = i18;
                    i19 = i5 & 4096;
                    if (i19 == 0) {
                    }
                    i21 = i5 & 8192;
                    if (i21 == 0) {
                    }
                    i23 = i5 & 16384;
                    if (i23 == 0) {
                    }
                    i25 = i5 & 32768;
                    if (i25 == 0) {
                    }
                    i26 = i5 & 65536;
                    if (i26 == 0) {
                    }
                    if (!composerStartRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i24 & 599187) != 599186, i6 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                none = visualTransformation;
                i9 = i5 & 32;
                if (i9 == 0) {
                }
                i10 = i5 & 64;
                if (i10 == 0) {
                }
                i11 = i5 & 128;
                if (i11 == 0) {
                }
                i12 = i5 & 256;
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i5 & 512;
                if (i14 == 0) {
                }
                i15 = i14;
                i16 = i5 & 1024;
                if (i16 == 0) {
                }
                if ((i4 & 48) == 0) {
                }
                int i34222 = i18;
                i19 = i5 & 4096;
                if (i19 == 0) {
                }
                i21 = i5 & 8192;
                if (i21 == 0) {
                }
                i23 = i5 & 16384;
                if (i23 == 0) {
                }
                i25 = i5 & 32768;
                if (i25 == 0) {
                }
                i26 = i5 & 65536;
                if (i26 == 0) {
                }
                if (!composerStartRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i24 & 599187) != 599186, i6 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            textStyle2 = textStyle;
            i8 = i5 & 16;
            if (i8 != 0) {
            }
            none = visualTransformation;
            i9 = i5 & 32;
            if (i9 == 0) {
            }
            i10 = i5 & 64;
            if (i10 == 0) {
            }
            i11 = i5 & 128;
            if (i11 == 0) {
            }
            i12 = i5 & 256;
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i5 & 512;
            if (i14 == 0) {
            }
            i15 = i14;
            i16 = i5 & 1024;
            if (i16 == 0) {
            }
            if ((i4 & 48) == 0) {
            }
            int i342222 = i18;
            i19 = i5 & 4096;
            if (i19 == 0) {
            }
            i21 = i5 & 8192;
            if (i21 == 0) {
            }
            i23 = i5 & 16384;
            if (i23 == 0) {
            }
            i25 = i5 & 32768;
            if (i25 == 0) {
            }
            i26 = i5 & 65536;
            if (i26 == 0) {
            }
            if (!composerStartRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i24 & 599187) != 599186, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 8;
        if (i7 == 0) {
        }
        textStyle2 = textStyle;
        i8 = i5 & 16;
        if (i8 != 0) {
        }
        none = visualTransformation;
        i9 = i5 & 32;
        if (i9 == 0) {
        }
        i10 = i5 & 64;
        if (i10 == 0) {
        }
        i11 = i5 & 128;
        if (i11 == 0) {
        }
        i12 = i5 & 256;
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i5 & 512;
        if (i14 == 0) {
        }
        i15 = i14;
        i16 = i5 & 1024;
        if (i16 == 0) {
        }
        if ((i4 & 48) == 0) {
        }
        int i3422222 = i18;
        i19 = i5 & 4096;
        if (i19 == 0) {
        }
        i21 = i5 & 8192;
        if (i21 == 0) {
        }
        i23 = i5 & 16384;
        if (i23 == 0) {
        }
        i25 = i5 & 32768;
        if (i25 == 0) {
        }
        i26 = i5 & 65536;
        if (i26 == 0) {
        }
        if (!composerStartRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i24 & 599187) != 599186, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldScrollerPosition CoreTextField$lambda$4$0(Orientation orientation) {
        return new TextFieldScrollerPosition(orientation, 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString CoreTextField$lambda$11(TextFieldSelectionManager textFieldSelectionManager) {
        return TextFieldSelectionManager.copyWithResult$foundation$default(textFieldSelectionManager, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$10(TextFieldSelectionManager textFieldSelectionManager, AnnotatedString annotatedString) {
        textFieldSelectionManager.paste$foundation(annotatedString);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$13$0(LegacyTextFieldState legacyTextFieldState, boolean z, boolean z2, TextInputService textInputService, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping, TextFieldSelectionManager textFieldSelectionManager, CoroutineScope coroutineScope, BringIntoViewRequester bringIntoViewRequester, FocusState focusState) {
        TextLayoutResultProxy layoutResult;
        if (legacyTextFieldState.getHasFocus() == focusState.isFocused()) {
            return Unit.INSTANCE;
        }
        legacyTextFieldState.setHasFocus(focusState.isFocused());
        if (legacyTextFieldState.getHasFocus() && z && !z2) {
            startInputSession(textInputService, legacyTextFieldState, textFieldValue, imeOptions, offsetMapping);
        } else {
            endInputSession(legacyTextFieldState);
        }
        if (focusState.isFocused() && (layoutResult = legacyTextFieldState.getLayoutResult()) != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester, textFieldValue, legacyTextFieldState, layoutResult, offsetMapping, null), 3, null);
        }
        if (!focusState.isFocused()) {
            TextFieldSelectionManager.m4066deselect_kEHs6E$foundation$default(textFieldSelectionManager, null, 1, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$16$0(LegacyTextFieldState legacyTextFieldState, boolean z, WindowInfo windowInfo, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, OffsetMapping offsetMapping, LayoutCoordinates layoutCoordinates) {
        TextInputSession inputSession;
        legacyTextFieldState.setLayoutCoordinates(layoutCoordinates);
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (layoutResult != null) {
            layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
        }
        if (z) {
            if (legacyTextFieldState.getHandleState() == HandleState.Selection) {
                if (legacyTextFieldState.getShowFloatingToolbar() && windowInfo.isWindowFocused()) {
                    textFieldSelectionManager.showSelectionToolbar$foundation();
                } else {
                    textFieldSelectionManager.hideSelectionToolbar$foundation();
                }
                legacyTextFieldState.setShowSelectionHandleStart(TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true));
                legacyTextFieldState.setShowSelectionHandleEnd(TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, false));
                legacyTextFieldState.setShowCursorHandle(TextRange.m10447getCollapsedimpl(textFieldValue.getSelection()));
            } else if (legacyTextFieldState.getHandleState() == HandleState.Cursor) {
                legacyTextFieldState.setShowCursorHandle(TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true));
            }
            notifyFocusedRect(legacyTextFieldState, textFieldValue, offsetMapping);
            TextLayoutResultProxy layoutResult2 = legacyTextFieldState.getLayoutResult();
            if (layoutResult2 != null && (inputSession = legacyTextFieldState.getInputSession()) != null && legacyTextFieldState.getHasFocus()) {
                TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation(inputSession, textFieldValue, offsetMapping, layoutResult2);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult CoreTextField$lambda$18$0(LegacyTextFieldState legacyTextFieldState, TextInputService textInputService, TextFieldValue textFieldValue, ImeOptions imeOptions, DisposableEffectScope disposableEffectScope) {
        if (legacyTextFieldState.getHasFocus()) {
            legacyTextFieldState.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation(textInputService, textFieldValue, legacyTextFieldState.getProcessor(), imeOptions, legacyTextFieldState.getOnValueChange(), legacyTextFieldState.getOnImeActionPerformed()));
        }
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$lambda$18$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$19$0(boolean z, LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter) {
        if (z) {
            legacyPlatformTextInputServiceAdapter.startStylusHandwriting();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$20$0(LegacyTextFieldState legacyTextFieldState, Brush brush, ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        if (legacyTextFieldState.getAutofillHighlightOn() || legacyTextFieldState.getJustAutofilled()) {
            DrawScope.m8722drawRectAsUm42w$default(contentDrawScope, brush, 0L, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$21(LegacyTextFieldState legacyTextFieldState, LayoutCoordinates layoutCoordinates) {
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (layoutResult != null) {
            layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$22(Function3 function3, final LegacyTextFieldState legacyTextFieldState, final TextStyle textStyle, final int i, final int i2, final TextFieldScrollerPosition textFieldScrollerPosition, final TextFieldValue textFieldValue, final VisualTransformation visualTransformation, final Modifier modifier, final Modifier modifier2, final Modifier modifier3, final Modifier modifier4, final BringIntoViewRequester bringIntoViewRequester, final TextFieldSelectionManager textFieldSelectionManager, final boolean z, final boolean z2, final Function1 function1, final OffsetMapping offsetMapping, final Density density, Composer composer, int i3) {
        ComposerKt.sourceInformation(composer, "C548@25668L5379,548@25654L5393:CoreTextField.kt#423gt5");
        if (!composer.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-814563849, i3, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:548)");
            }
            function3.invoke(ComposableLambdaKt.rememberComposableLambda(-44346382, true, new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CoreTextFieldKt.CoreTextField$lambda$22$0(legacyTextFieldState, textStyle, i, i2, textFieldScrollerPosition, textFieldValue, visualTransformation, modifier, modifier2, modifier3, modifier4, bringIntoViewRequester, textFieldSelectionManager, z, z2, function1, offsetMapping, density, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$22$0(final LegacyTextFieldState legacyTextFieldState, TextStyle textStyle, int i, final int i2, TextFieldScrollerPosition textFieldScrollerPosition, final TextFieldValue textFieldValue, VisualTransformation visualTransformation, Modifier modifier, Modifier modifier2, Modifier modifier3, Modifier modifier4, BringIntoViewRequester bringIntoViewRequester, final TextFieldSelectionManager textFieldSelectionManager, final boolean z, final boolean z2, final Function1 function1, final OffsetMapping offsetMapping, final Density density, Composer composer, int i3) {
        ComposerKt.sourceInformation(composer, "C562@26519L22,571@26906L4131,571@26870L4167:CoreTextField.kt#423gt5");
        if (!composer.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-44346382, i3, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:551)");
            }
            Modifier modifierHeightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m2912heightInVpY3zN4$default(Modifier.INSTANCE, legacyTextFieldState.m3486getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle, i, i2);
            ComposerKt.sourceInformationMarkerStart(composer, 332827112, "CC(remember):CoreTextField.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(legacyTextFieldState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return legacyTextFieldState.getLayoutResult();
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SimpleLayoutKt.SimpleLayout(BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScroll_androidKt.textFieldScroll(modifierHeightInLines, textFieldScrollerPosition, textFieldValue, visualTransformation, (Function0) objRememberedValue).then(modifier).then(modifier2), textStyle).then(modifier3).then(modifier4), bringIntoViewRequester), ComposableLambdaKt.rememberComposableLambda(1412697320, true, new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CoreTextFieldKt.CoreTextField$lambda$22$0$1(textFieldSelectionManager, legacyTextFieldState, z, z2, function1, textFieldValue, offsetMapping, density, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit CoreTextField$lambda$22$0$1(TextFieldSelectionManager textFieldSelectionManager, LegacyTextFieldState legacyTextFieldState, boolean z, boolean z2, Function1 function1, TextFieldValue textFieldValue, OffsetMapping offsetMapping, Density density, int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C572@26924L3502,637@30444L359:CoreTextField.kt#423gt5");
        boolean z3 = true;
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1412697320, i2, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:572)");
            }
            CoreTextFieldKt$CoreTextField$8$1$1$2 coreTextFieldKt$CoreTextField$8$1$1$2 = new CoreTextFieldKt$CoreTextField$8$1$1$2(legacyTextFieldState, function1, textFieldValue, offsetMapping, density, i);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer);
            Updater.m7256setimpl(composerM7248constructorimpl, coreTextFieldKt$CoreTextField$8$1$1$2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1613409842, "C:CoreTextField.kt#423gt5");
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (legacyTextFieldState.getHandleState() == HandleState.None || legacyTextFieldState.getLayoutCoordinates() == null) {
                z3 = false;
                SelectionToolbarAndHandles(textFieldSelectionManager, z3, composer, 0);
                if (legacyTextFieldState.getHandleState() != HandleState.Cursor && !z2 && z) {
                    composer.startReplaceGroup(-714666198);
                    ComposerKt.sourceInformation(composer, "649@30965L40");
                    TextFieldCursorHandle(textFieldSelectionManager, composer, 0);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-714589318);
                    composer.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
                Intrinsics.checkNotNull(layoutCoordinates);
                if (!layoutCoordinates.isAttached() || !z) {
                }
                SelectionToolbarAndHandles(textFieldSelectionManager, z3, composer, 0);
                if (legacyTextFieldState.getHandleState() != HandleState.Cursor) {
                    composer.startReplaceGroup(-714589318);
                    composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    private static final void CoreTextFieldRootBox(final Modifier modifier, final TextFieldSelectionManager textFieldSelectionManager, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2036174316);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CoreTextFieldRootBox)N(modifier,manager,content)662@31212L83:CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2036174316, i2, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:661)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1799443472, "C662@31260L33:CoreTextField.kt#423gt5");
            ContextMenu_androidKt.ContextMenuArea(textFieldSelectionManager, function2, composerStartRestartGroup, (i2 >> 3) & WebSocketProtocol.PAYLOAD_SHORT);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CoreTextFieldKt.CoreTextFieldRootBox$lambda$1(modifier, textFieldSelectionManager, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final TextFieldSelectionManager textFieldSelectionManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.previewKeyEventToDeselectOnBack.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m3414invokeZmokQxo(keyEvent.m9313unboximpl());
            }

            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m3414invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean z;
                if (legacyTextFieldState.getHandleState() == HandleState.Selection && KeyEventHelpers_androidKt.m3419cancelsTextSelectionZmokQxo(keyEvent)) {
                    z = true;
                    TextFieldSelectionManager.m4066deselect_kEHs6E$foundation$default(textFieldSelectionManager, null, 1, null);
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    public static final void requestFocusAndShowKeyboardIfNeeded(LegacyTextFieldState legacyTextFieldState, FocusRequester focusRequester, boolean z) {
        SoftwareKeyboardController keyboardController;
        if (!legacyTextFieldState.getHasFocus()) {
            FocusRequester.m7808requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        } else {
            if (!z || (keyboardController = legacyTextFieldState.getKeyboardController()) == null) {
                return;
            }
            keyboardController.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startInputSession(TextInputService textInputService, LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        legacyTextFieldState.setInputSession(TextFieldDelegate.INSTANCE.onFocus$foundation(textInputService, textFieldValue, legacyTextFieldState.getProcessor(), imeOptions, legacyTextFieldState.getOnValueChange(), legacyTextFieldState.getOnImeActionPerformed()));
        notifyFocusedRect(legacyTextFieldState, textFieldValue, offsetMapping);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endInputSession(LegacyTextFieldState legacyTextFieldState) {
        TextInputSession inputSession = legacyTextFieldState.getInputSession();
        if (inputSession != null) {
            TextFieldDelegate.INSTANCE.onBlur$foundation(inputSession, legacyTextFieldState.getProcessor(), legacyTextFieldState.getOnValueChange());
        }
        legacyTextFieldState.setInputSession(null);
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> continuation) {
        Rect rect;
        int iOriginalToTransformed = offsetMapping.originalToTransformed(TextRange.m10450getMaximpl(textFieldValue.getSelection()));
        if (iOriginalToTransformed < textLayoutResult.getLayoutInput().getText().length()) {
            rect = textLayoutResult.getBoundingBox(iOriginalToTransformed);
        } else if (iOriginalToTransformed != 0) {
            rect = textLayoutResult.getBoundingBox(iOriginalToTransformed - 1);
        } else {
            rect = new Rect(0.0f, 0.0f, 1.0f, (int) (TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), null, 0, 24, null) & 4294967295L));
        }
        Object objBringIntoView = bringIntoViewRequester.bringIntoView(rect, continuation);
        return objBringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objBringIntoView : Unit.INSTANCE;
    }

    private static final void SelectionToolbarAndHandles(final TextFieldSelectionManager textFieldSelectionManager, final boolean z, Composer composer, final int i) {
        int i2;
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer composerStartRestartGroup = composer.startRestartGroup(626339208);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectionToolbarAndHandles)N(manager,show):CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(626339208, i2, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1014)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(1530097388);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                LegacyTextFieldState state = textFieldSelectionManager.getState();
                TextLayoutResult textLayoutResult = null;
                if (state != null && (layoutResult = state.getLayoutResult()) != null && (value = layoutResult.getValue()) != null) {
                    LegacyTextFieldState state2 = textFieldSelectionManager.getState();
                    if (!(state2 != null ? state2.getIsLayoutResultStale() : true)) {
                        textLayoutResult = value;
                    }
                }
                if (textLayoutResult == null) {
                    composerStartRestartGroup.startReplaceGroup(1530097387);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1530097388);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (TextRange.m10447getCollapsedimpl(textFieldSelectionManager.getValue$foundation().getSelection())) {
                        composerStartRestartGroup.startReplaceGroup(2110860558);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(2109807302);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        int iOriginalToTransformed = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m10453getStartimpl(textFieldSelectionManager.getValue$foundation().getSelection()));
                        int iOriginalToTransformed2 = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m10448getEndimpl(textFieldSelectionManager.getValue$foundation().getSelection()));
                        ResolvedTextDirection bidiRunDirection = textLayoutResult.getBidiRunDirection(iOriginalToTransformed);
                        ResolvedTextDirection bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(iOriginalToTransformed2 - 1, 0));
                        LegacyTextFieldState state3 = textFieldSelectionManager.getState();
                        if (state3 == null || !state3.getShowSelectionHandleStart()) {
                            composerStartRestartGroup.startReplaceGroup(2110490542);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(2110225306);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "1030@46532L220");
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, composerStartRestartGroup, ((i2 << 6) & 896) | 6);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        LegacyTextFieldState state4 = textFieldSelectionManager.getState();
                        if (state4 == null || !state4.getShowSelectionHandleEnd()) {
                            composerStartRestartGroup.startReplaceGroup(2110838734);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(2110574459);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "1037@46884L219");
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, composerStartRestartGroup, ((i2 << 6) & 896) | 6);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    LegacyTextFieldState state5 = textFieldSelectionManager.getState();
                    if (state5 != null) {
                        if (textFieldSelectionManager.isTextChanged$foundation()) {
                            state5.setShowFloatingToolbar(false);
                        }
                        if (state5.getHasFocus()) {
                            if (state5.getShowFloatingToolbar()) {
                                textFieldSelectionManager.showSelectionToolbar$foundation();
                            } else {
                                textFieldSelectionManager.hideSelectionToolbar$foundation();
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1989076778);
                composerStartRestartGroup.endReplaceGroup();
                textFieldSelectionManager.hideSelectionToolbar$foundation();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CoreTextFieldKt.SelectionToolbarAndHandles$lambda$1(textFieldSelectionManager, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionManager textFieldSelectionManager, Composer composer, final int i) {
        int i2;
        AnnotatedString transformedText$foundation;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1436003720);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextFieldCursorHandle)N(manager):CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1436003720, i2, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1061)");
            }
            LegacyTextFieldState state = textFieldSelectionManager.getState();
            if (state != null && state.getShowCursorHandle() && (transformedText$foundation = textFieldSelectionManager.getTransformedText$foundation()) != null && transformedText$foundation.length() > 0) {
                composerStartRestartGroup.startReplaceGroup(-2112351432);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1063@48047L50,1064@48160L7,1066@48220L12,1068@48305L645,1080@48982L385,1065@48177L1201");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1315066870, "CC(remember):CoreTextField.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(textFieldSelectionManager);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = textFieldSelectionManager.cursorDragObserver$foundation();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final TextDragObserver textDragObserver = (TextDragObserver) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final long jM4072getCursorPositiontuRUvjQ$foundation = textFieldSelectionManager.m4072getCursorPositiontuRUvjQ$foundation((Density) objConsume);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1315061372, "CC(remember):CoreTextField.kt#9igjgp");
                boolean zChanged2 = composerStartRestartGroup.changed(jM4072getCursorPositiontuRUvjQ$foundation);
                OffsetProvider offsetProviderRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || offsetProviderRememberedValue == Composer.INSTANCE.getEmpty()) {
                    offsetProviderRememberedValue = new OffsetProvider() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* JADX INFO: renamed from: provide-F1C5BW0 */
                        public final long mo3357provideF1C5BW0() {
                            return jM4072getCursorPositiontuRUvjQ$foundation;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(offsetProviderRememberedValue);
                }
                OffsetProvider offsetProvider = (OffsetProvider) offsetProviderRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1315058019, "CC(remember):CoreTextField.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(textDragObserver) | composerStartRestartGroup.changedInstance(textFieldSelectionManager);
                PointerInputEventHandler pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || pointerInputEventHandlerRememberedValue == Composer.INSTANCE.getEmpty()) {
                    pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1

                        /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1 */
                        /* JADX INFO: compiled from: CoreTextField.kt */
                        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
                        @DebugMetadata(m1608c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1", m1609f = "CoreTextField.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
                        static final class C06601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ TextFieldSelectionManager $manager;
                            final /* synthetic */ TextDragObserver $observer;
                            final /* synthetic */ PointerInputScope $this_pointerInput;
                            private /* synthetic */ Object L$0;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C06601(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, TextFieldSelectionManager textFieldSelectionManager, Continuation<? super C06601> continuation) {
                                super(2, continuation);
                                this.$this_pointerInput = pointerInputScope;
                                this.$observer = textDragObserver;
                                this.$manager = textFieldSelectionManager;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                C06601 c06601 = new C06601(this.$this_pointerInput, this.$observer, this.$manager, continuation);
                                c06601.L$0 = obj;
                                return c06601;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((C06601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                if (this.label == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(this.$this_pointerInput, this.$observer, null), 1, null);
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(this.$this_pointerInput, this.$manager, null), 1, null);
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: CoreTextField.kt */
                            @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
                            @DebugMetadata(m1608c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1", m1609f = "CoreTextField.kt", m1610i = {}, m1611l = {1074}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ TextDragObserver $observer;
                                final /* synthetic */ PointerInputScope $this_pointerInput;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$this_pointerInput = pointerInputScope;
                                    this.$observer = textDragObserver;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$this_pointerInput, this.$observer, continuation);
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
                                        if (LongPressTextDragObserverKt.detectDownAndDragGesturesWithObserver(this.$this_pointerInput, this.$observer, this) == coroutine_suspended) {
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

                            /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2, reason: invalid class name */
                            /* JADX INFO: compiled from: CoreTextField.kt */
                            @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
                            @DebugMetadata(m1608c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2", m1609f = "CoreTextField.kt", m1610i = {}, m1611l = {1077}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
                            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ TextFieldSelectionManager $manager;
                                final /* synthetic */ PointerInputScope $this_pointerInput;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass2(PointerInputScope pointerInputScope, TextFieldSelectionManager textFieldSelectionManager, Continuation<? super AnonymousClass2> continuation) {
                                    super(2, continuation);
                                    this.$this_pointerInput = pointerInputScope;
                                    this.$manager = textFieldSelectionManager;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass2(this.$this_pointerInput, this.$manager, continuation);
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
                                        PointerInputScope pointerInputScope = this.$this_pointerInput;
                                        final TextFieldSelectionManager textFieldSelectionManager = this.$manager;
                                        this.label = 1;
                                        if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, 
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2$$ExternalSyntheticLambda0, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                            	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:129)
                                            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:57)
                                            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:46)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:115)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:303)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                            */
                                        /*
                                            this = this;
                                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                            int r1 = r9.label
                                            r2 = 1
                                            if (r1 == 0) goto L17
                                            if (r1 != r2) goto Lf
                                            kotlin.ResultKt.throwOnFailure(r10)
                                            goto L34
                                        Lf:
                                            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                            r10.<init>(r0)
                                            throw r10
                                        L17:
                                            kotlin.ResultKt.throwOnFailure(r10)
                                            androidx.compose.ui.input.pointer.PointerInputScope r1 = r9.$this_pointerInput
                                            androidx.compose.foundation.text.selection.TextFieldSelectionManager r10 = r9.$manager
                                            androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2$$ExternalSyntheticLambda0 r5 = new androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2$$ExternalSyntheticLambda0
                                            r5.<init>(r10)
                                            r6 = r9
                                            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                                            r9.label = r2
                                            r2 = 0
                                            r3 = 0
                                            r4 = 0
                                            r7 = 7
                                            r8 = 0
                                            java.lang.Object r10 = androidx.compose.foundation.gestures.TapGestureDetectorKt.detectTapGestures$default(r1, r2, r3, r4, r5, r6, r7, r8)
                                            if (r10 != r0) goto L34
                                            return r0
                                        L34:
                                            kotlin.Unit r10 = kotlin.Unit.INSTANCE
                                            return r10
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1.C06601.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                                    }

                                    /* JADX INFO: Access modifiers changed from: private */
                                    public static final Unit invokeSuspend$lambda$0(TextFieldSelectionManager textFieldSelectionManager, Offset offset) {
                                        textFieldSelectionManager.showSelectionToolbar$foundation();
                                        return Unit.INSTANCE;
                                    }
                                }
                            }

                            @Override // androidx.compose.p004ui.input.pointer.PointerInputEventHandler
                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C06601(pointerInputScope, textDragObserver, textFieldSelectionManager, null), continuation);
                                return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, textDragObserver, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1315036615, "CC(remember):CoreTextField.kt#9igjgp");
                    boolean zChanged3 = composerStartRestartGroup.changed(jM4072getCursorPositiontuRUvjQ$foundation);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CoreTextFieldKt.TextFieldCursorHandle$lambda$3$0(jM4072getCursorPositiontuRUvjQ$foundation, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidCursorHandle_androidKt.m3337CursorHandleUSBMPiE(offsetProvider, SemanticsModifierKt.semantics$default(modifierPointerInput, false, (Function1) objRememberedValue2, 1, null), 0L, composerStartRestartGroup, 0, 4);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-2111042550);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CoreTextFieldKt.TextFieldCursorHandle$lambda$4(textFieldSelectionManager, i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit TextFieldCursorHandle$lambda$3$0(long j, SemanticsPropertyReceiver semanticsPropertyReceiver) {
            semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, j, SelectionHandleAnchor.Middle, true, null));
            return Unit.INSTANCE;
        }

        public static final Modifier defaultTextFieldDraw(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final TextFieldValue textFieldValue, final OffsetMapping offsetMapping) {
            return DrawModifierKt.drawBehind(modifier, new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CoreTextFieldKt.defaultTextFieldDraw$lambda$0(legacyTextFieldState, textFieldValue, offsetMapping, (DrawScope) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit defaultTextFieldDraw$lambda$0(LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping, DrawScope drawScope) {
            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
            if (layoutResult != null) {
                TextFieldDelegate.INSTANCE.m3530drawQ1vqE60$foundation(drawScope.getDrawContext().getCanvas(), textFieldValue, legacyTextFieldState.m3488getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState.m3485getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping, layoutResult.getValue(), legacyTextFieldState.getHighlightPaint(), legacyTextFieldState.getSelectionBackgroundColor());
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void notifyFocusedRect(LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
            Snapshot.Companion companion = Snapshot.INSTANCE;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                if (layoutResult == null) {
                    return;
                }
                TextInputSession inputSession = legacyTextFieldState.getInputSession();
                if (inputSession == null) {
                    return;
                }
                LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
                if (layoutCoordinates == null) {
                    return;
                }
                TextFieldDelegate.INSTANCE.notifyFocusedRect$foundation(textFieldValue, legacyTextFieldState.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, inputSession, legacyTextFieldState.getHasFocus(), offsetMapping);
                Unit unit = Unit.INSTANCE;
            } finally {
                companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            }
        }

        private static final Modifier addContextMenuComponents(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, CoroutineScope coroutineScope) {
            return ComposeFoundationFlags.isNewContextMenuEnabled ? TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents(modifier, textFieldSelectionManager, coroutineScope) : modifier;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final DisposableEffectResult CoreTextField$lambda$17$0(final TextFieldSelectionManager textFieldSelectionManager, DisposableEffectScope disposableEffectScope) {
            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$lambda$17$0$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    textFieldSelectionManager.hideSelectionToolbar$foundation();
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean CoreTextField$lambda$14(State<Boolean> state) {
            return state.getValue().booleanValue();
        }
    }
