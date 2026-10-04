package com.myscript.atk.text;

import com.myscript.atk.core.SWIGVectorMimeType;

/* JADX INFO: loaded from: classes4.dex */
public interface INativeClipboard {
    SWIGVectorMimeType getClipboardMetadata();

    SWIGClipboard getNativeClipboard();

    void updateNativeClipboard(SWIGClipboard sWIGClipboard);
}
