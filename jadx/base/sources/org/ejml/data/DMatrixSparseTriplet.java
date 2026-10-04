package org.ejml.data;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX INFO: loaded from: classes9.dex */
public class DMatrixSparseTriplet implements DMatrixSparse {
    public int numCols;
    public int numRows;
    public Element[] nz_data;
    public int nz_length;

    public DMatrixSparseTriplet() {
        this.nz_data = new Element[0];
    }

    public DMatrixSparseTriplet(int i, int i2, int i3) {
        this.nz_data = new Element[0];
        growData(i3);
        this.numRows = i;
        this.numCols = i2;
    }

    public DMatrixSparseTriplet(DMatrixSparseTriplet dMatrixSparseTriplet) {
        this.nz_data = new Element[0];
        set(dMatrixSparseTriplet);
    }

    public void reset() {
        this.nz_length = 0;
        this.numRows = 0;
        this.numCols = 0;
    }

    public void reshape(int i, int i2) {
        this.numRows = i;
        this.numCols = i2;
        this.nz_length = 0;
    }

    @Override // org.ejml.data.DMatrixSparse
    public void reshape(int i, int i2, int i3) {
        reshape(i, i2);
        growData(i3);
    }

    public void addItem(int i, int i2, double d) {
        int i3 = this.nz_length;
        if (i3 == this.nz_data.length) {
            growData((i3 * 2) + 10);
        }
        Element[] elementArr = this.nz_data;
        int i4 = this.nz_length;
        this.nz_length = i4 + 1;
        elementArr[i4].set(i, i2, d);
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
        if (iNz_index < 0) {
            addItem(i, i2, d);
        } else {
            this.nz_data[iNz_index].value = d;
        }
    }

    @Override // org.ejml.data.DMatrix
    public int getNumElements() {
        return this.nz_length;
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
        return iNz_index < 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : this.nz_data[iNz_index].value;
    }

    public int nz_index(int i, int i2) {
        for (int i3 = 0; i3 < this.nz_length; i3++) {
            Element element = this.nz_data[i3];
            if (element.row == i && element.col == i2) {
                return i3;
            }
        }
        return -1;
    }

    public void growData(int i) {
        Element[] elementArr = this.nz_data;
        if (elementArr.length < i) {
            Element[] elementArr2 = new Element[i];
            System.arraycopy(elementArr, 0, elementArr2, 0, elementArr.length);
            for (int length = this.nz_data.length; length < i; length++) {
                elementArr2[length] = new Element();
            }
            this.nz_data = elementArr2;
        }
    }

    public int getLength() {
        return this.nz_length;
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
        return new DMatrixSparseTriplet(this);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new DMatrixSparseTriplet(this.numRows, this.numCols, this.nz_length);
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        DMatrixSparseTriplet dMatrixSparseTriplet = (DMatrixSparseTriplet) matrix;
        reshape(dMatrixSparseTriplet.numRows, dMatrixSparseTriplet.numCols);
        growData(dMatrixSparseTriplet.nz_length);
        this.nz_length = dMatrixSparseTriplet.nz_length;
        for (int i = 0; i < this.nz_length; i++) {
            this.nz_data[i].set(dMatrixSparseTriplet.nz_data[i]);
        }
    }

    @Override // org.ejml.data.DMatrixSparse
    public void shrinkArrays() {
        int i = this.nz_length;
        Element[] elementArr = this.nz_data;
        if (i < elementArr.length) {
            Element[] elementArr2 = new Element[i];
            System.arraycopy(elementArr, 0, elementArr2, 0, i);
            this.nz_data = elementArr2;
        }
    }

    @Override // org.ejml.data.DMatrixSparse
    public void remove(int i, int i2) {
        int iNz_index = nz_index(i, i2);
        if (iNz_index < 0) {
            return;
        }
        Element element = this.nz_data[iNz_index];
        this.nz_length--;
        while (true) {
            int i3 = this.nz_length;
            if (iNz_index < i3) {
                Element[] elementArr = this.nz_data;
                int i4 = iNz_index + 1;
                elementArr[iNz_index] = elementArr[i4];
                iNz_index = i4;
            } else {
                this.nz_data[i3] = element;
                return;
            }
        }
    }

    @Override // org.ejml.data.DMatrixSparse
    public boolean isAssigned(int i, int i2) {
        return nz_index(i, i2) >= 0;
    }

    @Override // org.ejml.data.DMatrixSparse
    public void zero() {
        this.nz_length = 0;
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        System.out.println(getClass().getSimpleName() + "\n , numRows = " + this.numRows + " , numCols = " + this.numCols + " , nz_length = " + this.nz_length);
        for (int i = 0; i < this.numRows; i++) {
            for (int i2 = 0; i2 < this.numCols; i2++) {
                int iNz_index = nz_index(i, i2);
                if (iNz_index >= 0) {
                    System.out.printf("%6.3f", Double.valueOf(this.nz_data[iNz_index].value));
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
        System.out.println(getClass().getSimpleName() + "\n , numRows = " + this.numRows + " , numCols = " + this.numCols + " , nz_length = " + this.nz_length);
        for (int i = 0; i < this.nz_length; i++) {
            Element element = this.nz_data[i];
            System.out.printf("%d %d %f\n", Integer.valueOf(element.row), Integer.valueOf(element.col), Double.valueOf(element.value));
        }
    }

    public static class Element {
        public int col;
        public int row;
        public double value;

        public void set(int i, int i2, double d) {
            this.row = i;
            this.col = i2;
            this.value = d;
        }

        public void set(Element element) {
            this.row = element.row;
            this.col = element.col;
            this.value = element.value;
        }
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.UNSPECIFIED;
    }
}
