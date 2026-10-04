package com.myscript.nebo.dms.search;

import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.dms.search.DMSSearchController;
import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.ISearchListener;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.SearchMatch;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DMSSearchController.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u001c"}, m1599d2 = {"com/myscript/nebo/dms/search/DMSSearchController$onSearchUpdate$1", "Lcom/myscript/snt/core/ISearchListener;", "searchStarted", "", "rootPath", "", "searchEnded", "hitCount", "", "searchStartedDocument", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "searchEndedDocument", "searchStartedPage", "pageKey", "Lcom/myscript/snt/core/PageKey;", "searchEndedPage", "searchStartedCollection", "collectionKey", "Lcom/myscript/snt/core/CollectionKey;", "searchEndedCollection", "newSearchMatch", "match", "Lcom/myscript/snt/core/SearchMatch;", "searchInterrupted", "onFirstSearchResultInDocument", "onFirstSearchResultInCollection", "onTitleMatch", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DMSSearchController$onSearchUpdate$1 implements ISearchListener {
    final /* synthetic */ DMSSearchController this$0;

    /* JADX INFO: compiled from: DMSSearchController.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DMSSearchController.SearchType.values().length];
            try {
                iArr[DMSSearchController.SearchType.PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DMSSearchController.SearchType.GRID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DMSSearchController.SearchType.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.myscript.snt.core.ISearchListener
    public void onFirstSearchResultInCollection(CollectionKey collectionKey) {
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
    }

    @Override // com.myscript.snt.core.ISearchListener
    public void onFirstSearchResultInDocument(NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
    }

    @Override // com.myscript.snt.core.ISearchListener
    public void searchEndedCollection(CollectionKey collectionKey, int hitCount) {
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
    }

    @Override // com.myscript.snt.core.ISearchListener
    public void searchStartedCollection(CollectionKey collectionKey) {
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
    }

    DMSSearchController$onSearchUpdate$1(DMSSearchController dMSSearchController) {
        this.this$0 = dMSSearchController;
    }

    @Override // com.myscript.snt.core.ISearchListener
    public void searchStarted(final String rootPath) {
        Intrinsics.checkNotNullParameter(rootPath, "rootPath");
        Object obj = this.this$0.searchLock;
        DMSSearchController dMSSearchController = this.this$0;
        synchronized (obj) {
            dMSSearchController.isSearching = true;
            Unit unit = Unit.INSTANCE;
        }
        this.this$0.notifyDMSListeners(new Function1() { // from class: com.myscript.nebo.dms.search.DMSSearchController$onSearchUpdate$1$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return DMSSearchController$onSearchUpdate$1.searchStarted$lambda$1(rootPath, (DMSSearchController.IGridSearch) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchStarted$lambda$1(String str, DMSSearchController.IGridSearch it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onSearchStarted(str);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.snt.core.ISearchListener
    public void searchEnded(final int hitCount) {
        Object obj = this.this$0.searchLock;
        DMSSearchController dMSSearchController = this.this$0;
        synchronized (obj) {
            dMSSearchController.isSearching = false;
            Unit unit = Unit.INSTANCE;
        }
        if (this.this$0.getSearchType() == DMSSearchController.SearchType.GRID) {
            this.this$0.notifyDMSListeners(new Function1() { // from class: com.myscript.nebo.dms.search.DMSSearchController$onSearchUpdate$1$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return DMSSearchController$onSearchUpdate$1.searchEnded$lambda$3(hitCount, (DMSSearchController.IGridSearch) obj2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchEnded$lambda$3(int i, DMSSearchController.IGridSearch it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onSearchEnded(i);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.snt.core.ISearchListener
    public void searchStartedDocument(final NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        if (this.this$0.getSearchType() == DMSSearchController.SearchType.GRID) {
            this.this$0.notifyDMSListeners(new Function1() { // from class: com.myscript.nebo.dms.search.DMSSearchController$onSearchUpdate$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DMSSearchController$onSearchUpdate$1.searchStartedDocument$lambda$4(notebookKey, (DMSSearchController.IGridSearch) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchStartedDocument$lambda$4(NotebookKey notebookKey, DMSSearchController.IGridSearch it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onSearchStartedFolder(notebookKey);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.snt.core.ISearchListener
    public void searchEndedDocument(final NotebookKey notebookKey, final int hitCount) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        if (this.this$0.getSearchType() == DMSSearchController.SearchType.GRID) {
            this.this$0.notifyDMSListeners(new Function1() { // from class: com.myscript.nebo.dms.search.DMSSearchController$onSearchUpdate$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DMSSearchController$onSearchUpdate$1.searchEndedDocument$lambda$5(notebookKey, hitCount, (DMSSearchController.IGridSearch) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchEndedDocument$lambda$5(NotebookKey notebookKey, int i, DMSSearchController.IGridSearch it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onSearchEndedFolder(notebookKey, i);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.snt.core.ISearchListener
    public void searchStartedPage(PageKey pageKey) {
        DMSSearchController.IPageSearch searchPageListener;
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        if (this.this$0.getSearchType() == DMSSearchController.SearchType.PAGE) {
            Object obj = this.this$0.searchLock;
            DMSSearchController dMSSearchController = this.this$0;
            synchronized (obj) {
                dMSSearchController.isSearching = true;
                Unit unit = Unit.INSTANCE;
            }
            String searchQuery = this.this$0.getSearchQuery();
            if (searchQuery == null || (searchPageListener = this.this$0.getSearchPageListener()) == null) {
                return;
            }
            searchPageListener.onSearchStartedPage(pageKey, searchQuery);
        }
    }

    @Override // com.myscript.snt.core.ISearchListener
    public void searchEndedPage(final PageKey pageKey, final int hitCount) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        int i = WhenMappings.$EnumSwitchMapping$0[this.this$0.getSearchType().ordinal()];
        if (i == 1) {
            Object obj = this.this$0.searchLock;
            DMSSearchController dMSSearchController = this.this$0;
            synchronized (obj) {
                dMSSearchController.isSearching = false;
                Unit unit = Unit.INSTANCE;
            }
            DMSSearchController.IPageSearch searchPageListener = this.this$0.getSearchPageListener();
            if (searchPageListener != null) {
                searchPageListener.onSearchEndedPage(pageKey, hitCount);
                return;
            }
            return;
        }
        if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            return;
        }
        PageModel page = this.this$0.libraryRepository.getPage(pageKey);
        if (page == null || page.isContainer()) {
            return;
        }
        PageKey paginatedContainerKeyFromPageKey = this.this$0.libraryRepository.getPaginatedContainerKeyFromPageKey(pageKey);
        if (paginatedContainerKeyFromPageKey != null) {
            pageKey = paginatedContainerKeyFromPageKey;
        }
        this.this$0.notifyDMSListeners(new Function1() { // from class: com.myscript.nebo.dms.search.DMSSearchController$onSearchUpdate$1$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return DMSSearchController$onSearchUpdate$1.searchEndedPage$lambda$8(pageKey, hitCount, (DMSSearchController.IGridSearch) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchEndedPage$lambda$8(PageKey pageKey, int i, DMSSearchController.IGridSearch it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onSearchEndedPage(pageKey, i);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.snt.core.ISearchListener
    public void newSearchMatch(SearchMatch match) {
        DMSSearchController.IPageSearch searchPageListener;
        Intrinsics.checkNotNullParameter(match, "match");
        if (this.this$0.getSearchType() != DMSSearchController.SearchType.PAGE || (searchPageListener = this.this$0.getSearchPageListener()) == null) {
            return;
        }
        searchPageListener.onAddSearchMatch(match);
    }

    @Override // com.myscript.snt.core.ISearchListener
    public void searchInterrupted() {
        Object obj = this.this$0.searchLock;
        DMSSearchController dMSSearchController = this.this$0;
        synchronized (obj) {
            dMSSearchController.isSearching = false;
            Unit unit = Unit.INSTANCE;
        }
        this.this$0.setSearchQuery(null);
        DMSSearchController.IPageSearch searchPageListener = this.this$0.getSearchPageListener();
        if (searchPageListener != null) {
            searchPageListener.onSearchInterrupted();
        }
        this.this$0.notifyDMSListeners(new Function1() { // from class: com.myscript.nebo.dms.search.DMSSearchController$onSearchUpdate$1$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return DMSSearchController$onSearchUpdate$1.searchInterrupted$lambda$10((DMSSearchController.IGridSearch) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchInterrupted$lambda$10(DMSSearchController.IGridSearch it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onSearchInterrupted();
        return Unit.INSTANCE;
    }

    @Override // com.myscript.snt.core.ISearchListener
    public void onTitleMatch(final PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        if (this.this$0.getSearchType() == DMSSearchController.SearchType.GRID) {
            PageKey paginatedContainerKeyFromPageKey = this.this$0.libraryRepository.getPaginatedContainerKeyFromPageKey(pageKey);
            if (paginatedContainerKeyFromPageKey != null) {
                pageKey = paginatedContainerKeyFromPageKey;
            }
            this.this$0.notifyDMSListeners(new Function1() { // from class: com.myscript.nebo.dms.search.DMSSearchController$onSearchUpdate$1$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DMSSearchController$onSearchUpdate$1.onTitleMatch$lambda$11(pageKey, (DMSSearchController.IGridSearch) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onTitleMatch$lambda$11(PageKey pageKey, DMSSearchController.IGridSearch it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onTitleMatch(pageKey);
        return Unit.INSTANCE;
    }
}
