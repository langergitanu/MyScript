package org.ejml.dense.row.decompose.p048qr;

import java.lang.reflect.Array;
import org.ejml.data.CMatrixRMaj;
import org.ejml.data.Complex_F32;
import org.ejml.dense.row.decompose.UtilDecompositons_CDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class QRDecompositionHouseholderColumn_CDRM implements QRDecomposition<CMatrixRMaj> {
    protected float[][] dataQR;
    protected boolean error;
    protected float gamma;
    protected float[] gammas;
    protected int minLength;
    protected int numCols;
    protected int numRows;
    protected Complex_F32 tau = new Complex_F32();

    /* JADX INFO: renamed from: v */
    protected float[] f2487v;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    public void setExpectedMaxSize(int i, int i2) {
        this.numCols = i2;
        this.numRows = i;
        this.minLength = Math.min(i2, i);
        int iMax = Math.max(i2, i);
        float[][] fArr = this.dataQR;
        if (fArr == null || fArr.length < i2 || fArr[0].length < i * 2) {
            this.dataQR = (float[][]) Array.newInstance((Class<?>) Float.TYPE, i2, i * 2);
            this.f2487v = new float[iMax * 2];
            this.gammas = new float[this.minLength];
        }
        int i3 = iMax * 2;
        if (this.f2487v.length < i3) {
            this.f2487v = new float[i3];
        }
        int length = this.gammas.length;
        int i4 = this.minLength;
        if (length < i4) {
            this.gammas = new float[i4];
        }
    }

    public float[][] getQR() {
        return this.dataQR;
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
            float[] fArr = this.dataQR[i2];
            int i3 = i2 * 2;
            float f = fArr[i3];
            int i4 = i3 + 1;
            float f2 = fArr[i4];
            fArr[i3] = 1.0f;
            fArr[i4] = 0.0f;
            QrHelperFunctions_CDRM.rank1UpdateMultR(cMatrixRMaj2, fArr, 0, this.gammas[i2], i2, i2, this.numRows, this.f2487v);
            fArr[i3] = f;
            fArr[i4] = f2;
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
        for (int i = 0; i < this.numCols; i++) {
            float[] fArr = this.dataQR[i];
            int iMin = Math.min(i, this.numRows - 1);
            for (int i2 = 0; i2 <= iMin; i2++) {
                int i3 = i2 * 2;
                cMatrixRMajCheckZerosLT.set(i2, i, fArr[i3], fArr[i3 + 1]);
            }
        }
        return cMatrixRMajCheckZerosLT;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(CMatrixRMaj cMatrixRMaj) {
        setExpectedMaxSize(cMatrixRMaj.numRows, cMatrixRMaj.numCols);
        convertToColumnMajor(cMatrixRMaj);
        this.error = false;
        for (int i = 0; i < this.minLength; i++) {
            householder(i);
            updateA(i);
        }
        return !this.error;
    }

    protected void convertToColumnMajor(CMatrixRMaj cMatrixRMaj) {
        for (int i = 0; i < this.numCols; i++) {
            float[] fArr = this.dataQR[i];
            int i2 = 0;
            for (int i3 = 0; i3 < this.numRows; i3++) {
                int i4 = ((this.numCols * i3) + i) * 2;
                int i5 = i2 + 1;
                fArr[i2] = cMatrixRMaj.data[i4];
                i2 += 2;
                fArr[i5] = cMatrixRMaj.data[i4 + 1];
            }
        }
    }

    protected void householder(int i) {
        float[] fArr = this.dataQR[i];
        float fFindMax = QrHelperFunctions_CDRM.findMax(fArr, i, this.numRows - i);
        if (fFindMax == 0.0f) {
            this.gamma = 0.0f;
            this.error = true;
        } else {
            this.gamma = QrHelperFunctions_CDRM.computeTauGammaAndDivide(i, this.numRows, fArr, fFindMax, this.tau);
            int i2 = i * 2;
            int i3 = i2 + 1;
            QrHelperFunctions_CDRM.divideElements(i + 1, this.numRows, fArr, 0, fArr[i2] + this.tau.real, fArr[i3] + this.tau.imaginary);
            this.tau.real *= fFindMax;
            this.tau.imaginary *= fFindMax;
            fArr[i2] = -this.tau.real;
            fArr[i3] = -this.tau.imaginary;
        }
        this.gammas[i] = this.gamma;
    }

    protected void updateA(int i) {
        float[] fArr = this.dataQR[i];
        int i2 = i + 1;
        for (int i3 = i2; i3 < this.numCols; i3++) {
            float[] fArr2 = this.dataQR[i3];
            int i4 = i * 2;
            float f = fArr2[i4];
            int i5 = i4 + 1;
            float f2 = fArr2[i5];
            for (int i6 = i2; i6 < this.numRows; i6++) {
                int i7 = i6 * 2;
                float f3 = fArr[i7];
                int i8 = i7 + 1;
                float f4 = -fArr[i8];
                float f5 = fArr2[i7];
                float f6 = fArr2[i8];
                f += (f3 * f5) - (f4 * f6);
                f2 += (f4 * f5) + (f3 * f6);
            }
            float f7 = this.gamma;
            float f8 = f * f7;
            float f9 = f2 * f7;
            fArr2[i4] = fArr2[i4] - f8;
            fArr2[i5] = fArr2[i5] - f9;
            for (int i9 = i2; i9 < this.numRows; i9++) {
                int i10 = i9 * 2;
                float f10 = fArr[i10];
                int i11 = i10 + 1;
                float f11 = fArr[i11];
                fArr2[i10] = fArr2[i10] - ((f10 * f8) - (f11 * f9));
                fArr2[i11] = fArr2[i11] - ((f11 * f8) + (f10 * f9));
            }
        }
    }

    public float[] getGammas() {
        return this.gammas;
    }
}
