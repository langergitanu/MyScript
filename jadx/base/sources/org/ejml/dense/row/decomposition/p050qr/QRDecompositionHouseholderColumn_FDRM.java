package org.ejml.dense.row.decomposition.p050qr;

import java.lang.reflect.Array;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.decomposition.UtilDecompositons_FDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class QRDecompositionHouseholderColumn_FDRM implements QRDecomposition<FMatrixRMaj> {
    protected float[][] dataQR;
    protected boolean error;
    protected float gamma;
    protected float[] gammas;
    protected int minLength;
    protected int numCols;
    protected int numRows;
    protected float tau;

    /* JADX INFO: renamed from: v */
    protected float[] f2622v;

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
        if (fArr == null || fArr.length < i2 || fArr[0].length < i) {
            this.dataQR = (float[][]) Array.newInstance((Class<?>) Float.TYPE, i2, i);
            this.f2622v = new float[iMax];
            this.gammas = new float[this.minLength];
        }
        if (this.f2622v.length < iMax) {
            this.f2622v = new float[iMax];
        }
        int length = this.gammas.length;
        int i3 = this.minLength;
        if (length < i3) {
            this.gammas = new float[i3];
        }
    }

    public float[][] getQR() {
        return this.dataQR;
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public FMatrixRMaj getQ(FMatrixRMaj fMatrixRMaj, boolean z) {
        FMatrixRMaj fMatrixRMajCheckIdentity;
        if (z) {
            fMatrixRMajCheckIdentity = UtilDecompositons_FDRM.checkIdentity(fMatrixRMaj, this.numRows, this.minLength);
        } else {
            int i = this.numRows;
            fMatrixRMajCheckIdentity = UtilDecompositons_FDRM.checkIdentity(fMatrixRMaj, i, i);
        }
        FMatrixRMaj fMatrixRMaj2 = fMatrixRMajCheckIdentity;
        for (int i2 = this.minLength - 1; i2 >= 0; i2--) {
            float[] fArr = this.dataQR[i2];
            float f = fArr[i2];
            fArr[i2] = 1.0f;
            QrHelperFunctions_FDRM.rank1UpdateMultR(fMatrixRMaj2, fArr, this.gammas[i2], i2, i2, this.numRows, this.f2622v);
            fArr[i2] = f;
        }
        return fMatrixRMaj2;
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public FMatrixRMaj getR(FMatrixRMaj fMatrixRMaj, boolean z) {
        FMatrixRMaj fMatrixRMajCheckZerosLT;
        if (z) {
            fMatrixRMajCheckZerosLT = UtilDecompositons_FDRM.checkZerosLT(fMatrixRMaj, this.minLength, this.numCols);
        } else {
            fMatrixRMajCheckZerosLT = UtilDecompositons_FDRM.checkZerosLT(fMatrixRMaj, this.numRows, this.numCols);
        }
        for (int i = 0; i < this.numCols; i++) {
            float[] fArr = this.dataQR[i];
            int iMin = Math.min(i, this.numRows - 1);
            for (int i2 = 0; i2 <= iMin; i2++) {
                fMatrixRMajCheckZerosLT.set(i2, i, fArr[i2]);
            }
        }
        return fMatrixRMajCheckZerosLT;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(FMatrixRMaj fMatrixRMaj) {
        setExpectedMaxSize(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        convertToColumnMajor(fMatrixRMaj);
        this.error = false;
        for (int i = 0; i < this.minLength; i++) {
            householder(i);
            updateA(i);
        }
        return !this.error;
    }

    protected void convertToColumnMajor(FMatrixRMaj fMatrixRMaj) {
        for (int i = 0; i < this.numCols; i++) {
            float[] fArr = this.dataQR[i];
            for (int i2 = 0; i2 < this.numRows; i2++) {
                fArr[i2] = fMatrixRMaj.data[(this.numCols * i2) + i];
            }
        }
    }

    protected void householder(int i) {
        float[] fArr = this.dataQR[i];
        float fFindMax = QrHelperFunctions_FDRM.findMax(fArr, i, this.numRows - i);
        if (fFindMax == 0.0f) {
            this.gamma = 0.0f;
            this.error = true;
        } else {
            float fComputeTauAndDivide = QrHelperFunctions_FDRM.computeTauAndDivide(i, this.numRows, fArr, fFindMax);
            this.tau = fComputeTauAndDivide;
            float f = fArr[i] + fComputeTauAndDivide;
            QrHelperFunctions_FDRM.divideElements(i + 1, this.numRows, fArr, f);
            float f2 = this.tau;
            this.gamma = f / f2;
            float f3 = f2 * fFindMax;
            this.tau = f3;
            fArr[i] = -f3;
        }
        this.gammas[i] = this.gamma;
    }

    protected void updateA(int i) {
        float[] fArr = this.dataQR[i];
        int i2 = i + 1;
        for (int i3 = i2; i3 < this.numCols; i3++) {
            float[] fArr2 = this.dataQR[i3];
            float f = fArr2[i];
            for (int i4 = i2; i4 < this.numRows; i4++) {
                f += fArr[i4] * fArr2[i4];
            }
            float f2 = f * this.gamma;
            fArr2[i] = fArr2[i] - f2;
            for (int i5 = i2; i5 < this.numRows; i5++) {
                fArr2[i5] = fArr2[i5] - (fArr[i5] * f2);
            }
        }
    }

    public float[] getGammas() {
        return this.gammas;
    }
}
