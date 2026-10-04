package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class MonkeyTestConfiguration {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MonkeyTestConfiguration(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(MonkeyTestConfiguration monkeyTestConfiguration) {
        if (monkeyTestConfiguration == null) {
            return 0L;
        }
        return monkeyTestConfiguration.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_MonkeyTestConfiguration(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setWorkingDir(String str) {
        NeboDMSJNI.MonkeyTestConfiguration_workingDir_set(this.swigCPtr, this, str.getBytes());
    }

    public String getWorkingDir() {
        return new String(NeboDMSJNI.MonkeyTestConfiguration_workingDir_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setTempDir(String str) {
        NeboDMSJNI.MonkeyTestConfiguration_tempDir_set(this.swigCPtr, this, str.getBytes());
    }

    public String getTempDir() {
        return new String(NeboDMSJNI.MonkeyTestConfiguration_tempDir_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setRecoAssetsDir(String str) {
        NeboDMSJNI.MonkeyTestConfiguration_recoAssetsDir_set(this.swigCPtr, this, str.getBytes());
    }

    public String getRecoAssetsDir() {
        return new String(NeboDMSJNI.MonkeyTestConfiguration_recoAssetsDir_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setImagePathPattern(String str) {
        NeboDMSJNI.MonkeyTestConfiguration_imagePathPattern_set(this.swigCPtr, this, str.getBytes());
    }

    public String getImagePathPattern() {
        return new String(NeboDMSJNI.MonkeyTestConfiguration_imagePathPattern_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setImageNumMin(int i) {
        NeboDMSJNI.MonkeyTestConfiguration_imageNumMin_set(this.swigCPtr, this, i);
    }

    public int getImageNumMin() {
        return NeboDMSJNI.MonkeyTestConfiguration_imageNumMin_get(this.swigCPtr, this);
    }

    public void setImageNumMax(int i) {
        NeboDMSJNI.MonkeyTestConfiguration_imageNumMax_set(this.swigCPtr, this, i);
    }

    public int getImageNumMax() {
        return NeboDMSJNI.MonkeyTestConfiguration_imageNumMax_get(this.swigCPtr, this);
    }

    public void setSeed(long j) {
        NeboDMSJNI.MonkeyTestConfiguration_seed_set(this.swigCPtr, this, j);
    }

    public long getSeed() {
        return NeboDMSJNI.MonkeyTestConfiguration_seed_get(this.swigCPtr, this);
    }

    public void setVerbose(boolean z) {
        NeboDMSJNI.MonkeyTestConfiguration_verbose_set(this.swigCPtr, this, z);
    }

    public boolean getVerbose() {
        return NeboDMSJNI.MonkeyTestConfiguration_verbose_get(this.swigCPtr, this);
    }

    public void setOperationCount(long j) {
        NeboDMSJNI.MonkeyTestConfiguration_operationCount_set(this.swigCPtr, this, j);
    }

    public long getOperationCount() {
        return NeboDMSJNI.MonkeyTestConfiguration_operationCount_get(this.swigCPtr, this);
    }

    public void setUseDeterministicsUuid(boolean z) {
        NeboDMSJNI.MonkeyTestConfiguration_useDeterministicsUuid_set(this.swigCPtr, this, z);
    }

    public boolean getUseDeterministicsUuid() {
        return NeboDMSJNI.MonkeyTestConfiguration_useDeterministicsUuid_get(this.swigCPtr, this);
    }

    public void setForceInitializeV2(boolean z) {
        NeboDMSJNI.MonkeyTestConfiguration_forceInitializeV2_set(this.swigCPtr, this, z);
    }

    public boolean getForceInitializeV2() {
        return NeboDMSJNI.MonkeyTestConfiguration_forceInitializeV2_get(this.swigCPtr, this);
    }

    public void setWithV1Data(boolean z) {
        NeboDMSJNI.MonkeyTestConfiguration_withV1Data_set(this.swigCPtr, this, z);
    }

    public boolean getWithV1Data() {
        return NeboDMSJNI.MonkeyTestConfiguration_withV1Data_get(this.swigCPtr, this);
    }

    public void setWithPageContainer(boolean z) {
        NeboDMSJNI.MonkeyTestConfiguration_withPageContainer_set(this.swigCPtr, this, z);
    }

    public boolean getWithPageContainer() {
        return NeboDMSJNI.MonkeyTestConfiguration_withPageContainer_get(this.swigCPtr, this);
    }

    public void setOnlyFirstDeviceUseV1Data(boolean z) {
        NeboDMSJNI.MonkeyTestConfiguration_onlyFirstDeviceUseV1Data_set(this.swigCPtr, this, z);
    }

    public boolean getOnlyFirstDeviceUseV1Data() {
        return NeboDMSJNI.MonkeyTestConfiguration_onlyFirstDeviceUseV1Data_get(this.swigCPtr, this);
    }

    public void setAssertOrExitOnComplete(boolean z) {
        NeboDMSJNI.MonkeyTestConfiguration_assertOrExitOnComplete_set(this.swigCPtr, this, z);
    }

    public boolean getAssertOrExitOnComplete() {
        return NeboDMSJNI.MonkeyTestConfiguration_assertOrExitOnComplete_get(this.swigCPtr, this);
    }

    public void setV1CollectionMin(long j) {
        NeboDMSJNI.MonkeyTestConfiguration_v1CollectionMin_set(this.swigCPtr, this, j);
    }

    public long getV1CollectionMin() {
        return NeboDMSJNI.MonkeyTestConfiguration_v1CollectionMin_get(this.swigCPtr, this);
    }

    public void setV1CollectionMax(long j) {
        NeboDMSJNI.MonkeyTestConfiguration_v1CollectionMax_set(this.swigCPtr, this, j);
    }

    public long getV1CollectionMax() {
        return NeboDMSJNI.MonkeyTestConfiguration_v1CollectionMax_get(this.swigCPtr, this);
    }

    public void setV1NotebookMin(long j) {
        NeboDMSJNI.MonkeyTestConfiguration_v1NotebookMin_set(this.swigCPtr, this, j);
    }

    public long getV1NotebookMin() {
        return NeboDMSJNI.MonkeyTestConfiguration_v1NotebookMin_get(this.swigCPtr, this);
    }

    public void setV1NotebookMax(long j) {
        NeboDMSJNI.MonkeyTestConfiguration_v1NotebookMax_set(this.swigCPtr, this, j);
    }

    public long getV1NotebookMax() {
        return NeboDMSJNI.MonkeyTestConfiguration_v1NotebookMax_get(this.swigCPtr, this);
    }

    public void setV1PageMin(long j) {
        NeboDMSJNI.MonkeyTestConfiguration_v1PageMin_set(this.swigCPtr, this, j);
    }

    public long getV1PageMin() {
        return NeboDMSJNI.MonkeyTestConfiguration_v1PageMin_get(this.swigCPtr, this);
    }

    public void setV1PageMax(long j) {
        NeboDMSJNI.MonkeyTestConfiguration_v1PageMax_set(this.swigCPtr, this, j);
    }

    public long getV1PageMax() {
        return NeboDMSJNI.MonkeyTestConfiguration_v1PageMax_get(this.swigCPtr, this);
    }

    public void setEnableTrashSupport(boolean z) {
        NeboDMSJNI.MonkeyTestConfiguration_enableTrashSupport_set(this.swigCPtr, this, z);
    }

    public boolean getEnableTrashSupport() {
        return NeboDMSJNI.MonkeyTestConfiguration_enableTrashSupport_get(this.swigCPtr, this);
    }

    public MonkeyTestConfiguration(String str, String str2, String str3, String str4, int i, int i2) {
        this(NeboDMSJNI.new_MonkeyTestConfiguration__SWIG_0(str.getBytes(), str2.getBytes(), str3.getBytes(), str4.getBytes(), i, i2), true);
    }

    public MonkeyTestConfiguration(String str, String str2, String str3, String str4, int i) {
        this(NeboDMSJNI.new_MonkeyTestConfiguration__SWIG_1(str.getBytes(), str2.getBytes(), str3.getBytes(), str4.getBytes(), i), true);
    }

    public MonkeyTestConfiguration(String str, String str2, String str3, String str4) {
        this(NeboDMSJNI.new_MonkeyTestConfiguration__SWIG_2(str.getBytes(), str2.getBytes(), str3.getBytes(), str4.getBytes()), true);
    }
}
