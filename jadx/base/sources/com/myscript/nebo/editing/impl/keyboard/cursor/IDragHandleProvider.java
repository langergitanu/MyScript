package com.myscript.nebo.editing.impl.keyboard.cursor;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes7.dex */
public interface IDragHandleProvider {
    void handleScrollDown(float f);

    void handleScrollLeft(float f);

    void handleScrollRight(float f);

    void handleScrollUp(float f);

    void handleStopScroll();

    boolean onDoubleTap(MotionEvent motionEvent);
}
