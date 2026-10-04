package androidx.compose.material;

import androidx.compose.p004ui.unit.C1486Dp;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u0014"}, m1599d2 = {"Landroidx/compose/material/TabPosition;", "", TtmlNode.LEFT, "Landroidx/compose/ui/unit/Dp;", "width", "<init>", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLeft-D9Ej5fM", "()F", "F", "getWidth-D9Ej5fM", TtmlNode.RIGHT, "getRight-D9Ej5fM", "equals", "", "other", "hashCode", "", "toString", "", "material"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TabPosition {
    public static final int $stable = 0;
    private final float left;
    private final float width;

    public /* synthetic */ TabPosition(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2);
    }

    private TabPosition(float f, float f2) {
        this.left = f;
        this.width = f2;
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
    public final float m4471getRightD9Ej5fM() {
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
        return C1486Dp.m11022equalsimpl0(this.left, tabPosition.left) && C1486Dp.m11022equalsimpl0(this.width, tabPosition.width);
    }

    public int hashCode() {
        return (C1486Dp.m11023hashCodeimpl(this.left) * 31) + C1486Dp.m11023hashCodeimpl(this.width);
    }

    public String toString() {
        return "TabPosition(left=" + ((Object) C1486Dp.m11028toStringimpl(this.left)) + ", right=" + ((Object) C1486Dp.m11028toStringimpl(m4471getRightD9Ej5fM())) + ", width=" + ((Object) C1486Dp.m11028toStringimpl(this.width)) + ')';
    }
}
