package com.myscript.nebo.sso.api;

import com.myscript.nebo.sso.api.entity.DropboxCredentialPayload;
import com.myscript.nebo.sso.api.entity.GDriveAuthCodePayload;
import com.myscript.nebo.sso.api.entity.SSOAccount;
import com.myscript.nebo.sso.api.entity.ShareNotesPayload;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/* JADX INFO: compiled from: SSOApi.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH§@¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\t\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\f2\b\b\u0001\u0010\t\u001a\u00020\u0010H§@¢\u0006\u0002\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/SSOApi;", "", "getAccount", "Lcom/myscript/nebo/sso/api/entity/SSOAccount;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reSendEmail", "", "saveShareMyNotesSetting", "Lcom/myscript/nebo/sso/api/entity/ShareNotesPayload;", "request", "(Lcom/myscript/nebo/sso/api/entity/ShareNotesPayload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "linkDropboxAccount", "", "Lcom/myscript/nebo/sso/api/entity/DropboxCredentialPayload;", "(Lcom/myscript/nebo/sso/api/entity/DropboxCredentialPayload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "linkGDriveAccount", "Lcom/myscript/nebo/sso/api/entity/GDriveAuthCodePayload;", "(Lcom/myscript/nebo/sso/api/entity/GDriveAuthCodePayload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface SSOApi {
    @GET("v1/api/account")
    Object getAccount(Continuation<? super SSOAccount> continuation);

    @POST("v1/api/account/linkaccount/dropbox")
    Object linkDropboxAccount(@Body DropboxCredentialPayload dropboxCredentialPayload, Continuation<? super Unit> continuation);

    @POST("v1/api/account/linkaccount/gdrive")
    Object linkGDriveAccount(@Body GDriveAuthCodePayload gDriveAuthCodePayload, Continuation<? super Unit> continuation);

    @POST("v1/api/account/sendactivation")
    Object reSendEmail(Continuation<? super String> continuation);

    @POST("v1/api/account")
    Object saveShareMyNotesSetting(@Body ShareNotesPayload shareNotesPayload, Continuation<? super ShareNotesPayload> continuation);
}
