package com.myscript.android.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignatureUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"getApkSigners", "", "Landroid/content/pm/Signature;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)[Landroid/content/pm/Signature;", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SignatureUtilsKt {
    public static final Signature[] getApkSigners(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                SigningInfo signingInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 134217728).signingInfo;
                if (signingInfo != null && signingInfo.hasMultipleSigners()) {
                    SigningInfo signingInfo2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 134217728).signingInfo;
                    if (signingInfo2 != null) {
                        return signingInfo2.getApkContentsSigners();
                    }
                    return null;
                }
                SigningInfo signingInfo3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 134217728).signingInfo;
                if (signingInfo3 != null) {
                    return signingInfo3.getSigningCertificateHistory();
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }
}
