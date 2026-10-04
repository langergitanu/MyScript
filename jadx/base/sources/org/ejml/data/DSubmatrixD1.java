package org.ejml.data;

import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class DSubmatrixD1 {
    public int col0;
    public int col1;
    public DMatrixD1 original;
    public int row0;
    public int row1;

    public DSubmatrixD1() {
    }

    public DSubmatrixD1(DMatrixD1 dMatrixD1) {
        set(dMatrixD1);
    }

    public DSubmatrixD1(DMatrixD1 dMatrixD1, int i, int i2, int i3, int i4) {
        set(dMatrixD1, i, i2, i3, i4);
    }

    public void set(DMatrixD1 dMatrixD1, int i, int i2, int i3, int i4) {
        this.original = dMatrixD1;
        this.row0 = i;
        this.col0 = i3;
        this.row1 = i2;
        this.col1 = i4;
    }

    public void set(DMatrixD1 dMatrixD1) {
        this.original = dMatrixD1;
        this.row1 = dMatrixD1.numRows;
        this.col1 = dMatrixD1.numCols;
    }

    public int getRows() {
        return this.row1 - this.row0;
    }

    public int getCols() {
        return this.col1 - this.col0;
    }

    public double get(int i, int i2) {
        return this.original.get(i + this.row0, i2 + this.col0);
    }

    public void set(int i, int i2, double d) {
        this.original.set(i + this.row0, i2 + this.col0, d);
    }

    public DMatrixRMaj extract() {
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(this.row1 - this.row0, this.col1 - this.col0);
        for (int i = 0; i < dMatrixRMaj.numRows; i++) {
            for (int i2 = 0; i2 < dMatrixRMaj.numCols; i2++) {
                dMatrixRMaj.set(i, i2, get(i, i2));
            }
        }
        return dMatrixRMaj;
    }

    public void print() {
        MatrixIO.print(System.out, this.original, "%6.3f", this.row0, this.row1, this.col0, this.col1);
    }
}
