package com.revenuecat.purchases.p036ui.revenuecatui.utils;

import android.net.Uri;
import aws.sdk.kotlin.runtime.config.profile.Literals;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: compiled from: URIExtensions.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0000¨\u0006\u0005"}, m1599d2 = {"upsertQueryParameters", "Ljava/net/URI;", "parameters", "", "", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class URIExtensionsKt {
    public static final /* synthetic */ URI upsertQueryParameters(URI uri, Map parameters) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        if (parameters.isEmpty()) {
            return uri;
        }
        Set<Map.Entry> setEntrySet = parameters.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : setEntrySet) {
            String str = (String) entry.getKey();
            Pair pairM1606to = TuplesKt.m1606to(str, Uri.encode(str) + Literals.PROPERTY_SPLITTER + Uri.encode((String) entry.getValue()));
            linkedHashMap.put(pairM1606to.getFirst(), pairM1606to.getSecond());
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString()");
        String strSubstringBefore$default = StringsKt.substringBefore$default(string, '#', (String) null, 2, (Object) null);
        String strRemovePrefix = StringsKt.removePrefix(string, (CharSequence) strSubstringBefore$default);
        List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.substringAfter(strSubstringBefore$default, '?', ""), new char[]{Typography.amp}, false, 0, 6, (Object) null);
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : listSplit$default) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : arrayList) {
            String strDecode = Uri.decode(StringsKt.substringBefore$default(str2, Literals.PROPERTY_SPLITTER, (String) null, 2, (Object) null));
            if (parameters.containsKey(strDecode)) {
                str2 = (String) linkedHashMap2.remove(strDecode);
            }
            if (str2 != null) {
                arrayList2.add(str2);
            }
        }
        Collection collectionValues = linkedHashMap2.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "pending.values");
        return new URI(StringsKt.substringBefore$default(strSubstringBefore$default, '?', (String) null, 2, (Object) null) + '?' + CollectionsKt.joinToString$default(CollectionsKt.plus((Collection) arrayList2, (Iterable) collectionValues), "&", null, null, 0, null, null, 62, null) + strRemovePrefix);
    }
}
