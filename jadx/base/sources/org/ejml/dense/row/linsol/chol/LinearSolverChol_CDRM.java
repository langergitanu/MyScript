package org.ejml.dense.row.linsol.chol;

import java.util.Arrays;
import org.ejml.data.CMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_CDRM;
import org.ejml.dense.row.decompose.TriangularSolver_CDRM;
import org.ejml.dense.row.decompose.chol.CholeskyDecompositionCommon_CDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_CDRM;
import org.ejml.interfaces.decomposition.CholeskyDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverChol_CDRM extends LinearSolverAbstract_CDRM {
    CholeskyDecompositionCommon_CDRM decomposer;

    /* JADX INFO: renamed from: n */
    int f2675n;

    /* JADX INFO: renamed from: t */
    float[] f2676t;

    /* JADX INFO: renamed from: vv */
    float[] f2677vv = new float[0];

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolverChol_CDRM(CholeskyDecompositionCommon_CDRM choleskyDecompositionCommon_CDRM) {
        this.decomposer = choleskyDecompositionCommon_CDRM;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(CMatrixRMaj cMatrixRMaj) {
        if (cMatrixRMaj.numRows != cMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Matrix must be square");
        }
        _setA(cMatrixRMaj);
        if (!this.decomposer.decompose(cMatrixRMaj)) {
            return false;
        }
        int i = cMatrixRMaj.numCols;
        this.f2675n = i;
        if (this.f2677vv.length < i * 2) {
            this.f2677vv = new float[i * 2];
        }
        this.f2676t = this.decomposer._getT().data;
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_CDRM.qualityTriangular(this.decomposer._getT());
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2) {
        if (cMatrixRMaj.numCols != cMatrixRMaj2.numCols || cMatrixRMaj.numRows != this.f2675n || cMatrixRMaj2.numRows != this.f2675n) {
            throw new IllegalArgumentException("Unexpected matrix size");
        }
        int i = cMatrixRMaj.numCols;
        float[] fArr = cMatrixRMaj.data;
        float[] fArr2 = cMatrixRMaj2.data;
        if (!this.decomposer.isLower()) {
            throw new RuntimeException("Implement");
        }
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < this.f2675n; i3++) {
                float[] fArr3 = this.f2677vv;
                int i4 = i3 * 2;
                int i5 = ((i3 * i) + i2) * 2;
                fArr3[i4] = fArr[i5];
                fArr3[i4 + 1] = fArr[i5 + 1];
            }
            solveInternalL();
            for (int i6 = 0; i6 < this.f2675n; i6++) {
                int i7 = ((i6 * i) + i2) * 2;
                float[] fArr4 = this.f2677vv;
                int i8 = i6 * 2;
                fArr2[i7] = fArr4[i8];
                fArr2[i7 + 1] = fArr4[i8 + 1];
            }
        }
    }

    private void solveInternalL() {
        TriangularSolver_CDRM.solveL_diagReal(this.f2676t, this.f2677vv, this.f2675n);
        TriangularSolver_CDRM.solveConjTranL_diagReal(this.f2676t, this.f2677vv, this.f2675n);
    }

    @Override // org.ejml.dense.row.linsol.LinearSolverAbstract_CDRM, org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(CMatrixRMaj cMatrixRMaj) {
        if (cMatrixRMaj.numRows != this.f2675n || cMatrixRMaj.numCols != this.f2675n) {
            throw new RuntimeException("Unexpected matrix dimension");
        }
        if (cMatrixRMaj.data == this.f2676t) {
            throw new IllegalArgumentException("Passing in the same matrix that was decomposed.");
        }
        if (this.decomposer.isLower()) {
            setToInverseL(cMatrixRMaj.data);
            return;
        }
        throw new RuntimeException("Implement");
    }

    public void setToInverseL(float[] fArr) {
        for (int i = 0; i < this.f2675n; i++) {
            Arrays.fill(this.f2677vv, 0.0f);
            float[] fArr2 = this.f2677vv;
            fArr2[i * 2] = 1.0f;
            TriangularSolver_CDRM.solveL_diagReal(this.f2676t, fArr2, this.f2675n);
            TriangularSolver_CDRM.solveConjTranL_diagReal(this.f2676t, this.f2677vv, this.f2675n);
            for (int i2 = 0; i2 < this.f2675n; i2++) {
                int i3 = i2 * 2;
                fArr[((this.numCols * i2) + i) * 2] = this.f2677vv[i3];
                fArr[(((this.numCols * i2) + i) * 2) + 1] = this.f2677vv[i3 + 1];
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.decomposer.inputModified();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public CholeskyDecomposition_F32<CMatrixRMaj> getDecomposition() {
        return this.decomposer;
    }
}
