package com.myscript.nebo.dms.sharepage.api;

import com.myscript.nebo.dms.sharepage.api.entity.AddUsersPayload;
import com.myscript.nebo.dms.sharepage.api.entity.OptionsPayload;
import com.myscript.nebo.dms.sharepage.api.entity.PagePayload;
import com.myscript.nebo.dms.sharepage.api.entity.PublishResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/* JADX INFO: compiled from: SharePageApi.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\"\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0010J\"\u0010\u0011\u001a\u00020\r2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\r2\b\b\u0001\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\"\u0010\u0015\u001a\u00020\r2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0016\u001a\u00020\nH§@¢\u0006\u0002\u0010\u0017¨\u0006\u0019À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/api/SharePageApi;", "", "publishPage", "Lretrofit2/Response;", "Lcom/myscript/nebo/dms/sharepage/api/entity/PublishResult;", "payload", "Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload;", "(Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPage", "uuid", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePage", "", "changePageVisibility", "Lcom/myscript/nebo/dms/sharepage/api/entity/OptionsPayload;", "(Ljava/lang/String;Lcom/myscript/nebo/dms/sharepage/api/entity/OptionsPayload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addUsersToPage", "Lcom/myscript/nebo/dms/sharepage/api/entity/AddUsersPayload;", "(Ljava/lang/String;Lcom/myscript/nebo/dms/sharepage/api/entity/AddUsersPayload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeAllUsersFromPage", "removeUsersFromPage", "contacts", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface SharePageApi {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @JvmStatic
    static SharePageApi build(OkHttpClient okHttpClient, String str) {
        return INSTANCE.build(okHttpClient, str);
    }

    @POST("api/v2.0/nebo/pages/{uuid}/contacts")
    Object addUsersToPage(@Path("uuid") String str, @Body AddUsersPayload addUsersPayload, Continuation<? super Unit> continuation);

    @PUT("api/v2.0/nebo/pages/{uuid}")
    Object changePageVisibility(@Path("uuid") String str, @Body OptionsPayload optionsPayload, Continuation<? super Unit> continuation);

    @DELETE("api/v2.0/nebo/pages/{uuid}")
    Object deletePage(@Path("uuid") String str, Continuation<? super Unit> continuation);

    @GET("api/v2.0/nebo/pages/{uuid}")
    Object getPage(@Path("uuid") String str, Continuation<? super PagePayload> continuation);

    @POST("api/v3.0/nebo/pages")
    Object publishPage(@Body PagePayload pagePayload, Continuation<? super Response<PublishResult>> continuation);

    @DELETE("api/v2.0/nebo/pages/{uuid}/contacts")
    Object removeAllUsersFromPage(@Path("uuid") String str, Continuation<? super Unit> continuation);

    @DELETE("api/v2.0/nebo/pages/{uuid}/contacts/{contacts}")
    Object removeUsersFromPage(@Path("uuid") String str, @Path("contacts") String str2, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: SharePageApi.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/api/SharePageApi$Companion;", "", "<init>", "()V", "build", "Lcom/myscript/nebo/dms/sharepage/api/SharePageApi;", "httpClient", "Lokhttp3/OkHttpClient;", "baseUrl", "", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @JvmStatic
        public final SharePageApi build(OkHttpClient httpClient, String baseUrl) {
            Intrinsics.checkNotNullParameter(httpClient, "httpClient");
            Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
            Object objCreate = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).client(httpClient).build().create(SharePageApi.class);
            Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
            return (SharePageApi) objCreate;
        }
    }
}
