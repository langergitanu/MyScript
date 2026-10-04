package org.ejml.dense.fixed;

import org.ejml.data.FMatrix5;
import org.ejml.data.FMatrix5x5;

/* JADX INFO: loaded from: classes9.dex */
public class NormOps_FDF5 {
    public static void normalizeF(FMatrix5x5 fMatrix5x5) {
        CommonOps_FDF5.divide(fMatrix5x5, normF(fMatrix5x5));
    }

    public static void normalizeF(FMatrix5 fMatrix5) {
        CommonOps_FDF5.divide(fMatrix5, normF(fMatrix5));
    }

    public static float fastNormF(FMatrix5x5 fMatrix5x5) {
        return (float) Math.sqrt((fMatrix5x5.a11 * fMatrix5x5.a11) + (fMatrix5x5.a12 * fMatrix5x5.a12) + (fMatrix5x5.a13 * fMatrix5x5.a13) + (fMatrix5x5.a14 * fMatrix5x5.a14) + (fMatrix5x5.a15 * fMatrix5x5.a15) + 0.0f + (fMatrix5x5.a21 * fMatrix5x5.a21) + (fMatrix5x5.a22 * fMatrix5x5.a22) + (fMatrix5x5.a23 * fMatrix5x5.a23) + (fMatrix5x5.a24 * fMatrix5x5.a24) + (fMatrix5x5.a25 * fMatrix5x5.a25) + (fMatrix5x5.a31 * fMatrix5x5.a31) + (fMatrix5x5.a32 * fMatrix5x5.a32) + (fMatrix5x5.a33 * fMatrix5x5.a33) + (fMatrix5x5.a34 * fMatrix5x5.a34) + (fMatrix5x5.a35 * fMatrix5x5.a35) + (fMatrix5x5.a41 * fMatrix5x5.a41) + (fMatrix5x5.a42 * fMatrix5x5.a42) + (fMatrix5x5.a43 * fMatrix5x5.a43) + (fMatrix5x5.a44 * fMatrix5x5.a44) + (fMatrix5x5.a45 * fMatrix5x5.a45) + (fMatrix5x5.a51 * fMatrix5x5.a51) + (fMatrix5x5.a52 * fMatrix5x5.a52) + (fMatrix5x5.a53 * fMatrix5x5.a53) + (fMatrix5x5.a54 * fMatrix5x5.a54) + (fMatrix5x5.a55 * fMatrix5x5.a55));
    }

    public static float fastNormF(FMatrix5 fMatrix5) {
        return (float) Math.sqrt((fMatrix5.f2427a1 * fMatrix5.f2427a1) + (fMatrix5.f2428a2 * fMatrix5.f2428a2) + (fMatrix5.f2429a3 * fMatrix5.f2429a3) + (fMatrix5.f2430a4 * fMatrix5.f2430a4) + (fMatrix5.f2431a5 * fMatrix5.f2431a5));
    }

    public static float normF(FMatrix5x5 fMatrix5x5) {
        float fElementMaxAbs = CommonOps_FDF5.elementMaxAbs(fMatrix5x5);
        if (fElementMaxAbs == 0.0f) {
            return 0.0f;
        }
        float f = fMatrix5x5.a11 / fElementMaxAbs;
        float f2 = fMatrix5x5.a12 / fElementMaxAbs;
        float f3 = fMatrix5x5.a13 / fElementMaxAbs;
        float f4 = fMatrix5x5.a14 / fElementMaxAbs;
        float f5 = fMatrix5x5.a15 / fElementMaxAbs;
        float f6 = fMatrix5x5.a21 / fElementMaxAbs;
        float f7 = fMatrix5x5.a22 / fElementMaxAbs;
        float f8 = fMatrix5x5.a23 / fElementMaxAbs;
        float f9 = fMatrix5x5.a24 / fElementMaxAbs;
        float f10 = fMatrix5x5.a25 / fElementMaxAbs;
        float f11 = fMatrix5x5.a31 / fElementMaxAbs;
        float f12 = fMatrix5x5.a32 / fElementMaxAbs;
        float f13 = fMatrix5x5.a33 / fElementMaxAbs;
        float f14 = fMatrix5x5.a34 / fElementMaxAbs;
        float f15 = fMatrix5x5.a35 / fElementMaxAbs;
        float f16 = fMatrix5x5.a41 / fElementMaxAbs;
        float f17 = fMatrix5x5.a42 / fElementMaxAbs;
        float f18 = fMatrix5x5.a43 / fElementMaxAbs;
        float f19 = fMatrix5x5.a44 / fElementMaxAbs;
        float f20 = fMatrix5x5.a45 / fElementMaxAbs;
        float f21 = fMatrix5x5.a51 / fElementMaxAbs;
        float f22 = fMatrix5x5.a52 / fElementMaxAbs;
        float f23 = fMatrix5x5.a53 / fElementMaxAbs;
        float f24 = fMatrix5x5.a54 / fElementMaxAbs;
        float f25 = fMatrix5x5.a55 / fElementMaxAbs;
        return fElementMaxAbs * ((float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3) + (f4 * f4) + (f5 * f5) + 0.0f + (f6 * f6) + (f7 * f7) + (f8 * f8) + (f9 * f9) + (f10 * f10) + (f11 * f11) + (f12 * f12) + (f13 * f13) + (f14 * f14) + (f15 * f15) + (f16 * f16) + (f17 * f17) + (f18 * f18) + (f19 * f19) + (f20 * f20) + (f21 * f21) + (f22 * f22) + (f23 * f23) + (f24 * f24) + (f25 * f25)));
    }

    public static float normF(FMatrix5 fMatrix5) {
        float fElementMaxAbs = CommonOps_FDF5.elementMaxAbs(fMatrix5);
        if (fElementMaxAbs == 0.0f) {
            return 0.0f;
        }
        float f = fMatrix5.f2427a1 / fElementMaxAbs;
        float f2 = fMatrix5.f2428a2 / fElementMaxAbs;
        float f3 = fMatrix5.f2429a3 / fElementMaxAbs;
        float f4 = fMatrix5.f2430a4 / fElementMaxAbs;
        float f5 = fMatrix5.f2431a5 / fElementMaxAbs;
        return fElementMaxAbs * ((float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3) + (f4 * f4) + (f5 * f5)));
    }
}
