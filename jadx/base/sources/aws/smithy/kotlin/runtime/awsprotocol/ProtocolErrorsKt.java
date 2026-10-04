package aws.smithy.kotlin.runtime.awsprotocol;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.ServiceErrorMetadata;
import aws.smithy.kotlin.runtime.ServiceException;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProtocolErrors.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"", "exception", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "response", "Laws/smithy/kotlin/runtime/awsprotocol/AwsErrorDetails;", "errorDetails", "", "setAseErrorMetadata", "(Ljava/lang/Object;Laws/smithy/kotlin/runtime/http/response/HttpResponse;Laws/smithy/kotlin/runtime/awsprotocol/AwsErrorDetails;)V", "aws-protocol-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ProtocolErrorsKt {
    @InternalApi
    public static final void setAseErrorMetadata(Object exception, HttpResponse response, AwsErrorDetails awsErrorDetails) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(response, "response");
        if (exception instanceof ServiceException) {
            ServiceException serviceException = (ServiceException) exception;
            AttributesKt.setIfValueNotNull(serviceException.getSdkErrorMetadata().getAttributes(), ServiceErrorMetadata.INSTANCE.getErrorCode(), awsErrorDetails != null ? awsErrorDetails.getCode() : null);
            AttributesKt.setIfValueNotNull(serviceException.getSdkErrorMetadata().getAttributes(), ServiceErrorMetadata.INSTANCE.getErrorMessage(), awsErrorDetails != null ? awsErrorDetails.getMessage() : null);
            AttributesKt.setIfValueNotNull(serviceException.getSdkErrorMetadata().getAttributes(), ServiceErrorMetadata.INSTANCE.getRequestId(), response.getHeaders().get(ResponseUtilsKt.X_AMZN_REQUEST_ID_HEADER));
            serviceException.getSdkErrorMetadata().getAttributes().set(ServiceErrorMetadata.INSTANCE.getProtocolResponse(), response);
        }
    }
}
