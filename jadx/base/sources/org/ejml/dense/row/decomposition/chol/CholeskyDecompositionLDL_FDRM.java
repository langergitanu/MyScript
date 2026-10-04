package org.ejml.dense.row.decomposition.chol;

import org.ejml.data.FMatrixD1;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.interfaces.decomposition.CholeskyLDLDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class CholeskyDecompositionLDL_FDRM implements CholeskyLDLDecomposition_F32<FMatrixRMaj> {

    /* JADX INFO: renamed from: L */
    private FMatrixRMaj f2531L;

    /* JADX INFO: renamed from: d */
    private float[] f2532d;
    private int maxWidth;

    /* JADX INFO: renamed from: n */
    private int f2533n;

    /* JADX INFO: renamed from: vv */
    float[] f2534vv;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    public void setExpectedMaxSize(int i, int i2) {
        if (i != i2) {
            throw new IllegalArgumentException("Can only decompose square matrices");
        }
        this.maxWidth = i;
        int i3 = this.maxWidth;
        this.f2531L = new FMatrixRMaj(i3, i3);
        int i4 = this.maxWidth;
        this.f2534vv = new float[i4];
        this.f2532d = new float[i4];
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:
    
        r2 = r2 + 1;
     */
    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean decompose(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj.numRows > this.maxWidth) {
            setExpectedMaxSize(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        } else if (fMatrixRMaj.numRows != fMatrixRMaj.numCols) {
            throw new RuntimeException("Can only decompose square matrices");
        }
        this.f2533n = fMatrixRMaj.numRows;
        this.f2531L.set((FMatrixD1) fMatrixRMaj);
        float[] fArr = this.f2531L.data;
        int i = 0;
        float f = 0.0f;
        int i2 = 0;
        while (i2 < this.f2533n) {
            int i3 = i2;
            while (true) {
                int i4 = this.f2533n;
                if (i3 < i4) {
                    float f2 = fArr[(i4 * i2) + i3];
                    for (int i5 = 0; i5 < i2; i5++) {
                        int i6 = this.f2533n;
                        f2 -= (fArr[(i2 * i6) + i5] * fArr[(i6 * i3) + i5]) * this.f2532d[i5];
                    }
                    if (i2 == i3) {
                        if (f2 <= 0.0f) {
                            return false;
                        }
                        this.f2532d[i2] = f2;
                        fArr[(this.f2533n * i2) + i2] = 1.0f;
                        f = 1.0f / f2;
                    } else {
                        fArr[(this.f2533n * i3) + i2] = f2 * f;
                    }
                    i3++;
                }
            }
        }
        while (i < this.f2533n) {
            int i7 = i + 1;
            int i8 = i7;
            while (true) {
                int i9 = this.f2533n;
                if (i8 < i9) {
                    fArr[(i9 * i) + i8] = 0.0f;
                    i8++;
                }
            }
            i = i7;
        }
        return true;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyLDLDecomposition_F32
    public float[] getDiagonal() {
        return this.f2532d;
    }

    public FMatrixRMaj getL() {
        return this.f2531L;
    }

    public float[] _getVV() {
        return this.f2534vv;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyLDLDecomposition
    public FMatrixRMaj getL(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj == null) {
            return this.f2531L.copy();
        }
        fMatrixRMaj.set((FMatrixD1) this.f2531L);
        return fMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyLDLDecomposition
    public FMatrixRMaj getD(FMatrixRMaj fMatrixRMaj) {
        return CommonOps_FDRM.diag(fMatrixRMaj, this.f2531L.numCols, this.f2532d);
    }
}
