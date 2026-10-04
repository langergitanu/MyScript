package com.myscript.nebo.sso.util;

import aws.sdk.kotlin.runtime.config.profile.Literals;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AccessTokenExtractor.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0004"}, m1599d2 = {"extractAccessToken", "", ImagesContract.URL, "extractAuthCode", "sso_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AccessTokenExtractorKt {
    public static final String extractAccessToken(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Object obj = null;
        List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.substringAfter$default(url, Literals.COMMENT_1, (String) null, 2, (Object) null), new String[]{"&"}, false, 0, 6, (Object) null);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10)), 16));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            List listSplit$default2 = StringsKt.split$default((CharSequence) it.next(), new String[]{"="}, false, 0, 6, (Object) null);
            String str = (String) CollectionsKt.getOrNull(listSplit$default2, 0);
            if (str == null) {
                str = "";
            }
            Pair pairM1606to = TuplesKt.m1606to(str, (String) CollectionsKt.getOrNull(listSplit$default2, 1));
            linkedHashMap.put(pairM1606to.getFirst(), pairM1606to.getSecond());
        }
        Object obj2 = linkedHashMap.get("access_token");
        if (((String) obj2) != null && Intrinsics.areEqual(linkedHashMap.get("token_type"), "bearer")) {
            obj = obj2;
        }
        return (String) obj;
    }

    public static final String extractAuthCode(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        List listSplit$default = StringsKt.split$default((CharSequence) url, new String[]{"?"}, false, 0, 6, (Object) null);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10)), 16));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            List listSplit$default2 = StringsKt.split$default((CharSequence) it.next(), new String[]{"="}, false, 0, 6, (Object) null);
            String str = (String) CollectionsKt.getOrNull(listSplit$default2, 0);
            if (str == null) {
                str = "";
            }
            Pair pairM1606to = TuplesKt.m1606to(str, (String) CollectionsKt.getOrNull(listSplit$default2, 1));
            linkedHashMap.put(pairM1606to.getFirst(), pairM1606to.getSecond());
        }
        Object obj = linkedHashMap.get("code");
        if (((String) obj) == null) {
            obj = null;
        }
        return (String) obj;
    }
}
