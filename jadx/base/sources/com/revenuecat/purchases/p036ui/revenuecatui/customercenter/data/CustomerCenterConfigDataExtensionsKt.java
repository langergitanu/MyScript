package com.revenuecat.purchases.p036ui.revenuecatui.customercenter.data;

import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.paywalls.PaywallColor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomerCenterConfigDataExtensions.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0018\u00010\bj\u0004\u0018\u0001`\t0\u0006H\u0000¨\u0006\n"}, m1599d2 = {"getColorForTheme", "Landroidx/compose/ui/graphics/Color;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;", "isDark", "", "selector", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance$ColorInformation;", "Lcom/revenuecat/purchases/paywalls/PaywallColor;", "Lcom/revenuecat/purchases/customercenter/RCColor;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class CustomerCenterConfigDataExtensionsKt {
    public static final /* synthetic */ Color getColorForTheme(CustomerCenterConfigData.Appearance appearance, boolean z, Function1 selector) {
        PaywallColor paywallColor;
        Intrinsics.checkNotNullParameter(appearance, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        CustomerCenterConfigData.Appearance.ColorInformation dark = z ? appearance.getDark() : appearance.getLight();
        if (dark == null || (paywallColor = (PaywallColor) selector.invoke(dark)) == null) {
            return null;
        }
        return Color.m8138boximpl(ColorKt.Color(paywallColor.getColorInt()));
    }
}
