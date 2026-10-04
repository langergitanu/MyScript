package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.client.SdkClientOptionKt;
import aws.smithy.kotlin.runtime.collections.AttributesBuilder;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.collections.MutableAttributes;
import aws.smithy.kotlin.runtime.http.interceptors.OperationTelemetryInterceptor;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProviderContext;
import aws.smithy.kotlin.runtime.telemetry.context.Context;
import aws.smithy.kotlin.runtime.telemetry.logging.LoggingContextElement;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan;
import aws.smithy.kotlin.runtime.telemetry.trace.Tracer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OperationTelemetry.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a7\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, m1599d2 = {"I", "O", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperationBuilder;", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/http/operation/SdkOperationTelemetry;", "", "Lkotlin/ExtensionFunctionType;", "block", "telemetry", "(Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperationBuilder;Lkotlin/jvm/functions/Function1;)V", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;", "Lkotlin/Pair;", "Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpan;", "Lkotlin/coroutines/CoroutineContext;", "instrument", "(Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;)Lkotlin/Pair;", "http-client"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OperationTelemetryKt {
    @InternalApi
    public static final <I, O> void telemetry(SdkHttpOperationBuilder<I, O> sdkHttpOperationBuilder, Function1<? super SdkOperationTelemetry, Unit> block) {
        Intrinsics.checkNotNullParameter(sdkHttpOperationBuilder, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(sdkHttpOperationBuilder.getTelemetry());
    }

    public static final <I, O> Pair<TraceSpan, CoroutineContext> instrument(SdkHttpOperation<I, O> sdkHttpOperation) {
        Intrinsics.checkNotNullParameter(sdkHttpOperation, "<this>");
        String serviceName = SdkClientOptionKt.getServiceName(sdkHttpOperation.getContext());
        if (serviceName == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        String operationName = SdkClientOptionKt.getOperationName(sdkHttpOperation.getContext());
        if (operationName == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        String scope = sdkHttpOperation.getTelemetry().getScope();
        if (scope == null) {
            scope = serviceName;
        }
        Tracer orCreateTracer = sdkHttpOperation.getTelemetry().getProvider().getTracerProvider().getOrCreateTracer(scope);
        Context contextCurrent = sdkHttpOperation.getTelemetry().getProvider().getContextManager().current();
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.service", serviceName);
        attributesBuilder.m498to("rpc.method", operationName);
        MutableAttributes attributes = attributesBuilder.getAttributes();
        MutableAttributes mutableAttributes = AttributesKt.toMutableAttributes(sdkHttpOperation.getTelemetry().getAttributes());
        AttributesKt.merge(mutableAttributes, attributes);
        String str = serviceName + '.' + operationName;
        String spanName = sdkHttpOperation.getTelemetry().getSpanName();
        if (spanName == null) {
            spanName = str;
        }
        TraceSpan traceSpanCreateSpan = orCreateTracer.createSpan(spanName, mutableAttributes, sdkHttpOperation.getTelemetry().getSpanKind(), contextCurrent);
        CoroutineContext coroutineContextPlus = new TelemetryProviderContext(sdkHttpOperation.getTelemetry().getProvider()).plus(new LoggingContextElement((Pair<String, ? extends Object>[]) new Pair[]{TuplesKt.m1606to("rpc", str), TuplesKt.m1606to("sdkInvocationId", SdkHttpOperationKt.getSdkInvocationId(sdkHttpOperation.getContext()))}));
        sdkHttpOperation.getContext().set(HttpOperationContext.INSTANCE.getOperationMetrics(), sdkHttpOperation.getTelemetry().getMetrics());
        sdkHttpOperation.getContext().set(HttpOperationContext.INSTANCE.getOperationAttributes(), attributes);
        sdkHttpOperation.getInterceptors().add(new OperationTelemetryInterceptor(sdkHttpOperation.getTelemetry().getMetrics(), serviceName, operationName, null, 8, null));
        return TuplesKt.m1606to(traceSpanCreateSpan, coroutineContextPlus);
    }
}
