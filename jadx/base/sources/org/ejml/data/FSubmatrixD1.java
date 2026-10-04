package org.ejml.data;

import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class FSubmatrixD1 {
    public int col0;
    public int col1;
    public FMatrixD1 original;
    public int row0;
    public int row1;

    public FSubmatrixD1() {
    }

    public FSubmatrixD1(FMatrixD1 fMatrixD1) {
        set(fMatrixD1);
    }

    public FSubmatrixD1(FMatrixD1 fMatrixD1, int i, int i2, int i3, int i4) {
        set(fMatrixD1, i, i2, i3, i4);
    }

    public void set(FMatrixD1 fMatrixD1, int i, int i2, int i3, int i4) {
        this.original = fMatrixD1;
        this.row0 = i;
        this.col0 = i3;
        this.row1 = i2;
        this.col1 = i4;
    }

    public void set(FMatrixD1 fMatrixD1) {
        this.original = fMatrixD1;
        this.row1 = fMatrixD1.numRows;
        this.col1 = fMatrixD1.numCols;
    }

    public int getRows() {
        return this.row1 - this.row0;
    }

    public int getCols() {
        return this.col1 - this.col0;
    }

    public float get(int i, int i2) {
        return this.original.get(i + this.row0, i2 + this.col0);
    }

    public void set(int i, int i2, float f) {
        this.original.set(i + this.row0, i2 + this.col0, f);
    }

    public FMatrixRMaj extract() {
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(this.row1 - this.row0, this.col1 - this.col0);
        for (int i = 0; i < fMatrixRMaj.numRows; i++) {
            for (int i2 = 0; i2 < fMatrixRMaj.numCols; i2++) {
                fMatrixRMaj.set(i, i2, get(i, i2));
            }
        }
        return fMatrixRMaj;
    }

    public void print() {
        MatrixIO.print(System.out, this.original, "%6.3ff", this.row0, this.row1, this.col0, this.col1);
    }
}
