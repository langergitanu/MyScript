package org.ejml.data;

import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class FMatrix4 implements FMatrixFixed {

    /* JADX INFO: renamed from: a1 */
    public float f2423a1;

    /* JADX INFO: renamed from: a2 */
    public float f2424a2;

    /* JADX INFO: renamed from: a3 */
    public float f2425a3;

    /* JADX INFO: renamed from: a4 */
    public float f2426a4;

    @Override // org.ejml.data.Matrix
    public int getNumCols() {
        return 1;
    }

    @Override // org.ejml.data.FMatrix
    public int getNumElements() {
        return 4;
    }

    @Override // org.ejml.data.Matrix
    public int getNumRows() {
        return 4;
    }

    public FMatrix4() {
    }

    public FMatrix4(float f, float f2, float f3, float f4) {
        this.f2423a1 = f;
        this.f2424a2 = f2;
        this.f2425a3 = f3;
        this.f2426a4 = f4;
    }

    public FMatrix4(FMatrix4 fMatrix4) {
        this.f2423a1 = fMatrix4.f2423a1;
        this.f2424a2 = fMatrix4.f2424a2;
        this.f2425a3 = fMatrix4.f2425a3;
        this.f2426a4 = fMatrix4.f2426a4;
    }

    @Override // org.ejml.data.FMatrix
    public float get(int i, int i2) {
        return unsafe_get(i, i2);
    }

    @Override // org.ejml.data.FMatrix
    public float unsafe_get(int i, int i2) {
        if (i != 0 && i2 != 0) {
            throw new IllegalArgumentException("Row or column must be zero since this is a vector");
        }
        int iMax = Math.max(i, i2);
        if (iMax == 0) {
            return this.f2423a1;
        }
        if (iMax == 1) {
            return this.f2424a2;
        }
        if (iMax == 2) {
            return this.f2425a3;
        }
        if (iMax == 3) {
            return this.f2426a4;
        }
        throw new IllegalArgumentException("Out of range.  " + iMax);
    }

    @Override // org.ejml.data.FMatrix
    public void set(int i, int i2, float f) {
        unsafe_set(i, i2, f);
    }

    @Override // org.ejml.data.FMatrix
    public void unsafe_set(int i, int i2, float f) {
        if (i != 0 && i2 != 0) {
            throw new IllegalArgumentException("Row or column must be zero since this is a vector");
        }
        int iMax = Math.max(i, i2);
        if (iMax == 0) {
            this.f2423a1 = f;
            return;
        }
        if (iMax == 1) {
            this.f2424a2 = f;
        } else if (iMax == 2) {
            this.f2425a3 = f;
        } else {
            if (iMax == 3) {
                this.f2426a4 = f;
                return;
            }
            throw new IllegalArgumentException("Out of range.  " + iMax);
        }
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        FMatrix fMatrix = (FMatrix) matrix;
        if (fMatrix.getNumCols() == 1 && fMatrix.getNumRows() == 4) {
            this.f2423a1 = fMatrix.get(0, 0);
            this.f2424a2 = fMatrix.get(1, 0);
            this.f2425a3 = fMatrix.get(2, 0);
            this.f2426a4 = fMatrix.get(3, 0);
            return;
        }
        if (fMatrix.getNumRows() == 1 && fMatrix.getNumCols() == 4) {
            this.f2423a1 = fMatrix.get(0, 0);
            this.f2424a2 = fMatrix.get(0, 1);
            this.f2425a3 = fMatrix.get(0, 2);
            this.f2426a4 = fMatrix.get(0, 3);
            return;
        }
        throw new IllegalArgumentException("Incompatible shape");
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T copy() {
        return new FMatrix4(this);
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new FMatrix4();
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
