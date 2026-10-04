package aws.sdk.kotlin.runtime.config.imds;

import aws.sdk.kotlin.runtime.config.imds.EndpointConfiguration;
import aws.sdk.kotlin.runtime.http.ApiMetadata;
import aws.sdk.kotlin.runtime.http.AwsUserAgentMetadata;
import aws.sdk.kotlin.runtime.http.middleware.UserAgent;
import aws.smithy.kotlin.runtime.client.LogMode;
import aws.smithy.kotlin.runtime.client.SdkClientOption;
import aws.smithy.kotlin.runtime.http.SdkHttpClient;
import aws.smithy.kotlin.runtime.http.engine.CloseableHttpClientEngine;
import aws.smithy.kotlin.runtime.http.engine.DefaultHttpEngineKt;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig;
import aws.smithy.kotlin.runtime.http.engine.ProxySelector;
import aws.smithy.kotlin.runtime.http.operation.HttpSerializer;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationBuilder;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.p011io.CloseableKt;
import aws.smithy.kotlin.runtime.p011io.Handler;
import aws.smithy.kotlin.runtime.p011io.middleware.Phase;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: ImdsClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0096@¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020%H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/imds/ImdsClient;", "Laws/sdk/kotlin/runtime/config/imds/InstanceMetadataProvider;", "builder", "Laws/sdk/kotlin/runtime/config/imds/ImdsClient$Builder;", "<init>", "(Laws/sdk/kotlin/runtime/config/imds/ImdsClient$Builder;)V", "()V", "maxRetries", "", "endpointConfiguration", "Laws/sdk/kotlin/runtime/config/imds/EndpointConfiguration;", "tokenTtl", "Lkotlin/time/Duration;", "J", "clock", "Laws/smithy/kotlin/runtime/time/Clock;", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "logMode", "Laws/smithy/kotlin/runtime/client/LogMode;", "engine", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "httpClient", "Laws/smithy/kotlin/runtime/http/SdkHttpClient;", "manageEngine", "", "userAgentMiddleware", "Laws/sdk/kotlin/runtime/http/middleware/UserAgent;", "imdsEndpointProvider", "Laws/sdk/kotlin/runtime/config/imds/ImdsEndpointProvider;", "tokenMiddleware", "Laws/sdk/kotlin/runtime/config/imds/TokenMiddleware;", "get", "", ClientCookie.PATH_ATTR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "Companion", "Builder", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ImdsClient implements InstanceMetadataProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Clock clock;
    private final EndpointConfiguration endpointConfiguration;
    private final HttpClientEngine engine;
    private final SdkHttpClient httpClient;
    private final ImdsEndpointProvider imdsEndpointProvider;
    private final LogMode logMode;
    private final boolean manageEngine;
    private final int maxRetries;
    private final PlatformProvider platformProvider;
    private final TokenMiddleware tokenMiddleware;
    private final long tokenTtl;
    private final UserAgent userAgentMiddleware;

    public /* synthetic */ ImdsClient(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private ImdsClient(Builder builder) {
        int maxRetries = builder.getMaxRetries();
        this.maxRetries = maxRetries;
        EndpointConfiguration endpointConfiguration = builder.getEndpointConfiguration();
        this.endpointConfiguration = endpointConfiguration;
        long tokenTtl = builder.getTokenTtl();
        this.tokenTtl = tokenTtl;
        Clock clock = builder.getClock();
        this.clock = clock;
        PlatformProvider platformProvider = builder.getPlatformProvider();
        this.platformProvider = platformProvider;
        this.logMode = builder.getLogMode();
        this.manageEngine = builder.getEngine() == null;
        if (maxRetries <= 0) {
            throw new IllegalArgumentException("maxRetries must be greater than zero".toString());
        }
        CloseableHttpClientEngine engine = builder.getEngine();
        engine = engine == null ? DefaultHttpEngineKt.DefaultHttpEngine(new Function1() { // from class: aws.sdk.kotlin.runtime.config.imds.ImdsClient$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImdsClient._init_$lambda$1((HttpClientEngineConfig.Builder) obj);
            }
        }) : engine;
        this.engine = engine;
        SdkHttpClient sdkHttpClient = new SdkHttpClient(engine);
        this.httpClient = sdkHttpClient;
        this.userAgentMiddleware = new UserAgent(AwsUserAgentMetadata.Companion.fromEnvironment$default(AwsUserAgentMetadata.INSTANCE, new ApiMetadata("imds", "unknown"), null, 2, null));
        ImdsEndpointProvider imdsEndpointProvider = new ImdsEndpointProvider(platformProvider, endpointConfiguration);
        this.imdsEndpointProvider = imdsEndpointProvider;
        this.tokenMiddleware = new TokenMiddleware(sdkHttpClient, imdsEndpointProvider, tokenTtl, clock, null);
    }

    public ImdsClient() {
        this(new Builder());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(HttpClientEngineConfig.Builder DefaultHttpEngine) {
        Intrinsics.checkNotNullParameter(DefaultHttpEngine, "$this$DefaultHttpEngine");
        Duration.Companion companion = Duration.INSTANCE;
        DefaultHttpEngine.mo12181setConnectTimeoutLRDsOJo(DurationKt.toDuration(1, DurationUnit.SECONDS));
        Duration.Companion companion2 = Duration.INSTANCE;
        DefaultHttpEngine.mo12185setSocketReadTimeoutLRDsOJo(DurationKt.toDuration(1, DurationUnit.SECONDS));
        DefaultHttpEngine.setProxySelector(ProxySelector.INSTANCE.getNoProxy());
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: ImdsClient.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/imds/ImdsClient$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/runtime/config/imds/ImdsClient;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/config/imds/ImdsClient$Builder;", "", "Lkotlin/ExtensionFunctionType;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImdsClient invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return new ImdsClient(builder, null);
        }
    }

    @Override // aws.sdk.kotlin.runtime.config.imds.InstanceMetadataProvider
    public Object get(String str, Continuation<? super String> continuation) {
        CoroutineContext coroutineContext = continuation.get$context();
        String qualifiedName = Reflection.getOrCreateKotlinClass(ImdsClient.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
        }
        Logger logger = CoroutineContextLogExtKt.logger(coroutineContext, qualifiedName);
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(Unit.class), Reflection.getOrCreateKotlinClass(String.class));
        sdkHttpOperationBuilder.setSerializeWith(HttpSerializer.INSTANCE.getUnit());
        sdkHttpOperationBuilder.setDeserializeWith(new ImdsClient$get$op$1$1(logger));
        sdkHttpOperationBuilder.setOperationName(str);
        sdkHttpOperationBuilder.setServiceName("IMDS");
        sdkHttpOperationBuilder.getContext().set(SdkClientOption.INSTANCE.getLogMode(), this.logMode);
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(this.imdsEndpointProvider);
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        sdkHttpOperationBuild.getExecution().setRetryPolicy(new ImdsRetryPolicy(continuation.get$context()));
        sdkHttpOperationBuild.install(this.userAgentMiddleware);
        sdkHttpOperationBuild.install(this.tokenMiddleware);
        sdkHttpOperationBuild.getExecution().getMutate().intercept(Phase.Order.Before, new C31082(str, null));
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.httpClient, Unit.INSTANCE, continuation);
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.imds.ImdsClient$get$2 */
    /* JADX INFO: compiled from: ImdsClient.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0010\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\u001c\u0010\u0006\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012\u0004\u0012\u00020\u00010\u0007H\n"}, m1599d2 = {"<anonymous>", "", "req", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "next", "Laws/smithy/kotlin/runtime/io/Handler;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.imds.ImdsClient$get$2", m1609f = "ImdsClient.kt", m1610i = {0, 0}, m1611l = {144}, m1612m = "invokeSuspend", m1613n = {"req", "next"}, m1614nl = {-1}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C31082 extends SuspendLambda implements Function3<OperationRequest<HttpRequestBuilder>, Handler<? super OperationRequest<HttpRequestBuilder>, ? extends String>, Continuation<? super String>, Object> {
        final /* synthetic */ String $path;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31082(String str, Continuation<? super C31082> continuation) {
            super(3, continuation);
            this.$path = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(OperationRequest<HttpRequestBuilder> operationRequest, Handler<? super OperationRequest<HttpRequestBuilder>, String> handler, Continuation<? super String> continuation) {
            C31082 c31082 = new C31082(this.$path, continuation);
            c31082.L$0 = operationRequest;
            c31082.L$1 = handler;
            return c31082.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(OperationRequest<HttpRequestBuilder> operationRequest, Handler<? super OperationRequest<HttpRequestBuilder>, ? extends String> handler, Continuation<? super String> continuation) {
            return invoke2(operationRequest, (Handler<? super OperationRequest<HttpRequestBuilder>, String>) handler, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            OperationRequest operationRequest = (OperationRequest) this.L$0;
            Handler handler = (Handler) this.L$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            ((HttpRequestBuilder) operationRequest.getSubject()).getUrl().getPath().setEncoded(this.$path);
            this.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest);
            this.L$1 = SpillingKt.nullOutSpilledVariable(handler);
            this.label = 1;
            Object objCall = handler.call(operationRequest, this);
            return objCall == coroutine_suspended ? coroutine_suspended : objCall;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.manageEngine) {
            CloseableKt.closeIfCloseable(this.engine);
        }
    }

    /* JADX INFO: compiled from: ImdsClient.kt */
    @Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006/"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/imds/ImdsClient$Builder;", "", "<init>", "()V", "maxRetries", "", "getMaxRetries", "()I", "setMaxRetries", "(I)V", "endpointConfiguration", "Laws/sdk/kotlin/runtime/config/imds/EndpointConfiguration;", "getEndpointConfiguration", "()Laws/sdk/kotlin/runtime/config/imds/EndpointConfiguration;", "setEndpointConfiguration", "(Laws/sdk/kotlin/runtime/config/imds/EndpointConfiguration;)V", "tokenTtl", "Lkotlin/time/Duration;", "getTokenTtl-UwyO8pc", "()J", "setTokenTtl-LRDsOJo", "(J)V", "J", "logMode", "Laws/smithy/kotlin/runtime/client/LogMode;", "getLogMode", "()Laws/smithy/kotlin/runtime/client/LogMode;", "setLogMode", "(Laws/smithy/kotlin/runtime/client/LogMode;)V", "engine", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "getEngine", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "setEngine", "(Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;)V", "clock", "Laws/smithy/kotlin/runtime/time/Clock;", "getClock$aws_config", "()Laws/smithy/kotlin/runtime/time/Clock;", "setClock$aws_config", "(Laws/smithy/kotlin/runtime/time/Clock;)V", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "getPlatformProvider$aws_config", "()Laws/smithy/kotlin/runtime/util/PlatformProvider;", "setPlatformProvider$aws_config", "(Laws/smithy/kotlin/runtime/util/PlatformProvider;)V", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Clock clock;
        private HttpClientEngine engine;
        private LogMode logMode;
        private PlatformProvider platformProvider;
        private long tokenTtl;
        private int maxRetries = 3;
        private EndpointConfiguration endpointConfiguration = EndpointConfiguration.Default.INSTANCE;

        public Builder() {
            Duration.Companion companion = Duration.INSTANCE;
            this.tokenTtl = DurationKt.toDuration(ImdsClientKt.DEFAULT_TOKEN_TTL_SECONDS, DurationUnit.SECONDS);
            this.logMode = LogMode.Default.INSTANCE;
            this.clock = Clock.System.INSTANCE;
            this.platformProvider = PlatformProvider.INSTANCE.getSystem();
        }

        public final int getMaxRetries() {
            return this.maxRetries;
        }

        public final void setMaxRetries(int i) {
            this.maxRetries = i;
        }

        public final EndpointConfiguration getEndpointConfiguration() {
            return this.endpointConfiguration;
        }

        public final void setEndpointConfiguration(EndpointConfiguration endpointConfiguration) {
            Intrinsics.checkNotNullParameter(endpointConfiguration, "<set-?>");
            this.endpointConfiguration = endpointConfiguration;
        }

        /* JADX INFO: renamed from: getTokenTtl-UwyO8pc, reason: not valid java name and from getter */
        public final long getTokenTtl() {
            return this.tokenTtl;
        }

        /* JADX INFO: renamed from: setTokenTtl-LRDsOJo, reason: not valid java name */
        public final void m12056setTokenTtlLRDsOJo(long j) {
            this.tokenTtl = j;
        }

        public final LogMode getLogMode() {
            return this.logMode;
        }

        public final void setLogMode(LogMode logMode) {
            Intrinsics.checkNotNullParameter(logMode, "<set-?>");
            this.logMode = logMode;
        }

        public final HttpClientEngine getEngine() {
            return this.engine;
        }

        public final void setEngine(HttpClientEngine httpClientEngine) {
            this.engine = httpClientEngine;
        }

        /* JADX INFO: renamed from: getClock$aws_config, reason: from getter */
        public final Clock getClock() {
            return this.clock;
        }

        public final void setClock$aws_config(Clock clock) {
            Intrinsics.checkNotNullParameter(clock, "<set-?>");
            this.clock = clock;
        }

        /* JADX INFO: renamed from: getPlatformProvider$aws_config, reason: from getter */
        public final PlatformProvider getPlatformProvider() {
            return this.platformProvider;
        }

        public final void setPlatformProvider$aws_config(PlatformProvider platformProvider) {
            Intrinsics.checkNotNullParameter(platformProvider, "<set-?>");
            this.platformProvider = platformProvider;
        }
    }
}
