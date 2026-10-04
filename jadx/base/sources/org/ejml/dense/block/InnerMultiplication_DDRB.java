package org.ejml.dense.block;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX INFO: loaded from: classes9.dex */
public class InnerMultiplication_DDRB {
    public static void blockMultPlus(double[] dArr, double[] dArr2, double[] dArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i3;
        int i8 = 0;
        int i9 = i;
        while (i8 < i4) {
            int i10 = i7 + i6;
            int i11 = i9 + i5;
            int i12 = i2;
            while (i9 != i11) {
                int i13 = i9 + 1;
                double d = dArr[i9];
                int i14 = i7;
                while (i14 != i10) {
                    dArr3[i14] = dArr3[i14] + (dArr2[i12] * d);
                    i14++;
                    i12++;
                }
                i9 = i13;
            }
            i8++;
            i7 = i10;
        }
    }

    public static void blockMultPlusTransA(double[] dArr, double[] dArr2, double[] dArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        int i8 = i3;
        while (i7 < i5) {
            int i9 = i7 + i;
            int i10 = (i5 * i4) + i9;
            int i11 = i2;
            while (i9 != i10) {
                double d = dArr[i9];
                int i12 = i11 + i6;
                int i13 = i8;
                while (i11 != i12) {
                    dArr3[i13] = dArr3[i13] + (dArr2[i11] * d);
                    i13++;
                    i11++;
                }
                i9 += i5;
            }
            i7++;
            i8 += i6;
        }
    }

    public static void blockMultPlusTransB(double[] dArr, double[] dArr2, double[] dArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i4; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i9 = 0; i9 < i5; i9++) {
                    d += dArr[(i7 * i5) + i9 + i] * dArr2[(i8 * i5) + i9 + i2];
                }
                int i10 = (i7 * i6) + i8 + i3;
                dArr3[i10] = dArr3[i10] + d;
            }
        }
    }

    public static void blockMultMinus(double[] dArr, double[] dArr2, double[] dArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i3;
        int i8 = 0;
        int i9 = i;
        while (i8 < i4) {
            int i10 = i7 + i6;
            int i11 = i9 + i5;
            int i12 = i2;
            while (i9 != i11) {
                int i13 = i9 + 1;
                double d = dArr[i9];
                int i14 = i7;
                while (i14 != i10) {
                    dArr3[i14] = dArr3[i14] - (dArr2[i12] * d);
                    i14++;
                    i12++;
                }
                i9 = i13;
            }
            i8++;
            i7 = i10;
        }
    }

    public static void blockMultMinusTransA(double[] dArr, double[] dArr2, double[] dArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        int i8 = i3;
        while (i7 < i5) {
            int i9 = i7 + i;
            int i10 = (i5 * i4) + i9;
            int i11 = i2;
            while (i9 != i10) {
                double d = dArr[i9];
                int i12 = i11 + i6;
                int i13 = i8;
                while (i11 != i12) {
                    dArr3[i13] = dArr3[i13] - (dArr2[i11] * d);
                    i13++;
                    i11++;
                }
                i9 += i5;
            }
            i7++;
            i8 += i6;
        }
    }

    public static void blockMultMinusTransB(double[] dArr, double[] dArr2, double[] dArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i4; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i9 = 0; i9 < i5; i9++) {
                    d += dArr[(i7 * i5) + i9 + i] * dArr2[(i8 * i5) + i9 + i2];
                }
                int i10 = (i7 * i6) + i8 + i3;
                dArr3[i10] = dArr3[i10] - d;
            }
        }
    }

    public static void blockMultSet(double[] dArr, double[] dArr2, double[] dArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i3;
        int i8 = 0;
        int i9 = i;
        while (i8 < i4) {
            int i10 = i7 + i6;
            int i11 = i9 + i5;
            int i12 = i2;
            while (i9 != i11) {
                int i13 = i9 + 1;
                double d = dArr[i9];
                int i14 = i7;
                if (i12 == i2) {
                    while (i14 != i10) {
                        dArr3[i14] = dArr2[i12] * d;
                        i14++;
                        i12++;
                    }
                } else {
                    while (i14 != i10) {
                        dArr3[i14] = dArr3[i14] + (dArr2[i12] * d);
                        i14++;
                        i12++;
                    }
                }
                i9 = i13;
            }
            i8++;
            i7 = i10;
        }
    }

    public static void blockMultSetTransA(double[] dArr, double[] dArr2, double[] dArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        int i8 = i3;
        while (i7 < i5) {
            int i9 = i7 + i;
            int i10 = (i5 * i4) + i9;
            int i11 = i2;
            while (i9 != i10) {
                double d = dArr[i9];
                int i12 = i11 + i6;
                int i13 = i8;
                if (i11 == i2) {
                    while (i11 != i12) {
                        dArr3[i13] = dArr2[i11] * d;
                        i13++;
                        i11++;
                    }
                } else {
                    while (i11 != i12) {
                        dArr3[i13] = dArr3[i13] + (dArr2[i11] * d);
                        i13++;
                        i11++;
                    }
                }
                i9 += i5;
            }
            i7++;
            i8 += i6;
        }
    }

    public static void blockMultSetTransB(double[] dArr, double[] dArr2, double[] dArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i4; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i9 = 0; i9 < i5; i9++) {
                    d += dArr[(i7 * i5) + i9 + i] * dArr2[(i8 * i5) + i9 + i2];
                }
                dArr3[(i7 * i6) + i8 + i3] = d;
            }
        }
    }

    public static void blockMultPlus(double d, double[] dArr, double[] dArr2, double[] dArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i3;
        int i8 = 0;
        int i9 = i;
        while (i8 < i4) {
            int i10 = i7 + i6;
            int i11 = i9 + i5;
            int i12 = i2;
            while (i9 != i11) {
                int i13 = i9 + 1;
                double d2 = dArr[i9] * d;
                int i14 = i7;
                while (i14 != i10) {
                    dArr3[i14] = dArr3[i14] + (dArr2[i12] * d2);
                    i14++;
                    i12++;
                }
                i9 = i13;
            }
            i8++;
            i7 = i10;
        }
    }

    public static void blockMultPlusTransA(double d, double[] dArr, double[] dArr2, double[] dArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        int i8 = i3;
        while (i7 < i5) {
            int i9 = i7 + i;
            int i10 = (i5 * i4) + i9;
            int i11 = i2;
            while (i9 != i10) {
                double d2 = dArr[i9] * d;
                int i12 = i11 + i6;
                int i13 = i8;
                while (i11 != i12) {
                    dArr3[i13] = dArr3[i13] + (dArr2[i11] * d2);
                    i13++;
                    i11++;
                }
                i9 += i5;
            }
            i7++;
            i8 += i6;
        }
    }

    public static void blockMultPlusTransB(double d, double[] dArr, double[] dArr2, double[] dArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i4; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i9 = 0; i9 < i5; i9++) {
                    d2 += dArr[(i7 * i5) + i9 + i] * dArr2[(i8 * i5) + i9 + i2];
                }
                int i10 = (i7 * i6) + i8 + i3;
                dArr3[i10] = dArr3[i10] + (d2 * d);
            }
        }
    }

    public static void blockMultSet(double d, double[] dArr, double[] dArr2, double[] dArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i3;
        int i8 = 0;
        int i9 = i;
        while (i8 < i4) {
            int i10 = i7 + i6;
            int i11 = i9 + i5;
            int i12 = i2;
            while (i9 != i11) {
                int i13 = i9 + 1;
                double d2 = dArr[i9] * d;
                int i14 = i7;
                if (i12 == i2) {
                    while (i14 != i10) {
                        dArr3[i14] = dArr2[i12] * d2;
                        i14++;
                        i12++;
                    }
                } else {
                    while (i14 != i10) {
                        dArr3[i14] = dArr3[i14] + (dArr2[i12] * d2);
                        i14++;
                        i12++;
                    }
                }
                i9 = i13;
            }
            i8++;
            i7 = i10;
        }
    }

    public static void blockMultSetTransA(double d, double[] dArr, double[] dArr2, double[] dArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        int i8 = i3;
        while (i7 < i5) {
            int i9 = i7 + i;
            int i10 = (i5 * i4) + i9;
            int i11 = i2;
            while (i9 != i10) {
                double d2 = dArr[i9] * d;
                int i12 = i11 + i6;
                int i13 = i8;
                if (i11 == i2) {
                    while (i11 != i12) {
                        dArr3[i13] = dArr2[i11] * d2;
                        i13++;
                        i11++;
                    }
                } else {
                    while (i11 != i12) {
                        dArr3[i13] = dArr3[i13] + (dArr2[i11] * d2);
                        i13++;
                        i11++;
                    }
                }
                i9 += i5;
            }
            i7++;
            i8 += i6;
        }
    }

    public static void blockMultSetTransB(double d, double[] dArr, double[] dArr2, double[] dArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i4; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i9 = 0; i9 < i5; i9++) {
                    d2 += dArr[(i7 * i5) + i9 + i] * dArr2[(i8 * i5) + i9 + i2];
                }
                dArr3[(i7 * i6) + i8 + i3] = d2 * d;
            }
        }
    }
}
