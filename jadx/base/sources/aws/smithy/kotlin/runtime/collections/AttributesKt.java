package aws.smithy.kotlin.runtime.collections;

import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Attributes.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a,\u0010\u0005\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\b\u0010\t\u001a1\u0010\f\u001a\u00020\u000b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\r\u001a3\u0010\u000e\u001a\u00020\u000b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u000e\u0010\r\u001a3\u0010\u000f\u001a\u00020\u000b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u000f\u0010\r\u001a+\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0010\u0010\t\u001a\u0019\u0010\u0012\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a3\u0010\u0017\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0014*\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00150\u00032\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\r\u001a\r\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a\r\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a,\u0010 \u001a\u00020\u00072\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u000b0\u001c¢\u0006\u0002\b\u001eH\u0086\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a,\u0010\"\u001a\u00020\u00022\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u000b0\u001c¢\u0006\u0002\b\u001eH\u0086\bø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u0011\u0010$\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0004\b$\u0010%\"\u0015\u0010'\u001a\u00020&*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b'\u0010(\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, m1599d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/collections/Attributes;", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", SubscriberAttributeKt.JSON_NAME_KEY, "get", "(Laws/smithy/kotlin/runtime/collections/Attributes;Laws/smithy/kotlin/runtime/collections/AttributeKey;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/collections/MutableAttributes;", "take", "(Laws/smithy/kotlin/runtime/collections/MutableAttributes;Laws/smithy/kotlin/runtime/collections/AttributeKey;)Ljava/lang/Object;", "value", "", "putIfAbsent", "(Laws/smithy/kotlin/runtime/collections/MutableAttributes;Laws/smithy/kotlin/runtime/collections/AttributeKey;Ljava/lang/Object;)V", "putIfAbsentNotNull", "setIfValueNotNull", "takeOrNull", "other", "merge", "(Laws/smithy/kotlin/runtime/collections/MutableAttributes;Laws/smithy/kotlin/runtime/collections/Attributes;)V", ExifInterface.LONGITUDE_EAST, "", "element", "appendValue", "emptyAttributes", "()Laws/smithy/kotlin/runtime/collections/Attributes;", "mutableAttributes", "()Laws/smithy/kotlin/runtime/collections/MutableAttributes;", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/collections/AttributesBuilder;", "Lkotlin/ExtensionFunctionType;", "block", "mutableAttributesOf", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/collections/MutableAttributes;", "attributesOf", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/collections/Attributes;", "toMutableAttributes", "(Laws/smithy/kotlin/runtime/collections/Attributes;)Laws/smithy/kotlin/runtime/collections/MutableAttributes;", "", "isNotEmpty", "(Laws/smithy/kotlin/runtime/collections/Attributes;)Z", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AttributesKt {
    public static final boolean isNotEmpty(Attributes attributes) {
        Intrinsics.checkNotNullParameter(attributes, "<this>");
        return !attributes.isEmpty();
    }

    public static final <T> T get(Attributes attributes, AttributeKey<T> key) {
        Intrinsics.checkNotNullParameter(attributes, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        T t = (T) attributes.getOrNull(key);
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("No instance for " + key);
    }

    public static final <T> T take(MutableAttributes mutableAttributes, AttributeKey<T> key) {
        Intrinsics.checkNotNullParameter(mutableAttributes, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        T t = (T) get(mutableAttributes, key);
        mutableAttributes.remove(key);
        return t;
    }

    public static final <T> void putIfAbsent(MutableAttributes mutableAttributes, AttributeKey<T> key, T value) {
        Intrinsics.checkNotNullParameter(mutableAttributes, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (mutableAttributes.contains(key)) {
            return;
        }
        mutableAttributes.set(key, value);
    }

    public static final <T> void putIfAbsentNotNull(MutableAttributes mutableAttributes, AttributeKey<T> key, T t) {
        Intrinsics.checkNotNullParameter(mutableAttributes, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (t != null) {
            putIfAbsent(mutableAttributes, key, t);
        }
    }

    public static final <T> void setIfValueNotNull(MutableAttributes mutableAttributes, AttributeKey<T> key, T t) {
        Intrinsics.checkNotNullParameter(mutableAttributes, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (t != null) {
            mutableAttributes.set(key, t);
        }
    }

    public static final <T> T takeOrNull(MutableAttributes mutableAttributes, AttributeKey<T> key) {
        Intrinsics.checkNotNullParameter(mutableAttributes, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        T t = (T) mutableAttributes.getOrNull(key);
        mutableAttributes.remove(key);
        return t;
    }

    public static final void merge(MutableAttributes mutableAttributes, Attributes other) {
        Intrinsics.checkNotNullParameter(mutableAttributes, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Iterator<T> it = other.getKeys().iterator();
        while (it.hasNext()) {
            AttributeKey attributeKey = (AttributeKey) it.next();
            Intrinsics.checkNotNull(attributeKey, "null cannot be cast to non-null type aws.smithy.kotlin.runtime.collections.AttributeKey<kotlin.Any>");
            mutableAttributes.set(attributeKey, get(other, attributeKey));
        }
    }

    public static final <E> void appendValue(MutableAttributes mutableAttributes, AttributeKey<List<E>> key, E e) {
        Intrinsics.checkNotNullParameter(mutableAttributes, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        List listEmptyList = (List) mutableAttributes.getOrNull(key);
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        mutableAttributes.set(key, CollectionsKt.plus((Collection<? extends E>) listEmptyList, e));
    }

    public static final Attributes emptyAttributes() {
        return EmptyAttributes.INSTANCE;
    }

    public static final MutableAttributes mutableAttributes() {
        return new AttributesImpl();
    }

    public static final MutableAttributes mutableAttributesOf(Function1<? super AttributesBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        block.invoke(attributesBuilder);
        return attributesBuilder.getAttributes();
    }

    public static final MutableAttributes toMutableAttributes(Attributes attributes) {
        Intrinsics.checkNotNullParameter(attributes, "<this>");
        return new AttributesImpl(attributes);
    }

    public static final Attributes attributesOf(Function1<? super AttributesBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        block.invoke(attributesBuilder);
        return attributesBuilder.getAttributes();
    }
}
