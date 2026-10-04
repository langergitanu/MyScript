package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpOperationContext.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\b\u001a\u00020\u0005*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "Laws/smithy/kotlin/runtime/http/operation/OperationMetrics;", "getOperationMetrics", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;)Laws/smithy/kotlin/runtime/http/operation/OperationMetrics;", "operationMetrics", "Laws/smithy/kotlin/runtime/collections/Attributes;", "getOperationAttributes", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;)Laws/smithy/kotlin/runtime/collections/Attributes;", "operationAttributes", "http-client"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HttpOperationContextKt {
    public static final OperationMetrics getOperationMetrics(ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(executionContext, "<this>");
        OperationMetrics operationMetrics = (OperationMetrics) executionContext.getOrNull(HttpOperationContext.INSTANCE.getOperationMetrics());
        return operationMetrics == null ? OperationMetrics.INSTANCE.getNone() : operationMetrics;
    }

    public static final Attributes getOperationAttributes(ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(executionContext, "<this>");
        Attributes attributes = (Attributes) executionContext.getOrNull(HttpOperationContext.INSTANCE.getOperationAttributes());
        return attributes == null ? AttributesKt.emptyAttributes() : attributes;
    }
}
