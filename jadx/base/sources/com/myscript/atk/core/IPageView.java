package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public interface IPageView<T, U> {
    void colorInversionPolicyChanged(IColorInversionPolicy iColorInversionPolicy);

    T createDrawingContext(Sprite sprite, Extent extent, Transform transform, int i);

    Sprite createOffscreenRender(Extent extent, boolean z, Transform transform);

    U draw(LayoutItemStroke layoutItemStroke, T t, Transform transform);

    void draw(int i, T t);

    void draw(long j, InkStroke inkStroke, T t, Transform transform);

    void draw(LayoutItemArc layoutItemArc, T t, Transform transform);

    void draw(LayoutItemDecoration layoutItemDecoration, T t, Transform transform);

    void draw(LayoutItemObject layoutItemObject, String str, String str2, Rectangle rectangle, Transform transform, T t);

    void draw(LayoutItemPoint layoutItemPoint, T t, Transform transform);

    void draw(LayoutItemString layoutItemString, T t, Transform transform);

    void draw(Rectangle rectangle, T t);

    void draw(Sprite sprite, Transform transform, float f, T t);

    void draw(U u, T t);

    void drawLine(Point point, Point point2, T t, boolean z, boolean z2);

    void drawPath(String str, Path path, InkStyle inkStyle, boolean z, T t);

    void drawSelection(Path path, T t);

    void drawWithPrediction(long j, InkStroke inkStroke, T t, Transform transform, SWIGVectorMotionEvent sWIGVectorMotionEvent, boolean z);

    void groupChanged(LayoutGroup layoutGroup, T t);

    void invalidate(int i);

    void invalidate(Extent extent, int i);

    boolean isCachingStroke();

    void popClip(T t);

    void pushClip(Extent extent, T t);

    void releaseDrawingContext(Sprite sprite, T t);

    void releaseOffscreenRender(Sprite sprite);

    void setStretchedFontRenderingMode(boolean z, T t);

    void styleChanged(InkStyle inkStyle, T t);

    void stylesheetChanged(Layout layout);

    boolean supportsMotionPrediction();
}
