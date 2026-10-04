package org.ejml.dense.row.linsol.chol;

import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_DDRM;
import org.ejml.dense.row.decomposition.TriangularSolver_DDRM;
import org.ejml.dense.row.decomposition.chol.CholeskyDecompositionCommon_DDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_DDRM;
import org.ejml.interfaces.decomposition.CholeskyDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverChol_DDRM extends LinearSolverAbstract_DDRM {
    CholeskyDecompositionCommon_DDRM decomposer;

    /* JADX INFO: renamed from: n */
    int f2678n;

    /* JADX INFO: renamed from: t */
    double[] f2679t;

    /* JADX INFO: renamed from: vv */
    double[] f2680vv;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolverChol_DDRM(CholeskyDecompositionCommon_DDRM choleskyDecompositionCommon_DDRM) {
        this.decomposer = choleskyDecompositionCommon_DDRM;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj.numRows != dMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Matrix must be square");
        }
        _setA(dMatrixRMaj);
        if (!this.decomposer.decompose(dMatrixRMaj)) {
            return false;
        }
        this.f2678n = dMatrixRMaj.numCols;
        this.f2680vv = this.decomposer._getVV();
        this.f2679t = this.decomposer.getT().data;
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_DDRM.qualityTriangular(this.decomposer.getT());
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj.numCols != dMatrixRMaj2.numCols || dMatrixRMaj.numRows != this.f2678n || dMatrixRMaj2.numRows != this.f2678n) {
            throw new IllegalArgumentException("Unexpected matrix size");
        }
        int i = dMatrixRMaj.numCols;
        double[] dArr = dMatrixRMaj.data;
        double[] dArr2 = dMatrixRMaj2.data;
        if (!this.decomposer.isLower()) {
            throw new RuntimeException("Implement");
        }
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < this.f2678n; i3++) {
                this.f2680vv[i3] = dArr[(i3 * i) + i2];
            }
            solveInternalL();
            for (int i4 = 0; i4 < this.f2678n; i4++) {
                dArr2[(i4 * i) + i2] = this.f2680vv[i4];
            }
        }
    }

    private void solveInternalL() {
        TriangularSolver_DDRM.solveL(this.f2679t, this.f2680vv, this.f2678n);
        TriangularSolver_DDRM.solveTranL(this.f2679t, this.f2680vv, this.f2678n);
    }

    @Override // org.ejml.dense.row.linsol.LinearSolverAbstract_DDRM, org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj.numRows != this.f2678n || dMatrixRMaj.numCols != this.f2678n) {
            throw new RuntimeException("Unexpected matrix dimension");
        }
        if (dMatrixRMaj.data == this.f2679t) {
            throw new IllegalArgumentException("Passing in the same matrix that was decomposed.");
        }
        double[] dArr = dMatrixRMaj.data;
        if (this.decomposer.isLower()) {
            setToInverseL(dArr);
            return;
        }
        throw new RuntimeException("Implement");
    }

    public void setToInverseL(double[] dArr) {
        int i;
        int i2;
        int i3 = 0;
        while (true) {
            i = this.f2678n;
            if (i3 >= i) {
                break;
            }
            double d = this.f2679t[(i * i3) + i3];
            int i4 = 0;
            while (i4 <= i3) {
                double d2 = i3 == i4 ? 1.0d : 0.0d;
                for (int i5 = i3 - 1; i5 >= i4; i5--) {
                    double[] dArr2 = this.f2679t;
                    int i6 = this.f2678n;
                    d2 -= dArr2[(i3 * i6) + i5] * dArr[(i6 * i4) + i5];
                }
                dArr[(this.f2678n * i4) + i3] = d2 / d;
                i4++;
            }
            i3++;
        }
        int i7 = i - 1;
        while (i7 >= 0) {
            double d3 = this.f2679t[(this.f2678n * i7) + i7];
            int i8 = 0;
            while (i8 <= i7) {
                double d4 = i7 < i8 ? 0.0d : dArr[(this.f2678n * i8) + i7];
                int i9 = i7 + 1;
                while (true) {
                    i2 = this.f2678n;
                    if (i9 < i2) {
                        d4 -= this.f2679t[(i9 * i2) + i7] * dArr[(i2 * i8) + i9];
                        i9++;
                    }
                }
                double d5 = d4 / d3;
                dArr[(i2 * i8) + i7] = d5;
                dArr[(i7 * i2) + i8] = d5;
                i8++;
            }
            i7--;
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.decomposer.inputModified();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public CholeskyDecomposition_F64<DMatrixRMaj> getDecomposition() {
        return this.decomposer;
    }
}
