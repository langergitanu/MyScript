package aws.smithy.kotlin.runtime.retries.policy;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.ServiceErrorMetadata;
import aws.smithy.kotlin.runtime.ServiceException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Acceptors.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/policy/ErrorTypeAcceptor;", "Laws/smithy/kotlin/runtime/retries/policy/Acceptor;", "", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "state", "", "errorType", "<init>", "(Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;Ljava/lang/String;)V", "request", "Lkotlin/Result;", "result", "", "matches", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Ljava/lang/String;", "getErrorType", "()Ljava/lang/String;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ErrorTypeAcceptor extends Acceptor<Object, Object> {
    private final String errorType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorTypeAcceptor(RetryDirective state, String errorType) {
        super(state);
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        this.errorType = errorType;
    }

    public final String getErrorType() {
        return this.errorType;
    }

    @Override // aws.smithy.kotlin.runtime.retries.policy.Acceptor
    protected boolean matches(Object request, Object result) {
        ServiceErrorMetadata sdkErrorMetadata;
        Intrinsics.checkNotNullParameter(request, "request");
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(result);
        String errorCode = null;
        ServiceException serviceException = thM14502exceptionOrNullimpl instanceof ServiceException ? (ServiceException) thM14502exceptionOrNullimpl : null;
        if (serviceException != null && (sdkErrorMetadata = serviceException.getSdkErrorMetadata()) != null) {
            errorCode = sdkErrorMetadata.getErrorCode();
        }
        return Intrinsics.areEqual(errorCode, this.errorType);
    }
}
