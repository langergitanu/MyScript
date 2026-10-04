package org.ejml.data;

import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class DMatrix2 implements DMatrixFixed {

    /* JADX INFO: renamed from: a1 */
    public double f2397a1;

    /* JADX INFO: renamed from: a2 */
    public double f2398a2;

    @Override // org.ejml.data.Matrix
    public int getNumCols() {
        return 1;
    }

    @Override // org.ejml.data.DMatrix
    public int getNumElements() {
        return 2;
    }

    @Override // org.ejml.data.Matrix
    public int getNumRows() {
        return 2;
    }

    public DMatrix2() {
    }

    public DMatrix2(double d, double d2) {
        this.f2397a1 = d;
        this.f2398a2 = d2;
    }

    public DMatrix2(DMatrix2 dMatrix2) {
        this.f2397a1 = dMatrix2.f2397a1;
        this.f2398a2 = dMatrix2.f2398a2;
    }

    @Override // org.ejml.data.DMatrix
    public double get(int i, int i2) {
        return unsafe_get(i, i2);
    }

    @Override // org.ejml.data.DMatrix
    public double unsafe_get(int i, int i2) {
        if (i != 0 && i2 != 0) {
            throw new IllegalArgumentException("Row or column must be zero since this is a vector");
        }
        int iMax = Math.max(i, i2);
        if (iMax == 0) {
            return this.f2397a1;
        }
        if (iMax == 1) {
            return this.f2398a2;
        }
        throw new IllegalArgumentException("Out of range.  " + iMax);
    }

    @Override // org.ejml.data.DMatrix
    public void set(int i, int i2, double d) {
        unsafe_set(i, i2, d);
    }

    @Override // org.ejml.data.DMatrix
    public void unsafe_set(int i, int i2, double d) {
        if (i != 0 && i2 != 0) {
            throw new IllegalArgumentException("Row or column must be zero since this is a vector");
        }
        int iMax = Math.max(i, i2);
        if (iMax == 0) {
            this.f2397a1 = d;
        } else {
            if (iMax == 1) {
                this.f2398a2 = d;
                return;
            }
            throw new IllegalArgumentException("Out of range.  " + iMax);
        }
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        DMatrix dMatrix = (DMatrix) matrix;
        if (dMatrix.getNumCols() == 1 && dMatrix.getNumRows() == 2) {
            this.f2397a1 = dMatrix.get(0, 0);
            this.f2398a2 = dMatrix.get(1, 0);
        } else {
            if (dMatrix.getNumRows() == 1 && dMatrix.getNumCols() == 2) {
                this.f2397a1 = dMatrix.get(0, 0);
                this.f2398a2 = dMatrix.get(0, 1);
                return;
            }
            throw new IllegalArgumentException("Incompatible shape");
        }
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T copy() {
        return new DMatrix2(this);
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new DMatrix2();
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
