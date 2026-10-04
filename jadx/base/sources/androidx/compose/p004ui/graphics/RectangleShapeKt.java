package androidx.compose.p004ui.graphics;

import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.p004ui.graphics.Outline;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import kotlin.Metadata;

/* JADX INFO: compiled from: RectangleShape.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001c\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"RectangleShape", "Landroidx/compose/ui/graphics/Shape;", "getRectangleShape$annotations", "()V", "getRectangleShape", "()Landroidx/compose/ui/graphics/Shape;", "ui-graphics"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class RectangleShapeKt {
    private static final Shape RectangleShape = new Shape() { // from class: androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1
        @Override // androidx.compose.p004ui.graphics.Shape
        /* JADX INFO: renamed from: createOutline-Pq9zytI */
        public Outline.Rectangle mo2085createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
            return new Outline.Rectangle(SizeKt.m7993toRectuvyYCjk(size));
        }

        public String toString() {
            return "RectangleShape";
        }
    };

    public static /* synthetic */ void getRectangleShape$annotations() {
    }

    public static final Shape getRectangleShape() {
        return RectangleShape;
    }
}
