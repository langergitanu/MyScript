package org.ejml.interfaces.decomposition;

import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface CholeskyLDLDecomposition_F32<MatrixType extends Matrix> extends CholeskyLDLDecomposition<MatrixType> {
    float[] getDiagonal();
}
