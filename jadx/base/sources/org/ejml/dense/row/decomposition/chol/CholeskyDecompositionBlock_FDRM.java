package org.ejml.dense.row.decomposition.chol;

import org.ejml.data.FMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class CholeskyDecompositionBlock_FDRM extends CholeskyDecompositionCommon_FDRM {

    /* JADX INFO: renamed from: B */
    private FMatrixRMaj f2518B;
    private int blockWidth;
    private CholeskyBlockHelper_FDRM chol;

    public CholeskyDecompositionBlock_FDRM(int i) {
        super(true);
        this.blockWidth = i;
    }

    @Override // org.ejml.dense.row.decomposition.chol.CholeskyDecompositionCommon_FDRM
    public void setExpectedMaxSize(int i, int i2) {
        super.setExpectedMaxSize(i, i2);
        if (i < this.blockWidth) {
            this.f2518B = new FMatrixRMaj(0, 0);
        } else {
            this.f2518B = new FMatrixRMaj(this.blockWidth, this.maxWidth);
        }
        this.chol = new CholeskyBlockHelper_FDRM(this.blockWidth);
    }

    @Override // org.ejml.dense.row.decomposition.chol.CholeskyDecompositionCommon_FDRM
    protected boolean decomposeLower() {
        int i = this.f2524n;
        int i2 = this.blockWidth;
        int i3 = 0;
        if (i < i2) {
            this.f2518B.reshape(0, 0, false);
        } else {
            this.f2518B.reshape(i2, this.f2524n - this.blockWidth, false);
        }
        int i4 = this.f2524n / this.blockWidth;
        int i5 = this.f2524n % this.blockWidth;
        if (i5 > 0) {
            i4++;
        }
        this.f2518B.numCols = this.f2524n;
        for (int i6 = 0; i6 < i4; i6++) {
            this.f2518B.numCols -= this.blockWidth;
            if (this.f2518B.numCols > 0) {
                CholeskyBlockHelper_FDRM choleskyBlockHelper_FDRM = this.chol;
                FMatrixRMaj fMatrixRMaj = this.f2523T;
                int i7 = this.blockWidth * i6 * this.f2523T.numCols;
                int i8 = this.blockWidth;
                if (!choleskyBlockHelper_FDRM.decompose(fMatrixRMaj, i7 + (i6 * i8), i8)) {
                    return false;
                }
                int i9 = this.blockWidth * i6 * this.f2523T.numCols;
                int i10 = i6 + 1;
                int i11 = this.blockWidth;
                solveL_special(this.chol.getL().data, this.f2523T, i9 + (i10 * i11), (i11 * i10 * this.f2523T.numCols) + (this.blockWidth * i6), this.f2518B);
                symmRankTranA_sub(this.f2518B, this.f2523T, (this.blockWidth * i10 * this.f2524n) + (i10 * this.blockWidth));
            } else {
                if (!this.chol.decompose(this.f2523T, (this.blockWidth * i6 * this.f2523T.numCols) + (this.blockWidth * i6), i5 > 0 ? i5 : this.blockWidth)) {
                    return false;
                }
            }
        }
        while (i3 < this.f2524n) {
            int i12 = i3 + 1;
            for (int i13 = i12; i13 < this.f2524n; i13++) {
                this.f2525t[(this.f2524n * i3) + i13] = 0.0f;
            }
            i3 = i12;
        }
        return true;
    }

    @Override // org.ejml.dense.row.decomposition.chol.CholeskyDecompositionCommon_FDRM
    protected boolean decomposeUpper() {
        throw new RuntimeException("Not implemented.  Do a lower decomposition and transpose it...");
    }

    public static void solveL_special(float[] fArr, FMatrixRMaj fMatrixRMaj, int i, int i2, FMatrixRMaj fMatrixRMaj2) {
        float[] fArr2 = fMatrixRMaj.data;
        float[] fArr3 = fMatrixRMaj2.data;
        int i3 = fMatrixRMaj2.numRows;
        int i4 = fMatrixRMaj2.numCols;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = 0;
            int i7 = 0;
            int i8 = i5;
            while (i6 < i3) {
                float f = fArr2[i + (fMatrixRMaj.numCols * i6) + i5];
                int i9 = i7 + i6;
                int i10 = i5;
                for (int i11 = i7; i11 != i9; i11++) {
                    f -= fArr[i11] * fArr3[i10];
                    i10 += i4;
                }
                float f2 = f / fArr[(i6 * i3) + i6];
                fArr2[i2 + (fMatrixRMaj.numCols * i5) + i6] = f2;
                fArr3[i8] = f2;
                i6++;
                i8 += i4;
                i7 += i3;
            }
        }
    }

    public static void symmRankTranA_sub(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, int i) {
        float[] fArr = fMatrixRMaj.data;
        float[] fArr2 = fMatrixRMaj2.data;
        int i2 = fMatrixRMaj2.numCols + 1;
        for (int i3 = 0; i3 < fMatrixRMaj.numCols; i3++) {
            int i4 = fMatrixRMaj.numCols;
            int i5 = 0;
            int i6 = i3;
            while (i5 < fMatrixRMaj.numRows) {
                float f = fArr[i6];
                int i7 = i;
                for (int i8 = i6; i8 < i4; i8++) {
                    fArr2[i7] = fArr2[i7] - (fArr[i8] * f);
                    i7++;
                }
                i5++;
                i6 += fMatrixRMaj.numCols;
                i4 += fMatrixRMaj.numCols;
            }
            i += i2;
        }
    }
}
