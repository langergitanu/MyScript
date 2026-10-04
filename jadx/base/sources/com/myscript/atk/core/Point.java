package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class Point {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Point(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Point point) {
        if (point == null) {
            return 0L;
        }
        return point.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Point(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public Point() {
        this(ATKCoreJNI.new_Point__SWIG_0(), true);
    }

    public Point(float f, float f2) {
        this(ATKCoreJNI.new_Point__SWIG_1(f, f2), true);
    }

    public Point(PointerInfo pointerInfo) {
        this(ATKCoreJNI.new_Point__SWIG_2(PointerInfo.getCPtr(pointerInfo), pointerInfo), true);
    }

    public Point(SWIGTYPE_p_Angle sWIGTYPE_p_Angle, float f) {
        this(ATKCoreJNI.new_Point__SWIG_3(SWIGTYPE_p_Angle.getCPtr(sWIGTYPE_p_Angle), f), true);
    }

    public Point(SWIGTYPE_p_Angle sWIGTYPE_p_Angle) {
        this(ATKCoreJNI.new_Point__SWIG_4(SWIGTYPE_p_Angle.getCPtr(sWIGTYPE_p_Angle)), true);
    }

    public float coord(Axis axis) {
        return ATKCoreJNI.Point_coord(this.swigCPtr, this, axis.swigValue());
    }

    public void assign(Axis axis, float f) {
        ATKCoreJNI.Point_assign(this.swigCPtr, this, axis.swigValue(), f);
    }

    public void add(Axis axis, float f) {
        ATKCoreJNI.Point_add(this.swigCPtr, this, axis.swigValue(), f);
    }

    public void translate(float f, float f2) {
        ATKCoreJNI.Point_translate(this.swigCPtr, this, f, f2);
    }

    public Point translated(float f, float f2) {
        return new Point(ATKCoreJNI.Point_translated(this.swigCPtr, this, f, f2), true);
    }

    public void rotate(double d) {
        ATKCoreJNI.Point_rotate__SWIG_0(this.swigCPtr, this, d);
    }

    public Point rotated(double d) {
        return new Point(ATKCoreJNI.Point_rotated__SWIG_0(this.swigCPtr, this, d), true);
    }

    public void rotate(SWIGTYPE_p_Angle sWIGTYPE_p_Angle) {
        ATKCoreJNI.Point_rotate__SWIG_1(this.swigCPtr, this, SWIGTYPE_p_Angle.getCPtr(sWIGTYPE_p_Angle));
    }

    public Point rotated(SWIGTYPE_p_Angle sWIGTYPE_p_Angle) {
        return new Point(ATKCoreJNI.Point_rotated__SWIG_1(this.swigCPtr, this, SWIGTYPE_p_Angle.getCPtr(sWIGTYPE_p_Angle)), true);
    }

    public float length() {
        return ATKCoreJNI.Point_length(this.swigCPtr, this);
    }

    public float lengthSquared() {
        return ATKCoreJNI.Point_lengthSquared(this.swigCPtr, this);
    }

    public float manhattanLength() {
        return ATKCoreJNI.Point_manhattanLength(this.swigCPtr, this);
    }

    public SWIGTYPE_p_Angle angle() {
        return new SWIGTYPE_p_Angle(ATKCoreJNI.Point_angle(this.swigCPtr, this), true);
    }

    public Point normalized() {
        return new Point(ATKCoreJNI.Point_normalized(this.swigCPtr, this), true);
    }

    public static Point middle(Point point, Point point2) {
        return new Point(ATKCoreJNI.Point_middle(getCPtr(point), point, getCPtr(point2), point2), true);
    }

    public float norm() {
        return ATKCoreJNI.Point_norm(this.swigCPtr, this);
    }

    public boolean strictlyEquals(Point point) {
        return ATKCoreJNI.Point_strictlyEquals(this.swigCPtr, this, getCPtr(point), point);
    }

    public boolean almostEquals(Point point, float f) {
        return ATKCoreJNI.Point_almostEquals__SWIG_0(this.swigCPtr, this, getCPtr(point), point, f);
    }

    public boolean almostEquals(Point point) {
        return ATKCoreJNI.Point_almostEquals__SWIG_1(this.swigCPtr, this, getCPtr(point), point);
    }

    public boolean almostEqualsRelatively(Point point, float f, float f2) {
        return ATKCoreJNI.Point_almostEqualsRelatively(this.swigCPtr, this, getCPtr(point), point, f, f2);
    }

    public float distanceTo(Point point) {
        return ATKCoreJNI.Point_distanceTo(this.swigCPtr, this, getCPtr(point), point);
    }

    public static Point getOrigin() {
        long jPoint_Origin_get = ATKCoreJNI.Point_Origin_get();
        if (jPoint_Origin_get == 0) {
            return null;
        }
        return new Point(jPoint_Origin_get, false);
    }

    public static Point getUndefined() {
        long jPoint_Undefined_get = ATKCoreJNI.Point_Undefined_get();
        if (jPoint_Undefined_get == 0) {
            return null;
        }
        return new Point(jPoint_Undefined_get, false);
    }

    public boolean isUndefined() {
        return ATKCoreJNI.Point_isUndefined(this.swigCPtr, this);
    }

    public boolean isDefined() {
        return ATKCoreJNI.Point_isDefined(this.swigCPtr, this);
    }

    public int hashCode() {
        return ATKCoreJNI.Point_hashCode(this.swigCPtr, this);
    }

    public boolean nativeEquals(Point point) {
        return ATKCoreJNI.Point_nativeEquals(this.swigCPtr, this, getCPtr(point), point);
    }

    public String toString() {
        return new String(ATKCoreJNI.Point_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public float getX() {
        return ATKCoreJNI.Point_getX(this.swigCPtr, this);
    }

    public float getY() {
        return ATKCoreJNI.Point_getY(this.swigCPtr, this);
    }

    public void setX(float f) {
        ATKCoreJNI.Point_setX(this.swigCPtr, this, f);
    }

    public void setY(float f) {
        ATKCoreJNI.Point_setY(this.swigCPtr, this, f);
    }

    public void set(float f, float f2) {
        ATKCoreJNI.Point_set(this.swigCPtr, this, f, f2);
    }
}
