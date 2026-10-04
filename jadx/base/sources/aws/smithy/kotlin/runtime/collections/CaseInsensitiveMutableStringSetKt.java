package aws.smithy.kotlin.runtime.collections;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaseInsensitiveMutableStringSet.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0010\u001c\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"", "", "initialValues", "Laws/smithy/kotlin/runtime/collections/CaseInsensitiveMutableStringSet;", "CaseInsensitiveMutableStringSet", "(Ljava/lang/Iterable;)Laws/smithy/kotlin/runtime/collections/CaseInsensitiveMutableStringSet;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CaseInsensitiveMutableStringSetKt {
    public static final CaseInsensitiveMutableStringSet CaseInsensitiveMutableStringSet(Iterable<String> initialValues) {
        Intrinsics.checkNotNullParameter(initialValues, "initialValues");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(initialValues, 10));
        Iterator<String> it = initialValues.iterator();
        while (it.hasNext()) {
            arrayList.add(CaseInsensitiveStringKt.toInsensitive(it.next()));
        }
        return new CaseInsensitiveMutableStringSet(arrayList);
    }
}
