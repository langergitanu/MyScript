package org.ejml.interfaces.decomposition;

import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface BidiagonalDecomposition_F32<T extends Matrix> extends BidiagonalDecomposition<T> {
    void getDiagonal(float[] fArr, float[] fArr2);
}
