package com.myscript.snt.dms;

import com.myscript.snt.core.PageKey;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class SharePageManager {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SharePageManager(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SharePageManager sharePageManager) {
        if (sharePageManager == null) {
            return 0L;
        }
        return sharePageManager.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_SharePageManager(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static SharePageManager create(DMS dms, String str, String str2) {
        long jSharePageManager_create = NeboDMSJNI.SharePageManager_create(DMS.getCPtr(dms), dms, str.getBytes(), str2.getBytes());
        if (jSharePageManager_create == 0) {
            return null;
        }
        return new SharePageManager(jSharePageManager_create, true);
    }

    public void destroy() {
        NeboDMSJNI.SharePageManager_destroy(this.swigCPtr, this);
    }

    public void setRequester(ISharePageManagerRequester iSharePageManagerRequester) {
        NeboDMSJNI.SharePageManager_setRequester(this.swigCPtr, this, iSharePageManagerRequester);
    }

    public void setUIListener(ISharePageManagerUIListener iSharePageManagerUIListener) {
        NeboDMSJNI.SharePageManager_setUIListener(this.swigCPtr, this, iSharePageManagerUIListener);
    }

    public void sharePage(PageKey pageKey) {
        NeboDMSJNI.SharePageManager_sharePage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public void sharePageDone(PageKey pageKey, SharePageResult sharePageResult) {
        NeboDMSJNI.SharePageManager_sharePageDone(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, SharePageResult.getCPtr(sharePageResult), sharePageResult);
    }

    public void listSharedPages() {
        NeboDMSJNI.SharePageManager_listSharedPages(this.swigCPtr, this);
    }

    public void fetchSharedPageInfos(PageKey pageKey) {
        NeboDMSJNI.SharePageManager_fetchSharedPageInfos(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public void addUsers(PageKey pageKey, List<SharePageUser> list, String str) {
        SWIGVectorSharePageUser sWIGVectorSharePageUser = new SWIGVectorSharePageUser(list);
        NeboDMSJNI.SharePageManager_addUsers(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, SWIGVectorSharePageUser.getCPtr(sWIGVectorSharePageUser), sWIGVectorSharePageUser, str.getBytes());
    }

    public void removeUser(PageKey pageKey, String str) {
        NeboDMSJNI.SharePageManager_removeUser(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, str.getBytes());
    }

    public void updateUser(PageKey pageKey, SharePageUser sharePageUser) {
        NeboDMSJNI.SharePageManager_updateUser(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, SharePageUser.getCPtr(sharePageUser), sharePageUser);
    }

    public void changeVisibility(PageKey pageKey, SharePageVisibility sharePageVisibility) {
        NeboDMSJNI.SharePageManager_changeVisibility(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, sharePageVisibility.swigValue());
    }

    public void disableSharePage(PageKey pageKey) {
        NeboDMSJNI.SharePageManager_disableSharePage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public void removeSharePage(PageKey pageKey) {
        NeboDMSJNI.SharePageManager_removeSharePage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public List<SharePage> sharedPages() {
        return new SWIGVectorSharePage(NeboDMSJNI.SharePageManager_sharedPages(this.swigCPtr, this), true);
    }

    public SharePage sharedPage(PageKey pageKey) {
        long jSharePageManager_sharedPage = NeboDMSJNI.SharePageManager_sharedPage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
        if (jSharePageManager_sharedPage == 0) {
            return null;
        }
        return new SharePage(jSharePageManager_sharedPage, true);
    }

    public boolean changeSharePageState(PageKey pageKey, SharePageState sharePageState) {
        return NeboDMSJNI.SharePageManager_changeSharePageState(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, sharePageState.swigValue());
    }

    public boolean changeSharePageUploadProgress(PageKey pageKey, float f, float f2) {
        return NeboDMSJNI.SharePageManager_changeSharePageUploadProgress(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, f, f2);
    }

    public void startListPagesTimer() {
        NeboDMSJNI.SharePageManager_startListPagesTimer(this.swigCPtr, this);
    }

    public void stopListPagesTimer() {
        NeboDMSJNI.SharePageManager_stopListPagesTimer(this.swigCPtr, this);
    }

    public void setListPagesTimerInterval(long j) {
        NeboDMSJNI.SharePageManager_setListPagesTimerInterval(this.swigCPtr, this, j);
    }
}
