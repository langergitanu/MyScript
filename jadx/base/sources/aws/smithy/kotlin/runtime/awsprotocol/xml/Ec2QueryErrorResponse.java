package aws.smithy.kotlin.runtime.awsprotocol.xml;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Ec2QueryErrorDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0006HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/xml/Ec2QueryErrorResponse;", "", "errors", "", "Laws/smithy/kotlin/runtime/awsprotocol/xml/Ec2QueryError;", "requestId", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getErrors", "()Ljava/util/List;", "getRequestId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "aws-xml-protocols"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class Ec2QueryErrorResponse {
    private final List<Ec2QueryError> errors;
    private final String requestId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Ec2QueryErrorResponse copy$default(Ec2QueryErrorResponse ec2QueryErrorResponse, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = ec2QueryErrorResponse.errors;
        }
        if ((i & 2) != 0) {
            str = ec2QueryErrorResponse.requestId;
        }
        return ec2QueryErrorResponse.copy(list, str);
    }

    public final List<Ec2QueryError> component1() {
        return this.errors;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    public final Ec2QueryErrorResponse copy(List<Ec2QueryError> errors, String requestId) {
        Intrinsics.checkNotNullParameter(errors, "errors");
        return new Ec2QueryErrorResponse(errors, requestId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Ec2QueryErrorResponse)) {
            return false;
        }
        Ec2QueryErrorResponse ec2QueryErrorResponse = (Ec2QueryErrorResponse) other;
        return Intrinsics.areEqual(this.errors, ec2QueryErrorResponse.errors) && Intrinsics.areEqual(this.requestId, ec2QueryErrorResponse.requestId);
    }

    public int hashCode() {
        int iHashCode = this.errors.hashCode() * 31;
        String str = this.requestId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Ec2QueryErrorResponse(errors=" + this.errors + ", requestId=" + this.requestId + ')';
    }

    public Ec2QueryErrorResponse(List<Ec2QueryError> errors, String str) {
        Intrinsics.checkNotNullParameter(errors, "errors");
        this.errors = errors;
        this.requestId = str;
    }

    public final List<Ec2QueryError> getErrors() {
        return this.errors;
    }

    public final String getRequestId() {
        return this.requestId;
    }
}
