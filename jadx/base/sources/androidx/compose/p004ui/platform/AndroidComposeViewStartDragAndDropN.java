package androidx.compose.p004ui.platform;

import android.view.View;
import androidx.compose.p004ui.draganddrop.ComposeDragShadowBuilder;
import androidx.compose.p004ui.draganddrop.DragAndDropTransferData;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidComposeView.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, m1599d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewStartDragAndDropN;", "", "<init>", "()V", "startDragAndDrop", "", "view", "Landroid/view/View;", "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "dragShadowBuilder", "Landroidx/compose/ui/draganddrop/ComposeDragShadowBuilder;", "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class AndroidComposeViewStartDragAndDropN {
    public static final AndroidComposeViewStartDragAndDropN INSTANCE = new AndroidComposeViewStartDragAndDropN();

    private AndroidComposeViewStartDragAndDropN() {
    }

    public final boolean startDragAndDrop(View view, DragAndDropTransferData transferData, ComposeDragShadowBuilder dragShadowBuilder) {
        return view.startDragAndDrop(transferData.getClipData(), dragShadowBuilder, transferData.getLocalState(), transferData.getFlags());
    }
}
