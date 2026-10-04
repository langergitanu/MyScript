package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_ZDRM;
import org.ejml.dense.row.decompose.TriangularSolver_ZDRM;
import org.ejml.dense.row.decompose.p048qr.QRDecompositionHouseholderTran_ZDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_ZDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQrHouseTran_ZDRM extends LinearSolverAbstract_ZDRM {

    /* JADX INFO: renamed from: QR */
    private ZMatrixRMaj f2718QR;

    /* JADX INFO: renamed from: U */
    private ZMatrixRMaj f2719U;

    /* JADX INFO: renamed from: a */
    private double[] f2720a;
    protected int maxRows = -1;
    protected int maxCols = -1;
    private QRDecompositionHouseholderTran_ZDRM decomposer = new QRDecompositionHouseholderTran_ZDRM();

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public void setMaxSize(int i, int i2) {
        this.maxRows = i;
        this.maxCols = i2;
        this.f2720a = new double[i * 2];
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(ZMatrixRMaj zMatrixRMaj) {
        if (zMatrixRMaj.numRows > this.maxRows || zMatrixRMaj.numCols > this.maxCols) {
            setMaxSize(zMatrixRMaj.numRows, zMatrixRMaj.numCols);
        }
        _setA(zMatrixRMaj);
        if (!this.decomposer.decompose(zMatrixRMaj)) {
            return false;
        }
        this.f2718QR = this.decomposer.getQR();
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_ZDRM.qualityTriangular(this.f2718QR);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2) {
        if (zMatrixRMaj2.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for X: X rows = " + zMatrixRMaj2.numRows + " expected = " + this.numCols);
        }
        if (zMatrixRMaj.numRows != this.numRows || zMatrixRMaj.numCols != zMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for B");
        }
        int i = 1;
        this.f2719U = this.decomposer.getR(this.f2719U, true);
        double[] gammas = this.decomposer.getGammas();
        double[] dArr = this.f2718QR.data;
        int i2 = zMatrixRMaj.numCols;
        int i3 = 0;
        while (i3 < i2) {
            for (int i4 = 0; i4 < this.numRows; i4++) {
                int i5 = ((i4 * i2) + i3) * 2;
                int i6 = i4 * 2;
                this.f2720a[i6] = zMatrixRMaj.data[i5];
                this.f2720a[i6 + i] = zMatrixRMaj.data[i5 + i];
            }
            int i7 = 0;
            while (i7 < this.numCols) {
                int i8 = ((this.numRows * i7) + i7 + i) * 2;
                double[] dArr2 = this.f2720a;
                int i9 = i7 * 2;
                double d = dArr2[i9];
                int i10 = i9 + 1;
                double d2 = dArr2[i10];
                int i11 = i7 + 1;
                int i12 = i;
                int i13 = i11;
                while (i13 < this.numRows) {
                    int i14 = i8 + 1;
                    double d3 = dArr[i8];
                    i8 += 2;
                    double[] dArr3 = gammas;
                    double[] dArr4 = dArr;
                    double d4 = -dArr4[i14];
                    double[] dArr5 = this.f2720a;
                    int i15 = i13 * 2;
                    double d5 = dArr5[i15];
                    double d6 = dArr5[i15 + 1];
                    d += (d3 * d5) - (d4 * d6);
                    d2 += (d3 * d6) + (d4 * d5);
                    i13++;
                    gammas = dArr3;
                    dArr = dArr4;
                }
                double[] dArr6 = gammas;
                double[] dArr7 = dArr;
                double d7 = dArr6[i7];
                double d8 = d * d7;
                double d9 = d2 * d7;
                double[] dArr8 = this.f2720a;
                dArr8[i9] = dArr8[i9] - d8;
                dArr8[i10] = dArr8[i10] - d9;
                int i16 = ((this.numRows * i7) + i7 + 1) * 2;
                for (int i17 = i11; i17 < this.numRows; i17++) {
                    int i18 = i16 + 1;
                    double d10 = dArr7[i16];
                    i16 += 2;
                    double d11 = dArr7[i18];
                    double[] dArr9 = this.f2720a;
                    int i19 = i17 * 2;
                    dArr9[i19] = dArr9[i19] - ((d10 * d8) - (d11 * d9));
                    int i20 = i19 + 1;
                    dArr9[i20] = dArr9[i20] - ((d10 * d9) + (d11 * d8));
                }
                i7 = i11;
                i = i12;
                gammas = dArr6;
                dArr = dArr7;
            }
            double[] dArr10 = gammas;
            double[] dArr11 = dArr;
            int i21 = i;
            TriangularSolver_ZDRM.solveU(this.f2719U.data, this.f2720a, this.numCols);
            for (int i22 = 0; i22 < this.numCols; i22++) {
                int i23 = ((zMatrixRMaj2.numCols * i22) + i3) * 2;
                int i24 = i22 * 2;
                zMatrixRMaj2.data[i23] = this.f2720a[i24];
                zMatrixRMaj2.data[i23 + 1] = this.f2720a[i24 + 1];
            }
            i3++;
            i = i21;
            gammas = dArr10;
            dArr = dArr11;
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.decomposer.inputModified();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public QRDecomposition<ZMatrixRMaj> getDecomposition() {
        return this.decomposer;
    }
}
