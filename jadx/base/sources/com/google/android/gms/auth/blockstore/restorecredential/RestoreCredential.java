package com.google.android.gms.auth.blockstore.restorecredential;

import android.content.Context;
import com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-blockstore@@16.4.0 */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, m1599d2 = {"Lcom/google/android/gms/auth/blockstore/restorecredential/RestoreCredential;", "", "<init>", "()V", "getRestoreCredentialClient", "Lcom/google/android/gms/auth/blockstore/restorecredential/RestoreCredentialClient;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "java.com.google.android.gmscore.integ.client.auth_blockstore_client_auth_blockstore"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class RestoreCredential {
    public static final RestoreCredential INSTANCE = new RestoreCredential();

    private RestoreCredential() {
    }

    @JvmStatic
    public static final RestoreCredentialClient getRestoreCredentialClient(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new InternalRestoreCredentialClient(context);
    }
}
