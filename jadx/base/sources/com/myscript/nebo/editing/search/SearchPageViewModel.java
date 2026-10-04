package com.myscript.nebo.editing.search;

import android.content.ComponentCallbacks2;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.SingleLiveEvent;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.SWIGVectorExtent;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.search.DMSSearchController;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageController;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.SearchMatch;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: SearchPageViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f*\u0002?B\b\u0007\u0018\u0000 Z2\u00020\u0001:\u0001ZB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010D\u001a\u00020EH\u0017J\u000e\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020\u0017J\u000e\u0010H\u001a\u00020E2\u0006\u0010I\u001a\u00020JJ\u0016\u0010K\u001a\u00020E2\u0006\u0010I\u001a\u00020JH\u0082@¢\u0006\u0002\u0010LJ\u0016\u0010M\u001a\u00020E2\u0006\u0010I\u001a\u00020J2\u0006\u0010N\u001a\u00020OJ\u0006\u0010P\u001a\u00020EJ\u0006\u0010Q\u001a\u00020EJ\u0010\u0010R\u001a\u00020E2\u0006\u0010S\u001a\u00020)H\u0002J\u0006\u0010T\u001a\u00020EJ\u0006\u0010U\u001a\u00020EJ\u0006\u0010V\u001a\u00020EJ\u0010\u0010W\u001a\u00020E2\u0006\u0010X\u001a\u000201H\u0002J\u000e\u0010=\u001a\u00020E2\u0006\u0010Y\u001a\u000206R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00128F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010%0%0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00128F¢\u0006\u0006\u001a\u0004\b'\u0010\u0014R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010,R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020100X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u00160\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u00160\u00128F¢\u0006\u0006\u001a\u0004\b4\u0010\u0014R\u0014\u00105\u001a\u0002068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00107R\u0011\u00108\u001a\u0002068F¢\u0006\u0006\u001a\u0004\b8\u00107R\u0011\u00109\u001a\u0002068F¢\u0006\u0006\u001a\u0004\b9\u00107R\u0011\u0010:\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b;\u0010<R\u000e\u0010=\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0004\n\u0002\u0010@R\u0010\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010C¨\u0006["}, m1599d2 = {"Lcom/myscript/nebo/editing/search/SearchPageViewModel;", "Landroidx/lifecycle/ViewModel;", "searchController", "Lcom/myscript/nebo/dms/search/DMSSearchController;", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "workDispatcher", "<init>", "(Lcom/myscript/nebo/dms/search/DMSSearchController;Lcom/myscript/nebo/dms/core/LibraryRepository;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getLibraryRepository", "()Lcom/myscript/nebo/dms/core/LibraryRepository;", "_searchState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/editing/search/SearchPageState;", "kotlin.jvm.PlatformType", "searchState", "Landroidx/lifecycle/LiveData;", "getSearchState", "()Landroidx/lifecycle/LiveData;", "history", "", "", "getHistory", "value", "Lcom/myscript/nebo/dms/search/DMSSearchController$SearchType;", "searchType", "getSearchType", "()Lcom/myscript/nebo/dms/search/DMSSearchController$SearchType;", "setSearchType", "(Lcom/myscript/nebo/dms/search/DMSSearchController$SearchType;)V", "pageIdToShow", "Lcom/myscript/android/utils/SingleLiveEvent;", "getPageIdToShow", "()Lcom/myscript/android/utils/SingleLiveEvent;", "_hitNavState", "Lcom/myscript/nebo/editing/search/SearchHitNavState;", "hitNavState", "getHitNavState", "selectedHitIndex", "", "selectedHitNumber", "getSelectedHitNumber", "()I", "hitCount", "getHitCount", "hits", "", "Lcom/myscript/snt/core/SearchMatch;", "_searchHits", "searchHits", "getSearchHits", "isSearchingFromGrid", "", "()Z", "isSearchModeActive", "isSearchProcessing", "searchQuery", "getSearchQuery", "()Ljava/lang/String;", "showCurrentHitNextPageBinding", "onDMSSearchUpdate", "com/myscript/nebo/editing/search/SearchPageViewModel$onDMSSearchUpdate$1", "Lcom/myscript/nebo/editing/search/SearchPageViewModel$onDMSSearchUpdate$1;", "onSearchUpdate", "com/myscript/nebo/editing/search/SearchPageViewModel$onSearchUpdate$1", "Lcom/myscript/nebo/editing/search/SearchPageViewModel$onSearchUpdate$1;", "onCleared", "", FirebaseAnalytics.Event.SEARCH, "label", "refreshHitBounds", "pageKey", "Lcom/myscript/snt/core/PageKey;", "refreshHitBoundsInternal", "(Lcom/myscript/snt/core/PageKey;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindPageController", "pageController", "Lcom/myscript/snt/core/PageController;", "previousHit", "nextHit", "updateSelectedHit", "increment", "openSearch", "closeSearch", "clearHistory", "processSearchMatch", "match", "show", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SearchPageViewModel extends ViewModel {
    private static final ViewModelProvider.Factory Factory;
    private final MutableLiveData<SearchHitNavState> _hitNavState;
    private final MutableLiveData<List<SearchMatch>> _searchHits;
    private final MutableLiveData<SearchPageState> _searchState;
    private final List<SearchMatch> hits;
    private final LibraryRepository libraryRepository;
    private final CoroutineDispatcher mainDispatcher;
    private final SearchPageViewModel$onDMSSearchUpdate$1 onDMSSearchUpdate;
    private final SearchPageViewModel$onSearchUpdate$1 onSearchUpdate;
    private final SingleLiveEvent<String> pageIdToShow;
    private final DMSSearchController searchController;
    private int selectedHitIndex;
    private boolean showCurrentHitNextPageBinding;
    private final CoroutineDispatcher workDispatcher;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.myscript.nebo.editing.search.SearchPageViewModel$refreshHitBoundsInternal$1 */
    /* JADX INFO: compiled from: SearchPageViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.search.SearchPageViewModel", m1609f = "SearchPageViewModel.kt", m1610i = {0}, m1611l = {245}, m1612m = "refreshHitBoundsInternal", m1613n = {"pageKey"}, m1614nl = {262}, m1615s = {"L$0"}, m1616v = 2)
    static final class C64441 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C64441(Continuation<? super C64441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SearchPageViewModel.this.refreshHitBoundsInternal(null, this);
        }
    }

    /* JADX WARN: Type inference failed for: r12v7, types: [com.myscript.nebo.editing.search.SearchPageViewModel$onDMSSearchUpdate$1] */
    /* JADX WARN: Type inference failed for: r13v2, types: [com.myscript.nebo.editing.search.SearchPageViewModel$onSearchUpdate$1] */
    public SearchPageViewModel(DMSSearchController searchController, LibraryRepository libraryRepository, CoroutineDispatcher mainDispatcher, CoroutineDispatcher workDispatcher) {
        Intrinsics.checkNotNullParameter(searchController, "searchController");
        Intrinsics.checkNotNullParameter(libraryRepository, "libraryRepository");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(workDispatcher, "workDispatcher");
        this.searchController = searchController;
        this.libraryRepository = libraryRepository;
        this.mainDispatcher = mainDispatcher;
        this.workDispatcher = workDispatcher;
        this._searchState = new MutableLiveData<>(new SearchPageState(null, null, null, false, false, false, false, 127, null));
        this.pageIdToShow = new SingleLiveEvent<>();
        this._hitNavState = new MutableLiveData<>(new SearchHitNavState(0, 0, null, 7, null));
        this.hits = new ArrayList();
        this._searchHits = new MutableLiveData<>(CollectionsKt.emptyList());
        ?? r12 = new DMSSearchController.IGridSearch() { // from class: com.myscript.nebo.editing.search.SearchPageViewModel$onDMSSearchUpdate$1
            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onClearResults() {
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onSearchEndedFolder(NotebookKey notebookKey, int hitCount) {
                Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onSearchEndedPage(PageKey pageKey, int hitCount) {
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onSearchInterrupted() {
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onSearchStarted(String rootPath) {
                Intrinsics.checkNotNullParameter(rootPath, "rootPath");
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onSearchStartedFolder(NotebookKey notebookKey) {
                Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onTitleMatch(PageKey pageKey) {
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IGridSearch
            public void onSearchEnded(int hitCount) {
                if (this.this$0.searchController.getSearchType() == DMSSearchController.SearchType.GRID) {
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), null, null, new SearchPageViewModel$onDMSSearchUpdate$1$onSearchEnded$1(this.this$0, null), 3, null);
                }
            }
        };
        this.onDMSSearchUpdate = r12;
        ?? r13 = new DMSSearchController.IPageSearch() { // from class: com.myscript.nebo.editing.search.SearchPageViewModel$onSearchUpdate$1
            @Override // com.myscript.nebo.dms.search.DMSSearchController.IPageSearch
            public void onAddSearchMatch(SearchMatch match) {
                Intrinsics.checkNotNullParameter(match, "match");
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new SearchPageViewModel$onSearchUpdate$1$onAddSearchMatch$1(this.this$0, match, null), 2, null);
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IPageSearch
            public void onSearchStartedPage(PageKey pageKey, String searchQuery) {
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
                Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new SearchPageViewModel$onSearchUpdate$1$onSearchStartedPage$1(this.this$0, pageKey, searchQuery, null), 2, null);
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IPageSearch
            public void onSearchEndedPage(PageKey pageKey, int hitCount) {
                Intrinsics.checkNotNullParameter(pageKey, "pageKey");
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new SearchPageViewModel$onSearchUpdate$1$onSearchEndedPage$1(this.this$0, null), 2, null);
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IPageSearch
            public void onSearchInterrupted() {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.mainDispatcher, null, new SearchPageViewModel$onSearchUpdate$1$onSearchInterrupted$1(this.this$0, null), 2, null);
            }

            @Override // com.myscript.nebo.dms.search.DMSSearchController.IPageSearch
            public void onClearResults() {
                this.this$0.hits.clear();
                this.this$0.selectedHitIndex = 0;
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), null, null, new SearchPageViewModel$onSearchUpdate$1$onClearResults$1(this.this$0, null), 3, null);
            }
        };
        this.onSearchUpdate = r13;
        searchController.setSearchPageListener((DMSSearchController.IPageSearch) r13);
        searchController.addDMSSearchListener((DMSSearchController.IGridSearch) r12);
    }

    public /* synthetic */ SearchPageViewModel(DMSSearchController dMSSearchController, LibraryRepository libraryRepository, MainCoroutineDispatcher mainCoroutineDispatcher, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dMSSearchController, libraryRepository, (i & 4) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher, (i & 8) != 0 ? Dispatchers.getDefault() : coroutineDispatcher);
    }

    public final LibraryRepository getLibraryRepository() {
        return this.libraryRepository;
    }

    public final LiveData<SearchPageState> getSearchState() {
        return this._searchState;
    }

    public final LiveData<List<String>> getHistory() {
        return this.searchController.getHistory();
    }

    public final DMSSearchController.SearchType getSearchType() {
        return this.searchController.getSearchType();
    }

    public final void setSearchType(DMSSearchController.SearchType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.searchController.setSearchType(value);
    }

    public final SingleLiveEvent<String> getPageIdToShow() {
        return this.pageIdToShow;
    }

    public final LiveData<SearchHitNavState> getHitNavState() {
        return this._hitNavState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSelectedHitNumber() {
        return this.selectedHitIndex + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getHitCount() {
        return this.hits.size();
    }

    public final LiveData<List<SearchMatch>> getSearchHits() {
        return this._searchHits;
    }

    private final boolean isSearchingFromGrid() {
        return getSearchType() == DMSSearchController.SearchType.GRID && getSearchQuery().length() > 0;
    }

    public final boolean isSearchModeActive() {
        return this.searchController.isSearchModeActive();
    }

    public final boolean isSearchProcessing() {
        return this.searchController.isSearchProcessing();
    }

    public final String getSearchQuery() {
        String searchQuery = this.searchController.getSearchQuery();
        return searchQuery == null ? "" : searchQuery;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.searchController.setSearchPageListener(null);
        this.searchController.removeDMSSearchListener(this.onDMSSearchUpdate);
        super.onCleared();
    }

    public final void search(String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.searchController.search(label, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.search.SearchPageViewModel$refreshHitBounds$1 */
    /* JADX INFO: compiled from: SearchPageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.search.SearchPageViewModel$refreshHitBounds$1", m1609f = "SearchPageViewModel.kt", m1610i = {}, m1611l = {234}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {235}, m1615s = {}, m1616v = 2)
    static final class C64431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PageKey $pageKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C64431(PageKey pageKey, Continuation<? super C64431> continuation) {
            super(2, continuation);
            this.$pageKey = pageKey;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SearchPageViewModel.this.new C64431(this.$pageKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SearchPageViewModel.this.refreshHitBoundsInternal(this.$pageKey, this) == coroutine_suspended) {
                    return coroutine_suspended;
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

    public final void refreshHitBounds(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64431(pageKey, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshHitBoundsInternal(PageKey pageKey, Continuation<? super Unit> continuation) {
        C64441 c64441;
        Extent extent;
        PageKey pageKey2 = pageKey;
        if (continuation instanceof C64441) {
            c64441 = (C64441) continuation;
            if ((c64441.label & Integer.MIN_VALUE) != 0) {
                c64441.label -= Integer.MIN_VALUE;
            } else {
                c64441 = new C64441(continuation);
            }
        }
        Object objWithContext = c64441.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c64441.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            MutableLiveData<SearchPageState> mutableLiveData = this._searchState;
            SearchPageState value = mutableLiveData.getValue();
            mutableLiveData.setValue(value != null ? SearchPageState.copy$default(value, null, null, null, false, false, true, false, 79, null) : null);
            if (this.searchController.isSearchProcessing()) {
                return Unit.INSTANCE;
            }
            this.hits.clear();
            CoroutineDispatcher coroutineDispatcher = this.workDispatcher;
            C6445x7d03559b c6445x7d03559b = new C6445x7d03559b(this, pageKey2, null);
            c64441.L$0 = pageKey2;
            c64441.label = 1;
            objWithContext = BuildersKt.withContext(coroutineDispatcher, c6445x7d03559b, c64441);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pageKey2 = (PageKey) c64441.L$0;
            ResultKt.throwOnFailure(objWithContext);
        }
        List list = (List) objWithContext;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                processSearchMatch((SearchMatch) it.next());
            }
        }
        this._searchHits.setValue(CollectionsKt.toList(this.hits));
        int size = this.hits.size();
        int i2 = this.selectedHitIndex;
        if (Intrinsics.areEqual((i2 < 0 || i2 >= size) ? null : this.hits.get(i2).getPageUUID(), pageKey2.uuid())) {
            SWIGVectorExtent extents = this.hits.get(this.selectedHitIndex).getExtents();
            Intrinsics.checkNotNullExpressionValue(extents, "getExtents(...)");
            extent = (Extent) CollectionsKt.first((List) extents);
        } else {
            extent = null;
        }
        this._hitNavState.setValue(new SearchHitNavState(getSelectedHitNumber(), getHitCount(), extent));
        MutableLiveData<SearchPageState> mutableLiveData2 = this._searchState;
        SearchPageState value2 = mutableLiveData2.getValue();
        mutableLiveData2.setValue(value2 != null ? SearchPageState.copy$default(value2, null, null, null, false, true, false, false, 79, null) : null);
        return Unit.INSTANCE;
    }

    public final void bindPageController(PageKey pageKey, PageController pageController) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(pageController, "pageController");
        this.searchController.configureSearchForPage(pageKey, pageController);
        String searchQuery = getSearchQuery();
        if (!isSearchingFromGrid() || searchQuery.length() <= 0) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64401(pageKey, searchQuery, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.search.SearchPageViewModel$bindPageController$1 */
    /* JADX INFO: compiled from: SearchPageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.search.SearchPageViewModel$bindPageController$1", m1609f = "SearchPageViewModel.kt", m1610i = {}, m1611l = {289}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA2_9_1}, m1615s = {}, m1616v = 2)
    static final class C64401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PageKey $pageKey;
        final /* synthetic */ String $searchQuery;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C64401(PageKey pageKey, String str, Continuation<? super C64401> continuation) {
            super(2, continuation);
            this.$pageKey = pageKey;
            this.$searchQuery = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SearchPageViewModel.this.new C64401(this.$pageKey, this.$searchQuery, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SearchPageViewModel.this._searchState.setValue(new SearchPageState(SearchState.Active, this.$pageKey, this.$searchQuery, true, false, false, false, 64, null));
                if (SearchPageViewModel.this.showCurrentHitNextPageBinding) {
                    this.label = 1;
                    if (SearchPageViewModel.this.refreshHitBoundsInternal(this.$pageKey, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int size = SearchPageViewModel.this.hits.size();
            int i2 = SearchPageViewModel.this.selectedHitIndex;
            if (i2 >= 0 && i2 < size) {
                SearchPageViewModel.this.getPageIdToShow().setValue(((SearchMatch) SearchPageViewModel.this.hits.get(SearchPageViewModel.this.selectedHitIndex)).getPageUUID());
                SearchPageViewModel.this.showCurrentHitNextPageBinding = false;
            }
            return Unit.INSTANCE;
        }
    }

    public final void previousHit() {
        if (!isSearchProcessing() || getSearchType() == DMSSearchController.SearchType.GRID) {
            updateSelectedHit(-1);
        }
    }

    public final void nextHit() {
        if (!isSearchProcessing() || getSearchType() == DMSSearchController.SearchType.GRID) {
            updateSelectedHit(1);
        }
    }

    private final void updateSelectedHit(int increment) {
        if (getHitCount() > 0) {
            int i = this.selectedHitIndex;
            this.selectedHitIndex = i + increment < 0 ? getHitCount() - 1 : (i + increment) % getHitCount();
        } else {
            this.selectedHitIndex = 0;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64461(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.search.SearchPageViewModel$updateSelectedHit$1 */
    /* JADX INFO: compiled from: SearchPageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.search.SearchPageViewModel$updateSelectedHit$1", m1609f = "SearchPageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C64461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C64461(Continuation<? super C64461> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SearchPageViewModel.this.new C64461(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64461) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Extent extent = null;
                SearchPageViewModel.this.getPageIdToShow().setValue(SearchPageViewModel.this.getHitCount() > 0 ? ((SearchMatch) SearchPageViewModel.this.hits.get(SearchPageViewModel.this.selectedHitIndex)).getPageUUID() : null);
                if (SearchPageViewModel.this.getHitCount() > 0) {
                    SWIGVectorExtent extents = ((SearchMatch) SearchPageViewModel.this.hits.get(SearchPageViewModel.this.selectedHitIndex)).getExtents();
                    Intrinsics.checkNotNullExpressionValue(extents, "getExtents(...)");
                    extent = (Extent) CollectionsKt.first((List) extents);
                }
                SearchPageViewModel.this._hitNavState.setValue(new SearchHitNavState(SearchPageViewModel.this.getSelectedHitNumber(), SearchPageViewModel.this.getHitCount(), extent));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.search.SearchPageViewModel$openSearch$1 */
    /* JADX INFO: compiled from: SearchPageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.search.SearchPageViewModel$openSearch$1", m1609f = "SearchPageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C64421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C64421(Continuation<? super C64421> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SearchPageViewModel.this.new C64421(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SearchPageViewModel.this._searchState.setValue(new SearchPageState(SearchState.Open, null, null, true, false, false, false, 118, null));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void openSearch() {
        this.searchController.openSearch();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64421(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.search.SearchPageViewModel$closeSearch$1 */
    /* JADX INFO: compiled from: SearchPageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.search.SearchPageViewModel$closeSearch$1", m1609f = "SearchPageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C64411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C64411(Continuation<? super C64411> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SearchPageViewModel.this.new C64411(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SearchPageViewModel.this._hitNavState.setValue(new SearchHitNavState(0, 0, null, 7, null));
                SearchPageViewModel.this._searchState.setValue(new SearchPageState(SearchState.Closed, null, null, false, false, false, false, WebSocketProtocol.PAYLOAD_SHORT, null));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void closeSearch() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64411(null), 2, null);
        this.searchController.closeSearch();
    }

    public final void clearHistory() {
        this.searchController.clearHistory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processSearchMatch(SearchMatch match) {
        Extent next;
        SWIGVectorExtent extents = match.getExtents();
        Intrinsics.checkNotNullExpressionValue(extents, "getExtents(...)");
        Iterator<Extent> it = extents.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Extent extent = next;
            if (extent.valid() && !extent.empty()) {
                break;
            }
        }
        if (next != null) {
            this.hits.add(match);
        }
    }

    public final void showCurrentHitNextPageBinding(boolean show) {
        this.showCurrentHitNextPageBinding = show;
    }

    /* JADX INFO: compiled from: SearchPageViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/editing/search/SearchPageViewModel$Companion;", "", "<init>", "()V", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewModelProvider.Factory getFactory() {
            return SearchPageViewModel.Factory;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchPageViewModel Factory$lambda$0$0(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        ComponentCallbacks2 componentCallbacks2RequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
        Intrinsics.checkNotNull(componentCallbacks2RequireApplication, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
        LibraryRepository libraryRepositoryProvideLibraryRepository = ((LibraryRepository.Provider) componentCallbacks2RequireApplication).provideLibraryRepository();
        return new SearchPageViewModel(libraryRepositoryProvideLibraryRepository.getSearchController(), libraryRepositoryProvideLibraryRepository, null, null, 12, null);
    }

    static {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(SearchPageViewModel.class), new Function1() { // from class: com.myscript.nebo.editing.search.SearchPageViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchPageViewModel.Factory$lambda$0$0((CreationExtras) obj);
            }
        });
        Factory = initializerViewModelFactoryBuilder.build();
    }
}
