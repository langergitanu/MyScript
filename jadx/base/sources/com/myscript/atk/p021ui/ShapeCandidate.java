package com.myscript.atk.p021ui;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class ShapeCandidate {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ShapeCandidate(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ShapeCandidate shapeCandidate) {
        if (shapeCandidate == null) {
            return 0L;
        }
        return shapeCandidate.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKSharedUIJNI.delete_ShapeCandidate(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public ShapeCandidate(String str, boolean z) {
        this(ATKSharedUIJNI.new_ShapeCandidate__SWIG_0(str.getBytes(), z), true);
    }

    public ShapeCandidate(ShapeCandidate shapeCandidate) {
        this(ATKSharedUIJNI.new_ShapeCandidate__SWIG_1(getCPtr(shapeCandidate), shapeCandidate), true);
    }

    public void setLabel(String str) {
        ATKSharedUIJNI.ShapeCandidate_label_set(this.swigCPtr, this, str.getBytes());
    }

    public String getLabel() {
        return new String(ATKSharedUIJNI.ShapeCandidate_label_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setSelected(boolean z) {
        ATKSharedUIJNI.ShapeCandidate_selected_set(this.swigCPtr, this, z);
    }

    public boolean getSelected() {
        return ATKSharedUIJNI.ShapeCandidate_selected_get(this.swigCPtr, this);
    }
}
