package com.myscript.nebo.sso.api;

import androidx.media3.extractor.p007ts.PsExtractor;
import com.chuckerteam.chucker.api.ChuckerInterceptor;
import com.google.auth.http.AuthHttpConstants;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.sso.api.auth.SSOAuthApi;
import com.myscript.nebo.sso.api.auth.SSOAuthApiKt;
import com.myscript.nebo.sso.api.discovery.DiscoveryApi;
import com.myscript.nebo.sso.model.UserData;
import com.myscript.nebo.sso.util.SSOCustomHeaderKt;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import okhttp3.Authenticator;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Invocation;

/* JADX INFO: compiled from: SSOHttpClient.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u001a`\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0011H\u0007\u001a\"\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u0013"}, m1599d2 = {"buildSSOHttpClient", "Lokhttp3/OkHttpClient;", "userData", "Lcom/myscript/nebo/sso/model/UserData;", "config", "Lcom/myscript/nebo/sso/api/SSOConfiguration;", "appVersion", "", "ssoAuthApi", "Lcom/myscript/nebo/sso/api/auth/SSOAuthApi;", "discoveryApi", "Lcom/myscript/nebo/sso/api/discovery/DiscoveryApi;", "chuckerInterceptor", "Lcom/chuckerteam/chucker/api/ChuckerInterceptor;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "customHeaders", "", "buildNativeLoginHttpClient", "sso_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SSOHttpClientKt {
    public static final OkHttpClient buildSSOHttpClient(UserData userData, SSOConfiguration config, String appVersion, SSOAuthApi ssoAuthApi, DiscoveryApi discoveryApi) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(ssoAuthApi, "ssoAuthApi");
        Intrinsics.checkNotNullParameter(discoveryApi, "discoveryApi");
        return buildSSOHttpClient$default(userData, config, appVersion, ssoAuthApi, discoveryApi, null, null, null, 224, null);
    }

    public static final OkHttpClient buildSSOHttpClient(UserData userData, SSOConfiguration config, String appVersion, SSOAuthApi ssoAuthApi, DiscoveryApi discoveryApi, ChuckerInterceptor chuckerInterceptor) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(ssoAuthApi, "ssoAuthApi");
        Intrinsics.checkNotNullParameter(discoveryApi, "discoveryApi");
        return buildSSOHttpClient$default(userData, config, appVersion, ssoAuthApi, discoveryApi, chuckerInterceptor, null, null, PsExtractor.AUDIO_STREAM, null);
    }

    public static final OkHttpClient buildSSOHttpClient(UserData userData, SSOConfiguration config, String appVersion, SSOAuthApi ssoAuthApi, DiscoveryApi discoveryApi, ChuckerInterceptor chuckerInterceptor, TechnicalLogger technicalLogger) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(ssoAuthApi, "ssoAuthApi");
        Intrinsics.checkNotNullParameter(discoveryApi, "discoveryApi");
        return buildSSOHttpClient$default(userData, config, appVersion, ssoAuthApi, discoveryApi, chuckerInterceptor, technicalLogger, null, 128, null);
    }

    public static final OkHttpClient buildSSOHttpClient(UserData userData, SSOConfiguration config, String appVersion, DiscoveryApi discoveryApi) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(discoveryApi, "discoveryApi");
        return buildSSOHttpClient$default(userData, config, appVersion, null, discoveryApi, null, null, null, PDFACompliance.e_PDFA2_3_2, null);
    }

    public static /* synthetic */ OkHttpClient buildSSOHttpClient$default(UserData userData, SSOConfiguration sSOConfiguration, String str, SSOAuthApi sSOAuthApi, DiscoveryApi discoveryApi, ChuckerInterceptor chuckerInterceptor, TechnicalLogger technicalLogger, Map map, int i, Object obj) {
        Map mapComputeCustomHeaders;
        UserData userData2;
        String str2;
        DiscoveryApi discoveryApi2;
        SSOAuthApi sSOAuthApi2;
        SSOAuthApi sSOAuthApiBuildSSOAuthApi$default = (i & 8) != 0 ? SSOAuthApiKt.buildSSOAuthApi$default(userData.getAppInstanceId(), str, null, 4, null) : sSOAuthApi;
        ChuckerInterceptor chuckerInterceptor2 = (i & 32) != 0 ? null : chuckerInterceptor;
        TechnicalLogger technicalLogger2 = (i & 64) != 0 ? null : technicalLogger;
        if ((i & 128) != 0) {
            mapComputeCustomHeaders = SSOCustomHeaderKt.computeCustomHeaders(userData.getAppInstanceId(), str);
            str2 = str;
            discoveryApi2 = discoveryApi;
            sSOAuthApi2 = sSOAuthApiBuildSSOAuthApi$default;
            userData2 = userData;
        } else {
            mapComputeCustomHeaders = map;
            userData2 = userData;
            str2 = str;
            discoveryApi2 = discoveryApi;
            sSOAuthApi2 = sSOAuthApiBuildSSOAuthApi$default;
        }
        return buildSSOHttpClient(userData2, sSOConfiguration, str2, sSOAuthApi2, discoveryApi2, chuckerInterceptor2, technicalLogger2, mapComputeCustomHeaders);
    }

    public static final OkHttpClient buildSSOHttpClient(final UserData userData, final SSOConfiguration config, String appVersion, final SSOAuthApi ssoAuthApi, final DiscoveryApi discoveryApi, ChuckerInterceptor chuckerInterceptor, final TechnicalLogger technicalLogger, final Map<String, String> customHeaders) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(ssoAuthApi, "ssoAuthApi");
        Intrinsics.checkNotNullParameter(discoveryApi, "discoveryApi");
        Intrinsics.checkNotNullParameter(customHeaders, "customHeaders");
        Authenticator authenticator = new Authenticator() { // from class: com.myscript.nebo.sso.api.SSOHttpClientKt$$ExternalSyntheticLambda1
            @Override // okhttp3.Authenticator
            public final Request authenticate(Route route, Response response) {
                return SSOHttpClientKt.buildSSOHttpClient$lambda$0(userData, ssoAuthApi, discoveryApi, config, technicalLogger, route, response);
            }
        };
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
        OkHttpClient.Builder timeout = new OkHttpClient.Builder().authenticator(authenticator).addInterceptor(httpLoggingInterceptor).addInterceptor(new Interceptor() { // from class: com.myscript.nebo.sso.api.SSOHttpClientKt$$ExternalSyntheticLambda2
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                return SSOHttpClientKt.buildSSOHttpClient$lambda$2(customHeaders, userData, chain);
            }
        }).readTimeout(60L, TimeUnit.SECONDS);
        if (chuckerInterceptor != null) {
            timeout.addInterceptor(chuckerInterceptor);
        }
        return timeout.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Request buildSSOHttpClient$lambda$0(UserData userData, SSOAuthApi sSOAuthApi, DiscoveryApi discoveryApi, SSOConfiguration sSOConfiguration, TechnicalLogger technicalLogger, Route route, Response response) {
        String str;
        Intrinsics.checkNotNullParameter(response, "response");
        Request request = response.request();
        String strHeader = request.header("Authorization");
        if (strHeader == null || !StringsKt.startsWith$default(strHeader, AuthHttpConstants.BEARER, false, 2, (Object) null) || (str = (String) BuildersKt__BuildersKt.runBlocking$default(null, new C6823xc603cc9d(sSOAuthApi, discoveryApi, sSOConfiguration, userData, technicalLogger, null), 1, null)) == null) {
            return null;
        }
        userData.setAccessToken(str);
        return request.newBuilder().header("Authorization", "Bearer " + str).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response buildSSOHttpClient$lambda$2(Map map, UserData userData, Interceptor.Chain chain) {
        Method method;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Request.Builder builderNewBuilder = request.newBuilder();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (request.header(str) == null) {
                builderNewBuilder.addHeader(str, str2);
            }
        }
        Invocation invocation = (Invocation) request.tag(Invocation.class);
        boolean z = ((invocation == null || (method = invocation.method()) == null) ? null : (NoAuthorizationHeader) method.getAnnotation(NoAuthorizationHeader.class)) == null;
        boolean z2 = StringsKt.isBlank(userData.getAccessToken()) && StringsKt.isBlank(userData.getRefreshToken());
        if (request.header("Authorization") == null && z && !z2) {
            builderNewBuilder.addHeader("Authorization", "Bearer " + userData.getAccessToken());
        }
        return chain.proceed(builderNewBuilder.build());
    }

    public static /* synthetic */ OkHttpClient buildNativeLoginHttpClient$default(UserData userData, String str, ChuckerInterceptor chuckerInterceptor, int i, Object obj) {
        if ((i & 4) != 0) {
            chuckerInterceptor = null;
        }
        return buildNativeLoginHttpClient(userData, str, chuckerInterceptor);
    }

    public static final OkHttpClient buildNativeLoginHttpClient(UserData userData, String appVersion, ChuckerInterceptor chuckerInterceptor) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
        final Map<String, String> mapComputeCustomHeaders = SSOCustomHeaderKt.computeCustomHeaders(userData.getAppInstanceId(), appVersion);
        Interceptor interceptor = new Interceptor() { // from class: com.myscript.nebo.sso.api.SSOHttpClientKt$$ExternalSyntheticLambda0
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                return SSOHttpClientKt.buildNativeLoginHttpClient$lambda$1(mapComputeCustomHeaders, chain);
            }
        };
        OkHttpClient.Builder builderFollowRedirects = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).addInterceptor(interceptor).cookieJar(new SSOHttpClientKt$buildNativeLoginHttpClient$cookieJar$1()).followRedirects(false);
        if (chuckerInterceptor != null) {
            builderFollowRedirects.addInterceptor(chuckerInterceptor);
        }
        return builderFollowRedirects.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response buildNativeLoginHttpClient$lambda$1(Map map, Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Request.Builder builderNewBuilder = request.newBuilder();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (request.header(str) == null) {
                builderNewBuilder.addHeader(str, str2);
            }
        }
        return chain.proceed(builderNewBuilder.build());
    }
}
