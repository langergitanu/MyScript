package org.ejml.data;

import org.ejml.MatrixDimensionException;

/* JADX INFO: loaded from: classes9.dex */
public abstract class CMatrixD1 implements CMatrix, ReshapeMatrix {
    public float[] data;
    public int numCols;
    public int numRows;

    public abstract int getIndex(int i, int i2);

    public float[] getData() {
        return this.data;
    }

    public void setData(float[] fArr) {
        this.data = fArr;
    }

    public void set(CMatrixD1 cMatrixD1) {
        if (this.numRows != cMatrixD1.numRows || this.numCols != cMatrixD1.numCols) {
            throw new MatrixDimensionException("The two matrices do not have compatible shapes.");
        }
        System.arraycopy(cMatrixD1.data, 0, this.data, 0, cMatrixD1.getDataLength());
    }

    @Override // org.ejml.data.Matrix
    public int getNumRows() {
        return this.numRows;
    }

    @Override // org.ejml.data.Matrix
    public int getNumCols() {
        return this.numCols;
    }

    public void setNumRows(int i) {
        this.numRows = i;
    }

    public void setNumCols(int i) {
        this.numCols = i;
    }

    public int getNumElements() {
        return this.numRows * this.numCols;
    }
}
