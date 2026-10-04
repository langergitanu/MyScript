package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class CenterEllipticArc {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public CenterEllipticArc(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CenterEllipticArc centerEllipticArc) {
        if (centerEllipticArc == null) {
            return 0L;
        }
        return centerEllipticArc.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_CenterEllipticArc(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setCx(float f) {
        ATKCoreJNI.CenterEllipticArc_cx_set(this.swigCPtr, this, f);
    }

    public float getCx() {
        return ATKCoreJNI.CenterEllipticArc_cx_get(this.swigCPtr, this);
    }

    public void setCy(float f) {
        ATKCoreJNI.CenterEllipticArc_cy_set(this.swigCPtr, this, f);
    }

    public float getCy() {
        return ATKCoreJNI.CenterEllipticArc_cy_get(this.swigCPtr, this);
    }

    public void setRx(float f) {
        ATKCoreJNI.CenterEllipticArc_rx_set(this.swigCPtr, this, f);
    }

    public float getRx() {
        return ATKCoreJNI.CenterEllipticArc_rx_get(this.swigCPtr, this);
    }

    public void setRy(float f) {
        ATKCoreJNI.CenterEllipticArc_ry_set(this.swigCPtr, this, f);
    }

    public float getRy() {
        return ATKCoreJNI.CenterEllipticArc_ry_get(this.swigCPtr, this);
    }

    public void setPhi(float f) {
        ATKCoreJNI.CenterEllipticArc_phi_set(this.swigCPtr, this, f);
    }

    public float getPhi() {
        return ATKCoreJNI.CenterEllipticArc_phi_get(this.swigCPtr, this);
    }

    public void setStartAngle(float f) {
        ATKCoreJNI.CenterEllipticArc_startAngle_set(this.swigCPtr, this, f);
    }

    public float getStartAngle() {
        return ATKCoreJNI.CenterEllipticArc_startAngle_get(this.swigCPtr, this);
    }

    public void setSweepAngle(float f) {
        ATKCoreJNI.CenterEllipticArc_sweepAngle_set(this.swigCPtr, this, f);
    }

    public float getSweepAngle() {
        return ATKCoreJNI.CenterEllipticArc_sweepAngle_get(this.swigCPtr, this);
    }

    public CenterEllipticArc() {
        this(ATKCoreJNI.new_CenterEllipticArc(), true);
    }
}
