package com.myscript.shared.datacollect;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: S3FileUploader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, m1599d2 = {"Lcom/myscript/shared/datacollect/S3ClientConfig;", "", "bucketName", "", TtmlNode.TAG_REGION, "credentials", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "objectKeyPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;Ljava/lang/String;)V", "getBucketName", "()Ljava/lang/String;", "getRegion", "getCredentials", "()Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "getObjectKeyPath", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "shared-datacollect_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class S3ClientConfig {
    private final String bucketName;
    private final CredentialsProvider credentials;
    private final String objectKeyPath;
    private final String region;

    public static /* synthetic */ S3ClientConfig copy$default(S3ClientConfig s3ClientConfig, String str, String str2, CredentialsProvider credentialsProvider, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = s3ClientConfig.bucketName;
        }
        if ((i & 2) != 0) {
            str2 = s3ClientConfig.region;
        }
        if ((i & 4) != 0) {
            credentialsProvider = s3ClientConfig.credentials;
        }
        if ((i & 8) != 0) {
            str3 = s3ClientConfig.objectKeyPath;
        }
        return s3ClientConfig.copy(str, str2, credentialsProvider, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBucketName() {
        return this.bucketName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CredentialsProvider getCredentials() {
        return this.credentials;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getObjectKeyPath() {
        return this.objectKeyPath;
    }

    public final S3ClientConfig copy(String bucketName, String region, CredentialsProvider credentials, String objectKeyPath) {
        Intrinsics.checkNotNullParameter(bucketName, "bucketName");
        Intrinsics.checkNotNullParameter(region, "region");
        Intrinsics.checkNotNullParameter(credentials, "credentials");
        Intrinsics.checkNotNullParameter(objectKeyPath, "objectKeyPath");
        return new S3ClientConfig(bucketName, region, credentials, objectKeyPath);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof S3ClientConfig)) {
            return false;
        }
        S3ClientConfig s3ClientConfig = (S3ClientConfig) other;
        return Intrinsics.areEqual(this.bucketName, s3ClientConfig.bucketName) && Intrinsics.areEqual(this.region, s3ClientConfig.region) && Intrinsics.areEqual(this.credentials, s3ClientConfig.credentials) && Intrinsics.areEqual(this.objectKeyPath, s3ClientConfig.objectKeyPath);
    }

    public int hashCode() {
        return (((((this.bucketName.hashCode() * 31) + this.region.hashCode()) * 31) + this.credentials.hashCode()) * 31) + this.objectKeyPath.hashCode();
    }

    public String toString() {
        return "S3ClientConfig(bucketName=" + this.bucketName + ", region=" + this.region + ", credentials=" + this.credentials + ", objectKeyPath=" + this.objectKeyPath + ")";
    }

    public S3ClientConfig(String bucketName, String region, CredentialsProvider credentials, String objectKeyPath) {
        Intrinsics.checkNotNullParameter(bucketName, "bucketName");
        Intrinsics.checkNotNullParameter(region, "region");
        Intrinsics.checkNotNullParameter(credentials, "credentials");
        Intrinsics.checkNotNullParameter(objectKeyPath, "objectKeyPath");
        this.bucketName = bucketName;
        this.region = region;
        this.credentials = credentials;
        this.objectKeyPath = objectKeyPath;
    }

    public final String getBucketName() {
        return this.bucketName;
    }

    public final String getRegion() {
        return this.region;
    }

    public final CredentialsProvider getCredentials() {
        return this.credentials;
    }

    public final String getObjectKeyPath() {
        return this.objectKeyPath;
    }
}
