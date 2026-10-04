package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public class CancelableCloudTaskProgressHandler {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public CancelableCloudTaskProgressHandler(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler) {
        if (cancelableCloudTaskProgressHandler == null) {
            return 0L;
        }
        return cancelableCloudTaskProgressHandler.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_CancelableCloudTaskProgressHandler(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public CancelableCloudTaskProgressHandler(SWIGTYPE_p_std__functionT_bool_fint_bool_int_intF_t sWIGTYPE_p_std__functionT_bool_fint_bool_int_intF_t) {
        this(NeboDMSJNI.new_CancelableCloudTaskProgressHandler(SWIGTYPE_p_std__functionT_bool_fint_bool_int_intF_t.getCPtr(sWIGTYPE_p_std__functionT_bool_fint_bool_int_intF_t)), true);
    }

    public boolean progress(long j, boolean z, long j2, long j3) {
        return NeboDMSJNI.CancelableCloudTaskProgressHandler_progress(this.swigCPtr, this, j, z, j2, j3);
    }
}
