package org.ejml.dense.fixed;

import org.ejml.data.FMatrix2;
import org.ejml.data.FMatrix2x2;

/* JADX INFO: loaded from: classes9.dex */
public class CommonOps_FDF2 {
    public static void add(FMatrix2x2 fMatrix2x2, FMatrix2x2 fMatrix2x22, FMatrix2x2 fMatrix2x23) {
        fMatrix2x23.a11 = fMatrix2x2.a11 + fMatrix2x22.a11;
        fMatrix2x23.a12 = fMatrix2x2.a12 + fMatrix2x22.a12;
        fMatrix2x23.a21 = fMatrix2x2.a21 + fMatrix2x22.a21;
        fMatrix2x23.a22 = fMatrix2x2.a22 + fMatrix2x22.a22;
    }

    public static void add(FMatrix2 fMatrix2, FMatrix2 fMatrix22, FMatrix2 fMatrix23) {
        fMatrix23.f2418a1 = fMatrix2.f2418a1 + fMatrix22.f2418a1;
        fMatrix23.f2419a2 = fMatrix2.f2419a2 + fMatrix22.f2419a2;
    }

    public static void addEquals(FMatrix2x2 fMatrix2x2, FMatrix2x2 fMatrix2x22) {
        fMatrix2x2.a11 += fMatrix2x22.a11;
        fMatrix2x2.a12 += fMatrix2x22.a12;
        fMatrix2x2.a21 += fMatrix2x22.a21;
        fMatrix2x2.a22 += fMatrix2x22.a22;
    }

    public static void addEquals(FMatrix2 fMatrix2, FMatrix2 fMatrix22) {
        fMatrix2.f2418a1 += fMatrix22.f2418a1;
        fMatrix2.f2419a2 += fMatrix22.f2419a2;
    }

    public static void subtract(FMatrix2x2 fMatrix2x2, FMatrix2x2 fMatrix2x22, FMatrix2x2 fMatrix2x23) {
        fMatrix2x23.a11 = fMatrix2x2.a11 - fMatrix2x22.a11;
        fMatrix2x23.a12 = fMatrix2x2.a12 - fMatrix2x22.a12;
        fMatrix2x23.a21 = fMatrix2x2.a21 - fMatrix2x22.a21;
        fMatrix2x23.a22 = fMatrix2x2.a22 - fMatrix2x22.a22;
    }

    public static void subtract(FMatrix2 fMatrix2, FMatrix2 fMatrix22, FMatrix2 fMatrix23) {
        fMatrix23.f2418a1 = fMatrix2.f2418a1 - fMatrix22.f2418a1;
        fMatrix23.f2419a2 = fMatrix2.f2419a2 - fMatrix22.f2419a2;
    }

    public static void subtractEquals(FMatrix2x2 fMatrix2x2, FMatrix2x2 fMatrix2x22) {
        fMatrix2x2.a11 -= fMatrix2x22.a11;
        fMatrix2x2.a12 -= fMatrix2x22.a12;
        fMatrix2x2.a21 -= fMatrix2x22.a21;
        fMatrix2x2.a22 -= fMatrix2x22.a22;
    }

    public static void subtractEquals(FMatrix2 fMatrix2, FMatrix2 fMatrix22) {
        fMatrix2.f2418a1 -= fMatrix22.f2418a1;
        fMatrix2.f2419a2 -= fMatrix22.f2419a2;
    }

    public static void transpose(FMatrix2x2 fMatrix2x2) {
        float f = fMatrix2x2.a12;
        fMatrix2x2.a12 = fMatrix2x2.a21;
        fMatrix2x2.a21 = f;
    }

    public static FMatrix2x2 transpose(FMatrix2x2 fMatrix2x2, FMatrix2x2 fMatrix2x22) {
        if (fMatrix2x2 == null) {
            fMatrix2x2 = new FMatrix2x2();
        }
        fMatrix2x22.a11 = fMatrix2x2.a11;
        fMatrix2x22.a12 = fMatrix2x2.a21;
        fMatrix2x22.a21 = fMatrix2x2.a12;
        fMatrix2x22.a22 = fMatrix2x2.a22;
        return fMatrix2x22;
    }

    public static void mult(FMatrix2x2 fMatrix2x2, FMatrix2x2 fMatrix2x22, FMatrix2x2 fMatrix2x23) {
        fMatrix2x23.a11 = (fMatrix2x2.a11 * fMatrix2x22.a11) + (fMatrix2x2.a12 * fMatrix2x22.a21);
        fMatrix2x23.a12 = (fMatrix2x2.a11 * fMatrix2x22.a12) + (fMatrix2x2.a12 * fMatrix2x22.a22);
        fMatrix2x23.a21 = (fMatrix2x2.a21 * fMatrix2x22.a11) + (fMatrix2x2.a22 * fMatrix2x22.a21);
        fMatrix2x23.a22 = (fMatrix2x2.a21 * fMatrix2x22.a12) + (fMatrix2x2.a22 * fMatrix2x22.a22);
    }

    public static void multTransA(FMatrix2x2 fMatrix2x2, FMatrix2x2 fMatrix2x22, FMatrix2x2 fMatrix2x23) {
        fMatrix2x23.a11 = (fMatrix2x2.a11 * fMatrix2x22.a11) + (fMatrix2x2.a21 * fMatrix2x22.a21);
        fMatrix2x23.a12 = (fMatrix2x2.a11 * fMatrix2x22.a12) + (fMatrix2x2.a21 * fMatrix2x22.a22);
        fMatrix2x23.a21 = (fMatrix2x2.a12 * fMatrix2x22.a11) + (fMatrix2x2.a22 * fMatrix2x22.a21);
        fMatrix2x23.a22 = (fMatrix2x2.a12 * fMatrix2x22.a12) + (fMatrix2x2.a22 * fMatrix2x22.a22);
    }

    public static void multTransAB(FMatrix2x2 fMatrix2x2, FMatrix2x2 fMatrix2x22, FMatrix2x2 fMatrix2x23) {
        fMatrix2x23.a11 = (fMatrix2x2.a11 * fMatrix2x22.a11) + (fMatrix2x2.a21 * fMatrix2x22.a12);
        fMatrix2x23.a12 = (fMatrix2x2.a11 * fMatrix2x22.a21) + (fMatrix2x2.a21 * fMatrix2x22.a22);
        fMatrix2x23.a21 = (fMatrix2x2.a12 * fMatrix2x22.a11) + (fMatrix2x2.a22 * fMatrix2x22.a12);
        fMatrix2x23.a22 = (fMatrix2x2.a12 * fMatrix2x22.a21) + (fMatrix2x2.a22 * fMatrix2x22.a22);
    }

    public static void multTransB(FMatrix2x2 fMatrix2x2, FMatrix2x2 fMatrix2x22, FMatrix2x2 fMatrix2x23) {
        fMatrix2x23.a11 = (fMatrix2x2.a11 * fMatrix2x22.a11) + (fMatrix2x2.a12 * fMatrix2x22.a12);
        fMatrix2x23.a12 = (fMatrix2x2.a11 * fMatrix2x22.a21) + (fMatrix2x2.a12 * fMatrix2x22.a22);
        fMatrix2x23.a21 = (fMatrix2x2.a21 * fMatrix2x22.a11) + (fMatrix2x2.a22 * fMatrix2x22.a12);
        fMatrix2x23.a22 = (fMatrix2x2.a21 * fMatrix2x22.a21) + (fMatrix2x2.a22 * fMatrix2x22.a22);
    }

    public static void multAdd(FMatrix2x2 fMatrix2x2, FMatrix2x2 fMatrix2x22, FMatrix2x2 fMatrix2x23) {
        fMatrix2x23.a11 += (fMatrix2x2.a11 * fMatrix2x22.a11) + (fMatrix2x2.a12 * fMatrix2x22.a21);
        fMatrix2x23.a12 += (fMatrix2x2.a11 * fMatrix2x22.a12) + (fMatrix2x2.a12 * fMatrix2x22.a22);
        fMatrix2x23.a21 += (fMatrix2x2.a21 * fMatrix2x22.a11) + (fMatrix2x2.a22 * fMatrix2x22.a21);
        fMatrix2x23.a22 += (fMatrix2x2.a21 * fMatrix2x22.a12) + (fMatrix2x2.a22 * fMatrix2x22.a22);
    }

    public static void multAddTransA(FMatrix2x2 fMatrix2x2, FMatrix2x2 fMatrix2x22, FMatrix2x2 fMatrix2x23) {
        fMatrix2x23.a11 += (fMatrix2x2.a11 * fMatrix2x22.a11) + (fMatrix2x2.a21 * fMatrix2x22.a21);
        fMatrix2x23.a12 += (fMatrix2x2.a11 * fMatrix2x22.a12) + (fMatrix2x2.a21 * fMatrix2x22.a22);
        fMatrix2x23.a21 += (fMatrix2x2.a12 * fMatrix2x22.a11) + (fMatrix2x2.a22 * fMatrix2x22.a21);
        fMatrix2x23.a22 += (fMatrix2x2.a12 * fMatrix2x22.a12) + (fMatrix2x2.a22 * fMatrix2x22.a22);
    }

    public static void multAddTransAB(FMatrix2x2 fMatrix2x2, FMatrix2x2 fMatrix2x22, FMatrix2x2 fMatrix2x23) {
        fMatrix2x23.a11 += (fMatrix2x2.a11 * fMatrix2x22.a11) + (fMatrix2x2.a21 * fMatrix2x22.a12);
        fMatrix2x23.a12 += (fMatrix2x2.a11 * fMatrix2x22.a21) + (fMatrix2x2.a21 * fMatrix2x22.a22);
        fMatrix2x23.a21 += (fMatrix2x2.a12 * fMatrix2x22.a11) + (fMatrix2x2.a22 * fMatrix2x22.a12);
        fMatrix2x23.a22 += (fMatrix2x2.a12 * fMatrix2x22.a21) + (fMatrix2x2.a22 * fMatrix2x22.a22);
    }

    public static void multAddTransB(FMatrix2x2 fMatrix2x2, FMatrix2x2 fMatrix2x22, FMatrix2x2 fMatrix2x23) {
        fMatrix2x23.a11 += (fMatrix2x2.a11 * fMatrix2x22.a11) + (fMatrix2x2.a12 * fMatrix2x22.a12);
        fMatrix2x23.a12 += (fMatrix2x2.a11 * fMatrix2x22.a21) + (fMatrix2x2.a12 * fMatrix2x22.a22);
        fMatrix2x23.a21 += (fMatrix2x2.a21 * fMatrix2x22.a11) + (fMatrix2x2.a22 * fMatrix2x22.a12);
        fMatrix2x23.a22 += (fMatrix2x2.a21 * fMatrix2x22.a21) + (fMatrix2x2.a22 * fMatrix2x22.a22);
    }

    public static void mult(FMatrix2x2 fMatrix2x2, FMatrix2 fMatrix2, FMatrix2 fMatrix22) {
        fMatrix22.f2418a1 = (fMatrix2x2.a11 * fMatrix2.f2418a1) + (fMatrix2x2.a12 * fMatrix2.f2419a2);
        fMatrix22.f2419a2 = (fMatrix2x2.a21 * fMatrix2.f2418a1) + (fMatrix2x2.a22 * fMatrix2.f2419a2);
    }

    public static void mult(FMatrix2 fMatrix2, FMatrix2x2 fMatrix2x2, FMatrix2 fMatrix22) {
        fMatrix22.f2418a1 = (fMatrix2.f2418a1 * fMatrix2x2.a11) + (fMatrix2.f2419a2 * fMatrix2x2.a21);
        fMatrix22.f2419a2 = (fMatrix2.f2418a1 * fMatrix2x2.a12) + (fMatrix2.f2419a2 * fMatrix2x2.a22);
    }

    public static float dot(FMatrix2 fMatrix2, FMatrix2 fMatrix22) {
        return (fMatrix2.f2418a1 * fMatrix22.f2418a1) + (fMatrix2.f2419a2 * fMatrix22.f2419a2);
    }

    public static void setIdentity(FMatrix2x2 fMatrix2x2) {
        fMatrix2x2.a11 = 1.0f;
        fMatrix2x2.a21 = 0.0f;
        fMatrix2x2.a12 = 0.0f;
        fMatrix2x2.a22 = 1.0f;
    }

    public static boolean invert(FMatrix2x2 fMatrix2x2, FMatrix2x2 fMatrix2x22) {
        float fElementMaxAbs = 1.0f / elementMaxAbs(fMatrix2x2);
        float f = fMatrix2x2.a11 * fElementMaxAbs;
        float f2 = fMatrix2x2.a12 * fElementMaxAbs;
        float f3 = fMatrix2x2.a21 * fElementMaxAbs;
        float f4 = fMatrix2x2.a22 * fElementMaxAbs;
        float f5 = -f3;
        float f6 = ((f * f4) + (f2 * f5)) / fElementMaxAbs;
        fMatrix2x22.a11 = f4 / f6;
        fMatrix2x22.a12 = (-f2) / f6;
        fMatrix2x22.a21 = f5 / f6;
        fMatrix2x22.a22 = f / f6;
        return (Float.isNaN(f6) || Float.isInfinite(f6)) ? false : true;
    }

    public static float det(FMatrix2x2 fMatrix2x2) {
        return (fMatrix2x2.a11 * fMatrix2x2.a22) - (fMatrix2x2.a12 * fMatrix2x2.a21);
    }

    public static float trace(FMatrix2x2 fMatrix2x2) {
        return fMatrix2x2.a11 + fMatrix2x2.a22;
    }

    public static void diag(FMatrix2x2 fMatrix2x2, FMatrix2 fMatrix2) {
        fMatrix2.f2418a1 = fMatrix2x2.a11;
        fMatrix2.f2419a2 = fMatrix2x2.a22;
    }

    public static float elementMax(FMatrix2x2 fMatrix2x2) {
        float f = fMatrix2x2.a11;
        if (fMatrix2x2.a12 > f) {
            f = fMatrix2x2.a12;
        }
        if (fMatrix2x2.a21 > f) {
            f = fMatrix2x2.a21;
        }
        return fMatrix2x2.a22 > f ? fMatrix2x2.a22 : f;
    }

    public static float elementMax(FMatrix2 fMatrix2) {
        float f = fMatrix2.f2418a1;
        return fMatrix2.f2419a2 > f ? fMatrix2.f2419a2 : f;
    }

    public static float elementMaxAbs(FMatrix2x2 fMatrix2x2) {
        float fAbs = Math.abs(fMatrix2x2.a11);
        float fAbs2 = Math.abs(fMatrix2x2.a12);
        if (fAbs2 > fAbs) {
            fAbs = fAbs2;
        }
        float fAbs3 = Math.abs(fMatrix2x2.a21);
        if (fAbs3 > fAbs) {
            fAbs = fAbs3;
        }
        float fAbs4 = Math.abs(fMatrix2x2.a22);
        return fAbs4 > fAbs ? fAbs4 : fAbs;
    }

    public static float elementMaxAbs(FMatrix2 fMatrix2) {
        float fAbs = Math.abs(fMatrix2.f2418a1);
        float fAbs2 = Math.abs(fMatrix2.f2419a2);
        if (fAbs2 > fAbs) {
            fAbs = fAbs2;
        }
        float fAbs3 = Math.abs(fMatrix2.f2419a2);
        return fAbs3 > fAbs ? fAbs3 : fAbs;
    }

    public static float elementMin(FMatrix2x2 fMatrix2x2) {
        float f = fMatrix2x2.a11;
        if (fMatrix2x2.a12 < f) {
            f = fMatrix2x2.a12;
        }
        if (fMatrix2x2.a21 < f) {
            f = fMatrix2x2.a21;
        }
        return fMatrix2x2.a22 < f ? fMatrix2x2.a22 : f;
    }

    public static float elementMin(FMatrix2 fMatrix2) {
        float f = fMatrix2.f2418a1;
        return fMatrix2.f2419a2 < f ? fMatrix2.f2419a2 : f;
    }

    public static float elementMinAbs(FMatrix2x2 fMatrix2x2) {
        float fAbs = Math.abs(fMatrix2x2.a11);
        float fAbs2 = Math.abs(fMatrix2x2.a12);
        if (fAbs2 < fAbs) {
            fAbs = fAbs2;
        }
        float fAbs3 = Math.abs(fMatrix2x2.a21);
        if (fAbs3 < fAbs) {
            fAbs = fAbs3;
        }
        float fAbs4 = Math.abs(fMatrix2x2.a22);
        return fAbs4 < fAbs ? fAbs4 : fAbs;
    }

    public static float elementMinAbs(FMatrix2 fMatrix2) {
        float fAbs = Math.abs(fMatrix2.f2418a1);
        float fAbs2 = Math.abs(fMatrix2.f2418a1);
        if (fAbs2 < fAbs) {
            fAbs = fAbs2;
        }
        float fAbs3 = Math.abs(fMatrix2.f2419a2);
        return fAbs3 < fAbs ? fAbs3 : fAbs;
    }

    public static void elementMult(FMatrix2x2 fMatrix2x2, FMatrix2x2 fMatrix2x22) {
        fMatrix2x2.a11 *= fMatrix2x22.a11;
        fMatrix2x2.a12 *= fMatrix2x22.a12;
        fMatrix2x2.a21 *= fMatrix2x22.a21;
        fMatrix2x2.a22 *= fMatrix2x22.a22;
    }

    public static void elementMult(FMatrix2 fMatrix2, FMatrix2 fMatrix22) {
        fMatrix2.f2418a1 *= fMatrix22.f2418a1;
        fMatrix2.f2419a2 *= fMatrix22.f2419a2;
    }

    public static void elementMult(FMatrix2x2 fMatrix2x2, FMatrix2x2 fMatrix2x22, FMatrix2x2 fMatrix2x23) {
        fMatrix2x23.a11 = fMatrix2x2.a11 * fMatrix2x22.a11;
        fMatrix2x23.a12 = fMatrix2x2.a12 * fMatrix2x22.a12;
        fMatrix2x23.a21 = fMatrix2x2.a21 * fMatrix2x22.a21;
        fMatrix2x23.a22 = fMatrix2x2.a22 * fMatrix2x22.a22;
    }

    public static void elementMult(FMatrix2 fMatrix2, FMatrix2 fMatrix22, FMatrix2 fMatrix23) {
        fMatrix23.f2418a1 = fMatrix2.f2418a1 * fMatrix22.f2418a1;
        fMatrix23.f2419a2 = fMatrix2.f2419a2 * fMatrix22.f2419a2;
    }

    public static void elementDiv(FMatrix2x2 fMatrix2x2, FMatrix2x2 fMatrix2x22) {
        fMatrix2x2.a11 /= fMatrix2x22.a11;
        fMatrix2x2.a12 /= fMatrix2x22.a12;
        fMatrix2x2.a21 /= fMatrix2x22.a21;
        fMatrix2x2.a22 /= fMatrix2x22.a22;
    }

    public static void elementDiv(FMatrix2 fMatrix2, FMatrix2 fMatrix22) {
        fMatrix2.f2418a1 /= fMatrix22.f2418a1;
        fMatrix2.f2419a2 /= fMatrix22.f2419a2;
    }

    public static void elementDiv(FMatrix2x2 fMatrix2x2, FMatrix2x2 fMatrix2x22, FMatrix2x2 fMatrix2x23) {
        fMatrix2x23.a11 = fMatrix2x2.a11 / fMatrix2x22.a11;
        fMatrix2x23.a12 = fMatrix2x2.a12 / fMatrix2x22.a12;
        fMatrix2x23.a21 = fMatrix2x2.a21 / fMatrix2x22.a21;
        fMatrix2x23.a22 = fMatrix2x2.a22 / fMatrix2x22.a22;
    }

    public static void elementDiv(FMatrix2 fMatrix2, FMatrix2 fMatrix22, FMatrix2 fMatrix23) {
        fMatrix23.f2418a1 = fMatrix2.f2418a1 / fMatrix22.f2418a1;
        fMatrix23.f2419a2 = fMatrix2.f2419a2 / fMatrix22.f2419a2;
    }

    public static void scale(float f, FMatrix2x2 fMatrix2x2) {
        fMatrix2x2.a11 *= f;
        fMatrix2x2.a12 *= f;
        fMatrix2x2.a21 *= f;
        fMatrix2x2.a22 *= f;
    }

    public static void scale(float f, FMatrix2 fMatrix2) {
        fMatrix2.f2418a1 *= f;
        fMatrix2.f2419a2 *= f;
    }

    public static void scale(float f, FMatrix2x2 fMatrix2x2, FMatrix2x2 fMatrix2x22) {
        fMatrix2x22.a11 = fMatrix2x2.a11 * f;
        fMatrix2x22.a12 = fMatrix2x2.a12 * f;
        fMatrix2x22.a21 = fMatrix2x2.a21 * f;
        fMatrix2x22.a22 = fMatrix2x2.a22 * f;
    }

    public static void scale(float f, FMatrix2 fMatrix2, FMatrix2 fMatrix22) {
        fMatrix22.f2418a1 = fMatrix2.f2418a1 * f;
        fMatrix22.f2419a2 = fMatrix2.f2419a2 * f;
    }

    public static void divide(FMatrix2x2 fMatrix2x2, float f) {
        fMatrix2x2.a11 /= f;
        fMatrix2x2.a12 /= f;
        fMatrix2x2.a21 /= f;
        fMatrix2x2.a22 /= f;
    }

    public static void divide(FMatrix2 fMatrix2, float f) {
        fMatrix2.f2418a1 /= f;
        fMatrix2.f2419a2 /= f;
    }

    public static void divide(FMatrix2x2 fMatrix2x2, float f, FMatrix2x2 fMatrix2x22) {
        fMatrix2x22.a11 = fMatrix2x2.a11 / f;
        fMatrix2x22.a12 = fMatrix2x2.a12 / f;
        fMatrix2x22.a21 = fMatrix2x2.a21 / f;
        fMatrix2x22.a22 = fMatrix2x2.a22 / f;
    }

    public static void divide(FMatrix2 fMatrix2, float f, FMatrix2 fMatrix22) {
        fMatrix22.f2418a1 = fMatrix2.f2418a1 / f;
        fMatrix22.f2419a2 = fMatrix2.f2419a2 / f;
    }

    public static void changeSign(FMatrix2x2 fMatrix2x2) {
        fMatrix2x2.a11 = -fMatrix2x2.a11;
        fMatrix2x2.a12 = -fMatrix2x2.a12;
        fMatrix2x2.a21 = -fMatrix2x2.a21;
        fMatrix2x2.a22 = -fMatrix2x2.a22;
    }

    public static void changeSign(FMatrix2 fMatrix2) {
        fMatrix2.f2418a1 = -fMatrix2.f2418a1;
        fMatrix2.f2419a2 = -fMatrix2.f2419a2;
    }

    public static void fill(FMatrix2x2 fMatrix2x2, float f) {
        fMatrix2x2.a11 = f;
        fMatrix2x2.a12 = f;
        fMatrix2x2.a21 = f;
        fMatrix2x2.a22 = f;
    }

    public static void fill(FMatrix2 fMatrix2, float f) {
        fMatrix2.f2418a1 = f;
        fMatrix2.f2419a2 = f;
    }

    public static FMatrix2 extractRow(FMatrix2x2 fMatrix2x2, int i, FMatrix2 fMatrix2) {
        if (fMatrix2 == null) {
            fMatrix2 = new FMatrix2();
        }
        if (i == 0) {
            fMatrix2.f2418a1 = fMatrix2x2.a11;
            fMatrix2.f2419a2 = fMatrix2x2.a12;
            return fMatrix2;
        }
        if (i == 1) {
            fMatrix2.f2418a1 = fMatrix2x2.a21;
            fMatrix2.f2419a2 = fMatrix2x2.a22;
            return fMatrix2;
        }
        throw new IllegalArgumentException("Out of bounds row.  row = " + i);
    }

    public static FMatrix2 extractColumn(FMatrix2x2 fMatrix2x2, int i, FMatrix2 fMatrix2) {
        if (fMatrix2 == null) {
            fMatrix2 = new FMatrix2();
        }
        if (i == 0) {
            fMatrix2.f2418a1 = fMatrix2x2.a11;
            fMatrix2.f2419a2 = fMatrix2x2.a21;
            return fMatrix2;
        }
        if (i == 1) {
            fMatrix2.f2418a1 = fMatrix2x2.a12;
            fMatrix2.f2419a2 = fMatrix2x2.a22;
            return fMatrix2;
        }
        throw new IllegalArgumentException("Out of bounds column.  column = " + i);
    }
}
