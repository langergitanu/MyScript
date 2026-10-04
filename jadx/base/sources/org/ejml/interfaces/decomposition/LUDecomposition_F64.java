package org.ejml.interfaces.decomposition;

import org.ejml.data.Complex_F64;
import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface LUDecomposition_F64<T extends Matrix> extends LUDecomposition<T> {
    Complex_F64 computeDeterminant();
}
