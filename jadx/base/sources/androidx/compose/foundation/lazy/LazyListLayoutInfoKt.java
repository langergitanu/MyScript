package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: LazyListLayoutInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"visibleItemsAverageSize", "", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "calculateContentSize", "singleAxisViewportSize", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/LazyListLayoutInfo;)I", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class LazyListLayoutInfoKt {
    public static final int visibleItemsAverageSize(LazyListLayoutInfo lazyListLayoutInfo) {
        List<LazyListItemInfo> visibleItemsInfo = lazyListLayoutInfo.getVisibleItemsInfo();
        if (visibleItemsInfo.isEmpty()) {
            return 0;
        }
        int size = visibleItemsInfo.size();
        int size2 = 0;
        for (int i = 0; i < size; i++) {
            size2 += visibleItemsInfo.get(i).getSize();
        }
        return (size2 / visibleItemsInfo.size()) + lazyListLayoutInfo.getMainAxisItemSpacing();
    }

    public static final int calculateContentSize(LazyListLayoutInfo lazyListLayoutInfo) {
        int beforeContentPadding = lazyListLayoutInfo.getBeforeContentPadding() + lazyListLayoutInfo.getAfterContentPadding();
        return lazyListLayoutInfo.getTotalItemsCount() == 0 ? beforeContentPadding : ((visibleItemsAverageSize(lazyListLayoutInfo) - lazyListLayoutInfo.getMainAxisItemSpacing()) * lazyListLayoutInfo.getTotalItemsCount()) + ((lazyListLayoutInfo.getTotalItemsCount() - 1) * lazyListLayoutInfo.getMainAxisItemSpacing()) + beforeContentPadding;
    }

    public static final int getSingleAxisViewportSize(LazyListLayoutInfo lazyListLayoutInfo) {
        long jMo2995getViewportSizeYbymL2g;
        if (lazyListLayoutInfo.getOrientation() == Orientation.Vertical) {
            jMo2995getViewportSizeYbymL2g = lazyListLayoutInfo.mo2995getViewportSizeYbymL2g() & 4294967295L;
        } else {
            jMo2995getViewportSizeYbymL2g = lazyListLayoutInfo.mo2995getViewportSizeYbymL2g() >> 32;
        }
        return (int) jMo2995getViewportSizeYbymL2g;
    }
}
