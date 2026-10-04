package org.ejml.dense.block.decomposition.p045qr;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DSubmatrixD1;
import org.ejml.dense.block.InnerMultiplication_DDRB;
import org.ejml.dense.block.VectorOps_DDRB;

/* JADX INFO: loaded from: classes9.dex */
public class BlockHouseHolder_DDRB {
    public static boolean decomposeQR_block_col(int i, DSubmatrixD1 dSubmatrixD1, double[] dArr) {
        int iMin = Math.min(dSubmatrixD1.col1 - dSubmatrixD1.col0, dSubmatrixD1.row1 - dSubmatrixD1.row0);
        for (int i2 = 0; i2 < iMin; i2++) {
            if (!computeHouseHolderCol(i, dSubmatrixD1, dArr, i2)) {
                return false;
            }
            rank1UpdateMultR_Col(i, dSubmatrixD1, i2, dArr[dSubmatrixD1.col0 + i2]);
        }
        return true;
    }

    public static boolean computeHouseHolderCol(int i, DSubmatrixD1 dSubmatrixD1, double[] dArr, int i2) {
        double dFindMaxCol = findMaxCol(i, dSubmatrixD1, i2);
        if (dFindMaxCol == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return false;
        }
        double dComputeTauAndDivideCol = computeTauAndDivideCol(i, dSubmatrixD1, i2, dFindMaxCol);
        double d = dSubmatrixD1.get(i2, i2) + dComputeTauAndDivideCol;
        divideElementsCol(i, dSubmatrixD1, i2, d);
        dArr[dSubmatrixD1.col0 + i2] = d / dComputeTauAndDivideCol;
        dSubmatrixD1.set(i2, i2, -(dComputeTauAndDivideCol * dFindMaxCol));
        return true;
    }

    public static boolean computeHouseHolderRow(int i, DSubmatrixD1 dSubmatrixD1, double[] dArr, int i2) {
        int i3 = i2 + 1;
        double dFindMaxRow = findMaxRow(i, dSubmatrixD1, i2, i3);
        if (dFindMaxRow == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return false;
        }
        double dComputeTauAndDivideRow = computeTauAndDivideRow(i, dSubmatrixD1, i2, i3, dFindMaxRow);
        double d = dSubmatrixD1.get(i2, i3) + dComputeTauAndDivideRow;
        VectorOps_DDRB.div_row(i, dSubmatrixD1, i2, d, dSubmatrixD1, i2, i3, dSubmatrixD1.col1 - dSubmatrixD1.col0);
        dArr[dSubmatrixD1.row0 + i2] = d / dComputeTauAndDivideRow;
        dSubmatrixD1.set(i2, i3, (-dComputeTauAndDivideRow) * dFindMaxRow);
        return true;
    }

    public static void rank1UpdateMultR_Col(int i, DSubmatrixD1 dSubmatrixD1, int i2, double d) {
        int iMin = Math.min(i, dSubmatrixD1.col1 - dSubmatrixD1.col0);
        double[] dArr = dSubmatrixD1.original.data;
        int i3 = i2 + 1;
        for (int i4 = i3; i4 < iMin; i4++) {
            double dInnerProdCol = innerProdCol(i, dSubmatrixD1, i2, iMin, i4, iMin) * d;
            int i5 = dSubmatrixD1.row0;
            while (i5 < dSubmatrixD1.row1) {
                int iMin2 = Math.min(i, dSubmatrixD1.row1 - i5);
                int i6 = (dSubmatrixD1.original.numCols * i5) + (dSubmatrixD1.col0 * iMin2) + i2;
                int i7 = (dSubmatrixD1.original.numCols * i5) + (dSubmatrixD1.col0 * iMin2) + i4;
                if (i5 == dSubmatrixD1.row0) {
                    int i8 = i6 + (iMin * i3);
                    int i9 = i7 + (iMin * i2);
                    dArr[i9] = dArr[i9] - dInnerProdCol;
                    int i10 = i9 + iMin;
                    int i11 = i3;
                    while (i11 < iMin2) {
                        dArr[i10] = dArr[i10] - (dArr[i8] * dInnerProdCol);
                        i11++;
                        i8 += iMin;
                        i10 += iMin;
                    }
                } else {
                    int i12 = (iMin2 * iMin) + i6;
                    while (i6 != i12) {
                        dArr[i7] = dArr[i7] - (dArr[i6] * dInnerProdCol);
                        i6 += iMin;
                        i7 += iMin;
                    }
                }
                i5 += i;
            }
        }
    }

    public static void rank1UpdateMultR_TopRow(int i, DSubmatrixD1 dSubmatrixD1, int i2, double d) {
        double[] dArr = dSubmatrixD1.original.data;
        int iMin = Math.min(i, dSubmatrixD1.col1 - i2);
        int i3 = dSubmatrixD1.col0 + i;
        while (i3 < dSubmatrixD1.col1) {
            int iMin2 = Math.min(i, dSubmatrixD1.col1 - i3);
            for (int i4 = 0; i4 < iMin2; i4++) {
                double dInnerProdCol = innerProdCol(i, dSubmatrixD1, i2, iMin, (i3 - dSubmatrixD1.col0) + i4, iMin2) * d;
                int i5 = dSubmatrixD1.row0;
                int iMin3 = Math.min(i, dSubmatrixD1.row1 - i5);
                int i6 = i2 + 1;
                int i7 = (dSubmatrixD1.original.numCols * i5) + (dSubmatrixD1.col0 * iMin3) + i2 + (iMin * i6);
                int i8 = (i5 * dSubmatrixD1.original.numCols) + (iMin3 * i3) + i4 + (iMin2 * i2);
                dArr[i8] = dArr[i8] - dInnerProdCol;
                while (true) {
                    i8 += iMin2;
                    if (i6 < iMin3) {
                        dArr[i8] = dArr[i8] - (dArr[i7] * dInnerProdCol);
                        i6++;
                        i7 += iMin;
                    }
                }
            }
            i3 += i;
        }
    }

    public static void rank1UpdateMultL_Row(int i, DSubmatrixD1 dSubmatrixD1, int i2, int i3, double d) {
        int iMin = Math.min(i, dSubmatrixD1.row1 - dSubmatrixD1.row0);
        double[] dArr = dSubmatrixD1.original.data;
        int i4 = i3 - i2;
        for (int i5 = i2 + 1; i5 < iMin; i5++) {
            double dInnerProdRow = innerProdRow(i, dSubmatrixD1, i2, dSubmatrixD1, i5, i4) * d;
            int i6 = dSubmatrixD1.col0;
            while (i6 < dSubmatrixD1.col1) {
                int iMin2 = Math.min(i, dSubmatrixD1.col1 - i6);
                int i7 = iMin * i6;
                int i8 = (dSubmatrixD1.row0 * dSubmatrixD1.original.numCols) + i7 + (i2 * iMin2);
                int i9 = (dSubmatrixD1.row0 * dSubmatrixD1.original.numCols) + i7 + (i5 * iMin2);
                if (i6 == dSubmatrixD1.col0) {
                    int i10 = i3 + 1;
                    int i11 = i8 + i10;
                    int i12 = i9 + i3;
                    int i13 = i12 + 1;
                    dArr[i12] = dArr[i12] - dInnerProdRow;
                    while (i10 < iMin2) {
                        dArr[i13] = dArr[i13] - (dArr[i11] * dInnerProdRow);
                        i10++;
                        i13++;
                        i11++;
                    }
                } else {
                    int i14 = 0;
                    while (i14 < iMin2) {
                        dArr[i9] = dArr[i9] - (dArr[i8] * dInnerProdRow);
                        i14++;
                        i9++;
                        i8++;
                    }
                }
                i6 += i;
            }
        }
    }

    public static void rank1UpdateMultL_LeftCol(int i, DSubmatrixD1 dSubmatrixD1, int i2, double d, int i3) {
        int i4 = i;
        int iMin = Math.min(i4, dSubmatrixD1.row1 - dSubmatrixD1.row0);
        int iMin2 = Math.min(i4, dSubmatrixD1.col1 - dSubmatrixD1.col0);
        double[] dArr = dSubmatrixD1.original.data;
        int i5 = dSubmatrixD1.row0 + i4;
        while (i5 < dSubmatrixD1.row1) {
            int iMin3 = Math.min(i4, dSubmatrixD1.row1 - i5);
            int i6 = 0;
            while (i6 < iMin3) {
                double dInnerProdRow = innerProdRow(i4, dSubmatrixD1, i2, dSubmatrixD1, i6 + (i5 - dSubmatrixD1.row0), i3) * d;
                int i7 = i3 + 1;
                int i8 = (dSubmatrixD1.row0 * dSubmatrixD1.original.numCols) + (dSubmatrixD1.col0 * iMin) + (i2 * iMin2) + i7;
                int i9 = (dSubmatrixD1.original.numCols * i5) + (dSubmatrixD1.col0 * iMin3) + (i6 * iMin2) + i3;
                int i10 = i9 + 1;
                dArr[i9] = dArr[i9] - dInnerProdRow;
                while (i7 < iMin2) {
                    dArr[i10] = dArr[i10] - (dArr[i8] * dInnerProdRow);
                    i7++;
                    i10++;
                    i8++;
                }
                i6++;
                i4 = i;
            }
            i5 += i;
            i4 = i;
        }
    }

    public static double innerProdCol(int i, DSubmatrixD1 dSubmatrixD1, int i2, int i3, int i4, int i5) {
        double[] dArr = dSubmatrixD1.original.data;
        int i6 = i2 % i;
        int i7 = (dSubmatrixD1.col0 + i2) - i6;
        int i8 = i4 % i;
        int i9 = (dSubmatrixD1.col0 + i4) - i8;
        int i10 = dSubmatrixD1.row0;
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        while (i10 < dSubmatrixD1.row1) {
            int iMin = Math.min(i, dSubmatrixD1.row1 - i10);
            int i11 = (dSubmatrixD1.original.numCols * i10) + (iMin * i7) + i6;
            int i12 = (dSubmatrixD1.original.numCols * i10) + (iMin * i9) + i8;
            if (i10 == dSubmatrixD1.row0) {
                int i13 = i11 + ((i6 + 1) * i3);
                int i14 = i12 + (i5 * i6);
                d = dArr[i14];
                int i15 = i14 + i5;
                int i16 = (((iMin - i6) - 1) * i3) + i13;
                while (i13 != i16) {
                    d += dArr[i13] * dArr[i15];
                    i13 += i3;
                    i15 += i5;
                }
            } else {
                int i17 = (iMin * i3) + i11;
                while (i11 != i17) {
                    d += dArr[i11] * dArr[i12];
                    i11 += i3;
                    i12 += i5;
                }
            }
            i10 += i;
        }
        return d;
    }

    public static double innerProdRow(int i, DSubmatrixD1 dSubmatrixD1, int i2, DSubmatrixD1 dSubmatrixD12, int i3, int i4) {
        int i5 = i4 + i2;
        return dSubmatrixD12.col0 + i5 >= dSubmatrixD12.col1 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : dSubmatrixD12.get(i3, i5) + VectorOps_DDRB.dot_row(i, dSubmatrixD1, i2, dSubmatrixD12, i3, i5 + 1, dSubmatrixD1.col1 - dSubmatrixD1.col0);
    }

    public static void add_row(int i, DSubmatrixD1 dSubmatrixD1, int i2, double d, DSubmatrixD1 dSubmatrixD12, int i3, double d2, DSubmatrixD1 dSubmatrixD13, int i4, int i5, int i6) {
        int i7 = i2 + i5;
        if (dSubmatrixD13.col0 + i7 >= dSubmatrixD13.col1) {
            return;
        }
        dSubmatrixD13.set(i4, i7, d + (dSubmatrixD12.get(i3, i7) * d2));
        VectorOps_DDRB.add_row(i, dSubmatrixD1, i2, d, dSubmatrixD12, i3, d2, dSubmatrixD13, i4, i7 + 1, i6);
    }

    public static void divideElementsCol(int i, DSubmatrixD1 dSubmatrixD1, int i2, double d) {
        int iMin = Math.min(i, dSubmatrixD1.col1 - dSubmatrixD1.col0);
        double[] dArr = dSubmatrixD1.original.data;
        int i3 = dSubmatrixD1.row0;
        while (i3 < dSubmatrixD1.row1) {
            int iMin2 = Math.min(i, dSubmatrixD1.row1 - i3);
            int i4 = (dSubmatrixD1.original.numCols * i3) + (dSubmatrixD1.col0 * iMin2) + i2;
            if (i3 == dSubmatrixD1.row0) {
                int i5 = i2 + 1;
                int i6 = i4 + (iMin * i5);
                while (i5 < iMin2) {
                    dArr[i6] = dArr[i6] / d;
                    i5++;
                    i6 += iMin;
                }
            } else {
                int i7 = (iMin2 * iMin) + i4;
                while (i4 != i7) {
                    dArr[i4] = dArr[i4] / d;
                    i4 += iMin;
                }
            }
            i3 += i;
        }
    }

    public static void scale_row(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, int i2, int i3, double d) {
        int i4 = i2 + i3;
        if (i4 >= dSubmatrixD12.col1 - dSubmatrixD12.col0) {
            return;
        }
        dSubmatrixD12.set(i2, i4, d);
        VectorOps_DDRB.scale_row(i, dSubmatrixD1, i2, d, dSubmatrixD12, i2, i4 + 1, dSubmatrixD1.col1 - dSubmatrixD1.col0);
    }

    public static double computeTauAndDivideCol(int i, DSubmatrixD1 dSubmatrixD1, int i2, double d) {
        int iMin = Math.min(i, dSubmatrixD1.col1 - dSubmatrixD1.col0);
        double[] dArr = dSubmatrixD1.original.data;
        int i3 = dSubmatrixD1.row0;
        double d2 = 0.0d;
        double d3 = 0.0d;
        while (i3 < dSubmatrixD1.row1) {
            int iMin2 = Math.min(i, dSubmatrixD1.row1 - i3);
            int i4 = (dSubmatrixD1.original.numCols * i3) + (dSubmatrixD1.col0 * iMin2) + i2;
            if (i3 == dSubmatrixD1.row0) {
                int i5 = i4 + (iMin * i2);
                d3 = dArr[i5] / d;
                dArr[i5] = d3;
                d2 += d3 * d3;
                int i6 = i5 + iMin;
                int i7 = i2 + 1;
                while (i7 < iMin2) {
                    double d4 = dArr[i6] / d;
                    dArr[i6] = d4;
                    d2 += d4 * d4;
                    i7++;
                    i6 += iMin;
                }
            } else {
                int i8 = 0;
                while (i8 < iMin2) {
                    double d5 = dArr[i4] / d;
                    dArr[i4] = d5;
                    d2 += d5 * d5;
                    i8++;
                    i4 += iMin;
                }
            }
            i3 += i;
        }
        double dSqrt = Math.sqrt(d2);
        return d3 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? -dSqrt : dSqrt;
    }

    public static double computeTauAndDivideRow(int i, DSubmatrixD1 dSubmatrixD1, int i2, int i3, double d) {
        int iMin = Math.min(i, dSubmatrixD1.row1 - dSubmatrixD1.row0);
        double[] dArr = dSubmatrixD1.original.data;
        int i4 = i3 % i;
        int i5 = (dSubmatrixD1.col0 + i3) - i4;
        int i6 = i5;
        double d2 = 0.0d;
        double d3 = 0.0d;
        while (i6 < dSubmatrixD1.col1) {
            int iMin2 = Math.min(i, dSubmatrixD1.col1 - i6);
            int i7 = (dSubmatrixD1.row0 * dSubmatrixD1.original.numCols) + (iMin * i6) + (i2 * iMin2);
            if (i6 == i5) {
                int i8 = i7 + i4;
                d3 = dArr[i8] / d;
                dArr[i8] = d3;
                d2 += d3 * d3;
                int i9 = i8 + 1;
                int i10 = i4 + 1;
                while (i10 < iMin2) {
                    double d4 = dArr[i9] / d;
                    dArr[i9] = d4;
                    d2 += d4 * d4;
                    i10++;
                    i9++;
                }
            } else {
                int i11 = 0;
                while (i11 < iMin2) {
                    double d5 = dArr[i7] / d;
                    dArr[i7] = d5;
                    d2 += d5 * d5;
                    i11++;
                    i7++;
                }
            }
            i6 += i;
        }
        double dSqrt = Math.sqrt(d2);
        return d3 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? -dSqrt : dSqrt;
    }

    public static double findMaxCol(int i, DSubmatrixD1 dSubmatrixD1, int i2) {
        int iMin = Math.min(i, dSubmatrixD1.col1 - dSubmatrixD1.col0);
        double[] dArr = dSubmatrixD1.original.data;
        int i3 = dSubmatrixD1.row0;
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        while (i3 < dSubmatrixD1.row1) {
            int iMin2 = Math.min(i, dSubmatrixD1.row1 - i3);
            int i4 = (dSubmatrixD1.original.numCols * i3) + (dSubmatrixD1.col0 * iMin2) + i2;
            if (i3 == dSubmatrixD1.row0) {
                int i5 = i4 + (iMin * i2);
                int i6 = i2;
                while (i6 < iMin2) {
                    double dAbs = Math.abs(dArr[i5]);
                    if (dAbs > d) {
                        d = dAbs;
                    }
                    i6++;
                    i5 += iMin;
                }
            } else {
                int i7 = 0;
                while (i7 < iMin2) {
                    double dAbs2 = Math.abs(dArr[i4]);
                    if (dAbs2 > d) {
                        d = dAbs2;
                    }
                    i7++;
                    i4 += iMin;
                }
            }
            i3 += i;
        }
        return d;
    }

    public static double findMaxRow(int i, DSubmatrixD1 dSubmatrixD1, int i2, int i3) {
        int iMin = Math.min(i, dSubmatrixD1.row1 - dSubmatrixD1.row0);
        double[] dArr = dSubmatrixD1.original.data;
        int i4 = dSubmatrixD1.col0;
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        while (i4 < dSubmatrixD1.col1) {
            int iMin2 = Math.min(i, dSubmatrixD1.col1 - i4);
            int i5 = (dSubmatrixD1.row0 * dSubmatrixD1.original.numCols) + (iMin * i4) + (i2 * iMin2);
            if (i4 == dSubmatrixD1.col0) {
                int i6 = i5 + i3;
                int i7 = i3;
                while (i7 < iMin2) {
                    int i8 = i6 + 1;
                    double dAbs = Math.abs(dArr[i6]);
                    if (dAbs > d) {
                        d = dAbs;
                    }
                    i7++;
                    i6 = i8;
                }
            } else {
                int i9 = 0;
                while (i9 < iMin2) {
                    int i10 = i5 + 1;
                    double dAbs2 = Math.abs(dArr[i5]);
                    if (dAbs2 > d) {
                        d = dAbs2;
                    }
                    i9++;
                    i5 = i10;
                }
            }
            i4 += i;
        }
        return d;
    }

    public static void computeW_Column(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, double[] dArr, double[] dArr2, int i2) {
        int i3 = dSubmatrixD12.col1 - dSubmatrixD12.col0;
        int i4 = i2 + 1;
        initializeW(i, dSubmatrixD12, dSubmatrixD1, i3, dArr2[i2]);
        int iMin = Math.min(i3, dSubmatrixD12.row1 - dSubmatrixD12.row0);
        int i5 = 1;
        while (i5 < iMin) {
            computeY_t_V(i, dSubmatrixD1, i5, dArr);
            computeZ(i, dSubmatrixD1, dSubmatrixD12, i5, dArr, dArr2[i4]);
            i5++;
            i4++;
        }
    }

    public static void initializeW(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, int i2, double d) {
        double[] dArr = dSubmatrixD1.original.data;
        double[] dArr2 = dSubmatrixD12.original.data;
        int i3 = dSubmatrixD1.row0;
        while (i3 < dSubmatrixD1.row1) {
            int iMin = Math.min(i, dSubmatrixD1.row1 - i3);
            int i4 = (dSubmatrixD1.original.numCols * i3) + (dSubmatrixD1.col0 * iMin);
            int i5 = (dSubmatrixD12.original.numCols * i3) + (dSubmatrixD12.col0 * iMin);
            if (i3 == dSubmatrixD1.row0) {
                double d2 = -d;
                dArr[i4] = d2;
                int i6 = i4 + i2;
                int i7 = i5 + i2;
                int i8 = 1;
                while (i8 < iMin) {
                    dArr[i6] = dArr2[i7] * d2;
                    i8++;
                    i6 += i2;
                    i7 += i2;
                }
            } else {
                int i9 = 0;
                while (i9 < iMin) {
                    dArr[i4] = (-d) * dArr2[i5];
                    i9++;
                    i4 += i2;
                    i5 += i2;
                }
            }
            i3 += i;
        }
    }

    public static void computeZ(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, int i2, double[] dArr, double d) {
        int i3 = i;
        int i4 = dSubmatrixD1.col1 - dSubmatrixD1.col0;
        double[] dArr2 = dSubmatrixD12.original.data;
        double[] dArr3 = dSubmatrixD1.original.data;
        int i5 = dSubmatrixD12.original.numCols;
        double d2 = -d;
        int i6 = dSubmatrixD1.row0;
        while (i6 < dSubmatrixD1.row1) {
            int iMin = Math.min(i3, dSubmatrixD1.row1 - i6);
            int i7 = i6 * i5;
            int i8 = (dSubmatrixD12.col0 * iMin) + i7;
            int i9 = i7 + (dSubmatrixD12.col0 * iMin) + i2;
            int i10 = (dSubmatrixD1.original.numCols * i6) + (dSubmatrixD1.col0 * iMin) + i2;
            if (i6 == dSubmatrixD1.row0) {
                int i11 = 0;
                while (i11 < iMin) {
                    double d3 = 0.0d;
                    for (int i12 = 0; i12 < i2; i12++) {
                        d3 += dArr2[i8 + i12] * dArr[i12];
                    }
                    if (i11 < i2) {
                        dArr2[i9] = d3 * d2;
                    } else if (i11 == i2) {
                        dArr2[i9] = (d3 + 1.0d) * d2;
                    } else {
                        dArr2[i9] = (dArr3[i10] + d3) * d2;
                    }
                    i11++;
                    i9 += i4;
                    i8 += i4;
                    i10 += i4;
                }
            } else {
                int i13 = (iMin * i4) + i9;
                while (i9 != i13) {
                    double d4 = 0.0d;
                    for (int i14 = 0; i14 < i2; i14++) {
                        d4 += dArr2[i8 + i14] * dArr[i14];
                    }
                    dArr2[i9] = (dArr3[i10] + d4) * d2;
                    i9 += i4;
                    i8 += i4;
                    i10 += i4;
                }
            }
            i6 += i;
            i3 = i;
        }
    }

    public static void computeY_t_V(int i, DSubmatrixD1 dSubmatrixD1, int i2, double[] dArr) {
        int i3 = dSubmatrixD1.col1 - dSubmatrixD1.col0;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = i;
            DSubmatrixD1 dSubmatrixD12 = dSubmatrixD1;
            dArr[i4] = innerProdCol(i5, dSubmatrixD12, i2, i3, i4, i3);
            i4++;
            i = i5;
            dSubmatrixD1 = dSubmatrixD12;
        }
    }

    public static void multAdd_zeros(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, DSubmatrixD1 dSubmatrixD13) {
        int i2 = dSubmatrixD1.col1 - dSubmatrixD1.col0;
        int i3 = dSubmatrixD1.row0;
        while (i3 < dSubmatrixD1.row1) {
            int iMin = Math.min(i, dSubmatrixD1.row1 - i3);
            int i4 = dSubmatrixD12.col0;
            while (i4 < dSubmatrixD12.col1) {
                int iMin2 = Math.min(i, dSubmatrixD12.col1 - i4);
                int i5 = (((i3 - dSubmatrixD1.row0) + dSubmatrixD13.row0) * dSubmatrixD13.original.numCols) + (((i4 - dSubmatrixD12.col0) + dSubmatrixD13.col0) * iMin);
                int i6 = dSubmatrixD1.col0;
                while (i6 < dSubmatrixD1.col1) {
                    int i7 = (dSubmatrixD1.original.numCols * i3) + (i6 * iMin);
                    int i8 = (((i6 - dSubmatrixD1.col0) + dSubmatrixD12.row0) * dSubmatrixD12.original.numCols) + (i4 * i2);
                    if (i3 == dSubmatrixD1.row0) {
                        multBlockAdd_zerosone(dSubmatrixD1.original.data, dSubmatrixD12.original.data, dSubmatrixD13.original.data, i7, i8, i5, iMin, i2, iMin2);
                    } else {
                        InnerMultiplication_DDRB.blockMultPlus(dSubmatrixD1.original.data, dSubmatrixD12.original.data, dSubmatrixD13.original.data, i7, i8, i5, iMin, i2, iMin2);
                    }
                    i6 += i;
                }
                i4 += i;
            }
            i3 += i;
        }
    }

    public static void multBlockAdd_zerosone(double[] dArr, double[] dArr2, double[] dArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        while (i7 < i4) {
            for (int i8 = 0; i8 < i6; i8++) {
                double d = i7 < i5 ? dArr2[(i7 * i6) + i8 + i2] : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int iMin = Math.min(i7, i5);
                for (int i9 = 0; i9 < iMin; i9++) {
                    d += dArr[(i7 * i5) + i9 + i] * dArr2[(i9 * i6) + i8 + i2];
                }
                int i10 = (i7 * i6) + i8 + i3;
                dArr3[i10] = dArr3[i10] + d;
            }
            i7++;
        }
    }

    public static void multTransA_vecCol(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, DSubmatrixD1 dSubmatrixD13) {
        int i2 = dSubmatrixD1.col1 - dSubmatrixD1.col0;
        if (i2 > i) {
            throw new IllegalArgumentException("A is expected to be at most one block wide.");
        }
        int i3 = dSubmatrixD12.col0;
        while (i3 < dSubmatrixD12.col1) {
            int iMin = Math.min(i, dSubmatrixD12.col1 - i3);
            int i4 = (dSubmatrixD13.row0 * dSubmatrixD13.original.numCols) + (((i3 - dSubmatrixD12.col0) + dSubmatrixD13.col0) * i2);
            int i5 = dSubmatrixD1.row0;
            while (i5 < dSubmatrixD1.row1) {
                int iMin2 = Math.min(i, dSubmatrixD1.row1 - i5);
                int i6 = (dSubmatrixD1.original.numCols * i5) + (dSubmatrixD1.col0 * iMin2);
                int i7 = (((i5 - dSubmatrixD1.row0) + dSubmatrixD12.row0) * dSubmatrixD12.original.numCols) + (i3 * iMin2);
                if (i5 == dSubmatrixD1.row0) {
                    multTransABlockSet_lowerTriag(dSubmatrixD1.original.data, dSubmatrixD12.original.data, dSubmatrixD13.original.data, i6, i7, i4, iMin2, i2, iMin);
                } else {
                    InnerMultiplication_DDRB.blockMultPlusTransA(dSubmatrixD1.original.data, dSubmatrixD12.original.data, dSubmatrixD13.original.data, i6, i7, i4, iMin2, i2, iMin);
                }
                i5 += i;
            }
            i3 += i;
        }
    }

    protected static void multTransABlockSet_lowerTriag(double[] dArr, double[] dArr2, double[] dArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        while (i7 < i5) {
            for (int i8 = 0; i8 < i6; i8++) {
                double d = i7 < i4 ? dArr2[(i7 * i6) + i8 + i2] : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i9 = i7 + 1; i9 < i4; i9++) {
                    d += dArr[(i9 * i5) + i7 + i] * dArr2[(i9 * i6) + i8 + i2];
                }
                dArr3[(i7 * i6) + i8 + i3] = d;
            }
            i7++;
        }
    }
}
