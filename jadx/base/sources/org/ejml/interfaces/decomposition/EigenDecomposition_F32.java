package org.ejml.interfaces.decomposition;

import org.ejml.data.Complex_F32;
import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface EigenDecomposition_F32<MatrixType extends Matrix> extends EigenDecomposition<MatrixType> {
    Complex_F32 getEigenvalue(int i);
}
