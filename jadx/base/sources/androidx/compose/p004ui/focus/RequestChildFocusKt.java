package androidx.compose.p004ui.focus;

import androidx.compose.p004ui.node.DelegatableNode;
import androidx.compose.p004ui.node.DelegatableNodeKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;

/* JADX INFO: compiled from: RequestChildFocus.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, m1599d2 = {"requestFocusForChildInRootBounds", "", "Landroidx/compose/ui/node/DelegatableNode;", TtmlNode.LEFT, "", "top", TtmlNode.RIGHT, "bottom", "ui"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class RequestChildFocusKt {
    public static final boolean requestFocusForChildInRootBounds(DelegatableNode delegatableNode, int i, int i2, int i3, int i4) {
        FocusTargetModifierNode focusTargetModifierNodeFindFocusableNodeFromRect$ui = DelegatableNodeKt.requireOwner(delegatableNode).getRectManager().findFocusableNodeFromRect$ui(i, i2, i3, i4, DelegatableNodeKt.requireLayoutNode(delegatableNode).getSemanticsId());
        if (focusTargetModifierNodeFindFocusableNodeFromRect$ui != null) {
            return FocusTargetModifierNode.m7810requestFocus3ESFkO8$default(focusTargetModifierNodeFindFocusableNodeFromRect$ui, 0, 1, null);
        }
        return false;
    }
}
