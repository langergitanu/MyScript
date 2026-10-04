package com.myscript.nebo.grid;

import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.grid.DisplayMode;
import com.myscript.nebo.grid.EmptyState;
import com.myscript.snt.core.NotebookKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GridViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003J\t\u00102\u001a\u00020\nHÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\t\u00104\u001a\u00020\u000eHÆ\u0003J\t\u00105\u001a\u00020\u0010HÆ\u0003J\t\u00106\u001a\u00020\u0012HÆ\u0003J\t\u00107\u001a\u00020\nHÆ\u0003J\t\u00108\u001a\u00020\u0015HÆ\u0003J\t\u00109\u001a\u00020\u0017HÆ\u0003J\u0089\u0001\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017HÆ\u0001J\u0014\u0010;\u001a\u00020\n2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010=\u001a\u00020>HÖ\u0081\u0004J\n\u0010?\u001a\u00020\u0005HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010!R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0013\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006@"}, m1599d2 = {"Lcom/myscript/nebo/grid/FolderUIState;", "", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "folderName", "", "pages", "", "Lcom/myscript/nebo/dms/core/model/PageModel;", "canModify", "", "canOpenPage", "isLoading", "folderState", "Lcom/myscript/nebo/grid/FolderState;", "selectionModeState", "Lcom/myscript/nebo/grid/SelectionModeState;", "emptyState", "Lcom/myscript/nebo/grid/EmptyState;", "hasCorrupted", "sortState", "Lcom/myscript/nebo/grid/SortState;", "displayMode", "Lcom/myscript/nebo/grid/DisplayMode;", "<init>", "(Lcom/myscript/snt/core/NotebookKey;Ljava/lang/String;Ljava/util/List;ZZZLcom/myscript/nebo/grid/FolderState;Lcom/myscript/nebo/grid/SelectionModeState;Lcom/myscript/nebo/grid/EmptyState;ZLcom/myscript/nebo/grid/SortState;Lcom/myscript/nebo/grid/DisplayMode;)V", "getNotebookKey", "()Lcom/myscript/snt/core/NotebookKey;", "getFolderName", "()Ljava/lang/String;", "getPages", "()Ljava/util/List;", "getCanModify", "()Z", "getCanOpenPage", "getFolderState", "()Lcom/myscript/nebo/grid/FolderState;", "getSelectionModeState", "()Lcom/myscript/nebo/grid/SelectionModeState;", "getEmptyState", "()Lcom/myscript/nebo/grid/EmptyState;", "getHasCorrupted", "getSortState", "()Lcom/myscript/nebo/grid/SortState;", "getDisplayMode", "()Lcom/myscript/nebo/grid/DisplayMode;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class FolderUIState {
    public static final int $stable = 8;
    private final boolean canModify;
    private final boolean canOpenPage;
    private final DisplayMode displayMode;
    private final EmptyState emptyState;
    private final String folderName;
    private final FolderState folderState;
    private final boolean hasCorrupted;
    private final boolean isLoading;
    private final NotebookKey notebookKey;
    private final List<PageModel> pages;
    private final SelectionModeState selectionModeState;
    private final SortState sortState;

    public FolderUIState() {
        this(null, null, null, false, false, false, null, null, null, false, null, null, 4095, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FolderUIState copy$default(FolderUIState folderUIState, NotebookKey notebookKey, String str, List list, boolean z, boolean z2, boolean z3, FolderState folderState, SelectionModeState selectionModeState, EmptyState emptyState, boolean z4, SortState sortState, DisplayMode displayMode, int i, Object obj) {
        if ((i & 1) != 0) {
            notebookKey = folderUIState.notebookKey;
        }
        if ((i & 2) != 0) {
            str = folderUIState.folderName;
        }
        if ((i & 4) != 0) {
            list = folderUIState.pages;
        }
        if ((i & 8) != 0) {
            z = folderUIState.canModify;
        }
        if ((i & 16) != 0) {
            z2 = folderUIState.canOpenPage;
        }
        if ((i & 32) != 0) {
            z3 = folderUIState.isLoading;
        }
        if ((i & 64) != 0) {
            folderState = folderUIState.folderState;
        }
        if ((i & 128) != 0) {
            selectionModeState = folderUIState.selectionModeState;
        }
        if ((i & 256) != 0) {
            emptyState = folderUIState.emptyState;
        }
        if ((i & 512) != 0) {
            z4 = folderUIState.hasCorrupted;
        }
        if ((i & 1024) != 0) {
            sortState = folderUIState.sortState;
        }
        if ((i & 2048) != 0) {
            displayMode = folderUIState.displayMode;
        }
        SortState sortState2 = sortState;
        DisplayMode displayMode2 = displayMode;
        EmptyState emptyState2 = emptyState;
        boolean z5 = z4;
        FolderState folderState2 = folderState;
        SelectionModeState selectionModeState2 = selectionModeState;
        boolean z6 = z2;
        boolean z7 = z3;
        return folderUIState.copy(notebookKey, str, list, z, z6, z7, folderState2, selectionModeState2, emptyState2, z5, sortState2, displayMode2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final NotebookKey getNotebookKey() {
        return this.notebookKey;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getHasCorrupted() {
        return this.hasCorrupted;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final SortState getSortState() {
        return this.sortState;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final DisplayMode getDisplayMode() {
        return this.displayMode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFolderName() {
        return this.folderName;
    }

    public final List<PageModel> component3() {
        return this.pages;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCanModify() {
        return this.canModify;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanOpenPage() {
        return this.canOpenPage;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final FolderState getFolderState() {
        return this.folderState;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final SelectionModeState getSelectionModeState() {
        return this.selectionModeState;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final EmptyState getEmptyState() {
        return this.emptyState;
    }

    public final FolderUIState copy(NotebookKey notebookKey, String folderName, List<PageModel> pages, boolean canModify, boolean canOpenPage, boolean isLoading, FolderState folderState, SelectionModeState selectionModeState, EmptyState emptyState, boolean hasCorrupted, SortState sortState, DisplayMode displayMode) {
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(folderState, "folderState");
        Intrinsics.checkNotNullParameter(selectionModeState, "selectionModeState");
        Intrinsics.checkNotNullParameter(emptyState, "emptyState");
        Intrinsics.checkNotNullParameter(sortState, "sortState");
        Intrinsics.checkNotNullParameter(displayMode, "displayMode");
        return new FolderUIState(notebookKey, folderName, pages, canModify, canOpenPage, isLoading, folderState, selectionModeState, emptyState, hasCorrupted, sortState, displayMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FolderUIState)) {
            return false;
        }
        FolderUIState folderUIState = (FolderUIState) other;
        return Intrinsics.areEqual(this.notebookKey, folderUIState.notebookKey) && Intrinsics.areEqual(this.folderName, folderUIState.folderName) && Intrinsics.areEqual(this.pages, folderUIState.pages) && this.canModify == folderUIState.canModify && this.canOpenPage == folderUIState.canOpenPage && this.isLoading == folderUIState.isLoading && this.folderState == folderUIState.folderState && Intrinsics.areEqual(this.selectionModeState, folderUIState.selectionModeState) && Intrinsics.areEqual(this.emptyState, folderUIState.emptyState) && this.hasCorrupted == folderUIState.hasCorrupted && Intrinsics.areEqual(this.sortState, folderUIState.sortState) && Intrinsics.areEqual(this.displayMode, folderUIState.displayMode);
    }

    public int hashCode() {
        NotebookKey notebookKey = this.notebookKey;
        return ((((((((((((((((((((((notebookKey == null ? 0 : notebookKey.hashCode()) * 31) + this.folderName.hashCode()) * 31) + this.pages.hashCode()) * 31) + Boolean.hashCode(this.canModify)) * 31) + Boolean.hashCode(this.canOpenPage)) * 31) + Boolean.hashCode(this.isLoading)) * 31) + this.folderState.hashCode()) * 31) + this.selectionModeState.hashCode()) * 31) + this.emptyState.hashCode()) * 31) + Boolean.hashCode(this.hasCorrupted)) * 31) + this.sortState.hashCode()) * 31) + this.displayMode.hashCode();
    }

    public String toString() {
        return "FolderUIState(notebookKey=" + this.notebookKey + ", folderName=" + this.folderName + ", pages=" + this.pages + ", canModify=" + this.canModify + ", canOpenPage=" + this.canOpenPage + ", isLoading=" + this.isLoading + ", folderState=" + this.folderState + ", selectionModeState=" + this.selectionModeState + ", emptyState=" + this.emptyState + ", hasCorrupted=" + this.hasCorrupted + ", sortState=" + this.sortState + ", displayMode=" + this.displayMode + ")";
    }

    public FolderUIState(NotebookKey notebookKey, String folderName, List<PageModel> pages, boolean z, boolean z2, boolean z3, FolderState folderState, SelectionModeState selectionModeState, EmptyState emptyState, boolean z4, SortState sortState, DisplayMode displayMode) {
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(folderState, "folderState");
        Intrinsics.checkNotNullParameter(selectionModeState, "selectionModeState");
        Intrinsics.checkNotNullParameter(emptyState, "emptyState");
        Intrinsics.checkNotNullParameter(sortState, "sortState");
        Intrinsics.checkNotNullParameter(displayMode, "displayMode");
        this.notebookKey = notebookKey;
        this.folderName = folderName;
        this.pages = pages;
        this.canModify = z;
        this.canOpenPage = z2;
        this.isLoading = z3;
        this.folderState = folderState;
        this.selectionModeState = selectionModeState;
        this.emptyState = emptyState;
        this.hasCorrupted = z4;
        this.sortState = sortState;
        this.displayMode = displayMode;
    }

    public final NotebookKey getNotebookKey() {
        return this.notebookKey;
    }

    public /* synthetic */ FolderUIState(NotebookKey notebookKey, String str, List list, boolean z, boolean z2, boolean z3, FolderState folderState, SelectionModeState selectionModeState, EmptyState emptyState, boolean z4, SortState sortState, DisplayMode displayMode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : notebookKey, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? FolderState.Unloaded : folderState, (i & 128) != 0 ? new SelectionModeState(false, false, false, false, false, false, false, false, false, 0, 1023, null) : selectionModeState, (i & 256) != 0 ? EmptyState.NotEmpty.INSTANCE : emptyState, (i & 512) == 0 ? z4 : false, (i & 1024) != 0 ? new SortState(null, null, null, false, 15, null) : sortState, (i & 2048) != 0 ? DisplayMode.Grid.INSTANCE : displayMode);
    }

    public final String getFolderName() {
        return this.folderName;
    }

    public final List<PageModel> getPages() {
        return this.pages;
    }

    public final boolean getCanModify() {
        return this.canModify;
    }

    public final boolean getCanOpenPage() {
        return this.canOpenPage;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final FolderState getFolderState() {
        return this.folderState;
    }

    public final SelectionModeState getSelectionModeState() {
        return this.selectionModeState;
    }

    public final EmptyState getEmptyState() {
        return this.emptyState;
    }

    public final boolean getHasCorrupted() {
        return this.hasCorrupted;
    }

    public final SortState getSortState() {
        return this.sortState;
    }

    public final DisplayMode getDisplayMode() {
        return this.displayMode;
    }
}
