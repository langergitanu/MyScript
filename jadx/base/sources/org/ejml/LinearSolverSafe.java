package org.ejml;

import org.ejml.data.ReshapeMatrix;
import org.ejml.interfaces.decomposition.DecompositionInterface;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes7.dex */
public class LinearSolverSafe<T extends ReshapeMatrix> implements LinearSolverDense<T> {

    /* JADX INFO: renamed from: A */
    private T f2392A;

    /* JADX INFO: renamed from: B */
    private T f2393B;
    private LinearSolverDense<T> alg;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return false;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolverSafe(LinearSolverDense<T> linearSolverDense) {
        this.alg = linearSolverDense;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(T t) {
        if (this.alg.modifiesA()) {
            T t2 = this.f2392A;
            if (t2 == null) {
                this.f2392A = (T) t.copy();
            } else {
                if (t2.getNumRows() != t.getNumRows() || this.f2392A.getNumCols() != t.getNumCols()) {
                    this.f2392A.reshape(t.getNumRows(), t.getNumCols());
                }
                this.f2392A.set(t);
            }
            return this.alg.setA(this.f2392A);
        }
        return this.alg.setA(t);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return this.alg.quality();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(T t, T t2) {
        if (this.alg.modifiesB()) {
            T t3 = this.f2393B;
            if (t3 == null) {
                this.f2393B = (T) t.copy();
            } else {
                if (t3.getNumRows() != t.getNumRows() || this.f2393B.getNumCols() != t.getNumCols()) {
                    this.f2393B.reshape(this.f2392A.getNumRows(), t.getNumCols());
                }
                this.f2393B.set(t);
            }
            t = this.f2393B;
        }
        this.alg.solve(t, t2);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(T t) {
        this.alg.invert(t);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public <D extends DecompositionInterface> D getDecomposition() {
        return (D) this.alg.getDecomposition();
    }
}
