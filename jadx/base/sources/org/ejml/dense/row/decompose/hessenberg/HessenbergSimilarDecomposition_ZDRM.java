package org.ejml.dense.row.decompose.hessenberg;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import org.ejml.data.Complex_F64;
import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.decompose.UtilDecompositons_ZDRM;
import org.ejml.dense.row.decompose.p048qr.QrHelperFunctions_ZDRM;
import org.ejml.interfaces.decomposition.DecompositionInterface;

/* JADX INFO: loaded from: classes9.dex */
public class HessenbergSimilarDecomposition_ZDRM implements DecompositionInterface<ZMatrixRMaj> {

    /* JADX INFO: renamed from: N */
    private int f2467N;

    /* JADX INFO: renamed from: QH */
    private ZMatrixRMaj f2468QH;

    /* JADX INFO: renamed from: b */
    private double[] f2469b;
    private double[] gammas;
    private Complex_F64 tau;

    /* JADX INFO: renamed from: u */
    private double[] f2470u;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return true;
    }

    public HessenbergSimilarDecomposition_ZDRM(int i) {
        this.tau = new Complex_F64();
        this.gammas = new double[i];
        int i2 = i * 2;
        this.f2469b = new double[i2];
        this.f2470u = new double[i2];
    }

    public HessenbergSimilarDecomposition_ZDRM() {
        this(5);
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(ZMatrixRMaj zMatrixRMaj) {
        if (zMatrixRMaj.numRows != zMatrixRMaj.numCols) {
            throw new IllegalArgumentException("A must be square.");
        }
        if (zMatrixRMaj.numRows <= 0) {
            return false;
        }
        this.f2468QH = zMatrixRMaj;
        int i = zMatrixRMaj.numCols;
        this.f2467N = i;
        if (this.f2469b.length < i * 2) {
            this.f2469b = new double[i * 2];
            this.gammas = new double[i];
            this.f2470u = new double[i * 2];
        }
        return _decompose();
    }

    public ZMatrixRMaj getQH() {
        return this.f2468QH;
    }

    public ZMatrixRMaj getH(ZMatrixRMaj zMatrixRMaj) {
        int i = this.f2467N;
        ZMatrixRMaj zMatrixRMajCheckZeros = UtilDecompositons_ZDRM.checkZeros(zMatrixRMaj, i, i);
        System.arraycopy(this.f2468QH.data, 0, zMatrixRMajCheckZeros.data, 0, this.f2467N * 2);
        for (int i2 = 1; i2 < this.f2467N; i2++) {
            double[] dArr = this.f2468QH.data;
            int i3 = (((this.f2467N * i2) + i2) - 1) * 2;
            double[] dArr2 = zMatrixRMajCheckZeros.data;
            int i4 = this.f2467N;
            System.arraycopy(dArr, i3, dArr2, (((i2 * i4) + i2) - 1) * 2, ((i4 - i2) + 1) * 2);
        }
        return zMatrixRMajCheckZeros;
    }

    public ZMatrixRMaj getQ(ZMatrixRMaj zMatrixRMaj) {
        int i = this.f2467N;
        ZMatrixRMaj zMatrixRMajCheckIdentity = UtilDecompositons_ZDRM.checkIdentity(zMatrixRMaj, i, i);
        Arrays.fill(this.f2470u, 0, this.f2467N * 2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        int i2 = this.f2467N - 2;
        while (i2 >= 0) {
            int i3 = i2 + 1;
            QrHelperFunctions_ZDRM.extractHouseholderColumn(this.f2468QH, i3, this.f2467N, i2, this.f2470u, 0);
            int i4 = i2;
            QrHelperFunctions_ZDRM.rank1UpdateMultR(zMatrixRMajCheckIdentity, this.f2470u, 0, this.gammas[i4], i3, i3, this.f2467N, this.f2469b);
            i2 = i4 - 1;
        }
        return zMatrixRMajCheckIdentity;
    }

    private boolean _decompose() {
        int i;
        double[] dArr = this.f2468QH.data;
        int i2 = 0;
        while (true) {
            int i3 = this.f2467N;
            if (i2 >= i3 - 2) {
                return true;
            }
            double[] dArr2 = this.f2470u;
            int i4 = i2 * 2;
            dArr2[i4] = 0.0d;
            dArr2[i4 + 1] = 0.0d;
            int i5 = i2 + 1;
            double dExtractColumnAndMax = QrHelperFunctions_ZDRM.extractColumnAndMax(this.f2468QH, i5, i3, i2, dArr2, 0);
            if (dExtractColumnAndMax > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double dComputeTauGammaAndDivide = QrHelperFunctions_ZDRM.computeTauGammaAndDivide(i5, this.f2467N, this.f2470u, dExtractColumnAndMax, this.tau);
                this.gammas[i2] = dComputeTauGammaAndDivide;
                int i6 = i5 * 2;
                int i7 = i6 + 1;
                int i8 = i2 + 2;
                QrHelperFunctions_ZDRM.divideElements(i8, this.f2467N, this.f2470u, 0, this.f2470u[i6] + this.tau.real, this.f2470u[i7] + this.tau.imaginary);
                int i9 = i8;
                while (true) {
                    i = this.f2467N;
                    if (i9 >= i) {
                        break;
                    }
                    double[] dArr3 = this.f2470u;
                    int i10 = i9 * 2;
                    dArr[((i9 * i) + i2) * 2] = dArr3[i10];
                    dArr[(((i * i9) + i2) * 2) + 1] = dArr3[i10 + 1];
                    i9++;
                }
                double[] dArr4 = this.f2470u;
                dArr4[i6] = 1.0d;
                dArr4[i7] = 0.0d;
                QrHelperFunctions_ZDRM.rank1UpdateMultR(this.f2468QH, dArr4, 0, dComputeTauGammaAndDivide, i5, i5, i, this.f2469b);
                QrHelperFunctions_ZDRM.rank1UpdateMultL(this.f2468QH, this.f2470u, 0, dComputeTauGammaAndDivide, 0, i5, this.f2467N);
                i5 = i5;
                dArr[((this.f2467N * i5) + i2) * 2] = (-this.tau.real) * dExtractColumnAndMax;
                dArr[(((this.f2467N * i5) + i2) * 2) + 1] = (-this.tau.imaginary) * dExtractColumnAndMax;
            } else {
                this.gammas[i2] = 0.0d;
            }
            i2 = i5;
        }
    }

    public double[] getGammas() {
        return this.gammas;
    }
}
