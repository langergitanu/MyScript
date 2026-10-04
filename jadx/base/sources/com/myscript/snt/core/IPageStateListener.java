package com.myscript.snt.core;

import com.myscript.atk.core.Extent;

/* JADX INFO: loaded from: classes7.dex */
public interface IPageStateListener {
    void contentSizeChanged(Extent extent);

    void initViewportRequested(float f, float f2, float f3);

    void pageStateChanged(boolean z, boolean z2, boolean z3);

    void updateViewportRequested(float f, float f2, float f3);
}
