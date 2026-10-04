package com.myscript.nebo.dms.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.nebo.clipboard.ClipboardContentProvider;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.snt.core.NotebookKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes7.dex */
public final class ImportController {
    private static final boolean DEBUG = false;
    private static final String TAG = "ImportController";

    public enum ImportStatus {
        OK,
        KO_NO_URI,
        KO_IMPORT_IMPOSSIBLE,
        KO_EMPTY,
        KO_UNREADABLE
    }

    public static class ImportResult {
        public final File file;
        public NotebookKey notebookKey;
        public ImportStatus status;

        ImportResult(ImportStatus importStatus) {
            this(importStatus, null);
        }

        ImportResult(ImportStatus importStatus, File file) {
            this.status = importStatus;
            this.file = file;
        }

        public boolean isSuccess() {
            return this.status == ImportStatus.OK && this.file != null;
        }
    }

    private ImportController() {
    }

    /* JADX WARN: Removed duplicated region for block: B:105:? A[Catch: IOException -> 0x0068, DONT_GENERATE, FINALLY_INSNS, SYNTHETIC, TRY_LEAVE, TryCatch #4 {IOException -> 0x0068, blocks: (B:10:0x0027, B:20:0x0049, B:38:0x0067, B:37:0x0064, B:33:0x005e, B:11:0x002b, B:18:0x0044, B:29:0x0059, B:28:0x0056), top: B:90:0x0027, inners: #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ImportResult copyFile(Context context, File file, Uri uri, String str, TechnicalLogger technicalLogger) {
        ImportStatus importStatus;
        FileOutputStream fileOutputStream;
        if (uri == null) {
            return new ImportResult(ImportStatus.KO_NO_URI);
        }
        file.mkdirs();
        File file2 = new File(file, str);
        if (file2.isFile()) {
            file2.delete();
        }
        ImportStatus importStatus2 = ImportStatus.KO_EMPTY;
        ContentResolver contentResolver = context.getContentResolver();
        if (isVirtualFile(context, uri, contentResolver, technicalLogger)) {
            try {
                InputStream inputStreamForVirtualFile = getInputStreamForVirtualFile(uri, contentResolver);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } finally {
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStreamForVirtualFile.read(bArr);
                        if (i <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                    fileOutputStream.flush();
                    importStatus = ImportStatus.OK;
                    fileOutputStream.close();
                    if (inputStreamForVirtualFile != null) {
                        inputStreamForVirtualFile.close();
                    }
                } finally {
                }
            } catch (IOException e) {
                Log.e(TAG, "error while copying virtual file", e);
                importStatus = ImportStatus.KO_IMPORT_IMPOSSIBLE;
                file2.delete();
            }
        } else if (isSupportedScheme(uri)) {
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
                try {
                    FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                    try {
                        FileChannel channel = fileInputStream.getChannel();
                        long size = channel.size();
                        if (size > 0) {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                            try {
                                channel.transferTo(0L, size, fileOutputStream2.getChannel());
                                ImportStatus importStatus3 = ImportStatus.OK;
                                fileOutputStream2.close();
                                importStatus2 = importStatus3;
                            } finally {
                            }
                        }
                        fileInputStream.close();
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        }
                        importStatus = importStatus2;
                    } finally {
                    }
                } finally {
                    return new ImportResult(importStatus, file2);
                }
            } catch (Exception unused) {
                importStatus = ImportStatus.KO_IMPORT_IMPOSSIBLE;
                file2.delete();
            }
        } else {
            importStatus = ImportStatus.KO_IMPORT_IMPOSSIBLE;
        }
        return new ImportResult(importStatus, file2);
    }

    private static boolean isVirtualFile(Context context, Uri uri, ContentResolver contentResolver, TechnicalLogger technicalLogger) {
        if (!DocumentsContract.isDocumentUri(context, uri)) {
            return false;
        }
        Cursor cursorQuery = contentResolver.query(uri, new String[]{"flags"}, null, null, null);
        if (cursorQuery == null) {
            if (technicalLogger != null) {
                technicalLogger.logError(new RuntimeException("Content resolver query result is null with uri = " + uri));
            }
            return false;
        }
        int i = cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        cursorQuery.close();
        return (i & 512) != 0;
    }

    private static InputStream getInputStreamForVirtualFile(Uri uri, ContentResolver contentResolver) throws IOException {
        String[] streamTypes = contentResolver.getStreamTypes(uri, ClipboardContentProvider.ALL_FILTER);
        if (streamTypes == null || streamTypes.length < 1) {
            throw new FileNotFoundException();
        }
        return contentResolver.openTypedAssetFileDescriptor(uri, streamTypes[0], null).createInputStream();
    }

    private static boolean isSupportedScheme(Uri uri) {
        String scheme = uri.getScheme();
        return "file".equals(scheme) || FirebaseAnalytics.Param.CONTENT.equals(scheme);
    }
}
