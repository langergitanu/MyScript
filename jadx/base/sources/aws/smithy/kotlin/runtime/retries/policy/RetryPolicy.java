package aws.smithy.kotlin.runtime.retries.policy;

import kotlin.Metadata;

/* JADX INFO: compiled from: RetryPolicy.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "R", "", "Lkotlin/Result;", "result", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "evaluate", "(Ljava/lang/Object;)Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface RetryPolicy<R> {
    RetryDirective evaluate(Object result);
}
