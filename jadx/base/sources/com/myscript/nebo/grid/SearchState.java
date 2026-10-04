package com.myscript.nebo.grid;

import com.myscript.nebo.dms.core.model.PageModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GridViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\t\n\u000bB\u0019\b\u0004\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, m1599d2 = {"Lcom/myscript/nebo/grid/SearchState;", "", "filteredPages", "", "Lcom/myscript/nebo/dms/core/model/PageModel;", "<init>", "(Ljava/util/List;)V", "getFilteredPages", "()Ljava/util/List;", "Searching", "Open", "Closed", "Lcom/myscript/nebo/grid/SearchState$Closed;", "Lcom/myscript/nebo/grid/SearchState$Open;", "Lcom/myscript/nebo/grid/SearchState$Searching;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class SearchState {
    public static final int $stable = 8;
    private final List<PageModel> filteredPages;

    public /* synthetic */ SearchState(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }

    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/grid/SearchState$Searching;", "Lcom/myscript/nebo/grid/SearchState;", "filteredPages", "", "Lcom/myscript/nebo/dms/core/model/PageModel;", "<init>", "(Ljava/util/List;)V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Searching extends SearchState {
        public static final int $stable = 8;

        /* JADX WARN: Multi-variable type inference failed */
        public Searching() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Searching(List<PageModel> filteredPages) {
            super(filteredPages, null);
            Intrinsics.checkNotNullParameter(filteredPages, "filteredPages");
        }

        public /* synthetic */ Searching(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
        }
    }

    private SearchState(List<PageModel> list) {
        this.filteredPages = list;
    }

    public /* synthetic */ SearchState(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, null);
    }

    public final List<PageModel> getFilteredPages() {
        return this.filteredPages;
    }

    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/grid/SearchState$Open;", "Lcom/myscript/nebo/grid/SearchState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Open extends SearchState {
        public static final Open INSTANCE = new Open();
        public static final int $stable = 8;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Open)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 8667639;
        }

        public String toString() {
            return "Open";
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Open() {
            super(null, 1, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/grid/SearchState$Closed;", "Lcom/myscript/nebo/grid/SearchState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Closed extends SearchState {
        public static final Closed INSTANCE = new Closed();
        public static final int $stable = 8;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Closed)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -607271463;
        }

        public String toString() {
            return "Closed";
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Closed() {
            super(null, 1, 0 == true ? 1 : 0);
        }
    }
}
