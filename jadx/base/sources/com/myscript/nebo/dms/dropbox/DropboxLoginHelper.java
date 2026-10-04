package com.myscript.nebo.dms.dropbox;

import android.content.Context;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.android.Auth;
import com.dropbox.core.oauth.DbxCredential;
import com.myscript.nebo.dms.dropbox.DropboxClient;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class DropboxLoginHelper {
    private static final String CLIENT_IDENTIFIER = "nebo_android";

    public interface SetupCallback {
        void onResult(boolean z, Exception exc);
    }

    public static void login(Context context, String str) {
        Auth.startOAuth2PKCE(context, str, new DbxRequestConfig(CLIENT_IDENTIFIER));
    }

    public static void logout() {
        DropboxClient.destroy();
    }

    public static void setupDropboxClient(DbxCredential dbxCredential, final SetupCallback setupCallback) {
        try {
            DropboxClient.getInstance();
        } catch (IllegalStateException unused) {
            DropboxClient.init(dbxCredential);
        }
        Objects.requireNonNull(setupCallback);
        DropboxClient.isWellConnectedAsync(new DropboxClient.ConnectionCallback() { // from class: com.myscript.nebo.dms.dropbox.DropboxLoginHelper$$ExternalSyntheticLambda0
            @Override // com.myscript.nebo.dms.dropbox.DropboxClient.ConnectionCallback
            public final void onResult(boolean z, Exception exc) {
                setupCallback.onResult(z, exc);
            }
        });
    }
}
