package org.ejml.dense.block.decomposition.hessenberg;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrixRBlock;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.DSubmatrixD1;
import org.ejml.dense.block.InnerMultiplication_DDRB;
import org.ejml.dense.block.MatrixMult_DDRB;
import org.ejml.dense.block.decomposition.p045qr.QRDecompositionHouseholder_DDRB;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class TridiagonalDecompositionHouseholder_DDRB implements TridiagonalSimilarDecomposition_F64<DMatrixRBlock> {

    /* JADX INFO: renamed from: A */
    protected DMatrixRBlock f2441A;

    /* JADX INFO: renamed from: V */
    protected DMatrixRBlock f2442V = new DMatrixRBlock(1, 1);
    protected DMatrixRBlock tmp = new DMatrixRBlock(1, 1);
    protected double[] gammas = new double[1];
    protected DMatrixRMaj zerosM = new DMatrixRMaj(1, 1);

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return true;
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition
    public DMatrixRBlock getT(DMatrixRBlock dMatrixRBlock) {
        if (dMatrixRBlock == null) {
            dMatrixRBlock = new DMatrixRBlock(this.f2441A.numRows, this.f2441A.numCols, this.f2441A.blockLength);
        } else {
            if (dMatrixRBlock.numRows != this.f2441A.numRows || dMatrixRBlock.numCols != this.f2441A.numCols) {
                throw new IllegalArgumentException("T must have the same dimensions as the input matrix");
            }
            CommonOps_DDRM.fill(dMatrixRBlock, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
        dMatrixRBlock.set(0, 0, this.f2441A.data[0]);
        for (int i = 1; i < this.f2441A.numRows; i++) {
            int i2 = i - 1;
            double d = this.f2441A.get(i2, i);
            dMatrixRBlock.set(i, i, this.f2441A.get(i, i));
            dMatrixRBlock.set(i2, i, d);
            dMatrixRBlock.set(i, i2, d);
        }
        return dMatrixRBlock;
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition
    public DMatrixRBlock getQ(DMatrixRBlock dMatrixRBlock, boolean z) {
        DMatrixRBlock dMatrixRBlockInitializeQ = QRDecompositionHouseholder_DDRB.initializeQ(dMatrixRBlock, this.f2441A.numRows, this.f2441A.numCols, this.f2441A.blockLength, false);
        int iMin = Math.min(this.f2441A.blockLength, this.f2441A.numRows);
        this.f2442V.reshape(iMin, this.f2441A.numCols, false);
        this.tmp.reshape(iMin, this.f2441A.numCols, false);
        DSubmatrixD1 dSubmatrixD1 = new DSubmatrixD1(dMatrixRBlockInitializeQ);
        DSubmatrixD1 dSubmatrixD12 = new DSubmatrixD1(this.f2441A);
        DSubmatrixD1 dSubmatrixD13 = new DSubmatrixD1(this.f2442V);
        DSubmatrixD1 dSubmatrixD14 = new DSubmatrixD1(this.tmp);
        int i = this.f2441A.numRows;
        int i2 = i - (i % this.f2441A.blockLength);
        if (i2 == i) {
            i2 -= this.f2441A.blockLength;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 >= 0) {
            int iMin2 = Math.min(this.f2441A.blockLength, i - i2);
            dSubmatrixD13.col0 = i2;
            dSubmatrixD13.row1 = iMin2;
            dSubmatrixD13.original.reshape(dSubmatrixD13.row1, dSubmatrixD13.col1, false);
            if (z) {
                dSubmatrixD14.row0 = i2;
                dSubmatrixD14.row1 = this.f2441A.numCols;
                dSubmatrixD14.col0 = 0;
                dSubmatrixD14.col1 = iMin2;
            } else {
                dSubmatrixD14.col0 = i2;
                dSubmatrixD14.row1 = iMin2;
            }
            dSubmatrixD14.original.reshape(dSubmatrixD14.row1, dSubmatrixD14.col1, false);
            dSubmatrixD12.col0 = i2;
            dSubmatrixD12.row0 = i2;
            dSubmatrixD12.row1 = dSubmatrixD12.row0 + iMin2;
            copyZeros(dSubmatrixD12);
            TridiagonalHelper_DDRB.computeW_row(this.f2441A.blockLength, dSubmatrixD12, dSubmatrixD13, this.gammas, i2);
            dSubmatrixD1.col0 = i2;
            dSubmatrixD1.row0 = i2;
            if (z) {
                MatrixMult_DDRB.multTransB(this.f2441A.blockLength, dSubmatrixD1, dSubmatrixD12, dSubmatrixD14);
            } else {
                MatrixMult_DDRB.mult(this.f2441A.blockLength, dSubmatrixD12, dSubmatrixD1, dSubmatrixD14);
            }
            if (z) {
                MatrixMult_DDRB.multPlus(this.f2441A.blockLength, dSubmatrixD14, dSubmatrixD13, dSubmatrixD1);
            } else {
                MatrixMult_DDRB.multPlusTransA(this.f2441A.blockLength, dSubmatrixD13, dSubmatrixD14, dSubmatrixD1);
            }
            replaceZeros(dSubmatrixD12);
            i2 -= this.f2441A.blockLength;
        }
        return dMatrixRBlockInitializeQ;
    }

    private void copyZeros(DSubmatrixD1 dSubmatrixD1) {
        int iMin = Math.min(this.f2441A.blockLength, dSubmatrixD1.col1 - dSubmatrixD1.col0);
        for (int i = 0; i < iMin; i++) {
            for (int i2 = 0; i2 <= i; i2++) {
                this.zerosM.unsafe_set(i, i2, dSubmatrixD1.get(i, i2));
                dSubmatrixD1.set(i, i2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            }
            if (dSubmatrixD1.col0 + i + 1 < dSubmatrixD1.original.numCols) {
                int i3 = i + 1;
                this.zerosM.unsafe_set(i, i3, dSubmatrixD1.get(i, i3));
                dSubmatrixD1.set(i, i3, 1.0d);
            }
        }
    }

    private void replaceZeros(DSubmatrixD1 dSubmatrixD1) {
        int iMin = Math.min(this.f2441A.blockLength, dSubmatrixD1.col1 - dSubmatrixD1.col0);
        for (int i = 0; i < iMin; i++) {
            for (int i2 = 0; i2 <= i; i2++) {
                dSubmatrixD1.set(i, i2, this.zerosM.get(i, i2));
            }
            if (dSubmatrixD1.col0 + i + 1 < dSubmatrixD1.original.numCols) {
                int i3 = i + 1;
                dSubmatrixD1.set(i, i3, this.zerosM.get(i, i3));
            }
        }
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F64
    public void getDiagonal(double[] dArr, double[] dArr2) {
        dArr[0] = this.f2441A.data[0];
        for (int i = 1; i < this.f2441A.numRows; i++) {
            dArr[i] = this.f2441A.get(i, i);
            int i2 = i - 1;
            dArr2[i2] = this.f2441A.get(i2, i);
        }
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixRBlock dMatrixRBlock) {
        if (dMatrixRBlock.numCols != dMatrixRBlock.numRows) {
            throw new IllegalArgumentException("Input matrix must be square.");
        }
        init(dMatrixRBlock);
        DSubmatrixD1 dSubmatrixD1 = new DSubmatrixD1(this.f2441A);
        DSubmatrixD1 dSubmatrixD12 = new DSubmatrixD1(this.f2442V);
        DSubmatrixD1 dSubmatrixD13 = new DSubmatrixD1(this.f2441A);
        int i = dMatrixRBlock.numCols;
        int i2 = 0;
        while (i2 < i) {
            int iMin = Math.min(this.f2441A.blockLength, this.f2441A.numRows - i2);
            dSubmatrixD13.col0 = i2;
            dSubmatrixD1.col0 = i2;
            dSubmatrixD13.row0 = i2;
            dSubmatrixD1.row0 = i2;
            dSubmatrixD13.row1 = dSubmatrixD13.row0 + iMin;
            dSubmatrixD12.col0 = i2;
            dSubmatrixD12.row1 = iMin;
            dSubmatrixD12.original.reshape(dSubmatrixD12.row1, dSubmatrixD12.col1, false);
            TridiagonalHelper_DDRB.tridiagUpperRow(this.f2441A.blockLength, dSubmatrixD1, this.gammas, dSubmatrixD12);
            if (dSubmatrixD13.row1 < dMatrixRBlock.numCols) {
                double d = dSubmatrixD13.get(this.f2441A.blockLength - 1, this.f2441A.blockLength);
                dSubmatrixD13.set(this.f2441A.blockLength - 1, this.f2441A.blockLength, 1.0d);
                multPlusTransA(this.f2441A.blockLength, dSubmatrixD13, dSubmatrixD12, dSubmatrixD1);
                multPlusTransA(this.f2441A.blockLength, dSubmatrixD12, dSubmatrixD13, dSubmatrixD1);
                dSubmatrixD13.set(this.f2441A.blockLength - 1, this.f2441A.blockLength, d);
            }
            i2 += this.f2441A.blockLength;
        }
        return true;
    }

    public static void multPlusTransA(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, DSubmatrixD1 dSubmatrixD13) {
        int iMin = Math.min(i, dSubmatrixD1.row1 - dSubmatrixD1.row0);
        int i2 = dSubmatrixD13.row0;
        while (true) {
            i2 += i;
            if (i2 >= dSubmatrixD13.row1) {
                return;
            }
            int iMin2 = Math.min(i, dSubmatrixD13.row1 - i2);
            int i3 = (dSubmatrixD1.row0 * dSubmatrixD1.original.numCols) + (((i2 - dSubmatrixD13.row0) + dSubmatrixD1.col0) * iMin);
            int i4 = i2;
            while (i4 < dSubmatrixD13.col1) {
                int iMin3 = Math.min(i, dSubmatrixD13.col1 - i4);
                int i5 = (dSubmatrixD13.original.numCols * i2) + (i4 * iMin2);
                InnerMultiplication_DDRB.blockMultPlusTransA(dSubmatrixD1.original.data, dSubmatrixD12.original.data, dSubmatrixD13.original.data, i3, (dSubmatrixD12.row0 * dSubmatrixD12.original.numCols) + (((i4 - dSubmatrixD13.col0) + dSubmatrixD12.col0) * iMin), i5, iMin, iMin2, iMin3);
                i4 += i;
            }
        }
    }

    private void init(DMatrixRBlock dMatrixRBlock) {
        this.f2441A = dMatrixRBlock;
        int iMin = Math.min(dMatrixRBlock.blockLength, this.f2441A.numRows);
        this.f2442V.reshape(iMin, this.f2441A.numCols, this.f2441A.blockLength, false);
        this.tmp.reshape(iMin, this.f2441A.numCols, this.f2441A.blockLength, false);
        if (this.gammas.length < this.f2441A.numCols) {
            this.gammas = new double[this.f2441A.numCols];
        }
        this.zerosM.reshape(this.f2441A.blockLength, this.f2441A.blockLength + 1, false);
    }
}
