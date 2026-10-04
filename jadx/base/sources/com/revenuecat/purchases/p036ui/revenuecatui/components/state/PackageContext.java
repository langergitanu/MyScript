package com.revenuecat.purchases.p036ui.revenuecatui.components.state;

import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResolvedOffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: PackageContext.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001dÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageContext;", "", "offerEligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "getOfferEligibility", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "packageUniqueId", "", "getPackageUniqueId", "()Ljava/lang/String;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "getResolvedOffer", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "tabIndex", "", "getTabIndex", "()Ljava/lang/Integer;", "computeIsSelected", "", "selectedPackageInfo", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "selectedTabIndex", "resolveOfferEligibility", "selectedOfferEligibility", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface PackageContext {
    OfferEligibility getOfferEligibility();

    Package getRcPackage();

    ResolvedOffer getResolvedOffer();

    Integer getTabIndex();

    /* JADX INFO: compiled from: PackageContext.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static String getPackageUniqueId(PackageContext packageContext) {
            return PackageContext.super.getPackageUniqueId();
        }

        @Deprecated
        public static /* synthetic */ OfferEligibility resolveOfferEligibility(PackageContext packageContext, OfferEligibility selectedOfferEligibility) {
            Intrinsics.checkNotNullParameter(selectedOfferEligibility, "selectedOfferEligibility");
            return PackageContext.super.resolveOfferEligibility(selectedOfferEligibility);
        }
    }

    default String getPackageUniqueId() {
        SubscriptionOption option;
        Package rcPackage = getRcPackage();
        String str = null;
        if (rcPackage == null) {
            return null;
        }
        ResolvedOffer resolvedOffer = getResolvedOffer();
        ResolvedOffer.ConfiguredOffer configuredOffer = resolvedOffer instanceof ResolvedOffer.ConfiguredOffer ? (ResolvedOffer.ConfiguredOffer) resolvedOffer : null;
        if (configuredOffer != null && (option = configuredOffer.getOption()) != null) {
            str = option.get$id();
        }
        return str != null ? rcPackage.getIdentifier() + AbstractJsonLexerKt.COLON + str : rcPackage.getIdentifier();
    }

    /* synthetic */ default boolean computeIsSelected(PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, int selectedTabIndex) {
        Package rcPackage;
        String packageUniqueId = getPackageUniqueId();
        Package rcPackage2 = getRcPackage();
        Integer tabIndex = getTabIndex();
        if (packageUniqueId != null) {
            return Intrinsics.areEqual(packageUniqueId, selectedPackageInfo != null ? selectedPackageInfo.getUniqueId() : null);
        }
        if (rcPackage2 == null) {
            return tabIndex != null && tabIndex.intValue() == selectedTabIndex;
        }
        String identifier = rcPackage2.getIdentifier();
        if (selectedPackageInfo != null && (rcPackage = selectedPackageInfo.getRcPackage()) != null) {
            identifier = rcPackage.getIdentifier();
        }
        return Intrinsics.areEqual(identifier, identifier);
    }

    /* synthetic */ default OfferEligibility resolveOfferEligibility(OfferEligibility selectedOfferEligibility) {
        Intrinsics.checkNotNullParameter(selectedOfferEligibility, "selectedOfferEligibility");
        OfferEligibility offerEligibility = getOfferEligibility();
        return offerEligibility == null ? selectedOfferEligibility : offerEligibility;
    }
}
