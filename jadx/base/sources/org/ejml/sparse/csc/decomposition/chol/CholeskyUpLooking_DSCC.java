package org.ejml.sparse.csc.decomposition.chol;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.Complex_F64;
import org.ejml.data.DGrowArray;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.data.IGrowArray;
import org.ejml.interfaces.decomposition.CholeskySparseDecomposition_F64;
import org.ejml.sparse.csc.misc.ColumnCounts_DSCC;
import org.ejml.sparse.csc.misc.TriangularSolver_DSCC;

/* JADX INFO: loaded from: classes9.dex */
public class CholeskyUpLooking_DSCC implements CholeskySparseDecomposition_F64<DMatrixSparseCSC> {

    /* JADX INFO: renamed from: N */
    private int f2762N;

    /* JADX INFO: renamed from: L */
    DMatrixSparseCSC f2761L = new DMatrixSparseCSC(1, 1, 0);

    /* JADX INFO: renamed from: gw */
    IGrowArray f2764gw = new IGrowArray(1);

    /* JADX INFO: renamed from: gs */
    IGrowArray f2763gs = new IGrowArray(1);

    /* JADX INFO: renamed from: gx */
    DGrowArray f2765gx = new DGrowArray(1);
    int[] parent = new int[1];
    int[] post = new int[1];
    int[] counts = new int[1];
    ColumnCounts_DSCC columnCounter = new ColumnCounts_DSCC(false);
    private boolean decomposed = false;
    private boolean locked = false;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition
    public boolean isLower() {
        return true;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixSparseCSC dMatrixSparseCSC) {
        if (dMatrixSparseCSC.numCols != dMatrixSparseCSC.numRows) {
            throw new IllegalArgumentException("Must be a square matrix");
        }
        if (!this.locked || !this.decomposed) {
            performSymbolic(dMatrixSparseCSC);
        }
        if (!performDecomposition(dMatrixSparseCSC)) {
            return false;
        }
        this.decomposed = true;
        return true;
    }

    public void performSymbolic(DMatrixSparseCSC dMatrixSparseCSC) {
        init(dMatrixSparseCSC.numCols);
        TriangularSolver_DSCC.eliminationTree(dMatrixSparseCSC, false, this.parent, this.f2764gw);
        TriangularSolver_DSCC.postorder(this.parent, this.f2762N, this.post, this.f2764gw);
        this.columnCounter.process(dMatrixSparseCSC, this.parent, this.post, this.counts);
        this.f2761L.reshape(dMatrixSparseCSC.numRows, dMatrixSparseCSC.numCols, 0);
        this.f2761L.colsum(this.counts);
    }

    private void init(int i) {
        this.f2762N = i;
        if (this.parent.length < i) {
            this.parent = new int[i];
            this.post = new int[i];
            this.counts = new int[i];
            this.f2764gw.reshape(i * 3);
        }
    }

    private boolean performDecomposition(DMatrixSparseCSC dMatrixSparseCSC) {
        int i;
        int[] iArrAdjust = TriangularSolver_DSCC.adjust(this.f2764gw, this.f2762N);
        int[] iArrAdjust2 = TriangularSolver_DSCC.adjust(this.f2763gs, this.f2762N);
        double[] dArrAdjust = TriangularSolver_DSCC.adjust(this.f2765gx, this.f2762N);
        boolean z = false;
        System.arraycopy(this.f2761L.col_idx, 0, iArrAdjust, 0, this.f2762N);
        int i2 = 0;
        while (i2 < this.f2762N) {
            int iSearchNzRowsElim = TriangularSolver_DSCC.searchNzRowsElim(dMatrixSparseCSC, i2, this.parent, iArrAdjust2, iArrAdjust);
            double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            dArrAdjust[i2] = 0.0d;
            int i3 = i2 + 1;
            int i4 = dMatrixSparseCSC.col_idx[i3];
            for (int i5 = dMatrixSparseCSC.col_idx[i2]; i5 < i4; i5++) {
                if (dMatrixSparseCSC.nz_rows[i5] <= i2) {
                    dArrAdjust[dMatrixSparseCSC.nz_rows[i5]] = dMatrixSparseCSC.nz_values[i5];
                }
            }
            double d2 = dArrAdjust[i2];
            dArrAdjust[i2] = 0.0d;
            while (iSearchNzRowsElim < this.f2762N) {
                int i6 = iArrAdjust2[iSearchNzRowsElim];
                boolean z2 = z;
                double d3 = dArrAdjust[i6] / this.f2761L.nz_values[this.f2761L.col_idx[i6]];
                dArrAdjust[i6] = d;
                int i7 = this.f2761L.col_idx[i6] + 1;
                while (true) {
                    i = iArrAdjust[i6];
                    if (i7 < i) {
                        int i8 = this.f2761L.nz_rows[i7];
                        dArrAdjust[i8] = dArrAdjust[i8] - (this.f2761L.nz_values[i7] * d3);
                        i7++;
                        d = d;
                    }
                }
                d2 -= d3 * d3;
                iArrAdjust[i6] = i + 1;
                this.f2761L.nz_rows[i] = i2;
                this.f2761L.nz_values[i] = d3;
                iSearchNzRowsElim++;
                z = z2;
                d = d;
            }
            boolean z3 = z;
            if (d2 <= d) {
                return z3;
            }
            int i9 = iArrAdjust[i2];
            iArrAdjust[i2] = i9 + 1;
            this.f2761L.nz_rows[i9] = i2;
            this.f2761L.nz_values[i9] = Math.sqrt(d2);
            i2 = i3;
            z = z3;
        }
        return true;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition
    public DMatrixSparseCSC getT(DMatrixSparseCSC dMatrixSparseCSC) {
        if (dMatrixSparseCSC == null) {
            dMatrixSparseCSC = new DMatrixSparseCSC(this.f2761L.numRows, this.f2761L.numCols, this.f2761L.nz_length);
        }
        dMatrixSparseCSC.set(this.f2761L);
        return dMatrixSparseCSC;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskySparseDecomposition_F64
    public Complex_F64 computeDeterminant() {
        double d = 1.0d;
        for (int i = 0; i < this.f2762N; i++) {
            d *= this.f2761L.nz_values[this.f2761L.col_idx[i]];
        }
        return new Complex_F64(d * d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public DGrowArray getGx() {
        return this.f2765gx;
    }

    public DMatrixSparseCSC getL() {
        return this.f2761L;
    }

    public IGrowArray getGw() {
        return this.f2764gw;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionSparseInterface
    public void lockStructure() {
        if (this.locked) {
            return;
        }
        this.locked = true;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionSparseInterface
    public boolean isStructureLocked() {
        return this.locked;
    }
}
