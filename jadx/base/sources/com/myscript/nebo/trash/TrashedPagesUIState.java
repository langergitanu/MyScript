package com.myscript.nebo.trash;

import com.google.errorprone.annotations.Immutable;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.grid.DisplayMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.PersistentList;

/* JADX INFO: compiled from: TrashViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Immutable
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\u000eHÆ\u0003JU\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0014\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020\bHÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0018R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, m1599d2 = {"Lcom/myscript/nebo/trash/TrashedPagesUIState;", "", "folderName", "", "pages", "Lkotlinx/collections/immutable/ImmutableList;", "Lcom/myscript/nebo/dms/core/model/PageModel;", "remainingPagesCount", "", "showProgress", "", "isSelectionMode", "isTrashEmpty", "displayMode", "Lcom/myscript/nebo/grid/DisplayMode;", "<init>", "(Ljava/lang/String;Lkotlinx/collections/immutable/ImmutableList;IZZZLcom/myscript/nebo/grid/DisplayMode;)V", "getFolderName", "()Ljava/lang/String;", "getPages", "()Lkotlinx/collections/immutable/ImmutableList;", "getRemainingPagesCount", "()I", "getShowProgress", "()Z", "getDisplayMode", "()Lcom/myscript/nebo/grid/DisplayMode;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class TrashedPagesUIState {
    public static final int $stable = 0;
    private final DisplayMode displayMode;
    private final String folderName;
    private final boolean isSelectionMode;
    private final boolean isTrashEmpty;
    private final ImmutableList<PageModel> pages;
    private final int remainingPagesCount;
    private final boolean showProgress;

    public TrashedPagesUIState() {
        this(null, null, 0, false, false, false, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TrashedPagesUIState copy$default(TrashedPagesUIState trashedPagesUIState, String str, ImmutableList immutableList, int i, boolean z, boolean z2, boolean z3, DisplayMode displayMode, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = trashedPagesUIState.folderName;
        }
        if ((i2 & 2) != 0) {
            immutableList = trashedPagesUIState.pages;
        }
        if ((i2 & 4) != 0) {
            i = trashedPagesUIState.remainingPagesCount;
        }
        if ((i2 & 8) != 0) {
            z = trashedPagesUIState.showProgress;
        }
        if ((i2 & 16) != 0) {
            z2 = trashedPagesUIState.isSelectionMode;
        }
        if ((i2 & 32) != 0) {
            z3 = trashedPagesUIState.isTrashEmpty;
        }
        if ((i2 & 64) != 0) {
            displayMode = trashedPagesUIState.displayMode;
        }
        boolean z4 = z3;
        DisplayMode displayMode2 = displayMode;
        boolean z5 = z2;
        int i3 = i;
        return trashedPagesUIState.copy(str, immutableList, i3, z, z5, z4, displayMode2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFolderName() {
        return this.folderName;
    }

    public final ImmutableList<PageModel> component2() {
        return this.pages;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRemainingPagesCount() {
        return this.remainingPagesCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShowProgress() {
        return this.showProgress;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsSelectionMode() {
        return this.isSelectionMode;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsTrashEmpty() {
        return this.isTrashEmpty;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final DisplayMode getDisplayMode() {
        return this.displayMode;
    }

    public final TrashedPagesUIState copy(String folderName, ImmutableList<PageModel> pages, int remainingPagesCount, boolean showProgress, boolean isSelectionMode, boolean isTrashEmpty, DisplayMode displayMode) {
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(displayMode, "displayMode");
        return new TrashedPagesUIState(folderName, pages, remainingPagesCount, showProgress, isSelectionMode, isTrashEmpty, displayMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrashedPagesUIState)) {
            return false;
        }
        TrashedPagesUIState trashedPagesUIState = (TrashedPagesUIState) other;
        return Intrinsics.areEqual(this.folderName, trashedPagesUIState.folderName) && Intrinsics.areEqual(this.pages, trashedPagesUIState.pages) && this.remainingPagesCount == trashedPagesUIState.remainingPagesCount && this.showProgress == trashedPagesUIState.showProgress && this.isSelectionMode == trashedPagesUIState.isSelectionMode && this.isTrashEmpty == trashedPagesUIState.isTrashEmpty && Intrinsics.areEqual(this.displayMode, trashedPagesUIState.displayMode);
    }

    public int hashCode() {
        return (((((((((((this.folderName.hashCode() * 31) + this.pages.hashCode()) * 31) + Integer.hashCode(this.remainingPagesCount)) * 31) + Boolean.hashCode(this.showProgress)) * 31) + Boolean.hashCode(this.isSelectionMode)) * 31) + Boolean.hashCode(this.isTrashEmpty)) * 31) + this.displayMode.hashCode();
    }

    public String toString() {
        return "TrashedPagesUIState(folderName=" + this.folderName + ", pages=" + this.pages + ", remainingPagesCount=" + this.remainingPagesCount + ", showProgress=" + this.showProgress + ", isSelectionMode=" + this.isSelectionMode + ", isTrashEmpty=" + this.isTrashEmpty + ", displayMode=" + this.displayMode + ")";
    }

    public TrashedPagesUIState(String folderName, ImmutableList<PageModel> pages, int i, boolean z, boolean z2, boolean z3, DisplayMode displayMode) {
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(displayMode, "displayMode");
        this.folderName = folderName;
        this.pages = pages;
        this.remainingPagesCount = i;
        this.showProgress = z;
        this.isSelectionMode = z2;
        this.isTrashEmpty = z3;
        this.displayMode = displayMode;
    }

    public /* synthetic */ TrashedPagesUIState(String str, PersistentList persistentList, int i, boolean z, boolean z2, boolean z3, DisplayMode.Grid grid, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? ExtensionsKt.persistentListOf() : persistentList, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? true : z3, (i2 & 64) != 0 ? DisplayMode.Grid.INSTANCE : grid);
    }

    public final String getFolderName() {
        return this.folderName;
    }

    public final ImmutableList<PageModel> getPages() {
        return this.pages;
    }

    public final int getRemainingPagesCount() {
        return this.remainingPagesCount;
    }

    public final boolean getShowProgress() {
        return this.showProgress;
    }

    public final boolean isSelectionMode() {
        return this.isSelectionMode;
    }

    public final boolean isTrashEmpty() {
        return this.isTrashEmpty;
    }

    public final DisplayMode getDisplayMode() {
        return this.displayMode;
    }
}
