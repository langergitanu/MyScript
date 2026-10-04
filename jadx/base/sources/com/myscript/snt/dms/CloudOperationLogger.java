package com.myscript.snt.dms;

import com.myscript.atk.core.SWIGVectorString;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class CloudOperationLogger {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public CloudOperationLogger(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CloudOperationLogger cloudOperationLogger) {
        if (cloudOperationLogger == null) {
            return 0L;
        }
        return cloudOperationLogger.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_CloudOperationLogger(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public CloudOperationLogger() {
        this(NeboDMSJNI.new_CloudOperationLogger(), true);
    }

    public void startSession(String str, int i, String str2) {
        NeboDMSJNI.CloudOperationLogger_startSession(this.swigCPtr, this, str.getBytes(), i, str2.getBytes());
    }

    public void endSession(String str) {
        NeboDMSJNI.CloudOperationLogger_endSession(this.swigCPtr, this, str.getBytes());
    }

    public String startAction() {
        return new String(NeboDMSJNI.CloudOperationLogger_startAction(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void endAction(String str, String str2, String str3) {
        NeboDMSJNI.CloudOperationLogger_endAction__SWIG_0(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes());
    }

    public void endAction(String str, String str2) {
        NeboDMSJNI.CloudOperationLogger_endAction__SWIG_1(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public void endActionBatch(String str, String str2, List<String> list) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        NeboDMSJNI.CloudOperationLogger_endActionBatch(this.swigCPtr, this, str.getBytes(), str2.getBytes(), SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString);
    }

    public void addError(String str, String str2) {
        NeboDMSJNI.CloudOperationLogger_addError(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public String dump() {
        return new String(NeboDMSJNI.CloudOperationLogger_dump(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
