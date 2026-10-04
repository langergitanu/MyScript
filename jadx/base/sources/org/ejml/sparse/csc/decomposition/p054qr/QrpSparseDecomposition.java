package org.ejml.sparse.csc.decomposition.p054qr;

import org.ejml.data.Matrix;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public interface QrpSparseDecomposition<T extends Matrix> extends QRDecomposition<T> {
    T getColPivotMatrix(T t);

    int[] getColPivots();

    int getRank();

    T getRowPivotMatrix(T t);

    int[] getRowPivots();

    boolean isColumnPivot();

    boolean isRowPivot();
}
