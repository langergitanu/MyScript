package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class InputCharacter {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public InputCharacter(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(InputCharacter inputCharacter) {
        if (inputCharacter == null) {
            return 0L;
        }
        return inputCharacter.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_InputCharacter(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void clear() {
        ATKCoreJNI.InputCharacter_clear(this.swigCPtr, this);
    }

    public void addAlternate(String str, float f) {
        ATKCoreJNI.InputCharacter_addAlternate(this.swigCPtr, this, str.getBytes(), f);
    }

    public InputCharacter() {
        this(ATKCoreJNI.new_InputCharacter__SWIG_0(), true);
    }

    public InputCharacter(InputCharacter inputCharacter) {
        this(ATKCoreJNI.new_InputCharacter__SWIG_1(getCPtr(inputCharacter), inputCharacter), true);
    }
}
