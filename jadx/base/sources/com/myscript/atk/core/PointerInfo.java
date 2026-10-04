package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class PointerInfo extends PointerInfoData {
    public static final float UNDEFINED_ORIENTATION = -10.0f;
    public static final float UNDEFINED_TILT = -1.0f;
    private transient long swigCPtr;

    public PointerInfo(long j, boolean z) {
        super(ATKCoreJNI.PointerInfo_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(PointerInfo pointerInfo) {
        if (pointerInfo == null) {
            return 0L;
        }
        return pointerInfo.swigCPtr;
    }

    @Override // com.myscript.atk.core.PointerInfoData
    protected void finalize() {
        delete();
    }

    @Override // com.myscript.atk.core.PointerInfoData
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_PointerInfo(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public PointerInfo() {
        this(ATKCoreJNI.new_PointerInfo__SWIG_0(), true);
    }

    public PointerInfo(float f, float f2) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_1(f, f2), true);
    }

    public PointerInfo(float f, float f2, long j, float f3, PointerType pointerType, ButtonType buttonType, int i, long j2) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_2(f, f2, j, f3, pointerType.swigValue(), buttonType.swigValue(), i, j2), true);
    }

    public PointerInfo(float f, float f2, long j, float f3, PointerType pointerType, ButtonType buttonType, int i) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_3(f, f2, j, f3, pointerType.swigValue(), buttonType.swigValue(), i), true);
    }

    public PointerInfo(float f, float f2, long j, float f3, PointerType pointerType, ButtonType buttonType) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_4(f, f2, j, f3, pointerType.swigValue(), buttonType.swigValue()), true);
    }

    public PointerInfo(float f, float f2, long j, float f3, PointerType pointerType) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_5(f, f2, j, f3, pointerType.swigValue()), true);
    }

    public PointerInfo(float f, float f2, long j, float f3) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_6(f, f2, j, f3), true);
    }

    public PointerInfo(float f, float f2, long j) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_7(f, f2, j), true);
    }

    public PointerInfo(float f, float f2, long j, float f3, float f4, float f5, PointerType pointerType, ButtonType buttonType, int i, long j2) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_8(f, f2, j, f3, f4, f5, pointerType.swigValue(), buttonType.swigValue(), i, j2), true);
    }

    public PointerInfo(float f, float f2, long j, float f3, float f4, float f5, PointerType pointerType, ButtonType buttonType, int i) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_9(f, f2, j, f3, f4, f5, pointerType.swigValue(), buttonType.swigValue(), i), true);
    }

    public PointerInfo(float f, float f2, long j, float f3, float f4, float f5, PointerType pointerType, ButtonType buttonType) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_10(f, f2, j, f3, f4, f5, pointerType.swigValue(), buttonType.swigValue()), true);
    }

    public PointerInfo(float f, float f2, long j, float f3, float f4, float f5, PointerType pointerType) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_11(f, f2, j, f3, f4, f5, pointerType.swigValue()), true);
    }

    public PointerInfo(float f, float f2, long j, float f3, float f4, float f5) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_12(f, f2, j, f3, f4, f5), true);
    }

    public PointerInfo(Point point) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_13(Point.getCPtr(point), point), true);
    }

    public PointerInfo(Point point, long j, float f, PointerType pointerType, ButtonType buttonType, int i, long j2) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_14(Point.getCPtr(point), point, j, f, pointerType.swigValue(), buttonType.swigValue(), i, j2), true);
    }

    public PointerInfo(Point point, long j, float f, PointerType pointerType, ButtonType buttonType, int i) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_15(Point.getCPtr(point), point, j, f, pointerType.swigValue(), buttonType.swigValue(), i), true);
    }

    public PointerInfo(Point point, long j, float f, PointerType pointerType, ButtonType buttonType) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_16(Point.getCPtr(point), point, j, f, pointerType.swigValue(), buttonType.swigValue()), true);
    }

    public PointerInfo(Point point, long j, float f, PointerType pointerType) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_17(Point.getCPtr(point), point, j, f, pointerType.swigValue()), true);
    }

    public PointerInfo(Point point, long j, float f) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_18(Point.getCPtr(point), point, j, f), true);
    }

    public PointerInfo(Point point, long j) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_19(Point.getCPtr(point), point, j), true);
    }

    public PointerInfo(float f, float f2, PointerInfoData pointerInfoData) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_20(f, f2, PointerInfoData.getCPtr(pointerInfoData), pointerInfoData), true);
    }

    public PointerInfo(Point point, PointerInfoData pointerInfoData) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_21(Point.getCPtr(point), point, PointerInfoData.getCPtr(pointerInfoData), pointerInfoData), true);
    }

    public PointerInfo(PointerInfoData pointerInfoData) {
        this(ATKCoreJNI.new_PointerInfo__SWIG_22(PointerInfoData.getCPtr(pointerInfoData), pointerInfoData), true);
    }

    public static PointerInfo withF(PointerInfoData pointerInfoData, float f) {
        return new PointerInfo(ATKCoreJNI.PointerInfo_withF(PointerInfoData.getCPtr(pointerInfoData), pointerInfoData, f), true);
    }

    public PointerInfo setPosition(float f, float f2) {
        return new PointerInfo(ATKCoreJNI.PointerInfo_setPosition__SWIG_0(this.swigCPtr, this, f, f2), false);
    }

    public PointerInfo setPosition(Point point) {
        return new PointerInfo(ATKCoreJNI.PointerInfo_setPosition__SWIG_1(this.swigCPtr, this, Point.getCPtr(point), point), false);
    }

    public PointerInfo setTimestamp(long j) {
        return new PointerInfo(ATKCoreJNI.PointerInfo_setTimestamp(this.swigCPtr, this, j), false);
    }

    public PointerInfo setForce(float f) {
        return new PointerInfo(ATKCoreJNI.PointerInfo_setForce(this.swigCPtr, this, f), false);
    }

    public PointerInfo setTiltAngle(float f) {
        return new PointerInfo(ATKCoreJNI.PointerInfo_setTiltAngle(this.swigCPtr, this, f), false);
    }

    public PointerInfo setOrientationAngle(float f) {
        return new PointerInfo(ATKCoreJNI.PointerInfo_setOrientationAngle(this.swigCPtr, this, f), false);
    }

    public PointerInfo setPointerType(PointerType pointerType) {
        return new PointerInfo(ATKCoreJNI.PointerInfo_setPointerType(this.swigCPtr, this, pointerType.swigValue()), false);
    }

    public PointerInfo setButtonType(ButtonType buttonType) {
        return new PointerInfo(ATKCoreJNI.PointerInfo_setButtonType(this.swigCPtr, this, buttonType.swigValue()), false);
    }

    public PointerInfo setPointerId(int i) {
        return new PointerInfo(ATKCoreJNI.PointerInfo_setPointerId(this.swigCPtr, this, i), false);
    }

    public float coord(Axis axis) {
        return ATKCoreJNI.PointerInfo_coord(this.swigCPtr, this, axis.swigValue());
    }

    public boolean hasTiltAndOrientation() {
        return ATKCoreJNI.PointerInfo_hasTiltAndOrientation(this.swigCPtr, this);
    }

    public void assign(Axis axis, float f) {
        ATKCoreJNI.PointerInfo_assign(this.swigCPtr, this, axis.swigValue(), f);
    }

    public void add(Axis axis, float f) {
        ATKCoreJNI.PointerInfo_add(this.swigCPtr, this, axis.swigValue(), f);
    }

    public boolean pointAlmostEquals(PointerInfo pointerInfo) {
        return ATKCoreJNI.PointerInfo_pointAlmostEquals(this.swigCPtr, this, getCPtr(pointerInfo), pointerInfo);
    }

    public static PointerInfo interpolate(float f, PointerInfo pointerInfo, PointerInfo pointerInfo2) {
        return new PointerInfo(ATKCoreJNI.PointerInfo_interpolate(f, getCPtr(pointerInfo), pointerInfo, getCPtr(pointerInfo2), pointerInfo2), true);
    }

    public static boolean isValidTilt(float f) {
        return ATKCoreJNI.PointerInfo_isValidTilt(f);
    }

    public static boolean isValidOrientation(float f) {
        return ATKCoreJNI.PointerInfo_isValidOrientation(f);
    }

    public static PointerInfo getUndefined() {
        long jPointerInfo_Undefined_get = ATKCoreJNI.PointerInfo_Undefined_get();
        if (jPointerInfo_Undefined_get == 0) {
            return null;
        }
        return new PointerInfo(jPointerInfo_Undefined_get, false);
    }

    public boolean isUndefined() {
        return ATKCoreJNI.PointerInfo_isUndefined(this.swigCPtr, this);
    }

    public boolean isDefined() {
        return ATKCoreJNI.PointerInfo_isDefined(this.swigCPtr, this);
    }

    public int hashCode() {
        return ATKCoreJNI.PointerInfo_hashCode(this.swigCPtr, this);
    }

    public boolean nativeEquals(PointerInfo pointerInfo) {
        return ATKCoreJNI.PointerInfo_nativeEquals(this.swigCPtr, this, getCPtr(pointerInfo), pointerInfo);
    }

    public String toString() {
        return new String(ATKCoreJNI.PointerInfo_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
