package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public class DegradedCloudDriveWrapper {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public DegradedCloudDriveWrapper(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(DegradedCloudDriveWrapper degradedCloudDriveWrapper) {
        if (degradedCloudDriveWrapper == null) {
            return 0L;
        }
        return degradedCloudDriveWrapper.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_DegradedCloudDriveWrapper(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public DegradedCloudDriveWrapper(ICloudDriveInterface iCloudDriveInterface, int i, int i2) {
        this(NeboDMSJNI.new_DegradedCloudDriveWrapper__SWIG_0(iCloudDriveInterface, i, i2), true);
    }

    public DegradedCloudDriveWrapper(ICloudDriveInterface iCloudDriveInterface, int i) {
        this(NeboDMSJNI.new_DegradedCloudDriveWrapper__SWIG_1(iCloudDriveInterface, i), true);
    }

    public DegradedCloudDriveWrapper(ICloudDriveInterface iCloudDriveInterface) {
        this(NeboDMSJNI.new_DegradedCloudDriveWrapper__SWIG_2(iCloudDriveInterface), true);
    }

    public int getDegradedDownload() {
        return NeboDMSJNI.DegradedCloudDriveWrapper_getDegradedDownload(this.swigCPtr, this);
    }

    public void setDegradedDownload(int i) {
        NeboDMSJNI.DegradedCloudDriveWrapper_setDegradedDownload(this.swigCPtr, this, i);
    }

    public int getDegradedUpload() {
        return NeboDMSJNI.DegradedCloudDriveWrapper_getDegradedUpload(this.swigCPtr, this);
    }

    public void setDegradedUpload(int i) {
        NeboDMSJNI.DegradedCloudDriveWrapper_setDegradedUpload(this.swigCPtr, this, i);
    }
}
