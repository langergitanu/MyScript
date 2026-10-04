package com.myscript.snt.dms;

import com.myscript.snt.core.PageKey;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class SharePage {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SharePage(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SharePage sharePage) {
        if (sharePage == null) {
            return 0L;
        }
        return sharePage.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_SharePage(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public SharePage(PageKey pageKey) {
        this(NeboDMSJNI.new_SharePage(PageKey.getCPtr(pageKey), pageKey), true);
    }

    public static SharePage createEmptySharePage(String str) {
        long jSharePage_createEmptySharePage = NeboDMSJNI.SharePage_createEmptySharePage(str.getBytes());
        if (jSharePage_createEmptySharePage == 0) {
            return null;
        }
        return new SharePage(jSharePage_createEmptySharePage, true);
    }

    public static SharePage createDeletedSharePage(String str) {
        long jSharePage_createDeletedSharePage = NeboDMSJNI.SharePage_createDeletedSharePage(str.getBytes());
        if (jSharePage_createDeletedSharePage == 0) {
            return null;
        }
        return new SharePage(jSharePage_createDeletedSharePage, true);
    }

    public static SharePage createRemoteSharePage(String str, String str2, long j, long j2, String str3, boolean z, SharePageOptions sharePageOptions, String str4) {
        long jSharePage_createRemoteSharePage = NeboDMSJNI.SharePage_createRemoteSharePage(str.getBytes(), str2.getBytes(), j, j2, str3.getBytes(), z, SharePageOptions.getCPtr(sharePageOptions), sharePageOptions, str4.getBytes());
        if (jSharePage_createRemoteSharePage == 0) {
            return null;
        }
        return new SharePage(jSharePage_createRemoteSharePage, true);
    }

    public PageKey pageKey() {
        return new PageKey(NeboDMSJNI.SharePage_pageKey(this.swigCPtr, this), true);
    }

    public String uuid() {
        return new String(NeboDMSJNI.SharePage_uuid(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String sharedLink() {
        return new String(NeboDMSJNI.SharePage_sharedLink(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setSharedLink(String str) {
        NeboDMSJNI.SharePage_setSharedLink(this.swigCPtr, this, str.getBytes());
    }

    public String title() {
        return new String(NeboDMSJNI.SharePage_title(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setTitle(String str) {
        NeboDMSJNI.SharePage_setTitle(this.swigCPtr, this, str.getBytes());
    }

    public String remoteStatus() {
        return new String(NeboDMSJNI.SharePage_remoteStatus(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setRemoteStatus(String str) {
        NeboDMSJNI.SharePage_setRemoteStatus(this.swigCPtr, this, str.getBytes());
    }

    public long lastModificationDate() {
        return NeboDMSJNI.SharePage_lastModificationDate(this.swigCPtr, this);
    }

    public void setLastModificationDate(long j) {
        NeboDMSJNI.SharePage_setLastModificationDate(this.swigCPtr, this, j);
    }

    public long remoteLastModificationDate() {
        return NeboDMSJNI.SharePage_remoteLastModificationDate(this.swigCPtr, this);
    }

    public void setRemoteLastModificationDate(long j) {
        NeboDMSJNI.SharePage_setRemoteLastModificationDate(this.swigCPtr, this, j);
    }

    public long metadataModificationDate() {
        return NeboDMSJNI.SharePage_metadataModificationDate(this.swigCPtr, this);
    }

    public void setMetadataModificationDate(long j) {
        NeboDMSJNI.SharePage_setMetadataModificationDate(this.swigCPtr, this, j);
    }

    public long remoteMetadataModificationDate() {
        return NeboDMSJNI.SharePage_remoteMetadataModificationDate(this.swigCPtr, this);
    }

    public void setRemoteMetadataModificationDate(long j) {
        NeboDMSJNI.SharePage_setRemoteMetadataModificationDate(this.swigCPtr, this, j);
    }

    public long creationDate() {
        return NeboDMSJNI.SharePage_creationDate(this.swigCPtr, this);
    }

    public void setCreationDate(long j) {
        NeboDMSJNI.SharePage_setCreationDate(this.swigCPtr, this, j);
    }

    public long remoteUploadedDate() {
        return NeboDMSJNI.SharePage_remoteUploadedDate(this.swigCPtr, this);
    }

    public void setRemoteUploadedDate(long j) {
        NeboDMSJNI.SharePage_setRemoteUploadedDate(this.swigCPtr, this, j);
    }

    public long localUploadedDate() {
        return NeboDMSJNI.SharePage_localUploadedDate(this.swigCPtr, this);
    }

    public void setLocalUploadedDate(long j) {
        NeboDMSJNI.SharePage_setLocalUploadedDate(this.swigCPtr, this, j);
    }

    public String signature() {
        return new String(NeboDMSJNI.SharePage_signature(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String remoteSignature() {
        return new String(NeboDMSJNI.SharePage_remoteSignature(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String setRemoteSignature(String str) {
        return new String(NeboDMSJNI.SharePage_setRemoteSignature(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    public String lastSignature() {
        return new String(NeboDMSJNI.SharePage_lastSignature(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String pageType() {
        return new String(NeboDMSJNI.SharePage_pageType(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setPageType(String str) {
        NeboDMSJNI.SharePage_setPageType(this.swigCPtr, this, str.getBytes());
    }

    public boolean isDeleted() {
        return NeboDMSJNI.SharePage_isDeleted(this.swigCPtr, this);
    }

    public void setIsDeleted(boolean z) {
        NeboDMSJNI.SharePage_setIsDeleted(this.swigCPtr, this, z);
    }

    public SharePageOptions options() {
        long jSharePage_options = NeboDMSJNI.SharePage_options(this.swigCPtr, this);
        if (jSharePage_options == 0) {
            return null;
        }
        return new SharePageOptions(jSharePage_options, true);
    }

    public void setOptions(SharePageOptions sharePageOptions) {
        NeboDMSJNI.SharePage_setOptions(this.swigCPtr, this, SharePageOptions.getCPtr(sharePageOptions), sharePageOptions);
    }

    public float uploadProgress() {
        return NeboDMSJNI.SharePage_uploadProgress(this.swigCPtr, this);
    }

    public void setUploadProgress(float f) {
        NeboDMSJNI.SharePage_setUploadProgress(this.swigCPtr, this, f);
    }

    public float pageFileSize() {
        return NeboDMSJNI.SharePage_pageFileSize(this.swigCPtr, this);
    }

    public void setPageFileSize(float f) {
        NeboDMSJNI.SharePage_setPageFileSize(this.swigCPtr, this, f);
    }

    public boolean isPageUpToDate() {
        return NeboDMSJNI.SharePage_isPageUpToDate(this.swigCPtr, this);
    }

    public boolean isTemporaryState() {
        return NeboDMSJNI.SharePage_isTemporaryState(this.swigCPtr, this);
    }

    public SharePageState state() {
        return SharePageState.swigToEnum(NeboDMSJNI.SharePage_state(this.swigCPtr, this));
    }

    public void setState(SharePageState sharePageState) {
        NeboDMSJNI.SharePage_setState(this.swigCPtr, this, sharePageState.swigValue());
    }

    public void markAsOutdated() {
        NeboDMSJNI.SharePage_markAsOutdated(this.swigCPtr, this);
    }

    public void resetPageKey(PageKey pageKey) {
        NeboDMSJNI.SharePage_resetPageKey(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public void mergeWithRemote(SharePage sharePage) {
        NeboDMSJNI.SharePage_mergeWithRemote(this.swigCPtr, this, getCPtr(sharePage), sharePage);
    }

    public boolean canBeMerged() {
        return NeboDMSJNI.SharePage_canBeMerged(this.swigCPtr, this);
    }

    public boolean updateFromPageInfo(Page page) {
        return NeboDMSJNI.SharePage_updateFromPageInfo(this.swigCPtr, this, Page.getCPtr(page), page);
    }

    public boolean updateAfterUpload(SharePageResult sharePageResult) {
        return NeboDMSJNI.SharePage_updateAfterUpload(this.swigCPtr, this, SharePageResult.getCPtr(sharePageResult), sharePageResult);
    }

    public SharePageState pageStateFromPageDates() {
        return SharePageState.swigToEnum(NeboDMSJNI.SharePage_pageStateFromPageDates(this.swigCPtr, this));
    }

    public boolean isPageInitialized() {
        return NeboDMSJNI.SharePage_isPageInitialized(this.swigCPtr, this);
    }

    public int compare(SharePage sharePage) {
        return NeboDMSJNI.SharePage_compare__SWIG_0(this.swigCPtr, this, getCPtr(sharePage), sharePage);
    }

    public int compare(long j) {
        return NeboDMSJNI.SharePage_compare__SWIG_1(this.swigCPtr, this, j);
    }

    public boolean equals(SharePage sharePage) {
        return NeboDMSJNI.SharePage_equals__SWIG_0(this.swigCPtr, this, getCPtr(sharePage), sharePage);
    }

    public boolean equals(PageKey pageKey) {
        return NeboDMSJNI.SharePage_equals__SWIG_1(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public static SharePage derivedRef(SharePage sharePage) {
        long jSharePage_derivedRef = NeboDMSJNI.SharePage_derivedRef(getCPtr(sharePage), sharePage);
        if (jSharePage_derivedRef == 0) {
            return null;
        }
        return new SharePage(jSharePage_derivedRef, true);
    }
}
