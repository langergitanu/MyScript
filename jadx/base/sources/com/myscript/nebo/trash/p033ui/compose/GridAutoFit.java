package com.myscript.nebo.trash.p033ui.compose;

import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GridAutoFit.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016J\n\u0010\r\u001a\u00020\tH\u0096\u0080\u0004J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0082\u0004R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/trash/ui/compose/GridAutoFit;", "Landroidx/compose/foundation/lazy/grid/GridCells;", "minSize", "Landroidx/compose/ui/unit/Dp;", "<init>", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "calculateCrossAxisCellSizes", "", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "hashCode", "equals", "", "other", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GridAutoFit implements GridCells {
    public static final int $stable = 0;
    private final float minSize;

    public /* synthetic */ GridAutoFit(float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(f);
    }

    private GridAutoFit(float f) {
        this.minSize = f;
        if (C1486Dp.m11016compareTo0680j_4(f, C1486Dp.m11017constructorimpl(0)) > 0) {
            return;
        }
        throw new IllegalArgumentException(("Provided min size " + C1486Dp.m11028toStringimpl(f) + " should be larger than zero.").toString());
    }

    @Override // androidx.compose.foundation.lazy.grid.GridCells
    public List<Integer> calculateCrossAxisCellSizes(Density density, int i, int i2) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        return GridAutoFitKt.calculateCellsCrossAxisSizeImpl(i, ((i + i2) / (density.mo2185roundToPx0680j_4(this.minSize) + i2)) + 1, i2);
    }

    public int hashCode() {
        return C1486Dp.m11023hashCodeimpl(this.minSize);
    }

    public boolean equals(Object other) {
        return (other instanceof GridAutoFit) && C1486Dp.m11022equalsimpl0(this.minSize, ((GridAutoFit) other).minSize);
    }
}
