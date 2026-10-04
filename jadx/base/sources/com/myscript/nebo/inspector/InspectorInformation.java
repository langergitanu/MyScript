package com.myscript.nebo.inspector;

import android.app.Application;
import android.os.LocaleList;
import androidx.media3.common.MimeTypes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InspectorInformation.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, m1599d2 = {"Lcom/myscript/nebo/inspector/InspectorInformation;", "", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "files", "", "Lcom/myscript/nebo/inspector/NeboFile;", "stats", "Lcom/myscript/nebo/inspector/Stats;", "<init>", "(Landroid/app/Application;Ljava/util/List;Lcom/myscript/nebo/inspector/Stats;)V", "getFiles", "()Ljava/util/List;", "getStats", "()Lcom/myscript/nebo/inspector/Stats;", "inspectionTime", "", "getInspectionTime", "()Ljava/lang/String;", "locales", "Ljava/util/Locale;", "getLocales", "appInfo", "Lcom/myscript/nebo/inspector/AppInfo;", "getAppInfo", "()Lcom/myscript/nebo/inspector/AppInfo;", "deviceInfo", "Lcom/myscript/nebo/inspector/DeviceInfo;", "getDeviceInfo", "()Lcom/myscript/nebo/inspector/DeviceInfo;", "nebo-inspector_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InspectorInformation {
    private final AppInfo appInfo;
    private final DeviceInfo deviceInfo;
    private final List<NeboFile> files;
    private final String inspectionTime;
    private final List<Locale> locales;
    private final Stats stats;

    public InspectorInformation(Application application, List<NeboFile> files, Stats stats) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(files, "files");
        Intrinsics.checkNotNullParameter(stats, "stats");
        this.files = files;
        this.stats = stats;
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US).format(Long.valueOf(System.currentTimeMillis()));
        Intrinsics.checkNotNullExpressionValue(str, "with(...)");
        this.inspectionTime = str;
        ArrayList arrayList = new ArrayList();
        LocaleList localeList = LocaleList.getDefault();
        Intrinsics.checkNotNullExpressionValue(localeList, "getDefault(...)");
        int size = localeList.size();
        for (int i = 0; i < size; i++) {
            Locale locale = localeList.get(i);
            Intrinsics.checkNotNullExpressionValue(locale, "get(...)");
            arrayList.add(locale);
        }
        this.locales = arrayList;
        this.appInfo = new AppInfo(application);
        this.deviceInfo = new DeviceInfo();
    }

    public final List<NeboFile> getFiles() {
        return this.files;
    }

    public final Stats getStats() {
        return this.stats;
    }

    public final String getInspectionTime() {
        return this.inspectionTime;
    }

    public final List<Locale> getLocales() {
        return this.locales;
    }

    public final AppInfo getAppInfo() {
        return this.appInfo;
    }

    public final DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }
}
