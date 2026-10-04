package aws.smithy.kotlin.runtime.collections;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: MutableMultiMap.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H&¢\u0006\u0004\b\b\u0010\tJ'\u0010\b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00028\u0001H&¢\u0006\u0004\b\b\u0010\rJ%\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00028\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0012J)\u0010\u0010\u001a\u00020\f2\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00140\u0013H\u0016¢\u0006\u0004\b\u0010\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0017\u0010\tJ'\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H'¢\u0006\u0004\b\u001a\u0010\tJ!\u0010\u001c\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00028\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH&¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010 \u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00028\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH&¢\u0006\u0004\b \u0010\u001fJ\u001b\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!H\u0016¢\u0006\u0004\b\"\u0010#R&\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010%0$8&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/MutableMultiMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "", SubscriberAttributeKt.JSON_NAME_KEY, "value", "", "add", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "", FirebaseAnalytics.Param.INDEX, "", "(Ljava/lang/Object;ILjava/lang/Object;)V", "", "values", "addAll", "(Ljava/lang/Object;Ljava/util/Collection;)Z", "(Ljava/lang/Object;ILjava/util/Collection;)Z", "", "", "other", "(Ljava/util/Map;)V", "contains", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/List;", "removeElement", "remove", "removeAt", "(Ljava/lang/Object;I)Ljava/lang/Object;", "removeAll", "(Ljava/lang/Object;Ljava/util/Collection;)Ljava/lang/Boolean;", "retainAll", "Laws/smithy/kotlin/runtime/collections/MultiMap;", "toMultiMap", "()Laws/smithy/kotlin/runtime/collections/MultiMap;", "Lkotlin/sequences/Sequence;", "", "getEntryValues", "()Lkotlin/sequences/Sequence;", "entryValues", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface MutableMultiMap<K, V> extends Map<K, List<V>>, KMutableMap {
    void add(K key, int index, V value);

    boolean add(K key, V value);

    boolean addAll(K key, int index, Collection<? extends V> values);

    boolean addAll(K key, Collection<? extends V> values);

    Sequence<Map.Entry<K, V>> getEntryValues();

    Boolean removeAll(K key, Collection<? extends V> values);

    V removeAt(K key, int index);

    boolean removeElement(K key, V value);

    Boolean retainAll(K key, Collection<? extends V> values);

    /* JADX INFO: compiled from: MutableMultiMap.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <K, V> void addAll(MutableMultiMap<K, V> mutableMultiMap, Map<K, ? extends List<? extends V>> other) {
            Intrinsics.checkNotNullParameter(other, "other");
            MutableMultiMap.super.addAll(other);
        }

        @Deprecated
        public static <K, V> boolean contains(MutableMultiMap<K, V> mutableMultiMap, K k, V v) {
            return MutableMultiMap.super.contains(k, v);
        }

        @Deprecated
        public static <K, V> List<V> put(MutableMultiMap<K, V> mutableMultiMap, K k, V v) {
            return MutableMultiMap.super.put((Object) k, (Object) v);
        }

        @Deprecated
        public static <K, V> MultiMap<K, V> toMultiMap(MutableMultiMap<K, V> mutableMultiMap) {
            return MutableMultiMap.super.toMultiMap();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    default void addAll(Map<K, ? extends List<? extends V>> other) {
        Intrinsics.checkNotNullParameter(other, "other");
        Iterator<T> it = other.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            addAll(entry.getKey(), (List) entry.getValue());
        }
    }

    default boolean contains(K key, V value) {
        List list = (List) get(key);
        if (list != null) {
            return list.contains(value);
        }
        return false;
    }

    @Override // java.util.Map
    default List<V> put(K key, V value) {
        return put((Object) key, CollectionsKt.mutableListOf(value));
    }

    /* JADX WARN: Multi-variable type inference failed */
    default MultiMap<K, V> toMultiMap() {
        MutableMultiMap<K, V> mutableMultiMap = this;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mutableMultiMap.size()));
        Iterator<T> it = mutableMultiMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), CollectionsKt.toList((List) entry.getValue()));
        }
        return new SimpleMultiMap(MapsKt.toMap(linkedHashMap));
    }
}
