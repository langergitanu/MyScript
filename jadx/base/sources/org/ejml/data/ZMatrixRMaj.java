package org.ejml.data;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class ZMatrixRMaj extends ZMatrixD1 {
    public ZMatrixRMaj(double[][] dArr) {
        this.numRows = dArr.length;
        this.numCols = dArr[0].length / 2;
        this.data = new double[this.numRows * this.numCols * 2];
        for (int i = 0; i < this.numRows; i++) {
            double[] dArr2 = dArr[i];
            if (dArr2.length != this.numCols * 2) {
                throw new IllegalArgumentException("Unexpected row size in input data at row " + i);
            }
            System.arraycopy(dArr2, 0, this.data, this.numCols * i * 2, dArr2.length);
        }
    }

    public ZMatrixRMaj(int i, int i2, boolean z, double... dArr) {
        int i3 = i * i2 * 2;
        if (dArr.length != i3) {
            throw new RuntimeException("Unexpected length for data");
        }
        this.data = new double[i3];
        this.numRows = i;
        this.numCols = i2;
        set(i, i2, z, dArr);
    }

    public ZMatrixRMaj(ZMatrixRMaj zMatrixRMaj) {
        this(zMatrixRMaj.numRows, zMatrixRMaj.numCols);
        set(zMatrixRMaj);
    }

    public ZMatrixRMaj(int i, int i2) {
        this.numRows = i;
        this.numCols = i2;
        this.data = new double[i * i2 * 2];
    }

    @Override // org.ejml.data.ZMatrixD1
    public int getIndex(int i, int i2) {
        return (i * this.numCols * 2) + (i2 * 2);
    }

    @Override // org.ejml.data.ReshapeMatrix
    public void reshape(int i, int i2) {
        int i3 = i * i2 * 2;
        if (i3 > this.data.length) {
            this.data = new double[i3];
        }
        this.numRows = i;
        this.numCols = i2;
    }

    @Override // org.ejml.data.ZMatrix
    public void get(int i, int i2, Complex_F64 complex_F64) {
        int i3 = (i * this.numCols * 2) + (i2 * 2);
        complex_F64.real = this.data[i3];
        complex_F64.imaginary = this.data[i3 + 1];
    }

    @Override // org.ejml.data.ZMatrix
    public void set(int i, int i2, double d, double d2) {
        int i3 = (i * this.numCols * 2) + (i2 * 2);
        this.data[i3] = d;
        this.data[i3 + 1] = d2;
    }

    @Override // org.ejml.data.ZMatrix
    public double getReal(int i, int i2) {
        return this.data[((i * this.numCols) + i2) * 2];
    }

    @Override // org.ejml.data.ZMatrix
    public void setReal(int i, int i2, double d) {
        this.data[((i * this.numCols) + i2) * 2] = d;
    }

    @Override // org.ejml.data.ZMatrix
    public double getImag(int i, int i2) {
        return this.data[(((i * this.numCols) + i2) * 2) + 1];
    }

    @Override // org.ejml.data.ZMatrix
    public void setImag(int i, int i2, double d) {
        this.data[(((i * this.numCols) + i2) * 2) + 1] = d;
    }

    @Override // org.ejml.data.ZMatrix
    public int getDataLength() {
        return this.numRows * this.numCols * 2;
    }

    public void set(ZMatrixRMaj zMatrixRMaj) {
        reshape(zMatrixRMaj.numRows, zMatrixRMaj.numCols);
        int i = this.numCols * 2;
        for (int i2 = 0; i2 < this.numRows; i2++) {
            int i3 = this.numCols * i2 * 2;
            System.arraycopy(zMatrixRMaj.data, i3, this.data, i3, i);
        }
    }

    @Override // org.ejml.data.Matrix
    public ZMatrixRMaj copy() {
        return new ZMatrixRMaj(this);
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        reshape(matrix.getNumRows(), matrix.getNumCols());
        ZMatrix zMatrix = (ZMatrix) matrix;
        Complex_F64 complex_F64 = new Complex_F64();
        for (int i = 0; i < this.numRows; i++) {
            for (int i2 = 0; i2 < this.numCols; i2++) {
                zMatrix.get(i, i2, complex_F64);
                set(i, i2, complex_F64.real, complex_F64.imaginary);
            }
        }
    }

    @Override // org.ejml.data.Matrix
    public void print() {
        MatrixIO.print(System.out, this);
    }

    public int getRowStride() {
        return this.numCols * 2;
    }

    public void set(int i, int i2, boolean z, double... dArr) {
        reshape(i, i2);
        int i3 = i * i2 * 2;
        if (i3 > dArr.length) {
            throw new RuntimeException("Passed in array not long enough");
        }
        if (z) {
            System.arraycopy(dArr, 0, this.data, 0, i3);
            return;
        }
        int i4 = i * 2;
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            for (int i7 = 0; i7 < i2; i7++) {
                int i8 = i5 + 1;
                int i9 = (i7 * i4) + (i6 * 2);
                this.data[i5] = dArr[i9];
                i5 += 2;
                this.data[i8] = dArr[i9 + 1];
            }
        }
    }

    public void zero() {
        Arrays.fill(this.data, 0, this.numCols * this.numRows * 2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new ZMatrixRMaj(this.numRows, this.numCols);
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.ZDRM;
    }
}
