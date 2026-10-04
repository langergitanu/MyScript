package com.myscript.nebo.dms.core;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import androidx.media3.common.MimeTypes;
import com.myscript.nebo.dms.util.ImportController;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import java.io.File;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NeboFileImporter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/NeboFileImporter;", "Lcom/myscript/nebo/dms/core/INeboFileImporter;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "workingDir", "Ljava/io/File;", "<init>", "(Landroid/app/Application;Ljava/io/File;)V", "getApplication", "()Landroid/app/Application;", "importNeboFile", "Lcom/myscript/nebo/dms/util/ImportController$ImportResult;", "importUri", "Landroid/net/Uri;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NeboFileImporter implements INeboFileImporter {
    public static final int $stable = 8;
    private final Application application;
    private final File workingDir;

    public NeboFileImporter(Application application, File workingDir) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(workingDir, "workingDir");
        this.application = application;
        this.workingDir = workingDir;
    }

    public final Application getApplication() {
        return this.application;
    }

    @Override // com.myscript.nebo.dms.core.INeboFileImporter
    public ImportController.ImportResult importNeboFile(Uri importUri) {
        Intrinsics.checkNotNullParameter(importUri, "importUri");
        String str = UUID.randomUUID() + ".nebo";
        Object obj = this.application;
        Context context = (Context) obj;
        File file = this.workingDir;
        TechnicalLoggerProvider technicalLoggerProvider = obj instanceof TechnicalLoggerProvider ? (TechnicalLoggerProvider) obj : null;
        ImportController.ImportResult importResultCopyFile = ImportController.copyFile(context, file, importUri, str, technicalLoggerProvider != null ? technicalLoggerProvider.provideTechnicalLogger() : null);
        Intrinsics.checkNotNullExpressionValue(importResultCopyFile, "copyFile(...)");
        return importResultCopyFile;
    }
}
