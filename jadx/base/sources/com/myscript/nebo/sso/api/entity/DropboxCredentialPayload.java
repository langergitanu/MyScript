package com.myscript.nebo.sso.api.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DropboxCredentialPayload.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/entity/DropboxCredentialPayload;", "", "refreshToken", "", "clientId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getRefreshToken", "()Ljava/lang/String;", "getClientId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class DropboxCredentialPayload {

    @SerializedName("clientId")
    private final String clientId;

    @SerializedName("refreshtoken")
    private final String refreshToken;

    public static /* synthetic */ DropboxCredentialPayload copy$default(DropboxCredentialPayload dropboxCredentialPayload, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dropboxCredentialPayload.refreshToken;
        }
        if ((i & 2) != 0) {
            str2 = dropboxCredentialPayload.clientId;
        }
        return dropboxCredentialPayload.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    public final DropboxCredentialPayload copy(String refreshToken, String clientId) {
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        return new DropboxCredentialPayload(refreshToken, clientId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DropboxCredentialPayload)) {
            return false;
        }
        DropboxCredentialPayload dropboxCredentialPayload = (DropboxCredentialPayload) other;
        return Intrinsics.areEqual(this.refreshToken, dropboxCredentialPayload.refreshToken) && Intrinsics.areEqual(this.clientId, dropboxCredentialPayload.clientId);
    }

    public int hashCode() {
        return (this.refreshToken.hashCode() * 31) + this.clientId.hashCode();
    }

    public String toString() {
        return "DropboxCredentialPayload(refreshToken=" + this.refreshToken + ", clientId=" + this.clientId + ")";
    }

    public DropboxCredentialPayload(String refreshToken, String clientId) {
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        this.refreshToken = refreshToken;
        this.clientId = clientId;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final String getClientId() {
        return this.clientId;
    }
}
