package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class StateMachineLock {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public StateMachineLock(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(StateMachineLock stateMachineLock) {
        if (stateMachineLock == null) {
            return 0L;
        }
        return stateMachineLock.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_StateMachineLock(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public StateMachineLock(SWIGTYPE_p_atk__core__StateMachineType sWIGTYPE_p_atk__core__StateMachineType, boolean z) {
        this(ATKCoreJNI.new_StateMachineLock__SWIG_0(SWIGTYPE_p_atk__core__StateMachineType.getCPtr(sWIGTYPE_p_atk__core__StateMachineType), z), true);
    }

    public StateMachineLock(SWIGTYPE_p_atk__core__StateMachineType sWIGTYPE_p_atk__core__StateMachineType) {
        this(ATKCoreJNI.new_StateMachineLock__SWIG_1(SWIGTYPE_p_atk__core__StateMachineType.getCPtr(sWIGTYPE_p_atk__core__StateMachineType)), true);
    }

    public StateMachineLock(SWIGTYPE_p_atk__core__StateMachineType sWIGTYPE_p_atk__core__StateMachineType, SWIGTYPE_p_std__try_to_lock_t sWIGTYPE_p_std__try_to_lock_t, boolean z) {
        this(ATKCoreJNI.new_StateMachineLock__SWIG_2(SWIGTYPE_p_atk__core__StateMachineType.getCPtr(sWIGTYPE_p_atk__core__StateMachineType), SWIGTYPE_p_std__try_to_lock_t.getCPtr(sWIGTYPE_p_std__try_to_lock_t), z), true);
    }

    public StateMachineLock(SWIGTYPE_p_atk__core__StateMachineType sWIGTYPE_p_atk__core__StateMachineType, SWIGTYPE_p_std__try_to_lock_t sWIGTYPE_p_std__try_to_lock_t) {
        this(ATKCoreJNI.new_StateMachineLock__SWIG_3(SWIGTYPE_p_atk__core__StateMachineType.getCPtr(sWIGTYPE_p_atk__core__StateMachineType), SWIGTYPE_p_std__try_to_lock_t.getCPtr(sWIGTYPE_p_std__try_to_lock_t)), true);
    }

    public StateMachineLock(StateMachineLock stateMachineLock) {
        this(ATKCoreJNI.new_StateMachineLock__SWIG_4(getCPtr(stateMachineLock), stateMachineLock), true);
    }

    public boolean owns_lock() {
        return ATKCoreJNI.StateMachineLock_owns_lock(this.swigCPtr, this);
    }
}
