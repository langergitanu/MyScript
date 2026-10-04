package org.ejml.data;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class DMatrixRMaj extends DMatrix1Row {
    public DMatrixRMaj(int i, int i2, boolean z, double... dArr) {
        this.data = new double[i * i2];
        this.numRows = i;
        this.numCols = i2;
        set(i, i2, z, dArr);
    }

    public DMatrixRMaj(double[][] dArr) {
        this.numRows = dArr.length;
        this.numCols = dArr[0].length;
        this.data = new double[this.numRows * this.numCols];
        int i = 0;
        for (int i2 = 0; i2 < this.numRows; i2++) {
            double[] dArr2 = dArr[i2];
            if (dArr2.length != this.numCols) {
                throw new IllegalArgumentException("All rows must have the same length");
            }
            System.arraycopy(dArr2, 0, this.data, i, this.numCols);
            i += this.numCols;
        }
    }

    public DMatrixRMaj(int i, int i2) {
        this.data = new double[i * i2];
        this.numRows = i;
        this.numCols = i2;
    }

    public DMatrixRMaj(DMatrixRMaj dMatrixRMaj) {
        this(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        System.arraycopy(dMatrixRMaj.data, 0, this.data, 0, dMatrixRMaj.getNumElements());
    }

    public DMatrixRMaj(int i) {
        this.data = new double[i];
    }

    public DMatrixRMaj() {
    }

    public DMatrixRMaj(DMatrix dMatrix) {
        this(dMatrix.getNumRows(), dMatrix.getNumCols());
        for (int i = 0; i < this.numRows; i++) {
            for (int i2 = 0; i2 < this.numCols; i2++) {
                set(i, i2, dMatrix.get(i, i2));
            }
        }
    }

    public static DMatrixRMaj wrap(int i, int i2, double[] dArr) {
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj();
        dMatrixRMaj.data = dArr;
        dMatrixRMaj.numRows = i;
        dMatrixRMaj.numCols = i2;
        return dMatrixRMaj;
    }

    @Override // org.ejml.data.DMatrixD1
    public void reshape(int i, int i2, boolean z) {
        int i3 = i * i2;
        if (this.data.length < i3) {
            double[] dArr = new double[i3];
            if (z) {
                System.arraycopy(this.data, 0, dArr, 0, getNumElements());
            }
            this.data = dArr;
        }
        this.numRows = i;
        this.numCols = i2;
    }

    @Override // org.ejml.data.DMatrix
    public void set(int i, int i2, double d) {
        if (i2 < 0 || i2 >= this.numCols || i < 0 || i >= this.numRows) {
            throw new IllegalArgumentException("Specified element is out of bounds: (" + i + " , " + i2 + ")");
        }
        this.data[(i * this.numCols) + i2] = d;
    }

    @Override // org.ejml.data.DMatrix
    public void unsafe_set(int i, int i2, double d) {
        this.data[(i * this.numCols) + i2] = d;
    }

    public void add(int i, int i2, double d) {
        if (i2 < 0 || i2 >= this.numCols || i < 0 || i >= this.numRows) {
            throw new IllegalArgumentException("Specified element is out of bounds");
        }
        double[] dArr = this.data;
        int i3 = (i * this.numCols) + i2;
        dArr[i3] = dArr[i3] + d;
    }

    @Override // org.ejml.data.DMatrix
    public double get(int i, int i2) {
        if (i2 < 0 || i2 >= this.numCols || i < 0 || i >= this.numRows) {
            throw new IllegalArgumentException("Specified element is out of bounds: " + i + " " + i2);
        }
        return this.data[(i * this.numCols) + i2];
    }

    @Override // org.ejml.data.DMatrix
    public double unsafe_get(int i, int i2) {
        return this.data[(i * this.numCols) + i2];
    }

    @Override // org.ejml.data.DMatrixD1
    public int getIndex(int i, int i2) {
        return (i * this.numCols) + i2;
    }

    public boolean isInBounds(int i, int i2) {
        return i2 >= 0 && i2 < this.numCols && i >= 0 && i < this.numRows;
    }

    @Override // org.ejml.data.DMatrix
    public int getNumElements() {
        return this.numRows * this.numCols;
    }

    public void set(int i, int i2, boolean z, double... dArr) {
        reshape(i, i2);
        int i3 = i * i2;
        if (i3 > this.data.length) {
            throw new IllegalArgumentException("The length of this matrix's data array is too small.");
        }
        if (z) {
            System.arraycopy(dArr, 0, this.data, 0, i3);
            return;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = 0;
            while (i6 < i2) {
                this.data[i4] = dArr[(i6 * i) + i5];
                i6++;
                i4++;
            }
        }
    }

    public void zero() {
        Arrays.fill(this.data, 0, getNumElements(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    @Override // org.ejml.data.Matrix
    public DMatrixRMaj copy() {
        return new DMatrixRMaj(this);
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        DMatrix dMatrix = (DMatrix) matrix;
        reshape(matrix.getNumRows(), matrix.getNumCols());
        if (matrix instanceof DMatrixRMaj) {
            System.arraycopy(((DMatrixRMaj) dMatrix).data, 0, this.data, 0, this.numRows * this.numCols);
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.numRows; i2++) {
            int i3 = 0;
            while (i3 < this.numCols) {
                this.data[i] = dMatrix.get(i2, i3);
                i3++;
                i++;
            }
        }
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    public void print(String str) {
        MatrixIO.print(System.out, this, str);
    }

    public String toString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        MatrixIO.print(new PrintStream(byteArrayOutputStream), this);
        return byteArrayOutputStream.toString();
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new DMatrixRMaj(this.numRows, this.numCols);
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.DDRM;
    }
}
