package com.dropbox.core.android.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import com.dropbox.core.DbxSdkVersion;
import com.dropbox.core.IncludeGrantedScopes;
import com.dropbox.core.TokenAccessType;
import com.dropbox.core.android.AuthActivity;
import com.dropbox.core.android.internal.AuthSessionViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DropboxAuthIntent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u001e*\u00020\u001f¢\u0006\u0002\u0010 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006!"}, m1599d2 = {"Lcom/dropbox/core/android/internal/DropboxAuthIntent;", "", "()V", "EXTRA_ACCESS_SECRET", "", "EXTRA_ACCESS_TOKEN", "EXTRA_ALREADY_AUTHED_UIDS", "EXTRA_AUTH_QUERY_PARAMS", "EXTRA_AUTH_STATE", "EXTRA_CALLING_CLASS", "EXTRA_CALLING_PACKAGE", "EXTRA_CONSUMER_KEY", "EXTRA_CONSUMER_SIG", "EXTRA_DESIRED_UID", "EXTRA_DROPBOX_SDK_JAVA_VERSION", "EXTRA_EXPIRES_AT", "EXTRA_REFRESH_TOKEN", "EXTRA_SCOPE", "EXTRA_SESSION_ID", "EXTRA_TARGET_SDK_VERSION", "EXTRA_UID", "buildActionAuthenticateIntent", "Landroid/content/Intent;", "buildOfficialAuthIntent", "mState", "Lcom/dropbox/core/android/internal/AuthSessionViewModel$State;", "stateNonce", "authActivity", "Lcom/dropbox/core/android/AuthActivity;", "getTargetSdkVersion", "", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Integer;", "android_release"}, m1600k = 1, m1601mv = {1, 6, 0}, m1603xi = 48)
public final class DropboxAuthIntent {
    public static final String EXTRA_ACCESS_SECRET = "ACCESS_SECRET";
    public static final String EXTRA_ACCESS_TOKEN = "ACCESS_TOKEN";
    public static final String EXTRA_ALREADY_AUTHED_UIDS = "ALREADY_AUTHED_UIDS";
    public static final String EXTRA_AUTH_QUERY_PARAMS = "AUTH_QUERY_PARAMS";
    public static final String EXTRA_AUTH_STATE = "AUTH_STATE";
    public static final String EXTRA_CALLING_CLASS = "CALLING_CLASS";
    public static final String EXTRA_CALLING_PACKAGE = "CALLING_PACKAGE";
    public static final String EXTRA_CONSUMER_KEY = "CONSUMER_KEY";
    public static final String EXTRA_CONSUMER_SIG = "CONSUMER_SIG";
    public static final String EXTRA_DESIRED_UID = "DESIRED_UID";
    public static final String EXTRA_DROPBOX_SDK_JAVA_VERSION = "DROPBOX_SDK_JAVA_VERSION";
    public static final String EXTRA_EXPIRES_AT = "EXPIRES_AT";
    public static final String EXTRA_REFRESH_TOKEN = "REFRESH_TOKEN";
    public static final String EXTRA_SCOPE = "SCOPE";
    public static final String EXTRA_SESSION_ID = "SESSION_ID";
    public static final String EXTRA_TARGET_SDK_VERSION = "TARGET_SDK_VERSION";
    public static final String EXTRA_UID = "UID";
    public static final DropboxAuthIntent INSTANCE = new DropboxAuthIntent();

    private DropboxAuthIntent() {
    }

    public final Intent buildActionAuthenticateIntent() {
        Intent intent = new Intent(AuthActivity.ACTION_AUTHENTICATE_V2);
        intent.setPackage("com.dropbox.android");
        return intent;
    }

    public final Integer getTargetSdkVersion(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "packageManager.getPackageInfo(packageName, 0)");
            return Integer.valueOf(packageInfo.applicationInfo.targetSdkVersion);
        } catch (Exception unused) {
            return null;
        }
    }

    public final Intent buildOfficialAuthIntent(AuthSessionViewModel.State mState, String stateNonce, AuthActivity authActivity) {
        Intrinsics.checkNotNullParameter(mState, "mState");
        Intrinsics.checkNotNullParameter(stateNonce, "stateNonce");
        Intrinsics.checkNotNullParameter(authActivity, "authActivity");
        String name = authActivity.getClass().getName();
        String packageName = authActivity.getPackageName();
        Intent intentBuildActionAuthenticateIntent = buildActionAuthenticateIntent();
        intentBuildActionAuthenticateIntent.putExtra(EXTRA_CONSUMER_KEY, mState.getMAppKey());
        intentBuildActionAuthenticateIntent.putExtra(EXTRA_CONSUMER_SIG, "");
        intentBuildActionAuthenticateIntent.putExtra(EXTRA_CALLING_CLASS, name);
        intentBuildActionAuthenticateIntent.putExtra(EXTRA_DESIRED_UID, mState.getMDesiredUid());
        Object[] array = mState.getMAlreadyAuthedUids().toArray(new String[0]);
        if (array != null) {
            intentBuildActionAuthenticateIntent.putExtra(EXTRA_ALREADY_AUTHED_UIDS, (String[]) array);
            intentBuildActionAuthenticateIntent.putExtra(EXTRA_SESSION_ID, mState.getMSessionId());
            intentBuildActionAuthenticateIntent.putExtra(EXTRA_CALLING_PACKAGE, packageName);
            intentBuildActionAuthenticateIntent.putExtra(EXTRA_AUTH_STATE, stateNonce);
            intentBuildActionAuthenticateIntent.putExtra(EXTRA_DROPBOX_SDK_JAVA_VERSION, DbxSdkVersion.Version);
            Integer targetSdkVersion = INSTANCE.getTargetSdkVersion(authActivity);
            if (targetSdkVersion != null) {
                intentBuildActionAuthenticateIntent.putExtra(EXTRA_TARGET_SDK_VERSION, targetSdkVersion.intValue());
            }
            if (mState.getMTokenAccessType() != null) {
                QueryParamsUtil queryParamsUtil = QueryParamsUtil.INSTANCE;
                TokenAccessType mTokenAccessType = mState.getMTokenAccessType();
                String mScope = mState.getMScope();
                IncludeGrantedScopes mIncludeGrantedScopes = mState.getMIncludeGrantedScopes();
                String codeChallenge = mState.getMPKCEManager().getCodeChallenge();
                Intrinsics.checkNotNullExpressionValue(codeChallenge, "mState.mPKCEManager.codeChallenge");
                intentBuildActionAuthenticateIntent.putExtra(EXTRA_AUTH_QUERY_PARAMS, queryParamsUtil.createExtraQueryParams$android_release(mTokenAccessType, mScope, mIncludeGrantedScopes, codeChallenge));
            }
            return intentBuildActionAuthenticateIntent;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
