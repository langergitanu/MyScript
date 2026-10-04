package aws.sdk.kotlin.runtime.http;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AwsUserAgentMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\n\u001a\u00020\u0003H\u0096\u0080\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/ApiMetadata;", "", "serviceId", "", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getServiceId", "()Ljava/lang/String;", "getVersion", "toString", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@InternalSdkApi
public final /* data */ class ApiMetadata {
    private final String serviceId;
    private final String version;

    public static /* synthetic */ ApiMetadata copy$default(ApiMetadata apiMetadata, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = apiMetadata.serviceId;
        }
        if ((i & 2) != 0) {
            str2 = apiMetadata.version;
        }
        return apiMetadata.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getServiceId() {
        return this.serviceId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final ApiMetadata copy(String serviceId, String version) {
        Intrinsics.checkNotNullParameter(serviceId, "serviceId");
        Intrinsics.checkNotNullParameter(version, "version");
        return new ApiMetadata(serviceId, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiMetadata)) {
            return false;
        }
        ApiMetadata apiMetadata = (ApiMetadata) other;
        return Intrinsics.areEqual(this.serviceId, apiMetadata.serviceId) && Intrinsics.areEqual(this.version, apiMetadata.version);
    }

    public int hashCode() {
        return (this.serviceId.hashCode() * 31) + this.version.hashCode();
    }

    public ApiMetadata(String serviceId, String version) {
        Intrinsics.checkNotNullParameter(serviceId, "serviceId");
        Intrinsics.checkNotNullParameter(version, "version");
        this.serviceId = serviceId;
        this.version = version;
    }

    public final String getServiceId() {
        return this.serviceId;
    }

    public final String getVersion() {
        return this.version;
    }

    public String toString() {
        String lowerCase = StringsKt.replace$default(this.serviceId, " ", "-", false, 4, (Object) null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return AwsUserAgentMetadataKt.uaPair("api", lowerCase, this.version);
    }
}
