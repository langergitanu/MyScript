package aws.smithy.kotlin.runtime.serde.xml;

import androidx.webkit.Profile;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.serde.FieldTrait;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XmlFieldTraits.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlMapName;", "Laws/smithy/kotlin/runtime/serde/FieldTrait;", "entry", "", SubscriberAttributeKt.JSON_NAME_KEY, "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEntry", "()Ljava/lang/String;", "getKey", "getValue", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class XmlMapName implements FieldTrait {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final XmlMapName Default = new XmlMapName("entry", SubscriberAttributeKt.JSON_NAME_KEY, "value");
    private final String entry;
    private final String key;
    private final String value;

    public XmlMapName() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ XmlMapName copy$default(XmlMapName xmlMapName, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = xmlMapName.entry;
        }
        if ((i & 2) != 0) {
            str2 = xmlMapName.key;
        }
        if ((i & 4) != 0) {
            str3 = xmlMapName.value;
        }
        return xmlMapName.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEntry() {
        return this.entry;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final XmlMapName copy(String entry, String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return new XmlMapName(entry, key, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof XmlMapName)) {
            return false;
        }
        XmlMapName xmlMapName = (XmlMapName) other;
        return Intrinsics.areEqual(this.entry, xmlMapName.entry) && Intrinsics.areEqual(this.key, xmlMapName.key) && Intrinsics.areEqual(this.value, xmlMapName.value);
    }

    public int hashCode() {
        String str = this.entry;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.key.hashCode()) * 31) + this.value.hashCode();
    }

    public String toString() {
        return "XmlMapName(entry=" + this.entry + ", key=" + this.key + ", value=" + this.value + ')';
    }

    public XmlMapName(String str, String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.entry = str;
        this.key = key;
        this.value = value;
    }

    public /* synthetic */ XmlMapName(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Default.entry : str, (i & 2) != 0 ? Default.key : str2, (i & 4) != 0 ? Default.value : str3);
    }

    public final String getEntry() {
        return this.entry;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: compiled from: XmlFieldTraits.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlMapName$Companion;", "", "<init>", "()V", Profile.DEFAULT_PROFILE_NAME, "Laws/smithy/kotlin/runtime/serde/xml/XmlMapName;", "getDefault", "()Laws/smithy/kotlin/runtime/serde/xml/XmlMapName;", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final XmlMapName getDefault() {
            return XmlMapName.Default;
        }
    }
}
