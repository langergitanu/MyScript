package org.ejml.dense.row.decomposition.hessenberg;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.decomposition.UtilDecompositons_DDRM;
import org.ejml.dense.row.decomposition.p050qr.QrHelperFunctions_DDRM;

/* JADX INFO: loaded from: classes9.dex */
public class TridiagonalDecompositionHouseholderOrig_DDRM {

    /* JADX INFO: renamed from: N */
    int f2597N = 1;

    /* JADX INFO: renamed from: QT */
    DMatrixRMaj f2598QT;

    /* JADX INFO: renamed from: b */
    double[] f2599b;
    double[] gammas;

    /* JADX INFO: renamed from: w */
    double[] f2600w;

    public TridiagonalDecompositionHouseholderOrig_DDRM() {
        int i = this.f2597N;
        this.f2598QT = new DMatrixRMaj(i, i);
        int i2 = this.f2597N;
        this.f2600w = new double[i2];
        this.f2599b = new double[i2];
        this.gammas = new double[i2];
    }

    public DMatrixRMaj getQT() {
        return this.f2598QT;
    }

    public DMatrixRMaj getT(DMatrixRMaj dMatrixRMaj) {
        int i = this.f2597N;
        DMatrixRMaj dMatrixRMajCheckZeros = UtilDecompositons_DDRM.checkZeros(dMatrixRMaj, i, i);
        dMatrixRMajCheckZeros.data[0] = this.f2598QT.data[0];
        dMatrixRMajCheckZeros.data[1] = this.f2598QT.data[1];
        int i2 = 1;
        while (i2 < this.f2597N - 1) {
            dMatrixRMajCheckZeros.set(i2, i2, this.f2598QT.get(i2, i2));
            int i3 = i2 + 1;
            dMatrixRMajCheckZeros.set(i2, i3, this.f2598QT.get(i2, i3));
            int i4 = i2 - 1;
            dMatrixRMajCheckZeros.set(i2, i4, this.f2598QT.get(i4, i2));
            i2 = i3;
        }
        double[] dArr = dMatrixRMajCheckZeros.data;
        int i5 = this.f2597N;
        int i6 = (((i5 - 1) * i5) + i5) - 1;
        double[] dArr2 = this.f2598QT.data;
        int i7 = this.f2597N;
        dArr[i6] = dArr2[(((i7 - 1) * i7) + i7) - 1];
        double[] dArr3 = dMatrixRMajCheckZeros.data;
        int i8 = this.f2597N;
        int i9 = (((i8 - 1) * i8) + i8) - 2;
        double[] dArr4 = this.f2598QT.data;
        int i10 = this.f2597N;
        dArr3[i9] = dArr4[(((i10 - 2) * i10) + i10) - 1];
        return dMatrixRMajCheckZeros;
    }

    public DMatrixRMaj getQ(DMatrixRMaj dMatrixRMaj) {
        int i;
        int i2;
        int i3 = this.f2597N;
        DMatrixRMaj dMatrixRMajCheckIdentity = UtilDecompositons_DDRM.checkIdentity(dMatrixRMaj, i3, i3);
        int i4 = 0;
        while (true) {
            i = this.f2597N;
            if (i4 >= i) {
                break;
            }
            this.f2600w[i4] = 0.0d;
            i4++;
        }
        for (int i5 = i - 2; i5 >= 0; i5--) {
            int i6 = i5 + 1;
            this.f2600w[i6] = 1.0d;
            int i7 = i5 + 2;
            while (true) {
                i2 = this.f2597N;
                if (i7 < i2) {
                    this.f2600w[i7] = this.f2598QT.get(i5, i7);
                    i7++;
                }
            }
            QrHelperFunctions_DDRM.rank1UpdateMultR(dMatrixRMajCheckIdentity, this.f2600w, this.gammas[i6], i6, i6, i2, this.f2599b);
        }
        return dMatrixRMajCheckIdentity;
    }

    public void decompose(DMatrixRMaj dMatrixRMaj) {
        init(dMatrixRMaj);
        for (int i = 1; i < this.f2597N; i++) {
            similarTransform(i);
        }
    }

    private void similarTransform(int i) {
        double[] dArr = this.f2598QT.data;
        int i2 = (i - 1) * this.f2597N;
        double d = 0.0d;
        for (int i3 = i; i3 < this.f2597N; i3++) {
            double dAbs = Math.abs(dArr[i2 + i3]);
            if (dAbs > d) {
                d = dAbs;
            }
        }
        if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            double d2 = 0.0d;
            for (int i4 = i; i4 < this.f2597N; i4++) {
                int i5 = i2 + i4;
                double d3 = dArr[i5] / d;
                dArr[i5] = d3;
                d2 += d3 * d3;
            }
            double dSqrt = Math.sqrt(d2);
            int i6 = i2 + i;
            double d4 = dArr[i6];
            if (d4 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                dSqrt = -dSqrt;
            }
            double d5 = d4 + dSqrt;
            dArr[i6] = 1.0d;
            for (int i7 = i + 1; i7 < this.f2597N; i7++) {
                int i8 = i2 + i7;
                dArr[i8] = dArr[i8] / d5;
            }
            double d6 = d5 / dSqrt;
            this.gammas[i] = d6;
            householderSymmetric(i, d6);
            dArr[i6] = (-dSqrt) * d;
            return;
        }
        this.gammas[i] = 0.0d;
    }

    public void householderSymmetric(int i, double d) {
        double d2;
        int i2 = (i - 1) * this.f2597N;
        int i3 = i;
        while (true) {
            int i4 = this.f2597N;
            d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (i3 >= i4) {
                break;
            }
            for (int i5 = i; i5 < this.f2597N; i5++) {
                d2 += this.f2598QT.data[(this.f2597N * i3) + i5] * this.f2598QT.data[i2 + i5];
            }
            this.f2600w[i3] = (-d) * d2;
            i3++;
        }
        for (int i6 = i; i6 < this.f2597N; i6++) {
            d2 += this.f2598QT.data[i2 + i6] * this.f2600w[i6];
        }
        double d3 = d2 * d * (-0.5d);
        for (int i7 = i; i7 < this.f2597N; i7++) {
            double[] dArr = this.f2600w;
            dArr[i7] = dArr[i7] + (this.f2598QT.data[i2 + i7] * d3);
        }
        for (int i8 = i; i8 < this.f2597N; i8++) {
            double d4 = this.f2600w[i8];
            double d5 = this.f2598QT.data[i2 + i8];
            for (int i9 = i8; i9 < this.f2597N; i9++) {
                double[] dArr2 = this.f2598QT.data;
                int i10 = (this.f2597N * i9) + i8;
                double[] dArr3 = this.f2598QT.data;
                int i11 = (this.f2597N * i8) + i9;
                double d6 = dArr3[i11] + (this.f2598QT.data[i2 + i9] * d4) + (this.f2600w[i9] * d5);
                dArr3[i11] = d6;
                dArr2[i10] = d6;
            }
        }
    }

    public void init(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj.numRows != dMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Must be square");
        }
        if (dMatrixRMaj.numCols != this.f2597N) {
            int i = dMatrixRMaj.numCols;
            this.f2597N = i;
            this.f2598QT.reshape(i, i, false);
            int length = this.f2600w.length;
            int i2 = this.f2597N;
            if (length < i2) {
                this.f2600w = new double[i2];
                this.gammas = new double[i2];
                this.f2599b = new double[i2];
            }
        }
        this.f2598QT.set((DMatrixD1) dMatrixRMaj);
    }

    public double getGamma(int i) {
        return this.gammas[i];
    }
}
