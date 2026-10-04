package org.ejml.dense.row.decomposition.p049lu;

import org.ejml.UtilEjml;
import org.ejml.data.Complex_F32;
import org.ejml.data.FMatrixD1;
import org.ejml.data.FMatrixRMaj;
import org.ejml.data.IGrowArray;
import org.ejml.dense.row.SpecializedOps_FDRM;
import org.ejml.dense.row.decomposition.TriangularSolver_FDRM;
import org.ejml.dense.row.decomposition.UtilDecompositons_FDRM;
import org.ejml.interfaces.decomposition.LUDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public abstract class LUDecompositionBase_FDRM implements LUDecomposition_F32<FMatrixRMaj> {

    /* JADX INFO: renamed from: LU */
    protected FMatrixRMaj f2617LU;
    protected float[] dataLU;
    protected int[] indx;

    /* JADX INFO: renamed from: m */
    protected int f2618m;

    /* JADX INFO: renamed from: n */
    protected int f2619n;
    protected int[] pivot;
    protected float pivsign;

    /* JADX INFO: renamed from: vv */
    protected float[] f2620vv;
    protected int maxWidth = -1;
    Complex_F32 det = new Complex_F32();

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    public void setExpectedMaxSize(int i, int i2) {
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(i, i2);
        this.f2617LU = fMatrixRMaj;
        this.dataLU = fMatrixRMaj.data;
        int iMax = Math.max(i, i2);
        this.maxWidth = iMax;
        this.f2620vv = new float[iMax];
        this.indx = new int[iMax];
        this.pivot = new int[iMax];
    }

    public FMatrixRMaj getLU() {
        return this.f2617LU;
    }

    public int[] getIndx() {
        return this.indx;
    }

    public int[] getPivot() {
        return this.pivot;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public FMatrixRMaj getLower(FMatrixRMaj fMatrixRMaj) {
        int i = this.f2617LU.numRows;
        int i2 = this.f2617LU.numRows < this.f2617LU.numCols ? this.f2617LU.numRows : this.f2617LU.numCols;
        FMatrixRMaj fMatrixRMajCheckZerosUT = UtilDecompositons_FDRM.checkZerosUT(fMatrixRMaj, i, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            fMatrixRMajCheckZerosUT.unsafe_set(i3, i3, 1.0f);
            for (int i4 = 0; i4 < i3; i4++) {
                fMatrixRMajCheckZerosUT.unsafe_set(i3, i4, this.f2617LU.unsafe_get(i3, i4));
            }
        }
        if (i > i2) {
            for (int i5 = i2; i5 < i; i5++) {
                for (int i6 = 0; i6 < i2; i6++) {
                    fMatrixRMajCheckZerosUT.unsafe_set(i5, i6, this.f2617LU.unsafe_get(i5, i6));
                }
            }
        }
        return fMatrixRMajCheckZerosUT;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public FMatrixRMaj getUpper(FMatrixRMaj fMatrixRMaj) {
        int i = this.f2617LU.numRows < this.f2617LU.numCols ? this.f2617LU.numRows : this.f2617LU.numCols;
        int i2 = this.f2617LU.numCols;
        FMatrixRMaj fMatrixRMajCheckZerosLT = UtilDecompositons_FDRM.checkZerosLT(fMatrixRMaj, i, i2);
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = i3; i4 < i2; i4++) {
                fMatrixRMajCheckZerosLT.unsafe_set(i3, i4, this.f2617LU.unsafe_get(i3, i4));
            }
        }
        return fMatrixRMajCheckZerosLT;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public FMatrixRMaj getRowPivot(FMatrixRMaj fMatrixRMaj) {
        return SpecializedOps_FDRM.pivotMatrix(fMatrixRMaj, this.pivot, this.f2617LU.numRows, false);
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public int[] getRowPivotV(IGrowArray iGrowArray) {
        return UtilEjml.pivotVector(this.pivot, this.f2617LU.numRows, iGrowArray);
    }

    protected void decomposeCommonInit(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj.numRows > this.maxWidth || fMatrixRMaj.numCols > this.maxWidth) {
            setExpectedMaxSize(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        }
        this.f2618m = fMatrixRMaj.numRows;
        this.f2619n = fMatrixRMaj.numCols;
        this.f2617LU.set((FMatrixD1) fMatrixRMaj);
        for (int i = 0; i < this.f2618m; i++) {
            this.pivot[i] = i;
        }
        this.pivsign = 1.0f;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition
    public boolean isSingular() {
        for (int i = 0; i < this.f2618m; i++) {
            if (Math.abs(this.dataLU[(this.f2619n * i) + i]) < UtilEjml.F_EPS) {
                return true;
            }
        }
        return false;
    }

    @Override // org.ejml.interfaces.decomposition.LUDecomposition_F32
    public Complex_F32 computeDeterminant() {
        int i = this.f2618m;
        int i2 = this.f2619n;
        if (i != i2) {
            throw new IllegalArgumentException("Must be a square matrix.");
        }
        float f = this.pivsign;
        int i3 = i * i2;
        int i4 = 0;
        while (i4 < i3) {
            f *= this.dataLU[i4];
            i4 += this.f2619n + 1;
        }
        this.det.real = f;
        this.det.imaginary = 0.0f;
        return this.det;
    }

    public double quality() {
        return SpecializedOps_FDRM.qualityTriangular(this.f2617LU);
    }

    public void _solveVectorInternal(float[] fArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = this.f2619n;
            if (i < i3) {
                int i4 = this.indx[i];
                float f = fArr[i4];
                fArr[i4] = fArr[i];
                if (i2 != 0) {
                    int i5 = ((i3 * i) + i2) - 1;
                    int i6 = i2 - 1;
                    while (i6 < i) {
                        f -= this.dataLU[i5] * fArr[i6];
                        i6++;
                        i5++;
                    }
                } else if (f != 0.0f) {
                    i2 = i + 1;
                }
                fArr[i] = f;
                i++;
            } else {
                TriangularSolver_FDRM.solveU(this.dataLU, fArr, i3);
                return;
            }
        }
    }

    public float[] _getVV() {
        return this.f2620vv;
    }
}
