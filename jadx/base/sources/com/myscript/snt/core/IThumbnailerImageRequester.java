package com.myscript.snt.core;

import com.myscript.atk.core.Extent;
import com.myscript.atk.core.Renderer;
import com.myscript.atk.core.ViewTransform;

/* JADX INFO: loaded from: classes7.dex */
public interface IThumbnailerImageRequester {
    boolean createThumbnail(String str, Renderer renderer, Extent extent, ViewTransform viewTransform, float f);
}
