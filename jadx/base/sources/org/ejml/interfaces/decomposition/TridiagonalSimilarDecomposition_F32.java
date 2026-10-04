package org.ejml.interfaces.decomposition;

import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface TridiagonalSimilarDecomposition_F32<MatrixType extends Matrix> extends TridiagonalSimilarDecomposition<MatrixType> {
    void getDiagonal(float[] fArr, float[] fArr2);
}
