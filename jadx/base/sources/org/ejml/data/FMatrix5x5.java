package org.ejml.data;

import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class FMatrix5x5 implements FMatrixFixed {
    public float a11;
    public float a12;
    public float a13;
    public float a14;
    public float a15;
    public float a21;
    public float a22;
    public float a23;
    public float a24;
    public float a25;
    public float a31;
    public float a32;
    public float a33;
    public float a34;
    public float a35;
    public float a41;
    public float a42;
    public float a43;
    public float a44;
    public float a45;
    public float a51;
    public float a52;
    public float a53;
    public float a54;
    public float a55;

    @Override // org.ejml.data.Matrix
    public int getNumCols() {
        return 5;
    }

    @Override // org.ejml.data.FMatrix
    public int getNumElements() {
        return 25;
    }

    @Override // org.ejml.data.Matrix
    public int getNumRows() {
        return 5;
    }

    public FMatrix5x5() {
    }

    public FMatrix5x5(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25) {
        this.a11 = f;
        this.a12 = f2;
        this.a13 = f3;
        this.a14 = f4;
        this.a15 = f5;
        this.a21 = f6;
        this.a22 = f7;
        this.a23 = f8;
        this.a24 = f9;
        this.a25 = f10;
        this.a31 = f11;
        this.a32 = f12;
        this.a33 = f13;
        this.a34 = f14;
        this.a35 = f15;
        this.a41 = f16;
        this.a42 = f17;
        this.a43 = f18;
        this.a44 = f19;
        this.a45 = f20;
        this.a51 = f21;
        this.a52 = f22;
        this.a53 = f23;
        this.a54 = f24;
        this.a55 = f25;
    }

    public FMatrix5x5(FMatrix5x5 fMatrix5x5) {
        this.a11 = fMatrix5x5.a11;
        this.a12 = fMatrix5x5.a12;
        this.a13 = fMatrix5x5.a13;
        this.a14 = fMatrix5x5.a14;
        this.a15 = fMatrix5x5.a15;
        this.a21 = fMatrix5x5.a21;
        this.a22 = fMatrix5x5.a22;
        this.a23 = fMatrix5x5.a23;
        this.a24 = fMatrix5x5.a24;
        this.a25 = fMatrix5x5.a25;
        this.a31 = fMatrix5x5.a31;
        this.a32 = fMatrix5x5.a32;
        this.a33 = fMatrix5x5.a33;
        this.a34 = fMatrix5x5.a34;
        this.a35 = fMatrix5x5.a35;
        this.a41 = fMatrix5x5.a41;
        this.a42 = fMatrix5x5.a42;
        this.a43 = fMatrix5x5.a43;
        this.a44 = fMatrix5x5.a44;
        this.a45 = fMatrix5x5.a45;
        this.a51 = fMatrix5x5.a51;
        this.a52 = fMatrix5x5.a52;
        this.a53 = fMatrix5x5.a53;
        this.a54 = fMatrix5x5.a54;
        this.a55 = fMatrix5x5.a55;
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
            if (i2 == 4) {
                return this.a15;
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
            if (i2 == 4) {
                return this.a25;
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
            if (i2 == 4) {
                return this.a35;
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
            if (i2 == 4) {
                return this.a45;
            }
        } else if (i == 4) {
            if (i2 == 0) {
                return this.a51;
            }
            if (i2 == 1) {
                return this.a52;
            }
            if (i2 == 2) {
                return this.a53;
            }
            if (i2 == 3) {
                return this.a54;
            }
            if (i2 == 4) {
                return this.a55;
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
            }
            if (i2 == 2) {
                this.a13 = f;
                return;
            } else if (i2 == 3) {
                this.a14 = f;
                return;
            } else if (i2 == 4) {
                this.a15 = f;
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
            }
            if (i2 == 2) {
                this.a23 = f;
                return;
            } else if (i2 == 3) {
                this.a24 = f;
                return;
            } else if (i2 == 4) {
                this.a25 = f;
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
            }
            if (i2 == 2) {
                this.a33 = f;
                return;
            } else if (i2 == 3) {
                this.a34 = f;
                return;
            } else if (i2 == 4) {
                this.a35 = f;
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
            }
            if (i2 == 2) {
                this.a43 = f;
                return;
            } else if (i2 == 3) {
                this.a44 = f;
                return;
            } else if (i2 == 4) {
                this.a45 = f;
                return;
            }
        } else if (i == 4) {
            if (i2 == 0) {
                this.a51 = f;
                return;
            }
            if (i2 == 1) {
                this.a52 = f;
                return;
            }
            if (i2 == 2) {
                this.a53 = f;
                return;
            } else if (i2 == 3) {
                this.a54 = f;
                return;
            } else if (i2 == 4) {
                this.a55 = f;
                return;
            }
        }
        throw new IllegalArgumentException("Row and/or column out of range. " + i + " " + i2);
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        if (matrix.getNumCols() != 5 || matrix.getNumRows() != 5) {
            throw new IllegalArgumentException("Rows and/or columns do not match");
        }
        FMatrix fMatrix = (FMatrix) matrix;
        this.a11 = fMatrix.get(0, 0);
        this.a12 = fMatrix.get(0, 1);
        this.a13 = fMatrix.get(0, 2);
        this.a14 = fMatrix.get(0, 3);
        this.a15 = fMatrix.get(0, 4);
        this.a21 = fMatrix.get(1, 0);
        this.a22 = fMatrix.get(1, 1);
        this.a23 = fMatrix.get(1, 2);
        this.a24 = fMatrix.get(1, 3);
        this.a25 = fMatrix.get(1, 4);
        this.a31 = fMatrix.get(2, 0);
        this.a32 = fMatrix.get(2, 1);
        this.a33 = fMatrix.get(2, 2);
        this.a34 = fMatrix.get(2, 3);
        this.a35 = fMatrix.get(2, 4);
        this.a41 = fMatrix.get(3, 0);
        this.a42 = fMatrix.get(3, 1);
        this.a43 = fMatrix.get(3, 2);
        this.a44 = fMatrix.get(3, 3);
        this.a45 = fMatrix.get(3, 4);
        this.a51 = fMatrix.get(4, 0);
        this.a52 = fMatrix.get(4, 1);
        this.a53 = fMatrix.get(4, 2);
        this.a54 = fMatrix.get(4, 3);
        this.a55 = fMatrix.get(4, 4);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T copy() {
        return new FMatrix5x5(this);
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new FMatrix5x5();
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
