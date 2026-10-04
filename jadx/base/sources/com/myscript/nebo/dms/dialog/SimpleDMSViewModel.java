package com.myscript.nebo.dms.dialog;

import android.content.ComponentCallbacks2;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import com.google.android.gms.actions.SearchIntents;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.analytics.firebase.AIQuizConstants;
import com.myscript.nebo.dms.core.CollectionsManager;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.model.CollectionModel;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.snt.core.NotebookKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FolderPickerDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006*\u0001\u0014\b\u0007\u0018\u0000 )2\u00020\u0001:\u0002()B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0017H\u0002J=\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"0\u001dJ\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$J\u0010\u0010%\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010\u000eJ\b\u0010'\u001a\u00020\u0017H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006*"}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/SimpleDMSViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "<init>", "(Lcom/myscript/nebo/dms/core/LibraryRepository;)V", "_state", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/dms/dialog/SimpleDMSViewModel$DMSState;", "state", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "_selectedFolder", "Lcom/myscript/snt/core/NotebookKey;", "selectedFolder", "getSelectedFolder", "filterable", "Landroid/widget/Filterable;", "onLibraryUpdate", "com/myscript/nebo/dms/dialog/SimpleDMSViewModel$onLibraryUpdate$1", "Lcom/myscript/nebo/dms/dialog/SimpleDMSViewModel$onLibraryUpdate$1;", "initCollections", "", "getFilteredList", "", "Lcom/myscript/nebo/dms/core/model/CollectionModel;", "fullCollections", "filter", "Lkotlin/Function1;", "Lcom/myscript/nebo/dms/core/model/FolderModel;", "Lkotlin/ParameterName;", "name", AIQuizConstants.NOTEBOOK, "", SearchIntents.EXTRA_QUERY, "", "selectFolder", "notebookKey", "onCleared", "DMSState", "Companion", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SimpleDMSViewModel extends ViewModel {
    private static final ViewModelProvider.Factory Factory;
    private final MutableLiveData<NotebookKey> _selectedFolder;
    private final MutableLiveData<DMSState> _state;
    private final Filterable filterable;
    private final SimpleDMSViewModel$onLibraryUpdate$1 onLibraryUpdate;
    private final LibraryRepository repository;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initCollections$lambda$0(FolderModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    /* JADX INFO: compiled from: FolderPickerDialog.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/SimpleDMSViewModel$DMSState;", "", "<init>", "()V", "NoFolder", "Loading", "Ready", "Lcom/myscript/nebo/dms/dialog/SimpleDMSViewModel$DMSState$Loading;", "Lcom/myscript/nebo/dms/dialog/SimpleDMSViewModel$DMSState$NoFolder;", "Lcom/myscript/nebo/dms/dialog/SimpleDMSViewModel$DMSState$Ready;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class DMSState {
        public static final int $stable = 0;

        public /* synthetic */ DMSState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: FolderPickerDialog.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/SimpleDMSViewModel$DMSState$NoFolder;", "Lcom/myscript/nebo/dms/dialog/SimpleDMSViewModel$DMSState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class NoFolder extends DMSState {
            public static final int $stable = 0;
            public static final NoFolder INSTANCE = new NoFolder();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NoFolder)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1291911722;
            }

            public String toString() {
                return "NoFolder";
            }

            private NoFolder() {
                super(null);
            }
        }

        private DMSState() {
        }

        /* JADX INFO: compiled from: FolderPickerDialog.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/SimpleDMSViewModel$DMSState$Loading;", "Lcom/myscript/nebo/dms/dialog/SimpleDMSViewModel$DMSState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Loading extends DMSState {
            public static final int $stable = 0;
            public static final Loading INSTANCE = new Loading();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loading)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1810153493;
            }

            public String toString() {
                return "Loading";
            }

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FolderPickerDialog.kt */
        @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/SimpleDMSViewModel$DMSState$Ready;", "Lcom/myscript/nebo/dms/dialog/SimpleDMSViewModel$DMSState;", "collections", "", "Lcom/myscript/nebo/dms/core/model/CollectionModel;", "<init>", "(Ljava/util/List;)V", "getCollections", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Ready extends DMSState {
            public static final int $stable = 8;
            private final List<CollectionModel> collections;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Ready copy$default(Ready ready, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = ready.collections;
                }
                return ready.copy(list);
            }

            public final List<CollectionModel> component1() {
                return this.collections;
            }

            public final Ready copy(List<CollectionModel> collections) {
                Intrinsics.checkNotNullParameter(collections, "collections");
                return new Ready(collections);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Ready) && Intrinsics.areEqual(this.collections, ((Ready) other).collections);
            }

            public int hashCode() {
                return this.collections.hashCode();
            }

            public String toString() {
                return "Ready(collections=" + this.collections + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Ready(List<CollectionModel> collections) {
                super(null);
                Intrinsics.checkNotNullParameter(collections, "collections");
                this.collections = collections;
            }

            public final List<CollectionModel> getCollections() {
                return this.collections;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.myscript.nebo.dms.dialog.SimpleDMSViewModel$onLibraryUpdate$1] */
    public SimpleDMSViewModel(LibraryRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
        this._state = new MutableLiveData<>();
        this._selectedFolder = new MutableLiveData<>();
        this.filterable = new Filterable() { // from class: com.myscript.nebo.dms.dialog.SimpleDMSViewModel$$ExternalSyntheticLambda1
            @Override // android.widget.Filterable
            public final Filter getFilter() {
                return SimpleDMSViewModel.filterable$lambda$0(this.f$0);
            }
        };
        ?? r0 = new LibraryRepository.ModelChangedListener() { // from class: com.myscript.nebo.dms.dialog.SimpleDMSViewModel$onLibraryUpdate$1
            @Override // com.myscript.nebo.dms.core.LibraryRepository.ModelChangedListener
            public void onFolderUpdated(NotebookKey notebookKey) {
                Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.ModelChangedListener
            public void onCollectionsLoaded() {
                this.this$0.initCollections();
                this.this$0.selectFolder(null);
            }
        };
        this.onLibraryUpdate = r0;
        repository.addModelChangedListener((LibraryRepository.ModelChangedListener) r0);
        initCollections();
        selectFolder(null);
    }

    public final LiveData<DMSState> getState() {
        return this._state;
    }

    public final LiveData<NotebookKey> getSelectedFolder() {
        return this._selectedFolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Filter filterable$lambda$0(SimpleDMSViewModel simpleDMSViewModel) {
        return new SimpleDMSViewModel$filterable$1$1(simpleDMSViewModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initCollections() {
        boolean z = true;
        List<CollectionModel> filteredList = getFilteredList(CollectionsManager.getCollectionModels$default(this.repository, null, 1, null), new Function1() { // from class: com.myscript.nebo.dms.dialog.SimpleDMSViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SimpleDMSViewModel.initCollections$lambda$0((FolderModel) obj));
            }
        });
        List<CollectionModel> list = filteredList;
        if ((list instanceof Collection) && list.isEmpty()) {
            z = false;
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!((CollectionModel) it.next()).isEmpty()) {
                    break;
                }
            }
            z = false;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C62451(z, filteredList, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.dialog.SimpleDMSViewModel$initCollections$1 */
    /* JADX INFO: compiled from: FolderPickerDialog.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.dialog.SimpleDMSViewModel$initCollections$1", m1609f = "FolderPickerDialog.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<CollectionModel> $collections;
        final /* synthetic */ boolean $hasNotebooks;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62451(boolean z, List<CollectionModel> list, Continuation<? super C62451> continuation) {
            super(2, continuation);
            this.$hasNotebooks = z;
            this.$collections = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SimpleDMSViewModel.this.new C62451(this.$hasNotebooks, this.$collections, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62451) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DMSState ready;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData = SimpleDMSViewModel.this._state;
                if (this.$hasNotebooks) {
                    ready = new DMSState.Ready(this.$collections);
                } else {
                    ready = DMSState.NoFolder.INSTANCE;
                }
                mutableLiveData.setValue(ready);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final List<CollectionModel> getFilteredList(List<CollectionModel> fullCollections, Function1<? super FolderModel, Boolean> filter) {
        Intrinsics.checkNotNullParameter(fullCollections, "fullCollections");
        Intrinsics.checkNotNullParameter(filter, "filter");
        ArrayList arrayList = new ArrayList();
        for (CollectionModel collectionModel : fullCollections) {
            CollectionModel collectionModelCopy = CollectionModel.INSTANCE.copy(collectionModel);
            collectionModelCopy.clearNotebooks();
            collectionModelCopy.setExpanded(true);
            arrayList.add(collectionModelCopy);
            List<FolderModel> folders = collectionModel.getFolders();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : folders) {
                if (filter.invoke((FolderModel) obj).booleanValue()) {
                    arrayList2.add(obj);
                }
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                collectionModelCopy.addNotebookItem((FolderModel) it.next());
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!((CollectionModel) obj2).getFolders().isEmpty()) {
                arrayList3.add(obj2);
            }
        }
        return arrayList3;
    }

    public final void filter(CharSequence query) {
        Intrinsics.checkNotNullParameter(query, "query");
        this.filterable.getFilter().filter(query);
        selectFolder(null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.dialog.SimpleDMSViewModel$selectFolder$1 */
    /* JADX INFO: compiled from: FolderPickerDialog.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.dialog.SimpleDMSViewModel$selectFolder$1", m1609f = "FolderPickerDialog.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<CollectionModel> $collections;
        final /* synthetic */ NotebookKey $notebookKey;
        int label;
        final /* synthetic */ SimpleDMSViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62461(List<CollectionModel> list, SimpleDMSViewModel simpleDMSViewModel, NotebookKey notebookKey, Continuation<? super C62461> continuation) {
            super(2, continuation);
            this.$collections = list;
            this.this$0 = simpleDMSViewModel;
            this.$notebookKey = notebookKey;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C62461(this.$collections, this.this$0, this.$notebookKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62461) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<CollectionModel> list = this.$collections;
            NotebookKey notebookKey = this.$notebookKey;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                for (FolderModel folderModel : ((CollectionModel) it.next()).getFolders()) {
                    folderModel.setOpened(Intrinsics.areEqual(folderModel.getNotebookKey(), notebookKey) && !folderModel.isOpened());
                }
            }
            this.this$0._state.setValue(new DMSState.Ready(this.$collections));
            this.this$0._selectedFolder.setValue(!Intrinsics.areEqual(this.this$0._selectedFolder.getValue(), this.$notebookKey) ? this.$notebookKey : null);
            return Unit.INSTANCE;
        }
    }

    public final void selectFolder(NotebookKey notebookKey) {
        List<CollectionModel> collections;
        DMSState value = this._state.getValue();
        DMSState.Ready ready = value instanceof DMSState.Ready ? (DMSState.Ready) value : null;
        if (ready == null || (collections = ready.getCollections()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C62461(collections, this, notebookKey, null), 3, null);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        this.repository.removeModelChangedListener(this.onLibraryUpdate);
        super.onCleared();
    }

    /* JADX INFO: compiled from: FolderPickerDialog.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/SimpleDMSViewModel$Companion;", "", "<init>", "()V", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewModelProvider.Factory getFactory() {
            return SimpleDMSViewModel.Factory;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SimpleDMSViewModel Factory$lambda$0$0(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        ComponentCallbacks2 componentCallbacks2RequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
        Intrinsics.checkNotNull(componentCallbacks2RequireApplication, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
        return new SimpleDMSViewModel(((LibraryRepository.Provider) componentCallbacks2RequireApplication).provideLibraryRepository());
    }

    static {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(SimpleDMSViewModel.class), new Function1() { // from class: com.myscript.nebo.dms.dialog.SimpleDMSViewModel$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SimpleDMSViewModel.Factory$lambda$0$0((CreationExtras) obj);
            }
        });
        Factory = initializerViewModelFactoryBuilder.build();
    }
}
