package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class EngineError extends RuntimeException {
    private static final long serialVersionUID = -5804622651439172608L;
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public EngineError(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(EngineError engineError) {
        if (engineError == null) {
            return 0L;
        }
        return engineError.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_EngineError(j);
            }
            this.swigCPtr = 0L;
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getClass().getName() + ": [0x" + Integer.toHexString(getErrorId()) + "] " + getMessage();
    }

    public EngineError(int i) {
        this(ATKCoreJNI.new_EngineError__SWIG_0(i), true);
    }

    public EngineError(int i, String str) {
        this(ATKCoreJNI.new_EngineError__SWIG_1(i, str), true);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return ATKCoreJNI.EngineError_getMessage(this.swigCPtr, this);
    }

    public int getErrorId() {
        return ATKCoreJNI.EngineError_getErrorId(this.swigCPtr, this);
    }
}
