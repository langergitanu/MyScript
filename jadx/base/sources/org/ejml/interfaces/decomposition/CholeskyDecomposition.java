package org.ejml.interfaces.decomposition;

import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface CholeskyDecomposition<MatrixType extends Matrix> extends DecompositionInterface<MatrixType> {
    MatrixType getT(MatrixType matrixtype);

    boolean isLower();
}
