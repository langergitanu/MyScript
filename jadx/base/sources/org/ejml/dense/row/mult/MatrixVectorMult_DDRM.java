package org.ejml.dense.row.mult;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.MatrixDimensionException;
import org.ejml.data.DMatrix1Row;
import org.ejml.data.DMatrixD1;
import org.ejml.dense.row.CommonOps_DDRM;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixVectorMult_DDRM {
    public static void mult(DMatrix1Row dMatrix1Row, DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD12.numCols != 1) {
            throw new MatrixDimensionException("C is not a column vector");
        }
        if (dMatrixD12.numRows != dMatrix1Row.numRows) {
            throw new MatrixDimensionException("C is not the expected length");
        }
        if (dMatrixD1.numRows == 1) {
            if (dMatrix1Row.numCols != dMatrixD1.numCols) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else if (dMatrixD1.numCols == 1) {
            if (dMatrix1Row.numCols != dMatrixD1.numRows) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else {
            throw new MatrixDimensionException("B is not a vector");
        }
        if (dMatrix1Row.numCols == 0) {
            CommonOps_DDRM.fill(dMatrixD12, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            return;
        }
        int i = 0;
        double d = dMatrixD1.get(0);
        int i2 = 0;
        int i3 = 0;
        while (i < dMatrix1Row.numRows) {
            double d2 = dMatrix1Row.get(i2) * d;
            i2++;
            int i4 = 1;
            while (i4 < dMatrix1Row.numCols) {
                d2 += dMatrix1Row.get(i2) * dMatrixD1.get(i4);
                i4++;
                i2++;
            }
            dMatrixD12.set(i3, d2);
            i++;
            i3++;
        }
    }

    public static void multAdd(DMatrix1Row dMatrix1Row, DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD12.numCols != 1) {
            throw new MatrixDimensionException("C is not a column vector");
        }
        if (dMatrixD12.numRows != dMatrix1Row.numRows) {
            throw new MatrixDimensionException("C is not the expected length");
        }
        if (dMatrixD1.numRows == 1) {
            if (dMatrix1Row.numCols != dMatrixD1.numCols) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else if (dMatrixD1.numCols == 1) {
            if (dMatrix1Row.numCols != dMatrixD1.numRows) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else {
            throw new MatrixDimensionException("B is not a vector");
        }
        if (dMatrix1Row.numCols == 0) {
            return;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < dMatrix1Row.numRows) {
            double d = dMatrix1Row.get(i2) * dMatrixD1.get(0);
            i2++;
            int i4 = 1;
            while (i4 < dMatrix1Row.numCols) {
                d += dMatrix1Row.get(i2) * dMatrixD1.get(i4);
                i4++;
                i2++;
            }
            dMatrixD12.plus(i3, d);
            i++;
            i3++;
        }
    }

    public static void multTransA_small(DMatrix1Row dMatrix1Row, DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD12.numCols != 1) {
            throw new MatrixDimensionException("C is not a column vector");
        }
        if (dMatrixD12.numRows != dMatrix1Row.numCols) {
            throw new MatrixDimensionException("C is not the expected length");
        }
        if (dMatrixD1.numRows == 1) {
            if (dMatrix1Row.numRows != dMatrixD1.numCols) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else if (dMatrixD1.numCols == 1) {
            if (dMatrix1Row.numRows != dMatrixD1.numRows) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else {
            throw new MatrixDimensionException("B is not a vector");
        }
        int i = 0;
        int i2 = 0;
        while (i < dMatrix1Row.numCols) {
            double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            int i3 = i;
            for (int i4 = 0; i4 < dMatrix1Row.numRows; i4++) {
                d += dMatrix1Row.get(i3) * dMatrixD1.get(i4);
                i3 += dMatrix1Row.numCols;
            }
            dMatrixD12.set(i2, d);
            i++;
            i2++;
        }
    }

    public static void multTransA_reorder(DMatrix1Row dMatrix1Row, DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD12.numCols != 1) {
            throw new MatrixDimensionException("C is not a column vector");
        }
        if (dMatrixD12.numRows != dMatrix1Row.numCols) {
            throw new MatrixDimensionException("C is not the expected length");
        }
        if (dMatrixD1.numRows == 1) {
            if (dMatrix1Row.numRows != dMatrixD1.numCols) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else if (dMatrixD1.numCols == 1) {
            if (dMatrix1Row.numRows != dMatrixD1.numRows) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else {
            throw new MatrixDimensionException("B is not a vector");
        }
        if (dMatrix1Row.numRows == 0) {
            CommonOps_DDRM.fill(dMatrixD12, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            return;
        }
        double d = dMatrixD1.get(0);
        for (int i = 0; i < dMatrix1Row.numCols; i++) {
            dMatrixD12.set(i, dMatrix1Row.get(i) * d);
        }
        int i2 = dMatrix1Row.numCols;
        for (int i3 = 1; i3 < dMatrix1Row.numRows; i3++) {
            double d2 = dMatrixD1.get(i3);
            int i4 = 0;
            while (i4 < dMatrix1Row.numCols) {
                dMatrixD12.plus(i4, dMatrix1Row.get(i2) * d2);
                i4++;
                i2++;
            }
        }
    }

    public static void multAddTransA_small(DMatrix1Row dMatrix1Row, DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD12.numCols != 1) {
            throw new MatrixDimensionException("C is not a column vector");
        }
        if (dMatrixD12.numRows != dMatrix1Row.numCols) {
            throw new MatrixDimensionException("C is not the expected length");
        }
        if (dMatrixD1.numRows == 1) {
            if (dMatrix1Row.numRows != dMatrixD1.numCols) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else if (dMatrixD1.numCols == 1) {
            if (dMatrix1Row.numRows != dMatrixD1.numRows) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else {
            throw new MatrixDimensionException("B is not a vector");
        }
        int i = 0;
        int i2 = 0;
        while (i < dMatrix1Row.numCols) {
            double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            int i3 = i;
            for (int i4 = 0; i4 < dMatrix1Row.numRows; i4++) {
                d += dMatrix1Row.get(i3) * dMatrixD1.get(i4);
                i3 += dMatrix1Row.numCols;
            }
            dMatrixD12.plus(i2, d);
            i++;
            i2++;
        }
    }

    public static void multAddTransA_reorder(DMatrix1Row dMatrix1Row, DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD12.numCols != 1) {
            throw new MatrixDimensionException("C is not a column vector");
        }
        if (dMatrixD12.numRows != dMatrix1Row.numCols) {
            throw new MatrixDimensionException("C is not the expected length");
        }
        if (dMatrixD1.numRows == 1) {
            if (dMatrix1Row.numRows != dMatrixD1.numCols) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else if (dMatrixD1.numCols == 1) {
            if (dMatrix1Row.numRows != dMatrixD1.numRows) {
                throw new MatrixDimensionException("A and B are not compatible");
            }
        } else {
            throw new MatrixDimensionException("B is not a vector");
        }
        if (dMatrix1Row.numRows == 0) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < dMatrix1Row.numRows; i2++) {
            double d = dMatrixD1.get(i2);
            int i3 = 0;
            while (i3 < dMatrix1Row.numCols) {
                dMatrixD12.plus(i3, dMatrix1Row.get(i) * d);
                i3++;
                i++;
            }
        }
    }
}
