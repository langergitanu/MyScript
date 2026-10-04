package com.myscript.nebo.dms.core;

import android.content.SharedPreferences;
import com.myscript.nebo.analytics.AnalyticsEvent;
import com.myscript.nebo.analytics.firebase.NeboFirebaseEvent;
import com.myscript.nebo.common.MainThreadBus;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.event.OnGlobalNotebookSyncProgressEvent;
import com.myscript.nebo.dms.event.OnPrepareSyncProgressEvent;
import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.DMSLogLevel;
import com.myscript.snt.dms.DMSSyncState;
import com.myscript.snt.dms.IDMSListener;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: LibraryRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000U\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0016\u0010\u000e\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0016J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\fH\u0016J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0016\u0010\u0015\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J2\u0010\u0017\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0016J2\u0010\u001c\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0016J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0019H\u0016J\u0016\u0010#\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010H\u0016J,\u0010%\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00192\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0016J\u0016\u0010(\u001a\u00020\u00032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010H\u0016J&\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u00192\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0016J\u0016\u0010+\u001a\u00020\u00032\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0016J\u0018\u0010-\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\fH\u0016J \u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\f2\u0006\u0010*\u001a\u00020\f2\u0006\u00100\u001a\u00020\u0019H\u0016J\u0016\u00101\u001a\u00020\u00032\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0016J\u0018\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000204H\u0016J\u0018\u00106\u001a\u00020\u00032\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000204H\u0016J\u0018\u00107\u001a\u00020\u00032\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000204H\u0016J \u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\f2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000204H\u0016J\b\u0010:\u001a\u00020\u0003H\u0016J\u0010\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\fH\u0016J\b\u0010=\u001a\u00020\u0003H\u0016J \u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u0002042\u0006\u0010B\u001a\u00020CH\u0016J$\u0010D\u001a\u00020\u00032\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0016¨\u0006G"}, m1599d2 = {"com/myscript/nebo/dms/core/LibraryRepository$onDmsUpdate$1", "Lcom/myscript/snt/dms/IDMSListener;", "log", "", "message", "", "severity", "Lcom/myscript/snt/dms/DMSLogLevel;", "pageDeleted", "pageKey", "Lcom/myscript/snt/core/PageKey;", "parentNotebookKey", "Lcom/myscript/snt/core/NotebookKey;", "parentPageKey", "pagesRenamed", "pageKeys", "", "pageUUIDReset", "previousPageKey", "fromNotebookKey", "fromPageKey", "pagesUpdated", "pageContentChanged", "trashed", "trashedCollectionKeys", "Lcom/myscript/snt/core/CollectionKey;", "trashedNotebookKeys", "trashedPageKeys", "restored", "pageMoved", "previousParentNotebookKey", "previousParentPageKey", "collectionUUIDReset", "previousCollectionKey", "collectionKey", "collectionsRenamed", "collectionKeys", "collectionDeleted", "notebooksDeleted", "pagesDeleted", "collectionsUpdated", "notebookDeleted", "notebookKey", "notebooksRenamed", "notebookKeys", "notebookMoved", "notebookUUIDReset", "previousNotebookKey", "fromCollectionKey", "notebooksUpdated", "refreshProgress", "amountDone", "", "totalAmount", "syncProgress", "syncPrepareProgress", "notebookSyncProgress", "notebookSyncing", "syncCanceled", "notebookSyncCanceled", "notebookCanceled", "refreshCanceled", "dmsSyncStateChanged", "newSyncState", "Lcom/myscript/snt/dms/DMSSyncState;", "numberOfNotebookToSynchronize", "userAction", "", "conflictedPageCopies", "duplicatedKeys1", "duplicatedKeys2", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LibraryRepository$onDmsUpdate$1 implements IDMSListener {
    final /* synthetic */ LibraryRepository this$0;

    @Override // com.myscript.snt.dms.IDMSListener
    public void notebookSyncCanceled(NotebookKey notebookCanceled) {
        Intrinsics.checkNotNullParameter(notebookCanceled, "notebookCanceled");
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void pageContentChanged(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void refreshCanceled() {
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void syncCanceled() {
    }

    LibraryRepository$onDmsUpdate$1(LibraryRepository libraryRepository) {
        this.this$0 = libraryRepository;
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void log(String message, DMSLogLevel severity) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(severity, "severity");
        if (severity == DMSLogLevel.ERR) {
            this.this$0.logger.logError(new RuntimeException(message));
        } else {
            this.this$0.logTrace(message);
        }
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void pageDeleted(final PageKey pageKey, final NotebookKey parentNotebookKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(parentNotebookKey, "parentNotebookKey");
        this.this$0.notifyTrash(new Function1() { // from class: com.myscript.nebo.dms.core.LibraryRepository$onDmsUpdate$1$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryRepository$onDmsUpdate$1.pageDeleted$lambda$0(pageKey, parentNotebookKey, (LibraryRepository.TrashListener) obj);
            }
        });
        if (Intrinsics.areEqual(pageKey, this.this$0.getLastOpenedNoteKey())) {
            this.this$0.setLastOpenedNoteKey(null);
        }
        SharedPreferences.Editor editorEdit = this.this$0.sharedPreferences.edit();
        editorEdit.remove(LibraryRepository.INSTANCE.lastOpenPagePreferenceKey(pageKey));
        editorEdit.apply();
        this.this$0.notifyPageRemoved(pageKey);
        this.this$0.notifyUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pageDeleted$lambda$0(PageKey pageKey, NotebookKey notebookKey, LibraryRepository.TrashListener notifyTrash) {
        Intrinsics.checkNotNullParameter(notifyTrash, "$this$notifyTrash");
        notifyTrash.pageDeleted(pageKey, notebookKey);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void pageDeleted(final PageKey pageKey, final PageKey parentPageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(parentPageKey, "parentPageKey");
        this.this$0.notifyTrash(new Function1() { // from class: com.myscript.nebo.dms.core.LibraryRepository$onDmsUpdate$1$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryRepository$onDmsUpdate$1.pageDeleted$lambda$2(pageKey, parentPageKey, (LibraryRepository.TrashListener) obj);
            }
        });
        if (Intrinsics.areEqual(pageKey, this.this$0.getLastOpenedNoteKey())) {
            this.this$0.setLastOpenedNoteKey(null);
        }
        SharedPreferences.Editor editorEdit = this.this$0.sharedPreferences.edit();
        editorEdit.remove(LibraryRepository.INSTANCE.lastOpenPagePreferenceKey(pageKey));
        editorEdit.apply();
        this.this$0.notifyPageRemoved(pageKey);
        this.this$0.notifyUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pageDeleted$lambda$2(PageKey pageKey, PageKey pageKey2, LibraryRepository.TrashListener notifyTrash) {
        Intrinsics.checkNotNullParameter(notifyTrash, "$this$notifyTrash");
        notifyTrash.pageDeleted(pageKey, pageKey2);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void pagesRenamed(List<? extends PageKey> pageKeys) {
        Intrinsics.checkNotNullParameter(pageKeys, "pageKeys");
        LibraryRepository libraryRepository = this.this$0;
        Iterator<T> it = pageKeys.iterator();
        while (it.hasNext()) {
            libraryRepository.notifyPageUpdated((PageKey) it.next());
        }
        this.this$0.notifyUpdate();
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void pageUUIDReset(PageKey previousPageKey, PageKey pageKey, NotebookKey fromNotebookKey) {
        Intrinsics.checkNotNullParameter(previousPageKey, "previousPageKey");
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(fromNotebookKey, "fromNotebookKey");
        this.this$0.notifyPageUUIDReset(previousPageKey, pageKey);
        this.this$0.notifyUpdate();
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void pageUUIDReset(PageKey previousPageKey, PageKey pageKey, PageKey fromPageKey) {
        Intrinsics.checkNotNullParameter(previousPageKey, "previousPageKey");
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(fromPageKey, "fromPageKey");
        this.this$0.notifyPageUUIDReset(previousPageKey, pageKey);
        this.this$0.notifyUpdate();
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void pagesUpdated(final List<? extends PageKey> pageKeys) {
        Intrinsics.checkNotNullParameter(pageKeys, "pageKeys");
        this.this$0.notifyTrash(new Function1() { // from class: com.myscript.nebo.dms.core.LibraryRepository$onDmsUpdate$1$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryRepository$onDmsUpdate$1.pagesUpdated$lambda$4(pageKeys, (LibraryRepository.TrashListener) obj);
            }
        });
        LibraryRepository libraryRepository = this.this$0;
        Iterator<T> it = pageKeys.iterator();
        while (it.hasNext()) {
            libraryRepository.notifyPageUpdated((PageKey) it.next());
        }
        this.this$0.notifyUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pagesUpdated$lambda$4(List list, LibraryRepository.TrashListener notifyTrash) {
        Intrinsics.checkNotNullParameter(notifyTrash, "$this$notifyTrash");
        notifyTrash.pagesUpdated(list);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void trashed(final List<? extends CollectionKey> trashedCollectionKeys, final List<? extends NotebookKey> trashedNotebookKeys, final List<? extends PageKey> trashedPageKeys) {
        Intrinsics.checkNotNullParameter(trashedCollectionKeys, "trashedCollectionKeys");
        Intrinsics.checkNotNullParameter(trashedNotebookKeys, "trashedNotebookKeys");
        Intrinsics.checkNotNullParameter(trashedPageKeys, "trashedPageKeys");
        this.this$0.notifyTrash(new Function1() { // from class: com.myscript.nebo.dms.core.LibraryRepository$onDmsUpdate$1$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryRepository$onDmsUpdate$1.trashed$lambda$6(trashedCollectionKeys, trashedNotebookKeys, trashedPageKeys, (LibraryRepository.TrashListener) obj);
            }
        });
        NotebookKey lastOpenedFolderKey = this.this$0.getLastOpenedFolderKey();
        if (lastOpenedFolderKey != null) {
            LibraryRepository libraryRepository = this.this$0;
            if (trashedNotebookKeys.contains(lastOpenedFolderKey)) {
                libraryRepository.setLastOpenedFolderKey(null);
                libraryRepository.setLastOpenedNoteKey(null);
                libraryRepository.notifyFolderRemoved(lastOpenedFolderKey);
            }
        }
        LibraryRepository libraryRepository2 = this.this$0;
        for (PageKey pageKey : trashedPageKeys) {
            SharedPreferences.Editor editorEdit = libraryRepository2.sharedPreferences.edit();
            editorEdit.remove(LibraryRepository.INSTANCE.lastOpenPagePreferenceKey(pageKey));
            editorEdit.apply();
        }
        this.this$0.notifyUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit trashed$lambda$6(List list, List list2, List list3, LibraryRepository.TrashListener notifyTrash) {
        Intrinsics.checkNotNullParameter(notifyTrash, "$this$notifyTrash");
        notifyTrash.trashed(list, list2, list3);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void restored(final List<? extends CollectionKey> trashedCollectionKeys, final List<? extends NotebookKey> trashedNotebookKeys, final List<? extends PageKey> trashedPageKeys) {
        NotebookKey lastOpenedFolderKey;
        Intrinsics.checkNotNullParameter(trashedCollectionKeys, "trashedCollectionKeys");
        Intrinsics.checkNotNullParameter(trashedNotebookKeys, "trashedNotebookKeys");
        Intrinsics.checkNotNullParameter(trashedPageKeys, "trashedPageKeys");
        this.this$0.notifyTrash(new Function1() { // from class: com.myscript.nebo.dms.core.LibraryRepository$onDmsUpdate$1$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryRepository$onDmsUpdate$1.restored$lambda$9(trashedCollectionKeys, trashedNotebookKeys, trashedPageKeys, (LibraryRepository.TrashListener) obj);
            }
        });
        if (!trashedPageKeys.isEmpty() && (lastOpenedFolderKey = this.this$0.getLastOpenedFolderKey()) != null) {
            this.this$0.notifyFolderUpdated(lastOpenedFolderKey);
        }
        this.this$0.notifyUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit restored$lambda$9(List list, List list2, List list3, LibraryRepository.TrashListener notifyTrash) {
        Intrinsics.checkNotNullParameter(notifyTrash, "$this$notifyTrash");
        notifyTrash.restored(list, list2, list3);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void pageMoved(final NotebookKey previousParentNotebookKey, final PageKey pageKey) {
        Intrinsics.checkNotNullParameter(previousParentNotebookKey, "previousParentNotebookKey");
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        this.this$0.notifyTrash(new Function1() { // from class: com.myscript.nebo.dms.core.LibraryRepository$onDmsUpdate$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryRepository$onDmsUpdate$1.pageMoved$lambda$11(previousParentNotebookKey, pageKey, (LibraryRepository.TrashListener) obj);
            }
        });
        this.this$0.notifyPageUpdated(pageKey);
        this.this$0.notifyUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pageMoved$lambda$11(NotebookKey notebookKey, PageKey pageKey, LibraryRepository.TrashListener notifyTrash) {
        Intrinsics.checkNotNullParameter(notifyTrash, "$this$notifyTrash");
        notifyTrash.pageMoved(notebookKey, pageKey);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void pageMoved(final PageKey previousParentPageKey, final PageKey pageKey) {
        Intrinsics.checkNotNullParameter(previousParentPageKey, "previousParentPageKey");
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        this.this$0.notifyTrash(new Function1() { // from class: com.myscript.nebo.dms.core.LibraryRepository$onDmsUpdate$1$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryRepository$onDmsUpdate$1.pageMoved$lambda$12(previousParentPageKey, pageKey, (LibraryRepository.TrashListener) obj);
            }
        });
        this.this$0.notifyPageUpdated(pageKey);
        this.this$0.notifyUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pageMoved$lambda$12(PageKey pageKey, PageKey pageKey2, LibraryRepository.TrashListener notifyTrash) {
        Intrinsics.checkNotNullParameter(notifyTrash, "$this$notifyTrash");
        notifyTrash.pageMoved(pageKey, pageKey2);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void collectionUUIDReset(CollectionKey previousCollectionKey, CollectionKey collectionKey) {
        Intrinsics.checkNotNullParameter(previousCollectionKey, "previousCollectionKey");
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        this.this$0.notifyUpdate();
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void collectionsRenamed(final List<? extends CollectionKey> collectionKeys) {
        Intrinsics.checkNotNullParameter(collectionKeys, "collectionKeys");
        this.this$0.notifyTrash(new Function1() { // from class: com.myscript.nebo.dms.core.LibraryRepository$onDmsUpdate$1$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryRepository$onDmsUpdate$1.collectionsRenamed$lambda$13(collectionKeys, (LibraryRepository.TrashListener) obj);
            }
        });
        this.this$0.notifyUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit collectionsRenamed$lambda$13(List list, LibraryRepository.TrashListener notifyTrash) {
        Intrinsics.checkNotNullParameter(notifyTrash, "$this$notifyTrash");
        notifyTrash.collectionsRenamed(list);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void collectionDeleted(final CollectionKey collectionKey, final List<? extends NotebookKey> notebooksDeleted, final List<? extends PageKey> pagesDeleted) {
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        Intrinsics.checkNotNullParameter(notebooksDeleted, "notebooksDeleted");
        Intrinsics.checkNotNullParameter(pagesDeleted, "pagesDeleted");
        this.this$0.notifyTrash(new Function1() { // from class: com.myscript.nebo.dms.core.LibraryRepository$onDmsUpdate$1$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryRepository$onDmsUpdate$1.collectionDeleted$lambda$14(collectionKey, notebooksDeleted, pagesDeleted, (LibraryRepository.TrashListener) obj);
            }
        });
        NotebookKey lastOpenedFolderKey = this.this$0.getLastOpenedFolderKey();
        if (lastOpenedFolderKey != null) {
            LibraryRepository libraryRepository = this.this$0;
            if (notebooksDeleted.contains(lastOpenedFolderKey)) {
                libraryRepository.setLastOpenedFolderKey(null);
                libraryRepository.setLastOpenedNoteKey(null);
            }
        }
        LibraryRepository libraryRepository2 = this.this$0;
        for (PageKey pageKey : pagesDeleted) {
            SharedPreferences.Editor editorEdit = libraryRepository2.sharedPreferences.edit();
            editorEdit.remove(LibraryRepository.INSTANCE.lastOpenPagePreferenceKey(pageKey));
            editorEdit.apply();
        }
        this.this$0.notifyUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit collectionDeleted$lambda$14(CollectionKey collectionKey, List list, List list2, LibraryRepository.TrashListener notifyTrash) {
        Intrinsics.checkNotNullParameter(notifyTrash, "$this$notifyTrash");
        notifyTrash.collectionDeleted(collectionKey, list, list2);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void collectionsUpdated(final List<? extends CollectionKey> collectionKey) {
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        this.this$0.notifyTrash(new Function1() { // from class: com.myscript.nebo.dms.core.LibraryRepository$onDmsUpdate$1$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryRepository$onDmsUpdate$1.collectionsUpdated$lambda$17(collectionKey, (LibraryRepository.TrashListener) obj);
            }
        });
        this.this$0.notifyUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit collectionsUpdated$lambda$17(List list, LibraryRepository.TrashListener notifyTrash) {
        Intrinsics.checkNotNullParameter(notifyTrash, "$this$notifyTrash");
        notifyTrash.collectionsUpdated(list);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void notebookDeleted(final NotebookKey notebookKey, final CollectionKey collectionKey, final List<? extends PageKey> pagesDeleted) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        Intrinsics.checkNotNullParameter(pagesDeleted, "pagesDeleted");
        this.this$0.notifyTrash(new Function1() { // from class: com.myscript.nebo.dms.core.LibraryRepository$onDmsUpdate$1$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryRepository$onDmsUpdate$1.notebookDeleted$lambda$18(notebookKey, collectionKey, pagesDeleted, (LibraryRepository.TrashListener) obj);
            }
        });
        if (Intrinsics.areEqual(notebookKey, this.this$0.getLastOpenedFolderKey())) {
            this.this$0.setLastOpenedFolderKey(null);
            this.this$0.setLastOpenedNoteKey(null);
        }
        this.this$0.notifyFolderRemoved(notebookKey);
        this.this$0.notifyUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notebookDeleted$lambda$18(NotebookKey notebookKey, CollectionKey collectionKey, List list, LibraryRepository.TrashListener notifyTrash) {
        Intrinsics.checkNotNullParameter(notifyTrash, "$this$notifyTrash");
        notifyTrash.folderDeleted(notebookKey, collectionKey, list);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void notebooksRenamed(final List<? extends NotebookKey> notebookKeys) {
        Intrinsics.checkNotNullParameter(notebookKeys, "notebookKeys");
        this.this$0.notifyTrash(new Function1() { // from class: com.myscript.nebo.dms.core.LibraryRepository$onDmsUpdate$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryRepository$onDmsUpdate$1.notebooksRenamed$lambda$19(notebookKeys, (LibraryRepository.TrashListener) obj);
            }
        });
        LibraryRepository libraryRepository = this.this$0;
        Iterator<T> it = notebookKeys.iterator();
        while (it.hasNext()) {
            libraryRepository.notifyFolderUpdated((NotebookKey) it.next());
        }
        this.this$0.notifyUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notebooksRenamed$lambda$19(List list, LibraryRepository.TrashListener notifyTrash) {
        Intrinsics.checkNotNullParameter(notifyTrash, "$this$notifyTrash");
        notifyTrash.foldersRenamed(list);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void notebookMoved(final CollectionKey previousCollectionKey, final NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(previousCollectionKey, "previousCollectionKey");
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        this.this$0.notifyTrash(new Function1() { // from class: com.myscript.nebo.dms.core.LibraryRepository$onDmsUpdate$1$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryRepository$onDmsUpdate$1.notebookMoved$lambda$21(previousCollectionKey, notebookKey, (LibraryRepository.TrashListener) obj);
            }
        });
        this.this$0.notifyFolderUpdated(notebookKey);
        this.this$0.notifyUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notebookMoved$lambda$21(CollectionKey collectionKey, NotebookKey notebookKey, LibraryRepository.TrashListener notifyTrash) {
        Intrinsics.checkNotNullParameter(notifyTrash, "$this$notifyTrash");
        notifyTrash.folderMoved(collectionKey, notebookKey);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void notebookUUIDReset(NotebookKey previousNotebookKey, NotebookKey notebookKey, CollectionKey fromCollectionKey) {
        Intrinsics.checkNotNullParameter(previousNotebookKey, "previousNotebookKey");
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        Intrinsics.checkNotNullParameter(fromCollectionKey, "fromCollectionKey");
        this.this$0.notifyUpdate();
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void notebooksUpdated(final List<? extends NotebookKey> notebookKeys) {
        Intrinsics.checkNotNullParameter(notebookKeys, "notebookKeys");
        this.this$0.notifyTrash(new Function1() { // from class: com.myscript.nebo.dms.core.LibraryRepository$onDmsUpdate$1$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryRepository$onDmsUpdate$1.notebooksUpdated$lambda$22(notebookKeys, (LibraryRepository.TrashListener) obj);
            }
        });
        LibraryRepository libraryRepository = this.this$0;
        Iterator<T> it = notebookKeys.iterator();
        while (it.hasNext()) {
            libraryRepository.notifyFolderUpdated((NotebookKey) it.next());
        }
        this.this$0.notifyUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notebooksUpdated$lambda$22(List list, LibraryRepository.TrashListener notifyTrash) {
        Intrinsics.checkNotNullParameter(notifyTrash, "$this$notifyTrash");
        notifyTrash.foldersUpdated(list);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void refreshProgress(int amountDone, int totalAmount) {
        Set set = this.this$0.syncListeners;
        LibraryRepository libraryRepository = this.this$0;
        synchronized (set) {
            Iterator it = libraryRepository.syncListeners.iterator();
            while (it.hasNext()) {
                ((LibraryRepository.SyncListener) it.next()).refreshProgress(amountDone, totalAmount);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void syncProgress(int amountDone, int totalAmount) {
        Set set = this.this$0.syncListeners;
        LibraryRepository libraryRepository = this.this$0;
        synchronized (set) {
            Iterator it = libraryRepository.syncListeners.iterator();
            while (it.hasNext()) {
                ((LibraryRepository.SyncListener) it.next()).syncProgress(amountDone, totalAmount);
            }
            Unit unit = Unit.INSTANCE;
        }
        MainThreadBus.eventBus.post(new OnGlobalNotebookSyncProgressEvent(amountDone, totalAmount, this.this$0.lastNumberOfNotebookToSynchronize));
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void syncPrepareProgress(int amountDone, int totalAmount) {
        Set set = this.this$0.syncListeners;
        LibraryRepository libraryRepository = this.this$0;
        synchronized (set) {
            Iterator it = libraryRepository.syncListeners.iterator();
            while (it.hasNext()) {
                ((LibraryRepository.SyncListener) it.next()).syncPrepareProgress(amountDone, totalAmount);
            }
            Unit unit = Unit.INSTANCE;
        }
        MainThreadBus.eventBus.post(new OnPrepareSyncProgressEvent(amountDone, totalAmount, this.this$0.lastNumberOfNotebookToSynchronize));
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void notebookSyncProgress(NotebookKey notebookSyncing, int amountDone, int totalAmount) {
        Intrinsics.checkNotNullParameter(notebookSyncing, "notebookSyncing");
        Set set = this.this$0.syncListeners;
        LibraryRepository libraryRepository = this.this$0;
        synchronized (set) {
            Iterator it = libraryRepository.syncListeners.iterator();
            while (it.hasNext()) {
                ((LibraryRepository.SyncListener) it.next()).syncProgress(notebookSyncing, amountDone, totalAmount);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void dmsSyncStateChanged(DMSSyncState newSyncState, int numberOfNotebookToSynchronize, boolean userAction) {
        Intrinsics.checkNotNullParameter(newSyncState, "newSyncState");
        String strDump = (DMSSyncState.SYNCING == this.this$0.previousSyncState || DMSSyncState.REFRESHING == this.this$0.previousSyncState || newSyncState == DMSSyncState.SYNC_FAILED || newSyncState == DMSSyncState.REFRESH_FAILED) ? this.this$0.getCloudOperationLogger().dump() : "";
        if (DMSSyncState.SYNCING == this.this$0.previousSyncState || DMSSyncState.REFRESHING == this.this$0.previousSyncState) {
            this.this$0.getCloudOperationLogger().endSession(newSyncState.name());
            BuildersKt__Builders_commonKt.launch$default(this.this$0.coroutinesScope, Dispatchers.getIO(), null, new LibraryRepository$onDmsUpdate$1$dmsSyncStateChanged$1(this.this$0, strDump, this.this$0.dms.debugSyncStates(), null), 2, null);
        }
        if (DMSSyncState.SYNCING == newSyncState || DMSSyncState.REFRESHING == newSyncState) {
            this.this$0.getCloudOperationLogger().startSession(newSyncState.name(), numberOfNotebookToSynchronize, this.this$0.previousSyncState.name());
        }
        this.this$0.lastNumberOfNotebookToSynchronize = numberOfNotebookToSynchronize;
        String strName = newSyncState.name();
        this.this$0.logTrace("DMSSyncState: " + strName + " by user? " + userAction);
        if (newSyncState == DMSSyncState.SYNC_FAILED || newSyncState == DMSSyncState.REFRESH_FAILED) {
            this.this$0.logger.setKeyValue("dms_cloud_sync_state_error", strName);
            LibraryRepository libraryRepository = this.this$0;
            libraryRepository.logTrace("Sync error debugSyncStates " + libraryRepository.dms.debugSyncStates());
            this.this$0.logTrace("Sync error cloudOperationLoggerContent " + strDump);
        }
        if (newSyncState == DMSSyncState.SYNC_FAILED && this.this$0.previousSyncState != newSyncState) {
            AnalyticsEvent.log$default(NeboFirebaseEvent.syncFailed, null, 1, null);
        }
        this.this$0.previousSyncState = newSyncState;
        this.this$0.notifySyncState(newSyncState, numberOfNotebookToSynchronize, userAction);
    }

    @Override // com.myscript.snt.dms.IDMSListener
    public void conflictedPageCopies(List<? extends PageKey> duplicatedKeys1, List<? extends PageKey> duplicatedKeys2) {
        Intrinsics.checkNotNullParameter(duplicatedKeys1, "duplicatedKeys1");
        Intrinsics.checkNotNullParameter(duplicatedKeys2, "duplicatedKeys2");
        Set set = this.this$0.syncListeners;
        LibraryRepository libraryRepository = this.this$0;
        synchronized (set) {
            Iterator it = libraryRepository.syncListeners.iterator();
            while (it.hasNext()) {
                ((LibraryRepository.SyncListener) it.next()).conflictedPageCopies(duplicatedKeys1, duplicatedKeys2);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
