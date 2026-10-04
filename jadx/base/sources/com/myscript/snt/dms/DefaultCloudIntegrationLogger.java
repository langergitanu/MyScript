package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public class DefaultCloudIntegrationLogger {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public DefaultCloudIntegrationLogger(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(DefaultCloudIntegrationLogger defaultCloudIntegrationLogger) {
        if (defaultCloudIntegrationLogger == null) {
            return 0L;
        }
        return defaultCloudIntegrationLogger.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_DefaultCloudIntegrationLogger(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void log(String str) {
        NeboDMSJNI.DefaultCloudIntegrationLogger_log(this.swigCPtr, this, str.getBytes());
    }

    public void logLine(String str) {
        NeboDMSJNI.DefaultCloudIntegrationLogger_logLine__SWIG_0(this.swigCPtr, this, str.getBytes());
    }

    public void logLine() {
        NeboDMSJNI.DefaultCloudIntegrationLogger_logLine__SWIG_1(this.swigCPtr, this);
    }

    public void flush() {
        NeboDMSJNI.DefaultCloudIntegrationLogger_flush(this.swigCPtr, this);
    }

    public boolean allowColors() {
        return NeboDMSJNI.DefaultCloudIntegrationLogger_allowColors(this.swigCPtr, this);
    }

    public DefaultCloudIntegrationLogger() {
        this(NeboDMSJNI.new_DefaultCloudIntegrationLogger(), true);
    }
}
