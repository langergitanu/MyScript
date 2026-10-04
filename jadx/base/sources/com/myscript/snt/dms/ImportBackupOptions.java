package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public class ImportBackupOptions {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ImportBackupOptions(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ImportBackupOptions importBackupOptions) {
        if (importBackupOptions == null) {
            return 0L;
        }
        return importBackupOptions.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_ImportBackupOptions(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setDeleteCloudOnlyObjects(boolean z) {
        NeboDMSJNI.ImportBackupOptions_deleteCloudOnlyObjects_set(this.swigCPtr, this, z);
    }

    public boolean getDeleteCloudOnlyObjects() {
        return NeboDMSJNI.ImportBackupOptions_deleteCloudOnlyObjects_get(this.swigCPtr, this);
    }

    public ImportBackupOptions() {
        this(NeboDMSJNI.new_ImportBackupOptions(), true);
    }
}
