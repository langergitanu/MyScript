package aws.smithy.kotlin.runtime.retries.policy;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.retries.policy.RetryDirective;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AcceptorRetryPolicy.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00002\b\u0012\u0004\u0012\u00028\u00010\u0003B)\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\f*\b\u0012\u0004\u0012\u00028\u00010\nH\u0002¢\u0006\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0004\u001a\u00028\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010R&\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/policy/AcceptorRetryPolicy;", "I", "O", "Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "input", "", "Laws/smithy/kotlin/runtime/retries/policy/Acceptor;", "acceptors", "<init>", "(Ljava/lang/Object;Ljava/util/List;)V", "Lkotlin/Result;", "result", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "evaluate", "(Ljava/lang/Object;)Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "toDefaultDirective", "Ljava/lang/Object;", "Ljava/util/List;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AcceptorRetryPolicy<I, O> implements RetryPolicy<O> {
    private final List<Acceptor<I, O>> acceptors;
    private final I input;

    /* JADX WARN: Multi-variable type inference failed */
    public AcceptorRetryPolicy(I i, List<? extends Acceptor<? super I, ? super O>> acceptors) {
        Intrinsics.checkNotNullParameter(acceptors, "acceptors");
        this.input = i;
        this.acceptors = acceptors;
    }

    @Override // aws.smithy.kotlin.runtime.retries.policy.RetryPolicy
    public RetryDirective evaluate(Object result) {
        RetryDirective retryDirectiveEvaluate;
        Iterator<T> it = this.acceptors.iterator();
        while (true) {
            if (!it.hasNext()) {
                retryDirectiveEvaluate = null;
                break;
            }
            retryDirectiveEvaluate = ((Acceptor) it.next()).evaluate(this.input, result);
            if (retryDirectiveEvaluate != null) {
                break;
            }
        }
        return retryDirectiveEvaluate == null ? toDefaultDirective(result) : retryDirectiveEvaluate;
    }

    private final RetryDirective toDefaultDirective(Object obj) {
        return Result.m14506isSuccessimpl(obj) ? new RetryDirective.RetryError(RetryErrorType.ServerSide) : RetryDirective.TerminateAndFail.INSTANCE;
    }
}
