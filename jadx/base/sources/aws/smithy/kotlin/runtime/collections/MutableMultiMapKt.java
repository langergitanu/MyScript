package aws.smithy.kotlin.runtime.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MutableMultiMap.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aQ\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00030\u0002\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Lkotlin/Pair;", "pairs", "Laws/smithy/kotlin/runtime/collections/MutableMultiMap;", "mutableMultiMapOf", "([Lkotlin/Pair;)Laws/smithy/kotlin/runtime/collections/MutableMultiMap;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MutableMultiMapKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> MutableMultiMap<K, V> mutableMultiMapOf(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair<? extends K, ? extends V> pair : pairs) {
            K first = pair.getFirst();
            Object obj = linkedHashMap.get(first);
            if (obj == null) {
                obj = (List) new ArrayList();
                linkedHashMap.put(first, obj);
            }
            ((List) obj).add(pair.getSecond());
        }
        return new SimpleMutableMultiMap(linkedHashMap);
    }
}
