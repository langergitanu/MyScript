package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public final class BackgroundPatternExt {
    private BackgroundPatternExt() {
    }

    public static String toString(BackgroundPattern backgroundPattern) {
        return ATKCore.patternToString(backgroundPattern);
    }

    public static BackgroundPattern fromString(String str) {
        return ATKCore.patternFromString(str);
    }
}
