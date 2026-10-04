package androidx.webkit.internal;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;

/* JADX INFO: loaded from: classes3.dex */
public class ApiHelperForTiramisu {
    private ApiHelperForTiramisu() {
    }

    /* JADX INFO: renamed from: of */
    static PackageManager.ComponentInfoFlags m334of(long j) {
        return PackageManager.ComponentInfoFlags.of(j);
    }

    static ServiceInfo getServiceInfo(PackageManager packageManager, ComponentName componentName, PackageManager.ComponentInfoFlags componentInfoFlags) throws PackageManager.NameNotFoundException {
        return packageManager.getServiceInfo(componentName, componentInfoFlags);
    }
}
