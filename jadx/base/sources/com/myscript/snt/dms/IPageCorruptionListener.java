package com.myscript.snt.dms;

import com.myscript.snt.core.NeboSanitizer;
import com.myscript.snt.core.PageKey;

/* JADX INFO: loaded from: classes7.dex */
public interface IPageCorruptionListener {
    void corruptionStateChanged(PageKey pageKey, NeboSanitizer.SanitizerResult sanitizerResult);
}
