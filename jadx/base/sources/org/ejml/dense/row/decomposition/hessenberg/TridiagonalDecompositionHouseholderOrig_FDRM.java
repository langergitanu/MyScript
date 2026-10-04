package org.ejml.dense.row.decomposition.hessenberg;

import org.ejml.data.FMatrixD1;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.decomposition.UtilDecompositons_FDRM;
import org.ejml.dense.row.decomposition.p050qr.QrHelperFunctions_FDRM;

/* JADX INFO: loaded from: classes9.dex */
public class TridiagonalDecompositionHouseholderOrig_FDRM {

    /* JADX INFO: renamed from: N */
    int f2601N = 1;

    /* JADX INFO: renamed from: QT */
    FMatrixRMaj f2602QT;

    /* JADX INFO: renamed from: b */
    float[] f2603b;
    float[] gammas;

    /* JADX INFO: renamed from: w */
    float[] f2604w;

    public TridiagonalDecompositionHouseholderOrig_FDRM() {
        int i = this.f2601N;
        this.f2602QT = new FMatrixRMaj(i, i);
        int i2 = this.f2601N;
        this.f2604w = new float[i2];
        this.f2603b = new float[i2];
        this.gammas = new float[i2];
    }

    public FMatrixRMaj getQT() {
        return this.f2602QT;
    }

    public FMatrixRMaj getT(FMatrixRMaj fMatrixRMaj) {
        int i = this.f2601N;
        FMatrixRMaj fMatrixRMajCheckZeros = UtilDecompositons_FDRM.checkZeros(fMatrixRMaj, i, i);
        fMatrixRMajCheckZeros.data[0] = this.f2602QT.data[0];
        fMatrixRMajCheckZeros.data[1] = this.f2602QT.data[1];
        int i2 = 1;
        while (i2 < this.f2601N - 1) {
            fMatrixRMajCheckZeros.set(i2, i2, this.f2602QT.get(i2, i2));
            int i3 = i2 + 1;
            fMatrixRMajCheckZeros.set(i2, i3, this.f2602QT.get(i2, i3));
            int i4 = i2 - 1;
            fMatrixRMajCheckZeros.set(i2, i4, this.f2602QT.get(i4, i2));
            i2 = i3;
        }
        float[] fArr = fMatrixRMajCheckZeros.data;
        int i5 = this.f2601N;
        int i6 = (((i5 - 1) * i5) + i5) - 1;
        float[] fArr2 = this.f2602QT.data;
        int i7 = this.f2601N;
        fArr[i6] = fArr2[(((i7 - 1) * i7) + i7) - 1];
        float[] fArr3 = fMatrixRMajCheckZeros.data;
        int i8 = this.f2601N;
        int i9 = (((i8 - 1) * i8) + i8) - 2;
        float[] fArr4 = this.f2602QT.data;
        int i10 = this.f2601N;
        fArr3[i9] = fArr4[(((i10 - 2) * i10) + i10) - 1];
        return fMatrixRMajCheckZeros;
    }

    public FMatrixRMaj getQ(FMatrixRMaj fMatrixRMaj) {
        int i;
        int i2;
        int i3 = this.f2601N;
        FMatrixRMaj fMatrixRMajCheckIdentity = UtilDecompositons_FDRM.checkIdentity(fMatrixRMaj, i3, i3);
        int i4 = 0;
        while (true) {
            i = this.f2601N;
            if (i4 >= i) {
                break;
            }
            this.f2604w[i4] = 0.0f;
            i4++;
        }
        for (int i5 = i - 2; i5 >= 0; i5--) {
            int i6 = i5 + 1;
            this.f2604w[i6] = 1.0f;
            int i7 = i5 + 2;
            while (true) {
                i2 = this.f2601N;
                if (i7 < i2) {
                    this.f2604w[i7] = this.f2602QT.get(i5, i7);
                    i7++;
                }
            }
            QrHelperFunctions_FDRM.rank1UpdateMultR(fMatrixRMajCheckIdentity, this.f2604w, this.gammas[i6], i6, i6, i2, this.f2603b);
        }
        return fMatrixRMajCheckIdentity;
    }

    public void decompose(FMatrixRMaj fMatrixRMaj) {
        init(fMatrixRMaj);
        for (int i = 1; i < this.f2601N; i++) {
            similarTransform(i);
        }
    }

    private void similarTransform(int i) {
        float[] fArr = this.f2602QT.data;
        int i2 = (i - 1) * this.f2601N;
        float f = 0.0f;
        for (int i3 = i; i3 < this.f2601N; i3++) {
            float fAbs = Math.abs(fArr[i2 + i3]);
            if (fAbs > f) {
                f = fAbs;
            }
        }
        if (f > 0.0f) {
            float f2 = 0.0f;
            for (int i4 = i; i4 < this.f2601N; i4++) {
                int i5 = i2 + i4;
                float f3 = fArr[i5] / f;
                fArr[i5] = f3;
                f2 += f3 * f3;
            }
            float fSqrt = (float) Math.sqrt(f2);
            int i6 = i2 + i;
            float f4 = fArr[i6];
            if (f4 < 0.0f) {
                fSqrt = -fSqrt;
            }
            float f5 = f4 + fSqrt;
            fArr[i6] = 1.0f;
            for (int i7 = i + 1; i7 < this.f2601N; i7++) {
                int i8 = i2 + i7;
                fArr[i8] = fArr[i8] / f5;
            }
            float f6 = f5 / fSqrt;
            this.gammas[i] = f6;
            householderSymmetric(i, f6);
            fArr[i6] = (-fSqrt) * f;
            return;
        }
        this.gammas[i] = 0.0f;
    }

    public void householderSymmetric(int i, float f) {
        float f2;
        int i2 = (i - 1) * this.f2601N;
        int i3 = i;
        while (true) {
            f2 = 0.0f;
            if (i3 >= this.f2601N) {
                break;
            }
            for (int i4 = i; i4 < this.f2601N; i4++) {
                f2 += this.f2602QT.data[(this.f2601N * i3) + i4] * this.f2602QT.data[i2 + i4];
            }
            this.f2604w[i3] = (-f) * f2;
            i3++;
        }
        for (int i5 = i; i5 < this.f2601N; i5++) {
            f2 += this.f2602QT.data[i2 + i5] * this.f2604w[i5];
        }
        float f3 = f2 * f * (-0.5f);
        for (int i6 = i; i6 < this.f2601N; i6++) {
            float[] fArr = this.f2604w;
            fArr[i6] = fArr[i6] + (this.f2602QT.data[i2 + i6] * f3);
        }
        while (i < this.f2601N) {
            float f4 = this.f2604w[i];
            float f5 = this.f2602QT.data[i2 + i];
            for (int i7 = i; i7 < this.f2601N; i7++) {
                float[] fArr2 = this.f2602QT.data;
                int i8 = (this.f2601N * i7) + i;
                float[] fArr3 = this.f2602QT.data;
                int i9 = (this.f2601N * i) + i7;
                float f6 = fArr3[i9] + (this.f2602QT.data[i2 + i7] * f4) + (this.f2604w[i7] * f5);
                fArr3[i9] = f6;
                fArr2[i8] = f6;
            }
            i++;
        }
    }

    public void init(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj.numRows != fMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Must be square");
        }
        if (fMatrixRMaj.numCols != this.f2601N) {
            int i = fMatrixRMaj.numCols;
            this.f2601N = i;
            this.f2602QT.reshape(i, i, false);
            int length = this.f2604w.length;
            int i2 = this.f2601N;
            if (length < i2) {
                this.f2604w = new float[i2];
                this.gammas = new float[i2];
                this.f2603b = new float[i2];
            }
        }
        this.f2602QT.set((FMatrixD1) fMatrixRMaj);
    }

    public float getGamma(int i) {
        return this.gammas[i];
    }
}
