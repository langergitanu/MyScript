package org.ejml.data;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import org.ejml.ops.SortCoupledArray_F64;

/* JADX INFO: loaded from: classes9.dex */
public class DMatrixSparseCSC implements DMatrixSparse {
    public int[] col_idx;
    public boolean indicesSorted;
    public int numCols;
    public int numRows;
    public int nz_length;
    public int[] nz_rows;
    public double[] nz_values;

    public DMatrixSparseCSC(int i, int i2) {
        this(i, i2, 0);
    }

    public DMatrixSparseCSC(int i, int i2, int i3) {
        this.indicesSorted = false;
        int iMin = Math.min(i2 * i, i3);
        this.numRows = i;
        this.numCols = i2;
        this.nz_length = 0;
        this.nz_values = new double[iMin];
        this.col_idx = new int[i2 + 1];
        this.nz_rows = new int[iMin];
    }

    public DMatrixSparseCSC(DMatrixSparseCSC dMatrixSparseCSC) {
        this(dMatrixSparseCSC.numRows, dMatrixSparseCSC.numCols, dMatrixSparseCSC.nz_length);
        set(dMatrixSparseCSC);
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
    public DMatrixSparseCSC copy() {
        return new DMatrixSparseCSC(this);
    }

    @Override // org.ejml.data.Matrix
    public DMatrixSparseCSC createLike() {
        return new DMatrixSparseCSC(this.numRows, this.numCols);
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        DMatrixSparseCSC dMatrixSparseCSC = (DMatrixSparseCSC) matrix;
        reshape(dMatrixSparseCSC.numRows, dMatrixSparseCSC.numCols, dMatrixSparseCSC.nz_length);
        int i = dMatrixSparseCSC.nz_length;
        this.nz_length = i;
        System.arraycopy(dMatrixSparseCSC.nz_values, 0, this.nz_values, 0, i);
        System.arraycopy(dMatrixSparseCSC.nz_rows, 0, this.nz_rows, 0, this.nz_length);
        System.arraycopy(dMatrixSparseCSC.col_idx, 0, this.col_idx, 0, this.numCols + 1);
        this.indicesSorted = dMatrixSparseCSC.indicesSorted;
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        System.out.println(getClass().getSimpleName() + "\nnumRows = " + this.numRows + " , numCols = " + this.numCols + " , nz_length = " + this.nz_length);
        for (int i = 0; i < this.numRows; i++) {
            for (int i2 = 0; i2 < this.numCols; i2++) {
                if (nz_index(i, i2) >= 0) {
                    System.out.printf("%6.3f", Double.valueOf(get(i, i2)));
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

    @Override // org.ejml.data.DMatrixSparse
    public void printNonZero() {
        System.out.println(getClass().getSimpleName() + "\nnumRows = " + this.numRows + " , numCols = " + this.numCols + " , nz_length = " + this.nz_length);
        int i = 0;
        while (i < this.numCols) {
            int[] iArr = this.col_idx;
            int i2 = i + 1;
            int i3 = iArr[i2];
            for (int i4 = iArr[i]; i4 < i3; i4++) {
                System.out.printf("%d %d %f\n", Integer.valueOf(this.nz_rows[i4]), Integer.valueOf(i), Double.valueOf(this.nz_values[i4]));
            }
            i = i2;
        }
    }

    @Override // org.ejml.data.DMatrixSparse
    public boolean isAssigned(int i, int i2) {
        return nz_index(i, i2) >= 0;
    }

    @Override // org.ejml.data.DMatrix
    public double get(int i, int i2) {
        if (i < 0 || i >= this.numRows || i2 < 0 || i2 >= this.numCols) {
            throw new IllegalArgumentException("Outside of matrix bounds");
        }
        return unsafe_get(i, i2);
    }

    @Override // org.ejml.data.DMatrix
    public double unsafe_get(int i, int i2) {
        int iNz_index = nz_index(i, i2);
        return iNz_index >= 0 ? this.nz_values[iNz_index] : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
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

    @Override // org.ejml.data.DMatrix
    public void set(int i, int i2, double d) {
        if (i < 0 || i >= this.numRows || i2 < 0 || i2 >= this.numCols) {
            throw new IllegalArgumentException("Outside of matrix bounds");
        }
        unsafe_set(i, i2, d);
    }

    @Override // org.ejml.data.DMatrix
    public void unsafe_set(int i, int i2, double d) {
        int iNz_index = nz_index(i, i2);
        if (iNz_index >= 0) {
            this.nz_values[iNz_index] = d;
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
            double[] dArr = this.nz_values;
            dArr[i7] = dArr[i8];
        }
        this.nz_rows[i3] = i;
        this.nz_values[i3] = d;
        this.nz_length++;
    }

    @Override // org.ejml.data.DMatrixSparse
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
            double[] dArr = this.nz_values;
            dArr[iNz_index] = dArr[i3];
            iNz_index = i3;
        }
    }

    @Override // org.ejml.data.DMatrixSparse
    public void zero() {
        Arrays.fill(this.col_idx, 0, this.numCols + 1, 0);
        this.nz_length = 0;
        this.indicesSorted = false;
    }

    @Override // org.ejml.data.DMatrix
    public int getNumElements() {
        return this.nz_length;
    }

    @Override // org.ejml.data.DMatrixSparse
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

    @Override // org.ejml.data.DMatrixSparse
    public void shrinkArrays() {
        int i = this.nz_length;
        double[] dArr = this.nz_values;
        if (i < dArr.length) {
            double[] dArr2 = new double[i];
            int[] iArr = new int[i];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.nz_rows, 0, iArr, 0, this.nz_length);
            this.nz_values = dArr2;
            this.nz_rows = iArr;
        }
    }

    public void growMaxLength(int i, boolean z) {
        int iMin = Math.min(this.numRows * this.numCols, i);
        double[] dArr = this.nz_values;
        if (iMin > dArr.length) {
            double[] dArr2 = new double[iMin];
            int[] iArr = new int[iMin];
            if (z) {
                System.arraycopy(dArr, 0, dArr2, 0, this.nz_length);
                System.arraycopy(this.nz_rows, 0, iArr, 0, this.nz_length);
            }
            this.nz_values = dArr2;
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

    public void sortIndices(SortCoupledArray_F64 sortCoupledArray_F64) {
        if (sortCoupledArray_F64 == null) {
            sortCoupledArray_F64 = new SortCoupledArray_F64();
        }
        sortCoupledArray_F64.quick(this.col_idx, this.numCols + 1, this.nz_rows, this.nz_values);
        this.indicesSorted = true;
    }

    public void copyStructure(DMatrixSparseCSC dMatrixSparseCSC) {
        reshape(dMatrixSparseCSC.numRows, dMatrixSparseCSC.numCols, dMatrixSparseCSC.nz_length);
        this.nz_length = dMatrixSparseCSC.nz_length;
        System.arraycopy(dMatrixSparseCSC.col_idx, 0, this.col_idx, 0, dMatrixSparseCSC.numCols + 1);
        System.arraycopy(dMatrixSparseCSC.nz_rows, 0, this.nz_rows, 0, dMatrixSparseCSC.nz_length);
    }

    public boolean isIndicesSorted() {
        return this.indicesSorted;
    }

    public boolean isFull() {
        return this.nz_length == this.numRows * this.numCols;
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.DSCC;
    }
}
