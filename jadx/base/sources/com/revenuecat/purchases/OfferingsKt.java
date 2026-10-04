package com.revenuecat.purchases;

import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PresentedOfferingContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Offerings.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"withPresentedContext", "Lcom/revenuecat/purchases/Offering;", "placementId", "", "targeting", "Lcom/revenuecat/purchases/Offerings$Targeting;", "purchases_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class OfferingsKt {
    public static final Offering withPresentedContext(Offering offering, String str, Offerings.Targeting targeting) {
        PresentedOfferingContext.TargetingContext targetingContext;
        Intrinsics.checkNotNullParameter(offering, "<this>");
        List<Package> availablePackages = offering.getAvailablePackages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(availablePackages, 10));
        for (Package r3 : availablePackages) {
            PresentedOfferingContext presentedOfferingContext = r3.getPresentedOfferingContext();
            String placementIdentifier = str == null ? presentedOfferingContext.getPlacementIdentifier() : str;
            if (targeting != null) {
                targetingContext = new PresentedOfferingContext.TargetingContext(targeting.getRevision(), targeting.getRuleId());
            } else {
                targetingContext = presentedOfferingContext.getTargetingContext();
            }
            PresentedOfferingContext presentedOfferingContextCopy$default = PresentedOfferingContext.copy$default(presentedOfferingContext, null, placementIdentifier, targetingContext, 1, null);
            arrayList.add(new Package(r3.getIdentifier(), r3.getPackageType(), r3.getProduct().copyWithPresentedOfferingContext(presentedOfferingContextCopy$default), presentedOfferingContextCopy$default, r3.getWebCheckoutURL()));
        }
        Offering offering2 = new Offering(offering.getIdentifier(), offering.getServerDescription(), offering.getMetadata(), arrayList, offering.getPaywall(), offering.getPaywallComponents(), offering.getWebCheckoutURL());
        offering2.setHasPaywallComponents$purchases_defaultsRelease(offering.getHasPaywallComponents());
        return offering2;
    }
}
