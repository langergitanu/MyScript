package org.ejml.interfaces.decomposition;

import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface SingularValueDecomposition_F32<T extends Matrix> extends SingularValueDecomposition<T> {
    float[] getSingularValues();
}
