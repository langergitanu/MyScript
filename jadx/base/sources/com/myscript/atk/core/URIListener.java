package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class URIListener {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public URIListener(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(URIListener uRIListener) {
        if (uRIListener == null) {
            return 0L;
        }
        return uRIListener.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_URIListener(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isEmpty() {
        return ATKCoreJNI.URIListener_isEmpty(this.swigCPtr, this);
    }

    public void linkActivated(String str) {
        ATKCoreJNI.URIListener_linkActivated(this.swigCPtr, this, str.getBytes());
    }
}
