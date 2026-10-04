package org.ejml.dense.row.decomposition.bidiagonal;

import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.dense.row.decomposition.p050qr.QrHelperFunctions_FDRM;
import org.ejml.interfaces.decomposition.BidiagonalDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class BidiagonalDecompositionRow_FDRM implements BidiagonalDecomposition_F32<FMatrixRMaj> {
    private FMatrixRMaj UBV;

    /* JADX INFO: renamed from: b */
    private float[] f2503b;
    private float[] gammasU;
    private float[] gammasV;

    /* JADX INFO: renamed from: m */
    private int f2504m;
    private int min;

    /* JADX INFO: renamed from: n */
    private int f2505n;

    /* JADX INFO: renamed from: u */
    private float[] f2506u;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return true;
    }

    public BidiagonalDecompositionRow_FDRM(int i) {
        this.UBV = new FMatrixRMaj(i);
        this.gammasU = new float[i];
        this.gammasV = new float[i];
        this.f2503b = new float[i];
        this.f2506u = new float[i];
    }

    public BidiagonalDecompositionRow_FDRM() {
        this(1);
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(FMatrixRMaj fMatrixRMaj) {
        init(fMatrixRMaj);
        return _decompose();
    }

    protected void init(FMatrixRMaj fMatrixRMaj) {
        this.UBV = fMatrixRMaj;
        this.f2504m = fMatrixRMaj.numRows;
        int i = this.UBV.numCols;
        this.f2505n = i;
        this.min = Math.min(this.f2504m, i);
        int iMax = Math.max(this.f2504m, this.f2505n) + 1;
        if (this.f2503b.length < iMax) {
            this.f2503b = new float[iMax];
            this.f2506u = new float[iMax];
        }
        int length = this.gammasU.length;
        int i2 = this.f2504m;
        if (length < i2) {
            this.gammasU = new float[i2];
        }
        int length2 = this.gammasV.length;
        int i3 = this.f2505n;
        if (length2 < i3) {
            this.gammasV = new float[i3];
        }
    }

    public FMatrixRMaj getUBV() {
        return this.UBV;
    }

    @Override // org.ejml.interfaces.decomposition.BidiagonalDecomposition_F32
    public void getDiagonal(float[] fArr, float[] fArr2) {
        fArr[0] = this.UBV.get(0);
        for (int i = 1; i < this.f2505n; i++) {
            fArr[i] = this.UBV.unsafe_get(i, i);
            int i2 = i - 1;
            fArr2[i2] = this.UBV.unsafe_get(i2, i);
        }
    }

    @Override // org.ejml.interfaces.decomposition.BidiagonalDecomposition
    public FMatrixRMaj getB(FMatrixRMaj fMatrixRMaj, boolean z) {
        int i;
        FMatrixRMaj fMatrixRMajHandleB = handleB(fMatrixRMaj, z, this.f2504m, this.f2505n, this.min);
        fMatrixRMajHandleB.set(0, 0, this.UBV.get(0, 0));
        int i2 = 1;
        while (true) {
            i = this.min;
            if (i2 >= i) {
                break;
            }
            fMatrixRMajHandleB.set(i2, i2, this.UBV.get(i2, i2));
            int i3 = i2 - 1;
            fMatrixRMajHandleB.set(i3, i2, this.UBV.get(i3, i2));
            i2++;
        }
        if (this.f2505n > this.f2504m) {
            fMatrixRMajHandleB.set(i - 1, i, this.UBV.get(i - 1, i));
        }
        return fMatrixRMajHandleB;
    }

    public static FMatrixRMaj handleB(FMatrixRMaj fMatrixRMaj, boolean z, int i, int i2, int i3) {
        int i4 = i2 > i ? i3 + 1 : i3;
        if (z) {
            if (fMatrixRMaj == null) {
                return new FMatrixRMaj(i3, i4);
            }
            fMatrixRMaj.reshape(i3, i4, false);
            fMatrixRMaj.zero();
            return fMatrixRMaj;
        }
        if (fMatrixRMaj == null) {
            return new FMatrixRMaj(i, i2);
        }
        fMatrixRMaj.reshape(i, i2, false);
        fMatrixRMaj.zero();
        return fMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.BidiagonalDecomposition
    public FMatrixRMaj getU(FMatrixRMaj fMatrixRMaj, boolean z, boolean z2) {
        int i;
        FMatrixRMaj fMatrixRMajHandleU = handleU(fMatrixRMaj, z, z2, this.f2504m, this.f2505n, this.min);
        CommonOps_FDRM.setIdentity(fMatrixRMajHandleU);
        for (int i2 = 0; i2 < this.f2504m; i2++) {
            this.f2506u[i2] = 0.0f;
        }
        for (int i3 = this.min - 1; i3 >= 0; i3--) {
            this.f2506u[i3] = 1.0f;
            int i4 = i3 + 1;
            while (true) {
                i = this.f2504m;
                if (i4 >= i) {
                    break;
                }
                this.f2506u[i4] = this.UBV.get(i4, i3);
                i4++;
            }
            if (z) {
                QrHelperFunctions_FDRM.rank1UpdateMultL(fMatrixRMajHandleU, this.f2506u, this.gammasU[i3], i3, i3, i);
            } else {
                QrHelperFunctions_FDRM.rank1UpdateMultR(fMatrixRMajHandleU, this.f2506u, this.gammasU[i3], i3, i3, i, this.f2503b);
            }
        }
        return fMatrixRMajHandleU;
    }

    public static FMatrixRMaj handleU(FMatrixRMaj fMatrixRMaj, boolean z, boolean z2, int i, int i2, int i3) {
        if (!z2) {
            if (fMatrixRMaj == null) {
                return new FMatrixRMaj(i, i);
            }
            fMatrixRMaj.reshape(i, i, false);
            return fMatrixRMaj;
        }
        if (z) {
            if (fMatrixRMaj == null) {
                return new FMatrixRMaj(i3, i);
            }
            fMatrixRMaj.reshape(i3, i, false);
            return fMatrixRMaj;
        }
        if (fMatrixRMaj == null) {
            return new FMatrixRMaj(i, i3);
        }
        fMatrixRMaj.reshape(i, i3, false);
        return fMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.BidiagonalDecomposition
    public FMatrixRMaj getV(FMatrixRMaj fMatrixRMaj, boolean z, boolean z2) {
        int i;
        FMatrixRMaj fMatrixRMajHandleV = handleV(fMatrixRMaj, z, z2, this.f2504m, this.f2505n, this.min);
        CommonOps_FDRM.setIdentity(fMatrixRMajHandleV);
        for (int i2 = this.min - 1; i2 >= 0; i2--) {
            int i3 = i2 + 1;
            this.f2506u[i3] = 1.0f;
            int i4 = i2 + 2;
            while (true) {
                i = this.f2505n;
                if (i4 >= i) {
                    break;
                }
                this.f2506u[i4] = this.UBV.get(i2, i4);
                i4++;
            }
            if (z) {
                QrHelperFunctions_FDRM.rank1UpdateMultL(fMatrixRMajHandleV, this.f2506u, this.gammasV[i2], i3, i3, i);
            } else {
                QrHelperFunctions_FDRM.rank1UpdateMultR(fMatrixRMajHandleV, this.f2506u, this.gammasV[i2], i3, i3, i, this.f2503b);
            }
        }
        return fMatrixRMajHandleV;
    }

    public static FMatrixRMaj handleV(FMatrixRMaj fMatrixRMaj, boolean z, boolean z2, int i, int i2, int i3) {
        if (i2 > i) {
            i3++;
        }
        if (!z2) {
            if (fMatrixRMaj == null) {
                return new FMatrixRMaj(i2, i2);
            }
            fMatrixRMaj.reshape(i2, i2, false);
            return fMatrixRMaj;
        }
        if (z) {
            if (fMatrixRMaj == null) {
                return new FMatrixRMaj(i3, i2);
            }
            fMatrixRMaj.reshape(i3, i2, false);
            return fMatrixRMaj;
        }
        if (fMatrixRMaj == null) {
            return new FMatrixRMaj(i2, i3);
        }
        fMatrixRMaj.reshape(i2, i3, false);
        return fMatrixRMaj;
    }

    private boolean _decompose() {
        for (int i = 0; i < this.min; i++) {
            computeU(i);
            computeV(i);
        }
        return true;
    }

    protected void computeU(int i) {
        int i2;
        float[] fArr = this.UBV.data;
        int i3 = i;
        float f = 0.0f;
        while (true) {
            i2 = this.f2504m;
            if (i3 >= i2) {
                break;
            }
            float[] fArr2 = this.f2506u;
            float f2 = fArr[(this.f2505n * i3) + i];
            fArr2[i3] = f2;
            float fAbs = Math.abs(f2);
            if (fAbs > f) {
                f = fAbs;
            }
            i3++;
        }
        if (f > 0.0f) {
            float fComputeTauAndDivide = QrHelperFunctions_FDRM.computeTauAndDivide(i, i2, this.f2506u, f);
            float[] fArr3 = this.f2506u;
            float f3 = fArr3[i] + fComputeTauAndDivide;
            int i4 = i + 1;
            QrHelperFunctions_FDRM.divideElements_Bcol(i4, this.f2504m, this.f2505n, fArr3, fArr, i, f3);
            float[] fArr4 = this.f2506u;
            fArr4[i] = 1.0f;
            float f4 = f3 / fComputeTauAndDivide;
            this.gammasU[i] = f4;
            QrHelperFunctions_FDRM.rank1UpdateMultR(this.UBV, fArr4, f4, i4, i, this.f2504m, this.f2503b);
            fArr[(this.f2505n * i) + i] = (-fComputeTauAndDivide) * f;
            return;
        }
        this.gammasU[i] = 0.0f;
    }

    protected void computeV(int i) {
        float[] fArr = this.UBV.data;
        int i2 = i * this.f2505n;
        int i3 = i2 + i + 1;
        float fFindMax = QrHelperFunctions_FDRM.findMax(fArr, i3, (r1 - i) - 1);
        if (fFindMax > 0.0f) {
            int i4 = i + 1;
            float fComputeTauAndDivide = QrHelperFunctions_FDRM.computeTauAndDivide(i4, this.f2505n, fArr, i2, fFindMax);
            float f = fArr[i3] + fComputeTauAndDivide;
            QrHelperFunctions_FDRM.divideElements_Brow(i + 2, this.f2505n, this.f2506u, fArr, i2, f);
            float[] fArr2 = this.f2506u;
            fArr2[i4] = 1.0f;
            float f2 = f / fComputeTauAndDivide;
            this.gammasV[i] = f2;
            QrHelperFunctions_FDRM.rank1UpdateMultL(this.UBV, fArr2, f2, i4, i4, this.f2505n);
            fArr[i3] = (-fComputeTauAndDivide) * fFindMax;
            return;
        }
        this.gammasV[i] = 0.0f;
    }

    public float[] getGammasU() {
        return this.gammasU;
    }

    public float[] getGammasV() {
        return this.gammasV;
    }
}
