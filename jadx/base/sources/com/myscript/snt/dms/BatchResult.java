package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class BatchResult {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public BatchResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(BatchResult batchResult) {
        if (batchResult == null) {
            return 0L;
        }
        return batchResult.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_BatchResult(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public BatchResult() {
        this(NeboDMSJNI.new_BatchResult(), true);
    }

    public int size() {
        return NeboDMSJNI.BatchResult_size(this.swigCPtr, this);
    }

    public boolean hasKey(long j) {
        return NeboDMSJNI.BatchResult_hasKey(this.swigCPtr, this, j);
    }

    public boolean hasString(long j) {
        return NeboDMSJNI.BatchResult_hasString(this.swigCPtr, this, j);
    }

    public boolean hasCloudFileIdRev(long j) {
        return NeboDMSJNI.BatchResult_hasCloudFileIdRev(this.swigCPtr, this, j);
    }

    public boolean hasError(long j) {
        return NeboDMSJNI.BatchResult_hasError(this.swigCPtr, this, j);
    }

    public void put(long j, String str) {
        NeboDMSJNI.BatchResult_put__SWIG_0(this.swigCPtr, this, j, str.getBytes());
    }

    public void put(long j, CloudFileIdRev cloudFileIdRev) {
        NeboDMSJNI.BatchResult_put__SWIG_1(this.swigCPtr, this, j, CloudFileIdRev.getCPtr(cloudFileIdRev), cloudFileIdRev);
    }

    public void put(long j, CloudError cloudError) {
        NeboDMSJNI.BatchResult_put__SWIG_2(this.swigCPtr, this, j, CloudError.getCPtr(cloudError), cloudError);
    }

    public String string(long j) {
        return new String(NeboDMSJNI.BatchResult_string(this.swigCPtr, this, j), StandardCharsets.UTF_8);
    }

    public SWIGTYPE_p_CloudFileIdRev cloudFileIdRev(long j) {
        return new SWIGTYPE_p_CloudFileIdRev(NeboDMSJNI.BatchResult_cloudFileIdRev(this.swigCPtr, this, j), true);
    }

    public CloudError error(long j) {
        return new CloudError(NeboDMSJNI.BatchResult_error(this.swigCPtr, this, j), true);
    }
}
