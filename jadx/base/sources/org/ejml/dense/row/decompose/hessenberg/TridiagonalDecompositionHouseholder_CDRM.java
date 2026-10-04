package org.ejml.dense.row.decompose.hessenberg;

import java.util.Arrays;
import org.ejml.data.CMatrixRMaj;
import org.ejml.data.Complex_F32;
import org.ejml.dense.row.decompose.UtilDecompositons_CDRM;
import org.ejml.dense.row.decompose.p048qr.QrHelperFunctions_CDRM;
import org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class TridiagonalDecompositionHouseholder_CDRM implements TridiagonalSimilarDecomposition_F32<CMatrixRMaj> {

    /* JADX INFO: renamed from: QT */
    private CMatrixRMaj f2472QT;
    private Complex_F32 tau = new Complex_F32();

    /* JADX INFO: renamed from: N */
    private int f2471N = 1;

    /* JADX INFO: renamed from: w */
    private float[] f2474w = new float[2];

    /* JADX INFO: renamed from: b */
    private float[] f2473b = new float[2];
    private float[] gammas = new float[1];

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return true;
    }

    public CMatrixRMaj getQT() {
        return this.f2472QT;
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F32
    public void getDiagonal(float[] fArr, float[] fArr2) {
        int i = 0;
        while (i < this.f2471N) {
            int i2 = i * 2;
            fArr[i2] = this.f2472QT.data[((this.f2471N * i) + i) * 2];
            int i3 = i2 + 1;
            float[] fArr3 = this.f2472QT.data;
            int i4 = this.f2471N;
            fArr[i3] = fArr3[(((i * i4) + i) * 2) + 1];
            int i5 = i + 1;
            if (i5 < i4) {
                fArr2[i2] = this.f2472QT.data[((this.f2471N * i) + i + 1) * 2];
                fArr2[i3] = this.f2472QT.data[(((this.f2471N * i) + i + 1) * 2) + 1];
            }
            i = i5;
        }
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition
    public CMatrixRMaj getT(CMatrixRMaj cMatrixRMaj) {
        int i = this.f2471N;
        CMatrixRMaj cMatrixRMajCheckZeros = UtilDecompositons_CDRM.checkZeros(cMatrixRMaj, i, i);
        cMatrixRMajCheckZeros.data[0] = this.f2472QT.data[0];
        cMatrixRMajCheckZeros.data[1] = this.f2472QT.data[1];
        for (int i2 = 1; i2 < this.f2471N; i2++) {
            cMatrixRMajCheckZeros.set(i2, i2, this.f2472QT.getReal(i2, i2), this.f2472QT.getImag(i2, i2));
            int i3 = i2 - 1;
            float real = this.f2472QT.getReal(i3, i2);
            float imag = this.f2472QT.getImag(i3, i2);
            cMatrixRMajCheckZeros.set(i3, i2, real, imag);
            cMatrixRMajCheckZeros.set(i2, i3, real, -imag);
        }
        return cMatrixRMajCheckZeros;
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition
    public CMatrixRMaj getQ(CMatrixRMaj cMatrixRMaj, boolean z) {
        int i = this.f2471N;
        CMatrixRMaj cMatrixRMajCheckIdentity = UtilDecompositons_CDRM.checkIdentity(cMatrixRMaj, i, i);
        Arrays.fill(this.f2474w, 0, this.f2471N * 2, 0.0f);
        if (z) {
            int i2 = this.f2471N - 2;
            while (i2 >= 0) {
                int i3 = i2 + 1;
                QrHelperFunctions_CDRM.extractHouseholderRow(this.f2472QT, i2, i3, this.f2471N, this.f2474w, 0);
                int i4 = i2;
                QrHelperFunctions_CDRM.rank1UpdateMultL(cMatrixRMajCheckIdentity, this.f2474w, 0, this.gammas[i4], i3, i3, this.f2471N);
                i2 = i4 - 1;
            }
        } else {
            int i5 = this.f2471N - 2;
            while (i5 >= 0) {
                int i6 = i5 + 1;
                QrHelperFunctions_CDRM.extractHouseholderRow(this.f2472QT, i5, i6, this.f2471N, this.f2474w, 0);
                int i7 = i5;
                QrHelperFunctions_CDRM.rank1UpdateMultR(cMatrixRMajCheckIdentity, this.f2474w, 0, this.gammas[i7], i6, i6, this.f2471N, this.f2473b);
                i5 = i7 - 1;
            }
        }
        return cMatrixRMajCheckIdentity;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(CMatrixRMaj cMatrixRMaj) {
        init(cMatrixRMaj);
        for (int i = 0; i < this.f2471N - 1; i++) {
            similarTransform(i);
        }
        return true;
    }

    private void similarTransform(int i) {
        float[] fArr = this.f2472QT.data;
        float fComputeRowMax = QrHelperFunctions_CDRM.computeRowMax(this.f2472QT, i, i + 1, this.f2471N);
        if (fComputeRowMax > 0.0f) {
            int i2 = this.f2471N;
            float fComputeTauGammaAndDivide = QrHelperFunctions_CDRM.computeTauGammaAndDivide((i * i2) + i + 1, (i * i2) + i2, fArr, fComputeRowMax, this.tau);
            this.gammas[i] = fComputeTauGammaAndDivide;
            float f = fArr[((this.f2471N * i) + i + 1) * 2] + this.tau.real;
            float f2 = fArr[(((this.f2471N * i) + i + 1) * 2) + 1] + this.tau.imaginary;
            int i3 = i + 2;
            int i4 = this.f2471N;
            QrHelperFunctions_CDRM.divideElements(i3, i4, fArr, i * i4, f, f2);
            while (true) {
                int i5 = this.f2471N;
                if (i3 < i5) {
                    fArr[(((i * i5) + i3) * 2) + 1] = -fArr[(((i5 * i) + i3) * 2) + 1];
                    i3++;
                } else {
                    fArr[((i * i5) + i + 1) * 2] = 1.0f;
                    fArr[(((i5 * i) + i + 1) * 2) + 1] = 0.0f;
                    householderSymmetric(i, fComputeTauGammaAndDivide);
                    fArr[((this.f2471N * i) + i + 1) * 2] = (-this.tau.real) * fComputeRowMax;
                    fArr[(((this.f2471N * i) + i + 1) * 2) + 1] = (-this.tau.imaginary) * fComputeRowMax;
                    return;
                }
            }
        } else {
            this.gammas[i] = 0.0f;
        }
    }

    public void householderSymmetric(int i, float f) {
        float f2;
        int i2 = this.f2471N * i;
        int i3 = i + 1;
        int i4 = i3;
        while (true) {
            f2 = 0.0f;
            if (i4 >= this.f2471N) {
                break;
            }
            float f3 = 0.0f;
            for (int i5 = i3; i5 < i4; i5++) {
                float f4 = this.f2472QT.data[((this.f2471N * i5) + i4) * 2];
                float f5 = -this.f2472QT.data[(((this.f2471N * i5) + i4) * 2) + 1];
                int i6 = (i2 + i5) * 2;
                float f6 = this.f2472QT.data[i6];
                float f7 = this.f2472QT.data[i6 + 1];
                f2 += (f4 * f6) - (f5 * f7);
                f3 += (f4 * f7) + (f5 * f6);
            }
            for (int i7 = i4; i7 < this.f2471N; i7++) {
                float f8 = this.f2472QT.data[((this.f2471N * i4) + i7) * 2];
                float f9 = this.f2472QT.data[(((this.f2471N * i4) + i7) * 2) + 1];
                int i8 = (i2 + i7) * 2;
                float f10 = this.f2472QT.data[i8];
                float f11 = this.f2472QT.data[i8 + 1];
                f2 += (f8 * f10) - (f9 * f11);
                f3 += (f8 * f11) + (f9 * f10);
            }
            float[] fArr = this.f2474w;
            int i9 = i4 * 2;
            float f12 = -f;
            fArr[i9] = f2 * f12;
            fArr[i9 + 1] = f12 * f3;
            i4++;
        }
        float f13 = 0.0f;
        for (int i10 = i3; i10 < this.f2471N; i10++) {
            int i11 = (i2 + i10) * 2;
            float f14 = this.f2472QT.data[i11];
            float f15 = -this.f2472QT.data[i11 + 1];
            float[] fArr2 = this.f2474w;
            int i12 = i10 * 2;
            float f16 = fArr2[i12];
            float f17 = fArr2[i12 + 1];
            f2 += (f14 * f16) - (f15 * f17);
            f13 += (f14 * f17) + (f15 * f16);
        }
        float f18 = f * (-0.5f);
        float f19 = f2 * f18;
        float f20 = f13 * f18;
        for (int i13 = i3; i13 < this.f2471N; i13++) {
            int i14 = (i2 + i13) * 2;
            float f21 = this.f2472QT.data[i14];
            float f22 = this.f2472QT.data[i14 + 1];
            float[] fArr3 = this.f2474w;
            int i15 = i13 * 2;
            fArr3[i15] = fArr3[i15] + ((f19 * f21) - (f20 * f22));
            int i16 = i15 + 1;
            fArr3[i16] = fArr3[i16] + (f22 * f19) + (f21 * f20);
        }
        while (i3 < this.f2471N) {
            float[] fArr4 = this.f2474w;
            int i17 = i3 * 2;
            float f23 = fArr4[i17];
            float f24 = fArr4[i17 + 1];
            int i18 = (i2 + i3) * 2;
            float f25 = this.f2472QT.data[i18];
            float f26 = this.f2472QT.data[i18 + 1];
            int i19 = ((this.f2471N * i3) + i3) * 2;
            for (int i20 = i3; i20 < this.f2471N; i20++) {
                int i21 = (i2 + i20) * 2;
                float f27 = this.f2472QT.data[i21];
                float f28 = -this.f2472QT.data[i21 + 1];
                float[] fArr5 = this.f2474w;
                int i22 = i20 * 2;
                float f29 = fArr5[i22];
                float f30 = -fArr5[i22 + 1];
                float[] fArr6 = this.f2472QT.data;
                int i23 = i19 + 1;
                fArr6[i19] = fArr6[i19] + ((((f23 * f27) - (f24 * f28)) + (f29 * f25)) - (f30 * f26));
                float[] fArr7 = this.f2472QT.data;
                i19 += 2;
                fArr7[i23] = fArr7[i23] + (f28 * f23) + (f27 * f24) + (f29 * f26) + (f30 * f25);
            }
            i3++;
        }
    }

    public void init(CMatrixRMaj cMatrixRMaj) {
        if (cMatrixRMaj.numRows != cMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Must be square");
        }
        if (cMatrixRMaj.numCols != this.f2471N) {
            int i = cMatrixRMaj.numCols;
            this.f2471N = i;
            if (this.f2474w.length < i) {
                this.f2474w = new float[i * 2];
                this.gammas = new float[i * 2];
                this.f2473b = new float[i * 2];
            }
        }
        this.f2472QT = cMatrixRMaj;
    }

    public float[] getGammas() {
        return this.gammas;
    }
}
