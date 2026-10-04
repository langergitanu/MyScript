package com.survicate.surveys.helpers;

import com.survicate.surveys.traits.UserTrait;
import com.survicate.surveys.utils.FeatureFlags;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: UserTraitUtils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u000f"}, m1599d2 = {"Lcom/survicate/surveys/helpers/UserTraitUtils;", "", "<init>", "()V", "getVisitorAttributes", "", "", "userTraits", "", "Lcom/survicate/surveys/traits/UserTrait;", "updateTimestamp", "", "userTrait", "timestampMs", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class UserTraitUtils {
    public static final UserTraitUtils INSTANCE = new UserTraitUtils();

    private UserTraitUtils() {
    }

    public final Map<String, String> getVisitorAttributes(List<? extends UserTrait> userTraits) {
        Intrinsics.checkNotNullParameter(userTraits, "userTraits");
        List<? extends UserTrait> list = userTraits;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (UserTrait userTrait : list) {
            Pair pairM1606to = TuplesKt.m1606to(userTrait.key, userTrait.value);
            linkedHashMap.put(pairM1606to.getFirst(), pairM1606to.getSecond());
        }
        if (!FeatureFlags.INSTANCE.isBackendTargetingEnabled()) {
            return linkedHashMap;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (!Intrinsics.areEqual((String) entry.getKey(), UserTrait.USER_KEY)) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap2;
    }

    @JvmStatic
    public static final void updateTimestamp(UserTrait userTrait, long timestampMs) {
        Intrinsics.checkNotNullParameter(userTrait, "userTrait");
        userTrait.setTimestampMs$survicate_sdk_release(Long.valueOf(timestampMs));
    }
}
