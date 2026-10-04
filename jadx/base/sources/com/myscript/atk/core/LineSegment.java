package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class LineSegment {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public LineSegment(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(LineSegment lineSegment) {
        if (lineSegment == null) {
            return 0L;
        }
        return lineSegment.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_LineSegment(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public Point getP1() {
        return new Point(ATKCoreJNI.LineSegment_getP1(this.swigCPtr, this), true);
    }

    public Point getP2() {
        return new Point(ATKCoreJNI.LineSegment_getP2(this.swigCPtr, this), true);
    }

    public void setP1(Point point) {
        ATKCoreJNI.LineSegment_setP1(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public void setP2(Point point) {
        ATKCoreJNI.LineSegment_setP2(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public LineSegment() {
        this(ATKCoreJNI.new_LineSegment(), true);
    }
}
