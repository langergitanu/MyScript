package com.myscript.snt.core;

import com.myscript.atk.core.Axis;
import com.myscript.atk.core.Point;
import com.myscript.atk.core.ValuedAngle;

/* JADX INFO: loaded from: classes7.dex */
public class SWIGAngle extends ValuedAngle {
    private transient long swigCPtr;

    public SWIGAngle(long j, boolean z) {
        super(NeboEngineJNI.SWIGAngle_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGAngle sWIGAngle) {
        if (sWIGAngle == null) {
            return 0L;
        }
        return sWIGAngle.swigCPtr;
    }

    @Override // com.myscript.atk.core.ValuedAngle
    protected void finalize() {
        delete();
    }

    @Override // com.myscript.atk.core.ValuedAngle
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_SWIGAngle(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public static SWIGAngle Undefined() {
        return new SWIGAngle(NeboEngineJNI.SWIGAngle_Undefined(), true);
    }

    public SWIGAngle() {
        this(NeboEngineJNI.new_SWIGAngle__SWIG_0(), true);
    }

    public SWIGAngle(float f) {
        this(NeboEngineJNI.new_SWIGAngle__SWIG_1(f), true);
    }

    public SWIGAngle(double d) {
        this(NeboEngineJNI.new_SWIGAngle__SWIG_2(d), true);
    }

    public SWIGAngle(ValuedAngle valuedAngle) {
        this(NeboEngineJNI.new_SWIGAngle__SWIG_3(ValuedAngle.getCPtr(valuedAngle), valuedAngle), true);
    }

    public SWIGAngle(Point point, Point point2) {
        this(NeboEngineJNI.new_SWIGAngle__SWIG_4(Point.getCPtr(point), point, Point.getCPtr(point2), point2), true);
    }

    public SWIGAngle(Point point, Point point2, Point point3) {
        this(NeboEngineJNI.new_SWIGAngle__SWIG_5(Point.getCPtr(point), point, Point.getCPtr(point2), point2, Point.getCPtr(point3), point3), true);
    }

    public SWIGAngle(double d, double d2, double d3, double d4, Point point) {
        this(NeboEngineJNI.new_SWIGAngle__SWIG_6(d, d2, d3, d4, Point.getCPtr(point), point), true);
    }

    public SWIGAngle(Axis axis) {
        this(NeboEngineJNI.new_SWIGAngle__SWIG_7(axis.swigValue()), true);
    }

    public static SWIGAngle fromDegrees(double d) {
        return new SWIGAngle(NeboEngineJNI.SWIGAngle_fromDegrees(d), true);
    }

    public double valueModuloTwoPI() {
        return NeboEngineJNI.SWIGAngle_valueModuloTwoPI(this.swigCPtr, this);
    }

    public float valueModuloTwoPIAsFloat() {
        return NeboEngineJNI.SWIGAngle_valueModuloTwoPIAsFloat(this.swigCPtr, this);
    }

    public boolean isInRange(SWIGAngle sWIGAngle, ValuedAngle valuedAngle) {
        return NeboEngineJNI.SWIGAngle_isInRange(this.swigCPtr, this, getCPtr(sWIGAngle), sWIGAngle, ValuedAngle.getCPtr(valuedAngle), valuedAngle);
    }

    public static SWIGAngle minDiff(SWIGAngle sWIGAngle, SWIGAngle sWIGAngle2, double d) {
        return new SWIGAngle(NeboEngineJNI.SWIGAngle_minDiff__SWIG_0(getCPtr(sWIGAngle), sWIGAngle, getCPtr(sWIGAngle2), sWIGAngle2, d), true);
    }

    public static SWIGAngle minDiff(SWIGAngle sWIGAngle, SWIGAngle sWIGAngle2) {
        return new SWIGAngle(NeboEngineJNI.SWIGAngle_minDiff__SWIG_1(getCPtr(sWIGAngle), sWIGAngle, getCPtr(sWIGAngle2), sWIGAngle2), true);
    }

    public static SWIGAngle maxDiff(SWIGAngle sWIGAngle, SWIGAngle sWIGAngle2, double d) {
        return new SWIGAngle(NeboEngineJNI.SWIGAngle_maxDiff__SWIG_0(getCPtr(sWIGAngle), sWIGAngle, getCPtr(sWIGAngle2), sWIGAngle2, d), true);
    }

    public static SWIGAngle maxDiff(SWIGAngle sWIGAngle, SWIGAngle sWIGAngle2) {
        return new SWIGAngle(NeboEngineJNI.SWIGAngle_maxDiff__SWIG_1(getCPtr(sWIGAngle), sWIGAngle, getCPtr(sWIGAngle2), sWIGAngle2), true);
    }

    public SWIGAngle abs() {
        return new SWIGAngle(NeboEngineJNI.SWIGAngle_abs(this.swigCPtr, this), true);
    }

    public SWIGAngle roundedAround(SWIGAngle sWIGAngle, double d) {
        return new SWIGAngle(NeboEngineJNI.SWIGAngle_roundedAround(this.swigCPtr, this, getCPtr(sWIGAngle), sWIGAngle, d), true);
    }

    public boolean almostEquals(SWIGAngle sWIGAngle, double d) {
        return NeboEngineJNI.SWIGAngle_almostEquals__SWIG_0(this.swigCPtr, this, getCPtr(sWIGAngle), sWIGAngle, d);
    }

    public boolean almostEquals(SWIGAngle sWIGAngle) {
        return NeboEngineJNI.SWIGAngle_almostEquals__SWIG_1(this.swigCPtr, this, getCPtr(sWIGAngle), sWIGAngle);
    }
}
