package androidx.compose.p004ui.platform;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.node.SemanticsModifierNode;
import androidx.compose.p004ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p004ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;

/* JADX INFO: compiled from: TestTag.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\r"}, m1599d2 = {"Landroidx/compose/ui/platform/TestTagNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "tag", "", "<init>", "(Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "setTag", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class TestTagNode extends Modifier.Node implements SemanticsModifierNode {
    private String tag;

    public TestTagNode(String str) {
        this.tag = str;
    }

    public final String getTag() {
        return this.tag;
    }

    public final void setTag(String str) {
        this.tag = str;
    }

    @Override // androidx.compose.p004ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTestTag(semanticsPropertyReceiver, this.tag);
    }
}
