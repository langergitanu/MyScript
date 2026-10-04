package com.google.android.gms.identitycredentials.provider;

import android.app.PendingIntent;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.identitycredentials.CreateCredentialException;
import com.google.android.gms.identitycredentials.CreateCredentialResponse;
import kotlin.Metadata;

/* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, m1599d2 = {"Lcom/google/android/gms/identitycredentials/provider/CreateCredentialCallback;", "", "onConditionalCreateResult", "", "result", "Lcom/google/android/gms/identitycredentials/CreateCredentialResponse;", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "onError", "error", "Lcom/google/android/gms/identitycredentials/CreateCredentialException;", "java.com.google.android.gmscore.integ.client.identity_credentials_identity_credentials"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface CreateCredentialCallback {
    void onConditionalCreateResult(CreateCredentialResponse result, PendingIntent pendingIntent);

    void onError(CreateCredentialException error);
}
