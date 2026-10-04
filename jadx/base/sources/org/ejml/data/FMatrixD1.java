package org.ejml.data;

/* JADX INFO: loaded from: classes9.dex */
public abstract class FMatrixD1 implements ReshapeMatrix, FMatrix {
    public float[] data;
    public int numCols;
    public int numRows;

    public abstract int getIndex(int i, int i2);

    public abstract void reshape(int i, int i2, boolean z);

    public float[] getData() {
        return this.data;
    }

    public void setData(float[] fArr) {
        this.data = fArr;
    }

    public void set(FMatrixD1 fMatrixD1) {
        reshape(fMatrixD1.numRows, fMatrixD1.numCols);
        System.arraycopy(fMatrixD1.data, 0, this.data, 0, fMatrixD1.getNumElements());
    }

    public float get(int i) {
        return this.data[i];
    }

    public float set(int i, float f) {
        this.data[i] = f;
        return f;
    }

    public float plus(int i, float f) {
        float[] fArr = this.data;
        float f2 = fArr[i] + f;
        fArr[i] = f2;
        return f2;
    }

    public float minus(int i, float f) {
        float[] fArr = this.data;
        float f2 = fArr[i] - f;
        fArr[i] = f2;
        return f2;
    }

    public float times(int i, float f) {
        float[] fArr = this.data;
        float f2 = fArr[i] * f;
        fArr[i] = f2;
        return f2;
    }

    public float div(int i, float f) {
        float[] fArr = this.data;
        float f2 = fArr[i] / f;
        fArr[i] = f2;
        return f2;
    }

    @Override // org.ejml.data.ReshapeMatrix
    public void reshape(int i, int i2) {
        reshape(i, i2, false);
    }

    public FMatrixIterator iterator(boolean z, int i, int i2, int i3, int i4) {
        return new FMatrixIterator(this, z, i, i2, i3, i4);
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
