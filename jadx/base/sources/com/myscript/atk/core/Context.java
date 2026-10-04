package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class Context {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Context(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Context context) {
        if (context == null) {
            return 0L;
        }
        return context.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Context(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static Context getInstance(byte[] bArr, long j, Object obj, boolean z) {
        long jContext_getInstance__SWIG_0 = ATKCoreJNI.Context_getInstance__SWIG_0(bArr, j, obj, z);
        if (jContext_getInstance__SWIG_0 == 0) {
            return null;
        }
        return new Context(jContext_getInstance__SWIG_0, true);
    }

    public static Context getInstance(byte[] bArr, long j, Object obj) {
        long jContext_getInstance__SWIG_1 = ATKCoreJNI.Context_getInstance__SWIG_1(bArr, j, obj);
        if (jContext_getInstance__SWIG_1 == 0) {
            return null;
        }
        return new Context(jContext_getInstance__SWIG_1, true);
    }

    public static Context getInstance(byte[] bArr, long j) {
        long jContext_getInstance__SWIG_2 = ATKCoreJNI.Context_getInstance__SWIG_2(bArr, j);
        if (jContext_getInstance__SWIG_2 == 0) {
            return null;
        }
        return new Context(jContext_getInstance__SWIG_2, true);
    }

    public static Context getInstance(SWIGTYPE_p_voEngine sWIGTYPE_p_voEngine, boolean z) {
        long jContext_getInstance__SWIG_3 = ATKCoreJNI.Context_getInstance__SWIG_3(SWIGTYPE_p_voEngine.getCPtr(sWIGTYPE_p_voEngine), z);
        if (jContext_getInstance__SWIG_3 == 0) {
            return null;
        }
        return new Context(jContext_getInstance__SWIG_3, true);
    }

    public long getUserObjectCount() {
        return ATKCoreJNI.Context_getUserObjectCount(this.swigCPtr, this);
    }

    public long getUserObjectLimit() {
        return ATKCoreJNI.Context_getUserObjectLimit(this.swigCPtr, this);
    }

    public void setUserObjectCountLimit(long j) {
        ATKCoreJNI.Context_setUserObjectCountLimit(this.swigCPtr, this, j);
    }

    public long userHandwritingContextCount() {
        return ATKCoreJNI.Context_userHandwritingContextCount(this.swigCPtr, this);
    }

    public long userHandwritingContextLimit() {
        return ATKCoreJNI.Context_userHandwritingContextLimit(this.swigCPtr, this);
    }

    public void setUserHandwritingContextCountLimit(long j) {
        ATKCoreJNI.Context_setUserHandwritingContextCountLimit(this.swigCPtr, this, j);
    }
}
