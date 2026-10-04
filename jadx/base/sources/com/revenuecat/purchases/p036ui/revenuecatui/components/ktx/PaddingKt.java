package com.revenuecat.purchases.p036ui.revenuecatui.components.ktx;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p004ui.unit.C1486Dp;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Padding.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, m1599d2 = {"toPaddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "warnIfNegative", "", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class PaddingKt {
    public static /* synthetic */ PaddingValues toPaddingValues$default(Padding padding, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return toPaddingValues(padding, z);
    }

    public static final /* synthetic */ PaddingValues toPaddingValues(Padding padding, boolean z) {
        Intrinsics.checkNotNullParameter(padding, "<this>");
        if (z && ComparisonsKt.minOf(padding.getTop(), padding.getBottom(), padding.getLeading(), padding.getTrailing()) < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            Logger.INSTANCE.m1587w("Received negative padding/margin value(s) (top=" + padding.getTop() + ", bottom=" + padding.getBottom() + ", leading=" + padding.getLeading() + ", trailing=" + padding.getTrailing() + "). Negative padding/margin is not supported on Android; clamping to 0.");
        }
        return androidx.compose.foundation.layout.PaddingKt.m2850PaddingValuesa9UjIt4(C1486Dp.m11017constructorimpl((float) RangesKt.coerceAtLeast(padding.getLeading(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)), C1486Dp.m11017constructorimpl((float) RangesKt.coerceAtLeast(padding.getTop(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)), C1486Dp.m11017constructorimpl((float) RangesKt.coerceAtLeast(padding.getTrailing(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)), C1486Dp.m11017constructorimpl((float) RangesKt.coerceAtLeast(padding.getBottom(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)));
    }
}
