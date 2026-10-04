package org.ejml.data;

import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class DMatrix5x5 implements DMatrixFixed {
    public double a11;
    public double a12;
    public double a13;
    public double a14;
    public double a15;
    public double a21;
    public double a22;
    public double a23;
    public double a24;
    public double a25;
    public double a31;
    public double a32;
    public double a33;
    public double a34;
    public double a35;
    public double a41;
    public double a42;
    public double a43;
    public double a44;
    public double a45;
    public double a51;
    public double a52;
    public double a53;
    public double a54;
    public double a55;

    @Override // org.ejml.data.Matrix
    public int getNumCols() {
        return 5;
    }

    @Override // org.ejml.data.DMatrix
    public int getNumElements() {
        return 25;
    }

    @Override // org.ejml.data.Matrix
    public int getNumRows() {
        return 5;
    }

    public DMatrix5x5() {
    }

    public DMatrix5x5(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19, double d20, double d21, double d22, double d23, double d24, double d25) {
        this.a11 = d;
        this.a12 = d2;
        this.a13 = d3;
        this.a14 = d4;
        this.a15 = d5;
        this.a21 = d6;
        this.a22 = d7;
        this.a23 = d8;
        this.a24 = d9;
        this.a25 = d10;
        this.a31 = d11;
        this.a32 = d12;
        this.a33 = d13;
        this.a34 = d14;
        this.a35 = d15;
        this.a41 = d16;
        this.a42 = d17;
        this.a43 = d18;
        this.a44 = d19;
        this.a45 = d20;
        this.a51 = d21;
        this.a52 = d22;
        this.a53 = d23;
        this.a54 = d24;
        this.a55 = d25;
    }

    public DMatrix5x5(DMatrix5x5 dMatrix5x5) {
        this.a11 = dMatrix5x5.a11;
        this.a12 = dMatrix5x5.a12;
        this.a13 = dMatrix5x5.a13;
        this.a14 = dMatrix5x5.a14;
        this.a15 = dMatrix5x5.a15;
        this.a21 = dMatrix5x5.a21;
        this.a22 = dMatrix5x5.a22;
        this.a23 = dMatrix5x5.a23;
        this.a24 = dMatrix5x5.a24;
        this.a25 = dMatrix5x5.a25;
        this.a31 = dMatrix5x5.a31;
        this.a32 = dMatrix5x5.a32;
        this.a33 = dMatrix5x5.a33;
        this.a34 = dMatrix5x5.a34;
        this.a35 = dMatrix5x5.a35;
        this.a41 = dMatrix5x5.a41;
        this.a42 = dMatrix5x5.a42;
        this.a43 = dMatrix5x5.a43;
        this.a44 = dMatrix5x5.a44;
        this.a45 = dMatrix5x5.a45;
        this.a51 = dMatrix5x5.a51;
        this.a52 = dMatrix5x5.a52;
        this.a53 = dMatrix5x5.a53;
        this.a54 = dMatrix5x5.a54;
        this.a55 = dMatrix5x5.a55;
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
            }
            if (i2 == 2) {
                this.a13 = d;
                return;
            } else if (i2 == 3) {
                this.a14 = d;
                return;
            } else if (i2 == 4) {
                this.a15 = d;
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
            }
            if (i2 == 2) {
                this.a23 = d;
                return;
            } else if (i2 == 3) {
                this.a24 = d;
                return;
            } else if (i2 == 4) {
                this.a25 = d;
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
            }
            if (i2 == 2) {
                this.a33 = d;
                return;
            } else if (i2 == 3) {
                this.a34 = d;
                return;
            } else if (i2 == 4) {
                this.a35 = d;
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
            }
            if (i2 == 2) {
                this.a43 = d;
                return;
            } else if (i2 == 3) {
                this.a44 = d;
                return;
            } else if (i2 == 4) {
                this.a45 = d;
                return;
            }
        } else if (i == 4) {
            if (i2 == 0) {
                this.a51 = d;
                return;
            }
            if (i2 == 1) {
                this.a52 = d;
                return;
            }
            if (i2 == 2) {
                this.a53 = d;
                return;
            } else if (i2 == 3) {
                this.a54 = d;
                return;
            } else if (i2 == 4) {
                this.a55 = d;
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
        DMatrix dMatrix = (DMatrix) matrix;
        this.a11 = dMatrix.get(0, 0);
        this.a12 = dMatrix.get(0, 1);
        this.a13 = dMatrix.get(0, 2);
        this.a14 = dMatrix.get(0, 3);
        this.a15 = dMatrix.get(0, 4);
        this.a21 = dMatrix.get(1, 0);
        this.a22 = dMatrix.get(1, 1);
        this.a23 = dMatrix.get(1, 2);
        this.a24 = dMatrix.get(1, 3);
        this.a25 = dMatrix.get(1, 4);
        this.a31 = dMatrix.get(2, 0);
        this.a32 = dMatrix.get(2, 1);
        this.a33 = dMatrix.get(2, 2);
        this.a34 = dMatrix.get(2, 3);
        this.a35 = dMatrix.get(2, 4);
        this.a41 = dMatrix.get(3, 0);
        this.a42 = dMatrix.get(3, 1);
        this.a43 = dMatrix.get(3, 2);
        this.a44 = dMatrix.get(3, 3);
        this.a45 = dMatrix.get(3, 4);
        this.a51 = dMatrix.get(4, 0);
        this.a52 = dMatrix.get(4, 1);
        this.a53 = dMatrix.get(4, 2);
        this.a54 = dMatrix.get(4, 3);
        this.a55 = dMatrix.get(4, 4);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T copy() {
        return new DMatrix5x5(this);
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new DMatrix5x5();
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
