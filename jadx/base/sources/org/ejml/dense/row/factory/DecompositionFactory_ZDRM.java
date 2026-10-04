package org.ejml.dense.row.factory;

import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.decompose.chol.CholeskyDecompositionInner_ZDRM;
import org.ejml.dense.row.decompose.p047lu.LUDecompositionAlt_ZDRM;
import org.ejml.dense.row.decompose.p048qr.QRDecompositionHouseholderColumn_ZDRM;
import org.ejml.interfaces.decomposition.CholeskyDecomposition_F64;
import org.ejml.interfaces.decomposition.DecompositionInterface;
import org.ejml.interfaces.decomposition.LUDecomposition_F64;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class DecompositionFactory_ZDRM {
    /* JADX INFO: renamed from: lu */
    public static LUDecomposition_F64<ZMatrixRMaj> m1671lu(int i, int i2) {
        return new LUDecompositionAlt_ZDRM();
    }

    /* JADX INFO: renamed from: qr */
    public static QRDecomposition<ZMatrixRMaj> m1672qr(int i, int i2) {
        return new QRDecompositionHouseholderColumn_ZDRM();
    }

    public static CholeskyDecomposition_F64<ZMatrixRMaj> chol(int i, boolean z) {
        return new CholeskyDecompositionInner_ZDRM(z);
    }

    public static boolean decomposeSafe(DecompositionInterface<ZMatrixRMaj> decompositionInterface, ZMatrixRMaj zMatrixRMaj) {
        if (decompositionInterface.inputModified()) {
            zMatrixRMaj = zMatrixRMaj.copy();
        }
        return decompositionInterface.decompose(zMatrixRMaj);
    }
}
