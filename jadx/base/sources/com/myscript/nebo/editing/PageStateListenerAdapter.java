package com.myscript.nebo.editing;

import com.myscript.atk.core.Extent;
import com.myscript.snt.core.IPageStateListener;
import kotlin.Metadata;

/* JADX INFO: compiled from: PageStateListenerAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J \u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J \u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageStateListenerAdapter;", "Lcom/myscript/snt/core/IPageStateListener;", "<init>", "()V", "pageStateChanged", "", "canUndo", "", "canRedo", "hasContent", "contentSizeChanged", "newDocumentExtent", "Lcom/myscript/atk/core/Extent;", "initViewportRequested", "x", "", "y", "zoom", "updateViewportRequested", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class PageStateListenerAdapter implements IPageStateListener {
    public static final int $stable = 0;

    @Override // com.myscript.snt.core.IPageStateListener
    public void initViewportRequested(float x, float y, float zoom) {
    }

    @Override // com.myscript.snt.core.IPageStateListener
    public void pageStateChanged(boolean canUndo, boolean canRedo, boolean hasContent) {
    }

    @Override // com.myscript.snt.core.IPageStateListener
    public void updateViewportRequested(float x, float y, float zoom) {
    }

    @Override // com.myscript.snt.core.IPageStateListener
    public void contentSizeChanged(Extent newDocumentExtent) {
        if (newDocumentExtent != null) {
            newDocumentExtent.delete();
        }
    }
}
