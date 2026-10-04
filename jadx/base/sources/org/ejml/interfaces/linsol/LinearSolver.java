package org.ejml.interfaces.linsol;

import org.ejml.data.Matrix;
import org.ejml.interfaces.decomposition.DecompositionInterface;

/* JADX INFO: loaded from: classes9.dex */
public interface LinearSolver<S extends Matrix, D extends Matrix> {
    /* JADX WARN: Incorrect return type in method signature: <D::Lorg/ejml/interfaces/decomposition/DecompositionInterface;>()TD; */
    DecompositionInterface getDecomposition();

    boolean modifiesA();

    boolean modifiesB();

    double quality();

    boolean setA(S s);

    void solve(D d, D d2);
}
