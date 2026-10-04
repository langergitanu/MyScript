package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.HttpException;
import aws.smithy.kotlin.runtime.http.config.EngineFactory;
import aws.smithy.kotlin.runtime.http.engine.CoroutineUtilsKt;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineBase;
import aws.smithy.kotlin.runtime.http.engine.internal.HttpClientMetrics;
import aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpEngineConfig;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.p011io.CloseableKt;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.InstantKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.JobKt;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.coroutines.ExecuteAsyncKt;

/* JADX INFO: compiled from: OkHttpEngine.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u000bJ\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpEngine;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineBase;", "config", "Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpEngineConfig;", "userProvidedClient", "Lokhttp3/OkHttpClient;", "<init>", "(Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpEngineConfig;Lokhttp3/OkHttpClient;)V", "()V", "(Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpEngineConfig;)V", "client", "(Lokhttp3/OkHttpClient;)V", "getConfig", "()Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpEngineConfig;", "connectionMonitoringListener", "Lokhttp3/EventListener;", "metrics", "Laws/smithy/kotlin/runtime/http/engine/internal/HttpClientMetrics;", "getClient", "()Lokhttp3/OkHttpClient;", "client$delegate", "Lkotlin/Lazy;", "roundTrip", "Laws/smithy/kotlin/runtime/http/HttpCall;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "request", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Laws/smithy/kotlin/runtime/http/request/HttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shutdown", "", "Companion", "http-client-engine-okhttp"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OkHttpEngine extends HttpClientEngineBase {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final Function1<Function1<? super OkHttpEngineConfig.Builder, Unit>, OkHttpEngine> engineConstructor;

    /* JADX INFO: renamed from: client$delegate, reason: from kotlin metadata */
    private final Lazy client;
    private final OkHttpEngineConfig config;
    private final EventListener connectionMonitoringListener;
    private final HttpClientMetrics metrics;
    private final OkHttpClient userProvidedClient;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpEngine$roundTrip$1 */
    /* JADX INFO: compiled from: OkHttpEngine.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpEngine", m1609f = "OkHttpEngine.kt", m1610i = {0, 0, 1, 1, 1, 1, 1, 1, 1}, m1611l = {72, 77}, m1612m = "roundTrip", m1613n = {WebViewMessageType.CONTEXT, "request", WebViewMessageType.CONTEXT, "request", "callContext", "engineRequest", "engineCall", "$i$f$mapOkHttpExceptions", "$i$a$-mapOkHttpExceptions-OkHttpEngine$roundTrip$engineResponse$1"}, m1614nl = {74, 231}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, m1616v = 2)
    static final class C37061 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C37061(Continuation<? super C37061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OkHttpEngine.this.roundTrip(null, null, this);
        }
    }

    public /* synthetic */ OkHttpEngine(OkHttpEngineConfig okHttpEngineConfig, OkHttpClient okHttpClient, DefaultConstructorMarker defaultConstructorMarker) {
        this(okHttpEngineConfig, okHttpClient);
    }

    @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngine
    public OkHttpEngineConfig getConfig() {
        return this.config;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private OkHttpEngine(OkHttpEngineConfig okHttpEngineConfig, OkHttpClient okHttpClient) {
        super("OkHttp");
        this.config = okHttpEngineConfig;
        this.userProvidedClient = okHttpClient;
        Duration durationM12197getConnectionIdlePollingIntervalFghU774 = getConfig().getConnectionIdlePollingInterval();
        this.connectionMonitoringListener = durationM12197getConnectionIdlePollingIntervalFghU774 != null ? new ConnectionMonitoringEventListener(durationM12197getConnectionIdlePollingIntervalFghU774.getRawValue(), 0 == true ? 1 : 0) : null;
        this.metrics = new HttpClientMetrics(HttpEngineEventListenerKt.TELEMETRY_SCOPE, getConfig().getTelemetryProvider());
        this.client = LazyKt.lazy(new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpEngine$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return OkHttpEngine.client_delegate$lambda$0(this.f$0);
            }
        });
    }

    public OkHttpEngine() {
        this(OkHttpEngineConfig.INSTANCE.getDefault(), null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OkHttpEngine(OkHttpEngineConfig config) {
        this(config, null);
        Intrinsics.checkNotNullParameter(config, "config");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OkHttpEngine(OkHttpClient client) {
        this(OkHttpEngineConfig.INSTANCE.getDefault(), client);
        Intrinsics.checkNotNullParameter(client, "client");
    }

    /* JADX INFO: compiled from: OkHttpEngine.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00032\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086\u0002R1\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n\u0012\u0004\u0012\u00020\u00030\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpEngine$Companion;", "Laws/smithy/kotlin/runtime/http/config/EngineFactory;", "Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpEngineConfig$Builder;", "Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpEngine;", "<init>", "()V", "invoke", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "engineConstructor", "getEngineConstructor", "()Lkotlin/jvm/functions/Function1;", "http-client-engine-okhttp"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion implements EngineFactory<OkHttpEngineConfig.Builder, OkHttpEngine> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final OkHttpEngine invoke(Function1<? super OkHttpEngineConfig.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return new OkHttpEngine(OkHttpEngineConfig.INSTANCE.invoke(block), null, 0 == true ? 1 : 0);
        }

        @Override // aws.smithy.kotlin.runtime.http.config.EngineFactory
        public Function1<Function1<? super OkHttpEngineConfig.Builder, Unit>, OkHttpEngine> getEngineConstructor() {
            return OkHttpEngine.engineConstructor;
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        engineConstructor = new OkHttpEngine$Companion$engineConstructor$1(companion);
    }

    private final OkHttpClient getClient() {
        return (OkHttpClient) this.client.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpClient client_delegate$lambda$0(OkHttpEngine okHttpEngine) {
        OkHttpClient okHttpClientWithMetrics;
        OkHttpClient okHttpClient = okHttpEngine.userProvidedClient;
        return (okHttpClient == null || (okHttpClientWithMetrics = OkHttpEngineKt.withMetrics(okHttpClient, okHttpEngine.metrics, okHttpEngine.getConfig())) == null) ? OkHttpEngineKt.buildClient(okHttpEngine.getConfig(), okHttpEngine.metrics, okHttpEngine.connectionMonitoringListener) : okHttpClientWithMetrics;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object roundTrip(ExecutionContext executionContext, HttpRequest httpRequest, Continuation<? super HttpCall> continuation) {
        C37061 c37061;
        ExecutionContext executionContext2;
        HttpRequest httpRequest2;
        Object objCallContext;
        HttpRequest httpRequest3;
        CoroutineContext coroutineContext;
        Call call;
        if (continuation instanceof C37061) {
            c37061 = (C37061) continuation;
            if ((c37061.label & Integer.MIN_VALUE) != 0) {
                c37061.label -= Integer.MIN_VALUE;
            } else {
                c37061 = new C37061(continuation);
            }
        }
        Object objExecuteAsync = c37061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37061.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objExecuteAsync);
                executionContext2 = executionContext;
                c37061.L$0 = executionContext2;
                httpRequest2 = httpRequest;
                c37061.L$1 = httpRequest2;
                c37061.label = 1;
                objCallContext = CoroutineUtilsKt.callContext(c37061);
                if (objCallContext != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c37061.I$1;
                int i3 = c37061.I$0;
                Call call2 = (Call) c37061.L$4;
                CoroutineContext coroutineContext2 = (CoroutineContext) c37061.L$2;
                HttpRequest httpRequest4 = (HttpRequest) c37061.L$1;
                ResultKt.throwOnFailure(objExecuteAsync);
                call = call2;
                coroutineContext = coroutineContext2;
                httpRequest3 = httpRequest4;
                final Response response = (Response) objExecuteAsync;
                final OkHttpCall okHttpCall = new OkHttpCall(httpRequest3, OkHttpUtilsKt.toSdkResponse(response), InstantKt.fromEpochMilliseconds(Instant.INSTANCE, response.sentRequestAtMillis()), InstantKt.fromEpochMilliseconds(Instant.INSTANCE, response.receivedResponseAtMillis()), coroutineContext, call);
                JobKt.getJob(coroutineContext).invokeOnCompletion(new Function1() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpEngine$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OkHttpEngine.roundTrip$lambda$1$0(okHttpCall, response, (Throwable) obj);
                    }
                });
                return okHttpCall;
            }
            httpRequest2 = (HttpRequest) c37061.L$1;
            ExecutionContext executionContext3 = (ExecutionContext) c37061.L$0;
            ResultKt.throwOnFailure(objExecuteAsync);
            objCallContext = objExecuteAsync;
            executionContext2 = executionContext3;
            CoroutineContext coroutineContext3 = (CoroutineContext) objCallContext;
            Request okHttpRequest = OkHttpUtilsKt.toOkHttpRequest(httpRequest2, executionContext2, coroutineContext3, this.metrics);
            Call callNewCall = getClient().newCall(okHttpRequest);
            c37061.L$0 = SpillingKt.nullOutSpilledVariable(executionContext2);
            c37061.L$1 = httpRequest2;
            c37061.L$2 = coroutineContext3;
            c37061.L$3 = SpillingKt.nullOutSpilledVariable(okHttpRequest);
            c37061.L$4 = callNewCall;
            c37061.I$0 = 0;
            c37061.I$1 = 0;
            c37061.label = 2;
            objExecuteAsync = ExecuteAsyncKt.executeAsync(callNewCall, c37061);
            if (objExecuteAsync != coroutine_suspended) {
                httpRequest3 = httpRequest2;
                coroutineContext = coroutineContext3;
                call = callNewCall;
                final Response response2 = (Response) objExecuteAsync;
                final OkHttpCall okHttpCall2 = new OkHttpCall(httpRequest3, OkHttpUtilsKt.toSdkResponse(response2), InstantKt.fromEpochMilliseconds(Instant.INSTANCE, response2.sentRequestAtMillis()), InstantKt.fromEpochMilliseconds(Instant.INSTANCE, response2.receivedResponseAtMillis()), coroutineContext, call);
                JobKt.getJob(coroutineContext).invokeOnCompletion(new Function1() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpEngine$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OkHttpEngine.roundTrip$lambda$1$0(okHttpCall2, response2, (Throwable) obj);
                    }
                });
                return okHttpCall2;
            }
            return coroutine_suspended;
        } catch (IOException e) {
            throw new HttpException((Throwable) e, OkHttpUtilsKt.errCode(e), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit roundTrip$lambda$1$0(OkHttpCall okHttpCall, Response response, Throwable th) {
        if (th != null) {
            okHttpCall.cancelInFlight();
        }
        response.body().close();
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineBase
    protected void shutdown() throws IOException {
        EventListener eventListener = this.connectionMonitoringListener;
        if (eventListener != null) {
            CloseableKt.closeIfCloseable(eventListener);
        }
        this.metrics.close();
        if (this.userProvidedClient == null) {
            getClient().connectionPool().evictAll();
            getClient().dispatcher().executorService().shutdown();
        }
    }
}
