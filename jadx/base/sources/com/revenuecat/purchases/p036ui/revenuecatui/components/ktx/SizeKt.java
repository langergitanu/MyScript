package com.revenuecat.purchases.p036ui.revenuecatui.components.ktx;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p004ui.unit.LayoutDirection;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.PaddingValuesKt;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, m1599d2 = {"addMargin", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "margin", "Landroidx/compose/foundation/layout/PaddingValues;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;", "Lkotlin/UInt;", "addMargin-Qn1smSk", "(Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;I)Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class SizeKt {
    public static final /* synthetic */ Size addMargin(Size size, PaddingValues margin, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(size, "<this>");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return new Size(m13909addMarginQn1smSk(size.getWidth(), UnsignedKt.doubleToUInt(PaddingValuesKt.calculateHorizontalPadding(margin, layoutDirection))), m13909addMarginQn1smSk(size.getHeight(), UnsignedKt.doubleToUInt(PaddingValuesKt.calculateVerticalPadding(margin))));
    }

    /* JADX INFO: renamed from: addMargin-Qn1smSk, reason: not valid java name */
    private static final SizeConstraint m13909addMarginQn1smSk(SizeConstraint sizeConstraint, int i) {
        if (sizeConstraint instanceof SizeConstraint.Fixed) {
            return new SizeConstraint.Fixed(UInt.m14594constructorimpl(((SizeConstraint.Fixed) sizeConstraint).getValue() + i), null);
        }
        if (sizeConstraint instanceof SizeConstraint.Fill ? true : sizeConstraint instanceof SizeConstraint.Fit) {
            return sizeConstraint;
        }
        throw new NoWhenBranchMatchedException();
    }
}
