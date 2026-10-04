package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.Modifier;
import kotlin.Metadata;

/* JADX INFO: compiled from: LayoutBoundsHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, m1599d2 = {"layoutBounds", "Landroidx/compose/ui/Modifier;", "holder", "Landroidx/compose/ui/layout/LayoutBoundsHolder;", "ui"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class LayoutBoundsHolderKt {
    public static final Modifier layoutBounds(Modifier modifier, LayoutBoundsHolder layoutBoundsHolder) {
        return modifier.then(new LayoutBoundsElement(layoutBoundsHolder));
    }
}
