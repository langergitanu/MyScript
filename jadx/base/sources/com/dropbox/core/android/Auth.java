package com.dropbox.core.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.IncludeGrantedScopes;
import com.dropbox.core.TokenAccessType;
import com.dropbox.core.android.AuthActivity;
import com.dropbox.core.android.internal.DropboxAuthIntent;
import com.dropbox.core.oauth.DbxCredential;
import com.dropbox.core.util.StringUtil;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Auth.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m1599d2 = {"Lcom/dropbox/core/android/Auth;", "", "()V", "Companion", "android_release"}, m1600k = 1, m1601mv = {1, 6, 0}, m1603xi = 48)
public final class Auth {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final DbxCredential getDbxCredential() {
        return INSTANCE.getDbxCredential();
    }

    @JvmStatic
    public static final String getOAuth2Token() {
        return INSTANCE.getOAuth2Token();
    }

    @JvmStatic
    public static final String getScope() {
        return INSTANCE.getScope();
    }

    @JvmStatic
    public static final String getUid() {
        return INSTANCE.getUid();
    }

    @JvmStatic
    public static final void startOAuth2Authentication(Context context, String str) {
        INSTANCE.startOAuth2Authentication(context, str);
    }

    @JvmStatic
    public static final void startOAuth2Authentication(Context context, String str, String str2, String[] strArr, String str3) {
        INSTANCE.startOAuth2Authentication(context, str, str2, strArr, str3);
    }

    @JvmStatic
    public static final void startOAuth2Authentication(Context context, String str, String str2, String[] strArr, String str3, String str4) {
        INSTANCE.startOAuth2Authentication(context, str, str2, strArr, str3, str4);
    }

    @JvmStatic
    public static final void startOAuth2PKCE(Context context, String str, DbxRequestConfig dbxRequestConfig) {
        INSTANCE.startOAuth2PKCE(context, str, dbxRequestConfig);
    }

    @JvmStatic
    public static final void startOAuth2PKCE(Context context, String str, DbxRequestConfig dbxRequestConfig, DbxHost dbxHost) {
        INSTANCE.startOAuth2PKCE(context, str, dbxRequestConfig, dbxHost);
    }

    @JvmStatic
    public static final void startOAuth2PKCE(Context context, String str, DbxRequestConfig dbxRequestConfig, DbxHost dbxHost, Collection<String> collection) {
        INSTANCE.startOAuth2PKCE(context, str, dbxRequestConfig, dbxHost, collection);
    }

    @JvmStatic
    public static final void startOAuth2PKCE(Context context, String str, DbxRequestConfig dbxRequestConfig, DbxHost dbxHost, Collection<String> collection, IncludeGrantedScopes includeGrantedScopes) {
        INSTANCE.startOAuth2PKCE(context, str, dbxRequestConfig, dbxHost, collection, includeGrantedScopes);
    }

    @JvmStatic
    public static final void startOAuth2PKCE(Context context, String str, DbxRequestConfig dbxRequestConfig, Collection<String> collection) {
        INSTANCE.startOAuth2PKCE(context, str, dbxRequestConfig, collection);
    }

    /* JADX INFO: compiled from: Auth.kt */
    @Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\n\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0007JC\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0012JM\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0014J\u008b\u0001\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0012\b\u0002\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010\u001fJ.\u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J@\u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0010\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u001cH\u0007JJ\u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0010\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007J8\u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0012\b\u0002\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u001cH\u0007¨\u0006!"}, m1599d2 = {"Lcom/dropbox/core/android/Auth$Companion;", "", "()V", "getDbxCredential", "Lcom/dropbox/core/oauth/DbxCredential;", "getOAuth2Token", "", "getScope", "getUid", "startOAuth2Authentication", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "appKey", "desiredUid", "alreadyAuthedUids", "", "sessionId", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V", "webHost", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "tokenAccessType", "Lcom/dropbox/core/TokenAccessType;", "requestConfig", "Lcom/dropbox/core/DbxRequestConfig;", DiagnosticsTracker.HOST_KEY, "Lcom/dropbox/core/DbxHost;", "scope", "", "includeGrantedScopes", "Lcom/dropbox/core/IncludeGrantedScopes;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/dropbox/core/TokenAccessType;Lcom/dropbox/core/DbxRequestConfig;Lcom/dropbox/core/DbxHost;Ljava/util/Collection;Lcom/dropbox/core/IncludeGrantedScopes;)V", "startOAuth2PKCE", "android_release"}, m1600k = 1, m1601mv = {1, 6, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void startOAuth2PKCE(Context context, String str, DbxRequestConfig dbxRequestConfig) {
            Intrinsics.checkNotNullParameter(context, "context");
            startOAuth2PKCE$default(this, context, str, dbxRequestConfig, null, 8, null);
        }

        private Companion() {
        }

        @JvmStatic
        public final void startOAuth2Authentication(Context context, String appKey) {
            Intrinsics.checkNotNullParameter(context, "context");
            startOAuth2Authentication(context, appKey, null, null, null);
        }

        @JvmStatic
        public final void startOAuth2Authentication(Context context, String appKey, String desiredUid, String[] alreadyAuthedUids, String sessionId) {
            Intrinsics.checkNotNullParameter(context, "context");
            startOAuth2Authentication(context, appKey, desiredUid, alreadyAuthedUids, sessionId, "www.dropbox.com");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void startOAuth2PKCE$default(Companion companion, Context context, String str, DbxRequestConfig dbxRequestConfig, Collection collection, int i, Object obj) {
            if ((i & 8) != 0) {
                collection = null;
            }
            companion.startOAuth2PKCE(context, str, dbxRequestConfig, (Collection<String>) collection);
        }

        @JvmStatic
        public final void startOAuth2PKCE(Context context, String appKey, DbxRequestConfig requestConfig, Collection<String> scope) {
            Intrinsics.checkNotNullParameter(context, "context");
            startOAuth2PKCE(context, appKey, requestConfig, null, scope);
        }

        @JvmStatic
        public final void startOAuth2PKCE(Context context, String appKey, DbxRequestConfig requestConfig, DbxHost host) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (requestConfig == null) {
                throw new IllegalArgumentException("Invalid Dbx requestConfig for PKCE flow.".toString());
            }
            startOAuth2Authentication$default(this, context, appKey, null, null, null, null, TokenAccessType.OFFLINE, requestConfig, host, null, null, 1536, null);
        }

        @JvmStatic
        public final void startOAuth2PKCE(Context context, String appKey, DbxRequestConfig requestConfig, DbxHost host, Collection<String> scope) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (requestConfig == null) {
                throw new IllegalArgumentException("Invalid Dbx requestConfig for PKCE flow.".toString());
            }
            startOAuth2Authentication(context, appKey, null, null, null, null, TokenAccessType.OFFLINE, requestConfig, host, scope, null);
        }

        @JvmStatic
        public final void startOAuth2PKCE(Context context, String appKey, DbxRequestConfig requestConfig, DbxHost host, Collection<String> scope, IncludeGrantedScopes includeGrantedScopes) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (requestConfig == null) {
                throw new IllegalArgumentException("Invalid Dbx requestConfig for PKCE flow.".toString());
            }
            if (includeGrantedScopes != null && scope == null) {
                throw new IllegalArgumentException("If you are using includeGrantedScope, you must ask for specific new scopes".toString());
            }
            startOAuth2Authentication(context, appKey, null, null, null, null, TokenAccessType.OFFLINE, requestConfig, host, scope, includeGrantedScopes);
        }

        @JvmStatic
        public final void startOAuth2Authentication(Context context, String appKey, String desiredUid, String[] alreadyAuthedUids, String sessionId, String webHost) {
            Intrinsics.checkNotNullParameter(context, "context");
            startOAuth2Authentication$default(this, context, appKey, desiredUid, alreadyAuthedUids, sessionId, webHost, null, null, null, null, null, 1536, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ void startOAuth2Authentication$default(Companion companion, Context context, String str, String str2, String[] strArr, String str3, String str4, TokenAccessType tokenAccessType, DbxRequestConfig dbxRequestConfig, DbxHost dbxHost, Collection collection, IncludeGrantedScopes includeGrantedScopes, int i, Object obj) {
            if ((i & 512) != 0) {
                collection = null;
            }
            if ((i & 1024) != 0) {
                includeGrantedScopes = null;
            }
            companion.startOAuth2Authentication(context, str, str2, strArr, str3, str4, tokenAccessType, dbxRequestConfig, dbxHost, collection, includeGrantedScopes);
        }

        private final void startOAuth2Authentication(Context context, String appKey, String desiredUid, String[] alreadyAuthedUids, String sessionId, String webHost, TokenAccessType tokenAccessType, DbxRequestConfig requestConfig, DbxHost host, Collection<String> scope, IncludeGrantedScopes includeGrantedScopes) {
            String str;
            AuthActivity.Companion companion = AuthActivity.INSTANCE;
            Intrinsics.checkNotNull(appKey);
            if (companion.checkAppBeforeAuth(context, appKey, true)) {
                if (alreadyAuthedUids != null) {
                    str = desiredUid;
                    if (Arrays.asList(Arrays.copyOf(alreadyAuthedUids, alreadyAuthedUids.length)).contains(str)) {
                        throw new IllegalArgumentException("desiredUid cannot be present in alreadyAuthedUids".toString());
                    }
                } else {
                    str = desiredUid;
                }
                Intent intentMakeIntent$android_release = AuthActivity.INSTANCE.makeIntent$android_release(context, appKey, str, alreadyAuthedUids, sessionId, webHost, "1", tokenAccessType, requestConfig, host, scope != null ? StringUtil.join(scope, " ") : null, includeGrantedScopes);
                if (!(context instanceof Activity)) {
                    intentMakeIntent$android_release.addFlags(268435456);
                }
                context.startActivity(intentMakeIntent$android_release);
            }
        }

        @JvmStatic
        public final String getOAuth2Token() {
            DbxCredential dbxCredential = getDbxCredential();
            if (dbxCredential == null) {
                return null;
            }
            return dbxCredential.getAccessToken();
        }

        @JvmStatic
        public final String getUid() {
            if (getDbxCredential() == null) {
                return null;
            }
            Intent intent = AuthActivity.result;
            Intrinsics.checkNotNull(intent);
            return intent.getStringExtra(DropboxAuthIntent.EXTRA_UID);
        }

        @JvmStatic
        public final DbxCredential getDbxCredential() {
            Intent intent = AuthActivity.result;
            if (intent == null) {
                return null;
            }
            String stringExtra = intent.getStringExtra(DropboxAuthIntent.EXTRA_ACCESS_TOKEN);
            String stringExtra2 = intent.getStringExtra(DropboxAuthIntent.EXTRA_ACCESS_SECRET);
            String stringExtra3 = intent.getStringExtra(DropboxAuthIntent.EXTRA_UID);
            if (stringExtra == null || Intrinsics.areEqual("", stringExtra) || stringExtra2 == null || Intrinsics.areEqual("", stringExtra2) || stringExtra3 == null || Intrinsics.areEqual("", stringExtra3)) {
                return null;
            }
            String stringExtra4 = intent.getStringExtra(DropboxAuthIntent.EXTRA_CONSUMER_KEY);
            String stringExtra5 = intent.getStringExtra(DropboxAuthIntent.EXTRA_REFRESH_TOKEN);
            long longExtra = intent.getLongExtra(DropboxAuthIntent.EXTRA_EXPIRES_AT, -1L);
            return new DbxCredential(stringExtra2, longExtra >= 0 ? Long.valueOf(longExtra) : null, stringExtra5, stringExtra4);
        }

        @JvmStatic
        public final String getScope() {
            Intent intent = AuthActivity.result;
            if (intent == null) {
                return null;
            }
            return intent.getStringExtra(DropboxAuthIntent.EXTRA_SCOPE);
        }
    }
}
