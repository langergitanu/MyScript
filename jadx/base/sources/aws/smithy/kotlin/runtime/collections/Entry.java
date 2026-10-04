package aws.smithy.kotlin.runtime.collections;

import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: Entry.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ0\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u0001HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u00020\u0012HÖ\u0081\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0016\u001a\u00020\u0015HÖ\u0081\u0004¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0004\u001a\u00028\u00008\u0016X\u0096\u0084\b¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u001b\u0010\u0005\u001a\u00028\u00018\u0016X\u0096\u0084\b¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u001a\u0010\t¨\u0006\u001b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/Entry;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", SubscriberAttributeKt.JSON_NAME_KEY, "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "component1", "()Ljava/lang/Object;", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Laws/smithy/kotlin/runtime/collections/Entry;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getKey", "getValue", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class Entry<K, V> implements Map.Entry<K, V>, KMappedMarker {
    private final K key;
    private final V value;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Entry copy$default(Entry entry, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = entry.key;
        }
        if ((i & 2) != 0) {
            obj2 = entry.value;
        }
        return entry.copy(obj, obj2);
    }

    public final K component1() {
        return this.key;
    }

    public final V component2() {
        return this.value;
    }

    public final Entry<K, V> copy(K key, V value) {
        return new Entry<>(key, value);
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) other;
        return Intrinsics.areEqual(this.key, entry.key) && Intrinsics.areEqual(this.value, entry.value);
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        K k = this.key;
        int iHashCode = (k == null ? 0 : k.hashCode()) * 31;
        V v = this.value;
        return iHashCode + (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public String toString() {
        return "Entry(key=" + this.key + ", value=" + this.value + ')';
    }

    public Entry(K k, V v) {
        this.key = k;
        this.value = v;
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.value;
    }
}
