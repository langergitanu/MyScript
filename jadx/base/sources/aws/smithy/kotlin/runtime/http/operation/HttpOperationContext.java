package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.collections.AttributeKey;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.time.Instant;
import java.util.List;
import kotlin.Metadata;
import kotlin.time.Duration;

/* JADX INFO: compiled from: HttpOperationContext.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\tR#\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\tR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0014\u0010\tR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\tR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u0019\u0010\tR\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001c\u0010\tR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0007\u001a\u0004\b\u001e\u0010\tR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00048\u0006¢\u0006\f\n\u0004\b \u0010\u0007\u001a\u0004\b!\u0010\tR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u00048\u0006¢\u0006\f\n\u0004\b\"\u0010\u0007\u001a\u0004\b#\u0010\t¨\u0006$"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/HttpOperationContext;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "Lkotlin/time/Duration;", "AttemptTimeout", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "getAttemptTimeout", "()Laws/smithy/kotlin/runtime/collections/AttributeKey;", "CallTimeout", "getCallTimeout", "", "HostPrefix", "getHostPrefix", "", "Laws/smithy/kotlin/runtime/http/HttpCall;", "HttpCallList", "getHttpCallList", "SdkInvocationId", "getSdkInvocationId", "OperationInput", "getOperationInput", "Laws/smithy/kotlin/runtime/http/operation/OperationMetrics;", "OperationMetrics", "getOperationMetrics", "Laws/smithy/kotlin/runtime/collections/Attributes;", "OperationAttributes", "getOperationAttributes", "ClockSkew", "getClockSkew", "Laws/smithy/kotlin/runtime/time/Instant;", "ClockSkewApproximateSigningTime", "getClockSkewApproximateSigningTime", "DefaultChecksumAlgorithm", "getDefaultChecksumAlgorithm", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HttpOperationContext {
    public static final HttpOperationContext INSTANCE = new HttpOperationContext();
    private static final AttributeKey<Duration> AttemptTimeout = new AttributeKey<>("aws.smithy.kotlin#AttemptDuration");
    private static final AttributeKey<Duration> CallTimeout = new AttributeKey<>("aws.smithy.kotlin#CallDuration");
    private static final AttributeKey<String> HostPrefix = new AttributeKey<>("aws.smithy.kotlin#HostPrefix");
    private static final AttributeKey<List<HttpCall>> HttpCallList = new AttributeKey<>("aws.smithy.kotlin#HttpCallList");
    private static final AttributeKey<String> SdkInvocationId = new AttributeKey<>("aws.smithy.kotlin#SdkInvocationId");
    private static final AttributeKey<Object> OperationInput = new AttributeKey<>("aws.smithy.kotlin#OperationInput");
    private static final AttributeKey<OperationMetrics> OperationMetrics = new AttributeKey<>("aws.smithy.kotlin#OperationMetrics");
    private static final AttributeKey<Attributes> OperationAttributes = new AttributeKey<>("aws.smithy.kotlin#OperationAttributes");
    private static final AttributeKey<Duration> ClockSkew = new AttributeKey<>("aws.smithy.kotlin#ClockSkew");
    private static final AttributeKey<Instant> ClockSkewApproximateSigningTime = new AttributeKey<>("aws.smithy.kotlin#ClockSkewApproximateSigningTime");
    private static final AttributeKey<String> DefaultChecksumAlgorithm = new AttributeKey<>("aws.smithy.kotlin#DefaultChecksumAlgorithm");

    private HttpOperationContext() {
    }

    public final AttributeKey<Duration> getAttemptTimeout() {
        return AttemptTimeout;
    }

    public final AttributeKey<Duration> getCallTimeout() {
        return CallTimeout;
    }

    public final AttributeKey<String> getHostPrefix() {
        return HostPrefix;
    }

    public final AttributeKey<List<HttpCall>> getHttpCallList() {
        return HttpCallList;
    }

    public final AttributeKey<String> getSdkInvocationId() {
        return SdkInvocationId;
    }

    public final AttributeKey<Object> getOperationInput() {
        return OperationInput;
    }

    public final AttributeKey<OperationMetrics> getOperationMetrics() {
        return OperationMetrics;
    }

    public final AttributeKey<Attributes> getOperationAttributes() {
        return OperationAttributes;
    }

    public final AttributeKey<Duration> getClockSkew() {
        return ClockSkew;
    }

    public final AttributeKey<Instant> getClockSkewApproximateSigningTime() {
        return ClockSkewApproximateSigningTime;
    }

    public final AttributeKey<String> getDefaultChecksumAlgorithm() {
        return DefaultChecksumAlgorithm;
    }
}
