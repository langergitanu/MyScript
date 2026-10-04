package com.myscript.snt.dms;

import com.myscript.snt.core.PageKey;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface ISharePageManagerUIListener {
    void onPageShared(SharePageResult sharePageResult, SharePage sharePage);

    void onSharedPageError(SharePageListenerTask sharePageListenerTask, SharePageRequestResultCode sharePageRequestResultCode, PageKey pageKey);

    void onSharedPageInfosLoaded(SharePage sharePage);

    void onSharedPageInfosUpdated(SharePage sharePage);

    void onSharedPageSuccessful(SharePageListenerTask sharePageListenerTask, SharePage sharePage);

    void onSharedPagesLoaded(List<SharePage> list);

    void onSharedPagesSharedRemoved(SharePageRequestResultCode sharePageRequestResultCode, SharePage sharePage);

    void onSharedPagesStatusChanged(List<SharePage> list);

    void onSharedPagesUploadProgressed(SharePage sharePage);
}
