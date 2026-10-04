package org.ejml.interfaces.decomposition;

import org.ejml.data.Complex_F64;
import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface CholeskySparseDecomposition_F64<MatrixType extends Matrix> extends CholeskySparseDecomposition<MatrixType> {
    Complex_F64 computeDeterminant();
}
