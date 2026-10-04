package androidx.compose.foundation.gestures;

import android.view.ViewConfiguration;
import androidx.compose.p004ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.p004ui.node.DelegatableNode_androidKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidScrollable.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, m1599d2 = {"platformScrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AndroidScrollable_androidKt {
    public static final ScrollConfig platformScrollConfig(CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode) {
        return new AndroidConfig(ViewConfiguration.get(DelegatableNode_androidKt.requireView(compositionLocalConsumerModifierNode).getContext()));
    }
}
