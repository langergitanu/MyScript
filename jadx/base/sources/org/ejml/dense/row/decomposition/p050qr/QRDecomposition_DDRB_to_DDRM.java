package org.ejml.dense.row.decomposition.p050qr;

import org.ejml.EjmlParameters;
import org.ejml.data.DMatrixRBlock;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.block.MatrixOps_DDRB;
import org.ejml.dense.block.decomposition.p045qr.QRDecompositionHouseholder_DDRB;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.dense.row.decomposition.BaseDecomposition_DDRB_to_DDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class QRDecomposition_DDRB_to_DDRM extends BaseDecomposition_DDRB_to_DDRM implements QRDecomposition<DMatrixRMaj> {
    public QRDecomposition_DDRB_to_DDRM() {
        super(new QRDecompositionHouseholder_DDRB(), EjmlParameters.BLOCK_WIDTH);
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public DMatrixRMaj getQ(DMatrixRMaj dMatrixRMaj, boolean z) {
        int iMin = Math.min(this.Ablock.numRows, this.Ablock.numCols);
        if (dMatrixRMaj == null) {
            if (z) {
                dMatrixRMaj = new DMatrixRMaj(this.Ablock.numRows, iMin);
                CommonOps_DDRM.setIdentity(dMatrixRMaj);
            } else {
                dMatrixRMaj = new DMatrixRMaj(this.Ablock.numRows, this.Ablock.numRows);
                CommonOps_DDRM.setIdentity(dMatrixRMaj);
            }
        }
        DMatrixRBlock dMatrixRBlock = new DMatrixRBlock();
        dMatrixRBlock.numRows = dMatrixRMaj.numRows;
        dMatrixRBlock.numCols = dMatrixRMaj.numCols;
        dMatrixRBlock.blockLength = this.blockLength;
        dMatrixRBlock.data = dMatrixRMaj.data;
        ((QRDecompositionHouseholder_DDRB) this.alg).getQ(dMatrixRBlock, z);
        convertBlockToRow(dMatrixRMaj.numRows, dMatrixRMaj.numCols, this.Ablock.blockLength, dMatrixRMaj.data);
        return dMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public DMatrixRMaj getR(DMatrixRMaj dMatrixRMaj, boolean z) {
        DMatrixRBlock r = ((QRDecompositionHouseholder_DDRB) this.alg).getR((DMatrixRBlock) null, z);
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(r.numRows, r.numCols);
        }
        MatrixOps_DDRB.convert(r, dMatrixRMaj);
        return dMatrixRMaj;
    }
}
