package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.compose.foundation.text.DeadKeyCombiner;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyEventHelpers_androidKt;
import androidx.compose.foundation.text.KeyMapping;
import androidx.compose.foundation.text.KeyMapping_androidKt;
import androidx.compose.foundation.text.StringsHelpers_jvmAndAndroidKt;
import androidx.compose.foundation.text.TextFieldKeyInput_androidKt;
import androidx.compose.foundation.text.input.internal.selection.SelectionMovementDeletionContext;
import androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.p004ui.focus.FocusManager;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.input.key.KeyEventType;
import androidx.compose.p004ui.input.key.KeyEvent_androidKt;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.platform.SoftwareKeyboardController;
import androidx.compose.p004ui.text.TextRange;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TextFieldKeyEventHandler.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J]\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\"H\u0016¢\u0006\u0004\b#\u0010$JU\u0010%\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\"H\u0002¢\u0006\u0004\b&\u0010'J\f\u0010(\u001a\u00020)*\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, m1599d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "", "<init>", "()V", "preparedSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;", "deadKeyCombiner", "Landroidx/compose/foundation/text/DeadKeyCombiner;", "keyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "currentlyConsumedDownKeys", "Landroidx/collection/MutableLongSet;", "onPreKeyEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/key/KeyEvent;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "onPreKeyEvent-MyFupTE", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Z", "onKeyEvent", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "clipboardKeyCommandsHandler", "Landroidx/compose/foundation/text/input/internal/ClipboardKeyCommandsHandler;", "editable", "singleLine", "onSubmit", "Lkotlin/Function0;", "onKeyEvent-8zsqlwg", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/platform/SoftwareKeyboardController;ZZLkotlin/jvm/functions/Function0;)Z", "processKeyDownEvent", "processKeyDownEvent-q0GpTC0", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/platform/SoftwareKeyboardController;ZZLkotlin/jvm/functions/Function0;)Z", "getVisibleTextLayoutHeight", "", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public abstract class TextFieldKeyEventHandler {
    public static final int $stable = 8;
    private MutableLongSet currentlyConsumedDownKeys;
    private final TextFieldPreparedSelectionState preparedSelectionState = new TextFieldPreparedSelectionState();
    private final DeadKeyCombiner deadKeyCombiner = new DeadKeyCombiner();
    private final KeyMapping keyMapping = KeyMapping_androidKt.getPlatformDefaultKeyMapping();

    /* JADX INFO: compiled from: TextFieldKeyEventHandler.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KeyCommand.values().length];
            try {
                iArr[KeyCommand.COPY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KeyCommand.PASTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KeyCommand.CUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[KeyCommand.LEFT_CHAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[KeyCommand.RIGHT_CHAR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[KeyCommand.LEFT_WORD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[KeyCommand.RIGHT_WORD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[KeyCommand.PREV_PARAGRAPH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[KeyCommand.NEXT_PARAGRAPH.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[KeyCommand.f62UP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[KeyCommand.DOWN.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[KeyCommand.PAGE_UP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[KeyCommand.PAGE_DOWN.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[KeyCommand.LINE_START.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[KeyCommand.LINE_END.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[KeyCommand.LINE_LEFT.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[KeyCommand.LINE_RIGHT.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[KeyCommand.HOME.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[KeyCommand.END.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[KeyCommand.DELETE_PREV_CHAR.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[KeyCommand.DELETE_NEXT_CHAR.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[KeyCommand.DELETE_PREV_WORD.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[KeyCommand.DELETE_NEXT_WORD.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[KeyCommand.DELETE_FROM_LINE_START.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[KeyCommand.DELETE_TO_LINE_END.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[KeyCommand.NEW_LINE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[KeyCommand.TAB.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[KeyCommand.SELECT_ALL.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[KeyCommand.SELECT_LEFT_CHAR.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[KeyCommand.SELECT_RIGHT_CHAR.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[KeyCommand.SELECT_LEFT_WORD.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[KeyCommand.SELECT_RIGHT_WORD.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[KeyCommand.SELECT_PREV_PARAGRAPH.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[KeyCommand.SELECT_NEXT_PARAGRAPH.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_START.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_END.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_LEFT.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_RIGHT.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[KeyCommand.SELECT_UP.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[KeyCommand.SELECT_DOWN.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr[KeyCommand.SELECT_PAGE_UP.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr[KeyCommand.SELECT_PAGE_DOWN.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr[KeyCommand.SELECT_HOME.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr[KeyCommand.SELECT_END.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr[KeyCommand.DESELECT.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr[KeyCommand.UNDO.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                iArr[KeyCommand.REDO.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr[KeyCommand.CHARACTER_PALETTE.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                iArr[KeyCommand.CENTER.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: onPreKeyEvent-MyFupTE, reason: not valid java name */
    public boolean m3802onPreKeyEventMyFupTE(KeyEvent event, TransformedTextFieldState textFieldState, TextFieldSelectionState textFieldSelectionState, FocusManager focusManager, SoftwareKeyboardController keyboardController) {
        if (TextRange.m10447getCollapsedimpl(textFieldState.getVisualText().getSelection()) || !KeyEventHelpers_androidKt.m3419cancelsTextSelectionZmokQxo(event)) {
            return false;
        }
        textFieldSelectionState.deselect();
        return true;
    }

    /* JADX INFO: renamed from: onKeyEvent-8zsqlwg */
    public boolean mo3659onKeyEvent8zsqlwg(KeyEvent event, TransformedTextFieldState textFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, Function1<? super KeyCommand, ? extends Unit> clipboardKeyCommandsHandler, SoftwareKeyboardController keyboardController, boolean editable, boolean singleLine, Function0<Boolean> onSubmit) {
        long jM9324getKeyZmokQxo = KeyEvent_androidKt.m9324getKeyZmokQxo(event);
        if (KeyEventType.m9317equalsimpl0(KeyEvent_androidKt.m9325getTypeZmokQxo(event), KeyEventType.INSTANCE.m9322getKeyUpCS__XNY())) {
            MutableLongSet mutableLongSet = this.currentlyConsumedDownKeys;
            if (mutableLongSet == null || !mutableLongSet.contains(jM9324getKeyZmokQxo)) {
                return false;
            }
            MutableLongSet mutableLongSet2 = this.currentlyConsumedDownKeys;
            if (mutableLongSet2 != null) {
                mutableLongSet2.remove(jM9324getKeyZmokQxo);
            }
            return true;
        }
        if (KeyEventType.m9317equalsimpl0(KeyEvent_androidKt.m9325getTypeZmokQxo(event), KeyEventType.INSTANCE.m9323getUnknownCS__XNY()) && !TextFieldKeyInput_androidKt.m3549isTypedEventZmokQxo(event)) {
            return false;
        }
        boolean zM3801processKeyDownEventq0GpTC0 = m3801processKeyDownEventq0GpTC0(event, textFieldState, textLayoutState, clipboardKeyCommandsHandler, keyboardController, editable, singleLine, onSubmit);
        if (zM3801processKeyDownEventq0GpTC0) {
            MutableLongSet mutableLongSet3 = this.currentlyConsumedDownKeys;
            if (mutableLongSet3 == null) {
                mutableLongSet3 = new MutableLongSet(3);
                this.currentlyConsumedDownKeys = mutableLongSet3;
            }
            mutableLongSet3.plusAssign(jM9324getKeyZmokQxo);
        }
        return zM3801processKeyDownEventq0GpTC0;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x024c  */
    /* JADX INFO: renamed from: processKeyDownEvent-q0GpTC0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean m3801processKeyDownEventq0GpTC0(KeyEvent event, TransformedTextFieldState textFieldState, TextLayoutState textLayoutState, Function1<? super KeyCommand, ? extends Unit> clipboardKeyCommandsHandler, SoftwareKeyboardController keyboardController, boolean editable, boolean singleLine, Function0<Boolean> onSubmit) {
        WedgeAffinity wedgeAffinity;
        Integer numM3415consumeZmokQxo;
        boolean zBooleanValue = false;
        if (TextFieldKeyInput_androidKt.m3549isTypedEventZmokQxo(event) && (numM3415consumeZmokQxo = this.deadKeyCombiner.m3415consumeZmokQxo(event)) != null) {
            String string = StringsHelpers_jvmAndAndroidKt.appendCodePointX(new StringBuilder(2), numM3415consumeZmokQxo.intValue()).toString();
            if (!editable) {
                return false;
            }
            TransformedTextFieldState.replaceSelectedText$default(textFieldState, string, true, null, !TextFieldKeyEventHandler_androidKt.m3803isFromSoftKeyboardZmokQxo(event), 4, null);
            this.preparedSelectionState.resetCachedX();
            return true;
        }
        KeyCommand keyCommandMo3420mapZmokQxo = this.keyMapping.mo3420mapZmokQxo(event);
        if (keyCommandMo3420mapZmokQxo != null && (!keyCommandMo3420mapZmokQxo.getEditsText() || editable)) {
            SelectionMovementDeletionContext selectionMovementDeletionContext = new SelectionMovementDeletionContext(textFieldState, textLayoutState.getLayoutResult(), TextFieldKeyEventHandler_androidKt.m3803isFromSoftKeyboardZmokQxo(event), getVisibleTextLayoutHeight(textLayoutState), this.preparedSelectionState);
            switch (WhenMappings.$EnumSwitchMapping$0[keyCommandMo3420mapZmokQxo.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    clipboardKeyCommandsHandler.invoke(keyCommandMo3420mapZmokQxo);
                    Unit unit = Unit.INSTANCE;
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP || keyCommandMo3420mapZmokQxo == KeyCommand.DOWN || keyCommandMo3420mapZmokQxo == KeyCommand.LEFT_CHAR || keyCommandMo3420mapZmokQxo == KeyCommand.RIGHT_CHAR) {
                        zBooleanValue = !TextRange.m10446equalsimpl0(selectionMovementDeletionContext.getInitialValue().getSelection(), selectionMovementDeletionContext.getSelection());
                    }
                    if (!TextRange.m10446equalsimpl0(selectionMovementDeletionContext.getSelection(), selectionMovementDeletionContext.getInitialValue().getSelection())) {
                        textFieldState.m3835selectCharsIn5zctL8(selectionMovementDeletionContext.getSelection());
                    }
                    if (selectionMovementDeletionContext.getWedgeAffinity() != null && (wedgeAffinity = selectionMovementDeletionContext.getWedgeAffinity()) != null) {
                        if (!TextRange.m10447getCollapsedimpl(textFieldState.getUntransformedText().getSelection())) {
                            textFieldState.setSelectionWedgeAffinity(new SelectionWedgeAffinity(wedgeAffinity));
                            return zBooleanValue;
                        }
                        textFieldState.setSelectionWedgeAffinity(SelectionWedgeAffinity.copy$default(selectionMovementDeletionContext.getInitialWedgeAffinity(), null, wedgeAffinity, 1, null));
                    }
                    break;
                case 4:
                    selectionMovementDeletionContext.collapseLeftOr(new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TextFieldKeyEventHandler.processKeyDownEvent_q0GpTC0$lambda$0$0((SelectionMovementDeletionContext) obj);
                        }
                    });
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                        zBooleanValue = !TextRange.m10446equalsimpl0(selectionMovementDeletionContext.getInitialValue().getSelection(), selectionMovementDeletionContext.getSelection());
                        if (!TextRange.m10446equalsimpl0(selectionMovementDeletionContext.getSelection(), selectionMovementDeletionContext.getInitialValue().getSelection())) {
                        }
                        if (selectionMovementDeletionContext.getWedgeAffinity() != null) {
                            if (!TextRange.m10447getCollapsedimpl(textFieldState.getUntransformedText().getSelection())) {
                            }
                        }
                    }
                    break;
                case 5:
                    selectionMovementDeletionContext.collapseRightOr(new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TextFieldKeyEventHandler.processKeyDownEvent_q0GpTC0$lambda$0$1((SelectionMovementDeletionContext) obj);
                        }
                    });
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 6:
                    selectionMovementDeletionContext.moveCursorLeftByWord();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 7:
                    selectionMovementDeletionContext.moveCursorRightByWord();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 8:
                    selectionMovementDeletionContext.moveCursorPrevByParagraph();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 9:
                    selectionMovementDeletionContext.moveCursorNextByParagraph();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 10:
                    selectionMovementDeletionContext.moveCursorUpByLine();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 11:
                    selectionMovementDeletionContext.moveCursorDownByLine();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 12:
                    selectionMovementDeletionContext.moveCursorUpByPage();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 13:
                    selectionMovementDeletionContext.moveCursorDownByPage();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 14:
                    selectionMovementDeletionContext.moveCursorToLineStart();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 15:
                    selectionMovementDeletionContext.moveCursorToLineEnd();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 16:
                    selectionMovementDeletionContext.moveCursorToLineLeftSide();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 17:
                    selectionMovementDeletionContext.moveCursorToLineRightSide();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 18:
                    selectionMovementDeletionContext.moveCursorToHome();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 19:
                    selectionMovementDeletionContext.moveCursorToEnd();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 20:
                    selectionMovementDeletionContext.moveCursorPrevByCodePointOrEmoji().deleteMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 21:
                    selectionMovementDeletionContext.moveCursorNextByChar().deleteMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 22:
                    selectionMovementDeletionContext.moveCursorPrevByWord().deleteMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 23:
                    selectionMovementDeletionContext.moveCursorNextByWord().deleteMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 24:
                    selectionMovementDeletionContext.moveCursorToLineStart().deleteMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 25:
                    selectionMovementDeletionContext.moveCursorToLineEnd().deleteMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 26:
                    if (!singleLine) {
                        TransformedTextFieldState.replaceSelectedText$default(textFieldState, "\n", true, null, !TextFieldKeyEventHandler_androidKt.m3803isFromSoftKeyboardZmokQxo(event), 4, null);
                        zBooleanValue = true;
                    } else {
                        zBooleanValue = onSubmit.invoke().booleanValue();
                    }
                    Unit unit2 = Unit.INSTANCE;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 27:
                    if (!singleLine) {
                        TransformedTextFieldState.replaceSelectedText$default(textFieldState, "\t", true, null, !TextFieldKeyEventHandler_androidKt.m3803isFromSoftKeyboardZmokQxo(event), 4, null);
                        zBooleanValue = true;
                    }
                    Unit unit3 = Unit.INSTANCE;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 28:
                    selectionMovementDeletionContext.selectAll();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 29:
                    selectionMovementDeletionContext.moveCursorLeftByChar().selectMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 30:
                    selectionMovementDeletionContext.moveCursorRightByChar().selectMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 31:
                    selectionMovementDeletionContext.moveCursorLeftByWord().selectMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 32:
                    selectionMovementDeletionContext.moveCursorRightByWord().selectMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 33:
                    selectionMovementDeletionContext.moveCursorPrevByParagraph().selectMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 34:
                    selectionMovementDeletionContext.moveCursorNextByParagraph().selectMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 35:
                    selectionMovementDeletionContext.moveCursorToLineStart().selectMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 36:
                    selectionMovementDeletionContext.moveCursorToLineEnd().selectMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 37:
                    selectionMovementDeletionContext.moveCursorToLineLeftSide().selectMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 38:
                    selectionMovementDeletionContext.moveCursorToLineRightSide().selectMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 39:
                    selectionMovementDeletionContext.moveCursorUpByLine().selectMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 40:
                    selectionMovementDeletionContext.moveCursorDownByLine().selectMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 41:
                    selectionMovementDeletionContext.moveCursorUpByPage().selectMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 42:
                    selectionMovementDeletionContext.moveCursorDownByPage().selectMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 43:
                    selectionMovementDeletionContext.moveCursorToHome().selectMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 44:
                    selectionMovementDeletionContext.moveCursorToEnd().selectMovement();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 45:
                    selectionMovementDeletionContext.deselect();
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 46:
                    textFieldState.undo();
                    Unit unit4 = Unit.INSTANCE;
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 47:
                    textFieldState.redo();
                    Unit unit5 = Unit.INSTANCE;
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 48:
                    KeyEventHelpers_androidKt.showCharacterPalette();
                    Unit unit6 = Unit.INSTANCE;
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                case 49:
                    keyboardController.show();
                    Unit unit7 = Unit.INSTANCE;
                    zBooleanValue = true;
                    if (keyCommandMo3420mapZmokQxo == KeyCommand.f62UP) {
                    }
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        return zBooleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processKeyDownEvent_q0GpTC0$lambda$0$0(SelectionMovementDeletionContext selectionMovementDeletionContext) {
        selectionMovementDeletionContext.moveCursorLeftByChar();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processKeyDownEvent_q0GpTC0$lambda$0$1(SelectionMovementDeletionContext selectionMovementDeletionContext) {
        selectionMovementDeletionContext.moveCursorRightByChar();
        return Unit.INSTANCE;
    }

    private final float getVisibleTextLayoutHeight(TextLayoutState textLayoutState) {
        LayoutCoordinates textLayoutNodeCoordinates = textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates == null) {
            return Float.NaN;
        }
        Rect rectLocalBoundingBoxOf$default = null;
        if (!textLayoutNodeCoordinates.isAttached()) {
            textLayoutNodeCoordinates = null;
        }
        if (textLayoutNodeCoordinates == null) {
            return Float.NaN;
        }
        LayoutCoordinates decoratorNodeCoordinates = textLayoutState.getDecoratorNodeCoordinates();
        if (decoratorNodeCoordinates != null) {
            if (!decoratorNodeCoordinates.isAttached()) {
                decoratorNodeCoordinates = null;
            }
            if (decoratorNodeCoordinates != null) {
                rectLocalBoundingBoxOf$default = LayoutCoordinates.localBoundingBoxOf$default(decoratorNodeCoordinates, textLayoutNodeCoordinates, false, 2, null);
            }
        }
        if (rectLocalBoundingBoxOf$default != null) {
            return Float.intBitsToFloat((int) (rectLocalBoundingBoxOf$default.m7936getSizeNHjbRc() & 4294967295L));
        }
        return Float.NaN;
    }
}
