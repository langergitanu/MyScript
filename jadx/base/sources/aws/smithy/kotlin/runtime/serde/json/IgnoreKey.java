package aws.smithy.kotlin.runtime.serde.json;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.serde.FieldTrait;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonFieldTraits.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/IgnoreKey;", "Laws/smithy/kotlin/runtime/serde/FieldTrait;", SubscriberAttributeKt.JSON_NAME_KEY, "", "<init>", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class IgnoreKey implements FieldTrait {
    private final String key;

    public static /* synthetic */ IgnoreKey copy$default(IgnoreKey ignoreKey, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ignoreKey.key;
        }
        return ignoreKey.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public final IgnoreKey copy(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new IgnoreKey(key);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof IgnoreKey) && Intrinsics.areEqual(this.key, ((IgnoreKey) other).key);
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public String toString() {
        return "IgnoreKey(key=" + this.key + ')';
    }

    public IgnoreKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
    }

    public final String getKey() {
        return this.key;
    }
}
