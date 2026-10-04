package org.ejml.dense.row.factory;

import org.ejml.data.CMatrixRMaj;
import org.ejml.dense.row.decompose.chol.CholeskyDecompositionInner_CDRM;
import org.ejml.dense.row.decompose.p047lu.LUDecompositionAlt_CDRM;
import org.ejml.dense.row.decompose.p048qr.QRDecompositionHouseholderColumn_CDRM;
import org.ejml.interfaces.decomposition.CholeskyDecomposition_F32;
import org.ejml.interfaces.decomposition.DecompositionInterface;
import org.ejml.interfaces.decomposition.LUDecomposition_F32;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class DecompositionFactory_CDRM {
    /* JADX INFO: renamed from: lu */
    public static LUDecomposition_F32<CMatrixRMaj> m1665lu(int i, int i2) {
        return new LUDecompositionAlt_CDRM();
    }

    /* JADX INFO: renamed from: qr */
    public static QRDecomposition<CMatrixRMaj> m1666qr(int i, int i2) {
        return new QRDecompositionHouseholderColumn_CDRM();
    }

    public static CholeskyDecomposition_F32<CMatrixRMaj> chol(int i, boolean z) {
        return new CholeskyDecompositionInner_CDRM(z);
    }

    public static boolean decomposeSafe(DecompositionInterface<CMatrixRMaj> decompositionInterface, CMatrixRMaj cMatrixRMaj) {
        if (decompositionInterface.inputModified()) {
            cMatrixRMaj = cMatrixRMaj.copy();
        }
        return decompositionInterface.decompose(cMatrixRMaj);
    }
}
