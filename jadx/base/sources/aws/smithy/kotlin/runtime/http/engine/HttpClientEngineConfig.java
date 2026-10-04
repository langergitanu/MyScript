package aws.smithy.kotlin.runtime.http.engine;

import androidx.webkit.Profile;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.config.HttpEngineConfigDsl;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfigImpl;
import aws.smithy.kotlin.runtime.http.engine.TlsContext;
import aws.smithy.kotlin.runtime.net.HostResolver;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpClientEngineConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 *2\u00020\u0001:\u0002*+J \u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u0011\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0013\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0014\u0010\u0017\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010!\u001a\u00020\u001c8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010%\u001a\u00020\"8&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006,À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig;", "", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig$Builder;", "", "Lkotlin/ExtensionFunctionType;", "toBuilderApplicator", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/time/Duration;", "getSocketReadTimeout-UwyO8pc", "()J", "socketReadTimeout", "getSocketWriteTimeout-UwyO8pc", "socketWriteTimeout", "getConnectTimeout-UwyO8pc", "connectTimeout", "getConnectionAcquireTimeout-UwyO8pc", "connectionAcquireTimeout", "getConnectionIdleTimeout-UwyO8pc", "connectionIdleTimeout", "Lkotlin/UInt;", "getMaxConcurrency-pVg5ArA", "()I", "maxConcurrency", "Laws/smithy/kotlin/runtime/http/engine/ProxySelector;", "getProxySelector", "()Laws/smithy/kotlin/runtime/http/engine/ProxySelector;", "proxySelector", "Laws/smithy/kotlin/runtime/net/HostResolver;", "getHostResolver", "()Laws/smithy/kotlin/runtime/net/HostResolver;", "getHostResolver$annotations", "()V", "hostResolver", "Laws/smithy/kotlin/runtime/http/engine/TlsContext;", "getTlsContext", "()Laws/smithy/kotlin/runtime/http/engine/TlsContext;", "tlsContext", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "getTelemetryProvider", "()Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "telemetryProvider", "Companion", "Builder", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface HttpClientEngineConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: HttpClientEngineConfig.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @InternalApi
        public static /* synthetic */ void getHostResolver$annotations() {
        }
    }

    /* JADX INFO: renamed from: getConnectTimeout-UwyO8pc, reason: not valid java name */
    long getConnectTimeout();

    /* JADX INFO: renamed from: getConnectionAcquireTimeout-UwyO8pc, reason: not valid java name */
    long getConnectionAcquireTimeout();

    /* JADX INFO: renamed from: getConnectionIdleTimeout-UwyO8pc, reason: not valid java name */
    long getConnectionIdleTimeout();

    HostResolver getHostResolver();

    /* JADX INFO: renamed from: getMaxConcurrency-pVg5ArA, reason: not valid java name */
    int getMaxConcurrency();

    ProxySelector getProxySelector();

    /* JADX INFO: renamed from: getSocketReadTimeout-UwyO8pc, reason: not valid java name */
    long getSocketReadTimeout();

    /* JADX INFO: renamed from: getSocketWriteTimeout-UwyO8pc, reason: not valid java name */
    long getSocketWriteTimeout();

    TelemetryProvider getTelemetryProvider();

    TlsContext getTlsContext();

    @InternalApi
    Function1<Builder, Unit> toBuilderApplicator();

    /* JADX INFO: compiled from: HttpClientEngineConfig.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig$Companion;", "", "<init>", "()V", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig$Builder;", "", "Lkotlin/ExtensionFunctionType;", "block", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig;", "invoke", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig;", Profile.DEFAULT_PROFILE_NAME, "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig;", "getDefault", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final HttpClientEngineConfig Default = new HttpClientEngineConfigImpl(Builder.INSTANCE.invoke());

        private Companion() {
        }

        public final HttpClientEngineConfig invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builderInvoke = Builder.INSTANCE.invoke();
            block.invoke(builderInvoke);
            return new HttpClientEngineConfigImpl(builderInvoke);
        }

        public final HttpClientEngineConfig getDefault() {
            return Default;
        }
    }

    /* JADX INFO: compiled from: HttpClientEngineConfig.kt */
    @HttpEngineConfigDsl
    @Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 :2\u00020\u0001:\u0001:J(\u0010\u0007\u001a\u00020\u00042\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H&¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0011\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001c\u0010\u0014\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0017\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001c\u0010\u001a\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u001c\u0010 \u001a\u00020\u001b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010&\u001a\u00020!8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010.\u001a\u00020'8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b,\u0010-\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u0007\u001a\u00020/8&@&X¦\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00109\u001a\u0002048&@&X¦\u000e¢\u0006\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006;À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig$Builder;", "", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/http/engine/TlsContext$Builder;", "", "Lkotlin/ExtensionFunctionType;", "block", "tlsContext", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/time/Duration;", "getSocketReadTimeout-UwyO8pc", "()J", "setSocketReadTimeout-LRDsOJo", "(J)V", "socketReadTimeout", "getSocketWriteTimeout-UwyO8pc", "setSocketWriteTimeout-LRDsOJo", "socketWriteTimeout", "getConnectTimeout-UwyO8pc", "setConnectTimeout-LRDsOJo", "connectTimeout", "getConnectionAcquireTimeout-UwyO8pc", "setConnectionAcquireTimeout-LRDsOJo", "connectionAcquireTimeout", "getConnectionIdleTimeout-UwyO8pc", "setConnectionIdleTimeout-LRDsOJo", "connectionIdleTimeout", "Lkotlin/UInt;", "getMaxConcurrency-pVg5ArA", "()I", "setMaxConcurrency-WZ4Q5Ns", "(I)V", "maxConcurrency", "Laws/smithy/kotlin/runtime/http/engine/ProxySelector;", "getProxySelector", "()Laws/smithy/kotlin/runtime/http/engine/ProxySelector;", "setProxySelector", "(Laws/smithy/kotlin/runtime/http/engine/ProxySelector;)V", "proxySelector", "Laws/smithy/kotlin/runtime/net/HostResolver;", "getHostResolver", "()Laws/smithy/kotlin/runtime/net/HostResolver;", "setHostResolver", "(Laws/smithy/kotlin/runtime/net/HostResolver;)V", "getHostResolver$annotations", "()V", "hostResolver", "Laws/smithy/kotlin/runtime/http/engine/TlsContext;", "getTlsContext", "()Laws/smithy/kotlin/runtime/http/engine/TlsContext;", "setTlsContext", "(Laws/smithy/kotlin/runtime/http/engine/TlsContext;)V", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "getTelemetryProvider", "()Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "setTelemetryProvider", "(Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;)V", "telemetryProvider", "Companion", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Builder {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: HttpClientEngineConfig.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class DefaultImpls {
            @InternalApi
            public static /* synthetic */ void getHostResolver$annotations() {
            }
        }

        /* JADX INFO: renamed from: getConnectTimeout-UwyO8pc, reason: not valid java name */
        long getConnectTimeout();

        /* JADX INFO: renamed from: getConnectionAcquireTimeout-UwyO8pc, reason: not valid java name */
        long getConnectionAcquireTimeout();

        /* JADX INFO: renamed from: getConnectionIdleTimeout-UwyO8pc, reason: not valid java name */
        long getConnectionIdleTimeout();

        HostResolver getHostResolver();

        /* JADX INFO: renamed from: getMaxConcurrency-pVg5ArA, reason: not valid java name */
        int getMaxConcurrency();

        ProxySelector getProxySelector();

        /* JADX INFO: renamed from: getSocketReadTimeout-UwyO8pc, reason: not valid java name */
        long getSocketReadTimeout();

        /* JADX INFO: renamed from: getSocketWriteTimeout-UwyO8pc, reason: not valid java name */
        long getSocketWriteTimeout();

        TelemetryProvider getTelemetryProvider();

        TlsContext getTlsContext();

        /* JADX INFO: renamed from: setConnectTimeout-LRDsOJo, reason: not valid java name */
        void mo12181setConnectTimeoutLRDsOJo(long j);

        /* JADX INFO: renamed from: setConnectionAcquireTimeout-LRDsOJo, reason: not valid java name */
        void mo12182setConnectionAcquireTimeoutLRDsOJo(long j);

        /* JADX INFO: renamed from: setConnectionIdleTimeout-LRDsOJo, reason: not valid java name */
        void mo12183setConnectionIdleTimeoutLRDsOJo(long j);

        void setHostResolver(HostResolver hostResolver);

        /* JADX INFO: renamed from: setMaxConcurrency-WZ4Q5Ns, reason: not valid java name */
        void mo12184setMaxConcurrencyWZ4Q5Ns(int i);

        void setProxySelector(ProxySelector proxySelector);

        /* JADX INFO: renamed from: setSocketReadTimeout-LRDsOJo, reason: not valid java name */
        void mo12185setSocketReadTimeoutLRDsOJo(long j);

        /* JADX INFO: renamed from: setSocketWriteTimeout-LRDsOJo, reason: not valid java name */
        void mo12186setSocketWriteTimeoutLRDsOJo(long j);

        void setTelemetryProvider(TelemetryProvider telemetryProvider);

        void setTlsContext(TlsContext tlsContext);

        void tlsContext(Function1<? super TlsContext.Builder, Unit> block);

        /* JADX INFO: compiled from: HttpClientEngineConfig.kt */
        @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig$Builder$Companion;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig$Builder;", "invoke", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig$Builder;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final Builder invoke() {
                return new HttpClientEngineConfigImpl.BuilderImpl();
            }
        }
    }
}
