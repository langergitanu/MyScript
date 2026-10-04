package aws.smithy.kotlin.runtime.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LruCache.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aC\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "k", "", "moveKeyToBack", "(Ljava/util/LinkedHashMap;Ljava/lang/Object;)V", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LruCacheKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <K, V> void moveKeyToBack(LinkedHashMap<K, V> linkedHashMap, K k) {
        if (linkedHashMap.containsKey(k)) {
            V vRemove = linkedHashMap.remove(k);
            Intrinsics.checkNotNull(vRemove);
            linkedHashMap.put(k, vRemove);
        }
    }
}
