package com.myscript.nebo.dms.sharepage;

import androidx.lifecycle.Observer;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.dms.sharepage.api.SharingRequester;
import com.myscript.nebo.dms.sharepage.dialog.SinglePageUIController;
import com.myscript.nebo.sso.model.UserData;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.DMS;
import com.myscript.snt.dms.ISharePageManagerUIListener;
import com.myscript.snt.dms.SharePageManager;
import com.myscript.snt.dms.SharePageResult;
import com.myscript.snt.dms.SharePageUser;
import com.myscript.snt.dms.SharePageVisibility;
import java.util.List;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes7.dex */
public final class SharePageController implements SharingRequester.Callback {
    private SharingRequester.Cancelable mCurrentUpload;
    private final NeboNetworkStateRepository mNetworkStateRepository;
    private OnSharePageCanceledOverCellularListener mOnSharePageCanceledOverCellularListener;
    private final SharePageManager mSharePageManager;
    private final SinglePageUIController mSingleSharePageUIController;
    private final Observer<NeboNetworkState> onNetworkUpdate;

    public interface OnSharePageCanceledOverCellularListener {
        void onSharePageCanceledOverCellular();
    }

    public static final class DocumentParams {
        final String dataDirPath;
        final String workingDirPath;

        public DocumentParams(String str, String str2) {
            this.workingDirPath = str;
            this.dataDirPath = str2;
        }
    }

    public SharePageController(DMS dms, DocumentParams documentParams, UserData userData, OkHttpClient okHttpClient, String str, NeboNetworkStateRepository neboNetworkStateRepository) {
        Observer<NeboNetworkState> observer = new Observer<NeboNetworkState>() { // from class: com.myscript.nebo.dms.sharepage.SharePageController.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(NeboNetworkState neboNetworkState) {
                if (neboNetworkState.isDataTransferAllowed() || !SharePageController.this.isSharePageOngoing()) {
                    return;
                }
                SharePageController.this.cancelCurrentUpload();
                if (!(neboNetworkState instanceof NeboNetworkState.Connected) || ((NeboNetworkState.Connected) neboNetworkState).isEnabled() || SharePageController.this.mOnSharePageCanceledOverCellularListener == null) {
                    return;
                }
                SharePageController.this.mOnSharePageCanceledOverCellularListener.onSharePageCanceledOverCellular();
            }
        };
        this.onNetworkUpdate = observer;
        SharePageManager sharePageManagerCreate = SharePageManager.create(dms, documentParams.workingDirPath, documentParams.dataDirPath);
        this.mSharePageManager = sharePageManagerCreate;
        sharePageManagerCreate.stopListPagesTimer();
        sharePageManagerCreate.setRequester(new SharingRequester(userData, okHttpClient, str, this));
        SinglePageUIController singlePageUIController = new SinglePageUIController();
        this.mSingleSharePageUIController = singlePageUIController;
        sharePageManagerCreate.setUIListener(singlePageUIController);
        this.mNetworkStateRepository = neboNetworkStateRepository;
        neboNetworkStateRepository.getNeboNetworkState().observeForever(observer);
    }

    public void destroy() {
        this.mNetworkStateRepository.getNeboNetworkState().removeObserver(this.onNetworkUpdate);
    }

    public void setOnSharePageCanceledOverCellularListener(OnSharePageCanceledOverCellularListener onSharePageCanceledOverCellularListener) {
        this.mOnSharePageCanceledOverCellularListener = onSharePageCanceledOverCellularListener;
    }

    public void sharePage(PageKey pageKey) {
        this.mSharePageManager.sharePage(pageKey);
    }

    public boolean isSharePageOngoing() {
        return this.mCurrentUpload != null;
    }

    public void cancelCurrentUpload() {
        if (isSharePageOngoing()) {
            this.mCurrentUpload.cancel();
        }
    }

    public void loadPageInfos(PageKey pageKey) {
        this.mSharePageManager.fetchSharedPageInfos(pageKey);
    }

    public void removeSharePage(PageKey pageKey) {
        this.mSharePageManager.removeSharePage(pageKey);
    }

    public void changeVisibility(PageKey pageKey, SharePageVisibility sharePageVisibility) {
        this.mSharePageManager.changeVisibility(pageKey, sharePageVisibility);
    }

    public void addUsers(PageKey pageKey, List<SharePageUser> list, String str) {
        this.mSharePageManager.addUsers(pageKey, list, str);
    }

    public void removeUser(PageKey pageKey, String str) {
        this.mSharePageManager.removeUser(pageKey, str);
    }

    public SinglePageUIController getSingleSharePageUIController() {
        return this.mSingleSharePageUIController;
    }

    private void setUiListener(ISharePageManagerUIListener iSharePageManagerUIListener) {
        this.mSharePageManager.setUIListener(iSharePageManagerUIListener);
    }

    @Override // com.myscript.nebo.dms.sharepage.api.SharingRequester.Callback
    public void onSharePageDone(PageKey pageKey, SharePageResult sharePageResult) {
        this.mCurrentUpload = null;
        this.mSharePageManager.sharePageDone(pageKey, sharePageResult);
    }

    @Override // com.myscript.nebo.dms.sharepage.api.SharingRequester.Callback
    public void onUploadStarted(PageKey pageKey, float f, SharingRequester.Cancelable cancelable) {
        this.mCurrentUpload = cancelable;
        this.mSharePageManager.changeSharePageUploadProgress(pageKey, 0.0f, f);
    }

    @Override // com.myscript.nebo.dms.sharepage.api.SharingRequester.Callback
    public void onSharePageProgress(PageKey pageKey, float f, float f2) {
        this.mSharePageManager.changeSharePageUploadProgress(pageKey, f, f2);
    }
}
