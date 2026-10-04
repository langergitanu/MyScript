package org.ejml.interfaces.decomposition;

import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface DecompositionInterface<T extends Matrix> {
    boolean decompose(T t);

    boolean inputModified();
}
