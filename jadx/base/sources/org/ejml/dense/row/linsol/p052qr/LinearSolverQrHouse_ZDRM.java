package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_ZDRM;
import org.ejml.dense.row.decompose.TriangularSolver_ZDRM;
import org.ejml.dense.row.decompose.p048qr.QRDecompositionHouseholder_ZDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_ZDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQrHouse_ZDRM extends LinearSolverAbstract_ZDRM {

    /* JADX INFO: renamed from: QR */
    private ZMatrixRMaj f2730QR;

    /* JADX INFO: renamed from: a */
    private double[] f2731a;
    private double[] gammas;

    /* JADX INFO: renamed from: u */
    private double[] f2732u;
    private int maxRows = -1;
    private QRDecompositionHouseholder_ZDRM decomposer = new QRDecompositionHouseholder_ZDRM();

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
        this.f2731a = new double[i2];
        this.f2732u = new double[i2];
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(ZMatrixRMaj zMatrixRMaj) {
        if (zMatrixRMaj.numRows > this.maxRows) {
            setMaxSize(zMatrixRMaj.numRows);
        }
        _setA(zMatrixRMaj);
        if (!this.decomposer.decompose(zMatrixRMaj)) {
            return false;
        }
        this.gammas = this.decomposer.getGammas();
        this.f2730QR = this.decomposer.getQR();
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_ZDRM.qualityTriangular(this.f2730QR);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2) {
        ZMatrixRMaj zMatrixRMaj3 = zMatrixRMaj;
        if (zMatrixRMaj2.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for X");
        }
        if (zMatrixRMaj3.numRows != this.numRows || zMatrixRMaj3.numCols != zMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for B");
        }
        int i = zMatrixRMaj3.numCols;
        int i2 = 0;
        while (i2 < i) {
            for (int i3 = 0; i3 < this.numRows; i3++) {
                int i4 = ((i3 * i) + i2) * 2;
                int i5 = i3 * 2;
                this.f2731a[i5] = zMatrixRMaj3.data[i4];
                this.f2731a[i5 + 1] = zMatrixRMaj3.data[i4 + 1];
            }
            int i6 = 0;
            while (i6 < this.numCols) {
                double[] dArr = this.f2732u;
                int i7 = i6 * 2;
                dArr[i7] = 1.0d;
                int i8 = i7 + 1;
                dArr[i8] = 0.0d;
                double[] dArr2 = this.f2731a;
                double d = dArr2[i7];
                double d2 = dArr2[i8];
                int i9 = i6 + 1;
                for (int i10 = i9; i10 < this.numRows; i10++) {
                    int i11 = ((this.f2730QR.numCols * i10) + i6) * 2;
                    double[] dArr3 = this.f2732u;
                    int i12 = i10 * 2;
                    double d3 = this.f2730QR.data[i11];
                    dArr3[i12] = d3;
                    double[] dArr4 = this.f2732u;
                    int i13 = i12 + 1;
                    double d4 = this.f2730QR.data[i11 + 1];
                    dArr4[i13] = d4;
                    double[] dArr5 = this.f2731a;
                    double d5 = dArr5[i12];
                    double d6 = dArr5[i13];
                    d += (d3 * d5) + (d4 * d6);
                    d2 += (d3 * d6) - (d4 * d5);
                }
                double d7 = this.gammas[i6];
                double d8 = d * d7;
                double d9 = d2 * d7;
                while (i6 < this.numRows) {
                    double[] dArr6 = this.f2732u;
                    int i14 = i6 * 2;
                    double d10 = dArr6[i14];
                    int i15 = i14 + 1;
                    double d11 = dArr6[i15];
                    double[] dArr7 = this.f2731a;
                    dArr7[i14] = dArr7[i14] - ((d10 * d8) - (d11 * d9));
                    dArr7[i15] = dArr7[i15] - ((d10 * d9) + (d11 * d8));
                    i6++;
                }
                i6 = i9;
            }
            TriangularSolver_ZDRM.solveU(this.f2730QR.data, this.f2731a, this.numCols);
            for (int i16 = 0; i16 < this.numCols; i16++) {
                int i17 = ((zMatrixRMaj2.numCols * i16) + i2) * 2;
                int i18 = i16 * 2;
                zMatrixRMaj2.data[i17] = this.f2731a[i18];
                zMatrixRMaj2.data[i17 + 1] = this.f2731a[i18 + 1];
            }
            i2++;
            zMatrixRMaj3 = zMatrixRMaj;
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public QRDecomposition<ZMatrixRMaj> getDecomposition() {
        return this.decomposer;
    }
}
