package aws.smithy.kotlin.runtime.collections;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: MultiMap.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0004B!\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0082\u0004¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u00020\u000eH\u0096\u0080\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u00020\u0011H\u0096\u0080\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0081\u0004¢\u0006\u0004\b\u0015\u0010\rJ\u001f\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0096\u0081\u0004¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0083\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u00020\u000bH\u0096\u0081\u0004¢\u0006\u0004\b\u001b\u0010\u001cR&\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001dR&\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f0\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R-\u0010&\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u001f0#8\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001b\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000#8\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b'\u0010%R\u0015\u0010*\u001a\u00020\u000e8\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b)\u0010\u0010R!\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050+8\u0016X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006/"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/SimpleMultiMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Laws/smithy/kotlin/runtime/collections/MultiMap;", "", "", "delegate", "<init>", "(Ljava/util/Map;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", SubscriberAttributeKt.JSON_NAME_KEY, "containsKey", "value", "containsValue", "(Ljava/util/List;)Z", "get", "(Ljava/lang/Object;)Ljava/util/List;", "isEmpty", "()Z", "Ljava/util/Map;", "Lkotlin/sequences/Sequence;", "", "getEntryValues", "()Lkotlin/sequences/Sequence;", "entryValues", "", "getEntries", "()Ljava/util/Set;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "getKeys", UserMetadata.KEYDATA_FILENAME, "getSize", "size", "", "getValues", "()Ljava/util/Collection;", "values", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SimpleMultiMap<K, V> implements MultiMap<K, V>, Map<K, List<? extends V>>, KMappedMarker {
    private final Map<K, List<V>> delegate;

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public List<V> compute(K k, BiFunction<? super K, ? super List<? extends V>, ? extends List<? extends V>> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public List<V> computeIfAbsent(K k, Function<? super K, ? extends List<? extends V>> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public List<V> computeIfPresent(K k, BiFunction<? super K, ? super List<? extends V>, ? extends List<? extends V>> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return this.delegate.containsKey(key);
    }

    public boolean containsValue(List<? extends V> value) {
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
    public /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<V> merge(K k, List<? extends V> list, BiFunction<? super List<? extends V>, ? super List<? extends V>, ? extends List<? extends V>> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<V> put(K k, List<? extends V> list) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends List<? extends V>> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<V> putIfAbsent(K k, List<? extends V> list) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public List<V> remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<V> replace(K k, List<? extends V> list) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean replace(K k, List<? extends V> list, List<? extends V> list2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super List<? extends V>, ? extends List<? extends V>> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleMultiMap(Map<K, ? extends List<? extends V>> delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // aws.smithy.kotlin.runtime.collections.MultiMap
    public /* bridge */ boolean contains(K k, V v) {
        return super.contains(k, v);
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof List) {
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

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // aws.smithy.kotlin.runtime.collections.MultiMap
    public /* bridge */ MutableMultiMap<K, V> toMutableMultiMap() {
        return super.toMutableMultiMap();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<List<V>> values() {
        return getValues();
    }

    @Override // aws.smithy.kotlin.runtime.collections.MultiMap
    public Sequence<Map.Entry<K, V>> getEntryValues() {
        return SequencesKt.sequence(new SimpleMultiMap$entryValues$1(this, null));
    }

    @Override // java.util.Map
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        return Intrinsics.areEqual(this.delegate, ((SimpleMultiMap) other).delegate);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.delegate.hashCode();
    }

    public String toString() {
        return this.delegate.toString();
    }
}
