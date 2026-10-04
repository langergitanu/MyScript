package org.ejml.sparse.csc.decomposition.p053lu;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.UtilEjml;
import org.ejml.data.Complex_F64;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.data.IGrowArray;
import org.ejml.interfaces.decomposition.LUSparseDecomposition_F64;
import org.ejml.sparse.ComputePermutation;
import org.ejml.sparse.csc.CommonOps_DSCC;
import org.ejml.sparse.csc.misc.ApplyFillReductionPermutation;
import org.ejml.sparse.csc.misc.TriangularSolver_DSCC;

/* JADX INFO: loaded from: classes9.dex */
public class LuUpLooking_DSCC implements LUSparseDecomposition_F64<DMatrixSparseCSC> {
    private ApplyFillReductionPermutation applyReduce;
    private boolean singular;

    /* JADX INFO: renamed from: L */
    private DMatrixSparseCSC f2766L = new DMatrixSparseCSC(0, 0, 0);

    /* JADX INFO: renamed from: U */
    private DMatrixSparseCSC f2767U = new DMatrixSparseCSC(0, 0, 0);
    private int[] pinv = new int[0];

    /* JADX INFO: renamed from: x */
    private double[] f2769x = new double[0];
    private IGrowArray gxi = new IGrowArray();

    /* JADX INFO: renamed from: gw */
    private IGrowArray f2768gw = new IGrowArray();

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionSparseInterface
    public boolean isStructureLocked() {
        return false;
    }

    public LuUpLooking_DSCC(ComputePermutation<DMatrixSparseCSC> computePermutation) {
        this.applyReduce = new ApplyFillReductionPermutation(computePermutation, false);
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixSparseCSC dMatrixSparseCSC) {
        initialize(dMatrixSparseCSC);
        return performLU(this.applyReduce.apply(dMatrixSparseCSC));
    }

    private void initialize(DMatrixSparseCSC dMatrixSparseCSC) {
        int i = dMatrixSparseCSC.numRows;
        int i2 = dMatrixSparseCSC.numCols;
        int iMin = Math.min(i, i2);
        this.f2766L.reshape(i, i, (dMatrixSparseCSC.nz_length * 4) + iMin);
        this.f2766L.nz_length = 0;
        this.f2767U.reshape(i, i2, (dMatrixSparseCSC.nz_length * 4) + iMin);
        this.f2767U.nz_length = 0;
        this.singular = false;
        if (this.pinv.length != i) {
            this.pinv = new int[i];
            this.f2769x = new double[i];
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.pinv[i3] = -1;
            this.f2766L.col_idx[i3] = 0;
        }
    }

    private boolean performLU(DMatrixSparseCSC dMatrixSparseCSC) {
        DMatrixSparseCSC dMatrixSparseCSC2 = dMatrixSparseCSC;
        int i = dMatrixSparseCSC2.numRows;
        int i2 = dMatrixSparseCSC2.numCols;
        int[] arrayP = this.applyReduce.getArrayP();
        int i3 = 0;
        while (i3 < i2) {
            this.f2766L.col_idx[i3] = this.f2766L.nz_length;
            this.f2767U.col_idx[i3] = this.f2767U.nz_length;
            if (this.f2766L.nz_length + i2 > this.f2766L.nz_values.length) {
                DMatrixSparseCSC dMatrixSparseCSC3 = this.f2766L;
                dMatrixSparseCSC3.growMaxLength((dMatrixSparseCSC3.nz_values.length * 2) + i2, true);
            }
            if (this.f2767U.nz_length + i2 > this.f2767U.nz_values.length) {
                DMatrixSparseCSC dMatrixSparseCSC4 = this.f2767U;
                dMatrixSparseCSC4.growMaxLength((dMatrixSparseCSC4.nz_values.length * 2) + i2, true);
            }
            int iSolve = TriangularSolver_DSCC.solve(this.f2766L, true, dMatrixSparseCSC2, arrayP != null ? arrayP[i3] : i3, this.f2769x, this.pinv, this.gxi, this.f2768gw);
            int[] iArr = this.gxi.data;
            double d = -1.7976931348623157E308d;
            int i4 = -1;
            for (int i5 = iSolve; i5 < i2; i5++) {
                int i6 = iArr[i5];
                if (this.pinv[i6] < 0) {
                    double dAbs = Math.abs(this.f2769x[i6]);
                    if (dAbs > d) {
                        i4 = i6;
                        d = dAbs;
                    }
                } else {
                    this.f2767U.nz_rows[this.f2767U.nz_length] = this.pinv[i6];
                    double[] dArr = this.f2767U.nz_values;
                    DMatrixSparseCSC dMatrixSparseCSC5 = this.f2767U;
                    int i7 = dMatrixSparseCSC5.nz_length;
                    dMatrixSparseCSC5.nz_length = i7 + 1;
                    dArr[i7] = this.f2769x[i6];
                }
            }
            if (i4 == -1 || d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                this.singular = true;
                return false;
            }
            double d2 = this.f2769x[i4];
            this.f2767U.nz_rows[this.f2767U.nz_length] = i3;
            double[] dArr2 = this.f2767U.nz_values;
            DMatrixSparseCSC dMatrixSparseCSC6 = this.f2767U;
            int i8 = dMatrixSparseCSC6.nz_length;
            dMatrixSparseCSC6.nz_length = i8 + 1;
            dArr2[i8] = d2;
            this.pinv[i4] = i3;
            this.f2766L.nz_rows[this.f2766L.nz_length] = i4;
            double[] dArr3 = this.f2766L.nz_values;
            DMatrixSparseCSC dMatrixSparseCSC7 = this.f2766L;
            int i9 = dMatrixSparseCSC7.nz_length;
            dMatrixSparseCSC7.nz_length = i9 + 1;
            dArr3[i9] = 1.0d;
            while (iSolve < i2) {
                int i10 = iArr[iSolve];
                if (this.pinv[i10] < 0) {
                    this.f2766L.nz_rows[this.f2766L.nz_length] = i10;
                    double[] dArr4 = this.f2766L.nz_values;
                    DMatrixSparseCSC dMatrixSparseCSC8 = this.f2766L;
                    int i11 = dMatrixSparseCSC8.nz_length;
                    dMatrixSparseCSC8.nz_length = i11 + 1;
                    dArr4[i11] = this.f2769x[i10] / d2;
                }
                this.f2769x[i10] = 0.0d;
                iSolve++;
            }
            i3++;
            dMatrixSparseCSC2 = dMatrixSparseCSC;
        }
        this.f2766L.col_idx[i2] = this.f2766L.nz_length;
        this.f2767U.col_idx[i2] = this.f2767U.nz_length;
        for (int i12 = 0; i12 < this.f2766L.nz_length; i12++) {
            this.f2766L.nz_rows[i12] = this.pinv[this.f2766L.nz_rows[i12]];
        }
        return true;
    }

    @Override // org.ejml.interfaces.decomposition.LUSparseDecomposition_F64
    public Complex_F64 computeDeterminant() {
        double dPermutationSign = UtilEjml.permutationSign(this.pinv, this.f2767U.numCols, this.f2768gw.data);
        int i = 0;
        while (i < this.f2767U.numCols) {
            i++;
            dPermutationSign *= this.f2767U.nz_values[this.f2767U.col_idx[i] - 1];
        }
        return new Complex_F64(dPermutationSign, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public DMatrixSparseCSC getLower(DMatrixSparseCSC dMatrixSparseCSC) {
        if (dMatrixSparseCSC == null) {
            dMatrixSparseCSC = new DMatrixSparseCSC(1, 1, 0);
        }
        dMatrixSparseCSC.set(this.f2766L);
        return dMatrixSparseCSC;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public DMatrixSparseCSC getUpper(DMatrixSparseCSC dMatrixSparseCSC) {
        if (dMatrixSparseCSC == null) {
            dMatrixSparseCSC = new DMatrixSparseCSC(1, 1, 0);
        }
        dMatrixSparseCSC.set(this.f2767U);
        return dMatrixSparseCSC;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public DMatrixSparseCSC getRowPivot(DMatrixSparseCSC dMatrixSparseCSC) {
        if (dMatrixSparseCSC == null) {
            dMatrixSparseCSC = new DMatrixSparseCSC(this.f2766L.numRows, this.f2766L.numRows, 0);
        }
        dMatrixSparseCSC.reshape(this.f2766L.numRows, this.f2766L.numRows, this.f2766L.numRows);
        CommonOps_DSCC.permutationMatrix(this.pinv, true, this.f2766L.numRows, dMatrixSparseCSC);
        return dMatrixSparseCSC;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public int[] getRowPivotV(IGrowArray iGrowArray) {
        return UtilEjml.pivotVector(this.pinv, this.f2766L.numRows, iGrowArray);
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public boolean isSingular() {
        return this.singular;
    }

    public int[] getPinv() {
        return this.pinv;
    }

    public DMatrixSparseCSC getL() {
        return this.f2766L;
    }

    public DMatrixSparseCSC getU() {
        return this.f2767U;
    }

    public ComputePermutation<DMatrixSparseCSC> getReduceFill() {
        return this.applyReduce.getFillReduce();
    }

    public int[] getReducePermutation() {
        return this.applyReduce.getArrayP();
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionSparseInterface
    public void lockStructure() {
        throw new RuntimeException("Can't lock a LU decomposition. Pivots change depending on numerical values and not justthe matrix's structure");
    }
}
