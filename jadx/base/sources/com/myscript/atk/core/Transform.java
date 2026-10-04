package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class Transform {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Transform(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Transform transform) {
        if (transform == null) {
            return 0L;
        }
        return transform.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Transform(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public Transform() {
        this(ATKCoreJNI.new_Transform__SWIG_0(), true);
    }

    public Transform(float f, float f2, float f3, float f4) {
        this(ATKCoreJNI.new_Transform__SWIG_1(f, f2, f3, f4), true);
    }

    public Transform(float f, float f2, float f3, float f4, float f5, float f6) {
        this(ATKCoreJNI.new_Transform__SWIG_2(f, f2, f3, f4, f5, f6), true);
    }

    public Transform(SWIGTYPE_p_Angle sWIGTYPE_p_Angle, Point point) {
        this(ATKCoreJNI.new_Transform__SWIG_3(SWIGTYPE_p_Angle.getCPtr(sWIGTYPE_p_Angle), Point.getCPtr(point), point), true);
    }

    public Transform scaleFromPoint(float f, float f2, Point point) {
        return new Transform(ATKCoreJNI.Transform_scaleFromPoint(this.swigCPtr, this, f, f2, Point.getCPtr(point), point), false);
    }

    public Transform multiplied(Transform transform) {
        return new Transform(ATKCoreJNI.Transform_multiplied(this.swigCPtr, this, getCPtr(transform), transform), true);
    }

    public void decomposeQR(Transform transform, Transform transform2) {
        ATKCoreJNI.Transform_decomposeQR(this.swigCPtr, this, getCPtr(transform), transform, getCPtr(transform2), transform2);
    }

    public Transform inverted() {
        return new Transform(ATKCoreJNI.Transform_inverted(this.swigCPtr, this), true);
    }

    public boolean invertible() {
        return ATKCoreJNI.Transform_invertible(this.swigCPtr, this);
    }

    public boolean isIdentity() {
        return ATKCoreJNI.Transform_isIdentity(this.swigCPtr, this);
    }

    public boolean isTranslation() {
        return ATKCoreJNI.Transform_isTranslation(this.swigCPtr, this);
    }

    public boolean isRotation() {
        return ATKCoreJNI.Transform_isRotation(this.swigCPtr, this);
    }

    public boolean maybeRotation() {
        return ATKCoreJNI.Transform_maybeRotation(this.swigCPtr, this);
    }

    public void setIdentity() {
        ATKCoreJNI.Transform_setIdentity(this.swigCPtr, this);
    }

    public boolean almostEqual(Transform transform) {
        return ATKCoreJNI.Transform_almostEqual(this.swigCPtr, this, getCPtr(transform), transform);
    }

    public Point map(float f, float f2) {
        return new Point(ATKCoreJNI.Transform_map(this.swigCPtr, this, f, f2), true);
    }

    public float getXScale() {
        return ATKCoreJNI.Transform_getXScale(this.swigCPtr, this);
    }

    public float getYScale() {
        return ATKCoreJNI.Transform_getYScale(this.swigCPtr, this);
    }

    public float getXTranslate() {
        return ATKCoreJNI.Transform_getXTranslate(this.swigCPtr, this);
    }

    public float getYTranslate() {
        return ATKCoreJNI.Transform_getYTranslate(this.swigCPtr, this);
    }

    public float getXShear() {
        return ATKCoreJNI.Transform_getXShear(this.swigCPtr, this);
    }

    public float getYShear() {
        return ATKCoreJNI.Transform_getYShear(this.swigCPtr, this);
    }

    public double rawAngle() {
        return ATKCoreJNI.Transform_rawAngle(this.swigCPtr, this);
    }

    public SWIGTYPE_p_Angle getAngle() {
        return new SWIGTYPE_p_Angle(ATKCoreJNI.Transform_getAngle(this.swigCPtr, this), true);
    }

    public Transform fixRemarkableValues(float f) {
        return new Transform(ATKCoreJNI.Transform_fixRemarkableValues__SWIG_0(this.swigCPtr, this, f), true);
    }

    public Transform fixRemarkableValues() {
        return new Transform(ATKCoreJNI.Transform_fixRemarkableValues__SWIG_1(this.swigCPtr, this), true);
    }

    public void rotate2(float f) {
        ATKCoreJNI.Transform_rotate2__SWIG_0(this.swigCPtr, this, f);
    }

    public void rotate2(float f, float f2, float f3) {
        ATKCoreJNI.Transform_rotate2__SWIG_1(this.swigCPtr, this, f, f2, f3);
    }

    public void translate2(float f, float f2) {
        ATKCoreJNI.Transform_translate2__SWIG_0(this.swigCPtr, this, f, f2);
    }

    public void translate2(Point point) {
        ATKCoreJNI.Transform_translate2__SWIG_1(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public void scale2(float f, float f2) {
        ATKCoreJNI.Transform_scale2(this.swigCPtr, this, f, f2);
    }

    public void shear2(float f, float f2) {
        ATKCoreJNI.Transform_shear2(this.swigCPtr, this, f, f2);
    }

    public void shearX2(float f, float f2) {
        ATKCoreJNI.Transform_shearX2(this.swigCPtr, this, f, f2);
    }

    public void shearY2(float f, float f2) {
        ATKCoreJNI.Transform_shearY2(this.swigCPtr, this, f, f2);
    }

    public void multiply2(Transform transform) {
        ATKCoreJNI.Transform_multiply2(this.swigCPtr, this, getCPtr(transform), transform);
    }

    public void invert2() {
        ATKCoreJNI.Transform_invert2(this.swigCPtr, this);
    }

    public String toString() {
        return new String(ATKCoreJNI.Transform_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
