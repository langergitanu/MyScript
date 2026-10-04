package com.myscript.nebo.trash;

import com.google.errorprone.annotations.Immutable;
import com.myscript.nebo.dms.core.model.CollectionModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TrashViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Immutable
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, m1599d2 = {"Lcom/myscript/nebo/trash/TrashedCollectionsUIState;", "", "collections", "", "Lcom/myscript/nebo/dms/core/model/CollectionModel;", "showEmptyState", "", "showProgress", "isSelectionMode", "selectedFoldersCount", "", "<init>", "(Ljava/util/List;ZZZI)V", "getCollections", "()Ljava/util/List;", "getShowEmptyState", "()Z", "getShowProgress", "getSelectedFoldersCount", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class TrashedCollectionsUIState {
    public static final int $stable = 0;
    private final List<CollectionModel> collections;
    private final boolean isSelectionMode;
    private final int selectedFoldersCount;
    private final boolean showEmptyState;
    private final boolean showProgress;

    public TrashedCollectionsUIState() {
        this(null, false, false, false, 0, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TrashedCollectionsUIState copy$default(TrashedCollectionsUIState trashedCollectionsUIState, List list, boolean z, boolean z2, boolean z3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = trashedCollectionsUIState.collections;
        }
        if ((i2 & 2) != 0) {
            z = trashedCollectionsUIState.showEmptyState;
        }
        if ((i2 & 4) != 0) {
            z2 = trashedCollectionsUIState.showProgress;
        }
        if ((i2 & 8) != 0) {
            z3 = trashedCollectionsUIState.isSelectionMode;
        }
        if ((i2 & 16) != 0) {
            i = trashedCollectionsUIState.selectedFoldersCount;
        }
        int i3 = i;
        boolean z4 = z2;
        return trashedCollectionsUIState.copy(list, z, z4, z3, i3);
    }

    public final List<CollectionModel> component1() {
        return this.collections;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShowEmptyState() {
        return this.showEmptyState;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowProgress() {
        return this.showProgress;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsSelectionMode() {
        return this.isSelectionMode;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getSelectedFoldersCount() {
        return this.selectedFoldersCount;
    }

    public final TrashedCollectionsUIState copy(List<CollectionModel> collections, boolean showEmptyState, boolean showProgress, boolean isSelectionMode, int selectedFoldersCount) {
        Intrinsics.checkNotNullParameter(collections, "collections");
        return new TrashedCollectionsUIState(collections, showEmptyState, showProgress, isSelectionMode, selectedFoldersCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrashedCollectionsUIState)) {
            return false;
        }
        TrashedCollectionsUIState trashedCollectionsUIState = (TrashedCollectionsUIState) other;
        return Intrinsics.areEqual(this.collections, trashedCollectionsUIState.collections) && this.showEmptyState == trashedCollectionsUIState.showEmptyState && this.showProgress == trashedCollectionsUIState.showProgress && this.isSelectionMode == trashedCollectionsUIState.isSelectionMode && this.selectedFoldersCount == trashedCollectionsUIState.selectedFoldersCount;
    }

    public int hashCode() {
        return (((((((this.collections.hashCode() * 31) + Boolean.hashCode(this.showEmptyState)) * 31) + Boolean.hashCode(this.showProgress)) * 31) + Boolean.hashCode(this.isSelectionMode)) * 31) + Integer.hashCode(this.selectedFoldersCount);
    }

    public String toString() {
        return "TrashedCollectionsUIState(collections=" + this.collections + ", showEmptyState=" + this.showEmptyState + ", showProgress=" + this.showProgress + ", isSelectionMode=" + this.isSelectionMode + ", selectedFoldersCount=" + this.selectedFoldersCount + ")";
    }

    public TrashedCollectionsUIState(List<CollectionModel> collections, boolean z, boolean z2, boolean z3, int i) {
        Intrinsics.checkNotNullParameter(collections, "collections");
        this.collections = collections;
        this.showEmptyState = z;
        this.showProgress = z2;
        this.isSelectionMode = z3;
        this.selectedFoldersCount = i;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ TrashedCollectionsUIState(java.util.List r2, boolean r3, boolean r4, boolean r5, int r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L8
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L8:
            r8 = r7 & 2
            r0 = 0
            if (r8 == 0) goto Le
            r3 = r0
        Le:
            r8 = r7 & 4
            if (r8 == 0) goto L13
            r4 = 1
        L13:
            r8 = r7 & 8
            if (r8 == 0) goto L18
            r5 = r0
        L18:
            r7 = r7 & 16
            if (r7 == 0) goto L23
            r8 = r0
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L29
        L23:
            r8 = r6
            r7 = r5
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L29:
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.myscript.nebo.trash.TrashedCollectionsUIState.<init>(java.util.List, boolean, boolean, boolean, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<CollectionModel> getCollections() {
        return this.collections;
    }

    public final boolean getShowEmptyState() {
        return this.showEmptyState;
    }

    public final boolean getShowProgress() {
        return this.showProgress;
    }

    public final boolean isSelectionMode() {
        return this.isSelectionMode;
    }

    public final int getSelectedFoldersCount() {
        return this.selectedFoldersCount;
    }
}
