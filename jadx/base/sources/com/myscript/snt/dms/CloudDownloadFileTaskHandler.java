package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public class CloudDownloadFileTaskHandler {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public CloudDownloadFileTaskHandler(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CloudDownloadFileTaskHandler cloudDownloadFileTaskHandler) {
        if (cloudDownloadFileTaskHandler == null) {
            return 0L;
        }
        return cloudDownloadFileTaskHandler.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_CloudDownloadFileTaskHandler(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public CloudDownloadFileTaskHandler(SWIGTYPE_p_std__functionT_void_fint_constF_t sWIGTYPE_p_std__functionT_void_fint_constF_t) {
        this(NeboDMSJNI.new_CloudDownloadFileTaskHandler(SWIGTYPE_p_std__functionT_void_fint_constF_t.getCPtr(sWIGTYPE_p_std__functionT_void_fint_constF_t)), true);
    }

    public void downloaded(long j) {
        NeboDMSJNI.CloudDownloadFileTaskHandler_downloaded(this.swigCPtr, this, j);
    }
}
