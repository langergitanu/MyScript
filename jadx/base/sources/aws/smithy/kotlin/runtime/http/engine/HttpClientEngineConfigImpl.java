package aws.smithy.kotlin.runtime.http.engine;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig;
import aws.smithy.kotlin.runtime.http.engine.TlsContext;
import aws.smithy.kotlin.runtime.net.HostResolver;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: HttpClientEngineConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0017¢\u0006\u0004\b\u0004\u0010\u0006J \u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\u00198\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020\u001e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010)\u001a\u00020(8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001a\u0010.\u001a\u00020-8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00063"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfigImpl;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig$Builder;", "builder", "<init>", "(Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig$Builder;)V", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "toBuilderApplicator", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/time/Duration;", "socketReadTimeout", "J", "getSocketReadTimeout-UwyO8pc", "()J", "socketWriteTimeout", "getSocketWriteTimeout-UwyO8pc", "connectTimeout", "getConnectTimeout-UwyO8pc", "connectionAcquireTimeout", "getConnectionAcquireTimeout-UwyO8pc", "connectionIdleTimeout", "getConnectionIdleTimeout-UwyO8pc", "Lkotlin/UInt;", "maxConcurrency", "I", "getMaxConcurrency-pVg5ArA", "()I", "Laws/smithy/kotlin/runtime/http/engine/ProxySelector;", "proxySelector", "Laws/smithy/kotlin/runtime/http/engine/ProxySelector;", "getProxySelector", "()Laws/smithy/kotlin/runtime/http/engine/ProxySelector;", "Laws/smithy/kotlin/runtime/net/HostResolver;", "hostResolver", "Laws/smithy/kotlin/runtime/net/HostResolver;", "getHostResolver", "()Laws/smithy/kotlin/runtime/net/HostResolver;", "Laws/smithy/kotlin/runtime/http/engine/TlsContext;", "tlsContext", "Laws/smithy/kotlin/runtime/http/engine/TlsContext;", "getTlsContext", "()Laws/smithy/kotlin/runtime/http/engine/TlsContext;", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "telemetryProvider", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "getTelemetryProvider", "()Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "BuilderImpl", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class HttpClientEngineConfigImpl implements HttpClientEngineConfig {
    private final long connectTimeout;
    private final long connectionAcquireTimeout;
    private final long connectionIdleTimeout;
    private final HostResolver hostResolver;
    private final int maxConcurrency;
    private final ProxySelector proxySelector;
    private final long socketReadTimeout;
    private final long socketWriteTimeout;
    private final TelemetryProvider telemetryProvider;
    private final TlsContext tlsContext;

    public HttpClientEngineConfigImpl(HttpClientEngineConfig.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.socketReadTimeout = builder.getSocketReadTimeout();
        this.socketWriteTimeout = builder.getSocketWriteTimeout();
        this.connectTimeout = builder.getConnectTimeout();
        this.connectionAcquireTimeout = builder.getConnectionAcquireTimeout();
        this.connectionIdleTimeout = builder.getConnectionIdleTimeout();
        this.maxConcurrency = builder.getMaxConcurrency();
        this.proxySelector = builder.getProxySelector();
        this.hostResolver = builder.getHostResolver();
        this.tlsContext = builder.getTlsContext();
        this.telemetryProvider = builder.getTelemetryProvider();
    }

    @InternalApi
    public HttpClientEngineConfigImpl() {
        this(new BuilderImpl());
    }

    @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig
    /* JADX INFO: renamed from: getSocketReadTimeout-UwyO8pc, reason: from getter */
    public long getSocketReadTimeout() {
        return this.socketReadTimeout;
    }

    @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig
    /* JADX INFO: renamed from: getSocketWriteTimeout-UwyO8pc, reason: from getter */
    public long getSocketWriteTimeout() {
        return this.socketWriteTimeout;
    }

    @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig
    /* JADX INFO: renamed from: getConnectTimeout-UwyO8pc, reason: from getter */
    public long getConnectTimeout() {
        return this.connectTimeout;
    }

    @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig
    /* JADX INFO: renamed from: getConnectionAcquireTimeout-UwyO8pc, reason: from getter */
    public long getConnectionAcquireTimeout() {
        return this.connectionAcquireTimeout;
    }

    @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig
    /* JADX INFO: renamed from: getConnectionIdleTimeout-UwyO8pc, reason: from getter */
    public long getConnectionIdleTimeout() {
        return this.connectionIdleTimeout;
    }

    @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig
    /* JADX INFO: renamed from: getMaxConcurrency-pVg5ArA, reason: from getter */
    public int getMaxConcurrency() {
        return this.maxConcurrency;
    }

    @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig
    public ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig
    public HostResolver getHostResolver() {
        return this.hostResolver;
    }

    @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig
    public TlsContext getTlsContext() {
        return this.tlsContext;
    }

    @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig
    public TelemetryProvider getTelemetryProvider() {
        return this.telemetryProvider;
    }

    @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig
    public Function1<HttpClientEngineConfig.Builder, Unit> toBuilderApplicator() {
        return new Function1() { // from class: aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfigImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HttpClientEngineConfigImpl.toBuilderApplicator$lambda$0(this.f$0, (HttpClientEngineConfig.Builder) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toBuilderApplicator$lambda$0(HttpClientEngineConfigImpl httpClientEngineConfigImpl, HttpClientEngineConfig.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.mo12185setSocketReadTimeoutLRDsOJo(httpClientEngineConfigImpl.getSocketReadTimeout());
        builder.mo12186setSocketWriteTimeoutLRDsOJo(httpClientEngineConfigImpl.getSocketWriteTimeout());
        builder.mo12181setConnectTimeoutLRDsOJo(httpClientEngineConfigImpl.getConnectTimeout());
        builder.mo12182setConnectionAcquireTimeoutLRDsOJo(httpClientEngineConfigImpl.getConnectionAcquireTimeout());
        builder.mo12183setConnectionIdleTimeoutLRDsOJo(httpClientEngineConfigImpl.getConnectionIdleTimeout());
        builder.mo12184setMaxConcurrencyWZ4Q5Ns(httpClientEngineConfigImpl.getMaxConcurrency());
        builder.setProxySelector(httpClientEngineConfigImpl.getProxySelector());
        builder.setHostResolver(httpClientEngineConfigImpl.getHostResolver());
        builder.setTlsContext(httpClientEngineConfigImpl.getTlsContext());
        builder.setTelemetryProvider(httpClientEngineConfigImpl.getTelemetryProvider());
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: HttpClientEngineConfig.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\t\u001a\u00020\u00062\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0015\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\"\u0010\u0018\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\"\u0010\u001b\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\"\u0010\u001f\u001a\u00020\u001e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010\t\u001a\u0002038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\t\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006@"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfigImpl$BuilderImpl;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig$Builder;", "<init>", "()V", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/http/engine/TlsContext$Builder;", "", "Lkotlin/ExtensionFunctionType;", "block", "tlsContext", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/time/Duration;", "socketReadTimeout", "J", "getSocketReadTimeout-UwyO8pc", "()J", "setSocketReadTimeout-LRDsOJo", "(J)V", "socketWriteTimeout", "getSocketWriteTimeout-UwyO8pc", "setSocketWriteTimeout-LRDsOJo", "connectTimeout", "getConnectTimeout-UwyO8pc", "setConnectTimeout-LRDsOJo", "connectionAcquireTimeout", "getConnectionAcquireTimeout-UwyO8pc", "setConnectionAcquireTimeout-LRDsOJo", "connectionIdleTimeout", "getConnectionIdleTimeout-UwyO8pc", "setConnectionIdleTimeout-LRDsOJo", "Lkotlin/UInt;", "maxConcurrency", "I", "getMaxConcurrency-pVg5ArA", "()I", "setMaxConcurrency-WZ4Q5Ns", "(I)V", "Laws/smithy/kotlin/runtime/http/engine/ProxySelector;", "proxySelector", "Laws/smithy/kotlin/runtime/http/engine/ProxySelector;", "getProxySelector", "()Laws/smithy/kotlin/runtime/http/engine/ProxySelector;", "setProxySelector", "(Laws/smithy/kotlin/runtime/http/engine/ProxySelector;)V", "Laws/smithy/kotlin/runtime/net/HostResolver;", "hostResolver", "Laws/smithy/kotlin/runtime/net/HostResolver;", "getHostResolver", "()Laws/smithy/kotlin/runtime/net/HostResolver;", "setHostResolver", "(Laws/smithy/kotlin/runtime/net/HostResolver;)V", "Laws/smithy/kotlin/runtime/http/engine/TlsContext;", "Laws/smithy/kotlin/runtime/http/engine/TlsContext;", "getTlsContext", "()Laws/smithy/kotlin/runtime/http/engine/TlsContext;", "setTlsContext", "(Laws/smithy/kotlin/runtime/http/engine/TlsContext;)V", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "telemetryProvider", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "getTelemetryProvider", "()Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "setTelemetryProvider", "(Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;)V", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static class BuilderImpl implements HttpClientEngineConfig.Builder {
        private long connectTimeout;
        private long connectionAcquireTimeout;
        private long connectionIdleTimeout;
        private HostResolver hostResolver;
        private int maxConcurrency;
        private ProxySelector proxySelector;
        private long socketReadTimeout;
        private long socketWriteTimeout;
        private TelemetryProvider telemetryProvider;
        private TlsContext tlsContext;

        /* JADX WARN: Multi-variable type inference failed */
        public BuilderImpl() {
            Duration.Companion companion = Duration.INSTANCE;
            this.socketReadTimeout = DurationKt.toDuration(30, DurationUnit.SECONDS);
            Duration.Companion companion2 = Duration.INSTANCE;
            this.socketWriteTimeout = DurationKt.toDuration(30, DurationUnit.SECONDS);
            Duration.Companion companion3 = Duration.INSTANCE;
            this.connectTimeout = DurationKt.toDuration(2, DurationUnit.SECONDS);
            Duration.Companion companion4 = Duration.INSTANCE;
            this.connectionAcquireTimeout = DurationKt.toDuration(10, DurationUnit.SECONDS);
            Duration.Companion companion5 = Duration.INSTANCE;
            this.connectionIdleTimeout = DurationKt.toDuration(60, DurationUnit.SECONDS);
            this.maxConcurrency = 128;
            this.proxySelector = new EnvironmentProxySelector(null, 1, 0 == true ? 1 : 0);
            this.hostResolver = HostResolver.INSTANCE.getDefault();
            this.tlsContext = TlsContext.INSTANCE.getDefault();
            this.telemetryProvider = TelemetryProvider.INSTANCE.getNone();
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        /* JADX INFO: renamed from: getSocketReadTimeout-UwyO8pc, reason: from getter */
        public long getSocketReadTimeout() {
            return this.socketReadTimeout;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        /* JADX INFO: renamed from: setSocketReadTimeout-LRDsOJo */
        public void mo12185setSocketReadTimeoutLRDsOJo(long j) {
            this.socketReadTimeout = j;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        /* JADX INFO: renamed from: getSocketWriteTimeout-UwyO8pc, reason: from getter */
        public long getSocketWriteTimeout() {
            return this.socketWriteTimeout;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        /* JADX INFO: renamed from: setSocketWriteTimeout-LRDsOJo */
        public void mo12186setSocketWriteTimeoutLRDsOJo(long j) {
            this.socketWriteTimeout = j;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        /* JADX INFO: renamed from: getConnectTimeout-UwyO8pc, reason: from getter */
        public long getConnectTimeout() {
            return this.connectTimeout;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        /* JADX INFO: renamed from: setConnectTimeout-LRDsOJo */
        public void mo12181setConnectTimeoutLRDsOJo(long j) {
            this.connectTimeout = j;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        /* JADX INFO: renamed from: getConnectionAcquireTimeout-UwyO8pc, reason: from getter */
        public long getConnectionAcquireTimeout() {
            return this.connectionAcquireTimeout;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        /* JADX INFO: renamed from: setConnectionAcquireTimeout-LRDsOJo */
        public void mo12182setConnectionAcquireTimeoutLRDsOJo(long j) {
            this.connectionAcquireTimeout = j;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        /* JADX INFO: renamed from: getConnectionIdleTimeout-UwyO8pc, reason: from getter */
        public long getConnectionIdleTimeout() {
            return this.connectionIdleTimeout;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        /* JADX INFO: renamed from: setConnectionIdleTimeout-LRDsOJo */
        public void mo12183setConnectionIdleTimeoutLRDsOJo(long j) {
            this.connectionIdleTimeout = j;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        /* JADX INFO: renamed from: getMaxConcurrency-pVg5ArA, reason: from getter */
        public int getMaxConcurrency() {
            return this.maxConcurrency;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        /* JADX INFO: renamed from: setMaxConcurrency-WZ4Q5Ns */
        public void mo12184setMaxConcurrencyWZ4Q5Ns(int i) {
            this.maxConcurrency = i;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        public ProxySelector getProxySelector() {
            return this.proxySelector;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        public void setProxySelector(ProxySelector proxySelector) {
            Intrinsics.checkNotNullParameter(proxySelector, "<set-?>");
            this.proxySelector = proxySelector;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        public HostResolver getHostResolver() {
            return this.hostResolver;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        public void setHostResolver(HostResolver hostResolver) {
            Intrinsics.checkNotNullParameter(hostResolver, "<set-?>");
            this.hostResolver = hostResolver;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        public TlsContext getTlsContext() {
            return this.tlsContext;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        public void setTlsContext(TlsContext tlsContext) {
            Intrinsics.checkNotNullParameter(tlsContext, "<set-?>");
            this.tlsContext = tlsContext;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        public TelemetryProvider getTelemetryProvider() {
            return this.telemetryProvider;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        public void setTelemetryProvider(TelemetryProvider telemetryProvider) {
            Intrinsics.checkNotNullParameter(telemetryProvider, "<set-?>");
            this.telemetryProvider = telemetryProvider;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        public void tlsContext(Function1<? super TlsContext.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            TlsContext.Builder builder$http_client = getTlsContext().toBuilder$http_client();
            block.invoke(builder$http_client);
            setTlsContext(new TlsContext(builder$http_client));
        }
    }
}
