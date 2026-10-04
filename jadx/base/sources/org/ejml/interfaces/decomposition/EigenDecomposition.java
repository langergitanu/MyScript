package org.ejml.interfaces.decomposition;

import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface EigenDecomposition<T extends Matrix> extends DecompositionInterface<T> {
    T getEigenVector(int i);

    int getNumberOfEigenvalues();
}
