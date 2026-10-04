package org.ejml.dense.row.mult;

import org.ejml.MatrixDimensionException;
import org.ejml.data.FMatrix1Row;
import org.ejml.dense.row.CommonOps_FDRM;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixMatrixMult_FDRM {
    public static void mult_reorder(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numCols != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numRows != fMatrix1Row3.numRows || fMatrix1Row2.numCols != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (fMatrix1Row.numCols == 0 || fMatrix1Row.numRows == 0) {
            CommonOps_FDRM.fill(fMatrix1Row3, 0.0f);
            return;
        }
        int i = fMatrix1Row2.numRows * fMatrix1Row2.numCols;
        int i2 = 0;
        for (int i3 = 0; i3 < fMatrix1Row.numRows; i3++) {
            int i4 = fMatrix1Row.numCols * i3;
            int i5 = fMatrix1Row2.numCols;
            int i6 = i4 + 1;
            float f = fMatrix1Row.get(i4);
            int i7 = 0;
            int i8 = i2;
            while (i7 < i5) {
                fMatrix1Row3.set(i8, fMatrix1Row2.get(i7) * f);
                i8++;
                i7++;
            }
            while (i7 != i) {
                int i9 = fMatrix1Row2.numCols + i7;
                int i10 = i6 + 1;
                float f2 = fMatrix1Row.get(i6);
                int i11 = i2;
                while (i7 < i9) {
                    fMatrix1Row3.plus(i11, fMatrix1Row2.get(i7) * f2);
                    i11++;
                    i7++;
                }
                i6 = i10;
            }
            i2 += fMatrix1Row3.numCols;
        }
    }

    public static void mult_small(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numCols != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numRows != fMatrix1Row3.numRows || fMatrix1Row2.numCols != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < fMatrix1Row.numRows; i3++) {
            int i4 = 0;
            while (i4 < fMatrix1Row2.numCols) {
                int i5 = fMatrix1Row2.numRows + i;
                float f = 0.0f;
                int i6 = i4;
                for (int i7 = i; i7 < i5; i7++) {
                    f += fMatrix1Row.get(i7) * fMatrix1Row2.get(i6);
                    i6 += fMatrix1Row2.numCols;
                }
                fMatrix1Row3.set(i2, f);
                i4++;
                i2++;
            }
            i += fMatrix1Row.numCols;
        }
    }

    public static void mult_aux(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3, float[] fArr) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numCols != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numRows != fMatrix1Row3.numRows || fMatrix1Row2.numCols != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (fArr == null) {
            fArr = new float[fMatrix1Row2.numRows];
        }
        for (int i = 0; i < fMatrix1Row2.numCols; i++) {
            for (int i2 = 0; i2 < fMatrix1Row2.numRows; i2++) {
                fArr[i2] = fMatrix1Row2.unsafe_get(i2, i);
            }
            int i3 = 0;
            for (int i4 = 0; i4 < fMatrix1Row.numRows; i4++) {
                float f = 0.0f;
                for (int i5 = 0; i5 < fMatrix1Row2.numRows; i5++) {
                    f += fMatrix1Row.get(i3) * fArr[i5];
                    i3++;
                }
                fMatrix1Row3.set((fMatrix1Row3.numCols * i4) + i, f);
            }
        }
    }

    public static void multTransA_reorder(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numRows != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numCols != fMatrix1Row3.numRows || fMatrix1Row2.numCols != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (fMatrix1Row.numCols == 0 || fMatrix1Row.numRows == 0) {
            CommonOps_FDRM.fill(fMatrix1Row3, 0.0f);
            return;
        }
        for (int i = 0; i < fMatrix1Row.numCols; i++) {
            int i2 = fMatrix1Row3.numCols * i;
            float f = fMatrix1Row.get(i);
            int i3 = fMatrix1Row2.numCols;
            int i4 = 0;
            int i5 = i2;
            while (i4 < i3) {
                fMatrix1Row3.set(i5, fMatrix1Row2.get(i4) * f);
                i5++;
                i4++;
            }
            for (int i6 = 1; i6 < fMatrix1Row.numRows; i6++) {
                float fUnsafe_get = fMatrix1Row.unsafe_get(i6, i);
                int i7 = fMatrix1Row2.numCols + i4;
                int i8 = i2;
                while (i4 < i7) {
                    fMatrix1Row3.plus(i8, fMatrix1Row2.get(i4) * fUnsafe_get);
                    i8++;
                    i4++;
                }
            }
        }
    }

    public static void multTransA_small(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numRows != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numCols != fMatrix1Row3.numRows || fMatrix1Row2.numCols != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < fMatrix1Row.numCols; i2++) {
            int i3 = 0;
            while (i3 < fMatrix1Row2.numCols) {
                int i4 = (fMatrix1Row2.numRows * fMatrix1Row2.numCols) + i3;
                float f = 0.0f;
                int i5 = i2;
                int i6 = i3;
                while (i6 < i4) {
                    f += fMatrix1Row.get(i5) * fMatrix1Row2.get(i6);
                    i5 += fMatrix1Row.numCols;
                    i6 += fMatrix1Row2.numCols;
                }
                fMatrix1Row3.set(i, f);
                i3++;
                i++;
            }
        }
    }

    public static void multTransAB(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numRows != fMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numCols != fMatrix1Row3.numRows || fMatrix1Row2.numRows != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < fMatrix1Row.numCols; i2++) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < fMatrix1Row2.numRows) {
                int i5 = fMatrix1Row2.numCols + i4;
                float f = 0.0f;
                int i6 = i2;
                while (i4 < i5) {
                    f += fMatrix1Row.get(i6) * fMatrix1Row2.get(i4);
                    i6 += fMatrix1Row.numCols;
                    i4++;
                }
                fMatrix1Row3.set(i, f);
                i3++;
                i++;
            }
        }
    }

    public static void multTransAB_aux(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3, float[] fArr) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numRows != fMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numCols != fMatrix1Row3.numRows || fMatrix1Row2.numRows != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (fArr == null) {
            fArr = new float[fMatrix1Row.numRows];
        }
        if (fMatrix1Row.numCols == 0 || fMatrix1Row.numRows == 0) {
            CommonOps_FDRM.fill(fMatrix1Row3, 0.0f);
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < fMatrix1Row.numCols; i2++) {
            for (int i3 = 0; i3 < fMatrix1Row2.numCols; i3++) {
                fArr[i3] = fMatrix1Row.unsafe_get(i3, i2);
            }
            int i4 = 0;
            while (i4 < fMatrix1Row2.numRows) {
                float fUnsafe_get = 0.0f;
                for (int i5 = 0; i5 < fMatrix1Row2.numCols; i5++) {
                    fUnsafe_get += fArr[i5] * fMatrix1Row2.unsafe_get(i4, i5);
                }
                fMatrix1Row3.set(i, fUnsafe_get);
                i4++;
                i++;
            }
        }
    }

    public static void multTransB(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numCols != fMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numRows != fMatrix1Row3.numRows || fMatrix1Row2.numRows != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < fMatrix1Row.numRows; i3++) {
            int i4 = fMatrix1Row2.numCols + i;
            int i5 = 0;
            int i6 = 0;
            while (i5 < fMatrix1Row2.numRows) {
                float f = 0.0f;
                int i7 = i;
                while (i7 < i4) {
                    f += fMatrix1Row.get(i7) * fMatrix1Row2.get(i6);
                    i7++;
                    i6++;
                }
                fMatrix1Row3.set(i2, f);
                i5++;
                i2++;
            }
            i += fMatrix1Row.numCols;
        }
    }

    public static void multAdd_reorder(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numCols != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numRows != fMatrix1Row3.numRows || fMatrix1Row2.numCols != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (fMatrix1Row.numCols == 0 || fMatrix1Row.numRows == 0) {
            return;
        }
        int i = fMatrix1Row2.numRows * fMatrix1Row2.numCols;
        int i2 = 0;
        for (int i3 = 0; i3 < fMatrix1Row.numRows; i3++) {
            int i4 = fMatrix1Row.numCols * i3;
            int i5 = fMatrix1Row2.numCols;
            int i6 = i4 + 1;
            float f = fMatrix1Row.get(i4);
            int i7 = 0;
            int i8 = i2;
            while (i7 < i5) {
                fMatrix1Row3.plus(i8, fMatrix1Row2.get(i7) * f);
                i8++;
                i7++;
            }
            while (i7 != i) {
                int i9 = fMatrix1Row2.numCols + i7;
                int i10 = i6 + 1;
                float f2 = fMatrix1Row.get(i6);
                int i11 = i2;
                while (i7 < i9) {
                    fMatrix1Row3.plus(i11, fMatrix1Row2.get(i7) * f2);
                    i11++;
                    i7++;
                }
                i6 = i10;
            }
            i2 += fMatrix1Row3.numCols;
        }
    }

    public static void multAdd_small(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numCols != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numRows != fMatrix1Row3.numRows || fMatrix1Row2.numCols != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < fMatrix1Row.numRows; i3++) {
            int i4 = 0;
            while (i4 < fMatrix1Row2.numCols) {
                int i5 = fMatrix1Row2.numRows + i;
                float f = 0.0f;
                int i6 = i4;
                for (int i7 = i; i7 < i5; i7++) {
                    f += fMatrix1Row.get(i7) * fMatrix1Row2.get(i6);
                    i6 += fMatrix1Row2.numCols;
                }
                fMatrix1Row3.plus(i2, f);
                i4++;
                i2++;
            }
            i += fMatrix1Row.numCols;
        }
    }

    public static void multAdd_aux(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3, float[] fArr) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numCols != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numRows != fMatrix1Row3.numRows || fMatrix1Row2.numCols != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (fArr == null) {
            fArr = new float[fMatrix1Row2.numRows];
        }
        for (int i = 0; i < fMatrix1Row2.numCols; i++) {
            for (int i2 = 0; i2 < fMatrix1Row2.numRows; i2++) {
                fArr[i2] = fMatrix1Row2.unsafe_get(i2, i);
            }
            int i3 = 0;
            for (int i4 = 0; i4 < fMatrix1Row.numRows; i4++) {
                float f = 0.0f;
                for (int i5 = 0; i5 < fMatrix1Row2.numRows; i5++) {
                    f += fMatrix1Row.get(i3) * fArr[i5];
                    i3++;
                }
                fMatrix1Row3.plus((fMatrix1Row3.numCols * i4) + i, f);
            }
        }
    }

    public static void multAddTransA_reorder(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numRows != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numCols != fMatrix1Row3.numRows || fMatrix1Row2.numCols != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (fMatrix1Row.numCols == 0 || fMatrix1Row.numRows == 0) {
            return;
        }
        for (int i = 0; i < fMatrix1Row.numCols; i++) {
            int i2 = fMatrix1Row3.numCols * i;
            float f = fMatrix1Row.get(i);
            int i3 = fMatrix1Row2.numCols;
            int i4 = 0;
            int i5 = i2;
            while (i4 < i3) {
                fMatrix1Row3.plus(i5, fMatrix1Row2.get(i4) * f);
                i5++;
                i4++;
            }
            for (int i6 = 1; i6 < fMatrix1Row.numRows; i6++) {
                float fUnsafe_get = fMatrix1Row.unsafe_get(i6, i);
                int i7 = fMatrix1Row2.numCols + i4;
                int i8 = i2;
                while (i4 < i7) {
                    fMatrix1Row3.plus(i8, fMatrix1Row2.get(i4) * fUnsafe_get);
                    i8++;
                    i4++;
                }
            }
        }
    }

    public static void multAddTransA_small(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numRows != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numCols != fMatrix1Row3.numRows || fMatrix1Row2.numCols != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < fMatrix1Row.numCols; i2++) {
            int i3 = 0;
            while (i3 < fMatrix1Row2.numCols) {
                int i4 = (fMatrix1Row2.numRows * fMatrix1Row2.numCols) + i3;
                float f = 0.0f;
                int i5 = i2;
                int i6 = i3;
                while (i6 < i4) {
                    f += fMatrix1Row.get(i5) * fMatrix1Row2.get(i6);
                    i5 += fMatrix1Row.numCols;
                    i6 += fMatrix1Row2.numCols;
                }
                fMatrix1Row3.plus(i, f);
                i3++;
                i++;
            }
        }
    }

    public static void multAddTransAB(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numRows != fMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numCols != fMatrix1Row3.numRows || fMatrix1Row2.numRows != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < fMatrix1Row.numCols; i2++) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < fMatrix1Row2.numRows) {
                int i5 = fMatrix1Row2.numCols + i4;
                float f = 0.0f;
                int i6 = i2;
                while (i4 < i5) {
                    f += fMatrix1Row.get(i6) * fMatrix1Row2.get(i4);
                    i6 += fMatrix1Row.numCols;
                    i4++;
                }
                fMatrix1Row3.plus(i, f);
                i3++;
                i++;
            }
        }
    }

    public static void multAddTransAB_aux(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3, float[] fArr) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numRows != fMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numCols != fMatrix1Row3.numRows || fMatrix1Row2.numRows != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (fArr == null) {
            fArr = new float[fMatrix1Row.numRows];
        }
        if (fMatrix1Row.numCols == 0 || fMatrix1Row.numRows == 0) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < fMatrix1Row.numCols; i2++) {
            for (int i3 = 0; i3 < fMatrix1Row2.numCols; i3++) {
                fArr[i3] = fMatrix1Row.unsafe_get(i3, i2);
            }
            int i4 = 0;
            while (i4 < fMatrix1Row2.numRows) {
                float fUnsafe_get = 0.0f;
                for (int i5 = 0; i5 < fMatrix1Row2.numCols; i5++) {
                    fUnsafe_get += fArr[i5] * fMatrix1Row2.unsafe_get(i4, i5);
                }
                fMatrix1Row3.plus(i, fUnsafe_get);
                i4++;
                i++;
            }
        }
    }

    public static void multAddTransB(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numCols != fMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numRows != fMatrix1Row3.numRows || fMatrix1Row2.numRows != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < fMatrix1Row.numRows; i3++) {
            int i4 = fMatrix1Row2.numCols + i;
            int i5 = 0;
            int i6 = 0;
            while (i5 < fMatrix1Row2.numRows) {
                float f = 0.0f;
                int i7 = i;
                while (i7 < i4) {
                    f += fMatrix1Row.get(i7) * fMatrix1Row2.get(i6);
                    i7++;
                    i6++;
                }
                fMatrix1Row3.plus(i2, f);
                i5++;
                i2++;
            }
            i += fMatrix1Row.numCols;
        }
    }

    public static void mult_reorder(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numCols != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numRows != fMatrix1Row3.numRows || fMatrix1Row2.numCols != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (fMatrix1Row.numCols == 0 || fMatrix1Row.numRows == 0) {
            CommonOps_FDRM.fill(fMatrix1Row3, 0.0f);
            return;
        }
        int i = fMatrix1Row2.numRows * fMatrix1Row2.numCols;
        int i2 = 0;
        for (int i3 = 0; i3 < fMatrix1Row.numRows; i3++) {
            int i4 = fMatrix1Row.numCols * i3;
            int i5 = fMatrix1Row2.numCols;
            int i6 = i4 + 1;
            float f2 = fMatrix1Row.get(i4) * f;
            int i7 = 0;
            int i8 = i2;
            while (i7 < i5) {
                fMatrix1Row3.set(i8, fMatrix1Row2.get(i7) * f2);
                i8++;
                i7++;
            }
            while (i7 != i) {
                int i9 = fMatrix1Row2.numCols + i7;
                int i10 = i6 + 1;
                float f3 = fMatrix1Row.get(i6) * f;
                int i11 = i2;
                while (i7 < i9) {
                    fMatrix1Row3.plus(i11, fMatrix1Row2.get(i7) * f3);
                    i11++;
                    i7++;
                }
                i6 = i10;
            }
            i2 += fMatrix1Row3.numCols;
        }
    }

    public static void mult_small(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numCols != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numRows != fMatrix1Row3.numRows || fMatrix1Row2.numCols != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < fMatrix1Row.numRows; i3++) {
            int i4 = 0;
            while (i4 < fMatrix1Row2.numCols) {
                int i5 = fMatrix1Row2.numRows + i;
                float f2 = 0.0f;
                int i6 = i4;
                for (int i7 = i; i7 < i5; i7++) {
                    f2 += fMatrix1Row.get(i7) * fMatrix1Row2.get(i6);
                    i6 += fMatrix1Row2.numCols;
                }
                fMatrix1Row3.set(i2, f2 * f);
                i4++;
                i2++;
            }
            i += fMatrix1Row.numCols;
        }
    }

    public static void mult_aux(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3, float[] fArr) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numCols != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numRows != fMatrix1Row3.numRows || fMatrix1Row2.numCols != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (fArr == null) {
            fArr = new float[fMatrix1Row2.numRows];
        }
        for (int i = 0; i < fMatrix1Row2.numCols; i++) {
            for (int i2 = 0; i2 < fMatrix1Row2.numRows; i2++) {
                fArr[i2] = fMatrix1Row2.unsafe_get(i2, i);
            }
            int i3 = 0;
            for (int i4 = 0; i4 < fMatrix1Row.numRows; i4++) {
                float f2 = 0.0f;
                for (int i5 = 0; i5 < fMatrix1Row2.numRows; i5++) {
                    f2 += fMatrix1Row.get(i3) * fArr[i5];
                    i3++;
                }
                fMatrix1Row3.set((fMatrix1Row3.numCols * i4) + i, f2 * f);
            }
        }
    }

    public static void multTransA_reorder(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numRows != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numCols != fMatrix1Row3.numRows || fMatrix1Row2.numCols != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (fMatrix1Row.numCols == 0 || fMatrix1Row.numRows == 0) {
            CommonOps_FDRM.fill(fMatrix1Row3, 0.0f);
            return;
        }
        for (int i = 0; i < fMatrix1Row.numCols; i++) {
            int i2 = fMatrix1Row3.numCols * i;
            float f2 = fMatrix1Row.get(i) * f;
            int i3 = fMatrix1Row2.numCols;
            int i4 = 0;
            int i5 = i2;
            while (i4 < i3) {
                fMatrix1Row3.set(i5, fMatrix1Row2.get(i4) * f2);
                i5++;
                i4++;
            }
            for (int i6 = 1; i6 < fMatrix1Row.numRows; i6++) {
                float fUnsafe_get = fMatrix1Row.unsafe_get(i6, i) * f;
                int i7 = fMatrix1Row2.numCols + i4;
                int i8 = i2;
                while (i4 < i7) {
                    fMatrix1Row3.plus(i8, fMatrix1Row2.get(i4) * fUnsafe_get);
                    i8++;
                    i4++;
                }
            }
        }
    }

    public static void multTransA_small(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numRows != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numCols != fMatrix1Row3.numRows || fMatrix1Row2.numCols != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < fMatrix1Row.numCols; i2++) {
            int i3 = 0;
            while (i3 < fMatrix1Row2.numCols) {
                int i4 = (fMatrix1Row2.numRows * fMatrix1Row2.numCols) + i3;
                float f2 = 0.0f;
                int i5 = i2;
                int i6 = i3;
                while (i6 < i4) {
                    f2 += fMatrix1Row.get(i5) * fMatrix1Row2.get(i6);
                    i5 += fMatrix1Row.numCols;
                    i6 += fMatrix1Row2.numCols;
                }
                fMatrix1Row3.set(i, f2 * f);
                i3++;
                i++;
            }
        }
    }

    public static void multTransAB(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numRows != fMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numCols != fMatrix1Row3.numRows || fMatrix1Row2.numRows != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < fMatrix1Row.numCols; i2++) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < fMatrix1Row2.numRows) {
                int i5 = fMatrix1Row2.numCols + i4;
                float f2 = 0.0f;
                int i6 = i2;
                while (i4 < i5) {
                    f2 += fMatrix1Row.get(i6) * fMatrix1Row2.get(i4);
                    i6 += fMatrix1Row.numCols;
                    i4++;
                }
                fMatrix1Row3.set(i, f2 * f);
                i3++;
                i++;
            }
        }
    }

    public static void multTransAB_aux(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3, float[] fArr) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numRows != fMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numCols != fMatrix1Row3.numRows || fMatrix1Row2.numRows != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (fArr == null) {
            fArr = new float[fMatrix1Row.numRows];
        }
        if (fMatrix1Row.numCols == 0 || fMatrix1Row.numRows == 0) {
            CommonOps_FDRM.fill(fMatrix1Row3, 0.0f);
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < fMatrix1Row.numCols; i2++) {
            for (int i3 = 0; i3 < fMatrix1Row2.numCols; i3++) {
                fArr[i3] = fMatrix1Row.unsafe_get(i3, i2);
            }
            int i4 = 0;
            while (i4 < fMatrix1Row2.numRows) {
                float fUnsafe_get = 0.0f;
                for (int i5 = 0; i5 < fMatrix1Row2.numCols; i5++) {
                    fUnsafe_get += fArr[i5] * fMatrix1Row2.unsafe_get(i4, i5);
                }
                fMatrix1Row3.set(i, fUnsafe_get * f);
                i4++;
                i++;
            }
        }
    }

    public static void multTransB(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numCols != fMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numRows != fMatrix1Row3.numRows || fMatrix1Row2.numRows != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < fMatrix1Row.numRows; i3++) {
            int i4 = fMatrix1Row2.numCols + i;
            int i5 = 0;
            int i6 = 0;
            while (i5 < fMatrix1Row2.numRows) {
                float f2 = 0.0f;
                int i7 = i;
                while (i7 < i4) {
                    f2 += fMatrix1Row.get(i7) * fMatrix1Row2.get(i6);
                    i7++;
                    i6++;
                }
                fMatrix1Row3.set(i2, f2 * f);
                i5++;
                i2++;
            }
            i += fMatrix1Row.numCols;
        }
    }

    public static void multAdd_reorder(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numCols != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numRows != fMatrix1Row3.numRows || fMatrix1Row2.numCols != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (fMatrix1Row.numCols == 0 || fMatrix1Row.numRows == 0) {
            return;
        }
        int i = fMatrix1Row2.numRows * fMatrix1Row2.numCols;
        int i2 = 0;
        for (int i3 = 0; i3 < fMatrix1Row.numRows; i3++) {
            int i4 = fMatrix1Row.numCols * i3;
            int i5 = fMatrix1Row2.numCols;
            int i6 = i4 + 1;
            float f2 = fMatrix1Row.get(i4) * f;
            int i7 = 0;
            int i8 = i2;
            while (i7 < i5) {
                fMatrix1Row3.plus(i8, fMatrix1Row2.get(i7) * f2);
                i8++;
                i7++;
            }
            while (i7 != i) {
                int i9 = fMatrix1Row2.numCols + i7;
                int i10 = i6 + 1;
                float f3 = fMatrix1Row.get(i6) * f;
                int i11 = i2;
                while (i7 < i9) {
                    fMatrix1Row3.plus(i11, fMatrix1Row2.get(i7) * f3);
                    i11++;
                    i7++;
                }
                i6 = i10;
            }
            i2 += fMatrix1Row3.numCols;
        }
    }

    public static void multAdd_small(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numCols != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numRows != fMatrix1Row3.numRows || fMatrix1Row2.numCols != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < fMatrix1Row.numRows; i3++) {
            int i4 = 0;
            while (i4 < fMatrix1Row2.numCols) {
                int i5 = fMatrix1Row2.numRows + i;
                float f2 = 0.0f;
                int i6 = i4;
                for (int i7 = i; i7 < i5; i7++) {
                    f2 += fMatrix1Row.get(i7) * fMatrix1Row2.get(i6);
                    i6 += fMatrix1Row2.numCols;
                }
                fMatrix1Row3.plus(i2, f2 * f);
                i4++;
                i2++;
            }
            i += fMatrix1Row.numCols;
        }
    }

    public static void multAdd_aux(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3, float[] fArr) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numCols != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numRows != fMatrix1Row3.numRows || fMatrix1Row2.numCols != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (fArr == null) {
            fArr = new float[fMatrix1Row2.numRows];
        }
        for (int i = 0; i < fMatrix1Row2.numCols; i++) {
            for (int i2 = 0; i2 < fMatrix1Row2.numRows; i2++) {
                fArr[i2] = fMatrix1Row2.unsafe_get(i2, i);
            }
            int i3 = 0;
            for (int i4 = 0; i4 < fMatrix1Row.numRows; i4++) {
                float f2 = 0.0f;
                for (int i5 = 0; i5 < fMatrix1Row2.numRows; i5++) {
                    f2 += fMatrix1Row.get(i3) * fArr[i5];
                    i3++;
                }
                fMatrix1Row3.plus((fMatrix1Row3.numCols * i4) + i, f2 * f);
            }
        }
    }

    public static void multAddTransA_reorder(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numRows != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numCols != fMatrix1Row3.numRows || fMatrix1Row2.numCols != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (fMatrix1Row.numCols == 0 || fMatrix1Row.numRows == 0) {
            return;
        }
        for (int i = 0; i < fMatrix1Row.numCols; i++) {
            int i2 = fMatrix1Row3.numCols * i;
            float f2 = fMatrix1Row.get(i) * f;
            int i3 = fMatrix1Row2.numCols;
            int i4 = 0;
            int i5 = i2;
            while (i4 < i3) {
                fMatrix1Row3.plus(i5, fMatrix1Row2.get(i4) * f2);
                i5++;
                i4++;
            }
            for (int i6 = 1; i6 < fMatrix1Row.numRows; i6++) {
                float fUnsafe_get = fMatrix1Row.unsafe_get(i6, i) * f;
                int i7 = fMatrix1Row2.numCols + i4;
                int i8 = i2;
                while (i4 < i7) {
                    fMatrix1Row3.plus(i8, fMatrix1Row2.get(i4) * fUnsafe_get);
                    i8++;
                    i4++;
                }
            }
        }
    }

    public static void multAddTransA_small(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numRows != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numCols != fMatrix1Row3.numRows || fMatrix1Row2.numCols != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < fMatrix1Row.numCols; i2++) {
            int i3 = 0;
            while (i3 < fMatrix1Row2.numCols) {
                int i4 = (fMatrix1Row2.numRows * fMatrix1Row2.numCols) + i3;
                float f2 = 0.0f;
                int i5 = i2;
                int i6 = i3;
                while (i6 < i4) {
                    f2 += fMatrix1Row.get(i5) * fMatrix1Row2.get(i6);
                    i5 += fMatrix1Row.numCols;
                    i6 += fMatrix1Row2.numCols;
                }
                fMatrix1Row3.plus(i, f2 * f);
                i3++;
                i++;
            }
        }
    }

    public static void multAddTransAB(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numRows != fMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numCols != fMatrix1Row3.numRows || fMatrix1Row2.numRows != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < fMatrix1Row.numCols; i2++) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < fMatrix1Row2.numRows) {
                int i5 = fMatrix1Row2.numCols + i4;
                float f2 = 0.0f;
                int i6 = i2;
                while (i4 < i5) {
                    f2 += fMatrix1Row.get(i6) * fMatrix1Row2.get(i4);
                    i6 += fMatrix1Row.numCols;
                    i4++;
                }
                fMatrix1Row3.plus(i, f2 * f);
                i3++;
                i++;
            }
        }
    }

    public static void multAddTransAB_aux(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3, float[] fArr) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numRows != fMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numCols != fMatrix1Row3.numRows || fMatrix1Row2.numRows != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (fArr == null) {
            fArr = new float[fMatrix1Row.numRows];
        }
        if (fMatrix1Row.numCols == 0 || fMatrix1Row.numRows == 0) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < fMatrix1Row.numCols; i2++) {
            for (int i3 = 0; i3 < fMatrix1Row2.numCols; i3++) {
                fArr[i3] = fMatrix1Row.unsafe_get(i3, i2);
            }
            int i4 = 0;
            while (i4 < fMatrix1Row2.numRows) {
                float fUnsafe_get = 0.0f;
                for (int i5 = 0; i5 < fMatrix1Row2.numCols; i5++) {
                    fUnsafe_get += fArr[i5] * fMatrix1Row2.unsafe_get(i4, i5);
                }
                fMatrix1Row3.plus(i, fUnsafe_get * f);
                i4++;
                i++;
            }
        }
    }

    public static void multAddTransB(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row == fMatrix1Row3 || fMatrix1Row2 == fMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (fMatrix1Row.numCols != fMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (fMatrix1Row.numRows != fMatrix1Row3.numRows || fMatrix1Row2.numRows != fMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < fMatrix1Row.numRows; i3++) {
            int i4 = fMatrix1Row2.numCols + i;
            int i5 = 0;
            int i6 = 0;
            while (i5 < fMatrix1Row2.numRows) {
                float f2 = 0.0f;
                int i7 = i;
                while (i7 < i4) {
                    f2 += fMatrix1Row.get(i7) * fMatrix1Row2.get(i6);
                    i7++;
                    i6++;
                }
                fMatrix1Row3.plus(i2, f2 * f);
                i5++;
                i2++;
            }
            i += fMatrix1Row.numCols;
        }
    }
}
