package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class CaptureInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public CaptureInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CaptureInfo captureInfo) {
        if (captureInfo == null) {
            return 0L;
        }
        return captureInfo.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_CaptureInfo(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public CaptureInfo(PointerInfo pointerInfo, SWIGTYPE_p_Tool__Kind sWIGTYPE_p_Tool__Kind) {
        this(ATKCoreJNI.new_CaptureInfo__SWIG_0(PointerInfo.getCPtr(pointerInfo), pointerInfo, SWIGTYPE_p_Tool__Kind.getCPtr(sWIGTYPE_p_Tool__Kind)), true);
    }

    public CaptureInfo(PointerInfo pointerInfo, SWIGTYPE_p_Tool sWIGTYPE_p_Tool, Origin origin) {
        this(ATKCoreJNI.new_CaptureInfo__SWIG_1(PointerInfo.getCPtr(pointerInfo), pointerInfo, SWIGTYPE_p_Tool.getCPtr(sWIGTYPE_p_Tool), origin.swigValue()), true);
    }

    public CaptureInfo(PointerInfo pointerInfo, SWIGTYPE_p_Tool sWIGTYPE_p_Tool) {
        this(ATKCoreJNI.new_CaptureInfo__SWIG_2(PointerInfo.getCPtr(pointerInfo), pointerInfo, SWIGTYPE_p_Tool.getCPtr(sWIGTYPE_p_Tool)), true);
    }

    public CaptureInfo(SWIGTYPE_p_atk__core__CaptureInfoData sWIGTYPE_p_atk__core__CaptureInfoData) {
        this(ATKCoreJNI.new_CaptureInfo__SWIG_3(SWIGTYPE_p_atk__core__CaptureInfoData.getCPtr(sWIGTYPE_p_atk__core__CaptureInfoData)), true);
    }

    public SWIGTYPE_p_Tool__Kind toolKind() {
        return new SWIGTYPE_p_Tool__Kind(ATKCoreJNI.CaptureInfo_toolKind(this.swigCPtr, this), true);
    }

    public PointerInfo pointerInfo() {
        return new PointerInfo(ATKCoreJNI.CaptureInfo_pointerInfo(this.swigCPtr, this), true);
    }

    public Point pagePoint() {
        return new Point(ATKCoreJNI.CaptureInfo_pagePoint(this.swigCPtr, this), true);
    }

    public PointerInfoData pointerInfoData() {
        return new PointerInfoData(ATKCoreJNI.CaptureInfo_pointerInfoData(this.swigCPtr, this), false);
    }

    public enum Origin {
        VIEW(0),
        PAGE;

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static Origin swigToEnum(int i) {
            Origin[] originArr = (Origin[]) Origin.class.getEnumConstants();
            if (i < originArr.length && i >= 0) {
                Origin origin = originArr[i];
                if (origin.swigValue == i) {
                    return origin;
                }
            }
            for (Origin origin2 : originArr) {
                if (origin2.swigValue == i) {
                    return origin2;
                }
            }
            throw new IllegalArgumentException("No enum " + Origin.class + " with value " + i);
        }

        Origin() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        Origin(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        Origin(Origin origin) {
            int i = origin.swigValue;
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        private static class SwigNext {
            private static int next;

            private SwigNext() {
            }
        }
    }
}
