package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class Line {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Line(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Line line) {
        if (line == null) {
            return 0L;
        }
        return line.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Line(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setP1(Point point) {
        ATKCoreJNI.Line_p1_set(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public Point getP1() {
        long jLine_p1_get = ATKCoreJNI.Line_p1_get(this.swigCPtr, this);
        if (jLine_p1_get == 0) {
            return null;
        }
        return new Point(jLine_p1_get, false);
    }

    public void setP2(Point point) {
        ATKCoreJNI.Line_p2_set(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public Point getP2() {
        long jLine_p2_get = ATKCoreJNI.Line_p2_get(this.swigCPtr, this);
        if (jLine_p2_get == 0) {
            return null;
        }
        return new Point(jLine_p2_get, false);
    }

    public Line() {
        this(ATKCoreJNI.new_Line__SWIG_0(), true);
    }

    public Line(Point point, Point point2) {
        this(ATKCoreJNI.new_Line__SWIG_1(Point.getCPtr(point), point, Point.getCPtr(point2), point2), true);
    }

    public void translate(float f, float f2) {
        ATKCoreJNI.Line_translate(this.swigCPtr, this, f, f2);
    }

    public float length() {
        return ATKCoreJNI.Line_length(this.swigCPtr, this);
    }

    public float lengthSquared() {
        return ATKCoreJNI.Line_lengthSquared(this.swigCPtr, this);
    }

    public SWIGTYPE_p_Angle angle() {
        return new SWIGTYPE_p_Angle(ATKCoreJNI.Line_angle(this.swigCPtr, this), true);
    }

    public Point center() {
        return new Point(ATKCoreJNI.Line_center(this.swigCPtr, this), true);
    }

    public static Line intersectorOf(Rectangle rectangle, Point point, SWIGTYPE_p_Angle sWIGTYPE_p_Angle) {
        return new Line(ATKCoreJNI.Line_intersectorOf(Rectangle.getCPtr(rectangle), rectangle, Point.getCPtr(point), point, SWIGTYPE_p_Angle.getCPtr(sWIGTYPE_p_Angle)), true);
    }

    public boolean intersects(Rectangle rectangle) {
        return ATKCoreJNI.Line_intersects__SWIG_0(this.swigCPtr, this, Rectangle.getCPtr(rectangle), rectangle);
    }

    public boolean intersects(Line line) {
        return ATKCoreJNI.Line_intersects__SWIG_1(this.swigCPtr, this, getCPtr(line), line);
    }

    public Point intersection(Line line) {
        return new Point(ATKCoreJNI.Line_intersection(this.swigCPtr, this, getCPtr(line), line), true);
    }

    public Point orthogonalProjection(Point point, boolean z) {
        return new Point(ATKCoreJNI.Line_orthogonalProjection__SWIG_0(this.swigCPtr, this, Point.getCPtr(point), point, z), true);
    }

    public Point orthogonalProjection(Point point) {
        return new Point(ATKCoreJNI.Line_orthogonalProjection__SWIG_1(this.swigCPtr, this, Point.getCPtr(point), point), true);
    }

    public float distanceTo(Point point) {
        return ATKCoreJNI.Line_distanceTo(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public static Line getUndefined() {
        long jLine_Undefined_get = ATKCoreJNI.Line_Undefined_get();
        if (jLine_Undefined_get == 0) {
            return null;
        }
        return new Line(jLine_Undefined_get, false);
    }

    public boolean isUndefined() {
        return ATKCoreJNI.Line_isUndefined(this.swigCPtr, this);
    }

    public boolean isDefined() {
        return ATKCoreJNI.Line_isDefined(this.swigCPtr, this);
    }

    public String toString() {
        return new String(ATKCoreJNI.Line_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
