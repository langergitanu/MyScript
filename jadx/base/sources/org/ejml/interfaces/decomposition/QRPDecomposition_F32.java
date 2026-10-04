package org.ejml.interfaces.decomposition;

import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface QRPDecomposition_F32<T extends Matrix> extends QRPDecomposition<T> {
    void setSingularThreshold(float f);
}
