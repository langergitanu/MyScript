package org.ejml.dense.row.decomposition.eig.watched;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import org.ejml.UtilEjml;
import org.ejml.data.Complex_F64;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.dense.row.NormOps_DDRM;
import org.ejml.dense.row.SpecializedOps_DDRM;
import org.ejml.dense.row.decomposition.TriangularSolver_DDRM;
import org.ejml.dense.row.factory.LinearSolverFactory_DDRM;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class WatchedDoubleStepQREigenvector_DDRM {

    /* JADX INFO: renamed from: N */
    int f2581N;

    /* JADX INFO: renamed from: Q */
    DMatrixRMaj f2582Q;
    DMatrixRMaj eigenvectorTemp;
    DMatrixRMaj[] eigenvectors;
    WatchedDoubleStepQREigen_DDRM implicit;
    int indexVal;
    int numSplits;
    boolean onscript;
    Complex_F64[] origEigenvalues;
    LinearSolverDense solver;
    int[] splits;

    /* JADX INFO: renamed from: x1 */
    int f2583x1;

    /* JADX INFO: renamed from: x2 */
    int f2584x2;

    public boolean process(WatchedDoubleStepQREigen_DDRM watchedDoubleStepQREigen_DDRM, DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        this.implicit = watchedDoubleStepQREigen_DDRM;
        if (this.f2581N != dMatrixRMaj.numRows) {
            this.f2581N = dMatrixRMaj.numRows;
            int i = this.f2581N;
            this.f2582Q = new DMatrixRMaj(i, i);
            int i2 = this.f2581N;
            this.splits = new int[i2];
            this.origEigenvalues = new Complex_F64[i2];
            this.eigenvectors = new DMatrixRMaj[i2];
            this.eigenvectorTemp = new DMatrixRMaj(this.f2581N, 1);
            this.solver = LinearSolverFactory_DDRM.linear(0);
        } else {
            this.eigenvectors = new DMatrixRMaj[this.f2581N];
        }
        System.arraycopy(watchedDoubleStepQREigen_DDRM.eigenvalues, 0, this.origEigenvalues, 0, this.f2581N);
        watchedDoubleStepQREigen_DDRM.setup(dMatrixRMaj);
        watchedDoubleStepQREigen_DDRM.setQ(this.f2582Q);
        this.numSplits = 0;
        this.onscript = true;
        if (findQandR()) {
            return extractVectors(dMatrixRMaj2);
        }
        return false;
    }

    public boolean extractVectors(DMatrixRMaj dMatrixRMaj) {
        Arrays.fill(this.eigenvectorTemp.data, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        boolean z = true;
        for (int i = 0; i < this.f2581N; i++) {
            Complex_F64 complex_F64 = this.implicit.eigenvalues[(this.f2581N - i) - 1];
            if (z && !complex_F64.isReal()) {
                z = false;
            }
            if (complex_F64.isReal() && this.eigenvectors[(this.f2581N - i) - 1] == null) {
                solveEigenvectorDuplicateEigenvalue(complex_F64.real, i, z);
            }
        }
        if (dMatrixRMaj != null) {
            DMatrixRMaj dMatrixRMaj2 = new DMatrixRMaj(this.f2581N, 1);
            for (int i2 = 0; i2 < this.f2581N; i2++) {
                DMatrixRMaj dMatrixRMaj3 = this.eigenvectors[i2];
                if (dMatrixRMaj3 != null) {
                    CommonOps_DDRM.mult(dMatrixRMaj, dMatrixRMaj3, dMatrixRMaj2);
                    this.eigenvectors[i2] = dMatrixRMaj2;
                    dMatrixRMaj2 = dMatrixRMaj3;
                }
            }
        }
        return true;
    }

    private void solveEigenvectorDuplicateEigenvalue(double d, int i, boolean z) {
        int i2 = i;
        double dAbs = Math.abs(d);
        if (dAbs == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            dAbs = 1.0d;
        }
        this.eigenvectorTemp.reshape(this.f2581N, 1, false);
        this.eigenvectorTemp.zero();
        if (i2 > 0) {
            if (z) {
                solveUsingTriangle(d, i2, this.eigenvectorTemp);
            } else {
                solveWithLU(d, i2, this.eigenvectorTemp);
            }
        }
        this.eigenvectorTemp.reshape(this.f2581N, 1, false);
        while (i2 < this.f2581N) {
            Complex_F64 complex_F64 = this.implicit.eigenvalues[(this.f2581N - i2) - 1];
            if (complex_F64.isReal() && Math.abs(complex_F64.real - d) / dAbs < UtilEjml.EPS * 100.0d) {
                this.eigenvectorTemp.data[i2] = 1.0d;
                DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(this.f2581N, 1);
                CommonOps_DDRM.multTransA(this.f2582Q, this.eigenvectorTemp, dMatrixRMaj);
                this.eigenvectors[(this.f2581N - i2) - 1] = dMatrixRMaj;
                NormOps_DDRM.normalizeF(dMatrixRMaj);
                this.eigenvectorTemp.data[i2] = 0.0d;
            }
            i2++;
        }
    }

    private void solveUsingTriangle(double d, int i, DMatrixRMaj dMatrixRMaj) {
        for (int i2 = 0; i2 < i; i2++) {
            this.implicit.f2569A.add(i2, i2, -d);
        }
        SpecializedOps_DDRM.subvector(this.implicit.f2569A, 0, i, i, false, 0, dMatrixRMaj);
        CommonOps_DDRM.changeSign(dMatrixRMaj);
        TriangularSolver_DDRM.solveU(this.implicit.f2569A.data, dMatrixRMaj.data, this.implicit.f2569A.numRows, 0, i);
        for (int i3 = 0; i3 < i; i3++) {
            this.implicit.f2569A.add(i3, i3, d);
        }
    }

    private void solveWithLU(double d, int i, DMatrixRMaj dMatrixRMaj) {
        DMatrixRMaj dMatrixRMaj2 = new DMatrixRMaj(i, i);
        CommonOps_DDRM.extract(this.implicit.f2569A, 0, i, 0, i, dMatrixRMaj2, 0, 0);
        for (int i2 = 0; i2 < i; i2++) {
            dMatrixRMaj2.add(i2, i2, -d);
        }
        dMatrixRMaj.reshape(i, 1, false);
        SpecializedOps_DDRM.subvector(this.implicit.f2569A, 0, i, i, false, 0, dMatrixRMaj);
        CommonOps_DDRM.changeSign(dMatrixRMaj);
        if (!this.solver.setA(dMatrixRMaj2)) {
            throw new RuntimeException("Solve failed");
        }
        this.solver.solve(dMatrixRMaj, dMatrixRMaj);
    }

    public boolean findQandR() {
        CommonOps_DDRM.setIdentity(this.f2582Q);
        this.f2583x1 = 0;
        this.f2584x2 = this.f2581N - 1;
        this.indexVal = 0;
        while (this.indexVal < this.f2581N) {
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
            int i = this.f2584x2;
            int i2 = this.f2583x1;
            if (i < i2) {
                moveToNextSplit();
            } else {
                if (i - i2 == 0) {
                    this.implicit.addEigenAt(i2);
                    this.f2584x2--;
                    this.indexVal++;
                } else if (i - i2 == 1 && !this.implicit.isReal2x2(i2, i)) {
                    this.implicit.addComputedEigen2x2(this.f2583x1, this.f2584x2);
                    this.f2584x2 -= 2;
                    this.indexVal += 2;
                } else if (this.implicit.steps - this.implicit.lastExceptional > this.implicit.exceptionalThreshold) {
                    this.implicit.exceptionalShift(this.f2583x1, this.f2584x2);
                    WatchedDoubleStepQREigen_DDRM watchedDoubleStepQREigen_DDRM = this.implicit;
                    watchedDoubleStepQREigen_DDRM.lastExceptional = watchedDoubleStepQREigen_DDRM.steps;
                } else {
                    WatchedDoubleStepQREigen_DDRM watchedDoubleStepQREigen_DDRM2 = this.implicit;
                    int i3 = this.f2584x2;
                    if (watchedDoubleStepQREigen_DDRM2.isZero(i3, i3 - 1)) {
                        this.implicit.addEigenAt(this.f2584x2);
                        this.f2584x2--;
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
        int i = this.f2584x2;
        while (true) {
            int i2 = this.f2583x1;
            if (i > i2) {
                int i3 = i - 1;
                if (this.implicit.isZero(i, i3)) {
                    this.f2583x1 = i;
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
                    Complex_F64 complex_F64 = this.origEigenvalues[this.indexVal];
                    if (complex_F64.isReal()) {
                        this.implicit.performImplicitSingleStep(this.f2583x1, this.f2584x2, complex_F64.getReal());
                        return;
                    }
                    int i5 = this.f2584x2;
                    int i6 = this.f2583x1;
                    if (i5 - i6 >= 1 && i6 + 2 < this.f2581N) {
                        this.implicit.performImplicitDoubleStep(i6, i5, complex_F64.real, complex_F64.imaginary);
                        return;
                    } else {
                        this.onscript = false;
                        return;
                    }
                }
                int i7 = this.f2584x2;
                if (i7 - i2 >= 1 && i2 + 2 < this.f2581N) {
                    this.implicit.implicitDoubleStep(i2, i7);
                    return;
                }
                WatchedDoubleStepQREigen_DDRM watchedDoubleStepQREigen_DDRM = this.implicit;
                DMatrixRMaj dMatrixRMaj = watchedDoubleStepQREigen_DDRM.f2569A;
                int i8 = this.f2584x2;
                watchedDoubleStepQREigen_DDRM.performImplicitSingleStep(i2, i7, dMatrixRMaj.get(i8, i8));
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
        this.f2584x2 = iArr[i2];
        if (i2 > 0) {
            this.f2583x1 = iArr[i - 2] + 1;
        } else {
            this.f2583x1 = 0;
        }
    }

    public DMatrixRMaj getQ() {
        return this.f2582Q;
    }

    public WatchedDoubleStepQREigen_DDRM getImplicit() {
        return this.implicit;
    }

    public DMatrixRMaj[] getEigenvectors() {
        return this.eigenvectors;
    }

    public Complex_F64[] getEigenvalues() {
        return this.implicit.eigenvalues;
    }
}
