package com.myscript.nebo.dms.expandlist;

import android.R;
import android.content.Context;
import androidx.core.content.res.ResourcesCompat;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.common.OngoingProgress;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.core.model.SelectionState;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.dms.SyncProgress;
import com.myscript.snt.dms.SyncState;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FolderUI.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0015\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BC\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000f\"\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d8G¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u001d8G¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0011\u0010\"\u001a\u00020\u001d8G¢\u0006\u0006\u001a\u0004\b#\u0010\u001fR\u0011\u0010$\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b$\u0010\u000fR\u0011\u0010%\u001a\u00020\u001d8G¢\u0006\u0006\u001a\u0004\b&\u0010\u001fR\u0011\u0010'\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b'\u0010\u000fR\u0011\u0010(\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b(\u0010\u000fR\u0011\u0010)\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b*\u0010\u001fR\u0011\u0010+\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b+\u0010\u000fR\u0011\u0010,\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b-\u0010\u001fR\u0011\u0010.\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b.\u0010\u000fR\u0011\u0010/\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b/\u0010\u000fR\u0011\u00100\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b0\u0010\u000fR\u0011\u00101\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b1\u0010\u000f¨\u00065"}, m1599d2 = {"Lcom/myscript/nebo/dms/expandlist/FolderUI;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "folder", "Lcom/myscript/nebo/dms/core/model/FolderModel;", "ongoingProgresses", "", "Lcom/myscript/snt/core/NotebookKey;", "Lcom/myscript/nebo/common/OngoingProgress;", "isSelected", "", "isSelectionMode", "<init>", "(Landroid/content/Context;Lcom/myscript/nebo/dms/core/model/FolderModel;Ljava/util/Map;ZZ)V", "()Z", "setSelected", "(Z)V", "setSelectionMode", "ongoingProgress", "getOngoingProgress", "()Lcom/myscript/nebo/common/OngoingProgress;", "isDownloadAllowed", "setDownloadAllowed", "name", "", "getName", "()Ljava/lang/String;", "coverIconRes", "", "getCoverIconRes", "()I", "coverColor", "getCoverColor", "coverBackgroundRes", "getCoverBackgroundRes", "isCoverVisible", "cloudIconRes", "getCloudIconRes", "isCloudStateEnabled", "isCloudStateVisible", "searchCount", "getSearchCount", "isSearchCountVisible", "trashedPagesCount", "getTrashedPagesCount", "isTrashedPagesCountVisible", "isCancelVisible", "isProgressVisible", "isSyncable", "computeSelectorState", "", "isHovering", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FolderUI {
    public static final int $stable = 8;
    private final Context context;
    private final FolderModel folder;
    private boolean isDownloadAllowed;
    private boolean isSelected;
    private boolean isSelectionMode;
    private final OngoingProgress ongoingProgress;

    /* JADX INFO: compiled from: FolderUI.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SelectionState.values().length];
            try {
                iArr[SelectionState.SELECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SelectionState.UNSELECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SyncState.values().length];
            try {
                iArr2[SyncState.NEED_UPLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[SyncState.NEED_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[SyncState.CONFLICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[SyncState.NEED_MERGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[SyncState.TO_DELETE_LOCALLY.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FolderUI(Context context, FolderModel folder) {
        this(context, folder, null, false, false, 28, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(folder, "folder");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FolderUI(Context context, FolderModel folder, Map<NotebookKey, OngoingProgress> ongoingProgresses) {
        this(context, folder, ongoingProgresses, false, false, 24, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intrinsics.checkNotNullParameter(ongoingProgresses, "ongoingProgresses");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FolderUI(Context context, FolderModel folder, Map<NotebookKey, OngoingProgress> ongoingProgresses, boolean z) {
        this(context, folder, ongoingProgresses, z, false, 16, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intrinsics.checkNotNullParameter(ongoingProgresses, "ongoingProgresses");
    }

    public FolderUI(Context context, FolderModel folder, Map<NotebookKey, OngoingProgress> ongoingProgresses, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intrinsics.checkNotNullParameter(ongoingProgresses, "ongoingProgresses");
        this.context = context;
        this.folder = folder;
        this.isSelected = z;
        this.isSelectionMode = z2;
        OngoingProgress ongoingProgress = ongoingProgresses.get(folder.getNotebookKey());
        this.ongoingProgress = (ongoingProgress == null || folder.getSyncProgress() == SyncProgress.NONE) ? null : ongoingProgress;
    }

    public /* synthetic */ FolderUI(Context context, FolderModel folderModel, Map map, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, folderModel, (i & 4) != 0 ? MapsKt.emptyMap() : map, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2);
    }

    /* JADX INFO: renamed from: isSelected, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    /* JADX INFO: renamed from: isSelectionMode, reason: from getter */
    public final boolean getIsSelectionMode() {
        return this.isSelectionMode;
    }

    public final void setSelectionMode(boolean z) {
        this.isSelectionMode = z;
    }

    public final OngoingProgress getOngoingProgress() {
        return this.ongoingProgress;
    }

    /* JADX INFO: renamed from: isDownloadAllowed, reason: from getter */
    public final boolean getIsDownloadAllowed() {
        return this.isDownloadAllowed;
    }

    public final void setDownloadAllowed(boolean z) {
        this.isDownloadAllowed = z;
    }

    public final String getName() {
        return this.folder.getName();
    }

    public final int getCoverIconRes() {
        return this.folder.isTrashed() ? C6208R.drawable.ic_folder_outlined : !this.folder.isValid() ? C6208R.drawable.ic_folder_invalid : !this.folder.isSupported() ? C6208R.drawable.ic_folder_off_outlined : C6208R.drawable.ic_folder;
    }

    public final int getCoverColor() {
        boolean z = (!this.folder.isSupported() || this.folder.isTrashed() || this.folder.getColor() == 0) ? false : true;
        Integer numValueOf = Integer.valueOf(this.folder.getColor());
        numValueOf.intValue();
        if (!z) {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : ResourcesCompat.getColor(this.context.getResources(), C6183R.color.colorInvalidNotebookCover, this.context.getTheme());
    }

    public final int getCoverBackgroundRes() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.folder.getSelectionState().ordinal()];
        if (i == 1) {
            return C6208R.drawable.ic_cover_background_selected;
        }
        if (i == 2) {
            return C6208R.drawable.ic_cover_background;
        }
        return C6183R.drawable.ic_empty;
    }

    public final boolean isCoverVisible() {
        return this.folder.getSelectionState() != SelectionState.SELECTED;
    }

    public final int getCloudIconRes() {
        boolean z = this.folder.getSyncProgress() != SyncProgress.NONE;
        SyncState syncState = this.folder.getSyncState();
        return (this.folder.isAutoSyncEnabled() || !(syncState == SyncState.NEED_MERGE || syncState == SyncState.CONFLICT)) ? (syncState != SyncState.NEED_UPLOAD || z || this.folder.isAutoSyncEnabled()) ? (syncState != SyncState.NEED_DOWNLOAD || z || this.folder.isAutoSyncEnabled()) ? syncState == SyncState.TO_DELETE_LOCALLY ? C6208R.drawable.ic_cloud_cross_outline : C6183R.drawable.ic_empty : C6208R.drawable.ic_cloud_refresh_outline : C6208R.drawable.ic_cloud_refresh_outline : C6208R.drawable.ic_cloud_refresh_outline;
    }

    public final boolean isCloudStateEnabled() {
        return this.isDownloadAllowed && !this.isSelectionMode && this.folder.getSyncState() != SyncState.UP_TO_DATE && this.folder.getSyncProgress() == SyncProgress.NONE;
    }

    public final boolean isCloudStateVisible() {
        return this.folder.getSyncProgress() == SyncProgress.NONE && this.folder.getSearchCount() == 0 && isSyncable() && !this.isSelectionMode;
    }

    public final int getSearchCount() {
        return this.folder.getSearchCount();
    }

    public final boolean isSearchCountVisible() {
        return this.folder.getSearchCount() > 0;
    }

    public final int getTrashedPagesCount() {
        return this.folder.getTrashedPagesCount();
    }

    public final boolean isTrashedPagesCountVisible() {
        return this.folder.isTrashed() && this.folder.getTrashedPagesCount() > 0;
    }

    public final boolean isCancelVisible() {
        return (this.folder.isAutoSyncEnabled() || this.folder.getSyncProgress() == SyncProgress.NONE) ? false : true;
    }

    public final boolean isProgressVisible() {
        return this.folder.isSyncing() && !this.folder.isSyncQueued();
    }

    public final boolean isSyncable() {
        int i = WhenMappings.$EnumSwitchMapping$1[this.folder.getSyncState().ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5;
    }

    public final int[] computeSelectorState(boolean isHovering) {
        return new int[]{(!this.folder.isSupported() || this.folder.isTrashed()) ? -16842910 : R.attr.state_enabled, this.isSelected ? R.attr.state_selected : -16842913, this.folder.isOpened() ? R.attr.state_activated : -16843518, isHovering ? R.attr.state_drag_hovered : -16843625, this.folder.isSupported() ? R.attr.state_drag_can_accept : -16843624};
    }
}
