package aws.smithy.kotlin.runtime.retries.policy;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Acceptors.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002B#\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fR#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/policy/OutputAcceptor;", "O", "Laws/smithy/kotlin/runtime/retries/policy/Acceptor;", "", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "state", "Lkotlin/Function1;", "", "matcher", "<init>", "(Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;Lkotlin/jvm/functions/Function1;)V", "request", "Lkotlin/Result;", "result", "matches", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlin/jvm/functions/Function1;", "getMatcher", "()Lkotlin/jvm/functions/Function1;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OutputAcceptor<O> extends Acceptor<Object, O> {
    private final Function1<O, Boolean> matcher;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OutputAcceptor(RetryDirective state, Function1<? super O, Boolean> matcher) {
        super(state);
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        this.matcher = matcher;
    }

    public final Function1<O, Boolean> getMatcher() {
        return this.matcher;
    }

    @Override // aws.smithy.kotlin.runtime.retries.policy.Acceptor
    protected boolean matches(Object request, Object result) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (Result.m14505isFailureimpl(result)) {
            result = null;
        }
        if (result != null) {
            return this.matcher.invoke((O) result).booleanValue();
        }
        return false;
    }
}
