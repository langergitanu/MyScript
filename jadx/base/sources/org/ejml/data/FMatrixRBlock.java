package org.ejml.data;

import org.ejml.EjmlParameters;
import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class FMatrixRBlock extends FMatrixD1 {
    public int blockLength;

    public FMatrixRBlock(int i, int i2, int i3) {
        this.data = new float[i * i2];
        this.blockLength = i3;
        this.numRows = i;
        this.numCols = i2;
    }

    public FMatrixRBlock(int i, int i2) {
        this(i, i2, EjmlParameters.BLOCK_WIDTH);
    }

    public FMatrixRBlock() {
    }

    public void set(FMatrixRBlock fMatrixRBlock) {
        this.blockLength = fMatrixRBlock.blockLength;
        this.numRows = fMatrixRBlock.numRows;
        this.numCols = fMatrixRBlock.numCols;
        int i = this.numCols * this.numRows;
        if (this.data.length < i) {
            this.data = new float[i];
        }
        System.arraycopy(fMatrixRBlock.data, 0, this.data, 0, i);
    }

    public static FMatrixRBlock wrap(float[] fArr, int i, int i2, int i3) {
        FMatrixRBlock fMatrixRBlock = new FMatrixRBlock();
        fMatrixRBlock.data = fArr;
        fMatrixRBlock.numRows = i;
        fMatrixRBlock.numCols = i2;
        fMatrixRBlock.blockLength = i3;
        return fMatrixRBlock;
    }

    @Override // org.ejml.data.FMatrixD1
    public float[] getData() {
        return this.data;
    }

    @Override // org.ejml.data.FMatrixD1
    public void reshape(int i, int i2, boolean z) {
        int i3 = i * i2;
        if (i3 <= this.data.length) {
            this.numRows = i;
            this.numCols = i2;
            return;
        }
        float[] fArr = new float[i3];
        if (z) {
            System.arraycopy(this.data, 0, fArr, 0, getNumElements());
        }
        this.numRows = i;
        this.numCols = i2;
        this.data = fArr;
    }

    public void reshape(int i, int i2, int i3, boolean z) {
        this.blockLength = i3;
        reshape(i, i2, z);
    }

    @Override // org.ejml.data.FMatrixD1
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

    @Override // org.ejml.data.FMatrix
    public float get(int i, int i2) {
        return this.data[getIndex(i, i2)];
    }

    @Override // org.ejml.data.FMatrix
    public float unsafe_get(int i, int i2) {
        return this.data[getIndex(i, i2)];
    }

    @Override // org.ejml.data.FMatrix
    public void set(int i, int i2, float f) {
        this.data[getIndex(i, i2)] = f;
    }

    @Override // org.ejml.data.FMatrix
    public void unsafe_set(int i, int i2, float f) {
        this.data[getIndex(i, i2)] = f;
    }

    @Override // org.ejml.data.FMatrixD1, org.ejml.data.Matrix
    public int getNumRows() {
        return this.numRows;
    }

    @Override // org.ejml.data.FMatrixD1, org.ejml.data.Matrix
    public int getNumCols() {
        return this.numCols;
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new FMatrixRBlock(this.numRows, this.numCols);
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        if (matrix instanceof FMatrixRBlock) {
            set((FMatrixRBlock) matrix);
            return;
        }
        FMatrix fMatrix = (FMatrix) matrix;
        for (int i = 0; i < this.numRows; i++) {
            for (int i2 = 0; i2 < this.numCols; i2++) {
                set(i, i2, fMatrix.get(i, i2));
            }
        }
    }

    @Override // org.ejml.data.FMatrix
    public int getNumElements() {
        return this.numRows * this.numCols;
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    @Override // org.ejml.data.Matrix
    public FMatrixRBlock copy() {
        FMatrixRBlock fMatrixRBlock = new FMatrixRBlock(this.numRows, this.numCols, this.blockLength);
        fMatrixRBlock.set(this);
        return fMatrixRBlock;
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
