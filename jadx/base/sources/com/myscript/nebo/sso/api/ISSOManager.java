package com.myscript.nebo.sso.api;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: SSOManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001:\u0006-./012J\u000e\u0010\u000e\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u000fJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H¦@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001bH&J\u001c\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u001fH&J$\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010#H&J\u001c\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010#H&J\u0014\u0010&\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010'H'J\u001a\u0010(\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010'H¦@¢\u0006\u0002\u0010)J \u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H¦@¢\u0006\u0002\u0010\u0014J\u000e\u0010,\u001a\u00020\u0017H¦@¢\u0006\u0002\u0010\u000fR\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\t¨\u00063À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/ISSOManager;", "", "customHeaders", "", "", "getCustomHeaders", "()Ljava/util/Map;", "privacyPolicyUpdateUrl", "getPrivacyPolicyUpdateUrl", "()Ljava/lang/String;", "privacyPolicyAcceptedUrl", "getPrivacyPolicyAcceptedUrl", "privacyPolicyRejectedUrl", "getPrivacyPolicyRejectedUrl", "buildAuthorizeUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startNativeLoginWithGoogle", "", "googleIdToken", "origin", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLogoutEndpoint", "reSendEmail", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/myscript/nebo/sso/api/ISSOManager$OnResendEmailListener;", "addLoginListener", "Lcom/myscript/nebo/sso/api/ISSOManager$OnLoginListener;", "removeLoginListener", "saveShareMyNotesSetting", "shareWithMyScript", "Lcom/myscript/nebo/sso/api/ISSOManager$OnShareSavedListener;", "saveDropboxCredential", "clientId", "refreshToken", "Lcom/myscript/nebo/sso/api/ISSOManager$OnProviderTokenSaved;", "saveGDriveAuthToken", "authToken", "getAccountAsync", "Lcom/myscript/nebo/sso/api/ISSOManager$OnAccountReceivedListener;", "fetchAccount", "(Lcom/myscript/nebo/sso/api/ISSOManager$OnAccountReceivedListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "code", "logout", "OnLoginListener", "OnAccountReceivedListener", "OnShareSavedListener", "OnProviderTokenSaved", "OnResendEmailListener", "Provider", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface ISSOManager {

    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/ISSOManager$OnAccountReceivedListener;", "", "onAccountReceived", "", "onTokenInvalid", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface OnAccountReceivedListener {
        void onAccountReceived();

        void onTokenInvalid();
    }

    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/ISSOManager$OnLoginListener;", "", "onLogin", "", "onLogout", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface OnLoginListener {
        void onLogin();

        void onLogout();
    }

    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/ISSOManager$OnProviderTokenSaved;", "", "onProviderTokenSaved", "", FirebaseAnalytics.Param.SUCCESS, "", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface OnProviderTokenSaved {
        void onProviderTokenSaved(boolean success);
    }

    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/ISSOManager$OnResendEmailListener;", "", "onResult", "", FirebaseAnalytics.Param.SUCCESS, "", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface OnResendEmailListener {
        void onResult(boolean success);
    }

    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/ISSOManager$OnShareSavedListener;", "", "onShareSaved", "", FirebaseAnalytics.Param.SUCCESS, "", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface OnShareSavedListener {
        void onShareSaved(boolean success);
    }

    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/ISSOManager$Provider;", "", "provideSSOManager", "Lcom/myscript/nebo/sso/api/ISSOManager;", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        ISSOManager provideSSOManager();
    }

    void addLoginListener(OnLoginListener listener);

    Object buildAuthorizeUrl(Continuation<? super String> continuation);

    Object fetchAccount(OnAccountReceivedListener onAccountReceivedListener, Continuation<? super Unit> continuation);

    @Deprecated(message = "Use suspendable function getAccount instead")
    void getAccountAsync(OnAccountReceivedListener listener);

    Map<String, String> getCustomHeaders();

    Object getLogoutEndpoint(Continuation<? super String> continuation);

    String getPrivacyPolicyAcceptedUrl();

    String getPrivacyPolicyRejectedUrl();

    String getPrivacyPolicyUpdateUrl();

    Object login(String str, String str2, Continuation<? super Unit> continuation);

    Object logout(Continuation<? super Unit> continuation);

    void reSendEmail(OnResendEmailListener listener);

    void removeLoginListener(OnLoginListener listener);

    void saveDropboxCredential(String clientId, String refreshToken, OnProviderTokenSaved listener);

    void saveGDriveAuthToken(String authToken, OnProviderTokenSaved listener);

    void saveShareMyNotesSetting(boolean shareWithMyScript, OnShareSavedListener listener);

    Object startNativeLoginWithGoogle(String str, String str2, Continuation<? super Boolean> continuation);

    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void reSendEmail$default(ISSOManager iSSOManager, OnResendEmailListener onResendEmailListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reSendEmail");
        }
        if ((i & 1) != 0) {
            onResendEmailListener = null;
        }
        iSSOManager.reSendEmail(onResendEmailListener);
    }

    static /* synthetic */ void saveShareMyNotesSetting$default(ISSOManager iSSOManager, boolean z, OnShareSavedListener onShareSavedListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveShareMyNotesSetting");
        }
        if ((i & 2) != 0) {
            onShareSavedListener = null;
        }
        iSSOManager.saveShareMyNotesSetting(z, onShareSavedListener);
    }

    static /* synthetic */ void saveDropboxCredential$default(ISSOManager iSSOManager, String str, String str2, OnProviderTokenSaved onProviderTokenSaved, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveDropboxCredential");
        }
        if ((i & 4) != 0) {
            onProviderTokenSaved = null;
        }
        iSSOManager.saveDropboxCredential(str, str2, onProviderTokenSaved);
    }

    static /* synthetic */ void saveGDriveAuthToken$default(ISSOManager iSSOManager, String str, OnProviderTokenSaved onProviderTokenSaved, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveGDriveAuthToken");
        }
        if ((i & 2) != 0) {
            onProviderTokenSaved = null;
        }
        iSSOManager.saveGDriveAuthToken(str, onProviderTokenSaved);
    }

    static /* synthetic */ void getAccountAsync$default(ISSOManager iSSOManager, OnAccountReceivedListener onAccountReceivedListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAccountAsync");
        }
        if ((i & 1) != 0) {
            onAccountReceivedListener = null;
        }
        iSSOManager.getAccountAsync(onAccountReceivedListener);
    }

    static /* synthetic */ Object fetchAccount$default(ISSOManager iSSOManager, OnAccountReceivedListener onAccountReceivedListener, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchAccount");
        }
        if ((i & 1) != 0) {
            onAccountReceivedListener = null;
        }
        return iSSOManager.fetchAccount(onAccountReceivedListener, continuation);
    }
}
