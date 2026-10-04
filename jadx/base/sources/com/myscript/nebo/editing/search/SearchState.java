package com.myscript.nebo.editing.search;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SearchPageViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/editing/search/SearchState;", "", "<init>", "(Ljava/lang/String;I)V", "Open", "Active", "Closed", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SearchState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SearchState[] $VALUES;
    public static final SearchState Open = new SearchState("Open", 0);
    public static final SearchState Active = new SearchState("Active", 1);
    public static final SearchState Closed = new SearchState("Closed", 2);

    private static final /* synthetic */ SearchState[] $values() {
        return new SearchState[]{Open, Active, Closed};
    }

    public static EnumEntries<SearchState> getEntries() {
        return $ENTRIES;
    }

    public static SearchState valueOf(String str) {
        return (SearchState) Enum.valueOf(SearchState.class, str);
    }

    public static SearchState[] values() {
        return (SearchState[]) $VALUES.clone();
    }

    private SearchState(String str, int i) {
    }

    static {
        SearchState[] searchStateArr$values = $values();
        $VALUES = searchStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(searchStateArr$values);
    }
}
