package androidx.compose.material3.adaptive;

import androidx.compose.p004ui.unit.C1486Dp;
import androidx.webkit.Profile;
import androidx.window.core.layout.WindowSizeClass;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: WindowSizeClassHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m1599d2 = {"Landroidx/compose/material3/adaptive/DpHeightSizeClasses;", "", "<init>", "()V", "Compact", "Landroidx/compose/ui/unit/Dp;", "getCompact-D9Ej5fM", "()F", "F", "Medium", "getMedium-D9Ej5fM", "Expanded", "getExpanded-D9Ej5fM", Profile.DEFAULT_PROFILE_NAME, "", "getDefault", "()Ljava/util/Set;", "adaptive"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
final class DpHeightSizeClasses {
    private static final float Compact;
    private static final Set<C1486Dp> Default;
    private static final float Expanded;
    public static final DpHeightSizeClasses INSTANCE = new DpHeightSizeClasses();
    private static final float Medium;

    private DpHeightSizeClasses() {
    }

    /* JADX INFO: renamed from: getCompact-D9Ej5fM, reason: not valid java name */
    public final float m6151getCompactD9Ej5fM() {
        return Compact;
    }

    /* JADX INFO: renamed from: getMedium-D9Ej5fM, reason: not valid java name */
    public final float m6153getMediumD9Ej5fM() {
        return Medium;
    }

    /* JADX INFO: renamed from: getExpanded-D9Ej5fM, reason: not valid java name */
    public final float m6152getExpandedD9Ej5fM() {
        return Expanded;
    }

    public final Set<C1486Dp> getDefault() {
        return Default;
    }

    static {
        float fM11017constructorimpl = C1486Dp.m11017constructorimpl(0);
        Compact = fM11017constructorimpl;
        float fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
        Medium = fM11017constructorimpl2;
        float fM11017constructorimpl3 = C1486Dp.m11017constructorimpl(900);
        Expanded = fM11017constructorimpl3;
        Default = SetsKt.setOf((Object[]) new C1486Dp[]{C1486Dp.m11015boximpl(fM11017constructorimpl), C1486Dp.m11015boximpl(fM11017constructorimpl2), C1486Dp.m11015boximpl(fM11017constructorimpl3)});
    }
}
