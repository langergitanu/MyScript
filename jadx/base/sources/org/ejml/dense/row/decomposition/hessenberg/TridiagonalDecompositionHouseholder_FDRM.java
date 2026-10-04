package org.ejml.dense.row.decomposition.hessenberg;

import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.decomposition.UtilDecompositons_FDRM;
import org.ejml.dense.row.decomposition.p050qr.QrHelperFunctions_FDRM;
import org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class TridiagonalDecompositionHouseholder_FDRM implements TridiagonalSimilarDecomposition_F32<FMatrixRMaj> {

    /* JADX INFO: renamed from: QT */
    private FMatrixRMaj f2610QT;

    /* JADX INFO: renamed from: N */
    private int f2609N = 1;

    /* JADX INFO: renamed from: w */
    private float[] f2612w = new float[1];

    /* JADX INFO: renamed from: b */
    private float[] f2611b = new float[1];
    private float[] gammas = new float[1];

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return true;
    }

    public FMatrixRMaj getQT() {
        return this.f2610QT;
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F32
    public void getDiagonal(float[] fArr, float[] fArr2) {
        int i = 0;
        while (i < this.f2609N) {
            float[] fArr3 = this.f2610QT.data;
            int i2 = this.f2609N;
            fArr[i] = fArr3[(i * i2) + i];
            int i3 = i + 1;
            if (i3 < i2) {
                fArr2[i] = this.f2610QT.data[(this.f2609N * i) + i + 1];
            }
            i = i3;
        }
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition
    public FMatrixRMaj getT(FMatrixRMaj fMatrixRMaj) {
        int i;
        int i2 = this.f2609N;
        FMatrixRMaj fMatrixRMajCheckZeros = UtilDecompositons_FDRM.checkZeros(fMatrixRMaj, i2, i2);
        fMatrixRMajCheckZeros.data[0] = this.f2610QT.data[0];
        int i3 = 1;
        while (true) {
            i = this.f2609N;
            if (i3 >= i) {
                break;
            }
            fMatrixRMajCheckZeros.set(i3, i3, this.f2610QT.get(i3, i3));
            int i4 = i3 - 1;
            float f = this.f2610QT.get(i4, i3);
            fMatrixRMajCheckZeros.set(i4, i3, f);
            fMatrixRMajCheckZeros.set(i3, i4, f);
            i3++;
        }
        if (i > 1) {
            float[] fArr = fMatrixRMajCheckZeros.data;
            int i5 = this.f2609N;
            int i6 = (((i5 - 1) * i5) + i5) - 1;
            float[] fArr2 = this.f2610QT.data;
            int i7 = this.f2609N;
            fArr[i6] = fArr2[(((i7 - 1) * i7) + i7) - 1];
            float[] fArr3 = fMatrixRMajCheckZeros.data;
            int i8 = this.f2609N;
            int i9 = (((i8 - 1) * i8) + i8) - 2;
            float[] fArr4 = this.f2610QT.data;
            int i10 = this.f2609N;
            fArr3[i9] = fArr4[(((i10 - 2) * i10) + i10) - 1];
        }
        return fMatrixRMajCheckZeros;
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition
    public FMatrixRMaj getQ(FMatrixRMaj fMatrixRMaj, boolean z) {
        int i;
        int i2;
        int i3;
        int i4 = this.f2609N;
        FMatrixRMaj fMatrixRMajCheckIdentity = UtilDecompositons_FDRM.checkIdentity(fMatrixRMaj, i4, i4);
        int i5 = 0;
        while (true) {
            i = this.f2609N;
            if (i5 >= i) {
                break;
            }
            this.f2612w[i5] = 0.0f;
            i5++;
        }
        if (z) {
            for (int i6 = i - 2; i6 >= 0; i6--) {
                int i7 = i6 + 1;
                this.f2612w[i7] = 1.0f;
                int i8 = i6 + 2;
                while (true) {
                    i3 = this.f2609N;
                    if (i8 < i3) {
                        this.f2612w[i8] = this.f2610QT.data[(this.f2609N * i6) + i8];
                        i8++;
                    }
                }
                QrHelperFunctions_FDRM.rank1UpdateMultL(fMatrixRMajCheckIdentity, this.f2612w, this.gammas[i7], i7, i7, i3);
            }
        } else {
            for (int i9 = i - 2; i9 >= 0; i9--) {
                int i10 = i9 + 1;
                this.f2612w[i10] = 1.0f;
                int i11 = i9 + 2;
                while (true) {
                    i2 = this.f2609N;
                    if (i11 < i2) {
                        this.f2612w[i11] = this.f2610QT.get(i9, i11);
                        i11++;
                    }
                }
                QrHelperFunctions_FDRM.rank1UpdateMultR(fMatrixRMajCheckIdentity, this.f2612w, this.gammas[i10], i10, i10, i2, this.f2611b);
            }
        }
        return fMatrixRMajCheckIdentity;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(FMatrixRMaj fMatrixRMaj) {
        init(fMatrixRMaj);
        for (int i = 1; i < this.f2609N; i++) {
            similarTransform(i);
        }
        return true;
    }

    private void similarTransform(int i) {
        int i2;
        float[] fArr = this.f2610QT.data;
        int i3 = (i - 1) * this.f2609N;
        int i4 = i;
        float f = 0.0f;
        while (true) {
            i2 = this.f2609N;
            if (i4 >= i2) {
                break;
            }
            float fAbs = Math.abs(fArr[i3 + i4]);
            if (fAbs > f) {
                f = fAbs;
            }
            i4++;
        }
        if (f > 0.0f) {
            float fComputeTauAndDivide = QrHelperFunctions_FDRM.computeTauAndDivide(i, i2, fArr, i3, f);
            int i5 = i3 + i;
            float f2 = fArr[i5] + fComputeTauAndDivide;
            QrHelperFunctions_FDRM.divideElements(i + 1, this.f2609N, fArr, i3, f2);
            fArr[i5] = 1.0f;
            float f3 = f2 / fComputeTauAndDivide;
            this.gammas[i] = f3;
            householderSymmetric(i, f3);
            fArr[i5] = (-fComputeTauAndDivide) * f;
            return;
        }
        this.gammas[i] = 0.0f;
    }

    public void householderSymmetric(int i, float f) {
        float f2;
        int i2 = (i - 1) * this.f2609N;
        int i3 = i;
        while (true) {
            f2 = 0.0f;
            if (i3 >= this.f2609N) {
                break;
            }
            for (int i4 = i; i4 < i3; i4++) {
                f2 += this.f2610QT.data[(this.f2609N * i4) + i3] * this.f2610QT.data[i2 + i4];
            }
            for (int i5 = i3; i5 < this.f2609N; i5++) {
                f2 += this.f2610QT.data[(this.f2609N * i3) + i5] * this.f2610QT.data[i2 + i5];
            }
            this.f2612w[i3] = (-f) * f2;
            i3++;
        }
        for (int i6 = i; i6 < this.f2609N; i6++) {
            f2 += this.f2610QT.data[i2 + i6] * this.f2612w[i6];
        }
        float f3 = f2 * f * (-0.5f);
        for (int i7 = i; i7 < this.f2609N; i7++) {
            float[] fArr = this.f2612w;
            fArr[i7] = fArr[i7] + (this.f2610QT.data[i2 + i7] * f3);
        }
        while (i < this.f2609N) {
            float f4 = this.f2612w[i];
            float f5 = this.f2610QT.data[i2 + i];
            int i8 = this.f2609N * i;
            for (int i9 = i; i9 < this.f2609N; i9++) {
                float[] fArr2 = this.f2610QT.data;
                int i10 = i8 + i9;
                fArr2[i10] = fArr2[i10] + (this.f2610QT.data[i2 + i9] * f4) + (this.f2612w[i9] * f5);
            }
            i++;
        }
    }

    public void init(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj.numRows != fMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Must be square");
        }
        if (fMatrixRMaj.numCols != this.f2609N) {
            int i = fMatrixRMaj.numCols;
            this.f2609N = i;
            if (this.f2612w.length < i) {
                this.f2612w = new float[i];
                this.gammas = new float[i];
                this.f2611b = new float[i];
            }
        }
        this.f2610QT = fMatrixRMaj;
    }
}
