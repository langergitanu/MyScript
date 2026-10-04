package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class GuidePositioning {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GuidePositioning(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(GuidePositioning guidePositioning) {
        if (guidePositioning == null) {
            return 0L;
        }
        return guidePositioning.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_GuidePositioning(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setZeroIndexedLine(GuidePositioningType guidePositioningType) {
        ATKCoreJNI.GuidePositioning_zeroIndexedLine_set(this.swigCPtr, this, guidePositioningType.swigValue());
    }

    public GuidePositioningType getZeroIndexedLine() {
        return GuidePositioningType.swigToEnum(ATKCoreJNI.GuidePositioning_zeroIndexedLine_get(this.swigCPtr, this));
    }

    public void setLineBeginning(GuidePositioningType guidePositioningType) {
        ATKCoreJNI.GuidePositioning_lineBeginning_set(this.swigCPtr, this, guidePositioningType.swigValue());
    }

    public GuidePositioningType getLineBeginning() {
        return GuidePositioningType.swigToEnum(ATKCoreJNI.GuidePositioning_lineBeginning_get(this.swigCPtr, this));
    }

    public void setLineEnd(GuidePositioningType guidePositioningType) {
        ATKCoreJNI.GuidePositioning_lineEnd_set(this.swigCPtr, this, guidePositioningType.swigValue());
    }

    public GuidePositioningType getLineEnd() {
        return GuidePositioningType.swigToEnum(ATKCoreJNI.GuidePositioning_lineEnd_get(this.swigCPtr, this));
    }

    public GuidePositioning() {
        this(ATKCoreJNI.new_GuidePositioning(), true);
    }
}
