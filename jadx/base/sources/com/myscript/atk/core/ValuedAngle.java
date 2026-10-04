package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class ValuedAngle {

    /* JADX INFO: renamed from: pi */
    public static final double f1257pi = 3.141592653589793d;
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ValuedAngle(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ValuedAngle valuedAngle) {
        if (valuedAngle == null) {
            return 0L;
        }
        return valuedAngle.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_ValuedAngle(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static ValuedAngle Undefined() {
        return new ValuedAngle(ATKCoreJNI.ValuedAngle_Undefined(), true);
    }

    public ValuedAngle() {
        this(ATKCoreJNI.new_ValuedAngle__SWIG_0(), true);
    }

    public ValuedAngle(double d) {
        this(ATKCoreJNI.new_ValuedAngle__SWIG_1(d), true);
    }

    public double value() {
        return ATKCoreJNI.ValuedAngle_value(this.swigCPtr, this);
    }

    public double degrees() {
        return ATKCoreJNI.ValuedAngle_degrees(this.swigCPtr, this);
    }

    public static ValuedAngle fromDegrees(double d) {
        return new ValuedAngle(ATKCoreJNI.ValuedAngle_fromDegrees(d), true);
    }

    public float valueAsFloat() {
        return ATKCoreJNI.ValuedAngle_valueAsFloat(this.swigCPtr, this);
    }

    public float degreesAsFloat() {
        return ATKCoreJNI.ValuedAngle_degreesAsFloat(this.swigCPtr, this);
    }

    public boolean isUndefined() {
        return ATKCoreJNI.ValuedAngle_isUndefined(this.swigCPtr, this);
    }

    public boolean isDefined() {
        return ATKCoreJNI.ValuedAngle_isDefined(this.swigCPtr, this);
    }

    public boolean strictlyEquals(ValuedAngle valuedAngle) {
        return ATKCoreJNI.ValuedAngle_strictlyEquals(this.swigCPtr, this, getCPtr(valuedAngle), valuedAngle);
    }
}
