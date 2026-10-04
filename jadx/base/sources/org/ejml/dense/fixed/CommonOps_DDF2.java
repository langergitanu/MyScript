package org.ejml.dense.fixed;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrix2;
import org.ejml.data.DMatrix2x2;

/* JADX INFO: loaded from: classes9.dex */
public class CommonOps_DDF2 {
    public static void add(DMatrix2x2 dMatrix2x2, DMatrix2x2 dMatrix2x22, DMatrix2x2 dMatrix2x23) {
        dMatrix2x23.a11 = dMatrix2x2.a11 + dMatrix2x22.a11;
        dMatrix2x23.a12 = dMatrix2x2.a12 + dMatrix2x22.a12;
        dMatrix2x23.a21 = dMatrix2x2.a21 + dMatrix2x22.a21;
        dMatrix2x23.a22 = dMatrix2x2.a22 + dMatrix2x22.a22;
    }

    public static void add(DMatrix2 dMatrix2, DMatrix2 dMatrix22, DMatrix2 dMatrix23) {
        dMatrix23.f2397a1 = dMatrix2.f2397a1 + dMatrix22.f2397a1;
        dMatrix23.f2398a2 = dMatrix2.f2398a2 + dMatrix22.f2398a2;
    }

    public static void addEquals(DMatrix2x2 dMatrix2x2, DMatrix2x2 dMatrix2x22) {
        dMatrix2x2.a11 += dMatrix2x22.a11;
        dMatrix2x2.a12 += dMatrix2x22.a12;
        dMatrix2x2.a21 += dMatrix2x22.a21;
        dMatrix2x2.a22 += dMatrix2x22.a22;
    }

    public static void addEquals(DMatrix2 dMatrix2, DMatrix2 dMatrix22) {
        dMatrix2.f2397a1 += dMatrix22.f2397a1;
        dMatrix2.f2398a2 += dMatrix22.f2398a2;
    }

    public static void subtract(DMatrix2x2 dMatrix2x2, DMatrix2x2 dMatrix2x22, DMatrix2x2 dMatrix2x23) {
        dMatrix2x23.a11 = dMatrix2x2.a11 - dMatrix2x22.a11;
        dMatrix2x23.a12 = dMatrix2x2.a12 - dMatrix2x22.a12;
        dMatrix2x23.a21 = dMatrix2x2.a21 - dMatrix2x22.a21;
        dMatrix2x23.a22 = dMatrix2x2.a22 - dMatrix2x22.a22;
    }

    public static void subtract(DMatrix2 dMatrix2, DMatrix2 dMatrix22, DMatrix2 dMatrix23) {
        dMatrix23.f2397a1 = dMatrix2.f2397a1 - dMatrix22.f2397a1;
        dMatrix23.f2398a2 = dMatrix2.f2398a2 - dMatrix22.f2398a2;
    }

    public static void subtractEquals(DMatrix2x2 dMatrix2x2, DMatrix2x2 dMatrix2x22) {
        dMatrix2x2.a11 -= dMatrix2x22.a11;
        dMatrix2x2.a12 -= dMatrix2x22.a12;
        dMatrix2x2.a21 -= dMatrix2x22.a21;
        dMatrix2x2.a22 -= dMatrix2x22.a22;
    }

    public static void subtractEquals(DMatrix2 dMatrix2, DMatrix2 dMatrix22) {
        dMatrix2.f2397a1 -= dMatrix22.f2397a1;
        dMatrix2.f2398a2 -= dMatrix22.f2398a2;
    }

    public static void transpose(DMatrix2x2 dMatrix2x2) {
        double d = dMatrix2x2.a12;
        dMatrix2x2.a12 = dMatrix2x2.a21;
        dMatrix2x2.a21 = d;
    }

    public static DMatrix2x2 transpose(DMatrix2x2 dMatrix2x2, DMatrix2x2 dMatrix2x22) {
        if (dMatrix2x2 == null) {
            dMatrix2x2 = new DMatrix2x2();
        }
        dMatrix2x22.a11 = dMatrix2x2.a11;
        dMatrix2x22.a12 = dMatrix2x2.a21;
        dMatrix2x22.a21 = dMatrix2x2.a12;
        dMatrix2x22.a22 = dMatrix2x2.a22;
        return dMatrix2x22;
    }

    public static void mult(DMatrix2x2 dMatrix2x2, DMatrix2x2 dMatrix2x22, DMatrix2x2 dMatrix2x23) {
        dMatrix2x23.a11 = (dMatrix2x2.a11 * dMatrix2x22.a11) + (dMatrix2x2.a12 * dMatrix2x22.a21);
        dMatrix2x23.a12 = (dMatrix2x2.a11 * dMatrix2x22.a12) + (dMatrix2x2.a12 * dMatrix2x22.a22);
        dMatrix2x23.a21 = (dMatrix2x2.a21 * dMatrix2x22.a11) + (dMatrix2x2.a22 * dMatrix2x22.a21);
        dMatrix2x23.a22 = (dMatrix2x2.a21 * dMatrix2x22.a12) + (dMatrix2x2.a22 * dMatrix2x22.a22);
    }

    public static void multTransA(DMatrix2x2 dMatrix2x2, DMatrix2x2 dMatrix2x22, DMatrix2x2 dMatrix2x23) {
        dMatrix2x23.a11 = (dMatrix2x2.a11 * dMatrix2x22.a11) + (dMatrix2x2.a21 * dMatrix2x22.a21);
        dMatrix2x23.a12 = (dMatrix2x2.a11 * dMatrix2x22.a12) + (dMatrix2x2.a21 * dMatrix2x22.a22);
        dMatrix2x23.a21 = (dMatrix2x2.a12 * dMatrix2x22.a11) + (dMatrix2x2.a22 * dMatrix2x22.a21);
        dMatrix2x23.a22 = (dMatrix2x2.a12 * dMatrix2x22.a12) + (dMatrix2x2.a22 * dMatrix2x22.a22);
    }

    public static void multTransAB(DMatrix2x2 dMatrix2x2, DMatrix2x2 dMatrix2x22, DMatrix2x2 dMatrix2x23) {
        dMatrix2x23.a11 = (dMatrix2x2.a11 * dMatrix2x22.a11) + (dMatrix2x2.a21 * dMatrix2x22.a12);
        dMatrix2x23.a12 = (dMatrix2x2.a11 * dMatrix2x22.a21) + (dMatrix2x2.a21 * dMatrix2x22.a22);
        dMatrix2x23.a21 = (dMatrix2x2.a12 * dMatrix2x22.a11) + (dMatrix2x2.a22 * dMatrix2x22.a12);
        dMatrix2x23.a22 = (dMatrix2x2.a12 * dMatrix2x22.a21) + (dMatrix2x2.a22 * dMatrix2x22.a22);
    }

    public static void multTransB(DMatrix2x2 dMatrix2x2, DMatrix2x2 dMatrix2x22, DMatrix2x2 dMatrix2x23) {
        dMatrix2x23.a11 = (dMatrix2x2.a11 * dMatrix2x22.a11) + (dMatrix2x2.a12 * dMatrix2x22.a12);
        dMatrix2x23.a12 = (dMatrix2x2.a11 * dMatrix2x22.a21) + (dMatrix2x2.a12 * dMatrix2x22.a22);
        dMatrix2x23.a21 = (dMatrix2x2.a21 * dMatrix2x22.a11) + (dMatrix2x2.a22 * dMatrix2x22.a12);
        dMatrix2x23.a22 = (dMatrix2x2.a21 * dMatrix2x22.a21) + (dMatrix2x2.a22 * dMatrix2x22.a22);
    }

    public static void multAdd(DMatrix2x2 dMatrix2x2, DMatrix2x2 dMatrix2x22, DMatrix2x2 dMatrix2x23) {
        dMatrix2x23.a11 += (dMatrix2x2.a11 * dMatrix2x22.a11) + (dMatrix2x2.a12 * dMatrix2x22.a21);
        dMatrix2x23.a12 += (dMatrix2x2.a11 * dMatrix2x22.a12) + (dMatrix2x2.a12 * dMatrix2x22.a22);
        dMatrix2x23.a21 += (dMatrix2x2.a21 * dMatrix2x22.a11) + (dMatrix2x2.a22 * dMatrix2x22.a21);
        dMatrix2x23.a22 += (dMatrix2x2.a21 * dMatrix2x22.a12) + (dMatrix2x2.a22 * dMatrix2x22.a22);
    }

    public static void multAddTransA(DMatrix2x2 dMatrix2x2, DMatrix2x2 dMatrix2x22, DMatrix2x2 dMatrix2x23) {
        dMatrix2x23.a11 += (dMatrix2x2.a11 * dMatrix2x22.a11) + (dMatrix2x2.a21 * dMatrix2x22.a21);
        dMatrix2x23.a12 += (dMatrix2x2.a11 * dMatrix2x22.a12) + (dMatrix2x2.a21 * dMatrix2x22.a22);
        dMatrix2x23.a21 += (dMatrix2x2.a12 * dMatrix2x22.a11) + (dMatrix2x2.a22 * dMatrix2x22.a21);
        dMatrix2x23.a22 += (dMatrix2x2.a12 * dMatrix2x22.a12) + (dMatrix2x2.a22 * dMatrix2x22.a22);
    }

    public static void multAddTransAB(DMatrix2x2 dMatrix2x2, DMatrix2x2 dMatrix2x22, DMatrix2x2 dMatrix2x23) {
        dMatrix2x23.a11 += (dMatrix2x2.a11 * dMatrix2x22.a11) + (dMatrix2x2.a21 * dMatrix2x22.a12);
        dMatrix2x23.a12 += (dMatrix2x2.a11 * dMatrix2x22.a21) + (dMatrix2x2.a21 * dMatrix2x22.a22);
        dMatrix2x23.a21 += (dMatrix2x2.a12 * dMatrix2x22.a11) + (dMatrix2x2.a22 * dMatrix2x22.a12);
        dMatrix2x23.a22 += (dMatrix2x2.a12 * dMatrix2x22.a21) + (dMatrix2x2.a22 * dMatrix2x22.a22);
    }

    public static void multAddTransB(DMatrix2x2 dMatrix2x2, DMatrix2x2 dMatrix2x22, DMatrix2x2 dMatrix2x23) {
        dMatrix2x23.a11 += (dMatrix2x2.a11 * dMatrix2x22.a11) + (dMatrix2x2.a12 * dMatrix2x22.a12);
        dMatrix2x23.a12 += (dMatrix2x2.a11 * dMatrix2x22.a21) + (dMatrix2x2.a12 * dMatrix2x22.a22);
        dMatrix2x23.a21 += (dMatrix2x2.a21 * dMatrix2x22.a11) + (dMatrix2x2.a22 * dMatrix2x22.a12);
        dMatrix2x23.a22 += (dMatrix2x2.a21 * dMatrix2x22.a21) + (dMatrix2x2.a22 * dMatrix2x22.a22);
    }

    public static void mult(DMatrix2x2 dMatrix2x2, DMatrix2 dMatrix2, DMatrix2 dMatrix22) {
        dMatrix22.f2397a1 = (dMatrix2x2.a11 * dMatrix2.f2397a1) + (dMatrix2x2.a12 * dMatrix2.f2398a2);
        dMatrix22.f2398a2 = (dMatrix2x2.a21 * dMatrix2.f2397a1) + (dMatrix2x2.a22 * dMatrix2.f2398a2);
    }

    public static void mult(DMatrix2 dMatrix2, DMatrix2x2 dMatrix2x2, DMatrix2 dMatrix22) {
        dMatrix22.f2397a1 = (dMatrix2.f2397a1 * dMatrix2x2.a11) + (dMatrix2.f2398a2 * dMatrix2x2.a21);
        dMatrix22.f2398a2 = (dMatrix2.f2397a1 * dMatrix2x2.a12) + (dMatrix2.f2398a2 * dMatrix2x2.a22);
    }

    public static double dot(DMatrix2 dMatrix2, DMatrix2 dMatrix22) {
        return (dMatrix2.f2397a1 * dMatrix22.f2397a1) + (dMatrix2.f2398a2 * dMatrix22.f2398a2);
    }

    public static void setIdentity(DMatrix2x2 dMatrix2x2) {
        dMatrix2x2.a11 = 1.0d;
        dMatrix2x2.a21 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix2x2.a12 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        dMatrix2x2.a22 = 1.0d;
    }

    public static boolean invert(DMatrix2x2 dMatrix2x2, DMatrix2x2 dMatrix2x22) {
        double dElementMaxAbs = 1.0d / elementMaxAbs(dMatrix2x2);
        double d = dMatrix2x2.a11 * dElementMaxAbs;
        double d2 = dMatrix2x2.a12 * dElementMaxAbs;
        double d3 = dMatrix2x2.a21 * dElementMaxAbs;
        double d4 = dMatrix2x2.a22 * dElementMaxAbs;
        double d5 = -d3;
        double d6 = ((d * d4) + (d2 * d5)) / dElementMaxAbs;
        dMatrix2x22.a11 = d4 / d6;
        dMatrix2x22.a12 = (-d2) / d6;
        dMatrix2x22.a21 = d5 / d6;
        dMatrix2x22.a22 = d / d6;
        return (Double.isNaN(d6) || Double.isInfinite(d6)) ? false : true;
    }

    public static double det(DMatrix2x2 dMatrix2x2) {
        return (dMatrix2x2.a11 * dMatrix2x2.a22) - (dMatrix2x2.a12 * dMatrix2x2.a21);
    }

    public static double trace(DMatrix2x2 dMatrix2x2) {
        return dMatrix2x2.a11 + dMatrix2x2.a22;
    }

    public static void diag(DMatrix2x2 dMatrix2x2, DMatrix2 dMatrix2) {
        dMatrix2.f2397a1 = dMatrix2x2.a11;
        dMatrix2.f2398a2 = dMatrix2x2.a22;
    }

    public static double elementMax(DMatrix2x2 dMatrix2x2) {
        double d = dMatrix2x2.a11;
        if (dMatrix2x2.a12 > d) {
            d = dMatrix2x2.a12;
        }
        if (dMatrix2x2.a21 > d) {
            d = dMatrix2x2.a21;
        }
        return dMatrix2x2.a22 > d ? dMatrix2x2.a22 : d;
    }

    public static double elementMax(DMatrix2 dMatrix2) {
        double d = dMatrix2.f2397a1;
        return dMatrix2.f2398a2 > d ? dMatrix2.f2398a2 : d;
    }

    public static double elementMaxAbs(DMatrix2x2 dMatrix2x2) {
        double dAbs = Math.abs(dMatrix2x2.a11);
        double dAbs2 = Math.abs(dMatrix2x2.a12);
        if (dAbs2 > dAbs) {
            dAbs = dAbs2;
        }
        double dAbs3 = Math.abs(dMatrix2x2.a21);
        if (dAbs3 > dAbs) {
            dAbs = dAbs3;
        }
        double dAbs4 = Math.abs(dMatrix2x2.a22);
        return dAbs4 > dAbs ? dAbs4 : dAbs;
    }

    public static double elementMaxAbs(DMatrix2 dMatrix2) {
        double dAbs = Math.abs(dMatrix2.f2397a1);
        double dAbs2 = Math.abs(dMatrix2.f2398a2);
        if (dAbs2 > dAbs) {
            dAbs = dAbs2;
        }
        double dAbs3 = Math.abs(dMatrix2.f2398a2);
        return dAbs3 > dAbs ? dAbs3 : dAbs;
    }

    public static double elementMin(DMatrix2x2 dMatrix2x2) {
        double d = dMatrix2x2.a11;
        if (dMatrix2x2.a12 < d) {
            d = dMatrix2x2.a12;
        }
        if (dMatrix2x2.a21 < d) {
            d = dMatrix2x2.a21;
        }
        return dMatrix2x2.a22 < d ? dMatrix2x2.a22 : d;
    }

    public static double elementMin(DMatrix2 dMatrix2) {
        double d = dMatrix2.f2397a1;
        return dMatrix2.f2398a2 < d ? dMatrix2.f2398a2 : d;
    }

    public static double elementMinAbs(DMatrix2x2 dMatrix2x2) {
        double dAbs = Math.abs(dMatrix2x2.a11);
        double dAbs2 = Math.abs(dMatrix2x2.a12);
        if (dAbs2 < dAbs) {
            dAbs = dAbs2;
        }
        double dAbs3 = Math.abs(dMatrix2x2.a21);
        if (dAbs3 < dAbs) {
            dAbs = dAbs3;
        }
        double dAbs4 = Math.abs(dMatrix2x2.a22);
        return dAbs4 < dAbs ? dAbs4 : dAbs;
    }

    public static double elementMinAbs(DMatrix2 dMatrix2) {
        double dAbs = Math.abs(dMatrix2.f2397a1);
        double dAbs2 = Math.abs(dMatrix2.f2397a1);
        if (dAbs2 < dAbs) {
            dAbs = dAbs2;
        }
        double dAbs3 = Math.abs(dMatrix2.f2398a2);
        return dAbs3 < dAbs ? dAbs3 : dAbs;
    }

    public static void elementMult(DMatrix2x2 dMatrix2x2, DMatrix2x2 dMatrix2x22) {
        dMatrix2x2.a11 *= dMatrix2x22.a11;
        dMatrix2x2.a12 *= dMatrix2x22.a12;
        dMatrix2x2.a21 *= dMatrix2x22.a21;
        dMatrix2x2.a22 *= dMatrix2x22.a22;
    }

    public static void elementMult(DMatrix2 dMatrix2, DMatrix2 dMatrix22) {
        dMatrix2.f2397a1 *= dMatrix22.f2397a1;
        dMatrix2.f2398a2 *= dMatrix22.f2398a2;
    }

    public static void elementMult(DMatrix2x2 dMatrix2x2, DMatrix2x2 dMatrix2x22, DMatrix2x2 dMatrix2x23) {
        dMatrix2x23.a11 = dMatrix2x2.a11 * dMatrix2x22.a11;
        dMatrix2x23.a12 = dMatrix2x2.a12 * dMatrix2x22.a12;
        dMatrix2x23.a21 = dMatrix2x2.a21 * dMatrix2x22.a21;
        dMatrix2x23.a22 = dMatrix2x2.a22 * dMatrix2x22.a22;
    }

    public static void elementMult(DMatrix2 dMatrix2, DMatrix2 dMatrix22, DMatrix2 dMatrix23) {
        dMatrix23.f2397a1 = dMatrix2.f2397a1 * dMatrix22.f2397a1;
        dMatrix23.f2398a2 = dMatrix2.f2398a2 * dMatrix22.f2398a2;
    }

    public static void elementDiv(DMatrix2x2 dMatrix2x2, DMatrix2x2 dMatrix2x22) {
        dMatrix2x2.a11 /= dMatrix2x22.a11;
        dMatrix2x2.a12 /= dMatrix2x22.a12;
        dMatrix2x2.a21 /= dMatrix2x22.a21;
        dMatrix2x2.a22 /= dMatrix2x22.a22;
    }

    public static void elementDiv(DMatrix2 dMatrix2, DMatrix2 dMatrix22) {
        dMatrix2.f2397a1 /= dMatrix22.f2397a1;
        dMatrix2.f2398a2 /= dMatrix22.f2398a2;
    }

    public static void elementDiv(DMatrix2x2 dMatrix2x2, DMatrix2x2 dMatrix2x22, DMatrix2x2 dMatrix2x23) {
        dMatrix2x23.a11 = dMatrix2x2.a11 / dMatrix2x22.a11;
        dMatrix2x23.a12 = dMatrix2x2.a12 / dMatrix2x22.a12;
        dMatrix2x23.a21 = dMatrix2x2.a21 / dMatrix2x22.a21;
        dMatrix2x23.a22 = dMatrix2x2.a22 / dMatrix2x22.a22;
    }

    public static void elementDiv(DMatrix2 dMatrix2, DMatrix2 dMatrix22, DMatrix2 dMatrix23) {
        dMatrix23.f2397a1 = dMatrix2.f2397a1 / dMatrix22.f2397a1;
        dMatrix23.f2398a2 = dMatrix2.f2398a2 / dMatrix22.f2398a2;
    }

    public static void scale(double d, DMatrix2x2 dMatrix2x2) {
        dMatrix2x2.a11 *= d;
        dMatrix2x2.a12 *= d;
        dMatrix2x2.a21 *= d;
        dMatrix2x2.a22 *= d;
    }

    public static void scale(double d, DMatrix2 dMatrix2) {
        dMatrix2.f2397a1 *= d;
        dMatrix2.f2398a2 *= d;
    }

    public static void scale(double d, DMatrix2x2 dMatrix2x2, DMatrix2x2 dMatrix2x22) {
        dMatrix2x22.a11 = dMatrix2x2.a11 * d;
        dMatrix2x22.a12 = dMatrix2x2.a12 * d;
        dMatrix2x22.a21 = dMatrix2x2.a21 * d;
        dMatrix2x22.a22 = dMatrix2x2.a22 * d;
    }

    public static void scale(double d, DMatrix2 dMatrix2, DMatrix2 dMatrix22) {
        dMatrix22.f2397a1 = dMatrix2.f2397a1 * d;
        dMatrix22.f2398a2 = dMatrix2.f2398a2 * d;
    }

    public static void divide(DMatrix2x2 dMatrix2x2, double d) {
        dMatrix2x2.a11 /= d;
        dMatrix2x2.a12 /= d;
        dMatrix2x2.a21 /= d;
        dMatrix2x2.a22 /= d;
    }

    public static void divide(DMatrix2 dMatrix2, double d) {
        dMatrix2.f2397a1 /= d;
        dMatrix2.f2398a2 /= d;
    }

    public static void divide(DMatrix2x2 dMatrix2x2, double d, DMatrix2x2 dMatrix2x22) {
        dMatrix2x22.a11 = dMatrix2x2.a11 / d;
        dMatrix2x22.a12 = dMatrix2x2.a12 / d;
        dMatrix2x22.a21 = dMatrix2x2.a21 / d;
        dMatrix2x22.a22 = dMatrix2x2.a22 / d;
    }

    public static void divide(DMatrix2 dMatrix2, double d, DMatrix2 dMatrix22) {
        dMatrix22.f2397a1 = dMatrix2.f2397a1 / d;
        dMatrix22.f2398a2 = dMatrix2.f2398a2 / d;
    }

    public static void changeSign(DMatrix2x2 dMatrix2x2) {
        dMatrix2x2.a11 = -dMatrix2x2.a11;
        dMatrix2x2.a12 = -dMatrix2x2.a12;
        dMatrix2x2.a21 = -dMatrix2x2.a21;
        dMatrix2x2.a22 = -dMatrix2x2.a22;
    }

    public static void changeSign(DMatrix2 dMatrix2) {
        dMatrix2.f2397a1 = -dMatrix2.f2397a1;
        dMatrix2.f2398a2 = -dMatrix2.f2398a2;
    }

    public static void fill(DMatrix2x2 dMatrix2x2, double d) {
        dMatrix2x2.a11 = d;
        dMatrix2x2.a12 = d;
        dMatrix2x2.a21 = d;
        dMatrix2x2.a22 = d;
    }

    public static void fill(DMatrix2 dMatrix2, double d) {
        dMatrix2.f2397a1 = d;
        dMatrix2.f2398a2 = d;
    }

    public static DMatrix2 extractRow(DMatrix2x2 dMatrix2x2, int i, DMatrix2 dMatrix2) {
        if (dMatrix2 == null) {
            dMatrix2 = new DMatrix2();
        }
        if (i == 0) {
            dMatrix2.f2397a1 = dMatrix2x2.a11;
            dMatrix2.f2398a2 = dMatrix2x2.a12;
            return dMatrix2;
        }
        if (i == 1) {
            dMatrix2.f2397a1 = dMatrix2x2.a21;
            dMatrix2.f2398a2 = dMatrix2x2.a22;
            return dMatrix2;
        }
        throw new IllegalArgumentException("Out of bounds row.  row = " + i);
    }

    public static DMatrix2 extractColumn(DMatrix2x2 dMatrix2x2, int i, DMatrix2 dMatrix2) {
        if (dMatrix2 == null) {
            dMatrix2 = new DMatrix2();
        }
        if (i == 0) {
            dMatrix2.f2397a1 = dMatrix2x2.a11;
            dMatrix2.f2398a2 = dMatrix2x2.a21;
            return dMatrix2;
        }
        if (i == 1) {
            dMatrix2.f2397a1 = dMatrix2x2.a12;
            dMatrix2.f2398a2 = dMatrix2x2.a22;
            return dMatrix2;
        }
        throw new IllegalArgumentException("Out of bounds column.  column = " + i);
    }
}
