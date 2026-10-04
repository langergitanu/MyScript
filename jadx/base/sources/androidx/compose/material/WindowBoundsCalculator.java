package androidx.compose.material;

import android.view.View;
import androidx.compose.p004ui.unit.IntRect;
import kotlin.Metadata;

/* JADX INFO: compiled from: ExposedDropdownMenu.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"Landroidx/compose/material/WindowBoundsCalculator;", "", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getVisibleWindowBounds", "Landroidx/compose/ui/unit/IntRect;", "material"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class WindowBoundsCalculator {
    public static final int $stable = 8;
    private final View view;

    public WindowBoundsCalculator(View view) {
        this.view = view;
    }

    public final IntRect getVisibleWindowBounds() {
        return ExposedDropdownMenu_android.getWindowBounds(this.view);
    }
}
