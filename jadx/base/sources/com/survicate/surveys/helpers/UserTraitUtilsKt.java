package com.survicate.surveys.helpers;

import com.survicate.surveys.traits.UserTrait;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: UserTraitUtils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0002*\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0002¨\u0006\t"}, m1599d2 = {"updatedWith", "", "Lcom/survicate/surveys/traits/UserTrait;", "other", "findUserIdTrait", "findUserKeyTrait", "withoutCredentials", "isCredential", "", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class UserTraitUtilsKt {
    public static final List<UserTrait> updatedWith(List<? extends UserTrait> list, List<? extends UserTrait> other) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        List<? extends UserTrait> list2 = list;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
        for (Object obj : list2) {
            linkedHashMap.put(((UserTrait) obj).key, obj);
        }
        List<? extends UserTrait> list3 = other;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list3, 10)), 16));
        for (Object obj2 : list3) {
            linkedHashMap2.put(((UserTrait) obj2).key, obj2);
        }
        return CollectionsKt.toList(MapsKt.plus(linkedHashMap, linkedHashMap2).values());
    }

    public static final UserTrait findUserIdTrait(List<? extends UserTrait> list) {
        Object next;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((UserTrait) next).key, "user_id")) {
                break;
            }
        }
        return (UserTrait) next;
    }

    public static final UserTrait findUserKeyTrait(List<? extends UserTrait> list) {
        Object next;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((UserTrait) next).key, UserTrait.USER_KEY)) {
                break;
            }
        }
        return (UserTrait) next;
    }

    public static final List<UserTrait> withoutCredentials(List<? extends UserTrait> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!isCredential((UserTrait) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final boolean isCredential(UserTrait userTrait) {
        Intrinsics.checkNotNullParameter(userTrait, "<this>");
        return Intrinsics.areEqual(userTrait.key, "user_id") || Intrinsics.areEqual(userTrait.key, UserTrait.USER_KEY);
    }
}
