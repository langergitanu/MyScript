package com.myscript.atk.text;

import com.myscript.atk.core.SWIGVectorString;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class StyleUtils {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public StyleUtils(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(StyleUtils styleUtils) {
        if (styleUtils == null) {
            return 0L;
        }
        return styleUtils.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKTextJNI.delete_StyleUtils(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static String getTITLE_H1_STYLE_NAME() {
        return new String(ATKTextJNI.StyleUtils_TITLE_H1_STYLE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getTITLE_H2_STYLE_NAME() {
        return new String(ATKTextJNI.StyleUtils_TITLE_H2_STYLE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getTITLE_H3_STYLE_NAME() {
        return new String(ATKTextJNI.StyleUtils_TITLE_H3_STYLE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getBOLD_STYLE_NAME() {
        return new String(ATKTextJNI.StyleUtils_BOLD_STYLE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getUNDERLINE_STYLE_NAME() {
        return new String(ATKTextJNI.StyleUtils_UNDERLINE_STYLE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getDOUBLE_UNDERLINE_STYLE_NAME() {
        return new String(ATKTextJNI.StyleUtils_DOUBLE_UNDERLINE_STYLE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getSTRIKETHROUGH_STYLE_NAME() {
        return new String(ATKTextJNI.StyleUtils_STRIKETHROUGH_STYLE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getHIGHLIGHT_STYLE_NAME() {
        return new String(ATKTextJNI.StyleUtils_HIGHLIGHT_STYLE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getEMPHASIS_1_STYLE_NAME() {
        return new String(ATKTextJNI.StyleUtils_EMPHASIS_1_STYLE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getEMPHASIS_2_STYLE_NAME() {
        return new String(ATKTextJNI.StyleUtils_EMPHASIS_2_STYLE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static List<String> getSTYLE_TYPE_STYLE_CLASSES() {
        long jStyleUtils_STYLE_TYPE_STYLE_CLASSES_get = ATKTextJNI.StyleUtils_STYLE_TYPE_STYLE_CLASSES_get();
        if (jStyleUtils_STYLE_TYPE_STYLE_CLASSES_get == 0) {
            return null;
        }
        return new SWIGVectorString(jStyleUtils_STYLE_TYPE_STYLE_CLASSES_get, false);
    }

    public StyleUtils() {
        this(ATKTextJNI.new_StyleUtils(), true);
    }
}
