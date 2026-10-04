package com.myscript.snt.dms;

import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.SWIGVectorNotebookKey;
import com.myscript.snt.core.SWIGVectorPageKey;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class SharePageManagerTaskParam {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SharePageManagerTaskParam(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SharePageManagerTaskParam sharePageManagerTaskParam) {
        if (sharePageManagerTaskParam == null) {
            return 0L;
        }
        return sharePageManagerTaskParam.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_SharePageManagerTaskParam(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setSharePageRequest(SharePageRequest sharePageRequest) {
        NeboDMSJNI.SharePageManagerTaskParam_sharePageRequest_set(this.swigCPtr, this, SharePageRequest.getCPtr(sharePageRequest), sharePageRequest);
    }

    public SharePageRequest getSharePageRequest() {
        long jSharePageManagerTaskParam_sharePageRequest_get = NeboDMSJNI.SharePageManagerTaskParam_sharePageRequest_get(this.swigCPtr, this);
        if (jSharePageManagerTaskParam_sharePageRequest_get == 0) {
            return null;
        }
        return new SharePageRequest(jSharePageManagerTaskParam_sharePageRequest_get, true);
    }

    public void setResult(SharePageResult sharePageResult) {
        NeboDMSJNI.SharePageManagerTaskParam_result_set(this.swigCPtr, this, SharePageResult.getCPtr(sharePageResult), sharePageResult);
    }

    public SharePageResult getResult() {
        long jSharePageManagerTaskParam_result_get = NeboDMSJNI.SharePageManagerTaskParam_result_get(this.swigCPtr, this);
        if (jSharePageManagerTaskParam_result_get == 0) {
            return null;
        }
        return new SharePageResult(jSharePageManagerTaskParam_result_get, false);
    }

    public void setDocumentPath(String str) {
        NeboDMSJNI.SharePageManagerTaskParam_documentPath_set(this.swigCPtr, this, str.getBytes());
    }

    public String getDocumentPath() {
        return new String(NeboDMSJNI.SharePageManagerTaskParam_documentPath_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setVisibility(SharePageVisibility sharePageVisibility) {
        NeboDMSJNI.SharePageManagerTaskParam_visibility_set(this.swigCPtr, this, sharePageVisibility.swigValue());
    }

    public SharePageVisibility getVisibility() {
        return SharePageVisibility.swigToEnum(NeboDMSJNI.SharePageManagerTaskParam_visibility_get(this.swigCPtr, this));
    }

    public void setUsers(SWIGVectorSharePageUser sWIGVectorSharePageUser) {
        SWIGVectorSharePageUser sWIGVectorSharePageUser2 = new SWIGVectorSharePageUser(sWIGVectorSharePageUser);
        NeboDMSJNI.SharePageManagerTaskParam_users_set(this.swigCPtr, this, SWIGVectorSharePageUser.getCPtr(sWIGVectorSharePageUser2), sWIGVectorSharePageUser2);
    }

    public SWIGVectorSharePageUser getUsers() {
        long jSharePageManagerTaskParam_users_get = NeboDMSJNI.SharePageManagerTaskParam_users_get(this.swigCPtr, this);
        if (jSharePageManagerTaskParam_users_get == 0) {
            return null;
        }
        return new SWIGVectorSharePageUser(jSharePageManagerTaskParam_users_get, false);
    }

    public void setUserEmail(String str) {
        NeboDMSJNI.SharePageManagerTaskParam_userEmail_set(this.swigCPtr, this, str.getBytes());
    }

    public String getUserEmail() {
        return new String(NeboDMSJNI.SharePageManagerTaskParam_userEmail_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setMessage(String str) {
        NeboDMSJNI.SharePageManagerTaskParam_message_set(this.swigCPtr, this, str.getBytes());
    }

    public String getMessage() {
        return new String(NeboDMSJNI.SharePageManagerTaskParam_message_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setNotebookKeys(SWIGVectorNotebookKey sWIGVectorNotebookKey) {
        SWIGVectorNotebookKey sWIGVectorNotebookKey2 = new SWIGVectorNotebookKey(sWIGVectorNotebookKey);
        NeboDMSJNI.SharePageManagerTaskParam_notebookKeys_set(this.swigCPtr, this, SWIGVectorNotebookKey.getCPtr(sWIGVectorNotebookKey2), sWIGVectorNotebookKey2);
    }

    public SWIGVectorNotebookKey getNotebookKeys() {
        long jSharePageManagerTaskParam_notebookKeys_get = NeboDMSJNI.SharePageManagerTaskParam_notebookKeys_get(this.swigCPtr, this);
        if (jSharePageManagerTaskParam_notebookKeys_get == 0) {
            return null;
        }
        return new SWIGVectorNotebookKey(jSharePageManagerTaskParam_notebookKeys_get, false);
    }

    public void setPageKeys(SWIGVectorPageKey sWIGVectorPageKey) {
        SWIGVectorPageKey sWIGVectorPageKey2 = new SWIGVectorPageKey(sWIGVectorPageKey);
        NeboDMSJNI.SharePageManagerTaskParam_pageKeys_set(this.swigCPtr, this, SWIGVectorPageKey.getCPtr(sWIGVectorPageKey2), sWIGVectorPageKey2);
    }

    public SWIGVectorPageKey getPageKeys() {
        long jSharePageManagerTaskParam_pageKeys_get = NeboDMSJNI.SharePageManagerTaskParam_pageKeys_get(this.swigCPtr, this);
        if (jSharePageManagerTaskParam_pageKeys_get == 0) {
            return null;
        }
        return new SWIGVectorPageKey(jSharePageManagerTaskParam_pageKeys_get, false);
    }

    public void setNewPageKey(PageKey pageKey) {
        NeboDMSJNI.SharePageManagerTaskParam_newPageKey_set(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public PageKey getNewPageKey() {
        long jSharePageManagerTaskParam_newPageKey_get = NeboDMSJNI.SharePageManagerTaskParam_newPageKey_get(this.swigCPtr, this);
        if (jSharePageManagerTaskParam_newPageKey_get == 0) {
            return null;
        }
        return new PageKey(jSharePageManagerTaskParam_newPageKey_get, false);
    }

    public SharePageManagerTaskParam() {
        this(NeboDMSJNI.new_SharePageManagerTaskParam(), true);
    }
}
