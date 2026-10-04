package androidx.compose.p004ui.node;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;

/* JADX INFO: compiled from: DrawModifierNode.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1599d2 = {"invalidateDraw", "", "Landroidx/compose/ui/node/DrawModifierNode;", "dispatchDraw", "Landroidx/compose/ui/node/DelegatableNode;", "scope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DrawModifierNodeKt {
    public static final void invalidateDraw(DrawModifierNode drawModifierNode) {
        if (drawModifierNode.getNode().getIsAttached()) {
            DelegatableNodeKt.m9797requireCoordinator64DMado(drawModifierNode, NodeKind.m9943constructorimpl(1)).invalidateLayer();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v7 */
    public static final void dispatchDraw(DelegatableNode delegatableNode, ContentDrawScope contentDrawScope) {
        Modifier.Node node = delegatableNode.getNode();
        int iM9943constructorimpl = NodeKind.m9943constructorimpl(4);
        MutableVector mutableVector = null;
        while (node != 0) {
            if (node instanceof DrawModifierNode) {
                ((DrawModifierNode) node).draw(contentDrawScope);
            } else if ((node.getKindSet() & iM9943constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                Modifier.Node delegate = ((DelegatingNode) node).getDelegate();
                int i = 0;
                node = node;
                while (delegate != null) {
                    if ((delegate.getKindSet() & iM9943constructorimpl) != 0) {
                        i++;
                        if (i == 1) {
                            node = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != 0) {
                                if (mutableVector != null) {
                                    mutableVector.add(node);
                                }
                                node = 0;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate);
                            }
                        }
                    }
                    delegate = delegate.getChild();
                    node = node;
                }
                if (i == 1) {
                }
            }
            node = DelegatableNodeKt.pop(mutableVector);
        }
    }
}
