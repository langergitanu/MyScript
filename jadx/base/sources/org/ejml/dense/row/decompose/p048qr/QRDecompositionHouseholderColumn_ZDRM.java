package org.ejml.dense.row.decompose.p048qr;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Array;
import org.ejml.data.Complex_F64;
import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.decompose.UtilDecompositons_ZDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class QRDecompositionHouseholderColumn_ZDRM implements QRDecomposition<ZMatrixRMaj> {
    protected double[][] dataQR;
    protected boolean error;
    protected double gamma;
    protected double[] gammas;
    protected int minLength;
    protected int numCols;
    protected int numRows;
    protected Complex_F64 tau = new Complex_F64();

    /* JADX INFO: renamed from: v */
    protected double[] f2488v;

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
        if (dArr == null || dArr.length < i2 || dArr[0].length < i * 2) {
            this.dataQR = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i2, i * 2);
            this.f2488v = new double[iMax * 2];
            this.gammas = new double[this.minLength];
        }
        int i3 = iMax * 2;
        if (this.f2488v.length < i3) {
            this.f2488v = new double[i3];
        }
        int length = this.gammas.length;
        int i4 = this.minLength;
        if (length < i4) {
            this.gammas = new double[i4];
        }
    }

    public double[][] getQR() {
        return this.dataQR;
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public ZMatrixRMaj getQ(ZMatrixRMaj zMatrixRMaj, boolean z) {
        ZMatrixRMaj zMatrixRMajCheckIdentity;
        if (z) {
            zMatrixRMajCheckIdentity = UtilDecompositons_ZDRM.checkIdentity(zMatrixRMaj, this.numRows, this.minLength);
        } else {
            int i = this.numRows;
            zMatrixRMajCheckIdentity = UtilDecompositons_ZDRM.checkIdentity(zMatrixRMaj, i, i);
        }
        ZMatrixRMaj zMatrixRMaj2 = zMatrixRMajCheckIdentity;
        for (int i2 = this.minLength - 1; i2 >= 0; i2--) {
            double[] dArr = this.dataQR[i2];
            int i3 = i2 * 2;
            double d = dArr[i3];
            int i4 = i3 + 1;
            double d2 = dArr[i4];
            dArr[i3] = 1.0d;
            dArr[i4] = 0.0d;
            QrHelperFunctions_ZDRM.rank1UpdateMultR(zMatrixRMaj2, dArr, 0, this.gammas[i2], i2, i2, this.numRows, this.f2488v);
            dArr[i3] = d;
            dArr[i4] = d2;
        }
        return zMatrixRMaj2;
    }

    @Override // org.ejml.interfaces.decomposition.QRDecomposition
    public ZMatrixRMaj getR(ZMatrixRMaj zMatrixRMaj, boolean z) {
        ZMatrixRMaj zMatrixRMajCheckZerosLT;
        if (z) {
            zMatrixRMajCheckZerosLT = UtilDecompositons_ZDRM.checkZerosLT(zMatrixRMaj, this.minLength, this.numCols);
        } else {
            zMatrixRMajCheckZerosLT = UtilDecompositons_ZDRM.checkZerosLT(zMatrixRMaj, this.numRows, this.numCols);
        }
        ZMatrixRMaj zMatrixRMaj2 = zMatrixRMajCheckZerosLT;
        for (int i = 0; i < this.numCols; i++) {
            double[] dArr = this.dataQR[i];
            int iMin = Math.min(i, this.numRows - 1);
            for (int i2 = 0; i2 <= iMin; i2++) {
                int i3 = i2 * 2;
                zMatrixRMaj2.set(i2, i, dArr[i3], dArr[i3 + 1]);
            }
        }
        return zMatrixRMaj2;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(ZMatrixRMaj zMatrixRMaj) {
        setExpectedMaxSize(zMatrixRMaj.numRows, zMatrixRMaj.numCols);
        convertToColumnMajor(zMatrixRMaj);
        this.error = false;
        for (int i = 0; i < this.minLength; i++) {
            householder(i);
            updateA(i);
        }
        return !this.error;
    }

    protected void convertToColumnMajor(ZMatrixRMaj zMatrixRMaj) {
        for (int i = 0; i < this.numCols; i++) {
            double[] dArr = this.dataQR[i];
            int i2 = 0;
            for (int i3 = 0; i3 < this.numRows; i3++) {
                int i4 = ((this.numCols * i3) + i) * 2;
                int i5 = i2 + 1;
                dArr[i2] = zMatrixRMaj.data[i4];
                i2 += 2;
                dArr[i5] = zMatrixRMaj.data[i4 + 1];
            }
        }
    }

    protected void householder(int i) {
        double[] dArr = this.dataQR[i];
        double dFindMax = QrHelperFunctions_ZDRM.findMax(dArr, i, this.numRows - i);
        if (dFindMax == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.gamma = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            this.error = true;
        } else {
            this.gamma = QrHelperFunctions_ZDRM.computeTauGammaAndDivide(i, this.numRows, dArr, dFindMax, this.tau);
            int i2 = i * 2;
            int i3 = i2 + 1;
            QrHelperFunctions_ZDRM.divideElements(i + 1, this.numRows, dArr, 0, dArr[i2] + this.tau.real, this.tau.imaginary + dArr[i3]);
            this.tau.real *= dFindMax;
            this.tau.imaginary *= dFindMax;
            dArr[i2] = -this.tau.real;
            dArr[i3] = -this.tau.imaginary;
        }
        this.gammas[i] = this.gamma;
    }

    protected void updateA(int i) {
        double[] dArr = this.dataQR[i];
        int i2 = i + 1;
        int i3 = i2;
        while (i3 < this.numCols) {
            double[] dArr2 = this.dataQR[i3];
            int i4 = i * 2;
            double d = dArr2[i4];
            int i5 = i4 + 1;
            double d2 = dArr2[i5];
            int i6 = i2;
            while (i6 < this.numRows) {
                int i7 = i6 * 2;
                double d3 = dArr[i7];
                int i8 = i7 + 1;
                int i9 = i2;
                double d4 = -dArr[i8];
                double d5 = dArr2[i7];
                double d6 = dArr2[i8];
                d += (d3 * d5) - (d4 * d6);
                d2 += (d4 * d5) + (d3 * d6);
                i6++;
                i2 = i9;
                i3 = i3;
            }
            int i10 = i2;
            int i11 = i3;
            double d7 = this.gamma;
            double d8 = d * d7;
            double d9 = d2 * d7;
            dArr2[i4] = dArr2[i4] - d8;
            dArr2[i5] = dArr2[i5] - d9;
            for (int i12 = i10; i12 < this.numRows; i12++) {
                int i13 = i12 * 2;
                double d10 = dArr[i13];
                int i14 = i13 + 1;
                double d11 = dArr[i14];
                dArr2[i13] = dArr2[i13] - ((d10 * d8) - (d11 * d9));
                dArr2[i14] = dArr2[i14] - ((d11 * d8) + (d10 * d9));
            }
            i3 = i11 + 1;
            i2 = i10;
        }
    }

    public double[] getGammas() {
        return this.gammas;
    }
}
