package aws.smithy.kotlin.runtime.collections;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: MutableMultiMap.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0007\n\u0002\u0010\u001f\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B!\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u000e\u001a\u00020\u00122\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u000e\u0010\u0013J%\u0010\u0016\u001a\u00020\r2\u0006\u0010\t\u001a\u00028\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u0016\u001a\u00020\r2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0018J\u001b\u0010\u001b\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0096\u0082\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u00020\u0010H\u0096\u0080\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\r2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001H\u0017¢\u0006\u0004\b\u001f\u0010\u000fJ!\u0010!\u001a\u0004\u0018\u00018\u00012\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b!\u0010\"J'\u0010#\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00028\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016¢\u0006\u0004\b#\u0010$J'\u0010%\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00028\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016¢\u0006\u0004\b%\u0010$J\u0011\u0010'\u001a\u00020&H\u0096\u0080\u0004¢\u0006\u0004\b'\u0010(J\u0011\u0010)\u001a\u00020\u0012H\u0096\u0081\u0004¢\u0006\u0004\b)\u0010*J\u0019\u0010+\u001a\u00020\r2\u0006\u0010\t\u001a\u00028\u0000H\u0096\u0081\u0004¢\u0006\u0004\b+\u0010\u001cJ\u001f\u0010,\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0081\u0004¢\u0006\u0004\b,\u0010-J!\u0010.\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\t\u001a\u00028\u0000H\u0096\u0083\u0004¢\u0006\u0004\b.\u0010\u000bJ\u0011\u0010/\u001a\u00020\rH\u0096\u0081\u0004¢\u0006\u0004\b/\u00100J/\u00101\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\t\u001a\u00028\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0097\u0081\b¢\u0006\u0004\b1\u00102J-\u00105\u001a\u00020\u00122\u001a\u00104\u001a\u0016\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000403H\u0096\u0081\u0004¢\u0006\u0004\b5\u0010\bJ!\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\t\u001a\u00028\u0000H\u0097\u0081\b¢\u0006\u0004\b \u0010\u000bR&\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00106R&\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000108078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R-\u0010@\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040=0<8\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b>\u0010?R\u001b\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000<8\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\bA\u0010?R\u0015\u0010D\u001a\u00020\u00108\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\bC\u0010\u001eR!\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040E8\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006H"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/SimpleMutableMultiMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "", "Laws/smithy/kotlin/runtime/collections/MutableMultiMap;", "delegate", "<init>", "(Ljava/util/Map;)V", SubscriberAttributeKt.JSON_NAME_KEY, "ensureKey", "(Ljava/lang/Object;)Ljava/util/List;", "value", "", "add", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "", FirebaseAnalytics.Param.INDEX, "", "(Ljava/lang/Object;ILjava/lang/Object;)V", "", "values", "addAll", "(Ljava/lang/Object;Ljava/util/Collection;)Z", "(Ljava/lang/Object;ILjava/util/Collection;)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "removeElement", "remove", "removeAt", "(Ljava/lang/Object;I)Ljava/lang/Object;", "removeAll", "(Ljava/lang/Object;Ljava/util/Collection;)Ljava/lang/Boolean;", "retainAll", "", "toString", "()Ljava/lang/String;", "clear", "()V", "containsKey", "containsValue", "(Ljava/util/List;)Z", "get", "isEmpty", "()Z", "put", "(Ljava/lang/Object;Ljava/util/List;)Ljava/util/List;", "", TypedValues.TransitionType.S_FROM, "putAll", "Ljava/util/Map;", "Lkotlin/sequences/Sequence;", "", "getEntryValues", "()Lkotlin/sequences/Sequence;", "entryValues", "", "", "getEntries", "()Ljava/util/Set;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "getKeys", UserMetadata.KEYDATA_FILENAME, "getSize", "size", "", "getValues", "()Ljava/util/Collection;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SimpleMutableMultiMap<K, V> implements Map<K, List<V>>, MutableMultiMap<K, V>, KMutableMap {
    private final Map<K, List<V>> delegate;

    @Override // java.util.Map
    public void clear() {
        this.delegate.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return this.delegate.containsKey(key);
    }

    public boolean containsValue(List<V> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return this.delegate.containsValue(value);
    }

    @Override // java.util.Map
    public List<V> get(Object key) {
        return this.delegate.get(key);
    }

    public Set<Map.Entry<K, List<V>>> getEntries() {
        return this.delegate.entrySet();
    }

    public Set<K> getKeys() {
        return this.delegate.keySet();
    }

    public int getSize() {
        return this.delegate.size();
    }

    public Collection<List<V>> getValues() {
        return this.delegate.values();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Map
    @IgnorableReturnValue
    public List<V> put(K key, List<V> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return this.delegate.put(key, value);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends List<V>> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        this.delegate.putAll(from);
    }

    @Override // java.util.Map
    @IgnorableReturnValue
    public List<V> remove(Object key) {
        return this.delegate.remove(key);
    }

    public SimpleMutableMultiMap(Map<K, List<V>> delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public /* bridge */ void addAll(Map<K, ? extends List<? extends V>> map) {
        super.addAll(map);
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public /* bridge */ boolean contains(K k, V v) {
        return super.contains(k, v);
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (TypeIntrinsics.isMutableList(obj)) {
            return containsValue((List) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, List<V>>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map, aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public /* bridge */ List<V> put(K k, V v) {
        return super.put((Object) k, (Object) v);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public /* bridge */ MultiMap<K, V> toMultiMap() {
        return super.toMultiMap();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<List<V>> values() {
        return getValues();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<V> ensureKey(K key) {
        SimpleMutableMultiMap<K, V> simpleMutableMultiMap = this;
        Object obj = simpleMutableMultiMap.get((Object) key);
        if (obj == null) {
            obj = (List) new ArrayList();
            simpleMutableMultiMap.put((Object) key, obj);
        }
        return (List) obj;
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public boolean add(K key, V value) {
        return ensureKey(key).add(value);
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public void add(K key, int index, V value) {
        ensureKey(key).add(index, value);
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public boolean addAll(K key, Collection<? extends V> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        return ensureKey(key).addAll(values);
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public boolean addAll(K key, int index, Collection<? extends V> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        return ensureKey(key).addAll(index, values);
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public Sequence<Map.Entry<K, V>> getEntryValues() {
        return SequencesKt.sequence(new SimpleMutableMultiMap$entryValues$1(this, null));
    }

    @Override // java.util.Map
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        return Intrinsics.areEqual(this.delegate, ((SimpleMutableMultiMap) other).delegate);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public boolean removeElement(K key, V value) {
        List list = (List) get((Object) key);
        if (list != null) {
            return list.remove(value);
        }
        return false;
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public V removeAt(K key, int index) {
        List list = (List) get((Object) key);
        if (list != null) {
            return (V) list.remove(index);
        }
        return null;
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public Boolean removeAll(K key, Collection<? extends V> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        List list = (List) get((Object) key);
        if (list != null) {
            return Boolean.valueOf(list.removeAll(values));
        }
        return null;
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public Boolean retainAll(K key, Collection<? extends V> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        List list = (List) get((Object) key);
        if (list != null) {
            return Boolean.valueOf(list.retainAll(values));
        }
        return null;
    }

    public String toString() {
        return this.delegate.toString();
    }
}
