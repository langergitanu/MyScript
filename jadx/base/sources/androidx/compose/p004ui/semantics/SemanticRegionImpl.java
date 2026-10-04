package androidx.compose.p004ui.semantics;

import android.graphics.Region;
import androidx.compose.p004ui.graphics.RectHelper_androidKt;
import androidx.compose.p004ui.unit.IntRect;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SemanticsRegion.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0001H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0014"}, m1599d2 = {"Landroidx/compose/ui/semantics/SemanticRegionImpl;", "Landroidx/compose/ui/semantics/SemanticsRegion;", "<init>", "()V", TtmlNode.TAG_REGION, "Landroid/graphics/Region;", "getRegion", "()Landroid/graphics/Region;", "set", "", "rect", "Landroidx/compose/ui/unit/IntRect;", "bounds", "getBounds", "()Landroidx/compose/ui/unit/IntRect;", "isEmpty", "", "()Z", "intersect", "difference", "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class SemanticRegionImpl implements SemanticsRegion {
    private final Region region = new Region();

    public final Region getRegion() {
        return this.region;
    }

    @Override // androidx.compose.p004ui.semantics.SemanticsRegion
    public void set(IntRect rect) {
        this.region.set(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
    }

    @Override // androidx.compose.p004ui.semantics.SemanticsRegion
    public IntRect getBounds() {
        return RectHelper_androidKt.toComposeIntRect(this.region.getBounds());
    }

    @Override // androidx.compose.p004ui.semantics.SemanticsRegion
    public boolean isEmpty() {
        return this.region.isEmpty();
    }

    @Override // androidx.compose.p004ui.semantics.SemanticsRegion
    public boolean intersect(SemanticsRegion region) {
        Region region2 = this.region;
        Intrinsics.checkNotNull(region, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticRegionImpl");
        return region2.op(((SemanticRegionImpl) region).region, Region.Op.INTERSECT);
    }

    @Override // androidx.compose.p004ui.semantics.SemanticsRegion
    public boolean difference(IntRect rect) {
        return this.region.op(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), Region.Op.DIFFERENCE);
    }
}
