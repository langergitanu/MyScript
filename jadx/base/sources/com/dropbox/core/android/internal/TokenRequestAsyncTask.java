package com.dropbox.core.android.internal;

import android.os.AsyncTask;
import android.util.Log;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxPKCEManager;
import com.dropbox.core.DbxRequestConfig;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TokenRequestAsyncTask.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00122\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ'\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0010\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0011R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m1599d2 = {"Lcom/dropbox/core/android/internal/TokenRequestAsyncTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "Lcom/dropbox/core/DbxAuthFinish;", "code", "", "mPKCEManager", "Lcom/dropbox/core/DbxPKCEManager;", "requestConfig", "Lcom/dropbox/core/DbxRequestConfig;", "appKey", DiagnosticsTracker.HOST_KEY, "Lcom/dropbox/core/DbxHost;", "(Ljava/lang/String;Lcom/dropbox/core/DbxPKCEManager;Lcom/dropbox/core/DbxRequestConfig;Ljava/lang/String;Lcom/dropbox/core/DbxHost;)V", "doInBackground", "params", "", "([Ljava/lang/Void;)Lcom/dropbox/core/DbxAuthFinish;", "Companion", "android_release"}, m1600k = 1, m1601mv = {1, 6, 0}, m1603xi = 48)
public final class TokenRequestAsyncTask extends AsyncTask<Void, Void, DbxAuthFinish> {
    private static final String TAG;
    private final String appKey;
    private final String code;
    private final DbxHost host;
    private final DbxPKCEManager mPKCEManager;
    private final DbxRequestConfig requestConfig;

    public TokenRequestAsyncTask(String code, DbxPKCEManager mPKCEManager, DbxRequestConfig requestConfig, String appKey, DbxHost host) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(mPKCEManager, "mPKCEManager");
        Intrinsics.checkNotNullParameter(requestConfig, "requestConfig");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(host, "host");
        this.code = code;
        this.mPKCEManager = mPKCEManager;
        this.requestConfig = requestConfig;
        this.appKey = appKey;
        this.host = host;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public DbxAuthFinish doInBackground(Void... params) {
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            return this.mPKCEManager.makeTokenRequest(this.requestConfig, this.code, this.appKey, null, this.host);
        } catch (DbxException e) {
            Log.e(TAG, "Token Request Failed: " + e.getMessage());
            return null;
        }
    }

    static {
        Intrinsics.checkNotNullExpressionValue("TokenRequestAsyncTask", "TokenRequestAsyncTask::class.java.simpleName");
        TAG = "TokenRequestAsyncTask";
    }
}
