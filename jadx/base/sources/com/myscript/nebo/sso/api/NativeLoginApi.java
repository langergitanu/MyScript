package com.myscript.nebo.sso.api;

import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

/* JADX INFO: compiled from: SSOApi.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0001\u0010\f\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/NativeLoginApi;", "", "loginWithGoogle", "", "clientId", "", "neboVersion", "googleToken", "Lokhttp3/RequestBody;", "(Ljava/lang/String;Ljava/lang/String;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authorize", "Lretrofit2/Response;", ImagesContract.URL, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface NativeLoginApi {
    @GET
    Object authorize(@Url String str, Continuation<? super Response<Unit>> continuation);

    @POST("/public/openid/google")
    Object loginWithGoogle(@Header("Client-Id") String str, @Header("Nebo-Version") String str2, @Body RequestBody requestBody, Continuation<? super Unit> continuation);
}
