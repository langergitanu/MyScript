package org.ejml.dense.block.decomposition.p045qr;

import org.ejml.data.FMatrixRBlock;
import org.ejml.data.FSubmatrixD1;
import org.ejml.dense.block.MatrixMult_FDRB;
import org.ejml.dense.block.MatrixOps_FDRB;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class QRDecompositionHouseholder_FDRB implements QRDecomposition<FMatrixRBlock> {
    private int blockLength;
    private FMatrixRBlock dataA;
    private FMatrixRBlock dataW = new FMatrixRBlock(1, 1);
    private FMatrixRBlock dataWTA = new FMatrixRBlock(1, 1);

    /* JADX INFO: renamed from: A */
    private FSubmatrixD1 f2448A = new FSubmatrixD1();

    /* JADX INFO: renamed from: Y */
    private FSubmatrixD1 f2450Y = new FSubmatrixD1();

    /* JADX INFO: renamed from: W */
    private FSubmatrixD1 f2449W = new FSubmatrixD1(this.dataW);
    private FSubmatrixD1 WTA = new FSubmatrixD1(this.dataWTA);
    private float[] temp = new float[1];
    private float[] gammas = new float[1];
    private boolean saveW = false;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return true;
    }

    public FMatrixRBlock getQR() {
        return this.dataA;
    }

    public void setSaveW(boolean z) {
        this.saveW = z;
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public FMatrixRBlock getQ(FMatrixRBlock fMatrixRBlock, boolean z) {
        FMatrixRBlock fMatrixRBlockInitializeQ = initializeQ(fMatrixRBlock, this.dataA.numRows, this.dataA.numCols, this.blockLength, z);
        applyQ(fMatrixRBlockInitializeQ, true);
        return fMatrixRBlockInitializeQ;
    }

    public static FMatrixRBlock initializeQ(FMatrixRBlock fMatrixRBlock, int i, int i2, int i3, boolean z) {
        int iMin = Math.min(i, i2);
        if (z) {
            if (fMatrixRBlock == null) {
                FMatrixRBlock fMatrixRBlock2 = new FMatrixRBlock(i, iMin, i3);
                MatrixOps_FDRB.setIdentity(fMatrixRBlock2);
                return fMatrixRBlock2;
            }
            if (fMatrixRBlock.numRows != i || fMatrixRBlock.numCols != iMin) {
                throw new IllegalArgumentException("Unexpected matrix dimension. Found " + fMatrixRBlock.numRows + " " + fMatrixRBlock.numCols);
            }
            MatrixOps_FDRB.setIdentity(fMatrixRBlock);
            return fMatrixRBlock;
        }
        if (fMatrixRBlock == null) {
            FMatrixRBlock fMatrixRBlock3 = new FMatrixRBlock(i, i, i3);
            MatrixOps_FDRB.setIdentity(fMatrixRBlock3);
            return fMatrixRBlock3;
        }
        if (fMatrixRBlock.numRows != i || fMatrixRBlock.numCols != i) {
            throw new IllegalArgumentException("Unexpected matrix dimension. Found " + fMatrixRBlock.numRows + " " + fMatrixRBlock.numCols);
        }
        MatrixOps_FDRB.setIdentity(fMatrixRBlock);
        return fMatrixRBlock;
    }

    public void applyQ(FMatrixRBlock fMatrixRBlock) {
        applyQ(fMatrixRBlock, false);
    }

    public void applyQ(FMatrixRBlock fMatrixRBlock, boolean z) {
        int iMin = Math.min(this.dataA.numCols, this.dataA.numRows);
        FSubmatrixD1 fSubmatrixD1 = new FSubmatrixD1(fMatrixRBlock);
        FSubmatrixD1 fSubmatrixD12 = this.f2449W;
        fSubmatrixD12.row0 = 0;
        fSubmatrixD12.col0 = 0;
        FSubmatrixD1 fSubmatrixD13 = this.f2450Y;
        FSubmatrixD1 fSubmatrixD14 = this.f2449W;
        int i = this.dataA.numRows;
        fSubmatrixD14.row1 = i;
        fSubmatrixD13.row1 = i;
        FSubmatrixD1 fSubmatrixD15 = this.WTA;
        fSubmatrixD15.col0 = 0;
        fSubmatrixD15.row0 = 0;
        int i2 = this.blockLength;
        int i3 = iMin - (iMin % i2);
        if (i3 == iMin) {
            i3 -= i2;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 >= 0) {
            this.f2450Y.col0 = i3;
            FSubmatrixD1 fSubmatrixD16 = this.f2450Y;
            fSubmatrixD16.col1 = Math.min(fSubmatrixD16.col0 + this.blockLength, this.dataA.numCols);
            this.f2450Y.row0 = i3;
            if (z) {
                fSubmatrixD1.col0 = i3;
            }
            fSubmatrixD1.row0 = i3;
            setW();
            this.WTA.row1 = this.f2450Y.col1 - this.f2450Y.col0;
            this.WTA.col1 = fSubmatrixD1.col1 - fSubmatrixD1.col0;
            this.WTA.original.reshape(this.WTA.row1, this.WTA.col1, false);
            if (!this.saveW) {
                int i4 = this.blockLength;
                FSubmatrixD1 fSubmatrixD17 = this.f2450Y;
                BlockHouseHolder_FDRB.computeW_Column(i4, fSubmatrixD17, this.f2449W, this.temp, this.gammas, fSubmatrixD17.col0);
            }
            BlockHouseHolder_FDRB.multTransA_vecCol(this.blockLength, this.f2450Y, fSubmatrixD1, this.WTA);
            MatrixMult_FDRB.multPlus(this.blockLength, this.f2449W, this.WTA, fSubmatrixD1);
            i3 -= this.blockLength;
        }
    }

    public void applyQTran(FMatrixRBlock fMatrixRBlock) {
        int iMin = Math.min(this.dataA.numCols, this.dataA.numRows);
        FSubmatrixD1 fSubmatrixD1 = new FSubmatrixD1(fMatrixRBlock);
        FSubmatrixD1 fSubmatrixD12 = this.f2449W;
        fSubmatrixD12.row0 = 0;
        fSubmatrixD12.col0 = 0;
        FSubmatrixD1 fSubmatrixD13 = this.f2450Y;
        FSubmatrixD1 fSubmatrixD14 = this.f2449W;
        int i = this.dataA.numRows;
        fSubmatrixD14.row1 = i;
        fSubmatrixD13.row1 = i;
        FSubmatrixD1 fSubmatrixD15 = this.WTA;
        fSubmatrixD15.col0 = 0;
        fSubmatrixD15.row0 = 0;
        int i2 = 0;
        while (i2 < iMin) {
            this.f2450Y.col0 = i2;
            FSubmatrixD1 fSubmatrixD16 = this.f2450Y;
            fSubmatrixD16.col1 = Math.min(fSubmatrixD16.col0 + this.blockLength, this.dataA.numCols);
            this.f2450Y.row0 = i2;
            fSubmatrixD1.row0 = i2;
            setW();
            this.WTA.row0 = 0;
            this.WTA.col0 = 0;
            this.WTA.row1 = this.f2449W.col1 - this.f2449W.col0;
            this.WTA.col1 = fSubmatrixD1.col1 - fSubmatrixD1.col0;
            this.WTA.original.reshape(this.WTA.row1, this.WTA.col1, false);
            if (!this.saveW) {
                int i3 = this.blockLength;
                FSubmatrixD1 fSubmatrixD17 = this.f2450Y;
                BlockHouseHolder_FDRB.computeW_Column(i3, fSubmatrixD17, this.f2449W, this.temp, this.gammas, fSubmatrixD17.col0);
            }
            MatrixMult_FDRB.multTransA(this.blockLength, this.f2449W, fSubmatrixD1, this.WTA);
            BlockHouseHolder_FDRB.multAdd_zeros(this.blockLength, this.f2450Y, this.WTA, fSubmatrixD1);
            i2 += this.blockLength;
        }
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public FMatrixRBlock getR(FMatrixRBlock fMatrixRBlock, boolean z) {
        int iMin = Math.min(this.dataA.numRows, this.dataA.numCols);
        if (fMatrixRBlock == null) {
            if (z) {
                fMatrixRBlock = new FMatrixRBlock(iMin, this.dataA.numCols, this.blockLength);
            } else {
                fMatrixRBlock = new FMatrixRBlock(this.dataA.numRows, this.dataA.numCols, this.blockLength);
            }
        } else if (z) {
            if (fMatrixRBlock.numCols != this.dataA.numCols || fMatrixRBlock.numRows != iMin) {
                throw new IllegalArgumentException("Unexpected dimension.");
            }
        } else if (fMatrixRBlock.numCols != this.dataA.numCols || fMatrixRBlock.numRows != this.dataA.numRows) {
            throw new IllegalArgumentException("Unexpected dimension.");
        }
        MatrixOps_FDRB.zeroTriangle(false, fMatrixRBlock);
        MatrixOps_FDRB.copyTriangle(true, this.dataA, fMatrixRBlock);
        return fMatrixRBlock;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(FMatrixRBlock fMatrixRBlock) {
        setup(fMatrixRBlock);
        int iMin = Math.min(fMatrixRBlock.numCols, fMatrixRBlock.numRows);
        int i = 0;
        while (i < iMin) {
            this.f2450Y.col0 = i;
            this.f2450Y.col1 = Math.min(fMatrixRBlock.numCols, this.f2450Y.col0 + this.blockLength);
            this.f2450Y.row0 = i;
            if (!BlockHouseHolder_FDRB.decomposeQR_block_col(this.blockLength, this.f2450Y, this.gammas)) {
                return false;
            }
            updateA(this.f2448A);
            i += this.blockLength;
        }
        return true;
    }

    private void setup(FMatrixRBlock fMatrixRBlock) {
        int i = fMatrixRBlock.blockLength;
        this.blockLength = i;
        this.dataW.blockLength = i;
        this.dataWTA.blockLength = this.blockLength;
        this.dataA = fMatrixRBlock;
        this.f2448A.original = fMatrixRBlock;
        int iMin = Math.min(this.blockLength, fMatrixRBlock.numCols);
        this.dataW.reshape(fMatrixRBlock.numRows, iMin, false);
        this.dataWTA.reshape(iMin, fMatrixRBlock.numRows, false);
        this.f2450Y.original = fMatrixRBlock;
        FSubmatrixD1 fSubmatrixD1 = this.f2450Y;
        FSubmatrixD1 fSubmatrixD12 = this.f2449W;
        int i2 = fMatrixRBlock.numRows;
        fSubmatrixD12.row1 = i2;
        fSubmatrixD1.row1 = i2;
        int length = this.temp.length;
        int i3 = this.blockLength;
        if (length < i3) {
            this.temp = new float[i3];
        }
        if (this.gammas.length < fMatrixRBlock.numCols) {
            this.gammas = new float[fMatrixRBlock.numCols];
        }
        if (this.saveW) {
            this.dataW.reshape(fMatrixRBlock.numRows, fMatrixRBlock.numCols, false);
        }
    }

    protected void updateA(FSubmatrixD1 fSubmatrixD1) {
        setW();
        fSubmatrixD1.row0 = this.f2450Y.row0;
        fSubmatrixD1.row1 = this.f2450Y.row1;
        fSubmatrixD1.col0 = this.f2450Y.col1;
        fSubmatrixD1.col1 = this.f2450Y.original.numCols;
        this.WTA.row0 = 0;
        this.WTA.col0 = 0;
        this.WTA.row1 = this.f2449W.col1 - this.f2449W.col0;
        this.WTA.col1 = fSubmatrixD1.col1 - fSubmatrixD1.col0;
        this.WTA.original.reshape(this.WTA.row1, this.WTA.col1, false);
        if (fSubmatrixD1.col1 > fSubmatrixD1.col0) {
            int i = this.blockLength;
            FSubmatrixD1 fSubmatrixD12 = this.f2450Y;
            BlockHouseHolder_FDRB.computeW_Column(i, fSubmatrixD12, this.f2449W, this.temp, this.gammas, fSubmatrixD12.col0);
            MatrixMult_FDRB.multTransA(this.blockLength, this.f2449W, fSubmatrixD1, this.WTA);
            BlockHouseHolder_FDRB.multAdd_zeros(this.blockLength, this.f2450Y, this.WTA, fSubmatrixD1);
            return;
        }
        if (this.saveW) {
            int i2 = this.blockLength;
            FSubmatrixD1 fSubmatrixD13 = this.f2450Y;
            BlockHouseHolder_FDRB.computeW_Column(i2, fSubmatrixD13, this.f2449W, this.temp, this.gammas, fSubmatrixD13.col0);
        }
    }

    private void setW() {
        if (this.saveW) {
            this.f2449W.col0 = this.f2450Y.col0;
            this.f2449W.col1 = this.f2450Y.col1;
            this.f2449W.row0 = this.f2450Y.row0;
            this.f2449W.row1 = this.f2450Y.row1;
            return;
        }
        this.f2449W.col1 = this.f2450Y.col1 - this.f2450Y.col0;
        this.f2449W.row0 = this.f2450Y.row0;
    }
}
