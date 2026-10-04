package org.ejml.dense.block;

import org.ejml.data.DSubmatrixD1;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixMult_DDRB {
    public static void mult(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, DSubmatrixD1 dSubmatrixD13) {
        int i2 = dSubmatrixD1.row0;
        while (i2 < dSubmatrixD1.row1) {
            int iMin = Math.min(i, dSubmatrixD1.row1 - i2);
            int i3 = dSubmatrixD12.col0;
            while (i3 < dSubmatrixD12.col1) {
                int iMin2 = Math.min(i, dSubmatrixD12.col1 - i3);
                int i4 = (((i2 - dSubmatrixD1.row0) + dSubmatrixD13.row0) * dSubmatrixD13.original.numCols) + (((i3 - dSubmatrixD12.col0) + dSubmatrixD13.col0) * iMin);
                int i5 = dSubmatrixD1.col0;
                while (i5 < dSubmatrixD1.col1) {
                    int iMin3 = Math.min(i, dSubmatrixD1.col1 - i5);
                    int i6 = (dSubmatrixD1.original.numCols * i2) + (i5 * iMin);
                    int i7 = (((i5 - dSubmatrixD1.col0) + dSubmatrixD12.row0) * dSubmatrixD12.original.numCols) + (i3 * iMin3);
                    if (i5 == dSubmatrixD1.col0) {
                        InnerMultiplication_DDRB.blockMultSet(dSubmatrixD1.original.data, dSubmatrixD12.original.data, dSubmatrixD13.original.data, i6, i7, i4, iMin, iMin3, iMin2);
                    } else {
                        InnerMultiplication_DDRB.blockMultPlus(dSubmatrixD1.original.data, dSubmatrixD12.original.data, dSubmatrixD13.original.data, i6, i7, i4, iMin, iMin3, iMin2);
                    }
                    i5 += i;
                }
                i3 += i;
            }
            i2 += i;
        }
    }

    public static void multPlus(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, DSubmatrixD1 dSubmatrixD13) {
        int i2 = dSubmatrixD1.row0;
        while (i2 < dSubmatrixD1.row1) {
            int iMin = Math.min(i, dSubmatrixD1.row1 - i2);
            int i3 = dSubmatrixD12.col0;
            while (i3 < dSubmatrixD12.col1) {
                int iMin2 = Math.min(i, dSubmatrixD12.col1 - i3);
                int i4 = (((i2 - dSubmatrixD1.row0) + dSubmatrixD13.row0) * dSubmatrixD13.original.numCols) + (((i3 - dSubmatrixD12.col0) + dSubmatrixD13.col0) * iMin);
                int i5 = dSubmatrixD1.col0;
                while (i5 < dSubmatrixD1.col1) {
                    int iMin3 = Math.min(i, dSubmatrixD1.col1 - i5);
                    InnerMultiplication_DDRB.blockMultPlus(dSubmatrixD1.original.data, dSubmatrixD12.original.data, dSubmatrixD13.original.data, (dSubmatrixD1.original.numCols * i2) + (i5 * iMin), (((i5 - dSubmatrixD1.col0) + dSubmatrixD12.row0) * dSubmatrixD12.original.numCols) + (i3 * iMin3), i4, iMin, iMin3, iMin2);
                    i5 += i;
                }
                i3 += i;
            }
            i2 += i;
        }
    }

    public static void multMinus(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, DSubmatrixD1 dSubmatrixD13) {
        checkInput(i, dSubmatrixD1, dSubmatrixD12, dSubmatrixD13);
        int i2 = dSubmatrixD1.row0;
        while (i2 < dSubmatrixD1.row1) {
            int iMin = Math.min(i, dSubmatrixD1.row1 - i2);
            int i3 = dSubmatrixD12.col0;
            while (i3 < dSubmatrixD12.col1) {
                int iMin2 = Math.min(i, dSubmatrixD12.col1 - i3);
                int i4 = (((i2 - dSubmatrixD1.row0) + dSubmatrixD13.row0) * dSubmatrixD13.original.numCols) + (((i3 - dSubmatrixD12.col0) + dSubmatrixD13.col0) * iMin);
                int i5 = dSubmatrixD1.col0;
                while (i5 < dSubmatrixD1.col1) {
                    int iMin3 = Math.min(i, dSubmatrixD1.col1 - i5);
                    InnerMultiplication_DDRB.blockMultMinus(dSubmatrixD1.original.data, dSubmatrixD12.original.data, dSubmatrixD13.original.data, (dSubmatrixD1.original.numCols * i2) + (i5 * iMin), (((i5 - dSubmatrixD1.col0) + dSubmatrixD12.row0) * dSubmatrixD12.original.numCols) + (i3 * iMin3), i4, iMin, iMin3, iMin2);
                    i5 += i;
                }
                i3 += i;
            }
            i2 += i;
        }
    }

    private static void checkInput(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, DSubmatrixD1 dSubmatrixD13) {
        int rows = dSubmatrixD1.getRows();
        int cols = dSubmatrixD1.getCols();
        int rows2 = dSubmatrixD12.getRows();
        int cols2 = dSubmatrixD12.getCols();
        int rows3 = dSubmatrixD13.getRows();
        int cols3 = dSubmatrixD13.getCols();
        if (rows != rows3) {
            throw new RuntimeException("Mismatch A and C rows");
        }
        if (cols2 != cols3) {
            throw new RuntimeException("Mismatch B and C columns");
        }
        if (cols != rows2) {
            throw new RuntimeException("Mismatch A columns and B rows");
        }
        if (!MatrixOps_DDRB.blockAligned(i, dSubmatrixD1)) {
            throw new RuntimeException("Sub-Matrix A is not block aligned");
        }
        if (!MatrixOps_DDRB.blockAligned(i, dSubmatrixD12)) {
            throw new RuntimeException("Sub-Matrix B is not block aligned");
        }
        if (!MatrixOps_DDRB.blockAligned(i, dSubmatrixD13)) {
            throw new RuntimeException("Sub-Matrix C is not block aligned");
        }
    }

    public static void multTransA(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, DSubmatrixD1 dSubmatrixD13) {
        int i2 = dSubmatrixD1.col0;
        while (i2 < dSubmatrixD1.col1) {
            int iMin = Math.min(i, dSubmatrixD1.col1 - i2);
            int i3 = dSubmatrixD12.col0;
            while (i3 < dSubmatrixD12.col1) {
                int iMin2 = Math.min(i, dSubmatrixD12.col1 - i3);
                int i4 = (((i2 - dSubmatrixD1.col0) + dSubmatrixD13.row0) * dSubmatrixD13.original.numCols) + (((i3 - dSubmatrixD12.col0) + dSubmatrixD13.col0) * iMin);
                int i5 = dSubmatrixD1.row0;
                while (i5 < dSubmatrixD1.row1) {
                    int iMin3 = Math.min(i, dSubmatrixD1.row1 - i5);
                    int i6 = (dSubmatrixD1.original.numCols * i5) + (i2 * iMin3);
                    int i7 = (((i5 - dSubmatrixD1.row0) + dSubmatrixD12.row0) * dSubmatrixD12.original.numCols) + (i3 * iMin3);
                    if (i5 == dSubmatrixD1.row0) {
                        InnerMultiplication_DDRB.blockMultSetTransA(dSubmatrixD1.original.data, dSubmatrixD12.original.data, dSubmatrixD13.original.data, i6, i7, i4, iMin3, iMin, iMin2);
                    } else {
                        InnerMultiplication_DDRB.blockMultPlusTransA(dSubmatrixD1.original.data, dSubmatrixD12.original.data, dSubmatrixD13.original.data, i6, i7, i4, iMin3, iMin, iMin2);
                    }
                    i5 += i;
                }
                i3 += i;
            }
            i2 += i;
        }
    }

    public static void multPlusTransA(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, DSubmatrixD1 dSubmatrixD13) {
        int i2 = dSubmatrixD1.col0;
        while (i2 < dSubmatrixD1.col1) {
            int iMin = Math.min(i, dSubmatrixD1.col1 - i2);
            int i3 = dSubmatrixD12.col0;
            while (i3 < dSubmatrixD12.col1) {
                int iMin2 = Math.min(i, dSubmatrixD12.col1 - i3);
                int i4 = (((i2 - dSubmatrixD1.col0) + dSubmatrixD13.row0) * dSubmatrixD13.original.numCols) + (((i3 - dSubmatrixD12.col0) + dSubmatrixD13.col0) * iMin);
                int i5 = dSubmatrixD1.row0;
                while (i5 < dSubmatrixD1.row1) {
                    int iMin3 = Math.min(i, dSubmatrixD1.row1 - i5);
                    InnerMultiplication_DDRB.blockMultPlusTransA(dSubmatrixD1.original.data, dSubmatrixD12.original.data, dSubmatrixD13.original.data, (dSubmatrixD1.original.numCols * i5) + (i2 * iMin3), (((i5 - dSubmatrixD1.row0) + dSubmatrixD12.row0) * dSubmatrixD12.original.numCols) + (i3 * iMin3), i4, iMin3, iMin, iMin2);
                    i5 += i;
                }
                i3 += i;
            }
            i2 += i;
        }
    }

    public static void multMinusTransA(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, DSubmatrixD1 dSubmatrixD13) {
        int i2 = dSubmatrixD1.col0;
        while (i2 < dSubmatrixD1.col1) {
            int iMin = Math.min(i, dSubmatrixD1.col1 - i2);
            int i3 = dSubmatrixD12.col0;
            while (i3 < dSubmatrixD12.col1) {
                int iMin2 = Math.min(i, dSubmatrixD12.col1 - i3);
                int i4 = (((i2 - dSubmatrixD1.col0) + dSubmatrixD13.row0) * dSubmatrixD13.original.numCols) + (((i3 - dSubmatrixD12.col0) + dSubmatrixD13.col0) * iMin);
                int i5 = dSubmatrixD1.row0;
                while (i5 < dSubmatrixD1.row1) {
                    int iMin3 = Math.min(i, dSubmatrixD1.row1 - i5);
                    InnerMultiplication_DDRB.blockMultMinusTransA(dSubmatrixD1.original.data, dSubmatrixD12.original.data, dSubmatrixD13.original.data, (dSubmatrixD1.original.numCols * i5) + (i2 * iMin3), (((i5 - dSubmatrixD1.row0) + dSubmatrixD12.row0) * dSubmatrixD12.original.numCols) + (i3 * iMin3), i4, iMin3, iMin, iMin2);
                    i5 += i;
                }
                i3 += i;
            }
            i2 += i;
        }
    }

    public static void multTransB(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, DSubmatrixD1 dSubmatrixD13) {
        int i2 = dSubmatrixD1.row0;
        while (i2 < dSubmatrixD1.row1) {
            int iMin = Math.min(i, dSubmatrixD1.row1 - i2);
            int i3 = dSubmatrixD12.row0;
            while (i3 < dSubmatrixD12.row1) {
                int iMin2 = Math.min(i, dSubmatrixD12.row1 - i3);
                int i4 = (((i2 - dSubmatrixD1.row0) + dSubmatrixD13.row0) * dSubmatrixD13.original.numCols) + (((i3 - dSubmatrixD12.row0) + dSubmatrixD13.col0) * iMin);
                int i5 = dSubmatrixD1.col0;
                while (i5 < dSubmatrixD1.col1) {
                    int iMin3 = Math.min(i, dSubmatrixD1.col1 - i5);
                    int i6 = (dSubmatrixD1.original.numCols * i2) + (i5 * iMin);
                    int i7 = (dSubmatrixD12.original.numCols * i3) + (((i5 - dSubmatrixD1.col0) + dSubmatrixD12.col0) * iMin2);
                    if (i5 == dSubmatrixD1.col0) {
                        InnerMultiplication_DDRB.blockMultSetTransB(dSubmatrixD1.original.data, dSubmatrixD12.original.data, dSubmatrixD13.original.data, i6, i7, i4, iMin, iMin3, iMin2);
                    } else {
                        InnerMultiplication_DDRB.blockMultPlusTransB(dSubmatrixD1.original.data, dSubmatrixD12.original.data, dSubmatrixD13.original.data, i6, i7, i4, iMin, iMin3, iMin2);
                    }
                    i5 += i;
                }
                i3 += i;
            }
            i2 += i;
        }
    }
}
