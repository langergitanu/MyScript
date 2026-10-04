package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class LogIndenter {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public LogIndenter(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(LogIndenter logIndenter) {
        if (logIndenter == null) {
            return 0L;
        }
        return logIndenter.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_LogIndenter(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public LogIndenter(Logger logger, int i) {
        this(ATKCoreJNI.new_LogIndenter__SWIG_0(Logger.getCPtr(logger), logger, i), true);
    }

    public LogIndenter(Logger logger) {
        this(ATKCoreJNI.new_LogIndenter__SWIG_1(Logger.getCPtr(logger), logger), true);
    }
}
