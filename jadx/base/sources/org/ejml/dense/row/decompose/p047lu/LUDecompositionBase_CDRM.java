package org.ejml.dense.row.decompose.p047lu;

import org.ejml.UtilEjml;
import org.ejml.data.CMatrixRMaj;
import org.ejml.data.Complex_F32;
import org.ejml.data.IGrowArray;
import org.ejml.dense.row.SpecializedOps_CDRM;
import org.ejml.dense.row.decompose.TriangularSolver_CDRM;
import org.ejml.dense.row.decompose.UtilDecompositons_CDRM;
import org.ejml.interfaces.decomposition.LUDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public abstract class LUDecompositionBase_CDRM implements LUDecomposition_F32<CMatrixRMaj> {

    /* JADX INFO: renamed from: LU */
    protected CMatrixRMaj f2479LU;
    protected float[] dataLU;
    protected int[] indx;

    /* JADX INFO: renamed from: m */
    protected int f2480m;

    /* JADX INFO: renamed from: n */
    protected int f2481n;
    protected int[] pivot;
    protected float pivsign;
    protected int stride;

    /* JADX INFO: renamed from: vv */
    protected float[] f2482vv;
    protected int maxWidth = -1;
    protected Complex_F32 det = new Complex_F32();

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    public void setExpectedMaxSize(int i, int i2) {
        CMatrixRMaj cMatrixRMaj = new CMatrixRMaj(i, i2);
        this.f2479LU = cMatrixRMaj;
        this.dataLU = cMatrixRMaj.data;
        int iMax = Math.max(i, i2);
        this.maxWidth = iMax;
        this.f2482vv = new float[iMax * 2];
        this.indx = new int[iMax];
        this.pivot = new int[iMax];
    }

    public CMatrixRMaj getLU() {
        return this.f2479LU;
    }

    public int[] getIndx() {
        return this.indx;
    }

    public int[] getPivot() {
        return this.pivot;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public CMatrixRMaj getLower(CMatrixRMaj cMatrixRMaj) {
        int i = this.f2479LU.numRows;
        int i2 = this.f2479LU.numRows < this.f2479LU.numCols ? this.f2479LU.numRows : this.f2479LU.numCols;
        CMatrixRMaj cMatrixRMajCheckZerosUT = UtilDecompositons_CDRM.checkZerosUT(cMatrixRMaj, i, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            cMatrixRMajCheckZerosUT.set(i3, i3, 1.0f, 0.0f);
            for (int i4 = 0; i4 < i3; i4++) {
                int index = this.f2479LU.getIndex(i3, i4);
                int index2 = cMatrixRMajCheckZerosUT.getIndex(i3, i4);
                float f = this.f2479LU.data[index];
                float f2 = this.f2479LU.data[index + 1];
                cMatrixRMajCheckZerosUT.data[index2] = f;
                cMatrixRMajCheckZerosUT.data[index2 + 1] = f2;
            }
        }
        if (i > i2) {
            for (int i5 = i2; i5 < i; i5++) {
                for (int i6 = 0; i6 < i2; i6++) {
                    int index3 = this.f2479LU.getIndex(i5, i6);
                    int index4 = cMatrixRMajCheckZerosUT.getIndex(i5, i6);
                    float f3 = this.f2479LU.data[index3];
                    float f4 = this.f2479LU.data[index3 + 1];
                    cMatrixRMajCheckZerosUT.data[index4] = f3;
                    cMatrixRMajCheckZerosUT.data[index4 + 1] = f4;
                }
            }
        }
        return cMatrixRMajCheckZerosUT;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public CMatrixRMaj getUpper(CMatrixRMaj cMatrixRMaj) {
        int i = this.f2479LU.numRows < this.f2479LU.numCols ? this.f2479LU.numRows : this.f2479LU.numCols;
        int i2 = this.f2479LU.numCols;
        CMatrixRMaj cMatrixRMajCheckZerosLT = UtilDecompositons_CDRM.checkZerosLT(cMatrixRMaj, i, i2);
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = i3; i4 < i2; i4++) {
                int index = this.f2479LU.getIndex(i3, i4);
                int index2 = cMatrixRMajCheckZerosLT.getIndex(i3, i4);
                float f = this.f2479LU.data[index];
                float f2 = this.f2479LU.data[index + 1];
                cMatrixRMajCheckZerosLT.data[index2] = f;
                cMatrixRMajCheckZerosLT.data[index2 + 1] = f2;
            }
        }
        return cMatrixRMajCheckZerosLT;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public CMatrixRMaj getRowPivot(CMatrixRMaj cMatrixRMaj) {
        return SpecializedOps_CDRM.pivotMatrix(cMatrixRMaj, this.pivot, this.f2479LU.numRows, false);
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public int[] getRowPivotV(IGrowArray iGrowArray) {
        return UtilEjml.pivotVector(this.pivot, this.f2479LU.numRows, iGrowArray);
    }

    protected void decomposeCommonInit(CMatrixRMaj cMatrixRMaj) {
        if (cMatrixRMaj.numRows > this.maxWidth || cMatrixRMaj.numCols > this.maxWidth) {
            setExpectedMaxSize(cMatrixRMaj.numRows, cMatrixRMaj.numCols);
        }
        this.f2480m = cMatrixRMaj.numRows;
        int i = cMatrixRMaj.numCols;
        this.f2481n = i;
        this.stride = i * 2;
        this.f2479LU.set(cMatrixRMaj);
        for (int i2 = 0; i2 < this.f2480m; i2++) {
            this.pivot[i2] = i2;
        }
        this.pivsign = 1.0f;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public boolean isSingular() {
        for (int i = 0; i < this.f2480m; i++) {
            float[] fArr = this.dataLU;
            int i2 = this.stride;
            int i3 = i * 2;
            float f = fArr[(i * i2) + i3];
            float f2 = fArr[(i2 * i) + i3 + 1];
            if ((f * f) + (f2 * f2) < UtilEjml.F_EPS * UtilEjml.F_EPS) {
                return true;
            }
        }
        return false;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition_F32
    public Complex_F32 computeDeterminant() {
        int i = this.f2480m;
        if (i != this.f2481n) {
            throw new IllegalArgumentException("Must be a square matrix.");
        }
        float f = this.pivsign;
        int i2 = i * this.stride;
        float f2 = 0.0f;
        int i3 = 0;
        while (i3 < i2) {
            float[] fArr = this.dataLU;
            float f3 = fArr[i3];
            float f4 = fArr[i3 + 1];
            float f5 = (f * f3) - (f2 * f4);
            f2 = (f2 * f3) + (f * f4);
            i3 += this.stride + 2;
            f = f5;
        }
        this.det.set(f, f2);
        return this.det;
    }

    public double quality() {
        return SpecializedOps_CDRM.qualityTriangular(this.f2479LU);
    }

    public void _solveVectorInternal(float[] fArr) {
        solveL(fArr);
        TriangularSolver_CDRM.solveU(this.dataLU, fArr, this.f2481n);
    }

    protected void solveL(float[] fArr) {
        int i = 0;
        for (int i2 = 0; i2 < this.f2481n; i2++) {
            int i3 = this.indx[i2] * 2;
            float f = fArr[i3];
            int i4 = i3 + 1;
            float f2 = fArr[i4];
            int i5 = i2 * 2;
            fArr[i3] = fArr[i5];
            int i6 = i5 + 1;
            fArr[i4] = fArr[i6];
            if (i != 0) {
                int i7 = i - 1;
                int i8 = (this.stride * i2) + (i7 * 2);
                while (i7 < i2) {
                    float[] fArr2 = this.dataLU;
                    int i9 = i8 + 1;
                    float f3 = fArr2[i8];
                    i8 += 2;
                    float f4 = fArr2[i9];
                    int i10 = i7 * 2;
                    float f5 = fArr[i10];
                    float f6 = fArr[i10 + 1];
                    f -= (f3 * f5) - (f4 * f6);
                    f2 -= (f3 * f6) + (f4 * f5);
                    i7++;
                }
            } else if ((f * f) + (f2 * f2) != 0.0f) {
                i = i2 + 1;
            }
            fArr[i5] = f;
            fArr[i6] = f2;
        }
    }

    public float[] _getVV() {
        return this.f2482vv;
    }
}
