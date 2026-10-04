package org.ejml.dense.row.decomposition.bidiagonal;

import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.dense.row.factory.DecompositionFactory_DDRM;
import org.ejml.interfaces.decomposition.BidiagonalDecomposition_F64;
import org.ejml.interfaces.decomposition.QRPDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class BidiagonalDecompositionTall_DDRM implements BidiagonalDecomposition_F64<DMatrixRMaj> {

    /* JADX INFO: renamed from: m */
    int f2508m;
    int min;

    /* JADX INFO: renamed from: n */
    int f2509n;
    QRPDecomposition_F64<DMatrixRMaj> decompQRP = DecompositionFactory_DDRM.qrp(500, 100);
    BidiagonalDecomposition_F64<DMatrixRMaj> decompBi = new BidiagonalDecompositionRow_DDRM();

    /* JADX INFO: renamed from: B */
    DMatrixRMaj f2507B = new DMatrixRMaj(1, 1);

    @Override // org.ejml.interfaces.decomposition.BidiagonalDecomposition_F64
    public void getDiagonal(double[] dArr, double[] dArr2) {
        dArr[0] = this.f2507B.get(0);
        for (int i = 1; i < this.f2509n; i++) {
            dArr[i] = this.f2507B.unsafe_get(i, i);
            int i2 = i - 1;
            dArr2[i2] = this.f2507B.unsafe_get(i2, i);
        }
    }

    @Override // org.ejml.interfaces.decomposition.BidiagonalDecomposition
    public DMatrixRMaj getB(DMatrixRMaj dMatrixRMaj, boolean z) {
        int i;
        DMatrixRMaj dMatrixRMajHandleB = BidiagonalDecompositionRow_DDRM.handleB(dMatrixRMaj, z, this.f2508m, this.f2509n, this.min);
        dMatrixRMajHandleB.set(0, 0, this.f2507B.get(0, 0));
        int i2 = 1;
        while (true) {
            i = this.min;
            if (i2 >= i) {
                break;
            }
            dMatrixRMajHandleB.set(i2, i2, this.f2507B.get(i2, i2));
            int i3 = i2 - 1;
            dMatrixRMajHandleB.set(i3, i2, this.f2507B.get(i3, i2));
            i2++;
        }
        if (this.f2509n > this.f2508m) {
            dMatrixRMajHandleB.set(i - 1, i, this.f2507B.get(i - 1, i));
        }
        return dMatrixRMajHandleB;
    }

    @Override // org.ejml.interfaces.decomposition.BidiagonalDecomposition
    public DMatrixRMaj getU(DMatrixRMaj dMatrixRMaj, boolean z, boolean z2) {
        DMatrixRMaj dMatrixRMajHandleU = BidiagonalDecompositionRow_DDRM.handleU(dMatrixRMaj, false, z2, this.f2508m, this.f2509n, this.min);
        if (z2) {
            CommonOps_DDRM.mult(this.decompQRP.getQ(null, true), this.decompBi.getU(null, false, true), dMatrixRMajHandleU);
        } else {
            DMatrixRMaj q = this.decompQRP.getQ(dMatrixRMajHandleU, false);
            DMatrixRMaj u = this.decompBi.getU(null, false, true);
            DMatrixRMaj dMatrixRMajExtract = CommonOps_DDRM.extract(q, 0, q.numRows, 0, this.min);
            DMatrixRMaj dMatrixRMaj2 = new DMatrixRMaj(dMatrixRMajExtract.numRows, u.numCols);
            CommonOps_DDRM.mult(dMatrixRMajExtract, u, dMatrixRMaj2);
            CommonOps_DDRM.insert(dMatrixRMaj2, q, 0, 0);
        }
        if (z) {
            CommonOps_DDRM.transpose(dMatrixRMajHandleU);
        }
        return dMatrixRMajHandleU;
    }

    @Override // org.ejml.interfaces.decomposition.BidiagonalDecomposition
    public DMatrixRMaj getV(DMatrixRMaj dMatrixRMaj, boolean z, boolean z2) {
        return this.decompBi.getV(dMatrixRMaj, z, z2);
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixRMaj dMatrixRMaj) {
        if (!this.decompQRP.decompose(dMatrixRMaj)) {
            return false;
        }
        this.f2508m = dMatrixRMaj.numRows;
        int i = dMatrixRMaj.numCols;
        this.f2509n = i;
        int iMin = Math.min(this.f2508m, i);
        this.min = iMin;
        this.f2507B.reshape(iMin, this.f2509n, false);
        this.decompQRP.getR(this.f2507B, true);
        DMatrixRMaj dMatrixRMaj2 = new DMatrixRMaj(this.min, this.f2509n);
        CommonOps_DDRM.multTransB(this.f2507B, this.decompQRP.getColPivotMatrix(null), dMatrixRMaj2);
        this.f2507B.set((DMatrixD1) dMatrixRMaj2);
        return this.decompBi.decompose(this.f2507B);
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return this.decompQRP.inputModified();
    }
}
