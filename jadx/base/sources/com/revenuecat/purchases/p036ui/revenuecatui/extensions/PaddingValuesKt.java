package com.revenuecat.purchases.p036ui.revenuecatui.extensions;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaddingValues.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0000¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m1599d2 = {"calculateHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/foundation/layout/PaddingValues;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateVerticalPadding", "(Landroidx/compose/foundation/layout/PaddingValues;)F", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class PaddingValuesKt {
    public static final /* synthetic */ float calculateHorizontalPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(paddingValues, "<this>");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return C1486Dp.m11017constructorimpl(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) + PaddingKt.calculateEndPadding(paddingValues, layoutDirection));
    }

    public static final /* synthetic */ float calculateVerticalPadding(PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(paddingValues, "<this>");
        return C1486Dp.m11017constructorimpl(paddingValues.getTop() + paddingValues.getBottom());
    }
}
