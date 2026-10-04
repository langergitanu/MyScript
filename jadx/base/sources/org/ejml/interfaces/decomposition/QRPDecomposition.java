package org.ejml.interfaces.decomposition;

import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface QRPDecomposition<T extends Matrix> extends QRDecomposition<T> {
    T getColPivotMatrix(T t);

    int[] getColPivots();

    int getRank();
}
