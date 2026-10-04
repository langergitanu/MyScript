package com.myscript.nebo.inspector;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.media3.common.MimeTypes;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.dms.core.CollectionsManager;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.model.CollectionModel;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.inspector.State;
import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.NotebookKey;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
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
import kotlin.p039io.FilesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: NeboFilesViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001(\u0018\u0000 :2\u00020\u0001:\u0001:BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010*\u001a\u00020+H\u0017J\u0006\u0010,\u001a\u00020+J\u000e\u0010-\u001a\u00020 H\u0082@¢\u0006\u0002\u0010.J\u0006\u0010/\u001a\u00020+J:\u00100\u001a\u00020+2\u0006\u00101\u001a\u0002022\u0014\b\u0002\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u000202042\u0014\b\u0002\u00105\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020+04J\u000e\u00107\u001a\u000202H\u0086@¢\u0006\u0002\u0010.J\u000e\u00108\u001a\u000202H\u0086@¢\u0006\u0002\u0010.J\u000e\u00109\u001a\u000202H\u0086@¢\u0006\u0002\u0010.R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b#\u0010%R\u0011\u0010&\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b&\u0010%R\u0010\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)¨\u0006;"}, m1599d2 = {"Lcom/myscript/nebo/inspector/NeboFilesViewModel;", "Landroidx/lifecycle/ViewModel;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "repository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "lookupDir", "Ljava/io/File;", "customCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "mainDispatcher", "Lkotlin/coroutines/CoroutineContext;", "workDispatcher", "ioDispatcher", "<init>", "(Landroid/app/Application;Lcom/myscript/nebo/dms/core/LibraryRepository;Ljava/io/File;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;)V", "coroutineScope", "inspector", "Lcom/myscript/nebo/inspector/NeboFilesInspector;", "_state", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/inspector/State;", "state", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "files", "", "Lcom/myscript/nebo/inspector/NeboFile;", "getFiles", "()Ljava/util/List;", "stats", "Lcom/myscript/nebo/inspector/Stats;", "getStats", "()Lcom/myscript/nebo/inspector/Stats;", "isEmpty", "", "()Z", "isCloudConnected", "onLibraryUpdate", "com/myscript/nebo/inspector/NeboFilesViewModel$onLibraryUpdate$1", "Lcom/myscript/nebo/inspector/NeboFilesViewModel$onLibraryUpdate$1;", "onCleared", "", "reload", "computeStats", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCurrentState", "restoreCurrentState", "restorationCollectionName", "", "outputNotebookNameFn", "Lkotlin/Function1;", "onDone", "", "exportDatalog", "dumpCloudV1", "exportCloudOperationsLog", "Companion", "nebo-inspector_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NeboFilesViewModel extends ViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function1<NeboFile, String> DefaultOutputNotebookNameFn = new Function1() { // from class: com.myscript.nebo.inspector.NeboFilesViewModel$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return NeboFilesViewModel.DefaultOutputNotebookNameFn$lambda$0((NeboFile) obj);
        }
    };
    private static final ViewModelProvider.Factory Factory;
    private final MutableLiveData<State> _state;
    private final Application application;
    private final CoroutineScope coroutineScope;
    private final NeboFilesInspector inspector;
    private final CoroutineContext ioDispatcher;
    private final CoroutineContext mainDispatcher;
    private final NeboFilesViewModel$onLibraryUpdate$1 onLibraryUpdate;
    private final LibraryRepository repository;
    private final CoroutineContext workDispatcher;

    /* JADX WARN: Type inference failed for: r2v3, types: [com.myscript.nebo.inspector.NeboFilesViewModel$onLibraryUpdate$1] */
    public NeboFilesViewModel(Application application, LibraryRepository repository, File lookupDir, CoroutineScope coroutineScope, CoroutineContext mainDispatcher, CoroutineContext workDispatcher, CoroutineContext ioDispatcher) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(lookupDir, "lookupDir");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(workDispatcher, "workDispatcher");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.application = application;
        this.repository = repository;
        this.mainDispatcher = mainDispatcher;
        this.workDispatcher = workDispatcher;
        this.ioDispatcher = ioDispatcher;
        this.coroutineScope = coroutineScope == null ? ViewModelKt.getViewModelScope(this) : coroutineScope;
        this.inspector = new NeboFilesInspector(new File[]{lookupDir}, repository.getDatabaseDir());
        this._state = new MutableLiveData<>();
        ?? r2 = new LibraryRepository.ModelChangedListener() { // from class: com.myscript.nebo.inspector.NeboFilesViewModel$onLibraryUpdate$1
            @Override // com.myscript.nebo.dms.core.LibraryRepository.ModelChangedListener
            public void onFolderUpdated(NotebookKey notebookKey) {
                Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.myscript.nebo.dms.core.LibraryRepository.ModelChangedListener
            public void onCollectionsLoaded() {
                State state = (State) this.this$0._state.getValue();
                if (state == null) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(this.this$0.coroutineScope, this.this$0.mainDispatcher, null, new NeboFilesViewModel$onLibraryUpdate$1$onCollectionsLoaded$1(this.this$0, state, null), 2, null);
            }
        };
        this.onLibraryUpdate = r2;
        reload();
        repository.addModelChangedListener((LibraryRepository.ModelChangedListener) r2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ NeboFilesViewModel(Application application, LibraryRepository libraryRepository, File file, CoroutineScope coroutineScope, MainCoroutineDispatcher mainCoroutineDispatcher, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            file = application.getFilesDir();
            Intrinsics.checkNotNullExpressionValue(file, "getFilesDir(...)");
        }
        this(application, libraryRepository, file, (i & 8) != 0 ? null : coroutineScope, (i & 16) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher, (i & 32) != 0 ? Dispatchers.getDefault() : coroutineContext, (i & 64) != 0 ? Dispatchers.getIO() : coroutineContext2);
    }

    public final LiveData<State> getState() {
        return this._state;
    }

    public final List<NeboFile> getFiles() {
        List<NeboFile> files;
        State value = this._state.getValue();
        return (value == null || (files = value.getFiles()) == null) ? CollectionsKt.emptyList() : files;
    }

    public final Stats getStats() {
        Stats stats;
        State value = this._state.getValue();
        return (value == null || (stats = value.getStats()) == null) ? new Stats(0, 0, 0, 7, null) : stats;
    }

    public final boolean isEmpty() {
        State value = this._state.getValue();
        List<NeboFile> files = value != null ? value.getFiles() : null;
        return files == null || files.isEmpty();
    }

    public final boolean isCloudConnected() {
        return this.repository.getHasCloudProvider();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.repository.removeModelChangedListener(this.onLibraryUpdate);
        CoroutineScopeKt.cancel$default(this.coroutineScope, null, 1, null);
        super.onCleared();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.inspector.NeboFilesViewModel$reload$1 */
    /* JADX INFO: compiled from: NeboFilesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.inspector.NeboFilesViewModel$reload$1", m1609f = "NeboFilesViewModel.kt", m1610i = {2, 3, 3, 4, 4}, m1611l = {110, 111, 114, 118, 120}, m1612m = "invokeSuspend", m1613n = {"foundFiles", "foundFiles", "sortedFiles", "foundFiles", "sortedFiles"}, m1614nl = {111, 114, 117, 120, 117}, m1615s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, m1616v = 2)
    static final class C66001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        C66001(Continuation<? super C66001> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboFilesViewModel.this.new C66001(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66001) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x00be A[PHI: r1 r10
          0x00be: PHI (r1v7 java.util.List) = (r1v6 java.util.List), (r1v21 java.util.List) binds: [B:23:0x00bb, B:13:0x0046] A[DONT_GENERATE, DONT_INLINE]
          0x00be: PHI (r10v13 java.lang.Object) = (r10v12 java.lang.Object), (r10v0 java.lang.Object) binds: [B:23:0x00bb, B:13:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00f3  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            List list;
            List list2;
            List list3;
            MutableLiveData mutableLiveData2;
            MutableLiveData mutableLiveData3;
            State empty;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutableLiveData = NeboFilesViewModel.this._state;
                this.L$0 = mutableLiveData;
                this.label = 1;
                obj = NeboFilesViewModel.this.computeStats(this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    list = (List) obj;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(list);
                    this.label = 3;
                    obj = BuildersKt.withContext(NeboFilesViewModel.this.workDispatcher, new NeboFilesViewModel$reload$1$sortedFiles$1(list, null), this);
                    if (obj != coroutine_suspended) {
                        list2 = (List) obj;
                        MutableLiveData mutableLiveData4 = NeboFilesViewModel.this._state;
                        if (!list2.isEmpty()) {
                        }
                    }
                    return coroutine_suspended;
                }
                if (i != 3) {
                    if (i == 4) {
                        mutableLiveData3 = (MutableLiveData) this.L$2;
                        ResultKt.throwOnFailure(obj);
                        empty = new State.Empty((Stats) obj);
                        mutableLiveData3.setValue(empty);
                        return Unit.INSTANCE;
                    }
                    if (i != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list3 = (List) this.L$3;
                    mutableLiveData2 = (MutableLiveData) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    State loaded = new State.Loaded(list3, (Stats) obj);
                    mutableLiveData3 = mutableLiveData2;
                    empty = loaded;
                    mutableLiveData3.setValue(empty);
                    return Unit.INSTANCE;
                }
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                list2 = (List) obj;
                MutableLiveData mutableLiveData42 = NeboFilesViewModel.this._state;
                if (!list2.isEmpty()) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(list);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                    this.L$2 = mutableLiveData42;
                    this.label = 4;
                    obj = NeboFilesViewModel.this.computeStats(this);
                    if (obj != coroutine_suspended) {
                        mutableLiveData3 = mutableLiveData42;
                        empty = new State.Empty((Stats) obj);
                        mutableLiveData3.setValue(empty);
                        return Unit.INSTANCE;
                    }
                } else {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(list);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                    this.L$2 = mutableLiveData42;
                    this.L$3 = list2;
                    this.label = 5;
                    Object objComputeStats = NeboFilesViewModel.this.computeStats(this);
                    if (objComputeStats != coroutine_suspended) {
                        list3 = list2;
                        obj = objComputeStats;
                        mutableLiveData2 = mutableLiveData42;
                        State loaded2 = new State.Loaded(list3, (Stats) obj);
                        mutableLiveData3 = mutableLiveData2;
                        empty = loaded2;
                        mutableLiveData3.setValue(empty);
                        return Unit.INSTANCE;
                    }
                }
                return coroutine_suspended;
            }
            mutableLiveData = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
            mutableLiveData.setValue(new State.Loading((Stats) obj));
            this.L$0 = null;
            this.label = 2;
            obj = BuildersKt.withContext(NeboFilesViewModel.this.ioDispatcher, new NeboFilesViewModel$reload$1$foundFiles$1(NeboFilesViewModel.this, null), this);
            if (obj != coroutine_suspended) {
                list = (List) obj;
                this.L$0 = SpillingKt.nullOutSpilledVariable(list);
                this.label = 3;
                obj = BuildersKt.withContext(NeboFilesViewModel.this.workDispatcher, new NeboFilesViewModel$reload$1$sortedFiles$1(list, null), this);
                if (obj != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }
    }

    public final void reload() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.mainDispatcher, null, new C66001(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.inspector.NeboFilesViewModel$computeStats$2 */
    /* JADX INFO: compiled from: NeboFilesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/nebo/inspector/Stats;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.inspector.NeboFilesViewModel$computeStats$2", m1609f = "NeboFilesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65962 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Stats>, Object> {
        int label;

        C65962(Continuation<? super C65962> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboFilesViewModel.this.new C65962(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Stats> continuation) {
            return ((C65962) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                List collectionModels$default = CollectionsManager.getCollectionModels$default(NeboFilesViewModel.this.repository, null, 1, null);
                List list = collectionModels$default;
                Iterator it = list.iterator();
                int size = 0;
                int notebookCount = 0;
                while (it.hasNext()) {
                    notebookCount += ((CollectionModel) it.next()).getNotebookCount();
                }
                ArrayList arrayList = new ArrayList();
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    CollectionsKt.addAll(arrayList, ((CollectionModel) it2.next()).getFolders());
                }
                NeboFilesViewModel neboFilesViewModel = NeboFilesViewModel.this;
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    size += neboFilesViewModel.repository.getPageKeys(((FolderModel) it3.next()).getNotebookKey()).size();
                }
                return new Stats(collectionModels$default.size(), notebookCount, size);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object computeStats(Continuation<? super Stats> continuation) {
        return BuildersKt.withContext(this.workDispatcher, new C65962(null), continuation);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.inspector.NeboFilesViewModel$clearCurrentState$1 */
    /* JADX INFO: compiled from: NeboFilesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.inspector.NeboFilesViewModel$clearCurrentState$1", m1609f = "NeboFilesViewModel.kt", m1610i = {}, m1611l = {137}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {140}, m1615s = {}, m1616v = 2)
    static final class C65951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ State.Loaded $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C65951(State.Loaded loaded, Continuation<? super C65951> continuation) {
            super(2, continuation);
            this.$state = loaded;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboFilesViewModel.this.new C65951(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65951) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.inspector.NeboFilesViewModel$clearCurrentState$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: NeboFilesViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.inspector.NeboFilesViewModel$clearCurrentState$1$1", m1609f = "NeboFilesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ State.Loaded $state;
            int label;
            final /* synthetic */ NeboFilesViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(NeboFilesViewModel neboFilesViewModel, State.Loaded loaded, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = neboFilesViewModel;
                this.$state = loaded;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$state, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    NeboFilesInspector neboFilesInspector = this.this$0.inspector;
                    List<NeboFile> files = this.$state.getFiles();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(files, 10));
                    Iterator<T> it = files.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((NeboFile) it.next()).getFile());
                    }
                    neboFilesInspector.clear(arrayList);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(NeboFilesViewModel.this.ioDispatcher, new AnonymousClass1(NeboFilesViewModel.this, this.$state, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            NeboFilesViewModel.this.reload();
            return Unit.INSTANCE;
        }
    }

    public final void clearCurrentState() {
        State value = this._state.getValue();
        State.Loaded loaded = value instanceof State.Loaded ? (State.Loaded) value : null;
        if (loaded == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.mainDispatcher, null, new C65951(loaded, null), 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void restoreCurrentState$default(NeboFilesViewModel neboFilesViewModel, String str, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = DefaultOutputNotebookNameFn;
        }
        if ((i & 4) != 0) {
            function12 = new Function1() { // from class: com.myscript.nebo.inspector.NeboFilesViewModel$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return NeboFilesViewModel.restoreCurrentState$lambda$0(((Integer) obj2).intValue());
                }
            };
        }
        neboFilesViewModel.restoreCurrentState(str, function1, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit restoreCurrentState$lambda$0(int i) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.inspector.NeboFilesViewModel$restoreCurrentState$2 */
    /* JADX INFO: compiled from: NeboFilesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.inspector.NeboFilesViewModel$restoreCurrentState$2", m1609f = "NeboFilesViewModel.kt", m1610i = {0, 0, 0, 0, 0, 0, 0}, m1611l = {158}, m1612m = "invokeSuspend", m1613n = {"restorationCollectionKey", "restoredCount", "$this$forEach$iv", "element$iv", "lostFile", "$i$f$forEach", "$i$a$-forEach-NeboFilesViewModel$restoreCurrentState$2$1"}, m1614nl = {170}, m1615s = {"L$0", "L$1", "L$2", "L$7", "L$8", "I$0", "I$1"}, m1616v = 2)
    static final class C66022 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Integer, Unit> $onDone;
        final /* synthetic */ Function1<NeboFile, String> $outputNotebookNameFn;
        final /* synthetic */ String $restorationCollectionName;
        final /* synthetic */ State $state;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C66022(String str, Function1<? super Integer, Unit> function1, State state, Function1<? super NeboFile, String> function12, Continuation<? super C66022> continuation) {
            super(2, continuation);
            this.$restorationCollectionName = str;
            this.$onDone = function1;
            this.$state = state;
            this.$outputNotebookNameFn = function12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboFilesViewModel.this.new C66022(this.$restorationCollectionName, this.$onDone, this.$state, this.$outputNotebookNameFn, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66022) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00f4  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00f0 -> B:6:0x0038). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CollectionKey collectionKey;
            int i;
            AtomicInteger atomicInteger;
            NeboFilesViewModel neboFilesViewModel;
            Function1<NeboFile, String> function1;
            State state;
            Iterator it;
            Iterable iterable;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                CollectionKey collectionKeyFindCollectionByName = NeboFilesViewModel.this.repository.findCollectionByName(this.$restorationCollectionName);
                if (collectionKeyFindCollectionByName == null) {
                    collectionKeyFindCollectionByName = NeboFilesViewModel.this.repository.createCollection(this.$restorationCollectionName);
                }
                if (collectionKeyFindCollectionByName == null) {
                    Log.e("NeboFilesViewModel", "Unable to find or create restoration collection " + this.$restorationCollectionName);
                    this.$onDone.invoke(Boxing.boxInt(-1));
                    return Unit.INSTANCE;
                }
                AtomicInteger atomicInteger2 = new AtomicInteger(0);
                List<NeboFile> files = this.$state.getFiles();
                NeboFilesViewModel neboFilesViewModel2 = NeboFilesViewModel.this;
                collectionKey = collectionKeyFindCollectionByName;
                i = 0;
                atomicInteger = atomicInteger2;
                neboFilesViewModel = neboFilesViewModel2;
                function1 = this.$outputNotebookNameFn;
                state = this.$state;
                it = files.iterator();
                iterable = files;
                if (it.hasNext()) {
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                it = (Iterator) this.L$6;
                State state2 = (State) this.L$5;
                Function1<NeboFile, String> function12 = (Function1) this.L$4;
                NeboFilesViewModel neboFilesViewModel3 = (NeboFilesViewModel) this.L$3;
                iterable = (Iterable) this.L$2;
                AtomicInteger atomicInteger3 = (AtomicInteger) this.L$1;
                CollectionKey collectionKey2 = (CollectionKey) this.L$0;
                ResultKt.throwOnFailure(obj);
                state = state2;
                function1 = function12;
                neboFilesViewModel = neboFilesViewModel3;
                collectionKey = collectionKey2;
                atomicInteger = atomicInteger3;
                if (it.hasNext()) {
                    Object next = it.next();
                    NeboFile neboFile = (NeboFile) next;
                    CoroutineContext coroutineContext = neboFilesViewModel.ioDispatcher;
                    atomicInteger3 = atomicInteger;
                    State state3 = state;
                    NeboFilesViewModel$restoreCurrentState$2$1$1 neboFilesViewModel$restoreCurrentState$2$1$1 = new NeboFilesViewModel$restoreCurrentState$2$1$1(function1, neboFile, neboFilesViewModel, collectionKey, atomicInteger, state, null);
                    this.L$0 = collectionKey;
                    this.L$1 = atomicInteger3;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(iterable);
                    this.L$3 = neboFilesViewModel;
                    this.L$4 = function1;
                    this.L$5 = state3;
                    this.L$6 = it;
                    this.L$7 = SpillingKt.nullOutSpilledVariable(next);
                    this.L$8 = SpillingKt.nullOutSpilledVariable(neboFile);
                    this.I$0 = i;
                    this.I$1 = 0;
                    this.label = 1;
                    if (BuildersKt.withContext(coroutineContext, neboFilesViewModel$restoreCurrentState$2$1$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    state = state3;
                    atomicInteger = atomicInteger3;
                    if (it.hasNext()) {
                        this.$onDone.invoke(Boxing.boxInt(atomicInteger.get()));
                        NeboFilesViewModel.this.reload();
                        return Unit.INSTANCE;
                    }
                }
            }
        }
    }

    public final void restoreCurrentState(String restorationCollectionName, Function1<? super NeboFile, String> outputNotebookNameFn, Function1<? super Integer, Unit> onDone) {
        Intrinsics.checkNotNullParameter(restorationCollectionName, "restorationCollectionName");
        Intrinsics.checkNotNullParameter(outputNotebookNameFn, "outputNotebookNameFn");
        Intrinsics.checkNotNullParameter(onDone, "onDone");
        State value = this._state.getValue();
        if (value == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.mainDispatcher, null, new C66022(restorationCollectionName, onDone, value, outputNotebookNameFn, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.inspector.NeboFilesViewModel$exportDatalog$2 */
    /* JADX INFO: compiled from: NeboFilesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.inspector.NeboFilesViewModel$exportDatalog$2", m1609f = "NeboFilesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65992 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        int label;

        C65992(Continuation<? super C65992> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboFilesViewModel.this.new C65992(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((C65992) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LibraryRepository libraryRepository = NeboFilesViewModel.this.repository;
                String absolutePath = NeboFilesViewModel.this.application.getCacheDir().getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                return libraryRepository.exportDatalog(absolutePath);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object exportDatalog(Continuation<? super String> continuation) {
        return BuildersKt.withContext(this.coroutineScope.getCoroutineContext().plus(Dispatchers.getIO()), new C65992(null), continuation);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.inspector.NeboFilesViewModel$dumpCloudV1$2 */
    /* JADX INFO: compiled from: NeboFilesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.inspector.NeboFilesViewModel$dumpCloudV1$2", m1609f = "NeboFilesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65972 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        int label;

        C65972(Continuation<? super C65972> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboFilesViewModel.this.new C65972(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((C65972) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return NeboFilesViewModel.this.repository.dumpV1Cloud(NeboFilesViewModel.this.application.getCacheDir().getAbsolutePath());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object dumpCloudV1(Continuation<? super String> continuation) {
        return BuildersKt.withContext(this.coroutineScope.getCoroutineContext().plus(Dispatchers.getIO()), new C65972(null), continuation);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.inspector.NeboFilesViewModel$exportCloudOperationsLog$2 */
    /* JADX INFO: compiled from: NeboFilesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.inspector.NeboFilesViewModel$exportCloudOperationsLog$2", m1609f = "NeboFilesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C65982 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        int label;

        C65982(Continuation<? super C65982> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboFilesViewModel.this.new C65982(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((C65982) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String text$default;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                File cloudOperations = NeboFilesViewModel.this.repository.getCloudOperations();
                return (cloudOperations == null || (text$default = FilesKt.readText$default(cloudOperations, null, 1, null)) == null) ? "" : text$default;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object exportCloudOperationsLog(Continuation<? super String> continuation) {
        return BuildersKt.withContext(this.coroutineScope.getCoroutineContext().plus(Dispatchers.getIO()), new C65982(null), continuation);
    }

    /* JADX INFO: compiled from: NeboFilesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/inspector/NeboFilesViewModel$Companion;", "", "<init>", "()V", "DefaultOutputNotebookNameFn", "Lkotlin/Function1;", "Lcom/myscript/nebo/inspector/NeboFile;", "", "getDefaultOutputNotebookNameFn", "()Lkotlin/jvm/functions/Function1;", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "nebo-inspector_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function1<NeboFile, String> getDefaultOutputNotebookNameFn() {
            return NeboFilesViewModel.DefaultOutputNotebookNameFn;
        }

        public final ViewModelProvider.Factory getFactory() {
            return NeboFilesViewModel.Factory;
        }
    }

    static {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(NeboFilesViewModel.class), new Function1() { // from class: com.myscript.nebo.inspector.NeboFilesViewModel$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NeboFilesViewModel.Factory$lambda$0$0((CreationExtras) obj);
            }
        });
        Factory = initializerViewModelFactoryBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String DefaultOutputNotebookNameFn$lambda$0(NeboFile it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getFilepathMd5sum();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final NeboFilesViewModel Factory$lambda$0$0(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        Application applicationRequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
        Intrinsics.checkNotNull(applicationRequireApplication, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
        return new NeboFilesViewModel(applicationRequireApplication, ((LibraryRepository.Provider) applicationRequireApplication).provideLibraryRepository(), null, null, null, null, null, 124, null);
    }
}
