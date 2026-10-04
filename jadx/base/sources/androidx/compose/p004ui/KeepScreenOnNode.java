package androidx.compose.p004ui;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.node.DelegatableNodeKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: KeepScreenOn.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, m1599d2 = {"Landroidx/compose/ui/KeepScreenOnNode;", "Landroidx/compose/ui/Modifier$Node;", "<init>", "()V", "onAttach", "", "onDetach", "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class KeepScreenOnNode extends Modifier.Node {
    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        DelegatableNodeKt.requireOwner(this).incrementKeepScreenOnCount();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        DelegatableNodeKt.requireOwner(this).decrementKeepScreenOnCount();
    }
}
