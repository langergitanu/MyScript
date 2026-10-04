package org.ejml.dense.row.decomposition;

import org.ejml.data.DMatrixRBlock;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.block.MatrixOps_DDRB;
import org.ejml.interfaces.decomposition.DecompositionInterface;

/* JADX INFO: loaded from: classes9.dex */
public class BaseDecomposition_DDRB_to_DDRM implements DecompositionInterface<DMatrixRMaj> {
    protected DMatrixRBlock Ablock = new DMatrixRBlock();
    protected DecompositionInterface<DMatrixRBlock> alg;
    protected int blockLength;
    protected double[] tmp;

    public BaseDecomposition_DDRB_to_DDRM(DecompositionInterface<DMatrixRBlock> decompositionInterface, int i) {
        this.alg = decompositionInterface;
        this.blockLength = i;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixRMaj dMatrixRMaj) {
        this.Ablock.numRows = dMatrixRMaj.numRows;
        this.Ablock.numCols = dMatrixRMaj.numCols;
        this.Ablock.blockLength = this.blockLength;
        this.Ablock.data = dMatrixRMaj.data;
        int iMin = Math.min(this.Ablock.blockLength, dMatrixRMaj.numRows) * dMatrixRMaj.numCols;
        double[] dArr = this.tmp;
        if (dArr == null || dArr.length < iMin) {
            this.tmp = new double[iMin];
        }
        MatrixOps_DDRB.convertRowToBlock(dMatrixRMaj.numRows, dMatrixRMaj.numCols, this.Ablock.blockLength, dMatrixRMaj.data, this.tmp);
        boolean zDecompose = this.alg.decompose(this.Ablock);
        if (!this.alg.inputModified()) {
            MatrixOps_DDRB.convertBlockToRow(dMatrixRMaj.numRows, dMatrixRMaj.numCols, this.Ablock.blockLength, dMatrixRMaj.data, this.tmp);
        }
        return zDecompose;
    }

    public void convertBlockToRow(int i, int i2, int i3, double[] dArr) {
        int iMin = Math.min(i3, i) * i2;
        double[] dArr2 = this.tmp;
        if (dArr2 == null || dArr2.length < iMin) {
            this.tmp = new double[iMin];
        }
        MatrixOps_DDRB.convertBlockToRow(i, i2, this.Ablock.blockLength, dArr, this.tmp);
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return this.alg.inputModified();
    }
}
