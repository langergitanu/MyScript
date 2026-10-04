package com.revenuecat.purchases.p036ui.revenuecatui.helpers;

import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.GoogleSubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResolvedOffer;
import com.revenuecat.purchases.paywalls.components.common.PromoOfferConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PromoOfferResolver.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e¨\u0006\u000f"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PromoOfferResolver;", "", "()V", "findOfferById", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "subscriptionOptions", "", "offerId", "", "resolve", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "offerConfig", "Lcom/revenuecat/purchases/paywalls/components/common/PromoOfferConfig;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PromoOfferResolver {
    public static final int $stable = 0;
    public static final PromoOfferResolver INSTANCE = new PromoOfferResolver();

    private PromoOfferResolver() {
    }

    public final ResolvedOffer resolve(Package rcPackage, PromoOfferConfig offerConfig) {
        String str;
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        SubscriptionOption defaultOption = rcPackage.getProduct().getDefaultOption();
        if (offerConfig == null) {
            return new ResolvedOffer.NoConfiguration(defaultOption);
        }
        SubscriptionOptions subscriptionOptions = rcPackage.getProduct().getSubscriptionOptions();
        SubscriptionOption subscriptionOptionFindOfferById = subscriptionOptions != null ? INSTANCE.findOfferById(subscriptionOptions, offerConfig.getOfferId()) : null;
        if (subscriptionOptionFindOfferById != null) {
            return new ResolvedOffer.ConfiguredOffer(subscriptionOptionFindOfferById);
        }
        if (subscriptionOptions == null) {
            str = "product has no subscription options";
        } else {
            str = "offer not found in available options";
        }
        Logger.INSTANCE.m1587w("Configured offer '" + offerConfig.getOfferId() + "' for package '" + rcPackage.getIdentifier() + "': " + str + ". Falling back to default option.");
        return new ResolvedOffer.OfferNotFound(offerConfig.getOfferId(), defaultOption);
    }

    private final SubscriptionOption findOfferById(List<? extends SubscriptionOption> subscriptionOptions, String offerId) {
        Object obj;
        Iterator<T> it = subscriptionOptions.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            SubscriptionOption subscriptionOption = (SubscriptionOption) next;
            GoogleSubscriptionOption googleSubscriptionOption = subscriptionOption instanceof GoogleSubscriptionOption ? (GoogleSubscriptionOption) subscriptionOption : null;
            if (Intrinsics.areEqual(googleSubscriptionOption != null ? googleSubscriptionOption.getOfferId() : null, offerId)) {
                obj = next;
                break;
            }
        }
        return (SubscriptionOption) obj;
    }
}
