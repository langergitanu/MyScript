package org.ejml.dense.block.decomposition.chol;

import org.ejml.data.Complex_F32;
import org.ejml.data.FMatrixRBlock;
import org.ejml.data.FSubmatrixD1;
import org.ejml.dense.block.InnerRankUpdate_FDRB;
import org.ejml.dense.block.MatrixOps_FDRB;
import org.ejml.dense.block.TriangularSolver_FDRB;
import org.ejml.interfaces.decomposition.CholeskyDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class CholeskyOuterForm_FDRB implements CholeskyDecomposition_F32<FMatrixRBlock> {

    /* JADX INFO: renamed from: T */
    private FMatrixRBlock f2440T;
    private boolean lower;
    private FSubmatrixD1 subA = new FSubmatrixD1();
    private FSubmatrixD1 subB = new FSubmatrixD1();
    private FSubmatrixD1 subC = new FSubmatrixD1();
    private Complex_F32 det = new Complex_F32();

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return true;
    }

    public CholeskyOuterForm_FDRB(boolean z) {
        this.lower = false;
        this.lower = z;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(FMatrixRBlock fMatrixRBlock) {
        if (fMatrixRBlock.numCols != fMatrixRBlock.numRows) {
            throw new IllegalArgumentException("A must be square");
        }
        this.f2440T = fMatrixRBlock;
        if (this.lower) {
            return decomposeLower();
        }
        return decomposeUpper();
    }

    private boolean decomposeLower() {
        int i = this.f2440T.blockLength;
        this.subA.set(this.f2440T);
        this.subB.set(this.f2440T);
        this.subC.set(this.f2440T);
        for (int i2 = 0; i2 < this.f2440T.numCols; i2 += i) {
            int iMin = Math.min(i, this.f2440T.numCols - i2);
            this.subA.col0 = i2;
            int i3 = i2 + iMin;
            this.subA.col1 = i3;
            FSubmatrixD1 fSubmatrixD1 = this.subA;
            fSubmatrixD1.row0 = fSubmatrixD1.col0;
            FSubmatrixD1 fSubmatrixD12 = this.subA;
            fSubmatrixD12.row1 = fSubmatrixD12.col1;
            this.subB.col0 = i2;
            this.subB.col1 = i3;
            this.subB.row0 = i3;
            this.subB.row1 = this.f2440T.numRows;
            this.subC.col0 = i3;
            this.subC.col1 = this.f2440T.numRows;
            this.subC.row0 = i3;
            this.subC.row1 = this.f2440T.numRows;
            if (!InnerCholesky_FDRB.lower(this.subA)) {
                return false;
            }
            if (iMin == i) {
                TriangularSolver_FDRB.solveBlock(i, false, this.subA, this.subB, false, true);
                InnerRankUpdate_FDRB.symmRankNMinus_L(i, this.subC, this.subB);
            }
        }
        MatrixOps_FDRB.zeroTriangle(true, this.f2440T);
        return true;
    }

    private boolean decomposeUpper() {
        int i = this.f2440T.blockLength;
        this.subA.set(this.f2440T);
        this.subB.set(this.f2440T);
        this.subC.set(this.f2440T);
        for (int i2 = 0; i2 < this.f2440T.numCols; i2 += i) {
            int iMin = Math.min(i, this.f2440T.numCols - i2);
            this.subA.col0 = i2;
            int i3 = i2 + iMin;
            this.subA.col1 = i3;
            FSubmatrixD1 fSubmatrixD1 = this.subA;
            fSubmatrixD1.row0 = fSubmatrixD1.col0;
            FSubmatrixD1 fSubmatrixD12 = this.subA;
            fSubmatrixD12.row1 = fSubmatrixD12.col1;
            this.subB.col0 = i3;
            this.subB.col1 = this.f2440T.numCols;
            this.subB.row0 = i2;
            this.subB.row1 = i3;
            this.subC.col0 = i3;
            this.subC.col1 = this.f2440T.numCols;
            this.subC.row0 = i3;
            this.subC.row1 = this.f2440T.numCols;
            if (!InnerCholesky_FDRB.upper(this.subA)) {
                return false;
            }
            if (iMin == i) {
                TriangularSolver_FDRB.solveBlock(i, true, this.subA, this.subB, true, false);
                InnerRankUpdate_FDRB.symmRankNMinus_U(i, this.subC, this.subB);
            }
        }
        MatrixOps_FDRB.zeroTriangle(false, this.f2440T);
        return true;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition
    public boolean isLower() {
        return this.lower;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition
    public FMatrixRBlock getT(FMatrixRBlock fMatrixRBlock) {
        if (fMatrixRBlock == null) {
            return this.f2440T;
        }
        fMatrixRBlock.set(this.f2440T);
        return fMatrixRBlock;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition_F32
    public Complex_F32 computeDeterminant() {
        int i = this.f2440T.blockLength;
        float f = 1.0f;
        for (int i2 = 0; i2 < this.f2440T.numCols; i2 += i) {
            int iMin = Math.min(i, this.f2440T.numCols - i2);
            int i3 = (this.f2440T.numCols * i2) + (i2 * iMin);
            for (int i4 = 0; i4 < iMin; i4++) {
                f *= this.f2440T.data[i3];
                i3 += iMin + 1;
            }
        }
        this.det.real = f * f;
        this.det.imaginary = 0.0f;
        return this.det;
    }
}
