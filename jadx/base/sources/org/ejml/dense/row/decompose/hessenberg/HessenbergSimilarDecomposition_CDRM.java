package org.ejml.dense.row.decompose.hessenberg;

import java.util.Arrays;
import org.ejml.data.CMatrixRMaj;
import org.ejml.data.Complex_F32;
import org.ejml.dense.row.decompose.UtilDecompositons_CDRM;
import org.ejml.dense.row.decompose.p048qr.QrHelperFunctions_CDRM;
import org.ejml.interfaces.decomposition.DecompositionInterface;

/* JADX INFO: loaded from: classes9.dex */
public class HessenbergSimilarDecomposition_CDRM implements DecompositionInterface<CMatrixRMaj> {

    /* JADX INFO: renamed from: N */
    private int f2463N;

    /* JADX INFO: renamed from: QH */
    private CMatrixRMaj f2464QH;

    /* JADX INFO: renamed from: b */
    private float[] f2465b;
    private float[] gammas;
    private Complex_F32 tau;

    /* JADX INFO: renamed from: u */
    private float[] f2466u;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return true;
    }

    public HessenbergSimilarDecomposition_CDRM(int i) {
        this.tau = new Complex_F32();
        this.gammas = new float[i];
        int i2 = i * 2;
        this.f2465b = new float[i2];
        this.f2466u = new float[i2];
    }

    public HessenbergSimilarDecomposition_CDRM() {
        this(5);
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(CMatrixRMaj cMatrixRMaj) {
        if (cMatrixRMaj.numRows != cMatrixRMaj.numCols) {
            throw new IllegalArgumentException("A must be square.");
        }
        if (cMatrixRMaj.numRows <= 0) {
            return false;
        }
        this.f2464QH = cMatrixRMaj;
        int i = cMatrixRMaj.numCols;
        this.f2463N = i;
        if (this.f2465b.length < i * 2) {
            this.f2465b = new float[i * 2];
            this.gammas = new float[i];
            this.f2466u = new float[i * 2];
        }
        return _decompose();
    }

    public CMatrixRMaj getQH() {
        return this.f2464QH;
    }

    public CMatrixRMaj getH(CMatrixRMaj cMatrixRMaj) {
        int i = this.f2463N;
        CMatrixRMaj cMatrixRMajCheckZeros = UtilDecompositons_CDRM.checkZeros(cMatrixRMaj, i, i);
        System.arraycopy(this.f2464QH.data, 0, cMatrixRMajCheckZeros.data, 0, this.f2463N * 2);
        for (int i2 = 1; i2 < this.f2463N; i2++) {
            float[] fArr = this.f2464QH.data;
            int i3 = (((this.f2463N * i2) + i2) - 1) * 2;
            float[] fArr2 = cMatrixRMajCheckZeros.data;
            int i4 = this.f2463N;
            System.arraycopy(fArr, i3, fArr2, (((i2 * i4) + i2) - 1) * 2, ((i4 - i2) + 1) * 2);
        }
        return cMatrixRMajCheckZeros;
    }

    public CMatrixRMaj getQ(CMatrixRMaj cMatrixRMaj) {
        int i = this.f2463N;
        CMatrixRMaj cMatrixRMajCheckIdentity = UtilDecompositons_CDRM.checkIdentity(cMatrixRMaj, i, i);
        Arrays.fill(this.f2466u, 0, this.f2463N * 2, 0.0f);
        int i2 = this.f2463N - 2;
        while (i2 >= 0) {
            int i3 = i2 + 1;
            QrHelperFunctions_CDRM.extractHouseholderColumn(this.f2464QH, i3, this.f2463N, i2, this.f2466u, 0);
            int i4 = i2;
            QrHelperFunctions_CDRM.rank1UpdateMultR(cMatrixRMajCheckIdentity, this.f2466u, 0, this.gammas[i4], i3, i3, this.f2463N, this.f2465b);
            i2 = i4 - 1;
        }
        return cMatrixRMajCheckIdentity;
    }

    private boolean _decompose() {
        int i;
        float[] fArr = this.f2464QH.data;
        int i2 = 0;
        while (true) {
            int i3 = this.f2463N;
            if (i2 >= i3 - 2) {
                return true;
            }
            float[] fArr2 = this.f2466u;
            int i4 = i2 * 2;
            fArr2[i4] = 0.0f;
            fArr2[i4 + 1] = 0.0f;
            int i5 = i2 + 1;
            float fExtractColumnAndMax = QrHelperFunctions_CDRM.extractColumnAndMax(this.f2464QH, i5, i3, i2, fArr2, 0);
            if (fExtractColumnAndMax > 0.0f) {
                float fComputeTauGammaAndDivide = QrHelperFunctions_CDRM.computeTauGammaAndDivide(i5, this.f2463N, this.f2466u, fExtractColumnAndMax, this.tau);
                this.gammas[i2] = fComputeTauGammaAndDivide;
                int i6 = i5 * 2;
                int i7 = i6 + 1;
                int i8 = i2 + 2;
                QrHelperFunctions_CDRM.divideElements(i8, this.f2463N, this.f2466u, 0, this.f2466u[i6] + this.tau.real, this.f2466u[i7] + this.tau.imaginary);
                int i9 = i8;
                while (true) {
                    i = this.f2463N;
                    if (i9 >= i) {
                        break;
                    }
                    float[] fArr3 = this.f2466u;
                    int i10 = i9 * 2;
                    fArr[((i9 * i) + i2) * 2] = fArr3[i10];
                    fArr[(((i * i9) + i2) * 2) + 1] = fArr3[i10 + 1];
                    i9++;
                }
                float[] fArr4 = this.f2466u;
                fArr4[i6] = 1.0f;
                fArr4[i7] = 0.0f;
                QrHelperFunctions_CDRM.rank1UpdateMultR(this.f2464QH, fArr4, 0, fComputeTauGammaAndDivide, i5, i5, i, this.f2465b);
                QrHelperFunctions_CDRM.rank1UpdateMultL(this.f2464QH, this.f2466u, 0, fComputeTauGammaAndDivide, 0, i5, this.f2463N);
                i5 = i5;
                fArr[((this.f2463N * i5) + i2) * 2] = (-this.tau.real) * fExtractColumnAndMax;
                fArr[(((this.f2463N * i5) + i2) * 2) + 1] = (-this.tau.imaginary) * fExtractColumnAndMax;
            } else {
                this.gammas[i2] = 0.0f;
            }
            i2 = i5;
        }
    }

    public float[] getGammas() {
        return this.gammas;
    }
}
