package org.ejml.interfaces.decomposition;

import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface TridiagonalSimilarDecomposition<MatrixType extends Matrix> extends DecompositionInterface<MatrixType> {
    MatrixType getQ(MatrixType matrixtype, boolean z);

    MatrixType getT(MatrixType matrixtype);
}
