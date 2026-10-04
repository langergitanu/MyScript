package androidx.compose.p004ui.spatial;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.node.DelegatableNode;
import androidx.compose.p004ui.node.DelegatableNodeKt;
import androidx.compose.p004ui.node.LayoutNode;
import androidx.compose.p004ui.node.NodeCoordinator;
import androidx.compose.p004ui.node.NodeKind;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntOffsetKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: ThrottledCallbacks.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"rectInfoFor", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "node", "Landroidx/compose/ui/node/DelegatableNode;", "topLeft", "", "bottomRight", "windowOffset", "Landroidx/compose/ui/unit/IntOffset;", "screenOffset", "windowSize", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "rectInfoFor-Dg36KO4", "(Landroidx/compose/ui/node/DelegatableNode;JJJJJ[F)Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "ui"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ThrottledCallbacksKt {
    /* JADX INFO: renamed from: rectInfoFor-Dg36KO4, reason: not valid java name */
    public static final RelativeLayoutBounds m10236rectInfoForDg36KO4(DelegatableNode delegatableNode, long j, long j2, long j3, long j4, long j5, float[] fArr) {
        NodeCoordinator nodeCoordinatorM9797requireCoordinator64DMado = DelegatableNodeKt.m9797requireCoordinator64DMado(delegatableNode, NodeKind.m9943constructorimpl(2));
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        if (!layoutNodeRequireLayoutNode.isPlaced()) {
            return null;
        }
        if (layoutNodeRequireLayoutNode.getOuterCoordinator$ui() != nodeCoordinatorM9797requireCoordinator64DMado) {
            long jM11139constructorimpl = IntOffset.m11139constructorimpl(j);
            long jM7895constructorimpl = Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(IntOffset.m11145getXimpl(jM11139constructorimpl))) << 32) | (((long) Float.floatToRawIntBits(IntOffset.m11146getYimpl(jM11139constructorimpl))) & 4294967295L));
            long jMo9633getSizeYbymL2g = nodeCoordinatorM9797requireCoordinator64DMado.getCoordinates().mo9633getSizeYbymL2g();
            long jM11162roundk4lQ0M = IntOffsetKt.m11162roundk4lQ0M(layoutNodeRequireLayoutNode.getOuterCoordinator$ui().getCoordinates().mo9634localPositionOfR5De75A(nodeCoordinatorM9797requireCoordinator64DMado, jM7895constructorimpl));
            return new RelativeLayoutBounds(jM11162roundk4lQ0M, IntOffset.m11139constructorimpl((((long) (IntOffset.m11145getXimpl(jM11162roundk4lQ0M) + ((int) (jMo9633getSizeYbymL2g >> 32)))) << 32) | (((long) (IntOffset.m11146getYimpl(jM11162roundk4lQ0M) + ((int) (jMo9633getSizeYbymL2g & 4294967295L)))) & 4294967295L)), j3, j4, j5, fArr, delegatableNode, null);
        }
        return new RelativeLayoutBounds(j, j2, j3, j4, j5, fArr, delegatableNode, null);
    }
}
