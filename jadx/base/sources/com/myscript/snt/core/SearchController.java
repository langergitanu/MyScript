package com.myscript.snt.core;

import com.myscript.atk.core.Extent;
import com.myscript.atk.core.Page;
import com.myscript.atk.core.SWIGVectorExtent;
import com.myscript.atk.core.SWIGVectorString;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class SearchController {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SearchController(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SearchController searchController) {
        if (searchController == null) {
            return 0L;
        }
        return searchController.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_SearchController(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static class SearchDMSInterface {
        protected transient boolean swigCMemOwn;
        private transient long swigCPtr;

        public SearchDMSInterface(long j, boolean z) {
            this.swigCMemOwn = z;
            this.swigCPtr = j;
        }

        public static long getCPtr(SearchDMSInterface searchDMSInterface) {
            if (searchDMSInterface == null) {
                return 0L;
            }
            return searchDMSInterface.swigCPtr;
        }

        protected void finalize() {
            delete();
        }

        public synchronized void delete() {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    NeboEngineJNI.delete_SearchController_SearchDMSInterface(j);
                }
                this.swigCPtr = 0L;
            }
        }

        public boolean valid() {
            return NeboEngineJNI.SearchController_SearchDMSInterface_valid(this.swigCPtr, this);
        }

        public String rootEntry() {
            return new String(NeboEngineJNI.SearchController_SearchDMSInterface_rootEntry(this.swigCPtr, this), StandardCharsets.UTF_8);
        }

        public List<String> notebooks(String str) {
            return new SWIGVectorString(NeboEngineJNI.SearchController_SearchDMSInterface_notebooks(this.swigCPtr, this, str.getBytes()), true);
        }

        public List<String> collections() {
            return new SWIGVectorString(NeboEngineJNI.SearchController_SearchDMSInterface_collections(this.swigCPtr, this), true);
        }

        public NotebookKey notebookKeyFromEntry(String str) {
            return new NotebookKey(NeboEngineJNI.SearchController_SearchDMSInterface_notebookKeyFromEntry(this.swigCPtr, this, str.getBytes()), true);
        }

        public NotebookKey notebookKeyFromPageKey(PageKey pageKey) {
            return new NotebookKey(NeboEngineJNI.SearchController_SearchDMSInterface_notebookKeyFromPageKey(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey), true);
        }

        public CollectionKey collectionKeyFromEntry(String str) {
            return new CollectionKey(NeboEngineJNI.SearchController_SearchDMSInterface_collectionKeyFromEntry(this.swigCPtr, this, str.getBytes()), true);
        }

        public CollectionKey collectionKeyFromNotebookKey(NotebookKey notebookKey) {
            return new CollectionKey(NeboEngineJNI.SearchController_SearchDMSInterface_collectionKeyFromNotebookKey(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey), true);
        }

        public PageKey pageKeyFromEntry(String str) {
            return new PageKey(NeboEngineJNI.SearchController_SearchDMSInterface_pageKeyFromEntry(this.swigCPtr, this, str.getBytes()), true);
        }

        public PageKey pageKeyFromPageIndex(NotebookKey notebookKey, int i) {
            return new PageKey(NeboEngineJNI.SearchController_SearchDMSInterface_pageKeyFromPageIndex__SWIG_0(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, i), true);
        }

        public Page openPage(PageKey pageKey) {
            return new Page(NeboEngineJNI.SearchController_SearchDMSInterface_openPage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey), true);
        }

        public int pageCount(NotebookKey notebookKey) {
            return NeboEngineJNI.SearchController_SearchDMSInterface_pageCount__SWIG_0(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey);
        }

        public List<PageKey> pages(PageKey pageKey) {
            return new SWIGVectorPageKey(NeboEngineJNI.SearchController_SearchDMSInterface_pages(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey), true);
        }

        public boolean pageIsContainer(PageKey pageKey) {
            return NeboEngineJNI.SearchController_SearchDMSInterface_pageIsContainer(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
        }

        public boolean parentIsContainer(PageKey pageKey) {
            return NeboEngineJNI.SearchController_SearchDMSInterface_parentIsContainer(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
        }

        public PageKey parentContainer(PageKey pageKey) {
            return new PageKey(NeboEngineJNI.SearchController_SearchDMSInterface_parentContainer(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey), true);
        }

        public PageKey pageKeyFromPageIndex(PageKey pageKey, int i) {
            return new PageKey(NeboEngineJNI.SearchController_SearchDMSInterface_pageKeyFromPageIndex__SWIG_1(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, i), true);
        }

        public int pageCount(PageKey pageKey) {
            return NeboEngineJNI.SearchController_SearchDMSInterface_pageCount__SWIG_1(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
        }

        public String pageTitle(PageKey pageKey) {
            return new String(NeboEngineJNI.SearchController_SearchDMSInterface_pageTitle(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey), StandardCharsets.UTF_8);
        }
    }

    public static class SearchDMSFileSystem extends SearchDMSInterface {
        private transient long swigCPtr;

        public SearchDMSFileSystem(long j, boolean z) {
            super(NeboEngineJNI.SearchController_SearchDMSFileSystem_SWIGUpcast(j), z);
            this.swigCPtr = j;
        }

        public static long getCPtr(SearchDMSFileSystem searchDMSFileSystem) {
            if (searchDMSFileSystem == null) {
                return 0L;
            }
            return searchDMSFileSystem.swigCPtr;
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        protected void finalize() {
            delete();
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        public synchronized void delete() {
            if (this.swigCPtr != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    NeboEngineJNI.delete_SearchController_SearchDMSFileSystem(this.swigCPtr);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        }

        public SearchDMSFileSystem(String str) {
            this(NeboEngineJNI.new_SearchController_SearchDMSFileSystem(str.getBytes()), true);
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        public boolean valid() {
            return NeboEngineJNI.SearchController_SearchDMSFileSystem_valid(this.swigCPtr, this);
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        public String rootEntry() {
            return new String(NeboEngineJNI.SearchController_SearchDMSFileSystem_rootEntry(this.swigCPtr, this), StandardCharsets.UTF_8);
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        public List<String> notebooks(String str) {
            return new SWIGVectorString(NeboEngineJNI.SearchController_SearchDMSFileSystem_notebooks(this.swigCPtr, this, str.getBytes()), true);
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        public List<String> collections() {
            return new SWIGVectorString(NeboEngineJNI.SearchController_SearchDMSFileSystem_collections(this.swigCPtr, this), true);
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        public NotebookKey notebookKeyFromEntry(String str) {
            return new NotebookKey(NeboEngineJNI.SearchController_SearchDMSFileSystem_notebookKeyFromEntry(this.swigCPtr, this, str.getBytes()), true);
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        public NotebookKey notebookKeyFromPageKey(PageKey pageKey) {
            return new NotebookKey(NeboEngineJNI.SearchController_SearchDMSFileSystem_notebookKeyFromPageKey(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey), true);
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        public CollectionKey collectionKeyFromEntry(String str) {
            return new CollectionKey(NeboEngineJNI.SearchController_SearchDMSFileSystem_collectionKeyFromEntry(this.swigCPtr, this, str.getBytes()), true);
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        public CollectionKey collectionKeyFromNotebookKey(NotebookKey notebookKey) {
            return new CollectionKey(NeboEngineJNI.m1090x5e7e4b26(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey), true);
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        public PageKey pageKeyFromEntry(String str) {
            return new PageKey(NeboEngineJNI.SearchController_SearchDMSFileSystem_pageKeyFromEntry(this.swigCPtr, this, str.getBytes()), true);
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        public PageKey pageKeyFromPageIndex(NotebookKey notebookKey, int i) {
            return new PageKey(NeboEngineJNI.m1091xa0595be9(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, i), true);
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        public Page openPage(PageKey pageKey) {
            return new Page(NeboEngineJNI.SearchController_SearchDMSFileSystem_openPage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey), true);
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        public int pageCount(NotebookKey notebookKey) {
            return NeboEngineJNI.SearchController_SearchDMSFileSystem_pageCount__SWIG_0(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey);
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        public List<PageKey> pages(PageKey pageKey) {
            return new SWIGVectorPageKey(NeboEngineJNI.SearchController_SearchDMSFileSystem_pages(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey), true);
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        public boolean pageIsContainer(PageKey pageKey) {
            return NeboEngineJNI.SearchController_SearchDMSFileSystem_pageIsContainer(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        public boolean parentIsContainer(PageKey pageKey) {
            return NeboEngineJNI.SearchController_SearchDMSFileSystem_parentIsContainer(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        public PageKey parentContainer(PageKey pageKey) {
            return new PageKey(NeboEngineJNI.SearchController_SearchDMSFileSystem_parentContainer(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey), true);
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        public PageKey pageKeyFromPageIndex(PageKey pageKey, int i) {
            return new PageKey(NeboEngineJNI.m1092xa0595bea(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, i), true);
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        public int pageCount(PageKey pageKey) {
            return NeboEngineJNI.SearchController_SearchDMSFileSystem_pageCount__SWIG_1(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
        }

        @Override // com.myscript.snt.core.SearchController.SearchDMSInterface
        public String pageTitle(PageKey pageKey) {
            return new String(NeboEngineJNI.SearchController_SearchDMSFileSystem_pageTitle(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey), StandardCharsets.UTF_8);
        }
    }

    public SearchController(String str, SearchNotificationFlags searchNotificationFlags) {
        this(NeboEngineJNI.new_SearchController__SWIG_0(str.getBytes(), searchNotificationFlags.swigValue()), true);
    }

    public SearchController(String str) {
        this(NeboEngineJNI.new_SearchController__SWIG_1(str.getBytes()), true);
    }

    public SearchController(C6919x775775d9 c6919x775775d9, SearchNotificationFlags searchNotificationFlags) {
        this(NeboEngineJNI.new_SearchController__SWIG_2(C6919x775775d9.getCPtr(c6919x775775d9), searchNotificationFlags.swigValue()), true);
    }

    public SearchController(C6919x775775d9 c6919x775775d9) {
        this(NeboEngineJNI.new_SearchController__SWIG_3(C6919x775775d9.getCPtr(c6919x775775d9)), true);
    }

    public SearchController(SearchController searchController) {
        this(NeboEngineJNI.new_SearchController__SWIG_4(getCPtr(searchController), searchController), true);
    }

    public void init() {
        NeboEngineJNI.SearchController_init(this.swigCPtr, this);
    }

    public boolean active() {
        return NeboEngineJNI.SearchController_active(this.swigCPtr, this);
    }

    public C6919x775775d9 searchDMSInterface() {
        return new C6919x775775d9(NeboEngineJNI.SearchController_searchDMSInterface(this.swigCPtr, this), true);
    }

    public int numberOfCollectionsForSearch() {
        return NeboEngineJNI.SearchController_numberOfCollectionsForSearch(this.swigCPtr, this);
    }

    public int numberOfDocumentsForSearch(CollectionKey collectionKey) {
        return NeboEngineJNI.SearchController_numberOfDocumentsForSearch(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey);
    }

    public void removeCollectionForSearch(CollectionKey collectionKey) {
        NeboEngineJNI.SearchController_removeCollectionForSearch(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey);
    }

    public void removeDocumentForSearch(CollectionKey collectionKey, NotebookKey notebookKey) {
        NeboEngineJNI.SearchController_removeDocumentForSearch__SWIG_0(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    public void removeDocumentForSearch(NotebookKey notebookKey) {
        NeboEngineJNI.SearchController_removeDocumentForSearch__SWIG_1(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    public void registerSearchListener(ISearchListener iSearchListener) {
        NeboEngineJNI.SearchController_registerSearchListener(this.swigCPtr, this, iSearchListener);
    }

    public void unregisterSearchListener(ISearchListener iSearchListener) {
        NeboEngineJNI.SearchController_unregisterSearchListener(this.swigCPtr, this, iSearchListener);
    }

    public PageKey currentPageKey() {
        return new PageKey(NeboEngineJNI.SearchController_currentPageKey(this.swigCPtr, this), true);
    }

    public void setCurrentPageKey(PageKey pageKey) {
        NeboEngineJNI.SearchController_setCurrentPageKey(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public void setGrid(LayoutGrid layoutGrid) {
        NeboEngineJNI.SearchController_setGrid(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid);
    }

    public int currentSearchMatchColorIndex() {
        return NeboEngineJNI.SearchController_currentSearchMatchColorIndex(this.swigCPtr, this);
    }

    public void setCurrentSearchMatchColorIndex(int i) {
        NeboEngineJNI.SearchController_setCurrentSearchMatchColorIndex(this.swigCPtr, this, i);
    }

    public List<Extent> updateSearchResultWithMatch(CollectionKey collectionKey, NotebookKey notebookKey, PageKey pageKey, Page page, String str, SWIGTYPE_p_atk__text__TextSearch__MatchDetails sWIGTYPE_p_atk__text__TextSearch__MatchDetails) {
        return new SWIGVectorExtent(NeboEngineJNI.SearchController_updateSearchResultWithMatch(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey, NotebookKey.getCPtr(notebookKey), notebookKey, PageKey.getCPtr(pageKey), pageKey, Page.getCPtr(page), page, str.getBytes(), SWIGTYPE_p_atk__text__TextSearch__MatchDetails.getCPtr(sWIGTYPE_p_atk__text__TextSearch__MatchDetails)), true);
    }

    public List<String> retrieveSerializedResults(NotebookKey notebookKey, PageKey pageKey) {
        return new SWIGVectorString(NeboEngineJNI.SearchController_retrieveSerializedResults__SWIG_0(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, PageKey.getCPtr(pageKey), pageKey), true);
    }

    public List<String> retrieveSerializedResults(PageKey pageKey) {
        return new SWIGVectorString(NeboEngineJNI.SearchController_retrieveSerializedResults__SWIG_1(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey), true);
    }

    public List<SearchMatch> retrieveDeserializedSearchResults(NotebookKey notebookKey, PageKey pageKey) {
        return new SWIGVectorSearchMatch(NeboEngineJNI.SearchController_retrieveDeserializedSearchResults__SWIG_0(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, PageKey.getCPtr(pageKey), pageKey), true);
    }

    public List<SearchMatch> retrieveDeserializedSearchResults(PageKey pageKey) {
        return new SWIGVectorSearchMatch(NeboEngineJNI.SearchController_retrieveDeserializedSearchResults__SWIG_1(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey), true);
    }

    public int numberOfCollectionHits() {
        return NeboEngineJNI.SearchController_numberOfCollectionHits(this.swigCPtr, this);
    }

    public int numberOfDocumentHitsInCollection(CollectionKey collectionKey) {
        return NeboEngineJNI.SearchController_numberOfDocumentHitsInCollection(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey);
    }

    public int numberOfDocumentHits() {
        return NeboEngineJNI.SearchController_numberOfDocumentHits(this.swigCPtr, this);
    }

    public int numberOfHitsInCollection(CollectionKey collectionKey) {
        return NeboEngineJNI.SearchController_numberOfHitsInCollection(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey);
    }

    public int numberOfPageHitsInDocument(NotebookKey notebookKey) {
        return NeboEngineJNI.SearchController_numberOfPageHitsInDocument(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    public int numberOfHitsInDocument(NotebookKey notebookKey) {
        return NeboEngineJNI.SearchController_numberOfHitsInDocument(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    public int numberOfHitsInPage(NotebookKey notebookKey, PageKey pageKey) {
        return NeboEngineJNI.SearchController_numberOfHitsInPage__SWIG_0(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, PageKey.getCPtr(pageKey), pageKey);
    }

    public int numberOfHitsInPage(PageKey pageKey) {
        return NeboEngineJNI.SearchController_numberOfHitsInPage__SWIG_1(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public int cumulativeNumberOfHits() {
        return NeboEngineJNI.SearchController_cumulativeNumberOfHits(this.swigCPtr, this);
    }

    public void removeResultInPage(CollectionKey collectionKey, NotebookKey notebookKey, PageKey pageKey) {
        NeboEngineJNI.SearchController_removeResultInPage__SWIG_0(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey, NotebookKey.getCPtr(notebookKey), notebookKey, PageKey.getCPtr(pageKey), pageKey);
    }

    public void removeResultInPage(PageKey pageKey) {
        NeboEngineJNI.SearchController_removeResultInPage__SWIG_1(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public String searchPage(String str, PageKey pageKey) {
        return new String(NeboEngineJNI.SearchController_searchPage(this.swigCPtr, this, str.getBytes(), PageKey.getCPtr(pageKey), pageKey), StandardCharsets.UTF_8);
    }

    public String startSearch(String str) {
        return new String(NeboEngineJNI.SearchController_startSearch(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    public void waitEnd() {
        NeboEngineJNI.SearchController_waitEnd(this.swigCPtr, this);
    }

    public void stopSearch() {
        NeboEngineJNI.SearchController_stopSearch(this.swigCPtr, this);
    }

    public void interruptSearch() {
        NeboEngineJNI.SearchController_interruptSearch(this.swigCPtr, this);
    }

    public SWIGTYPE_p_SearchHelper searchHelper() {
        return new SWIGTYPE_p_SearchHelper(NeboEngineJNI.SearchController_searchHelper(this.swigCPtr, this), false);
    }

    public void setPriorityCollections(List<CollectionKey> list) {
        SWIGVectorCollectionKey sWIGVectorCollectionKey = new SWIGVectorCollectionKey(list);
        NeboEngineJNI.SearchController_setPriorityCollections(this.swigCPtr, this, SWIGVectorCollectionKey.getCPtr(sWIGVectorCollectionKey), sWIGVectorCollectionKey);
    }

    public void setPriorityNotebooks(List<NotebookKey> list) {
        SWIGVectorNotebookKey sWIGVectorNotebookKey = new SWIGVectorNotebookKey(list);
        NeboEngineJNI.SearchController_setPriorityNotebooks(this.swigCPtr, this, SWIGVectorNotebookKey.getCPtr(sWIGVectorNotebookKey), sWIGVectorNotebookKey);
    }

    public void clearSearchWorkers() {
        NeboEngineJNI.SearchController_clearSearchWorkers(this.swigCPtr, this);
    }

    public SearchNotificationFlags notificationFlag() {
        return SearchNotificationFlags.swigToEnum(NeboEngineJNI.SearchController_notificationFlag(this.swigCPtr, this));
    }

    public void enableSearchInNotebooksFeatureFlag(boolean z) {
        NeboEngineJNI.SearchController_enableSearchInNotebooksFeatureFlag(this.swigCPtr, this, z);
    }

    public boolean isEnabledSearchInNotebooksFeatureFlag() {
        return NeboEngineJNI.SearchController_isEnabledSearchInNotebooksFeatureFlag(this.swigCPtr, this);
    }

    public enum SearchNotificationFlags {
        All(0),
        CurrentPageOnly(1);

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static SearchNotificationFlags swigToEnum(int i) {
            SearchNotificationFlags[] searchNotificationFlagsArr = (SearchNotificationFlags[]) SearchNotificationFlags.class.getEnumConstants();
            if (i < searchNotificationFlagsArr.length && i >= 0) {
                SearchNotificationFlags searchNotificationFlags = searchNotificationFlagsArr[i];
                if (searchNotificationFlags.swigValue == i) {
                    return searchNotificationFlags;
                }
            }
            for (SearchNotificationFlags searchNotificationFlags2 : searchNotificationFlagsArr) {
                if (searchNotificationFlags2.swigValue == i) {
                    return searchNotificationFlags2;
                }
            }
            throw new IllegalArgumentException("No enum " + SearchNotificationFlags.class + " with value " + i);
        }

        SearchNotificationFlags() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        SearchNotificationFlags(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        SearchNotificationFlags(SearchNotificationFlags searchNotificationFlags) {
            int i = searchNotificationFlags.swigValue;
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        private static class SwigNext {
            private static int next;

            private SwigNext() {
            }
        }
    }
}
