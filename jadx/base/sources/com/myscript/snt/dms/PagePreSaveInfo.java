package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class PagePreSaveInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public PagePreSaveInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(PagePreSaveInfo pagePreSaveInfo) {
        if (pagePreSaveInfo == null) {
            return 0L;
        }
        return pagePreSaveInfo.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_PagePreSaveInfo(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setPage(SWIGTYPE_p_snt__dms__Object sWIGTYPE_p_snt__dms__Object) {
        NeboDMSJNI.PagePreSaveInfo_page_set(this.swigCPtr, this, SWIGTYPE_p_snt__dms__Object.getCPtr(sWIGTYPE_p_snt__dms__Object));
    }

    public SWIGTYPE_p_snt__dms__Object getPage() {
        long jPagePreSaveInfo_page_get = NeboDMSJNI.PagePreSaveInfo_page_get(this.swigCPtr, this);
        if (jPagePreSaveInfo_page_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_snt__dms__Object(jPagePreSaveInfo_page_get, false);
    }

    public void setTimestamp(long j) {
        NeboDMSJNI.PagePreSaveInfo_timestamp_set(this.swigCPtr, this, j);
    }

    public long getTimestamp() {
        return NeboDMSJNI.PagePreSaveInfo_timestamp_get(this.swigCPtr, this);
    }

    public void setAutomaticTitle(String str) {
        NeboDMSJNI.PagePreSaveInfo_automaticTitle_set(this.swigCPtr, this, str.getBytes());
    }

    public String getAutomaticTitle() {
        return new String(NeboDMSJNI.PagePreSaveInfo_automaticTitle_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setScrollPosition(String str) {
        NeboDMSJNI.PagePreSaveInfo_scrollPosition_set(this.swigCPtr, this, str.getBytes());
    }

    public String getScrollPosition() {
        return new String(NeboDMSJNI.PagePreSaveInfo_scrollPosition_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setIsDeleted(boolean z) {
        NeboDMSJNI.PagePreSaveInfo_isDeleted_set(this.swigCPtr, this, z);
    }

    public boolean getIsDeleted() {
        return NeboDMSJNI.PagePreSaveInfo_isDeleted_get(this.swigCPtr, this);
    }

    public void setIsModified(boolean z) {
        NeboDMSJNI.PagePreSaveInfo_isModified_set(this.swigCPtr, this, z);
    }

    public boolean getIsModified() {
        return NeboDMSJNI.PagePreSaveInfo_isModified_get(this.swigCPtr, this);
    }

    public void setHasContent(boolean z) {
        NeboDMSJNI.PagePreSaveInfo_hasContent_set(this.swigCPtr, this, z);
    }

    public boolean getHasContent() {
        return NeboDMSJNI.PagePreSaveInfo_hasContent_get(this.swigCPtr, this);
    }

    public void setAutomaticTitleChanged(boolean z) {
        NeboDMSJNI.PagePreSaveInfo_automaticTitleChanged_set(this.swigCPtr, this, z);
    }

    public boolean getAutomaticTitleChanged() {
        return NeboDMSJNI.PagePreSaveInfo_automaticTitleChanged_get(this.swigCPtr, this);
    }

    public void setScrollPositionChanged(boolean z) {
        NeboDMSJNI.PagePreSaveInfo_scrollPositionChanged_set(this.swigCPtr, this, z);
    }

    public boolean getScrollPositionChanged() {
        return NeboDMSJNI.PagePreSaveInfo_scrollPositionChanged_get(this.swigCPtr, this);
    }

    public void setNeedThumbnailUpdate(boolean z) {
        NeboDMSJNI.PagePreSaveInfo_needThumbnailUpdate_set(this.swigCPtr, this, z);
    }

    public boolean getNeedThumbnailUpdate() {
        return NeboDMSJNI.PagePreSaveInfo_needThumbnailUpdate_get(this.swigCPtr, this);
    }

    public PagePreSaveInfo() {
        this(NeboDMSJNI.new_PagePreSaveInfo(), true);
    }
}
