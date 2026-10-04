package aws.sdk.kotlin.services.p010s3.express;

import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: S3ExpressCredentialsCache.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/express/S3ExpressCredentialsCacheKey;", "", "bucket", "", "baseCredentials", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "<init>", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;)V", "getBucket", "()Ljava/lang/String;", "getBaseCredentials", "()Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class S3ExpressCredentialsCacheKey {
    private final Credentials baseCredentials;
    private final String bucket;

    public static /* synthetic */ S3ExpressCredentialsCacheKey copy$default(S3ExpressCredentialsCacheKey s3ExpressCredentialsCacheKey, String str, Credentials credentials, int i, Object obj) {
        if ((i & 1) != 0) {
            str = s3ExpressCredentialsCacheKey.bucket;
        }
        if ((i & 2) != 0) {
            credentials = s3ExpressCredentialsCacheKey.baseCredentials;
        }
        return s3ExpressCredentialsCacheKey.copy(str, credentials);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBucket() {
        return this.bucket;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Credentials getBaseCredentials() {
        return this.baseCredentials;
    }

    public final S3ExpressCredentialsCacheKey copy(String bucket, Credentials baseCredentials) {
        Intrinsics.checkNotNullParameter(bucket, "bucket");
        Intrinsics.checkNotNullParameter(baseCredentials, "baseCredentials");
        return new S3ExpressCredentialsCacheKey(bucket, baseCredentials);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof S3ExpressCredentialsCacheKey)) {
            return false;
        }
        S3ExpressCredentialsCacheKey s3ExpressCredentialsCacheKey = (S3ExpressCredentialsCacheKey) other;
        return Intrinsics.areEqual(this.bucket, s3ExpressCredentialsCacheKey.bucket) && Intrinsics.areEqual(this.baseCredentials, s3ExpressCredentialsCacheKey.baseCredentials);
    }

    public int hashCode() {
        return (this.bucket.hashCode() * 31) + this.baseCredentials.hashCode();
    }

    public String toString() {
        return "S3ExpressCredentialsCacheKey(bucket=" + this.bucket + ", baseCredentials=" + this.baseCredentials + ')';
    }

    public S3ExpressCredentialsCacheKey(String bucket, Credentials baseCredentials) {
        Intrinsics.checkNotNullParameter(bucket, "bucket");
        Intrinsics.checkNotNullParameter(baseCredentials, "baseCredentials");
        this.bucket = bucket;
        this.baseCredentials = baseCredentials;
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final Credentials getBaseCredentials() {
        return this.baseCredentials;
    }
}
