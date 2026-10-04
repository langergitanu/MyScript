package org.ejml.data;

import java.util.Arrays;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes9.dex */
public class BMatrixRMaj implements ReshapeMatrix {
    public boolean[] data;
    public int numCols;
    public int numRows;

    public BMatrixRMaj(int i, int i2) {
        this.data = new boolean[i * i2];
        this.numRows = i;
        this.numCols = i2;
    }

    public int getNumElements() {
        return this.numRows * this.numCols;
    }

    public int getIndex(int i, int i2) {
        return (i * this.numCols) + i2;
    }

    public void fill(boolean z) {
        Arrays.fill(this.data, 0, getNumElements(), z);
    }

    public boolean get(int i) {
        return this.data[i];
    }

    public boolean get(int i, int i2) {
        if (!isInBounds(i, i2)) {
            throw new IllegalArgumentException("Out of matrix bounds. " + i + " " + i2);
        }
        return this.data[(i * this.numCols) + i2];
    }

    public void set(int i, int i2, boolean z) {
        if (!isInBounds(i, i2)) {
            throw new IllegalArgumentException("Out of matrix bounds. " + i + " " + i2);
        }
        this.data[(i * this.numCols) + i2] = z;
    }

    public boolean unsafe_get(int i, int i2) {
        return this.data[(i * this.numCols) + i2];
    }

    public void unsafe_set(int i, int i2, boolean z) {
        this.data[(i * this.numCols) + i2] = z;
    }

    public boolean isInBounds(int i, int i2) {
        return i2 >= 0 && i2 < this.numCols && i >= 0 && i < this.numRows;
    }

    public int sum() {
        int numElements = getNumElements();
        int i = 0;
        for (int i2 = 0; i2 < numElements; i2++) {
            if (this.data[i2]) {
                i++;
            }
        }
        return i;
    }

    @Override // org.ejml.data.ReshapeMatrix
    public void reshape(int i, int i2) {
        int i3 = i * i2;
        if (this.data.length < i3) {
            this.data = new boolean[i3];
        }
        this.numRows = i;
        this.numCols = i2;
    }

    @Override // org.ejml.data.Matrix
    public int getNumRows() {
        return this.numRows;
    }

    @Override // org.ejml.data.Matrix
    public int getNumCols() {
        return this.numCols;
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T copy() {
        BMatrixRMaj bMatrixRMaj = new BMatrixRMaj(this.numRows, this.numCols);
        bMatrixRMaj.set(this);
        return bMatrixRMaj;
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        BMatrixRMaj bMatrixRMaj = (BMatrixRMaj) matrix;
        reshape(matrix.getNumRows(), matrix.getNumCols());
        System.arraycopy(bMatrixRMaj.data, 0, this.data, 0, bMatrixRMaj.getNumElements());
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        System.out.println("Type = binary , numRows = " + this.numRows + " , numCols = " + this.numCols);
        for (int i = 0; i < this.numRows; i++) {
            for (int i2 = 0; i2 < this.numCols; i2++) {
                if (get(i, i2)) {
                    System.out.print(Marker.ANY_NON_NULL_MARKER);
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new BMatrixRMaj(this.numRows, this.numCols);
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
