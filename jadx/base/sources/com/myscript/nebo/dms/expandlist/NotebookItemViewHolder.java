package com.myscript.nebo.dms.expandlist;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.myscript.android.utils.ViewExt;
import com.myscript.nebo.common.MainThreadBus;
import com.myscript.nebo.common.OngoingProgress;
import com.myscript.nebo.common.view.ViewHolderTouchDelegate;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.dms.DragNotebookClipDataHelper;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.event.NotebookMoreMenuEvent;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.dms.SyncProgress;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class NotebookItemViewHolder extends DmsChildItemViewHolder implements View.OnClickListener, ViewHolderTouchDelegate.Listener {
    public static final String MORE_MENU_IS_DELETABLE = "com.myscript.nebo.dms.expandlist.NotebookItemViewHolder.MORE_MENU_IS_DELETABLE";
    public static final String MORE_MENU_IS_EDITABLE = "com.myscript.nebo.dms.expandlist.NotebookItemViewHolder.MORE_MENU_IS_EDITABLE";
    public static final String MORE_MENU_IS_SYNCABLE = "com.myscript.nebo.dms.expandlist.NotebookItemViewHolder.MORE_MENU_IS_SYNCABLE";
    private final View mBackground;
    private final ColorStateList mBackgroundTint;
    private OnNotebookClickedListener mCallback;
    private final ImageButton mCancel;
    private final ImageButton mCloudState;
    private final ImageView mCover;
    private final ImageView mCoverBackground;
    private final View mFocus;
    private Bundle mMoreMenuBundle;
    private final TextView mName;
    private FolderModel mNotebook;
    private final Map<NotebookKey, OngoingProgress> mOngoingProgresses;
    private final ProgressBar mProgress;
    private final TextView mSearchCount;
    private final ViewHolderTouchDelegate mTouchDelegate;
    private FolderUI mUIState;

    public interface OnNotebookClickedListener {
        boolean doesCurrentNetworkProvideDownload();

        boolean isDragConfirmed();

        boolean isSelectionModeEnabled();

        boolean onDragStarted(View view, FolderModel folderModel);

        void onNotebookClicked(FolderModel folderModel);

        void onSelectionChanged(FolderModel folderModel, boolean z);

        void onSyncCancelRequested(FolderModel folderModel);

        void onSyncRequested(FolderModel folderModel);
    }

    NotebookItemViewHolder(ViewGroup viewGroup, Map<NotebookKey, OngoingProgress> map) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(C6208R.layout.dms_notebook_item, viewGroup, false));
        this.mOngoingProgresses = map;
        ImageView imageView = (ImageView) this.itemView.findViewById(C6208R.id.dms_notebook_cover);
        this.mCover = imageView;
        this.mCoverBackground = (ImageView) this.itemView.findViewById(C6208R.id.dms_notebook_cover_selection_mode);
        this.mName = (TextView) this.itemView.findViewById(C6208R.id.dms_notebook_name);
        this.mSearchCount = (TextView) this.itemView.findViewById(C6208R.id.dms_notebook_details);
        this.mProgress = (ProgressBar) this.itemView.findViewById(C6208R.id.notebook_progress_bottom);
        ImageButton imageButton = (ImageButton) this.itemView.findViewById(C6208R.id.dms_notebook_progress_cancel);
        this.mCancel = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.expandlist.NotebookItemViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0(view);
            }
        });
        View viewFindViewById = this.itemView.findViewById(C6208R.id.focused_notebook_item);
        this.mFocus = viewFindViewById;
        viewFindViewById.setOnKeyListener(new View.OnKeyListener() { // from class: com.myscript.nebo.dms.expandlist.NotebookItemViewHolder$$ExternalSyntheticLambda2
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$new$1(view, i, keyEvent);
            }
        });
        View viewFindViewById2 = this.itemView.findViewById(C6208R.id.selected_background_color);
        this.mBackground = viewFindViewById2;
        this.mBackgroundTint = viewFindViewById2.getBackgroundTintList();
        this.mCloudState = (ImageButton) this.itemView.findViewById(C6208R.id.dms_notebook_cloud_state);
        this.mTouchDelegate = new ViewHolderTouchDelegate(this.itemView, DragNotebookClipDataHelper.DRAG_NOTEBOOK_MIME, this);
        this.itemView.setOnClickListener(this);
        imageView.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        this.mCallback.onSyncCancelRequested(this.mNotebook);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$1(View view, int i, KeyEvent keyEvent) {
        if (i != 66) {
            return false;
        }
        onClick(this.mFocus);
        return true;
    }

    void bind(FolderModel folderModel, OnNotebookClickedListener onNotebookClickedListener, boolean z) {
        this.mTouchDelegate.bind(folderModel.getNotebookKey(), z);
        this.mNotebook = folderModel;
        this.mCallback = onNotebookClickedListener;
        this.itemView.setActivated(this.mNotebook.isOpened());
        this.itemView.setSelected(z);
        if (this.mNotebook.getSyncProgress() == SyncProgress.NONE) {
            this.mOngoingProgresses.remove(this.mNotebook.getNotebookKey());
        }
        FolderUI folderUI = new FolderUI(this.itemView.getContext(), folderModel, this.mOngoingProgresses, z, this.mCallback.isSelectionModeEnabled());
        this.mUIState = folderUI;
        folderUI.setSelectionMode(this.mCallback.isSelectionModeEnabled());
        this.mUIState.setDownloadAllowed(this.mCallback.doesCurrentNetworkProvideDownload());
        int[] iArrComputeSelectorState = this.mUIState.computeSelectorState(false);
        this.mCover.setImageResource(this.mUIState.getCoverIconRes());
        this.mCover.setColorFilter(this.mUIState.getCoverColor(), PorterDuff.Mode.SRC_IN);
        this.mCover.setVisibility(this.mUIState.isCoverVisible() ? 0 : 8);
        this.mCoverBackground.setImageResource(this.mUIState.getCoverBackgroundRes());
        this.mName.setText(this.mUIState.getName());
        this.mSearchCount.setText(String.valueOf(this.mUIState.getSearchCount()));
        this.mSearchCount.setVisibility(this.mUIState.isSearchCountVisible() ? 0 : 8);
        setBackgroundTint(iArrComputeSelectorState);
        this.mCloudState.setImageResource(this.mUIState.getCloudIconRes());
        this.mCloudState.setVisibility(this.mUIState.isCloudStateVisible() ? 0 : 8);
        this.mCloudState.setEnabled(this.mUIState.isCloudStateEnabled());
        this.mCloudState.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.expandlist.NotebookItemViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bind$2(view);
            }
        });
        this.mCancel.setVisibility(this.mUIState.isCancelVisible() ? 0 : 8);
        this.mProgress.setVisibility(this.mUIState.isProgressVisible() ? 0 : 8);
        OngoingProgress ongoingProgress = this.mUIState.getOngoingProgress();
        if (ongoingProgress != null) {
            this.mProgress.setIndeterminate(false);
            this.mProgress.setMax(ongoingProgress.getMax());
            ViewExt.animateProgress(this.mProgress, ongoingProgress.getProgress());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bind$2(View view) {
        this.mCallback.onSyncRequested(this.mNotebook);
    }

    private void setupMoreMenuBundle() {
        if (this.mMoreMenuBundle == null) {
            this.mMoreMenuBundle = new Bundle();
        }
        this.mMoreMenuBundle.clear();
        this.mMoreMenuBundle.putBoolean(MORE_MENU_IS_SYNCABLE, this.mUIState.isSyncable());
        this.mMoreMenuBundle.putBoolean(MORE_MENU_IS_DELETABLE, true);
        this.mMoreMenuBundle.putBoolean(MORE_MENU_IS_EDITABLE, true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mCallback.isSelectionModeEnabled()) {
            this.mTouchDelegate.updateSelection(this.mNotebook.getNotebookKey());
        } else if (view == this.mCover) {
            this.mTouchDelegate.updateSelection(this.mNotebook.getNotebookKey());
        } else {
            this.mCallback.onNotebookClicked(this.mNotebook);
        }
    }

    @Override // com.myscript.nebo.common.view.ViewHolderTouchDelegate.Listener
    public boolean isDragging() {
        return this.mCallback.isDragConfirmed();
    }

    @Override // com.myscript.nebo.common.view.ViewHolderTouchDelegate.Listener
    public boolean isDragConfirmed() {
        return this.mCallback.isDragConfirmed();
    }

    @Override // com.myscript.nebo.common.view.ViewHolderTouchDelegate.Listener
    public void onSelectedChanged(boolean z, Object obj) {
        this.mCallback.onSelectionChanged(this.mNotebook, z);
        this.itemView.setSelected(z);
        this.mUIState.setSelected(z);
        this.mCover.setVisibility(this.mUIState.isCoverVisible() ? 0 : 8);
        setBackgroundTint(this.mUIState.computeSelectorState(false));
        this.mCoverBackground.setImageResource(this.mUIState.getCoverBackgroundRes());
    }

    @Override // com.myscript.nebo.common.view.ViewHolderTouchDelegate.Listener
    public boolean onDragStarted(View view) {
        return this.mCallback.onDragStarted(view, this.mNotebook);
    }

    @Override // com.myscript.nebo.common.view.ViewHolderTouchDelegate.Listener
    public void onContextClick(View view, int i, int i2) {
        setupMoreMenuBundle();
        MainThreadBus.eventBus.post(new NotebookMoreMenuEvent(this.mNotebook.getNotebookKey(), this.mMoreMenuBundle, i, i2));
    }

    public void setBackgroundTint(int[] iArr) {
        Drawable background = this.mBackground.getBackground();
        if (background != null) {
            background.setTint(this.mBackgroundTint.getColorForState(iArr, 0));
        }
    }

    void setDraggedOn(boolean z) {
        setBackgroundTint(this.mUIState.computeSelectorState(z));
    }

    void setNotebookDraggedOn(boolean z) {
        setBackgroundTint(this.mUIState.computeSelectorState(z));
    }

    FolderModel getNotebook() {
        return this.mNotebook;
    }

    public void onDragStopped() {
        this.mTouchDelegate.onDragStopped();
    }
}
