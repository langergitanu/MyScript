package org.ejml.data;

/* JADX INFO: loaded from: classes9.dex */
public abstract class DMatrixD1 implements ReshapeMatrix, DMatrix {
    public double[] data;
    public int numCols;
    public int numRows;

    public abstract int getIndex(int i, int i2);

    public abstract void reshape(int i, int i2, boolean z);

    public double[] getData() {
        return this.data;
    }

    public void setData(double[] dArr) {
        this.data = dArr;
    }

    public void set(DMatrixD1 dMatrixD1) {
        reshape(dMatrixD1.numRows, dMatrixD1.numCols);
        System.arraycopy(dMatrixD1.data, 0, this.data, 0, dMatrixD1.getNumElements());
    }

    public double get(int i) {
        return this.data[i];
    }

    public double set(int i, double d) {
        this.data[i] = d;
        return d;
    }

    public double plus(int i, double d) {
        double[] dArr = this.data;
        double d2 = dArr[i] + d;
        dArr[i] = d2;
        return d2;
    }

    public double minus(int i, double d) {
        double[] dArr = this.data;
        double d2 = dArr[i] - d;
        dArr[i] = d2;
        return d2;
    }

    public double times(int i, double d) {
        double[] dArr = this.data;
        double d2 = dArr[i] * d;
        dArr[i] = d2;
        return d2;
    }

    public double div(int i, double d) {
        double[] dArr = this.data;
        double d2 = dArr[i] / d;
        dArr[i] = d2;
        return d2;
    }

    @Override // org.ejml.data.ReshapeMatrix
    public void reshape(int i, int i2) {
        reshape(i, i2, false);
    }

    public DMatrixIterator iterator(boolean z, int i, int i2, int i3, int i4) {
        return new DMatrixIterator(this, z, i, i2, i3, i4);
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
}
