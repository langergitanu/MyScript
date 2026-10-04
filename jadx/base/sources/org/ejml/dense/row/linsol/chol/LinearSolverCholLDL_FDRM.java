package org.ejml.dense.row.linsol.chol;

import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_FDRM;
import org.ejml.dense.row.decomposition.TriangularSolver_FDRM;
import org.ejml.dense.row.decomposition.chol.CholeskyDecompositionLDL_FDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_FDRM;
import org.ejml.interfaces.decomposition.CholeskyLDLDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverCholLDL_FDRM extends LinearSolverAbstract_FDRM {

    /* JADX INFO: renamed from: d */
    private float[] f2671d;
    private CholeskyDecompositionLDL_FDRM decomposer;

    /* JADX INFO: renamed from: el */
    private float[] f2672el;

    /* JADX INFO: renamed from: n */
    private int f2673n;

    /* JADX INFO: renamed from: vv */
    private float[] f2674vv;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolverCholLDL_FDRM(CholeskyDecompositionLDL_FDRM choleskyDecompositionLDL_FDRM) {
        this.decomposer = choleskyDecompositionLDL_FDRM;
    }

    public LinearSolverCholLDL_FDRM() {
        this.decomposer = new CholeskyDecompositionLDL_FDRM();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(FMatrixRMaj fMatrixRMaj) {
        _setA(fMatrixRMaj);
        if (!this.decomposer.decompose(fMatrixRMaj)) {
            return false;
        }
        this.f2673n = fMatrixRMaj.numCols;
        this.f2674vv = this.decomposer._getVV();
        this.f2672el = this.decomposer.getL().data;
        this.f2671d = this.decomposer.getDiagonal();
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return Math.abs(SpecializedOps_FDRM.diagProd(this.decomposer.getL()));
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj.numCols != fMatrixRMaj2.numCols && fMatrixRMaj.numRows != this.f2673n && fMatrixRMaj2.numRows != this.f2673n) {
            throw new IllegalArgumentException("Unexpected matrix size");
        }
        int i = fMatrixRMaj.numCols;
        float[] fArr = fMatrixRMaj.data;
        float[] fArr2 = fMatrixRMaj2.data;
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < this.f2673n; i3++) {
                this.f2674vv[i3] = fArr[(i3 * i) + i2];
            }
            solveInternal();
            for (int i4 = 0; i4 < this.f2673n; i4++) {
                fArr2[(i4 * i) + i2] = this.f2674vv[i4];
            }
        }
    }

    private void solveInternal() {
        TriangularSolver_FDRM.solveL(this.f2672el, this.f2674vv, this.f2673n);
        int i = 0;
        while (true) {
            int i2 = this.f2673n;
            if (i < i2) {
                float[] fArr = this.f2674vv;
                fArr[i] = fArr[i] / this.f2671d[i];
                i++;
            } else {
                TriangularSolver_FDRM.solveTranL(this.f2672el, this.f2674vv, i2);
                return;
            }
        }
    }

    @Override // org.ejml.dense.row.linsol.LinearSolverAbstract_FDRM, org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(FMatrixRMaj fMatrixRMaj) {
        int i;
        int i2;
        if (fMatrixRMaj.numRows != this.f2673n || fMatrixRMaj.numCols != this.f2673n) {
            throw new RuntimeException("Unexpected matrix dimension");
        }
        float[] fArr = fMatrixRMaj.data;
        int i3 = 0;
        while (i3 < this.f2673n) {
            int i4 = 0;
            while (i4 <= i3) {
                float f = i3 == i4 ? 1.0f : 0.0f;
                for (int i5 = i3 - 1; i5 >= i4; i5--) {
                    float[] fArr2 = this.f2672el;
                    int i6 = this.f2673n;
                    f -= fArr2[(i3 * i6) + i5] * fArr[(i6 * i4) + i5];
                }
                fArr[(this.f2673n * i4) + i3] = f;
                i4++;
            }
            i3++;
        }
        int i7 = 0;
        while (true) {
            i = this.f2673n;
            if (i7 >= i) {
                break;
            }
            float f2 = 1.0f / this.f2671d[i7];
            for (int i8 = 0; i8 <= i7; i8++) {
                int i9 = (this.f2673n * i8) + i7;
                fArr[i9] = fArr[i9] * f2;
            }
            i7++;
        }
        int i10 = i - 1;
        while (i10 >= 0) {
            int i11 = 0;
            while (i11 <= i10) {
                float f3 = i10 < i11 ? 0.0f : fArr[(this.f2673n * i11) + i10];
                int i12 = i10 + 1;
                while (true) {
                    i2 = this.f2673n;
                    if (i12 < i2) {
                        f3 -= this.f2672el[(i12 * i2) + i10] * fArr[(i2 * i11) + i12];
                        i12++;
                    }
                }
                fArr[(i2 * i11) + i10] = f3;
                fArr[(i10 * i2) + i11] = f3;
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
    public CholeskyLDLDecomposition_F32<FMatrixRMaj> getDecomposition() {
        return this.decomposer;
    }
}
