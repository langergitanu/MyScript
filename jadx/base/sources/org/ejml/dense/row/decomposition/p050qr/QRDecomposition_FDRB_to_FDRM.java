package org.ejml.dense.row.decomposition.p050qr;

import org.ejml.EjmlParameters;
import org.ejml.data.FMatrixRBlock;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.block.MatrixOps_FDRB;
import org.ejml.dense.block.decomposition.p045qr.QRDecompositionHouseholder_FDRB;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.dense.row.decomposition.BaseDecomposition_FDRB_to_FDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class QRDecomposition_FDRB_to_FDRM extends BaseDecomposition_FDRB_to_FDRM implements QRDecomposition<FMatrixRMaj> {
    public QRDecomposition_FDRB_to_FDRM() {
        super(new QRDecompositionHouseholder_FDRB(), EjmlParameters.BLOCK_WIDTH);
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public FMatrixRMaj getQ(FMatrixRMaj fMatrixRMaj, boolean z) {
        int iMin = Math.min(this.Ablock.numRows, this.Ablock.numCols);
        if (fMatrixRMaj == null) {
            if (z) {
                fMatrixRMaj = new FMatrixRMaj(this.Ablock.numRows, iMin);
                CommonOps_FDRM.setIdentity(fMatrixRMaj);
            } else {
                fMatrixRMaj = new FMatrixRMaj(this.Ablock.numRows, this.Ablock.numRows);
                CommonOps_FDRM.setIdentity(fMatrixRMaj);
            }
        }
        FMatrixRBlock fMatrixRBlock = new FMatrixRBlock();
        fMatrixRBlock.numRows = fMatrixRMaj.numRows;
        fMatrixRBlock.numCols = fMatrixRMaj.numCols;
        fMatrixRBlock.blockLength = this.blockLength;
        fMatrixRBlock.data = fMatrixRMaj.data;
        ((QRDecompositionHouseholder_FDRB) this.alg).getQ(fMatrixRBlock, z);
        convertBlockToRow(fMatrixRMaj.numRows, fMatrixRMaj.numCols, this.Ablock.blockLength, fMatrixRMaj.data);
        return fMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public FMatrixRMaj getR(FMatrixRMaj fMatrixRMaj, boolean z) {
        FMatrixRBlock r = ((QRDecompositionHouseholder_FDRB) this.alg).getR((FMatrixRBlock) null, z);
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(r.numRows, r.numCols);
        }
        MatrixOps_FDRB.convert(r, fMatrixRMaj);
        return fMatrixRMaj;
    }
}
