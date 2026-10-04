package com.myscript.nebo.sso.api.discovery;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DiscoveryApi.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/discovery/DiscoveredSSOConfiguration;", "", "issuer", "", "authorizationEndpoint", "tokenEndpoint", "userInfoEndpoint", "logoutEndpoint", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIssuer", "()Ljava/lang/String;", "getAuthorizationEndpoint", "getTokenEndpoint", "getUserInfoEndpoint", "getLogoutEndpoint", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class DiscoveredSSOConfiguration {

    @SerializedName("authorization_endpoint")
    private final String authorizationEndpoint;

    @SerializedName("issuer")
    private final String issuer;

    @SerializedName("end_session_endpoint")
    private final String logoutEndpoint;

    @SerializedName("token_endpoint")
    private final String tokenEndpoint;

    @SerializedName("userinfo_endpoint")
    private final String userInfoEndpoint;

    public DiscoveredSSOConfiguration() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ DiscoveredSSOConfiguration copy$default(DiscoveredSSOConfiguration discoveredSSOConfiguration, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = discoveredSSOConfiguration.issuer;
        }
        if ((i & 2) != 0) {
            str2 = discoveredSSOConfiguration.authorizationEndpoint;
        }
        if ((i & 4) != 0) {
            str3 = discoveredSSOConfiguration.tokenEndpoint;
        }
        if ((i & 8) != 0) {
            str4 = discoveredSSOConfiguration.userInfoEndpoint;
        }
        if ((i & 16) != 0) {
            str5 = discoveredSSOConfiguration.logoutEndpoint;
        }
        String str6 = str5;
        String str7 = str3;
        return discoveredSSOConfiguration.copy(str, str2, str7, str4, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getIssuer() {
        return this.issuer;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAuthorizationEndpoint() {
        return this.authorizationEndpoint;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTokenEndpoint() {
        return this.tokenEndpoint;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUserInfoEndpoint() {
        return this.userInfoEndpoint;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLogoutEndpoint() {
        return this.logoutEndpoint;
    }

    public final DiscoveredSSOConfiguration copy(String issuer, String authorizationEndpoint, String tokenEndpoint, String userInfoEndpoint, String logoutEndpoint) {
        Intrinsics.checkNotNullParameter(issuer, "issuer");
        Intrinsics.checkNotNullParameter(authorizationEndpoint, "authorizationEndpoint");
        Intrinsics.checkNotNullParameter(tokenEndpoint, "tokenEndpoint");
        Intrinsics.checkNotNullParameter(userInfoEndpoint, "userInfoEndpoint");
        Intrinsics.checkNotNullParameter(logoutEndpoint, "logoutEndpoint");
        return new DiscoveredSSOConfiguration(issuer, authorizationEndpoint, tokenEndpoint, userInfoEndpoint, logoutEndpoint);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiscoveredSSOConfiguration)) {
            return false;
        }
        DiscoveredSSOConfiguration discoveredSSOConfiguration = (DiscoveredSSOConfiguration) other;
        return Intrinsics.areEqual(this.issuer, discoveredSSOConfiguration.issuer) && Intrinsics.areEqual(this.authorizationEndpoint, discoveredSSOConfiguration.authorizationEndpoint) && Intrinsics.areEqual(this.tokenEndpoint, discoveredSSOConfiguration.tokenEndpoint) && Intrinsics.areEqual(this.userInfoEndpoint, discoveredSSOConfiguration.userInfoEndpoint) && Intrinsics.areEqual(this.logoutEndpoint, discoveredSSOConfiguration.logoutEndpoint);
    }

    public int hashCode() {
        return (((((((this.issuer.hashCode() * 31) + this.authorizationEndpoint.hashCode()) * 31) + this.tokenEndpoint.hashCode()) * 31) + this.userInfoEndpoint.hashCode()) * 31) + this.logoutEndpoint.hashCode();
    }

    public String toString() {
        return "DiscoveredSSOConfiguration(issuer=" + this.issuer + ", authorizationEndpoint=" + this.authorizationEndpoint + ", tokenEndpoint=" + this.tokenEndpoint + ", userInfoEndpoint=" + this.userInfoEndpoint + ", logoutEndpoint=" + this.logoutEndpoint + ")";
    }

    public DiscoveredSSOConfiguration(String issuer, String authorizationEndpoint, String tokenEndpoint, String userInfoEndpoint, String logoutEndpoint) {
        Intrinsics.checkNotNullParameter(issuer, "issuer");
        Intrinsics.checkNotNullParameter(authorizationEndpoint, "authorizationEndpoint");
        Intrinsics.checkNotNullParameter(tokenEndpoint, "tokenEndpoint");
        Intrinsics.checkNotNullParameter(userInfoEndpoint, "userInfoEndpoint");
        Intrinsics.checkNotNullParameter(logoutEndpoint, "logoutEndpoint");
        this.issuer = issuer;
        this.authorizationEndpoint = authorizationEndpoint;
        this.tokenEndpoint = tokenEndpoint;
        this.userInfoEndpoint = userInfoEndpoint;
        this.logoutEndpoint = logoutEndpoint;
    }

    public /* synthetic */ DiscoveredSSOConfiguration(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5);
    }

    public final String getIssuer() {
        return this.issuer;
    }

    public final String getAuthorizationEndpoint() {
        return this.authorizationEndpoint;
    }

    public final String getTokenEndpoint() {
        return this.tokenEndpoint;
    }

    public final String getUserInfoEndpoint() {
        return this.userInfoEndpoint;
    }

    public final String getLogoutEndpoint() {
        return this.logoutEndpoint;
    }
}
