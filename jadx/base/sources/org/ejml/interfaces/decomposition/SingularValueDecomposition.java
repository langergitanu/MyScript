package org.ejml.interfaces.decomposition;

import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface SingularValueDecomposition<T extends Matrix> extends DecompositionInterface<T> {
    T getU(T t, boolean z);

    T getV(T t, boolean z);

    T getW(T t);

    boolean isCompact();

    int numCols();

    int numRows();

    int numberOfSingularValues();
}
