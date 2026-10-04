package com.myscript.nebo.sso.api.discovery;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: DiscoveryApi.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, m1599d2 = {"buildDiscoveryApi", "Lcom/myscript/nebo/sso/api/discovery/DiscoveryApi;", "baseUrl", "", "httpClient", "Lokhttp3/OkHttpClient;", "sso_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DiscoveryApiKt {
    public static final DiscoveryApi buildDiscoveryApi(String baseUrl, OkHttpClient httpClient) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Object objCreate = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).client(httpClient).build().create(DiscoveryApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (DiscoveryApi) objCreate;
    }
}
