package androidx.compose.material3.tokens;

import androidx.compose.p004ui.unit.C1486Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: LoadingIndicatorTokens.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000bR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u0019"}, m1599d2 = {"Landroidx/compose/material3/tokens/LoadingIndicatorTokens;", "", "<init>", "()V", "ActiveIndicatorColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getActiveIndicatorColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActiveSize", "Landroidx/compose/ui/unit/Dp;", "getActiveSize-D9Ej5fM", "()F", "F", "ContainedActiveColor", "getContainedActiveColor", "ContainedContainerColor", "getContainedContainerColor", "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ContainerWidth", "getContainerWidth-D9Ej5fM", "material3"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class LoadingIndicatorTokens {
    public static final int $stable = 0;
    private static final float ContainerHeight;
    private static final float ContainerWidth;
    public static final LoadingIndicatorTokens INSTANCE = new LoadingIndicatorTokens();
    private static final ColorSchemeKeyTokens ActiveIndicatorColor = ColorSchemeKeyTokens.Primary;
    private static final float ActiveSize = C1486Dp.m11017constructorimpl((float) 38.0d);
    private static final ColorSchemeKeyTokens ContainedActiveColor = ColorSchemeKeyTokens.OnPrimaryContainer;
    private static final ColorSchemeKeyTokens ContainedContainerColor = ColorSchemeKeyTokens.PrimaryContainer;
    private static final ShapeKeyTokens ContainerShape = ShapeKeyTokens.CornerFull;

    private LoadingIndicatorTokens() {
    }

    static {
        float f = (float) 48.0d;
        ContainerHeight = C1486Dp.m11017constructorimpl(f);
        ContainerWidth = C1486Dp.m11017constructorimpl(f);
    }

    public final ColorSchemeKeyTokens getActiveIndicatorColor() {
        return ActiveIndicatorColor;
    }

    /* JADX INFO: renamed from: getActiveSize-D9Ej5fM, reason: not valid java name */
    public final float m6763getActiveSizeD9Ej5fM() {
        return ActiveSize;
    }

    public final ColorSchemeKeyTokens getContainedActiveColor() {
        return ContainedActiveColor;
    }

    public final ColorSchemeKeyTokens getContainedContainerColor() {
        return ContainedContainerColor;
    }

    /* JADX INFO: renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m6764getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    /* JADX INFO: renamed from: getContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m6765getContainerWidthD9Ej5fM() {
        return ContainerWidth;
    }
}
