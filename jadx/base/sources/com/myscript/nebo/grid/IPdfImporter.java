package com.myscript.nebo.grid;

import android.net.Uri;
import com.myscript.nebo.dms.util.ImportController;
import kotlin.Metadata;

/* JADX INFO: compiled from: PdfImporter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/grid/IPdfImporter;", "", "importPdf", "Lcom/myscript/nebo/dms/util/ImportController$ImportResult;", "uriToImport", "Landroid/net/Uri;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface IPdfImporter {
    ImportController.ImportResult importPdf(Uri uriToImport);
}
