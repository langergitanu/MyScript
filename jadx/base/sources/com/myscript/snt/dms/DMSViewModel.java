package com.myscript.snt.dms;

import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.SWIGVectorCollectionKey;
import com.myscript.snt.core.SWIGVectorNotebookKey;
import com.myscript.snt.core.SWIGVectorPageKey;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class DMSViewModel {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public DMSViewModel(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(DMSViewModel dMSViewModel) {
        if (dMSViewModel == null) {
            return 0L;
        }
        return dMSViewModel.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_DMSViewModel(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void log(String str, DMSLogLevel dMSLogLevel) {
        NeboDMSJNI.DMSViewModel_log(this.swigCPtr, this, str.getBytes(), dMSLogLevel.swigValue());
    }

    public C6923x25f03a14 errors() {
        return new C6923x25f03a14(NeboDMSJNI.DMSViewModel_errors(this.swigCPtr, this), true);
    }

    public void clearErrors() {
        NeboDMSJNI.DMSViewModel_clearErrors(this.swigCPtr, this);
    }

    public void collectionDeleted(CollectionKey collectionKey, List<NotebookKey> list, List<PageKey> list2) {
        SWIGVectorNotebookKey sWIGVectorNotebookKey = new SWIGVectorNotebookKey(list);
        SWIGVectorPageKey sWIGVectorPageKey = new SWIGVectorPageKey(list2);
        NeboDMSJNI.DMSViewModel_collectionDeleted(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey, SWIGVectorNotebookKey.getCPtr(sWIGVectorNotebookKey), sWIGVectorNotebookKey, SWIGVectorPageKey.getCPtr(sWIGVectorPageKey), sWIGVectorPageKey);
    }

    public void collectionUUIDReset(CollectionKey collectionKey, CollectionKey collectionKey2) {
        NeboDMSJNI.DMSViewModel_collectionUUIDReset(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey, CollectionKey.getCPtr(collectionKey2), collectionKey2);
    }

    public void collectionsRenamed(List<CollectionKey> list) {
        SWIGVectorCollectionKey sWIGVectorCollectionKey = new SWIGVectorCollectionKey(list);
        NeboDMSJNI.DMSViewModel_collectionsRenamed(this.swigCPtr, this, SWIGVectorCollectionKey.getCPtr(sWIGVectorCollectionKey), sWIGVectorCollectionKey);
    }

    public void collectionsUpdated(List<CollectionKey> list) {
        SWIGVectorCollectionKey sWIGVectorCollectionKey = new SWIGVectorCollectionKey(list);
        NeboDMSJNI.DMSViewModel_collectionsUpdated(this.swigCPtr, this, SWIGVectorCollectionKey.getCPtr(sWIGVectorCollectionKey), sWIGVectorCollectionKey);
    }

    public void notebookDeleted(NotebookKey notebookKey, CollectionKey collectionKey, List<PageKey> list) {
        SWIGVectorPageKey sWIGVectorPageKey = new SWIGVectorPageKey(list);
        NeboDMSJNI.DMSViewModel_notebookDeleted(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, CollectionKey.getCPtr(collectionKey), collectionKey, SWIGVectorPageKey.getCPtr(sWIGVectorPageKey), sWIGVectorPageKey);
    }

    public void notebookMoved(CollectionKey collectionKey, NotebookKey notebookKey) {
        NeboDMSJNI.DMSViewModel_notebookMoved(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    public void notebookUUIDReset(NotebookKey notebookKey, NotebookKey notebookKey2, CollectionKey collectionKey) {
        NeboDMSJNI.DMSViewModel_notebookUUIDReset(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, NotebookKey.getCPtr(notebookKey2), notebookKey2, CollectionKey.getCPtr(collectionKey), collectionKey);
    }

    public void notebooksRenamed(List<NotebookKey> list) {
        SWIGVectorNotebookKey sWIGVectorNotebookKey = new SWIGVectorNotebookKey(list);
        NeboDMSJNI.DMSViewModel_notebooksRenamed(this.swigCPtr, this, SWIGVectorNotebookKey.getCPtr(sWIGVectorNotebookKey), sWIGVectorNotebookKey);
    }

    public void notebooksUpdated(List<NotebookKey> list) {
        SWIGVectorNotebookKey sWIGVectorNotebookKey = new SWIGVectorNotebookKey(list);
        NeboDMSJNI.DMSViewModel_notebooksUpdated(this.swigCPtr, this, SWIGVectorNotebookKey.getCPtr(sWIGVectorNotebookKey), sWIGVectorNotebookKey);
    }

    public void pageDeleted(PageKey pageKey, NotebookKey notebookKey) {
        NeboDMSJNI.DMSViewModel_pageDeleted__SWIG_0(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    public void pageDeleted(PageKey pageKey, PageKey pageKey2) {
        NeboDMSJNI.DMSViewModel_pageDeleted__SWIG_1(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, PageKey.getCPtr(pageKey2), pageKey2);
    }

    public void pageMoved(NotebookKey notebookKey, PageKey pageKey) {
        NeboDMSJNI.DMSViewModel_pageMoved__SWIG_0(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, PageKey.getCPtr(pageKey), pageKey);
    }

    public void pageMoved(PageKey pageKey, PageKey pageKey2) {
        NeboDMSJNI.DMSViewModel_pageMoved__SWIG_1(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, PageKey.getCPtr(pageKey2), pageKey2);
    }

    public void pageUUIDReset(PageKey pageKey, PageKey pageKey2, NotebookKey notebookKey) {
        NeboDMSJNI.DMSViewModel_pageUUIDReset__SWIG_0(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, PageKey.getCPtr(pageKey2), pageKey2, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    public void pageUUIDReset(PageKey pageKey, PageKey pageKey2, PageKey pageKey3) {
        NeboDMSJNI.DMSViewModel_pageUUIDReset__SWIG_1(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, PageKey.getCPtr(pageKey2), pageKey2, PageKey.getCPtr(pageKey3), pageKey3);
    }

    public void pagesRenamed(List<PageKey> list) {
        SWIGVectorPageKey sWIGVectorPageKey = new SWIGVectorPageKey(list);
        NeboDMSJNI.DMSViewModel_pagesRenamed(this.swigCPtr, this, SWIGVectorPageKey.getCPtr(sWIGVectorPageKey), sWIGVectorPageKey);
    }

    public void pagesUpdated(List<PageKey> list) {
        SWIGVectorPageKey sWIGVectorPageKey = new SWIGVectorPageKey(list);
        NeboDMSJNI.DMSViewModel_pagesUpdated(this.swigCPtr, this, SWIGVectorPageKey.getCPtr(sWIGVectorPageKey), sWIGVectorPageKey);
    }

    public void trashed(List<CollectionKey> list, List<NotebookKey> list2, List<PageKey> list3) {
        SWIGVectorCollectionKey sWIGVectorCollectionKey = new SWIGVectorCollectionKey(list);
        SWIGVectorNotebookKey sWIGVectorNotebookKey = new SWIGVectorNotebookKey(list2);
        SWIGVectorPageKey sWIGVectorPageKey = new SWIGVectorPageKey(list3);
        NeboDMSJNI.DMSViewModel_trashed(this.swigCPtr, this, SWIGVectorCollectionKey.getCPtr(sWIGVectorCollectionKey), sWIGVectorCollectionKey, SWIGVectorNotebookKey.getCPtr(sWIGVectorNotebookKey), sWIGVectorNotebookKey, SWIGVectorPageKey.getCPtr(sWIGVectorPageKey), sWIGVectorPageKey);
    }

    public void restored(List<CollectionKey> list, List<NotebookKey> list2, List<PageKey> list3) {
        SWIGVectorCollectionKey sWIGVectorCollectionKey = new SWIGVectorCollectionKey(list);
        SWIGVectorNotebookKey sWIGVectorNotebookKey = new SWIGVectorNotebookKey(list2);
        SWIGVectorPageKey sWIGVectorPageKey = new SWIGVectorPageKey(list3);
        NeboDMSJNI.DMSViewModel_restored(this.swigCPtr, this, SWIGVectorCollectionKey.getCPtr(sWIGVectorCollectionKey), sWIGVectorCollectionKey, SWIGVectorNotebookKey.getCPtr(sWIGVectorNotebookKey), sWIGVectorNotebookKey, SWIGVectorPageKey.getCPtr(sWIGVectorPageKey), sWIGVectorPageKey);
    }

    public void refreshProgress(long j, long j2) {
        NeboDMSJNI.DMSViewModel_refreshProgress(this.swigCPtr, this, j, j2);
    }

    public void syncProgress(long j, long j2) {
        NeboDMSJNI.DMSViewModel_syncProgress(this.swigCPtr, this, j, j2);
    }

    public void notebookSyncProgress(NotebookKey notebookKey, long j, long j2) {
        NeboDMSJNI.DMSViewModel_notebookSyncProgress(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, j, j2);
    }

    public void syncCanceled() {
        NeboDMSJNI.DMSViewModel_syncCanceled(this.swigCPtr, this);
    }

    public void notebookSyncCanceled(NotebookKey notebookKey) {
        NeboDMSJNI.DMSViewModel_notebookSyncCanceled(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    public void refreshCanceled() {
        NeboDMSJNI.DMSViewModel_refreshCanceled(this.swigCPtr, this);
    }

    public void dmsSyncStateChanged(DMSSyncState dMSSyncState, long j, boolean z) {
        NeboDMSJNI.DMSViewModel_dmsSyncStateChanged(this.swigCPtr, this, dMSSyncState.swigValue(), j, z);
    }

    public void conflictedPageCopies(SWIGTYPE_p_std__vectorT_std__pairT_snt__PageKey_snt__PageKey_t_t sWIGTYPE_p_std__vectorT_std__pairT_snt__PageKey_snt__PageKey_t_t) {
        NeboDMSJNI.DMSViewModel_conflictedPageCopies(this.swigCPtr, this, SWIGTYPE_p_std__vectorT_std__pairT_snt__PageKey_snt__PageKey_t_t.getCPtr(sWIGTYPE_p_std__vectorT_std__pairT_snt__PageKey_snt__PageKey_t_t));
    }

    public void pageContentChanged(PageKey pageKey) {
        NeboDMSJNI.DMSViewModel_pageContentChanged(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public void needThumbnailUpdate(PageKey pageKey) {
        NeboDMSJNI.DMSViewModel_needThumbnailUpdate(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public DMSViewModel() {
        this(NeboDMSJNI.new_DMSViewModel(), true);
    }
}
