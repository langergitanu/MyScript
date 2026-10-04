package org.ejml.dense.row.decomposition.chol;

import org.ejml.data.DMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class CholeskyDecompositionBlock_DDRM extends CholeskyDecompositionCommon_DDRM {

    /* JADX INFO: renamed from: B */
    private DMatrixRMaj f2517B;
    private int blockWidth;
    private CholeskyBlockHelper_DDRM chol;

    public CholeskyDecompositionBlock_DDRM(int i) {
        super(true);
        this.blockWidth = i;
    }

    @Override // org.ejml.dense.row.decomposition.chol.CholeskyDecompositionCommon_DDRM
    public void setExpectedMaxSize(int i, int i2) {
        super.setExpectedMaxSize(i, i2);
        if (i < this.blockWidth) {
            this.f2517B = new DMatrixRMaj(0, 0);
        } else {
            this.f2517B = new DMatrixRMaj(this.blockWidth, this.maxWidth);
        }
        this.chol = new CholeskyBlockHelper_DDRM(this.blockWidth);
    }

    @Override // org.ejml.dense.row.decomposition.chol.CholeskyDecompositionCommon_DDRM
    protected boolean decomposeLower() {
        int i = this.f2520n;
        int i2 = this.blockWidth;
        int i3 = 0;
        if (i < i2) {
            this.f2517B.reshape(0, 0, false);
        } else {
            this.f2517B.reshape(i2, this.f2520n - this.blockWidth, false);
        }
        int i4 = this.f2520n / this.blockWidth;
        int i5 = this.f2520n % this.blockWidth;
        if (i5 > 0) {
            i4++;
        }
        this.f2517B.numCols = this.f2520n;
        for (int i6 = 0; i6 < i4; i6++) {
            this.f2517B.numCols -= this.blockWidth;
            if (this.f2517B.numCols > 0) {
                CholeskyBlockHelper_DDRM choleskyBlockHelper_DDRM = this.chol;
                DMatrixRMaj dMatrixRMaj = this.f2519T;
                int i7 = this.blockWidth * i6 * this.f2519T.numCols;
                int i8 = this.blockWidth;
                if (!choleskyBlockHelper_DDRM.decompose(dMatrixRMaj, i7 + (i6 * i8), i8)) {
                    return false;
                }
                int i9 = this.blockWidth * i6 * this.f2519T.numCols;
                int i10 = i6 + 1;
                int i11 = this.blockWidth;
                solveL_special(this.chol.getL().data, this.f2519T, i9 + (i10 * i11), (i11 * i10 * this.f2519T.numCols) + (this.blockWidth * i6), this.f2517B);
                symmRankTranA_sub(this.f2517B, this.f2519T, (this.blockWidth * i10 * this.f2520n) + (i10 * this.blockWidth));
            } else {
                if (!this.chol.decompose(this.f2519T, (this.blockWidth * i6 * this.f2519T.numCols) + (this.blockWidth * i6), i5 > 0 ? i5 : this.blockWidth)) {
                    return false;
                }
            }
        }
        while (i3 < this.f2520n) {
            int i12 = i3 + 1;
            for (int i13 = i12; i13 < this.f2520n; i13++) {
                this.f2521t[(this.f2520n * i3) + i13] = 0.0d;
            }
            i3 = i12;
        }
        return true;
    }

    @Override // org.ejml.dense.row.decomposition.chol.CholeskyDecompositionCommon_DDRM
    protected boolean decomposeUpper() {
        throw new RuntimeException("Not implemented.  Do a lower decomposition and transpose it...");
    }

    public static void solveL_special(double[] dArr, DMatrixRMaj dMatrixRMaj, int i, int i2, DMatrixRMaj dMatrixRMaj2) {
        double[] dArr2 = dMatrixRMaj.data;
        double[] dArr3 = dMatrixRMaj2.data;
        int i3 = dMatrixRMaj2.numRows;
        int i4 = dMatrixRMaj2.numCols;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = 0;
            int i7 = 0;
            int i8 = i5;
            while (i6 < i3) {
                double d = dArr2[i + (dMatrixRMaj.numCols * i6) + i5];
                int i9 = i7 + i6;
                int i10 = i5;
                for (int i11 = i7; i11 != i9; i11++) {
                    d -= dArr[i11] * dArr3[i10];
                    i10 += i4;
                }
                double d2 = d / dArr[(i6 * i3) + i6];
                dArr2[i2 + (dMatrixRMaj.numCols * i5) + i6] = d2;
                dArr3[i8] = d2;
                i6++;
                i8 += i4;
                i7 += i3;
            }
        }
    }

    public static void symmRankTranA_sub(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, int i) {
        double[] dArr = dMatrixRMaj.data;
        double[] dArr2 = dMatrixRMaj2.data;
        int i2 = dMatrixRMaj2.numCols + 1;
        int i3 = i;
        for (int i4 = 0; i4 < dMatrixRMaj.numCols; i4++) {
            int i5 = dMatrixRMaj.numCols;
            int i6 = 0;
            int i7 = i4;
            while (i6 < dMatrixRMaj.numRows) {
                double d = dArr[i7];
                int i8 = i3;
                for (int i9 = i7; i9 < i5; i9++) {
                    dArr2[i8] = dArr2[i8] - (dArr[i9] * d);
                    i8++;
                }
                i6++;
                i7 += dMatrixRMaj.numCols;
                i5 += dMatrixRMaj.numCols;
            }
            i3 += i2;
        }
    }
}
