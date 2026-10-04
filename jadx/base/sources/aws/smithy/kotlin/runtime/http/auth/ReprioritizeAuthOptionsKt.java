package aws.smithy.kotlin.runtime.http.auth;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.auth.AuthOption;
import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ReprioritizeAuthOptions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¨\u0006\u0006"}, m1599d2 = {"reprioritizeAuthOptions", "", "Laws/smithy/kotlin/runtime/auth/AuthOption;", "authSchemePreference", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "authOptions", "http-auth"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ReprioritizeAuthOptionsKt {
    @InternalApi
    public static final List<AuthOption> reprioritizeAuthOptions(List<AuthSchemeId> authSchemePreference, List<? extends AuthOption> authOptions) {
        Intrinsics.checkNotNullParameter(authSchemePreference, "authSchemePreference");
        Intrinsics.checkNotNullParameter(authOptions, "authOptions");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = authSchemePreference.iterator();
        while (it.hasNext()) {
            Object obj = null;
            String strSubstringAfter$default = StringsKt.substringAfter$default(((AuthSchemeId) it.next()).m12122unboximpl(), '#', (String) null, 2, (Object) null);
            Iterator<T> it2 = authOptions.iterator();
            boolean z = false;
            Object obj2 = null;
            while (true) {
                if (it2.hasNext()) {
                    Object next = it2.next();
                    if (Intrinsics.areEqual(StringsKt.substringAfter$default(((AuthOption) next).mo12110getSchemeIdDepwgT4(), '#', (String) null, 2, (Object) null), strSubstringAfter$default)) {
                        if (z) {
                            break;
                        }
                        z = true;
                        obj2 = next;
                    }
                } else if (z) {
                    obj = obj2;
                }
            }
            AuthOption authOption = (AuthOption) obj;
            if (authOption != null) {
                arrayList.add(authOption);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : authOptions) {
            if (!arrayList2.contains((AuthOption) obj3)) {
                arrayList3.add(obj3);
            }
        }
        return CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList3);
    }
}
