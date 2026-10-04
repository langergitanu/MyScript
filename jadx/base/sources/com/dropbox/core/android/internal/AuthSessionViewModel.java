package com.dropbox.core.android.internal;

import android.content.Intent;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxPKCEManager;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.IncludeGrantedScopes;
import com.dropbox.core.TokenAccessType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthSessionViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, m1599d2 = {"Lcom/dropbox/core/android/internal/AuthSessionViewModel;", "", "()V", "Companion", "State", "android_release"}, m1600k = 1, m1601mv = {1, 6, 0}, m1603xi = 48)
public final class AuthSessionViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static State _state = new State(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    private static boolean authInProgress;

    /* JADX INFO: compiled from: AuthSessionViewModel.kt */
    @Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 V2\u00020\u0001:\u0001VB£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0007HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000f\u0010M\u001a\b\u0012\u0004\u0012\u00020\t0\u000eHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\tHÆ\u0003J§\u0001\u0010O\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001J\u0013\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020THÖ\u0001J\t\u0010U\u001a\u00020\tHÖ\u0001R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001c\u0010\f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001d\"\u0004\b7\u0010\u001fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001d\"\u0004\b9\u0010\u001fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006W"}, m1599d2 = {"Lcom/dropbox/core/android/internal/AuthSessionViewModel$State;", "", "mHost", "Lcom/dropbox/core/DbxHost;", "result", "Landroid/content/Intent;", "mPKCEManager", "Lcom/dropbox/core/DbxPKCEManager;", "mAuthStateNonce", "", "mAppKey", "mApiType", "mDesiredUid", "mAlreadyAuthedUids", "", "mSessionId", "mTokenAccessType", "Lcom/dropbox/core/TokenAccessType;", "mRequestConfig", "Lcom/dropbox/core/DbxRequestConfig;", "mScope", "mIncludeGrantedScopes", "Lcom/dropbox/core/IncludeGrantedScopes;", "(Lcom/dropbox/core/DbxHost;Landroid/content/Intent;Lcom/dropbox/core/DbxPKCEManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/dropbox/core/TokenAccessType;Lcom/dropbox/core/DbxRequestConfig;Ljava/lang/String;Lcom/dropbox/core/IncludeGrantedScopes;)V", "getMAlreadyAuthedUids", "()Ljava/util/List;", "setMAlreadyAuthedUids", "(Ljava/util/List;)V", "getMApiType", "()Ljava/lang/String;", "setMApiType", "(Ljava/lang/String;)V", "getMAppKey", "setMAppKey", "getMAuthStateNonce", "setMAuthStateNonce", "getMDesiredUid", "setMDesiredUid", "getMHost", "()Lcom/dropbox/core/DbxHost;", "setMHost", "(Lcom/dropbox/core/DbxHost;)V", "getMIncludeGrantedScopes", "()Lcom/dropbox/core/IncludeGrantedScopes;", "setMIncludeGrantedScopes", "(Lcom/dropbox/core/IncludeGrantedScopes;)V", "getMPKCEManager", "()Lcom/dropbox/core/DbxPKCEManager;", "setMPKCEManager", "(Lcom/dropbox/core/DbxPKCEManager;)V", "getMRequestConfig", "()Lcom/dropbox/core/DbxRequestConfig;", "setMRequestConfig", "(Lcom/dropbox/core/DbxRequestConfig;)V", "getMScope", "setMScope", "getMSessionId", "setMSessionId", "getMTokenAccessType", "()Lcom/dropbox/core/TokenAccessType;", "setMTokenAccessType", "(Lcom/dropbox/core/TokenAccessType;)V", "getResult", "()Landroid/content/Intent;", "setResult", "(Landroid/content/Intent;)V", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "android_release"}, m1600k = 1, m1601mv = {1, 6, 0}, m1603xi = 48)
    public static final /* data */ class State {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private List<String> mAlreadyAuthedUids;
        private String mApiType;
        private String mAppKey;
        private String mAuthStateNonce;
        private String mDesiredUid;
        private DbxHost mHost;
        private IncludeGrantedScopes mIncludeGrantedScopes;
        private DbxPKCEManager mPKCEManager;
        private DbxRequestConfig mRequestConfig;
        private String mScope;
        private String mSessionId;
        private TokenAccessType mTokenAccessType;
        private Intent result;

        public State() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, DbxHost dbxHost, Intent intent, DbxPKCEManager dbxPKCEManager, String str, String str2, String str3, String str4, List list, String str5, TokenAccessType tokenAccessType, DbxRequestConfig dbxRequestConfig, String str6, IncludeGrantedScopes includeGrantedScopes, int i, Object obj) {
            if ((i & 1) != 0) {
                dbxHost = state.mHost;
            }
            return state.copy(dbxHost, (i & 2) != 0 ? state.result : intent, (i & 4) != 0 ? state.mPKCEManager : dbxPKCEManager, (i & 8) != 0 ? state.mAuthStateNonce : str, (i & 16) != 0 ? state.mAppKey : str2, (i & 32) != 0 ? state.mApiType : str3, (i & 64) != 0 ? state.mDesiredUid : str4, (i & 128) != 0 ? state.mAlreadyAuthedUids : list, (i & 256) != 0 ? state.mSessionId : str5, (i & 512) != 0 ? state.mTokenAccessType : tokenAccessType, (i & 1024) != 0 ? state.mRequestConfig : dbxRequestConfig, (i & 2048) != 0 ? state.mScope : str6, (i & 4096) != 0 ? state.mIncludeGrantedScopes : includeGrantedScopes);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DbxHost getMHost() {
            return this.mHost;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final TokenAccessType getMTokenAccessType() {
            return this.mTokenAccessType;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final DbxRequestConfig getMRequestConfig() {
            return this.mRequestConfig;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getMScope() {
            return this.mScope;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final IncludeGrantedScopes getMIncludeGrantedScopes() {
            return this.mIncludeGrantedScopes;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Intent getResult() {
            return this.result;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final DbxPKCEManager getMPKCEManager() {
            return this.mPKCEManager;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getMAuthStateNonce() {
            return this.mAuthStateNonce;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getMAppKey() {
            return this.mAppKey;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getMApiType() {
            return this.mApiType;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getMDesiredUid() {
            return this.mDesiredUid;
        }

        public final List<String> component8() {
            return this.mAlreadyAuthedUids;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getMSessionId() {
            return this.mSessionId;
        }

        public final State copy(DbxHost mHost, Intent result, DbxPKCEManager mPKCEManager, String mAuthStateNonce, String mAppKey, String mApiType, String mDesiredUid, List<String> mAlreadyAuthedUids, String mSessionId, TokenAccessType mTokenAccessType, DbxRequestConfig mRequestConfig, String mScope, IncludeGrantedScopes mIncludeGrantedScopes) {
            Intrinsics.checkNotNullParameter(mPKCEManager, "mPKCEManager");
            Intrinsics.checkNotNullParameter(mAlreadyAuthedUids, "mAlreadyAuthedUids");
            return new State(mHost, result, mPKCEManager, mAuthStateNonce, mAppKey, mApiType, mDesiredUid, mAlreadyAuthedUids, mSessionId, mTokenAccessType, mRequestConfig, mScope, mIncludeGrantedScopes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.mHost, state.mHost) && Intrinsics.areEqual(this.result, state.result) && Intrinsics.areEqual(this.mPKCEManager, state.mPKCEManager) && Intrinsics.areEqual(this.mAuthStateNonce, state.mAuthStateNonce) && Intrinsics.areEqual(this.mAppKey, state.mAppKey) && Intrinsics.areEqual(this.mApiType, state.mApiType) && Intrinsics.areEqual(this.mDesiredUid, state.mDesiredUid) && Intrinsics.areEqual(this.mAlreadyAuthedUids, state.mAlreadyAuthedUids) && Intrinsics.areEqual(this.mSessionId, state.mSessionId) && this.mTokenAccessType == state.mTokenAccessType && Intrinsics.areEqual(this.mRequestConfig, state.mRequestConfig) && Intrinsics.areEqual(this.mScope, state.mScope) && this.mIncludeGrantedScopes == state.mIncludeGrantedScopes;
        }

        public int hashCode() {
            DbxHost dbxHost = this.mHost;
            int iHashCode = (dbxHost == null ? 0 : dbxHost.hashCode()) * 31;
            Intent intent = this.result;
            int iHashCode2 = (((iHashCode + (intent == null ? 0 : intent.hashCode())) * 31) + this.mPKCEManager.hashCode()) * 31;
            String str = this.mAuthStateNonce;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.mAppKey;
            int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.mApiType;
            int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.mDesiredUid;
            int iHashCode6 = (((iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.mAlreadyAuthedUids.hashCode()) * 31;
            String str5 = this.mSessionId;
            int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            TokenAccessType tokenAccessType = this.mTokenAccessType;
            int iHashCode8 = (iHashCode7 + (tokenAccessType == null ? 0 : tokenAccessType.hashCode())) * 31;
            DbxRequestConfig dbxRequestConfig = this.mRequestConfig;
            int iHashCode9 = (iHashCode8 + (dbxRequestConfig == null ? 0 : dbxRequestConfig.hashCode())) * 31;
            String str6 = this.mScope;
            int iHashCode10 = (iHashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
            IncludeGrantedScopes includeGrantedScopes = this.mIncludeGrantedScopes;
            return iHashCode10 + (includeGrantedScopes != null ? includeGrantedScopes.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("State(mHost=");
            sb.append(this.mHost).append(", result=").append(this.result).append(", mPKCEManager=").append(this.mPKCEManager).append(", mAuthStateNonce=").append(this.mAuthStateNonce).append(", mAppKey=").append(this.mAppKey).append(", mApiType=").append(this.mApiType).append(", mDesiredUid=").append(this.mDesiredUid).append(", mAlreadyAuthedUids=").append(this.mAlreadyAuthedUids).append(", mSessionId=").append(this.mSessionId).append(", mTokenAccessType=").append(this.mTokenAccessType).append(", mRequestConfig=").append(this.mRequestConfig).append(", mScope=");
            sb.append(this.mScope).append(", mIncludeGrantedScopes=").append(this.mIncludeGrantedScopes).append(')');
            return sb.toString();
        }

        public State(DbxHost dbxHost, Intent intent, DbxPKCEManager mPKCEManager, String str, String str2, String str3, String str4, List<String> mAlreadyAuthedUids, String str5, TokenAccessType tokenAccessType, DbxRequestConfig dbxRequestConfig, String str6, IncludeGrantedScopes includeGrantedScopes) {
            Intrinsics.checkNotNullParameter(mPKCEManager, "mPKCEManager");
            Intrinsics.checkNotNullParameter(mAlreadyAuthedUids, "mAlreadyAuthedUids");
            this.mHost = dbxHost;
            this.result = intent;
            this.mPKCEManager = mPKCEManager;
            this.mAuthStateNonce = str;
            this.mAppKey = str2;
            this.mApiType = str3;
            this.mDesiredUid = str4;
            this.mAlreadyAuthedUids = mAlreadyAuthedUids;
            this.mSessionId = str5;
            this.mTokenAccessType = tokenAccessType;
            this.mRequestConfig = dbxRequestConfig;
            this.mScope = str6;
            this.mIncludeGrantedScopes = includeGrantedScopes;
        }

        public final DbxHost getMHost() {
            return this.mHost;
        }

        public final void setMHost(DbxHost dbxHost) {
            this.mHost = dbxHost;
        }

        public final Intent getResult() {
            return this.result;
        }

        public final void setResult(Intent intent) {
            this.result = intent;
        }

        public /* synthetic */ State(DbxHost dbxHost, Intent intent, DbxPKCEManager dbxPKCEManager, String str, String str2, String str3, String str4, List list, String str5, TokenAccessType tokenAccessType, DbxRequestConfig dbxRequestConfig, String str6, IncludeGrantedScopes includeGrantedScopes, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : dbxHost, (i & 2) != 0 ? null : intent, (i & 4) != 0 ? new DbxPKCEManager() : dbxPKCEManager, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? CollectionsKt.emptyList() : list, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : tokenAccessType, (i & 1024) != 0 ? null : dbxRequestConfig, (i & 2048) != 0 ? null : str6, (i & 4096) != 0 ? null : includeGrantedScopes);
        }

        public final DbxPKCEManager getMPKCEManager() {
            return this.mPKCEManager;
        }

        public final void setMPKCEManager(DbxPKCEManager dbxPKCEManager) {
            Intrinsics.checkNotNullParameter(dbxPKCEManager, "<set-?>");
            this.mPKCEManager = dbxPKCEManager;
        }

        public final String getMAuthStateNonce() {
            return this.mAuthStateNonce;
        }

        public final void setMAuthStateNonce(String str) {
            this.mAuthStateNonce = str;
        }

        public final String getMAppKey() {
            return this.mAppKey;
        }

        public final void setMAppKey(String str) {
            this.mAppKey = str;
        }

        public final String getMApiType() {
            return this.mApiType;
        }

        public final void setMApiType(String str) {
            this.mApiType = str;
        }

        public final String getMDesiredUid() {
            return this.mDesiredUid;
        }

        public final void setMDesiredUid(String str) {
            this.mDesiredUid = str;
        }

        public final List<String> getMAlreadyAuthedUids() {
            return this.mAlreadyAuthedUids;
        }

        public final void setMAlreadyAuthedUids(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.mAlreadyAuthedUids = list;
        }

        public final String getMSessionId() {
            return this.mSessionId;
        }

        public final void setMSessionId(String str) {
            this.mSessionId = str;
        }

        public final TokenAccessType getMTokenAccessType() {
            return this.mTokenAccessType;
        }

        public final void setMTokenAccessType(TokenAccessType tokenAccessType) {
            this.mTokenAccessType = tokenAccessType;
        }

        public final DbxRequestConfig getMRequestConfig() {
            return this.mRequestConfig;
        }

        public final void setMRequestConfig(DbxRequestConfig dbxRequestConfig) {
            this.mRequestConfig = dbxRequestConfig;
        }

        public final String getMScope() {
            return this.mScope;
        }

        public final void setMScope(String str) {
            this.mScope = str;
        }

        public final IncludeGrantedScopes getMIncludeGrantedScopes() {
            return this.mIncludeGrantedScopes;
        }

        public final void setMIncludeGrantedScopes(IncludeGrantedScopes includeGrantedScopes) {
            this.mIncludeGrantedScopes = includeGrantedScopes;
        }

        /* JADX INFO: compiled from: AuthSessionViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/dropbox/core/android/internal/AuthSessionViewModel$State$Companion;", "", "()V", "fromAuthParams", "Lcom/dropbox/core/android/internal/AuthSessionViewModel$State;", "sAuthParams", "Lcom/dropbox/core/android/internal/AuthParameters;", "android_release"}, m1600k = 1, m1601mv = {1, 6, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final State fromAuthParams(AuthParameters sAuthParams) {
                List<String> listEmptyList;
                String sAppKey = sAuthParams != null ? sAuthParams.getSAppKey() : null;
                String sApiType = sAuthParams != null ? sAuthParams.getSApiType() : null;
                String sDesiredUid = sAuthParams != null ? sAuthParams.getSDesiredUid() : null;
                if (sAuthParams == null || (listEmptyList = sAuthParams.getSAlreadyAuthedUids()) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                return new State(sAuthParams != null ? sAuthParams.getSHost() : null, null, null, null, sAppKey, sApiType, sDesiredUid, listEmptyList, sAuthParams != null ? sAuthParams.getSSessionId() : null, sAuthParams != null ? sAuthParams.getSTokenAccessType() : null, sAuthParams != null ? sAuthParams.getSRequestConfig() : null, sAuthParams != null ? sAuthParams.getSScope() : null, sAuthParams != null ? sAuthParams.getSIncludeGrantedScopes() : null, 14, null);
            }
        }
    }

    /* JADX INFO: compiled from: AuthSessionViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, m1599d2 = {"Lcom/dropbox/core/android/internal/AuthSessionViewModel$Companion;", "", "()V", "_state", "Lcom/dropbox/core/android/internal/AuthSessionViewModel$State;", "authInProgress", "", "state", "getState", "()Lcom/dropbox/core/android/internal/AuthSessionViewModel$State;", "endAuthSession", "", "isAuthInProgress", "startAuthSession", "android_release"}, m1600k = 1, m1601mv = {1, 6, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final State getState() {
            return AuthSessionViewModel._state;
        }

        public final boolean isAuthInProgress() {
            return AuthSessionViewModel.authInProgress;
        }

        public final void startAuthSession(State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            AuthSessionViewModel.authInProgress = true;
            AuthSessionViewModel._state = state;
        }

        public final void endAuthSession() {
            AuthSessionViewModel.authInProgress = false;
            AuthSessionViewModel._state = new State(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
        }
    }
}
