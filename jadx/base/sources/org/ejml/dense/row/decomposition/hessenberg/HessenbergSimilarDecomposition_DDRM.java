package org.ejml.dense.row.decomposition.hessenberg;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.decomposition.UtilDecompositons_DDRM;
import org.ejml.dense.row.decomposition.p050qr.QrHelperFunctions_DDRM;
import org.ejml.interfaces.decomposition.DecompositionInterface;

/* JADX INFO: loaded from: classes9.dex */
public class HessenbergSimilarDecomposition_DDRM implements DecompositionInterface<DMatrixRMaj> {

    /* JADX INFO: renamed from: N */
    private int f2589N;

    /* JADX INFO: renamed from: QH */
    private DMatrixRMaj f2590QH;

    /* JADX INFO: renamed from: b */
    private double[] f2591b;
    private double[] gammas;

    /* JADX INFO: renamed from: u */
    private double[] f2592u;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return true;
    }

    public HessenbergSimilarDecomposition_DDRM(int i) {
        this.gammas = new double[i];
        this.f2591b = new double[i];
        this.f2592u = new double[i];
    }

    public HessenbergSimilarDecomposition_DDRM() {
        this(5);
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj.numRows != dMatrixRMaj.numCols) {
            throw new IllegalArgumentException("A must be square.");
        }
        if (dMatrixRMaj.numRows <= 0) {
            return false;
        }
        this.f2590QH = dMatrixRMaj;
        int i = dMatrixRMaj.numCols;
        this.f2589N = i;
        if (this.f2591b.length < i) {
            this.f2591b = new double[i];
            this.gammas = new double[i];
            this.f2592u = new double[i];
        }
        return _decompose();
    }

    public DMatrixRMaj getQH() {
        return this.f2590QH;
    }

    public DMatrixRMaj getH(DMatrixRMaj dMatrixRMaj) {
        int i = this.f2589N;
        DMatrixRMaj dMatrixRMajCheckZeros = UtilDecompositons_DDRM.checkZeros(dMatrixRMaj, i, i);
        System.arraycopy(this.f2590QH.data, 0, dMatrixRMajCheckZeros.data, 0, this.f2589N);
        for (int i2 = 1; i2 < this.f2589N; i2++) {
            for (int i3 = i2 - 1; i3 < this.f2589N; i3++) {
                dMatrixRMajCheckZeros.set(i2, i3, this.f2590QH.get(i2, i3));
            }
        }
        return dMatrixRMajCheckZeros;
    }

    public DMatrixRMaj getQ(DMatrixRMaj dMatrixRMaj) {
        int i;
        int i2 = this.f2589N;
        DMatrixRMaj dMatrixRMajCheckIdentity = UtilDecompositons_DDRM.checkIdentity(dMatrixRMaj, i2, i2);
        for (int i3 = this.f2589N - 2; i3 >= 0; i3--) {
            int i4 = i3 + 1;
            this.f2592u[i4] = 1.0d;
            int i5 = i3 + 2;
            while (true) {
                i = this.f2589N;
                if (i5 < i) {
                    this.f2592u[i5] = this.f2590QH.get(i5, i3);
                    i5++;
                }
            }
            QrHelperFunctions_DDRM.rank1UpdateMultR(dMatrixRMajCheckIdentity, this.f2592u, this.gammas[i3], i4, i4, i, this.f2591b);
        }
        return dMatrixRMajCheckIdentity;
    }

    private boolean _decompose() {
        int i;
        double[] dArr = this.f2590QH.data;
        int i2 = 0;
        while (i2 < this.f2589N - 2) {
            int i3 = i2 + 1;
            double d = 0.0d;
            int i4 = i3;
            while (true) {
                int i5 = this.f2589N;
                if (i4 >= i5) {
                    break;
                }
                double[] dArr2 = this.f2592u;
                double d2 = dArr[(i5 * i4) + i2];
                dArr2[i4] = d2;
                double dAbs = Math.abs(d2);
                if (dAbs > d) {
                    d = dAbs;
                }
                i4++;
            }
            if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double d3 = 0.0d;
                for (int i6 = i3; i6 < this.f2589N; i6++) {
                    double[] dArr3 = this.f2592u;
                    double d4 = dArr3[i6] / d;
                    dArr3[i6] = d4;
                    d3 += d4 * d4;
                }
                double dSqrt = Math.sqrt(d3);
                double[] dArr4 = this.f2592u;
                double d5 = dArr4[i3];
                if (d5 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    dSqrt = -dSqrt;
                }
                double d6 = dSqrt;
                double d7 = d5 + d6;
                dArr4[i3] = 1.0d;
                int i7 = i2 + 2;
                while (true) {
                    i = this.f2589N;
                    if (i7 >= i) {
                        break;
                    }
                    double[] dArr5 = this.f2592u;
                    double d8 = dArr5[i7] / d7;
                    dArr5[i7] = d8;
                    dArr[(i * i7) + i2] = d8;
                    i7++;
                }
                double d9 = d7 / d6;
                this.gammas[i2] = d9;
                QrHelperFunctions_DDRM.rank1UpdateMultR(this.f2590QH, this.f2592u, d9, i3, i3, i, this.f2591b);
                QrHelperFunctions_DDRM.rank1UpdateMultL(this.f2590QH, this.f2592u, d9, 0, i3, this.f2589N);
                i3 = i3;
                dArr[(this.f2589N * i3) + i2] = (-d6) * d;
            } else {
                this.gammas[i2] = 0.0d;
            }
            i2 = i3;
        }
        return true;
    }

    public double[] getGammas() {
        return this.gammas;
    }
}
