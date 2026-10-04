package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class BackupMetadata {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public BackupMetadata(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(BackupMetadata backupMetadata) {
        if (backupMetadata == null) {
            return 0L;
        }
        return backupMetadata.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_BackupMetadata(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setBackupVersion(long j) {
        NeboDMSJNI.BackupMetadata_backupVersion_set(this.swigCPtr, this, j);
    }

    public long getBackupVersion() {
        return NeboDMSJNI.BackupMetadata_backupVersion_get(this.swigCPtr, this);
    }

    public void setApplicationVersion(String str) {
        NeboDMSJNI.BackupMetadata_applicationVersion_set(this.swigCPtr, this, str.getBytes());
    }

    public String getApplicationVersion() {
        return new String(NeboDMSJNI.BackupMetadata_applicationVersion_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setTimestamp(long j) {
        NeboDMSJNI.BackupMetadata_timestamp_set(this.swigCPtr, this, j);
    }

    public long getTimestamp() {
        return NeboDMSJNI.BackupMetadata_timestamp_get(this.swigCPtr, this);
    }

    public void setUncompressedSize(long j) {
        NeboDMSJNI.BackupMetadata_uncompressedSize_set(this.swigCPtr, this, j);
    }

    public long getUncompressedSize() {
        return NeboDMSJNI.BackupMetadata_uncompressedSize_get(this.swigCPtr, this);
    }

    public void setOsNameAndVersion(String str) {
        NeboDMSJNI.BackupMetadata_osNameAndVersion_set(this.swigCPtr, this, str.getBytes());
    }

    public String getOsNameAndVersion() {
        return new String(NeboDMSJNI.BackupMetadata_osNameAndVersion_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public boolean isValid() {
        return NeboDMSJNI.BackupMetadata_isValid(this.swigCPtr, this);
    }

    public BackupMetadata() {
        this(NeboDMSJNI.new_BackupMetadata(), true);
    }
}
