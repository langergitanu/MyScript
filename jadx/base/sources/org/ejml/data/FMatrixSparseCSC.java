package org.ejml.data;

import java.util.Arrays;
import org.ejml.ops.SortCoupledArray_F32;

/* JADX INFO: loaded from: classes9.dex */
public class FMatrixSparseCSC implements FMatrixSparse {
    public int[] col_idx;
    public boolean indicesSorted;
    public int numCols;
    public int numRows;
    public int nz_length;
    public int[] nz_rows;
    public float[] nz_values;

    public FMatrixSparseCSC(int i, int i2) {
        this(i, i2, 0);
    }

    public FMatrixSparseCSC(int i, int i2, int i3) {
        this.indicesSorted = false;
        int iMin = Math.min(i2 * i, i3);
        this.numRows = i;
        this.numCols = i2;
        this.nz_length = 0;
        this.nz_values = new float[iMin];
        this.col_idx = new int[i2 + 1];
        this.nz_rows = new int[iMin];
    }

    public FMatrixSparseCSC(FMatrixSparseCSC fMatrixSparseCSC) {
        this(fMatrixSparseCSC.numRows, fMatrixSparseCSC.numCols, fMatrixSparseCSC.nz_length);
        set(fMatrixSparseCSC);
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
    public FMatrixSparseCSC copy() {
        return new FMatrixSparseCSC(this);
    }

    @Override // org.ejml.data.Matrix
    public FMatrixSparseCSC createLike() {
        return new FMatrixSparseCSC(this.numRows, this.numCols);
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        FMatrixSparseCSC fMatrixSparseCSC = (FMatrixSparseCSC) matrix;
        reshape(fMatrixSparseCSC.numRows, fMatrixSparseCSC.numCols, fMatrixSparseCSC.nz_length);
        int i = fMatrixSparseCSC.nz_length;
        this.nz_length = i;
        System.arraycopy(fMatrixSparseCSC.nz_values, 0, this.nz_values, 0, i);
        System.arraycopy(fMatrixSparseCSC.nz_rows, 0, this.nz_rows, 0, this.nz_length);
        System.arraycopy(fMatrixSparseCSC.col_idx, 0, this.col_idx, 0, this.numCols + 1);
        this.indicesSorted = fMatrixSparseCSC.indicesSorted;
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        System.out.println(getClass().getSimpleName() + "\nnumRows = " + this.numRows + " , numCols = " + this.numCols + " , nz_length = " + this.nz_length);
        for (int i = 0; i < this.numRows; i++) {
            for (int i2 = 0; i2 < this.numCols; i2++) {
                if (nz_index(i, i2) >= 0) {
                    System.out.printf("%6.3ff", Float.valueOf(get(i, i2)));
                } else {
                    System.out.print("   *  ");
                }
                if (i2 != this.numCols - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    @Override // org.ejml.data.FMatrixSparse
    public void printNonZero() {
        System.out.println(getClass().getSimpleName() + "\nnumRows = " + this.numRows + " , numCols = " + this.numCols + " , nz_length = " + this.nz_length);
        int i = 0;
        while (i < this.numCols) {
            int[] iArr = this.col_idx;
            int i2 = i + 1;
            int i3 = iArr[i2];
            for (int i4 = iArr[i]; i4 < i3; i4++) {
                System.out.printf("%d %d %f\n", Integer.valueOf(this.nz_rows[i4]), Integer.valueOf(i), Float.valueOf(this.nz_values[i4]));
            }
            i = i2;
        }
    }

    @Override // org.ejml.data.FMatrixSparse
    public boolean isAssigned(int i, int i2) {
        return nz_index(i, i2) >= 0;
    }

    @Override // org.ejml.data.FMatrix
    public float get(int i, int i2) {
        if (i < 0 || i >= this.numRows || i2 < 0 || i2 >= this.numCols) {
            throw new IllegalArgumentException("Outside of matrix bounds");
        }
        return unsafe_get(i, i2);
    }

    @Override // org.ejml.data.FMatrix
    public float unsafe_get(int i, int i2) {
        int iNz_index = nz_index(i, i2);
        if (iNz_index >= 0) {
            return this.nz_values[iNz_index];
        }
        return 0.0f;
    }

    public int nz_index(int i, int i2) {
        int[] iArr = this.col_idx;
        int i3 = iArr[i2 + 1];
        for (int i4 = iArr[i2]; i4 < i3; i4++) {
            if (this.nz_rows[i4] == i) {
                return i4;
            }
        }
        return -1;
    }

    @Override // org.ejml.data.FMatrix
    public void set(int i, int i2, float f) {
        if (i < 0 || i >= this.numRows || i2 < 0 || i2 >= this.numCols) {
            throw new IllegalArgumentException("Outside of matrix bounds");
        }
        unsafe_set(i, i2, f);
    }

    @Override // org.ejml.data.FMatrix
    public void unsafe_set(int i, int i2, float f) {
        int iNz_index = nz_index(i, i2);
        if (iNz_index >= 0) {
            this.nz_values[iNz_index] = f;
            return;
        }
        int[] iArr = this.col_idx;
        int i3 = iArr[i2];
        int i4 = i2 + 1;
        int i5 = iArr[i4];
        while (i3 < i5 && i >= this.nz_rows[i3]) {
            i3++;
        }
        while (i4 <= this.numCols) {
            int[] iArr2 = this.col_idx;
            iArr2[i4] = iArr2[i4] + 1;
            i4++;
        }
        int i6 = this.nz_length;
        if (i6 >= this.nz_values.length) {
            growMaxLength((i6 * 2) + 1, true);
        }
        for (int i7 = this.nz_length; i7 > i3; i7--) {
            int[] iArr3 = this.nz_rows;
            int i8 = i7 - 1;
            iArr3[i7] = iArr3[i8];
            float[] fArr = this.nz_values;
            fArr[i7] = fArr[i8];
        }
        this.nz_rows[i3] = i;
        this.nz_values[i3] = f;
        this.nz_length++;
    }

    @Override // org.ejml.data.FMatrixSparse
    public void remove(int i, int i2) {
        int iNz_index = nz_index(i, i2);
        if (iNz_index < 0) {
            return;
        }
        while (true) {
            i2++;
            if (i2 > this.numCols) {
                break;
            }
            this.col_idx[i2] = r0[i2] - 1;
        }
        this.nz_length--;
        while (iNz_index < this.nz_length) {
            int[] iArr = this.nz_rows;
            int i3 = iNz_index + 1;
            iArr[iNz_index] = iArr[i3];
            float[] fArr = this.nz_values;
            fArr[iNz_index] = fArr[i3];
            iNz_index = i3;
        }
    }

    @Override // org.ejml.data.FMatrixSparse
    public void zero() {
        Arrays.fill(this.col_idx, 0, this.numCols + 1, 0);
        this.nz_length = 0;
        this.indicesSorted = false;
    }

    @Override // org.ejml.data.FMatrix
    public int getNumElements() {
        return this.nz_length;
    }

    @Override // org.ejml.data.FMatrixSparse
    public void reshape(int i, int i2, int i3) {
        this.indicesSorted = false;
        this.numRows = i;
        this.numCols = i2;
        growMaxLength(i3, false);
        this.nz_length = 0;
        int i4 = i2 + 1;
        int[] iArr = this.col_idx;
        if (i4 > iArr.length) {
            this.col_idx = new int[i4];
        } else {
            Arrays.fill(iArr, 0, i4, 0);
        }
    }

    @Override // org.ejml.data.FMatrixSparse
    public void shrinkArrays() {
        int i = this.nz_length;
        float[] fArr = this.nz_values;
        if (i < fArr.length) {
            float[] fArr2 = new float[i];
            int[] iArr = new int[i];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.nz_rows, 0, iArr, 0, this.nz_length);
            this.nz_values = fArr2;
            this.nz_rows = iArr;
        }
    }

    public void growMaxLength(int i, boolean z) {
        int iMin = Math.min(this.numRows * this.numCols, i);
        float[] fArr = this.nz_values;
        if (iMin > fArr.length) {
            float[] fArr2 = new float[iMin];
            int[] iArr = new int[iMin];
            if (z) {
                System.arraycopy(fArr, 0, fArr2, 0, this.nz_length);
                System.arraycopy(this.nz_rows, 0, iArr, 0, this.nz_length);
            }
            this.nz_values = fArr2;
            this.nz_rows = iArr;
        }
    }

    public void growMaxColumns(int i, boolean z) {
        int[] iArr = this.col_idx;
        int i2 = i + 1;
        if (iArr.length < i2) {
            int[] iArr2 = new int[i2];
            if (z) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            }
            this.col_idx = iArr2;
        }
    }

    public void colsum(int[] iArr) {
        int i;
        this.col_idx[0] = 0;
        int i2 = 1;
        int i3 = 0;
        while (true) {
            i = this.numCols;
            if (i2 > i) {
                break;
            }
            int[] iArr2 = this.col_idx;
            i3 += iArr[i2 - 1];
            iArr2[i2] = i3;
            i2++;
        }
        System.arraycopy(this.col_idx, 0, iArr, 0, i);
        this.nz_length = i3;
        growMaxLength(i3, false);
        if (this.col_idx[this.numCols] != this.nz_length) {
            throw new RuntimeException("Egads");
        }
    }

    public void sortIndices(SortCoupledArray_F32 sortCoupledArray_F32) {
        if (sortCoupledArray_F32 == null) {
            sortCoupledArray_F32 = new SortCoupledArray_F32();
        }
        sortCoupledArray_F32.quick(this.col_idx, this.numCols + 1, this.nz_rows, this.nz_values);
        this.indicesSorted = true;
    }

    public void copyStructure(FMatrixSparseCSC fMatrixSparseCSC) {
        reshape(fMatrixSparseCSC.numRows, fMatrixSparseCSC.numCols, fMatrixSparseCSC.nz_length);
        this.nz_length = fMatrixSparseCSC.nz_length;
        System.arraycopy(fMatrixSparseCSC.col_idx, 0, this.col_idx, 0, fMatrixSparseCSC.numCols + 1);
        System.arraycopy(fMatrixSparseCSC.nz_rows, 0, this.nz_rows, 0, fMatrixSparseCSC.nz_length);
    }

    public boolean isIndicesSorted() {
        return this.indicesSorted;
    }

    public boolean isFull() {
        return this.nz_length == this.numRows * this.numCols;
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.FSCC;
    }
}
