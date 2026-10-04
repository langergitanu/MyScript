package androidx.compose.p004ui.node;

import androidx.compose.p004ui.Modifier;
import kotlin.Metadata;

/* JADX INFO: compiled from: LayoutNodeDrawScope.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, m1599d2 = {"nextDrawNode", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "ui"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class LayoutNodeDrawScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier.Node nextDrawNode(DelegatableNode delegatableNode) {
        int iM9943constructorimpl = NodeKind.m9943constructorimpl(4);
        int iM9943constructorimpl2 = NodeKind.m9943constructorimpl(2);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null || (child.getAggregateChildKindSet() & iM9943constructorimpl) == 0) {
            return null;
        }
        while (child != null && (child.getKindSet() & iM9943constructorimpl2) == 0) {
            if ((child.getKindSet() & iM9943constructorimpl) != 0) {
                return child;
            }
            child = child.getChild();
        }
        return null;
    }
}
