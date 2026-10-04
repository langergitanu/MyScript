package aws.smithy.kotlin.runtime.awsprotocol.xml;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RestXmlErrorDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/xml/XmlError;", "Laws/smithy/kotlin/runtime/awsprotocol/xml/RestXmlErrorDetails;", "requestId", "", "code", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRequestId", "()Ljava/lang/String;", "getCode", "getMessage", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aws-xml-protocols"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class XmlError implements RestXmlErrorDetails {
    private final String code;
    private final String message;
    private final String requestId;

    public static /* synthetic */ XmlError copy$default(XmlError xmlError, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = xmlError.requestId;
        }
        if ((i & 2) != 0) {
            str2 = xmlError.code;
        }
        if ((i & 4) != 0) {
            str3 = xmlError.message;
        }
        return xmlError.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final XmlError copy(String requestId, String code, String message) {
        return new XmlError(requestId, code, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof XmlError)) {
            return false;
        }
        XmlError xmlError = (XmlError) other;
        return Intrinsics.areEqual(this.requestId, xmlError.requestId) && Intrinsics.areEqual(this.code, xmlError.code) && Intrinsics.areEqual(this.message, xmlError.message);
    }

    public int hashCode() {
        String str = this.requestId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.code;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.message;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "XmlError(requestId=" + this.requestId + ", code=" + this.code + ", message=" + this.message + ')';
    }

    public XmlError(String str, String str2, String str3) {
        this.requestId = str;
        this.code = str2;
        this.message = str3;
    }

    @Override // aws.smithy.kotlin.runtime.awsprotocol.xml.RestXmlErrorDetails
    public String getRequestId() {
        return this.requestId;
    }

    @Override // aws.smithy.kotlin.runtime.awsprotocol.xml.RestXmlErrorDetails
    public String getCode() {
        return this.code;
    }

    @Override // aws.smithy.kotlin.runtime.awsprotocol.xml.RestXmlErrorDetails
    public String getMessage() {
        return this.message;
    }
}
