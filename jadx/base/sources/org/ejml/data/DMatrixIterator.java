package org.ejml.data;

import java.util.Iterator;

/* JADX INFO: loaded from: classes9.dex */
public class DMatrixIterator implements Iterator<Double> {

    /* JADX INFO: renamed from: a */
    private DMatrixD1 f2417a;
    private int index = 0;
    private int minCol;
    private int minRow;
    private boolean rowMajor;
    private int size;
    int subCol;
    int subRow;
    private int submatrixStride;

    public DMatrixIterator(DMatrixD1 dMatrixD1, boolean z, int i, int i2, int i3, int i4) {
        if (i4 < i2) {
            throw new IllegalArgumentException("maxCol has to be more than or equal to minCol");
        }
        if (i3 < i) {
            throw new IllegalArgumentException("maxRow has to be more than or equal to minCol");
        }
        if (i4 >= dMatrixD1.numCols) {
            throw new IllegalArgumentException("maxCol must be < numCols");
        }
        if (i3 >= dMatrixD1.numRows) {
            throw new IllegalArgumentException("maxRow must be < numCRows");
        }
        this.f2417a = dMatrixD1;
        this.rowMajor = z;
        this.minCol = i2;
        this.minRow = i;
        int i5 = (i4 - i2) + 1;
        int i6 = (i3 - i) + 1;
        this.size = i5 * i6;
        if (z) {
            this.submatrixStride = i5;
        } else {
            this.submatrixStride = i6;
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.size;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Double next() {
        if (this.rowMajor) {
            int i = this.index;
            int i2 = this.submatrixStride;
            this.subRow = i / i2;
            this.subCol = i % i2;
        } else {
            int i3 = this.index;
            int i4 = this.submatrixStride;
            this.subRow = i3 % i4;
            this.subCol = i3 / i4;
        }
        this.index++;
        return Double.valueOf(this.f2417a.get(this.subRow + this.minRow, this.subCol + this.minCol));
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new RuntimeException("Operation not supported");
    }

    public int getIndex() {
        return this.index - 1;
    }

    public boolean isRowMajor() {
        return this.rowMajor;
    }

    public void set(double d) {
        this.f2417a.set(this.subRow + this.minRow, this.subCol + this.minCol, d);
    }
}
