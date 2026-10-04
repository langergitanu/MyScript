package com.dropbox.core.android;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxPKCEManager;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.IncludeGrantedScopes;
import com.dropbox.core.TokenAccessType;
import com.dropbox.core.android.DbxOfficialAppConnector;
import com.dropbox.core.android.internal.AuthParameters;
import com.dropbox.core.android.internal.AuthSessionViewModel;
import com.dropbox.core.android.internal.AuthUtils;
import com.dropbox.core.android.internal.DropboxAuthIntent;
import com.dropbox.core.android.internal.QueryParamsUtil;
import com.dropbox.core.android.internal.TokenRequestAsyncTask;
import com.dropbox.core.android.internal.TokenType;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.security.SecureRandom;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0014J\b\u0010\u0012\u001a\u00020\nH\u0014J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u001a"}, m1599d2 = {"Lcom/dropbox/core/android/AuthActivity;", "Landroid/app/Activity;", "()V", "mActivityDispatchHandlerPosted", "", "mState", "Lcom/dropbox/core/android/internal/AuthSessionViewModel$State;", "getMState", "()Lcom/dropbox/core/android/internal/AuthSessionViewModel$State;", "authFinished", "", "authResult", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "onResume", "onTopResumedActivityChanged", "onTop", "startWebAuth", "state", "", "Companion", "SecurityProvider", "android_release"}, m1600k = 1, m1601mv = {1, 6, 0}, m1603xi = 48)
public class AuthActivity extends Activity {
    public static final String ACTION_AUTHENTICATE_V1 = "com.dropbox.android.AUTHENTICATE_V1";
    public static final String ACTION_AUTHENTICATE_V2 = "com.dropbox.android.AUTHENTICATE_V2";
    public static final String AUTH_PATH_CONNECT = "/connect";
    public static final int AUTH_VERSION = 1;
    public static Intent result;
    private static AuthParameters sAuthParams;
    private boolean mActivityDispatchHandlerPosted;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = AuthActivity.class.getName();
    private static SecurityProvider sSecurityProvider = new SecurityProvider() { // from class: com.dropbox.core.android.AuthActivity$Companion$sSecurityProvider$1
        @Override // com.dropbox.core.android.AuthActivity.SecurityProvider
        public SecureRandom getSecureRandom() {
            return new SecureRandom();
        }
    };
    private static final Object sSecurityProviderLock = new Object();

    /* JADX INFO: compiled from: AuthActivity.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/dropbox/core/android/AuthActivity$SecurityProvider;", "", "secureRandom", "Ljava/security/SecureRandom;", "getSecureRandom", "()Ljava/security/SecureRandom;", "android_release"}, m1600k = 1, m1601mv = {1, 6, 0}, m1603xi = 48)
    public interface SecurityProvider {
        SecureRandom getSecureRandom();
    }

    @Deprecated(message = "Use Methods in com.dropbox.core.android.Auth, This will be removed in future versions.")
    @JvmStatic
    public static final boolean checkAppBeforeAuth(Context context, String str, boolean z) {
        return INSTANCE.checkAppBeforeAuth(context, str, z);
    }

    @Deprecated(message = "Use Methods in com.dropbox.core.android.Auth, This will be removed in future versions.")
    @JvmStatic
    public static final Intent makeIntent(Context context, String str, String str2, String str3) {
        return INSTANCE.makeIntent(context, str, str2, str3);
    }

    @Deprecated(message = "Use Methods in com.dropbox.core.android.Auth. This will be removed in future versions.")
    @JvmStatic
    public static final Intent makeIntent(Context context, String str, String str2, String[] strArr, String str3, String str4, String str5) {
        return INSTANCE.makeIntent(context, str, str2, strArr, str3, str4, str5);
    }

    @JvmStatic
    public static final void setSecurityProvider(SecurityProvider securityProvider) {
        INSTANCE.setSecurityProvider(securityProvider);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        if (!AuthSessionViewModel.INSTANCE.isAuthInProgress()) {
            AuthSessionViewModel.INSTANCE.startAuthSession(AuthSessionViewModel.State.INSTANCE.fromAuthParams(sAuthParams));
        }
        setTheme(R.style.Theme.Translucent.NoTitleBar);
        super.onCreate(savedInstanceState);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT < 29) {
            onTopResumedActivityChanged(true);
        }
    }

    private final AuthSessionViewModel.State getMState() {
        return AuthSessionViewModel.INSTANCE.getState();
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean onTop) {
        final String strCreateStateNonce;
        if (isFinishing() || !onTop) {
            return;
        }
        if (getMState().getMAuthStateNonce() != null || getMState().getMAppKey() == null) {
            authFinished(null);
            return;
        }
        Companion companion = INSTANCE;
        result = null;
        if (this.mActivityDispatchHandlerPosted) {
            Log.w(TAG, "onResume called again before Handler run");
            return;
        }
        if (getMState().getMTokenAccessType() != null) {
            String codeChallenge = getMState().getMPKCEManager().getCodeChallenge();
            Intrinsics.checkNotNullExpressionValue(codeChallenge, "mState.mPKCEManager.codeChallenge");
            strCreateStateNonce = AuthUtils.createPKCEStateNonce(codeChallenge, String.valueOf(getMState().getMTokenAccessType()), getMState().getMScope(), getMState().getMIncludeGrantedScopes());
        } else {
            strCreateStateNonce = AuthUtils.createStateNonce(companion.getSecurityProvider());
        }
        final Intent intentBuildOfficialAuthIntent = DropboxAuthIntent.INSTANCE.buildOfficialAuthIntent(getMState(), strCreateStateNonce, this);
        runOnUiThread(new Runnable() { // from class: com.dropbox.core.android.AuthActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AuthActivity.m12443onTopResumedActivityChanged$lambda0(this.f$0, intentBuildOfficialAuthIntent, strCreateStateNonce);
            }
        });
        this.mActivityDispatchHandlerPosted = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onTopResumedActivityChanged$lambda-0, reason: not valid java name */
    public static final void m12443onTopResumedActivityChanged$lambda0(AuthActivity this$0, Intent officialAuthIntent, String stateNonce) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(officialAuthIntent, "$officialAuthIntent");
        Intrinsics.checkNotNullParameter(stateNonce, "$stateNonce");
        Log.d(TAG, "running startActivity in handler");
        try {
            DbxOfficialAppConnector.Companion companion = DbxOfficialAppConnector.INSTANCE;
            Context applicationContext = this$0.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            if (companion.getDropboxAppPackage$android_release(applicationContext, officialAuthIntent) != null) {
                this$0.startActivity(officialAuthIntent);
            } else {
                this$0.startWebAuth(stateNonce);
            }
            this$0.getMState().setMAuthStateNonce(stateNonce);
        } catch (ActivityNotFoundException e) {
            Log.e(TAG, "Could not launch intent. User may have restricted profile", e);
            this$0.finish();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a5  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onNewIntent(Intent intent) {
        String queryParameter;
        String queryParameter2;
        String str;
        String str2;
        String queryParameter3;
        String queryParameter4;
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intent intent2 = null;
        if (getMState().getMAuthStateNonce() == null) {
            authFinished(null);
            return;
        }
        if (intent.hasExtra(DropboxAuthIntent.EXTRA_ACCESS_TOKEN)) {
            queryParameter2 = intent.getStringExtra(DropboxAuthIntent.EXTRA_ACCESS_TOKEN);
            queryParameter3 = intent.getStringExtra(DropboxAuthIntent.EXTRA_ACCESS_SECRET);
            queryParameter4 = intent.getStringExtra(DropboxAuthIntent.EXTRA_UID);
            queryParameter = intent.getStringExtra(DropboxAuthIntent.EXTRA_AUTH_STATE);
        } else {
            Uri data = intent.getData();
            if (data == null || !Intrinsics.areEqual(AUTH_PATH_CONNECT, data.getPath())) {
                queryParameter = null;
                queryParameter2 = null;
                str = null;
                str2 = null;
            } else {
                try {
                    queryParameter2 = data.getQueryParameter("oauth_token");
                    try {
                        queryParameter3 = data.getQueryParameter("oauth_token_secret");
                        try {
                            queryParameter4 = data.getQueryParameter("uid");
                        } catch (UnsupportedOperationException unused) {
                            queryParameter4 = null;
                        }
                    } catch (UnsupportedOperationException unused2) {
                        queryParameter3 = null;
                        queryParameter4 = queryParameter3;
                        String str3 = queryParameter4;
                        str2 = queryParameter3;
                        str = str3;
                        queryParameter = null;
                        if (queryParameter2 != null) {
                        }
                        authFinished(intent2);
                    }
                } catch (UnsupportedOperationException unused3) {
                    queryParameter2 = null;
                    queryParameter3 = null;
                }
                try {
                    queryParameter = data.getQueryParameter("state");
                } catch (UnsupportedOperationException unused4) {
                    String str32 = queryParameter4;
                    str2 = queryParameter3;
                    str = str32;
                    queryParameter = null;
                }
            }
            if (queryParameter2 != null && !Intrinsics.areEqual(queryParameter2, "") && str2 != null && !Intrinsics.areEqual(str2, "") && str != null && !Intrinsics.areEqual(str, "") && queryParameter != null && !Intrinsics.areEqual(queryParameter, "")) {
                if (Intrinsics.areEqual(getMState().getMAuthStateNonce(), queryParameter)) {
                    authFinished(null);
                    return;
                }
                if (Intrinsics.areEqual(queryParameter2, TokenType.OAUTH2.getString())) {
                    intent2 = new Intent();
                    intent2.putExtra(DropboxAuthIntent.EXTRA_ACCESS_TOKEN, queryParameter2);
                    intent2.putExtra(DropboxAuthIntent.EXTRA_ACCESS_SECRET, str2);
                    intent2.putExtra(DropboxAuthIntent.EXTRA_UID, str);
                } else if (Intrinsics.areEqual(queryParameter2, TokenType.OAUTH2CODE.getString())) {
                    DbxPKCEManager mPKCEManager = getMState().getMPKCEManager();
                    DbxRequestConfig mRequestConfig = getMState().getMRequestConfig();
                    Intrinsics.checkNotNull(mRequestConfig);
                    String mAppKey = getMState().getMAppKey();
                    Intrinsics.checkNotNull(mAppKey);
                    DbxHost mHost = getMState().getMHost();
                    Intrinsics.checkNotNull(mHost);
                    try {
                        DbxAuthFinish dbxAuthFinish = new TokenRequestAsyncTask(str2, mPKCEManager, mRequestConfig, mAppKey, mHost).execute(new Void[0]).get();
                        if (dbxAuthFinish != null) {
                            Intent intent3 = new Intent();
                            intent3.putExtra(DropboxAuthIntent.EXTRA_ACCESS_TOKEN, dbxAuthFinish.getAccessToken());
                            intent3.putExtra(DropboxAuthIntent.EXTRA_ACCESS_SECRET, dbxAuthFinish.getAccessToken());
                            intent3.putExtra(DropboxAuthIntent.EXTRA_REFRESH_TOKEN, dbxAuthFinish.getRefreshToken());
                            Long expiresAt = dbxAuthFinish.getExpiresAt();
                            Intrinsics.checkNotNullExpressionValue(expiresAt, "dbxAuthFinish.expiresAt");
                            intent3.putExtra(DropboxAuthIntent.EXTRA_EXPIRES_AT, expiresAt.longValue());
                            intent3.putExtra(DropboxAuthIntent.EXTRA_UID, dbxAuthFinish.getUserId());
                            intent3.putExtra(DropboxAuthIntent.EXTRA_CONSUMER_KEY, getMState().getMAppKey());
                            intent3.putExtra(DropboxAuthIntent.EXTRA_SCOPE, dbxAuthFinish.getScope());
                            intent2 = intent3;
                        }
                    } catch (Exception unused5) {
                    }
                }
            }
            authFinished(intent2);
        }
        String str4 = queryParameter4;
        str2 = queryParameter3;
        str = str4;
        if (queryParameter2 != null) {
            if (Intrinsics.areEqual(getMState().getMAuthStateNonce(), queryParameter)) {
            }
        }
        authFinished(intent2);
    }

    private final void authFinished(Intent authResult) {
        result = authResult;
        AuthSessionViewModel.INSTANCE.endAuthSession();
        finish();
    }

    private final void startWebAuth(String state) {
        Locale locale = Locale.getDefault();
        Locale locale2 = new Locale(locale.getLanguage(), locale.getCountry());
        List listMutableListOf = CollectionsKt.mutableListOf("k", getMState().getMAppKey(), "n", !getMState().getMAlreadyAuthedUids().isEmpty() ? getMState().getMAlreadyAuthedUids().get(0) : "0", "api", getMState().getMApiType(), "state", state);
        if (getMState().getMTokenAccessType() != null) {
            listMutableListOf.add("extra_query_params");
            QueryParamsUtil queryParamsUtil = QueryParamsUtil.INSTANCE;
            TokenAccessType mTokenAccessType = getMState().getMTokenAccessType();
            String mScope = getMState().getMScope();
            IncludeGrantedScopes mIncludeGrantedScopes = getMState().getMIncludeGrantedScopes();
            String codeChallenge = getMState().getMPKCEManager().getCodeChallenge();
            Intrinsics.checkNotNullExpressionValue(codeChallenge, "mState.mPKCEManager.codeChallenge");
            listMutableListOf.add(queryParamsUtil.createExtraQueryParams$android_release(mTokenAccessType, mScope, mIncludeGrantedScopes, codeChallenge));
        }
        String string = locale2.toString();
        DbxHost mHost = getMState().getMHost();
        Intrinsics.checkNotNull(mHost);
        String web = mHost.getWeb();
        Object[] array = listMutableListOf.toArray(new String[0]);
        if (array != null) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(DbxRequestUtil.buildUrlWithParams(string, web, "1/connect", (String[]) array))));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    /* JADX INFO: compiled from: AuthActivity.kt */
    @Metadata(m1598d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0013H\u0007J\b\u0010\u0018\u001a\u00020\u0010H\u0002JY\u0010\u0019\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010 J\u008d\u0001\u0010\u0019\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010\u00042\b\u0010(\u001a\u0004\u0018\u00010)H\u0000¢\u0006\u0004\b*\u0010+J0\u0010\u0019\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0007J/\u0010,\u001a\u00020-2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010.J9\u0010,\u001a\u00020-2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010/JC\u0010,\u001a\u00020-2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u00100J\u0083\u0001\u0010,\u001a\u00020-2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010\u00042\b\u0010(\u001a\u0004\u0018\u00010)H\u0000¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, m1599d2 = {"Lcom/dropbox/core/android/AuthActivity$Companion;", "", "()V", "ACTION_AUTHENTICATE_V1", "", "ACTION_AUTHENTICATE_V2", "AUTH_PATH_CONNECT", "AUTH_VERSION", "", "TAG", "kotlin.jvm.PlatformType", "result", "Landroid/content/Intent;", "sAuthParams", "Lcom/dropbox/core/android/internal/AuthParameters;", "sSecurityProvider", "Lcom/dropbox/core/android/AuthActivity$SecurityProvider;", "sSecurityProviderLock", "checkAppBeforeAuth", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "appKey", "alertUser", "getSecurityProvider", "makeIntent", "desiredUid", "alreadyAuthedUids", "", "sessionId", "webHost", "apiType", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "tokenAccessType", "Lcom/dropbox/core/TokenAccessType;", "requestConfig", "Lcom/dropbox/core/DbxRequestConfig;", DiagnosticsTracker.HOST_KEY, "Lcom/dropbox/core/DbxHost;", "scope", "includeGrantedScopes", "Lcom/dropbox/core/IncludeGrantedScopes;", "makeIntent$android_release", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/dropbox/core/TokenAccessType;Lcom/dropbox/core/DbxRequestConfig;Lcom/dropbox/core/DbxHost;Ljava/lang/String;Lcom/dropbox/core/IncludeGrantedScopes;)Landroid/content/Intent;", "setAuthParams", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "setAuthParams$android_release", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/dropbox/core/TokenAccessType;Lcom/dropbox/core/DbxRequestConfig;Lcom/dropbox/core/DbxHost;Ljava/lang/String;Lcom/dropbox/core/IncludeGrantedScopes;)V", "setSecurityProvider", "prov", "android_release"}, m1600k = 1, m1601mv = {1, 6, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void setAuthParams(String appKey, String desiredUid, String[] alreadyAuthedUids) {
            setAuthParams(appKey, desiredUid, alreadyAuthedUids, null);
        }

        public final void setAuthParams(String appKey, String desiredUid, String[] alreadyAuthedUids, String webHost, String apiType) {
            setAuthParams$android_release(appKey, desiredUid, alreadyAuthedUids, null, null, null, null, null, null, null, null);
        }

        public final void setAuthParams(String appKey, String desiredUid, String[] alreadyAuthedUids, String sessionId) {
            setAuthParams$android_release(appKey, desiredUid, alreadyAuthedUids, sessionId, null, null, null, null, null, null, null);
        }

        public final void setAuthParams$android_release(String appKey, String desiredUid, String[] alreadyAuthedUids, String sessionId, String webHost, String apiType, TokenAccessType tokenAccessType, DbxRequestConfig requestConfig, DbxHost host, String scope, IncludeGrantedScopes includeGrantedScopes) {
            List listEmptyList;
            DbxHost dbxHost;
            if (alreadyAuthedUids == null || (listEmptyList = ArraysKt.toList(alreadyAuthedUids)) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            List list = listEmptyList;
            if (host != null) {
                dbxHost = host;
            } else if (webHost != null) {
                dbxHost = new DbxHost(DbxHost.DEFAULT.getApi(), DbxHost.DEFAULT.getContent(), webHost, DbxHost.DEFAULT.getNotify());
            } else {
                dbxHost = DbxHost.DEFAULT;
            }
            AuthActivity.sAuthParams = new AuthParameters(appKey, apiType, desiredUid, list, sessionId, tokenAccessType, requestConfig, dbxHost, scope, includeGrantedScopes);
        }

        @Deprecated(message = "Use Methods in com.dropbox.core.android.Auth, This will be removed in future versions.")
        @JvmStatic
        public final Intent makeIntent(Context context, String appKey, String webHost, String apiType) {
            return makeIntent$android_release(context, appKey, null, null, null, webHost, apiType, null, null, null, null, null);
        }

        @Deprecated(message = "Use Methods in com.dropbox.core.android.Auth. This will be removed in future versions.")
        @JvmStatic
        public final Intent makeIntent(Context context, String appKey, String desiredUid, String[] alreadyAuthedUids, String sessionId, String webHost, String apiType) {
            if (appKey == null) {
                throw new IllegalArgumentException("'appKey' can't be null".toString());
            }
            setAuthParams$android_release(appKey, desiredUid, alreadyAuthedUids, sessionId, webHost, apiType, null, null, null, null, null);
            return new Intent(context, (Class<?>) AuthActivity.class);
        }

        public final Intent makeIntent$android_release(Context context, String appKey, String desiredUid, String[] alreadyAuthedUids, String sessionId, String webHost, String apiType, TokenAccessType tokenAccessType, DbxRequestConfig requestConfig, DbxHost host, String scope, IncludeGrantedScopes includeGrantedScopes) {
            if (appKey == null) {
                throw new IllegalArgumentException("'appKey' can't be null".toString());
            }
            setAuthParams$android_release(appKey, desiredUid, alreadyAuthedUids, sessionId, webHost, apiType, tokenAccessType, requestConfig, host, scope, includeGrantedScopes);
            return new Intent(context, (Class<?>) AuthActivity.class);
        }

        @Deprecated(message = "Use Methods in com.dropbox.core.android.Auth, This will be removed in future versions.")
        @JvmStatic
        public final boolean checkAppBeforeAuth(Context context, String appKey, boolean alertUser) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(appKey, "appKey");
            Intent intent = new Intent("android.intent.action.VIEW");
            String str = "db-" + appKey;
            intent.setData(Uri.parse(str + "://1/connect"));
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "pm.queryIntentActivities(testIntent, 0)");
            if (listQueryIntentActivities.size() == 0) {
                throw new IllegalStateException(("URI scheme in your app's manifest is not set up correctly. You should have a " + AuthActivity.class.getName() + " with the scheme: " + str).toString());
            }
            if (listQueryIntentActivities.size() <= 1) {
                ResolveInfo resolveInfo = listQueryIntentActivities.get(0);
                if ((resolveInfo != null ? resolveInfo.activityInfo : null) == null || !Intrinsics.areEqual(context.getPackageName(), resolveInfo.activityInfo.packageName)) {
                    throw new IllegalStateException(("There must be a " + AuthActivity.class.getName() + " within your app's package registered for your URI scheme (" + str + "). However, it appears that an activity in a different package is registered for that scheme instead. If you have multiple apps that all want to use the same accesstoken pair, designate one of them to do authentication and have the other apps launch it and then retrieve the token pair from it.").toString());
                }
                return true;
            }
            if (alertUser) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Security alert");
                builder.setMessage("Another app on your phone may be trying to pose as the app you are currently using. The malicious app can't access your account, but linking to Dropbox has been disabled as a precaution. Please contact support@dropbox.com.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.dropbox.core.android.AuthActivity$Companion$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            } else {
                Log.w(AuthActivity.TAG, "There are multiple apps registered for the AuthActivity URI scheme (" + str + ").  Another app may be trying to  impersonate this app, so authentication will be disabled.");
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SecurityProvider getSecurityProvider() {
            SecurityProvider securityProvider;
            synchronized (AuthActivity.sSecurityProviderLock) {
                securityProvider = AuthActivity.sSecurityProvider;
            }
            return securityProvider;
        }

        @JvmStatic
        public final void setSecurityProvider(SecurityProvider prov) {
            Intrinsics.checkNotNullParameter(prov, "prov");
            synchronized (AuthActivity.sSecurityProviderLock) {
                Companion companion = AuthActivity.INSTANCE;
                AuthActivity.sSecurityProvider = prov;
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
