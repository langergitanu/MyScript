package aws.smithy.kotlin.runtime.retries.policy;

import aws.smithy.kotlin.runtime.InternalApi;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Acceptors.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/policy/SuccessAcceptor;", "Laws/smithy/kotlin/runtime/retries/policy/Acceptor;", "", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "state", "", FirebaseAnalytics.Param.SUCCESS, "<init>", "(Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;Z)V", "request", "Lkotlin/Result;", "result", "matches", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Z", "getSuccess", "()Z", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SuccessAcceptor extends Acceptor<Object, Object> {
    private final boolean success;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuccessAcceptor(RetryDirective state, boolean z) {
        super(state);
        Intrinsics.checkNotNullParameter(state, "state");
        this.success = z;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    @Override // aws.smithy.kotlin.runtime.retries.policy.Acceptor
    protected boolean matches(Object request, Object result) {
        Intrinsics.checkNotNullParameter(request, "request");
        return Result.m14506isSuccessimpl(result) == this.success;
    }
}
