package org.ejml.dense.row.linsol.chol;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_ZDRM;
import org.ejml.dense.row.decompose.TriangularSolver_ZDRM;
import org.ejml.dense.row.decompose.chol.CholeskyDecompositionCommon_ZDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_ZDRM;
import org.ejml.interfaces.decomposition.CholeskyDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverChol_ZDRM extends LinearSolverAbstract_ZDRM {
    CholeskyDecompositionCommon_ZDRM decomposer;

    /* JADX INFO: renamed from: n */
    int f2684n;

    /* JADX INFO: renamed from: t */
    double[] f2685t;

    /* JADX INFO: renamed from: vv */
    double[] f2686vv = new double[0];

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolverChol_ZDRM(CholeskyDecompositionCommon_ZDRM choleskyDecompositionCommon_ZDRM) {
        this.decomposer = choleskyDecompositionCommon_ZDRM;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(ZMatrixRMaj zMatrixRMaj) {
        if (zMatrixRMaj.numRows != zMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Matrix must be square");
        }
        _setA(zMatrixRMaj);
        if (!this.decomposer.decompose(zMatrixRMaj)) {
            return false;
        }
        int i = zMatrixRMaj.numCols;
        this.f2684n = i;
        if (this.f2686vv.length < i * 2) {
            this.f2686vv = new double[i * 2];
        }
        this.f2685t = this.decomposer._getT().data;
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_ZDRM.qualityTriangular(this.decomposer._getT());
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2) {
        if (zMatrixRMaj.numCols != zMatrixRMaj2.numCols || zMatrixRMaj.numRows != this.f2684n || zMatrixRMaj2.numRows != this.f2684n) {
            throw new IllegalArgumentException("Unexpected matrix size");
        }
        int i = zMatrixRMaj.numCols;
        double[] dArr = zMatrixRMaj.data;
        double[] dArr2 = zMatrixRMaj2.data;
        if (!this.decomposer.isLower()) {
            throw new RuntimeException("Implement");
        }
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < this.f2684n; i3++) {
                double[] dArr3 = this.f2686vv;
                int i4 = i3 * 2;
                int i5 = ((i3 * i) + i2) * 2;
                dArr3[i4] = dArr[i5];
                dArr3[i4 + 1] = dArr[i5 + 1];
            }
            solveInternalL();
            for (int i6 = 0; i6 < this.f2684n; i6++) {
                int i7 = ((i6 * i) + i2) * 2;
                double[] dArr4 = this.f2686vv;
                int i8 = i6 * 2;
                dArr2[i7] = dArr4[i8];
                dArr2[i7 + 1] = dArr4[i8 + 1];
            }
        }
    }

    private void solveInternalL() {
        TriangularSolver_ZDRM.solveL_diagReal(this.f2685t, this.f2686vv, this.f2684n);
        TriangularSolver_ZDRM.solveConjTranL_diagReal(this.f2685t, this.f2686vv, this.f2684n);
    }

    @Override // org.ejml.dense.row.linsol.LinearSolverAbstract_ZDRM, org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(ZMatrixRMaj zMatrixRMaj) {
        if (zMatrixRMaj.numRows != this.f2684n || zMatrixRMaj.numCols != this.f2684n) {
            throw new RuntimeException("Unexpected matrix dimension");
        }
        if (zMatrixRMaj.data == this.f2685t) {
            throw new IllegalArgumentException("Passing in the same matrix that was decomposed.");
        }
        if (this.decomposer.isLower()) {
            setToInverseL(zMatrixRMaj.data);
            return;
        }
        throw new RuntimeException("Implement");
    }

    public void setToInverseL(double[] dArr) {
        for (int i = 0; i < this.f2684n; i++) {
            Arrays.fill(this.f2686vv, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            double[] dArr2 = this.f2686vv;
            dArr2[i * 2] = 1.0d;
            TriangularSolver_ZDRM.solveL_diagReal(this.f2685t, dArr2, this.f2684n);
            TriangularSolver_ZDRM.solveConjTranL_diagReal(this.f2685t, this.f2686vv, this.f2684n);
            for (int i2 = 0; i2 < this.f2684n; i2++) {
                int i3 = i2 * 2;
                dArr[((this.numCols * i2) + i) * 2] = this.f2686vv[i3];
                dArr[(((this.numCols * i2) + i) * 2) + 1] = this.f2686vv[i3 + 1];
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.decomposer.inputModified();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public CholeskyDecomposition_F64<ZMatrixRMaj> getDecomposition() {
        return this.decomposer;
    }
}
