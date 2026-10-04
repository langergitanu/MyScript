package org.ejml.dense.row.mult;

import org.ejml.MatrixDimensionException;
import org.ejml.data.FMatrix1Row;
import org.ejml.data.FMatrixD1;
import org.ejml.dense.row.CommonOps_FDRM;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixVectorMult_FDRM {
    public static void mult(FMatrix1Row fMatrix1Row, FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD12.numCols != 1) {
            throw new MatrixDimensionException("C is not a column vector");
        }
        if (fMatrixD12.numRows != fMatrix1Row.numRows) {
            throw new MatrixDimensionException("C is not the expected length");
        }
        if (fMatrixD1.numRows == 1) {
            if (fMatrix1Row.numCols != fMatrixD1.numCols) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else if (fMatrixD1.numCols == 1) {
            if (fMatrix1Row.numCols != fMatrixD1.numRows) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else {
            throw new MatrixDimensionException("B is not a vector");
        }
        if (fMatrix1Row.numCols == 0) {
            CommonOps_FDRM.fill(fMatrixD12, 0.0f);
            return;
        }
        int i = 0;
        float f = fMatrixD1.get(0);
        int i2 = 0;
        int i3 = 0;
        while (i < fMatrix1Row.numRows) {
            int i4 = i2 + 1;
            float f2 = fMatrix1Row.get(i2) * f;
            int i5 = 1;
            while (i5 < fMatrix1Row.numCols) {
                f2 += fMatrix1Row.get(i4) * fMatrixD1.get(i5);
                i5++;
                i4++;
            }
            fMatrixD12.set(i3, f2);
            i++;
            i2 = i4;
            i3++;
        }
    }

    public static void multAdd(FMatrix1Row fMatrix1Row, FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD12.numCols != 1) {
            throw new MatrixDimensionException("C is not a column vector");
        }
        if (fMatrixD12.numRows != fMatrix1Row.numRows) {
            throw new MatrixDimensionException("C is not the expected length");
        }
        if (fMatrixD1.numRows == 1) {
            if (fMatrix1Row.numCols != fMatrixD1.numCols) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else if (fMatrixD1.numCols == 1) {
            if (fMatrix1Row.numCols != fMatrixD1.numRows) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else {
            throw new MatrixDimensionException("B is not a vector");
        }
        if (fMatrix1Row.numCols == 0) {
            return;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < fMatrix1Row.numRows) {
            int i4 = i2 + 1;
            float f = fMatrix1Row.get(i2) * fMatrixD1.get(0);
            int i5 = 1;
            while (i5 < fMatrix1Row.numCols) {
                f += fMatrix1Row.get(i4) * fMatrixD1.get(i5);
                i5++;
                i4++;
            }
            fMatrixD12.plus(i3, f);
            i++;
            i2 = i4;
            i3++;
        }
    }

    public static void multTransA_small(FMatrix1Row fMatrix1Row, FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD12.numCols != 1) {
            throw new MatrixDimensionException("C is not a column vector");
        }
        if (fMatrixD12.numRows != fMatrix1Row.numCols) {
            throw new MatrixDimensionException("C is not the expected length");
        }
        if (fMatrixD1.numRows == 1) {
            if (fMatrix1Row.numRows != fMatrixD1.numCols) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else if (fMatrixD1.numCols == 1) {
            if (fMatrix1Row.numRows != fMatrixD1.numRows) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else {
            throw new MatrixDimensionException("B is not a vector");
        }
        int i = 0;
        int i2 = 0;
        while (i < fMatrix1Row.numCols) {
            float f = 0.0f;
            int i3 = i;
            for (int i4 = 0; i4 < fMatrix1Row.numRows; i4++) {
                f += fMatrix1Row.get(i3) * fMatrixD1.get(i4);
                i3 += fMatrix1Row.numCols;
            }
            fMatrixD12.set(i2, f);
            i++;
            i2++;
        }
    }

    public static void multTransA_reorder(FMatrix1Row fMatrix1Row, FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD12.numCols != 1) {
            throw new MatrixDimensionException("C is not a column vector");
        }
        if (fMatrixD12.numRows != fMatrix1Row.numCols) {
            throw new MatrixDimensionException("C is not the expected length");
        }
        if (fMatrixD1.numRows == 1) {
            if (fMatrix1Row.numRows != fMatrixD1.numCols) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else if (fMatrixD1.numCols == 1) {
            if (fMatrix1Row.numRows != fMatrixD1.numRows) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else {
            throw new MatrixDimensionException("B is not a vector");
        }
        if (fMatrix1Row.numRows == 0) {
            CommonOps_FDRM.fill(fMatrixD12, 0.0f);
            return;
        }
        float f = fMatrixD1.get(0);
        for (int i = 0; i < fMatrix1Row.numCols; i++) {
            fMatrixD12.set(i, fMatrix1Row.get(i) * f);
        }
        int i2 = fMatrix1Row.numCols;
        for (int i3 = 1; i3 < fMatrix1Row.numRows; i3++) {
            float f2 = fMatrixD1.get(i3);
            int i4 = 0;
            while (i4 < fMatrix1Row.numCols) {
                fMatrixD12.plus(i4, fMatrix1Row.get(i2) * f2);
                i4++;
                i2++;
            }
        }
    }

    public static void multAddTransA_small(FMatrix1Row fMatrix1Row, FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD12.numCols != 1) {
            throw new MatrixDimensionException("C is not a column vector");
        }
        if (fMatrixD12.numRows != fMatrix1Row.numCols) {
            throw new MatrixDimensionException("C is not the expected length");
        }
        if (fMatrixD1.numRows == 1) {
            if (fMatrix1Row.numRows != fMatrixD1.numCols) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else if (fMatrixD1.numCols == 1) {
            if (fMatrix1Row.numRows != fMatrixD1.numRows) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else {
            throw new MatrixDimensionException("B is not a vector");
        }
        int i = 0;
        int i2 = 0;
        while (i < fMatrix1Row.numCols) {
            float f = 0.0f;
            int i3 = i;
            for (int i4 = 0; i4 < fMatrix1Row.numRows; i4++) {
                f += fMatrix1Row.get(i3) * fMatrixD1.get(i4);
                i3 += fMatrix1Row.numCols;
            }
            fMatrixD12.plus(i2, f);
            i++;
            i2++;
        }
    }

    public static void multAddTransA_reorder(FMatrix1Row fMatrix1Row, FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD12.numCols != 1) {
            throw new MatrixDimensionException("C is not a column vector");
        }
        if (fMatrixD12.numRows != fMatrix1Row.numCols) {
            throw new MatrixDimensionException("C is not the expected length");
        }
        if (fMatrixD1.numRows == 1) {
            if (fMatrix1Row.numRows != fMatrixD1.numCols) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else if (fMatrixD1.numCols == 1) {
            if (fMatrix1Row.numRows != fMatrixD1.numRows) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else {
            throw new MatrixDimensionException("B is not a vector");
        }
        if (fMatrix1Row.numRows == 0) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < fMatrix1Row.numRows; i2++) {
            float f = fMatrixD1.get(i2);
            int i3 = 0;
            while (i3 < fMatrix1Row.numCols) {
                fMatrixD12.plus(i3, fMatrix1Row.get(i) * f);
                i3++;
                i++;
            }
        }
    }
}
