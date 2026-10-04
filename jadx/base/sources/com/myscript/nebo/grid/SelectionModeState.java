package com.myscript.nebo.grid;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GridViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003Jm\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0014\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020\rHÖ\u0081\u0004J\n\u0010)\u001a\u00020*HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006+"}, m1599d2 = {"Lcom/myscript/nebo/grid/SelectionModeState;", "", "isSelectionMode", "", "canDuplicate", "canExport", "canMove", "canDelete", "canSelectAll", "canShare", "canUnselectAll", "canEdit", "selectedItemCount", "", "<init>", "(ZZZZZZZZZI)V", "()Z", "getCanDuplicate", "getCanExport", "getCanMove", "getCanDelete", "getCanSelectAll", "getCanShare", "getCanUnselectAll", "getCanEdit", "getSelectedItemCount", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class SelectionModeState {
    public static final int $stable = 0;
    private final boolean canDelete;
    private final boolean canDuplicate;
    private final boolean canEdit;
    private final boolean canExport;
    private final boolean canMove;
    private final boolean canSelectAll;
    private final boolean canShare;
    private final boolean canUnselectAll;
    private final boolean isSelectionMode;
    private final int selectedItemCount;

    public SelectionModeState() {
        this(false, false, false, false, false, false, false, false, false, 0, 1023, null);
    }

    public static /* synthetic */ SelectionModeState copy$default(SelectionModeState selectionModeState, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = selectionModeState.isSelectionMode;
        }
        if ((i2 & 2) != 0) {
            z2 = selectionModeState.canDuplicate;
        }
        if ((i2 & 4) != 0) {
            z3 = selectionModeState.canExport;
        }
        if ((i2 & 8) != 0) {
            z4 = selectionModeState.canMove;
        }
        if ((i2 & 16) != 0) {
            z5 = selectionModeState.canDelete;
        }
        if ((i2 & 32) != 0) {
            z6 = selectionModeState.canSelectAll;
        }
        if ((i2 & 64) != 0) {
            z7 = selectionModeState.canShare;
        }
        if ((i2 & 128) != 0) {
            z8 = selectionModeState.canUnselectAll;
        }
        if ((i2 & 256) != 0) {
            z9 = selectionModeState.canEdit;
        }
        if ((i2 & 512) != 0) {
            i = selectionModeState.selectedItemCount;
        }
        boolean z10 = z9;
        int i3 = i;
        boolean z11 = z7;
        boolean z12 = z8;
        boolean z13 = z5;
        boolean z14 = z6;
        return selectionModeState.copy(z, z2, z3, z4, z13, z14, z11, z12, z10, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsSelectionMode() {
        return this.isSelectionMode;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getSelectedItemCount() {
        return this.selectedItemCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanDuplicate() {
        return this.canDuplicate;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanExport() {
        return this.canExport;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCanMove() {
        return this.canMove;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanDelete() {
        return this.canDelete;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getCanSelectAll() {
        return this.canSelectAll;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getCanShare() {
        return this.canShare;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getCanUnselectAll() {
        return this.canUnselectAll;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getCanEdit() {
        return this.canEdit;
    }

    public final SelectionModeState copy(boolean isSelectionMode, boolean canDuplicate, boolean canExport, boolean canMove, boolean canDelete, boolean canSelectAll, boolean canShare, boolean canUnselectAll, boolean canEdit, int selectedItemCount) {
        return new SelectionModeState(isSelectionMode, canDuplicate, canExport, canMove, canDelete, canSelectAll, canShare, canUnselectAll, canEdit, selectedItemCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectionModeState)) {
            return false;
        }
        SelectionModeState selectionModeState = (SelectionModeState) other;
        return this.isSelectionMode == selectionModeState.isSelectionMode && this.canDuplicate == selectionModeState.canDuplicate && this.canExport == selectionModeState.canExport && this.canMove == selectionModeState.canMove && this.canDelete == selectionModeState.canDelete && this.canSelectAll == selectionModeState.canSelectAll && this.canShare == selectionModeState.canShare && this.canUnselectAll == selectionModeState.canUnselectAll && this.canEdit == selectionModeState.canEdit && this.selectedItemCount == selectionModeState.selectedItemCount;
    }

    public int hashCode() {
        return (((((((((((((((((Boolean.hashCode(this.isSelectionMode) * 31) + Boolean.hashCode(this.canDuplicate)) * 31) + Boolean.hashCode(this.canExport)) * 31) + Boolean.hashCode(this.canMove)) * 31) + Boolean.hashCode(this.canDelete)) * 31) + Boolean.hashCode(this.canSelectAll)) * 31) + Boolean.hashCode(this.canShare)) * 31) + Boolean.hashCode(this.canUnselectAll)) * 31) + Boolean.hashCode(this.canEdit)) * 31) + Integer.hashCode(this.selectedItemCount);
    }

    public String toString() {
        return "SelectionModeState(isSelectionMode=" + this.isSelectionMode + ", canDuplicate=" + this.canDuplicate + ", canExport=" + this.canExport + ", canMove=" + this.canMove + ", canDelete=" + this.canDelete + ", canSelectAll=" + this.canSelectAll + ", canShare=" + this.canShare + ", canUnselectAll=" + this.canUnselectAll + ", canEdit=" + this.canEdit + ", selectedItemCount=" + this.selectedItemCount + ")";
    }

    public SelectionModeState(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, int i) {
        this.isSelectionMode = z;
        this.canDuplicate = z2;
        this.canExport = z3;
        this.canMove = z4;
        this.canDelete = z5;
        this.canSelectAll = z6;
        this.canShare = z7;
        this.canUnselectAll = z8;
        this.canEdit = z9;
        this.selectedItemCount = i;
    }

    public /* synthetic */ SelectionModeState(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? false : z3, (i2 & 8) != 0 ? false : z4, (i2 & 16) != 0 ? false : z5, (i2 & 32) != 0 ? false : z6, (i2 & 64) != 0 ? false : z7, (i2 & 128) != 0 ? false : z8, (i2 & 256) != 0 ? false : z9, (i2 & 512) != 0 ? 0 : i);
    }

    public final boolean isSelectionMode() {
        return this.isSelectionMode;
    }

    public final boolean getCanDuplicate() {
        return this.canDuplicate;
    }

    public final boolean getCanExport() {
        return this.canExport;
    }

    public final boolean getCanMove() {
        return this.canMove;
    }

    public final boolean getCanDelete() {
        return this.canDelete;
    }

    public final boolean getCanSelectAll() {
        return this.canSelectAll;
    }

    public final boolean getCanShare() {
        return this.canShare;
    }

    public final boolean getCanUnselectAll() {
        return this.canUnselectAll;
    }

    public final boolean getCanEdit() {
        return this.canEdit;
    }

    public final int getSelectedItemCount() {
        return this.selectedItemCount;
    }
}
