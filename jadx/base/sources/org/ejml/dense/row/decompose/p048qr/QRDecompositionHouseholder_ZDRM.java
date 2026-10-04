package org.ejml.dense.row.decompose.p048qr;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.Complex_F64;
import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.decompose.UtilDecompositons_ZDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class QRDecompositionHouseholder_ZDRM implements QRDecomposition<ZMatrixRMaj> {

    /* JADX INFO: renamed from: QR */
    protected ZMatrixRMaj f2496QR;
    protected double[] dataQR;
    protected boolean error;
    protected double[] gammas;
    protected int minLength;
    protected int numCols;
    protected int numRows;
    protected Complex_F64 tau = new Complex_F64();

    /* JADX INFO: renamed from: u */
    protected double[] f2497u;

    /* JADX INFO: renamed from: v */
    protected double[] f2498v;

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
        ZMatrixRMaj zMatrixRMaj = this.f2496QR;
        if (zMatrixRMaj == null) {
            this.f2496QR = new ZMatrixRMaj(i, i2);
            int i3 = iMax * 2;
            this.f2497u = new double[i3];
            this.f2498v = new double[i3];
            this.gammas = new double[this.minLength];
        } else {
            zMatrixRMaj.reshape(i, i2);
        }
        this.dataQR = this.f2496QR.data;
        int i4 = iMax * 2;
        if (this.f2497u.length < i4) {
            this.f2497u = new double[i4];
            this.f2498v = new double[i4];
        }
        int length = this.gammas.length;
        int i5 = this.minLength;
        if (length < i5) {
            this.gammas = new double[i5];
        }
    }

    public ZMatrixRMaj getQR() {
        return this.f2496QR;
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
        int i2 = this.minLength - 1;
        while (i2 >= 0) {
            QrHelperFunctions_ZDRM.extractHouseholderColumn(this.f2496QR, i2, this.numRows, i2, this.f2497u, 0);
            int i3 = i2;
            QrHelperFunctions_ZDRM.rank1UpdateMultR(zMatrixRMaj2, this.f2497u, 0, this.gammas[i2], i3, i3, this.numRows, this.f2498v);
            i2 = i3 - 1;
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
        for (int i = 0; i < this.minLength; i++) {
            for (int i2 = i; i2 < this.numCols; i2++) {
                int index = this.f2496QR.getIndex(i, i2);
                zMatrixRMaj2.set(i, i2, this.f2496QR.data[index], this.f2496QR.data[index + 1]);
            }
        }
        return zMatrixRMaj2;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(ZMatrixRMaj zMatrixRMaj) {
        commonSetup(zMatrixRMaj);
        for (int i = 0; i < this.minLength; i++) {
            householder(i);
        }
        return !this.error;
    }

    protected void householder(int i) {
        int i2;
        double dExtractColumnAndMax = QrHelperFunctions_ZDRM.extractColumnAndMax(this.f2496QR, i, this.numRows, i, this.f2497u, 0);
        if (dExtractColumnAndMax <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.gammas[i] = 0.0d;
            this.error = true;
            return;
        }
        double dComputeTauGammaAndDivide = QrHelperFunctions_ZDRM.computeTauGammaAndDivide(i, this.numRows, this.f2497u, dExtractColumnAndMax, this.tau);
        this.gammas[i] = dComputeTauGammaAndDivide;
        int i3 = i * 2;
        int i4 = i3 + 1;
        int i5 = i + 1;
        QrHelperFunctions_ZDRM.divideElements(i5, this.numRows, this.f2497u, 0, this.f2497u[i3] + this.tau.real, this.f2497u[i4] + this.tau.imaginary);
        int i6 = i5;
        while (true) {
            i2 = this.numRows;
            if (i6 >= i2) {
                break;
            }
            double[] dArr = this.dataQR;
            int i7 = this.numCols;
            double[] dArr2 = this.f2497u;
            int i8 = i6 * 2;
            dArr[((i6 * i7) + i) * 2] = dArr2[i8];
            dArr[(((i7 * i6) + i) * 2) + 1] = dArr2[i8 + 1];
            i6++;
        }
        double[] dArr3 = this.f2497u;
        dArr3[i3] = 1.0d;
        dArr3[i4] = 0.0d;
        QrHelperFunctions_ZDRM.rank1UpdateMultR(this.f2496QR, dArr3, 0, dComputeTauGammaAndDivide, i5, i, i2, this.f2498v);
        int i9 = this.numCols;
        if (i < i9) {
            this.dataQR[((i9 * i) + i) * 2] = (-this.tau.real) * dExtractColumnAndMax;
            this.dataQR[(((this.numCols * i) + i) * 2) + 1] = (-this.tau.imaginary) * dExtractColumnAndMax;
        }
    }

    protected void commonSetup(ZMatrixRMaj zMatrixRMaj) {
        setExpectedMaxSize(zMatrixRMaj.numRows, zMatrixRMaj.numCols);
        this.f2496QR.set(zMatrixRMaj);
    }

    public double[] getGammas() {
        return this.gammas;
    }
}
