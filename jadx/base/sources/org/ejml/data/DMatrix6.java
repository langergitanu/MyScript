package org.ejml.data;

import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class DMatrix6 implements DMatrixFixed {

    /* JADX INFO: renamed from: a1 */
    public double f2411a1;

    /* JADX INFO: renamed from: a2 */
    public double f2412a2;

    /* JADX INFO: renamed from: a3 */
    public double f2413a3;

    /* JADX INFO: renamed from: a4 */
    public double f2414a4;

    /* JADX INFO: renamed from: a5 */
    public double f2415a5;

    /* JADX INFO: renamed from: a6 */
    public double f2416a6;

    @Override // org.ejml.data.Matrix
    public int getNumCols() {
        return 1;
    }

    @Override // org.ejml.data.DMatrix
    public int getNumElements() {
        return 6;
    }

    @Override // org.ejml.data.Matrix
    public int getNumRows() {
        return 6;
    }

    public DMatrix6() {
    }

    public DMatrix6(double d, double d2, double d3, double d4, double d5, double d6) {
        this.f2411a1 = d;
        this.f2412a2 = d2;
        this.f2413a3 = d3;
        this.f2414a4 = d4;
        this.f2415a5 = d5;
        this.f2416a6 = d6;
    }

    public DMatrix6(DMatrix6 dMatrix6) {
        this.f2411a1 = dMatrix6.f2411a1;
        this.f2412a2 = dMatrix6.f2412a2;
        this.f2413a3 = dMatrix6.f2413a3;
        this.f2414a4 = dMatrix6.f2414a4;
        this.f2415a5 = dMatrix6.f2415a5;
        this.f2416a6 = dMatrix6.f2416a6;
    }

    @Override // org.ejml.data.DMatrix
    public double get(int i, int i2) {
        return unsafe_get(i, i2);
    }

    @Override // org.ejml.data.DMatrix
    public double unsafe_get(int i, int i2) {
        if (i != 0 && i2 != 0) {
            throw new IllegalArgumentException("Row or column must be zero since this is a vector");
        }
        int iMax = Math.max(i, i2);
        if (iMax == 0) {
            return this.f2411a1;
        }
        if (iMax == 1) {
            return this.f2412a2;
        }
        if (iMax == 2) {
            return this.f2413a3;
        }
        if (iMax == 3) {
            return this.f2414a4;
        }
        if (iMax == 4) {
            return this.f2415a5;
        }
        if (iMax == 5) {
            return this.f2416a6;
        }
        throw new IllegalArgumentException("Out of range.  " + iMax);
    }

    @Override // org.ejml.data.DMatrix
    public void set(int i, int i2, double d) {
        unsafe_set(i, i2, d);
    }

    @Override // org.ejml.data.DMatrix
    public void unsafe_set(int i, int i2, double d) {
        if (i != 0 && i2 != 0) {
            throw new IllegalArgumentException("Row or column must be zero since this is a vector");
        }
        int iMax = Math.max(i, i2);
        if (iMax == 0) {
            this.f2411a1 = d;
            return;
        }
        if (iMax == 1) {
            this.f2412a2 = d;
            return;
        }
        if (iMax == 2) {
            this.f2413a3 = d;
            return;
        }
        if (iMax == 3) {
            this.f2414a4 = d;
        } else if (iMax == 4) {
            this.f2415a5 = d;
        } else {
            if (iMax == 5) {
                this.f2416a6 = d;
                return;
            }
            throw new IllegalArgumentException("Out of range.  " + iMax);
        }
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        DMatrix dMatrix = (DMatrix) matrix;
        if (dMatrix.getNumCols() == 1 && dMatrix.getNumRows() == 6) {
            this.f2411a1 = dMatrix.get(0, 0);
            this.f2412a2 = dMatrix.get(1, 0);
            this.f2413a3 = dMatrix.get(2, 0);
            this.f2414a4 = dMatrix.get(3, 0);
            this.f2415a5 = dMatrix.get(4, 0);
            this.f2416a6 = dMatrix.get(5, 0);
            return;
        }
        if (dMatrix.getNumRows() == 1 && dMatrix.getNumCols() == 6) {
            this.f2411a1 = dMatrix.get(0, 0);
            this.f2412a2 = dMatrix.get(0, 1);
            this.f2413a3 = dMatrix.get(0, 2);
            this.f2414a4 = dMatrix.get(0, 3);
            this.f2415a5 = dMatrix.get(0, 4);
            this.f2416a6 = dMatrix.get(0, 5);
            return;
        }
        throw new IllegalArgumentException("Incompatible shape");
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T copy() {
        return new DMatrix6(this);
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new DMatrix6();
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
