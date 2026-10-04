package androidx.compose.p004ui.text;

import androidx.compose.p004ui.geometry.CornerRadius;
import androidx.compose.p004ui.geometry.RoundRectKt;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.p004ui.graphics.Outline;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import kotlin.Metadata;

/* JADX INFO: compiled from: Bullet.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, m1599d2 = {"Landroidx/compose/ui/text/CircleShape;", "Landroidx/compose/ui/graphics/Shape;", "<init>", "()V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "ui-text"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class CircleShape implements Shape {
    public static final CircleShape INSTANCE = new CircleShape();

    private CircleShape() {
    }

    @Override // androidx.compose.p004ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public Outline mo2085createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
        float fM7971getMinDimensionimpl = Size.m7971getMinDimensionimpl(size) / 2.0f;
        long jM7857constructorimpl = CornerRadius.m7857constructorimpl((((long) Float.floatToRawIntBits(fM7971getMinDimensionimpl)) & 4294967295L) | (Float.floatToRawIntBits(fM7971getMinDimensionimpl) << 32));
        return new Outline.Rounded(RoundRectKt.m7955RoundRectZAM2FJo(SizeKt.m7993toRectuvyYCjk(size), jM7857constructorimpl, jM7857constructorimpl, jM7857constructorimpl, jM7857constructorimpl));
    }
}
