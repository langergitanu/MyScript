package androidx.compose.material3;

import androidx.compose.p004ui.unit.C1486Dp;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\t¨\u0006\u0016"}, m1599d2 = {"Landroidx/compose/material3/TabPosition;", "", TtmlNode.LEFT, "Landroidx/compose/ui/unit/Dp;", "width", "contentWidth", "<init>", "(FFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLeft-D9Ej5fM", "()F", "F", "getWidth-D9Ej5fM", "getContentWidth-D9Ej5fM", TtmlNode.RIGHT, "getRight-D9Ej5fM", "equals", "", "other", "hashCode", "", "toString", "", "material3"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class TabPosition {
    public static final int $stable = 0;
    private final float contentWidth;
    private final float left;
    private final float width;

    public /* synthetic */ TabPosition(float f, float f2, float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3);
    }

    private TabPosition(float f, float f2, float f3) {
        this.left = f;
        this.width = f2;
        this.contentWidth = f3;
    }

    /* JADX INFO: renamed from: getContentWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getContentWidth() {
        return this.contentWidth;
    }

    /* JADX INFO: renamed from: getLeft-D9Ej5fM, reason: not valid java name and from getter */
    public final float getLeft() {
        return this.left;
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: getRight-D9Ej5fM, reason: not valid java name */
    public final float m5743getRightD9Ej5fM() {
        return C1486Dp.m11017constructorimpl(this.left + this.width);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TabPosition)) {
            return false;
        }
        TabPosition tabPosition = (TabPosition) other;
        return C1486Dp.m11022equalsimpl0(this.left, tabPosition.left) && C1486Dp.m11022equalsimpl0(this.width, tabPosition.width) && C1486Dp.m11022equalsimpl0(this.contentWidth, tabPosition.contentWidth);
    }

    public int hashCode() {
        return (((C1486Dp.m11023hashCodeimpl(this.left) * 31) + C1486Dp.m11023hashCodeimpl(this.width)) * 31) + C1486Dp.m11023hashCodeimpl(this.contentWidth);
    }

    public String toString() {
        return "TabPosition(left=" + ((Object) C1486Dp.m11028toStringimpl(this.left)) + ", right=" + ((Object) C1486Dp.m11028toStringimpl(m5743getRightD9Ej5fM())) + ", width=" + ((Object) C1486Dp.m11028toStringimpl(this.width)) + ", contentWidth=" + ((Object) C1486Dp.m11028toStringimpl(this.contentWidth)) + ')';
    }
}
