package com.myscript.nebo.rating.feedback;

import com.myscript.nebo.rating.feedback.entity.FreshdeskTicket;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/* JADX INFO: compiled from: FreshDeskApi.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/rating/feedback/FreshDeskApi;", "", "sendFeedback", "Lretrofit2/Call;", "Ljava/lang/Void;", "authHeader", "", "ticket", "Lcom/myscript/nebo/rating/feedback/entity/FreshdeskTicket;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface FreshDeskApi {
    @POST("api/v2/tickets")
    Call<Void> sendFeedback(@Header("Authorization") String authHeader, @Body FreshdeskTicket ticket);
}
