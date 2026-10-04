package aws.smithy.kotlin.runtime;

import aws.smithy.kotlin.runtime.ServiceException;
import aws.smithy.kotlin.runtime.collections.AttributeKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\t\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\r\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0011\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0015"}, m1599d2 = {"Laws/smithy/kotlin/runtime/ServiceErrorMetadata;", "Laws/smithy/kotlin/runtime/ErrorMetadata;", "<init>", "()V", "", "getErrorCode", "()Ljava/lang/String;", "errorCode", "getErrorMessage", "errorMessage", "Laws/smithy/kotlin/runtime/ServiceException$ErrorType;", "getErrorType", "()Laws/smithy/kotlin/runtime/ServiceException$ErrorType;", "errorType", "Laws/smithy/kotlin/runtime/ProtocolResponse;", "getProtocolResponse", "()Laws/smithy/kotlin/runtime/ProtocolResponse;", "protocolResponse", "getRequestId", "requestId", "Companion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class ServiceErrorMetadata extends ErrorMetadata {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AttributeKey<String> ErrorCode = new AttributeKey<>("aws.smithy.kotlin#ErrorCode");
    private static final AttributeKey<String> ErrorMessage = new AttributeKey<>("aws.smithy.kotlin#ErrorMessage");
    private static final AttributeKey<ServiceException.ErrorType> ErrorType = new AttributeKey<>("aws.smithy.kotlin#ErrorType");
    private static final AttributeKey<ProtocolResponse> ProtocolResponse = new AttributeKey<>("aws.smithy.kotlin#ProtocolResponse");
    private static final AttributeKey<String> RequestId = new AttributeKey<>("aws.smithy.kotlin#RequestId");

    /* JADX INFO: compiled from: Exceptions.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\tR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\tR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0013\u0010\t¨\u0006\u0014"}, m1599d2 = {"Laws/smithy/kotlin/runtime/ServiceErrorMetadata$Companion;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "", "ErrorCode", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "getErrorCode", "()Laws/smithy/kotlin/runtime/collections/AttributeKey;", "ErrorMessage", "getErrorMessage", "Laws/smithy/kotlin/runtime/ServiceException$ErrorType;", "ErrorType", "getErrorType", "Laws/smithy/kotlin/runtime/ProtocolResponse;", "ProtocolResponse", "getProtocolResponse", "RequestId", "getRequestId", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AttributeKey<String> getErrorCode() {
            return ServiceErrorMetadata.ErrorCode;
        }

        public final AttributeKey<String> getErrorMessage() {
            return ServiceErrorMetadata.ErrorMessage;
        }

        public final AttributeKey<ServiceException.ErrorType> getErrorType() {
            return ServiceErrorMetadata.ErrorType;
        }

        public final AttributeKey<ProtocolResponse> getProtocolResponse() {
            return ServiceErrorMetadata.ProtocolResponse;
        }

        public final AttributeKey<String> getRequestId() {
            return ServiceErrorMetadata.RequestId;
        }
    }

    public final String getErrorCode() {
        return (String) getAttributes().getOrNull(ErrorCode);
    }

    public final String getErrorMessage() {
        return (String) getAttributes().getOrNull(ErrorMessage);
    }

    public final ServiceException.ErrorType getErrorType() {
        ServiceException.ErrorType errorType = (ServiceException.ErrorType) getAttributes().getOrNull(ErrorType);
        return errorType == null ? ServiceException.ErrorType.Unknown : errorType;
    }

    public final ProtocolResponse getProtocolResponse() {
        ProtocolResponse protocolResponse = (ProtocolResponse) getAttributes().getOrNull(ProtocolResponse);
        return protocolResponse == null ? EmptyProtocolResponse.INSTANCE : protocolResponse;
    }

    public final String getRequestId() {
        return (String) getAttributes().getOrNull(RequestId);
    }
}
