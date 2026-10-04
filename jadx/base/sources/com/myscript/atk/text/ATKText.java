package com.myscript.atk.text;

import com.myscript.atk.core.SWIGVectorString;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ATKText {
    protected static byte[] getBytesUTF8(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (Exception unused) {
            throw new RuntimeException("UTF8 Not supported");
        }
    }

    public static List<String> getStyleTypeDecorationLabels() {
        long jStyleTypeDecorationLabels_get = ATKTextJNI.StyleTypeDecorationLabels_get();
        if (jStyleTypeDecorationLabels_get == 0) {
            return null;
        }
        return new SWIGVectorString(jStyleTypeDecorationLabels_get, false);
    }

    public static float getHANDLE_TOUCH_ATTRACTION() {
        return ATKTextJNI.HANDLE_TOUCH_ATTRACTION_get();
    }

    public static float getHANDLE_PEN_ATTRACTION() {
        return ATKTextJNI.HANDLE_PEN_ATTRACTION_get();
    }
}
