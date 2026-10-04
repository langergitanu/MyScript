package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class NotebookInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public NotebookInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(NotebookInfo notebookInfo) {
        if (notebookInfo == null) {
            return 0L;
        }
        return notebookInfo.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_NotebookInfo(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setObject(SWIGTYPE_p_snt__dms__Object sWIGTYPE_p_snt__dms__Object) {
        NeboDMSJNI.NotebookInfo_object_set(this.swigCPtr, this, SWIGTYPE_p_snt__dms__Object.getCPtr(sWIGTYPE_p_snt__dms__Object));
    }

    public SWIGTYPE_p_snt__dms__Object getObject() {
        long jNotebookInfo_object_get = NeboDMSJNI.NotebookInfo_object_get(this.swigCPtr, this);
        if (jNotebookInfo_object_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_snt__dms__Object(jNotebookInfo_object_get, false);
    }

    public void setName(String str) {
        NeboDMSJNI.NotebookInfo_name_set(this.swigCPtr, this, str.getBytes());
    }

    public String getName() {
        return new String(NeboDMSJNI.NotebookInfo_name_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setCoverColor(long j) {
        NeboDMSJNI.NotebookInfo_coverColor_set(this.swigCPtr, this, j);
    }

    public long getCoverColor() {
        return NeboDMSJNI.NotebookInfo_coverColor_get(this.swigCPtr, this);
    }

    public void setLastOpenedPageId(String str) {
        NeboDMSJNI.NotebookInfo_lastOpenedPageId_set(this.swigCPtr, this, str.getBytes());
    }

    public String getLastOpenedPageId() {
        return new String(NeboDMSJNI.NotebookInfo_lastOpenedPageId_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setLastModificationDate(long j) {
        NeboDMSJNI.NotebookInfo_lastModificationDate_set(this.swigCPtr, this, j);
    }

    public long getLastModificationDate() {
        return NeboDMSJNI.NotebookInfo_lastModificationDate_get(this.swigCPtr, this);
    }

    public void setApp(String str) {
        NeboDMSJNI.NotebookInfo_app_set(this.swigCPtr, this, str.getBytes());
    }

    public String getApp() {
        return new String(NeboDMSJNI.NotebookInfo_app_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setOs(String str) {
        NeboDMSJNI.NotebookInfo_os_set(this.swigCPtr, this, str.getBytes());
    }

    public String getOs() {
        return new String(NeboDMSJNI.NotebookInfo_os_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setAppVersion(String str) {
        NeboDMSJNI.NotebookInfo_appVersion_set(this.swigCPtr, this, str.getBytes());
    }

    public String getAppVersion() {
        return new String(NeboDMSJNI.NotebookInfo_appVersion_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setDocVersion(String str) {
        NeboDMSJNI.NotebookInfo_docVersion_set(this.swigCPtr, this, str.getBytes());
    }

    public String getDocVersion() {
        return new String(NeboDMSJNI.NotebookInfo_docVersion_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setWelcomeVersion(String str) {
        NeboDMSJNI.NotebookInfo_welcomeVersion_set(this.swigCPtr, this, str.getBytes());
    }

    public String getWelcomeVersion() {
        return new String(NeboDMSJNI.NotebookInfo_welcomeVersion_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setCorrupted(String str) {
        NeboDMSJNI.NotebookInfo_corrupted_set(this.swigCPtr, this, str.getBytes());
    }

    public String getCorrupted() {
        return new String(NeboDMSJNI.NotebookInfo_corrupted_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setTrashState(TrashState trashState) {
        NeboDMSJNI.NotebookInfo_trashState_set(this.swigCPtr, this, trashState.swigValue());
    }

    public TrashState getTrashState() {
        return TrashState.swigToEnum(NeboDMSJNI.NotebookInfo_trashState_get(this.swigCPtr, this));
    }

    public NotebookInfo() {
        this(NeboDMSJNI.new_NotebookInfo(), true);
    }

    public boolean valid() {
        return NeboDMSJNI.NotebookInfo_valid(this.swigCPtr, this);
    }
}
