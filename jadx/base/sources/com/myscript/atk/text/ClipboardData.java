package com.myscript.atk.text;

import com.myscript.atk.core.MimeType;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class ClipboardData {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ClipboardData(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ClipboardData clipboardData) {
        if (clipboardData == null) {
            return 0L;
        }
        return clipboardData.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKTextJNI.delete_ClipboardData(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static String getCLIPBOARD_BASE_DIR() {
        return new String(ATKTextJNI.ClipboardData_CLIPBOARD_BASE_DIR_get(), StandardCharsets.UTF_8);
    }

    public static String getCLIPBOARD_BASE_NAME() {
        return new String(ATKTextJNI.ClipboardData_CLIPBOARD_BASE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getCLIPBOARD_HTML_DATA_DIR_KEY() {
        return new String(ATKTextJNI.ClipboardData_CLIPBOARD_HTML_DATA_DIR_KEY_get(), StandardCharsets.UTF_8);
    }

    public static String getClipboardFileName(MimeType mimeType) {
        return new String(ATKTextJNI.ClipboardData_getClipboardFileName(mimeType.swigValue()), StandardCharsets.UTF_8);
    }

    public ClipboardData() {
        this(ATKTextJNI.new_ClipboardData(), true);
    }
}
