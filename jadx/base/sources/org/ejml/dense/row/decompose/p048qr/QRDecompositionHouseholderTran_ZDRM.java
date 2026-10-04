package org.ejml.dense.row.decompose.p048qr;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.Complex_F64;
import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.CommonOps_ZDRM;
import org.ejml.dense.row.decompose.UtilDecompositons_ZDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class QRDecompositionHouseholderTran_ZDRM implements QRDecomposition<ZMatrixRMaj> {

    /* JADX INFO: renamed from: QR */
    protected ZMatrixRMaj f2491QR;
    protected boolean error;
    protected double gamma;
    protected double[] gammas;
    protected int minLength;
    protected int numCols;
    protected int numRows;
    protected Complex_F64 tau = new Complex_F64();

    /* JADX INFO: renamed from: v */
    protected double[] f2492v;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    public void setExpectedMaxSize(int i, int i2) {
        this.numCols = i2;
        this.numRows = i;
        this.minLength = Math.min(i2, i);
        int iMax = Math.max(i2, i);
        ZMatrixRMaj zMatrixRMaj = this.f2491QR;
        if (zMatrixRMaj == null) {
            this.f2491QR = new ZMatrixRMaj(i2, i);
            this.f2492v = new double[iMax * 2];
            this.gammas = new double[this.minLength];
        } else {
            zMatrixRMaj.reshape(i2, i);
        }
        int i3 = iMax * 2;
        if (this.f2492v.length < i3) {
            this.f2492v = new double[i3];
        }
        int length = this.gammas.length;
        int i4 = this.minLength;
        if (length < i4) {
            this.gammas = new double[i4];
        }
    }

    public ZMatrixRMaj getQR() {
        return this.f2491QR;
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
            int i3 = ((this.numRows * i2) + i2) * 2;
            double d = this.f2491QR.data[i3];
            int i4 = i3 + 1;
            double d2 = this.f2491QR.data[i4];
            this.f2491QR.data[i3] = 1.0d;
            this.f2491QR.data[i4] = 0.0d;
            double[] dArr = this.f2491QR.data;
            int i5 = this.numRows;
            QrHelperFunctions_ZDRM.rank1UpdateMultR(zMatrixRMaj2, dArr, i2 * i5, this.gammas[i2], i2, i2, i5, this.f2492v);
            this.f2491QR.data[i3] = d;
            this.f2491QR.data[i4] = d2;
        }
        return zMatrixRMaj2;
    }

    public void applyQ(ZMatrixRMaj zMatrixRMaj) {
        ZMatrixRMaj zMatrixRMaj2 = zMatrixRMaj;
        if (zMatrixRMaj2.numRows != this.numRows) {
            throw new IllegalArgumentException("A must have at least " + this.numRows + " rows.");
        }
        int i = this.minLength - 1;
        while (i >= 0) {
            int i2 = ((this.numRows * i) + i) * 2;
            double d = this.f2491QR.data[i2];
            int i3 = i2 + 1;
            double d2 = this.f2491QR.data[i3];
            this.f2491QR.data[i2] = 1.0d;
            this.f2491QR.data[i3] = 0.0d;
            double[] dArr = this.f2491QR.data;
            int i4 = this.numRows;
            QrHelperFunctions_ZDRM.rank1UpdateMultR(zMatrixRMaj2, dArr, i * i4, this.gammas[i], 0, i, i4, this.f2492v);
            this.f2491QR.data[i2] = d;
            this.f2491QR.data[i3] = d2;
            i--;
            zMatrixRMaj2 = zMatrixRMaj;
        }
    }

    public void applyTranQ(ZMatrixRMaj zMatrixRMaj) {
        for (int i = 0; i < this.minLength; i++) {
            int i2 = ((this.numRows * i) + i) * 2;
            double d = this.f2491QR.data[i2];
            int i3 = i2 + 1;
            double d2 = this.f2491QR.data[i3];
            this.f2491QR.data[i2] = 1.0d;
            this.f2491QR.data[i3] = 0.0d;
            double[] dArr = this.f2491QR.data;
            int i4 = this.numRows;
            QrHelperFunctions_ZDRM.rank1UpdateMultR(zMatrixRMaj, dArr, i * i4, this.gammas[i], 0, i, i4, this.f2492v);
            this.f2491QR.data[i2] = d;
            this.f2491QR.data[i3] = d2;
        }
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
        for (int i = 0; i < zMatrixRMaj2.numRows; i++) {
            for (int i2 = i; i2 < zMatrixRMaj2.numCols; i2++) {
                int index = this.f2491QR.getIndex(i2, i);
                zMatrixRMaj2.set(i, i2, this.f2491QR.data[index], this.f2491QR.data[index + 1]);
            }
        }
        return zMatrixRMaj2;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(ZMatrixRMaj zMatrixRMaj) {
        setExpectedMaxSize(zMatrixRMaj.numRows, zMatrixRMaj.numCols);
        CommonOps_ZDRM.transpose(zMatrixRMaj, this.f2491QR);
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
        double dFindMax = QrHelperFunctions_ZDRM.findMax(this.f2491QR.data, i5, this.numRows - i);
        if (dFindMax == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.gamma = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            this.error = true;
        } else {
            this.gamma = QrHelperFunctions_ZDRM.computeTauGammaAndDivide(i5, i4, this.f2491QR.data, dFindMax, this.tau);
            int i6 = i5 * 2;
            int i7 = i6 + 1;
            QrHelperFunctions_ZDRM.divideElements(i5 + 1, i4, this.f2491QR.data, 0, this.tau.real + this.f2491QR.data[i6], this.f2491QR.data[i7] + this.tau.imaginary);
            this.tau.real *= dFindMax;
            this.tau.imaginary *= dFindMax;
            this.f2491QR.data[i6] = -this.tau.real;
            this.f2491QR.data[i7] = -this.tau.imaginary;
        }
        this.gammas[i] = this.gamma;
    }

    protected void updateA(int i) {
        double[] dArr = this.f2491QR.data;
        int i2 = this.numRows;
        int i3 = (i * i2) + i + 1;
        int i4 = i3 + i2;
        int i5 = ((((this.numCols - i) - 1) * i2) + i4) * 2;
        int i6 = (((i2 + i3) - i) - 1) * 2;
        int i7 = i4 * 2;
        int i8 = i3 * 2;
        while (i5 != i7) {
            int i9 = i7 - 2;
            double d = dArr[i9];
            int i10 = i7 - 1;
            double d2 = dArr[i10];
            int i11 = i8;
            int i12 = i7;
            while (i11 != i6) {
                int i13 = i11 + 1;
                double d3 = dArr[i11];
                i11 += 2;
                int i14 = i8;
                double d4 = -dArr[i13];
                int i15 = i12 + 1;
                double d5 = dArr[i12];
                i12 += 2;
                double d6 = dArr[i15];
                d += (d3 * d5) - (d4 * d6);
                d2 += (d3 * d6) + (d4 * d5);
                i8 = i14;
                i7 = i7;
            }
            int i16 = i8;
            int i17 = i7;
            double d7 = this.gamma;
            double d8 = d * d7;
            double d9 = d2 * d7;
            dArr[i9] = dArr[i9] - d8;
            dArr[i10] = dArr[i10] - d9;
            int i18 = i16;
            int i19 = i17;
            while (i18 != i6) {
                int i20 = i18 + 1;
                double d10 = dArr[i18];
                i18 += 2;
                double d11 = dArr[i20];
                int i21 = i19 + 1;
                dArr[i19] = dArr[i19] - ((d10 * d8) - (d11 * d9));
                i19 += 2;
                dArr[i21] = dArr[i21] - ((d10 * d9) + (d11 * d8));
            }
            i7 = i17 + (this.numRows * 2);
            i8 = i16;
        }
    }

    public double[] getGammas() {
        return this.gammas;
    }
}
