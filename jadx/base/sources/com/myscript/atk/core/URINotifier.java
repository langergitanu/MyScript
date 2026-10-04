package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class URINotifier extends URIListener {
    private transient long swigCPtr;

    public URINotifier(long j, boolean z) {
        super(ATKCoreJNI.URINotifier_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(URINotifier uRINotifier) {
        if (uRINotifier == null) {
            return 0L;
        }
        return uRINotifier.swigCPtr;
    }

    @Override // com.myscript.atk.core.URIListener
    protected void finalize() {
        delete();
    }

    @Override // com.myscript.atk.core.URIListener
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_URINotifier(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public void addURIListener(SWIGTYPE_p_std__shared_ptrT_atk__core__URIListener_t sWIGTYPE_p_std__shared_ptrT_atk__core__URIListener_t) {
        ATKCoreJNI.URINotifier_addURIListener(this.swigCPtr, this, SWIGTYPE_p_std__shared_ptrT_atk__core__URIListener_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_atk__core__URIListener_t));
    }

    public void removeURIListener(SWIGTYPE_p_std__shared_ptrT_atk__core__URIListener_t sWIGTYPE_p_std__shared_ptrT_atk__core__URIListener_t) {
        ATKCoreJNI.URINotifier_removeURIListener(this.swigCPtr, this, SWIGTYPE_p_std__shared_ptrT_atk__core__URIListener_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_atk__core__URIListener_t));
    }

    @Override // com.myscript.atk.core.URIListener
    public boolean isEmpty() {
        return ATKCoreJNI.URINotifier_isEmpty(this.swigCPtr, this);
    }

    @Override // com.myscript.atk.core.URIListener
    public void linkActivated(String str) {
        ATKCoreJNI.URINotifier_linkActivated(this.swigCPtr, this, str.getBytes());
    }

    public URINotifier() {
        this(ATKCoreJNI.new_URINotifier(), true);
    }
}
