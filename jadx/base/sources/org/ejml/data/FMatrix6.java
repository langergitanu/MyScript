package org.ejml.data;

import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class FMatrix6 implements FMatrixFixed {

    /* JADX INFO: renamed from: a1 */
    public float f2432a1;

    /* JADX INFO: renamed from: a2 */
    public float f2433a2;

    /* JADX INFO: renamed from: a3 */
    public float f2434a3;

    /* JADX INFO: renamed from: a4 */
    public float f2435a4;

    /* JADX INFO: renamed from: a5 */
    public float f2436a5;

    /* JADX INFO: renamed from: a6 */
    public float f2437a6;

    @Override // org.ejml.data.Matrix
    public int getNumCols() {
        return 1;
    }

    @Override // org.ejml.data.FMatrix
    public int getNumElements() {
        return 6;
    }

    @Override // org.ejml.data.Matrix
    public int getNumRows() {
        return 6;
    }

    public FMatrix6() {
    }

    public FMatrix6(float f, float f2, float f3, float f4, float f5, float f6) {
        this.f2432a1 = f;
        this.f2433a2 = f2;
        this.f2434a3 = f3;
        this.f2435a4 = f4;
        this.f2436a5 = f5;
        this.f2437a6 = f6;
    }

    public FMatrix6(FMatrix6 fMatrix6) {
        this.f2432a1 = fMatrix6.f2432a1;
        this.f2433a2 = fMatrix6.f2433a2;
        this.f2434a3 = fMatrix6.f2434a3;
        this.f2435a4 = fMatrix6.f2435a4;
        this.f2436a5 = fMatrix6.f2436a5;
        this.f2437a6 = fMatrix6.f2437a6;
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
            return this.f2432a1;
        }
        if (iMax == 1) {
            return this.f2433a2;
        }
        if (iMax == 2) {
            return this.f2434a3;
        }
        if (iMax == 3) {
            return this.f2435a4;
        }
        if (iMax == 4) {
            return this.f2436a5;
        }
        if (iMax == 5) {
            return this.f2437a6;
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
            this.f2432a1 = f;
            return;
        }
        if (iMax == 1) {
            this.f2433a2 = f;
            return;
        }
        if (iMax == 2) {
            this.f2434a3 = f;
            return;
        }
        if (iMax == 3) {
            this.f2435a4 = f;
        } else if (iMax == 4) {
            this.f2436a5 = f;
        } else {
            if (iMax == 5) {
                this.f2437a6 = f;
                return;
            }
            throw new IllegalArgumentException("Out of range.  " + iMax);
        }
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        FMatrix fMatrix = (FMatrix) matrix;
        if (fMatrix.getNumCols() == 1 && fMatrix.getNumRows() == 6) {
            this.f2432a1 = fMatrix.get(0, 0);
            this.f2433a2 = fMatrix.get(1, 0);
            this.f2434a3 = fMatrix.get(2, 0);
            this.f2435a4 = fMatrix.get(3, 0);
            this.f2436a5 = fMatrix.get(4, 0);
            this.f2437a6 = fMatrix.get(5, 0);
            return;
        }
        if (fMatrix.getNumRows() == 1 && fMatrix.getNumCols() == 6) {
            this.f2432a1 = fMatrix.get(0, 0);
            this.f2433a2 = fMatrix.get(0, 1);
            this.f2434a3 = fMatrix.get(0, 2);
            this.f2435a4 = fMatrix.get(0, 3);
            this.f2436a5 = fMatrix.get(0, 4);
            this.f2437a6 = fMatrix.get(0, 5);
            return;
        }
        throw new IllegalArgumentException("Incompatible shape");
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T copy() {
        return new FMatrix6(this);
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new FMatrix6();
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
