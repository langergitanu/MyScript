package com.myscript.nebo.sso.api.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SSOAccount.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003Je\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006%"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/entity/Provider;", "", "providerId", "", "providerUserId", "providerEmail", "isProviderEmailVerified", "", "providerToken", "providerTokenExpires", "providerRefreshToken", "providerFirstName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getProviderId", "()Ljava/lang/String;", "getProviderUserId", "getProviderEmail", "()Z", "getProviderToken", "getProviderTokenExpires", "getProviderRefreshToken", "getProviderFirstName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class Provider {

    @SerializedName("provider_email_verified")
    private final boolean isProviderEmailVerified;

    @SerializedName("provider_email")
    private final String providerEmail;

    @SerializedName("provider_first_name")
    private final String providerFirstName;

    @SerializedName("provider_id")
    private final String providerId;

    @SerializedName("provider_refresh_token")
    private final String providerRefreshToken;

    @SerializedName("provider_token")
    private final String providerToken;

    @SerializedName("provider_token_expires")
    private final String providerTokenExpires;

    @SerializedName("provider_user_id")
    private final String providerUserId;

    public static /* synthetic */ Provider copy$default(Provider provider, String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = provider.providerId;
        }
        if ((i & 2) != 0) {
            str2 = provider.providerUserId;
        }
        if ((i & 4) != 0) {
            str3 = provider.providerEmail;
        }
        if ((i & 8) != 0) {
            z = provider.isProviderEmailVerified;
        }
        if ((i & 16) != 0) {
            str4 = provider.providerToken;
        }
        if ((i & 32) != 0) {
            str5 = provider.providerTokenExpires;
        }
        if ((i & 64) != 0) {
            str6 = provider.providerRefreshToken;
        }
        if ((i & 128) != 0) {
            str7 = provider.providerFirstName;
        }
        String str8 = str6;
        String str9 = str7;
        String str10 = str4;
        String str11 = str5;
        return provider.copy(str, str2, str3, z, str10, str11, str8, str9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProviderId() {
        return this.providerId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getProviderUserId() {
        return this.providerUserId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getProviderEmail() {
        return this.providerEmail;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsProviderEmailVerified() {
        return this.isProviderEmailVerified;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getProviderToken() {
        return this.providerToken;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getProviderTokenExpires() {
        return this.providerTokenExpires;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getProviderRefreshToken() {
        return this.providerRefreshToken;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getProviderFirstName() {
        return this.providerFirstName;
    }

    public final Provider copy(String providerId, String providerUserId, String providerEmail, boolean isProviderEmailVerified, String providerToken, String providerTokenExpires, String providerRefreshToken, String providerFirstName) {
        Intrinsics.checkNotNullParameter(providerId, "providerId");
        return new Provider(providerId, providerUserId, providerEmail, isProviderEmailVerified, providerToken, providerTokenExpires, providerRefreshToken, providerFirstName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Provider)) {
            return false;
        }
        Provider provider = (Provider) other;
        return Intrinsics.areEqual(this.providerId, provider.providerId) && Intrinsics.areEqual(this.providerUserId, provider.providerUserId) && Intrinsics.areEqual(this.providerEmail, provider.providerEmail) && this.isProviderEmailVerified == provider.isProviderEmailVerified && Intrinsics.areEqual(this.providerToken, provider.providerToken) && Intrinsics.areEqual(this.providerTokenExpires, provider.providerTokenExpires) && Intrinsics.areEqual(this.providerRefreshToken, provider.providerRefreshToken) && Intrinsics.areEqual(this.providerFirstName, provider.providerFirstName);
    }

    public int hashCode() {
        int iHashCode = this.providerId.hashCode() * 31;
        String str = this.providerUserId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.providerEmail;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.isProviderEmailVerified)) * 31;
        String str3 = this.providerToken;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.providerTokenExpires;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.providerRefreshToken;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.providerFirstName;
        return iHashCode6 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "Provider(providerId=" + this.providerId + ", providerUserId=" + this.providerUserId + ", providerEmail=" + this.providerEmail + ", isProviderEmailVerified=" + this.isProviderEmailVerified + ", providerToken=" + this.providerToken + ", providerTokenExpires=" + this.providerTokenExpires + ", providerRefreshToken=" + this.providerRefreshToken + ", providerFirstName=" + this.providerFirstName + ")";
    }

    public Provider(String providerId, String str, String str2, boolean z, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(providerId, "providerId");
        this.providerId = providerId;
        this.providerUserId = str;
        this.providerEmail = str2;
        this.isProviderEmailVerified = z;
        this.providerToken = str3;
        this.providerTokenExpires = str4;
        this.providerRefreshToken = str5;
        this.providerFirstName = str6;
    }

    public /* synthetic */ Provider(String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, z, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7);
    }

    public final String getProviderId() {
        return this.providerId;
    }

    public final String getProviderUserId() {
        return this.providerUserId;
    }

    public final String getProviderEmail() {
        return this.providerEmail;
    }

    public final boolean isProviderEmailVerified() {
        return this.isProviderEmailVerified;
    }

    public final String getProviderToken() {
        return this.providerToken;
    }

    public final String getProviderTokenExpires() {
        return this.providerTokenExpires;
    }

    public final String getProviderRefreshToken() {
        return this.providerRefreshToken;
    }

    public final String getProviderFirstName() {
        return this.providerFirstName;
    }
}
