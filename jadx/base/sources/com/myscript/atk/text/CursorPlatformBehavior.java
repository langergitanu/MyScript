package com.myscript.atk.text;

/* JADX INFO: loaded from: classes4.dex */
public class CursorPlatformBehavior {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public CursorPlatformBehavior(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CursorPlatformBehavior cursorPlatformBehavior) {
        if (cursorPlatformBehavior == null) {
            return 0L;
        }
        return cursorPlatformBehavior.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKTextJNI.delete_CursorPlatformBehavior(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public CursorPlatformBehavior() {
        this(ATKTextJNI.new_CursorPlatformBehavior__SWIG_0(), true);
    }

    public CursorPlatformBehavior(boolean z, SetCursorBehavior setCursorBehavior, boolean z2) {
        this(ATKTextJNI.new_CursorPlatformBehavior__SWIG_1(z, setCursorBehavior.swigValue(), z2), true);
    }

    public void setIsCursorSwapAllowed(boolean z) {
        ATKTextJNI.CursorPlatformBehavior_isCursorSwapAllowed_set(this.swigCPtr, this, z);
    }

    public boolean getIsCursorSwapAllowed() {
        return ATKTextJNI.CursorPlatformBehavior_isCursorSwapAllowed_get(this.swigCPtr, this);
    }

    public void setSetCursorBehavior(SetCursorBehavior setCursorBehavior) {
        ATKTextJNI.CursorPlatformBehavior_setCursorBehavior_set(this.swigCPtr, this, setCursorBehavior.swigValue());
    }

    public SetCursorBehavior getSetCursorBehavior() {
        return SetCursorBehavior.swigToEnum(ATKTextJNI.CursorPlatformBehavior_setCursorBehavior_get(this.swigCPtr, this));
    }

    public void setIsFullContext(boolean z) {
        ATKTextJNI.CursorPlatformBehavior_isFullContext_set(this.swigCPtr, this, z);
    }

    public boolean getIsFullContext() {
        return ATKTextJNI.CursorPlatformBehavior_isFullContext_get(this.swigCPtr, this);
    }
}
