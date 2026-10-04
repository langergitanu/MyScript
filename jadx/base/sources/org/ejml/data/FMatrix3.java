package org.ejml.data;

import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class FMatrix3 implements FMatrixFixed {

    /* JADX INFO: renamed from: a1 */
    public float f2420a1;

    /* JADX INFO: renamed from: a2 */
    public float f2421a2;

    /* JADX INFO: renamed from: a3 */
    public float f2422a3;

    @Override // org.ejml.data.Matrix
    public int getNumCols() {
        return 1;
    }

    @Override // org.ejml.data.FMatrix
    public int getNumElements() {
        return 3;
    }

    @Override // org.ejml.data.Matrix
    public int getNumRows() {
        return 3;
    }

    public FMatrix3() {
    }

    public FMatrix3(float f, float f2, float f3) {
        this.f2420a1 = f;
        this.f2421a2 = f2;
        this.f2422a3 = f3;
    }

    public FMatrix3(FMatrix3 fMatrix3) {
        this.f2420a1 = fMatrix3.f2420a1;
        this.f2421a2 = fMatrix3.f2421a2;
        this.f2422a3 = fMatrix3.f2422a3;
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
            return this.f2420a1;
        }
        if (iMax == 1) {
            return this.f2421a2;
        }
        if (iMax == 2) {
            return this.f2422a3;
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
            this.f2420a1 = f;
        } else if (iMax == 1) {
            this.f2421a2 = f;
        } else {
            if (iMax == 2) {
                this.f2422a3 = f;
                return;
            }
            throw new IllegalArgumentException("Out of range.  " + iMax);
        }
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        FMatrix fMatrix = (FMatrix) matrix;
        if (fMatrix.getNumCols() == 1 && fMatrix.getNumRows() == 3) {
            this.f2420a1 = fMatrix.get(0, 0);
            this.f2421a2 = fMatrix.get(1, 0);
            this.f2422a3 = fMatrix.get(2, 0);
        } else {
            if (fMatrix.getNumRows() == 1 && fMatrix.getNumCols() == 3) {
                this.f2420a1 = fMatrix.get(0, 0);
                this.f2421a2 = fMatrix.get(0, 1);
                this.f2422a3 = fMatrix.get(0, 2);
                return;
            }
            throw new IllegalArgumentException("Incompatible shape");
        }
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T copy() {
        return new FMatrix3(this);
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new FMatrix3();
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
