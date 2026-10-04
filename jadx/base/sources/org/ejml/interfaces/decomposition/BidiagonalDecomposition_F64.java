package org.ejml.interfaces.decomposition;

import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface BidiagonalDecomposition_F64<T extends Matrix> extends BidiagonalDecomposition<T> {
    void getDiagonal(double[] dArr, double[] dArr2);
}
