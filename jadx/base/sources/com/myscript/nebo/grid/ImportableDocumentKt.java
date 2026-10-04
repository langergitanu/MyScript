package com.myscript.nebo.grid;

import android.content.Context;
import android.net.Uri;
import com.myscript.nebo.dms.core.FolderPropertiesValidatorKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ImportableDocument.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, m1599d2 = {"classifyImportableDocument", "Lcom/myscript/nebo/grid/ImportableKind;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ImportableDocumentKt {
    public static final ImportableKind classifyImportableDocument(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String strResolveFileName = ImportRequestData.resolveFileName(uri, context, "", null);
        Intrinsics.checkNotNullExpressionValue(strResolveFileName, "resolveFileName(...)");
        if (FolderPropertiesValidatorKt.hasNeboExtension(strResolveFileName)) {
            return ImportableKind.NEBO;
        }
        String mimeTypeForUri = ImportRequestData.getMimeTypeForUri(context, uri);
        if (mimeTypeForUri != null) {
            String[] MIMETYPES_FOR_PDF_IMPORT = ImportRequestData.MIMETYPES_FOR_PDF_IMPORT;
            Intrinsics.checkNotNullExpressionValue(MIMETYPES_FOR_PDF_IMPORT, "MIMETYPES_FOR_PDF_IMPORT");
            if (ArraysKt.contains(MIMETYPES_FOR_PDF_IMPORT, mimeTypeForUri)) {
                return ImportableKind.PDF;
            }
        }
        return StringsKt.endsWith(strResolveFileName, ".pdf", true) ? ImportableKind.PDF : ImportableKind.UNSUPPORTED;
    }
}
