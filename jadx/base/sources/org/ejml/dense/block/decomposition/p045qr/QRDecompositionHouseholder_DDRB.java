package org.ejml.dense.block.decomposition.p045qr;

import org.ejml.data.DMatrixRBlock;
import org.ejml.data.DSubmatrixD1;
import org.ejml.dense.block.MatrixMult_DDRB;
import org.ejml.dense.block.MatrixOps_DDRB;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class QRDecompositionHouseholder_DDRB implements QRDecomposition<DMatrixRBlock> {
    private int blockLength;
    private DMatrixRBlock dataA;
    private DMatrixRBlock dataW = new DMatrixRBlock(1, 1);
    private DMatrixRBlock dataWTA = new DMatrixRBlock(1, 1);

    /* JADX INFO: renamed from: A */
    private DSubmatrixD1 f2445A = new DSubmatrixD1();

    /* JADX INFO: renamed from: Y */
    private DSubmatrixD1 f2447Y = new DSubmatrixD1();

    /* JADX INFO: renamed from: W */
    private DSubmatrixD1 f2446W = new DSubmatrixD1(this.dataW);
    private DSubmatrixD1 WTA = new DSubmatrixD1(this.dataWTA);
    private double[] temp = new double[1];
    private double[] gammas = new double[1];
    private boolean saveW = false;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return true;
    }

    public DMatrixRBlock getQR() {
        return this.dataA;
    }

    public void setSaveW(boolean z) {
        this.saveW = z;
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public DMatrixRBlock getQ(DMatrixRBlock dMatrixRBlock, boolean z) {
        DMatrixRBlock dMatrixRBlockInitializeQ = initializeQ(dMatrixRBlock, this.dataA.numRows, this.dataA.numCols, this.blockLength, z);
        applyQ(dMatrixRBlockInitializeQ, true);
        return dMatrixRBlockInitializeQ;
    }

    public static DMatrixRBlock initializeQ(DMatrixRBlock dMatrixRBlock, int i, int i2, int i3, boolean z) {
        int iMin = Math.min(i, i2);
        if (z) {
            if (dMatrixRBlock == null) {
                DMatrixRBlock dMatrixRBlock2 = new DMatrixRBlock(i, iMin, i3);
                MatrixOps_DDRB.setIdentity(dMatrixRBlock2);
                return dMatrixRBlock2;
            }
            if (dMatrixRBlock.numRows != i || dMatrixRBlock.numCols != iMin) {
                throw new IllegalArgumentException("Unexpected matrix dimension. Found " + dMatrixRBlock.numRows + " " + dMatrixRBlock.numCols);
            }
            MatrixOps_DDRB.setIdentity(dMatrixRBlock);
            return dMatrixRBlock;
        }
        if (dMatrixRBlock == null) {
            DMatrixRBlock dMatrixRBlock3 = new DMatrixRBlock(i, i, i3);
            MatrixOps_DDRB.setIdentity(dMatrixRBlock3);
            return dMatrixRBlock3;
        }
        if (dMatrixRBlock.numRows != i || dMatrixRBlock.numCols != i) {
            throw new IllegalArgumentException("Unexpected matrix dimension. Found " + dMatrixRBlock.numRows + " " + dMatrixRBlock.numCols);
        }
        MatrixOps_DDRB.setIdentity(dMatrixRBlock);
        return dMatrixRBlock;
    }

    public void applyQ(DMatrixRBlock dMatrixRBlock) {
        applyQ(dMatrixRBlock, false);
    }

    public void applyQ(DMatrixRBlock dMatrixRBlock, boolean z) {
        int iMin = Math.min(this.dataA.numCols, this.dataA.numRows);
        DSubmatrixD1 dSubmatrixD1 = new DSubmatrixD1(dMatrixRBlock);
        DSubmatrixD1 dSubmatrixD12 = this.f2446W;
        dSubmatrixD12.row0 = 0;
        dSubmatrixD12.col0 = 0;
        DSubmatrixD1 dSubmatrixD13 = this.f2447Y;
        DSubmatrixD1 dSubmatrixD14 = this.f2446W;
        int i = this.dataA.numRows;
        dSubmatrixD14.row1 = i;
        dSubmatrixD13.row1 = i;
        DSubmatrixD1 dSubmatrixD15 = this.WTA;
        dSubmatrixD15.col0 = 0;
        dSubmatrixD15.row0 = 0;
        int i2 = this.blockLength;
        int i3 = iMin - (iMin % i2);
        if (i3 == iMin) {
            i3 -= i2;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 >= 0) {
            this.f2447Y.col0 = i3;
            DSubmatrixD1 dSubmatrixD16 = this.f2447Y;
            dSubmatrixD16.col1 = Math.min(dSubmatrixD16.col0 + this.blockLength, this.dataA.numCols);
            this.f2447Y.row0 = i3;
            if (z) {
                dSubmatrixD1.col0 = i3;
            }
            dSubmatrixD1.row0 = i3;
            setW();
            this.WTA.row1 = this.f2447Y.col1 - this.f2447Y.col0;
            this.WTA.col1 = dSubmatrixD1.col1 - dSubmatrixD1.col0;
            this.WTA.original.reshape(this.WTA.row1, this.WTA.col1, false);
            if (!this.saveW) {
                int i4 = this.blockLength;
                DSubmatrixD1 dSubmatrixD17 = this.f2447Y;
                BlockHouseHolder_DDRB.computeW_Column(i4, dSubmatrixD17, this.f2446W, this.temp, this.gammas, dSubmatrixD17.col0);
            }
            BlockHouseHolder_DDRB.multTransA_vecCol(this.blockLength, this.f2447Y, dSubmatrixD1, this.WTA);
            MatrixMult_DDRB.multPlus(this.blockLength, this.f2446W, this.WTA, dSubmatrixD1);
            i3 -= this.blockLength;
        }
    }

    public void applyQTran(DMatrixRBlock dMatrixRBlock) {
        int iMin = Math.min(this.dataA.numCols, this.dataA.numRows);
        DSubmatrixD1 dSubmatrixD1 = new DSubmatrixD1(dMatrixRBlock);
        DSubmatrixD1 dSubmatrixD12 = this.f2446W;
        dSubmatrixD12.row0 = 0;
        dSubmatrixD12.col0 = 0;
        DSubmatrixD1 dSubmatrixD13 = this.f2447Y;
        DSubmatrixD1 dSubmatrixD14 = this.f2446W;
        int i = this.dataA.numRows;
        dSubmatrixD14.row1 = i;
        dSubmatrixD13.row1 = i;
        DSubmatrixD1 dSubmatrixD15 = this.WTA;
        dSubmatrixD15.col0 = 0;
        dSubmatrixD15.row0 = 0;
        int i2 = 0;
        while (i2 < iMin) {
            this.f2447Y.col0 = i2;
            DSubmatrixD1 dSubmatrixD16 = this.f2447Y;
            dSubmatrixD16.col1 = Math.min(dSubmatrixD16.col0 + this.blockLength, this.dataA.numCols);
            this.f2447Y.row0 = i2;
            dSubmatrixD1.row0 = i2;
            setW();
            this.WTA.row0 = 0;
            this.WTA.col0 = 0;
            this.WTA.row1 = this.f2446W.col1 - this.f2446W.col0;
            this.WTA.col1 = dSubmatrixD1.col1 - dSubmatrixD1.col0;
            this.WTA.original.reshape(this.WTA.row1, this.WTA.col1, false);
            if (!this.saveW) {
                int i3 = this.blockLength;
                DSubmatrixD1 dSubmatrixD17 = this.f2447Y;
                BlockHouseHolder_DDRB.computeW_Column(i3, dSubmatrixD17, this.f2446W, this.temp, this.gammas, dSubmatrixD17.col0);
            }
            MatrixMult_DDRB.multTransA(this.blockLength, this.f2446W, dSubmatrixD1, this.WTA);
            BlockHouseHolder_DDRB.multAdd_zeros(this.blockLength, this.f2447Y, this.WTA, dSubmatrixD1);
            i2 += this.blockLength;
        }
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public DMatrixRBlock getR(DMatrixRBlock dMatrixRBlock, boolean z) {
        int iMin = Math.min(this.dataA.numRows, this.dataA.numCols);
        if (dMatrixRBlock == null) {
            if (z) {
                dMatrixRBlock = new DMatrixRBlock(iMin, this.dataA.numCols, this.blockLength);
            } else {
                dMatrixRBlock = new DMatrixRBlock(this.dataA.numRows, this.dataA.numCols, this.blockLength);
            }
        } else if (z) {
            if (dMatrixRBlock.numCols != this.dataA.numCols || dMatrixRBlock.numRows != iMin) {
                throw new IllegalArgumentException("Unexpected dimension.");
            }
        } else if (dMatrixRBlock.numCols != this.dataA.numCols || dMatrixRBlock.numRows != this.dataA.numRows) {
            throw new IllegalArgumentException("Unexpected dimension.");
        }
        MatrixOps_DDRB.zeroTriangle(false, dMatrixRBlock);
        MatrixOps_DDRB.copyTriangle(true, this.dataA, dMatrixRBlock);
        return dMatrixRBlock;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixRBlock dMatrixRBlock) {
        setup(dMatrixRBlock);
        int iMin = Math.min(dMatrixRBlock.numCols, dMatrixRBlock.numRows);
        int i = 0;
        while (i < iMin) {
            this.f2447Y.col0 = i;
            this.f2447Y.col1 = Math.min(dMatrixRBlock.numCols, this.f2447Y.col0 + this.blockLength);
            this.f2447Y.row0 = i;
            if (!BlockHouseHolder_DDRB.decomposeQR_block_col(this.blockLength, this.f2447Y, this.gammas)) {
                return false;
            }
            updateA(this.f2445A);
            i += this.blockLength;
        }
        return true;
    }

    private void setup(DMatrixRBlock dMatrixRBlock) {
        int i = dMatrixRBlock.blockLength;
        this.blockLength = i;
        this.dataW.blockLength = i;
        this.dataWTA.blockLength = this.blockLength;
        this.dataA = dMatrixRBlock;
        this.f2445A.original = dMatrixRBlock;
        int iMin = Math.min(this.blockLength, dMatrixRBlock.numCols);
        this.dataW.reshape(dMatrixRBlock.numRows, iMin, false);
        this.dataWTA.reshape(iMin, dMatrixRBlock.numRows, false);
        this.f2447Y.original = dMatrixRBlock;
        DSubmatrixD1 dSubmatrixD1 = this.f2447Y;
        DSubmatrixD1 dSubmatrixD12 = this.f2446W;
        int i2 = dMatrixRBlock.numRows;
        dSubmatrixD12.row1 = i2;
        dSubmatrixD1.row1 = i2;
        int length = this.temp.length;
        int i3 = this.blockLength;
        if (length < i3) {
            this.temp = new double[i3];
        }
        if (this.gammas.length < dMatrixRBlock.numCols) {
            this.gammas = new double[dMatrixRBlock.numCols];
        }
        if (this.saveW) {
            this.dataW.reshape(dMatrixRBlock.numRows, dMatrixRBlock.numCols, false);
        }
    }

    protected void updateA(DSubmatrixD1 dSubmatrixD1) {
        setW();
        dSubmatrixD1.row0 = this.f2447Y.row0;
        dSubmatrixD1.row1 = this.f2447Y.row1;
        dSubmatrixD1.col0 = this.f2447Y.col1;
        dSubmatrixD1.col1 = this.f2447Y.original.numCols;
        this.WTA.row0 = 0;
        this.WTA.col0 = 0;
        this.WTA.row1 = this.f2446W.col1 - this.f2446W.col0;
        this.WTA.col1 = dSubmatrixD1.col1 - dSubmatrixD1.col0;
        this.WTA.original.reshape(this.WTA.row1, this.WTA.col1, false);
        if (dSubmatrixD1.col1 > dSubmatrixD1.col0) {
            int i = this.blockLength;
            DSubmatrixD1 dSubmatrixD12 = this.f2447Y;
            BlockHouseHolder_DDRB.computeW_Column(i, dSubmatrixD12, this.f2446W, this.temp, this.gammas, dSubmatrixD12.col0);
            MatrixMult_DDRB.multTransA(this.blockLength, this.f2446W, dSubmatrixD1, this.WTA);
            BlockHouseHolder_DDRB.multAdd_zeros(this.blockLength, this.f2447Y, this.WTA, dSubmatrixD1);
            return;
        }
        if (this.saveW) {
            int i2 = this.blockLength;
            DSubmatrixD1 dSubmatrixD13 = this.f2447Y;
            BlockHouseHolder_DDRB.computeW_Column(i2, dSubmatrixD13, this.f2446W, this.temp, this.gammas, dSubmatrixD13.col0);
        }
    }

    private void setW() {
        if (this.saveW) {
            this.f2446W.col0 = this.f2447Y.col0;
            this.f2446W.col1 = this.f2447Y.col1;
            this.f2446W.row0 = this.f2447Y.row0;
            this.f2446W.row1 = this.f2447Y.row1;
            return;
        }
        this.f2446W.col1 = this.f2447Y.col1 - this.f2447Y.col0;
        this.f2446W.row0 = this.f2447Y.row0;
    }
}
