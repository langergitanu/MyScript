package com.myscript.nebo.editing.impl.keyboard;

import android.util.Pair;
import com.myscript.atk.core.TextImpl;

/* JADX INFO: loaded from: classes7.dex */
public abstract class KeyboardUtils {
    private static final boolean DBG = false;
    private static final String TAG = "KeyboardUtils";

    static int charIndexFromGraphemeIndex(String str, int i) {
        return charIndexFromGraphemeIndex(new TextImpl(str), i);
    }

    private static int charIndexFromGraphemeIndex(TextImpl textImpl, int i) {
        return i >= 0 ? textImpl.getGlyphUtf16BeginAt(i) : i;
    }

    static Pair<Integer, Integer> charIndexFromGraphemeIndex(String str, int i, int i2) {
        TextImpl textImpl = new TextImpl(str);
        return new Pair<>(Integer.valueOf(charIndexFromGraphemeIndex(textImpl, i)), Integer.valueOf(charIndexFromGraphemeIndex(textImpl, i2)));
    }

    static int graphemeIndexFromCharIndex(String str, int i) {
        return graphemeIndexFromCharIndex(new TextImpl(str), i);
    }

    private static int graphemeIndexFromCharIndex(TextImpl textImpl, int i) {
        return i >= 0 ? textImpl.getGlyphIndexUtf16At(i) : i;
    }

    static Pair<Integer, Integer> graphemeIndexFromCharIndex(String str, int i, int i2) {
        TextImpl textImpl = new TextImpl(str);
        return new Pair<>(Integer.valueOf(graphemeIndexFromCharIndex(textImpl, i)), Integer.valueOf(graphemeIndexFromCharIndex(textImpl, i2)));
    }
}
