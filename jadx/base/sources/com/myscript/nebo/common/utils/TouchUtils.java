package com.myscript.nebo.common.utils;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes3.dex */
public final class TouchUtils {
    private TouchUtils() {
    }

    public static boolean isRightClick(MotionEvent motionEvent) {
        return (motionEvent.getSource() == 8194 && motionEvent.getAction() == 0) && ((motionEvent.getButtonState() == 2) || (motionEvent.getButtonState() == 1 && (motionEvent.getMetaState() & 4096) != 0));
    }
}
