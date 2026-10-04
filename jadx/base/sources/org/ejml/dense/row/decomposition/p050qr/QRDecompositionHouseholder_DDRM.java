package org.ejml.dense.row.decomposition.p050qr;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class QRDecompositionHouseholder_DDRM implements QRDecomposition<DMatrixRMaj> {

    /* JADX INFO: renamed from: QR */
    protected DMatrixRMaj f2627QR;
    protected double[] dataQR;
    protected boolean error;
    protected double gamma;
    protected double[] gammas;
    protected int minLength;
    protected int numCols;
    protected int numRows;
    protected double tau;

    /* JADX INFO: renamed from: u */
    protected double[] f2628u;

    /* JADX INFO: renamed from: v */
    protected double[] f2629v;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    public void setExpectedMaxSize(int i, int i2) {
        this.error = false;
        this.numCols = i2;
        this.numRows = i;
        this.minLength = Math.min(i, i2);
        int iMax = Math.max(i, i2);
        DMatrixRMaj dMatrixRMaj = this.f2627QR;
        if (dMatrixRMaj == null) {
            this.f2627QR = new DMatrixRMaj(i, i2);
            this.f2628u = new double[iMax];
            this.f2629v = new double[iMax];
            this.gammas = new double[this.minLength];
        } else {
            dMatrixRMaj.reshape(i, i2, false);
        }
        this.dataQR = this.f2627QR.data;
        if (this.f2628u.length < iMax) {
            this.f2628u = new double[iMax];
            this.f2629v = new double[iMax];
        }
        int length = this.gammas.length;
        int i3 = this.minLength;
        if (length < i3) {
            this.gammas = new double[i3];
        }
    }

    public DMatrixRMaj getQR() {
        return this.f2627QR;
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public DMatrixRMaj getQ(DMatrixRMaj dMatrixRMaj, boolean z) {
        int i;
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
        for (int i2 = this.minLength - 1; i2 >= 0; i2--) {
            this.f2628u[i2] = 1.0d;
            int i3 = i2 + 1;
            while (true) {
                i = this.numRows;
                if (i3 < i) {
                    this.f2628u[i3] = this.f2627QR.get(i3, i2);
                    i3++;
                }
            }
            QrHelperFunctions_DDRM.rank1UpdateMultR(dMatrixRMaj2, this.f2628u, this.gammas[i2], i2, i2, i, this.f2629v);
        }
        return dMatrixRMaj2;
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
                    dMatrixRMaj.set(i, i2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                }
            }
        } else if (z) {
            dMatrixRMaj = new DMatrixRMaj(this.minLength, this.numCols);
        } else {
            dMatrixRMaj = new DMatrixRMaj(this.numRows, this.numCols);
        }
        for (int i3 = 0; i3 < this.minLength; i3++) {
            for (int i4 = i3; i4 < this.numCols; i4++) {
                dMatrixRMaj.set(i3, i4, this.f2627QR.get(i3, i4));
            }
        }
        return dMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixRMaj dMatrixRMaj) {
        commonSetup(dMatrixRMaj);
        for (int i = 0; i < this.minLength; i++) {
            householder(i);
            updateA(i);
        }
        return !this.error;
    }

    protected void householder(int i) {
        int i2 = (this.numCols * i) + i;
        double d = 0.0d;
        for (int i3 = i; i3 < this.numRows; i3++) {
            double[] dArr = this.f2628u;
            double d2 = this.dataQR[i2];
            dArr[i3] = d2;
            if (d2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                d2 = -d2;
            }
            if (d < d2) {
                d = d2;
            }
            i2 += this.numCols;
        }
        if (d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.gamma = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            this.error = true;
        } else {
            this.tau = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            for (int i4 = i; i4 < this.numRows; i4++) {
                double[] dArr2 = this.f2628u;
                double d3 = dArr2[i4] / d;
                dArr2[i4] = d3;
                this.tau += d3 * d3;
            }
            double dSqrt = Math.sqrt(this.tau);
            this.tau = dSqrt;
            double d4 = this.f2628u[i];
            if (d4 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                this.tau = -dSqrt;
            }
            double d5 = this.tau;
            double d6 = d4 + d5;
            this.gamma = d6 / d5;
            for (int i5 = i + 1; i5 < this.numRows; i5++) {
                double[] dArr3 = this.f2628u;
                dArr3[i5] = dArr3[i5] / d6;
            }
            this.f2628u[i] = 1.0d;
            this.tau *= d;
        }
        this.gammas[i] = this.gamma;
    }

    protected void updateA(int i) {
        int i2 = i + 1;
        int i3 = i2;
        while (true) {
            int i4 = this.numCols;
            if (i3 >= i4) {
                break;
            }
            this.f2629v[i3] = this.f2628u[i] * this.dataQR[(i4 * i) + i3];
            i3++;
        }
        for (int i5 = i2; i5 < this.numRows; i5++) {
            int i6 = (this.numCols * i5) + i + 1;
            int i7 = i2;
            while (i7 < this.numCols) {
                double[] dArr = this.f2629v;
                dArr[i7] = dArr[i7] + (this.f2628u[i5] * this.dataQR[i6]);
                i7++;
                i6++;
            }
        }
        for (int i8 = i2; i8 < this.numCols; i8++) {
            double[] dArr2 = this.f2629v;
            dArr2[i8] = dArr2[i8] * this.gamma;
        }
        for (int i9 = i; i9 < this.numRows; i9++) {
            double d = this.f2628u[i9];
            int i10 = (this.numCols * i9) + i + 1;
            int i11 = i2;
            while (i11 < this.numCols) {
                double[] dArr3 = this.dataQR;
                dArr3[i10] = dArr3[i10] - (this.f2629v[i11] * d);
                i11++;
                i10++;
            }
        }
        int i12 = this.numCols;
        if (i < i12) {
            this.dataQR[(i12 * i) + i] = -this.tau;
        }
        while (i2 < this.numRows) {
            this.dataQR[(this.numCols * i2) + i] = this.f2628u[i2];
            i2++;
        }
    }

    protected void commonSetup(DMatrixRMaj dMatrixRMaj) {
        setExpectedMaxSize(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        this.f2627QR.set((DMatrixD1) dMatrixRMaj);
    }

    public double[] getGammas() {
        return this.gammas;
    }
}
