package androidx.constraintlayout.compose;

import androidx.compose.p004ui.unit.C1486Dp;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import kotlin.Metadata;

/* JADX INFO: compiled from: ConstraintScopeCommon.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H&ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H&ø\u0001\u0000¢\u0006\u0004\b\t\u0010\fø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0003"}, m1599d2 = {"Landroidx/constraintlayout/compose/BaselineAnchorable;", "", "linkTo", "", "anchor", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$BaselineAnchor;", "margin", "Landroidx/compose/ui/unit/Dp;", "goneMargin", "linkTo-VpY3zN4", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$BaselineAnchor;FF)V", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;FF)V", "constraintlayout-compose_release"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface BaselineAnchorable {
    /* JADX INFO: renamed from: linkTo-VpY3zN4, reason: not valid java name */
    void mo11282linkToVpY3zN4(ConstraintLayoutBaseScope.BaselineAnchor anchor, float margin, float goneMargin);

    /* JADX INFO: renamed from: linkTo-VpY3zN4, reason: not valid java name */
    void mo11283linkToVpY3zN4(ConstraintLayoutBaseScope.HorizontalAnchor anchor, float margin, float goneMargin);

    /* JADX INFO: compiled from: ConstraintScopeCommon.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX INFO: renamed from: linkTo-VpY3zN4$default, reason: not valid java name */
    static /* synthetic */ void m11280linkToVpY3zN4$default(BaselineAnchorable baselineAnchorable, ConstraintLayoutBaseScope.BaselineAnchor baselineAnchor, float f, float f2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: linkTo-VpY3zN4");
        }
        if ((i & 2) != 0) {
            f = C1486Dp.m11017constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f2 = C1486Dp.m11017constructorimpl(0);
        }
        baselineAnchorable.mo11282linkToVpY3zN4(baselineAnchor, f, f2);
    }

    /* JADX INFO: renamed from: linkTo-VpY3zN4$default, reason: not valid java name */
    static /* synthetic */ void m11281linkToVpY3zN4$default(BaselineAnchorable baselineAnchorable, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, float f, float f2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: linkTo-VpY3zN4");
        }
        if ((i & 2) != 0) {
            f = C1486Dp.m11017constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f2 = C1486Dp.m11017constructorimpl(0);
        }
        baselineAnchorable.mo11283linkToVpY3zN4(horizontalAnchor, f, f2);
    }
}
