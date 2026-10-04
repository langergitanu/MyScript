package com.myscript.atk.core.p020ui.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import com.myscript.atk.core.AssetUtils;
import com.myscript.atk.core.InkStyle;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class FontManager {
    private static final boolean DBG = false;
    private static boolean EnableInterTracking = true;
    private static final String FONTS_FOLDER = "fonts";
    private static final String TAG = "FontManager";
    private static Typeface sTypeface;
    private static final Map<String, String> fontFiles = new HashMap();
    private static final Map<String, Typeface> typefaces = new HashMap();
    private static int sFontStyle = 0;

    private FontManager() {
    }

    public static String getFontPath(InkStyle inkStyle) {
        InkStyleCacheData data = InkStyleCacheData.getData(inkStyle, InkStyleCacheData.FONT_PROPERTIES);
        if (data.updatedCacheFlag == 0) {
            return null;
        }
        return fontFiles.get(data.getFontFamily());
    }

    public static synchronized int getFontStyle(InkStyleCacheData inkStyleCacheData) {
        if (inkStyleCacheData.updatedCacheFlag != 0) {
            boolean zIsItalic = inkStyleCacheData.isItalic();
            boolean zIsBold = inkStyleCacheData.isBold();
            sFontStyle = zIsItalic ? zIsBold ? 3 : 2 : zIsBold ? 1 : 0;
        }
        return sFontStyle;
    }

    public static Typeface getTypeface(String str) {
        return typefaces.get(str);
    }

    public static synchronized Typeface getTypeface(InkStyleCacheData inkStyleCacheData) {
        if (inkStyleCacheData.updatedCacheFlag != 0) {
            String fontFamily = inkStyleCacheData.getFontFamily();
            int fontStyle = getFontStyle(inkStyleCacheData);
            Typeface typeface = getTypeface(fontFamily);
            if (typeface == null) {
                sTypeface = Typeface.create(fontFamily, fontStyle);
            } else if (fontStyle != 0) {
                sTypeface = Typeface.create(typeface, fontStyle);
            } else {
                sTypeface = typeface;
            }
        }
        return sTypeface;
    }

    public static void toggleInterFontTracking() {
        EnableInterTracking = !EnableInterTracking;
    }

    public static float computeLetterSpacing(boolean z, float f) {
        if (EnableInterTracking && z) {
            return (float) ((Math.exp(f * (-0.1745f)) * 0.1850000023841858d) - 0.022299999371170998d);
        }
        return 0.0f;
    }

    public static boolean copyFontAssets(Context context, String str, File file, boolean z) throws IOException {
        return AssetUtils.copyAssetFiles(context, str, Pattern.compile("^(.+)\\.(ttf|otf)$"), file, z);
    }

    public static void registerFont(String str, String str2) {
        Typeface typefaceCreateFromFile;
        Map<String, Typeface> map = typefaces;
        if (map.containsKey(str2) || (typefaceCreateFromFile = Typeface.createFromFile(str)) == null) {
            return;
        }
        fontFiles.put(str2, str);
        map.put(str2, typefaceCreateFromFile);
    }

    public static void initializeFromAssets(Context context) {
        initializeFromAssets(context, FONTS_FOLDER);
    }

    public static void initializeFromAssets(Context context, String str) {
        try {
            for (String str2 : context.getResources().getAssets().list(str)) {
                String str3 = str + File.separatorChar + str2;
                Typeface typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), str3);
                if (typefaceCreateFromAsset != null) {
                    String strSubstring = str2.substring(0, str2.indexOf(46));
                    fontFiles.put(strSubstring, str3);
                    typefaces.put(strSubstring, typefaceCreateFromAsset);
                }
            }
        } catch (IOException e) {
            Log.e(TAG, "Fail to list fonts from " + str, e);
        }
    }
}
