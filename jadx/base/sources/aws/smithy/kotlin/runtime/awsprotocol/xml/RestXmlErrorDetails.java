package aws.smithy.kotlin.runtime.awsprotocol.xml;

import kotlin.Metadata;

/* JADX INFO: compiled from: RestXmlErrorDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/xml/RestXmlErrorDetails;", "", "requestId", "", "getRequestId", "()Ljava/lang/String;", "code", "getCode", "message", "getMessage", "aws-xml-protocols"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface RestXmlErrorDetails {
    String getCode();

    String getMessage();

    String getRequestId();
}
