package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class IObjectManagerFactory {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public IObjectManagerFactory(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(IObjectManagerFactory iObjectManagerFactory) {
        if (iObjectManagerFactory == null) {
            return 0L;
        }
        return iObjectManagerFactory.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_IObjectManagerFactory(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public SWIGTYPE_p_std__shared_ptrT_atk__core__IObjectManager_t create(SWIGTYPE_p_myscript__document__Page sWIGTYPE_p_myscript__document__Page) {
        return new SWIGTYPE_p_std__shared_ptrT_atk__core__IObjectManager_t(ATKCoreJNI.IObjectManagerFactory_create(this.swigCPtr, this, SWIGTYPE_p_myscript__document__Page.getCPtr(sWIGTYPE_p_myscript__document__Page)), true);
    }
}
