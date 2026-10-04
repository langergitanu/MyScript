package org.ejml.dense.row.decomposition.p050qr;

import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class QRDecompositionHouseholderTran_FDRM implements QRDecomposition<FMatrixRMaj> {

    /* JADX INFO: renamed from: QR */
    protected FMatrixRMaj f2625QR;
    protected boolean error;
    protected float gamma;
    protected float[] gammas;
    protected int minLength;
    protected int numCols;
    protected int numRows;
    protected float tau;

    /* JADX INFO: renamed from: v */
    protected float[] f2626v;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    public void setExpectedMaxSize(int i, int i2) {
        this.numCols = i2;
        this.numRows = i;
        this.minLength = Math.min(i2, i);
        int iMax = Math.max(i2, i);
        FMatrixRMaj fMatrixRMaj = this.f2625QR;
        if (fMatrixRMaj == null) {
            this.f2625QR = new FMatrixRMaj(i2, i);
            this.f2626v = new float[iMax];
            this.gammas = new float[this.minLength];
        } else {
            fMatrixRMaj.reshape(i2, i, false);
        }
        if (this.f2626v.length < iMax) {
            this.f2626v = new float[iMax];
        }
        int length = this.gammas.length;
        int i3 = this.minLength;
        if (length < i3) {
            this.gammas = new float[i3];
        }
    }

    public FMatrixRMaj getQR() {
        return this.f2625QR;
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public FMatrixRMaj getQ(FMatrixRMaj fMatrixRMaj, boolean z) {
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
        for (int i = this.minLength - 1; i >= 0; i--) {
            int i2 = (this.numRows * i) + i;
            float f = this.f2625QR.data[i2];
            this.f2625QR.data[i2] = 1.0f;
            float[] fArr = this.f2625QR.data;
            int i3 = this.numRows;
            QrHelperFunctions_FDRM.rank1UpdateMultR(fMatrixRMaj2, fArr, i * i3, this.gammas[i], i, i, i3, this.f2626v);
            this.f2625QR.data[i2] = f;
        }
        return fMatrixRMaj2;
    }

    public void applyQ(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj.numRows != this.numRows) {
            throw new IllegalArgumentException("A must have at least " + this.numRows + " rows.");
        }
        int i = this.minLength - 1;
        while (i >= 0) {
            int i2 = (this.numRows * i) + i;
            float f = this.f2625QR.data[i2];
            this.f2625QR.data[i2] = 1.0f;
            float[] fArr = this.f2625QR.data;
            int i3 = this.numRows;
            FMatrixRMaj fMatrixRMaj2 = fMatrixRMaj;
            QrHelperFunctions_FDRM.rank1UpdateMultR(fMatrixRMaj2, fArr, i * i3, this.gammas[i], 0, i, i3, this.f2626v);
            this.f2625QR.data[i2] = f;
            i--;
            fMatrixRMaj = fMatrixRMaj2;
        }
    }

    public void applyTranQ(FMatrixRMaj fMatrixRMaj) {
        int i = 0;
        while (i < this.minLength) {
            int i2 = (this.numRows * i) + i;
            float f = this.f2625QR.data[i2];
            this.f2625QR.data[i2] = 1.0f;
            float[] fArr = this.f2625QR.data;
            int i3 = this.numRows;
            FMatrixRMaj fMatrixRMaj2 = fMatrixRMaj;
            QrHelperFunctions_FDRM.rank1UpdateMultR(fMatrixRMaj2, fArr, i * i3, this.gammas[i], 0, i, i3, this.f2626v);
            this.f2625QR.data[i2] = f;
            i++;
            fMatrixRMaj = fMatrixRMaj2;
        }
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
                    fMatrixRMaj.unsafe_set(i, i2, 0.0f);
                }
            }
        } else if (z) {
            fMatrixRMaj = new FMatrixRMaj(this.minLength, this.numCols);
        } else {
            fMatrixRMaj = new FMatrixRMaj(this.numRows, this.numCols);
        }
        for (int i3 = 0; i3 < fMatrixRMaj.numRows; i3++) {
            for (int i4 = i3; i4 < fMatrixRMaj.numCols; i4++) {
                fMatrixRMaj.unsafe_set(i3, i4, this.f2625QR.unsafe_get(i4, i3));
            }
        }
        return fMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(FMatrixRMaj fMatrixRMaj) {
        setExpectedMaxSize(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        CommonOps_FDRM.transpose(fMatrixRMaj, this.f2625QR);
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
        float fFindMax = QrHelperFunctions_FDRM.findMax(this.f2625QR.data, i5, this.numRows - i);
        if (fFindMax == 0.0f) {
            this.gamma = 0.0f;
            this.error = true;
        } else {
            this.tau = QrHelperFunctions_FDRM.computeTauAndDivide(i5, i4, this.f2625QR.data, fFindMax);
            float f = this.f2625QR.data[i5] + this.tau;
            QrHelperFunctions_FDRM.divideElements(i5 + 1, i4, this.f2625QR.data, f);
            float f2 = this.tau;
            this.gamma = f / f2;
            this.tau = f2 * fFindMax;
            this.f2625QR.data[i5] = -this.tau;
        }
        this.gammas[i] = this.gamma;
    }

    protected void updateA(int i) {
        float[] fArr = this.f2625QR.data;
        int i2 = this.numRows;
        int i3 = (i * i2) + i + 1;
        int i4 = i3 + i2;
        int i5 = (((this.numCols - i) - 1) * i2) + i4;
        int i6 = ((i2 + i3) - i) - 1;
        while (i5 != i4) {
            int i7 = i4 - 1;
            float f = fArr[i7];
            int i8 = i3;
            int i9 = i4;
            while (i8 != i6) {
                f += fArr[i8] * fArr[i9];
                i8++;
                i9++;
            }
            float f2 = f * this.gamma;
            fArr[i7] = fArr[i7] - f2;
            int i10 = i4;
            for (int i11 = i3; i11 != i6; i11++) {
                fArr[i10] = fArr[i10] - (fArr[i11] * f2);
                i10++;
            }
            i4 += this.numRows;
        }
    }

    public float[] getGammas() {
        return this.gammas;
    }
}
