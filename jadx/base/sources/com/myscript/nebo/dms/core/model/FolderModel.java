package com.myscript.nebo.dms.core.model;

import com.myscript.nebo.analytics.firebase.AIQuizConstants;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.dms.Notebook;
import com.myscript.snt.dms.SyncProgress;
import com.myscript.snt.dms.SyncState;
import java.text.Collator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FolderModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b\u0014\b\u0087\b\u0018\u0000 L2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0001:\u0001LB¥\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0003\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u00105\u001a\u00020\r2\b\u00106\u001a\u0004\u0018\u00010\u0000H\u0096\u0082\u0004J\n\u00107\u001a\u00020\rH\u0096\u0080\u0004J\u0014\u00108\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u000109H\u0096\u0082\u0004J\n\u0010:\u001a\u00020\u000bH\u0096\u0080\u0004J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\tHÆ\u0003J\t\u0010@\u001a\u00020\u000bHÆ\u0003J\t\u0010A\u001a\u00020\rHÆ\u0003J\t\u0010B\u001a\u00020\u000fHÆ\u0003J\t\u0010C\u001a\u00020\u0011HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\rHÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\rHÆ\u0003J\t\u0010H\u001a\u00020\rHÆ\u0003J\t\u0010I\u001a\u00020\u0018HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J©\u0001\u0010K\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0005HÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u001e\"\u0004\b)\u0010*R\u0011\u0010\u0013\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b+\u0010$R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u001eR\u0011\u0010\u0015\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u0011\u0010\u0016\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001e\"\u0004\b2\u0010*R\u0011\u00103\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b3\u0010\u001eR\u0011\u00104\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b4\u0010\u001e¨\u0006M"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/model/FolderModel;", "", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "isValid", "", "isSupported", "isLocal", "lastModificationDate", "", "name", "", "color", "", "syncState", "Lcom/myscript/snt/dms/SyncState;", "syncProgress", "Lcom/myscript/snt/dms/SyncProgress;", "isOpened", "searchCount", "isTrashed", "trashedPagesCount", "remainingPagesCount", "selectionState", "Lcom/myscript/nebo/dms/core/model/SelectionState;", "isAutoSyncEnabled", "<init>", "(Lcom/myscript/snt/core/NotebookKey;ZZZJLjava/lang/String;ILcom/myscript/snt/dms/SyncState;Lcom/myscript/snt/dms/SyncProgress;ZIZIILcom/myscript/nebo/dms/core/model/SelectionState;Z)V", "getNotebookKey", "()Lcom/myscript/snt/core/NotebookKey;", "()Z", "getLastModificationDate", "()J", "getName", "()Ljava/lang/String;", "getColor", "()I", "getSyncState", "()Lcom/myscript/snt/dms/SyncState;", "getSyncProgress", "()Lcom/myscript/snt/dms/SyncProgress;", "setOpened", "(Z)V", "getSearchCount", "getTrashedPagesCount", "getRemainingPagesCount", "getSelectionState", "()Lcom/myscript/nebo/dms/core/model/SelectionState;", "setSelectionState", "(Lcom/myscript/nebo/dms/core/model/SelectionState;)V", "setAutoSyncEnabled", "isSyncQueued", "isSyncing", "compareTo", "other", "hashCode", "equals", "", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "Companion", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class FolderModel implements Comparable<FolderModel> {
    private final int color;
    private boolean isAutoSyncEnabled;
    private final boolean isLocal;
    private boolean isOpened;
    private final boolean isSupported;
    private final boolean isTrashed;
    private final boolean isValid;
    private final long lastModificationDate;
    private final String name;
    private final NotebookKey notebookKey;
    private final int remainingPagesCount;
    private final int searchCount;
    private SelectionState selectionState;
    private final SyncProgress syncProgress;
    private final SyncState syncState;
    private final int trashedPagesCount;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ FolderModel copy$default(FolderModel folderModel, NotebookKey notebookKey, boolean z, boolean z2, boolean z3, long j, String str, int i, SyncState syncState, SyncProgress syncProgress, boolean z4, int i2, boolean z5, int i3, int i4, SelectionState selectionState, boolean z6, int i5, Object obj) {
        NotebookKey notebookKey2 = (i5 & 1) != 0 ? folderModel.notebookKey : notebookKey;
        return folderModel.copy(notebookKey2, (i5 & 2) != 0 ? folderModel.isValid : z, (i5 & 4) != 0 ? folderModel.isSupported : z2, (i5 & 8) != 0 ? folderModel.isLocal : z3, (i5 & 16) != 0 ? folderModel.lastModificationDate : j, (i5 & 32) != 0 ? folderModel.name : str, (i5 & 64) != 0 ? folderModel.color : i, (i5 & 128) != 0 ? folderModel.syncState : syncState, (i5 & 256) != 0 ? folderModel.syncProgress : syncProgress, (i5 & 512) != 0 ? folderModel.isOpened : z4, (i5 & 1024) != 0 ? folderModel.searchCount : i2, (i5 & 2048) != 0 ? folderModel.isTrashed : z5, (i5 & 4096) != 0 ? folderModel.trashedPagesCount : i3, (i5 & 8192) != 0 ? folderModel.remainingPagesCount : i4, (i5 & 16384) != 0 ? folderModel.selectionState : selectionState, (i5 & 32768) != 0 ? folderModel.isAutoSyncEnabled : z6);
    }

    @JvmStatic
    public static final FolderModel fromNotebook(Notebook notebook, boolean z) {
        return INSTANCE.fromNotebook(notebook, z);
    }

    @JvmStatic
    public static final FolderModel fromNotebook(Notebook notebook, boolean z, boolean z2) {
        return INSTANCE.fromNotebook(notebook, z, z2);
    }

    @JvmStatic
    public static final FolderModel fromNotebook(Notebook notebook, boolean z, boolean z2, int i) {
        return INSTANCE.fromNotebook(notebook, z, z2, i);
    }

    @JvmStatic
    public static final FolderModel fromNotebook(Notebook notebook, boolean z, boolean z2, int i, int i2) {
        return INSTANCE.fromNotebook(notebook, z, z2, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final NotebookKey getNotebookKey() {
        return this.notebookKey;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsOpened() {
        return this.isOpened;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getSearchCount() {
        return this.searchCount;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsTrashed() {
        return this.isTrashed;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getTrashedPagesCount() {
        return this.trashedPagesCount;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getRemainingPagesCount() {
        return this.remainingPagesCount;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final SelectionState getSelectionState() {
        return this.selectionState;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getIsAutoSyncEnabled() {
        return this.isAutoSyncEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsValid() {
        return this.isValid;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSupported() {
        return this.isSupported;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsLocal() {
        return this.isLocal;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getLastModificationDate() {
        return this.lastModificationDate;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final SyncState getSyncState() {
        return this.syncState;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final SyncProgress getSyncProgress() {
        return this.syncProgress;
    }

    public final FolderModel copy(NotebookKey notebookKey, boolean isValid, boolean isSupported, boolean isLocal, long lastModificationDate, String name, int color, SyncState syncState, SyncProgress syncProgress, boolean isOpened, int searchCount, boolean isTrashed, int trashedPagesCount, int remainingPagesCount, SelectionState selectionState, boolean isAutoSyncEnabled) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(syncState, "syncState");
        Intrinsics.checkNotNullParameter(syncProgress, "syncProgress");
        Intrinsics.checkNotNullParameter(selectionState, "selectionState");
        return new FolderModel(notebookKey, isValid, isSupported, isLocal, lastModificationDate, name, color, syncState, syncProgress, isOpened, searchCount, isTrashed, trashedPagesCount, remainingPagesCount, selectionState, isAutoSyncEnabled);
    }

    public FolderModel(NotebookKey notebookKey, boolean z, boolean z2, boolean z3, long j, String name, int i, SyncState syncState, SyncProgress syncProgress, boolean z4, int i2, boolean z5, int i3, int i4, SelectionState selectionState, boolean z6) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(syncState, "syncState");
        Intrinsics.checkNotNullParameter(syncProgress, "syncProgress");
        Intrinsics.checkNotNullParameter(selectionState, "selectionState");
        this.notebookKey = notebookKey;
        this.isValid = z;
        this.isSupported = z2;
        this.isLocal = z3;
        this.lastModificationDate = j;
        this.name = name;
        this.color = i;
        this.syncState = syncState;
        this.syncProgress = syncProgress;
        this.isOpened = z4;
        this.searchCount = i2;
        this.isTrashed = z5;
        this.trashedPagesCount = i3;
        this.remainingPagesCount = i4;
        this.selectionState = selectionState;
        this.isAutoSyncEnabled = z6;
    }

    public final NotebookKey getNotebookKey() {
        return this.notebookKey;
    }

    public final boolean isValid() {
        return this.isValid;
    }

    public final boolean isSupported() {
        return this.isSupported;
    }

    public final boolean isLocal() {
        return this.isLocal;
    }

    public final long getLastModificationDate() {
        return this.lastModificationDate;
    }

    public /* synthetic */ FolderModel(NotebookKey notebookKey, boolean z, boolean z2, boolean z3, long j, String str, int i, SyncState syncState, SyncProgress syncProgress, boolean z4, int i2, boolean z5, int i3, int i4, SelectionState selectionState, boolean z6, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(notebookKey, (i5 & 2) != 0 ? true : z, (i5 & 4) != 0 ? true : z2, (i5 & 8) == 0 ? z3 : true, (i5 & 16) != 0 ? 0L : j, (i5 & 32) != 0 ? "" : str, (i5 & 64) != 0 ? 0 : i, (i5 & 128) != 0 ? SyncState.UP_TO_DATE : syncState, (i5 & 256) != 0 ? SyncProgress.NONE : syncProgress, (i5 & 512) != 0 ? false : z4, (i5 & 1024) != 0 ? 0 : i2, (i5 & 2048) != 0 ? false : z5, (i5 & 4096) != 0 ? 0 : i3, (i5 & 8192) != 0 ? 0 : i4, (i5 & 16384) != 0 ? SelectionState.NOT_SELECTABLE : selectionState, (i5 & 32768) != 0 ? false : z6);
    }

    public final String getName() {
        return this.name;
    }

    public final int getColor() {
        return this.color;
    }

    public final SyncState getSyncState() {
        return this.syncState;
    }

    public final SyncProgress getSyncProgress() {
        return this.syncProgress;
    }

    public final boolean isOpened() {
        return this.isOpened;
    }

    public final void setOpened(boolean z) {
        this.isOpened = z;
    }

    public final int getSearchCount() {
        return this.searchCount;
    }

    public final boolean isTrashed() {
        return this.isTrashed;
    }

    public final int getTrashedPagesCount() {
        return this.trashedPagesCount;
    }

    public final int getRemainingPagesCount() {
        return this.remainingPagesCount;
    }

    public final SelectionState getSelectionState() {
        return this.selectionState;
    }

    public final void setSelectionState(SelectionState selectionState) {
        Intrinsics.checkNotNullParameter(selectionState, "<set-?>");
        this.selectionState = selectionState;
    }

    public final boolean isAutoSyncEnabled() {
        return this.isAutoSyncEnabled;
    }

    public final void setAutoSyncEnabled(boolean z) {
        this.isAutoSyncEnabled = z;
    }

    public final boolean isSyncQueued() {
        return this.syncProgress == SyncProgress.SYNC_QUEUED;
    }

    public final boolean isSyncing() {
        return this.syncProgress == SyncProgress.SYNCING;
    }

    @Override // java.lang.Comparable
    public int compareTo(FolderModel other) {
        if (other == null) {
            return 1;
        }
        return Collator.getInstance().compare(this.name, other.name);
    }

    public int hashCode() {
        return this.notebookKey.hashCode();
    }

    public boolean equals(Object other) {
        NotebookKey notebookKey = this.notebookKey;
        FolderModel folderModel = other instanceof FolderModel ? (FolderModel) other : null;
        return Intrinsics.areEqual(notebookKey, folderModel != null ? folderModel.notebookKey : null);
    }

    public String toString() {
        return this.name;
    }

    /* JADX INFO: compiled from: FolderModel.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/model/FolderModel$Companion;", "", "<init>", "()V", "fromNotebook", "Lcom/myscript/nebo/dms/core/model/FolderModel;", AIQuizConstants.NOTEBOOK, "Lcom/myscript/snt/dms/Notebook;", "isAutoSyncEnabled", "", "hasTrashedChildren", "trashedPagesCount", "", "remainingPagesCount", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final FolderModel fromNotebook(Notebook notebook, boolean z) {
            Intrinsics.checkNotNullParameter(notebook, "notebook");
            return fromNotebook$default(this, notebook, z, false, 0, 0, 28, null);
        }

        @JvmStatic
        public final FolderModel fromNotebook(Notebook notebook, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(notebook, "notebook");
            return fromNotebook$default(this, notebook, z, z2, 0, 0, 24, null);
        }

        @JvmStatic
        public final FolderModel fromNotebook(Notebook notebook, boolean z, boolean z2, int i) {
            Intrinsics.checkNotNullParameter(notebook, "notebook");
            return fromNotebook$default(this, notebook, z, z2, i, 0, 16, null);
        }

        private Companion() {
        }

        public static /* synthetic */ FolderModel fromNotebook$default(Companion companion, Notebook notebook, boolean z, boolean z2, int i, int i2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                z2 = false;
            }
            if ((i3 & 8) != 0) {
                i = 0;
            }
            if ((i3 & 16) != 0) {
                i2 = 0;
            }
            return companion.fromNotebook(notebook, z, z2, i, i2);
        }

        @JvmStatic
        public final FolderModel fromNotebook(Notebook notebook, boolean isAutoSyncEnabled, boolean hasTrashedChildren, int trashedPagesCount, int remainingPagesCount) {
            boolean z;
            boolean z2;
            Intrinsics.checkNotNullParameter(notebook, "notebook");
            NotebookKey key = notebook.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "getKey(...)");
            boolean z3 = false;
            if (notebook.isCorrupted() || !notebook.isValid()) {
                z = false;
                z2 = true;
            } else {
                z = false;
                z3 = true;
                z2 = true;
            }
            boolean zIsSupported = notebook.isSupported();
            boolean zIsCloudOnly = notebook.isCloudOnly() ^ z2;
            boolean z4 = z2;
            long lastModificationDate = notebook.getLastModificationDate();
            String name = notebook.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            int coverColor2 = notebook.getCoverColor2();
            SyncState syncState = notebook.syncState();
            Intrinsics.checkNotNullExpressionValue(syncState, "syncState(...)");
            SyncProgress syncProgress = notebook.syncProgress();
            Intrinsics.checkNotNullExpressionValue(syncProgress, "syncProgress(...)");
            return new FolderModel(key, z3, zIsSupported, zIsCloudOnly, lastModificationDate, name, coverColor2, syncState, syncProgress, false, 0, (notebook.isTrashed() || hasTrashedChildren) ? z4 : z, trashedPagesCount, remainingPagesCount, null, isAutoSyncEnabled, 16384, null);
        }
    }
}
