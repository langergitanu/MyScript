package aws.smithy.kotlin.runtime.collections;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Attributes.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0003H\u0096\u0080\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ \u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\u00020\u0010HÖ\u0081\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\b¨\u0006\u0015"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/AttributeKey;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "name", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "component1", "copy", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/collections/AttributeKey;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getName", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class AttributeKey<T> {
    private final String name;

    public static /* synthetic */ AttributeKey copy$default(AttributeKey attributeKey, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = attributeKey.name;
        }
        return attributeKey.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final AttributeKey<T> copy(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new AttributeKey<>(name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AttributeKey) && Intrinsics.areEqual(this.name, ((AttributeKey) other).name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public AttributeKey(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        if (StringsKt.isBlank(name)) {
            throw new IllegalArgumentException("AttributeKey name must not be blank".toString());
        }
    }

    public final String getName() {
        return this.name;
    }

    public String toString() {
        return "AttributeKey(" + this.name + ')';
    }
}
