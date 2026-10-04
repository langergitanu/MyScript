package aws.smithy.kotlin.runtime.http.auth;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.auth.AuthOption;
import aws.smithy.kotlin.runtime.auth.AuthOptionKt;
import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.collections.MutableAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: EndpointAuth.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¨\u0006\u0005"}, m1599d2 = {"mergeAuthOptions", "", "Laws/smithy/kotlin/runtime/auth/AuthOption;", "modeled", "endpointOptions", "http-auth-aws"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EndpointAuthKt {
    @InternalApi
    public static final List<AuthOption> mergeAuthOptions(List<? extends AuthOption> modeled, List<? extends AuthOption> endpointOptions) {
        Intrinsics.checkNotNullParameter(modeled, "modeled");
        Intrinsics.checkNotNullParameter(endpointOptions, "endpointOptions");
        List<? extends AuthOption> list = modeled;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(AuthSchemeId.m12116boximpl(((AuthOption) obj).mo12110getSchemeIdDepwgT4()), obj);
        }
        ArrayList arrayList = new ArrayList();
        for (AuthOption authOptionM12114AuthOptionJh0Pmzk : endpointOptions) {
            AuthOption authOption = (AuthOption) linkedHashMap.get(AuthSchemeId.m12116boximpl(authOptionM12114AuthOptionJh0Pmzk.mo12110getSchemeIdDepwgT4()));
            if (authOption != null && !authOption.getAttributes().isEmpty()) {
                MutableAttributes mutableAttributes = AttributesKt.toMutableAttributes(authOption.getAttributes());
                AttributesKt.merge(mutableAttributes, authOptionM12114AuthOptionJh0Pmzk.getAttributes());
                authOptionM12114AuthOptionJh0Pmzk = AuthOptionKt.m12114AuthOptionJh0Pmzk(authOptionM12114AuthOptionJh0Pmzk.mo12110getSchemeIdDepwgT4(), mutableAttributes);
            }
            arrayList.add(authOptionM12114AuthOptionJh0Pmzk);
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(AuthSchemeId.m12116boximpl(((AuthOption) it.next()).mo12110getSchemeIdDepwgT4()));
        }
        Set set = CollectionsKt.toSet(arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : list) {
            if (!set.contains(AuthSchemeId.m12116boximpl(((AuthOption) obj2).mo12110getSchemeIdDepwgT4()))) {
                arrayList4.add(obj2);
            }
        }
        arrayList.addAll(arrayList4);
        return arrayList;
    }
}
