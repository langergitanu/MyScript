package aws.smithy.kotlin.runtime.awsprotocol;

import aws.sdk.kotlin.runtime.config.profile.Literals;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.ServiceErrorMetadata;
import aws.smithy.kotlin.runtime.ServiceException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AwsQueryCompatibleErrorDetails.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\"\u001a\u0010\n\u001a\u00020\u00078\u0006X\u0087T¢\u0006\f\n\u0004\b\n\u0010\u000b\u0012\u0004\b\f\u0010\r¨\u0006\u000e"}, m1599d2 = {"", "exception", "Laws/smithy/kotlin/runtime/awsprotocol/AwsQueryCompatibleErrorDetails;", "error", "", "setAwsQueryCompatibleErrorMetadata", "(Ljava/lang/Object;Laws/smithy/kotlin/runtime/awsprotocol/AwsQueryCompatibleErrorDetails;)V", "", "parseImpl", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/awsprotocol/AwsQueryCompatibleErrorDetails;", "X_AMZN_QUERY_ERROR_HEADER", "Ljava/lang/String;", "getX_AMZN_QUERY_ERROR_HEADER$annotations", "()V", "aws-protocol-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsQueryCompatibleErrorDetailsKt {
    public static final String X_AMZN_QUERY_ERROR_HEADER = "x-amzn-query-error";

    @InternalApi
    public static /* synthetic */ void getX_AMZN_QUERY_ERROR_HEADER$annotations() {
    }

    @InternalApi
    public static final void setAwsQueryCompatibleErrorMetadata(Object exception, AwsQueryCompatibleErrorDetails error) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(error, "error");
        if (exception instanceof ServiceException) {
            ServiceException serviceException = (ServiceException) exception;
            serviceException.getSdkErrorMetadata().getAttributes().set(ServiceErrorMetadata.INSTANCE.getErrorCode(), error.getCode());
            serviceException.getSdkErrorMetadata().getAttributes().set(ServiceErrorMetadata.INSTANCE.getErrorType(), error.getType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AwsQueryCompatibleErrorDetails parseImpl(String str) {
        ServiceException.ErrorType errorType;
        List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{Literals.COMMENT_2}, false, 2, 2, (Object) null);
        if (listSplit$default.size() != 2) {
            throw new IllegalArgumentException("value is malformed".toString());
        }
        if (((CharSequence) listSplit$default.get(0)).length() <= 0) {
            throw new IllegalArgumentException("code is empty".toString());
        }
        if (((CharSequence) listSplit$default.get(1)).length() <= 0) {
            throw new IllegalArgumentException("type is empty".toString());
        }
        String str2 = (String) listSplit$default.get(0);
        String str3 = (String) listSplit$default.get(1);
        if (Intrinsics.areEqual(str3, "Sender")) {
            errorType = ServiceException.ErrorType.Client;
        } else {
            errorType = Intrinsics.areEqual(str3, "Receiver") ? ServiceException.ErrorType.Server : ServiceException.ErrorType.Unknown;
        }
        return new AwsQueryCompatibleErrorDetails(str2, errorType);
    }
}
