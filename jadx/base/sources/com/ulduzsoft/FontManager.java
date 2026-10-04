package com.ulduzsoft;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class FontManager {
    private static final FilenameFilter FONT_FILEFILTER = new FilenameFilter() { // from class: com.ulduzsoft.FontManager$$ExternalSyntheticLambda0
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return FontManager.lambda$static$0(file, str);
        }
    };

    static /* synthetic */ boolean lambda$static$0(File file, String str) {
        return str.endsWith(".ttf") || str.endsWith(".otf");
    }

    public static Map<String, String> enumerateFonts() {
        String[] strArr = {"/system/fonts", "/system/font", "/data/fonts"};
        HashMap map = new HashMap();
        for (int i = 0; i < 3; i++) {
            enumerateFonts(new File(strArr[i]), map);
        }
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }

    public static void enumerateFonts(File file, Map<String, String> map) {
        File[] fileArrListFiles;
        TTFAnalyzer tTFAnalyzer = new TTFAnalyzer();
        if (file.exists() && (fileArrListFiles = file.listFiles(FONT_FILEFILTER)) != null) {
            for (File file2 : fileArrListFiles) {
                String ttfFontName = tTFAnalyzer.getTtfFontName(file2.getAbsolutePath());
                if (ttfFontName != null) {
                    map.put(file2.getAbsolutePath(), ttfFontName);
                } else {
                    String name = file2.getName();
                    int iLastIndexOf = name.lastIndexOf(46);
                    if (iLastIndexOf != -1) {
                        name = name.substring(0, iLastIndexOf);
                    }
                    map.put(file2.getAbsolutePath(), name);
                }
            }
        }
    }
}
