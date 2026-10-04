package aws.sdk.kotlin.runtime.config;

import androidx.compose.material.TextFieldImplKt;
import aws.sdk.kotlin.runtime.config.AwsSdkClientConfig;
import aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder;
import aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import aws.smithy.kotlin.runtime.client.AbstractSdkClientFactory;
import aws.smithy.kotlin.runtime.client.SdkClient;
import aws.smithy.kotlin.runtime.client.SdkClient.Builder;
import aws.smithy.kotlin.runtime.client.SdkClientConfig;
import aws.smithy.kotlin.runtime.client.SdkClientConfig.Builder;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.telemetry.TelemetryConfig;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProviderContext;
import aws.smithy.kotlin.runtime.telemetry.context.Context;
import aws.smithy.kotlin.runtime.telemetry.context.ContextManager;
import aws.smithy.kotlin.runtime.telemetry.context.TelemetryContextElement;
import aws.smithy.kotlin.runtime.telemetry.context.TelemetryContextElementKt;
import aws.smithy.kotlin.runtime.telemetry.trace.SpanKind;
import aws.smithy.kotlin.runtime.telemetry.trace.SpanStatus;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpanContext;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpanExtKt;
import aws.smithy.kotlin.runtime.telemetry.trace.Tracer;
import aws.smithy.kotlin.runtime.util.LazyAsyncValue;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: compiled from: AbstractAwsSdkClientFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\f\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u0003*\u0012\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00010\u0005*\u00020\u0006*\b\b\u0002\u0010\u0007*\u00020\b*\u001a\b\u0003\u0010\t*\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00070\n2\u001a\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\t0\u000bB\u0007¢\u0006\u0004\b\f\u0010\rJ+\u0010\u000e\u001a\u00028\u00022\u001b\b\u0002\u0010\u000f\u001a\u0015\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\u0002\b\u0012H\u0086@¢\u0006\u0002\u0010\u0013J6\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00028\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0010\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u001aj\u0002`\u001b0\u0017H\u0094@¢\u0006\u0002\u0010\u001c¨\u0006\u001d"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/AbstractAwsSdkClientFactory;", "TConfig", "Laws/smithy/kotlin/runtime/client/SdkClientConfig;", "Laws/sdk/kotlin/runtime/config/AwsSdkClientConfig;", "TConfigBuilder", "Laws/smithy/kotlin/runtime/client/SdkClientConfig$Builder;", "Laws/sdk/kotlin/runtime/config/AwsSdkClientConfig$Builder;", "TClient", "Laws/smithy/kotlin/runtime/client/SdkClient;", "TClientBuilder", "Laws/smithy/kotlin/runtime/client/SdkClient$Builder;", "Laws/smithy/kotlin/runtime/client/AbstractSdkClientFactory;", "<init>", "()V", "fromEnvironment", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finalizeEnvironmentalConfig", "builder", "sharedConfig", "Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "Laws/sdk/kotlin/runtime/config/profile/AwsSharedConfig;", "activeProfile", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;", "(Laws/smithy/kotlin/runtime/client/SdkClient$Builder;Laws/smithy/kotlin/runtime/util/LazyAsyncValue;Laws/smithy/kotlin/runtime/util/LazyAsyncValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class AbstractAwsSdkClientFactory<TConfig extends SdkClientConfig & AwsSdkClientConfig, TConfigBuilder extends SdkClientConfig.Builder<TConfig> & AwsSdkClientConfig.Builder, TClient extends SdkClient, TClientBuilder extends SdkClient.Builder<TConfig, TConfigBuilder, ? extends TClient>> extends AbstractSdkClientFactory<TConfig, TConfigBuilder, TClient, TClientBuilder> {

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.AbstractAwsSdkClientFactory$fromEnvironment$1 */
    /* JADX INFO: compiled from: AbstractAwsSdkClientFactory.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.AbstractAwsSdkClientFactory", m1609f = "AbstractAwsSdkClientFactory.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {149}, m1612m = "fromEnvironment", m1613n = {"block", "builder", "config", "telemetryProvider", "tracer", "$this$withSpan_u24default$iv", "name$iv", "initialAttributes$iv", "spanKind$iv", "context$iv", "parent$iv", "span$iv", "span$iv$iv", "context$iv$iv", "telemetryCtxElement$iv$iv", "updatedCtx$iv$iv", "$i$f$withSpan", "$i$f$withSpan"}, m1614nl = {TextFieldImplKt.AnimationDuration}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "I$0", "I$1"}, m1616v = 2)
    static final class C30921 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AbstractAwsSdkClientFactory<TConfig, TConfigBuilder, TClient, TClientBuilder> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C30921(AbstractAwsSdkClientFactory<TConfig, TConfigBuilder, TClient, TClientBuilder> abstractAwsSdkClientFactory, Continuation<? super C30921> continuation) {
            super(continuation);
            this.this$0 = abstractAwsSdkClientFactory;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.fromEnvironment(null, this);
        }
    }

    protected Object finalizeEnvironmentalConfig(TClientBuilder tclientbuilder, LazyAsyncValue<AwsSharedConfig> lazyAsyncValue, LazyAsyncValue<ConfigSection> lazyAsyncValue2, Continuation<? super Unit> continuation) {
        return finalizeEnvironmentalConfig$suspendImpl(this, tclientbuilder, lazyAsyncValue, lazyAsyncValue2, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object fromEnvironment$default(AbstractAwsSdkClientFactory abstractAwsSdkClientFactory, Function1 function1, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fromEnvironment");
        }
        if ((i & 1) != 0) {
            function1 = null;
        }
        return abstractAwsSdkClientFactory.fromEnvironment(function1, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b2 A[Catch: all -> 0x0075, TryCatch #1 {all -> 0x0075, blocks: (B:12:0x0070, B:54:0x01ae, B:56:0x01b2, B:58:0x01c9, B:57:0x01bd), top: B:61:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01bd A[Catch: all -> 0x0075, TryCatch #1 {all -> 0x0075, blocks: (B:12:0x0070, B:54:0x01ae, B:56:0x01b2, B:58:0x01c9, B:57:0x01bd), top: B:61:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fromEnvironment(Function1<? super TConfigBuilder, Unit> function1, Continuation<? super TClient> continuation) throws Throwable {
        C30921 c30921;
        AbstractAwsSdkClientFactory<TConfig, TConfigBuilder, TClient, TClientBuilder> abstractAwsSdkClientFactory;
        TelemetryProvider none;
        TraceSpan traceSpan;
        CoroutineContext telemetryContextElement;
        SdkClient.Builder builder;
        TelemetryProvider provider;
        ContextManager contextManager;
        if (continuation instanceof C30921) {
            c30921 = (C30921) continuation;
            if ((c30921.label & Integer.MIN_VALUE) != 0) {
                c30921.label -= Integer.MIN_VALUE;
                abstractAwsSdkClientFactory = this;
            } else {
                abstractAwsSdkClientFactory = this;
                c30921 = new C30921(abstractAwsSdkClientFactory, continuation);
            }
        }
        Object obj = c30921.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = c30921.label;
        try {
            if (r2 != 0) {
                if (r2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i = c30921.I$1;
                int i2 = c30921.I$0;
                traceSpan = (TraceSpan) c30921.L$12;
                builder = (SdkClient.Builder) c30921.L$1;
                try {
                    ResultKt.throwOnFailure(obj);
                    traceSpan.close();
                    return builder.build();
                } catch (Exception e) {
                    e = e;
                    if (e instanceof CancellationException) {
                        traceSpan.setStatus(SpanStatus.ERROR);
                        TraceSpanExtKt.recordException(traceSpan, e, true);
                    } else {
                        TraceSpanExtKt.setAttribute(traceSpan, "cancelled", Boxing.boxBoolean(true));
                    }
                    throw e;
                }
            }
            ResultKt.throwOnFailure(obj);
            TClientBuilder tclientbuilderBuilder = abstractAwsSdkClientFactory.builder();
            SdkClientConfig.Builder config = tclientbuilderBuilder.getConfig();
            TelemetryConfig.Builder builder2 = tclientbuilderBuilder instanceof TelemetryConfig.Builder ? (TelemetryConfig.Builder) tclientbuilderBuilder : null;
            if (builder2 == null || (none = builder2.getTelemetryProvider()) == null) {
                none = TelemetryProvider.INSTANCE.getNone();
            }
            Tracer orCreateTracer = none.getTracerProvider().getOrCreateTracer("AwsSdkClientFactory");
            Attributes attributesEmptyAttributes = AttributesKt.emptyAttributes();
            SpanKind spanKind = SpanKind.INTERNAL;
            EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
            Context telemetryContext = TelemetryContextElementKt.getTelemetryContext(c30921.get$context());
            TraceSpan traceSpanCreateSpan = orCreateTracer.createSpan("fromEnvironment", attributesEmptyAttributes, spanKind, telemetryContext);
            try {
                TelemetryProviderContext telemetryProviderContext = (TelemetryProviderContext) c30921.get$context().get(TelemetryProviderContext.INSTANCE);
                Context contextCurrent = (telemetryProviderContext == null || (provider = telemetryProviderContext.getProvider()) == null || (contextManager = provider.getContextManager()) == null) ? null : contextManager.current();
                if (contextCurrent != null) {
                    telemetryContextElement = new TelemetryContextElement(contextCurrent);
                } else {
                    telemetryContextElement = (TelemetryContextElement) c30921.get$context().get(TelemetryContextElement.INSTANCE);
                    if (telemetryContextElement == null) {
                        telemetryContextElement = EmptyCoroutineContext.INSTANCE;
                    }
                }
                CoroutineContext coroutineContext = telemetryContextElement;
                TelemetryProvider telemetryProvider = none;
                CoroutineContext coroutineContextPlus = emptyCoroutineContext.plus(new TraceSpanContext(traceSpanCreateSpan)).plus(coroutineContext).plus(traceSpanCreateSpan.asContextElement());
                Context context = contextCurrent;
                C3091x4caf68f8 c3091x4caf68f8 = new C3091x4caf68f8(traceSpanCreateSpan, null, config, function1, abstractAwsSdkClientFactory, tclientbuilderBuilder);
                c30921.L$0 = SpillingKt.nullOutSpilledVariable(function1);
                c30921.L$1 = tclientbuilderBuilder;
                c30921.L$2 = SpillingKt.nullOutSpilledVariable(config);
                c30921.L$3 = SpillingKt.nullOutSpilledVariable(telemetryProvider);
                c30921.L$4 = SpillingKt.nullOutSpilledVariable(orCreateTracer);
                c30921.L$5 = SpillingKt.nullOutSpilledVariable(orCreateTracer);
                c30921.L$6 = SpillingKt.nullOutSpilledVariable("fromEnvironment");
                c30921.L$7 = SpillingKt.nullOutSpilledVariable(attributesEmptyAttributes);
                c30921.L$8 = SpillingKt.nullOutSpilledVariable(spanKind);
                c30921.L$9 = SpillingKt.nullOutSpilledVariable(emptyCoroutineContext);
                c30921.L$10 = SpillingKt.nullOutSpilledVariable(telemetryContext);
                c30921.L$11 = SpillingKt.nullOutSpilledVariable(traceSpanCreateSpan);
                c30921.L$12 = traceSpanCreateSpan;
                c30921.L$13 = SpillingKt.nullOutSpilledVariable(emptyCoroutineContext);
                c30921.L$14 = SpillingKt.nullOutSpilledVariable(coroutineContext);
                c30921.L$15 = SpillingKt.nullOutSpilledVariable(context);
                c30921.I$0 = 0;
                c30921.I$1 = 0;
                c30921.label = 1;
                if (BuildersKt.withContext(coroutineContextPlus, c3091x4caf68f8, c30921) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                traceSpan = traceSpanCreateSpan;
                builder = tclientbuilderBuilder;
                traceSpan.close();
                return builder.build();
            } catch (Exception e2) {
                e = e2;
                traceSpan = traceSpanCreateSpan;
                if (e instanceof CancellationException) {
                }
                throw e;
            } catch (Throwable th) {
                th = th;
                r2 = traceSpanCreateSpan;
                r2.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    static /* synthetic */ <TConfig extends SdkClientConfig & AwsSdkClientConfig, TConfigBuilder extends SdkClientConfig.Builder<TConfig> & AwsSdkClientConfig.Builder, TClient extends SdkClient, TClientBuilder extends SdkClient.Builder<TConfig, TConfigBuilder, ? extends TClient>> Object finalizeEnvironmentalConfig$suspendImpl(AbstractAwsSdkClientFactory<TConfig, TConfigBuilder, TClient, TClientBuilder> abstractAwsSdkClientFactory, TClientBuilder tclientbuilder, LazyAsyncValue<AwsSharedConfig> lazyAsyncValue, LazyAsyncValue<ConfigSection> lazyAsyncValue2, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}
