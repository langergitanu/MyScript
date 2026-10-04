package com.myscript.nebo.sso.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SSOManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/SSOConfiguration;", "", "baseUrl", "", "clientId", "clientSecret", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "getClientId", "getClientSecret", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class SSOConfiguration {
    private final String baseUrl;
    private final String clientId;
    private final String clientSecret;

    public static /* synthetic */ SSOConfiguration copy$default(SSOConfiguration sSOConfiguration, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sSOConfiguration.baseUrl;
        }
        if ((i & 2) != 0) {
            str2 = sSOConfiguration.clientId;
        }
        if ((i & 4) != 0) {
            str3 = sSOConfiguration.clientSecret;
        }
        return sSOConfiguration.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getClientSecret() {
        return this.clientSecret;
    }

    public final SSOConfiguration copy(String baseUrl, String clientId, String clientSecret) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(clientSecret, "clientSecret");
        return new SSOConfiguration(baseUrl, clientId, clientSecret);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SSOConfiguration)) {
            return false;
        }
        SSOConfiguration sSOConfiguration = (SSOConfiguration) other;
        return Intrinsics.areEqual(this.baseUrl, sSOConfiguration.baseUrl) && Intrinsics.areEqual(this.clientId, sSOConfiguration.clientId) && Intrinsics.areEqual(this.clientSecret, sSOConfiguration.clientSecret);
    }

    public int hashCode() {
        return (((this.baseUrl.hashCode() * 31) + this.clientId.hashCode()) * 31) + this.clientSecret.hashCode();
    }

    public String toString() {
        return "SSOConfiguration(baseUrl=" + this.baseUrl + ", clientId=" + this.clientId + ", clientSecret=" + this.clientSecret + ")";
    }

    public SSOConfiguration(String baseUrl, String clientId, String clientSecret) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(clientSecret, "clientSecret");
        this.baseUrl = baseUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getClientSecret() {
        return this.clientSecret;
    }
}
