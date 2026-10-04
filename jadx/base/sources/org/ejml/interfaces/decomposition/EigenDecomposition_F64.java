package org.ejml.interfaces.decomposition;

import org.ejml.data.Complex_F64;
import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface EigenDecomposition_F64<MatrixType extends Matrix> extends EigenDecomposition<MatrixType> {
    Complex_F64 getEigenvalue(int i);
}
