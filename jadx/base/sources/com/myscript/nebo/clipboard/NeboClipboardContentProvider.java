package com.myscript.nebo.clipboard;

import android.content.ClipDescription;
import android.net.Uri;
import android.text.TextUtils;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.myscript.atk.core.MimeType;
import com.myscript.atk.text.ClipboardData;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class NeboClipboardContentProvider extends ClipboardContentProvider {
    public static final String NEBO_CLIPBOARD_MIMETYPE = "application/com.myscript.nebo.clipdata";

    @Override // com.myscript.nebo.clipboard.ClipboardContentProvider, android.content.ContentProvider
    public String getType(Uri uri) {
        File fileForUri = this.mStrategy.getFileForUri(uri);
        if (TextUtils.equals(ClipboardData.getCLIPBOARD_BASE_DIR(), fileForUri.getParentFile().getName())) {
            if (TextUtils.equals(ClipboardData.getClipboardFileName(MimeType.NEBO), fileForUri.getName())) {
                return NEBO_CLIPBOARD_MIMETYPE;
            }
        }
        return super.getType(uri);
    }

    @Override // com.myscript.nebo.clipboard.ClipboardContentProvider, android.content.ContentProvider
    public String[] getStreamTypes(Uri uri, String str) {
        ClipDescription clipDescription;
        if (uri.toString().endsWith(ClipboardData.getCLIPBOARD_BASE_DIR() + DomExceptionUtils.SEPARATOR + ClipboardData.getClipboardFileName(MimeType.NEBO))) {
            clipDescription = new ClipDescription(null, new String[]{NEBO_CLIPBOARD_MIMETYPE});
        } else if (ClipboardContentProvider.ALL_FILTER.equals(str)) {
            String[] streamTypes = super.getStreamTypes(uri, str);
            int length = streamTypes.length;
            String[] strArr = new String[length + 1];
            System.arraycopy(streamTypes, 0, strArr, 0, length);
            strArr[length] = NEBO_CLIPBOARD_MIMETYPE;
            clipDescription = new ClipDescription(null, strArr);
        } else {
            return super.getStreamTypes(uri, str);
        }
        return clipDescription.filterMimeTypes(str);
    }
}
