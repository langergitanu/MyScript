package aws.sdk.kotlin.runtime.http;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.smithy.kotlin.runtime.util.OsFamily;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AwsUserAgentMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\f\u001a\u00020\u0005H\u0096\u0080\u0004J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/OsMetadata;", "", "family", "Laws/smithy/kotlin/runtime/util/OsFamily;", "version", "", "<init>", "(Laws/smithy/kotlin/runtime/util/OsFamily;Ljava/lang/String;)V", "getFamily", "()Laws/smithy/kotlin/runtime/util/OsFamily;", "getVersion", "()Ljava/lang/String;", "toString", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@InternalSdkApi
public final /* data */ class OsMetadata {
    private final OsFamily family;
    private final String version;

    /* JADX INFO: compiled from: AwsUserAgentMetadata.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OsFamily.values().length];
            try {
                iArr[OsFamily.Unknown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ OsMetadata copy$default(OsMetadata osMetadata, OsFamily osFamily, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            osFamily = osMetadata.family;
        }
        if ((i & 2) != 0) {
            str = osMetadata.version;
        }
        return osMetadata.copy(osFamily, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final OsFamily getFamily() {
        return this.family;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final OsMetadata copy(OsFamily family, String version) {
        Intrinsics.checkNotNullParameter(family, "family");
        return new OsMetadata(family, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OsMetadata)) {
            return false;
        }
        OsMetadata osMetadata = (OsMetadata) other;
        return this.family == osMetadata.family && Intrinsics.areEqual(this.version, osMetadata.version);
    }

    public int hashCode() {
        int iHashCode = this.family.hashCode() * 31;
        String str = this.version;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public OsMetadata(OsFamily family, String str) {
        Intrinsics.checkNotNullParameter(family, "family");
        this.family = family;
        this.version = str;
    }

    public /* synthetic */ OsMetadata(OsFamily osFamily, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(osFamily, (i & 2) != 0 ? null : str);
    }

    public final OsFamily getFamily() {
        return this.family;
    }

    public final String getVersion() {
        return this.version;
    }

    public String toString() {
        String string;
        if (WhenMappings.$EnumSwitchMapping$0[this.family.ordinal()] == 1) {
            string = "other";
        } else {
            string = this.family.toString();
        }
        return AwsUserAgentMetadataKt.uaPair("os", string, this.version);
    }
}
