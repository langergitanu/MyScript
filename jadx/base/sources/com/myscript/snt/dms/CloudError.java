package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public class CloudError extends RuntimeException {
    private static final long serialVersionUID = -687991492884005033L;
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public CloudError(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CloudError cloudError) {
        if (cloudError == null) {
            return 0L;
        }
        return cloudError.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_CloudError(j);
            }
            this.swigCPtr = 0L;
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getClass().getName() + ": [" + getErrorId() + "] " + getMessage();
    }

    public CloudError(CloudErrorType cloudErrorType, String str, boolean z) {
        this(NeboDMSJNI.new_CloudError__SWIG_0(cloudErrorType.swigValue(), str.getBytes(), z), true);
    }

    public CloudError(CloudErrorType cloudErrorType, String str) {
        this(NeboDMSJNI.new_CloudError__SWIG_1(cloudErrorType.swigValue(), str.getBytes()), true);
    }

    public CloudError(CloudErrorType cloudErrorType) {
        this(NeboDMSJNI.new_CloudError__SWIG_2(cloudErrorType.swigValue()), true);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return NeboDMSJNI.CloudError_getMessage(this.swigCPtr, this);
    }

    public CloudErrorType getErrorId() {
        return CloudErrorType.swigToEnum(NeboDMSJNI.CloudError_getErrorId(this.swigCPtr, this));
    }

    public boolean handled() {
        return NeboDMSJNI.CloudError_handled(this.swigCPtr, this);
    }
}
