package com.myscript.nebo.grid;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.documentfile.provider.DocumentFile;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes7.dex */
public class ImportRequestData {
    static String APPLICATION_MIMETYPE = "application/*";
    static String DOCX_MIMETYPE = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
    static String GOOGLE_DOC_MIMETYPE = "application/vnd.google-apps.document";
    static String GOOGLE_PRES_MIMETYPE = "application/vnd.google-apps.presentation";
    static String PDF_MIMETYPE = "application/pdf";
    static String PPTX_MIMETYPE = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
    public static final String REQUESTED_URI = "REQUESTED_URI";
    private final String mFallbackMimeType;
    private final Uri mRequestedUri;
    public static final String[] MIMETYPES_FOR_PDF_IMPORT = {"application/pdf", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "application/vnd.google-apps.document", "application/vnd.google-apps.presentation"};
    public static final String[] MIMETYPES_FOR_NEBO_IMPORT = {"application/*"};
    public static final String[] MIMETYPES_FOR_IMPORT = {"application/pdf", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "application/vnd.google-apps.document", "application/vnd.google-apps.presentation", "application/octet-stream", "application/zip"};

    public static String getMimeTypeForUri(Context context, Uri uri) {
        return getMimeType(context, uri, null);
    }

    public static ImportRequestData fromUri(Uri uri) {
        try {
            return new ImportRequestData(uri);
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static ImportRequestData fromIntent(Context context, Intent intent) {
        String action;
        if (intent == null) {
            return null;
        }
        try {
            action = intent.getAction();
        } catch (NullPointerException unused) {
        }
        if ("android.intent.action.VIEW".equals(action)) {
            return fromUri(intent.getData());
        }
        if ("android.intent.action.SEND".equals(action)) {
            ClipData clipData = intent.getClipData();
            if (clipData != null) {
                return new ImportRequestData(context, clipData);
            }
            if (intent.hasExtra("android.intent.extra.STREAM")) {
                return fromUri((Uri) intent.getParcelableExtra("android.intent.extra.STREAM"));
            }
        }
        return null;
    }

    public static ImportRequestData fromBundle(Bundle bundle) {
        if (bundle != null) {
            return fromUri((Uri) bundle.getParcelable(REQUESTED_URI));
        }
        return null;
    }

    private ImportRequestData(Context context, ClipData clipData) {
        ContentResolver contentResolver = context.getContentResolver();
        for (int i = 0; i < clipData.getItemCount(); i++) {
            Uri uri = clipData.getItemAt(i).getUri();
            if (uri != null) {
                String type = contentResolver.getType(uri);
                if (type == null && clipData.getDescription().getMimeTypeCount() > i) {
                    type = clipData.getDescription().getMimeType(i);
                }
                ArrayList arrayList = new ArrayList(Arrays.asList(MIMETYPES_FOR_NEBO_IMPORT));
                arrayList.addAll(Arrays.asList(MIMETYPES_FOR_PDF_IMPORT));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (ClipDescription.compareMimeTypes(type, (String) it.next())) {
                        this.mRequestedUri = uri;
                        this.mFallbackMimeType = type;
                        return;
                    }
                }
            }
        }
        throw null;
    }

    private ImportRequestData(Uri uri) {
        uri.getClass();
        this.mRequestedUri = uri;
        this.mFallbackMimeType = null;
    }

    public Uri getUri() {
        return this.mRequestedUri;
    }

    public String getMimeType(Context context) {
        return getMimeType(context, this.mRequestedUri, this.mFallbackMimeType);
    }

    private static String getMimeType(Context context, Uri uri, String str) {
        String scheme = uri.getScheme();
        String type = null;
        if ("file".equals(scheme)) {
            DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(context, uri);
            String type2 = documentFileFromSingleUri != null ? documentFileFromSingleUri.getType() : null;
            if (type2 == null) {
                try {
                    String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(new URL(uri.toString()).toString());
                    if (fileExtensionFromUrl != null) {
                        type2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
                    }
                    type = type2;
                } catch (MalformedURLException unused) {
                }
            } else {
                type = type2;
            }
        } else {
            if (!FirebaseAnalytics.Param.CONTENT.equals(scheme)) {
                return null;
            }
            type = context.getContentResolver().getType(uri);
        }
        return type != null ? type : str;
    }

    public Bundle getBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(REQUESTED_URI, this.mRequestedUri);
        return bundle;
    }

    public String toString() {
        return "ImportRequestData: Uri=" + this.mRequestedUri;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0080 A[Catch: Exception -> 0x00b6, TRY_LEAVE, TryCatch #1 {Exception -> 0x00b6, blocks: (B:10:0x0029, B:42:0x0080, B:39:0x007c, B:38:0x0079, B:34:0x0073, B:12:0x002f, B:14:0x0035, B:16:0x003d, B:19:0x0045, B:21:0x004b, B:23:0x0053, B:25:0x0059, B:27:0x005f, B:29:0x0068), top: B:59:0x0029, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String resolveFileName(Uri uri, Context context, String str, String str2) {
        Uri uri2;
        String string;
        if (uri != null) {
            String scheme = uri.getScheme();
            if ("file".equals(scheme)) {
                string = uri.getLastPathSegment();
                uri2 = uri;
            } else if (FirebaseAnalytics.Param.CONTENT.equals(scheme)) {
                uri2 = uri;
                try {
                    Cursor cursorQuery = context.getContentResolver().query(uri2, null, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                int columnIndex = cursorQuery.getColumnIndex("_display_name");
                                string = columnIndex >= 0 ? cursorQuery.getString(columnIndex) : null;
                                if (string == null || string.isEmpty()) {
                                    int columnIndex2 = cursorQuery.getColumnIndex("_data");
                                    if (columnIndex2 >= 0 && (string = cursorQuery.getString(columnIndex2)) != null && !string.isEmpty()) {
                                        int iLastIndexOf = string.lastIndexOf(47);
                                        if (iLastIndexOf != -1) {
                                            string = string.substring(iLastIndexOf + 1);
                                        }
                                    }
                                }
                                if (cursorQuery != null) {
                                }
                            } else {
                                string = null;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                            }
                        } finally {
                        }
                    }
                } catch (Exception unused) {
                }
            } else {
                uri2 = uri;
                string = null;
            }
            if (!TextUtils.isEmpty(string)) {
                String mimeType = getMimeType(context, uri2, str2);
                return (GOOGLE_DOC_MIMETYPE.equals(mimeType) || GOOGLE_PRES_MIMETYPE.equals(mimeType)) ? string + ".pdf" : string;
            }
        }
        return str;
    }
}
