package org.ejml.data;

import org.ejml.EjmlParameters;
import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class DMatrixRBlock extends DMatrixD1 {
    public int blockLength;

    public DMatrixRBlock(int i, int i2, int i3) {
        this.data = new double[i * i2];
        this.blockLength = i3;
        this.numRows = i;
        this.numCols = i2;
    }

    public DMatrixRBlock(int i, int i2) {
        this(i, i2, EjmlParameters.BLOCK_WIDTH);
    }

    public DMatrixRBlock() {
    }

    public void set(DMatrixRBlock dMatrixRBlock) {
        this.blockLength = dMatrixRBlock.blockLength;
        this.numRows = dMatrixRBlock.numRows;
        this.numCols = dMatrixRBlock.numCols;
        int i = this.numCols * this.numRows;
        if (this.data.length < i) {
            this.data = new double[i];
        }
        System.arraycopy(dMatrixRBlock.data, 0, this.data, 0, i);
    }

    public static DMatrixRBlock wrap(double[] dArr, int i, int i2, int i3) {
        DMatrixRBlock dMatrixRBlock = new DMatrixRBlock();
        dMatrixRBlock.data = dArr;
        dMatrixRBlock.numRows = i;
        dMatrixRBlock.numCols = i2;
        dMatrixRBlock.blockLength = i3;
        return dMatrixRBlock;
    }

    @Override // org.ejml.data.DMatrixD1
    public double[] getData() {
        return this.data;
    }

    @Override // org.ejml.data.DMatrixD1
    public void reshape(int i, int i2, boolean z) {
        int i3 = i * i2;
        if (i3 <= this.data.length) {
            this.numRows = i;
            this.numCols = i2;
            return;
        }
        double[] dArr = new double[i3];
        if (z) {
            System.arraycopy(this.data, 0, dArr, 0, getNumElements());
        }
        this.numRows = i;
        this.numCols = i2;
        this.data = dArr;
    }

    public void reshape(int i, int i2, int i3, boolean z) {
        this.blockLength = i3;
        reshape(i, i2, z);
    }

    @Override // org.ejml.data.DMatrixD1
    public int getIndex(int i, int i2) {
        int i3 = this.blockLength;
        int i4 = i / i3;
        int i5 = i2 / i3;
        int i6 = this.numRows;
        int i7 = this.blockLength;
        int iMin = (i4 * this.blockLength * this.numCols) + (Math.min(i6 - (i4 * i7), i7) * i5 * this.blockLength);
        int i8 = this.numCols;
        int i9 = this.blockLength;
        int iMin2 = Math.min(i8 - (i5 * i9), i9);
        int i10 = this.blockLength;
        return iMin + (iMin2 * (i % i10)) + (i2 % i10);
    }

    @Override // org.ejml.data.DMatrix
    public double get(int i, int i2) {
        return this.data[getIndex(i, i2)];
    }

    @Override // org.ejml.data.DMatrix
    public double unsafe_get(int i, int i2) {
        return this.data[getIndex(i, i2)];
    }

    @Override // org.ejml.data.DMatrix
    public void set(int i, int i2, double d) {
        this.data[getIndex(i, i2)] = d;
    }

    @Override // org.ejml.data.DMatrix
    public void unsafe_set(int i, int i2, double d) {
        this.data[getIndex(i, i2)] = d;
    }

    @Override // org.ejml.data.DMatrixD1, org.ejml.data.Matrix
    public int getNumRows() {
        return this.numRows;
    }

    @Override // org.ejml.data.DMatrixD1, org.ejml.data.Matrix
    public int getNumCols() {
        return this.numCols;
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new DMatrixRBlock(this.numRows, this.numCols);
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        if (matrix instanceof DMatrixRBlock) {
            set((DMatrixRBlock) matrix);
            return;
        }
        DMatrix dMatrix = (DMatrix) matrix;
        for (int i = 0; i < this.numRows; i++) {
            for (int i2 = 0; i2 < this.numCols; i2++) {
                set(i, i2, dMatrix.get(i, i2));
            }
        }
    }

    @Override // org.ejml.data.DMatrix
    public int getNumElements() {
        return this.numRows * this.numCols;
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    @Override // org.ejml.data.Matrix
    public DMatrixRBlock copy() {
        DMatrixRBlock dMatrixRBlock = new DMatrixRBlock(this.numRows, this.numCols, this.blockLength);
        dMatrixRBlock.set(this);
        return dMatrixRBlock;
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
