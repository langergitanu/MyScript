package org.ejml.dense.block;

import org.ejml.data.FSubmatrixD1;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixMult_FDRB {
    public static void mult(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, FSubmatrixD1 fSubmatrixD13) {
        int i2 = fSubmatrixD1.row0;
        while (i2 < fSubmatrixD1.row1) {
            int iMin = Math.min(i, fSubmatrixD1.row1 - i2);
            int i3 = fSubmatrixD12.col0;
            while (i3 < fSubmatrixD12.col1) {
                int iMin2 = Math.min(i, fSubmatrixD12.col1 - i3);
                int i4 = (((i2 - fSubmatrixD1.row0) + fSubmatrixD13.row0) * fSubmatrixD13.original.numCols) + (((i3 - fSubmatrixD12.col0) + fSubmatrixD13.col0) * iMin);
                int i5 = fSubmatrixD1.col0;
                while (i5 < fSubmatrixD1.col1) {
                    int iMin3 = Math.min(i, fSubmatrixD1.col1 - i5);
                    int i6 = (fSubmatrixD1.original.numCols * i2) + (i5 * iMin);
                    int i7 = (((i5 - fSubmatrixD1.col0) + fSubmatrixD12.row0) * fSubmatrixD12.original.numCols) + (i3 * iMin3);
                    if (i5 == fSubmatrixD1.col0) {
                        InnerMultiplication_FDRB.blockMultSet(fSubmatrixD1.original.data, fSubmatrixD12.original.data, fSubmatrixD13.original.data, i6, i7, i4, iMin, iMin3, iMin2);
                    } else {
                        InnerMultiplication_FDRB.blockMultPlus(fSubmatrixD1.original.data, fSubmatrixD12.original.data, fSubmatrixD13.original.data, i6, i7, i4, iMin, iMin3, iMin2);
                    }
                    i5 += i;
                }
                i3 += i;
            }
            i2 += i;
        }
    }

    public static void multPlus(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, FSubmatrixD1 fSubmatrixD13) {
        int i2 = fSubmatrixD1.row0;
        while (i2 < fSubmatrixD1.row1) {
            int iMin = Math.min(i, fSubmatrixD1.row1 - i2);
            int i3 = fSubmatrixD12.col0;
            while (i3 < fSubmatrixD12.col1) {
                int iMin2 = Math.min(i, fSubmatrixD12.col1 - i3);
                int i4 = (((i2 - fSubmatrixD1.row0) + fSubmatrixD13.row0) * fSubmatrixD13.original.numCols) + (((i3 - fSubmatrixD12.col0) + fSubmatrixD13.col0) * iMin);
                int i5 = fSubmatrixD1.col0;
                while (i5 < fSubmatrixD1.col1) {
                    int iMin3 = Math.min(i, fSubmatrixD1.col1 - i5);
                    InnerMultiplication_FDRB.blockMultPlus(fSubmatrixD1.original.data, fSubmatrixD12.original.data, fSubmatrixD13.original.data, (fSubmatrixD1.original.numCols * i2) + (i5 * iMin), (((i5 - fSubmatrixD1.col0) + fSubmatrixD12.row0) * fSubmatrixD12.original.numCols) + (i3 * iMin3), i4, iMin, iMin3, iMin2);
                    i5 += i;
                }
                i3 += i;
            }
            i2 += i;
        }
    }

    public static void multMinus(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, FSubmatrixD1 fSubmatrixD13) {
        checkInput(i, fSubmatrixD1, fSubmatrixD12, fSubmatrixD13);
        int i2 = fSubmatrixD1.row0;
        while (i2 < fSubmatrixD1.row1) {
            int iMin = Math.min(i, fSubmatrixD1.row1 - i2);
            int i3 = fSubmatrixD12.col0;
            while (i3 < fSubmatrixD12.col1) {
                int iMin2 = Math.min(i, fSubmatrixD12.col1 - i3);
                int i4 = (((i2 - fSubmatrixD1.row0) + fSubmatrixD13.row0) * fSubmatrixD13.original.numCols) + (((i3 - fSubmatrixD12.col0) + fSubmatrixD13.col0) * iMin);
                int i5 = fSubmatrixD1.col0;
                while (i5 < fSubmatrixD1.col1) {
                    int iMin3 = Math.min(i, fSubmatrixD1.col1 - i5);
                    InnerMultiplication_FDRB.blockMultMinus(fSubmatrixD1.original.data, fSubmatrixD12.original.data, fSubmatrixD13.original.data, (fSubmatrixD1.original.numCols * i2) + (i5 * iMin), (((i5 - fSubmatrixD1.col0) + fSubmatrixD12.row0) * fSubmatrixD12.original.numCols) + (i3 * iMin3), i4, iMin, iMin3, iMin2);
                    i5 += i;
                }
                i3 += i;
            }
            i2 += i;
        }
    }

    private static void checkInput(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, FSubmatrixD1 fSubmatrixD13) {
        int rows = fSubmatrixD1.getRows();
        int cols = fSubmatrixD1.getCols();
        int rows2 = fSubmatrixD12.getRows();
        int cols2 = fSubmatrixD12.getCols();
        int rows3 = fSubmatrixD13.getRows();
        int cols3 = fSubmatrixD13.getCols();
        if (rows != rows3) {
            throw new RuntimeException("Mismatch A and C rows");
        }
        if (cols2 != cols3) {
            throw new RuntimeException("Mismatch B and C columns");
        }
        if (cols != rows2) {
            throw new RuntimeException("Mismatch A columns and B rows");
        }
        if (!MatrixOps_FDRB.blockAligned(i, fSubmatrixD1)) {
            throw new RuntimeException("Sub-Matrix A is not block aligned");
        }
        if (!MatrixOps_FDRB.blockAligned(i, fSubmatrixD12)) {
            throw new RuntimeException("Sub-Matrix B is not block aligned");
        }
        if (!MatrixOps_FDRB.blockAligned(i, fSubmatrixD13)) {
            throw new RuntimeException("Sub-Matrix C is not block aligned");
        }
    }

    public static void multTransA(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, FSubmatrixD1 fSubmatrixD13) {
        int i2 = fSubmatrixD1.col0;
        while (i2 < fSubmatrixD1.col1) {
            int iMin = Math.min(i, fSubmatrixD1.col1 - i2);
            int i3 = fSubmatrixD12.col0;
            while (i3 < fSubmatrixD12.col1) {
                int iMin2 = Math.min(i, fSubmatrixD12.col1 - i3);
                int i4 = (((i2 - fSubmatrixD1.col0) + fSubmatrixD13.row0) * fSubmatrixD13.original.numCols) + (((i3 - fSubmatrixD12.col0) + fSubmatrixD13.col0) * iMin);
                int i5 = fSubmatrixD1.row0;
                while (i5 < fSubmatrixD1.row1) {
                    int iMin3 = Math.min(i, fSubmatrixD1.row1 - i5);
                    int i6 = (fSubmatrixD1.original.numCols * i5) + (i2 * iMin3);
                    int i7 = (((i5 - fSubmatrixD1.row0) + fSubmatrixD12.row0) * fSubmatrixD12.original.numCols) + (i3 * iMin3);
                    if (i5 == fSubmatrixD1.row0) {
                        InnerMultiplication_FDRB.blockMultSetTransA(fSubmatrixD1.original.data, fSubmatrixD12.original.data, fSubmatrixD13.original.data, i6, i7, i4, iMin3, iMin, iMin2);
                    } else {
                        InnerMultiplication_FDRB.blockMultPlusTransA(fSubmatrixD1.original.data, fSubmatrixD12.original.data, fSubmatrixD13.original.data, i6, i7, i4, iMin3, iMin, iMin2);
                    }
                    i5 += i;
                }
                i3 += i;
            }
            i2 += i;
        }
    }

    public static void multPlusTransA(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, FSubmatrixD1 fSubmatrixD13) {
        int i2 = fSubmatrixD1.col0;
        while (i2 < fSubmatrixD1.col1) {
            int iMin = Math.min(i, fSubmatrixD1.col1 - i2);
            int i3 = fSubmatrixD12.col0;
            while (i3 < fSubmatrixD12.col1) {
                int iMin2 = Math.min(i, fSubmatrixD12.col1 - i3);
                int i4 = (((i2 - fSubmatrixD1.col0) + fSubmatrixD13.row0) * fSubmatrixD13.original.numCols) + (((i3 - fSubmatrixD12.col0) + fSubmatrixD13.col0) * iMin);
                int i5 = fSubmatrixD1.row0;
                while (i5 < fSubmatrixD1.row1) {
                    int iMin3 = Math.min(i, fSubmatrixD1.row1 - i5);
                    InnerMultiplication_FDRB.blockMultPlusTransA(fSubmatrixD1.original.data, fSubmatrixD12.original.data, fSubmatrixD13.original.data, (fSubmatrixD1.original.numCols * i5) + (i2 * iMin3), (((i5 - fSubmatrixD1.row0) + fSubmatrixD12.row0) * fSubmatrixD12.original.numCols) + (i3 * iMin3), i4, iMin3, iMin, iMin2);
                    i5 += i;
                }
                i3 += i;
            }
            i2 += i;
        }
    }

    public static void multMinusTransA(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, FSubmatrixD1 fSubmatrixD13) {
        int i2 = fSubmatrixD1.col0;
        while (i2 < fSubmatrixD1.col1) {
            int iMin = Math.min(i, fSubmatrixD1.col1 - i2);
            int i3 = fSubmatrixD12.col0;
            while (i3 < fSubmatrixD12.col1) {
                int iMin2 = Math.min(i, fSubmatrixD12.col1 - i3);
                int i4 = (((i2 - fSubmatrixD1.col0) + fSubmatrixD13.row0) * fSubmatrixD13.original.numCols) + (((i3 - fSubmatrixD12.col0) + fSubmatrixD13.col0) * iMin);
                int i5 = fSubmatrixD1.row0;
                while (i5 < fSubmatrixD1.row1) {
                    int iMin3 = Math.min(i, fSubmatrixD1.row1 - i5);
                    InnerMultiplication_FDRB.blockMultMinusTransA(fSubmatrixD1.original.data, fSubmatrixD12.original.data, fSubmatrixD13.original.data, (fSubmatrixD1.original.numCols * i5) + (i2 * iMin3), (((i5 - fSubmatrixD1.row0) + fSubmatrixD12.row0) * fSubmatrixD12.original.numCols) + (i3 * iMin3), i4, iMin3, iMin, iMin2);
                    i5 += i;
                }
                i3 += i;
            }
            i2 += i;
        }
    }

    public static void multTransB(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, FSubmatrixD1 fSubmatrixD13) {
        int i2 = fSubmatrixD1.row0;
        while (i2 < fSubmatrixD1.row1) {
            int iMin = Math.min(i, fSubmatrixD1.row1 - i2);
            int i3 = fSubmatrixD12.row0;
            while (i3 < fSubmatrixD12.row1) {
                int iMin2 = Math.min(i, fSubmatrixD12.row1 - i3);
                int i4 = (((i2 - fSubmatrixD1.row0) + fSubmatrixD13.row0) * fSubmatrixD13.original.numCols) + (((i3 - fSubmatrixD12.row0) + fSubmatrixD13.col0) * iMin);
                int i5 = fSubmatrixD1.col0;
                while (i5 < fSubmatrixD1.col1) {
                    int iMin3 = Math.min(i, fSubmatrixD1.col1 - i5);
                    int i6 = (fSubmatrixD1.original.numCols * i2) + (i5 * iMin);
                    int i7 = (fSubmatrixD12.original.numCols * i3) + (((i5 - fSubmatrixD1.col0) + fSubmatrixD12.col0) * iMin2);
                    if (i5 == fSubmatrixD1.col0) {
                        InnerMultiplication_FDRB.blockMultSetTransB(fSubmatrixD1.original.data, fSubmatrixD12.original.data, fSubmatrixD13.original.data, i6, i7, i4, iMin, iMin3, iMin2);
                    } else {
                        InnerMultiplication_FDRB.blockMultPlusTransB(fSubmatrixD1.original.data, fSubmatrixD12.original.data, fSubmatrixD13.original.data, i6, i7, i4, iMin, iMin3, iMin2);
                    }
                    i5 += i;
                }
                i3 += i;
            }
            i2 += i;
        }
    }
}
