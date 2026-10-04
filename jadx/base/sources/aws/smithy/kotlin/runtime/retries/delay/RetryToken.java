package aws.smithy.kotlin.runtime.retries.delay;

import aws.smithy.kotlin.runtime.retries.policy.RetryErrorType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: RetryTokenBucket.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0004J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H¦@¢\u0006\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/RetryToken;", "", "", "notifyFailure", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifySuccess", "Laws/smithy/kotlin/runtime/retries/policy/RetryErrorType;", "reason", "scheduleRetry", "(Laws/smithy/kotlin/runtime/retries/policy/RetryErrorType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface RetryToken {
    Object notifyFailure(Continuation<? super Unit> continuation);

    Object notifySuccess(Continuation<? super Unit> continuation);

    Object scheduleRetry(RetryErrorType retryErrorType, Continuation<? super RetryToken> continuation);
}
