package aws.smithy.kotlin.runtime.collections;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Attributes.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J)\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\b*\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u000e\u001a\u00020\r2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\u0012\u001a\u00020\u0011\"\b\b\u0000\u0010\b*\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0014\u001a\u00020\u0011\"\b\b\u0000\u0010\b*\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J5\u0010\u0018\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001b\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0096\u0082\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001e\u001a\u00020\u001dH\u0096\u0080\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010!\u001a\u00020 H\u0096\u0080\u0004¢\u0006\u0004\b!\u0010\"R$\u0010$\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00070#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001e\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006,"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/AttributesImpl;", "Laws/smithy/kotlin/runtime/collections/MutableAttributes;", "Laws/smithy/kotlin/runtime/collections/Attributes;", "seed", "<init>", "(Laws/smithy/kotlin/runtime/collections/Attributes;)V", "()V", "", ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/collections/AttributeKey;", SubscriberAttributeKt.JSON_NAME_KEY, "getOrNull", "(Laws/smithy/kotlin/runtime/collections/AttributeKey;)Ljava/lang/Object;", "", "contains", "(Laws/smithy/kotlin/runtime/collections/AttributeKey;)Z", "value", "", "set", "(Laws/smithy/kotlin/runtime/collections/AttributeKey;Ljava/lang/Object;)V", "remove", "(Laws/smithy/kotlin/runtime/collections/AttributeKey;)V", "Lkotlin/Function0;", "block", "computeIfAbsent", "(Laws/smithy/kotlin/runtime/collections/AttributeKey;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "map", "Ljava/util/Map;", "isEmpty", "()Z", "", "getKeys", "()Ljava/util/Set;", UserMetadata.KEYDATA_FILENAME, "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class AttributesImpl implements MutableAttributes {
    private final Map<AttributeKey<?>, Object> map;

    public AttributesImpl(Attributes seed) {
        Intrinsics.checkNotNullParameter(seed, "seed");
        this.map = new LinkedHashMap();
        AttributesKt.merge(this, seed);
    }

    public AttributesImpl() {
        this(AttributesKt.emptyAttributes());
    }

    @Override // aws.smithy.kotlin.runtime.collections.Attributes
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // aws.smithy.kotlin.runtime.collections.Attributes
    public <T> T getOrNull(AttributeKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) this.map.get(key);
    }

    @Override // aws.smithy.kotlin.runtime.collections.Attributes
    public boolean contains(AttributeKey<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.map.containsKey(key);
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableAttributes
    public <T> void set(AttributeKey<T> key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.map.put(key, value);
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableAttributes
    public <T> void remove(AttributeKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.map.remove(key);
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableAttributes
    public <T> T computeIfAbsent(AttributeKey<T> key, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(block, "block");
        T t = (T) getOrNull(key);
        if (t != null) {
            return t;
        }
        T tInvoke = block.invoke();
        this.map.put(key, tInvoke);
        return tInvoke;
    }

    @Override // aws.smithy.kotlin.runtime.collections.Attributes
    public Set<AttributeKey<?>> getKeys() {
        return this.map.keySet();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof Attributes)) {
            return false;
        }
        Attributes attributes = (Attributes) other;
        if (getKeys().size() != attributes.getKeys().size()) {
            return false;
        }
        Set<AttributeKey<?>> keys = getKeys();
        if ((keys instanceof Collection) && keys.isEmpty()) {
            return true;
        }
        for (AttributeKey<?> attributeKey : keys) {
            if (contains(attributeKey)) {
                Intrinsics.checkNotNull(attributeKey, "null cannot be cast to non-null type aws.smithy.kotlin.runtime.collections.AttributeKey<kotlin.Any>");
                if (Intrinsics.areEqual(getOrNull(attributeKey), attributes.getOrNull(attributeKey))) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        return this.map.toString();
    }
}
