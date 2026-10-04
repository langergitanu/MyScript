package com.myscript.snt.dms;

import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface IDMSListener {
    void collectionDeleted(CollectionKey collectionKey, List<NotebookKey> list, List<PageKey> list2);

    void collectionUUIDReset(CollectionKey collectionKey, CollectionKey collectionKey2);

    void collectionsRenamed(List<CollectionKey> list);

    void collectionsUpdated(List<CollectionKey> list);

    void conflictedPageCopies(List<PageKey> list, List<PageKey> list2);

    void dmsSyncStateChanged(DMSSyncState dMSSyncState, int i, boolean z);

    void log(String str, DMSLogLevel dMSLogLevel);

    void notebookDeleted(NotebookKey notebookKey, CollectionKey collectionKey, List<PageKey> list);

    void notebookMoved(CollectionKey collectionKey, NotebookKey notebookKey);

    void notebookSyncCanceled(NotebookKey notebookKey);

    void notebookSyncProgress(NotebookKey notebookKey, int i, int i2);

    void notebookUUIDReset(NotebookKey notebookKey, NotebookKey notebookKey2, CollectionKey collectionKey);

    void notebooksRenamed(List<NotebookKey> list);

    void notebooksUpdated(List<NotebookKey> list);

    void pageContentChanged(PageKey pageKey);

    void pageDeleted(PageKey pageKey, NotebookKey notebookKey);

    void pageDeleted(PageKey pageKey, PageKey pageKey2);

    void pageMoved(NotebookKey notebookKey, PageKey pageKey);

    void pageMoved(PageKey pageKey, PageKey pageKey2);

    void pageUUIDReset(PageKey pageKey, PageKey pageKey2, NotebookKey notebookKey);

    void pageUUIDReset(PageKey pageKey, PageKey pageKey2, PageKey pageKey3);

    void pagesRenamed(List<PageKey> list);

    void pagesUpdated(List<PageKey> list);

    void refreshCanceled();

    void refreshProgress(int i, int i2);

    void restored(List<CollectionKey> list, List<NotebookKey> list2, List<PageKey> list3);

    void syncCanceled();

    void syncPrepareProgress(int i, int i2);

    void syncProgress(int i, int i2);

    void trashed(List<CollectionKey> list, List<NotebookKey> list2, List<PageKey> list3);
}
