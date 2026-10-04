package aws.smithy.kotlin.runtime.collections;

import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: MultiMap.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR&\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/MultiMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "", SubscriberAttributeKt.JSON_NAME_KEY, "value", "", "contains", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Laws/smithy/kotlin/runtime/collections/MutableMultiMap;", "toMutableMultiMap", "()Laws/smithy/kotlin/runtime/collections/MutableMultiMap;", "Lkotlin/sequences/Sequence;", "", "getEntryValues", "()Lkotlin/sequences/Sequence;", "entryValues", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface MultiMap<K, V> extends Map<K, List<? extends V>>, KMappedMarker {
    Sequence<Map.Entry<K, V>> getEntryValues();

    /* JADX INFO: compiled from: MultiMap.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <K, V> boolean contains(MultiMap<K, V> multiMap, K k, V v) {
            return MultiMap.super.contains(k, v);
        }

        @Deprecated
        public static <K, V> MutableMultiMap<K, V> toMutableMultiMap(MultiMap<K, V> multiMap) {
            return MultiMap.super.toMutableMultiMap();
        }
    }

    default boolean contains(K key, V value) {
        List list = (List) get(key);
        if (list != null) {
            return list.contains(value);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    default MutableMultiMap<K, V> toMutableMultiMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), CollectionsKt.toMutableList((Collection) entry.getValue()));
        }
        return new SimpleMutableMultiMap(linkedHashMap);
    }
}
