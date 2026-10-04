package org.ejml.interfaces.decomposition;

import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface CholeskyLDLDecomposition<MatrixType extends Matrix> extends DecompositionInterface<MatrixType> {
    MatrixType getD(MatrixType matrixtype);

    MatrixType getL(MatrixType matrixtype);
}
