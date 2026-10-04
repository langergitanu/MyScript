package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: TextFieldSelectionManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.compose.foundation.text.selection.TextFieldSelectionManager", m1609f = "TextFieldSelectionManager.kt", m1610i = {}, m1611l = {827}, m1612m = "updateClipboardEntry$foundation", m1613n = {}, m1615s = {}, m1616v = 1)
final class TextFieldSelectionManager$updateClipboardEntry$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TextFieldSelectionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldSelectionManager$updateClipboardEntry$1(TextFieldSelectionManager textFieldSelectionManager, Continuation<? super TextFieldSelectionManager$updateClipboardEntry$1> continuation) {
        super(continuation);
        this.this$0 = textFieldSelectionManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateClipboardEntry$foundation(this);
    }
}
