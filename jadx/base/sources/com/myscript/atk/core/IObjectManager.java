package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class IObjectManager {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public IObjectManager(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(IObjectManager iObjectManager) {
        if (iObjectManager == null) {
            return 0L;
        }
        return iObjectManager.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_IObjectManager(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public SWIGTYPE_p_std__shared_ptrT_atk__core__IObjectManager_t clone(SWIGTYPE_p_myscript__document__Page sWIGTYPE_p_myscript__document__Page) {
        return new SWIGTYPE_p_std__shared_ptrT_atk__core__IObjectManager_t(ATKCoreJNI.IObjectManager_clone(this.swigCPtr, this, SWIGTYPE_p_myscript__document__Page.getCPtr(sWIGTYPE_p_myscript__document__Page)), true);
    }

    public boolean add(String str, String str2) {
        return ATKCoreJNI.IObjectManager_add(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public void remove(String str) {
        ATKCoreJNI.IObjectManager_remove(this.swigCPtr, this, str.getBytes());
    }

    public boolean contains(String str) {
        return ATKCoreJNI.IObjectManager_contains(this.swigCPtr, this, str.getBytes());
    }

    public void extract(String str, String str2) {
        ATKCoreJNI.IObjectManager_extract(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public void trackUpdates() {
        ATKCoreJNI.IObjectManager_trackUpdates(this.swigCPtr, this);
    }
}
