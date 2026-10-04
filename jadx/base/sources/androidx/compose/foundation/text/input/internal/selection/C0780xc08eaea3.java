package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionStateKt$defaultDetectTextFieldTapGestures$2$1$1 */
/* JADX INFO: compiled from: TextFieldSelectionState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionStateKt$defaultDetectTextFieldTapGestures$2$1$1", m1609f = "TextFieldSelectionState.kt", m1610i = {}, m1611l = {1834, 1842}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
final class C0780xc08eaea3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PressGestureScope $$this$detectTapAndPress;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $offset;
    final /* synthetic */ TextFieldSelectionState $this_defaultDetectTextFieldTapGestures;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0780xc08eaea3(PressGestureScope pressGestureScope, TextFieldSelectionState textFieldSelectionState, long j, MutableInteractionSource mutableInteractionSource, Continuation<? super C0780xc08eaea3> continuation) {
        super(2, continuation);
        this.$$this$detectTapAndPress = pressGestureScope;
        this.$this_defaultDetectTextFieldTapGestures = textFieldSelectionState;
        this.$offset = j;
        this.$interactionSource = mutableInteractionSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C0780xc08eaea3 c0780xc08eaea3 = new C0780xc08eaea3(this.$$this$detectTapAndPress, this.$this_defaultDetectTextFieldTapGestures, this.$offset, this.$interactionSource, continuation);
        c0780xc08eaea3.L$0 = obj;
        return c0780xc08eaea3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C0780xc08eaea3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionStateKt$defaultDetectTextFieldTapGestures$2$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionStateKt$defaultDetectTextFieldTapGestures$2$1$1$1", m1609f = "TextFieldSelectionState.kt", m1610i = {1}, m1611l = {1826, 1831}, m1612m = "invokeSuspend", m1613n = {"press"}, m1615s = {"L$0"}, m1616v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ long $offset;
        final /* synthetic */ TextFieldSelectionState $this_defaultDetectTextFieldTapGestures;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TextFieldSelectionState textFieldSelectionState, long j, MutableInteractionSource mutableInteractionSource, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_defaultDetectTextFieldTapGestures = textFieldSelectionState;
            this.$offset = j;
            this.$interactionSource = mutableInteractionSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_defaultDetectTextFieldTapGestures, this.$offset, this.$interactionSource, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            TextFieldSelectionState textFieldSelectionState;
            PressInteraction.Press press;
            PressInteraction.Press press2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PressInteraction.Press pressInteraction = this.$this_defaultDetectTextFieldTapGestures.getPressInteraction();
                if (pressInteraction != null) {
                    MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                    TextFieldSelectionState textFieldSelectionState2 = this.$this_defaultDetectTextFieldTapGestures;
                    PressInteraction.Cancel cancel = new PressInteraction.Cancel(pressInteraction);
                    this.L$0 = textFieldSelectionState2;
                    this.label = 1;
                    if (mutableInteractionSource.emit(cancel, this) != coroutine_suspended) {
                        textFieldSelectionState = textFieldSelectionState2;
                    }
                } else {
                    press = new PressInteraction.Press(this.$offset, null);
                    this.L$0 = press;
                    this.label = 2;
                    if (this.$interactionSource.emit(press, this) != coroutine_suspended) {
                        press2 = press;
                        this.$this_defaultDetectTextFieldTapGestures.setPressInteraction(press2);
                        return Unit.INSTANCE;
                    }
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                press2 = (PressInteraction.Press) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.$this_defaultDetectTextFieldTapGestures.setPressInteraction(press2);
                return Unit.INSTANCE;
            }
            textFieldSelectionState = (TextFieldSelectionState) this.L$0;
            ResultKt.throwOnFailure(obj);
            textFieldSelectionState.setPressInteraction(null);
            press = new PressInteraction.Press(this.$offset, null);
            this.L$0 = press;
            this.label = 2;
            if (this.$interactionSource.emit(press, this) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0073, code lost:
    
        if (r3.emit(r12, r11) == r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        PressInteraction.Cancel cancel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new AnonymousClass1(this.$this_defaultDetectTextFieldTapGestures, this.$offset, this.$interactionSource, null), 3, null);
            this.label = 1;
            obj = this.$$this$detectTapAndPress.tryAwaitRelease(this);
            if (obj != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$this_defaultDetectTextFieldTapGestures.setPressInteraction(null);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        PressInteraction.Press pressInteraction = this.$this_defaultDetectTextFieldTapGestures.getPressInteraction();
        if (pressInteraction != null) {
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            if (zBooleanValue) {
                cancel = new PressInteraction.Release(pressInteraction);
            } else {
                cancel = new PressInteraction.Cancel(pressInteraction);
            }
            this.label = 2;
        }
        this.$this_defaultDetectTextFieldTapGestures.setPressInteraction(null);
        return Unit.INSTANCE;
    }
}
