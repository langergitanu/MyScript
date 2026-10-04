package org.ejml.dense.row.decompose.p047lu;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.UtilEjml;
import org.ejml.data.Complex_F64;
import org.ejml.data.IGrowArray;
import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_ZDRM;
import org.ejml.dense.row.decompose.TriangularSolver_ZDRM;
import org.ejml.dense.row.decompose.UtilDecompositons_ZDRM;
import org.ejml.interfaces.decomposition.LUDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public abstract class LUDecompositionBase_ZDRM implements LUDecomposition_F64<ZMatrixRMaj> {

    /* JADX INFO: renamed from: LU */
    protected ZMatrixRMaj f2483LU;
    protected double[] dataLU;
    protected int[] indx;

    /* JADX INFO: renamed from: m */
    protected int f2484m;

    /* JADX INFO: renamed from: n */
    protected int f2485n;
    protected int[] pivot;
    protected double pivsign;
    protected int stride;

    /* JADX INFO: renamed from: vv */
    protected double[] f2486vv;
    protected int maxWidth = -1;
    protected Complex_F64 det = new Complex_F64();

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    public void setExpectedMaxSize(int i, int i2) {
        ZMatrixRMaj zMatrixRMaj = new ZMatrixRMaj(i, i2);
        this.f2483LU = zMatrixRMaj;
        this.dataLU = zMatrixRMaj.data;
        int iMax = Math.max(i, i2);
        this.maxWidth = iMax;
        this.f2486vv = new double[iMax * 2];
        this.indx = new int[iMax];
        this.pivot = new int[iMax];
    }

    public ZMatrixRMaj getLU() {
        return this.f2483LU;
    }

    public int[] getIndx() {
        return this.indx;
    }

    public int[] getPivot() {
        return this.pivot;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public ZMatrixRMaj getLower(ZMatrixRMaj zMatrixRMaj) {
        int i = this.f2483LU.numRows;
        int i2 = this.f2483LU.numRows < this.f2483LU.numCols ? this.f2483LU.numRows : this.f2483LU.numCols;
        ZMatrixRMaj zMatrixRMajCheckZerosUT = UtilDecompositons_ZDRM.checkZerosUT(zMatrixRMaj, i, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            zMatrixRMajCheckZerosUT.set(i3, i3, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            for (int i4 = 0; i4 < i3; i4++) {
                int index = this.f2483LU.getIndex(i3, i4);
                int index2 = zMatrixRMajCheckZerosUT.getIndex(i3, i4);
                double d = this.f2483LU.data[index];
                double d2 = this.f2483LU.data[index + 1];
                zMatrixRMajCheckZerosUT.data[index2] = d;
                zMatrixRMajCheckZerosUT.data[index2 + 1] = d2;
            }
        }
        if (i > i2) {
            for (int i5 = i2; i5 < i; i5++) {
                for (int i6 = 0; i6 < i2; i6++) {
                    int index3 = this.f2483LU.getIndex(i5, i6);
                    int index4 = zMatrixRMajCheckZerosUT.getIndex(i5, i6);
                    double d3 = this.f2483LU.data[index3];
                    double d4 = this.f2483LU.data[index3 + 1];
                    zMatrixRMajCheckZerosUT.data[index4] = d3;
                    zMatrixRMajCheckZerosUT.data[index4 + 1] = d4;
                }
            }
        }
        return zMatrixRMajCheckZerosUT;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public ZMatrixRMaj getUpper(ZMatrixRMaj zMatrixRMaj) {
        int i = this.f2483LU.numRows < this.f2483LU.numCols ? this.f2483LU.numRows : this.f2483LU.numCols;
        int i2 = this.f2483LU.numCols;
        ZMatrixRMaj zMatrixRMajCheckZerosLT = UtilDecompositons_ZDRM.checkZerosLT(zMatrixRMaj, i, i2);
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = i3; i4 < i2; i4++) {
                int index = this.f2483LU.getIndex(i3, i4);
                int index2 = zMatrixRMajCheckZerosLT.getIndex(i3, i4);
                double d = this.f2483LU.data[index];
                double d2 = this.f2483LU.data[index + 1];
                zMatrixRMajCheckZerosLT.data[index2] = d;
                zMatrixRMajCheckZerosLT.data[index2 + 1] = d2;
            }
        }
        return zMatrixRMajCheckZerosLT;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public ZMatrixRMaj getRowPivot(ZMatrixRMaj zMatrixRMaj) {
        return SpecializedOps_ZDRM.pivotMatrix(zMatrixRMaj, this.pivot, this.f2483LU.numRows, false);
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public int[] getRowPivotV(IGrowArray iGrowArray) {
        return UtilEjml.pivotVector(this.pivot, this.f2483LU.numRows, iGrowArray);
    }

    protected void decomposeCommonInit(ZMatrixRMaj zMatrixRMaj) {
        if (zMatrixRMaj.numRows > this.maxWidth || zMatrixRMaj.numCols > this.maxWidth) {
            setExpectedMaxSize(zMatrixRMaj.numRows, zMatrixRMaj.numCols);
        }
        this.f2484m = zMatrixRMaj.numRows;
        int i = zMatrixRMaj.numCols;
        this.f2485n = i;
        this.stride = i * 2;
        this.f2483LU.set(zMatrixRMaj);
        for (int i2 = 0; i2 < this.f2484m; i2++) {
            this.pivot[i2] = i2;
        }
        this.pivsign = 1.0d;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public boolean isSingular() {
        for (int i = 0; i < this.f2484m; i++) {
            double[] dArr = this.dataLU;
            int i2 = this.stride;
            int i3 = i * 2;
            double d = dArr[(i * i2) + i3];
            double d2 = dArr[(i2 * i) + i3 + 1];
            if ((d * d) + (d2 * d2) < UtilEjml.EPS * UtilEjml.EPS) {
                return true;
            }
        }
        return false;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition_F64
    public Complex_F64 computeDeterminant() {
        int i = this.f2484m;
        if (i != this.f2485n) {
            throw new IllegalArgumentException("Must be a square matrix.");
        }
        double d = this.pivsign;
        int i2 = i * this.stride;
        double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i3 = 0;
        while (i3 < i2) {
            double[] dArr = this.dataLU;
            double d3 = dArr[i3];
            double d4 = dArr[i3 + 1];
            double d5 = (d * d3) - (d2 * d4);
            d2 = (d2 * d3) + (d * d4);
            i3 += this.stride + 2;
            d = d5;
        }
        this.det.set(d, d2);
        return this.det;
    }

    public double quality() {
        return SpecializedOps_ZDRM.qualityTriangular(this.f2483LU);
    }

    public void _solveVectorInternal(double[] dArr) {
        solveL(dArr);
        TriangularSolver_ZDRM.solveU(this.dataLU, dArr, this.f2485n);
    }

    protected void solveL(double[] dArr) {
        int i = 0;
        for (int i2 = 0; i2 < this.f2485n; i2++) {
            int i3 = this.indx[i2] * 2;
            double d = dArr[i3];
            int i4 = i3 + 1;
            double d2 = dArr[i4];
            int i5 = i2 * 2;
            dArr[i3] = dArr[i5];
            int i6 = i5 + 1;
            dArr[i4] = dArr[i6];
            if (i != 0) {
                int i7 = i - 1;
                int i8 = (this.stride * i2) + (i7 * 2);
                while (i7 < i2) {
                    double[] dArr2 = this.dataLU;
                    int i9 = i8 + 1;
                    double d3 = dArr2[i8];
                    i8 += 2;
                    double d4 = dArr2[i9];
                    int i10 = i7 * 2;
                    double d5 = dArr[i10];
                    double d6 = dArr[i10 + 1];
                    d -= (d3 * d5) - (d4 * d6);
                    d2 -= (d3 * d6) + (d4 * d5);
                    i7++;
                }
            } else if ((d * d) + (d2 * d2) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                i = i2 + 1;
            }
            dArr[i5] = d;
            dArr[i6] = d2;
        }
    }

    public double[] _getVV() {
        return this.f2486vv;
    }
}
