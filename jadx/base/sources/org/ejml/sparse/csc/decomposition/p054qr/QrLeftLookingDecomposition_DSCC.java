package org.ejml.sparse.csc.decomposition.p054qr;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import org.ejml.data.DGrowArray;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.data.DScalar;
import org.ejml.data.IGrowArray;
import org.ejml.dense.row.decomposition.p050qr.QrHelperFunctions_DDRM;
import org.ejml.interfaces.decomposition.QRSparseDecomposition;
import org.ejml.sparse.ComputePermutation;
import org.ejml.sparse.csc.CommonOps_DSCC;
import org.ejml.sparse.csc.misc.ApplyFillReductionPermutation;
import org.ejml.sparse.csc.mult.ImplSparseSparseMult_DSCC;

/* JADX INFO: loaded from: classes9.dex */
public class QrLeftLookingDecomposition_DSCC implements QRSparseDecomposition<DMatrixSparseCSC> {
    ApplyFillReductionPermutation applyReduce;

    /* JADX INFO: renamed from: m */
    int f2773m;

    /* JADX INFO: renamed from: m2 */
    int f2774m2;

    /* JADX INFO: renamed from: n */
    int f2775n;
    boolean singular;

    /* JADX INFO: renamed from: V */
    DMatrixSparseCSC f2771V = new DMatrixSparseCSC(1, 1, 0);

    /* JADX INFO: renamed from: R */
    DMatrixSparseCSC f2770R = new DMatrixSparseCSC(1, 1, 0);
    double[] beta = new double[0];
    DScalar Beta = new DScalar();

    /* JADX INFO: renamed from: x */
    double[] f2776x = new double[0];
    QrStructuralCounts_DSCC structure = new QrStructuralCounts_DSCC();
    int[] structureP = new int[0];
    IGrowArray gwork = new IGrowArray();

    /* JADX INFO: renamed from: gx */
    DGrowArray f2772gx = new DGrowArray();
    private boolean decomposed = false;
    private boolean locked = false;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    public QrLeftLookingDecomposition_DSCC(ComputePermutation<DMatrixSparseCSC> computePermutation) {
        this.applyReduce = new ApplyFillReductionPermutation(computePermutation, false);
        this.structure.setGwork(this.gwork);
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixSparseCSC dMatrixSparseCSC) {
        DMatrixSparseCSC dMatrixSparseCSCApply = this.applyReduce.apply(dMatrixSparseCSC);
        if (!this.decomposed || !this.locked) {
            if (!this.structure.process(dMatrixSparseCSCApply)) {
                return false;
            }
            initializeDecomposition(dMatrixSparseCSCApply);
        }
        performDecomposition(dMatrixSparseCSCApply);
        this.decomposed = true;
        return true;
    }

    private void performDecomposition(DMatrixSparseCSC dMatrixSparseCSC) {
        DMatrixSparseCSC dMatrixSparseCSC2 = dMatrixSparseCSC;
        int[] iArr = this.gwork.data;
        int[] arrayQ = this.applyReduce.getArrayQ();
        int[] parent = this.structure.getParent();
        int[] leftMost = this.structure.getLeftMost();
        int[] pinv = this.structure.getPinv();
        int i = this.f2774m2;
        Arrays.fill(iArr, 0, i, -1);
        double[] dArr = this.f2776x;
        int i2 = this.f2774m2;
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        Arrays.fill(dArr, 0, i2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        this.f2770R.nz_length = 0;
        this.f2771V.nz_length = 0;
        int i3 = 0;
        while (i3 < this.f2775n) {
            this.f2770R.col_idx[i3] = this.f2770R.nz_length;
            int[] iArr2 = this.f2771V.col_idx;
            int i4 = this.f2771V.nz_length;
            iArr2[i3] = i4;
            iArr[i3] = i3;
            int[] iArr3 = this.f2771V.nz_rows;
            DMatrixSparseCSC dMatrixSparseCSC3 = this.f2771V;
            int i5 = dMatrixSparseCSC3.nz_length;
            dMatrixSparseCSC3.nz_length = i5 + 1;
            iArr3[i5] = i3;
            int i6 = this.f2775n;
            int i7 = arrayQ != null ? arrayQ[i3] : i3;
            int i8 = dMatrixSparseCSC2.col_idx[i7];
            double d2 = d;
            int i9 = dMatrixSparseCSC2.col_idx[i7 + 1];
            while (i8 < i9) {
                int i10 = leftMost[dMatrixSparseCSC2.nz_rows[i8]];
                int i11 = 0;
                while (iArr[i10] != i3) {
                    iArr[i11 + i] = i10;
                    iArr[i10] = i3;
                    i10 = parent[i10];
                    i11++;
                }
                while (i11 > 0) {
                    i6--;
                    i11--;
                    iArr[i + i6] = iArr[i + i11];
                }
                int i12 = pinv[dMatrixSparseCSC2.nz_rows[i8]];
                this.f2776x[i12] = dMatrixSparseCSC2.nz_values[i8];
                if (i12 > i3 && iArr[i12] < i3) {
                    int[] iArr4 = this.f2771V.nz_rows;
                    DMatrixSparseCSC dMatrixSparseCSC4 = this.f2771V;
                    int i13 = dMatrixSparseCSC4.nz_length;
                    dMatrixSparseCSC4.nz_length = i13 + 1;
                    iArr4[i13] = i12;
                    iArr[i12] = i3;
                }
                i8++;
                dMatrixSparseCSC2 = dMatrixSparseCSC;
            }
            while (i6 < this.f2775n) {
                int i14 = iArr[i + i6];
                QrHelperFunctions_DSCC.applyHouseholder(this.f2771V, i14, this.beta[i14], this.f2776x);
                this.f2770R.nz_rows[this.f2770R.nz_length] = i14;
                double[] dArr2 = this.f2770R.nz_values;
                DMatrixSparseCSC dMatrixSparseCSC5 = this.f2770R;
                int i15 = dMatrixSparseCSC5.nz_length;
                dMatrixSparseCSC5.nz_length = i15 + 1;
                double[] dArr3 = this.f2776x;
                dArr2[i15] = dArr3[i14];
                dArr3[i14] = d2;
                if (parent[i14] == i3) {
                    DMatrixSparseCSC dMatrixSparseCSC6 = this.f2771V;
                    ImplSparseSparseMult_DSCC.addRowsInAInToC(dMatrixSparseCSC6, i14, dMatrixSparseCSC6, i3, iArr);
                }
                i6++;
            }
            for (int i16 = i4; i16 < this.f2771V.nz_length; i16++) {
                this.f2771V.nz_values[i16] = this.f2776x[this.f2771V.nz_rows[i16]];
                this.f2776x[this.f2771V.nz_rows[i16]] = d2;
            }
            this.f2770R.nz_rows[this.f2770R.nz_length] = i3;
            double dFindMax = QrHelperFunctions_DDRM.findMax(this.f2771V.nz_values, i4, this.f2771V.nz_length - i4);
            if (dFindMax == d2) {
                this.singular = true;
                this.f2770R.nz_values[this.f2770R.nz_length] = d2;
                this.beta[i3] = d2;
            } else {
                this.f2770R.nz_values[this.f2770R.nz_length] = QrHelperFunctions_DSCC.computeHouseholder(this.f2771V.nz_values, i4, this.f2771V.nz_length, dFindMax, this.Beta);
                this.beta[i3] = this.Beta.value;
            }
            this.f2770R.nz_length++;
            i3++;
            dMatrixSparseCSC2 = dMatrixSparseCSC;
            d = d2;
        }
        this.f2770R.col_idx[this.f2775n] = this.f2770R.nz_length;
        this.f2771V.col_idx[this.f2775n] = this.f2771V.nz_length;
    }

    private void initializeDecomposition(DMatrixSparseCSC dMatrixSparseCSC) {
        this.singular = false;
        this.f2774m2 = this.structure.getFicticousRowCount();
        this.f2773m = dMatrixSparseCSC.numRows;
        int i = dMatrixSparseCSC.numCols;
        this.f2775n = i;
        if (this.beta.length < i) {
            this.beta = new double[i];
        }
        int length = this.f2776x.length;
        int i2 = this.f2774m2;
        if (length < i2) {
            this.f2776x = new double[i2];
            this.structureP = new int[i2];
        }
        this.f2771V.reshape(i2, i, this.structure.nz_in_V);
        this.f2770R.reshape(this.f2774m2, this.f2775n, this.structure.nz_in_R);
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public DMatrixSparseCSC getQ(DMatrixSparseCSC dMatrixSparseCSC, boolean z) {
        if (dMatrixSparseCSC == null) {
            dMatrixSparseCSC = new DMatrixSparseCSC(1, 1, 0);
        }
        DMatrixSparseCSC dMatrixSparseCSC2 = dMatrixSparseCSC;
        if (z) {
            dMatrixSparseCSC2.reshape(this.f2771V.numRows, this.f2775n, 0);
        } else {
            dMatrixSparseCSC2.reshape(this.f2771V.numRows, this.f2773m, 0);
        }
        DMatrixSparseCSC dMatrixSparseCSCIdentity = CommonOps_DSCC.identity(this.f2771V.numRows, dMatrixSparseCSC2.numCols);
        for (int i = this.f2771V.numCols - 1; i >= 0; i--) {
            QrHelperFunctions_DSCC.rank1UpdateMultR(this.f2771V, i, this.beta[i], dMatrixSparseCSCIdentity, dMatrixSparseCSC2, this.gwork, this.f2772gx);
            dMatrixSparseCSCIdentity.set(dMatrixSparseCSC2);
        }
        CommonOps_DSCC.permutationInverse(this.structure.pinv, this.structureP, this.f2771V.numRows);
        CommonOps_DSCC.permuteRowInv(this.structureP, dMatrixSparseCSC2, dMatrixSparseCSCIdentity);
        int i2 = this.f2771V.numRows;
        int i3 = this.f2773m;
        if (i2 > i3) {
            CommonOps_DSCC.extractRows(dMatrixSparseCSCIdentity, 0, i3, dMatrixSparseCSC2);
            return dMatrixSparseCSC2;
        }
        dMatrixSparseCSC2.set(dMatrixSparseCSCIdentity);
        return dMatrixSparseCSC2;
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public DMatrixSparseCSC getR(DMatrixSparseCSC dMatrixSparseCSC, boolean z) {
        if (dMatrixSparseCSC == null) {
            dMatrixSparseCSC = new DMatrixSparseCSC(0, 0, 0);
        }
        dMatrixSparseCSC.set(this.f2770R);
        int i = this.f2773m;
        int i2 = this.f2775n;
        if (i > i2) {
            if (z) {
                i = i2;
            }
            dMatrixSparseCSC.numRows = i;
            return dMatrixSparseCSC;
        }
        if (i2 > i && this.f2771V.numRows != this.f2773m) {
            DMatrixSparseCSC dMatrixSparseCSC2 = new DMatrixSparseCSC(this.f2773m, this.f2775n, 0);
            CommonOps_DSCC.extractRows(dMatrixSparseCSC, 0, this.f2773m, dMatrixSparseCSC2);
            dMatrixSparseCSC.set(dMatrixSparseCSC2);
        }
        return dMatrixSparseCSC;
    }

    public QrStructuralCounts_DSCC getStructure() {
        return this.structure;
    }

    public DMatrixSparseCSC getV() {
        return this.f2771V;
    }

    public DMatrixSparseCSC getR() {
        return this.f2770R;
    }

    public double[] getBeta() {
        return this.beta;
    }

    public double getBeta(int i) {
        if (i >= this.f2775n) {
            throw new IllegalArgumentException("index is out of bounds");
        }
        return this.beta[i];
    }

    public int[] getFillPermutation() {
        return this.applyReduce.getArrayP();
    }

    public boolean isFillPermutated() {
        return this.applyReduce.isApplied();
    }

    public boolean isSingular() {
        return this.singular;
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
