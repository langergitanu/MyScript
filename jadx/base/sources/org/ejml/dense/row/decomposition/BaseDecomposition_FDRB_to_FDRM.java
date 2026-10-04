package org.ejml.dense.row.decomposition;

import org.ejml.data.FMatrixRBlock;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.block.MatrixOps_FDRB;
import org.ejml.interfaces.decomposition.DecompositionInterface;

/* JADX INFO: loaded from: classes9.dex */
public class BaseDecomposition_FDRB_to_FDRM implements DecompositionInterface<FMatrixRMaj> {
    protected FMatrixRBlock Ablock = new FMatrixRBlock();
    protected DecompositionInterface<FMatrixRBlock> alg;
    protected int blockLength;
    protected float[] tmp;

    public BaseDecomposition_FDRB_to_FDRM(DecompositionInterface<FMatrixRBlock> decompositionInterface, int i) {
        this.alg = decompositionInterface;
        this.blockLength = i;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(FMatrixRMaj fMatrixRMaj) {
        this.Ablock.numRows = fMatrixRMaj.numRows;
        this.Ablock.numCols = fMatrixRMaj.numCols;
        this.Ablock.blockLength = this.blockLength;
        this.Ablock.data = fMatrixRMaj.data;
        int iMin = Math.min(this.Ablock.blockLength, fMatrixRMaj.numRows) * fMatrixRMaj.numCols;
        float[] fArr = this.tmp;
        if (fArr == null || fArr.length < iMin) {
            this.tmp = new float[iMin];
        }
        MatrixOps_FDRB.convertRowToBlock(fMatrixRMaj.numRows, fMatrixRMaj.numCols, this.Ablock.blockLength, fMatrixRMaj.data, this.tmp);
        boolean zDecompose = this.alg.decompose(this.Ablock);
        if (!this.alg.inputModified()) {
            MatrixOps_FDRB.convertBlockToRow(fMatrixRMaj.numRows, fMatrixRMaj.numCols, this.Ablock.blockLength, fMatrixRMaj.data, this.tmp);
        }
        return zDecompose;
    }

    public void convertBlockToRow(int i, int i2, int i3, float[] fArr) {
        int iMin = Math.min(i3, i) * i2;
        float[] fArr2 = this.tmp;
        if (fArr2 == null || fArr2.length < iMin) {
            this.tmp = new float[iMin];
        }
        MatrixOps_FDRB.convertBlockToRow(i, i2, this.Ablock.blockLength, fArr, this.tmp);
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return this.alg.inputModified();
    }
}
