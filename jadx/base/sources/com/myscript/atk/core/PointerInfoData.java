package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class PointerInfoData {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public PointerInfoData(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(PointerInfoData pointerInfoData) {
        if (pointerInfoData == null) {
            return 0L;
        }
        return pointerInfoData.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_PointerInfoData(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setX(float f) {
        ATKCoreJNI.PointerInfoData_x_set(this.swigCPtr, this, f);
    }

    public float getX() {
        return ATKCoreJNI.PointerInfoData_x_get(this.swigCPtr, this);
    }

    public void setY(float f) {
        ATKCoreJNI.PointerInfoData_y_set(this.swigCPtr, this, f);
    }

    public float getY() {
        return ATKCoreJNI.PointerInfoData_y_get(this.swigCPtr, this);
    }

    public void setT(long j) {
        ATKCoreJNI.PointerInfoData_t_set(this.swigCPtr, this, j);
    }

    public long getT() {
        return ATKCoreJNI.PointerInfoData_t_get(this.swigCPtr, this);
    }

    public void setF(float f) {
        ATKCoreJNI.PointerInfoData_f_set(this.swigCPtr, this, f);
    }

    public float getF() {
        return ATKCoreJNI.PointerInfoData_f_get(this.swigCPtr, this);
    }

    public void setTilt(float f) {
        ATKCoreJNI.PointerInfoData_tilt_set(this.swigCPtr, this, f);
    }

    public float getTilt() {
        return ATKCoreJNI.PointerInfoData_tilt_get(this.swigCPtr, this);
    }

    public void setOrientation(float f) {
        ATKCoreJNI.PointerInfoData_orientation_set(this.swigCPtr, this, f);
    }

    public float getOrientation() {
        return ATKCoreJNI.PointerInfoData_orientation_get(this.swigCPtr, this);
    }

    public void setType(PointerType pointerType) {
        ATKCoreJNI.PointerInfoData_type_set(this.swigCPtr, this, pointerType.swigValue());
    }

    public PointerType getType() {
        return PointerType.swigToEnum(ATKCoreJNI.PointerInfoData_type_get(this.swigCPtr, this));
    }

    public void setButton(ButtonType buttonType) {
        ATKCoreJNI.PointerInfoData_button_set(this.swigCPtr, this, buttonType.swigValue());
    }

    public ButtonType getButton() {
        return ButtonType.swigToEnum(ATKCoreJNI.PointerInfoData_button_get(this.swigCPtr, this));
    }

    public void setId(int i) {
        ATKCoreJNI.PointerInfoData_id_set(this.swigCPtr, this, i);
    }

    public int getId() {
        return ATKCoreJNI.PointerInfoData_id_get(this.swigCPtr, this);
    }

    public void setFlags(long j) {
        ATKCoreJNI.PointerInfoData_flags_set(this.swigCPtr, this, j);
    }

    public long getFlags() {
        return ATKCoreJNI.PointerInfoData_flags_get(this.swigCPtr, this);
    }

    public PointerInfoData() {
        this(ATKCoreJNI.new_PointerInfoData(), true);
    }
}
