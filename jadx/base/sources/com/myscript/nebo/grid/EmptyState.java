package com.myscript.nebo.grid;

import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.dms.C6208R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GridViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u000f\u0010\u0011\u0012B1\b\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e\u0082\u0001\u0004\u0013\u0014\u0015\u0016¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/grid/EmptyState;", "", "imageResource", "", "titleResource", "subtitleResource", "isShown", "", "<init>", "(IIIZ)V", "getImageResource", "()I", "getTitleResource", "getSubtitleResource", "()Z", "NotEmpty", "NoFolder", "EmptyFolder", "EmptySearch", "Lcom/myscript/nebo/grid/EmptyState$EmptyFolder;", "Lcom/myscript/nebo/grid/EmptyState$EmptySearch;", "Lcom/myscript/nebo/grid/EmptyState$NoFolder;", "Lcom/myscript/nebo/grid/EmptyState$NotEmpty;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class EmptyState {
    public static final int $stable = 0;
    private final int imageResource;
    private final boolean isShown;
    private final int subtitleResource;
    private final int titleResource;

    public /* synthetic */ EmptyState(int i, int i2, int i3, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, z);
    }

    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/grid/EmptyState$NotEmpty;", "Lcom/myscript/nebo/grid/EmptyState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class NotEmpty extends EmptyState {
        public static final int $stable = 0;
        public static final NotEmpty INSTANCE = new NotEmpty();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotEmpty)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1604486204;
        }

        public String toString() {
            return "NotEmpty";
        }

        private NotEmpty() {
            super(0, 0, 0, false, 15, null);
        }
    }

    private EmptyState(int i, int i2, int i3, boolean z) {
        this.imageResource = i;
        this.titleResource = i2;
        this.subtitleResource = i3;
        this.isShown = z;
    }

    public /* synthetic */ EmptyState(int i, int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3, (i4 & 8) != 0 ? false : z, null);
    }

    public final int getImageResource() {
        return this.imageResource;
    }

    public final int getSubtitleResource() {
        return this.subtitleResource;
    }

    public final int getTitleResource() {
        return this.titleResource;
    }

    /* JADX INFO: renamed from: isShown, reason: from getter */
    public final boolean getIsShown() {
        return this.isShown;
    }

    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/grid/EmptyState$NoFolder;", "Lcom/myscript/nebo/grid/EmptyState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class NoFolder extends EmptyState {
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
            return 326291345;
        }

        public String toString() {
            return "NoFolder";
        }

        private NoFolder() {
            super(C6208R.drawable.ic_folder_outlined, C6079R.string.pages_grid_no_folder_open_title, C6079R.string.pages_grid_no_folder_open_subtext, true, null);
        }
    }

    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/grid/EmptyState$EmptyFolder;", "Lcom/myscript/nebo/grid/EmptyState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class EmptyFolder extends EmptyState {
        public static final int $stable = 0;
        public static final EmptyFolder INSTANCE = new EmptyFolder();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EmptyFolder)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -256443687;
        }

        public String toString() {
            return "EmptyFolder";
        }

        private EmptyFolder() {
            super(C6208R.drawable.ic_folder_outlined, C6079R.string.pages_grid_empty_folder_title, 0, true, 4, null);
        }
    }

    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/grid/EmptyState$EmptySearch;", "Lcom/myscript/nebo/grid/EmptyState;", "searchLabel", "", "notebookName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSearchLabel", "()Ljava/lang/String;", "getNotebookName", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class EmptySearch extends EmptyState {
        public static final int $stable = 0;
        private final String notebookName;
        private final String searchLabel;

        /* JADX WARN: Multi-variable type inference failed */
        public EmptySearch() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ EmptySearch copy$default(EmptySearch emptySearch, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = emptySearch.searchLabel;
            }
            if ((i & 2) != 0) {
                str2 = emptySearch.notebookName;
            }
            return emptySearch.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSearchLabel() {
            return this.searchLabel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getNotebookName() {
            return this.notebookName;
        }

        public final EmptySearch copy(String searchLabel, String notebookName) {
            Intrinsics.checkNotNullParameter(searchLabel, "searchLabel");
            Intrinsics.checkNotNullParameter(notebookName, "notebookName");
            return new EmptySearch(searchLabel, notebookName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EmptySearch)) {
                return false;
            }
            EmptySearch emptySearch = (EmptySearch) other;
            return Intrinsics.areEqual(this.searchLabel, emptySearch.searchLabel) && Intrinsics.areEqual(this.notebookName, emptySearch.notebookName);
        }

        public int hashCode() {
            return (this.searchLabel.hashCode() * 31) + this.notebookName.hashCode();
        }

        public String toString() {
            return "EmptySearch(searchLabel=" + this.searchLabel + ", notebookName=" + this.notebookName + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmptySearch(String searchLabel, String notebookName) {
            super(C6183R.drawable.ic_search, C6079R.string.pages_grid_no_search_result_title, C6079R.string.pages_grid_no_search_result_subtext, true, null);
            Intrinsics.checkNotNullParameter(searchLabel, "searchLabel");
            Intrinsics.checkNotNullParameter(notebookName, "notebookName");
            this.searchLabel = searchLabel;
            this.notebookName = notebookName;
        }

        public /* synthetic */ EmptySearch(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
        }

        public final String getNotebookName() {
            return this.notebookName;
        }

        public final String getSearchLabel() {
            return this.searchLabel;
        }
    }
}
