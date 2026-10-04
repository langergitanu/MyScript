package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.CMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_CDRM;
import org.ejml.dense.row.decompose.TriangularSolver_CDRM;
import org.ejml.dense.row.decompose.p048qr.QRDecompositionHouseholderTran_CDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_CDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQrHouseTran_CDRM extends LinearSolverAbstract_CDRM {

    /* JADX INFO: renamed from: QR */
    private CMatrixRMaj f2709QR;

    /* JADX INFO: renamed from: U */
    private CMatrixRMaj f2710U;

    /* JADX INFO: renamed from: a */
    private float[] f2711a;
    protected int maxRows = -1;
    protected int maxCols = -1;
    private QRDecompositionHouseholderTran_CDRM decomposer = new QRDecompositionHouseholderTran_CDRM();

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public void setMaxSize(int i, int i2) {
        this.maxRows = i;
        this.maxCols = i2;
        this.f2711a = new float[i * 2];
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(CMatrixRMaj cMatrixRMaj) {
        if (cMatrixRMaj.numRows > this.maxRows || cMatrixRMaj.numCols > this.maxCols) {
            setMaxSize(cMatrixRMaj.numRows, cMatrixRMaj.numCols);
        }
        _setA(cMatrixRMaj);
        if (!this.decomposer.decompose(cMatrixRMaj)) {
            return false;
        }
        this.f2709QR = this.decomposer.getQR();
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_CDRM.qualityTriangular(this.f2709QR);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2) {
        CMatrixRMaj cMatrixRMaj3 = cMatrixRMaj;
        if (cMatrixRMaj2.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for X: X rows = " + cMatrixRMaj2.numRows + " expected = " + this.numCols);
        }
        if (cMatrixRMaj3.numRows != this.numRows || cMatrixRMaj3.numCols != cMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for B");
        }
        int i = 1;
        this.f2710U = this.decomposer.getR(this.f2710U, true);
        float[] gammas = this.decomposer.getGammas();
        float[] fArr = this.f2709QR.data;
        int i2 = cMatrixRMaj3.numCols;
        int i3 = 0;
        while (i3 < i2) {
            for (int i4 = 0; i4 < this.numRows; i4++) {
                int i5 = ((i4 * i2) + i3) * 2;
                int i6 = i4 * 2;
                this.f2711a[i6] = cMatrixRMaj3.data[i5];
                this.f2711a[i6 + i] = cMatrixRMaj3.data[i5 + i];
            }
            int i7 = 0;
            while (i7 < this.numCols) {
                int i8 = ((this.numRows * i7) + i7 + i) * 2;
                float[] fArr2 = this.f2711a;
                int i9 = i7 * 2;
                float f = fArr2[i9];
                int i10 = i9 + 1;
                float f2 = fArr2[i10];
                int i11 = i7 + 1;
                int i12 = i;
                for (int i13 = i11; i13 < this.numRows; i13++) {
                    int i14 = i8 + 1;
                    float f3 = fArr[i8];
                    i8 += 2;
                    float f4 = -fArr[i14];
                    float[] fArr3 = this.f2711a;
                    int i15 = i13 * 2;
                    float f5 = fArr3[i15];
                    float f6 = fArr3[i15 + 1];
                    f += (f3 * f5) - (f4 * f6);
                    f2 += (f3 * f6) + (f4 * f5);
                }
                float f7 = gammas[i7];
                float f8 = f * f7;
                float f9 = f2 * f7;
                float[] fArr4 = this.f2711a;
                fArr4[i9] = fArr4[i9] - f8;
                fArr4[i10] = fArr4[i10] - f9;
                int i16 = ((this.numRows * i7) + i7 + 1) * 2;
                for (int i17 = i11; i17 < this.numRows; i17++) {
                    int i18 = i16 + 1;
                    float f10 = fArr[i16];
                    i16 += 2;
                    float f11 = fArr[i18];
                    float[] fArr5 = this.f2711a;
                    int i19 = i17 * 2;
                    fArr5[i19] = fArr5[i19] - ((f10 * f8) - (f11 * f9));
                    int i20 = i19 + 1;
                    fArr5[i20] = fArr5[i20] - ((f10 * f9) + (f11 * f8));
                }
                i7 = i11;
                i = i12;
            }
            int i21 = i;
            TriangularSolver_CDRM.solveU(this.f2710U.data, this.f2711a, this.numCols);
            for (int i22 = 0; i22 < this.numCols; i22++) {
                int i23 = ((cMatrixRMaj2.numCols * i22) + i3) * 2;
                int i24 = i22 * 2;
                cMatrixRMaj2.data[i23] = this.f2711a[i24];
                cMatrixRMaj2.data[i23 + 1] = this.f2711a[i24 + 1];
            }
            i3++;
            cMatrixRMaj3 = cMatrixRMaj;
            i = i21;
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.decomposer.inputModified();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public QRDecomposition<CMatrixRMaj> getDecomposition() {
        return this.decomposer;
    }
}
