package org.ejml.dense.fixed;

import org.ejml.data.FMatrix4;
import org.ejml.data.FMatrix4x4;

/* JADX INFO: loaded from: classes9.dex */
public class NormOps_FDF4 {
    public static void normalizeF(FMatrix4x4 fMatrix4x4) {
        CommonOps_FDF4.divide(fMatrix4x4, normF(fMatrix4x4));
    }

    public static void normalizeF(FMatrix4 fMatrix4) {
        CommonOps_FDF4.divide(fMatrix4, normF(fMatrix4));
    }

    public static float fastNormF(FMatrix4x4 fMatrix4x4) {
        return (float) Math.sqrt((fMatrix4x4.a11 * fMatrix4x4.a11) + (fMatrix4x4.a12 * fMatrix4x4.a12) + (fMatrix4x4.a13 * fMatrix4x4.a13) + (fMatrix4x4.a14 * fMatrix4x4.a14) + 0.0f + (fMatrix4x4.a21 * fMatrix4x4.a21) + (fMatrix4x4.a22 * fMatrix4x4.a22) + (fMatrix4x4.a23 * fMatrix4x4.a23) + (fMatrix4x4.a24 * fMatrix4x4.a24) + (fMatrix4x4.a31 * fMatrix4x4.a31) + (fMatrix4x4.a32 * fMatrix4x4.a32) + (fMatrix4x4.a33 * fMatrix4x4.a33) + (fMatrix4x4.a34 * fMatrix4x4.a34) + (fMatrix4x4.a41 * fMatrix4x4.a41) + (fMatrix4x4.a42 * fMatrix4x4.a42) + (fMatrix4x4.a43 * fMatrix4x4.a43) + (fMatrix4x4.a44 * fMatrix4x4.a44));
    }

    public static float fastNormF(FMatrix4 fMatrix4) {
        return (float) Math.sqrt((fMatrix4.f2423a1 * fMatrix4.f2423a1) + (fMatrix4.f2424a2 * fMatrix4.f2424a2) + (fMatrix4.f2425a3 * fMatrix4.f2425a3) + (fMatrix4.f2426a4 * fMatrix4.f2426a4));
    }

    public static float normF(FMatrix4x4 fMatrix4x4) {
        float fElementMaxAbs = CommonOps_FDF4.elementMaxAbs(fMatrix4x4);
        if (fElementMaxAbs == 0.0f) {
            return 0.0f;
        }
        float f = fMatrix4x4.a11 / fElementMaxAbs;
        float f2 = fMatrix4x4.a12 / fElementMaxAbs;
        float f3 = fMatrix4x4.a13 / fElementMaxAbs;
        float f4 = fMatrix4x4.a14 / fElementMaxAbs;
        float f5 = fMatrix4x4.a21 / fElementMaxAbs;
        float f6 = fMatrix4x4.a22 / fElementMaxAbs;
        float f7 = fMatrix4x4.a23 / fElementMaxAbs;
        float f8 = fMatrix4x4.a24 / fElementMaxAbs;
        float f9 = fMatrix4x4.a31 / fElementMaxAbs;
        float f10 = fMatrix4x4.a32 / fElementMaxAbs;
        float f11 = fMatrix4x4.a33 / fElementMaxAbs;
        float f12 = fMatrix4x4.a34 / fElementMaxAbs;
        float f13 = fMatrix4x4.a41 / fElementMaxAbs;
        float f14 = fMatrix4x4.a42 / fElementMaxAbs;
        float f15 = fMatrix4x4.a43 / fElementMaxAbs;
        float f16 = fMatrix4x4.a44 / fElementMaxAbs;
        return fElementMaxAbs * ((float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3) + (f4 * f4) + 0.0f + (f5 * f5) + (f6 * f6) + (f7 * f7) + (f8 * f8) + (f9 * f9) + (f10 * f10) + (f11 * f11) + (f12 * f12) + (f13 * f13) + (f14 * f14) + (f15 * f15) + (f16 * f16)));
    }

    public static float normF(FMatrix4 fMatrix4) {
        float fElementMaxAbs = CommonOps_FDF4.elementMaxAbs(fMatrix4);
        if (fElementMaxAbs == 0.0f) {
            return 0.0f;
        }
        float f = fMatrix4.f2423a1 / fElementMaxAbs;
        float f2 = fMatrix4.f2424a2 / fElementMaxAbs;
        float f3 = fMatrix4.f2425a3 / fElementMaxAbs;
        float f4 = fMatrix4.f2426a4 / fElementMaxAbs;
        return fElementMaxAbs * ((float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3) + (f4 * f4)));
    }
}
