package org.ejml.dense.row.decomposition.p050qr;

import org.ejml.data.FMatrixD1;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class QRDecompositionHouseholder_FDRM implements QRDecomposition<FMatrixRMaj> {

    /* JADX INFO: renamed from: QR */
    protected FMatrixRMaj f2630QR;
    protected float[] dataQR;
    protected boolean error;
    protected float gamma;
    protected float[] gammas;
    protected int minLength;
    protected int numCols;
    protected int numRows;
    protected float tau;

    /* JADX INFO: renamed from: u */
    protected float[] f2631u;

    /* JADX INFO: renamed from: v */
    protected float[] f2632v;

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
        FMatrixRMaj fMatrixRMaj = this.f2630QR;
        if (fMatrixRMaj == null) {
            this.f2630QR = new FMatrixRMaj(i, i2);
            this.f2631u = new float[iMax];
            this.f2632v = new float[iMax];
            this.gammas = new float[this.minLength];
        } else {
            fMatrixRMaj.reshape(i, i2, false);
        }
        this.dataQR = this.f2630QR.data;
        if (this.f2631u.length < iMax) {
            this.f2631u = new float[iMax];
            this.f2632v = new float[iMax];
        }
        int length = this.gammas.length;
        int i3 = this.minLength;
        if (length < i3) {
            this.gammas = new float[i3];
        }
    }

    public FMatrixRMaj getQR() {
        return this.f2630QR;
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public FMatrixRMaj getQ(FMatrixRMaj fMatrixRMaj, boolean z) {
        int i;
        if (z) {
            if (fMatrixRMaj == null) {
                fMatrixRMaj = CommonOps_FDRM.identity(this.numRows, this.minLength);
            } else {
                if (fMatrixRMaj.numRows != this.numRows || fMatrixRMaj.numCols != this.minLength) {
                    throw new IllegalArgumentException("Unexpected matrix dimension.");
                }
                CommonOps_FDRM.setIdentity(fMatrixRMaj);
            }
        } else if (fMatrixRMaj == null) {
            fMatrixRMaj = CommonOps_FDRM.identity(this.numRows);
        } else {
            if (fMatrixRMaj.numRows != this.numRows || fMatrixRMaj.numCols != this.numRows) {
                throw new IllegalArgumentException("Unexpected matrix dimension.");
            }
            CommonOps_FDRM.setIdentity(fMatrixRMaj);
        }
        FMatrixRMaj fMatrixRMaj2 = fMatrixRMaj;
        for (int i2 = this.minLength - 1; i2 >= 0; i2--) {
            this.f2631u[i2] = 1.0f;
            int i3 = i2 + 1;
            while (true) {
                i = this.numRows;
                if (i3 < i) {
                    this.f2631u[i3] = this.f2630QR.get(i3, i2);
                    i3++;
                }
            }
            QrHelperFunctions_FDRM.rank1UpdateMultR(fMatrixRMaj2, this.f2631u, this.gammas[i2], i2, i2, i, this.f2632v);
        }
        return fMatrixRMaj2;
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public FMatrixRMaj getR(FMatrixRMaj fMatrixRMaj, boolean z) {
        if (fMatrixRMaj != null) {
            if (z) {
                if (fMatrixRMaj.numCols != this.numCols || fMatrixRMaj.numRows != this.minLength) {
                    throw new IllegalArgumentException("Unexpected dimensions");
                }
            } else if (fMatrixRMaj.numCols != this.numCols || fMatrixRMaj.numRows != this.numRows) {
                throw new IllegalArgumentException("Unexpected dimensions");
            }
            for (int i = 0; i < fMatrixRMaj.numRows; i++) {
                int iMin = Math.min(i, fMatrixRMaj.numCols);
                for (int i2 = 0; i2 < iMin; i2++) {
                    fMatrixRMaj.set(i, i2, 0.0f);
                }
            }
        } else if (z) {
            fMatrixRMaj = new FMatrixRMaj(this.minLength, this.numCols);
        } else {
            fMatrixRMaj = new FMatrixRMaj(this.numRows, this.numCols);
        }
        for (int i3 = 0; i3 < this.minLength; i3++) {
            for (int i4 = i3; i4 < this.numCols; i4++) {
                fMatrixRMaj.set(i3, i4, this.f2630QR.get(i3, i4));
            }
        }
        return fMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(FMatrixRMaj fMatrixRMaj) {
        commonSetup(fMatrixRMaj);
        for (int i = 0; i < this.minLength; i++) {
            householder(i);
            updateA(i);
        }
        return !this.error;
    }

    protected void householder(int i) {
        int i2 = (this.numCols * i) + i;
        float f = 0.0f;
        for (int i3 = i; i3 < this.numRows; i3++) {
            float[] fArr = this.f2631u;
            float f2 = this.dataQR[i2];
            fArr[i3] = f2;
            if (f2 < 0.0f) {
                f2 = -f2;
            }
            if (f < f2) {
                f = f2;
            }
            i2 += this.numCols;
        }
        if (f == 0.0f) {
            this.gamma = 0.0f;
            this.error = true;
        } else {
            this.tau = 0.0f;
            for (int i4 = i; i4 < this.numRows; i4++) {
                float[] fArr2 = this.f2631u;
                float f3 = fArr2[i4] / f;
                fArr2[i4] = f3;
                this.tau += f3 * f3;
            }
            float fSqrt = (float) Math.sqrt(this.tau);
            this.tau = fSqrt;
            float f4 = this.f2631u[i];
            if (f4 < 0.0f) {
                this.tau = -fSqrt;
            }
            float f5 = this.tau;
            float f6 = f4 + f5;
            this.gamma = f6 / f5;
            for (int i5 = i + 1; i5 < this.numRows; i5++) {
                float[] fArr3 = this.f2631u;
                fArr3[i5] = fArr3[i5] / f6;
            }
            this.f2631u[i] = 1.0f;
            this.tau *= f;
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
            this.f2632v[i3] = this.f2631u[i] * this.dataQR[(i4 * i) + i3];
            i3++;
        }
        for (int i5 = i2; i5 < this.numRows; i5++) {
            int i6 = (this.numCols * i5) + i + 1;
            int i7 = i2;
            while (i7 < this.numCols) {
                float[] fArr = this.f2632v;
                fArr[i7] = fArr[i7] + (this.f2631u[i5] * this.dataQR[i6]);
                i7++;
                i6++;
            }
        }
        for (int i8 = i2; i8 < this.numCols; i8++) {
            float[] fArr2 = this.f2632v;
            fArr2[i8] = fArr2[i8] * this.gamma;
        }
        for (int i9 = i; i9 < this.numRows; i9++) {
            float f = this.f2631u[i9];
            int i10 = (this.numCols * i9) + i + 1;
            int i11 = i2;
            while (i11 < this.numCols) {
                float[] fArr3 = this.dataQR;
                fArr3[i10] = fArr3[i10] - (this.f2632v[i11] * f);
                i11++;
                i10++;
            }
        }
        int i12 = this.numCols;
        if (i < i12) {
            this.dataQR[(i12 * i) + i] = -this.tau;
        }
        while (i2 < this.numRows) {
            this.dataQR[(this.numCols * i2) + i] = this.f2631u[i2];
            i2++;
        }
    }

    protected void commonSetup(FMatrixRMaj fMatrixRMaj) {
        setExpectedMaxSize(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        this.f2630QR.set((FMatrixD1) fMatrixRMaj);
    }

    public float[] getGammas() {
        return this.gammas;
    }
}
