package org.ejml.data;

import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class FMatrix3x3 implements FMatrixFixed {
    public float a11;
    public float a12;
    public float a13;
    public float a21;
    public float a22;
    public float a23;
    public float a31;
    public float a32;
    public float a33;

    @Override // org.ejml.data.Matrix
    public int getNumCols() {
        return 3;
    }

    @Override // org.ejml.data.FMatrix
    public int getNumElements() {
        return 9;
    }

    @Override // org.ejml.data.Matrix
    public int getNumRows() {
        return 3;
    }

    public FMatrix3x3() {
    }

    public FMatrix3x3(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.a11 = f;
        this.a12 = f2;
        this.a13 = f3;
        this.a21 = f4;
        this.a22 = f5;
        this.a23 = f6;
        this.a31 = f7;
        this.a32 = f8;
        this.a33 = f9;
    }

    public FMatrix3x3(FMatrix3x3 fMatrix3x3) {
        this.a11 = fMatrix3x3.a11;
        this.a12 = fMatrix3x3.a12;
        this.a13 = fMatrix3x3.a13;
        this.a21 = fMatrix3x3.a21;
        this.a22 = fMatrix3x3.a22;
        this.a23 = fMatrix3x3.a23;
        this.a31 = fMatrix3x3.a31;
        this.a32 = fMatrix3x3.a32;
        this.a33 = fMatrix3x3.a33;
    }

    @Override // org.ejml.data.FMatrix
    public float get(int i, int i2) {
        return unsafe_get(i, i2);
    }

    @Override // org.ejml.data.FMatrix
    public float unsafe_get(int i, int i2) {
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

    @Override // org.ejml.data.FMatrix
    public void set(int i, int i2, float f) {
        unsafe_set(i, i2, f);
    }

    @Override // org.ejml.data.FMatrix
    public void unsafe_set(int i, int i2, float f) {
        if (i == 0) {
            if (i2 == 0) {
                this.a11 = f;
                return;
            } else if (i2 == 1) {
                this.a12 = f;
                return;
            } else if (i2 == 2) {
                this.a13 = f;
                return;
            }
        } else if (i == 1) {
            if (i2 == 0) {
                this.a21 = f;
                return;
            } else if (i2 == 1) {
                this.a22 = f;
                return;
            } else if (i2 == 2) {
                this.a23 = f;
                return;
            }
        } else if (i == 2) {
            if (i2 == 0) {
                this.a31 = f;
                return;
            } else if (i2 == 1) {
                this.a32 = f;
                return;
            } else if (i2 == 2) {
                this.a33 = f;
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
        FMatrix fMatrix = (FMatrix) matrix;
        this.a11 = fMatrix.get(0, 0);
        this.a12 = fMatrix.get(0, 1);
        this.a13 = fMatrix.get(0, 2);
        this.a21 = fMatrix.get(1, 0);
        this.a22 = fMatrix.get(1, 1);
        this.a23 = fMatrix.get(1, 2);
        this.a31 = fMatrix.get(2, 0);
        this.a32 = fMatrix.get(2, 1);
        this.a33 = fMatrix.get(2, 2);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T copy() {
        return new FMatrix3x3(this);
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new FMatrix3x3();
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
