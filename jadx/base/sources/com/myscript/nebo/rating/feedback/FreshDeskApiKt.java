package com.myscript.nebo.rating.feedback;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: FreshDeskApi.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, m1599d2 = {"buildFreshDeskApi", "Lcom/myscript/nebo/rating/feedback/FreshDeskApi;", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FreshDeskApiKt {
    public static final FreshDeskApi buildFreshDeskApi() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
        Object objCreate = new Retrofit.Builder().baseUrl("https://myscript.freshdesk.com/").client(new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()).addConverterFactory(GsonConverterFactory.create()).build().create(FreshDeskApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (FreshDeskApi) objCreate;
    }
}
