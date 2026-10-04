package aws.smithy.kotlin.runtime.http.interceptors;

import androidx.core.app.NotificationCompat;
import aws.smithy.kotlin.runtime.client.Interceptor;
import aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext;
import aws.smithy.kotlin.runtime.client.ProtocolResponseInterceptorContext;
import aws.smithy.kotlin.runtime.client.RequestInterceptorContext;
import aws.smithy.kotlin.runtime.client.ResponseInterceptorContext;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesBuilder;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.collections.MutableAttributes;
import aws.smithy.kotlin.runtime.http.engine.EngineAttributes;
import aws.smithy.kotlin.runtime.http.operation.OperationMetrics;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.telemetry.context.Context;
import aws.smithy.kotlin.runtime.telemetry.metrics.HistogramKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlin.time.TimeMark;
import kotlin.time.TimeSource;

/* JADX INFO: compiled from: OperationTelemetryInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005B)\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0015\u001a\u00020\u00112\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0013J#\u0010\u0019\u001a\u00020\u00112\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ1\u0010\u001b\u001a\u00020\u00112 \u0010\u0010\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014H\u0016¢\u0006\u0004\b\u001b\u0010\u0016J)\u0010\u001d\u001a\u00020\u00112\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ/\u0010\u001f\u001a\u00020\u00112\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0014H\u0016¢\u0006\u0004\b\u001f\u0010\u0016J#\u0010 \u001a\u00020\u00112\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0018H\u0016¢\u0006\u0004\b \u0010\u001aJ#\u0010!\u001a\u00020\u00112\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0018H\u0016¢\u0006\u0004\b!\u0010\u001aJ)\u0010\"\u001a\u00020\u00112\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u001cH\u0016¢\u0006\u0004\b\"\u0010\u001eR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010#R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010$R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010$R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010(R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00062"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/interceptors/OperationTelemetryInterceptor;", "Laws/smithy/kotlin/runtime/client/Interceptor;", "", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Laws/smithy/kotlin/runtime/http/interceptors/HttpInterceptor;", "Laws/smithy/kotlin/runtime/http/operation/OperationMetrics;", "metrics", "", NotificationCompat.CATEGORY_SERVICE, "operation", "Lkotlin/time/TimeSource;", "timeSource", "<init>", "(Laws/smithy/kotlin/runtime/http/operation/OperationMetrics;Ljava/lang/String;Ljava/lang/String;Lkotlin/time/TimeSource;)V", "Laws/smithy/kotlin/runtime/client/RequestInterceptorContext;", WebViewMessageType.CONTEXT, "", "readBeforeExecution", "(Laws/smithy/kotlin/runtime/client/RequestInterceptorContext;)V", "Laws/smithy/kotlin/runtime/client/ResponseInterceptorContext;", "readAfterExecution", "(Laws/smithy/kotlin/runtime/client/ResponseInterceptorContext;)V", "readBeforeSerialization", "Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;", "readAfterSerialization", "(Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;)V", "readAfterAttempt", "Laws/smithy/kotlin/runtime/client/ProtocolResponseInterceptorContext;", "readBeforeDeserialization", "(Laws/smithy/kotlin/runtime/client/ProtocolResponseInterceptorContext;)V", "readAfterDeserialization", "readBeforeAttempt", "readBeforeTransmit", "readAfterTransmit", "Laws/smithy/kotlin/runtime/http/operation/OperationMetrics;", "Ljava/lang/String;", "Lkotlin/time/TimeSource;", "Lkotlin/time/TimeMark;", "callStart", "Lkotlin/time/TimeMark;", "serializeStart", "deserializeStart", "attemptStart", "", "attempts", "I", "Laws/smithy/kotlin/runtime/collections/Attributes;", "perRpcAttributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OperationTelemetryInterceptor implements Interceptor<Object, Object, HttpRequest, HttpResponse> {
    private TimeMark attemptStart;
    private int attempts;
    private TimeMark callStart;
    private TimeMark deserializeStart;
    private final OperationMetrics metrics;
    private final String operation;
    private final Attributes perRpcAttributes;
    private TimeMark serializeStart;
    private final String service;
    private final TimeSource timeSource;

    public OperationTelemetryInterceptor(OperationMetrics metrics, String service, String operation, TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        this.metrics = metrics;
        this.service = service;
        this.operation = operation;
        this.timeSource = timeSource;
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.service", service);
        attributesBuilder.m498to("rpc.method", operation);
        this.perRpcAttributes = attributesBuilder.getAttributes();
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    /* JADX INFO: renamed from: modifyBeforeAttemptCompletion-gIAlu-s */
    public /* bridge */ Object mo12026modifyBeforeAttemptCompletiongIAlus(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext, Continuation<? super Result<? extends Object>> continuation) {
        return super.mo12026modifyBeforeAttemptCompletiongIAlus(responseInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    /* JADX INFO: renamed from: modifyBeforeCompletion-gIAlu-s */
    public /* bridge */ Object mo12027modifyBeforeCompletiongIAlus(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext, Continuation<? super Result<? extends Object>> continuation) {
        return super.mo12027modifyBeforeCompletiongIAlus(responseInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ Object modifyBeforeDeserialization(ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse> protocolResponseInterceptorContext, Continuation<? super HttpResponse> continuation) {
        return super.modifyBeforeDeserialization(protocolResponseInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ Object modifyBeforeRetryLoop(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext, Continuation<? super HttpRequest> continuation) {
        return super.modifyBeforeRetryLoop(protocolRequestInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ Object modifyBeforeSerialization(RequestInterceptorContext<Object> requestInterceptorContext, Continuation<? super Object> continuation) {
        return super.modifyBeforeSerialization(requestInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ Object modifyBeforeSigning(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext, Continuation<? super HttpRequest> continuation) {
        return super.modifyBeforeSigning(protocolRequestInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ Object modifyBeforeTransmit(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext, Continuation<? super HttpRequest> continuation) {
        return super.modifyBeforeTransmit(protocolRequestInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readAfterSigning(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext) {
        super.readAfterSigning(protocolRequestInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readBeforeSigning(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext) {
        super.readBeforeSigning(protocolRequestInterceptorContext);
    }

    public /* synthetic */ OperationTelemetryInterceptor(OperationMetrics operationMetrics, String str, String str2, TimeSource.Monotonic monotonic, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(operationMetrics, str, str2, (i & 8) != 0 ? TimeSource.Monotonic.INSTANCE : monotonic);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public void readBeforeExecution(RequestInterceptorContext<Object> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.callStart = this.timeSource.markNow();
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public void readAfterExecution(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> context) {
        MutableAttributes mutableAttributes;
        Intrinsics.checkNotNullParameter(context, "context");
        Context contextCurrent = this.metrics.getProvider().getContextManager().current();
        TimeMark timeMark = this.callStart;
        if (timeMark != null) {
            HistogramKt.m12285recordSecondsdWUq8MI(this.metrics.getRpcCallDuration(), timeMark.mo15844elapsedNowUwyO8pc(), this.perRpcAttributes, contextCurrent);
        }
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(context.mo12149getResponsed1pmJ48());
        if (thM14502exceptionOrNullimpl != null) {
            String simpleName = Reflection.getOrCreateKotlinClass(thM14502exceptionOrNullimpl.getClass()).getSimpleName();
            if (simpleName == null) {
                mutableAttributes = this.perRpcAttributes;
            } else {
                AttributesBuilder attributesBuilder = new AttributesBuilder();
                attributesBuilder.m498to("exception.type", simpleName);
                MutableAttributes attributes = attributesBuilder.getAttributes();
                AttributesKt.merge(attributes, this.perRpcAttributes);
                mutableAttributes = attributes;
            }
            this.metrics.getRpcErrors().add(1L, mutableAttributes, contextCurrent);
        }
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public void readBeforeSerialization(RequestInterceptorContext<Object> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.serializeStart = this.timeSource.markNow();
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public void readAfterSerialization(ProtocolRequestInterceptorContext<Object, HttpRequest> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        TimeMark timeMark = this.serializeStart;
        if (timeMark != null) {
            HistogramKt.m12285recordSecondsdWUq8MI(this.metrics.getSerializationDuration(), timeMark.mo15844elapsedNowUwyO8pc(), this.perRpcAttributes, this.metrics.getProvider().getContextManager().current());
        }
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public void readAfterAttempt(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.metrics.getRpcAttempts().add(1L, this.perRpcAttributes, this.metrics.getProvider().getContextManager().current());
        this.attempts++;
        TimeMark timeMark = this.attemptStart;
        if (timeMark != null) {
            long jMo15844elapsedNowUwyO8pc = timeMark.mo15844elapsedNowUwyO8pc();
            HistogramKt.m12285recordSecondsdWUq8MI(this.metrics.getRpcAttemptDuration(), jMo15844elapsedNowUwyO8pc, this.perRpcAttributes, this.metrics.getProvider().getContextManager().current());
            Duration duration = (Duration) AttributesKt.takeOrNull(context.getExecutionContext(), EngineAttributes.INSTANCE.getTimeToFirstByte());
            if (duration != null) {
                HistogramKt.m12286recordSecondsdWUq8MI$default(this.metrics.getRpcAttemptOverheadDuration(), Duration.m15884minusLRDsOJo(jMo15844elapsedNowUwyO8pc, duration.getRawValue()), this.perRpcAttributes, null, 4, null);
            }
        }
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public void readBeforeDeserialization(ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.deserializeStart = this.timeSource.markNow();
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public void readAfterDeserialization(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        TimeMark timeMark = this.deserializeStart;
        if (timeMark != null) {
            HistogramKt.m12285recordSecondsdWUq8MI(this.metrics.getDeserializationDuration(), timeMark.mo15844elapsedNowUwyO8pc(), this.perRpcAttributes, this.metrics.getProvider().getContextManager().current());
        }
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public void readBeforeAttempt(ProtocolRequestInterceptorContext<Object, HttpRequest> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.attemptStart = this.timeSource.markNow();
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public void readBeforeTransmit(ProtocolRequestInterceptorContext<Object, HttpRequest> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HistogramKt.recordPayloadSize$default(this.metrics.getRequestPayloadSize(), context.getProtocolRequest().getBody().getContentLength(), null, null, 6, null);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public void readAfterTransmit(ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HistogramKt.recordPayloadSize$default(this.metrics.getResponsePayloadSize(), context.getProtocolResponse().getBody().getContentLength(), null, null, 6, null);
    }
}
