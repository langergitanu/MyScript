package aws.smithy.kotlin.runtime.awsprotocol;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProtocolErrors.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ4\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0083\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u00020\u0013HÖ\u0081\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b\u0016\u0010\tR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\tR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001a\u0010\t¨\u0006\u001b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/ErrorDetails;", "Laws/smithy/kotlin/runtime/awsprotocol/AwsErrorDetails;", "", "code", "message", "requestId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Laws/smithy/kotlin/runtime/awsprotocol/ErrorDetails;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCode", "getMessage", "getRequestId", "aws-protocol-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ErrorDetails implements AwsErrorDetails {
    private final String code;
    private final String message;
    private final String requestId;

    public static /* synthetic */ ErrorDetails copy$default(ErrorDetails errorDetails, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = errorDetails.code;
        }
        if ((i & 2) != 0) {
            str2 = errorDetails.message;
        }
        if ((i & 4) != 0) {
            str3 = errorDetails.requestId;
        }
        return errorDetails.copy(str, str2, str3);
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

    public final ErrorDetails copy(String code, String message, String requestId) {
        return new ErrorDetails(code, message, requestId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorDetails)) {
            return false;
        }
        ErrorDetails errorDetails = (ErrorDetails) other;
        return Intrinsics.areEqual(this.code, errorDetails.code) && Intrinsics.areEqual(this.message, errorDetails.message) && Intrinsics.areEqual(this.requestId, errorDetails.requestId);
    }

    public int hashCode() {
        String str = this.code;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.message;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.requestId;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ErrorDetails(code=" + this.code + ", message=" + this.message + ", requestId=" + this.requestId + ')';
    }

    public ErrorDetails(String str, String str2, String str3) {
        this.code = str;
        this.message = str2;
        this.requestId = str3;
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
}
