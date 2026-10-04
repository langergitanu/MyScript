package com.myscript.nebo.sso.api.auth;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.myscript.nebo.sso.util.SSOCustomHeaderKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: SSOAuthApi.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006H\u0007¨\u0006\u0007"}, m1599d2 = {"buildSSOAuthApi", "Lcom/myscript/nebo/sso/api/auth/SSOAuthApi;", RemoteConfigConstants.RequestFieldKey.INSTANCE_ID, "", "appVersion", "customHeaders", "", "sso_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SSOAuthApiKt {
    public static final SSOAuthApi buildSSOAuthApi(String appInstanceId, String appVersion) {
        Intrinsics.checkNotNullParameter(appInstanceId, "appInstanceId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        return buildSSOAuthApi$default(appInstanceId, appVersion, null, 4, null);
    }

    public static /* synthetic */ SSOAuthApi buildSSOAuthApi$default(String str, String str2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = SSOCustomHeaderKt.computeCustomHeaders(str, str2);
        }
        return buildSSOAuthApi(str, str2, map);
    }

    public static final SSOAuthApi buildSSOAuthApi(String appInstanceId, String appVersion, final Map<String, String> customHeaders) {
        Intrinsics.checkNotNullParameter(appInstanceId, "appInstanceId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(customHeaders, "customHeaders");
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
        Object objCreate = new Retrofit.Builder().baseUrl("https://localhost").addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).addInterceptor(new Interceptor() { // from class: com.myscript.nebo.sso.api.auth.SSOAuthApiKt$$ExternalSyntheticLambda0
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                return SSOAuthApiKt.buildSSOAuthApi$lambda$1(customHeaders, chain);
            }
        }).build()).build().create(SSOAuthApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (SSOAuthApi) objCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response buildSSOAuthApi$lambda$1(Map map, Interceptor.Chain chain) {
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
