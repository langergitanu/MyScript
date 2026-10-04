package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.CMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_CDRM;
import org.ejml.dense.row.decompose.TriangularSolver_CDRM;
import org.ejml.dense.row.decompose.p048qr.QRDecompositionHouseholder_CDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_CDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQrHouse_CDRM extends LinearSolverAbstract_CDRM {

    /* JADX INFO: renamed from: QR */
    private CMatrixRMaj f2721QR;

    /* JADX INFO: renamed from: a */
    private float[] f2722a;
    private float[] gammas;

    /* JADX INFO: renamed from: u */
    private float[] f2723u;
    private int maxRows = -1;
    private QRDecompositionHouseholder_CDRM decomposer = new QRDecompositionHouseholder_CDRM();

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return false;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public void setMaxSize(int i) {
        this.maxRows = i;
        int i2 = i * 2;
        this.f2722a = new float[i2];
        this.f2723u = new float[i2];
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(CMatrixRMaj cMatrixRMaj) {
        if (cMatrixRMaj.numRows > this.maxRows) {
            setMaxSize(cMatrixRMaj.numRows);
        }
        _setA(cMatrixRMaj);
        if (!this.decomposer.decompose(cMatrixRMaj)) {
            return false;
        }
        this.gammas = this.decomposer.getGammas();
        this.f2721QR = this.decomposer.getQR();
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_CDRM.qualityTriangular(this.f2721QR);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2) {
        if (cMatrixRMaj2.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for X");
        }
        if (cMatrixRMaj.numRows != this.numRows || cMatrixRMaj.numCols != cMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for B");
        }
        int i = cMatrixRMaj.numCols;
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < this.numRows; i3++) {
                int i4 = ((i3 * i) + i2) * 2;
                int i5 = i3 * 2;
                this.f2722a[i5] = cMatrixRMaj.data[i4];
                this.f2722a[i5 + 1] = cMatrixRMaj.data[i4 + 1];
            }
            int i6 = 0;
            while (i6 < this.numCols) {
                float[] fArr = this.f2723u;
                int i7 = i6 * 2;
                fArr[i7] = 1.0f;
                int i8 = i7 + 1;
                fArr[i8] = 0.0f;
                float[] fArr2 = this.f2722a;
                float f = fArr2[i7];
                float f2 = fArr2[i8];
                int i9 = i6 + 1;
                for (int i10 = i9; i10 < this.numRows; i10++) {
                    int i11 = ((this.f2721QR.numCols * i10) + i6) * 2;
                    float[] fArr3 = this.f2723u;
                    int i12 = i10 * 2;
                    float f3 = this.f2721QR.data[i11];
                    fArr3[i12] = f3;
                    float[] fArr4 = this.f2723u;
                    int i13 = i12 + 1;
                    float f4 = this.f2721QR.data[i11 + 1];
                    fArr4[i13] = f4;
                    float[] fArr5 = this.f2722a;
                    float f5 = fArr5[i12];
                    float f6 = fArr5[i13];
                    f += (f3 * f5) + (f4 * f6);
                    f2 += (f3 * f6) - (f4 * f5);
                }
                float f7 = this.gammas[i6];
                float f8 = f * f7;
                float f9 = f2 * f7;
                while (i6 < this.numRows) {
                    float[] fArr6 = this.f2723u;
                    int i14 = i6 * 2;
                    float f10 = fArr6[i14];
                    int i15 = i14 + 1;
                    float f11 = fArr6[i15];
                    float[] fArr7 = this.f2722a;
                    fArr7[i14] = fArr7[i14] - ((f10 * f8) - (f11 * f9));
                    fArr7[i15] = fArr7[i15] - ((f10 * f9) + (f11 * f8));
                    i6++;
                }
                i6 = i9;
            }
            TriangularSolver_CDRM.solveU(this.f2721QR.data, this.f2722a, this.numCols);
            for (int i16 = 0; i16 < this.numCols; i16++) {
                int i17 = ((cMatrixRMaj2.numCols * i16) + i2) * 2;
                int i18 = i16 * 2;
                cMatrixRMaj2.data[i17] = this.f2722a[i18];
                cMatrixRMaj2.data[i17 + 1] = this.f2722a[i18 + 1];
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public QRDecomposition<CMatrixRMaj> getDecomposition() {
        return this.decomposer;
    }
}
