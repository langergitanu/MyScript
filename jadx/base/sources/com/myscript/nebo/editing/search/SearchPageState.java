package com.myscript.nebo.editing.search;

import com.myscript.snt.core.PageKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchPageViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003JQ\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tHÆ\u0001J\u0014\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0015R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0015R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0015¨\u0006#"}, m1599d2 = {"Lcom/myscript/nebo/editing/search/SearchPageState;", "", "state", "Lcom/myscript/nebo/editing/search/SearchState;", "pageKey", "Lcom/myscript/snt/core/PageKey;", "searchQuery", "", "isSearchToolbarVisible", "", "isResultsCountVisible", "isProgressVisible", "isActive", "<init>", "(Lcom/myscript/nebo/editing/search/SearchState;Lcom/myscript/snt/core/PageKey;Ljava/lang/String;ZZZZ)V", "getState", "()Lcom/myscript/nebo/editing/search/SearchState;", "getPageKey", "()Lcom/myscript/snt/core/PageKey;", "getSearchQuery", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class SearchPageState {
    public static final int $stable = 8;
    private final boolean isActive;
    private final boolean isProgressVisible;
    private final boolean isResultsCountVisible;
    private final boolean isSearchToolbarVisible;
    private final PageKey pageKey;
    private final String searchQuery;
    private final SearchState state;

    public SearchPageState() {
        this(null, null, null, false, false, false, false, 127, null);
    }

    public static /* synthetic */ SearchPageState copy$default(SearchPageState searchPageState, SearchState searchState, PageKey pageKey, String str, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            searchState = searchPageState.state;
        }
        if ((i & 2) != 0) {
            pageKey = searchPageState.pageKey;
        }
        if ((i & 4) != 0) {
            str = searchPageState.searchQuery;
        }
        if ((i & 8) != 0) {
            z = searchPageState.isSearchToolbarVisible;
        }
        if ((i & 16) != 0) {
            z2 = searchPageState.isResultsCountVisible;
        }
        if ((i & 32) != 0) {
            z3 = searchPageState.isProgressVisible;
        }
        if ((i & 64) != 0) {
            z4 = searchPageState.isActive;
        }
        boolean z5 = z3;
        boolean z6 = z4;
        boolean z7 = z2;
        String str2 = str;
        return searchPageState.copy(searchState, pageKey, str2, z, z7, z5, z6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SearchState getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PageKey getPageKey() {
        return this.pageKey;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSearchQuery() {
        return this.searchQuery;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsSearchToolbarVisible() {
        return this.isSearchToolbarVisible;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsResultsCountVisible() {
        return this.isResultsCountVisible;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsProgressVisible() {
        return this.isProgressVisible;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    public final SearchPageState copy(SearchState state, PageKey pageKey, String searchQuery, boolean isSearchToolbarVisible, boolean isResultsCountVisible, boolean isProgressVisible, boolean isActive) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
        return new SearchPageState(state, pageKey, searchQuery, isSearchToolbarVisible, isResultsCountVisible, isProgressVisible, isActive);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchPageState)) {
            return false;
        }
        SearchPageState searchPageState = (SearchPageState) other;
        return this.state == searchPageState.state && Intrinsics.areEqual(this.pageKey, searchPageState.pageKey) && Intrinsics.areEqual(this.searchQuery, searchPageState.searchQuery) && this.isSearchToolbarVisible == searchPageState.isSearchToolbarVisible && this.isResultsCountVisible == searchPageState.isResultsCountVisible && this.isProgressVisible == searchPageState.isProgressVisible && this.isActive == searchPageState.isActive;
    }

    public int hashCode() {
        int iHashCode = this.state.hashCode() * 31;
        PageKey pageKey = this.pageKey;
        return ((((((((((iHashCode + (pageKey == null ? 0 : pageKey.hashCode())) * 31) + this.searchQuery.hashCode()) * 31) + Boolean.hashCode(this.isSearchToolbarVisible)) * 31) + Boolean.hashCode(this.isResultsCountVisible)) * 31) + Boolean.hashCode(this.isProgressVisible)) * 31) + Boolean.hashCode(this.isActive);
    }

    public String toString() {
        return "SearchPageState(state=" + this.state + ", pageKey=" + this.pageKey + ", searchQuery=" + this.searchQuery + ", isSearchToolbarVisible=" + this.isSearchToolbarVisible + ", isResultsCountVisible=" + this.isResultsCountVisible + ", isProgressVisible=" + this.isProgressVisible + ", isActive=" + this.isActive + ")";
    }

    public SearchPageState(SearchState state, PageKey pageKey, String searchQuery, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
        this.state = state;
        this.pageKey = pageKey;
        this.searchQuery = searchQuery;
        this.isSearchToolbarVisible = z;
        this.isResultsCountVisible = z2;
        this.isProgressVisible = z3;
        this.isActive = z4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SearchPageState(SearchState searchState, PageKey pageKey, String str, boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        searchState = (i & 1) != 0 ? SearchState.Closed : searchState;
        this(searchState, (i & 2) != 0 ? null : pageKey, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? searchState != SearchState.Closed : z4);
    }

    public final SearchState getState() {
        return this.state;
    }

    public final PageKey getPageKey() {
        return this.pageKey;
    }

    public final String getSearchQuery() {
        return this.searchQuery;
    }

    public final boolean isSearchToolbarVisible() {
        return this.isSearchToolbarVisible;
    }

    public final boolean isResultsCountVisible() {
        return this.isResultsCountVisible;
    }

    public final boolean isProgressVisible() {
        return this.isProgressVisible;
    }

    public final boolean isActive() {
        return this.isActive;
    }
}
