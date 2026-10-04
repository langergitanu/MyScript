package com.myscript.nebo.sso.api.auth;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import com.myscript.nebo.sso.api.NoAuthorizationHeader;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

/* JADX INFO: compiled from: SSOAuthApi.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001:\u0001\u000fJT\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\fJ@\u0010\r\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\r\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000e¨\u0006\u0010À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/auth/SSOAuthApi;", "", "getToken", "Lcom/myscript/nebo/sso/api/auth/SSOAuthApi$AccessTokenResponse;", ImagesContract.URL, "", "clientId", "grantType", "clientSecret", "redirectUri", "code", "codeVerifier", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AccessTokenResponse", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface SSOAuthApi {
    @FormUrlEncoded
    @NoAuthorizationHeader
    @POST
    Object getToken(@Url String str, @Field("client_id") String str2, @Field("grant_type") String str3, @Field("client_secret") String str4, @Field("redirect_uri") String str5, @Field("code") String str6, @Field("code_verifier") String str7, Continuation<? super AccessTokenResponse> continuation);

    @FormUrlEncoded
    @NoAuthorizationHeader
    @POST
    Object refreshToken(@Url String str, @Field("grant_type") String str2, @Field("client_id") String str3, @Field("client_secret") String str4, @Field("refresh_token") String str5, Continuation<? super AccessTokenResponse> continuation);

    /* JADX INFO: compiled from: SSOAuthApi.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/auth/SSOAuthApi$AccessTokenResponse;", "", "accessToken", "", "refreshToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "getRefreshToken", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class AccessTokenResponse {

        @SerializedName("access_token")
        private final String accessToken;

        @SerializedName("refresh_token")
        private final String refreshToken;

        /* JADX WARN: Multi-variable type inference failed */
        public AccessTokenResponse() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ AccessTokenResponse copy$default(AccessTokenResponse accessTokenResponse, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = accessTokenResponse.accessToken;
            }
            if ((i & 2) != 0) {
                str2 = accessTokenResponse.refreshToken;
            }
            return accessTokenResponse.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAccessToken() {
            return this.accessToken;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getRefreshToken() {
            return this.refreshToken;
        }

        public final AccessTokenResponse copy(String accessToken, String refreshToken) {
            Intrinsics.checkNotNullParameter(accessToken, "accessToken");
            Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
            return new AccessTokenResponse(accessToken, refreshToken);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AccessTokenResponse)) {
                return false;
            }
            AccessTokenResponse accessTokenResponse = (AccessTokenResponse) other;
            return Intrinsics.areEqual(this.accessToken, accessTokenResponse.accessToken) && Intrinsics.areEqual(this.refreshToken, accessTokenResponse.refreshToken);
        }

        public int hashCode() {
            return (this.accessToken.hashCode() * 31) + this.refreshToken.hashCode();
        }

        public String toString() {
            return "AccessTokenResponse(accessToken=" + this.accessToken + ", refreshToken=" + this.refreshToken + ")";
        }

        public AccessTokenResponse(String accessToken, String refreshToken) {
            Intrinsics.checkNotNullParameter(accessToken, "accessToken");
            Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
        }

        public /* synthetic */ AccessTokenResponse(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
        }

        public final String getAccessToken() {
            return this.accessToken;
        }

        public final String getRefreshToken() {
            return this.refreshToken;
        }
    }

    /* JADX INFO: compiled from: SSOAuthApi.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object refreshToken$default(SSOAuthApi sSOAuthApi, String str, String str2, String str3, String str4, String str5, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshToken");
        }
        if ((i & 2) != 0) {
            str2 = "refresh_token";
        }
        return sSOAuthApi.refreshToken(str, str2, str3, str4, str5, continuation);
    }
}
