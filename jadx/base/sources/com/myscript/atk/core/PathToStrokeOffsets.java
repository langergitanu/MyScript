package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class PathToStrokeOffsets {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public PathToStrokeOffsets(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(PathToStrokeOffsets pathToStrokeOffsets) {
        if (pathToStrokeOffsets == null) {
            return 0L;
        }
        return pathToStrokeOffsets.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_PathToStrokeOffsets(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setFromRawStroke(StrokeOffsets strokeOffsets) {
        ATKCoreJNI.PathToStrokeOffsets_fromRawStroke_set(this.swigCPtr, this, StrokeOffsets.getCPtr(strokeOffsets), strokeOffsets);
    }

    public StrokeOffsets getFromRawStroke() {
        long jPathToStrokeOffsets_fromRawStroke_get = ATKCoreJNI.PathToStrokeOffsets_fromRawStroke_get(this.swigCPtr, this);
        if (jPathToStrokeOffsets_fromRawStroke_get == 0) {
            return null;
        }
        return new StrokeOffsets(jPathToStrokeOffsets_fromRawStroke_get, false);
    }

    public void setToInkStroke(StrokeOffsets strokeOffsets) {
        ATKCoreJNI.PathToStrokeOffsets_toInkStroke_set(this.swigCPtr, this, StrokeOffsets.getCPtr(strokeOffsets), strokeOffsets);
    }

    public StrokeOffsets getToInkStroke() {
        long jPathToStrokeOffsets_toInkStroke_get = ATKCoreJNI.PathToStrokeOffsets_toInkStroke_get(this.swigCPtr, this);
        if (jPathToStrokeOffsets_toInkStroke_get == 0) {
            return null;
        }
        return new StrokeOffsets(jPathToStrokeOffsets_toInkStroke_get, false);
    }

    public void setTimingsFromRawStroke(TimingOffsets timingOffsets) {
        ATKCoreJNI.PathToStrokeOffsets_timingsFromRawStroke_set(this.swigCPtr, this, TimingOffsets.getCPtr(timingOffsets), timingOffsets);
    }

    public TimingOffsets getTimingsFromRawStroke() {
        long jPathToStrokeOffsets_timingsFromRawStroke_get = ATKCoreJNI.PathToStrokeOffsets_timingsFromRawStroke_get(this.swigCPtr, this);
        if (jPathToStrokeOffsets_timingsFromRawStroke_get == 0) {
            return null;
        }
        return new TimingOffsets(jPathToStrokeOffsets_timingsFromRawStroke_get, false);
    }

    public void setStrokeOrientationAtBegin(SWIGTYPE_p_Angle sWIGTYPE_p_Angle) {
        ATKCoreJNI.PathToStrokeOffsets_strokeOrientationAtBegin_set(this.swigCPtr, this, SWIGTYPE_p_Angle.getCPtr(sWIGTYPE_p_Angle));
    }

    public SWIGTYPE_p_Angle getStrokeOrientationAtBegin() {
        return new SWIGTYPE_p_Angle(ATKCoreJNI.PathToStrokeOffsets_strokeOrientationAtBegin_get(this.swigCPtr, this), true);
    }

    public PathToStrokeOffsets() {
        this(ATKCoreJNI.new_PathToStrokeOffsets(), true);
    }
}
