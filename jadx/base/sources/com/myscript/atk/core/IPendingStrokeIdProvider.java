package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class IPendingStrokeIdProvider {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public IPendingStrokeIdProvider(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(IPendingStrokeIdProvider iPendingStrokeIdProvider) {
        if (iPendingStrokeIdProvider == null) {
            return 0L;
        }
        return iPendingStrokeIdProvider.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_IPendingStrokeIdProvider(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public long nextPendingStrokeId() {
        return ATKCoreJNI.IPendingStrokeIdProvider_nextPendingStrokeId(this.swigCPtr, this);
    }

    public long allocatePendingStrokeId() {
        return ATKCoreJNI.IPendingStrokeIdProvider_allocatePendingStrokeId(this.swigCPtr, this);
    }
}
