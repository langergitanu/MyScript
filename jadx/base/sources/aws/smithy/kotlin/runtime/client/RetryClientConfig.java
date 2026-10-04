package aws.smithy.kotlin.runtime.client;

import aws.smithy.kotlin.runtime.retries.policy.RetryPolicy;
import kotlin.Metadata;

/* JADX INFO: compiled from: RetryClientConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0007R\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/RetryClientConfig;", "Laws/smithy/kotlin/runtime/client/RetryStrategyClientConfig;", "retryPolicy", "Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "", "getRetryPolicy", "()Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "Builder", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface RetryClientConfig extends RetryStrategyClientConfig {

    /* JADX INFO: compiled from: RetryClientConfig.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\"\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/RetryClientConfig$Builder;", "", "retryPolicy", "Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "getRetryPolicy", "()Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "setRetryPolicy", "(Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;)V", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Builder {
        RetryPolicy<Object> getRetryPolicy();

        void setRetryPolicy(RetryPolicy<Object> retryPolicy);
    }

    RetryPolicy<Object> getRetryPolicy();
}
