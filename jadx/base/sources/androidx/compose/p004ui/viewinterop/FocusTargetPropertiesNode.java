package androidx.compose.p004ui.viewinterop;

import android.view.View;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.p004ui.focus.FocusProperties;
import androidx.compose.p004ui.focus.FocusPropertiesModifierNode;
import androidx.compose.p004ui.geometry.Rect;
import kotlin.Metadata;

/* JADX INFO: compiled from: FocusGroupNode.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m1599d2 = {"Landroidx/compose/ui/viewinterop/FocusTargetPropertiesNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "<init>", "()V", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class FocusTargetPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode {
    @Override // androidx.compose.p004ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(FocusProperties focusProperties) {
        Rect rectCalculateFocusRectRelativeTo;
        FocusTargetPropertiesNode focusTargetPropertiesNode = this;
        View embeddedView = FocusGroupNode_androidKt.getEmbeddedView(focusTargetPropertiesNode);
        focusProperties.setCanFocus(getNode().getIsAttached() && FocusGroupNode_androidKt.getEmbeddedView(focusTargetPropertiesNode).hasFocusable());
        View viewFindFocus = embeddedView.findFocus();
        if (viewFindFocus == null || (rectCalculateFocusRectRelativeTo = FocusInteropUtils_androidKt.calculateFocusRectRelativeTo(viewFindFocus, embeddedView)) == null) {
            return;
        }
        focusProperties.setFocusRect(rectCalculateFocusRectRelativeTo);
    }
}
