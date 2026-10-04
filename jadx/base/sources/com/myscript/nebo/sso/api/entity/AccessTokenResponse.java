package com.myscript.nebo.sso.api.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccessTokenResponse.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/entity/AccessTokenResponse;", "", "accessToken", "", "<init>", "(Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class AccessTokenResponse {

    @SerializedName("access_token")
    private final String accessToken;

    public static /* synthetic */ AccessTokenResponse copy$default(AccessTokenResponse accessTokenResponse, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = accessTokenResponse.accessToken;
        }
        return accessTokenResponse.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    public final AccessTokenResponse copy(String accessToken) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        return new AccessTokenResponse(accessToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AccessTokenResponse) && Intrinsics.areEqual(this.accessToken, ((AccessTokenResponse) other).accessToken);
    }

    public int hashCode() {
        return this.accessToken.hashCode();
    }

    public String toString() {
        return "AccessTokenResponse(accessToken=" + this.accessToken + ")";
    }

    public AccessTokenResponse(String accessToken) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        this.accessToken = accessToken;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }
}
