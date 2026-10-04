package com.myscript.nebo.editing;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.media3.extractor.p007ts.TsExtractor;
import androidx.preference.PreferenceManager;
import com.myscript.android.utils.SingleLiveEvent;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.discoverability.DiscoverabilityManager;
import com.myscript.nebo.discoverability.IDiscoverableFeature;
import com.myscript.nebo.discoverability.p024ui.TooltipUIState;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.TrashListenerAdapter;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.editing.discoverability.EditingDiscoverableFeature;
import com.myscript.nebo.editing.discoverability.TooltipUIStateKt;
import com.myscript.nebo.freemium.FreemiumBusinessModelStatus;
import com.myscript.nebo.p022ai.presentation.compose.AIContainerViewModel;
import com.myscript.nebo.purchase.ISubscriptionRepository;
import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.PageType;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: NoteEditorViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0003*-4\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001EB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020'J\u000e\u00106\u001a\u00020'2\u0006\u00107\u001a\u000208J\u0006\u00109\u001a\u00020'J\u000e\u0010:\u001a\u00020'2\u0006\u0010;\u001a\u00020<J\b\u0010=\u001a\u00020'H\u0017J\u000e\u0010>\u001a\u00020'2\u0006\u0010?\u001a\u00020@J\u000e\u0010A\u001a\u00020'2\u0006\u0010?\u001a\u00020@J\u0006\u0010B\u001a\u00020'J\u0006\u0010C\u001a\u00020'J\u0006\u0010D\u001a\u00020'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00138F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00138F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0010\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010.R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000700¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0010\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0004\n\u0002\u00105¨\u0006F"}, m1599d2 = {"Lcom/myscript/nebo/editing/NoteEditorViewModel;", "Landroidx/lifecycle/ViewModel;", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "discoverabilityManager", "Lcom/myscript/nebo/discoverability/DiscoverabilityManager;", "isFreemiumBusinessModelEnabled", "", "isAIEnabled", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "<init>", "(Lcom/myscript/nebo/dms/core/LibraryRepository;Lcom/myscript/nebo/discoverability/DiscoverabilityManager;ZZLkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_noteProperties", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/editing/NoteProperties;", "kotlin.jvm.PlatformType", "noteProperties", "Landroidx/lifecycle/LiveData;", "getNoteProperties", "()Landroidx/lifecycle/LiveData;", "openNoteProperties", "getOpenNoteProperties", "()Lcom/myscript/nebo/editing/NoteProperties;", "_discoveryTooltip", "Lcom/myscript/nebo/discoverability/ui/TooltipUIState;", "discoveryTooltip", "getDiscoveryTooltip", "_showPaywall", "showPaywall", "getShowPaywall", "_dataCollectVisible", "Lkotlinx/coroutines/flow/MutableStateFlow;", "dataCollectVisible", "Lkotlinx/coroutines/flow/StateFlow;", "getDataCollectVisible", "()Lkotlinx/coroutines/flow/StateFlow;", "showDataCollectDialog", "", "dismissDataCollectDialog", "noteListener", "com/myscript/nebo/editing/NoteEditorViewModel$noteListener$1", "Lcom/myscript/nebo/editing/NoteEditorViewModel$noteListener$1;", "trashListener", "com/myscript/nebo/editing/NoteEditorViewModel$trashListener$1", "Lcom/myscript/nebo/editing/NoteEditorViewModel$trashListener$1;", "cloudTokenExpiredNotification", "Lcom/myscript/android/utils/SingleLiveEvent;", "getCloudTokenExpiredNotification", "()Lcom/myscript/android/utils/SingleLiveEvent;", "onCloudExpired", "com/myscript/nebo/editing/NoteEditorViewModel$onCloudExpired$1", "Lcom/myscript/nebo/editing/NoteEditorViewModel$onCloudExpired$1;", "openNote", "pageKey", "Lcom/myscript/snt/core/PageKey;", "closeNote", "updateNoteName", "newName", "", "onCleared", "discover", "feature", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "setDiscoverable", "dismissCurrentTooltip", "initDiscoverability", "updateDiscoverableFeatures", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NoteEditorViewModel extends ViewModel {
    private static final ViewModelProvider.Factory Factory;
    private final MutableStateFlow<Boolean> _dataCollectVisible;
    private MutableLiveData<TooltipUIState> _discoveryTooltip;
    private final MutableLiveData<NoteProperties> _noteProperties;
    private final MutableLiveData<Boolean> _showPaywall;
    private final SingleLiveEvent<Boolean> cloudTokenExpiredNotification;
    private final StateFlow<Boolean> dataCollectVisible;
    private final DiscoverabilityManager discoverabilityManager;
    private final CoroutineDispatcher ioDispatcher;
    private final boolean isAIEnabled;
    private final boolean isFreemiumBusinessModelEnabled;
    private final LibraryRepository libraryRepository;
    private final CoroutineDispatcher mainDispatcher;
    private final NoteEditorViewModel$noteListener$1 noteListener;
    private final NoteEditorViewModel$onCloudExpired$1 onCloudExpired;
    private final NoteEditorViewModel$trashListener$1 trashListener;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: Type inference failed for: r10v6, types: [com.myscript.nebo.editing.NoteEditorViewModel$noteListener$1] */
    /* JADX WARN: Type inference failed for: r10v7, types: [com.myscript.nebo.editing.NoteEditorViewModel$trashListener$1] */
    /* JADX WARN: Type inference failed for: r10v9, types: [com.myscript.nebo.editing.NoteEditorViewModel$onCloudExpired$1] */
    public NoteEditorViewModel(LibraryRepository libraryRepository, DiscoverabilityManager discoverabilityManager, boolean z, boolean z2, CoroutineDispatcher mainDispatcher, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(libraryRepository, "libraryRepository");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.libraryRepository = libraryRepository;
        this.discoverabilityManager = discoverabilityManager;
        this.isFreemiumBusinessModelEnabled = z;
        this.isAIEnabled = z2;
        this.mainDispatcher = mainDispatcher;
        this.ioDispatcher = ioDispatcher;
        this._noteProperties = new MutableLiveData<>(new NoteProperties(null, null, null, null, null, 31, null));
        this._discoveryTooltip = new MutableLiveData<>(null);
        this._showPaywall = new MutableLiveData<>(false);
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._dataCollectVisible = MutableStateFlow;
        this.dataCollectVisible = MutableStateFlow;
        this.noteListener = new LibraryRepository.PageListener() { // from class: com.myscript.nebo.editing.NoteEditorViewModel$noteListener$1
            @Override // com.myscript.nebo.dms.core.LibraryRepository.PageListener
            public void onPageUpdated(PageKey pageKey) {
                PageModel page;
                FolderModel folder;
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
                if (Intrinsics.areEqual(pageKey, this.this$0.getOpenNoteProperties().getPageKey()) && (page = this.this$0.libraryRepository.getPage(pageKey)) != null) {
                    String noteName = this.this$0.getOpenNoteProperties().getNoteName();
                    String title = page.getTitle();
                    String lang = this.this$0.getOpenNoteProperties().getLang();
                    String languageTag = page.getLanguageTag();
                    String folderName = this.this$0.getOpenNoteProperties().getFolderName();
                    NotebookKey notebookKeyFromPageKey = this.this$0.libraryRepository.getNotebookKeyFromPageKey(pageKey);
                    String name = (notebookKeyFromPageKey == null || (folder = this.this$0.libraryRepository.getFolder(notebookKeyFromPageKey)) == null) ? null : folder.getName();
                    if (Intrinsics.areEqual(noteName, title) && Intrinsics.areEqual(lang, languageTag) && Intrinsics.areEqual(folderName, name)) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), null, null, new NoteEditorViewModel$noteListener$1$onPageUpdated$1(this.this$0, title, name, folderName, languageTag, null), 3, null);
                }
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.PageListener
            public void onPageDeleted(PageKey pageKey) {
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
                if (Intrinsics.areEqual(pageKey, this.this$0.getOpenNoteProperties().getPageKey())) {
                    this.this$0.libraryRepository.removePageListener(pageKey, this);
                    this.this$0.closeNote();
                }
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.PageListener
            public void onPageUUIDReset(PageKey previousKey, PageKey newKey) {
                Intrinsics.checkNotNullParameter(previousKey, "previousKey");
                Intrinsics.checkNotNullParameter(newKey, "newKey");
                if (Intrinsics.areEqual(previousKey, this.this$0.getOpenNoteProperties().getPageKey())) {
                    this.this$0.libraryRepository.removePageListener(previousKey, this);
                    this.this$0.closeNote();
                }
            }
        };
        this.trashListener = new TrashListenerAdapter() { // from class: com.myscript.nebo.editing.NoteEditorViewModel$trashListener$1
            @Override // com.myscript.nebo.dms.core.TrashListenerAdapter, com.myscript.nebo.dms.core.LibraryRepository.TrashListener
            public void trashed(List<? extends CollectionKey> trashedCollectionKeys, List<? extends NotebookKey> trashedNotebookKeys, List<? extends PageKey> trashedPageKeys) {
                Intrinsics.checkNotNullParameter(trashedCollectionKeys, "trashedCollectionKeys");
                Intrinsics.checkNotNullParameter(trashedNotebookKeys, "trashedNotebookKeys");
                Intrinsics.checkNotNullParameter(trashedPageKeys, "trashedPageKeys");
                if (CollectionsKt.contains(trashedPageKeys, this.this$0.getOpenNoteProperties().getPageKey())) {
                    this.this$0.libraryRepository.removeTrashListener(this);
                    this.this$0.closeNote();
                }
            }
        };
        this.cloudTokenExpiredNotification = new SingleLiveEvent<>();
        ?? r10 = new LibraryRepository.CloudTokenExpirationListener() { // from class: com.myscript.nebo.editing.NoteEditorViewModel$onCloudExpired$1
            @Override // com.myscript.nebo.dms.core.LibraryRepository.CloudTokenExpirationListener
            public void onCloudTokenExpired() {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new NoteEditorViewModel$onCloudExpired$1$onCloudTokenExpired$1(this.this$0, null), 2, null);
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.CloudTokenExpirationListener
            public void onValidCloudToken() {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new NoteEditorViewModel$onCloudExpired$1$onValidCloudToken$1(this.this$0, null), 2, null);
            }
        };
        this.onCloudExpired = r10;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), mainDispatcher, null, new C63781(null), 2, null);
        libraryRepository.addCloudTokenExpirationListener((LibraryRepository.CloudTokenExpirationListener) r10);
    }

    public /* synthetic */ NoteEditorViewModel(LibraryRepository libraryRepository, DiscoverabilityManager discoverabilityManager, boolean z, boolean z2, MainCoroutineDispatcher mainCoroutineDispatcher, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(libraryRepository, discoverabilityManager, z, z2, (i & 16) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher, (i & 32) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    public final LiveData<NoteProperties> getNoteProperties() {
        return this._noteProperties;
    }

    public final NoteProperties getOpenNoteProperties() {
        NoteProperties value = this._noteProperties.getValue();
        return value == null ? new NoteProperties(null, null, null, null, null, 31, null) : value;
    }

    public final LiveData<TooltipUIState> getDiscoveryTooltip() {
        return this._discoveryTooltip;
    }

    public final LiveData<Boolean> getShowPaywall() {
        return this._showPaywall;
    }

    public final StateFlow<Boolean> getDataCollectVisible() {
        return this.dataCollectVisible;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.NoteEditorViewModel$showDataCollectDialog$1 */
    /* JADX INFO: compiled from: NoteEditorViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.NoteEditorViewModel$showDataCollectDialog$1", m1609f = "NoteEditorViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C63861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C63861(Continuation<? super C63861> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteEditorViewModel.this.new C63861(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63861) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NoteEditorViewModel.this._dataCollectVisible.setValue(Boxing.boxBoolean(true));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void showDataCollectDialog() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C63861(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.NoteEditorViewModel$dismissDataCollectDialog$1 */
    /* JADX INFO: compiled from: NoteEditorViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.NoteEditorViewModel$dismissDataCollectDialog$1", m1609f = "NoteEditorViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C63821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C63821(Continuation<? super C63821> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteEditorViewModel.this.new C63821(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NoteEditorViewModel.this._dataCollectVisible.setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void dismissDataCollectDialog() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C63821(null), 2, null);
    }

    public final SingleLiveEvent<Boolean> getCloudTokenExpiredNotification() {
        return this.cloudTokenExpiredNotification;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.NoteEditorViewModel$1 */
    /* JADX INFO: compiled from: NoteEditorViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.NoteEditorViewModel$1", m1609f = "NoteEditorViewModel.kt", m1610i = {}, m1611l = {169}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {170}, m1615s = {}, m1616v = 2)
    static final class C63781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C63781(Continuation<? super C63781> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteEditorViewModel.this.new C63781(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DiscoverabilityManager discoverabilityManager = NoteEditorViewModel.this.discoverabilityManager;
                if (discoverabilityManager != null) {
                    this.label = 1;
                    if (discoverabilityManager.init(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.NoteEditorViewModel$openNote$1 */
    /* JADX INFO: compiled from: NoteEditorViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.NoteEditorViewModel$openNote$1", m1609f = "NoteEditorViewModel.kt", m1610i = {}, m1611l = {177}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {TsExtractor.TS_PACKET_SIZE}, m1615s = {}, m1616v = 2)
    static final class C63841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PageKey $pageKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63841(PageKey pageKey, Continuation<? super C63841> continuation) {
            super(2, continuation);
            this.$pageKey = pageKey;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteEditorViewModel.this.new C63841(this.$pageKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.editing.NoteEditorViewModel$openNote$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: NoteEditorViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\n"}, m1599d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/myscript/nebo/dms/core/model/FolderModel;", "Lcom/myscript/nebo/dms/core/model/PageModel;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.editing.NoteEditorViewModel$openNote$1$1", m1609f = "NoteEditorViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends FolderModel, ? extends PageModel>>, Object> {
            final /* synthetic */ PageKey $pageKey;
            int label;
            final /* synthetic */ NoteEditorViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PageKey pageKey, NoteEditorViewModel noteEditorViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$pageKey = pageKey;
                this.this$0 = noteEditorViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$pageKey, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends FolderModel, ? extends PageModel>> continuation) {
                return invoke2(coroutineScope, (Continuation<? super Pair<FolderModel, PageModel>>) continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<FolderModel, PageModel>> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    PageModel page = this.this$0.libraryRepository.getPage(this.$pageKey);
                    NotebookKey notebookKeyFromPageKey = this.this$0.libraryRepository.getNotebookKeyFromPageKey(this.$pageKey);
                    FolderModel folder = notebookKeyFromPageKey != null ? this.this$0.libraryRepository.getFolder(notebookKeyFromPageKey) : null;
                    if (folder != null && page != null) {
                        return TuplesKt.m1606to(folder, page);
                    }
                    return TuplesKt.m1606to(null, null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String title;
            String name;
            String languageTag;
            String fileExtension;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getDefault(), new AnonymousClass1(this.$pageKey, NoteEditorViewModel.this, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Pair pair = (Pair) obj;
            FolderModel folderModel = (FolderModel) pair.component1();
            PageModel pageModel = (PageModel) pair.component2();
            PageKey pageKey = NoteEditorViewModel.this.getOpenNoteProperties().getPageKey();
            if (pageKey != null) {
                NoteEditorViewModel noteEditorViewModel = NoteEditorViewModel.this;
                noteEditorViewModel.libraryRepository.removePageListener(pageKey, noteEditorViewModel.noteListener);
                noteEditorViewModel.libraryRepository.removeTrashListener(noteEditorViewModel.trashListener);
            }
            NoteEditorViewModel.this.libraryRepository.addPageListener(this.$pageKey, NoteEditorViewModel.this.noteListener);
            NoteEditorViewModel.this.libraryRepository.addTrashListener(NoteEditorViewModel.this.trashListener);
            MutableLiveData mutableLiveData = NoteEditorViewModel.this._noteProperties;
            PageKey pageKey2 = this.$pageKey;
            if (pageModel == null || (title = pageModel.getTitle()) == null) {
                title = "";
            }
            if (folderModel == null || (name = folderModel.getName()) == null) {
                name = "";
            }
            if (pageModel == null || (languageTag = pageModel.getLanguageTag()) == null) {
                languageTag = "";
            }
            mutableLiveData.setValue(new NoteProperties(pageKey2, title, name, languageTag, (pageModel == null || (fileExtension = pageModel.getFileExtension()) == null) ? "" : fileExtension));
            return Unit.INSTANCE;
        }
    }

    public final void openNote(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        this.libraryRepository.setLastOpenedNoteKey(pageKey);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63841(pageKey, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.NoteEditorViewModel$closeNote$1 */
    /* JADX INFO: compiled from: NoteEditorViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.NoteEditorViewModel$closeNote$1", m1609f = "NoteEditorViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C63791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C63791(Continuation<? super C63791> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteEditorViewModel.this.new C63791(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63791) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NoteEditorViewModel.this._noteProperties.setValue(null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void closeNote() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63791(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.NoteEditorViewModel$updateNoteName$1 */
    /* JADX INFO: compiled from: NoteEditorViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.NoteEditorViewModel$updateNoteName$1", m1609f = "NoteEditorViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C63881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $newName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63881(String str, Continuation<? super C63881> continuation) {
            super(2, continuation);
            this.$newName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteEditorViewModel.this.new C63881(this.$newName, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63881) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PageKey pageKey = NoteEditorViewModel.this.getOpenNoteProperties().getPageKey();
            if (pageKey != null) {
                NoteEditorViewModel noteEditorViewModel = NoteEditorViewModel.this;
                noteEditorViewModel.libraryRepository.updateNoteName(pageKey, this.$newName);
            }
            return Unit.INSTANCE;
        }
    }

    public final void updateNoteName(String newName) {
        Intrinsics.checkNotNullParameter(newName, "newName");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63881(newName, null), 3, null);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        PageKey pageKey = getOpenNoteProperties().getPageKey();
        if (pageKey != null) {
            this.libraryRepository.removePageListener(pageKey, this.noteListener);
            this.libraryRepository.removeTrashListener(this.trashListener);
        }
        closeNote();
        this.libraryRepository.removeCloudTokenExpirationListener(this.onCloudExpired);
        super.onCleared();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.NoteEditorViewModel$discover$1 */
    /* JADX INFO: compiled from: NoteEditorViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.NoteEditorViewModel$discover$1", m1609f = "NoteEditorViewModel.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA2_3_3}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {234}, m1615s = {}, m1616v = 2)
    static final class C63801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IDiscoverableFeature $feature;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63801(IDiscoverableFeature iDiscoverableFeature, Continuation<? super C63801> continuation) {
            super(2, continuation);
            this.$feature = iDiscoverableFeature;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteEditorViewModel.this.new C63801(this.$feature, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63801) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DiscoverabilityManager discoverabilityManager = NoteEditorViewModel.this.discoverabilityManager;
                if (discoverabilityManager != null) {
                    this.label = 1;
                    if (discoverabilityManager.discover(this.$feature, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void discover(IDiscoverableFeature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.ioDispatcher, null, new C63801(feature, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.NoteEditorViewModel$setDiscoverable$1 */
    /* JADX INFO: compiled from: NoteEditorViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.NoteEditorViewModel$setDiscoverable$1", m1609f = "NoteEditorViewModel.kt", m1610i = {}, m1611l = {239}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PsExtractor.VIDEO_STREAM_MASK}, m1615s = {}, m1616v = 2)
    static final class C63851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IDiscoverableFeature $feature;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63851(IDiscoverableFeature iDiscoverableFeature, Continuation<? super C63851> continuation) {
            super(2, continuation);
            this.$feature = iDiscoverableFeature;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteEditorViewModel.this.new C63851(this.$feature, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63851) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DiscoverabilityManager discoverabilityManager = NoteEditorViewModel.this.discoverabilityManager;
                if (discoverabilityManager != null) {
                    this.label = 1;
                    if (discoverabilityManager.setDiscoverable(this.$feature, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void setDiscoverable(IDiscoverableFeature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.ioDispatcher, null, new C63851(feature, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.NoteEditorViewModel$dismissCurrentTooltip$1 */
    /* JADX INFO: compiled from: NoteEditorViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.NoteEditorViewModel$dismissCurrentTooltip$1", m1609f = "NoteEditorViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C63811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C63811(Continuation<? super C63811> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteEditorViewModel.this.new C63811(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63811) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TooltipUIState tooltipUIState = (TooltipUIState) NoteEditorViewModel.this._discoveryTooltip.getValue();
                if (tooltipUIState != null) {
                    NoteEditorViewModel noteEditorViewModel = NoteEditorViewModel.this;
                    IDiscoverableFeature iDiscoverableFeatureFromTooltipState = EditingDiscoverableFeature.INSTANCE.fromTooltipState(tooltipUIState);
                    if (iDiscoverableFeatureFromTooltipState != null) {
                        noteEditorViewModel.discover(iDiscoverableFeatureFromTooltipState);
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void dismissCurrentTooltip() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C63811(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.NoteEditorViewModel$initDiscoverability$1 */
    /* JADX INFO: compiled from: NoteEditorViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.NoteEditorViewModel$initDiscoverability$1", m1609f = "NoteEditorViewModel.kt", m1610i = {0, 0, 0, 0, 0, 1, 1, 1}, m1611l = {258, 276}, m1612m = "invokeSuspend", m1613n = {"pageKey", "pageType", "note", "$i$a$-let-NoteEditorViewModel$initDiscoverability$1$1", "$i$a$-let-NoteEditorViewModel$initDiscoverability$1$1$1", "pageKey", "note", "$i$a$-let-NoteEditorViewModel$initDiscoverability$1$1"}, m1614nl = {274, 280}, m1615s = {"L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "I$0"}, m1616v = 2)
    static final class C63831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        C63831(Continuation<? super C63831> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteEditorViewModel.this.new C63831(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63831) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x00b7, code lost:
        
            if (r3.collect(r7, r11) != r0) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            PageKey pageKey;
            final NoteEditorViewModel noteEditorViewModel;
            PageModel page;
            int i;
            PageType pageType;
            PageModel pageModel;
            DiscoverabilityManager discoverabilityManager;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                pageKey = NoteEditorViewModel.this.getOpenNoteProperties().getPageKey();
                if (pageKey != null) {
                    noteEditorViewModel = NoteEditorViewModel.this;
                    page = noteEditorViewModel.libraryRepository.getPage(pageKey);
                    i = 0;
                    if (page == null || (pageType = page.getPageType()) == null) {
                        discoverabilityManager = noteEditorViewModel.discoverabilityManager;
                        if (discoverabilityManager != null && (r3 = discoverabilityManager.getNextDiscovery()) != null) {
                            FlowCollector<? super IDiscoverableFeature> flowCollector = new FlowCollector() { // from class: com.myscript.nebo.editing.NoteEditorViewModel$initDiscoverability$1$1$2
                                @Override // kotlinx.coroutines.flow.FlowCollector
                                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                                    return emit((IDiscoverableFeature) obj2, (Continuation<? super Unit>) continuation);
                                }

                                /* JADX WARN: Multi-variable type inference failed */
                                public final Object emit(IDiscoverableFeature iDiscoverableFeature, Continuation<? super Unit> continuation) {
                                    TooltipUIState tooltipState$default;
                                    MutableLiveData mutableLiveData = noteEditorViewModel._discoveryTooltip;
                                    TooltipUIState tooltipUIState = null;
                                    EditingDiscoverableFeature editingDiscoverableFeature = iDiscoverableFeature instanceof EditingDiscoverableFeature ? (EditingDiscoverableFeature) iDiscoverableFeature : null;
                                    if (editingDiscoverableFeature != null && (tooltipState$default = TooltipUIStateKt.toTooltipState$default(editingDiscoverableFeature, false, 1, null)) != null) {
                                        Object userData = tooltipState$default.getUserData();
                                        if ((userData instanceof EditingDiscoverableFeature.DiscoverableFeatureDestination ? (EditingDiscoverableFeature.DiscoverableFeatureDestination) userData : null) == EditingDiscoverableFeature.DiscoverableFeatureDestination.MAIN_FRAGMENT) {
                                            tooltipUIState = tooltipState$default;
                                        }
                                    }
                                    mutableLiveData.setValue(tooltipUIState);
                                    return Unit.INSTANCE;
                                }
                            };
                            this.L$0 = SpillingKt.nullOutSpilledVariable(pageKey);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(page);
                            this.L$2 = null;
                            this.L$3 = null;
                            this.I$0 = i;
                            this.label = 2;
                        }
                    } else {
                        CoroutineDispatcher coroutineDispatcher = noteEditorViewModel.ioDispatcher;
                        NoteEditorViewModel$initDiscoverability$1$1$1$1 noteEditorViewModel$initDiscoverability$1$1$1$1 = new NoteEditorViewModel$initDiscoverability$1$1$1$1(noteEditorViewModel, pageType, page, null);
                        this.L$0 = noteEditorViewModel;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(pageKey);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(pageType);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(page);
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.label = 1;
                        if (BuildersKt.withContext(coroutineDispatcher, noteEditorViewModel$initDiscoverability$1$1$1$1, this) != coroutine_suspended) {
                            pageModel = page;
                        }
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                throw new KotlinNothingValueException();
            }
            i = this.I$0;
            pageModel = (PageModel) this.L$3;
            pageKey = (PageKey) this.L$1;
            noteEditorViewModel = (NoteEditorViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
            page = pageModel;
            discoverabilityManager = noteEditorViewModel.discoverabilityManager;
            if (discoverabilityManager != null) {
                FlowCollector<? super IDiscoverableFeature> flowCollector2 = new FlowCollector() { // from class: com.myscript.nebo.editing.NoteEditorViewModel$initDiscoverability$1$1$2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((IDiscoverableFeature) obj2, (Continuation<? super Unit>) continuation);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public final Object emit(IDiscoverableFeature iDiscoverableFeature, Continuation<? super Unit> continuation) {
                        TooltipUIState tooltipState$default;
                        MutableLiveData mutableLiveData = noteEditorViewModel._discoveryTooltip;
                        TooltipUIState tooltipUIState = null;
                        EditingDiscoverableFeature editingDiscoverableFeature = iDiscoverableFeature instanceof EditingDiscoverableFeature ? (EditingDiscoverableFeature) iDiscoverableFeature : null;
                        if (editingDiscoverableFeature != null && (tooltipState$default = TooltipUIStateKt.toTooltipState$default(editingDiscoverableFeature, false, 1, null)) != null) {
                            Object userData = tooltipState$default.getUserData();
                            if ((userData instanceof EditingDiscoverableFeature.DiscoverableFeatureDestination ? (EditingDiscoverableFeature.DiscoverableFeatureDestination) userData : null) == EditingDiscoverableFeature.DiscoverableFeatureDestination.MAIN_FRAGMENT) {
                                tooltipUIState = tooltipState$default;
                            }
                        }
                        mutableLiveData.setValue(tooltipUIState);
                        return Unit.INSTANCE;
                    }
                };
                this.L$0 = SpillingKt.nullOutSpilledVariable(pageKey);
                this.L$1 = SpillingKt.nullOutSpilledVariable(page);
                this.L$2 = null;
                this.L$3 = null;
                this.I$0 = i;
                this.label = 2;
            }
            return Unit.INSTANCE;
        }
    }

    public final void initDiscoverability() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63831(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.NoteEditorViewModel$updateDiscoverableFeatures$1 */
    /* JADX INFO: compiled from: NoteEditorViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.NoteEditorViewModel$updateDiscoverableFeatures$1", m1609f = "NoteEditorViewModel.kt", m1610i = {}, m1611l = {286}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {287}, m1615s = {}, m1616v = 2)
    static final class C63871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C63871(Continuation<? super C63871> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteEditorViewModel.this.new C63871(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63871) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DiscoverabilityManager discoverabilityManager = NoteEditorViewModel.this.discoverabilityManager;
                if (discoverabilityManager != null) {
                    this.label = 1;
                    if (discoverabilityManager.updateDiscoverableFeatures(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void updateDiscoverableFeatures() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C63871(null), 3, null);
    }

    /* JADX INFO: compiled from: NoteEditorViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/editing/NoteEditorViewModel$Companion;", "", "<init>", "()V", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewModelProvider.Factory getFactory() {
            return NoteEditorViewModel.Factory;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final NoteEditorViewModel Factory$lambda$0$0(CreationExtras initializer) {
        boolean z;
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        Object objRequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
        Intrinsics.checkNotNull(objRequireApplication, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
        LibraryRepository libraryRepositoryProvideLibraryRepository = ((LibraryRepository.Provider) objRequireApplication).provideLibraryRepository();
        DiscoverabilityManager discoverabilityManagerProvideEditingDiscoverabilityManager = ((DiscoverabilityManager.Provider) objRequireApplication).provideEditingDiscoverabilityManager();
        ((ISubscriptionRepository.Provider) objRequireApplication).provideSubscriptionRepository();
        boolean zIsFreemiumBusinessModelEnabled = ((FreemiumBusinessModelStatus) objRequireApplication).isFreemiumBusinessModelEnabled();
        if (((ContextWrapper) objRequireApplication).getResources().getBoolean(C6079R.bool.is_ai_available_for_flavor)) {
            z = PreferenceManager.getDefaultSharedPreferences((Context) objRequireApplication).getBoolean(AIContainerViewModel.AI_ENABLED_PREFS, true);
        }
        return new NoteEditorViewModel(libraryRepositoryProvideLibraryRepository, discoverabilityManagerProvideEditingDiscoverabilityManager, zIsFreemiumBusinessModelEnabled, z, null, null, 48, null);
    }

    static {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(NoteEditorViewModel.class), new Function1() { // from class: com.myscript.nebo.editing.NoteEditorViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NoteEditorViewModel.Factory$lambda$0$0((CreationExtras) obj);
            }
        });
        Factory = initializerViewModelFactoryBuilder.build();
    }
}
