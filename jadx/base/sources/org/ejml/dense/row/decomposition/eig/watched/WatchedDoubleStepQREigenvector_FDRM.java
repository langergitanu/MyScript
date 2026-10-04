package org.ejml.dense.row.decomposition.eig.watched;

import java.util.Arrays;
import org.ejml.UtilEjml;
import org.ejml.data.Complex_F32;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.dense.row.NormOps_FDRM;
import org.ejml.dense.row.SpecializedOps_FDRM;
import org.ejml.dense.row.decomposition.TriangularSolver_FDRM;
import org.ejml.dense.row.factory.LinearSolverFactory_FDRM;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class WatchedDoubleStepQREigenvector_FDRM {

    /* JADX INFO: renamed from: N */
    int f2585N;

    /* JADX INFO: renamed from: Q */
    FMatrixRMaj f2586Q;
    FMatrixRMaj eigenvectorTemp;
    FMatrixRMaj[] eigenvectors;
    WatchedDoubleStepQREigen_FDRM implicit;
    int indexVal;
    int numSplits;
    boolean onscript;
    Complex_F32[] origEigenvalues;
    LinearSolverDense solver;
    int[] splits;

    /* JADX INFO: renamed from: x1 */
    int f2587x1;

    /* JADX INFO: renamed from: x2 */
    int f2588x2;

    public boolean process(WatchedDoubleStepQREigen_FDRM watchedDoubleStepQREigen_FDRM, FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        this.implicit = watchedDoubleStepQREigen_FDRM;
        if (this.f2585N != fMatrixRMaj.numRows) {
            this.f2585N = fMatrixRMaj.numRows;
            int i = this.f2585N;
            this.f2586Q = new FMatrixRMaj(i, i);
            int i2 = this.f2585N;
            this.splits = new int[i2];
            this.origEigenvalues = new Complex_F32[i2];
            this.eigenvectors = new FMatrixRMaj[i2];
            this.eigenvectorTemp = new FMatrixRMaj(this.f2585N, 1);
            this.solver = LinearSolverFactory_FDRM.linear(0);
        } else {
            this.eigenvectors = new FMatrixRMaj[this.f2585N];
        }
        System.arraycopy(watchedDoubleStepQREigen_FDRM.eigenvalues, 0, this.origEigenvalues, 0, this.f2585N);
        watchedDoubleStepQREigen_FDRM.setup(fMatrixRMaj);
        watchedDoubleStepQREigen_FDRM.setQ(this.f2586Q);
        this.numSplits = 0;
        this.onscript = true;
        if (findQandR()) {
            return extractVectors(fMatrixRMaj2);
        }
        return false;
    }

    public boolean extractVectors(FMatrixRMaj fMatrixRMaj) {
        Arrays.fill(this.eigenvectorTemp.data, 0.0f);
        boolean z = true;
        for (int i = 0; i < this.f2585N; i++) {
            Complex_F32 complex_F32 = this.implicit.eigenvalues[(this.f2585N - i) - 1];
            if (z && !complex_F32.isReal()) {
                z = false;
            }
            if (complex_F32.isReal() && this.eigenvectors[(this.f2585N - i) - 1] == null) {
                solveEigenvectorDuplicateEigenvalue(complex_F32.real, i, z);
            }
        }
        if (fMatrixRMaj != null) {
            FMatrixRMaj fMatrixRMaj2 = new FMatrixRMaj(this.f2585N, 1);
            for (int i2 = 0; i2 < this.f2585N; i2++) {
                FMatrixRMaj fMatrixRMaj3 = this.eigenvectors[i2];
                if (fMatrixRMaj3 != null) {
                    CommonOps_FDRM.mult(fMatrixRMaj, fMatrixRMaj3, fMatrixRMaj2);
                    this.eigenvectors[i2] = fMatrixRMaj2;
                    fMatrixRMaj2 = fMatrixRMaj3;
                }
            }
        }
        return true;
    }

    private void solveEigenvectorDuplicateEigenvalue(float f, int i, boolean z) {
        float fAbs = Math.abs(f);
        if (fAbs == 0.0f) {
            fAbs = 1.0f;
        }
        this.eigenvectorTemp.reshape(this.f2585N, 1, false);
        this.eigenvectorTemp.zero();
        if (i > 0) {
            if (z) {
                solveUsingTriangle(f, i, this.eigenvectorTemp);
            } else {
                solveWithLU(f, i, this.eigenvectorTemp);
            }
        }
        this.eigenvectorTemp.reshape(this.f2585N, 1, false);
        while (i < this.f2585N) {
            Complex_F32 complex_F32 = this.implicit.eigenvalues[(this.f2585N - i) - 1];
            if (complex_F32.isReal() && Math.abs(complex_F32.real - f) / fAbs < UtilEjml.F_EPS * 100.0f) {
                this.eigenvectorTemp.data[i] = 1.0f;
                FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(this.f2585N, 1);
                CommonOps_FDRM.multTransA(this.f2586Q, this.eigenvectorTemp, fMatrixRMaj);
                this.eigenvectors[(this.f2585N - i) - 1] = fMatrixRMaj;
                NormOps_FDRM.normalizeF(fMatrixRMaj);
                this.eigenvectorTemp.data[i] = 0.0f;
            }
            i++;
        }
    }

    private void solveUsingTriangle(float f, int i, FMatrixRMaj fMatrixRMaj) {
        for (int i2 = 0; i2 < i; i2++) {
            this.implicit.f2573A.add(i2, i2, -f);
        }
        SpecializedOps_FDRM.subvector(this.implicit.f2573A, 0, i, i, false, 0, fMatrixRMaj);
        CommonOps_FDRM.changeSign(fMatrixRMaj);
        TriangularSolver_FDRM.solveU(this.implicit.f2573A.data, fMatrixRMaj.data, this.implicit.f2573A.numRows, 0, i);
        for (int i3 = 0; i3 < i; i3++) {
            this.implicit.f2573A.add(i3, i3, f);
        }
    }

    private void solveWithLU(float f, int i, FMatrixRMaj fMatrixRMaj) {
        FMatrixRMaj fMatrixRMaj2 = new FMatrixRMaj(i, i);
        CommonOps_FDRM.extract(this.implicit.f2573A, 0, i, 0, i, fMatrixRMaj2, 0, 0);
        for (int i2 = 0; i2 < i; i2++) {
            fMatrixRMaj2.add(i2, i2, -f);
        }
        fMatrixRMaj.reshape(i, 1, false);
        SpecializedOps_FDRM.subvector(this.implicit.f2573A, 0, i, i, false, 0, fMatrixRMaj);
        CommonOps_FDRM.changeSign(fMatrixRMaj);
        if (!this.solver.setA(fMatrixRMaj2)) {
            throw new RuntimeException("Solve failed");
        }
        this.solver.solve(fMatrixRMaj, fMatrixRMaj);
    }

    public boolean findQandR() {
        CommonOps_FDRM.setIdentity(this.f2586Q);
        this.f2587x1 = 0;
        this.f2588x2 = this.f2585N - 1;
        this.indexVal = 0;
        while (this.indexVal < this.f2585N) {
            if (!findNextEigenvalue()) {
                return false;
            }
        }
        return true;
    }

    private boolean findNextEigenvalue() {
        boolean z = false;
        while (!z && this.implicit.steps < this.implicit.maxIterations) {
            this.implicit.incrementSteps();
            int i = this.f2588x2;
            int i2 = this.f2587x1;
            if (i < i2) {
                moveToNextSplit();
            } else {
                if (i - i2 == 0) {
                    this.implicit.addEigenAt(i2);
                    this.f2588x2--;
                    this.indexVal++;
                } else if (i - i2 == 1 && !this.implicit.isReal2x2(i2, i)) {
                    this.implicit.addComputedEigen2x2(this.f2587x1, this.f2588x2);
                    this.f2588x2 -= 2;
                    this.indexVal += 2;
                } else if (this.implicit.steps - this.implicit.lastExceptional > this.implicit.exceptionalThreshold) {
                    this.implicit.exceptionalShift(this.f2587x1, this.f2588x2);
                    WatchedDoubleStepQREigen_FDRM watchedDoubleStepQREigen_FDRM = this.implicit;
                    watchedDoubleStepQREigen_FDRM.lastExceptional = watchedDoubleStepQREigen_FDRM.steps;
                } else {
                    WatchedDoubleStepQREigen_FDRM watchedDoubleStepQREigen_FDRM2 = this.implicit;
                    int i3 = this.f2588x2;
                    if (watchedDoubleStepQREigen_FDRM2.isZero(i3, i3 - 1)) {
                        this.implicit.addEigenAt(this.f2588x2);
                        this.f2588x2--;
                        this.indexVal++;
                    } else {
                        checkSplitPerformImplicit();
                    }
                }
                z = true;
            }
        }
        return z;
    }

    private void checkSplitPerformImplicit() {
        int i = this.f2588x2;
        while (true) {
            int i2 = this.f2587x1;
            if (i > i2) {
                int i3 = i - 1;
                if (this.implicit.isZero(i, i3)) {
                    this.f2587x1 = i;
                    int[] iArr = this.splits;
                    int i4 = this.numSplits;
                    this.numSplits = i4 + 1;
                    iArr[i4] = i3;
                    return;
                }
                i--;
            } else {
                if (this.onscript) {
                    if (this.implicit.steps > this.implicit.exceptionalThreshold / 2) {
                        this.onscript = false;
                        return;
                    }
                    Complex_F32 complex_F32 = this.origEigenvalues[this.indexVal];
                    if (complex_F32.isReal()) {
                        this.implicit.performImplicitSingleStep(this.f2587x1, this.f2588x2, complex_F32.getReal());
                        return;
                    }
                    int i5 = this.f2588x2;
                    int i6 = this.f2587x1;
                    if (i5 - i6 >= 1 && i6 + 2 < this.f2585N) {
                        this.implicit.performImplicitDoubleStep(i6, i5, complex_F32.real, complex_F32.imaginary);
                        return;
                    } else {
                        this.onscript = false;
                        return;
                    }
                }
                int i7 = this.f2588x2;
                if (i7 - i2 >= 1 && i2 + 2 < this.f2585N) {
                    this.implicit.implicitDoubleStep(i2, i7);
                    return;
                }
                WatchedDoubleStepQREigen_FDRM watchedDoubleStepQREigen_FDRM = this.implicit;
                FMatrixRMaj fMatrixRMaj = watchedDoubleStepQREigen_FDRM.f2573A;
                int i8 = this.f2588x2;
                watchedDoubleStepQREigen_FDRM.performImplicitSingleStep(i2, i7, fMatrixRMaj.get(i8, i8));
                return;
            }
        }
    }

    private void moveToNextSplit() {
        int i = this.numSplits;
        if (i <= 0) {
            throw new RuntimeException("bad");
        }
        int[] iArr = this.splits;
        int i2 = i - 1;
        this.numSplits = i2;
        this.f2588x2 = iArr[i2];
        if (i2 > 0) {
            this.f2587x1 = iArr[i - 2] + 1;
        } else {
            this.f2587x1 = 0;
        }
    }

    public FMatrixRMaj getQ() {
        return this.f2586Q;
    }

    public WatchedDoubleStepQREigen_FDRM getImplicit() {
        return this.implicit;
    }

    public FMatrixRMaj[] getEigenvectors() {
        return this.eigenvectors;
    }

    public Complex_F32[] getEigenvalues() {
        return this.implicit.eigenvalues;
    }
}
