package aws.smithy.kotlin.runtime.client;

import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.Metadata;

/* JADX INFO: compiled from: Interceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/RequestInterceptorContext;", "I", "", "executionContext", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "getExecutionContext", "()Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "request", "getRequest", "()Ljava/lang/Object;", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface RequestInterceptorContext<I> {
    ExecutionContext getExecutionContext();

    I getRequest();
}
