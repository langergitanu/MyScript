package com.myscript.nebo.grid;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import androidx.media3.common.MimeTypes;
import com.myscript.nebo.dms.util.ImportController;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PdfImporter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/grid/PdfImporter;", "Lcom/myscript/nebo/grid/IPdfImporter;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "workDir", "Ljava/io/File;", "<init>", "(Landroid/app/Application;Ljava/io/File;)V", "importPdf", "Lcom/myscript/nebo/dms/util/ImportController$ImportResult;", "uriToImport", "Landroid/net/Uri;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PdfImporter implements IPdfImporter {
    public static final int $stable = 8;
    private final Application application;
    private final File workDir;

    public PdfImporter(Application application, File workDir) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(workDir, "workDir");
        this.application = application;
        this.workDir = workDir;
    }

    @Override // com.myscript.nebo.grid.IPdfImporter
    public ImportController.ImportResult importPdf(Uri uriToImport) {
        Intrinsics.checkNotNullParameter(uriToImport, "uriToImport");
        String strResolveFileName = ImportRequestData.resolveFileName(uriToImport, this.application, "file.pdf", ImportRequestData.PDF_MIMETYPE);
        Intrinsics.checkNotNullExpressionValue(strResolveFileName, "resolveFileName(...)");
        this.workDir.mkdirs();
        Object obj = this.application;
        Context context = (Context) obj;
        File file = this.workDir;
        TechnicalLoggerProvider technicalLoggerProvider = obj instanceof TechnicalLoggerProvider ? (TechnicalLoggerProvider) obj : null;
        ImportController.ImportResult importResultCopyFile = ImportController.copyFile(context, file, uriToImport, strResolveFileName, technicalLoggerProvider != null ? technicalLoggerProvider.provideTechnicalLogger() : null);
        Intrinsics.checkNotNullExpressionValue(importResultCopyFile, "copyFile(...)");
        return importResultCopyFile;
    }
}
