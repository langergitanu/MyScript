package org.ejml.data;

import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class DMatrix3 implements DMatrixFixed {

    /* JADX INFO: renamed from: a1 */
    public double f2399a1;

    /* JADX INFO: renamed from: a2 */
    public double f2400a2;

    /* JADX INFO: renamed from: a3 */
    public double f2401a3;

    @Override // org.ejml.data.Matrix
    public int getNumCols() {
        return 1;
    }

    @Override // org.ejml.data.DMatrix
    public int getNumElements() {
        return 3;
    }

    @Override // org.ejml.data.Matrix
    public int getNumRows() {
        return 3;
    }

    public DMatrix3() {
    }

    public DMatrix3(double d, double d2, double d3) {
        this.f2399a1 = d;
        this.f2400a2 = d2;
        this.f2401a3 = d3;
    }

    public DMatrix3(DMatrix3 dMatrix3) {
        this.f2399a1 = dMatrix3.f2399a1;
        this.f2400a2 = dMatrix3.f2400a2;
        this.f2401a3 = dMatrix3.f2401a3;
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
            return this.f2399a1;
        }
        if (iMax == 1) {
            return this.f2400a2;
        }
        if (iMax == 2) {
            return this.f2401a3;
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
            this.f2399a1 = d;
        } else if (iMax == 1) {
            this.f2400a2 = d;
        } else {
            if (iMax == 2) {
                this.f2401a3 = d;
                return;
            }
            throw new IllegalArgumentException("Out of range.  " + iMax);
        }
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        DMatrix dMatrix = (DMatrix) matrix;
        if (dMatrix.getNumCols() == 1 && dMatrix.getNumRows() == 3) {
            this.f2399a1 = dMatrix.get(0, 0);
            this.f2400a2 = dMatrix.get(1, 0);
            this.f2401a3 = dMatrix.get(2, 0);
        } else {
            if (dMatrix.getNumRows() == 1 && dMatrix.getNumCols() == 3) {
                this.f2399a1 = dMatrix.get(0, 0);
                this.f2400a2 = dMatrix.get(0, 1);
                this.f2401a3 = dMatrix.get(0, 2);
                return;
            }
            throw new IllegalArgumentException("Incompatible shape");
        }
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T copy() {
        return new DMatrix3(this);
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new DMatrix3();
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
