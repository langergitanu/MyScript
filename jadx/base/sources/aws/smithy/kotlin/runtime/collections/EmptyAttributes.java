package aws.smithy.kotlin.runtime.collections;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Attributes.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\n*\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0096\u0082\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00068\u0016X\u0096D¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R$\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/EmptyAttributes;", "Laws/smithy/kotlin/runtime/collections/Attributes;", "<init>", "()V", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", SubscriberAttributeKt.JSON_NAME_KEY, "", "contains", "(Laws/smithy/kotlin/runtime/collections/AttributeKey;)Z", "", ExifInterface.GPS_DIRECTION_TRUE, "getOrNull", "(Laws/smithy/kotlin/runtime/collections/AttributeKey;)Ljava/lang/Object;", "other", "equals", "(Ljava/lang/Object;)Z", "isEmpty", "Z", "()Z", "", UserMetadata.KEYDATA_FILENAME, "Ljava/util/Set;", "getKeys", "()Ljava/util/Set;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class EmptyAttributes implements Attributes {
    public static final EmptyAttributes INSTANCE = new EmptyAttributes();
    private static final boolean isEmpty = true;
    private static final Set<AttributeKey<?>> keys = SetsKt.emptySet();

    @Override // aws.smithy.kotlin.runtime.collections.Attributes
    public boolean contains(AttributeKey<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return false;
    }

    @Override // aws.smithy.kotlin.runtime.collections.Attributes
    public <T> T getOrNull(AttributeKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    private EmptyAttributes() {
    }

    @Override // aws.smithy.kotlin.runtime.collections.Attributes
    public boolean isEmpty() {
        return isEmpty;
    }

    @Override // aws.smithy.kotlin.runtime.collections.Attributes
    public Set<AttributeKey<?>> getKeys() {
        return keys;
    }

    public boolean equals(Object other) {
        return (other instanceof Attributes) && ((Attributes) other).isEmpty();
    }
}
