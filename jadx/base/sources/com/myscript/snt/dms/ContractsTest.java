package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public class ContractsTest {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ContractsTest(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ContractsTest contractsTest) {
        if (contractsTest == null) {
            return 0L;
        }
        return contractsTest.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_ContractsTest(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public ContractsTest(ContractsTestConfiguration contractsTestConfiguration) {
        this(NeboDMSJNI.new_ContractsTest(ContractsTestConfiguration.getCPtr(contractsTestConfiguration), contractsTestConfiguration), true);
    }

    public boolean run(ICloudDriveInterface iCloudDriveInterface) {
        return NeboDMSJNI.ContractsTest_run(this.swigCPtr, this, iCloudDriveInterface);
    }

    public void setLogger(CloudIntegrationLogger cloudIntegrationLogger) {
        NeboDMSJNI.ContractsTest_setLogger(this.swigCPtr, this, cloudIntegrationLogger);
    }

    public void setConfiguration(ContractsTestConfiguration contractsTestConfiguration) {
        NeboDMSJNI.ContractsTest_configuration_set(this.swigCPtr, this, ContractsTestConfiguration.getCPtr(contractsTestConfiguration), contractsTestConfiguration);
    }

    public ContractsTestConfiguration getConfiguration() {
        return new ContractsTestConfiguration(NeboDMSJNI.ContractsTest_configuration_get(this.swigCPtr, this), true);
    }

    public void setLogger(C6922xedf536fb c6922xedf536fb) {
        NeboDMSJNI.ContractsTest_logger_set(this.swigCPtr, this, C6922xedf536fb.getCPtr(c6922xedf536fb));
    }

    public C6922xedf536fb getLogger() {
        long jContractsTest_logger_get = NeboDMSJNI.ContractsTest_logger_get(this.swigCPtr, this);
        if (jContractsTest_logger_get == 0) {
            return null;
        }
        return new C6922xedf536fb(jContractsTest_logger_get, false);
    }
}
