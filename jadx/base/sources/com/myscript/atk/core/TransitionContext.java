package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class TransitionContext {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public TransitionContext(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(TransitionContext transitionContext) {
        if (transitionContext == null) {
            return 0L;
        }
        return transitionContext.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_TransitionContext(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setInternalStateLocked(boolean z) {
        ATKCoreJNI.TransitionContext_internalStateLocked_set(this.swigCPtr, this, z);
    }

    public boolean getInternalStateLocked() {
        return ATKCoreJNI.TransitionContext_internalStateLocked_get(this.swigCPtr, this);
    }

    public TransitionContext() {
        this(ATKCoreJNI.new_TransitionContext(), true);
    }
}
