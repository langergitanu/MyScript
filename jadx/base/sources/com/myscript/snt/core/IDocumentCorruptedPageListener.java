package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public interface IDocumentCorruptedPageListener {
    void didFixPageMetadata();

    void didTagPageCorrupted(PageKey pageKey);

    void didUnTagPageCorrupted(PageKey pageKey);
}
