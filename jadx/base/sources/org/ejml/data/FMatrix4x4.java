package org.ejml.data;

import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class FMatrix4x4 implements FMatrixFixed {
    public float a11;
    public float a12;
    public float a13;
    public float a14;
    public float a21;
    public float a22;
    public float a23;
    public float a24;
    public float a31;
    public float a32;
    public float a33;
    public float a34;
    public float a41;
    public float a42;
    public float a43;
    public float a44;

    @Override // org.ejml.data.Matrix
    public int getNumCols() {
        return 4;
    }

    @Override // org.ejml.data.FMatrix
    public int getNumElements() {
        return 16;
    }

    @Override // org.ejml.data.Matrix
    public int getNumRows() {
        return 4;
    }

    public FMatrix4x4() {
    }

    public FMatrix4x4(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        this.a11 = f;
        this.a12 = f2;
        this.a13 = f3;
        this.a14 = f4;
        this.a21 = f5;
        this.a22 = f6;
        this.a23 = f7;
        this.a24 = f8;
        this.a31 = f9;
        this.a32 = f10;
        this.a33 = f11;
        this.a34 = f12;
        this.a41 = f13;
        this.a42 = f14;
        this.a43 = f15;
        this.a44 = f16;
    }

    public FMatrix4x4(FMatrix4x4 fMatrix4x4) {
        this.a11 = fMatrix4x4.a11;
        this.a12 = fMatrix4x4.a12;
        this.a13 = fMatrix4x4.a13;
        this.a14 = fMatrix4x4.a14;
        this.a21 = fMatrix4x4.a21;
        this.a22 = fMatrix4x4.a22;
        this.a23 = fMatrix4x4.a23;
        this.a24 = fMatrix4x4.a24;
        this.a31 = fMatrix4x4.a31;
        this.a32 = fMatrix4x4.a32;
        this.a33 = fMatrix4x4.a33;
        this.a34 = fMatrix4x4.a34;
        this.a41 = fMatrix4x4.a41;
        this.a42 = fMatrix4x4.a42;
        this.a43 = fMatrix4x4.a43;
        this.a44 = fMatrix4x4.a44;
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
            }
            if (i2 == 1) {
                this.a12 = f;
                return;
            } else if (i2 == 2) {
                this.a13 = f;
                return;
            } else if (i2 == 3) {
                this.a14 = f;
                return;
            }
        } else if (i == 1) {
            if (i2 == 0) {
                this.a21 = f;
                return;
            }
            if (i2 == 1) {
                this.a22 = f;
                return;
            } else if (i2 == 2) {
                this.a23 = f;
                return;
            } else if (i2 == 3) {
                this.a24 = f;
                return;
            }
        } else if (i == 2) {
            if (i2 == 0) {
                this.a31 = f;
                return;
            }
            if (i2 == 1) {
                this.a32 = f;
                return;
            } else if (i2 == 2) {
                this.a33 = f;
                return;
            } else if (i2 == 3) {
                this.a34 = f;
                return;
            }
        } else if (i == 3) {
            if (i2 == 0) {
                this.a41 = f;
                return;
            }
            if (i2 == 1) {
                this.a42 = f;
                return;
            } else if (i2 == 2) {
                this.a43 = f;
                return;
            } else if (i2 == 3) {
                this.a44 = f;
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
        FMatrix fMatrix = (FMatrix) matrix;
        this.a11 = fMatrix.get(0, 0);
        this.a12 = fMatrix.get(0, 1);
        this.a13 = fMatrix.get(0, 2);
        this.a14 = fMatrix.get(0, 3);
        this.a21 = fMatrix.get(1, 0);
        this.a22 = fMatrix.get(1, 1);
        this.a23 = fMatrix.get(1, 2);
        this.a24 = fMatrix.get(1, 3);
        this.a31 = fMatrix.get(2, 0);
        this.a32 = fMatrix.get(2, 1);
        this.a33 = fMatrix.get(2, 2);
        this.a34 = fMatrix.get(2, 3);
        this.a41 = fMatrix.get(3, 0);
        this.a42 = fMatrix.get(3, 1);
        this.a43 = fMatrix.get(3, 2);
        this.a44 = fMatrix.get(3, 3);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T copy() {
        return new FMatrix4x4(this);
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new FMatrix4x4();
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
