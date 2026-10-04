package org.ejml.data;

import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class FMatrix6x6 implements FMatrixFixed {
    public float a11;
    public float a12;
    public float a13;
    public float a14;
    public float a15;
    public float a16;
    public float a21;
    public float a22;
    public float a23;
    public float a24;
    public float a25;
    public float a26;
    public float a31;
    public float a32;
    public float a33;
    public float a34;
    public float a35;
    public float a36;
    public float a41;
    public float a42;
    public float a43;
    public float a44;
    public float a45;
    public float a46;
    public float a51;
    public float a52;
    public float a53;
    public float a54;
    public float a55;
    public float a56;
    public float a61;
    public float a62;
    public float a63;
    public float a64;
    public float a65;
    public float a66;

    @Override // org.ejml.data.Matrix
    public int getNumCols() {
        return 6;
    }

    @Override // org.ejml.data.FMatrix
    public int getNumElements() {
        return 36;
    }

    @Override // org.ejml.data.Matrix
    public int getNumRows() {
        return 6;
    }

    public FMatrix6x6() {
    }

    public FMatrix6x6(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25, float f26, float f27, float f28, float f29, float f30, float f31, float f32, float f33, float f34, float f35, float f36) {
        this.a11 = f;
        this.a12 = f2;
        this.a13 = f3;
        this.a14 = f4;
        this.a15 = f5;
        this.a16 = f6;
        this.a21 = f7;
        this.a22 = f8;
        this.a23 = f9;
        this.a24 = f10;
        this.a25 = f11;
        this.a26 = f12;
        this.a31 = f13;
        this.a32 = f14;
        this.a33 = f15;
        this.a34 = f16;
        this.a35 = f17;
        this.a36 = f18;
        this.a41 = f19;
        this.a42 = f20;
        this.a43 = f21;
        this.a44 = f22;
        this.a45 = f23;
        this.a46 = f24;
        this.a51 = f25;
        this.a52 = f26;
        this.a53 = f27;
        this.a54 = f28;
        this.a55 = f29;
        this.a56 = f30;
        this.a61 = f31;
        this.a62 = f32;
        this.a63 = f33;
        this.a64 = f34;
        this.a65 = f35;
        this.a66 = f36;
    }

    public FMatrix6x6(FMatrix6x6 fMatrix6x6) {
        this.a11 = fMatrix6x6.a11;
        this.a12 = fMatrix6x6.a12;
        this.a13 = fMatrix6x6.a13;
        this.a14 = fMatrix6x6.a14;
        this.a15 = fMatrix6x6.a15;
        this.a16 = fMatrix6x6.a16;
        this.a21 = fMatrix6x6.a21;
        this.a22 = fMatrix6x6.a22;
        this.a23 = fMatrix6x6.a23;
        this.a24 = fMatrix6x6.a24;
        this.a25 = fMatrix6x6.a25;
        this.a26 = fMatrix6x6.a26;
        this.a31 = fMatrix6x6.a31;
        this.a32 = fMatrix6x6.a32;
        this.a33 = fMatrix6x6.a33;
        this.a34 = fMatrix6x6.a34;
        this.a35 = fMatrix6x6.a35;
        this.a36 = fMatrix6x6.a36;
        this.a41 = fMatrix6x6.a41;
        this.a42 = fMatrix6x6.a42;
        this.a43 = fMatrix6x6.a43;
        this.a44 = fMatrix6x6.a44;
        this.a45 = fMatrix6x6.a45;
        this.a46 = fMatrix6x6.a46;
        this.a51 = fMatrix6x6.a51;
        this.a52 = fMatrix6x6.a52;
        this.a53 = fMatrix6x6.a53;
        this.a54 = fMatrix6x6.a54;
        this.a55 = fMatrix6x6.a55;
        this.a56 = fMatrix6x6.a56;
        this.a61 = fMatrix6x6.a61;
        this.a62 = fMatrix6x6.a62;
        this.a63 = fMatrix6x6.a63;
        this.a64 = fMatrix6x6.a64;
        this.a65 = fMatrix6x6.a65;
        this.a66 = fMatrix6x6.a66;
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
            }
            if (i2 == 3) {
                this.a14 = f;
                return;
            } else if (i2 == 4) {
                this.a15 = f;
                return;
            } else if (i2 == 5) {
                this.a16 = f;
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
            }
            if (i2 == 3) {
                this.a24 = f;
                return;
            } else if (i2 == 4) {
                this.a25 = f;
                return;
            } else if (i2 == 5) {
                this.a26 = f;
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
            }
            if (i2 == 3) {
                this.a34 = f;
                return;
            } else if (i2 == 4) {
                this.a35 = f;
                return;
            } else if (i2 == 5) {
                this.a36 = f;
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
            }
            if (i2 == 3) {
                this.a44 = f;
                return;
            } else if (i2 == 4) {
                this.a45 = f;
                return;
            } else if (i2 == 5) {
                this.a46 = f;
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
            }
            if (i2 == 3) {
                this.a54 = f;
                return;
            } else if (i2 == 4) {
                this.a55 = f;
                return;
            } else if (i2 == 5) {
                this.a56 = f;
                return;
            }
        } else if (i == 5) {
            if (i2 == 0) {
                this.a61 = f;
                return;
            }
            if (i2 == 1) {
                this.a62 = f;
                return;
            }
            if (i2 == 2) {
                this.a63 = f;
                return;
            }
            if (i2 == 3) {
                this.a64 = f;
                return;
            } else if (i2 == 4) {
                this.a65 = f;
                return;
            } else if (i2 == 5) {
                this.a66 = f;
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
        FMatrix fMatrix = (FMatrix) matrix;
        this.a11 = fMatrix.get(0, 0);
        this.a12 = fMatrix.get(0, 1);
        this.a13 = fMatrix.get(0, 2);
        this.a14 = fMatrix.get(0, 3);
        this.a15 = fMatrix.get(0, 4);
        this.a16 = fMatrix.get(0, 5);
        this.a21 = fMatrix.get(1, 0);
        this.a22 = fMatrix.get(1, 1);
        this.a23 = fMatrix.get(1, 2);
        this.a24 = fMatrix.get(1, 3);
        this.a25 = fMatrix.get(1, 4);
        this.a26 = fMatrix.get(1, 5);
        this.a31 = fMatrix.get(2, 0);
        this.a32 = fMatrix.get(2, 1);
        this.a33 = fMatrix.get(2, 2);
        this.a34 = fMatrix.get(2, 3);
        this.a35 = fMatrix.get(2, 4);
        this.a36 = fMatrix.get(2, 5);
        this.a41 = fMatrix.get(3, 0);
        this.a42 = fMatrix.get(3, 1);
        this.a43 = fMatrix.get(3, 2);
        this.a44 = fMatrix.get(3, 3);
        this.a45 = fMatrix.get(3, 4);
        this.a46 = fMatrix.get(3, 5);
        this.a51 = fMatrix.get(4, 0);
        this.a52 = fMatrix.get(4, 1);
        this.a53 = fMatrix.get(4, 2);
        this.a54 = fMatrix.get(4, 3);
        this.a55 = fMatrix.get(4, 4);
        this.a56 = fMatrix.get(4, 5);
        this.a61 = fMatrix.get(5, 0);
        this.a62 = fMatrix.get(5, 1);
        this.a63 = fMatrix.get(5, 2);
        this.a64 = fMatrix.get(5, 3);
        this.a65 = fMatrix.get(5, 4);
        this.a66 = fMatrix.get(5, 5);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T copy() {
        return new FMatrix6x6(this);
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new FMatrix6x6();
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
