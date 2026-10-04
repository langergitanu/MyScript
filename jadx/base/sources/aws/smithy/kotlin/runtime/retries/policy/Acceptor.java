package aws.smithy.kotlin.runtime.retries.policy;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Acceptors.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00002\u00020\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00028\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00028\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\tH$¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/policy/Acceptor;", "I", "O", "", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "state", "<init>", "(Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;)V", "request", "Lkotlin/Result;", "result", "evaluate", "(Ljava/lang/Object;Ljava/lang/Object;)Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "", "matches", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "getState", "()Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class Acceptor<I, O> {
    private final RetryDirective state;

    protected abstract boolean matches(I request, Object result);

    public Acceptor(RetryDirective state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
    }

    public final RetryDirective getState() {
        return this.state;
    }

    public final RetryDirective evaluate(I request, Object result) {
        if (matches(request, result)) {
            return this.state;
        }
        return null;
    }
}
