package org.ejml.dense.row.decomposition.bidiagonal;

import org.ejml.data.FMatrixD1;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.dense.row.factory.DecompositionFactory_FDRM;
import org.ejml.interfaces.decomposition.BidiagonalDecomposition_F32;
import org.ejml.interfaces.decomposition.QRPDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class BidiagonalDecompositionTall_FDRM implements BidiagonalDecomposition_F32<FMatrixRMaj> {

    /* JADX INFO: renamed from: m */
    int f2511m;
    int min;

    /* JADX INFO: renamed from: n */
    int f2512n;
    QRPDecomposition_F32<FMatrixRMaj> decompQRP = DecompositionFactory_FDRM.qrp(500, 100);
    BidiagonalDecomposition_F32<FMatrixRMaj> decompBi = new BidiagonalDecompositionRow_FDRM();

    /* JADX INFO: renamed from: B */
    FMatrixRMaj f2510B = new FMatrixRMaj(1, 1);

    @Override // org.ejml.interfaces.decomposition.BidiagonalDecomposition_F32
    public void getDiagonal(float[] fArr, float[] fArr2) {
        fArr[0] = this.f2510B.get(0);
        for (int i = 1; i < this.f2512n; i++) {
            fArr[i] = this.f2510B.unsafe_get(i, i);
            int i2 = i - 1;
            fArr2[i2] = this.f2510B.unsafe_get(i2, i);
        }
    }

    @Override // org.ejml.interfaces.decomposition.BidiagonalDecomposition
    public FMatrixRMaj getB(FMatrixRMaj fMatrixRMaj, boolean z) {
        int i;
        FMatrixRMaj fMatrixRMajHandleB = BidiagonalDecompositionRow_FDRM.handleB(fMatrixRMaj, z, this.f2511m, this.f2512n, this.min);
        fMatrixRMajHandleB.set(0, 0, this.f2510B.get(0, 0));
        int i2 = 1;
        while (true) {
            i = this.min;
            if (i2 >= i) {
                break;
            }
            fMatrixRMajHandleB.set(i2, i2, this.f2510B.get(i2, i2));
            int i3 = i2 - 1;
            fMatrixRMajHandleB.set(i3, i2, this.f2510B.get(i3, i2));
            i2++;
        }
        if (this.f2512n > this.f2511m) {
            fMatrixRMajHandleB.set(i - 1, i, this.f2510B.get(i - 1, i));
        }
        return fMatrixRMajHandleB;
    }

    @Override // org.ejml.interfaces.decomposition.BidiagonalDecomposition
    public FMatrixRMaj getU(FMatrixRMaj fMatrixRMaj, boolean z, boolean z2) {
        FMatrixRMaj fMatrixRMajHandleU = BidiagonalDecompositionRow_FDRM.handleU(fMatrixRMaj, false, z2, this.f2511m, this.f2512n, this.min);
        if (z2) {
            CommonOps_FDRM.mult(this.decompQRP.getQ(null, true), this.decompBi.getU(null, false, true), fMatrixRMajHandleU);
        } else {
            FMatrixRMaj q = this.decompQRP.getQ(fMatrixRMajHandleU, false);
            FMatrixRMaj u = this.decompBi.getU(null, false, true);
            FMatrixRMaj fMatrixRMajExtract = CommonOps_FDRM.extract(q, 0, q.numRows, 0, this.min);
            FMatrixRMaj fMatrixRMaj2 = new FMatrixRMaj(fMatrixRMajExtract.numRows, u.numCols);
            CommonOps_FDRM.mult(fMatrixRMajExtract, u, fMatrixRMaj2);
            CommonOps_FDRM.insert(fMatrixRMaj2, q, 0, 0);
        }
        if (z) {
            CommonOps_FDRM.transpose(fMatrixRMajHandleU);
        }
        return fMatrixRMajHandleU;
    }

    @Override // org.ejml.interfaces.decomposition.BidiagonalDecomposition
    public FMatrixRMaj getV(FMatrixRMaj fMatrixRMaj, boolean z, boolean z2) {
        return this.decompBi.getV(fMatrixRMaj, z, z2);
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(FMatrixRMaj fMatrixRMaj) {
        if (!this.decompQRP.decompose(fMatrixRMaj)) {
            return false;
        }
        this.f2511m = fMatrixRMaj.numRows;
        int i = fMatrixRMaj.numCols;
        this.f2512n = i;
        int iMin = Math.min(this.f2511m, i);
        this.min = iMin;
        this.f2510B.reshape(iMin, this.f2512n, false);
        this.decompQRP.getR(this.f2510B, true);
        FMatrixRMaj fMatrixRMaj2 = new FMatrixRMaj(this.min, this.f2512n);
        CommonOps_FDRM.multTransB(this.f2510B, this.decompQRP.getColPivotMatrix(null), fMatrixRMaj2);
        this.f2510B.set((FMatrixD1) fMatrixRMaj2);
        return this.decompBi.decompose(this.f2510B);
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return this.decompQRP.inputModified();
    }
}
