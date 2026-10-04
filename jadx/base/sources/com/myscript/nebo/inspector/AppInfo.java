package com.myscript.nebo.inspector;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.core.content.p005pm.PackageInfoCompat;
import androidx.media3.common.MimeTypes;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InspectorInformation.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/inspector/AppInfo;", "", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "firstInstallTime", "", "getFirstInstallTime", "()Ljava/lang/String;", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "getPackageName", "versionName", "getVersionName", "versionCode", "", "getVersionCode", "()J", "nebo-inspector_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AppInfo {
    private final String firstInstallTime;
    private final String packageName;
    private final long versionCode;
    private final String versionName;

    public AppInfo(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        PackageManager packageManager = application.getPackageManager();
        PackageInfo packageInfo = packageManager != null ? packageManager.getPackageInfo(application.getPackageName(), 0) : null;
        if (packageInfo != null) {
            String str = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US).format(Long.valueOf(packageInfo.firstInstallTime));
            Intrinsics.checkNotNullExpressionValue(str, "with(...)");
            this.firstInstallTime = str;
            String packageName = packageInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
            this.packageName = packageName;
            String str2 = packageInfo.versionName;
            this.versionName = str2 == null ? "" : str2;
            this.versionCode = PackageInfoCompat.getLongVersionCode(packageInfo);
            return;
        }
        this.firstInstallTime = "n/a";
        this.packageName = "n/a";
        this.versionName = "n/a";
        this.versionCode = 0L;
    }

    public final String getFirstInstallTime() {
        return this.firstInstallTime;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final long getVersionCode() {
        return this.versionCode;
    }
}
