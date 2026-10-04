package com.myscript.snt.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class PaperSize {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public PaperSize(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(PaperSize paperSize) {
        if (paperSize == null) {
            return 0L;
        }
        return paperSize.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_PaperSize(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PaperSize)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return nativeEquals((PaperSize) obj);
    }

    public static PaperSize getA0() {
        long jPaperSize_A0_get = NeboEngineJNI.PaperSize_A0_get();
        if (jPaperSize_A0_get == 0) {
            return null;
        }
        return new PaperSize(jPaperSize_A0_get, false);
    }

    public static PaperSize getA1() {
        long jPaperSize_A1_get = NeboEngineJNI.PaperSize_A1_get();
        if (jPaperSize_A1_get == 0) {
            return null;
        }
        return new PaperSize(jPaperSize_A1_get, false);
    }

    public static PaperSize getA2() {
        long jPaperSize_A2_get = NeboEngineJNI.PaperSize_A2_get();
        if (jPaperSize_A2_get == 0) {
            return null;
        }
        return new PaperSize(jPaperSize_A2_get, false);
    }

    public static PaperSize getA3() {
        long jPaperSize_A3_get = NeboEngineJNI.PaperSize_A3_get();
        if (jPaperSize_A3_get == 0) {
            return null;
        }
        return new PaperSize(jPaperSize_A3_get, false);
    }

    public static PaperSize getA4() {
        long jPaperSize_A4_get = NeboEngineJNI.PaperSize_A4_get();
        if (jPaperSize_A4_get == 0) {
            return null;
        }
        return new PaperSize(jPaperSize_A4_get, false);
    }

    public static PaperSize getA5() {
        long jPaperSize_A5_get = NeboEngineJNI.PaperSize_A5_get();
        if (jPaperSize_A5_get == 0) {
            return null;
        }
        return new PaperSize(jPaperSize_A5_get, false);
    }

    public static PaperSize getA6() {
        long jPaperSize_A6_get = NeboEngineJNI.PaperSize_A6_get();
        if (jPaperSize_A6_get == 0) {
            return null;
        }
        return new PaperSize(jPaperSize_A6_get, false);
    }

    public static PaperSize getA7() {
        long jPaperSize_A7_get = NeboEngineJNI.PaperSize_A7_get();
        if (jPaperSize_A7_get == 0) {
            return null;
        }
        return new PaperSize(jPaperSize_A7_get, false);
    }

    public static PaperSize getA8() {
        long jPaperSize_A8_get = NeboEngineJNI.PaperSize_A8_get();
        if (jPaperSize_A8_get == 0) {
            return null;
        }
        return new PaperSize(jPaperSize_A8_get, false);
    }

    public static PaperSize getA9() {
        long jPaperSize_A9_get = NeboEngineJNI.PaperSize_A9_get();
        if (jPaperSize_A9_get == 0) {
            return null;
        }
        return new PaperSize(jPaperSize_A9_get, false);
    }

    public static PaperSize getA10() {
        long jPaperSize_A10_get = NeboEngineJNI.PaperSize_A10_get();
        if (jPaperSize_A10_get == 0) {
            return null;
        }
        return new PaperSize(jPaperSize_A10_get, false);
    }

    public static PaperSize getUS_Letter() {
        long jPaperSize_US_Letter_get = NeboEngineJNI.PaperSize_US_Letter_get();
        if (jPaperSize_US_Letter_get == 0) {
            return null;
        }
        return new PaperSize(jPaperSize_US_Letter_get, false);
    }

    public static PaperSize getUS_Legal() {
        long jPaperSize_US_Legal_get = NeboEngineJNI.PaperSize_US_Legal_get();
        if (jPaperSize_US_Legal_get == 0) {
            return null;
        }
        return new PaperSize(jPaperSize_US_Legal_get, false);
    }

    public static PaperSize getUS_Tabloid() {
        long jPaperSize_US_Tabloid_get = NeboEngineJNI.PaperSize_US_Tabloid_get();
        if (jPaperSize_US_Tabloid_get == 0) {
            return null;
        }
        return new PaperSize(jPaperSize_US_Tabloid_get, false);
    }

    public static PaperSize getUnlimited() {
        long jPaperSize_Unlimited_get = NeboEngineJNI.PaperSize_Unlimited_get();
        if (jPaperSize_Unlimited_get == 0) {
            return null;
        }
        return new PaperSize(jPaperSize_Unlimited_get, false);
    }

    public void setWidth(float f) {
        NeboEngineJNI.PaperSize_width_set(this.swigCPtr, this, f);
    }

    public float getWidth() {
        return NeboEngineJNI.PaperSize_width_get(this.swigCPtr, this);
    }

    public void setHeight(float f) {
        NeboEngineJNI.PaperSize_height_set(this.swigCPtr, this, f);
    }

    public float getHeight() {
        return NeboEngineJNI.PaperSize_height_get(this.swigCPtr, this);
    }

    public PaperSize() {
        this(NeboEngineJNI.new_PaperSize__SWIG_0(), true);
    }

    public PaperSize(float f, float f2) {
        this(NeboEngineJNI.new_PaperSize__SWIG_1(f, f2), true);
    }

    public boolean isUnlimited() {
        return NeboEngineJNI.PaperSize_isUnlimited(this.swigCPtr, this);
    }

    public boolean isPortrait() {
        return NeboEngineJNI.PaperSize_isPortrait(this.swigCPtr, this);
    }

    public boolean isLandscape() {
        return NeboEngineJNI.PaperSize_isLandscape(this.swigCPtr, this);
    }

    public void rotate() {
        NeboEngineJNI.PaperSize_rotate(this.swigCPtr, this);
    }

    public PaperSize rotated() {
        return new PaperSize(NeboEngineJNI.PaperSize_rotated(this.swigCPtr, this), true);
    }

    public float surface() {
        return NeboEngineJNI.PaperSize_surface(this.swigCPtr, this);
    }

    public double aspectRatio() {
        return NeboEngineJNI.PaperSize_aspectRatio(this.swigCPtr, this);
    }

    public int hashCode() {
        return NeboEngineJNI.PaperSize_hashCode(this.swigCPtr, this);
    }

    public boolean nativeEquals(PaperSize paperSize) {
        return NeboEngineJNI.PaperSize_nativeEquals(this.swigCPtr, this, getCPtr(paperSize), paperSize);
    }

    public String toString() {
        return new String(NeboEngineJNI.PaperSize_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
