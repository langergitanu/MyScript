package aws.smithy.kotlin.runtime.collections;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import aws.sdk.kotlin.runtime.config.profile.Literals;
import aws.smithy.kotlin.runtime.InternalApi;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: compiled from: CaseInsensitiveMap.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0005\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002:\u00012B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0080\u0004¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0082\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0007H\u0096\u0080\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u00020\u0011H\u0096\u0080\u0004¢\u0006\u0004\b\u0012\u0010\u0005J#\u0010\u0013\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000H\u0096\u0080\b¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0017\u001a\u00020\u00112\u0014\u0010\u0016\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0019\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0080\b¢\u0006\u0004\b\u0019\u0010\u000eJ\u0011\u0010\u001b\u001a\u00020\u001aH\u0096\u0080\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001f\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0096\u0082\u0004¢\u0006\u0004\b\u001f\u0010\fJ\u0011\u0010 \u001a\u00020\u0003H\u0096\u0080\u0004¢\u0006\u0004\b \u0010!R \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0015\u0010&\u001a\u00020\u001a8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b%\u0010\u001cR'\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000(0'8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b)\u0010*R\u001b\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030'8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b,\u0010*R\u001b\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000.8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00063"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/CaseInsensitiveMap;", "Value", "", "", "<init>", "()V", SubscriberAttributeKt.JSON_NAME_KEY, "", "containsKey", "(Ljava/lang/String;)Z", "value", "containsValue", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "isEmpty", "()Z", "", "clear", "put", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "", TypedValues.TransitionType.S_FROM, "putAll", "(Ljava/util/Map;)V", "remove", "", "hashCode", "()I", "", "other", "equals", "toString", "()Ljava/lang/String;", "Laws/smithy/kotlin/runtime/collections/CaseInsensitiveString;", "impl", "Ljava/util/Map;", "getSize", "size", "", "", "getEntries", "()Ljava/util/Set;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "getKeys", UserMetadata.KEYDATA_FILENAME, "", "getValues", "()Ljava/util/Collection;", "values", "Entry", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CaseInsensitiveMap<Value> implements Map<String, Value>, KMutableMap {
    private final Map<CaseInsensitiveString, Value> impl = new LinkedHashMap();

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Value>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ Value get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ Value remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<Value> values() {
        return getValues();
    }

    public int getSize() {
        return this.impl.size();
    }

    public boolean containsKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.impl.containsKey(CaseInsensitiveStringKt.toInsensitive(key));
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        return this.impl.containsValue(value);
    }

    public Value get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.impl.get(CaseInsensitiveStringKt.toInsensitive(key));
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.impl.isEmpty();
    }

    public Set<Map.Entry<String, Value>> getEntries() {
        Set<Map.Entry<CaseInsensitiveString, Value>> setEntrySet = this.impl.entrySet();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new Entry(((CaseInsensitiveString) entry.getKey()).getNormalized(), entry.getValue()));
        }
        return CollectionsKt.toMutableSet(arrayList);
    }

    public Set<String> getKeys() {
        return new CaseInsensitiveMutableStringSet(this.impl.keySet());
    }

    public Collection<Value> getValues() {
        return this.impl.values();
    }

    @Override // java.util.Map
    public void clear() {
        this.impl.clear();
    }

    @Override // java.util.Map
    public Value put(String key, Value value) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.impl.put(CaseInsensitiveStringKt.toInsensitive(key), value);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Value> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        for (Map.Entry<? extends String, ? extends Value> entry : from.entrySet()) {
            put(entry.getKey(), (Object) entry.getValue());
        }
    }

    public Value remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.impl.remove(CaseInsensitiveStringKt.toInsensitive(key));
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.impl.hashCode();
    }

    @Override // java.util.Map
    public boolean equals(Object other) {
        return (other instanceof CaseInsensitiveMap) && Intrinsics.areEqual(this.impl, ((CaseInsensitiveMap) other).impl);
    }

    public String toString() {
        return this.impl.toString();
    }

    /* JADX INFO: compiled from: CaseInsensitiveMap.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00028\u0001\u0012\u0006\u0010\u0005\u001a\u00028\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00028\u00022\u0006\u0010\b\u001a\u00028\u0002H\u0096\u0080\b¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u00020\u000bH\u0096\u0080\u0004¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0082\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u00020\u0013H\u0096\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0004\u001a\u00028\u00018\u0016X\u0096\u0084\b¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R#\u0010\u0005\u001a\u00028\u00028\u0016@\u0016X\u0096\u008e\b¢\u0006\u0012\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018\"\u0004\b\t\u0010\u001a¨\u0006\u001b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/CaseInsensitiveMap$Entry;", "Key", "Value", "", SubscriberAttributeKt.JSON_NAME_KEY, "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "getValue", "(Ljava/lang/Object;)V", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    private static final class Entry<Key, Value> implements Map.Entry<Key, Value>, KMutableMap.Entry {
        private final Key key;
        private Value value;

        public Entry(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        @Override // java.util.Map.Entry
        public Key getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public Value getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public void setValue(Value value) {
            this.value = value;
        }

        @Override // java.util.Map.Entry
        public Value setValue(Value newValue) {
            setValue((Object) newValue);
            return getValue();
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Key key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            Value value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object other) {
            if (other != null && (other instanceof Map.Entry)) {
                Map.Entry entry = (Map.Entry) other;
                if (Intrinsics.areEqual(entry.getKey(), getKey()) && Intrinsics.areEqual(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return new StringBuilder().append(getKey()).append(Literals.PROPERTY_SPLITTER).append(getValue()).toString();
        }
    }
}
