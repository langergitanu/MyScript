package org.ejml.dense.row.decompose.hessenberg;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import org.ejml.data.Complex_F64;
import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.decompose.UtilDecompositons_ZDRM;
import org.ejml.dense.row.decompose.p048qr.QrHelperFunctions_ZDRM;
import org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class TridiagonalDecompositionHouseholder_ZDRM implements TridiagonalSimilarDecomposition_F64<ZMatrixRMaj> {

    /* JADX INFO: renamed from: QT */
    private ZMatrixRMaj f2476QT;
    private Complex_F64 tau = new Complex_F64();

    /* JADX INFO: renamed from: N */
    private int f2475N = 1;

    /* JADX INFO: renamed from: w */
    private double[] f2478w = new double[2];

    /* JADX INFO: renamed from: b */
    private double[] f2477b = new double[2];
    private double[] gammas = new double[1];

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return true;
    }

    public ZMatrixRMaj getQT() {
        return this.f2476QT;
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F64
    public void getDiagonal(double[] dArr, double[] dArr2) {
        int i = 0;
        while (i < this.f2475N) {
            int i2 = i * 2;
            dArr[i2] = this.f2476QT.data[((this.f2475N * i) + i) * 2];
            int i3 = i2 + 1;
            double[] dArr3 = this.f2476QT.data;
            int i4 = this.f2475N;
            dArr[i3] = dArr3[(((i * i4) + i) * 2) + 1];
            int i5 = i + 1;
            if (i5 < i4) {
                dArr2[i2] = this.f2476QT.data[((this.f2475N * i) + i + 1) * 2];
                dArr2[i3] = this.f2476QT.data[(((this.f2475N * i) + i + 1) * 2) + 1];
            }
            i = i5;
        }
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition
    public ZMatrixRMaj getT(ZMatrixRMaj zMatrixRMaj) {
        int i = this.f2475N;
        ZMatrixRMaj zMatrixRMajCheckZeros = UtilDecompositons_ZDRM.checkZeros(zMatrixRMaj, i, i);
        zMatrixRMajCheckZeros.data[0] = this.f2476QT.data[0];
        int i2 = 1;
        zMatrixRMajCheckZeros.data[1] = this.f2476QT.data[1];
        while (i2 < this.f2475N) {
            zMatrixRMajCheckZeros.set(i2, i2, this.f2476QT.getReal(i2, i2), this.f2476QT.getImag(i2, i2));
            int i3 = i2 - 1;
            double real = this.f2476QT.getReal(i3, i2);
            double imag = this.f2476QT.getImag(i3, i2);
            int i4 = i2;
            zMatrixRMajCheckZeros.set(i3, i4, real, imag);
            zMatrixRMajCheckZeros.set(i4, i3, real, -imag);
            i2 = i4 + 1;
        }
        return zMatrixRMajCheckZeros;
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition
    public ZMatrixRMaj getQ(ZMatrixRMaj zMatrixRMaj, boolean z) {
        int i = this.f2475N;
        ZMatrixRMaj zMatrixRMajCheckIdentity = UtilDecompositons_ZDRM.checkIdentity(zMatrixRMaj, i, i);
        Arrays.fill(this.f2478w, 0, this.f2475N * 2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        if (z) {
            int i2 = this.f2475N - 2;
            while (i2 >= 0) {
                int i3 = i2 + 1;
                QrHelperFunctions_ZDRM.extractHouseholderRow(this.f2476QT, i2, i3, this.f2475N, this.f2478w, 0);
                int i4 = i2;
                QrHelperFunctions_ZDRM.rank1UpdateMultL(zMatrixRMajCheckIdentity, this.f2478w, 0, this.gammas[i4], i3, i3, this.f2475N);
                i2 = i4 - 1;
            }
        } else {
            int i5 = this.f2475N - 2;
            while (i5 >= 0) {
                int i6 = i5 + 1;
                QrHelperFunctions_ZDRM.extractHouseholderRow(this.f2476QT, i5, i6, this.f2475N, this.f2478w, 0);
                int i7 = i5;
                QrHelperFunctions_ZDRM.rank1UpdateMultR(zMatrixRMajCheckIdentity, this.f2478w, 0, this.gammas[i7], i6, i6, this.f2475N, this.f2477b);
                i5 = i7 - 1;
            }
        }
        return zMatrixRMajCheckIdentity;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(ZMatrixRMaj zMatrixRMaj) {
        init(zMatrixRMaj);
        for (int i = 0; i < this.f2475N - 1; i++) {
            similarTransform(i);
        }
        return true;
    }

    private void similarTransform(int i) {
        double[] dArr = this.f2476QT.data;
        double dComputeRowMax = QrHelperFunctions_ZDRM.computeRowMax(this.f2476QT, i, i + 1, this.f2475N);
        if (dComputeRowMax > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            int i2 = this.f2475N;
            double dComputeTauGammaAndDivide = QrHelperFunctions_ZDRM.computeTauGammaAndDivide((i * i2) + i + 1, (i * i2) + i2, dArr, dComputeRowMax, this.tau);
            this.gammas[i] = dComputeTauGammaAndDivide;
            double d = dArr[((this.f2475N * i) + i + 1) * 2] + this.tau.real;
            double d2 = this.tau.imaginary + dArr[(((this.f2475N * i) + i + 1) * 2) + 1];
            int i3 = i + 2;
            int i4 = this.f2475N;
            QrHelperFunctions_ZDRM.divideElements(i3, i4, dArr, i * i4, d, d2);
            while (true) {
                int i5 = this.f2475N;
                if (i3 < i5) {
                    dArr[(((i * i5) + i3) * 2) + 1] = -dArr[(((i5 * i) + i3) * 2) + 1];
                    i3++;
                } else {
                    dArr[((i * i5) + i + 1) * 2] = 1.0d;
                    dArr[(((i5 * i) + i + 1) * 2) + 1] = 0.0d;
                    householderSymmetric(i, dComputeTauGammaAndDivide);
                    dArr[((this.f2475N * i) + i + 1) * 2] = (-this.tau.real) * dComputeRowMax;
                    dArr[(((this.f2475N * i) + i + 1) * 2) + 1] = (-this.tau.imaginary) * dComputeRowMax;
                    return;
                }
            }
        } else {
            this.gammas[i] = 0.0d;
        }
    }

    public void householderSymmetric(int i, double d) {
        double d2;
        int i2 = this.f2475N * i;
        int i3 = i + 1;
        int i4 = i3;
        while (true) {
            int i5 = this.f2475N;
            d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (i4 >= i5) {
                break;
            }
            double d3 = 0.0d;
            for (int i6 = i3; i6 < i4; i6++) {
                double d4 = this.f2476QT.data[((this.f2475N * i6) + i4) * 2];
                double d5 = -this.f2476QT.data[(((this.f2475N * i6) + i4) * 2) + 1];
                int i7 = (i2 + i6) * 2;
                double d6 = this.f2476QT.data[i7];
                double d7 = this.f2476QT.data[i7 + 1];
                d2 += (d4 * d6) - (d5 * d7);
                d3 += (d4 * d7) + (d5 * d6);
            }
            for (int i8 = i4; i8 < this.f2475N; i8++) {
                double d8 = this.f2476QT.data[((this.f2475N * i4) + i8) * 2];
                double d9 = this.f2476QT.data[(((this.f2475N * i4) + i8) * 2) + 1];
                int i9 = (i2 + i8) * 2;
                double d10 = this.f2476QT.data[i9];
                double d11 = this.f2476QT.data[i9 + 1];
                d2 += (d8 * d10) - (d9 * d11);
                d3 += (d8 * d11) + (d9 * d10);
            }
            double[] dArr = this.f2478w;
            int i10 = i4 * 2;
            double d12 = -d;
            dArr[i10] = d2 * d12;
            dArr[i10 + 1] = d12 * d3;
            i4++;
        }
        double d13 = 0.0d;
        for (int i11 = i3; i11 < this.f2475N; i11++) {
            int i12 = (i2 + i11) * 2;
            double d14 = this.f2476QT.data[i12];
            double d15 = -this.f2476QT.data[i12 + 1];
            double[] dArr2 = this.f2478w;
            int i13 = i11 * 2;
            double d16 = dArr2[i13];
            double d17 = dArr2[i13 + 1];
            d2 += (d14 * d16) - (d15 * d17);
            d13 += (d14 * d17) + (d15 * d16);
        }
        double d18 = d * (-0.5d);
        double d19 = d2 * d18;
        double d20 = d13 * d18;
        for (int i14 = i3; i14 < this.f2475N; i14++) {
            int i15 = (i2 + i14) * 2;
            double d21 = this.f2476QT.data[i15];
            double d22 = this.f2476QT.data[i15 + 1];
            double[] dArr3 = this.f2478w;
            int i16 = i14 * 2;
            dArr3[i16] = dArr3[i16] + ((d19 * d21) - (d20 * d22));
            int i17 = i16 + 1;
            dArr3[i17] = dArr3[i17] + (d22 * d19) + (d21 * d20);
        }
        while (i3 < this.f2475N) {
            double[] dArr4 = this.f2478w;
            int i18 = i3 * 2;
            double d23 = dArr4[i18];
            double d24 = dArr4[i18 + 1];
            int i19 = (i2 + i3) * 2;
            double d25 = this.f2476QT.data[i19];
            double d26 = this.f2476QT.data[i19 + 1];
            int i20 = ((this.f2475N * i3) + i3) * 2;
            int i21 = i3;
            while (i21 < this.f2475N) {
                int i22 = (i2 + i21) * 2;
                double d27 = this.f2476QT.data[i22];
                int i23 = i20;
                int i24 = i21;
                double d28 = -this.f2476QT.data[i22 + 1];
                double[] dArr5 = this.f2478w;
                int i25 = i24 * 2;
                double d29 = dArr5[i25];
                double d30 = -dArr5[i25 + 1];
                double[] dArr6 = this.f2476QT.data;
                int i26 = i23 + 1;
                dArr6[i23] = dArr6[i23] + ((((d23 * d27) - (d24 * d28)) + (d29 * d25)) - (d30 * d26));
                double[] dArr7 = this.f2476QT.data;
                dArr7[i26] = dArr7[i26] + (d28 * d23) + (d27 * d24) + (d29 * d26) + (d30 * d25);
                i21 = i24 + 1;
                i20 = i23 + 2;
            }
            i3++;
        }
    }

    public void init(ZMatrixRMaj zMatrixRMaj) {
        if (zMatrixRMaj.numRows != zMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Must be square");
        }
        if (zMatrixRMaj.numCols != this.f2475N) {
            int i = zMatrixRMaj.numCols;
            this.f2475N = i;
            if (this.f2478w.length < i) {
                this.f2478w = new double[i * 2];
                this.gammas = new double[i * 2];
                this.f2477b = new double[i * 2];
            }
        }
        this.f2476QT = zMatrixRMaj;
    }

    public double[] getGammas() {
        return this.gammas;
    }
}
