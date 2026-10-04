package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class BackgroundDescription {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public BackgroundDescription(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(BackgroundDescription backgroundDescription) {
        if (backgroundDescription == null) {
            return 0L;
        }
        return backgroundDescription.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_BackgroundDescription(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setPattern(BackgroundPattern backgroundPattern) {
        ATKCoreJNI.BackgroundDescription_pattern_set(this.swigCPtr, this, backgroundPattern.swigValue());
    }

    public BackgroundPattern getPattern() {
        return BackgroundPattern.swigToEnum(ATKCoreJNI.BackgroundDescription_pattern_get(this.swigCPtr, this));
    }

    public void setDy(float f) {
        ATKCoreJNI.BackgroundDescription_dy_set(this.swigCPtr, this, f);
    }

    public float getDy() {
        return ATKCoreJNI.BackgroundDescription_dy_get(this.swigCPtr, this);
    }

    public void setDx(float f) {
        ATKCoreJNI.BackgroundDescription_dx_set(this.swigCPtr, this, f);
    }

    public float getDx() {
        return ATKCoreJNI.BackgroundDescription_dx_get(this.swigCPtr, this);
    }

    public BackgroundDescription() {
        this(ATKCoreJNI.new_BackgroundDescription(), true);
    }
}
