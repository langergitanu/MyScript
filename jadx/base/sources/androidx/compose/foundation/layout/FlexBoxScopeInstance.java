package androidx.compose.foundation.layout;

import androidx.compose.p004ui.Modifier;
import kotlin.Metadata;

/* JADX INFO: compiled from: FlexBox.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017¨\u0006\b"}, m1599d2 = {"Landroidx/compose/foundation/layout/FlexBoxScopeInstance;", "Landroidx/compose/foundation/layout/FlexBoxScope;", "<init>", "()V", "flex", "Landroidx/compose/ui/Modifier;", "flexConfig", "Landroidx/compose/foundation/layout/FlexConfig;", "foundation-layout"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class FlexBoxScopeInstance implements FlexBoxScope {
    public static final int $stable = 0;
    public static final FlexBoxScopeInstance INSTANCE = new FlexBoxScopeInstance();

    private FlexBoxScopeInstance() {
    }

    @Override // androidx.compose.foundation.layout.FlexBoxScope
    public Modifier flex(Modifier modifier, FlexConfig flexConfig) {
        return modifier.then(new FlexBoxChildElement(flexConfig));
    }
}
