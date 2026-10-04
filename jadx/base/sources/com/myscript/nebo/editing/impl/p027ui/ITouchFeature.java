package com.myscript.nebo.editing.impl.p027ui;

import android.graphics.Rect;
import com.myscript.atk.core.Extent;
import com.myscript.nebo.editing.impl.p027ui.DocumentTouchController;

/* JADX INFO: loaded from: classes7.dex */
public interface ITouchFeature {
    void addGestureListener(DocumentTouchController.GestureListener gestureListener);

    void addScrollListener(DocumentTouchController.ScrollListener scrollListener);

    void addZoomListener(DocumentTouchController.ZoomListener zoomListener);

    void animateScrollTo(int i, int i2);

    void enableFeatureCenterWhenPageWidthFitsScreen(boolean z);

    int getHorizontalScrollPos();

    Extent getPaperExtent();

    Rect getScreenVisibleArea();

    int getVerticalScrollPos();

    boolean isScrollToAnimatorRunning();

    void removeGestureListener(DocumentTouchController.GestureListener gestureListener);
}
