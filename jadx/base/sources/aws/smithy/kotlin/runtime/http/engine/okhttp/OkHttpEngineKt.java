package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.engine.AlpnId;
import aws.smithy.kotlin.runtime.http.engine.TlsContext;
import aws.smithy.kotlin.runtime.http.engine.internal.HttpClientMetrics;
import aws.smithy.kotlin.runtime.net.TlsVersion;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/* JADX INFO: compiled from: OkHttpEngine.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u001c\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0002\u001a \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0002\u001a\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002¨\u0006\u001c"}, m1599d2 = {"buildClient", "Lokhttp3/OkHttpClient;", "Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpEngineConfig;", "metrics", "Laws/smithy/kotlin/runtime/http/engine/internal/HttpClientMetrics;", "clientScopedEventListeners", "", "Lokhttp3/EventListener;", "(Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpEngineConfig;Laws/smithy/kotlin/runtime/http/engine/internal/HttpClientMetrics;[Lokhttp3/EventListener;)Lokhttp3/OkHttpClient;", "withMetrics", "config", "tlsConnectionSpec", "Lokhttp3/ConnectionSpec;", "tlsContext", "Laws/smithy/kotlin/runtime/http/engine/TlsContext;", "cipherSuites", "", "", "toOkHttpTlsVersion", "Lokhttp3/TlsVersion;", "sdkTlsVersion", "Laws/smithy/kotlin/runtime/net/TlsVersion;", "createSslContext", "Ljavax/net/ssl/SSLContext;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "keyManager", "Ljavax/net/ssl/KeyManager;", "http-client-engine-okhttp"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OkHttpEngineKt {

    /* JADX INFO: compiled from: OkHttpEngine.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[AlpnId.values().length];
            try {
                iArr[AlpnId.HTTP1_1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AlpnId.HTTP2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AlpnId.H2_PRIOR_KNOWLEDGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TlsVersion.values().length];
            try {
                iArr2[TlsVersion.TLS_1_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[TlsVersion.TLS_1_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[TlsVersion.TLS_1_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[TlsVersion.TLS_1_3.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @InternalApi
    public static final OkHttpClient buildClient(final OkHttpEngineConfig okHttpEngineConfig, final HttpClientMetrics metrics, final EventListener... clientScopedEventListeners) {
        Protocol protocol;
        Intrinsics.checkNotNullParameter(okHttpEngineConfig, "<this>");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(clientScopedEventListeners, "clientScopedEventListeners");
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.followRedirects(false);
        builder.followSslRedirects(false);
        builder.connectionSpecs(CollectionsKt.listOf((Object[]) new ConnectionSpec[]{tlsConnectionSpec(okHttpEngineConfig.getTlsContext(), okHttpEngineConfig.getCipherSuites()), ConnectionSpec.CLEARTEXT}));
        X509TrustManager trustManager = okHttpEngineConfig.getTrustManager();
        if (trustManager != null) {
            SSLSocketFactory socketFactory = createSslContext(trustManager, okHttpEngineConfig.getKeyManager()).getSocketFactory();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "getSocketFactory(...)");
            X509TrustManager trustManager2 = okHttpEngineConfig.getTrustManager();
            Intrinsics.checkNotNull(trustManager2);
            builder.sslSocketFactory(socketFactory, trustManager2);
        }
        CertificatePinner certificatePinner = okHttpEngineConfig.getCertificatePinner();
        if (certificatePinner != null) {
            builder.certificatePinner(certificatePinner);
        }
        HostnameVerifier hostnameVerifier = okHttpEngineConfig.getHostnameVerifier();
        if (hostnameVerifier != null) {
            builder.hostnameVerifier(hostnameVerifier);
        }
        builder.retryOnConnectionFailure(okHttpEngineConfig.getRetryOnConnectionFailure());
        Duration durationOfSeconds = Duration.ofSeconds(kotlin.time.Duration.m15870getInWholeSecondsimpl(okHttpEngineConfig.getConnectTimeout()), kotlin.time.Duration.m15872getNanosecondsComponentimpl(r5));
        Intrinsics.checkNotNullExpressionValue(durationOfSeconds, "toComponents-impl(...)");
        builder.connectTimeout(durationOfSeconds);
        Duration durationOfSeconds2 = Duration.ofSeconds(kotlin.time.Duration.m15870getInWholeSecondsimpl(okHttpEngineConfig.getSocketReadTimeout()), kotlin.time.Duration.m15872getNanosecondsComponentimpl(r5));
        Intrinsics.checkNotNullExpressionValue(durationOfSeconds2, "toComponents-impl(...)");
        builder.readTimeout(durationOfSeconds2);
        Duration durationOfSeconds3 = Duration.ofSeconds(kotlin.time.Duration.m15870getInWholeSecondsimpl(okHttpEngineConfig.getSocketWriteTimeout()), kotlin.time.Duration.m15872getNanosecondsComponentimpl(r5));
        Intrinsics.checkNotNullExpressionValue(durationOfSeconds3, "toComponents-impl(...)");
        builder.writeTimeout(durationOfSeconds3);
        final ConnectionPool connectionPool = new ConnectionPool(5, kotlin.time.Duration.m15867getInWholeMillisecondsimpl(okHttpEngineConfig.getConnectionIdleTimeout()), TimeUnit.MILLISECONDS);
        builder.connectionPool(connectionPool);
        final Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(okHttpEngineConfig.getMaxConcurrency());
        dispatcher.setMaxRequestsPerHost(okHttpEngineConfig.getMaxConcurrencyPerHost());
        builder.dispatcher(dispatcher);
        builder.eventListenerFactory(new EventListener.Factory() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpEngineKt$$ExternalSyntheticLambda0
            @Override // okhttp3.EventListener.Factory
            public final EventListener create(Call call) {
                return OkHttpEngineKt.buildClient$lambda$0$3(connectionPool, okHttpEngineConfig, dispatcher, metrics, clientScopedEventListeners, call);
            }
        });
        if (!okHttpEngineConfig.getTlsContext().getAlpn().isEmpty()) {
            List<AlpnId> alpn = okHttpEngineConfig.getTlsContext().getAlpn();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = alpn.iterator();
            while (it.hasNext()) {
                int i = WhenMappings.$EnumSwitchMapping$0[((AlpnId) it.next()).ordinal()];
                if (i == 1) {
                    protocol = Protocol.HTTP_1_1;
                } else if (i == 2) {
                    protocol = Protocol.HTTP_2;
                } else {
                    protocol = i != 3 ? null : Protocol.H2_PRIOR_KNOWLEDGE;
                }
                if (protocol != null) {
                    arrayList.add(protocol);
                }
            }
            builder.protocols(arrayList);
        }
        builder.proxySelector(new OkHttpProxySelector(okHttpEngineConfig.getProxySelector()));
        builder.proxyAuthenticator(new OkHttpProxyAuthenticator(okHttpEngineConfig.getProxySelector()));
        builder.dns(new OkHttpDns(okHttpEngineConfig.getHostResolver()));
        builder.addInterceptor(MetricsInterceptor.INSTANCE);
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventListener buildClient$lambda$0$3(ConnectionPool connectionPool, OkHttpEngineConfig okHttpEngineConfig, Dispatcher dispatcher, HttpClientMetrics httpClientMetrics, EventListener[] eventListenerArr, Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(new HttpEngineEventListener(connectionPool, okHttpEngineConfig.getHostResolver(), dispatcher, httpClientMetrics, call));
        spreadBuilder.addSpread(eventListenerArr);
        return new EventListenerChain(CollectionsKt.listOfNotNull(spreadBuilder.toArray(new EventListener[spreadBuilder.size()])));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpClient withMetrics(final OkHttpClient okHttpClient, final HttpClientMetrics httpClientMetrics, final OkHttpEngineConfig okHttpEngineConfig) {
        OkHttpClient.Builder builderNewBuilder = okHttpClient.newBuilder();
        builderNewBuilder.eventListenerFactory(new EventListener.Factory() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpEngineKt$$ExternalSyntheticLambda1
            @Override // okhttp3.EventListener.Factory
            public final EventListener create(Call call) {
                return OkHttpEngineKt.withMetrics$lambda$0$0(okHttpClient, okHttpEngineConfig, httpClientMetrics, call);
            }
        });
        builderNewBuilder.addInterceptor(MetricsInterceptor.INSTANCE);
        return builderNewBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventListener withMetrics$lambda$0$0(OkHttpClient okHttpClient, OkHttpEngineConfig okHttpEngineConfig, HttpClientMetrics httpClientMetrics, Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        return new EventListenerChain(CollectionsKt.listOf(new HttpEngineEventListener(okHttpClient.connectionPool(), okHttpEngineConfig.getHostResolver(), okHttpClient.dispatcher(), httpClientMetrics, call)));
    }

    private static final ConnectionSpec tlsConnectionSpec(TlsContext tlsContext, List<String> list) {
        String[] strArr;
        TlsVersion minVersion = tlsContext.getMinVersion();
        if (minVersion == null) {
            minVersion = TlsVersion.TLS_1_2;
        }
        TlsVersion[] tlsVersionArrValues = TlsVersion.values();
        ArrayList arrayList = new ArrayList();
        for (TlsVersion tlsVersion : tlsVersionArrValues) {
            if (tlsVersion.compareTo(minVersion) >= 0) {
                arrayList.add(tlsVersion);
            }
        }
        List listSortedDescending = CollectionsKt.sortedDescending(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedDescending, 10));
        Iterator it = listSortedDescending.iterator();
        while (it.hasNext()) {
            arrayList2.add(toOkHttpTlsVersion((TlsVersion) it.next()));
        }
        okhttp3.TlsVersion[] tlsVersionArr = (okhttp3.TlsVersion[]) arrayList2.toArray(new okhttp3.TlsVersion[0]);
        ConnectionSpec.Builder builderTlsVersions = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions((okhttp3.TlsVersion[]) Arrays.copyOf(tlsVersionArr, tlsVersionArr.length));
        if (list != null && (strArr = (String[]) list.toArray(new String[0])) != null) {
            builderTlsVersions.cipherSuites(strArr);
        }
        return builderTlsVersions.build();
    }

    private static final okhttp3.TlsVersion toOkHttpTlsVersion(TlsVersion tlsVersion) {
        int i = WhenMappings.$EnumSwitchMapping$1[tlsVersion.ordinal()];
        if (i == 1) {
            return okhttp3.TlsVersion.TLS_1_0;
        }
        if (i == 2) {
            return okhttp3.TlsVersion.TLS_1_1;
        }
        if (i == 3) {
            return okhttp3.TlsVersion.TLS_1_2;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return okhttp3.TlsVersion.TLS_1_3;
    }

    private static final SSLContext createSslContext(X509TrustManager x509TrustManager, KeyManager keyManager) throws NoSuchAlgorithmException, KeyManagementException {
        KeyManager[] keyManagerArr = keyManager != null ? new KeyManager[]{keyManager} : null;
        X509TrustManager[] x509TrustManagerArr = {x509TrustManager};
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(keyManagerArr, x509TrustManagerArr, null);
        Intrinsics.checkNotNull(sSLContext);
        return sSLContext;
    }
}
