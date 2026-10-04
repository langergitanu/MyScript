package org.ejml.dense.block.decomposition.chol;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.Complex_F64;
import org.ejml.data.DMatrixRBlock;
import org.ejml.data.DSubmatrixD1;
import org.ejml.dense.block.InnerRankUpdate_DDRB;
import org.ejml.dense.block.MatrixOps_DDRB;
import org.ejml.dense.block.TriangularSolver_DDRB;
import org.ejml.interfaces.decomposition.CholeskyDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class CholeskyOuterForm_DDRB implements CholeskyDecomposition_F64<DMatrixRBlock> {

    /* JADX INFO: renamed from: T */
    private DMatrixRBlock f2439T;
    private boolean lower;
    private DSubmatrixD1 subA = new DSubmatrixD1();
    private DSubmatrixD1 subB = new DSubmatrixD1();
    private DSubmatrixD1 subC = new DSubmatrixD1();
    private Complex_F64 det = new Complex_F64();

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return true;
    }

    public CholeskyOuterForm_DDRB(boolean z) {
        this.lower = false;
        this.lower = z;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixRBlock dMatrixRBlock) {
        if (dMatrixRBlock.numCols != dMatrixRBlock.numRows) {
            throw new IllegalArgumentException("A must be square");
        }
        this.f2439T = dMatrixRBlock;
        if (this.lower) {
            return decomposeLower();
        }
        return decomposeUpper();
    }

    private boolean decomposeLower() {
        int i = this.f2439T.blockLength;
        this.subA.set(this.f2439T);
        this.subB.set(this.f2439T);
        this.subC.set(this.f2439T);
        for (int i2 = 0; i2 < this.f2439T.numCols; i2 += i) {
            int iMin = Math.min(i, this.f2439T.numCols - i2);
            this.subA.col0 = i2;
            int i3 = i2 + iMin;
            this.subA.col1 = i3;
            DSubmatrixD1 dSubmatrixD1 = this.subA;
            dSubmatrixD1.row0 = dSubmatrixD1.col0;
            DSubmatrixD1 dSubmatrixD12 = this.subA;
            dSubmatrixD12.row1 = dSubmatrixD12.col1;
            this.subB.col0 = i2;
            this.subB.col1 = i3;
            this.subB.row0 = i3;
            this.subB.row1 = this.f2439T.numRows;
            this.subC.col0 = i3;
            this.subC.col1 = this.f2439T.numRows;
            this.subC.row0 = i3;
            this.subC.row1 = this.f2439T.numRows;
            if (!InnerCholesky_DDRB.lower(this.subA)) {
                return false;
            }
            if (iMin == i) {
                TriangularSolver_DDRB.solveBlock(i, false, this.subA, this.subB, false, true);
                InnerRankUpdate_DDRB.symmRankNMinus_L(i, this.subC, this.subB);
            }
        }
        MatrixOps_DDRB.zeroTriangle(true, this.f2439T);
        return true;
    }

    private boolean decomposeUpper() {
        int i = this.f2439T.blockLength;
        this.subA.set(this.f2439T);
        this.subB.set(this.f2439T);
        this.subC.set(this.f2439T);
        for (int i2 = 0; i2 < this.f2439T.numCols; i2 += i) {
            int iMin = Math.min(i, this.f2439T.numCols - i2);
            this.subA.col0 = i2;
            int i3 = i2 + iMin;
            this.subA.col1 = i3;
            DSubmatrixD1 dSubmatrixD1 = this.subA;
            dSubmatrixD1.row0 = dSubmatrixD1.col0;
            DSubmatrixD1 dSubmatrixD12 = this.subA;
            dSubmatrixD12.row1 = dSubmatrixD12.col1;
            this.subB.col0 = i3;
            this.subB.col1 = this.f2439T.numCols;
            this.subB.row0 = i2;
            this.subB.row1 = i3;
            this.subC.col0 = i3;
            this.subC.col1 = this.f2439T.numCols;
            this.subC.row0 = i3;
            this.subC.row1 = this.f2439T.numCols;
            if (!InnerCholesky_DDRB.upper(this.subA)) {
                return false;
            }
            if (iMin == i) {
                TriangularSolver_DDRB.solveBlock(i, true, this.subA, this.subB, true, false);
                InnerRankUpdate_DDRB.symmRankNMinus_U(i, this.subC, this.subB);
            }
        }
        MatrixOps_DDRB.zeroTriangle(false, this.f2439T);
        return true;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition
    public boolean isLower() {
        return this.lower;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition
    public DMatrixRBlock getT(DMatrixRBlock dMatrixRBlock) {
        if (dMatrixRBlock == null) {
            return this.f2439T;
        }
        dMatrixRBlock.set(this.f2439T);
        return dMatrixRBlock;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition_F64
    public Complex_F64 computeDeterminant() {
        int i = this.f2439T.blockLength;
        double d = 1.0d;
        for (int i2 = 0; i2 < this.f2439T.numCols; i2 += i) {
            int iMin = Math.min(i, this.f2439T.numCols - i2);
            int i3 = (this.f2439T.numCols * i2) + (i2 * iMin);
            for (int i4 = 0; i4 < iMin; i4++) {
                d *= this.f2439T.data[i3];
                i3 += iMin + 1;
            }
        }
        this.det.real = d * d;
        this.det.imaginary = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        return this.det;
    }
}
