package org.ejml.data;

import java.util.Arrays;
import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class CMatrixRMaj extends CMatrixD1 {
    public CMatrixRMaj(float[][] fArr) {
        this.numRows = fArr.length;
        this.numCols = fArr[0].length / 2;
        this.data = new float[this.numRows * this.numCols * 2];
        for (int i = 0; i < this.numRows; i++) {
            float[] fArr2 = fArr[i];
            if (fArr2.length != this.numCols * 2) {
                throw new IllegalArgumentException("Unexpected row size in input data at row " + i);
            }
            System.arraycopy(fArr2, 0, this.data, this.numCols * i * 2, fArr2.length);
        }
    }

    public CMatrixRMaj(int i, int i2, boolean z, float... fArr) {
        int i3 = i * i2 * 2;
        if (fArr.length != i3) {
            throw new RuntimeException("Unexpected length for data");
        }
        this.data = new float[i3];
        this.numRows = i;
        this.numCols = i2;
        set(i, i2, z, fArr);
    }

    public CMatrixRMaj(CMatrixRMaj cMatrixRMaj) {
        this(cMatrixRMaj.numRows, cMatrixRMaj.numCols);
        set(cMatrixRMaj);
    }

    public CMatrixRMaj(int i, int i2) {
        this.numRows = i;
        this.numCols = i2;
        this.data = new float[i * i2 * 2];
    }

    @Override // org.ejml.data.CMatrixD1
    public int getIndex(int i, int i2) {
        return (i * this.numCols * 2) + (i2 * 2);
    }

    @Override // org.ejml.data.ReshapeMatrix
    public void reshape(int i, int i2) {
        int i3 = i * i2 * 2;
        if (i3 > this.data.length) {
            this.data = new float[i3];
        }
        this.numRows = i;
        this.numCols = i2;
    }

    @Override // org.ejml.data.CMatrix
    public void get(int i, int i2, Complex_F32 complex_F32) {
        int i3 = (i * this.numCols * 2) + (i2 * 2);
        complex_F32.real = this.data[i3];
        complex_F32.imaginary = this.data[i3 + 1];
    }

    @Override // org.ejml.data.CMatrix
    public void set(int i, int i2, float f, float f2) {
        int i3 = (i * this.numCols * 2) + (i2 * 2);
        this.data[i3] = f;
        this.data[i3 + 1] = f2;
    }

    @Override // org.ejml.data.CMatrix
    public float getReal(int i, int i2) {
        return this.data[((i * this.numCols) + i2) * 2];
    }

    @Override // org.ejml.data.CMatrix
    public void setReal(int i, int i2, float f) {
        this.data[((i * this.numCols) + i2) * 2] = f;
    }

    @Override // org.ejml.data.CMatrix
    public float getImag(int i, int i2) {
        return this.data[(((i * this.numCols) + i2) * 2) + 1];
    }

    @Override // org.ejml.data.CMatrix
    public void setImag(int i, int i2, float f) {
        this.data[(((i * this.numCols) + i2) * 2) + 1] = f;
    }

    @Override // org.ejml.data.CMatrix
    public int getDataLength() {
        return this.numRows * this.numCols * 2;
    }

    public void set(CMatrixRMaj cMatrixRMaj) {
        reshape(cMatrixRMaj.numRows, cMatrixRMaj.numCols);
        int i = this.numCols * 2;
        for (int i2 = 0; i2 < this.numRows; i2++) {
            int i3 = this.numCols * i2 * 2;
            System.arraycopy(cMatrixRMaj.data, i3, this.data, i3, i);
        }
    }

    @Override // org.ejml.data.Matrix
    public CMatrixRMaj copy() {
        return new CMatrixRMaj(this);
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        reshape(matrix.getNumRows(), matrix.getNumCols());
        CMatrix cMatrix = (CMatrix) matrix;
        Complex_F32 complex_F32 = new Complex_F32();
        for (int i = 0; i < this.numRows; i++) {
            for (int i2 = 0; i2 < this.numCols; i2++) {
                cMatrix.get(i, i2, complex_F32);
                set(i, i2, complex_F32.real, complex_F32.imaginary);
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

    public void set(int i, int i2, boolean z, float... fArr) {
        reshape(i, i2);
        int i3 = i * i2 * 2;
        if (i3 > fArr.length) {
            throw new RuntimeException("Passed in array not long enough");
        }
        if (z) {
            System.arraycopy(fArr, 0, this.data, 0, i3);
            return;
        }
        int i4 = i * 2;
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            for (int i7 = 0; i7 < i2; i7++) {
                int i8 = i5 + 1;
                int i9 = (i7 * i4) + (i6 * 2);
                this.data[i5] = fArr[i9];
                i5 += 2;
                this.data[i8] = fArr[i9 + 1];
            }
        }
    }

    public void zero() {
        Arrays.fill(this.data, 0, this.numCols * this.numRows * 2, 0.0f);
    }

    @Override // org.ejml.data.Matrix
    public <T extends Matrix> T createLike() {
        return new CMatrixRMaj(this.numRows, this.numCols);
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.CDRM;
    }
}
