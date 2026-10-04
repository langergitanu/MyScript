package org.ejml.dense.row.decomposition.eig;

import org.ejml.data.Complex_F64;
import org.ejml.data.DMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public interface EigenvalueExtractor_DDRM {
    Complex_F64[] getEigenvalues();

    int getNumberOfEigenvalues();

    boolean process(DMatrixRMaj dMatrixRMaj);
}
