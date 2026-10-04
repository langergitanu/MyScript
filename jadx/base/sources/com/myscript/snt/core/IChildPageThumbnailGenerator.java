package com.myscript.snt.core;

import com.myscript.atk.core.IColorInversionPolicy;

/* JADX INFO: loaded from: classes7.dex */
public interface IChildPageThumbnailGenerator extends AutoCloseable {
    void addListener(IChildPageThumbnailListener iChildPageThumbnailListener);

    void cleanOldThumbnails();

    void delete();

    boolean generateThumbnail(String str, boolean z);

    String getThumbnailPath(String str);

    void removeListener(IChildPageThumbnailListener iChildPageThumbnailListener);

    void setColorInversionPolicy(IColorInversionPolicy iColorInversionPolicy);

    void setThumbnailSize(long j);

    void stop();
}
