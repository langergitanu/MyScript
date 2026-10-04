package aws.sdk.kotlin.runtime.http.operation;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.sdk.kotlin.runtime.http.AwsUserAgentMetadataKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomUserAgentMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\n\u001a\u00020\u0003H\u0096\u0080\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/operation/FeatureMetadata;", "Laws/sdk/kotlin/runtime/http/operation/TypedUserAgentMetadata;", "name", "", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getVersion", "toString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@InternalSdkApi
public final /* data */ class FeatureMetadata implements TypedUserAgentMetadata {
    private final String name;
    private final String version;

    public static /* synthetic */ FeatureMetadata copy$default(FeatureMetadata featureMetadata, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = featureMetadata.name;
        }
        if ((i & 2) != 0) {
            str2 = featureMetadata.version;
        }
        return featureMetadata.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final FeatureMetadata copy(String name, String version) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new FeatureMetadata(name, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeatureMetadata)) {
            return false;
        }
        FeatureMetadata featureMetadata = (FeatureMetadata) other;
        return Intrinsics.areEqual(this.name, featureMetadata.name) && Intrinsics.areEqual(this.version, featureMetadata.version);
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.version;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public FeatureMetadata(String name, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.version = str;
    }

    public /* synthetic */ FeatureMetadata(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public final String getName() {
        return this.name;
    }

    public final String getVersion() {
        return this.version;
    }

    public String toString() {
        return AwsUserAgentMetadataKt.uaPair("ft", this.name, this.version);
    }
}
