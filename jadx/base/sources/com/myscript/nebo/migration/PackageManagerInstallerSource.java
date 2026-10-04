package com.myscript.nebo.migration;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InstallerPackageSource.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/migration/PackageManagerInstallerSource;", "Lcom/myscript/nebo/migration/InstallerPackageSource;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "installerPackage", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PackageManagerInstallerSource implements InstallerPackageSource {
    public static final int $stable = 8;
    private final Context context;

    public PackageManagerInstallerSource(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.myscript.nebo.migration.InstallerPackageSource
    public String installerPackage() {
        Object objM14499constructorimpl;
        String installerPackageName;
        try {
            Result.Companion companion = Result.INSTANCE;
            PackageManagerInstallerSource packageManagerInstallerSource = this;
            PackageManager packageManager = this.context.getPackageManager();
            if (Build.VERSION.SDK_INT >= 30) {
                installerPackageName = packageManager.getInstallSourceInfo(this.context.getPackageName()).getInstallingPackageName();
            } else {
                installerPackageName = packageManager.getInstallerPackageName(this.context.getPackageName());
            }
            objM14499constructorimpl = Result.m14499constructorimpl(installerPackageName);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m14505isFailureimpl(objM14499constructorimpl)) {
            objM14499constructorimpl = null;
        }
        return (String) objM14499constructorimpl;
    }
}
