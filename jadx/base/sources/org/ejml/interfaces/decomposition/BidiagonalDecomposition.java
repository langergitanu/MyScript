package org.ejml.interfaces.decomposition;

import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface BidiagonalDecomposition<T extends Matrix> extends DecompositionInterface<T> {
    T getB(T t, boolean z);

    T getU(T t, boolean z, boolean z2);

    T getV(T t, boolean z, boolean z2);
}
