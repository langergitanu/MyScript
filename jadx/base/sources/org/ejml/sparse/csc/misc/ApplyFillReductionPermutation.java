package org.ejml.sparse.csc.misc;

import org.ejml.data.DMatrixSparseCSC;
import org.ejml.data.IGrowArray;
import org.ejml.sparse.ComputePermutation;
import org.ejml.sparse.csc.CommonOps_DSCC;

/* JADX INFO: loaded from: classes9.dex */
public class ApplyFillReductionPermutation {
    private ComputePermutation<DMatrixSparseCSC> fillReduce;
    boolean symmetric;
    DMatrixSparseCSC Aperm = new DMatrixSparseCSC(1, 1, 0);
    int[] pinv = new int[1];

    /* JADX INFO: renamed from: gw */
    IGrowArray f2790gw = new IGrowArray();

    public ApplyFillReductionPermutation(ComputePermutation<DMatrixSparseCSC> computePermutation, boolean z) {
        this.fillReduce = computePermutation;
        this.symmetric = z;
    }

    public DMatrixSparseCSC apply(DMatrixSparseCSC dMatrixSparseCSC) {
        ComputePermutation<DMatrixSparseCSC> computePermutation = this.fillReduce;
        if (computePermutation == null) {
            return dMatrixSparseCSC;
        }
        computePermutation.process(dMatrixSparseCSC);
        IGrowArray row = this.fillReduce.getRow();
        if (this.pinv.length < row.length) {
            this.pinv = new int[row.length];
        }
        CommonOps_DSCC.permutationInverse(row.data, this.pinv, row.length);
        if (this.symmetric) {
            CommonOps_DSCC.permuteSymmetric(dMatrixSparseCSC, this.pinv, this.Aperm, this.f2790gw);
        } else {
            CommonOps_DSCC.permuteRowInv(this.pinv, dMatrixSparseCSC, this.Aperm);
        }
        return this.Aperm;
    }

    public int[] getArrayPinv() {
        if (this.fillReduce == null) {
            return null;
        }
        return this.pinv;
    }

    public int[] getArrayP() {
        ComputePermutation<DMatrixSparseCSC> computePermutation = this.fillReduce;
        if (computePermutation == null) {
            return null;
        }
        return computePermutation.getRow().data;
    }

    public int[] getArrayQ() {
        ComputePermutation<DMatrixSparseCSC> computePermutation = this.fillReduce;
        if (computePermutation == null) {
            return null;
        }
        return computePermutation.getColumn().data;
    }

    public IGrowArray getGw() {
        return this.f2790gw;
    }

    public void setGw(IGrowArray iGrowArray) {
        this.f2790gw = iGrowArray;
    }

    public ComputePermutation<DMatrixSparseCSC> getFillReduce() {
        return this.fillReduce;
    }

    public boolean isApplied() {
        return this.fillReduce != null;
    }
}
