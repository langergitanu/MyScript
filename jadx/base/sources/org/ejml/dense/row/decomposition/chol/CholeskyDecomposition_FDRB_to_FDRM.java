package org.ejml.dense.row.decomposition.chol;

import org.ejml.EjmlParameters;
import org.ejml.data.Complex_F32;
import org.ejml.data.FMatrixRBlock;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.block.MatrixOps_FDRB;
import org.ejml.dense.block.decomposition.chol.CholeskyOuterForm_FDRB;
import org.ejml.dense.row.decomposition.BaseDecomposition_FDRB_to_FDRM;
import org.ejml.interfaces.decomposition.CholeskyDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class CholeskyDecomposition_FDRB_to_FDRM extends BaseDecomposition_FDRB_to_FDRM implements CholeskyDecomposition_F32<FMatrixRMaj> {
    public CholeskyDecomposition_FDRB_to_FDRM(boolean z) {
        super(new CholeskyOuterForm_FDRB(z), EjmlParameters.BLOCK_WIDTH);
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition
    public boolean isLower() {
        return ((CholeskyOuterForm_FDRB) this.alg).isLower();
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition
    public FMatrixRMaj getT(FMatrixRMaj fMatrixRMaj) {
        FMatrixRBlock t = ((CholeskyOuterForm_FDRB) this.alg).getT((FMatrixRBlock) null);
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(t.numRows, t.numCols);
        }
        MatrixOps_FDRB.convert(t, fMatrixRMaj);
        return fMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition_F32
    public Complex_F32 computeDeterminant() {
        return ((CholeskyOuterForm_FDRB) this.alg).computeDeterminant();
    }
}
