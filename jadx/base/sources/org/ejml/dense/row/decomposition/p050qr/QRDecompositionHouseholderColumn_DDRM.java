package org.ejml.dense.row.decomposition.p050qr;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Array;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.decomposition.UtilDecompositons_DDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class QRDecompositionHouseholderColumn_DDRM implements QRDecomposition<DMatrixRMaj> {
    protected double[][] dataQR;
    protected boolean error;
    protected double gamma;
    protected double[] gammas;
    protected int minLength;
    protected int numCols;
    protected int numRows;
    protected double tau;

    /* JADX INFO: renamed from: v */
    protected double[] f2621v;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    public void setExpectedMaxSize(int i, int i2) {
        this.numCols = i2;
        this.numRows = i;
        this.minLength = Math.min(i2, i);
        int iMax = Math.max(i2, i);
        double[][] dArr = this.dataQR;
        if (dArr == null || dArr.length < i2 || dArr[0].length < i) {
            this.dataQR = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i2, i);
            this.f2621v = new double[iMax];
            this.gammas = new double[this.minLength];
        }
        if (this.f2621v.length < iMax) {
            this.f2621v = new double[iMax];
        }
        int length = this.gammas.length;
        int i3 = this.minLength;
        if (length < i3) {
            this.gammas = new double[i3];
        }
    }

    public double[][] getQR() {
        return this.dataQR;
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public DMatrixRMaj getQ(DMatrixRMaj dMatrixRMaj, boolean z) {
        DMatrixRMaj dMatrixRMajCheckIdentity;
        if (z) {
            dMatrixRMajCheckIdentity = UtilDecompositons_DDRM.checkIdentity(dMatrixRMaj, this.numRows, this.minLength);
        } else {
            int i = this.numRows;
            dMatrixRMajCheckIdentity = UtilDecompositons_DDRM.checkIdentity(dMatrixRMaj, i, i);
        }
        DMatrixRMaj dMatrixRMaj2 = dMatrixRMajCheckIdentity;
        for (int i2 = this.minLength - 1; i2 >= 0; i2--) {
            double[] dArr = this.dataQR[i2];
            double d = dArr[i2];
            dArr[i2] = 1.0d;
            QrHelperFunctions_DDRM.rank1UpdateMultR(dMatrixRMaj2, dArr, this.gammas[i2], i2, i2, this.numRows, this.f2621v);
            dArr[i2] = d;
        }
        return dMatrixRMaj2;
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public DMatrixRMaj getR(DMatrixRMaj dMatrixRMaj, boolean z) {
        DMatrixRMaj dMatrixRMajCheckZerosLT;
        if (z) {
            dMatrixRMajCheckZerosLT = UtilDecompositons_DDRM.checkZerosLT(dMatrixRMaj, this.minLength, this.numCols);
        } else {
            dMatrixRMajCheckZerosLT = UtilDecompositons_DDRM.checkZerosLT(dMatrixRMaj, this.numRows, this.numCols);
        }
        for (int i = 0; i < this.numCols; i++) {
            double[] dArr = this.dataQR[i];
            int iMin = Math.min(i, this.numRows - 1);
            for (int i2 = 0; i2 <= iMin; i2++) {
                dMatrixRMajCheckZerosLT.set(i2, i, dArr[i2]);
            }
        }
        return dMatrixRMajCheckZerosLT;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixRMaj dMatrixRMaj) {
        setExpectedMaxSize(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        convertToColumnMajor(dMatrixRMaj);
        this.error = false;
        for (int i = 0; i < this.minLength; i++) {
            householder(i);
            updateA(i);
        }
        return !this.error;
    }

    protected void convertToColumnMajor(DMatrixRMaj dMatrixRMaj) {
        for (int i = 0; i < this.numCols; i++) {
            double[] dArr = this.dataQR[i];
            for (int i2 = 0; i2 < this.numRows; i2++) {
                dArr[i2] = dMatrixRMaj.data[(this.numCols * i2) + i];
            }
        }
    }

    protected void householder(int i) {
        double[] dArr = this.dataQR[i];
        double dFindMax = QrHelperFunctions_DDRM.findMax(dArr, i, this.numRows - i);
        if (dFindMax == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.gamma = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            this.error = true;
        } else {
            double dComputeTauAndDivide = QrHelperFunctions_DDRM.computeTauAndDivide(i, this.numRows, dArr, dFindMax);
            this.tau = dComputeTauAndDivide;
            double d = dArr[i] + dComputeTauAndDivide;
            QrHelperFunctions_DDRM.divideElements(i + 1, this.numRows, dArr, d);
            double d2 = this.tau;
            this.gamma = d / d2;
            double d3 = d2 * dFindMax;
            this.tau = d3;
            dArr[i] = -d3;
        }
        this.gammas[i] = this.gamma;
    }

    protected void updateA(int i) {
        double[] dArr = this.dataQR[i];
        int i2 = i + 1;
        for (int i3 = i2; i3 < this.numCols; i3++) {
            double[] dArr2 = this.dataQR[i3];
            double d = dArr2[i];
            for (int i4 = i2; i4 < this.numRows; i4++) {
                d += dArr[i4] * dArr2[i4];
            }
            double d2 = d * this.gamma;
            dArr2[i] = dArr2[i] - d2;
            for (int i5 = i2; i5 < this.numRows; i5++) {
                dArr2[i5] = dArr2[i5] - (dArr[i5] * d2);
            }
        }
    }

    public double[] getGammas() {
        return this.gammas;
    }
}
