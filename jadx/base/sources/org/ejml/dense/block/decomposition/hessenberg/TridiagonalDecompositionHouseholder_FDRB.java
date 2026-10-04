package org.ejml.dense.block.decomposition.hessenberg;

import org.ejml.data.FMatrixRBlock;
import org.ejml.data.FMatrixRMaj;
import org.ejml.data.FSubmatrixD1;
import org.ejml.dense.block.InnerMultiplication_FDRB;
import org.ejml.dense.block.MatrixMult_FDRB;
import org.ejml.dense.block.decomposition.p045qr.QRDecompositionHouseholder_FDRB;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class TridiagonalDecompositionHouseholder_FDRB implements TridiagonalSimilarDecomposition_F32<FMatrixRBlock> {

    /* JADX INFO: renamed from: A */
    protected FMatrixRBlock f2443A;

    /* JADX INFO: renamed from: V */
    protected FMatrixRBlock f2444V = new FMatrixRBlock(1, 1);
    protected FMatrixRBlock tmp = new FMatrixRBlock(1, 1);
    protected float[] gammas = new float[1];
    protected FMatrixRMaj zerosM = new FMatrixRMaj(1, 1);

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return true;
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition
    public FMatrixRBlock getT(FMatrixRBlock fMatrixRBlock) {
        if (fMatrixRBlock == null) {
            fMatrixRBlock = new FMatrixRBlock(this.f2443A.numRows, this.f2443A.numCols, this.f2443A.blockLength);
        } else {
            if (fMatrixRBlock.numRows != this.f2443A.numRows || fMatrixRBlock.numCols != this.f2443A.numCols) {
                throw new IllegalArgumentException("T must have the same dimensions as the input matrix");
            }
            CommonOps_FDRM.fill(fMatrixRBlock, 0.0f);
        }
        fMatrixRBlock.set(0, 0, this.f2443A.data[0]);
        for (int i = 1; i < this.f2443A.numRows; i++) {
            int i2 = i - 1;
            float f = this.f2443A.get(i2, i);
            fMatrixRBlock.set(i, i, this.f2443A.get(i, i));
            fMatrixRBlock.set(i2, i, f);
            fMatrixRBlock.set(i, i2, f);
        }
        return fMatrixRBlock;
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition
    public FMatrixRBlock getQ(FMatrixRBlock fMatrixRBlock, boolean z) {
        FMatrixRBlock fMatrixRBlockInitializeQ = QRDecompositionHouseholder_FDRB.initializeQ(fMatrixRBlock, this.f2443A.numRows, this.f2443A.numCols, this.f2443A.blockLength, false);
        int iMin = Math.min(this.f2443A.blockLength, this.f2443A.numRows);
        this.f2444V.reshape(iMin, this.f2443A.numCols, false);
        this.tmp.reshape(iMin, this.f2443A.numCols, false);
        FSubmatrixD1 fSubmatrixD1 = new FSubmatrixD1(fMatrixRBlockInitializeQ);
        FSubmatrixD1 fSubmatrixD12 = new FSubmatrixD1(this.f2443A);
        FSubmatrixD1 fSubmatrixD13 = new FSubmatrixD1(this.f2444V);
        FSubmatrixD1 fSubmatrixD14 = new FSubmatrixD1(this.tmp);
        int i = this.f2443A.numRows;
        int i2 = i - (i % this.f2443A.blockLength);
        if (i2 == i) {
            i2 -= this.f2443A.blockLength;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 >= 0) {
            int iMin2 = Math.min(this.f2443A.blockLength, i - i2);
            fSubmatrixD13.col0 = i2;
            fSubmatrixD13.row1 = iMin2;
            fSubmatrixD13.original.reshape(fSubmatrixD13.row1, fSubmatrixD13.col1, false);
            if (z) {
                fSubmatrixD14.row0 = i2;
                fSubmatrixD14.row1 = this.f2443A.numCols;
                fSubmatrixD14.col0 = 0;
                fSubmatrixD14.col1 = iMin2;
            } else {
                fSubmatrixD14.col0 = i2;
                fSubmatrixD14.row1 = iMin2;
            }
            fSubmatrixD14.original.reshape(fSubmatrixD14.row1, fSubmatrixD14.col1, false);
            fSubmatrixD12.col0 = i2;
            fSubmatrixD12.row0 = i2;
            fSubmatrixD12.row1 = fSubmatrixD12.row0 + iMin2;
            copyZeros(fSubmatrixD12);
            TridiagonalHelper_FDRB.computeW_row(this.f2443A.blockLength, fSubmatrixD12, fSubmatrixD13, this.gammas, i2);
            fSubmatrixD1.col0 = i2;
            fSubmatrixD1.row0 = i2;
            if (z) {
                MatrixMult_FDRB.multTransB(this.f2443A.blockLength, fSubmatrixD1, fSubmatrixD12, fSubmatrixD14);
            } else {
                MatrixMult_FDRB.mult(this.f2443A.blockLength, fSubmatrixD12, fSubmatrixD1, fSubmatrixD14);
            }
            if (z) {
                MatrixMult_FDRB.multPlus(this.f2443A.blockLength, fSubmatrixD14, fSubmatrixD13, fSubmatrixD1);
            } else {
                MatrixMult_FDRB.multPlusTransA(this.f2443A.blockLength, fSubmatrixD13, fSubmatrixD14, fSubmatrixD1);
            }
            replaceZeros(fSubmatrixD12);
            i2 -= this.f2443A.blockLength;
        }
        return fMatrixRBlockInitializeQ;
    }

    private void copyZeros(FSubmatrixD1 fSubmatrixD1) {
        int iMin = Math.min(this.f2443A.blockLength, fSubmatrixD1.col1 - fSubmatrixD1.col0);
        for (int i = 0; i < iMin; i++) {
            for (int i2 = 0; i2 <= i; i2++) {
                this.zerosM.unsafe_set(i, i2, fSubmatrixD1.get(i, i2));
                fSubmatrixD1.set(i, i2, 0.0f);
            }
            if (fSubmatrixD1.col0 + i + 1 < fSubmatrixD1.original.numCols) {
                int i3 = i + 1;
                this.zerosM.unsafe_set(i, i3, fSubmatrixD1.get(i, i3));
                fSubmatrixD1.set(i, i3, 1.0f);
            }
        }
    }

    private void replaceZeros(FSubmatrixD1 fSubmatrixD1) {
        int iMin = Math.min(this.f2443A.blockLength, fSubmatrixD1.col1 - fSubmatrixD1.col0);
        for (int i = 0; i < iMin; i++) {
            for (int i2 = 0; i2 <= i; i2++) {
                fSubmatrixD1.set(i, i2, this.zerosM.get(i, i2));
            }
            if (fSubmatrixD1.col0 + i + 1 < fSubmatrixD1.original.numCols) {
                int i3 = i + 1;
                fSubmatrixD1.set(i, i3, this.zerosM.get(i, i3));
            }
        }
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F32
    public void getDiagonal(float[] fArr, float[] fArr2) {
        fArr[0] = this.f2443A.data[0];
        for (int i = 1; i < this.f2443A.numRows; i++) {
            fArr[i] = this.f2443A.get(i, i);
            int i2 = i - 1;
            fArr2[i2] = this.f2443A.get(i2, i);
        }
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(FMatrixRBlock fMatrixRBlock) {
        if (fMatrixRBlock.numCols != fMatrixRBlock.numRows) {
            throw new IllegalArgumentException("Input matrix must be square.");
        }
        init(fMatrixRBlock);
        FSubmatrixD1 fSubmatrixD1 = new FSubmatrixD1(this.f2443A);
        FSubmatrixD1 fSubmatrixD12 = new FSubmatrixD1(this.f2444V);
        FSubmatrixD1 fSubmatrixD13 = new FSubmatrixD1(this.f2443A);
        int i = fMatrixRBlock.numCols;
        int i2 = 0;
        while (i2 < i) {
            int iMin = Math.min(this.f2443A.blockLength, this.f2443A.numRows - i2);
            fSubmatrixD13.col0 = i2;
            fSubmatrixD1.col0 = i2;
            fSubmatrixD13.row0 = i2;
            fSubmatrixD1.row0 = i2;
            fSubmatrixD13.row1 = fSubmatrixD13.row0 + iMin;
            fSubmatrixD12.col0 = i2;
            fSubmatrixD12.row1 = iMin;
            fSubmatrixD12.original.reshape(fSubmatrixD12.row1, fSubmatrixD12.col1, false);
            TridiagonalHelper_FDRB.tridiagUpperRow(this.f2443A.blockLength, fSubmatrixD1, this.gammas, fSubmatrixD12);
            if (fSubmatrixD13.row1 < fMatrixRBlock.numCols) {
                float f = fSubmatrixD13.get(this.f2443A.blockLength - 1, this.f2443A.blockLength);
                fSubmatrixD13.set(this.f2443A.blockLength - 1, this.f2443A.blockLength, 1.0f);
                multPlusTransA(this.f2443A.blockLength, fSubmatrixD13, fSubmatrixD12, fSubmatrixD1);
                multPlusTransA(this.f2443A.blockLength, fSubmatrixD12, fSubmatrixD13, fSubmatrixD1);
                fSubmatrixD13.set(this.f2443A.blockLength - 1, this.f2443A.blockLength, f);
            }
            i2 += this.f2443A.blockLength;
        }
        return true;
    }

    public static void multPlusTransA(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, FSubmatrixD1 fSubmatrixD13) {
        int iMin = Math.min(i, fSubmatrixD1.row1 - fSubmatrixD1.row0);
        int i2 = fSubmatrixD13.row0;
        while (true) {
            i2 += i;
            if (i2 >= fSubmatrixD13.row1) {
                return;
            }
            int iMin2 = Math.min(i, fSubmatrixD13.row1 - i2);
            int i3 = (fSubmatrixD1.row0 * fSubmatrixD1.original.numCols) + (((i2 - fSubmatrixD13.row0) + fSubmatrixD1.col0) * iMin);
            int i4 = i2;
            while (i4 < fSubmatrixD13.col1) {
                int iMin3 = Math.min(i, fSubmatrixD13.col1 - i4);
                int i5 = (fSubmatrixD13.original.numCols * i2) + (i4 * iMin2);
                InnerMultiplication_FDRB.blockMultPlusTransA(fSubmatrixD1.original.data, fSubmatrixD12.original.data, fSubmatrixD13.original.data, i3, (fSubmatrixD12.row0 * fSubmatrixD12.original.numCols) + (((i4 - fSubmatrixD13.col0) + fSubmatrixD12.col0) * iMin), i5, iMin, iMin2, iMin3);
                i4 += i;
            }
        }
    }

    private void init(FMatrixRBlock fMatrixRBlock) {
        this.f2443A = fMatrixRBlock;
        int iMin = Math.min(fMatrixRBlock.blockLength, this.f2443A.numRows);
        this.f2444V.reshape(iMin, this.f2443A.numCols, this.f2443A.blockLength, false);
        this.tmp.reshape(iMin, this.f2443A.numCols, this.f2443A.blockLength, false);
        if (this.gammas.length < this.f2443A.numCols) {
            this.gammas = new float[this.f2443A.numCols];
        }
        this.zerosM.reshape(this.f2443A.blockLength, this.f2443A.blockLength + 1, false);
    }
}
