package org.ejml.data;

import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class FMatrix2 implements FMatrixFixed {

    /* JADX INFO: renamed from: a1 */
    public float f2418a1;

    /* JADX INFO: renamed from: a2 */
    public float f2419a2;

    @Override // org.ejml.data.Matrix
    public int getNumCols() {
        return 1;
    }

    @Override // org.ejml.data.FMatrix
    public int getNumElements() {
        return 2;
    }

    @Override // org.ejml.data.Matrix
    public int getNumRows() {
        return 2;
    }

    public FMatrix2() {
    }

    public FMatrix2(float f, float f2) {
        this.f2418a1 = f;
        this.f2419a2 = f2;
    }

    public FMatrix2(FMatrix2 fMatrix2) {
        this.f2418a1 = fMatrix2.f2418a1;
        this.f2419a2 = fMatrix2.f2419a2;
    }

    @Override // org.ejml.data.FMatrix
    public float get(int i, int i2) {
        return unsafe_get(i, i2);
    }

    @Override // org.ejml.data.FMatrix
    public float unsafe_get(int i, int i2) {
        if (i != 0 && i2 != 0) {
            throw new IllegalArgumentException("Row or column must be zero since this is a vector");
        }
        int iMax = Math.max(i, i2);
        if (iMax == 0) {
            return this.f2418a1;
        }
        if (iMax == 1) {
            return this.f2419a2;
        }
        throw new IllegalArgumentException("Out of range.  " + iMax);
    }

    @Override // org.ejml.data.FMatrix
    public void set(int i, int i2, float f) {
        unsafe_set(i, i2, f);
    }

    @Override // org.ejml.data.FMatrix
    public void unsafe_set(int i, int i2, float f) {
        if (i != 0 && i2 != 0) {
            throw new IllegalArgumentException("Row or column must be zero since this is a vector");
        }
        int iMax = Math.max(i, i2);
        if (iMax == 0) {
            this.f2418a1 = f;
        } else {
            if (iMax == 1) {
                this.f2419a2 = f;
                return;
            }
            throw new IllegalArgumentException("Out of range.  " + iMax);
        }
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        FMatrix fMatrix = (FMatrix) matrix;
        if (fMatrix.getNumCols() == 1 && fMatrix.getNumRows() == 2) {
            this.f2418a1 = fMatrix.get(0, 0);
            this.f2419a2 = fMatrix.get(1, 0);
        } else {
            if (fMatrix.getNumRows() == 1 && fMatrix.getNumCols() == 2) {
                this.f2418a1 = fMatrix.get(0, 0);
                this.f2419a2 = fMatrix.get(0, 1);
                return;
            }
            throw new IllegalArgumentException("Incompatible shape");
        }
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T copy() {
        return new FMatrix2(this);
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new FMatrix2();
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
