package org.ejml.interfaces.decomposition;

import org.ejml.data.IGrowArray;
import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface LUDecomposition<T extends Matrix> extends DecompositionInterface<T> {
    T getLower(T t);

    T getRowPivot(T t);

    int[] getRowPivotV(IGrowArray iGrowArray);

    T getUpper(T t);

    boolean isSingular();
}
