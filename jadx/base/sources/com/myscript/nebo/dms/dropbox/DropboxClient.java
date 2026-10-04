package com.myscript.nebo.dms.dropbox;

import android.os.Handler;
import android.os.Looper;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.http.OkHttp3Requestor;
import com.dropbox.core.oauth.DbxCredential;
import com.dropbox.core.p013v2.DbxClientV2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes7.dex */
public class DropboxClient {
    private static DbxCredential sCredential;
    private static final ExecutorService sExecutor = Executors.newSingleThreadExecutor();
    private static final Handler sMainHandler = new Handler(Looper.getMainLooper());
    private static DbxRequestConfig sRequestConfig;
    private static String sToken;

    public interface ConnectionCallback {
        void onResult(boolean z, Exception exc);
    }

    public static void init(String str) {
        sRequestConfig = DbxRequestConfig.newBuilder(DropboxClient.class.getName()).build();
        sToken = str;
    }

    public static void init(DbxCredential dbxCredential) {
        sRequestConfig = DbxRequestConfig.newBuilder(DropboxClient.class.getName()).withHttpRequestor(new OkHttp3Requestor(OkHttp3Requestor.defaultOkHttpClient())).build();
        sCredential = dbxCredential;
    }

    public static void destroy() {
        sRequestConfig = null;
        sToken = null;
        sCredential = null;
    }

    public static DbxClientV2 getInstance() {
        if (hasInstance()) {
            return sCredential != null ? new DbxClientV2(sRequestConfig, sCredential) : new DbxClientV2(sRequestConfig, sToken);
        }
        throw new IllegalStateException("Client not initialized.");
    }

    public static boolean hasInstance() {
        return ((sToken == null && sCredential == null) || sRequestConfig == null) ? false : true;
    }

    public static void isWellConnectedAsync(final ConnectionCallback connectionCallback) {
        sExecutor.execute(new Runnable() { // from class: com.myscript.nebo.dms.dropbox.DropboxClient$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DropboxClient.lambda$isWellConnectedAsync$1(connectionCallback);
            }
        });
    }

    static /* synthetic */ void lambda$isWellConnectedAsync$1(final ConnectionCallback connectionCallback) {
        try {
            z = getInstance().users().getCurrentAccount() != null;
            e = null;
        } catch (Exception e) {
            e = e;
        }
        sMainHandler.post(new Runnable() { // from class: com.myscript.nebo.dms.dropbox.DropboxClient$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                connectionCallback.onResult(z, e);
            }
        });
    }
}
