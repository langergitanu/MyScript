package com.myscript.nebo.trash;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsSpec;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.preference.PreferenceManager;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.cloudsync.CloudManager;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.model.CollectionModel;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.dms.core.model.SelectionState;
import com.myscript.nebo.grid.DisplayMode;
import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.IThumbnailerNotificationListener;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.DMSFilter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentList;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: TrashViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000Ë\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001F\b\u0007\u0018\u0000 }2\u00020\u0001:\u0001}B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010L\u001a\u00020MH\u0002J\u000e\u0010N\u001a\u00020M2\u0006\u0010O\u001a\u00020\u0015J\u000e\u0010P\u001a\u00020M2\u0006\u0010O\u001a\u00020\u0015J\u000e\u0010Q\u001a\u00020\u00152\u0006\u0010R\u001a\u00020\u0018J\u000e\u0010S\u001a\u00020M2\u0006\u0010T\u001a\u00020\u001fJ9\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0017*\b\u0012\u0004\u0012\u00020\u001f0\u00172\u0006\u0010V\u001a\u00020\u001f2\u0017\u0010W\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0X¢\u0006\u0002\bYH\u0002J\u0012\u0010Z\u001a\u0004\u0018\u00010\u00182\u0006\u0010[\u001a\u00020\\H\u0002J\u000e\u0010]\u001a\u00020M2\u0006\u0010^\u001a\u00020\u0018J\b\u0010_\u001a\u00020MH\u0002J\b\u0010`\u001a\u00020MH\u0002J\b\u0010a\u001a\u00020MH\u0002J\b\u0010b\u001a\u00020MH\u0016J\u0006\u0010c\u001a\u00020MJ\u0006\u0010d\u001a\u00020MJ\u0006\u0010e\u001a\u00020MJ\u0006\u0010f\u001a\u00020MJ\u0006\u0010g\u001a\u00020MJ\u0006\u0010h\u001a\u00020MJ\u0006\u0010i\u001a\u00020MJ\u0006\u0010j\u001a\u00020MJ\u0006\u0010k\u001a\u00020MJ\u0006\u0010l\u001a\u00020MJ\u0006\u0010m\u001a\u00020MJ\u0006\u0010n\u001a\u00020MJ\u000e\u0010o\u001a\u00020M2\u0006\u0010p\u001a\u00020qJ\u000e\u0010r\u001a\u00020M2\u0006\u0010p\u001a\u00020qJ\u000e\u0010s\u001a\u00020M2\u0006\u0010V\u001a\u00020\u001fJ\u0006\u0010t\u001a\u00020MJ\u0018\u0010u\u001a\u00020M2\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020\u0011H\u0002J\u0012\u0010y\u001a\u00020M2\n\b\u0002\u0010z\u001a\u0004\u0018\u00010{J\b\u0010|\u001a\u00020AH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0010\u0012\f\u0012\n #*\u0004\u0018\u00010\"0\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\u0010\u0012\f\u0012\n #*\u0004\u0018\u00010)0)0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020)0%8F¢\u0006\u0006\u001a\u0004\b+\u0010'R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00180-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010.\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00103\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b4\u00105R\u0011\u00106\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b7\u00105R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020\u001f0-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00109\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b:\u00101R\u000e\u0010;\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010<\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b=\u00105R\u0011\u0010>\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b?\u00105R\u001e\u0010B\u001a\u00020A2\u0006\u0010@\u001a\u00020A@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bC\u0010DR\u0010\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010GR\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006~"}, m1599d2 = {"Lcom/myscript/nebo/trash/TrashViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "cloudManager", "Lcom/myscript/nebo/cloudsync/CloudManager;", "sharedPreferences", "Landroid/content/SharedPreferences;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "workDispatcher", "<init>", "(Lcom/myscript/nebo/dms/core/LibraryRepository;Lcom/myscript/nebo/cloudsync/CloudManager;Landroid/content/SharedPreferences;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "xdpi", "", "ydpi", "cloudProvider", "", "getCloudProvider", "()Ljava/lang/String;", "isLoading", "", "folders", "", "Lcom/myscript/nebo/dms/core/model/FolderModel;", "collections", "Lcom/myscript/nebo/dms/core/model/CollectionModel;", "currentFolder", "currentFolderName", "getCurrentFolderName", "pages", "Lcom/myscript/nebo/dms/core/model/PageModel;", "_trashedCollectionsState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/trash/TrashedCollectionsUIState;", "kotlin.jvm.PlatformType", "trashedCollectionsState", "Landroidx/lifecycle/LiveData;", "getTrashedCollectionsState", "()Landroidx/lifecycle/LiveData;", "_trashedPagesState", "Lcom/myscript/nebo/trash/TrashedPagesUIState;", "trashedPagesState", "getTrashedPagesState", "selectedFolders", "", "selectedFoldersCount", "", "getSelectedFoldersCount", "()I", "isFoldersSelectionMode", "enableFoldersMenuActions", "getEnableFoldersMenuActions", "()Z", "enableSelectAllFolders", "getEnableSelectAllFolders", "selectedPages", "selectedPagesCount", "getSelectedPagesCount", "isPagesSelectionMode", "enablePagesMenuActions", "getEnablePagesMenuActions", "enableSelectAllPages", "getEnableSelectAllPages", "value", "Lcom/myscript/nebo/grid/DisplayMode;", "currentDisplayMode", "setCurrentDisplayMode", "(Lcom/myscript/nebo/grid/DisplayMode;)V", "onTrashUpdate", "com/myscript/nebo/trash/TrashViewModel$onTrashUpdate$1", "Lcom/myscript/nebo/trash/TrashViewModel$onTrashUpdate$1;", "onThumbnailReady", "Lcom/myscript/snt/core/IThumbnailerNotificationListener;", "preferencesChangedListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "updateTrash", "", "activateFoldersSelectionMode", "selectionModeActivated", "activatePagesSelectionMode", "onFolderClicked", "folder", "togglePageSelection", "toggledPage", "update", "pageModel", "updateBlock", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "findFolder", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "toggleFolderSelection", "toggledFolder", "updateUIStates", "updateTrashedCollectionsUIState", "updateTrashedPagesUIState", "onCleared", "selectAllFolders", "deselectAllFolders", "selectAllPages", "deselectAllPages", "emptyTrash", "restoreAllPages", "restoreAllCollections", "deleteAllPages", "deleteSelectedFolders", "restoreSelectedFolders", "deleteSelectedPages", "restoreSelectedPages", "deleteCollection", "collectionKey", "Lcom/myscript/snt/core/CollectionKey;", "restoreCollection", "requestThumbnail", "toggleTrashDisplayMode", "updateThumbnail", "pageKey", "Lcom/myscript/snt/core/PageKey;", "thumbnailPath", "setThumbnailConfiguration", "metrics", "Landroid/util/DisplayMetrics;", "getPreferredDisplayMode", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TrashViewModel extends ViewModel {
    private static final ViewModelProvider.Factory Factory;
    private final MutableLiveData<TrashedCollectionsUIState> _trashedCollectionsState;
    private final MutableLiveData<TrashedPagesUIState> _trashedPagesState;
    private final CloudManager cloudManager;
    private List<CollectionModel> collections;
    private DisplayMode currentDisplayMode;
    private FolderModel currentFolder;
    private List<FolderModel> folders;
    private boolean isFoldersSelectionMode;
    private boolean isLoading;
    private boolean isPagesSelectionMode;
    private final CoroutineDispatcher mainDispatcher;
    private final IThumbnailerNotificationListener onThumbnailReady;
    private final TrashViewModel$onTrashUpdate$1 onTrashUpdate;
    private List<PageModel> pages;
    private final SharedPreferences.OnSharedPreferenceChangeListener preferencesChangedListener;
    private final LibraryRepository repository;
    private List<FolderModel> selectedFolders;
    private List<PageModel> selectedPages;
    private final SharedPreferences sharedPreferences;
    private final CoroutineDispatcher workDispatcher;
    private float xdpi;
    private float ydpi;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: Type inference failed for: r12v14, types: [com.myscript.nebo.trash.TrashViewModel$onTrashUpdate$1] */
    public TrashViewModel(LibraryRepository repository, CloudManager cloudManager, SharedPreferences sharedPreferences, CoroutineDispatcher mainDispatcher, CoroutineDispatcher workDispatcher) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(cloudManager, "cloudManager");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(workDispatcher, "workDispatcher");
        this.repository = repository;
        this.cloudManager = cloudManager;
        this.sharedPreferences = sharedPreferences;
        this.mainDispatcher = mainDispatcher;
        this.workDispatcher = workDispatcher;
        this.isLoading = true;
        this.folders = CollectionsKt.emptyList();
        this.collections = new ArrayList();
        this.pages = CollectionsKt.emptyList();
        this._trashedCollectionsState = new MutableLiveData<>(new TrashedCollectionsUIState(null, false, false, false, 0, 31, null));
        this._trashedPagesState = new MutableLiveData<>(new TrashedPagesUIState(null, null, 0, false, false, false, null, 127, null));
        this.selectedFolders = new ArrayList();
        this.selectedPages = new ArrayList();
        this.currentDisplayMode = DisplayMode.Grid.INSTANCE;
        ?? r12 = new LibraryRepository.TrashListener() { // from class: com.myscript.nebo.trash.TrashViewModel$onTrashUpdate$1
            @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
            public void collectionDeleted(CollectionKey collectionKey, List<? extends NotebookKey> notebooksDeleted, List<? extends PageKey> pagesDeleted) {
                Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
                Intrinsics.checkNotNullParameter(notebooksDeleted, "notebooksDeleted");
                Intrinsics.checkNotNullParameter(pagesDeleted, "pagesDeleted");
                this.this$0.updateTrash();
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
            public void collectionsRenamed(List<? extends CollectionKey> collectionKeys) {
                Intrinsics.checkNotNullParameter(collectionKeys, "collectionKeys");
                this.this$0.updateTrash();
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
            public void collectionsUpdated(List<? extends CollectionKey> collectionKeys) {
                Intrinsics.checkNotNullParameter(collectionKeys, "collectionKeys");
                this.this$0.updateTrash();
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
            public void folderDeleted(NotebookKey notebookKey, CollectionKey collectionKey, List<? extends PageKey> pagesDeleted) {
                Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
                Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
                Intrinsics.checkNotNullParameter(pagesDeleted, "pagesDeleted");
                this.this$0.updateTrash();
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
            public void foldersRenamed(List<? extends NotebookKey> notebookKeys) {
                Intrinsics.checkNotNullParameter(notebookKeys, "notebookKeys");
                this.this$0.updateTrash();
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
            public void foldersUpdated(List<? extends NotebookKey> notebookKeys) {
                Intrinsics.checkNotNullParameter(notebookKeys, "notebookKeys");
                this.this$0.updateTrash();
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
            public void folderMoved(CollectionKey previousCollectionKey, NotebookKey notebookKey) {
                Intrinsics.checkNotNullParameter(previousCollectionKey, "previousCollectionKey");
                this.this$0.updateTrash();
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
            public void pageDeleted(PageKey pageKey, NotebookKey parentNotebookKey) {
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
                Intrinsics.checkNotNullParameter(parentNotebookKey, "parentNotebookKey");
                this.this$0.updateTrash();
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
            public void pageDeleted(PageKey pageKey, PageKey parentPageKey) {
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
                Intrinsics.checkNotNullParameter(parentPageKey, "parentPageKey");
                this.this$0.updateTrash();
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
            public void pageMoved(NotebookKey previousParentNotebookKey, PageKey pageKey) {
                Intrinsics.checkNotNullParameter(previousParentNotebookKey, "previousParentNotebookKey");
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
                this.this$0.updateTrash();
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
            public void pageMoved(PageKey previousParentPageKey, PageKey pageKey) {
                Intrinsics.checkNotNullParameter(previousParentPageKey, "previousParentPageKey");
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
                this.this$0.updateTrash();
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
            public void pagesUpdated(List<? extends PageKey> pageKeys) {
                Intrinsics.checkNotNullParameter(pageKeys, "pageKeys");
                this.this$0.updateTrash();
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
            public void trashed(List<? extends CollectionKey> trashedCollectionKeys, List<? extends NotebookKey> trashedNotebookKeys, List<? extends PageKey> trashedPageKeys) {
                Intrinsics.checkNotNullParameter(trashedCollectionKeys, "trashedCollectionKeys");
                Intrinsics.checkNotNullParameter(trashedNotebookKeys, "trashedNotebookKeys");
                Intrinsics.checkNotNullParameter(trashedPageKeys, "trashedPageKeys");
                this.this$0.updateTrash();
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.TrashListener
            public void restored(List<? extends CollectionKey> restoredCollectionKeys, List<? extends NotebookKey> trashedNotebookKeys, List<? extends PageKey> trashedPageKeys) {
                Intrinsics.checkNotNullParameter(restoredCollectionKeys, "restoredCollectionKeys");
                Intrinsics.checkNotNullParameter(trashedNotebookKeys, "trashedNotebookKeys");
                Intrinsics.checkNotNullParameter(trashedPageKeys, "trashedPageKeys");
                this.this$0.updateTrash();
            }
        };
        this.onTrashUpdate = r12;
        IThumbnailerNotificationListener iThumbnailerNotificationListener = new IThumbnailerNotificationListener() { // from class: com.myscript.nebo.trash.TrashViewModel$$ExternalSyntheticLambda2
            @Override // com.myscript.snt.core.IThumbnailerNotificationListener
            public final void thumbnailCreated(PageKey pageKey, String str, boolean z) {
                TrashViewModel.onThumbnailReady$lambda$0(this.f$0, pageKey, str, z);
            }
        };
        this.onThumbnailReady = iThumbnailerNotificationListener;
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.myscript.nebo.trash.TrashViewModel$$ExternalSyntheticLambda3
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                TrashViewModel.preferencesChangedListener$lambda$0(this.f$0, sharedPreferences2, str);
            }
        };
        this.preferencesChangedListener = onSharedPreferenceChangeListener;
        setCurrentDisplayMode(getPreferredDisplayMode());
        repository.addTrashListener((LibraryRepository.TrashListener) r12);
        repository.addThumbnailListener(iThumbnailerNotificationListener);
        updateTrash();
        if (sharedPreferences != null) {
            sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }

    public /* synthetic */ TrashViewModel(LibraryRepository libraryRepository, CloudManager cloudManager, SharedPreferences sharedPreferences, MainCoroutineDispatcher mainCoroutineDispatcher, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(libraryRepository, cloudManager, (i & 4) != 0 ? null : sharedPreferences, (i & 8) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher, (i & 16) != 0 ? Dispatchers.getDefault() : coroutineDispatcher);
    }

    public final String getCloudProvider() {
        return this.cloudManager.getProviderName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCurrentFolderName() {
        String name;
        FolderModel folderModel = this.currentFolder;
        return (folderModel == null || (name = folderModel.getName()) == null) ? "" : name;
    }

    public final LiveData<TrashedCollectionsUIState> getTrashedCollectionsState() {
        return this._trashedCollectionsState;
    }

    public final LiveData<TrashedPagesUIState> getTrashedPagesState() {
        return this._trashedPagesState;
    }

    public final int getSelectedFoldersCount() {
        return this.selectedFolders.size();
    }

    public final boolean getEnableFoldersMenuActions() {
        return this.isFoldersSelectionMode ? !this.selectedFolders.isEmpty() : !this.collections.isEmpty();
    }

    public final boolean getEnableSelectAllFolders() {
        int size = this.selectedFolders.size();
        List<CollectionModel> list = this.collections;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((CollectionModel) it.next()).getFolders());
        }
        return size != arrayList.size();
    }

    public final int getSelectedPagesCount() {
        return this.selectedPages.size();
    }

    public final boolean getEnablePagesMenuActions() {
        return this.isPagesSelectionMode ? !this.selectedPages.isEmpty() : !this.pages.isEmpty();
    }

    public final boolean getEnableSelectAllPages() {
        return this.selectedPages.size() != this.pages.size();
    }

    private final void setCurrentDisplayMode(DisplayMode displayMode) {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(DisplayMode.PREF_FOLDER_DISPLAY_MODE_KEY, displayMode.getName());
            editorEdit.apply();
        }
        this.currentDisplayMode = displayMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onThumbnailReady$lambda$0(TrashViewModel trashViewModel, PageKey pageKey, String str, boolean z) {
        if (z) {
            Intrinsics.checkNotNull(pageKey);
            Intrinsics.checkNotNull(str);
            trashViewModel.updateThumbnail(pageKey, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preferencesChangedListener$lambda$0(TrashViewModel trashViewModel, SharedPreferences sharedPreferences, String str) {
        DisplayMode.Grid displayMode$default;
        String string;
        if (str != null && str.hashCode() == -1908392395 && str.equals(DisplayMode.PREF_FOLDER_DISPLAY_MODE_KEY)) {
            SharedPreferences sharedPreferences2 = trashViewModel.sharedPreferences;
            if (sharedPreferences2 == null || (string = sharedPreferences2.getString(DisplayMode.PREF_FOLDER_DISPLAY_MODE_KEY, DisplayMode.Grid.INSTANCE.getName())) == null || (displayMode$default = DisplayMode.toDisplayMode$default(DisplayMode.Grid.INSTANCE, string, null, 1, null)) == null) {
                displayMode$default = DisplayMode.Grid.INSTANCE;
            }
            trashViewModel.setCurrentDisplayMode(displayMode$default);
            trashViewModel.updateTrashedPagesUIState();
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.trash.TrashViewModel$updateTrash$1 */
    /* JADX INFO: compiled from: TrashViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.trash.TrashViewModel$updateTrash$1", m1609f = "TrashViewModel.kt", m1610i = {}, m1611l = {214, 227}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {220, 230}, m1615s = {}, m1616v = 2)
    static final class C68571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C68571(Continuation<? super C68571> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TrashViewModel.this.new C68571(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x00f8 A[LOOP:3: B:40:0x00f2->B:42:0x00f8, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0118  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0171  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            TrashViewModel trashViewModel;
            Object objWithContext;
            Object next;
            FolderModel folder;
            Iterator it;
            Object objWithContext2;
            TrashViewModel trashViewModel2;
            Object next2;
            PageModel pageModelCopy$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                trashViewModel = TrashViewModel.this;
                this.L$0 = trashViewModel;
                this.label = 1;
                objWithContext = BuildersKt.withContext(trashViewModel.workDispatcher, new AnonymousClass1(TrashViewModel.this, null), this);
                if (objWithContext != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                trashViewModel2 = (TrashViewModel) this.L$0;
                ResultKt.throwOnFailure(obj);
                objWithContext2 = obj;
                Iterable<PageModel> iterable = (Iterable) objWithContext2;
                TrashViewModel trashViewModel3 = TrashViewModel.this;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (PageModel pageModel : iterable) {
                    File file = new File(trashViewModel3.repository.getThumbnailPath(pageModel.getPageKey(), pageModel.getLastModificationDate()));
                    if (file.isFile()) {
                        pageModelCopy$default = PageModel.copy$default(pageModel, null, null, false, false, false, false, 0L, 0, 0L, 0L, 0L, null, null, false, null, null, 0, 0, null, 0, false, false, null, file, GroupFlagsSpec.CHILD_NODE_COUNT_MASK, null);
                    } else {
                        pageModelCopy$default = PageModel.copy$default(pageModel, null, null, false, false, false, false, 0L, 0, 0L, 0L, 0L, null, null, false, null, null, 0, 0, null, 0, false, false, null, null, ViewCompat.MEASURED_SIZE_MASK, null);
                    }
                    arrayList.add(pageModelCopy$default);
                }
                trashViewModel2.pages = arrayList;
                TrashViewModel.this.isLoading = false;
                TrashViewModel.this.updateUIStates();
                return Unit.INSTANCE;
            }
            trashViewModel = (TrashViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
            objWithContext = obj;
            trashViewModel.collections = (List) objWithContext;
            TrashViewModel trashViewModel4 = TrashViewModel.this;
            FolderModel folderModel = trashViewModel4.currentFolder;
            if (folderModel != null) {
                List list = TrashViewModel.this.collections;
                ArrayList arrayList2 = new ArrayList();
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    CollectionsKt.addAll(arrayList2, ((CollectionModel) it2.next()).getFolders());
                }
                Iterator it3 = arrayList2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it3.next();
                    if (Intrinsics.areEqual(((FolderModel) next2).getNotebookKey(), folderModel.getNotebookKey())) {
                        break;
                    }
                }
                folder = (FolderModel) next2;
                if (folder == null) {
                }
                trashViewModel4.currentFolder = folder;
                List list2 = TrashViewModel.this.collections;
                ArrayList<FolderModel> arrayList3 = new ArrayList();
                it = list2.iterator();
                while (it.hasNext()) {
                    CollectionsKt.addAll(arrayList3, ((CollectionModel) it.next()).getFolders());
                }
                TrashViewModel trashViewModel5 = TrashViewModel.this;
                for (FolderModel folderModel2 : arrayList3) {
                    NotebookKey notebookKey = folderModel2.getNotebookKey();
                    FolderModel folderModel3 = trashViewModel5.currentFolder;
                    folderModel2.setOpened(Intrinsics.areEqual(notebookKey, folderModel3 != null ? folderModel3.getNotebookKey() : null));
                }
                TrashViewModel trashViewModel6 = TrashViewModel.this;
                this.L$0 = trashViewModel6;
                this.label = 2;
                objWithContext2 = BuildersKt.withContext(trashViewModel6.workDispatcher, new AnonymousClass6(TrashViewModel.this, null), this);
                if (objWithContext2 != coroutine_suspended) {
                    trashViewModel2 = trashViewModel6;
                    Iterable<PageModel> iterable2 = (Iterable) objWithContext2;
                    TrashViewModel trashViewModel32 = TrashViewModel.this;
                    ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                    while (r4.hasNext()) {
                    }
                    trashViewModel2.pages = arrayList4;
                    TrashViewModel.this.isLoading = false;
                    TrashViewModel.this.updateUIStates();
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
            Iterator it4 = TrashViewModel.this.collections.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    next = null;
                    break;
                }
                next = it4.next();
                if (!((CollectionModel) next).isEmpty()) {
                    break;
                }
            }
            CollectionModel collectionModel = (CollectionModel) next;
            folder = collectionModel != null ? collectionModel.getFolder(0) : null;
            trashViewModel4.currentFolder = folder;
            List list22 = TrashViewModel.this.collections;
            ArrayList<FolderModel> arrayList32 = new ArrayList();
            it = list22.iterator();
            while (it.hasNext()) {
            }
            TrashViewModel trashViewModel52 = TrashViewModel.this;
            while (r5.hasNext()) {
            }
            TrashViewModel trashViewModel62 = TrashViewModel.this;
            this.L$0 = trashViewModel62;
            this.label = 2;
            objWithContext2 = BuildersKt.withContext(trashViewModel62.workDispatcher, new AnonymousClass6(TrashViewModel.this, null), this);
            if (objWithContext2 != coroutine_suspended) {
            }
            return coroutine_suspended;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.trash.TrashViewModel$updateTrash$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: TrashViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "Lcom/myscript/nebo/dms/core/model/CollectionModel;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.trash.TrashViewModel$updateTrash$1$1", m1609f = "TrashViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<CollectionModel>>, Object> {
            int label;
            final /* synthetic */ TrashViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TrashViewModel trashViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = trashViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<CollectionModel>> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    List mutableList = CollectionsKt.toMutableList((Collection) this.this$0.repository.getCollectionModels(DMSFilter.TRASH));
                    TrashViewModel trashViewModel = this.this$0;
                    ArrayList arrayList = new ArrayList();
                    Iterator it = mutableList.iterator();
                    while (it.hasNext()) {
                        CollectionsKt.addAll(arrayList, ((CollectionModel) it.next()).getFolders());
                    }
                    trashViewModel.folders = arrayList;
                    return mutableList;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.myscript.nebo.trash.TrashViewModel$updateTrash$1$6, reason: invalid class name */
        /* JADX INFO: compiled from: TrashViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "Lcom/myscript/nebo/dms/core/model/PageModel;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.trash.TrashViewModel$updateTrash$1$6", m1609f = "TrashViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PageModel>>, Object> {
            int label;
            final /* synthetic */ TrashViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass6(TrashViewModel trashViewModel, Continuation<? super AnonymousClass6> continuation) {
                super(2, continuation);
                this.this$0 = trashViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass6(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends PageModel>> continuation) {
                return invoke2(coroutineScope, (Continuation<? super List<PageModel>>) continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<PageModel>> continuation) {
                return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                NotebookKey notebookKey;
                List<PageModel> pages;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    FolderModel folderModel = this.this$0.currentFolder;
                    return (folderModel == null || (notebookKey = folderModel.getNotebookKey()) == null || (pages = this.this$0.repository.getPages(notebookKey, DMSFilter.TRASH)) == null) ? CollectionsKt.emptyList() : pages;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTrash() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C68571(null), 2, null);
    }

    public final void activateFoldersSelectionMode(boolean selectionModeActivated) {
        if (selectionModeActivated == this.isFoldersSelectionMode) {
            return;
        }
        activatePagesSelectionMode(false);
        this.isFoldersSelectionMode = selectionModeActivated;
        if (!selectionModeActivated) {
            this.selectedFolders.clear();
        }
        List<CollectionModel> list = this.collections;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((CollectionModel) it.next()).getFolders());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((FolderModel) it2.next()).setSelectionState(this.isFoldersSelectionMode ? SelectionState.UNSELECTED : SelectionState.NOT_SELECTABLE);
        }
        updateTrashedCollectionsUIState();
    }

    public final void activatePagesSelectionMode(boolean selectionModeActivated) {
        if (selectionModeActivated == this.isPagesSelectionMode) {
            return;
        }
        activateFoldersSelectionMode(false);
        this.isPagesSelectionMode = selectionModeActivated;
        if (!selectionModeActivated) {
            this.selectedPages.clear();
        }
        List<PageModel> list = this.pages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(PageModel.copy$default((PageModel) it.next(), null, null, false, false, false, false, 0L, 0, 0L, 0L, 0L, null, null, false, null, null, 0, 0, null, 0, false, false, this.isPagesSelectionMode ? SelectionState.UNSELECTED : SelectionState.NOT_SELECTABLE, null, 12582911, null));
        }
        this.pages = arrayList;
        updateTrashedPagesUIState();
    }

    public final boolean onFolderClicked(FolderModel folder) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        if (this.isFoldersSelectionMode) {
            toggleFolderSelection(folder);
            return true;
        }
        if (Intrinsics.areEqual(this.currentFolder, folder)) {
            return true;
        }
        this.currentFolder = folder;
        activatePagesSelectionMode(false);
        updateTrash();
        return true;
    }

    public final void togglePageSelection(PageModel toggledPage) {
        Object obj;
        Object next;
        Intrinsics.checkNotNullParameter(toggledPage, "toggledPage");
        if (this.isPagesSelectionMode) {
            Iterator<T> it = this.pages.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((PageModel) next).getPageKey(), toggledPage.getPageKey())) {
                        break;
                    }
                }
            }
            final PageModel pageModel = (PageModel) next;
            if (pageModel == null) {
                return;
            }
            if (pageModel.getIsSelected()) {
                List<PageModel> list = this.selectedPages;
                List<PageModel> list2 = list;
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next2 = it2.next();
                    if (Intrinsics.areEqual(((PageModel) next2).getPageKey(), toggledPage.getPageKey())) {
                        obj = next2;
                        break;
                    }
                }
                TypeIntrinsics.asMutableCollection(list2).remove(obj);
            } else {
                this.selectedPages.add(pageModel);
            }
            if (this.isPagesSelectionMode && this.selectedPages.isEmpty()) {
                activatePagesSelectionMode(false);
                return;
            }
            if (!this.isPagesSelectionMode && !this.selectedPages.isEmpty()) {
                activatePagesSelectionMode(true);
            }
            this.pages = update(this.pages, pageModel, new Function1() { // from class: com.myscript.nebo.trash.TrashViewModel$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TrashViewModel.togglePageSelection$lambda$2(pageModel, (PageModel) obj2);
                }
            });
            updateTrashedPagesUIState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageModel togglePageSelection$lambda$2(PageModel pageModel, PageModel update) {
        Intrinsics.checkNotNullParameter(update, "$this$update");
        return PageModel.copy$default(update, null, null, false, false, false, false, 0L, 0, 0L, 0L, 0L, null, null, false, null, null, 0, 0, null, 0, false, false, pageModel.getSelectionState() == SelectionState.UNSELECTED ? SelectionState.SELECTED : SelectionState.UNSELECTED, null, 12582911, null);
    }

    private final List<PageModel> update(List<PageModel> list, PageModel pageModel, Function1<? super PageModel, PageModel> function1) {
        List<PageModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (PageModel pageModelInvoke : list2) {
            if (Intrinsics.areEqual(pageModelInvoke, pageModel)) {
                pageModelInvoke = function1.invoke(pageModelInvoke);
            }
            arrayList.add(pageModelInvoke);
        }
        return arrayList;
    }

    private final FolderModel findFolder(NotebookKey notebookKey) {
        FolderModel folderModel;
        Iterator<T> it = this.collections.iterator();
        do {
            folderModel = null;
            Object obj = null;
            if (!it.hasNext()) {
                break;
            }
            Iterator<T> it2 = ((CollectionModel) it.next()).getFolders().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (Intrinsics.areEqual(((FolderModel) next).getNotebookKey(), notebookKey)) {
                    obj = next;
                    break;
                }
            }
            folderModel = (FolderModel) obj;
        } while (folderModel == null);
        return folderModel;
    }

    public final void toggleFolderSelection(FolderModel toggledFolder) {
        Intrinsics.checkNotNullParameter(toggledFolder, "toggledFolder");
        FolderModel folderModelFindFolder = findFolder(toggledFolder.getNotebookKey());
        if (folderModelFindFolder != null) {
            if (folderModelFindFolder.getSelectionState() != SelectionState.SELECTED) {
                this.selectedFolders.add(folderModelFindFolder);
            } else {
                this.selectedFolders.remove(folderModelFindFolder);
            }
            if (this.isFoldersSelectionMode && this.selectedFolders.isEmpty()) {
                activateFoldersSelectionMode(false);
                return;
            }
            if (!this.isFoldersSelectionMode && !this.selectedFolders.isEmpty()) {
                activateFoldersSelectionMode(true);
            }
            folderModelFindFolder.setSelectionState(toggledFolder.getSelectionState() == SelectionState.UNSELECTED ? SelectionState.SELECTED : SelectionState.UNSELECTED);
            updateTrashedCollectionsUIState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUIStates() {
        updateTrashedCollectionsUIState();
        updateTrashedPagesUIState();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.trash.TrashViewModel$updateTrashedCollectionsUIState$1 */
    /* JADX INFO: compiled from: TrashViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.trash.TrashViewModel$updateTrashedCollectionsUIState$1", m1609f = "TrashViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C68581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C68581(Continuation<? super C68581> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TrashViewModel.this.new C68581(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TrashViewModel.this._trashedCollectionsState.setValue(new TrashedCollectionsUIState(TrashViewModel.this.collections, TrashViewModel.this.collections.isEmpty() && !TrashViewModel.this.isLoading, TrashViewModel.this.isLoading, TrashViewModel.this.isFoldersSelectionMode, TrashViewModel.this.selectedFolders.size()));
            return Unit.INSTANCE;
        }
    }

    private final void updateTrashedCollectionsUIState() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C68581(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.trash.TrashViewModel$updateTrashedPagesUIState$1 */
    /* JADX INFO: compiled from: TrashViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.trash.TrashViewModel$updateTrashedPagesUIState$1", m1609f = "TrashViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C68591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C68591(Continuation<? super C68591> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TrashViewModel.this.new C68591(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData = TrashViewModel.this._trashedPagesState;
                String currentFolderName = TrashViewModel.this.getCurrentFolderName();
                PersistentList persistentList = ExtensionsKt.toPersistentList(TrashViewModel.this.pages);
                FolderModel folderModel = TrashViewModel.this.currentFolder;
                mutableLiveData.setValue(new TrashedPagesUIState(currentFolderName, persistentList, folderModel != null ? folderModel.getRemainingPagesCount() : 0, TrashViewModel.this.isLoading, TrashViewModel.this.isPagesSelectionMode, TrashViewModel.this.collections.isEmpty(), TrashViewModel.this.currentDisplayMode));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void updateTrashedPagesUIState() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C68591(null), 3, null);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.repository.setThumbnailImageRequester(null);
        this.repository.removeThumbnailListener(this.onThumbnailReady);
        this.repository.removeTrashListener(this.onTrashUpdate);
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(this.preferencesChangedListener);
        }
        super.onCleared();
    }

    public final void selectAllFolders() {
        if (this.isFoldersSelectionMode) {
            this.selectedFolders.clear();
            Iterator<T> it = this.collections.iterator();
            while (it.hasNext()) {
                for (FolderModel folderModel : ((CollectionModel) it.next()).getFolders()) {
                    folderModel.setSelectionState(SelectionState.SELECTED);
                    this.selectedFolders.add(folderModel);
                }
            }
            updateTrashedCollectionsUIState();
            return;
        }
        if (this.isPagesSelectionMode) {
            List<PageModel> list = this.pages;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(PageModel.copy$default((PageModel) it2.next(), null, null, false, false, false, false, 0L, 0, 0L, 0L, 0L, null, null, false, null, null, 0, 0, null, 0, false, false, SelectionState.SELECTED, null, 12582911, null));
            }
            this.selectedPages = CollectionsKt.toMutableList((Collection) arrayList);
            updateTrashedPagesUIState();
        }
    }

    public final void deselectAllFolders() {
        if (!this.isFoldersSelectionMode) {
            if (this.isPagesSelectionMode) {
                List<PageModel> list = this.pages;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(PageModel.copy$default((PageModel) it.next(), null, null, false, false, false, false, 0L, 0, 0L, 0L, 0L, null, null, false, null, null, 0, 0, null, 0, false, false, SelectionState.UNSELECTED, null, 12582911, null));
                }
                this.selectedPages = CollectionsKt.toMutableList((Collection) arrayList);
                updateTrashedPagesUIState();
                return;
            }
            return;
        }
        Iterator<T> it2 = this.collections.iterator();
        while (it2.hasNext()) {
            Iterator<T> it3 = ((CollectionModel) it2.next()).getFolders().iterator();
            while (it3.hasNext()) {
                ((FolderModel) it3.next()).setSelectionState(SelectionState.UNSELECTED);
            }
        }
        this.selectedFolders.clear();
        updateTrashedCollectionsUIState();
    }

    public final void selectAllPages() {
        if (this.isPagesSelectionMode) {
            List<PageModel> list = this.pages;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(PageModel.copy$default((PageModel) it.next(), null, null, false, false, false, false, 0L, 0, 0L, 0L, 0L, null, null, false, null, null, 0, 0, null, 0, false, false, SelectionState.SELECTED, null, 12582911, null));
            }
            List<PageModel> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
            this.pages = mutableList;
            this.selectedPages = CollectionsKt.toMutableList((Collection) mutableList);
            updateTrashedPagesUIState();
        }
    }

    public final void deselectAllPages() {
        if (this.isPagesSelectionMode) {
            List<PageModel> list = this.pages;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(PageModel.copy$default((PageModel) it.next(), null, null, false, false, false, false, 0L, 0, 0L, 0L, 0L, null, null, false, null, null, 0, 0, null, 0, false, false, SelectionState.UNSELECTED, null, 12582911, null));
            }
            this.pages = arrayList;
            this.selectedPages.clear();
            updateTrashedPagesUIState();
        }
    }

    public final void emptyTrash() {
        this.repository.emptyTrash();
    }

    public final void restoreAllPages() {
        LibraryRepository libraryRepository = this.repository;
        List<PageModel> list = this.pages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((PageModel) it.next()).getPageKey());
        }
        libraryRepository.restorePages(arrayList);
    }

    public final void restoreAllCollections() {
        this.repository.restoreAll();
    }

    public final void deleteAllPages() {
        LibraryRepository libraryRepository = this.repository;
        List<PageModel> list = this.pages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((PageModel) it.next()).getPageKey());
        }
        libraryRepository.deletePagesPermanently(arrayList);
    }

    public final void deleteSelectedFolders() {
        LibraryRepository libraryRepository = this.repository;
        List<FolderModel> list = this.selectedFolders;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((FolderModel) it.next()).getNotebookKey());
        }
        libraryRepository.deleteFoldersPermanently(arrayList);
        activateFoldersSelectionMode(false);
    }

    public final void restoreSelectedFolders() {
        LibraryRepository libraryRepository = this.repository;
        List<FolderModel> list = this.selectedFolders;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((FolderModel) it.next()).getNotebookKey());
        }
        libraryRepository.restoreFolders(arrayList);
        activateFoldersSelectionMode(false);
    }

    public final void deleteSelectedPages() {
        LibraryRepository libraryRepository = this.repository;
        List<PageModel> list = this.selectedPages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((PageModel) it.next()).getPageKey());
        }
        libraryRepository.deletePagesPermanently(arrayList);
        activatePagesSelectionMode(false);
    }

    public final void restoreSelectedPages() {
        LibraryRepository libraryRepository = this.repository;
        List<PageModel> list = this.selectedPages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((PageModel) it.next()).getPageKey());
        }
        libraryRepository.restorePages(arrayList);
        activatePagesSelectionMode(false);
    }

    public final void deleteCollection(CollectionKey collectionKey) {
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        this.repository.deleteCollectionPermanently(collectionKey);
    }

    public final void restoreCollection(CollectionKey collectionKey) {
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        this.repository.restoreCollection(collectionKey);
    }

    public final void requestThumbnail(PageModel pageModel) {
        Intrinsics.checkNotNullParameter(pageModel, "pageModel");
        String thumbnailPath = this.repository.getThumbnailPath(pageModel.getPageKey(), pageModel.getLastModificationDate());
        if (pageModel.isEmpty()) {
            return;
        }
        boolean zIsFile = new File(thumbnailPath).isFile();
        PageKey pageKey = pageModel.getPageKey();
        if (!zIsFile) {
            this.repository.createThumbnail(pageKey);
        } else {
            updateThumbnail(pageKey, thumbnailPath);
        }
    }

    public final void toggleTrashDisplayMode() {
        setCurrentDisplayMode(this.currentDisplayMode instanceof DisplayMode.Grid ? DisplayMode.List.INSTANCE : DisplayMode.Grid.INSTANCE);
        updateTrashedPagesUIState();
    }

    private final void updateThumbnail(PageKey pageKey, String thumbnailPath) {
        File file;
        ArrayList arrayList;
        File file2 = new File(thumbnailPath);
        if (file2.isFile()) {
            List<PageModel> list = this.pages;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (PageModel pageModelCopy$default : list) {
                if (Intrinsics.areEqual(pageModelCopy$default.getPageKey(), pageKey)) {
                    file = file2;
                    arrayList = arrayList2;
                    pageModelCopy$default = PageModel.copy$default(pageModelCopy$default, null, null, false, false, false, false, 0L, 0, 0L, 0L, 0L, null, null, false, null, null, 0, 0, null, 0, false, false, null, file, GroupFlagsSpec.CHILD_NODE_COUNT_MASK, null);
                } else {
                    file = file2;
                    arrayList = arrayList2;
                }
                arrayList.add(pageModelCopy$default);
                arrayList2 = arrayList;
                file2 = file;
            }
            this.pages = arrayList2;
            updateTrashedPagesUIState();
        }
    }

    public static /* synthetic */ void setThumbnailConfiguration$default(TrashViewModel trashViewModel, DisplayMetrics displayMetrics, int i, Object obj) {
        if ((i & 1) != 0) {
            displayMetrics = null;
        }
        trashViewModel.setThumbnailConfiguration(displayMetrics);
    }

    public final void setThumbnailConfiguration(DisplayMetrics metrics) {
        if (metrics != null) {
            this.xdpi = metrics.xdpi;
            this.ydpi = metrics.ydpi;
        }
    }

    private final DisplayMode getPreferredDisplayMode() {
        DisplayMode.Grid grid = DisplayMode.Grid.INSTANCE;
        SharedPreferences sharedPreferences = this.sharedPreferences;
        return DisplayMode.toDisplayMode$default(grid, sharedPreferences != null ? sharedPreferences.getString(DisplayMode.PREF_FOLDER_DISPLAY_MODE_KEY, null) : null, null, 1, null);
    }

    /* JADX INFO: compiled from: TrashViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/trash/TrashViewModel$Companion;", "", "<init>", "()V", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewModelProvider.Factory getFactory() {
            return TrashViewModel.Factory;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TrashViewModel Factory$lambda$0$0(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        Object objRequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
        Intrinsics.checkNotNull(objRequireApplication, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
        return new TrashViewModel(((LibraryRepository.Provider) objRequireApplication).provideLibraryRepository(), ((CloudManager.Provider) objRequireApplication).provideCloudManager(), PreferenceManager.getDefaultSharedPreferences((Context) objRequireApplication), null, null, 24, null);
    }

    static {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(TrashViewModel.class), new Function1() { // from class: com.myscript.nebo.trash.TrashViewModel$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TrashViewModel.Factory$lambda$0$0((CreationExtras) obj);
            }
        });
        Factory = initializerViewModelFactoryBuilder.build();
    }
}
