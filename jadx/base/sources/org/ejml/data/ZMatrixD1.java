package org.ejml.data;

import org.ejml.MatrixDimensionException;

/* JADX INFO: loaded from: classes9.dex */
public abstract class ZMatrixD1 implements ZMatrix, ReshapeMatrix {
    public double[] data;
    public int numCols;
    public int numRows;

    public abstract int getIndex(int i, int i2);

    public double[] getData() {
        return this.data;
    }

    public void setData(double[] dArr) {
        this.data = dArr;
    }

    public void set(ZMatrixD1 zMatrixD1) {
        if (this.numRows != zMatrixD1.numRows || this.numCols != zMatrixD1.numCols) {
            throw new MatrixDimensionException("The two matrices do not have compatible shapes.");
        }
        System.arraycopy(zMatrixD1.data, 0, this.data, 0, zMatrixD1.getDataLength());
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
