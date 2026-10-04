package aws.smithy.kotlin.runtime.http.engine.internal;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesBuilder;
import kotlin.Metadata;

/* JADX INFO: compiled from: HttpClientMetrics.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/internal/HttpClientMetricAttributes;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/collections/Attributes;", "IdleConnection", "Laws/smithy/kotlin/runtime/collections/Attributes;", "getIdleConnection", "()Laws/smithy/kotlin/runtime/collections/Attributes;", "AcquiredConnection", "getAcquiredConnection", "QueuedRequest", "getQueuedRequest", "InFlightRequest", "getInFlightRequest", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HttpClientMetricAttributes {
    private static final Attributes AcquiredConnection;
    public static final HttpClientMetricAttributes INSTANCE = new HttpClientMetricAttributes();
    private static final Attributes IdleConnection;
    private static final Attributes InFlightRequest;
    private static final Attributes QueuedRequest;

    private HttpClientMetricAttributes() {
    }

    public final Attributes getIdleConnection() {
        return IdleConnection;
    }

    public final Attributes getAcquiredConnection() {
        return AcquiredConnection;
    }

    public final Attributes getQueuedRequest() {
        return QueuedRequest;
    }

    public final Attributes getInFlightRequest() {
        return InFlightRequest;
    }

    static {
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("state", "idle");
        IdleConnection = attributesBuilder.getAttributes();
        AttributesBuilder attributesBuilder2 = new AttributesBuilder();
        attributesBuilder2.m498to("state", "acquired");
        AcquiredConnection = attributesBuilder2.getAttributes();
        AttributesBuilder attributesBuilder3 = new AttributesBuilder();
        attributesBuilder3.m498to("state", "queued");
        QueuedRequest = attributesBuilder3.getAttributes();
        AttributesBuilder attributesBuilder4 = new AttributesBuilder();
        attributesBuilder4.m498to("state", "in-flight");
        InFlightRequest = attributesBuilder4.getAttributes();
    }
}
