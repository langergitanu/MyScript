package androidx.compose.foundation;

import androidx.compose.p004ui.focus.FocusTargetModifierNodeKt;
import androidx.compose.p004ui.focus.Focusability;
import androidx.compose.p004ui.node.DelegatingNode;
import kotlin.Metadata;

/* JADX INFO: compiled from: Focusable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Landroidx/compose/foundation/FocusGroupNode;", "Landroidx/compose/ui/node/DelegatingNode;", "<init>", "()V", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class FocusGroupNode extends DelegatingNode {
    public FocusGroupNode() {
        delegate(FocusTargetModifierNodeKt.m7815FocusTargetModifierNodePYyLHbc$default(Focusability.INSTANCE.m7838getNeverLCbbffg(), null, 2, null));
    }
}
