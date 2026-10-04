package org.ejml.data;

import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class DMatrix4x4 implements DMatrixFixed {
    public double a11;
    public double a12;
    public double a13;
    public double a14;
    public double a21;
    public double a22;
    public double a23;
    public double a24;
    public double a31;
    public double a32;
    public double a33;
    public double a34;
    public double a41;
    public double a42;
    public double a43;
    public double a44;

    @Override // org.ejml.data.Matrix
    public int getNumCols() {
        return 4;
    }

    @Override // org.ejml.data.DMatrix
    public int getNumElements() {
        return 16;
    }

    @Override // org.ejml.data.Matrix
    public int getNumRows() {
        return 4;
    }

    public DMatrix4x4() {
    }

    public DMatrix4x4(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16) {
        this.a11 = d;
        this.a12 = d2;
        this.a13 = d3;
        this.a14 = d4;
        this.a21 = d5;
        this.a22 = d6;
        this.a23 = d7;
        this.a24 = d8;
        this.a31 = d9;
        this.a32 = d10;
        this.a33 = d11;
        this.a34 = d12;
        this.a41 = d13;
        this.a42 = d14;
        this.a43 = d15;
        this.a44 = d16;
    }

    public DMatrix4x4(DMatrix4x4 dMatrix4x4) {
        this.a11 = dMatrix4x4.a11;
        this.a12 = dMatrix4x4.a12;
        this.a13 = dMatrix4x4.a13;
        this.a14 = dMatrix4x4.a14;
        this.a21 = dMatrix4x4.a21;
        this.a22 = dMatrix4x4.a22;
        this.a23 = dMatrix4x4.a23;
        this.a24 = dMatrix4x4.a24;
        this.a31 = dMatrix4x4.a31;
        this.a32 = dMatrix4x4.a32;
        this.a33 = dMatrix4x4.a33;
        this.a34 = dMatrix4x4.a34;
        this.a41 = dMatrix4x4.a41;
        this.a42 = dMatrix4x4.a42;
        this.a43 = dMatrix4x4.a43;
        this.a44 = dMatrix4x4.a44;
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
            if (i2 == 3) {
                return this.a14;
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
            if (i2 == 3) {
                return this.a24;
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
            if (i2 == 3) {
                return this.a34;
            }
        } else if (i == 3) {
            if (i2 == 0) {
                return this.a41;
            }
            if (i2 == 1) {
                return this.a42;
            }
            if (i2 == 2) {
                return this.a43;
            }
            if (i2 == 3) {
                return this.a44;
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
            }
            if (i2 == 1) {
                this.a12 = d;
                return;
            } else if (i2 == 2) {
                this.a13 = d;
                return;
            } else if (i2 == 3) {
                this.a14 = d;
                return;
            }
        } else if (i == 1) {
            if (i2 == 0) {
                this.a21 = d;
                return;
            }
            if (i2 == 1) {
                this.a22 = d;
                return;
            } else if (i2 == 2) {
                this.a23 = d;
                return;
            } else if (i2 == 3) {
                this.a24 = d;
                return;
            }
        } else if (i == 2) {
            if (i2 == 0) {
                this.a31 = d;
                return;
            }
            if (i2 == 1) {
                this.a32 = d;
                return;
            } else if (i2 == 2) {
                this.a33 = d;
                return;
            } else if (i2 == 3) {
                this.a34 = d;
                return;
            }
        } else if (i == 3) {
            if (i2 == 0) {
                this.a41 = d;
                return;
            }
            if (i2 == 1) {
                this.a42 = d;
                return;
            } else if (i2 == 2) {
                this.a43 = d;
                return;
            } else if (i2 == 3) {
                this.a44 = d;
                return;
            }
        }
        throw new IllegalArgumentException("Row and/or column out of range. " + i + " " + i2);
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        if (matrix.getNumCols() != 4 || matrix.getNumRows() != 4) {
            throw new IllegalArgumentException("Rows and/or columns do not match");
        }
        DMatrix dMatrix = (DMatrix) matrix;
        this.a11 = dMatrix.get(0, 0);
        this.a12 = dMatrix.get(0, 1);
        this.a13 = dMatrix.get(0, 2);
        this.a14 = dMatrix.get(0, 3);
        this.a21 = dMatrix.get(1, 0);
        this.a22 = dMatrix.get(1, 1);
        this.a23 = dMatrix.get(1, 2);
        this.a24 = dMatrix.get(1, 3);
        this.a31 = dMatrix.get(2, 0);
        this.a32 = dMatrix.get(2, 1);
        this.a33 = dMatrix.get(2, 2);
        this.a34 = dMatrix.get(2, 3);
        this.a41 = dMatrix.get(3, 0);
        this.a42 = dMatrix.get(3, 1);
        this.a43 = dMatrix.get(3, 2);
        this.a44 = dMatrix.get(3, 3);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T copy() {
        return new DMatrix4x4(this);
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new DMatrix4x4();
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
