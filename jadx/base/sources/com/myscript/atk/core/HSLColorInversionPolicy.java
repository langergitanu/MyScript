package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class HSLColorInversionPolicy implements IColorInversionPolicy {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public HSLColorInversionPolicy(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(HSLColorInversionPolicy hSLColorInversionPolicy) {
        if (hSLColorInversionPolicy == null) {
            return 0L;
        }
        return hSLColorInversionPolicy.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_HSLColorInversionPolicy(j);
            }
            this.swigCPtr = 0L;
        }
    }

    @Override // com.myscript.atk.core.IColorInversionPolicy
    public int invertColor2(int i) {
        return ATKCoreJNI.HSLColorInversionPolicy_invertColor2(this.swigCPtr, this, i);
    }

    public HSLColorInversionPolicy() {
        this(ATKCoreJNI.new_HSLColorInversionPolicy(), true);
    }
}
