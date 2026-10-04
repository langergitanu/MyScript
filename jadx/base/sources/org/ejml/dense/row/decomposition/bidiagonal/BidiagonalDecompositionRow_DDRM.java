package org.ejml.dense.row.decomposition.bidiagonal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.dense.row.decomposition.p050qr.QrHelperFunctions_DDRM;
import org.ejml.interfaces.decomposition.BidiagonalDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class BidiagonalDecompositionRow_DDRM implements BidiagonalDecomposition_F64<DMatrixRMaj> {
    private DMatrixRMaj UBV;

    /* JADX INFO: renamed from: b */
    private double[] f2499b;
    private double[] gammasU;
    private double[] gammasV;

    /* JADX INFO: renamed from: m */
    private int f2500m;
    private int min;

    /* JADX INFO: renamed from: n */
    private int f2501n;

    /* JADX INFO: renamed from: u */
    private double[] f2502u;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return true;
    }

    public BidiagonalDecompositionRow_DDRM(int i) {
        this.UBV = new DMatrixRMaj(i);
        this.gammasU = new double[i];
        this.gammasV = new double[i];
        this.f2499b = new double[i];
        this.f2502u = new double[i];
    }

    public BidiagonalDecompositionRow_DDRM() {
        this(1);
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixRMaj dMatrixRMaj) {
        init(dMatrixRMaj);
        return _decompose();
    }

    protected void init(DMatrixRMaj dMatrixRMaj) {
        this.UBV = dMatrixRMaj;
        this.f2500m = dMatrixRMaj.numRows;
        int i = this.UBV.numCols;
        this.f2501n = i;
        this.min = Math.min(this.f2500m, i);
        int iMax = Math.max(this.f2500m, this.f2501n) + 1;
        if (this.f2499b.length < iMax) {
            this.f2499b = new double[iMax];
            this.f2502u = new double[iMax];
        }
        int length = this.gammasU.length;
        int i2 = this.f2500m;
        if (length < i2) {
            this.gammasU = new double[i2];
        }
        int length2 = this.gammasV.length;
        int i3 = this.f2501n;
        if (length2 < i3) {
            this.gammasV = new double[i3];
        }
    }

    public DMatrixRMaj getUBV() {
        return this.UBV;
    }

    @Override // org.ejml.interfaces.decomposition.BidiagonalDecomposition_F64
    public void getDiagonal(double[] dArr, double[] dArr2) {
        dArr[0] = this.UBV.get(0);
        for (int i = 1; i < this.f2501n; i++) {
            dArr[i] = this.UBV.unsafe_get(i, i);
            int i2 = i - 1;
            dArr2[i2] = this.UBV.unsafe_get(i2, i);
        }
    }

    @Override // org.ejml.interfaces.decomposition.BidiagonalDecomposition
    public DMatrixRMaj getB(DMatrixRMaj dMatrixRMaj, boolean z) {
        int i;
        DMatrixRMaj dMatrixRMajHandleB = handleB(dMatrixRMaj, z, this.f2500m, this.f2501n, this.min);
        dMatrixRMajHandleB.set(0, 0, this.UBV.get(0, 0));
        int i2 = 1;
        while (true) {
            i = this.min;
            if (i2 >= i) {
                break;
            }
            dMatrixRMajHandleB.set(i2, i2, this.UBV.get(i2, i2));
            int i3 = i2 - 1;
            dMatrixRMajHandleB.set(i3, i2, this.UBV.get(i3, i2));
            i2++;
        }
        if (this.f2501n > this.f2500m) {
            dMatrixRMajHandleB.set(i - 1, i, this.UBV.get(i - 1, i));
        }
        return dMatrixRMajHandleB;
    }

    public static DMatrixRMaj handleB(DMatrixRMaj dMatrixRMaj, boolean z, int i, int i2, int i3) {
        int i4 = i2 > i ? i3 + 1 : i3;
        if (z) {
            if (dMatrixRMaj == null) {
                return new DMatrixRMaj(i3, i4);
            }
            dMatrixRMaj.reshape(i3, i4, false);
            dMatrixRMaj.zero();
            return dMatrixRMaj;
        }
        if (dMatrixRMaj == null) {
            return new DMatrixRMaj(i, i2);
        }
        dMatrixRMaj.reshape(i, i2, false);
        dMatrixRMaj.zero();
        return dMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.BidiagonalDecomposition
    public DMatrixRMaj getU(DMatrixRMaj dMatrixRMaj, boolean z, boolean z2) {
        int i;
        DMatrixRMaj dMatrixRMajHandleU = handleU(dMatrixRMaj, z, z2, this.f2500m, this.f2501n, this.min);
        CommonOps_DDRM.setIdentity(dMatrixRMajHandleU);
        for (int i2 = 0; i2 < this.f2500m; i2++) {
            this.f2502u[i2] = 0.0d;
        }
        for (int i3 = this.min - 1; i3 >= 0; i3--) {
            this.f2502u[i3] = 1.0d;
            int i4 = i3 + 1;
            while (true) {
                i = this.f2500m;
                if (i4 >= i) {
                    break;
                }
                this.f2502u[i4] = this.UBV.get(i4, i3);
                i4++;
            }
            if (z) {
                QrHelperFunctions_DDRM.rank1UpdateMultL(dMatrixRMajHandleU, this.f2502u, this.gammasU[i3], i3, i3, i);
            } else {
                QrHelperFunctions_DDRM.rank1UpdateMultR(dMatrixRMajHandleU, this.f2502u, this.gammasU[i3], i3, i3, i, this.f2499b);
            }
        }
        return dMatrixRMajHandleU;
    }

    public static DMatrixRMaj handleU(DMatrixRMaj dMatrixRMaj, boolean z, boolean z2, int i, int i2, int i3) {
        if (!z2) {
            if (dMatrixRMaj == null) {
                return new DMatrixRMaj(i, i);
            }
            dMatrixRMaj.reshape(i, i, false);
            return dMatrixRMaj;
        }
        if (z) {
            if (dMatrixRMaj == null) {
                return new DMatrixRMaj(i3, i);
            }
            dMatrixRMaj.reshape(i3, i, false);
            return dMatrixRMaj;
        }
        if (dMatrixRMaj == null) {
            return new DMatrixRMaj(i, i3);
        }
        dMatrixRMaj.reshape(i, i3, false);
        return dMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.BidiagonalDecomposition
    public DMatrixRMaj getV(DMatrixRMaj dMatrixRMaj, boolean z, boolean z2) {
        int i;
        DMatrixRMaj dMatrixRMajHandleV = handleV(dMatrixRMaj, z, z2, this.f2500m, this.f2501n, this.min);
        CommonOps_DDRM.setIdentity(dMatrixRMajHandleV);
        for (int i2 = this.min - 1; i2 >= 0; i2--) {
            int i3 = i2 + 1;
            this.f2502u[i3] = 1.0d;
            int i4 = i2 + 2;
            while (true) {
                i = this.f2501n;
                if (i4 >= i) {
                    break;
                }
                this.f2502u[i4] = this.UBV.get(i2, i4);
                i4++;
            }
            if (z) {
                QrHelperFunctions_DDRM.rank1UpdateMultL(dMatrixRMajHandleV, this.f2502u, this.gammasV[i2], i3, i3, i);
            } else {
                QrHelperFunctions_DDRM.rank1UpdateMultR(dMatrixRMajHandleV, this.f2502u, this.gammasV[i2], i3, i3, i, this.f2499b);
            }
        }
        return dMatrixRMajHandleV;
    }

    public static DMatrixRMaj handleV(DMatrixRMaj dMatrixRMaj, boolean z, boolean z2, int i, int i2, int i3) {
        if (i2 > i) {
            i3++;
        }
        if (!z2) {
            if (dMatrixRMaj == null) {
                return new DMatrixRMaj(i2, i2);
            }
            dMatrixRMaj.reshape(i2, i2, false);
            return dMatrixRMaj;
        }
        if (z) {
            if (dMatrixRMaj == null) {
                return new DMatrixRMaj(i3, i2);
            }
            dMatrixRMaj.reshape(i3, i2, false);
            return dMatrixRMaj;
        }
        if (dMatrixRMaj == null) {
            return new DMatrixRMaj(i2, i3);
        }
        dMatrixRMaj.reshape(i2, i3, false);
        return dMatrixRMaj;
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
        double[] dArr = this.UBV.data;
        int i3 = i;
        double d = 0.0d;
        while (true) {
            i2 = this.f2500m;
            if (i3 >= i2) {
                break;
            }
            double[] dArr2 = this.f2502u;
            double d2 = dArr[(this.f2501n * i3) + i];
            dArr2[i3] = d2;
            double dAbs = Math.abs(d2);
            if (dAbs > d) {
                d = dAbs;
            }
            i3++;
        }
        if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            double dComputeTauAndDivide = QrHelperFunctions_DDRM.computeTauAndDivide(i, i2, this.f2502u, d);
            double[] dArr3 = this.f2502u;
            double d3 = dArr3[i] + dComputeTauAndDivide;
            int i4 = i + 1;
            QrHelperFunctions_DDRM.divideElements_Bcol(i4, this.f2500m, this.f2501n, dArr3, dArr, i, d3);
            double[] dArr4 = this.f2502u;
            dArr4[i] = 1.0d;
            double d4 = d3 / dComputeTauAndDivide;
            this.gammasU[i] = d4;
            QrHelperFunctions_DDRM.rank1UpdateMultR(this.UBV, dArr4, d4, i4, i, this.f2500m, this.f2499b);
            dArr[(this.f2501n * i) + i] = (-dComputeTauAndDivide) * d;
            return;
        }
        this.gammasU[i] = 0.0d;
    }

    protected void computeV(int i) {
        double[] dArr = this.UBV.data;
        int i2 = i * this.f2501n;
        int i3 = i2 + i + 1;
        double dFindMax = QrHelperFunctions_DDRM.findMax(dArr, i3, (r1 - i) - 1);
        if (dFindMax > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            int i4 = i + 1;
            double dComputeTauAndDivide = QrHelperFunctions_DDRM.computeTauAndDivide(i4, this.f2501n, dArr, i2, dFindMax);
            double d = dArr[i3] + dComputeTauAndDivide;
            QrHelperFunctions_DDRM.divideElements_Brow(i + 2, this.f2501n, this.f2502u, dArr, i2, d);
            double[] dArr2 = this.f2502u;
            dArr2[i4] = 1.0d;
            double d2 = d / dComputeTauAndDivide;
            this.gammasV[i] = d2;
            QrHelperFunctions_DDRM.rank1UpdateMultL(this.UBV, dArr2, d2, i4, i4, this.f2501n);
            dArr[i3] = (-dComputeTauAndDivide) * dFindMax;
            return;
        }
        this.gammasV[i] = 0.0d;
    }

    public double[] getGammasU() {
        return this.gammasU;
    }

    public double[] getGammasV() {
        return this.gammasV;
    }
}
