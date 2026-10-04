package org.ejml.data;

import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class DMatrix6x6 implements DMatrixFixed {
    public double a11;
    public double a12;
    public double a13;
    public double a14;
    public double a15;
    public double a16;
    public double a21;
    public double a22;
    public double a23;
    public double a24;
    public double a25;
    public double a26;
    public double a31;
    public double a32;
    public double a33;
    public double a34;
    public double a35;
    public double a36;
    public double a41;
    public double a42;
    public double a43;
    public double a44;
    public double a45;
    public double a46;
    public double a51;
    public double a52;
    public double a53;
    public double a54;
    public double a55;
    public double a56;
    public double a61;
    public double a62;
    public double a63;
    public double a64;
    public double a65;
    public double a66;

    @Override // org.ejml.data.Matrix
    public int getNumCols() {
        return 6;
    }

    @Override // org.ejml.data.DMatrix
    public int getNumElements() {
        return 36;
    }

    @Override // org.ejml.data.Matrix
    public int getNumRows() {
        return 6;
    }

    public DMatrix6x6() {
    }

    public DMatrix6x6(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19, double d20, double d21, double d22, double d23, double d24, double d25, double d26, double d27, double d28, double d29, double d30, double d31, double d32, double d33, double d34, double d35, double d36) {
        this.a11 = d;
        this.a12 = d2;
        this.a13 = d3;
        this.a14 = d4;
        this.a15 = d5;
        this.a16 = d6;
        this.a21 = d7;
        this.a22 = d8;
        this.a23 = d9;
        this.a24 = d10;
        this.a25 = d11;
        this.a26 = d12;
        this.a31 = d13;
        this.a32 = d14;
        this.a33 = d15;
        this.a34 = d16;
        this.a35 = d17;
        this.a36 = d18;
        this.a41 = d19;
        this.a42 = d20;
        this.a43 = d21;
        this.a44 = d22;
        this.a45 = d23;
        this.a46 = d24;
        this.a51 = d25;
        this.a52 = d26;
        this.a53 = d27;
        this.a54 = d28;
        this.a55 = d29;
        this.a56 = d30;
        this.a61 = d31;
        this.a62 = d32;
        this.a63 = d33;
        this.a64 = d34;
        this.a65 = d35;
        this.a66 = d36;
    }

    public DMatrix6x6(DMatrix6x6 dMatrix6x6) {
        this.a11 = dMatrix6x6.a11;
        this.a12 = dMatrix6x6.a12;
        this.a13 = dMatrix6x6.a13;
        this.a14 = dMatrix6x6.a14;
        this.a15 = dMatrix6x6.a15;
        this.a16 = dMatrix6x6.a16;
        this.a21 = dMatrix6x6.a21;
        this.a22 = dMatrix6x6.a22;
        this.a23 = dMatrix6x6.a23;
        this.a24 = dMatrix6x6.a24;
        this.a25 = dMatrix6x6.a25;
        this.a26 = dMatrix6x6.a26;
        this.a31 = dMatrix6x6.a31;
        this.a32 = dMatrix6x6.a32;
        this.a33 = dMatrix6x6.a33;
        this.a34 = dMatrix6x6.a34;
        this.a35 = dMatrix6x6.a35;
        this.a36 = dMatrix6x6.a36;
        this.a41 = dMatrix6x6.a41;
        this.a42 = dMatrix6x6.a42;
        this.a43 = dMatrix6x6.a43;
        this.a44 = dMatrix6x6.a44;
        this.a45 = dMatrix6x6.a45;
        this.a46 = dMatrix6x6.a46;
        this.a51 = dMatrix6x6.a51;
        this.a52 = dMatrix6x6.a52;
        this.a53 = dMatrix6x6.a53;
        this.a54 = dMatrix6x6.a54;
        this.a55 = dMatrix6x6.a55;
        this.a56 = dMatrix6x6.a56;
        this.a61 = dMatrix6x6.a61;
        this.a62 = dMatrix6x6.a62;
        this.a63 = dMatrix6x6.a63;
        this.a64 = dMatrix6x6.a64;
        this.a65 = dMatrix6x6.a65;
        this.a66 = dMatrix6x6.a66;
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
            if (i2 == 5) {
                return this.a16;
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
            if (i2 == 5) {
                return this.a26;
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
            if (i2 == 5) {
                return this.a36;
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
            if (i2 == 5) {
                return this.a46;
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
            if (i2 == 5) {
                return this.a56;
            }
        } else if (i == 5) {
            if (i2 == 0) {
                return this.a61;
            }
            if (i2 == 1) {
                return this.a62;
            }
            if (i2 == 2) {
                return this.a63;
            }
            if (i2 == 3) {
                return this.a64;
            }
            if (i2 == 4) {
                return this.a65;
            }
            if (i2 == 5) {
                return this.a66;
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
            }
            if (i2 == 3) {
                this.a14 = d;
                return;
            } else if (i2 == 4) {
                this.a15 = d;
                return;
            } else if (i2 == 5) {
                this.a16 = d;
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
            }
            if (i2 == 3) {
                this.a24 = d;
                return;
            } else if (i2 == 4) {
                this.a25 = d;
                return;
            } else if (i2 == 5) {
                this.a26 = d;
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
            }
            if (i2 == 3) {
                this.a34 = d;
                return;
            } else if (i2 == 4) {
                this.a35 = d;
                return;
            } else if (i2 == 5) {
                this.a36 = d;
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
            }
            if (i2 == 3) {
                this.a44 = d;
                return;
            } else if (i2 == 4) {
                this.a45 = d;
                return;
            } else if (i2 == 5) {
                this.a46 = d;
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
            }
            if (i2 == 3) {
                this.a54 = d;
                return;
            } else if (i2 == 4) {
                this.a55 = d;
                return;
            } else if (i2 == 5) {
                this.a56 = d;
                return;
            }
        } else if (i == 5) {
            if (i2 == 0) {
                this.a61 = d;
                return;
            }
            if (i2 == 1) {
                this.a62 = d;
                return;
            }
            if (i2 == 2) {
                this.a63 = d;
                return;
            }
            if (i2 == 3) {
                this.a64 = d;
                return;
            } else if (i2 == 4) {
                this.a65 = d;
                return;
            } else if (i2 == 5) {
                this.a66 = d;
                return;
            }
        }
        throw new IllegalArgumentException("Row and/or column out of range. " + i + " " + i2);
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        if (matrix.getNumCols() != 6 || matrix.getNumRows() != 6) {
            throw new IllegalArgumentException("Rows and/or columns do not match");
        }
        DMatrix dMatrix = (DMatrix) matrix;
        this.a11 = dMatrix.get(0, 0);
        this.a12 = dMatrix.get(0, 1);
        this.a13 = dMatrix.get(0, 2);
        this.a14 = dMatrix.get(0, 3);
        this.a15 = dMatrix.get(0, 4);
        this.a16 = dMatrix.get(0, 5);
        this.a21 = dMatrix.get(1, 0);
        this.a22 = dMatrix.get(1, 1);
        this.a23 = dMatrix.get(1, 2);
        this.a24 = dMatrix.get(1, 3);
        this.a25 = dMatrix.get(1, 4);
        this.a26 = dMatrix.get(1, 5);
        this.a31 = dMatrix.get(2, 0);
        this.a32 = dMatrix.get(2, 1);
        this.a33 = dMatrix.get(2, 2);
        this.a34 = dMatrix.get(2, 3);
        this.a35 = dMatrix.get(2, 4);
        this.a36 = dMatrix.get(2, 5);
        this.a41 = dMatrix.get(3, 0);
        this.a42 = dMatrix.get(3, 1);
        this.a43 = dMatrix.get(3, 2);
        this.a44 = dMatrix.get(3, 3);
        this.a45 = dMatrix.get(3, 4);
        this.a46 = dMatrix.get(3, 5);
        this.a51 = dMatrix.get(4, 0);
        this.a52 = dMatrix.get(4, 1);
        this.a53 = dMatrix.get(4, 2);
        this.a54 = dMatrix.get(4, 3);
        this.a55 = dMatrix.get(4, 4);
        this.a56 = dMatrix.get(4, 5);
        this.a61 = dMatrix.get(5, 0);
        this.a62 = dMatrix.get(5, 1);
        this.a63 = dMatrix.get(5, 2);
        this.a64 = dMatrix.get(5, 3);
        this.a65 = dMatrix.get(5, 4);
        this.a66 = dMatrix.get(5, 5);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T copy() {
        return new DMatrix6x6(this);
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new DMatrix6x6();
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
