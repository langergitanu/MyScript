package com.myscript.nebo.dms.core;

import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TrashListenerAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0016J\u0016\u0010\u000f\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0016J&\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0016J\u0016\u0010\u0012\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0016\u0010\u0014\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u001a\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u0016\u0010\u001e\u001a\u00020\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0016J2\u0010 \u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0016J2\u0010$\u001a\u00020\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0016¨\u0006&"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/TrashListenerAdapter;", "Lcom/myscript/nebo/dms/core/LibraryRepository$TrashListener;", "<init>", "()V", "collectionDeleted", "", "collectionKey", "Lcom/myscript/snt/core/CollectionKey;", "notebooksDeleted", "", "Lcom/myscript/snt/core/NotebookKey;", "pagesDeleted", "Lcom/myscript/snt/core/PageKey;", "collectionsRenamed", "collectionKeys", "collectionsUpdated", "folderDeleted", "notebookKey", "foldersRenamed", "notebookKeys", "foldersUpdated", "folderMoved", "previousCollectionKey", "pageDeleted", "pageKey", "parentNotebookKey", "parentPageKey", "pageMoved", "previousParentNotebookKey", "previousParentPageKey", "pagesUpdated", "pageKeys", "trashed", "trashedCollectionKeys", "trashedNotebookKeys", "trashedPageKeys", "restored", "restoredCollectionKeys", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class TrashListenerAdapter implements LibraryRepository.TrashListener {
    public static final int $stable = 0;

    @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
    public void collectionDeleted(CollectionKey collectionKey, List<? extends NotebookKey> notebooksDeleted, List<? extends PageKey> pagesDeleted) {
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        Intrinsics.checkNotNullParameter(notebooksDeleted, "notebooksDeleted");
        Intrinsics.checkNotNullParameter(pagesDeleted, "pagesDeleted");
    }

    @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
    public void collectionsRenamed(List<? extends CollectionKey> collectionKeys) {
        Intrinsics.checkNotNullParameter(collectionKeys, "collectionKeys");
    }

    @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
    public void collectionsUpdated(List<? extends CollectionKey> collectionKeys) {
        Intrinsics.checkNotNullParameter(collectionKeys, "collectionKeys");
    }

    @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
    public void folderDeleted(NotebookKey notebookKey, CollectionKey collectionKey, List<? extends PageKey> pagesDeleted) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        Intrinsics.checkNotNullParameter(pagesDeleted, "pagesDeleted");
    }

    @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
    public void folderMoved(CollectionKey previousCollectionKey, NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(previousCollectionKey, "previousCollectionKey");
    }

    @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
    public void foldersRenamed(List<? extends NotebookKey> notebookKeys) {
        Intrinsics.checkNotNullParameter(notebookKeys, "notebookKeys");
    }

    @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
    public void foldersUpdated(List<? extends NotebookKey> notebookKeys) {
        Intrinsics.checkNotNullParameter(notebookKeys, "notebookKeys");
    }

    @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
    public void pageDeleted(PageKey pageKey, NotebookKey parentNotebookKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(parentNotebookKey, "parentNotebookKey");
    }

    @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
    public void pageDeleted(PageKey pageKey, PageKey parentPageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(parentPageKey, "parentPageKey");
    }

    @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
    public void pageMoved(NotebookKey previousParentNotebookKey, PageKey pageKey) {
        Intrinsics.checkNotNullParameter(previousParentNotebookKey, "previousParentNotebookKey");
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
    }

    @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
    public void pageMoved(PageKey previousParentPageKey, PageKey pageKey) {
        Intrinsics.checkNotNullParameter(previousParentPageKey, "previousParentPageKey");
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
    }

    @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
    public void pagesUpdated(List<? extends PageKey> pageKeys) {
        Intrinsics.checkNotNullParameter(pageKeys, "pageKeys");
    }

    @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
    public void restored(List<? extends CollectionKey> restoredCollectionKeys, List<? extends NotebookKey> trashedNotebookKeys, List<? extends PageKey> trashedPageKeys) {
        Intrinsics.checkNotNullParameter(restoredCollectionKeys, "restoredCollectionKeys");
        Intrinsics.checkNotNullParameter(trashedNotebookKeys, "trashedNotebookKeys");
        Intrinsics.checkNotNullParameter(trashedPageKeys, "trashedPageKeys");
    }

    @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
    public void trashed(List<? extends CollectionKey> trashedCollectionKeys, List<? extends NotebookKey> trashedNotebookKeys, List<? extends PageKey> trashedPageKeys) {
        Intrinsics.checkNotNullParameter(trashedCollectionKeys, "trashedCollectionKeys");
        Intrinsics.checkNotNullParameter(trashedNotebookKeys, "trashedNotebookKeys");
        Intrinsics.checkNotNullParameter(trashedPageKeys, "trashedPageKeys");
    }
}
