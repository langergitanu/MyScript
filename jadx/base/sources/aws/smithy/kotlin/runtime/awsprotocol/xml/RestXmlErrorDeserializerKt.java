package aws.smithy.kotlin.runtime.awsprotocol.xml;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.awsprotocol.ErrorDetails;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RestXmlErrorDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, m1599d2 = {"parseRestXmlErrorResponse", "Laws/smithy/kotlin/runtime/awsprotocol/ErrorDetails;", "payload", "", "aws-xml-protocols"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RestXmlErrorDeserializerKt {
    @InternalApi
    public static final ErrorDetails parseRestXmlErrorResponse(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        XmlError xmlErrorDeserialize = XmlErrorDeserializer.INSTANCE.deserialize(XmlTagReaderKt.xmlTagReader(payload));
        return new ErrorDetails(xmlErrorDeserialize.getCode(), xmlErrorDeserialize.getMessage(), xmlErrorDeserialize.getRequestId());
    }
}
