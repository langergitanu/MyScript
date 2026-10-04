package aws.smithy.kotlin.runtime.client;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig;
import aws.smithy.kotlin.runtime.client.RetryStrategyClientConfigImpl;
import aws.smithy.kotlin.runtime.retries.RetryStrategy;
import aws.smithy.kotlin.runtime.retries.StandardRetryStrategy;
import aws.smithy.kotlin.runtime.util.DslBuilderProperty;
import aws.smithy.kotlin.runtime.util.DslFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RetryClientConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/RetryStrategyClientConfigImpl;", "Laws/smithy/kotlin/runtime/client/RetryStrategyClientConfig;", "retryStrategy", "Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "<init>", "(Laws/smithy/kotlin/runtime/retries/RetryStrategy;)V", "getRetryStrategy", "()Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "BuilderImpl", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RetryStrategyClientConfigImpl implements RetryStrategyClientConfig {
    private final RetryStrategy retryStrategy;

    public /* synthetic */ RetryStrategyClientConfigImpl(RetryStrategy retryStrategy, DefaultConstructorMarker defaultConstructorMarker) {
        this(retryStrategy);
    }

    private RetryStrategyClientConfigImpl(RetryStrategy retryStrategy) {
        this.retryStrategy = retryStrategy;
    }

    @Override // aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig
    public RetryStrategy getRetryStrategy() {
        return this.retryStrategy;
    }

    /* JADX INFO: compiled from: RetryClientConfig.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\u00102\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0002\b\u0014H\u0016JI\u0010\t\u001a\u00020\u0010\"\b\b\u0000\u0010\u0015*\u00020\u0006\"\b\b\u0001\u0010\u0016*\u00020\u00072\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00160\u00182\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0002\b\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0017R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u008e\u0002¢\u0006\u0012\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f*\u0004\b\n\u0010\u000b¨\u0006\u001b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/RetryStrategyClientConfigImpl$BuilderImpl;", "Laws/smithy/kotlin/runtime/client/RetryStrategyClientConfig$Builder;", "<init>", "()V", "retryStrategyProperty", "Laws/smithy/kotlin/runtime/util/DslBuilderProperty;", "Laws/smithy/kotlin/runtime/retries/RetryStrategy$Config$Builder;", "Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "<set-?>", "retryStrategy", "getRetryStrategy$delegate", "(Laws/smithy/kotlin/runtime/client/RetryStrategyClientConfigImpl$BuilderImpl;)Ljava/lang/Object;", "getRetryStrategy", "()Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "setRetryStrategy", "(Laws/smithy/kotlin/runtime/retries/RetryStrategy;)V", "", "block", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy$Config$Builder;", "Lkotlin/ExtensionFunctionType;", "B", "R", "factory", "Laws/smithy/kotlin/runtime/util/DslFactory;", "buildRetryStrategyClientConfig", "Laws/smithy/kotlin/runtime/client/RetryStrategyClientConfig;", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class BuilderImpl implements RetryStrategyClientConfig.Builder {
        private final DslBuilderProperty<RetryStrategy.Config.Builder, RetryStrategy> retryStrategyProperty = new DslBuilderProperty<>(StandardRetryStrategy.INSTANCE, new Function1() { // from class: aws.smithy.kotlin.runtime.client.RetryStrategyClientConfigImpl$BuilderImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RetryStrategyClientConfigImpl.BuilderImpl.retryStrategyProperty$lambda$0((RetryStrategy) obj);
            }
        }, null, 4, null);

        /* JADX INFO: Access modifiers changed from: private */
        public static final Function1 retryStrategyProperty$lambda$0(RetryStrategy DslBuilderProperty) {
            Intrinsics.checkNotNullParameter(DslBuilderProperty, "$this$DslBuilderProperty");
            return DslBuilderProperty.getConfig().toBuilderApplicator();
        }

        @Override // aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig.Builder
        public RetryStrategy getRetryStrategy() {
            return this.retryStrategyProperty.getInstance();
        }

        @Override // aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig.Builder
        public void setRetryStrategy(RetryStrategy retryStrategy) {
            this.retryStrategyProperty.setInstance(retryStrategy);
        }

        @Override // aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig.Builder
        public void retryStrategy(Function1<? super StandardRetryStrategy.Config.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.retryStrategyProperty.dsl(StandardRetryStrategy.INSTANCE, block);
        }

        @Override // aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig.Builder
        public <B extends RetryStrategy.Config.Builder, R extends RetryStrategy> void retryStrategy(DslFactory<? extends B, ? extends R> factory, Function1<? super B, Unit> block) {
            Intrinsics.checkNotNullParameter(factory, "factory");
            Intrinsics.checkNotNullParameter(block, "block");
            this.retryStrategyProperty.dsl(factory, block);
        }

        @Override // aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig.Builder
        @InternalApi
        public RetryStrategyClientConfig buildRetryStrategyClientConfig() {
            return new RetryStrategyClientConfigImpl(this.retryStrategyProperty.getSupply().invoke(), null);
        }
    }
}
