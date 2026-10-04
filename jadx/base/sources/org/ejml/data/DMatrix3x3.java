package org.ejml.data;

import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class DMatrix3x3 implements DMatrixFixed {
    public double a11;
    public double a12;
    public double a13;
    public double a21;
    public double a22;
    public double a23;
    public double a31;
    public double a32;
    public double a33;

    @Override // org.ejml.data.Matrix
    public int getNumCols() {
        return 3;
    }

    @Override // org.ejml.data.DMatrix
    public int getNumElements() {
        return 9;
    }

    @Override // org.ejml.data.Matrix
    public int getNumRows() {
        return 3;
    }

    public DMatrix3x3() {
    }

    public DMatrix3x3(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.a11 = d;
        this.a12 = d2;
        this.a13 = d3;
        this.a21 = d4;
        this.a22 = d5;
        this.a23 = d6;
        this.a31 = d7;
        this.a32 = d8;
        this.a33 = d9;
    }

    public DMatrix3x3(DMatrix3x3 dMatrix3x3) {
        this.a11 = dMatrix3x3.a11;
        this.a12 = dMatrix3x3.a12;
        this.a13 = dMatrix3x3.a13;
        this.a21 = dMatrix3x3.a21;
        this.a22 = dMatrix3x3.a22;
        this.a23 = dMatrix3x3.a23;
        this.a31 = dMatrix3x3.a31;
        this.a32 = dMatrix3x3.a32;
        this.a33 = dMatrix3x3.a33;
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
            if (i2 == 2) {
                return this.a13;
            }
        } else if (i == 1) {
            if (i2 == 0) {
                return this.a21;
            }
            if (i2 == 1) {
                return this.a22;
            }
            if (i2 == 2) {
                return this.a23;
            }
        } else if (i == 2) {
            if (i2 == 0) {
                return this.a31;
            }
            if (i2 == 1) {
                return this.a32;
            }
            if (i2 == 2) {
                return this.a33;
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
            } else if (i2 == 2) {
                this.a13 = d;
                return;
            }
        } else if (i == 1) {
            if (i2 == 0) {
                this.a21 = d;
                return;
            } else if (i2 == 1) {
                this.a22 = d;
                return;
            } else if (i2 == 2) {
                this.a23 = d;
                return;
            }
        } else if (i == 2) {
            if (i2 == 0) {
                this.a31 = d;
                return;
            } else if (i2 == 1) {
                this.a32 = d;
                return;
            } else if (i2 == 2) {
                this.a33 = d;
                return;
            }
        }
        throw new IllegalArgumentException("Row and/or column out of range. " + i + " " + i2);
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        if (matrix.getNumCols() != 3 || matrix.getNumRows() != 3) {
            throw new IllegalArgumentException("Rows and/or columns do not match");
        }
        DMatrix dMatrix = (DMatrix) matrix;
        this.a11 = dMatrix.get(0, 0);
        this.a12 = dMatrix.get(0, 1);
        this.a13 = dMatrix.get(0, 2);
        this.a21 = dMatrix.get(1, 0);
        this.a22 = dMatrix.get(1, 1);
        this.a23 = dMatrix.get(1, 2);
        this.a31 = dMatrix.get(2, 0);
        this.a32 = dMatrix.get(2, 1);
        this.a33 = dMatrix.get(2, 2);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T copy() {
        return new DMatrix3x3(this);
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new DMatrix3x3();
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
