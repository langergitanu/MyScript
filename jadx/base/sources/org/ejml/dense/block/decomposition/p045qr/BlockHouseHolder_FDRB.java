package org.ejml.dense.block.decomposition.p045qr;

import org.ejml.data.FSubmatrixD1;
import org.ejml.dense.block.InnerMultiplication_FDRB;
import org.ejml.dense.block.VectorOps_FDRB;

/* JADX INFO: loaded from: classes9.dex */
public class BlockHouseHolder_FDRB {
    public static boolean decomposeQR_block_col(int i, FSubmatrixD1 fSubmatrixD1, float[] fArr) {
        int iMin = Math.min(fSubmatrixD1.col1 - fSubmatrixD1.col0, fSubmatrixD1.row1 - fSubmatrixD1.row0);
        for (int i2 = 0; i2 < iMin; i2++) {
            if (!computeHouseHolderCol(i, fSubmatrixD1, fArr, i2)) {
                return false;
            }
            rank1UpdateMultR_Col(i, fSubmatrixD1, i2, fArr[fSubmatrixD1.col0 + i2]);
        }
        return true;
    }

    public static boolean computeHouseHolderCol(int i, FSubmatrixD1 fSubmatrixD1, float[] fArr, int i2) {
        float fFindMaxCol = findMaxCol(i, fSubmatrixD1, i2);
        if (fFindMaxCol == 0.0f) {
            return false;
        }
        float fComputeTauAndDivideCol = computeTauAndDivideCol(i, fSubmatrixD1, i2, fFindMaxCol);
        float f = fSubmatrixD1.get(i2, i2) + fComputeTauAndDivideCol;
        divideElementsCol(i, fSubmatrixD1, i2, f);
        fArr[fSubmatrixD1.col0 + i2] = f / fComputeTauAndDivideCol;
        fSubmatrixD1.set(i2, i2, -(fComputeTauAndDivideCol * fFindMaxCol));
        return true;
    }

    public static boolean computeHouseHolderRow(int i, FSubmatrixD1 fSubmatrixD1, float[] fArr, int i2) {
        int i3 = i2 + 1;
        float fFindMaxRow = findMaxRow(i, fSubmatrixD1, i2, i3);
        if (fFindMaxRow == 0.0f) {
            return false;
        }
        float fComputeTauAndDivideRow = computeTauAndDivideRow(i, fSubmatrixD1, i2, i3, fFindMaxRow);
        float f = fSubmatrixD1.get(i2, i3) + fComputeTauAndDivideRow;
        VectorOps_FDRB.div_row(i, fSubmatrixD1, i2, f, fSubmatrixD1, i2, i3, fSubmatrixD1.col1 - fSubmatrixD1.col0);
        fArr[fSubmatrixD1.row0 + i2] = f / fComputeTauAndDivideRow;
        fSubmatrixD1.set(i2, i3, (-fComputeTauAndDivideRow) * fFindMaxRow);
        return true;
    }

    public static void rank1UpdateMultR_Col(int i, FSubmatrixD1 fSubmatrixD1, int i2, float f) {
        int iMin = Math.min(i, fSubmatrixD1.col1 - fSubmatrixD1.col0);
        float[] fArr = fSubmatrixD1.original.data;
        int i3 = i2 + 1;
        int i4 = i3;
        while (i4 < iMin) {
            int i5 = i;
            FSubmatrixD1 fSubmatrixD12 = fSubmatrixD1;
            int i6 = i2;
            float fInnerProdCol = innerProdCol(i5, fSubmatrixD12, i6, iMin, i4, iMin) * f;
            for (int i7 = fSubmatrixD12.row0; i7 < fSubmatrixD12.row1; i7 += i5) {
                int iMin2 = Math.min(i5, fSubmatrixD12.row1 - i7);
                int i8 = (fSubmatrixD12.original.numCols * i7) + (fSubmatrixD12.col0 * iMin2) + i6;
                int i9 = (fSubmatrixD12.original.numCols * i7) + (fSubmatrixD12.col0 * iMin2) + i4;
                if (i7 == fSubmatrixD12.row0) {
                    int i10 = i8 + (iMin * i3);
                    int i11 = i9 + (iMin * i6);
                    fArr[i11] = fArr[i11] - fInnerProdCol;
                    int i12 = i11 + iMin;
                    int i13 = i3;
                    while (i13 < iMin2) {
                        fArr[i12] = fArr[i12] - (fArr[i10] * fInnerProdCol);
                        i13++;
                        i10 += iMin;
                        i12 += iMin;
                    }
                } else {
                    int i14 = (iMin2 * iMin) + i8;
                    while (i8 != i14) {
                        fArr[i9] = fArr[i9] - (fArr[i8] * fInnerProdCol);
                        i8 += iMin;
                        i9 += iMin;
                    }
                }
            }
            i4++;
            i = i5;
            fSubmatrixD1 = fSubmatrixD12;
            i2 = i6;
        }
    }

    public static void rank1UpdateMultR_TopRow(int i, FSubmatrixD1 fSubmatrixD1, int i2, float f) {
        float[] fArr = fSubmatrixD1.original.data;
        int iMin = Math.min(i, fSubmatrixD1.col1 - i2);
        for (int i3 = fSubmatrixD1.col0 + i; i3 < fSubmatrixD1.col1; i3 += i) {
            int iMin2 = Math.min(i, fSubmatrixD1.col1 - i3);
            int i4 = 0;
            while (i4 < iMin2) {
                int i5 = i;
                FSubmatrixD1 fSubmatrixD12 = fSubmatrixD1;
                int i6 = i2;
                float fInnerProdCol = innerProdCol(i5, fSubmatrixD12, i6, iMin, (i3 - fSubmatrixD1.col0) + i4, iMin2) * f;
                int i7 = fSubmatrixD12.row0;
                int iMin3 = Math.min(i5, fSubmatrixD12.row1 - i7);
                int i8 = i6 + 1;
                int i9 = (fSubmatrixD12.original.numCols * i7) + (fSubmatrixD12.col0 * iMin3) + i6 + (iMin * i8);
                int i10 = (i7 * fSubmatrixD12.original.numCols) + (iMin3 * i3) + i4 + (iMin2 * i6);
                fArr[i10] = fArr[i10] - fInnerProdCol;
                while (true) {
                    i10 += iMin2;
                    if (i8 < iMin3) {
                        fArr[i10] = fArr[i10] - (fArr[i9] * fInnerProdCol);
                        i8++;
                        i9 += iMin;
                    }
                }
                i4++;
                i = i5;
                fSubmatrixD1 = fSubmatrixD12;
                i2 = i6;
            }
        }
    }

    public static void rank1UpdateMultL_Row(int i, FSubmatrixD1 fSubmatrixD1, int i2, int i3, float f) {
        int iMin = Math.min(i, fSubmatrixD1.row1 - fSubmatrixD1.row0);
        float[] fArr = fSubmatrixD1.original.data;
        int i4 = i3 - i2;
        for (int i5 = i2 + 1; i5 < iMin; i5++) {
            float fInnerProdRow = innerProdRow(i, fSubmatrixD1, i2, fSubmatrixD1, i5, i4) * f;
            int i6 = fSubmatrixD1.col0;
            while (i6 < fSubmatrixD1.col1) {
                int iMin2 = Math.min(i, fSubmatrixD1.col1 - i6);
                int i7 = iMin * i6;
                int i8 = (fSubmatrixD1.row0 * fSubmatrixD1.original.numCols) + i7 + (i2 * iMin2);
                int i9 = (fSubmatrixD1.row0 * fSubmatrixD1.original.numCols) + i7 + (i5 * iMin2);
                if (i6 == fSubmatrixD1.col0) {
                    int i10 = i3 + 1;
                    int i11 = i8 + i10;
                    int i12 = i9 + i3;
                    int i13 = i12 + 1;
                    fArr[i12] = fArr[i12] - fInnerProdRow;
                    while (i10 < iMin2) {
                        fArr[i13] = fArr[i13] - (fArr[i11] * fInnerProdRow);
                        i10++;
                        i13++;
                        i11++;
                    }
                } else {
                    int i14 = 0;
                    while (i14 < iMin2) {
                        fArr[i9] = fArr[i9] - (fArr[i8] * fInnerProdRow);
                        i14++;
                        i9++;
                        i8++;
                    }
                }
                i6 += i;
            }
        }
    }

    public static void rank1UpdateMultL_LeftCol(int i, FSubmatrixD1 fSubmatrixD1, int i2, float f, int i3) {
        int iMin = Math.min(i, fSubmatrixD1.row1 - fSubmatrixD1.row0);
        int iMin2 = Math.min(i, fSubmatrixD1.col1 - fSubmatrixD1.col0);
        float[] fArr = fSubmatrixD1.original.data;
        int i4 = fSubmatrixD1.row0;
        while (true) {
            i4 += i;
            if (i4 >= fSubmatrixD1.row1) {
                return;
            }
            int iMin3 = Math.min(i, fSubmatrixD1.row1 - i4);
            for (int i5 = 0; i5 < iMin3; i5++) {
                float fInnerProdRow = innerProdRow(i, fSubmatrixD1, i2, fSubmatrixD1, i5 + (i4 - fSubmatrixD1.row0), i3) * f;
                int i6 = (fSubmatrixD1.row0 * fSubmatrixD1.original.numCols) + (fSubmatrixD1.col0 * iMin) + (i2 * iMin2);
                int i7 = i3 + 1;
                int i8 = i6 + i7;
                int i9 = (fSubmatrixD1.original.numCols * i4) + (fSubmatrixD1.col0 * iMin3) + (i5 * iMin2) + i3;
                int i10 = i9 + 1;
                fArr[i9] = fArr[i9] - fInnerProdRow;
                while (i7 < iMin2) {
                    fArr[i10] = fArr[i10] - (fArr[i8] * fInnerProdRow);
                    i7++;
                    i10++;
                    i8++;
                }
            }
        }
    }

    public static float innerProdCol(int i, FSubmatrixD1 fSubmatrixD1, int i2, int i3, int i4, int i5) {
        float[] fArr = fSubmatrixD1.original.data;
        int i6 = fSubmatrixD1.col0 + i2;
        int i7 = i2 % i;
        int i8 = i6 - i7;
        int i9 = fSubmatrixD1.col0 + i4;
        int i10 = i4 % i;
        int i11 = i9 - i10;
        int i12 = fSubmatrixD1.row0;
        float f = 0.0f;
        while (i12 < fSubmatrixD1.row1) {
            int iMin = Math.min(i, fSubmatrixD1.row1 - i12);
            int i13 = (fSubmatrixD1.original.numCols * i12) + (iMin * i8) + i7;
            int i14 = (fSubmatrixD1.original.numCols * i12) + (iMin * i11) + i10;
            if (i12 == fSubmatrixD1.row0) {
                int i15 = i13 + ((i7 + 1) * i3);
                int i16 = i14 + (i5 * i7);
                f = fArr[i16];
                int i17 = i16 + i5;
                int i18 = (((iMin - i7) - 1) * i3) + i15;
                while (i15 != i18) {
                    f += fArr[i15] * fArr[i17];
                    i15 += i3;
                    i17 += i5;
                }
            } else {
                int i19 = (iMin * i3) + i13;
                while (i13 != i19) {
                    f += fArr[i13] * fArr[i14];
                    i13 += i3;
                    i14 += i5;
                }
            }
            i12 += i;
        }
        return f;
    }

    public static float innerProdRow(int i, FSubmatrixD1 fSubmatrixD1, int i2, FSubmatrixD1 fSubmatrixD12, int i3, int i4) {
        int i5 = i4 + i2;
        if (fSubmatrixD12.col0 + i5 >= fSubmatrixD12.col1) {
            return 0.0f;
        }
        return fSubmatrixD12.get(i3, i5) + VectorOps_FDRB.dot_row(i, fSubmatrixD1, i2, fSubmatrixD12, i3, i5 + 1, fSubmatrixD1.col1 - fSubmatrixD1.col0);
    }

    public static void add_row(int i, FSubmatrixD1 fSubmatrixD1, int i2, float f, FSubmatrixD1 fSubmatrixD12, int i3, float f2, FSubmatrixD1 fSubmatrixD13, int i4, int i5, int i6) {
        int i7 = i2 + i5;
        if (fSubmatrixD13.col0 + i7 >= fSubmatrixD13.col1) {
            return;
        }
        fSubmatrixD13.set(i4, i7, (fSubmatrixD12.get(i3, i7) * f2) + f);
        VectorOps_FDRB.add_row(i, fSubmatrixD1, i2, f, fSubmatrixD12, i3, f2, fSubmatrixD13, i4, i7 + 1, i6);
    }

    public static void divideElementsCol(int i, FSubmatrixD1 fSubmatrixD1, int i2, float f) {
        int iMin = Math.min(i, fSubmatrixD1.col1 - fSubmatrixD1.col0);
        float[] fArr = fSubmatrixD1.original.data;
        int i3 = fSubmatrixD1.row0;
        while (i3 < fSubmatrixD1.row1) {
            int iMin2 = Math.min(i, fSubmatrixD1.row1 - i3);
            int i4 = (fSubmatrixD1.original.numCols * i3) + (fSubmatrixD1.col0 * iMin2) + i2;
            if (i3 == fSubmatrixD1.row0) {
                int i5 = i2 + 1;
                int i6 = i4 + (iMin * i5);
                while (i5 < iMin2) {
                    fArr[i6] = fArr[i6] / f;
                    i5++;
                    i6 += iMin;
                }
            } else {
                int i7 = (iMin2 * iMin) + i4;
                while (i4 != i7) {
                    fArr[i4] = fArr[i4] / f;
                    i4 += iMin;
                }
            }
            i3 += i;
        }
    }

    public static void scale_row(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, int i2, int i3, float f) {
        int i4 = i3 + i2;
        if (i4 >= fSubmatrixD12.col1 - fSubmatrixD12.col0) {
            return;
        }
        fSubmatrixD12.set(i2, i4, f);
        VectorOps_FDRB.scale_row(i, fSubmatrixD1, i2, f, fSubmatrixD12, i2, i4 + 1, fSubmatrixD1.col1 - fSubmatrixD1.col0);
    }

    public static float computeTauAndDivideCol(int i, FSubmatrixD1 fSubmatrixD1, int i2, float f) {
        int iMin = Math.min(i, fSubmatrixD1.col1 - fSubmatrixD1.col0);
        float[] fArr = fSubmatrixD1.original.data;
        int i3 = fSubmatrixD1.row0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i3 < fSubmatrixD1.row1) {
            int iMin2 = Math.min(i, fSubmatrixD1.row1 - i3);
            int i4 = (fSubmatrixD1.original.numCols * i3) + (fSubmatrixD1.col0 * iMin2) + i2;
            if (i3 == fSubmatrixD1.row0) {
                int i5 = i4 + (iMin * i2);
                f3 = fArr[i5] / f;
                fArr[i5] = f3;
                f2 += f3 * f3;
                int i6 = i5 + iMin;
                int i7 = i2 + 1;
                while (i7 < iMin2) {
                    float f4 = fArr[i6] / f;
                    fArr[i6] = f4;
                    f2 += f4 * f4;
                    i7++;
                    i6 += iMin;
                }
            } else {
                int i8 = 0;
                while (i8 < iMin2) {
                    float f5 = fArr[i4] / f;
                    fArr[i4] = f5;
                    f2 += f5 * f5;
                    i8++;
                    i4 += iMin;
                }
            }
            i3 += i;
        }
        float fSqrt = (float) Math.sqrt(f2);
        return f3 < 0.0f ? -fSqrt : fSqrt;
    }

    public static float computeTauAndDivideRow(int i, FSubmatrixD1 fSubmatrixD1, int i2, int i3, float f) {
        int iMin = Math.min(i, fSubmatrixD1.row1 - fSubmatrixD1.row0);
        float[] fArr = fSubmatrixD1.original.data;
        int i4 = i3 % i;
        int i5 = (fSubmatrixD1.col0 + i3) - i4;
        int i6 = i5;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i6 < fSubmatrixD1.col1) {
            int iMin2 = Math.min(i, fSubmatrixD1.col1 - i6);
            int i7 = (fSubmatrixD1.row0 * fSubmatrixD1.original.numCols) + (iMin * i6) + (i2 * iMin2);
            if (i6 == i5) {
                int i8 = i7 + i4;
                f3 = fArr[i8] / f;
                fArr[i8] = f3;
                f2 += f3 * f3;
                int i9 = i8 + 1;
                int i10 = i4 + 1;
                while (i10 < iMin2) {
                    float f4 = fArr[i9] / f;
                    fArr[i9] = f4;
                    f2 += f4 * f4;
                    i10++;
                    i9++;
                }
            } else {
                int i11 = 0;
                while (i11 < iMin2) {
                    float f5 = fArr[i7] / f;
                    fArr[i7] = f5;
                    f2 += f5 * f5;
                    i11++;
                    i7++;
                }
            }
            i6 += i;
        }
        float fSqrt = (float) Math.sqrt(f2);
        return f3 < 0.0f ? -fSqrt : fSqrt;
    }

    public static float findMaxCol(int i, FSubmatrixD1 fSubmatrixD1, int i2) {
        int iMin = Math.min(i, fSubmatrixD1.col1 - fSubmatrixD1.col0);
        float[] fArr = fSubmatrixD1.original.data;
        int i3 = fSubmatrixD1.row0;
        float f = 0.0f;
        while (i3 < fSubmatrixD1.row1) {
            int iMin2 = Math.min(i, fSubmatrixD1.row1 - i3);
            int i4 = (fSubmatrixD1.original.numCols * i3) + (fSubmatrixD1.col0 * iMin2) + i2;
            if (i3 == fSubmatrixD1.row0) {
                int i5 = i4 + (iMin * i2);
                int i6 = i2;
                while (i6 < iMin2) {
                    float fAbs = Math.abs(fArr[i5]);
                    if (fAbs > f) {
                        f = fAbs;
                    }
                    i6++;
                    i5 += iMin;
                }
            } else {
                int i7 = 0;
                while (i7 < iMin2) {
                    float fAbs2 = Math.abs(fArr[i4]);
                    if (fAbs2 > f) {
                        f = fAbs2;
                    }
                    i7++;
                    i4 += iMin;
                }
            }
            i3 += i;
        }
        return f;
    }

    public static float findMaxRow(int i, FSubmatrixD1 fSubmatrixD1, int i2, int i3) {
        int iMin = Math.min(i, fSubmatrixD1.row1 - fSubmatrixD1.row0);
        float[] fArr = fSubmatrixD1.original.data;
        int i4 = fSubmatrixD1.col0;
        float f = 0.0f;
        while (i4 < fSubmatrixD1.col1) {
            int iMin2 = Math.min(i, fSubmatrixD1.col1 - i4);
            int i5 = (fSubmatrixD1.row0 * fSubmatrixD1.original.numCols) + (iMin * i4) + (i2 * iMin2);
            if (i4 == fSubmatrixD1.col0) {
                int i6 = i5 + i3;
                int i7 = i3;
                while (i7 < iMin2) {
                    int i8 = i6 + 1;
                    float fAbs = Math.abs(fArr[i6]);
                    if (fAbs > f) {
                        f = fAbs;
                    }
                    i7++;
                    i6 = i8;
                }
            } else {
                int i9 = 0;
                while (i9 < iMin2) {
                    int i10 = i5 + 1;
                    float fAbs2 = Math.abs(fArr[i5]);
                    if (fAbs2 > f) {
                        f = fAbs2;
                    }
                    i9++;
                    i5 = i10;
                }
            }
            i4 += i;
        }
        return f;
    }

    public static void computeW_Column(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, float[] fArr, float[] fArr2, int i2) {
        int i3 = fSubmatrixD12.col1 - fSubmatrixD12.col0;
        int i4 = i2 + 1;
        initializeW(i, fSubmatrixD12, fSubmatrixD1, i3, fArr2[i2]);
        int iMin = Math.min(i3, fSubmatrixD12.row1 - fSubmatrixD12.row0);
        int i5 = 1;
        while (i5 < iMin) {
            computeY_t_V(i, fSubmatrixD1, i5, fArr);
            computeZ(i, fSubmatrixD1, fSubmatrixD12, i5, fArr, fArr2[i4]);
            i5++;
            i4++;
        }
    }

    public static void initializeW(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, int i2, float f) {
        float[] fArr = fSubmatrixD1.original.data;
        float[] fArr2 = fSubmatrixD12.original.data;
        int i3 = fSubmatrixD1.row0;
        while (i3 < fSubmatrixD1.row1) {
            int iMin = Math.min(i, fSubmatrixD1.row1 - i3);
            int i4 = (fSubmatrixD1.original.numCols * i3) + (fSubmatrixD1.col0 * iMin);
            int i5 = (fSubmatrixD12.original.numCols * i3) + (fSubmatrixD12.col0 * iMin);
            if (i3 == fSubmatrixD1.row0) {
                float f2 = -f;
                fArr[i4] = f2;
                int i6 = i4 + i2;
                int i7 = i5 + i2;
                int i8 = 1;
                while (i8 < iMin) {
                    fArr[i6] = fArr2[i7] * f2;
                    i8++;
                    i6 += i2;
                    i7 += i2;
                }
            } else {
                int i9 = 0;
                while (i9 < iMin) {
                    fArr[i4] = (-f) * fArr2[i5];
                    i9++;
                    i4 += i2;
                    i5 += i2;
                }
            }
            i3 += i;
        }
    }

    public static void computeZ(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, int i2, float[] fArr, float f) {
        int i3 = fSubmatrixD1.col1 - fSubmatrixD1.col0;
        float[] fArr2 = fSubmatrixD12.original.data;
        float[] fArr3 = fSubmatrixD1.original.data;
        int i4 = fSubmatrixD12.original.numCols;
        float f2 = -f;
        int i5 = fSubmatrixD1.row0;
        while (i5 < fSubmatrixD1.row1) {
            int iMin = Math.min(i, fSubmatrixD1.row1 - i5);
            int i6 = i5 * i4;
            int i7 = (fSubmatrixD12.col0 * iMin) + i6;
            int i8 = i6 + (fSubmatrixD12.col0 * iMin) + i2;
            int i9 = (fSubmatrixD1.original.numCols * i5) + (fSubmatrixD1.col0 * iMin) + i2;
            if (i5 == fSubmatrixD1.row0) {
                int i10 = 0;
                while (i10 < iMin) {
                    float f3 = 0.0f;
                    for (int i11 = 0; i11 < i2; i11++) {
                        f3 += fArr2[i7 + i11] * fArr[i11];
                    }
                    if (i10 < i2) {
                        fArr2[i8] = f3 * f2;
                    } else if (i10 == i2) {
                        fArr2[i8] = (f3 + 1.0f) * f2;
                    } else {
                        fArr2[i8] = (fArr3[i9] + f3) * f2;
                    }
                    i10++;
                    i8 += i3;
                    i7 += i3;
                    i9 += i3;
                }
            } else {
                int i12 = (iMin * i3) + i8;
                while (i8 != i12) {
                    float f4 = 0.0f;
                    for (int i13 = 0; i13 < i2; i13++) {
                        f4 += fArr2[i7 + i13] * fArr[i13];
                    }
                    fArr2[i8] = (fArr3[i9] + f4) * f2;
                    i8 += i3;
                    i7 += i3;
                    i9 += i3;
                }
            }
            i5 += i;
        }
    }

    public static void computeY_t_V(int i, FSubmatrixD1 fSubmatrixD1, int i2, float[] fArr) {
        int i3 = fSubmatrixD1.col1 - fSubmatrixD1.col0;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = i;
            fArr[i4] = innerProdCol(i5, fSubmatrixD1, i2, i3, i4, i3);
            i4++;
            i = i5;
        }
    }

    public static void multAdd_zeros(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, FSubmatrixD1 fSubmatrixD13) {
        int i2 = fSubmatrixD1.col1 - fSubmatrixD1.col0;
        int i3 = fSubmatrixD1.row0;
        while (i3 < fSubmatrixD1.row1) {
            int iMin = Math.min(i, fSubmatrixD1.row1 - i3);
            int i4 = fSubmatrixD12.col0;
            while (i4 < fSubmatrixD12.col1) {
                int iMin2 = Math.min(i, fSubmatrixD12.col1 - i4);
                int i5 = (((i3 - fSubmatrixD1.row0) + fSubmatrixD13.row0) * fSubmatrixD13.original.numCols) + (((i4 - fSubmatrixD12.col0) + fSubmatrixD13.col0) * iMin);
                int i6 = fSubmatrixD1.col0;
                while (i6 < fSubmatrixD1.col1) {
                    int i7 = (fSubmatrixD1.original.numCols * i3) + (i6 * iMin);
                    int i8 = (((i6 - fSubmatrixD1.col0) + fSubmatrixD12.row0) * fSubmatrixD12.original.numCols) + (i4 * i2);
                    if (i3 == fSubmatrixD1.row0) {
                        multBlockAdd_zerosone(fSubmatrixD1.original.data, fSubmatrixD12.original.data, fSubmatrixD13.original.data, i7, i8, i5, iMin, i2, iMin2);
                    } else {
                        InnerMultiplication_FDRB.blockMultPlus(fSubmatrixD1.original.data, fSubmatrixD12.original.data, fSubmatrixD13.original.data, i7, i8, i5, iMin, i2, iMin2);
                    }
                    i6 += i;
                }
                i4 += i;
            }
            i3 += i;
        }
    }

    public static void multBlockAdd_zerosone(float[] fArr, float[] fArr2, float[] fArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        while (i7 < i4) {
            for (int i8 = 0; i8 < i6; i8++) {
                float f = i7 < i5 ? fArr2[(i7 * i6) + i8 + i2] : 0.0f;
                int iMin = Math.min(i7, i5);
                for (int i9 = 0; i9 < iMin; i9++) {
                    f += fArr[(i7 * i5) + i9 + i] * fArr2[(i9 * i6) + i8 + i2];
                }
                int i10 = (i7 * i6) + i8 + i3;
                fArr3[i10] = fArr3[i10] + f;
            }
            i7++;
        }
    }

    public static void multTransA_vecCol(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, FSubmatrixD1 fSubmatrixD13) {
        int i2 = fSubmatrixD1.col1 - fSubmatrixD1.col0;
        if (i2 > i) {
            throw new IllegalArgumentException("A is expected to be at most one block wide.");
        }
        int i3 = fSubmatrixD12.col0;
        while (i3 < fSubmatrixD12.col1) {
            int iMin = Math.min(i, fSubmatrixD12.col1 - i3);
            int i4 = (fSubmatrixD13.row0 * fSubmatrixD13.original.numCols) + (((i3 - fSubmatrixD12.col0) + fSubmatrixD13.col0) * i2);
            int i5 = fSubmatrixD1.row0;
            while (i5 < fSubmatrixD1.row1) {
                int iMin2 = Math.min(i, fSubmatrixD1.row1 - i5);
                int i6 = (fSubmatrixD1.original.numCols * i5) + (fSubmatrixD1.col0 * iMin2);
                int i7 = (((i5 - fSubmatrixD1.row0) + fSubmatrixD12.row0) * fSubmatrixD12.original.numCols) + (i3 * iMin2);
                if (i5 == fSubmatrixD1.row0) {
                    multTransABlockSet_lowerTriag(fSubmatrixD1.original.data, fSubmatrixD12.original.data, fSubmatrixD13.original.data, i6, i7, i4, iMin2, i2, iMin);
                } else {
                    InnerMultiplication_FDRB.blockMultPlusTransA(fSubmatrixD1.original.data, fSubmatrixD12.original.data, fSubmatrixD13.original.data, i6, i7, i4, iMin2, i2, iMin);
                }
                i5 += i;
            }
            i3 += i;
        }
    }

    protected static void multTransABlockSet_lowerTriag(float[] fArr, float[] fArr2, float[] fArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        while (i7 < i5) {
            for (int i8 = 0; i8 < i6; i8++) {
                float f = i7 < i4 ? fArr2[(i7 * i6) + i8 + i2] : 0.0f;
                for (int i9 = i7 + 1; i9 < i4; i9++) {
                    f += fArr[(i9 * i5) + i7 + i] * fArr2[(i9 * i6) + i8 + i2];
                }
                fArr3[(i7 * i6) + i8 + i3] = f;
            }
            i7++;
        }
    }
}
