package aws.smithy.kotlin.runtime.retries.delay;

import aws.smithy.kotlin.runtime.retries.delay.RetryTokenBucket;
import aws.smithy.kotlin.runtime.retries.policy.RetryErrorType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: InfiniteTokenBucket.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/InfiniteTokenBucket;", "Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket;", "<init>", "()V", "Laws/smithy/kotlin/runtime/retries/delay/RetryToken;", "acquireToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket$Config;", "config", "Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket$Config;", "getConfig", "()Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket$Config;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InfiniteTokenBucket implements RetryTokenBucket {
    public static final InfiniteTokenBucket INSTANCE = new InfiniteTokenBucket();
    private static final RetryTokenBucket.Config config = new InfiniteTokenBucket$config$1();

    private InfiniteTokenBucket() {
    }

    @Override // aws.smithy.kotlin.runtime.retries.delay.RetryTokenBucket
    public RetryTokenBucket.Config getConfig() {
        return config;
    }

    @Override // aws.smithy.kotlin.runtime.retries.delay.RetryTokenBucket
    public Object acquireToken(Continuation<? super RetryToken> continuation) {
        return new RetryToken() { // from class: aws.smithy.kotlin.runtime.retries.delay.InfiniteTokenBucket.acquireToken.2
            @Override // aws.smithy.kotlin.runtime.retries.delay.RetryToken
            public Object scheduleRetry(RetryErrorType retryErrorType, Continuation<? super RetryToken> continuation2) {
                return this;
            }

            @Override // aws.smithy.kotlin.runtime.retries.delay.RetryToken
            public Object notifyFailure(Continuation<? super Unit> continuation2) {
                return Unit.INSTANCE;
            }

            @Override // aws.smithy.kotlin.runtime.retries.delay.RetryToken
            public Object notifySuccess(Continuation<? super Unit> continuation2) {
                return Unit.INSTANCE;
            }
        };
    }
}
