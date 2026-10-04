package org.ejml.dense.row.decompose.p048qr;

import org.ejml.data.CMatrixRMaj;
import org.ejml.data.Complex_F32;
import org.ejml.dense.row.decompose.UtilDecompositons_CDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class QRDecompositionHouseholder_CDRM implements QRDecomposition<CMatrixRMaj> {

    /* JADX INFO: renamed from: QR */
    protected CMatrixRMaj f2493QR;
    protected float[] dataQR;
    protected boolean error;
    protected float[] gammas;
    protected int minLength;
    protected int numCols;
    protected int numRows;
    protected Complex_F32 tau = new Complex_F32();

    /* JADX INFO: renamed from: u */
    protected float[] f2494u;

    /* JADX INFO: renamed from: v */
    protected float[] f2495v;

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
        CMatrixRMaj cMatrixRMaj = this.f2493QR;
        if (cMatrixRMaj == null) {
            this.f2493QR = new CMatrixRMaj(i, i2);
            int i3 = iMax * 2;
            this.f2494u = new float[i3];
            this.f2495v = new float[i3];
            this.gammas = new float[this.minLength];
        } else {
            cMatrixRMaj.reshape(i, i2);
        }
        this.dataQR = this.f2493QR.data;
        int i4 = iMax * 2;
        if (this.f2494u.length < i4) {
            this.f2494u = new float[i4];
            this.f2495v = new float[i4];
        }
        int length = this.gammas.length;
        int i5 = this.minLength;
        if (length < i5) {
            this.gammas = new float[i5];
        }
    }

    public CMatrixRMaj getQR() {
        return this.f2493QR;
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
        int i2 = this.minLength - 1;
        while (i2 >= 0) {
            int i3 = i2;
            QrHelperFunctions_CDRM.extractHouseholderColumn(this.f2493QR, i2, this.numRows, i3, this.f2494u, 0);
            QrHelperFunctions_CDRM.rank1UpdateMultR(cMatrixRMaj2, this.f2494u, 0, this.gammas[i2], i3, i3, this.numRows, this.f2495v);
            i2 = i3 - 1;
        }
        return cMatrixRMaj2;
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public CMatrixRMaj getR(CMatrixRMaj cMatrixRMaj, boolean z) {
        CMatrixRMaj cMatrixRMajCheckZerosLT;
        if (z) {
            cMatrixRMajCheckZerosLT = UtilDecompositons_CDRM.checkZerosLT(cMatrixRMaj, this.minLength, this.numCols);
        } else {
            cMatrixRMajCheckZerosLT = UtilDecompositons_CDRM.checkZerosLT(cMatrixRMaj, this.numRows, this.numCols);
        }
        for (int i = 0; i < this.minLength; i++) {
            for (int i2 = i; i2 < this.numCols; i2++) {
                int index = this.f2493QR.getIndex(i, i2);
                cMatrixRMajCheckZerosLT.set(i, i2, this.f2493QR.data[index], this.f2493QR.data[index + 1]);
            }
        }
        return cMatrixRMajCheckZerosLT;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(CMatrixRMaj cMatrixRMaj) {
        commonSetup(cMatrixRMaj);
        for (int i = 0; i < this.minLength; i++) {
            householder(i);
        }
        return !this.error;
    }

    protected void householder(int i) {
        int i2;
        float fExtractColumnAndMax = QrHelperFunctions_CDRM.extractColumnAndMax(this.f2493QR, i, this.numRows, i, this.f2494u, 0);
        if (fExtractColumnAndMax <= 0.0f) {
            this.gammas[i] = 0.0f;
            this.error = true;
            return;
        }
        float fComputeTauGammaAndDivide = QrHelperFunctions_CDRM.computeTauGammaAndDivide(i, this.numRows, this.f2494u, fExtractColumnAndMax, this.tau);
        this.gammas[i] = fComputeTauGammaAndDivide;
        int i3 = i * 2;
        int i4 = i3 + 1;
        int i5 = i + 1;
        QrHelperFunctions_CDRM.divideElements(i5, this.numRows, this.f2494u, 0, this.f2494u[i3] + this.tau.real, this.f2494u[i4] + this.tau.imaginary);
        int i6 = i5;
        while (true) {
            i2 = this.numRows;
            if (i6 >= i2) {
                break;
            }
            float[] fArr = this.dataQR;
            int i7 = this.numCols;
            float[] fArr2 = this.f2494u;
            int i8 = i6 * 2;
            fArr[((i6 * i7) + i) * 2] = fArr2[i8];
            fArr[(((i7 * i6) + i) * 2) + 1] = fArr2[i8 + 1];
            i6++;
        }
        float[] fArr3 = this.f2494u;
        fArr3[i3] = 1.0f;
        fArr3[i4] = 0.0f;
        QrHelperFunctions_CDRM.rank1UpdateMultR(this.f2493QR, fArr3, 0, fComputeTauGammaAndDivide, i5, i, i2, this.f2495v);
        int i9 = this.numCols;
        if (i < i9) {
            this.dataQR[((i9 * i) + i) * 2] = (-this.tau.real) * fExtractColumnAndMax;
            this.dataQR[(((this.numCols * i) + i) * 2) + 1] = (-this.tau.imaginary) * fExtractColumnAndMax;
        }
    }

    protected void commonSetup(CMatrixRMaj cMatrixRMaj) {
        setExpectedMaxSize(cMatrixRMaj.numRows, cMatrixRMaj.numCols);
        this.f2493QR.set(cMatrixRMaj);
    }

    public float[] getGammas() {
        return this.gammas;
    }
}
