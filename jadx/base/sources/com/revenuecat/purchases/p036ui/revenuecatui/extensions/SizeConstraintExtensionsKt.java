package com.revenuecat.purchases.p036ui.revenuecatui.extensions;

import androidx.compose.p004ui.unit.C1486Dp;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SizeConstraintExtensions.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, m1599d2 = {"dpOrNull", "Landroidx/compose/ui/unit/Dp;", "Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class SizeConstraintExtensionsKt {
    public static final /* synthetic */ C1486Dp dpOrNull(SizeConstraint sizeConstraint) {
        Intrinsics.checkNotNullParameter(sizeConstraint, "<this>");
        if (!(sizeConstraint instanceof SizeConstraint.Fixed)) {
            if ((sizeConstraint instanceof SizeConstraint.Fill) || (sizeConstraint instanceof SizeConstraint.Fit)) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
        return C1486Dp.m11015boximpl(C1486Dp.m11017constructorimpl(((SizeConstraint.Fixed) sizeConstraint).getValue()));
    }
}
