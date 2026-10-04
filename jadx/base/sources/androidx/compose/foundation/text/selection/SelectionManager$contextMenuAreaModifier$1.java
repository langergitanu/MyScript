package androidx.compose.foundation.text.selection;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.TextRange;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SelectionManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "clickLocation", "Landroidx/compose/ui/geometry/Offset;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.compose.foundation.text.selection.SelectionManager$contextMenuAreaModifier$1", m1609f = "SelectionManager.kt", m1610i = {}, m1611l = {194}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
final class SelectionManager$contextMenuAreaModifier$1 extends SuspendLambda implements Function2<Offset, Continuation<? super Unit>, Object> {
    /* synthetic */ long J$0;
    int label;
    final /* synthetic */ SelectionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SelectionManager$contextMenuAreaModifier$1(SelectionManager selectionManager, Continuation<? super SelectionManager$contextMenuAreaModifier$1> continuation) {
        super(2, continuation);
        this.this$0 = selectionManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SelectionManager$contextMenuAreaModifier$1 selectionManager$contextMenuAreaModifier$1 = new SelectionManager$contextMenuAreaModifier$1(this.this$0, continuation);
        selectionManager$contextMenuAreaModifier$1.J$0 = ((Offset) obj).m7913unboximpl();
        return selectionManager$contextMenuAreaModifier$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Offset offset, Continuation<? super Unit> continuation) {
        return m4040invoke3MmeM6k(offset.m7913unboximpl(), continuation);
    }

    /* JADX INFO: renamed from: invoke-3MmeM6k, reason: not valid java name */
    public final Object m4040invoke3MmeM6k(long j, Continuation<? super Unit> continuation) {
        return ((SelectionManager$contextMenuAreaModifier$1) create(Offset.m7892boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long j = this.J$0;
            Pair<AnnotatedString, TextRange> contextTextAndSelection$foundation = this.this$0.getContextTextAndSelection$foundation();
            if (contextTextAndSelection$foundation != null) {
                SelectionManager selectionManager = this.this$0;
                AnnotatedString annotatedStringComponent1 = contextTextAndSelection$foundation.component1();
                long packedValue = contextTextAndSelection$foundation.component2().getPackedValue();
                PlatformSelectionBehaviors platformSelectionBehaviors = selectionManager.getPlatformSelectionBehaviors();
                if (platformSelectionBehaviors != null) {
                    Offset offsetM7892boximpl = Offset.m7892boximpl(j);
                    this.label = 1;
                    if (platformSelectionBehaviors.mo3985onShowContextMenu_2OEclM(annotatedStringComponent1, packedValue, offsetM7892boximpl, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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
