package com.myscript.atk.core.p020ui.utils;

import android.content.Context;
import android.util.Log;
import com.ulduzsoft.FontManager;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TypefaceUtils {
    private static final String TAG = "TypefaceUtils";

    public static void loadFonts(Context context, String str, boolean z) {
        for (Map.Entry<String, String> entry : getFonts(context, str, z).entrySet()) {
            FontManager.registerFont(entry.getKey(), entry.getValue());
        }
    }

    private static Map<String, String> getFonts(Context context, String str, boolean z) {
        File file = new File(context.getFilesDir(), "fonts");
        HashMap map = new HashMap();
        try {
            FontManager.copyFontAssets(context, str, file, z);
            FontManager.enumerateFonts(file, map);
            return map;
        } catch (IOException e) {
            Log.e(TAG, "Unable to copy fonts for " + str, e);
            return map;
        }
    }
}
