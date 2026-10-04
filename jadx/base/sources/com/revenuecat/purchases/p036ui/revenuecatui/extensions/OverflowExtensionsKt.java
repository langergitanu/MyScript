package com.revenuecat.purchases.p036ui.revenuecatui.extensions;

import androidx.compose.foundation.gestures.Orientation;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OverflowExtensions.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, m1599d2 = {"toOrientation", "Landroidx/compose/foundation/gestures/Orientation;", "Lcom/revenuecat/purchases/paywalls/components/StackComponent$Overflow;", TypedValues.Custom.S_DIMENSION, "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class OverflowExtensionsKt {

    /* JADX INFO: compiled from: OverflowExtensions.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StackComponent.Overflow.values().length];
            try {
                iArr[StackComponent.Overflow.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StackComponent.Overflow.SCROLL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ Orientation toOrientation(StackComponent.Overflow overflow, Dimension dimension) {
        Intrinsics.checkNotNullParameter(overflow, "<this>");
        Intrinsics.checkNotNullParameter(dimension, "dimension");
        int i = WhenMappings.$EnumSwitchMapping$0[overflow.ordinal()];
        if (i == 1) {
            return null;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (dimension instanceof Dimension.Horizontal) {
            return Orientation.Horizontal;
        }
        if (dimension instanceof Dimension.Vertical) {
            return Orientation.Vertical;
        }
        if (dimension instanceof Dimension.ZLayer) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
