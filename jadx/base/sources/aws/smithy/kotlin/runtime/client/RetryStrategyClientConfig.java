package aws.smithy.kotlin.runtime.client;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.retries.RetryStrategy;
import aws.smithy.kotlin.runtime.retries.RetryStrategyConfigDsl;
import aws.smithy.kotlin.runtime.retries.StandardRetryStrategy;
import aws.smithy.kotlin.runtime.util.DslFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RetryClientConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/RetryStrategyClientConfig;", "", "retryStrategy", "Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "getRetryStrategy", "()Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "Builder", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface RetryStrategyClientConfig {

    /* JADX INFO: compiled from: RetryClientConfig.kt */
    @RetryStrategyConfigDsl
    @Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0007H&JI\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\t\"\b\b\u0001\u0010\n*\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\n0\r2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0007H&J\b\u0010\u0012\u001a\u00020\u0013H'R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/RetryStrategyClientConfig$Builder;", "", "retryStrategy", "", "block", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy$Config$Builder;", "Lkotlin/ExtensionFunctionType;", "B", "Laws/smithy/kotlin/runtime/retries/RetryStrategy$Config$Builder;", "R", "Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "factory", "Laws/smithy/kotlin/runtime/util/DslFactory;", "getRetryStrategy", "()Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "setRetryStrategy", "(Laws/smithy/kotlin/runtime/retries/RetryStrategy;)V", "buildRetryStrategyClientConfig", "Laws/smithy/kotlin/runtime/client/RetryStrategyClientConfig;", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Builder {
        @InternalApi
        RetryStrategyClientConfig buildRetryStrategyClientConfig();

        RetryStrategy getRetryStrategy();

        <B extends RetryStrategy.Config.Builder, R extends RetryStrategy> void retryStrategy(DslFactory<? extends B, ? extends R> factory, Function1<? super B, Unit> block);

        void retryStrategy(Function1<? super StandardRetryStrategy.Config.Builder, Unit> block);

        void setRetryStrategy(RetryStrategy retryStrategy);
    }

    RetryStrategy getRetryStrategy();
}
