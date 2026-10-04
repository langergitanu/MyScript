package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class MonkeyTest {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MonkeyTest(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(MonkeyTest monkeyTest) {
        if (monkeyTest == null) {
            return 0L;
        }
        return monkeyTest.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_MonkeyTest(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public MonkeyTest(MonkeyTestConfiguration monkeyTestConfiguration) {
        this(NeboDMSJNI.new_MonkeyTest(MonkeyTestConfiguration.getCPtr(monkeyTestConfiguration), monkeyTestConfiguration), true);
    }

    public String v1Dir() {
        return new String(NeboDMSJNI.MonkeyTest_v1Dir(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public boolean run(C6924xc2ebe93a c6924xc2ebe93a, C6925x49f74fb4 c6925x49f74fb4) {
        return NeboDMSJNI.MonkeyTest_run__SWIG_0(this.swigCPtr, this, C6924xc2ebe93a.getCPtr(c6924xc2ebe93a), C6925x49f74fb4.getCPtr(c6925x49f74fb4));
    }

    public boolean run(C6924xc2ebe93a c6924xc2ebe93a) {
        return NeboDMSJNI.MonkeyTest_run__SWIG_1(this.swigCPtr, this, C6924xc2ebe93a.getCPtr(c6924xc2ebe93a));
    }

    public void setLogger(CloudIntegrationLogger cloudIntegrationLogger) {
        NeboDMSJNI.MonkeyTest_setLogger(this.swigCPtr, this, cloudIntegrationLogger);
    }

    public boolean run2(ICloudDriveInterface iCloudDriveInterface, ICloudDriveInterface iCloudDriveInterface2, IDMSListener iDMSListener, IDMSListener iDMSListener2) {
        return NeboDMSJNI.MonkeyTest_run2(this.swigCPtr, this, iCloudDriveInterface, iCloudDriveInterface2, iDMSListener, iDMSListener2);
    }
}
