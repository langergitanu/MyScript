package org.ejml.dense.row.linsol.chol;

import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_DDRM;
import org.ejml.dense.row.decomposition.TriangularSolver_DDRM;
import org.ejml.dense.row.decomposition.chol.CholeskyDecompositionLDL_DDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_DDRM;
import org.ejml.interfaces.decomposition.CholeskyLDLDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverCholLDL_DDRM extends LinearSolverAbstract_DDRM {

    /* JADX INFO: renamed from: d */
    private double[] f2667d;
    private CholeskyDecompositionLDL_DDRM decomposer;

    /* JADX INFO: renamed from: el */
    private double[] f2668el;

    /* JADX INFO: renamed from: n */
    private int f2669n;

    /* JADX INFO: renamed from: vv */
    private double[] f2670vv;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolverCholLDL_DDRM(CholeskyDecompositionLDL_DDRM choleskyDecompositionLDL_DDRM) {
        this.decomposer = choleskyDecompositionLDL_DDRM;
    }

    public LinearSolverCholLDL_DDRM() {
        this.decomposer = new CholeskyDecompositionLDL_DDRM();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(DMatrixRMaj dMatrixRMaj) {
        _setA(dMatrixRMaj);
        if (!this.decomposer.decompose(dMatrixRMaj)) {
            return false;
        }
        this.f2669n = dMatrixRMaj.numCols;
        this.f2670vv = this.decomposer._getVV();
        this.f2668el = this.decomposer.getL().data;
        this.f2667d = this.decomposer.getDiagonal();
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return Math.abs(SpecializedOps_DDRM.diagProd(this.decomposer.getL()));
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj.numCols != dMatrixRMaj2.numCols && dMatrixRMaj.numRows != this.f2669n && dMatrixRMaj2.numRows != this.f2669n) {
            throw new IllegalArgumentException("Unexpected matrix size");
        }
        int i = dMatrixRMaj.numCols;
        double[] dArr = dMatrixRMaj.data;
        double[] dArr2 = dMatrixRMaj2.data;
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < this.f2669n; i3++) {
                this.f2670vv[i3] = dArr[(i3 * i) + i2];
            }
            solveInternal();
            for (int i4 = 0; i4 < this.f2669n; i4++) {
                dArr2[(i4 * i) + i2] = this.f2670vv[i4];
            }
        }
    }

    private void solveInternal() {
        TriangularSolver_DDRM.solveL(this.f2668el, this.f2670vv, this.f2669n);
        int i = 0;
        while (true) {
            int i2 = this.f2669n;
            if (i < i2) {
                double[] dArr = this.f2670vv;
                dArr[i] = dArr[i] / this.f2667d[i];
                i++;
            } else {
                TriangularSolver_DDRM.solveTranL(this.f2668el, this.f2670vv, i2);
                return;
            }
        }
    }

    @Override // org.ejml.dense.row.linsol.LinearSolverAbstract_DDRM, org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(DMatrixRMaj dMatrixRMaj) {
        int i;
        int i2;
        if (dMatrixRMaj.numRows != this.f2669n || dMatrixRMaj.numCols != this.f2669n) {
            throw new RuntimeException("Unexpected matrix dimension");
        }
        double[] dArr = dMatrixRMaj.data;
        int i3 = 0;
        while (i3 < this.f2669n) {
            int i4 = 0;
            while (i4 <= i3) {
                double d = i3 == i4 ? 1.0d : 0.0d;
                for (int i5 = i3 - 1; i5 >= i4; i5--) {
                    double[] dArr2 = this.f2668el;
                    int i6 = this.f2669n;
                    d -= dArr2[(i3 * i6) + i5] * dArr[(i6 * i4) + i5];
                }
                dArr[(this.f2669n * i4) + i3] = d;
                i4++;
            }
            i3++;
        }
        int i7 = 0;
        while (true) {
            i = this.f2669n;
            if (i7 >= i) {
                break;
            }
            double d2 = 1.0d / this.f2667d[i7];
            for (int i8 = 0; i8 <= i7; i8++) {
                int i9 = (this.f2669n * i8) + i7;
                dArr[i9] = dArr[i9] * d2;
            }
            i7++;
        }
        int i10 = i - 1;
        while (i10 >= 0) {
            int i11 = 0;
            while (i11 <= i10) {
                double d3 = i10 < i11 ? 0.0d : dArr[(this.f2669n * i11) + i10];
                int i12 = i10 + 1;
                while (true) {
                    i2 = this.f2669n;
                    if (i12 < i2) {
                        d3 -= this.f2668el[(i12 * i2) + i10] * dArr[(i2 * i11) + i12];
                        i12++;
                    }
                }
                dArr[(i2 * i11) + i10] = d3;
                dArr[(i10 * i2) + i11] = d3;
                i11++;
            }
            i10--;
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.decomposer.inputModified();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public CholeskyLDLDecomposition_F64<DMatrixRMaj> getDecomposition() {
        return this.decomposer;
    }
}
