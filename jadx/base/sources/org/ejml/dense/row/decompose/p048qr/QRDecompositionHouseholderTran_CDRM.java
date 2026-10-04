package org.ejml.dense.row.decompose.p048qr;

import org.ejml.data.CMatrixRMaj;
import org.ejml.data.Complex_F32;
import org.ejml.dense.row.CommonOps_CDRM;
import org.ejml.dense.row.decompose.UtilDecompositons_CDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class QRDecompositionHouseholderTran_CDRM implements QRDecomposition<CMatrixRMaj> {

    /* JADX INFO: renamed from: QR */
    protected CMatrixRMaj f2489QR;
    protected boolean error;
    protected float gamma;
    protected float[] gammas;
    protected int minLength;
    protected int numCols;
    protected int numRows;
    protected Complex_F32 tau = new Complex_F32();

    /* JADX INFO: renamed from: v */
    protected float[] f2490v;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    public void setExpectedMaxSize(int i, int i2) {
        this.numCols = i2;
        this.numRows = i;
        this.minLength = Math.min(i2, i);
        int iMax = Math.max(i2, i);
        CMatrixRMaj cMatrixRMaj = this.f2489QR;
        if (cMatrixRMaj == null) {
            this.f2489QR = new CMatrixRMaj(i2, i);
            this.f2490v = new float[iMax * 2];
            this.gammas = new float[this.minLength];
        } else {
            cMatrixRMaj.reshape(i2, i);
        }
        int i3 = iMax * 2;
        if (this.f2490v.length < i3) {
            this.f2490v = new float[i3];
        }
        int length = this.gammas.length;
        int i4 = this.minLength;
        if (length < i4) {
            this.gammas = new float[i4];
        }
    }

    public CMatrixRMaj getQR() {
        return this.f2489QR;
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public CMatrixRMaj getQ(CMatrixRMaj cMatrixRMaj, boolean z) {
        CMatrixRMaj cMatrixRMajCheckIdentity;
        if (z) {
            cMatrixRMajCheckIdentity = UtilDecompositons_CDRM.checkIdentity(cMatrixRMaj, this.numRows, this.minLength);
        } else {
            int i = this.numRows;
            cMatrixRMajCheckIdentity = UtilDecompositons_CDRM.checkIdentity(cMatrixRMaj, i, i);
        }
        CMatrixRMaj cMatrixRMaj2 = cMatrixRMajCheckIdentity;
        for (int i2 = this.minLength - 1; i2 >= 0; i2--) {
            int i3 = ((this.numRows * i2) + i2) * 2;
            float f = this.f2489QR.data[i3];
            int i4 = i3 + 1;
            float f2 = this.f2489QR.data[i4];
            this.f2489QR.data[i3] = 1.0f;
            this.f2489QR.data[i4] = 0.0f;
            float[] fArr = this.f2489QR.data;
            int i5 = this.numRows;
            QrHelperFunctions_CDRM.rank1UpdateMultR(cMatrixRMaj2, fArr, i2 * i5, this.gammas[i2], i2, i2, i5, this.f2490v);
            this.f2489QR.data[i3] = f;
            this.f2489QR.data[i4] = f2;
        }
        return cMatrixRMaj2;
    }

    public void applyQ(CMatrixRMaj cMatrixRMaj) {
        if (cMatrixRMaj.numRows != this.numRows) {
            throw new IllegalArgumentException("A must have at least " + this.numRows + " rows.");
        }
        int i = this.minLength - 1;
        while (i >= 0) {
            int i2 = ((this.numRows * i) + i) * 2;
            float f = this.f2489QR.data[i2];
            int i3 = i2 + 1;
            float f2 = this.f2489QR.data[i3];
            this.f2489QR.data[i2] = 1.0f;
            this.f2489QR.data[i3] = 0.0f;
            float[] fArr = this.f2489QR.data;
            int i4 = this.numRows;
            CMatrixRMaj cMatrixRMaj2 = cMatrixRMaj;
            QrHelperFunctions_CDRM.rank1UpdateMultR(cMatrixRMaj2, fArr, i * i4, this.gammas[i], 0, i, i4, this.f2490v);
            this.f2489QR.data[i2] = f;
            this.f2489QR.data[i3] = f2;
            i--;
            cMatrixRMaj = cMatrixRMaj2;
        }
    }

    public void applyTranQ(CMatrixRMaj cMatrixRMaj) {
        int i = 0;
        while (i < this.minLength) {
            int i2 = ((this.numRows * i) + i) * 2;
            float f = this.f2489QR.data[i2];
            int i3 = i2 + 1;
            float f2 = this.f2489QR.data[i3];
            this.f2489QR.data[i2] = 1.0f;
            this.f2489QR.data[i3] = 0.0f;
            float[] fArr = this.f2489QR.data;
            int i4 = this.numRows;
            CMatrixRMaj cMatrixRMaj2 = cMatrixRMaj;
            QrHelperFunctions_CDRM.rank1UpdateMultR(cMatrixRMaj2, fArr, i * i4, this.gammas[i], 0, i, i4, this.f2490v);
            this.f2489QR.data[i2] = f;
            this.f2489QR.data[i3] = f2;
            i++;
            cMatrixRMaj = cMatrixRMaj2;
        }
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public CMatrixRMaj getR(CMatrixRMaj cMatrixRMaj, boolean z) {
        CMatrixRMaj cMatrixRMajCheckZerosLT;
        if (z) {
            cMatrixRMajCheckZerosLT = UtilDecompositons_CDRM.checkZerosLT(cMatrixRMaj, this.minLength, this.numCols);
        } else {
            cMatrixRMajCheckZerosLT = UtilDecompositons_CDRM.checkZerosLT(cMatrixRMaj, this.numRows, this.numCols);
        }
        for (int i = 0; i < cMatrixRMajCheckZerosLT.numRows; i++) {
            for (int i2 = i; i2 < cMatrixRMajCheckZerosLT.numCols; i2++) {
                int index = this.f2489QR.getIndex(i2, i);
                cMatrixRMajCheckZerosLT.set(i, i2, this.f2489QR.data[index], this.f2489QR.data[index + 1]);
            }
        }
        return cMatrixRMajCheckZerosLT;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(CMatrixRMaj cMatrixRMaj) {
        setExpectedMaxSize(cMatrixRMaj.numRows, cMatrixRMaj.numCols);
        CommonOps_CDRM.transpose(cMatrixRMaj, this.f2489QR);
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
        int i4 = i3 + i2;
        int i5 = i3 + i;
        float fFindMax = QrHelperFunctions_CDRM.findMax(this.f2489QR.data, i5, this.numRows - i);
        if (fFindMax == 0.0f) {
            this.gamma = 0.0f;
            this.error = true;
        } else {
            this.gamma = QrHelperFunctions_CDRM.computeTauGammaAndDivide(i5, i4, this.f2489QR.data, fFindMax, this.tau);
            int i6 = i5 * 2;
            int i7 = i6 + 1;
            QrHelperFunctions_CDRM.divideElements(i5 + 1, i4, this.f2489QR.data, 0, this.f2489QR.data[i6] + this.tau.real, this.f2489QR.data[i7] + this.tau.imaginary);
            this.tau.real *= fFindMax;
            this.tau.imaginary *= fFindMax;
            this.f2489QR.data[i6] = -this.tau.real;
            this.f2489QR.data[i7] = -this.tau.imaginary;
        }
        this.gammas[i] = this.gamma;
    }

    protected void updateA(int i) {
        float[] fArr = this.f2489QR.data;
        int i2 = this.numRows;
        int i3 = (i * i2) + i + 1;
        int i4 = i3 + i2;
        int i5 = ((((this.numCols - i) - 1) * i2) + i4) * 2;
        int i6 = (((i2 + i3) - i) - 1) * 2;
        int i7 = i4 * 2;
        int i8 = i3 * 2;
        while (i5 != i7) {
            int i9 = i7 - 2;
            float f = fArr[i9];
            int i10 = i7 - 1;
            float f2 = fArr[i10];
            int i11 = i8;
            int i12 = i7;
            while (i11 != i6) {
                int i13 = i11 + 1;
                float f3 = fArr[i11];
                i11 += 2;
                float f4 = -fArr[i13];
                int i14 = i12 + 1;
                float f5 = fArr[i12];
                i12 += 2;
                float f6 = fArr[i14];
                f += (f3 * f5) - (f4 * f6);
                f2 += (f3 * f6) + (f4 * f5);
            }
            float f7 = this.gamma;
            float f8 = f * f7;
            float f9 = f2 * f7;
            fArr[i9] = fArr[i9] - f8;
            fArr[i10] = fArr[i10] - f9;
            int i15 = i8;
            int i16 = i7;
            while (i15 != i6) {
                int i17 = i15 + 1;
                float f10 = fArr[i15];
                i15 += 2;
                float f11 = fArr[i17];
                int i18 = i16 + 1;
                fArr[i16] = fArr[i16] - ((f10 * f8) - (f11 * f9));
                i16 += 2;
                fArr[i18] = fArr[i18] - ((f10 * f9) + (f11 * f8));
            }
            i7 += this.numRows * 2;
        }
    }

    public float[] getGammas() {
        return this.gammas;
    }
}
