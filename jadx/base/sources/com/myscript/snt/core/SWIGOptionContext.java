package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public class SWIGOptionContext {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGOptionContext(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGOptionContext sWIGOptionContext) {
        if (sWIGOptionContext == null) {
            return 0L;
        }
        return sWIGOptionContext.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_SWIGOptionContext(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public SWIGOptionContext(boolean z) {
        this(NeboEngineJNI.new_SWIGOptionContext__SWIG_0(z), true);
    }

    public SWIGOptionContext() {
        this(NeboEngineJNI.new_SWIGOptionContext__SWIG_1(), true);
    }

    public void setProperty(String str, String str2) {
        NeboEngineJNI.SWIGOptionContext_setProperty(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }
}
