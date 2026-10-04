package org.ejml.interfaces.decomposition;

import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface DecompositionSparseInterface<T extends Matrix> extends DecompositionInterface<T> {
    boolean isStructureLocked();

    void lockStructure();
}
