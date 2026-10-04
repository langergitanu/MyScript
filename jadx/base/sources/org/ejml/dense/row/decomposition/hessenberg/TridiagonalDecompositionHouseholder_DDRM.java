package org.ejml.dense.row.decomposition.hessenberg;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.decomposition.UtilDecompositons_DDRM;
import org.ejml.dense.row.decomposition.p050qr.QrHelperFunctions_DDRM;
import org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class TridiagonalDecompositionHouseholder_DDRM implements TridiagonalSimilarDecomposition_F64<DMatrixRMaj> {

    /* JADX INFO: renamed from: QT */
    private DMatrixRMaj f2606QT;

    /* JADX INFO: renamed from: N */
    private int f2605N = 1;

    /* JADX INFO: renamed from: w */
    private double[] f2608w = new double[1];

    /* JADX INFO: renamed from: b */
    private double[] f2607b = new double[1];
    private double[] gammas = new double[1];

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return true;
    }

    public DMatrixRMaj getQT() {
        return this.f2606QT;
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F64
    public void getDiagonal(double[] dArr, double[] dArr2) {
        int i = 0;
        while (i < this.f2605N) {
            double[] dArr3 = this.f2606QT.data;
            int i2 = this.f2605N;
            dArr[i] = dArr3[(i * i2) + i];
            int i3 = i + 1;
            if (i3 < i2) {
                dArr2[i] = this.f2606QT.data[(this.f2605N * i) + i + 1];
            }
            i = i3;
        }
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition
    public DMatrixRMaj getT(DMatrixRMaj dMatrixRMaj) {
        int i;
        int i2 = this.f2605N;
        DMatrixRMaj dMatrixRMajCheckZeros = UtilDecompositons_DDRM.checkZeros(dMatrixRMaj, i2, i2);
        dMatrixRMajCheckZeros.data[0] = this.f2606QT.data[0];
        int i3 = 1;
        while (true) {
            i = this.f2605N;
            if (i3 >= i) {
                break;
            }
            dMatrixRMajCheckZeros.set(i3, i3, this.f2606QT.get(i3, i3));
            int i4 = i3 - 1;
            double d = this.f2606QT.get(i4, i3);
            dMatrixRMajCheckZeros.set(i4, i3, d);
            dMatrixRMajCheckZeros.set(i3, i4, d);
            i3++;
        }
        if (i > 1) {
            double[] dArr = dMatrixRMajCheckZeros.data;
            int i5 = this.f2605N;
            int i6 = (((i5 - 1) * i5) + i5) - 1;
            double[] dArr2 = this.f2606QT.data;
            int i7 = this.f2605N;
            dArr[i6] = dArr2[(((i7 - 1) * i7) + i7) - 1];
            double[] dArr3 = dMatrixRMajCheckZeros.data;
            int i8 = this.f2605N;
            int i9 = (((i8 - 1) * i8) + i8) - 2;
            double[] dArr4 = this.f2606QT.data;
            int i10 = this.f2605N;
            dArr3[i9] = dArr4[(((i10 - 2) * i10) + i10) - 1];
        }
        return dMatrixRMajCheckZeros;
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition
    public DMatrixRMaj getQ(DMatrixRMaj dMatrixRMaj, boolean z) {
        int i;
        int i2;
        int i3;
        int i4 = this.f2605N;
        DMatrixRMaj dMatrixRMajCheckIdentity = UtilDecompositons_DDRM.checkIdentity(dMatrixRMaj, i4, i4);
        int i5 = 0;
        while (true) {
            i = this.f2605N;
            if (i5 >= i) {
                break;
            }
            this.f2608w[i5] = 0.0d;
            i5++;
        }
        if (z) {
            for (int i6 = i - 2; i6 >= 0; i6--) {
                int i7 = i6 + 1;
                this.f2608w[i7] = 1.0d;
                int i8 = i6 + 2;
                while (true) {
                    i3 = this.f2605N;
                    if (i8 < i3) {
                        this.f2608w[i8] = this.f2606QT.data[(this.f2605N * i6) + i8];
                        i8++;
                    }
                }
                QrHelperFunctions_DDRM.rank1UpdateMultL(dMatrixRMajCheckIdentity, this.f2608w, this.gammas[i7], i7, i7, i3);
            }
        } else {
            for (int i9 = i - 2; i9 >= 0; i9--) {
                int i10 = i9 + 1;
                this.f2608w[i10] = 1.0d;
                int i11 = i9 + 2;
                while (true) {
                    i2 = this.f2605N;
                    if (i11 < i2) {
                        this.f2608w[i11] = this.f2606QT.get(i9, i11);
                        i11++;
                    }
                }
                QrHelperFunctions_DDRM.rank1UpdateMultR(dMatrixRMajCheckIdentity, this.f2608w, this.gammas[i10], i10, i10, i2, this.f2607b);
            }
        }
        return dMatrixRMajCheckIdentity;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixRMaj dMatrixRMaj) {
        init(dMatrixRMaj);
        for (int i = 1; i < this.f2605N; i++) {
            similarTransform(i);
        }
        return true;
    }

    private void similarTransform(int i) {
        int i2;
        double[] dArr = this.f2606QT.data;
        int i3 = (i - 1) * this.f2605N;
        int i4 = i;
        double d = 0.0d;
        while (true) {
            i2 = this.f2605N;
            if (i4 >= i2) {
                break;
            }
            double dAbs = Math.abs(dArr[i3 + i4]);
            if (dAbs > d) {
                d = dAbs;
            }
            i4++;
        }
        if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            double dComputeTauAndDivide = QrHelperFunctions_DDRM.computeTauAndDivide(i, i2, dArr, i3, d);
            double d2 = d;
            int i5 = i3 + i;
            double d3 = dArr[i5] + dComputeTauAndDivide;
            QrHelperFunctions_DDRM.divideElements(i + 1, this.f2605N, dArr, i3, d3);
            dArr[i5] = 1.0d;
            double d4 = d3 / dComputeTauAndDivide;
            this.gammas[i] = d4;
            householderSymmetric(i, d4);
            dArr[i5] = (-dComputeTauAndDivide) * d2;
            return;
        }
        this.gammas[i] = 0.0d;
    }

    public void householderSymmetric(int i, double d) {
        double d2;
        int i2 = (i - 1) * this.f2605N;
        int i3 = i;
        while (true) {
            int i4 = this.f2605N;
            d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (i3 >= i4) {
                break;
            }
            for (int i5 = i; i5 < i3; i5++) {
                d2 += this.f2606QT.data[(this.f2605N * i5) + i3] * this.f2606QT.data[i2 + i5];
            }
            for (int i6 = i3; i6 < this.f2605N; i6++) {
                d2 += this.f2606QT.data[(this.f2605N * i3) + i6] * this.f2606QT.data[i2 + i6];
            }
            this.f2608w[i3] = (-d) * d2;
            i3++;
        }
        for (int i7 = i; i7 < this.f2605N; i7++) {
            d2 += this.f2606QT.data[i2 + i7] * this.f2608w[i7];
        }
        double d3 = d2 * d * (-0.5d);
        for (int i8 = i; i8 < this.f2605N; i8++) {
            double[] dArr = this.f2608w;
            dArr[i8] = dArr[i8] + (this.f2606QT.data[i2 + i8] * d3);
        }
        for (int i9 = i; i9 < this.f2605N; i9++) {
            double d4 = this.f2608w[i9];
            double d5 = this.f2606QT.data[i2 + i9];
            int i10 = this.f2605N * i9;
            for (int i11 = i9; i11 < this.f2605N; i11++) {
                double[] dArr2 = this.f2606QT.data;
                int i12 = i10 + i11;
                dArr2[i12] = dArr2[i12] + (this.f2606QT.data[i2 + i11] * d4) + (this.f2608w[i11] * d5);
            }
        }
    }

    public void init(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj.numRows != dMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Must be square");
        }
        if (dMatrixRMaj.numCols != this.f2605N) {
            int i = dMatrixRMaj.numCols;
            this.f2605N = i;
            if (this.f2608w.length < i) {
                this.f2608w = new double[i];
                this.gammas = new double[i];
                this.f2607b = new double[i];
            }
        }
        this.f2606QT = dMatrixRMaj;
    }
}
