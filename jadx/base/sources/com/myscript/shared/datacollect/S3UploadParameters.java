package com.myscript.shared.datacollect;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: S3UploadParameters.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, m1599d2 = {"Lcom/myscript/shared/datacollect/S3UploadParameters;", "", "objectKeyPath", "", "bucket", TtmlNode.TAG_REGION, "accessKeyId", "secretAccessKey", "sessionToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getObjectKeyPath", "()Ljava/lang/String;", "getBucket", "getRegion", "getAccessKeyId", "getSecretAccessKey", "getSessionToken", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "shared-datacollect_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class S3UploadParameters {

    @SerializedName("accessKeyId")
    private final String accessKeyId;

    @SerializedName("bucket")
    private final String bucket;

    @SerializedName("objectKeyPath")
    private final String objectKeyPath;

    @SerializedName(TtmlNode.TAG_REGION)
    private final String region;

    @SerializedName("secretAccessKey")
    private final String secretAccessKey;

    @SerializedName("sessionToken")
    private final String sessionToken;

    public static /* synthetic */ S3UploadParameters copy$default(S3UploadParameters s3UploadParameters, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = s3UploadParameters.objectKeyPath;
        }
        if ((i & 2) != 0) {
            str2 = s3UploadParameters.bucket;
        }
        if ((i & 4) != 0) {
            str3 = s3UploadParameters.region;
        }
        if ((i & 8) != 0) {
            str4 = s3UploadParameters.accessKeyId;
        }
        if ((i & 16) != 0) {
            str5 = s3UploadParameters.secretAccessKey;
        }
        if ((i & 32) != 0) {
            str6 = s3UploadParameters.sessionToken;
        }
        String str7 = str5;
        String str8 = str6;
        return s3UploadParameters.copy(str, str2, str3, str4, str7, str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getObjectKeyPath() {
        return this.objectKeyPath;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBucket() {
        return this.bucket;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAccessKeyId() {
        return this.accessKeyId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSessionToken() {
        return this.sessionToken;
    }

    public final S3UploadParameters copy(String objectKeyPath, String bucket, String region, String accessKeyId, String secretAccessKey, String sessionToken) {
        Intrinsics.checkNotNullParameter(objectKeyPath, "objectKeyPath");
        Intrinsics.checkNotNullParameter(bucket, "bucket");
        Intrinsics.checkNotNullParameter(region, "region");
        Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
        Intrinsics.checkNotNullParameter(secretAccessKey, "secretAccessKey");
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        return new S3UploadParameters(objectKeyPath, bucket, region, accessKeyId, secretAccessKey, sessionToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof S3UploadParameters)) {
            return false;
        }
        S3UploadParameters s3UploadParameters = (S3UploadParameters) other;
        return Intrinsics.areEqual(this.objectKeyPath, s3UploadParameters.objectKeyPath) && Intrinsics.areEqual(this.bucket, s3UploadParameters.bucket) && Intrinsics.areEqual(this.region, s3UploadParameters.region) && Intrinsics.areEqual(this.accessKeyId, s3UploadParameters.accessKeyId) && Intrinsics.areEqual(this.secretAccessKey, s3UploadParameters.secretAccessKey) && Intrinsics.areEqual(this.sessionToken, s3UploadParameters.sessionToken);
    }

    public int hashCode() {
        return (((((((((this.objectKeyPath.hashCode() * 31) + this.bucket.hashCode()) * 31) + this.region.hashCode()) * 31) + this.accessKeyId.hashCode()) * 31) + this.secretAccessKey.hashCode()) * 31) + this.sessionToken.hashCode();
    }

    public String toString() {
        return "S3UploadParameters(objectKeyPath=" + this.objectKeyPath + ", bucket=" + this.bucket + ", region=" + this.region + ", accessKeyId=" + this.accessKeyId + ", secretAccessKey=" + this.secretAccessKey + ", sessionToken=" + this.sessionToken + ")";
    }

    public S3UploadParameters(String objectKeyPath, String bucket, String region, String accessKeyId, String secretAccessKey, String sessionToken) {
        Intrinsics.checkNotNullParameter(objectKeyPath, "objectKeyPath");
        Intrinsics.checkNotNullParameter(bucket, "bucket");
        Intrinsics.checkNotNullParameter(region, "region");
        Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
        Intrinsics.checkNotNullParameter(secretAccessKey, "secretAccessKey");
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        this.objectKeyPath = objectKeyPath;
        this.bucket = bucket;
        this.region = region;
        this.accessKeyId = accessKeyId;
        this.secretAccessKey = secretAccessKey;
        this.sessionToken = sessionToken;
    }

    public final String getObjectKeyPath() {
        return this.objectKeyPath;
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getAccessKeyId() {
        return this.accessKeyId;
    }

    public final String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    public final String getSessionToken() {
        return this.sessionToken;
    }
}
