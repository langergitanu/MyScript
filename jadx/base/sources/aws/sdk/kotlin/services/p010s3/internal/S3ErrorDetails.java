package aws.sdk.kotlin.services.p010s3.internal;

import aws.smithy.kotlin.runtime.awsprotocol.AwsErrorDetails;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: S3ErrorMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/internal/S3ErrorDetails;", "Laws/smithy/kotlin/runtime/awsprotocol/AwsErrorDetails;", "code", "", "message", "requestId", "requestId2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getMessage", "getRequestId", "getRequestId2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class S3ErrorDetails implements AwsErrorDetails {
    private final String code;
    private final String message;
    private final String requestId;
    private final String requestId2;

    public S3ErrorDetails() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ S3ErrorDetails copy$default(S3ErrorDetails s3ErrorDetails, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = s3ErrorDetails.code;
        }
        if ((i & 2) != 0) {
            str2 = s3ErrorDetails.message;
        }
        if ((i & 4) != 0) {
            str3 = s3ErrorDetails.requestId;
        }
        if ((i & 8) != 0) {
            str4 = s3ErrorDetails.requestId2;
        }
        return s3ErrorDetails.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRequestId2() {
        return this.requestId2;
    }

    public final S3ErrorDetails copy(String code, String message, String requestId, String requestId2) {
        return new S3ErrorDetails(code, message, requestId, requestId2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof S3ErrorDetails)) {
            return false;
        }
        S3ErrorDetails s3ErrorDetails = (S3ErrorDetails) other;
        return Intrinsics.areEqual(this.code, s3ErrorDetails.code) && Intrinsics.areEqual(this.message, s3ErrorDetails.message) && Intrinsics.areEqual(this.requestId, s3ErrorDetails.requestId) && Intrinsics.areEqual(this.requestId2, s3ErrorDetails.requestId2);
    }

    public int hashCode() {
        String str = this.code;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.message;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.requestId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.requestId2;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "S3ErrorDetails(code=" + this.code + ", message=" + this.message + ", requestId=" + this.requestId + ", requestId2=" + this.requestId2 + ')';
    }

    public S3ErrorDetails(String str, String str2, String str3, String str4) {
        this.code = str;
        this.message = str2;
        this.requestId = str3;
        this.requestId2 = str4;
    }

    public /* synthetic */ S3ErrorDetails(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    @Override // aws.smithy.kotlin.runtime.awsprotocol.AwsErrorDetails
    public String getCode() {
        return this.code;
    }

    @Override // aws.smithy.kotlin.runtime.awsprotocol.AwsErrorDetails
    public String getMessage() {
        return this.message;
    }

    @Override // aws.smithy.kotlin.runtime.awsprotocol.AwsErrorDetails
    public String getRequestId() {
        return this.requestId;
    }

    public final String getRequestId2() {
        return this.requestId2;
    }
}
