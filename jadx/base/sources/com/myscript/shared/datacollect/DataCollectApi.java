package com.myscript.shared.datacollect;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* JADX INFO: compiled from: DataCollectApi.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/shared/datacollect/DataCollectApi;", "", "getS3UploadParameters", "Lcom/myscript/shared/datacollect/NotesCollectResponseModel;", "data", "Lcom/myscript/shared/datacollect/DataCollectPayload;", "(Lcom/myscript/shared/datacollect/DataCollectPayload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "shared-datacollect_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface DataCollectApi {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("api/v3.0/nebo/collect")
    Object getS3UploadParameters(@Body DataCollectPayload dataCollectPayload, Continuation<? super NotesCollectResponseModel> continuation);

    /* JADX INFO: compiled from: DataCollectApi.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, m1599d2 = {"Lcom/myscript/shared/datacollect/DataCollectApi$Companion;", "", "<init>", "()V", "build", "Lcom/myscript/shared/datacollect/DataCollectApi;", "httpClient", "Lokhttp3/OkHttpClient;", "baseUrl", "", "shared-datacollect_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final DataCollectApi build(OkHttpClient httpClient, String baseUrl) {
            Intrinsics.checkNotNullParameter(httpClient, "httpClient");
            Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
            Object objCreate = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).client(httpClient).build().create(DataCollectApi.class);
            Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
            return (DataCollectApi) objCreate;
        }
    }
}
