package com.myscript.nebo.dms.sharepage.api.entity;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PublishResult.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0019B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/api/entity/PublishResult;", "", DiagnosticsEntry.TIMESTAMP_KEY, "", ImagesContract.URL, "", "publicationDate", "s3UploadParameters", "Lcom/myscript/nebo/dms/sharepage/api/entity/PublishResult$S3UploadParameters;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lcom/myscript/nebo/dms/sharepage/api/entity/PublishResult$S3UploadParameters;)V", "publicationTimestamp", "getPublicationTimestamp", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "S3UploadParameters", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class PublishResult {

    @SerializedName("publicationDate")
    public final String publicationDate;

    @SerializedName("s3UploadParameters")
    public final S3UploadParameters s3UploadParameters;

    @SerializedName(DiagnosticsEntry.TIMESTAMP_KEY)
    public final long timestamp;

    @SerializedName(ImagesContract.URL)
    public final String url;

    public PublishResult() {
        this(0L, null, null, null, 15, null);
    }

    public static /* synthetic */ PublishResult copy$default(PublishResult publishResult, long j, String str, String str2, S3UploadParameters s3UploadParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            j = publishResult.timestamp;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = publishResult.url;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = publishResult.publicationDate;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            s3UploadParameters = publishResult.s3UploadParameters;
        }
        return publishResult.copy(j2, str3, str4, s3UploadParameters);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPublicationDate() {
        return this.publicationDate;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final S3UploadParameters getS3UploadParameters() {
        return this.s3UploadParameters;
    }

    public final PublishResult copy(long timestamp, String url, String publicationDate, S3UploadParameters s3UploadParameters) {
        return new PublishResult(timestamp, url, publicationDate, s3UploadParameters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublishResult)) {
            return false;
        }
        PublishResult publishResult = (PublishResult) other;
        return this.timestamp == publishResult.timestamp && Intrinsics.areEqual(this.url, publishResult.url) && Intrinsics.areEqual(this.publicationDate, publishResult.publicationDate) && Intrinsics.areEqual(this.s3UploadParameters, publishResult.s3UploadParameters);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.timestamp) * 31;
        String str = this.url;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.publicationDate;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        S3UploadParameters s3UploadParameters = this.s3UploadParameters;
        return iHashCode3 + (s3UploadParameters != null ? s3UploadParameters.hashCode() : 0);
    }

    public String toString() {
        return "PublishResult(timestamp=" + this.timestamp + ", url=" + this.url + ", publicationDate=" + this.publicationDate + ", s3UploadParameters=" + this.s3UploadParameters + ")";
    }

    public PublishResult(long j, String str, String str2, S3UploadParameters s3UploadParameters) {
        this.timestamp = j;
        this.url = str;
        this.publicationDate = str2;
        this.s3UploadParameters = s3UploadParameters;
    }

    public /* synthetic */ PublishResult(long j, String str, String str2, S3UploadParameters s3UploadParameters, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : s3UploadParameters);
    }

    public final long getPublicationTimestamp() {
        String str = this.publicationDate;
        if (str != null) {
            return DateUtilsKt.parseTimestampISO8601(str);
        }
        return 0L;
    }

    /* JADX INFO: compiled from: PublishResult.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ji\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/api/entity/PublishResult$S3UploadParameters;", "", "objectKey", "", "contentType", "contentDisposition", "bucket", TtmlNode.TAG_REGION, "accessKeyId", "secretAccessKey", "sessionToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class S3UploadParameters {

        @SerializedName("accessKeyId")
        public final String accessKeyId;

        @SerializedName("bucket")
        public final String bucket;

        @SerializedName("contentDisposition")
        public final String contentDisposition;

        @SerializedName("contentType")
        public final String contentType;

        @SerializedName("objectKey")
        public final String objectKey;

        @SerializedName(TtmlNode.TAG_REGION)
        public final String region;

        @SerializedName("secretAccessKey")
        public final String secretAccessKey;

        @SerializedName("sessionToken")
        public final String sessionToken;

        public S3UploadParameters() {
            this(null, null, null, null, null, null, null, null, 255, null);
        }

        public static /* synthetic */ S3UploadParameters copy$default(S3UploadParameters s3UploadParameters, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
            if ((i & 1) != 0) {
                str = s3UploadParameters.objectKey;
            }
            if ((i & 2) != 0) {
                str2 = s3UploadParameters.contentType;
            }
            if ((i & 4) != 0) {
                str3 = s3UploadParameters.contentDisposition;
            }
            if ((i & 8) != 0) {
                str4 = s3UploadParameters.bucket;
            }
            if ((i & 16) != 0) {
                str5 = s3UploadParameters.region;
            }
            if ((i & 32) != 0) {
                str6 = s3UploadParameters.accessKeyId;
            }
            if ((i & 64) != 0) {
                str7 = s3UploadParameters.secretAccessKey;
            }
            if ((i & 128) != 0) {
                str8 = s3UploadParameters.sessionToken;
            }
            String str9 = str7;
            String str10 = str8;
            String str11 = str5;
            String str12 = str6;
            return s3UploadParameters.copy(str, str2, str3, str4, str11, str12, str9, str10);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getObjectKey() {
            return this.objectKey;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getContentType() {
            return this.contentType;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getContentDisposition() {
            return this.contentDisposition;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getBucket() {
            return this.bucket;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getRegion() {
            return this.region;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getAccessKeyId() {
            return this.accessKeyId;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getSecretAccessKey() {
            return this.secretAccessKey;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getSessionToken() {
            return this.sessionToken;
        }

        public final S3UploadParameters copy(String objectKey, String contentType, String contentDisposition, String bucket, String region, String accessKeyId, String secretAccessKey, String sessionToken) {
            return new S3UploadParameters(objectKey, contentType, contentDisposition, bucket, region, accessKeyId, secretAccessKey, sessionToken);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof S3UploadParameters)) {
                return false;
            }
            S3UploadParameters s3UploadParameters = (S3UploadParameters) other;
            return Intrinsics.areEqual(this.objectKey, s3UploadParameters.objectKey) && Intrinsics.areEqual(this.contentType, s3UploadParameters.contentType) && Intrinsics.areEqual(this.contentDisposition, s3UploadParameters.contentDisposition) && Intrinsics.areEqual(this.bucket, s3UploadParameters.bucket) && Intrinsics.areEqual(this.region, s3UploadParameters.region) && Intrinsics.areEqual(this.accessKeyId, s3UploadParameters.accessKeyId) && Intrinsics.areEqual(this.secretAccessKey, s3UploadParameters.secretAccessKey) && Intrinsics.areEqual(this.sessionToken, s3UploadParameters.sessionToken);
        }

        public int hashCode() {
            String str = this.objectKey;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.contentType;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.contentDisposition;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.bucket;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.region;
            int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.accessKeyId;
            int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.secretAccessKey;
            int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.sessionToken;
            return iHashCode7 + (str8 != null ? str8.hashCode() : 0);
        }

        public String toString() {
            return "S3UploadParameters(objectKey=" + this.objectKey + ", contentType=" + this.contentType + ", contentDisposition=" + this.contentDisposition + ", bucket=" + this.bucket + ", region=" + this.region + ", accessKeyId=" + this.accessKeyId + ", secretAccessKey=" + this.secretAccessKey + ", sessionToken=" + this.sessionToken + ")";
        }

        public S3UploadParameters(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.objectKey = str;
            this.contentType = str2;
            this.contentDisposition = str3;
            this.bucket = str4;
            this.region = str5;
            this.accessKeyId = str6;
            this.secretAccessKey = str7;
            this.sessionToken = str8;
        }

        public /* synthetic */ S3UploadParameters(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8);
        }
    }
}
