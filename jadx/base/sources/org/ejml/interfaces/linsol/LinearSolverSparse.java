package org.ejml.interfaces.linsol;

import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface LinearSolverSparse<S extends Matrix, D extends Matrix> extends LinearSolver<S, D> {
    boolean isStructureLocked();

    void lockStructure();
}
