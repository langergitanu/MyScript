package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class NeboBackupController {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public NeboBackupController(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(NeboBackupController neboBackupController) {
        if (neboBackupController == null) {
            return 0L;
        }
        return neboBackupController.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_NeboBackupController(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static String getMETADATA_FILE_NAME() {
        return new String(NeboDMSJNI.NeboBackupController_METADATA_FILE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static long getCURRENT_BACKUP_VERSION() {
        return NeboDMSJNI.NeboBackupController_CURRENT_BACKUP_VERSION_get();
    }

    public NeboBackupController(DMS dms) {
        this(NeboDMSJNI.new_NeboBackupController(DMS.getCPtr(dms), dms), true);
    }

    public BackupMetadata metadata(String str) {
        return new BackupMetadata(NeboDMSJNI.NeboBackupController_metadata(this.swigCPtr, this, str.getBytes()), true);
    }

    public boolean restore(String str, IDMSMigrationToV2LogListener iDMSMigrationToV2LogListener) {
        return NeboDMSJNI.NeboBackupController_restore__SWIG_0(this.swigCPtr, this, str.getBytes(), iDMSMigrationToV2LogListener);
    }

    public boolean restore(String str) {
        return NeboDMSJNI.NeboBackupController_restore__SWIG_1(this.swigCPtr, this, str.getBytes());
    }

    public String backup(String str, String str2, String str3, boolean z) {
        return new String(NeboDMSJNI.NeboBackupController_backup__SWIG_0(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes(), z), StandardCharsets.UTF_8);
    }

    public String backup(String str, String str2, String str3) {
        return new String(NeboDMSJNI.NeboBackupController_backup__SWIG_1(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes()), StandardCharsets.UTF_8);
    }

    public void cancel() {
        NeboDMSJNI.NeboBackupController_cancel(this.swigCPtr, this);
    }

    public void setProgressionListener(INeboBackupProgressionListener iNeboBackupProgressionListener) {
        NeboDMSJNI.NeboBackupController_setProgressionListener(this.swigCPtr, this, iNeboBackupProgressionListener);
    }

    public void setZipArchiver(IZipArchiver iZipArchiver) {
        NeboDMSJNI.NeboBackupController_setZipArchiver(this.swigCPtr, this, iZipArchiver);
    }

    public static String neboBackupFileName(String str) {
        return new String(NeboDMSJNI.NeboBackupController_neboBackupFileName(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static String archiveExtension() {
        return new String(NeboDMSJNI.NeboBackupController_archiveExtension(), StandardCharsets.UTF_8);
    }

    public static boolean saveMetadata(BackupMetadata backupMetadata, String str) {
        return NeboDMSJNI.NeboBackupController_saveMetadata(BackupMetadata.getCPtr(backupMetadata), backupMetadata, str.getBytes());
    }
}
