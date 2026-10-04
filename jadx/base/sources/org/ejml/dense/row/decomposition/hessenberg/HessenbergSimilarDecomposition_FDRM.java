package org.ejml.dense.row.decomposition.hessenberg;

import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.decomposition.UtilDecompositons_FDRM;
import org.ejml.dense.row.decomposition.p050qr.QrHelperFunctions_FDRM;
import org.ejml.interfaces.decomposition.DecompositionInterface;

/* JADX INFO: loaded from: classes9.dex */
public class HessenbergSimilarDecomposition_FDRM implements DecompositionInterface<FMatrixRMaj> {

    /* JADX INFO: renamed from: N */
    private int f2593N;

    /* JADX INFO: renamed from: QH */
    private FMatrixRMaj f2594QH;

    /* JADX INFO: renamed from: b */
    private float[] f2595b;
    private float[] gammas;

    /* JADX INFO: renamed from: u */
    private float[] f2596u;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return true;
    }

    public HessenbergSimilarDecomposition_FDRM(int i) {
        this.gammas = new float[i];
        this.f2595b = new float[i];
        this.f2596u = new float[i];
    }

    public HessenbergSimilarDecomposition_FDRM() {
        this(5);
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj.numRows != fMatrixRMaj.numCols) {
            throw new IllegalArgumentException("A must be square.");
        }
        if (fMatrixRMaj.numRows <= 0) {
            return false;
        }
        this.f2594QH = fMatrixRMaj;
        int i = fMatrixRMaj.numCols;
        this.f2593N = i;
        if (this.f2595b.length < i) {
            this.f2595b = new float[i];
            this.gammas = new float[i];
            this.f2596u = new float[i];
        }
        return _decompose();
    }

    public FMatrixRMaj getQH() {
        return this.f2594QH;
    }

    public FMatrixRMaj getH(FMatrixRMaj fMatrixRMaj) {
        int i = this.f2593N;
        FMatrixRMaj fMatrixRMajCheckZeros = UtilDecompositons_FDRM.checkZeros(fMatrixRMaj, i, i);
        System.arraycopy(this.f2594QH.data, 0, fMatrixRMajCheckZeros.data, 0, this.f2593N);
        for (int i2 = 1; i2 < this.f2593N; i2++) {
            for (int i3 = i2 - 1; i3 < this.f2593N; i3++) {
                fMatrixRMajCheckZeros.set(i2, i3, this.f2594QH.get(i2, i3));
            }
        }
        return fMatrixRMajCheckZeros;
    }

    public FMatrixRMaj getQ(FMatrixRMaj fMatrixRMaj) {
        int i;
        int i2 = this.f2593N;
        FMatrixRMaj fMatrixRMajCheckIdentity = UtilDecompositons_FDRM.checkIdentity(fMatrixRMaj, i2, i2);
        for (int i3 = this.f2593N - 2; i3 >= 0; i3--) {
            int i4 = i3 + 1;
            this.f2596u[i4] = 1.0f;
            int i5 = i3 + 2;
            while (true) {
                i = this.f2593N;
                if (i5 < i) {
                    this.f2596u[i5] = this.f2594QH.get(i5, i3);
                    i5++;
                }
            }
            QrHelperFunctions_FDRM.rank1UpdateMultR(fMatrixRMajCheckIdentity, this.f2596u, this.gammas[i3], i4, i4, i, this.f2595b);
        }
        return fMatrixRMajCheckIdentity;
    }

    private boolean _decompose() {
        int i;
        float[] fArr = this.f2594QH.data;
        int i2 = 0;
        while (i2 < this.f2593N - 2) {
            int i3 = i2 + 1;
            float f = 0.0f;
            int i4 = i3;
            while (true) {
                int i5 = this.f2593N;
                if (i4 >= i5) {
                    break;
                }
                float[] fArr2 = this.f2596u;
                float f2 = fArr[(i5 * i4) + i2];
                fArr2[i4] = f2;
                float fAbs = Math.abs(f2);
                if (fAbs > f) {
                    f = fAbs;
                }
                i4++;
            }
            if (f > 0.0f) {
                float f3 = 0.0f;
                for (int i6 = i3; i6 < this.f2593N; i6++) {
                    float[] fArr3 = this.f2596u;
                    float f4 = fArr3[i6] / f;
                    fArr3[i6] = f4;
                    f3 += f4 * f4;
                }
                float fSqrt = (float) Math.sqrt(f3);
                float[] fArr4 = this.f2596u;
                float f5 = fArr4[i3];
                if (f5 < 0.0f) {
                    fSqrt = -fSqrt;
                }
                float f6 = fSqrt;
                float f7 = f5 + f6;
                fArr4[i3] = 1.0f;
                int i7 = i2 + 2;
                while (true) {
                    i = this.f2593N;
                    if (i7 >= i) {
                        break;
                    }
                    float[] fArr5 = this.f2596u;
                    float f8 = fArr5[i7] / f7;
                    fArr5[i7] = f8;
                    fArr[(i * i7) + i2] = f8;
                    i7++;
                }
                float f9 = f7 / f6;
                this.gammas[i2] = f9;
                QrHelperFunctions_FDRM.rank1UpdateMultR(this.f2594QH, this.f2596u, f9, i3, i3, i, this.f2595b);
                QrHelperFunctions_FDRM.rank1UpdateMultL(this.f2594QH, this.f2596u, f9, 0, i3, this.f2593N);
                i3 = i3;
                fArr[(this.f2593N * i3) + i2] = (-f6) * f;
            } else {
                this.gammas[i2] = 0.0f;
            }
            i2 = i3;
        }
        return true;
    }

    public float[] getGammas() {
        return this.gammas;
    }
}
