package com.revenuecat.purchases.utils;

import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PrewarmTargetOfferings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0000\u001a\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u0003H\u0000¨\u0006\u0007"}, m1599d2 = {"prewarmTargetOfferingIds", "", "", "Lcom/revenuecat/purchases/Offerings;", "prewarmTargetOfferings", "", "Lcom/revenuecat/purchases/Offering;", "purchases_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PrewarmTargetOfferingsKt {
    public static final Set<String> prewarmTargetOfferingIds(Offerings offerings) {
        String identifier;
        Intrinsics.checkNotNullParameter(offerings, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Offering current = offerings.getCurrent();
        if (current != null && (identifier = current.getIdentifier()) != null) {
            linkedHashSet.add(identifier);
        }
        Offerings.Placements placements = offerings.getPlacements();
        if (placements != null) {
            Collection collectionValues = MapsKt.toSortedMap(placements.getOfferingIdsByPlacement()).values();
            Intrinsics.checkNotNullExpressionValue(collectionValues, "config.offeringIdsByPlacement.toSortedMap().values");
            CollectionsKt.filterNotNullTo(collectionValues, linkedHashSet);
            String fallbackOfferingId = placements.getFallbackOfferingId();
            if (fallbackOfferingId != null) {
                linkedHashSet.add(fallbackOfferingId);
            }
        }
        return linkedHashSet;
    }

    public static final List<Offering> prewarmTargetOfferings(Offerings offerings) {
        Intrinsics.checkNotNullParameter(offerings, "<this>");
        Set<String> setPrewarmTargetOfferingIds = prewarmTargetOfferingIds(offerings);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setPrewarmTargetOfferingIds.iterator();
        while (it.hasNext()) {
            Offering offering = offerings.getOffering((String) it.next());
            if (offering != null) {
                arrayList.add(offering);
            }
        }
        return arrayList;
    }
}
