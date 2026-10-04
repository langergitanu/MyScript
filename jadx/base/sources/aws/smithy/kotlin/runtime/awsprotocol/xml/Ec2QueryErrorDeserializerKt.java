package aws.smithy.kotlin.runtime.awsprotocol.xml;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.awsprotocol.ErrorDetails;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Ec2QueryErrorDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, m1599d2 = {"parseEc2QueryErrorResponse", "Laws/smithy/kotlin/runtime/awsprotocol/ErrorDetails;", "payload", "", "aws-xml-protocols"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Ec2QueryErrorDeserializerKt {
    @InternalApi
    public static final ErrorDetails parseEc2QueryErrorResponse(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Ec2QueryErrorResponse ec2QueryErrorResponseDeserialize = Ec2QueryErrorResponseDeserializer.INSTANCE.deserialize(XmlTagReaderKt.xmlTagReader(payload));
        Ec2QueryError ec2QueryError = (Ec2QueryError) CollectionsKt.firstOrNull((List) ec2QueryErrorResponseDeserialize.getErrors());
        return new ErrorDetails(ec2QueryError != null ? ec2QueryError.getCode() : null, ec2QueryError != null ? ec2QueryError.getMessage() : null, ec2QueryErrorResponseDeserialize.getRequestId());
    }
}
