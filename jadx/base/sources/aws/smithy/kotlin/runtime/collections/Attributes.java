package aws.smithy.kotlin.runtime.collections;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: compiled from: Attributes.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J)\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H¦\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/Attributes;", "", ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/collections/AttributeKey;", SubscriberAttributeKt.JSON_NAME_KEY, "getOrNull", "(Laws/smithy/kotlin/runtime/collections/AttributeKey;)Ljava/lang/Object;", "", "contains", "(Laws/smithy/kotlin/runtime/collections/AttributeKey;)Z", "isEmpty", "()Z", "", "getKeys", "()Ljava/util/Set;", UserMetadata.KEYDATA_FILENAME, "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface Attributes {
    boolean contains(AttributeKey<?> key);

    Set<AttributeKey<?>> getKeys();

    <T> T getOrNull(AttributeKey<T> key);

    boolean isEmpty();
}
