package org.ejml.interfaces.decomposition;

import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface QRDecomposition<T extends Matrix> extends DecompositionInterface<T> {
    T getQ(T t, boolean z);

    T getR(T t, boolean z);
}
