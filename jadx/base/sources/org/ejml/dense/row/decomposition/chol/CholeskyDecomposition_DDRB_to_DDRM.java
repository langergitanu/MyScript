package org.ejml.dense.row.decomposition.chol;

import org.ejml.EjmlParameters;
import org.ejml.data.Complex_F64;
import org.ejml.data.DMatrixRBlock;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.block.MatrixOps_DDRB;
import org.ejml.dense.block.decomposition.chol.CholeskyOuterForm_DDRB;
import org.ejml.dense.row.decomposition.BaseDecomposition_DDRB_to_DDRM;
import org.ejml.interfaces.decomposition.CholeskyDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class CholeskyDecomposition_DDRB_to_DDRM extends BaseDecomposition_DDRB_to_DDRM implements CholeskyDecomposition_F64<DMatrixRMaj> {
    public CholeskyDecomposition_DDRB_to_DDRM(boolean z) {
        super(new CholeskyOuterForm_DDRB(z), EjmlParameters.BLOCK_WIDTH);
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition
    public boolean isLower() {
        return ((CholeskyOuterForm_DDRB) this.alg).isLower();
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition
    public DMatrixRMaj getT(DMatrixRMaj dMatrixRMaj) {
        DMatrixRBlock t = ((CholeskyOuterForm_DDRB) this.alg).getT((DMatrixRBlock) null);
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(t.numRows, t.numCols);
        }
        MatrixOps_DDRB.convert(t, dMatrixRMaj);
        return dMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition_F64
    public Complex_F64 computeDeterminant() {
        return ((CholeskyOuterForm_DDRB) this.alg).computeDeterminant();
    }
}
