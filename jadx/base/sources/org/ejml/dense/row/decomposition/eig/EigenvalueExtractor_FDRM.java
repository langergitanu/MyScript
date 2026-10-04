package org.ejml.dense.row.decomposition.eig;

import org.ejml.data.Complex_F32;
import org.ejml.data.FMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public interface EigenvalueExtractor_FDRM {
    Complex_F32[] getEigenvalues();

    int getNumberOfEigenvalues();

    boolean process(FMatrixRMaj fMatrixRMaj);
}
