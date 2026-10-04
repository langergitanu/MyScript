package org.ejml.sparse.csc.factory;

import org.ejml.data.DMatrixSparseCSC;
import org.ejml.interfaces.decomposition.CholeskySparseDecomposition_F64;
import org.ejml.interfaces.decomposition.LUSparseDecomposition_F64;
import org.ejml.interfaces.decomposition.QRSparseDecomposition;
import org.ejml.sparse.FillReducing;
import org.ejml.sparse.csc.decomposition.chol.CholeskyUpLooking_DSCC;
import org.ejml.sparse.csc.decomposition.p053lu.LuUpLooking_DSCC;
import org.ejml.sparse.csc.decomposition.p054qr.QrLeftLookingDecomposition_DSCC;

/* JADX INFO: loaded from: classes9.dex */
public class DecompositionFactory_DSCC {
    public static CholeskySparseDecomposition_F64 cholesky() {
        return new CholeskyUpLooking_DSCC();
    }

    /* JADX INFO: renamed from: qr */
    public static QRSparseDecomposition<DMatrixSparseCSC> m1682qr(FillReducing fillReducing) {
        return new QrLeftLookingDecomposition_DSCC(FillReductionFactory_DSCC.create(fillReducing));
    }

    /* JADX INFO: renamed from: lu */
    public static LUSparseDecomposition_F64<DMatrixSparseCSC> m1681lu(FillReducing fillReducing) {
        return new LuUpLooking_DSCC(FillReductionFactory_DSCC.create(fillReducing));
    }
}
