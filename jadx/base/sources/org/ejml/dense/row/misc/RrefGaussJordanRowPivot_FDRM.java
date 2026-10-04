package org.ejml.dense.row.misc;

import org.ejml.data.FMatrixRMaj;
import org.ejml.interfaces.linsol.ReducedRowEchelonForm_F32;

/* JADX INFO: loaded from: classes9.dex */
public class RrefGaussJordanRowPivot_FDRM implements ReducedRowEchelonForm_F32<FMatrixRMaj> {
    float tol;

    @Override // org.ejml.interfaces.linsol.ReducedRowEchelonForm_F32
    public void setTolerance(float f) {
        this.tol = f;
    }

    @Override // org.ejml.interfaces.linsol.ReducedRowEchelonForm
    public void reduce(FMatrixRMaj fMatrixRMaj, int i) {
        if (fMatrixRMaj.numCols < i) {
            throw new IllegalArgumentException("The system must be at least as wide as A");
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f = this.tol;
            int i4 = -1;
            for (int i5 = i2; i5 < fMatrixRMaj.numRows; i5++) {
                float fAbs = Math.abs(fMatrixRMaj.data[(fMatrixRMaj.numCols * i5) + i3]);
                if (fAbs > f) {
                    i4 = i5;
                    f = fAbs;
                }
            }
            if (i4 != -1) {
                if (i2 != i4) {
                    swapRows(fMatrixRMaj, i2, i4);
                }
                for (int i6 = 0; i6 < fMatrixRMaj.numRows; i6++) {
                    if (i6 != i2) {
                        int i7 = (fMatrixRMaj.numCols * i2) + i3;
                        int i8 = (fMatrixRMaj.numCols * i6) + i3;
                        int i9 = i7 + 1;
                        float f2 = fMatrixRMaj.data[i8] / fMatrixRMaj.data[i7];
                        int i10 = i8 + 1;
                        fMatrixRMaj.data[i8] = 0.0f;
                        int i11 = i3 + 1;
                        while (i11 < fMatrixRMaj.numCols) {
                            float[] fArr = fMatrixRMaj.data;
                            fArr[i10] = fArr[i10] - (fMatrixRMaj.data[i9] * f2);
                            i11++;
                            i10++;
                            i9++;
                        }
                    }
                }
                int i12 = (fMatrixRMaj.numCols * i2) + i3;
                float f3 = 1.0f / fMatrixRMaj.data[i12];
                int i13 = i12 + 1;
                fMatrixRMaj.data[i12] = 1.0f;
                int i14 = i3 + 1;
                while (i14 < fMatrixRMaj.numCols) {
                    float[] fArr2 = fMatrixRMaj.data;
                    fArr2[i13] = fArr2[i13] * f3;
                    i14++;
                    i13++;
                }
                i2++;
            }
        }
    }

    protected static void swapRows(FMatrixRMaj fMatrixRMaj, int i, int i2) {
        int i3 = i * fMatrixRMaj.numCols;
        int i4 = i2 * fMatrixRMaj.numCols;
        int i5 = 0;
        while (i5 < fMatrixRMaj.numCols) {
            float f = fMatrixRMaj.data[i3];
            fMatrixRMaj.data[i3] = fMatrixRMaj.data[i4];
            fMatrixRMaj.data[i4] = f;
            i5++;
            i3++;
            i4++;
        }
    }
}
