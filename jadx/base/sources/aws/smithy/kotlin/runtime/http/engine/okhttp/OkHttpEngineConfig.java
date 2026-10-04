package aws.smithy.kotlin.runtime.http.engine.okhttp;

import androidx.webkit.Profile;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfigImpl;
import aws.smithy.kotlin.runtime.telemetry.GlobalTelemetryProviderKt;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import okhttp3.CertificatePinner;

/* JADX INFO: compiled from: OkHttpEngineConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 12\u00020\u0001:\u000212B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010,\u001a\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-¢\u0006\u0002\b0H\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010$\u001a\u0004\u0018\u00010%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u00063"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpEngineConfig;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfigImpl;", "builder", "Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpEngineConfig$Builder;", "<init>", "(Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpEngineConfig$Builder;)V", "connectionIdlePollingInterval", "Lkotlin/time/Duration;", "getConnectionIdlePollingInterval-FghU774", "()Lkotlin/time/Duration;", "maxConcurrencyPerHost", "Lkotlin/UInt;", "getMaxConcurrencyPerHost-pVg5ArA", "()I", "I", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "getTrustManager", "()Ljavax/net/ssl/X509TrustManager;", "setTrustManager", "(Ljavax/net/ssl/X509TrustManager;)V", "keyManager", "Ljavax/net/ssl/KeyManager;", "getKeyManager", "()Ljavax/net/ssl/KeyManager;", "setKeyManager", "(Ljavax/net/ssl/KeyManager;)V", "cipherSuites", "", "", "getCipherSuites", "()Ljava/util/List;", "certificatePinner", "Lokhttp3/CertificatePinner;", "getCertificatePinner", "()Lokhttp3/CertificatePinner;", "hostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "getHostnameVerifier", "()Ljavax/net/ssl/HostnameVerifier;", "retryOnConnectionFailure", "", "getRetryOnConnectionFailure", "()Z", "toBuilderApplicator", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig$Builder;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "http-client-engine-okhttp"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OkHttpEngineConfig extends HttpClientEngineConfigImpl {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final OkHttpEngineConfig Default = new OkHttpEngineConfig(new Builder());
    private final CertificatePinner certificatePinner;
    private final List<String> cipherSuites;
    private final Duration connectionIdlePollingInterval;
    private final HostnameVerifier hostnameVerifier;
    private KeyManager keyManager;
    private final int maxConcurrencyPerHost;
    private final boolean retryOnConnectionFailure;
    private X509TrustManager trustManager;

    public /* synthetic */ OkHttpEngineConfig(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    /* JADX INFO: compiled from: OkHttpEngineConfig.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpEngineConfig$Companion;", "", "<init>", "()V", "invoke", "Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpEngineConfig;", "block", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpEngineConfig$Builder;", "", "Lkotlin/ExtensionFunctionType;", Profile.DEFAULT_PROFILE_NAME, "getDefault", "()Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpEngineConfig;", "http-client-engine-okhttp"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OkHttpEngineConfig invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return new OkHttpEngineConfig(builder, null);
        }

        public final OkHttpEngineConfig getDefault() {
            return OkHttpEngineConfig.Default;
        }
    }

    private OkHttpEngineConfig(Builder builder) {
        super(builder);
        this.connectionIdlePollingInterval = builder.getConnectionIdlePollingInterval();
        UInt maxConcurrencyPerHost = builder.getMaxConcurrencyPerHost();
        this.maxConcurrencyPerHost = maxConcurrencyPerHost != null ? maxConcurrencyPerHost.getData() : builder.getMaxConcurrency();
        this.trustManager = builder.getTrustManager();
        this.keyManager = builder.getKeyManager();
        this.cipherSuites = builder.getCipherSuites();
        this.certificatePinner = builder.getCertificatePinner();
        this.hostnameVerifier = builder.getHostnameVerifier();
        this.retryOnConnectionFailure = builder.getRetryOnConnectionFailure();
    }

    /* JADX INFO: renamed from: getConnectionIdlePollingInterval-FghU774, reason: not valid java name and from getter */
    public final Duration getConnectionIdlePollingInterval() {
        return this.connectionIdlePollingInterval;
    }

    /* JADX INFO: renamed from: getMaxConcurrencyPerHost-pVg5ArA, reason: not valid java name and from getter */
    public final int getMaxConcurrencyPerHost() {
        return this.maxConcurrencyPerHost;
    }

    public final X509TrustManager getTrustManager() {
        return this.trustManager;
    }

    public final void setTrustManager(X509TrustManager x509TrustManager) {
        this.trustManager = x509TrustManager;
    }

    public final KeyManager getKeyManager() {
        return this.keyManager;
    }

    public final void setKeyManager(KeyManager keyManager) {
        this.keyManager = keyManager;
    }

    public final List<String> getCipherSuites() {
        return this.cipherSuites;
    }

    public final CertificatePinner getCertificatePinner() {
        return this.certificatePinner;
    }

    public final HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final boolean getRetryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfigImpl, aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig
    public Function1<HttpClientEngineConfig.Builder, Unit> toBuilderApplicator() {
        return new Function1() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpEngineConfig$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OkHttpEngineConfig.toBuilderApplicator$lambda$0(this.f$0, (HttpClientEngineConfig.Builder) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toBuilderApplicator$lambda$0(OkHttpEngineConfig okHttpEngineConfig, HttpClientEngineConfig.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        super.toBuilderApplicator().invoke(builder);
        if (builder instanceof Builder) {
            Builder builder2 = (Builder) builder;
            builder2.m12201setConnectionIdlePollingIntervalBwNAW2A(okHttpEngineConfig.connectionIdlePollingInterval);
            builder2.m12202setMaxConcurrencyPerHostExVfyTY(UInt.m14588boximpl(okHttpEngineConfig.maxConcurrencyPerHost));
            builder2.setTrustManager(okHttpEngineConfig.trustManager);
            builder2.setKeyManager(okHttpEngineConfig.keyManager);
            builder2.setCipherSuites(okHttpEngineConfig.cipherSuites);
            builder2.setCertificatePinner(okHttpEngineConfig.certificatePinner);
            builder2.setHostnameVerifier(okHttpEngineConfig.hostnameVerifier);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: OkHttpEngineConfig.kt */
    @Metadata(m1598d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u00105\u001a\u000206X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u00069"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpEngineConfig$Builder;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfigImpl$BuilderImpl;", "<init>", "()V", "connectionIdlePollingInterval", "Lkotlin/time/Duration;", "getConnectionIdlePollingInterval-FghU774", "()Lkotlin/time/Duration;", "setConnectionIdlePollingInterval-BwNAW2A", "(Lkotlin/time/Duration;)V", "maxConcurrencyPerHost", "Lkotlin/UInt;", "getMaxConcurrencyPerHost-0hXNFcg", "()Lkotlin/UInt;", "setMaxConcurrencyPerHost-ExVfyTY", "(Lkotlin/UInt;)V", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "getTrustManager", "()Ljavax/net/ssl/X509TrustManager;", "setTrustManager", "(Ljavax/net/ssl/X509TrustManager;)V", "keyManager", "Ljavax/net/ssl/KeyManager;", "getKeyManager", "()Ljavax/net/ssl/KeyManager;", "setKeyManager", "(Ljavax/net/ssl/KeyManager;)V", "cipherSuites", "", "", "getCipherSuites", "()Ljava/util/List;", "setCipherSuites", "(Ljava/util/List;)V", "certificatePinner", "Lokhttp3/CertificatePinner;", "getCertificatePinner", "()Lokhttp3/CertificatePinner;", "setCertificatePinner", "(Lokhttp3/CertificatePinner;)V", "hostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "getHostnameVerifier", "()Ljavax/net/ssl/HostnameVerifier;", "setHostnameVerifier", "(Ljavax/net/ssl/HostnameVerifier;)V", "telemetryProvider", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "getTelemetryProvider", "()Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "setTelemetryProvider", "(Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;)V", "retryOnConnectionFailure", "", "getRetryOnConnectionFailure", "()Z", "http-client-engine-okhttp"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder extends HttpClientEngineConfigImpl.BuilderImpl {
        private CertificatePinner certificatePinner;
        private List<String> cipherSuites;
        private Duration connectionIdlePollingInterval;
        private HostnameVerifier hostnameVerifier;
        private KeyManager keyManager;
        private UInt maxConcurrencyPerHost;
        private X509TrustManager trustManager;
        private TelemetryProvider telemetryProvider = GlobalTelemetryProviderKt.getGlobal(TelemetryProvider.INSTANCE);
        private final boolean retryOnConnectionFailure = true;

        /* JADX INFO: renamed from: getConnectionIdlePollingInterval-FghU774, reason: not valid java name and from getter */
        public final Duration getConnectionIdlePollingInterval() {
            return this.connectionIdlePollingInterval;
        }

        /* JADX INFO: renamed from: setConnectionIdlePollingInterval-BwNAW2A, reason: not valid java name */
        public final void m12201setConnectionIdlePollingIntervalBwNAW2A(Duration duration) {
            this.connectionIdlePollingInterval = duration;
        }

        /* JADX INFO: renamed from: getMaxConcurrencyPerHost-0hXNFcg, reason: not valid java name and from getter */
        public final UInt getMaxConcurrencyPerHost() {
            return this.maxConcurrencyPerHost;
        }

        /* JADX INFO: renamed from: setMaxConcurrencyPerHost-ExVfyTY, reason: not valid java name */
        public final void m12202setMaxConcurrencyPerHostExVfyTY(UInt uInt) {
            this.maxConcurrencyPerHost = uInt;
        }

        public final X509TrustManager getTrustManager() {
            return this.trustManager;
        }

        public final void setTrustManager(X509TrustManager x509TrustManager) {
            this.trustManager = x509TrustManager;
        }

        public final KeyManager getKeyManager() {
            return this.keyManager;
        }

        public final void setKeyManager(KeyManager keyManager) {
            this.keyManager = keyManager;
        }

        public final List<String> getCipherSuites() {
            return this.cipherSuites;
        }

        public final void setCipherSuites(List<String> list) {
            this.cipherSuites = list;
        }

        public final CertificatePinner getCertificatePinner() {
            return this.certificatePinner;
        }

        public final void setCertificatePinner(CertificatePinner certificatePinner) {
            this.certificatePinner = certificatePinner;
        }

        public final HostnameVerifier getHostnameVerifier() {
            return this.hostnameVerifier;
        }

        public final void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.hostnameVerifier = hostnameVerifier;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfigImpl.BuilderImpl, aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        public TelemetryProvider getTelemetryProvider() {
            return this.telemetryProvider;
        }

        @Override // aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfigImpl.BuilderImpl, aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig.Builder
        public void setTelemetryProvider(TelemetryProvider telemetryProvider) {
            Intrinsics.checkNotNullParameter(telemetryProvider, "<set-?>");
            this.telemetryProvider = telemetryProvider;
        }

        public final boolean getRetryOnConnectionFailure() {
            return this.retryOnConnectionFailure;
        }
    }
}
