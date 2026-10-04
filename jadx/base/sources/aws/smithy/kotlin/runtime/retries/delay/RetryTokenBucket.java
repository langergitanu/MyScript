package aws.smithy.kotlin.runtime.retries.delay;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.retries.RetryStrategyConfigDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RetryTokenBucket.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u0010\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket;", "", "Laws/smithy/kotlin/runtime/retries/delay/RetryToken;", "acquireToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket$Config;", "getConfig", "()Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket$Config;", "config", "Config", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface RetryTokenBucket {

    /* JADX INFO: compiled from: RetryTokenBucket.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\bJ \u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket$Config;", "", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket$Config$Builder;", "", "Lkotlin/ExtensionFunctionType;", "toBuilderApplicator", "()Lkotlin/jvm/functions/Function1;", "Builder", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Config {

        /* JADX INFO: compiled from: RetryTokenBucket.kt */
        @RetryStrategyConfigDsl
        @Metadata(m1598d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket$Config$Builder;", "", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public interface Builder {
        }

        @InternalApi
        Function1<Builder, Unit> toBuilderApplicator();
    }

    Object acquireToken(Continuation<? super RetryToken> continuation);

    Config getConfig();
}
