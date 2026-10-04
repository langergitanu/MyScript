package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class EndpointEllipticArc {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public EndpointEllipticArc(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(EndpointEllipticArc endpointEllipticArc) {
        if (endpointEllipticArc == null) {
            return 0L;
        }
        return endpointEllipticArc.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_EndpointEllipticArc(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setRx(float f) {
        ATKCoreJNI.EndpointEllipticArc_rx_set(this.swigCPtr, this, f);
    }

    public float getRx() {
        return ATKCoreJNI.EndpointEllipticArc_rx_get(this.swigCPtr, this);
    }

    public void setRy(float f) {
        ATKCoreJNI.EndpointEllipticArc_ry_set(this.swigCPtr, this, f);
    }

    public float getRy() {
        return ATKCoreJNI.EndpointEllipticArc_ry_get(this.swigCPtr, this);
    }

    public void setPhi(float f) {
        ATKCoreJNI.EndpointEllipticArc_phi_set(this.swigCPtr, this, f);
    }

    public float getPhi() {
        return ATKCoreJNI.EndpointEllipticArc_phi_get(this.swigCPtr, this);
    }

    public void setFA(int i) {
        ATKCoreJNI.EndpointEllipticArc_fA_set(this.swigCPtr, this, i);
    }

    public int getFA() {
        return ATKCoreJNI.EndpointEllipticArc_fA_get(this.swigCPtr, this);
    }

    public void setFS(int i) {
        ATKCoreJNI.EndpointEllipticArc_fS_set(this.swigCPtr, this, i);
    }

    public int getFS() {
        return ATKCoreJNI.EndpointEllipticArc_fS_get(this.swigCPtr, this);
    }

    public Point getP1() {
        return new Point(ATKCoreJNI.EndpointEllipticArc_getP1(this.swigCPtr, this), true);
    }

    public Point getP2() {
        return new Point(ATKCoreJNI.EndpointEllipticArc_getP2(this.swigCPtr, this), true);
    }

    public void setP1(Point point) {
        ATKCoreJNI.EndpointEllipticArc_setP1(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public void setP2(Point point) {
        ATKCoreJNI.EndpointEllipticArc_setP2(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public EndpointEllipticArc() {
        this(ATKCoreJNI.new_EndpointEllipticArc(), true);
    }
}
