package org.ejml.dense.fixed;

import org.ejml.data.FMatrix6;
import org.ejml.data.FMatrix6x6;

/* JADX INFO: loaded from: classes9.dex */
public class NormOps_FDF6 {
    public static void normalizeF(FMatrix6x6 fMatrix6x6) {
        CommonOps_FDF6.divide(fMatrix6x6, normF(fMatrix6x6));
    }

    public static void normalizeF(FMatrix6 fMatrix6) {
        CommonOps_FDF6.divide(fMatrix6, normF(fMatrix6));
    }

    public static float fastNormF(FMatrix6x6 fMatrix6x6) {
        return (float) Math.sqrt((fMatrix6x6.a11 * fMatrix6x6.a11) + (fMatrix6x6.a12 * fMatrix6x6.a12) + (fMatrix6x6.a13 * fMatrix6x6.a13) + (fMatrix6x6.a14 * fMatrix6x6.a14) + (fMatrix6x6.a15 * fMatrix6x6.a15) + (fMatrix6x6.a16 * fMatrix6x6.a16) + 0.0f + (fMatrix6x6.a21 * fMatrix6x6.a21) + (fMatrix6x6.a22 * fMatrix6x6.a22) + (fMatrix6x6.a23 * fMatrix6x6.a23) + (fMatrix6x6.a24 * fMatrix6x6.a24) + (fMatrix6x6.a25 * fMatrix6x6.a25) + (fMatrix6x6.a26 * fMatrix6x6.a26) + (fMatrix6x6.a31 * fMatrix6x6.a31) + (fMatrix6x6.a32 * fMatrix6x6.a32) + (fMatrix6x6.a33 * fMatrix6x6.a33) + (fMatrix6x6.a34 * fMatrix6x6.a34) + (fMatrix6x6.a35 * fMatrix6x6.a35) + (fMatrix6x6.a36 * fMatrix6x6.a36) + (fMatrix6x6.a41 * fMatrix6x6.a41) + (fMatrix6x6.a42 * fMatrix6x6.a42) + (fMatrix6x6.a43 * fMatrix6x6.a43) + (fMatrix6x6.a44 * fMatrix6x6.a44) + (fMatrix6x6.a45 * fMatrix6x6.a45) + (fMatrix6x6.a46 * fMatrix6x6.a46) + (fMatrix6x6.a51 * fMatrix6x6.a51) + (fMatrix6x6.a52 * fMatrix6x6.a52) + (fMatrix6x6.a53 * fMatrix6x6.a53) + (fMatrix6x6.a54 * fMatrix6x6.a54) + (fMatrix6x6.a55 * fMatrix6x6.a55) + (fMatrix6x6.a56 * fMatrix6x6.a56) + (fMatrix6x6.a61 * fMatrix6x6.a61) + (fMatrix6x6.a62 * fMatrix6x6.a62) + (fMatrix6x6.a63 * fMatrix6x6.a63) + (fMatrix6x6.a64 * fMatrix6x6.a64) + (fMatrix6x6.a65 * fMatrix6x6.a65) + (fMatrix6x6.a66 * fMatrix6x6.a66));
    }

    public static float fastNormF(FMatrix6 fMatrix6) {
        return (float) Math.sqrt((fMatrix6.f2432a1 * fMatrix6.f2432a1) + (fMatrix6.f2433a2 * fMatrix6.f2433a2) + (fMatrix6.f2434a3 * fMatrix6.f2434a3) + (fMatrix6.f2435a4 * fMatrix6.f2435a4) + (fMatrix6.f2436a5 * fMatrix6.f2436a5) + (fMatrix6.f2437a6 * fMatrix6.f2437a6));
    }

    public static float normF(FMatrix6x6 fMatrix6x6) {
        float fElementMaxAbs = CommonOps_FDF6.elementMaxAbs(fMatrix6x6);
        if (fElementMaxAbs == 0.0f) {
            return 0.0f;
        }
        float f = fMatrix6x6.a11 / fElementMaxAbs;
        float f2 = fMatrix6x6.a12 / fElementMaxAbs;
        float f3 = fMatrix6x6.a13 / fElementMaxAbs;
        float f4 = fMatrix6x6.a14 / fElementMaxAbs;
        float f5 = fMatrix6x6.a15 / fElementMaxAbs;
        float f6 = fMatrix6x6.a16 / fElementMaxAbs;
        float f7 = fMatrix6x6.a21 / fElementMaxAbs;
        float f8 = fMatrix6x6.a22 / fElementMaxAbs;
        float f9 = fMatrix6x6.a23 / fElementMaxAbs;
        float f10 = fMatrix6x6.a24 / fElementMaxAbs;
        float f11 = fMatrix6x6.a25 / fElementMaxAbs;
        float f12 = fMatrix6x6.a26 / fElementMaxAbs;
        float f13 = fMatrix6x6.a31 / fElementMaxAbs;
        float f14 = fMatrix6x6.a32 / fElementMaxAbs;
        float f15 = fMatrix6x6.a33 / fElementMaxAbs;
        float f16 = fMatrix6x6.a34 / fElementMaxAbs;
        float f17 = fMatrix6x6.a35 / fElementMaxAbs;
        float f18 = fMatrix6x6.a36 / fElementMaxAbs;
        float f19 = fMatrix6x6.a41 / fElementMaxAbs;
        float f20 = fMatrix6x6.a42 / fElementMaxAbs;
        float f21 = fMatrix6x6.a43 / fElementMaxAbs;
        float f22 = fMatrix6x6.a44 / fElementMaxAbs;
        float f23 = fMatrix6x6.a45 / fElementMaxAbs;
        float f24 = fMatrix6x6.a46 / fElementMaxAbs;
        float f25 = fMatrix6x6.a51 / fElementMaxAbs;
        float f26 = fMatrix6x6.a52 / fElementMaxAbs;
        float f27 = fMatrix6x6.a53 / fElementMaxAbs;
        float f28 = fMatrix6x6.a54 / fElementMaxAbs;
        float f29 = fMatrix6x6.a55 / fElementMaxAbs;
        float f30 = fMatrix6x6.a56 / fElementMaxAbs;
        float f31 = fMatrix6x6.a61 / fElementMaxAbs;
        float f32 = fMatrix6x6.a62 / fElementMaxAbs;
        float f33 = fMatrix6x6.a63 / fElementMaxAbs;
        float f34 = fMatrix6x6.a64 / fElementMaxAbs;
        float f35 = fMatrix6x6.a65 / fElementMaxAbs;
        float f36 = fMatrix6x6.a66 / fElementMaxAbs;
        return fElementMaxAbs * ((float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3) + (f4 * f4) + (f5 * f5) + (f6 * f6) + 0.0f + (f7 * f7) + (f8 * f8) + (f9 * f9) + (f10 * f10) + (f11 * f11) + (f12 * f12) + (f13 * f13) + (f14 * f14) + (f15 * f15) + (f16 * f16) + (f17 * f17) + (f18 * f18) + (f19 * f19) + (f20 * f20) + (f21 * f21) + (f22 * f22) + (f23 * f23) + (f24 * f24) + (f25 * f25) + (f26 * f26) + (f27 * f27) + (f28 * f28) + (f29 * f29) + (f30 * f30) + (f31 * f31) + (f32 * f32) + (f33 * f33) + (f34 * f34) + (f35 * f35) + (f36 * f36)));
    }

    public static float normF(FMatrix6 fMatrix6) {
        float fElementMaxAbs = CommonOps_FDF6.elementMaxAbs(fMatrix6);
        if (fElementMaxAbs == 0.0f) {
            return 0.0f;
        }
        float f = fMatrix6.f2432a1 / fElementMaxAbs;
        float f2 = fMatrix6.f2433a2 / fElementMaxAbs;
        float f3 = fMatrix6.f2434a3 / fElementMaxAbs;
        float f4 = fMatrix6.f2435a4 / fElementMaxAbs;
        float f5 = fMatrix6.f2436a5 / fElementMaxAbs;
        float f6 = fMatrix6.f2437a6 / fElementMaxAbs;
        return fElementMaxAbs * ((float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3) + (f4 * f4) + (f5 * f5) + (f6 * f6)));
    }
}
