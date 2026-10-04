package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public class ReflowOptions {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ReflowOptions(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ReflowOptions reflowOptions) {
        if (reflowOptions == null) {
            return 0L;
        }
        return reflowOptions.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_ReflowOptions(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setEnableStacking(boolean z) {
        NeboEngineJNI.ReflowOptions_enableStacking_set(this.swigCPtr, this, z);
    }

    public boolean getEnableStacking() {
        return NeboEngineJNI.ReflowOptions_enableStacking_get(this.swigCPtr, this);
    }

    public ReflowOptions() {
        this(NeboEngineJNI.new_ReflowOptions(), true);
    }
}
