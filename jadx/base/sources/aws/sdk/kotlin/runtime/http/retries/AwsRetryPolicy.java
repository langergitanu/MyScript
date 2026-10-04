package aws.sdk.kotlin.runtime.http.retries;

import androidx.webkit.Profile;
import aws.smithy.kotlin.runtime.ProtocolResponse;
import aws.smithy.kotlin.runtime.ServiceErrorMetadata;
import aws.smithy.kotlin.runtime.ServiceException;
import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.retries.policy.RetryDirective;
import aws.smithy.kotlin.runtime.retries.policy.RetryErrorType;
import aws.smithy.kotlin.runtime.retries.policy.StandardRetryPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AwsRetryPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0002R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/retries/AwsRetryPolicy;", "Laws/smithy/kotlin/runtime/retries/policy/StandardRetryPolicy;", "<init>", "()V", "evaluateSpecificExceptions", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "ex", "", "evaluateServiceException", "Laws/smithy/kotlin/runtime/ServiceException;", "statusCode", "", "Laws/smithy/kotlin/runtime/ServiceErrorMetadata;", "getStatusCode", "(Laws/smithy/kotlin/runtime/ServiceErrorMetadata;)Ljava/lang/Integer;", "Companion", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class AwsRetryPolicy extends StandardRetryPolicy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AwsRetryPolicy Default = new AwsRetryPolicy();
    private static final Map<String, RetryErrorType> knownErrorTypes = MapsKt.mapOf(TuplesKt.m1606to("BandwidthLimitExceeded", RetryErrorType.Throttling), TuplesKt.m1606to("EC2ThrottledException", RetryErrorType.Throttling), TuplesKt.m1606to("IDPCommunicationError", RetryErrorType.Transient), TuplesKt.m1606to("LimitExceededException", RetryErrorType.Throttling), TuplesKt.m1606to("PriorRequestNotComplete", RetryErrorType.Throttling), TuplesKt.m1606to("ProvisionedThroughputExceededException", RetryErrorType.Throttling), TuplesKt.m1606to("RequestLimitExceeded", RetryErrorType.Throttling), TuplesKt.m1606to("RequestThrottled", RetryErrorType.Throttling), TuplesKt.m1606to("RequestThrottledException", RetryErrorType.Throttling), TuplesKt.m1606to("RequestTimeout", RetryErrorType.Transient), TuplesKt.m1606to("RequestTimeoutException", RetryErrorType.Transient), TuplesKt.m1606to("SlowDown", RetryErrorType.Throttling), TuplesKt.m1606to("ThrottledException", RetryErrorType.Throttling), TuplesKt.m1606to("Throttling", RetryErrorType.Throttling), TuplesKt.m1606to("ThrottlingException", RetryErrorType.Throttling), TuplesKt.m1606to("TooManyRequestsException", RetryErrorType.Throttling), TuplesKt.m1606to("TransactionInProgressException", RetryErrorType.Throttling));
    private static final Map<Integer, RetryErrorType> knownStatusCodes = MapsKt.mapOf(TuplesKt.m1606to(500, RetryErrorType.Transient), TuplesKt.m1606to(502, RetryErrorType.Transient), TuplesKt.m1606to(503, RetryErrorType.Transient), TuplesKt.m1606to(504, RetryErrorType.Transient));

    /* JADX INFO: compiled from: AwsRetryPolicy.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u0011"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/retries/AwsRetryPolicy$Companion;", "", "<init>", "()V", Profile.DEFAULT_PROFILE_NAME, "Laws/sdk/kotlin/runtime/http/retries/AwsRetryPolicy;", "getDefault", "()Laws/sdk/kotlin/runtime/http/retries/AwsRetryPolicy;", "knownErrorTypes", "", "", "Laws/smithy/kotlin/runtime/retries/policy/RetryErrorType;", "getKnownErrorTypes$aws_http", "()Ljava/util/Map;", "knownStatusCodes", "", "getKnownStatusCodes$aws_http", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AwsRetryPolicy getDefault() {
            return AwsRetryPolicy.Default;
        }

        public final Map<String, RetryErrorType> getKnownErrorTypes$aws_http() {
            return AwsRetryPolicy.knownErrorTypes;
        }

        public final Map<Integer, RetryErrorType> getKnownStatusCodes$aws_http() {
            return AwsRetryPolicy.knownStatusCodes;
        }
    }

    @Override // aws.smithy.kotlin.runtime.retries.policy.StandardRetryPolicy
    protected RetryDirective evaluateSpecificExceptions(Throwable ex) {
        Intrinsics.checkNotNullParameter(ex, "ex");
        if (ex instanceof ServiceException) {
            return evaluateServiceException((ServiceException) ex);
        }
        return null;
    }

    private final RetryDirective evaluateServiceException(ServiceException ex) {
        ServiceErrorMetadata sdkErrorMetadata = ex.getSdkErrorMetadata();
        RetryErrorType retryErrorType = knownErrorTypes.get(sdkErrorMetadata.getErrorCode());
        if (retryErrorType == null) {
            retryErrorType = knownStatusCodes.get(getStatusCode(sdkErrorMetadata));
        }
        return retryErrorType != null ? new RetryDirective.RetryError(retryErrorType) : null;
    }

    private final Integer getStatusCode(ServiceErrorMetadata serviceErrorMetadata) {
        HttpStatusCode status;
        ProtocolResponse protocolResponse = serviceErrorMetadata.getProtocolResponse();
        HttpResponse httpResponse = protocolResponse instanceof HttpResponse ? (HttpResponse) protocolResponse : null;
        if (httpResponse == null || (status = httpResponse.getStatus()) == null) {
            return null;
        }
        return Integer.valueOf(status.getValue());
    }
}
