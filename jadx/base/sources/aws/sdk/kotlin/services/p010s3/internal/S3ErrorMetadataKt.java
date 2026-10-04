package aws.sdk.kotlin.services.p010s3.internal;

import aws.sdk.kotlin.runtime.AwsServiceException;
import aws.sdk.kotlin.services.p010s3.model.S3ErrorMetadata;
import aws.sdk.kotlin.services.p010s3.model.S3Exception;
import aws.smithy.kotlin.runtime.ClientErrorContext;
import aws.smithy.kotlin.runtime.ErrorMetadata;
import aws.smithy.kotlin.runtime.ServiceErrorMetadata;
import aws.smithy.kotlin.runtime.awsprotocol.ProtocolErrorsKt;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: S3ErrorMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\u001a\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0000\u001a\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"X_AMZN_REQUEST_ID_2_HEADER", "", "setS3ErrorMetadata", "", "exception", "", "response", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "errorDetails", "Laws/sdk/kotlin/services/s3/internal/S3ErrorDetails;", "parseS3ErrorResponse", "payload", "", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class S3ErrorMetadataKt {
    private static final String X_AMZN_REQUEST_ID_2_HEADER = "x-amz-id-2";

    public static final void setS3ErrorMetadata(Object exception, HttpResponse response, S3ErrorDetails s3ErrorDetails) {
        String requestId2;
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(response, "response");
        ProtocolErrorsKt.setAseErrorMetadata(exception, response, s3ErrorDetails);
        if (exception instanceof AwsServiceException) {
            AttributesKt.setIfValueNotNull(((AwsServiceException) exception).getSdkErrorMetadata().getAttributes(), ServiceErrorMetadata.INSTANCE.getRequestId(), s3ErrorDetails != null ? s3ErrorDetails.getRequestId() : null);
        }
        if (exception instanceof S3Exception) {
            if (s3ErrorDetails == null || (requestId2 = s3ErrorDetails.getRequestId2()) == null) {
                requestId2 = response.getHeaders().get(X_AMZN_REQUEST_ID_2_HEADER);
            }
            if (requestId2 != null) {
                S3ErrorMetadata sdkErrorMetadata = ((S3Exception) exception).getSdkErrorMetadata();
                AttributesKt.setIfValueNotNull(sdkErrorMetadata.getAttributes(), S3ErrorMetadata.INSTANCE.getRequestId2(), requestId2);
                AttributesKt.appendValue(sdkErrorMetadata.getAttributes(), ErrorMetadata.INSTANCE.getClientContext(), new ClientErrorContext("Extended request ID", requestId2));
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final S3ErrorDetails parseS3ErrorResponse(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        XmlTagReader xmlTagReader = XmlTagReaderKt.xmlTagReader(payload);
        String strData = null;
        String strData2 = null;
        String strData3 = null;
        String strData4 = null;
        while (true) {
            XmlTagReader xmlTagReaderNextTag = xmlTagReader.nextTag();
            if (xmlTagReaderNextTag == null) {
                return new S3ErrorDetails(strData, strData2, strData3, strData4);
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            switch (tagName.hashCode()) {
                case -2127617789:
                    if (tagName.equals("HostId")) {
                        strData4 = XmlTagReaderKt.data(xmlTagReaderNextTag);
                        continue;
                    }
                    xmlTagReaderNextTag.drop();
                    break;
                case -1675388953:
                    if (!tagName.equals("Message")) {
                    }
                    xmlTagReaderNextTag.drop();
                    break;
                case -1597066262:
                    if (tagName.equals("RequestId")) {
                        strData3 = XmlTagReaderKt.data(xmlTagReaderNextTag);
                        continue;
                    }
                    xmlTagReaderNextTag.drop();
                    break;
                case 2105869:
                    if (tagName.equals("Code")) {
                        strData = XmlTagReaderKt.data(xmlTagReaderNextTag);
                    } else {
                        continue;
                    }
                    xmlTagReaderNextTag.drop();
                    break;
                case 954925063:
                    if (!tagName.equals("message")) {
                    }
                    xmlTagReaderNextTag.drop();
                    break;
                default:
                    xmlTagReaderNextTag.drop();
                    break;
            }
            strData2 = XmlTagReaderKt.data(xmlTagReaderNextTag);
            xmlTagReaderNextTag.drop();
        }
    }
}
