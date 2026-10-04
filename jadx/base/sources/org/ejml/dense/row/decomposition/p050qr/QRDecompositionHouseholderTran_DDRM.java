package org.ejml.dense.row.decomposition.p050qr;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class QRDecompositionHouseholderTran_DDRM implements QRDecomposition<DMatrixRMaj> {

    /* JADX INFO: renamed from: QR */
    protected DMatrixRMaj f2623QR;
    protected boolean error;
    protected double gamma;
    protected double[] gammas;
    protected int minLength;
    protected int numCols;
    protected int numRows;
    protected double tau;

    /* JADX INFO: renamed from: v */
    protected double[] f2624v;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    public void setExpectedMaxSize(int i, int i2) {
        this.numCols = i2;
        this.numRows = i;
        this.minLength = Math.min(i2, i);
        int iMax = Math.max(i2, i);
        DMatrixRMaj dMatrixRMaj = this.f2623QR;
        if (dMatrixRMaj == null) {
            this.f2623QR = new DMatrixRMaj(i2, i);
            this.f2624v = new double[iMax];
            this.gammas = new double[this.minLength];
        } else {
            dMatrixRMaj.reshape(i2, i, false);
        }
        if (this.f2624v.length < iMax) {
            this.f2624v = new double[iMax];
        }
        int length = this.gammas.length;
        int i3 = this.minLength;
        if (length < i3) {
            this.gammas = new double[i3];
        }
    }

    public DMatrixRMaj getQR() {
        return this.f2623QR;
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public DMatrixRMaj getQ(DMatrixRMaj dMatrixRMaj, boolean z) {
        if (z) {
            if (dMatrixRMaj == null) {
                dMatrixRMaj = CommonOps_DDRM.identity(this.numRows, this.minLength);
            } else {
                if (dMatrixRMaj.numRows != this.numRows || dMatrixRMaj.numCols != this.minLength) {
                    throw new IllegalArgumentException("Unexpected matrix dimension.");
                }
                CommonOps_DDRM.setIdentity(dMatrixRMaj);
            }
        } else if (dMatrixRMaj == null) {
            dMatrixRMaj = CommonOps_DDRM.identity(this.numRows);
        } else {
            if (dMatrixRMaj.numRows != this.numRows || dMatrixRMaj.numCols != this.numRows) {
                throw new IllegalArgumentException("Unexpected matrix dimension.");
            }
            CommonOps_DDRM.setIdentity(dMatrixRMaj);
        }
        DMatrixRMaj dMatrixRMaj2 = dMatrixRMaj;
        for (int i = this.minLength - 1; i >= 0; i--) {
            int i2 = (this.numRows * i) + i;
            double d = this.f2623QR.data[i2];
            this.f2623QR.data[i2] = 1.0d;
            double[] dArr = this.f2623QR.data;
            int i3 = this.numRows;
            QrHelperFunctions_DDRM.rank1UpdateMultR(dMatrixRMaj2, dArr, i * i3, this.gammas[i], i, i, i3, this.f2624v);
            this.f2623QR.data[i2] = d;
        }
        return dMatrixRMaj2;
    }

    public void applyQ(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj.numRows != this.numRows) {
            throw new IllegalArgumentException("A must have at least " + this.numRows + " rows.");
        }
        int i = this.minLength - 1;
        while (i >= 0) {
            int i2 = (this.numRows * i) + i;
            double d = this.f2623QR.data[i2];
            this.f2623QR.data[i2] = 1.0d;
            double[] dArr = this.f2623QR.data;
            int i3 = this.numRows;
            DMatrixRMaj dMatrixRMaj2 = dMatrixRMaj;
            QrHelperFunctions_DDRM.rank1UpdateMultR(dMatrixRMaj2, dArr, i * i3, this.gammas[i], 0, i, i3, this.f2624v);
            this.f2623QR.data[i2] = d;
            i--;
            dMatrixRMaj = dMatrixRMaj2;
        }
    }

    public void applyTranQ(DMatrixRMaj dMatrixRMaj) {
        int i = 0;
        while (i < this.minLength) {
            int i2 = (this.numRows * i) + i;
            double d = this.f2623QR.data[i2];
            this.f2623QR.data[i2] = 1.0d;
            double[] dArr = this.f2623QR.data;
            int i3 = this.numRows;
            DMatrixRMaj dMatrixRMaj2 = dMatrixRMaj;
            QrHelperFunctions_DDRM.rank1UpdateMultR(dMatrixRMaj2, dArr, i * i3, this.gammas[i], 0, i, i3, this.f2624v);
            this.f2623QR.data[i2] = d;
            i++;
            dMatrixRMaj = dMatrixRMaj2;
        }
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public DMatrixRMaj getR(DMatrixRMaj dMatrixRMaj, boolean z) {
        if (dMatrixRMaj != null) {
            if (z) {
                if (dMatrixRMaj.numCols != this.numCols || dMatrixRMaj.numRows != this.minLength) {
                    throw new IllegalArgumentException("Unexpected dimensions");
                }
            } else if (dMatrixRMaj.numCols != this.numCols || dMatrixRMaj.numRows != this.numRows) {
                throw new IllegalArgumentException("Unexpected dimensions");
            }
            for (int i = 0; i < dMatrixRMaj.numRows; i++) {
                int iMin = Math.min(i, dMatrixRMaj.numCols);
                for (int i2 = 0; i2 < iMin; i2++) {
                    dMatrixRMaj.unsafe_set(i, i2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                }
            }
        } else if (z) {
            dMatrixRMaj = new DMatrixRMaj(this.minLength, this.numCols);
        } else {
            dMatrixRMaj = new DMatrixRMaj(this.numRows, this.numCols);
        }
        for (int i3 = 0; i3 < dMatrixRMaj.numRows; i3++) {
            for (int i4 = i3; i4 < dMatrixRMaj.numCols; i4++) {
                dMatrixRMaj.unsafe_set(i3, i4, this.f2623QR.unsafe_get(i4, i3));
            }
        }
        return dMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixRMaj dMatrixRMaj) {
        setExpectedMaxSize(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        CommonOps_DDRM.transpose(dMatrixRMaj, this.f2623QR);
        this.error = false;
        for (int i = 0; i < this.minLength; i++) {
            householder(i);
            updateA(i);
        }
        return !this.error;
    }

    protected void householder(int i) {
        int i2 = this.numRows;
        int i3 = i * i2;
        int i4 = i2 + i3;
        int i5 = i3 + i;
        double dFindMax = QrHelperFunctions_DDRM.findMax(this.f2623QR.data, i5, this.numRows - i);
        if (dFindMax == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.gamma = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            this.error = true;
        } else {
            this.tau = QrHelperFunctions_DDRM.computeTauAndDivide(i5, i4, this.f2623QR.data, dFindMax);
            double d = this.f2623QR.data[i5] + this.tau;
            QrHelperFunctions_DDRM.divideElements(i5 + 1, i4, this.f2623QR.data, d);
            double d2 = this.tau;
            this.gamma = d / d2;
            this.tau = d2 * dFindMax;
            this.f2623QR.data[i5] = -this.tau;
        }
        this.gammas[i] = this.gamma;
    }

    protected void updateA(int i) {
        double[] dArr = this.f2623QR.data;
        int i2 = this.numRows;
        int i3 = (i * i2) + i + 1;
        int i4 = i3 + i2;
        int i5 = (((this.numCols - i) - 1) * i2) + i4;
        int i6 = ((i2 + i3) - i) - 1;
        while (i5 != i4) {
            int i7 = i4 - 1;
            double d = dArr[i7];
            int i8 = i4;
            for (int i9 = i3; i9 != i6; i9++) {
                d += dArr[i9] * dArr[i8];
                i8++;
            }
            double d2 = d * this.gamma;
            dArr[i7] = dArr[i7] - d2;
            int i10 = i4;
            for (int i11 = i3; i11 != i6; i11++) {
                dArr[i10] = dArr[i10] - (dArr[i11] * d2);
                i10++;
            }
            i4 += this.numRows;
        }
    }

    public double[] getGammas() {
        return this.gammas;
    }
}
