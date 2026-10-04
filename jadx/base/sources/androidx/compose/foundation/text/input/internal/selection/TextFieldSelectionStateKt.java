package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.contextmenu.ContextMenuStateKt;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.internal.PlatformUtils_androidKt;
import androidx.compose.foundation.text.CommonContextMenuAreaKt;
import androidx.compose.foundation.text.MenuItemsAvailability;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.pointer.PointerInputScope;
import androidx.compose.p004ui.text.TextRange;
import androidx.compose.p004ui.text.TextRangeKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: TextFieldSelectionState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a@\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0080@¢\u0006\u0002\u0010\n\u001a\"\u0010\u000b\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0080@¢\u0006\u0002\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u00020\u0012*\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a5\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\b\u0004\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0080\b\u001a\u0017\u0010\u001e\u001a\u00020\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\bH\u0082\b\u001aR\u0010 \u001a\u0013\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0002\b#*\u00020\u00022\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u001d\u0010)\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00010*¢\u0006\u0002\b#H\u0000\"\u000e\u0010\u001b\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u001dX\u0082T¢\u0006\u0002\n\u0000¨\u0006,"}, m1599d2 = {"defaultDetectTextFieldTapGestures", "", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "pointerInputScope", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "requestFocus", "Lkotlin/Function0;", "showKeyboard", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultTextFieldSelectionGestures", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "textDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/TextDragObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reverse", "Landroidx/compose/ui/text/TextRange;", "reverse-5zc-tL8", "(J)J", "menuItem", "enabled", "", "desiredState", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "operation", "DEBUG", "DEBUG_TAG", "", "logDebug", "text", "contextMenuBuilder", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "itemsAvailability", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text/MenuItemsAvailability;", "onMenuItemClicked", "Lkotlin/Function2;", "Landroidx/compose/foundation/text/TextContextMenuItems;", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TextFieldSelectionStateKt {
    private static final boolean DEBUG = false;
    private static final String DEBUG_TAG = "TextFieldSelectionState";

    private static final void logDebug(Function0<String> function0) {
    }

    public static final Object defaultDetectTextFieldTapGestures(final TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, MutableInteractionSource mutableInteractionSource, final Function0<Unit> function0, final Function0<Unit> function02, Continuation<? super Unit> continuation) {
        Object objDetectTapAndPress = TapGestureDetectorKt.detectTapAndPress(pointerInputScope, new C07792(mutableInteractionSource, textFieldSelectionState, null), new Function1() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionStateKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldSelectionStateKt.defaultDetectTextFieldTapGestures$lambda$0(function0, textFieldSelectionState, function02, (Offset) obj);
            }
        }, continuation);
        return objDetectTapAndPress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapAndPress : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit defaultDetectTextFieldTapGestures$lambda$0(Function0 function0, TextFieldSelectionState textFieldSelectionState, Function0 function02, Offset offset) {
        function0.invoke();
        if (textFieldSelectionState.getEnabled() && textFieldSelectionState.getIsFocused()) {
            if (!textFieldSelectionState.getReadOnly()) {
                function02.invoke();
                if (textFieldSelectionState.getTextFieldState().getVisualText().length() > 0) {
                    textFieldSelectionState.setShowCursorHandle(true);
                }
            }
            textFieldSelectionState.updateTextToolbarState(TextToolbarState.None);
            textFieldSelectionState.m3883placeCursorAtNearestOffsetk4lQ0M(TextLayoutStateKt.m3820fromDecorationToTextLayoutUv8p0NA(textFieldSelectionState.getTextLayoutState(), textFieldSelectionState.getTextLayoutState().m3813coercedInVisibleBoundsOfInputTextMKHz9U$foundation(offset.m7913unboximpl())));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionStateKt$defaultDetectTextFieldTapGestures$2 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/geometry/Offset;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionStateKt$defaultDetectTextFieldTapGestures$2", m1609f = "TextFieldSelectionState.kt", m1610i = {}, m1611l = {1821}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C07792 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ TextFieldSelectionState $this_defaultDetectTextFieldTapGestures;
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07792(MutableInteractionSource mutableInteractionSource, TextFieldSelectionState textFieldSelectionState, Continuation<? super C07792> continuation) {
            super(3, continuation);
            this.$interactionSource = mutableInteractionSource;
            this.$this_defaultDetectTextFieldTapGestures = textFieldSelectionState;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
            return m3895invoked4ec7I(pressGestureScope, offset.m7913unboximpl(), continuation);
        }

        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m3895invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
            C07792 c07792 = new C07792(this.$interactionSource, this.$this_defaultDetectTextFieldTapGestures, continuation);
            c07792.L$0 = pressGestureScope;
            c07792.J$0 = j;
            return c07792.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                long j = this.J$0;
                MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                if (mutableInteractionSource != null) {
                    C0780xc08eaea3 c0780xc08eaea3 = new C0780xc08eaea3(pressGestureScope, this.$this_defaultDetectTextFieldTapGestures, j, mutableInteractionSource, null);
                    this.label = 1;
                    if (CoroutineScopeKt.coroutineScope(c0780xc08eaea3, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    public static final Object defaultTextFieldSelectionGestures(PointerInputScope pointerInputScope, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation<? super Unit> continuation) {
        Object objAwaitSelectionGestures = SelectionGesturesKt.awaitSelectionGestures(pointerInputScope, mouseSelectionObserver, textDragObserver, continuation);
        return objAwaitSelectionGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitSelectionGestures : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: reverse-5zc-tL8, reason: not valid java name */
    public static final long m3894reverse5zctL8(long j) {
        return TextRangeKt.TextRange(TextRange.m10448getEndimpl(j), TextRange.m10453getStartimpl(j));
    }

    public static final Function0<Unit> menuItem(final TextFieldSelectionState textFieldSelectionState, boolean z, final TextToolbarState textToolbarState, final Function0<Unit> function0) {
        if (z) {
            return new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionStateKt.menuItem.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    function0.invoke();
                    textFieldSelectionState.updateTextToolbarState(textToolbarState);
                }
            };
        }
        return null;
    }

    public static final Function1<ContextMenuScope, Unit> contextMenuBuilder(final TextFieldSelectionState textFieldSelectionState, final ContextMenuState contextMenuState, final State<MenuItemsAvailability> state, final Function2<? super TextFieldSelectionState, ? super TextContextMenuItems, Unit> function2) {
        return new Function1() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionStateKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldSelectionStateKt.contextMenuBuilder$lambda$0(state, contextMenuState, function2, textFieldSelectionState, (ContextMenuScope) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contextMenuBuilder$lambda$0(State state, ContextMenuState contextMenuState, Function2 function2, TextFieldSelectionState textFieldSelectionState, ContextMenuScope contextMenuScope) {
        int iM3507unboximpl = ((MenuItemsAvailability) state.getValue()).m3507unboximpl();
        contextMenuBuilder$lambda$0$textFieldItem(contextMenuScope, contextMenuState, function2, textFieldSelectionState, TextContextMenuItems.Cut, MenuItemsAvailability.m3502getCanCutimpl(iM3507unboximpl));
        contextMenuBuilder$lambda$0$textFieldItem(contextMenuScope, contextMenuState, function2, textFieldSelectionState, TextContextMenuItems.Copy, MenuItemsAvailability.m3501getCanCopyimpl(iM3507unboximpl));
        contextMenuBuilder$lambda$0$textFieldItem(contextMenuScope, contextMenuState, function2, textFieldSelectionState, TextContextMenuItems.Paste, MenuItemsAvailability.m3503getCanPasteimpl(iM3507unboximpl));
        contextMenuBuilder$lambda$0$textFieldItem(contextMenuScope, contextMenuState, function2, textFieldSelectionState, TextContextMenuItems.SelectAll, MenuItemsAvailability.m3504getCanSelectAllimpl(iM3507unboximpl));
        if (PlatformUtils_androidKt.isAutofillAvailable()) {
            contextMenuBuilder$lambda$0$textFieldItem(contextMenuScope, contextMenuState, function2, textFieldSelectionState, TextContextMenuItems.Autofill, MenuItemsAvailability.m3500getCanAutofillimpl(iM3507unboximpl));
        }
        return Unit.INSTANCE;
    }

    private static final void contextMenuBuilder$lambda$0$textFieldItem(ContextMenuScope contextMenuScope, final ContextMenuState contextMenuState, final Function2<? super TextFieldSelectionState, ? super TextContextMenuItems, Unit> function2, final TextFieldSelectionState textFieldSelectionState, final TextContextMenuItems textContextMenuItems, boolean z) {
        if (z) {
            ContextMenuScope.item$default(contextMenuScope, new CommonContextMenuAreaKt.C06551(textContextMenuItems), null, false, null, new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionStateKt$contextMenuBuilder$lambda$0$textFieldItem$$inlined$TextItem$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    function2.invoke(textFieldSelectionState, textContextMenuItems);
                    ContextMenuStateKt.close(contextMenuState);
                }
            }, 14, null);
        }
    }
}
