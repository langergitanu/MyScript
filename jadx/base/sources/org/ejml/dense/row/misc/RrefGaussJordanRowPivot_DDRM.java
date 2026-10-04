package org.ejml.dense.row.misc;

import org.ejml.data.DMatrixRMaj;
import org.ejml.interfaces.linsol.ReducedRowEchelonForm_F64;

/* JADX INFO: loaded from: classes9.dex */
public class RrefGaussJordanRowPivot_DDRM implements ReducedRowEchelonForm_F64<DMatrixRMaj> {
    double tol;

    @Override // org.ejml.interfaces.linsol.ReducedRowEchelonForm_F64
    public void setTolerance(double d) {
        this.tol = d;
    }

    @Override // org.ejml.interfaces.linsol.ReducedRowEchelonForm
    public void reduce(DMatrixRMaj dMatrixRMaj, int i) {
        if (dMatrixRMaj.numCols < i) {
            throw new IllegalArgumentException("The system must be at least as wide as A");
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            double d = this.tol;
            int i4 = -1;
            for (int i5 = i2; i5 < dMatrixRMaj.numRows; i5++) {
                double dAbs = Math.abs(dMatrixRMaj.data[(dMatrixRMaj.numCols * i5) + i3]);
                if (dAbs > d) {
                    i4 = i5;
                    d = dAbs;
                }
            }
            if (i4 != -1) {
                if (i2 != i4) {
                    swapRows(dMatrixRMaj, i2, i4);
                }
                for (int i6 = 0; i6 < dMatrixRMaj.numRows; i6++) {
                    if (i6 != i2) {
                        int i7 = (dMatrixRMaj.numCols * i2) + i3;
                        int i8 = (dMatrixRMaj.numCols * i6) + i3;
                        int i9 = i7 + 1;
                        double d2 = dMatrixRMaj.data[i8] / dMatrixRMaj.data[i7];
                        int i10 = i8 + 1;
                        dMatrixRMaj.data[i8] = 0.0d;
                        int i11 = i3 + 1;
                        while (i11 < dMatrixRMaj.numCols) {
                            double[] dArr = dMatrixRMaj.data;
                            dArr[i10] = dArr[i10] - (dMatrixRMaj.data[i9] * d2);
                            i11++;
                            i10++;
                            i9++;
                        }
                    }
                }
                int i12 = (dMatrixRMaj.numCols * i2) + i3;
                double d3 = 1.0d / dMatrixRMaj.data[i12];
                int i13 = i12 + 1;
                dMatrixRMaj.data[i12] = 1.0d;
                int i14 = i3 + 1;
                while (i14 < dMatrixRMaj.numCols) {
                    double[] dArr2 = dMatrixRMaj.data;
                    dArr2[i13] = dArr2[i13] * d3;
                    i14++;
                    i13++;
                }
                i2++;
            }
        }
    }

    protected static void swapRows(DMatrixRMaj dMatrixRMaj, int i, int i2) {
        int i3 = i * dMatrixRMaj.numCols;
        int i4 = i2 * dMatrixRMaj.numCols;
        int i5 = 0;
        while (i5 < dMatrixRMaj.numCols) {
            double d = dMatrixRMaj.data[i3];
            dMatrixRMaj.data[i3] = dMatrixRMaj.data[i4];
            dMatrixRMaj.data[i4] = d;
            i5++;
            i3++;
            i4++;
        }
    }
}
