package aws.smithy.kotlin.runtime.client;

import aws.smithy.kotlin.runtime.client.LogMode;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkClientOption.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0017\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0017\u0010\r\u001a\u0004\u0018\u00010\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, m1599d2 = {"idempotencyTokenProvider", "Laws/smithy/kotlin/runtime/client/IdempotencyTokenProvider;", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "getIdempotencyTokenProvider", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;)Laws/smithy/kotlin/runtime/client/IdempotencyTokenProvider;", "logMode", "Laws/smithy/kotlin/runtime/client/LogMode;", "getLogMode", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;)Laws/smithy/kotlin/runtime/client/LogMode;", "operationName", "", "getOperationName", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;)Ljava/lang/String;", "serviceName", "getServiceName", "smithy-client"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkClientOptionKt {
    public static final IdempotencyTokenProvider getIdempotencyTokenProvider(ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(executionContext, "<this>");
        IdempotencyTokenProvider idempotencyTokenProvider = (IdempotencyTokenProvider) executionContext.getOrNull(SdkClientOption.INSTANCE.getIdempotencyTokenProvider());
        return idempotencyTokenProvider == null ? IdempotencyTokenProvider.INSTANCE.getDefault() : idempotencyTokenProvider;
    }

    public static final LogMode getLogMode(ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(executionContext, "<this>");
        LogMode logMode = (LogMode) executionContext.getOrNull(SdkClientOption.INSTANCE.getLogMode());
        return logMode == null ? LogMode.Default.INSTANCE : logMode;
    }

    public static final String getOperationName(ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(executionContext, "<this>");
        return (String) executionContext.getOrNull(SdkClientOption.INSTANCE.getOperationName());
    }

    public static final String getServiceName(ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(executionContext, "<this>");
        return (String) executionContext.getOrNull(SdkClientOption.INSTANCE.getServiceName());
    }
}
