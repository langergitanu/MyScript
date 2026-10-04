package aws.smithy.kotlin.runtime.collections;

import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Attributes.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J0\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0006\u001a\u00028\u0000H¦\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\n\u001a\u00020\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\u000e\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/MutableAttributes;", "Laws/smithy/kotlin/runtime/collections/Attributes;", "", ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/collections/AttributeKey;", SubscriberAttributeKt.JSON_NAME_KEY, "value", "", "set", "(Laws/smithy/kotlin/runtime/collections/AttributeKey;Ljava/lang/Object;)V", "remove", "(Laws/smithy/kotlin/runtime/collections/AttributeKey;)V", "Lkotlin/Function0;", "block", "computeIfAbsent", "(Laws/smithy/kotlin/runtime/collections/AttributeKey;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface MutableAttributes extends Attributes {
    <T> T computeIfAbsent(AttributeKey<T> key, Function0<? extends T> block);

    <T> void remove(AttributeKey<T> key);

    <T> void set(AttributeKey<T> key, T value);
}
