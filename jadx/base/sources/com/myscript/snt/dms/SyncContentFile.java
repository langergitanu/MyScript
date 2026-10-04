package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class SyncContentFile {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SyncContentFile(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SyncContentFile syncContentFile) {
        if (syncContentFile == null) {
            return 0L;
        }
        return syncContentFile.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_SyncContentFile(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setApplicable(boolean z) {
        NeboDMSJNI.SyncContentFile_applicable_set(this.swigCPtr, this, z);
    }

    public boolean getApplicable() {
        return NeboDMSJNI.SyncContentFile_applicable_get(this.swigCPtr, this);
    }

    public void setFilePath(String str) {
        NeboDMSJNI.SyncContentFile_filePath_set(this.swigCPtr, this, str.getBytes());
    }

    public String getFilePath() {
        return new String(NeboDMSJNI.SyncContentFile_filePath_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setSignature(String str) {
        NeboDMSJNI.SyncContentFile_signature_set(this.swigCPtr, this, str.getBytes());
    }

    public String getSignature() {
        return new String(NeboDMSJNI.SyncContentFile_signature_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setMakeCopy(boolean z) {
        NeboDMSJNI.SyncContentFile_makeCopy_set(this.swigCPtr, this, z);
    }

    public boolean getMakeCopy() {
        return NeboDMSJNI.SyncContentFile_makeCopy_get(this.swigCPtr, this);
    }

    public SyncContentFile() {
        this(NeboDMSJNI.new_SyncContentFile(), true);
    }
}
