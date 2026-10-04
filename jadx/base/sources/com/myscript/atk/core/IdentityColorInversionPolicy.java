package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class IdentityColorInversionPolicy implements IColorInversionPolicy {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public IdentityColorInversionPolicy(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(IdentityColorInversionPolicy identityColorInversionPolicy) {
        if (identityColorInversionPolicy == null) {
            return 0L;
        }
        return identityColorInversionPolicy.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_IdentityColorInversionPolicy(j);
            }
            this.swigCPtr = 0L;
        }
    }

    @Override // com.myscript.atk.core.IColorInversionPolicy
    public int invertColor2(int i) {
        return ATKCoreJNI.IdentityColorInversionPolicy_invertColor2(this.swigCPtr, this, i);
    }

    public IdentityColorInversionPolicy() {
        this(ATKCoreJNI.new_IdentityColorInversionPolicy(), true);
    }
}
