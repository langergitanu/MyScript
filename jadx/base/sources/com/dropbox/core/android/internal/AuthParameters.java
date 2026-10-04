package com.dropbox.core.android.internal;

import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.IncludeGrantedScopes;
import com.dropbox.core.TokenAccessType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthParameters.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001Bm\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0085\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00064"}, m1599d2 = {"Lcom/dropbox/core/android/internal/AuthParameters;", "", "sAppKey", "", "sApiType", "sDesiredUid", "sAlreadyAuthedUids", "", "sSessionId", "sTokenAccessType", "Lcom/dropbox/core/TokenAccessType;", "sRequestConfig", "Lcom/dropbox/core/DbxRequestConfig;", "sHost", "Lcom/dropbox/core/DbxHost;", "sScope", "sIncludeGrantedScopes", "Lcom/dropbox/core/IncludeGrantedScopes;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/dropbox/core/TokenAccessType;Lcom/dropbox/core/DbxRequestConfig;Lcom/dropbox/core/DbxHost;Ljava/lang/String;Lcom/dropbox/core/IncludeGrantedScopes;)V", "getSAlreadyAuthedUids", "()Ljava/util/List;", "getSApiType", "()Ljava/lang/String;", "getSAppKey", "getSDesiredUid", "getSHost", "()Lcom/dropbox/core/DbxHost;", "getSIncludeGrantedScopes", "()Lcom/dropbox/core/IncludeGrantedScopes;", "getSRequestConfig", "()Lcom/dropbox/core/DbxRequestConfig;", "getSScope", "getSSessionId", "getSTokenAccessType", "()Lcom/dropbox/core/TokenAccessType;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "android_release"}, m1600k = 1, m1601mv = {1, 6, 0}, m1603xi = 48)
public final /* data */ class AuthParameters {
    private final List<String> sAlreadyAuthedUids;
    private final String sApiType;
    private final String sAppKey;
    private final String sDesiredUid;
    private final DbxHost sHost;
    private final IncludeGrantedScopes sIncludeGrantedScopes;
    private final DbxRequestConfig sRequestConfig;
    private final String sScope;
    private final String sSessionId;
    private final TokenAccessType sTokenAccessType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AuthParameters copy$default(AuthParameters authParameters, String str, String str2, String str3, List list, String str4, TokenAccessType tokenAccessType, DbxRequestConfig dbxRequestConfig, DbxHost dbxHost, String str5, IncludeGrantedScopes includeGrantedScopes, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authParameters.sAppKey;
        }
        if ((i & 2) != 0) {
            str2 = authParameters.sApiType;
        }
        if ((i & 4) != 0) {
            str3 = authParameters.sDesiredUid;
        }
        if ((i & 8) != 0) {
            list = authParameters.sAlreadyAuthedUids;
        }
        if ((i & 16) != 0) {
            str4 = authParameters.sSessionId;
        }
        if ((i & 32) != 0) {
            tokenAccessType = authParameters.sTokenAccessType;
        }
        if ((i & 64) != 0) {
            dbxRequestConfig = authParameters.sRequestConfig;
        }
        if ((i & 128) != 0) {
            dbxHost = authParameters.sHost;
        }
        if ((i & 256) != 0) {
            str5 = authParameters.sScope;
        }
        if ((i & 512) != 0) {
            includeGrantedScopes = authParameters.sIncludeGrantedScopes;
        }
        String str6 = str5;
        IncludeGrantedScopes includeGrantedScopes2 = includeGrantedScopes;
        DbxRequestConfig dbxRequestConfig2 = dbxRequestConfig;
        DbxHost dbxHost2 = dbxHost;
        String str7 = str4;
        TokenAccessType tokenAccessType2 = tokenAccessType;
        return authParameters.copy(str, str2, str3, list, str7, tokenAccessType2, dbxRequestConfig2, dbxHost2, str6, includeGrantedScopes2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSAppKey() {
        return this.sAppKey;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final IncludeGrantedScopes getSIncludeGrantedScopes() {
        return this.sIncludeGrantedScopes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSApiType() {
        return this.sApiType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSDesiredUid() {
        return this.sDesiredUid;
    }

    public final List<String> component4() {
        return this.sAlreadyAuthedUids;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSSessionId() {
        return this.sSessionId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final TokenAccessType getSTokenAccessType() {
        return this.sTokenAccessType;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final DbxRequestConfig getSRequestConfig() {
        return this.sRequestConfig;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final DbxHost getSHost() {
        return this.sHost;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getSScope() {
        return this.sScope;
    }

    public final AuthParameters copy(String sAppKey, String sApiType, String sDesiredUid, List<String> sAlreadyAuthedUids, String sSessionId, TokenAccessType sTokenAccessType, DbxRequestConfig sRequestConfig, DbxHost sHost, String sScope, IncludeGrantedScopes sIncludeGrantedScopes) {
        Intrinsics.checkNotNullParameter(sAlreadyAuthedUids, "sAlreadyAuthedUids");
        return new AuthParameters(sAppKey, sApiType, sDesiredUid, sAlreadyAuthedUids, sSessionId, sTokenAccessType, sRequestConfig, sHost, sScope, sIncludeGrantedScopes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthParameters)) {
            return false;
        }
        AuthParameters authParameters = (AuthParameters) other;
        return Intrinsics.areEqual(this.sAppKey, authParameters.sAppKey) && Intrinsics.areEqual(this.sApiType, authParameters.sApiType) && Intrinsics.areEqual(this.sDesiredUid, authParameters.sDesiredUid) && Intrinsics.areEqual(this.sAlreadyAuthedUids, authParameters.sAlreadyAuthedUids) && Intrinsics.areEqual(this.sSessionId, authParameters.sSessionId) && this.sTokenAccessType == authParameters.sTokenAccessType && Intrinsics.areEqual(this.sRequestConfig, authParameters.sRequestConfig) && Intrinsics.areEqual(this.sHost, authParameters.sHost) && Intrinsics.areEqual(this.sScope, authParameters.sScope) && this.sIncludeGrantedScopes == authParameters.sIncludeGrantedScopes;
    }

    public int hashCode() {
        String str = this.sAppKey;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.sApiType;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sDesiredUid;
        int iHashCode3 = (((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.sAlreadyAuthedUids.hashCode()) * 31;
        String str4 = this.sSessionId;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        TokenAccessType tokenAccessType = this.sTokenAccessType;
        int iHashCode5 = (iHashCode4 + (tokenAccessType == null ? 0 : tokenAccessType.hashCode())) * 31;
        DbxRequestConfig dbxRequestConfig = this.sRequestConfig;
        int iHashCode6 = (iHashCode5 + (dbxRequestConfig == null ? 0 : dbxRequestConfig.hashCode())) * 31;
        DbxHost dbxHost = this.sHost;
        int iHashCode7 = (iHashCode6 + (dbxHost == null ? 0 : dbxHost.hashCode())) * 31;
        String str5 = this.sScope;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        IncludeGrantedScopes includeGrantedScopes = this.sIncludeGrantedScopes;
        return iHashCode8 + (includeGrantedScopes != null ? includeGrantedScopes.hashCode() : 0);
    }

    public String toString() {
        return "AuthParameters(sAppKey=" + this.sAppKey + ", sApiType=" + this.sApiType + ", sDesiredUid=" + this.sDesiredUid + ", sAlreadyAuthedUids=" + this.sAlreadyAuthedUids + ", sSessionId=" + this.sSessionId + ", sTokenAccessType=" + this.sTokenAccessType + ", sRequestConfig=" + this.sRequestConfig + ", sHost=" + this.sHost + ", sScope=" + this.sScope + ", sIncludeGrantedScopes=" + this.sIncludeGrantedScopes + ')';
    }

    public AuthParameters(String str, String str2, String str3, List<String> sAlreadyAuthedUids, String str4, TokenAccessType tokenAccessType, DbxRequestConfig dbxRequestConfig, DbxHost dbxHost, String str5, IncludeGrantedScopes includeGrantedScopes) {
        Intrinsics.checkNotNullParameter(sAlreadyAuthedUids, "sAlreadyAuthedUids");
        this.sAppKey = str;
        this.sApiType = str2;
        this.sDesiredUid = str3;
        this.sAlreadyAuthedUids = sAlreadyAuthedUids;
        this.sSessionId = str4;
        this.sTokenAccessType = tokenAccessType;
        this.sRequestConfig = dbxRequestConfig;
        this.sHost = dbxHost;
        this.sScope = str5;
        this.sIncludeGrantedScopes = includeGrantedScopes;
    }

    public final String getSAppKey() {
        return this.sAppKey;
    }

    public final String getSApiType() {
        return this.sApiType;
    }

    public final String getSDesiredUid() {
        return this.sDesiredUid;
    }

    public final List<String> getSAlreadyAuthedUids() {
        return this.sAlreadyAuthedUids;
    }

    public final String getSSessionId() {
        return this.sSessionId;
    }

    public final TokenAccessType getSTokenAccessType() {
        return this.sTokenAccessType;
    }

    public final DbxRequestConfig getSRequestConfig() {
        return this.sRequestConfig;
    }

    public final DbxHost getSHost() {
        return this.sHost;
    }

    public final String getSScope() {
        return this.sScope;
    }

    public final IncludeGrantedScopes getSIncludeGrantedScopes() {
        return this.sIncludeGrantedScopes;
    }
}
