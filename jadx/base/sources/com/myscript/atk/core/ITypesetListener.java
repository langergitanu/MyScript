package com.myscript.atk.core;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface ITypesetListener {
    float getAscent(InkStyle inkStyle);

    List<Rectangle> getCharacterBoundingBoxes(String str, InkStyle inkStyle);

    List<Rectangle> getCharacterBoundingBoxes(String str, List<InkStyle> list, List<SpanInterval> list2);

    float getCharacterDefaultHeight(InkStyle inkStyle, char c);

    String getCustomFontPath(InkStyle inkStyle);

    float getDescender(InkStyle inkStyle);

    float[] getGlyphMetrics(String str, int[] iArr, List<InkStyle> list, List<SpanInterval> list2);

    boolean supportsGlyphMetrics();
}
