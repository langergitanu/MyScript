package com.myscript.nebo.dms.search;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageController;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.SearchController;
import com.myscript.snt.core.SearchMatch;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: DMSSearchController.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\n*\u0001K\b\u0007\u0018\u0000 S2\u00020\u0001:\u0004PQRSB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u00105\u001a\u0002062\u0006\u00107\u001a\u00020.J\u000e\u00108\u001a\u0002062\u0006\u00107\u001a\u00020.J\u0006\u00109\u001a\u000206J\u0006\u0010:\u001a\u000206J\u0006\u0010;\u001a\u000206J\u0016\u0010<\u001a\u0002062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020>J\u0010\u0010?\u001a\u0002062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0018\u0010@\u001a\u0002062\u0006\u0010A\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0006\u0010B\u001a\u000206J\u0006\u0010C\u001a\u000206J+\u0010D\u001a\u0002062!\u0010E\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\bG\u0012\b\bH\u0012\u0004\b\b(I\u0012\u0004\u0012\u0002060FH\u0002J\u0016\u0010M\u001a\u0002062\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00130#H\u0002J\u000e\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00130#H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001d\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130#0\"¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00102\u001a\u0002008F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u0002008F¢\u0006\u0006\u001a\u0004\b4\u00103R\u0010\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0004\n\u0002\u0010L¨\u0006T"}, m1599d2 = {"Lcom/myscript/nebo/dms/search/DMSSearchController;", "", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "searchController", "Lcom/myscript/snt/core/SearchController;", "sharedPreferences", "Landroid/content/SharedPreferences;", "<init>", "(Lcom/myscript/nebo/dms/core/LibraryRepository;Lcom/myscript/snt/core/SearchController;Landroid/content/SharedPreferences;)V", "getSearchController", "()Lcom/myscript/snt/core/SearchController;", "searchType", "Lcom/myscript/nebo/dms/search/DMSSearchController$SearchType;", "getSearchType", "()Lcom/myscript/nebo/dms/search/DMSSearchController$SearchType;", "setSearchType", "(Lcom/myscript/nebo/dms/search/DMSSearchController$SearchType;)V", "searchQuery", "", "getSearchQuery", "()Ljava/lang/String;", "setSearchQuery", "(Ljava/lang/String;)V", "value", "Lcom/myscript/snt/core/NotebookKey;", "notebookKey", "getNotebookKey", "()Lcom/myscript/snt/core/NotebookKey;", "Lcom/myscript/snt/core/PageKey;", "pageKey", "getPageKey", "()Lcom/myscript/snt/core/PageKey;", "history", "Landroidx/lifecycle/MutableLiveData;", "", "getHistory", "()Landroidx/lifecycle/MutableLiveData;", "searchPageListener", "Lcom/myscript/nebo/dms/search/DMSSearchController$IPageSearch;", "getSearchPageListener", "()Lcom/myscript/nebo/dms/search/DMSSearchController$IPageSearch;", "setSearchPageListener", "(Lcom/myscript/nebo/dms/search/DMSSearchController$IPageSearch;)V", "searchDMSListeners", "", "Lcom/myscript/nebo/dms/search/DMSSearchController$IGridSearch;", "isSearching", "", "searchLock", "isSearchProcessing", "()Z", "isSearchModeActive", "addDMSSearchListener", "", "dmsSearchListener", "removeDMSSearchListener", "openSearch", "closeSearch", "stopSearch", "configureSearchForPage", "pageController", "Lcom/myscript/snt/core/PageController;", "setNotebook", FirebaseAnalytics.Event.SEARCH, "label", "clearResults", "clearHistory", "notifyDMSListeners", "notification", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onSearchUpdate", "com/myscript/nebo/dms/search/DMSSearchController$onSearchUpdate$1", "Lcom/myscript/nebo/dms/search/DMSSearchController$onSearchUpdate$1;", "saveSearchHistory", "searchHistory", "loadSearchHistory", "SearchType", "IPageSearch", "IGridSearch", "Companion", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DMSSearchController {
    private static final String SEARCH_HISTORY_PREF_KEY = "search_history";
    private static final String TAG = "SearchController";
    private final MutableLiveData<List<String>> history;
    private boolean isSearching;
    private final LibraryRepository libraryRepository;
    private NotebookKey notebookKey;
    private final DMSSearchController$onSearchUpdate$1 onSearchUpdate;
    private PageKey pageKey;
    private final SearchController searchController;
    private final List<IGridSearch> searchDMSListeners;
    private final Object searchLock;
    private IPageSearch searchPageListener;
    private String searchQuery;
    private SearchType searchType;
    private final SharedPreferences sharedPreferences;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: DMSSearchController.kt */
    @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u0013À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/search/DMSSearchController$IGridSearch;", "", "onSearchStarted", "", "rootPath", "", "onSearchEnded", "hitCount", "", "onSearchEndedPage", "pageKey", "Lcom/myscript/snt/core/PageKey;", "onSearchStartedFolder", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "onSearchEndedFolder", "onSearchInterrupted", "onClearResults", "onTitleMatch", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface IGridSearch {
        void onClearResults();

        void onSearchEnded(int hitCount);

        void onSearchEndedFolder(NotebookKey notebookKey, int hitCount);

        void onSearchEndedPage(PageKey pageKey, int hitCount);

        void onSearchInterrupted();

        void onSearchStarted(String rootPath);

        void onSearchStartedFolder(NotebookKey notebookKey);

        void onTitleMatch(PageKey pageKey);
    }

    /* JADX INFO: compiled from: DMSSearchController.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0010À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/search/DMSSearchController$IPageSearch;", "", "onAddSearchMatch", "", "match", "Lcom/myscript/snt/core/SearchMatch;", "onSearchStartedPage", "pageKey", "Lcom/myscript/snt/core/PageKey;", "searchQuery", "", "onSearchEndedPage", "hitCount", "", "onSearchInterrupted", "onClearResults", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface IPageSearch {
        void onAddSearchMatch(SearchMatch match);

        void onClearResults();

        void onSearchEndedPage(PageKey pageKey, int hitCount);

        void onSearchInterrupted();

        void onSearchStartedPage(PageKey pageKey, String searchQuery);
    }

    public DMSSearchController(LibraryRepository libraryRepository, SearchController searchController, SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(libraryRepository, "libraryRepository");
        Intrinsics.checkNotNullParameter(searchController, "searchController");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.libraryRepository = libraryRepository;
        this.searchController = searchController;
        this.sharedPreferences = sharedPreferences;
        this.searchType = SearchType.NONE;
        MutableLiveData<List<String>> mutableLiveData = new MutableLiveData<>(CollectionsKt.emptyList());
        this.history = mutableLiveData;
        this.searchDMSListeners = new ArrayList();
        this.searchLock = new Object();
        searchController.init();
        mutableLiveData.postValue(loadSearchHistory());
        this.onSearchUpdate = new DMSSearchController$onSearchUpdate$1(this);
    }

    public final SearchController getSearchController() {
        return this.searchController;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: DMSSearchController.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/dms/search/DMSSearchController$SearchType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "PAGE", "GRID", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class SearchType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SearchType[] $VALUES;
        public static final SearchType NONE = new SearchType("NONE", 0);
        public static final SearchType PAGE = new SearchType("PAGE", 1);
        public static final SearchType GRID = new SearchType("GRID", 2);

        private static final /* synthetic */ SearchType[] $values() {
            return new SearchType[]{NONE, PAGE, GRID};
        }

        public static EnumEntries<SearchType> getEntries() {
            return $ENTRIES;
        }

        public static SearchType valueOf(String str) {
            return (SearchType) Enum.valueOf(SearchType.class, str);
        }

        public static SearchType[] values() {
            return (SearchType[]) $VALUES.clone();
        }

        private SearchType(String str, int i) {
        }

        static {
            SearchType[] searchTypeArr$values = $values();
            $VALUES = searchTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(searchTypeArr$values);
        }
    }

    public final SearchType getSearchType() {
        return this.searchType;
    }

    public final void setSearchType(SearchType searchType) {
        Intrinsics.checkNotNullParameter(searchType, "<set-?>");
        this.searchType = searchType;
    }

    public final String getSearchQuery() {
        return this.searchQuery;
    }

    public final void setSearchQuery(String str) {
        this.searchQuery = str;
    }

    public final NotebookKey getNotebookKey() {
        return this.notebookKey;
    }

    public final PageKey getPageKey() {
        return this.pageKey;
    }

    public final MutableLiveData<List<String>> getHistory() {
        return this.history;
    }

    public final IPageSearch getSearchPageListener() {
        return this.searchPageListener;
    }

    public final void setSearchPageListener(IPageSearch iPageSearch) {
        this.searchPageListener = iPageSearch;
    }

    public final boolean isSearchProcessing() {
        boolean z;
        synchronized (this.searchLock) {
            z = this.isSearching;
        }
        return z;
    }

    public final boolean isSearchModeActive() {
        String str = this.searchQuery;
        return !(str == null || StringsKt.isBlank(str));
    }

    public final void addDMSSearchListener(IGridSearch dmsSearchListener) {
        Intrinsics.checkNotNullParameter(dmsSearchListener, "dmsSearchListener");
        synchronized (this.searchDMSListeners) {
            this.searchDMSListeners.add(dmsSearchListener);
        }
    }

    public final void removeDMSSearchListener(IGridSearch dmsSearchListener) {
        Intrinsics.checkNotNullParameter(dmsSearchListener, "dmsSearchListener");
        synchronized (this.searchDMSListeners) {
            this.searchDMSListeners.remove(dmsSearchListener);
        }
    }

    public final void openSearch() {
        this.searchController.registerSearchListener(this.onSearchUpdate);
    }

    public final void closeSearch() {
        stopSearch();
        clearResults();
        this.searchController.unregisterSearchListener(this.onSearchUpdate);
    }

    public final void stopSearch() {
        this.searchController.interruptSearch();
    }

    public final void configureSearchForPage(PageKey pageKey, PageController pageController) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(pageController, "pageController");
        PageKey paginatedContainerKeyFromPageKey = this.libraryRepository.getPaginatedContainerKeyFromPageKey(pageKey);
        if (paginatedContainerKeyFromPageKey != null) {
            pageKey = paginatedContainerKeyFromPageKey;
        }
        this.pageKey = pageKey;
        this.notebookKey = null;
        this.searchController.setCurrentPageKey(pageKey);
        pageController.setSearchController(this.searchController, this.pageKey);
    }

    public final void setNotebook(NotebookKey notebookKey) {
        this.notebookKey = notebookKey;
        this.pageKey = null;
    }

    public final void search(String label, NotebookKey notebookKey) {
        ArrayList arrayList;
        PageKey pageKey;
        Intrinsics.checkNotNullParameter(label, "label");
        this.notebookKey = notebookKey;
        String string = StringsKt.trim((CharSequence) label).toString();
        clearResults();
        if (this.searchType == SearchType.PAGE && (pageKey = this.pageKey) != null) {
            this.searchQuery = this.searchController.searchPage(string, pageKey);
        } else if (SearchType.GRID == this.searchType) {
            this.searchController.setPriorityNotebooks(notebookKey != null ? CollectionsKt.listOf(notebookKey) : CollectionsKt.emptyList());
            this.searchQuery = this.searchController.startSearch(string);
        }
        String str = this.searchQuery;
        if (str != null) {
            List<String> value = this.history.getValue();
            if (value == null || (arrayList = CollectionsKt.toMutableList((Collection) value)) == null) {
                arrayList = new ArrayList();
            }
            if (arrayList.contains(str)) {
                return;
            }
            arrayList.add(str);
            saveSearchHistory(arrayList);
            this.history.postValue(arrayList);
        }
    }

    public final void clearResults() {
        this.searchQuery = null;
        IPageSearch iPageSearch = this.searchPageListener;
        if (iPageSearch != null) {
            iPageSearch.onClearResults();
        }
        notifyDMSListeners(C62791.INSTANCE);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.search.DMSSearchController$clearResults$1 */
    /* JADX INFO: compiled from: DMSSearchController.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C62791 extends FunctionReferenceImpl implements Function1<IGridSearch, Unit> {
        public static final C62791 INSTANCE = new C62791();

        C62791() {
            super(1, IGridSearch.class, "onClearResults", "onClearResults()V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(IGridSearch iGridSearch) {
            invoke2(iGridSearch);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(IGridSearch p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            p0.onClearResults();
        }
    }

    public final void clearHistory() {
        List<String> listEmptyList = CollectionsKt.emptyList();
        saveSearchHistory(listEmptyList);
        this.history.postValue(listEmptyList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyDMSListeners(Function1<? super IGridSearch, Unit> notification) {
        List list;
        synchronized (this.searchDMSListeners) {
            list = CollectionsKt.toList(this.searchDMSListeners);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            notification.invoke(it.next());
        }
    }

    private final void saveSearchHistory(List<String> searchHistory) {
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = searchHistory.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        String string = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(SEARCH_HISTORY_PREF_KEY, string);
        editorEdit.apply();
    }

    private final List<String> loadSearchHistory() {
        ArrayList arrayList = new ArrayList();
        String string = this.sharedPreferences.getString(SEARCH_HISTORY_PREF_KEY, null);
        try {
            String str = string;
            if (str != null && str.length() != 0) {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    String string2 = jSONArray.getString(i);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    arrayList.add(string2);
                }
            }
            return arrayList;
        } catch (JSONException e) {
            Log.e(TAG, "Unable to load Search History", e);
            return arrayList;
        }
    }
}
