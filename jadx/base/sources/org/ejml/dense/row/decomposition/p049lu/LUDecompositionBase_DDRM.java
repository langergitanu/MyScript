package org.ejml.dense.row.decomposition.p049lu;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.UtilEjml;
import org.ejml.data.Complex_F64;
import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.IGrowArray;
import org.ejml.dense.row.SpecializedOps_DDRM;
import org.ejml.dense.row.decomposition.TriangularSolver_DDRM;
import org.ejml.dense.row.decomposition.UtilDecompositons_DDRM;
import org.ejml.interfaces.decomposition.LUDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public abstract class LUDecompositionBase_DDRM implements LUDecomposition_F64<DMatrixRMaj> {

    /* JADX INFO: renamed from: LU */
    protected DMatrixRMaj f2613LU;
    protected double[] dataLU;
    protected int[] indx;

    /* JADX INFO: renamed from: m */
    protected int f2614m;

    /* JADX INFO: renamed from: n */
    protected int f2615n;
    protected int[] pivot;
    protected double pivsign;

    /* JADX INFO: renamed from: vv */
    protected double[] f2616vv;
    protected int maxWidth = -1;
    Complex_F64 det = new Complex_F64();

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    public void setExpectedMaxSize(int i, int i2) {
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(i, i2);
        this.f2613LU = dMatrixRMaj;
        this.dataLU = dMatrixRMaj.data;
        int iMax = Math.max(i, i2);
        this.maxWidth = iMax;
        this.f2616vv = new double[iMax];
        this.indx = new int[iMax];
        this.pivot = new int[iMax];
    }

    public DMatrixRMaj getLU() {
        return this.f2613LU;
    }

    public int[] getIndx() {
        return this.indx;
    }

    public int[] getPivot() {
        return this.pivot;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public DMatrixRMaj getLower(DMatrixRMaj dMatrixRMaj) {
        int i = this.f2613LU.numRows;
        int i2 = this.f2613LU.numRows < this.f2613LU.numCols ? this.f2613LU.numRows : this.f2613LU.numCols;
        DMatrixRMaj dMatrixRMajCheckZerosUT = UtilDecompositons_DDRM.checkZerosUT(dMatrixRMaj, i, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            dMatrixRMajCheckZerosUT.unsafe_set(i3, i3, 1.0d);
            for (int i4 = 0; i4 < i3; i4++) {
                dMatrixRMajCheckZerosUT.unsafe_set(i3, i4, this.f2613LU.unsafe_get(i3, i4));
            }
        }
        if (i > i2) {
            for (int i5 = i2; i5 < i; i5++) {
                for (int i6 = 0; i6 < i2; i6++) {
                    dMatrixRMajCheckZerosUT.unsafe_set(i5, i6, this.f2613LU.unsafe_get(i5, i6));
                }
            }
        }
        return dMatrixRMajCheckZerosUT;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public DMatrixRMaj getUpper(DMatrixRMaj dMatrixRMaj) {
        int i = this.f2613LU.numRows < this.f2613LU.numCols ? this.f2613LU.numRows : this.f2613LU.numCols;
        int i2 = this.f2613LU.numCols;
        DMatrixRMaj dMatrixRMajCheckZerosLT = UtilDecompositons_DDRM.checkZerosLT(dMatrixRMaj, i, i2);
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = i3; i4 < i2; i4++) {
                dMatrixRMajCheckZerosLT.unsafe_set(i3, i4, this.f2613LU.unsafe_get(i3, i4));
            }
        }
        return dMatrixRMajCheckZerosLT;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public DMatrixRMaj getRowPivot(DMatrixRMaj dMatrixRMaj) {
        return SpecializedOps_DDRM.pivotMatrix(dMatrixRMaj, this.pivot, this.f2613LU.numRows, false);
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public int[] getRowPivotV(IGrowArray iGrowArray) {
        return UtilEjml.pivotVector(this.pivot, this.f2613LU.numRows, iGrowArray);
    }

    protected void decomposeCommonInit(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj.numRows > this.maxWidth || dMatrixRMaj.numCols > this.maxWidth) {
            setExpectedMaxSize(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        }
        this.f2614m = dMatrixRMaj.numRows;
        this.f2615n = dMatrixRMaj.numCols;
        this.f2613LU.set((DMatrixD1) dMatrixRMaj);
        for (int i = 0; i < this.f2614m; i++) {
            this.pivot[i] = i;
        }
        this.pivsign = 1.0d;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public boolean isSingular() {
        for (int i = 0; i < this.f2614m; i++) {
            if (Math.abs(this.dataLU[(this.f2615n * i) + i]) < UtilEjml.EPS) {
                return true;
            }
        }
        return false;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition_F64
    public Complex_F64 computeDeterminant() {
        int i = this.f2614m;
        int i2 = this.f2615n;
        if (i != i2) {
            throw new IllegalArgumentException("Must be a square matrix.");
        }
        double d = this.pivsign;
        int i3 = i * i2;
        int i4 = 0;
        while (i4 < i3) {
            d *= this.dataLU[i4];
            i4 += this.f2615n + 1;
        }
        this.det.real = d;
        this.det.imaginary = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        return this.det;
    }

    public double quality() {
        return SpecializedOps_DDRM.qualityTriangular(this.f2613LU);
    }

    public void _solveVectorInternal(double[] dArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = this.f2615n;
            if (i < i3) {
                int i4 = this.indx[i];
                double d = dArr[i4];
                dArr[i4] = dArr[i];
                if (i2 != 0) {
                    int i5 = ((i3 * i) + i2) - 1;
                    int i6 = i2 - 1;
                    while (i6 < i) {
                        d -= this.dataLU[i5] * dArr[i6];
                        i6++;
                        i5++;
                    }
                } else if (d != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    i2 = i + 1;
                }
                dArr[i] = d;
                i++;
            } else {
                TriangularSolver_DDRM.solveU(this.dataLU, dArr, i3);
                return;
            }
        }
    }

    public double[] _getVV() {
        return this.f2616vv;
    }
}
