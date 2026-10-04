package org.ejml.data;

import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class DMatrix2x2 implements DMatrixFixed {
    public double a11;
    public double a12;
    public double a21;
    public double a22;

    @Override // org.ejml.data.Matrix
    public int getNumCols() {
        return 2;
    }

    @Override // org.ejml.data.DMatrix
    public int getNumElements() {
        return 4;
    }

    @Override // org.ejml.data.Matrix
    public int getNumRows() {
        return 2;
    }

    public DMatrix2x2() {
    }

    public DMatrix2x2(double d, double d2, double d3, double d4) {
        this.a11 = d;
        this.a12 = d2;
        this.a21 = d3;
        this.a22 = d4;
    }

    public DMatrix2x2(DMatrix2x2 dMatrix2x2) {
        this.a11 = dMatrix2x2.a11;
        this.a12 = dMatrix2x2.a12;
        this.a21 = dMatrix2x2.a21;
        this.a22 = dMatrix2x2.a22;
    }

    @Override // org.ejml.data.DMatrix
    public double get(int i, int i2) {
        return unsafe_get(i, i2);
    }

    @Override // org.ejml.data.DMatrix
    public double unsafe_get(int i, int i2) {
        if (i == 0) {
            if (i2 == 0) {
                return this.a11;
            }
            if (i2 == 1) {
                return this.a12;
            }
        } else if (i == 1) {
            if (i2 == 0) {
                return this.a21;
            }
            if (i2 == 1) {
                return this.a22;
            }
        }
        throw new IllegalArgumentException("Row and/or column out of range. " + i + " " + i2);
    }

    @Override // org.ejml.data.DMatrix
    public void set(int i, int i2, double d) {
        unsafe_set(i, i2, d);
    }

    @Override // org.ejml.data.DMatrix
    public void unsafe_set(int i, int i2, double d) {
        if (i == 0) {
            if (i2 == 0) {
                this.a11 = d;
                return;
            } else if (i2 == 1) {
                this.a12 = d;
                return;
            }
        } else if (i == 1) {
            if (i2 == 0) {
                this.a21 = d;
                return;
            } else if (i2 == 1) {
                this.a22 = d;
                return;
            }
        }
        throw new IllegalArgumentException("Row and/or column out of range. " + i + " " + i2);
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        if (matrix.getNumCols() != 2 || matrix.getNumRows() != 2) {
            throw new IllegalArgumentException("Rows and/or columns do not match");
        }
        DMatrix dMatrix = (DMatrix) matrix;
        this.a11 = dMatrix.get(0, 0);
        this.a12 = dMatrix.get(0, 1);
        this.a21 = dMatrix.get(1, 0);
        this.a22 = dMatrix.get(1, 1);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T copy() {
        return new DMatrix2x2(this);
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new DMatrix2x2();
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
