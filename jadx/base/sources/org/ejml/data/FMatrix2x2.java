package org.ejml.data;

import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class FMatrix2x2 implements FMatrixFixed {
    public float a11;
    public float a12;
    public float a21;
    public float a22;

    @Override // org.ejml.data.Matrix
    public int getNumCols() {
        return 2;
    }

    @Override // org.ejml.data.FMatrix
    public int getNumElements() {
        return 4;
    }

    @Override // org.ejml.data.Matrix
    public int getNumRows() {
        return 2;
    }

    public FMatrix2x2() {
    }

    public FMatrix2x2(float f, float f2, float f3, float f4) {
        this.a11 = f;
        this.a12 = f2;
        this.a21 = f3;
        this.a22 = f4;
    }

    public FMatrix2x2(FMatrix2x2 fMatrix2x2) {
        this.a11 = fMatrix2x2.a11;
        this.a12 = fMatrix2x2.a12;
        this.a21 = fMatrix2x2.a21;
        this.a22 = fMatrix2x2.a22;
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
            }
        } else if (i == 1) {
            if (i2 == 0) {
                this.a21 = f;
                return;
            } else if (i2 == 1) {
                this.a22 = f;
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
        FMatrix fMatrix = (FMatrix) matrix;
        this.a11 = fMatrix.get(0, 0);
        this.a12 = fMatrix.get(0, 1);
        this.a21 = fMatrix.get(1, 0);
        this.a22 = fMatrix.get(1, 1);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T copy() {
        return new FMatrix2x2(this);
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new FMatrix2x2();
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
