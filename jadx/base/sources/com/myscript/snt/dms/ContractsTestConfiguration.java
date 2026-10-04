package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class ContractsTestConfiguration {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ContractsTestConfiguration(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ContractsTestConfiguration contractsTestConfiguration) {
        if (contractsTestConfiguration == null) {
            return 0L;
        }
        return contractsTestConfiguration.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_ContractsTestConfiguration(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setTempDir(String str) {
        NeboDMSJNI.ContractsTestConfiguration_tempDir_set(this.swigCPtr, this, str.getBytes());
    }

    public String getTempDir() {
        return new String(NeboDMSJNI.ContractsTestConfiguration_tempDir_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setExistingFilePath(String str) {
        NeboDMSJNI.ContractsTestConfiguration_existingFilePath_set(this.swigCPtr, this, str.getBytes());
    }

    public String getExistingFilePath() {
        return new String(NeboDMSJNI.ContractsTestConfiguration_existingFilePath_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setFilter(String str) {
        NeboDMSJNI.ContractsTestConfiguration_filter_set(this.swigCPtr, this, str.getBytes());
    }

    public String getFilter() {
        return new String(NeboDMSJNI.ContractsTestConfiguration_filter_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setBatchUploadThreshold(int i) {
        NeboDMSJNI.ContractsTestConfiguration_batchUploadThreshold_set(this.swigCPtr, this, i);
    }

    public int getBatchUploadThreshold() {
        return NeboDMSJNI.ContractsTestConfiguration_batchUploadThreshold_get(this.swigCPtr, this);
    }

    public ContractsTestConfiguration(String str, String str2, int i) {
        this(NeboDMSJNI.new_ContractsTestConfiguration__SWIG_0(str.getBytes(), str2.getBytes(), i), true);
    }

    public ContractsTestConfiguration(String str, String str2) {
        this(NeboDMSJNI.new_ContractsTestConfiguration__SWIG_1(str.getBytes(), str2.getBytes()), true);
    }
}
