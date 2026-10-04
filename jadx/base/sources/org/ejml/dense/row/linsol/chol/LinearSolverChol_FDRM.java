package org.ejml.dense.row.linsol.chol;

import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_FDRM;
import org.ejml.dense.row.decomposition.TriangularSolver_FDRM;
import org.ejml.dense.row.decomposition.chol.CholeskyDecompositionCommon_FDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_FDRM;
import org.ejml.interfaces.decomposition.CholeskyDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverChol_FDRM extends LinearSolverAbstract_FDRM {
    CholeskyDecompositionCommon_FDRM decomposer;

    /* JADX INFO: renamed from: n */
    int f2681n;

    /* JADX INFO: renamed from: t */
    float[] f2682t;

    /* JADX INFO: renamed from: vv */
    float[] f2683vv;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolverChol_FDRM(CholeskyDecompositionCommon_FDRM choleskyDecompositionCommon_FDRM) {
        this.decomposer = choleskyDecompositionCommon_FDRM;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj.numRows != fMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Matrix must be square");
        }
        _setA(fMatrixRMaj);
        if (!this.decomposer.decompose(fMatrixRMaj)) {
            return false;
        }
        this.f2681n = fMatrixRMaj.numCols;
        this.f2683vv = this.decomposer._getVV();
        this.f2682t = this.decomposer.getT().data;
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_FDRM.qualityTriangular(this.decomposer.getT());
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj.numCols != fMatrixRMaj2.numCols || fMatrixRMaj.numRows != this.f2681n || fMatrixRMaj2.numRows != this.f2681n) {
            throw new IllegalArgumentException("Unexpected matrix size");
        }
        int i = fMatrixRMaj.numCols;
        float[] fArr = fMatrixRMaj.data;
        float[] fArr2 = fMatrixRMaj2.data;
        if (!this.decomposer.isLower()) {
            throw new RuntimeException("Implement");
        }
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < this.f2681n; i3++) {
                this.f2683vv[i3] = fArr[(i3 * i) + i2];
            }
            solveInternalL();
            for (int i4 = 0; i4 < this.f2681n; i4++) {
                fArr2[(i4 * i) + i2] = this.f2683vv[i4];
            }
        }
    }

    private void solveInternalL() {
        TriangularSolver_FDRM.solveL(this.f2682t, this.f2683vv, this.f2681n);
        TriangularSolver_FDRM.solveTranL(this.f2682t, this.f2683vv, this.f2681n);
    }

    @Override // org.ejml.dense.row.linsol.LinearSolverAbstract_FDRM, org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj.numRows != this.f2681n || fMatrixRMaj.numCols != this.f2681n) {
            throw new RuntimeException("Unexpected matrix dimension");
        }
        if (fMatrixRMaj.data == this.f2682t) {
            throw new IllegalArgumentException("Passing in the same matrix that was decomposed.");
        }
        float[] fArr = fMatrixRMaj.data;
        if (this.decomposer.isLower()) {
            setToInverseL(fArr);
            return;
        }
        throw new RuntimeException("Implement");
    }

    public void setToInverseL(float[] fArr) {
        int i;
        int i2;
        int i3 = 0;
        while (true) {
            i = this.f2681n;
            if (i3 >= i) {
                break;
            }
            float f = this.f2682t[(i * i3) + i3];
            int i4 = 0;
            while (i4 <= i3) {
                float f2 = i3 == i4 ? 1.0f : 0.0f;
                for (int i5 = i3 - 1; i5 >= i4; i5--) {
                    float[] fArr2 = this.f2682t;
                    int i6 = this.f2681n;
                    f2 -= fArr2[(i3 * i6) + i5] * fArr[(i6 * i4) + i5];
                }
                fArr[(this.f2681n * i4) + i3] = f2 / f;
                i4++;
            }
            i3++;
        }
        int i7 = i - 1;
        while (i7 >= 0) {
            float f3 = this.f2682t[(this.f2681n * i7) + i7];
            int i8 = 0;
            while (i8 <= i7) {
                float f4 = i7 < i8 ? 0.0f : fArr[(this.f2681n * i8) + i7];
                int i9 = i7 + 1;
                while (true) {
                    i2 = this.f2681n;
                    if (i9 < i2) {
                        f4 -= this.f2682t[(i9 * i2) + i7] * fArr[(i2 * i8) + i9];
                        i9++;
                    }
                }
                float f5 = f4 / f3;
                fArr[(i2 * i8) + i7] = f5;
                fArr[(i7 * i2) + i8] = f5;
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
    public CholeskyDecomposition_F32<FMatrixRMaj> getDecomposition() {
        return this.decomposer;
    }
}
