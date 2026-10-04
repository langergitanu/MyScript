package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class GuideData {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GuideData(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(GuideData guideData) {
        if (guideData == null) {
            return 0L;
        }
        return guideData.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_GuideData(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public GuideType getType() {
        return GuideType.swigToEnum(ATKCoreJNI.GuideData_type_get(this.swigCPtr, this));
    }

    public GuidePurpose getPurpose() {
        return GuidePurpose.swigToEnum(ATKCoreJNI.GuideData_purpose_get(this.swigCPtr, this));
    }

    public GuideData(VerticalLineSet verticalLineSet) {
        this(ATKCoreJNI.new_GuideData__SWIG_0(VerticalLineSet.getCPtr(verticalLineSet), verticalLineSet), true);
    }

    public GuideData(VerticalLineSet verticalLineSet, GuidePurpose guidePurpose) {
        this(ATKCoreJNI.new_GuideData__SWIG_1(VerticalLineSet.getCPtr(verticalLineSet), verticalLineSet, guidePurpose.swigValue()), true);
    }

    public GuideData(HorizontalLineSet horizontalLineSet) {
        this(ATKCoreJNI.new_GuideData__SWIG_2(HorizontalLineSet.getCPtr(horizontalLineSet), horizontalLineSet), true);
    }

    public GuideData(HorizontalLineSet horizontalLineSet, GuidePurpose guidePurpose) {
        this(ATKCoreJNI.new_GuideData__SWIG_3(HorizontalLineSet.getCPtr(horizontalLineSet), horizontalLineSet, guidePurpose.swigValue()), true);
    }

    public VerticalLineSet getVerticalLineSet() {
        return new VerticalLineSet(ATKCoreJNI.GuideData_getVerticalLineSet(this.swigCPtr, this), true);
    }

    public HorizontalLineSet getHorizontalLineSet() {
        return new HorizontalLineSet(ATKCoreJNI.GuideData_getHorizontalLineSet(this.swigCPtr, this), true);
    }
}
