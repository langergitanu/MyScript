package com.revenuecat.purchases.p036ui.revenuecatui.components.ktx;

import androidx.compose.p004ui.layout.ContentScale;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FitMode.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, m1599d2 = {"toContentScale", "Landroidx/compose/ui/layout/ContentScale;", "Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class FitModeKt {

    /* JADX INFO: compiled from: FitMode.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FitMode.values().length];
            try {
                iArr[FitMode.FIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FitMode.FILL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ ContentScale toContentScale(FitMode fitMode) {
        Intrinsics.checkNotNullParameter(fitMode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[fitMode.ordinal()];
        if (i == 1) {
            return ContentScale.INSTANCE.getFit();
        }
        if (i == 2) {
            return ContentScale.INSTANCE.getCrop();
        }
        throw new NoWhenBranchMatchedException();
    }
}
