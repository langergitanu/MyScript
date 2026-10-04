package org.ejml.data;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.ejml.ops.MatrixIO;

/* JADX INFO: loaded from: classes9.dex */
public class FMatrixRMaj extends FMatrix1Row {
    public FMatrixRMaj(int i, int i2, boolean z, float... fArr) {
        this.data = new float[i * i2];
        this.numRows = i;
        this.numCols = i2;
        set(i, i2, z, fArr);
    }

    public FMatrixRMaj(float[][] fArr) {
        this.numRows = fArr.length;
        this.numCols = fArr[0].length;
        this.data = new float[this.numRows * this.numCols];
        int i = 0;
        for (int i2 = 0; i2 < this.numRows; i2++) {
            float[] fArr2 = fArr[i2];
            if (fArr2.length != this.numCols) {
                throw new IllegalArgumentException("All rows must have the same length");
            }
            System.arraycopy(fArr2, 0, this.data, i, this.numCols);
            i += this.numCols;
        }
    }

    public FMatrixRMaj(int i, int i2) {
        this.data = new float[i * i2];
        this.numRows = i;
        this.numCols = i2;
    }

    public FMatrixRMaj(FMatrixRMaj fMatrixRMaj) {
        this(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        System.arraycopy(fMatrixRMaj.data, 0, this.data, 0, fMatrixRMaj.getNumElements());
    }

    public FMatrixRMaj(int i) {
        this.data = new float[i];
    }

    public FMatrixRMaj() {
    }

    public FMatrixRMaj(FMatrix fMatrix) {
        this(fMatrix.getNumRows(), fMatrix.getNumCols());
        for (int i = 0; i < this.numRows; i++) {
            for (int i2 = 0; i2 < this.numCols; i2++) {
                set(i, i2, fMatrix.get(i, i2));
            }
        }
    }

    public static FMatrixRMaj wrap(int i, int i2, float[] fArr) {
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj();
        fMatrixRMaj.data = fArr;
        fMatrixRMaj.numRows = i;
        fMatrixRMaj.numCols = i2;
        return fMatrixRMaj;
    }

    @Override // org.ejml.data.FMatrixD1
    public void reshape(int i, int i2, boolean z) {
        int i3 = i * i2;
        if (this.data.length < i3) {
            float[] fArr = new float[i3];
            if (z) {
                System.arraycopy(this.data, 0, fArr, 0, getNumElements());
            }
            this.data = fArr;
        }
        this.numRows = i;
        this.numCols = i2;
    }

    @Override // org.ejml.data.FMatrix
    public void set(int i, int i2, float f) {
        if (i2 < 0 || i2 >= this.numCols || i < 0 || i >= this.numRows) {
            throw new IllegalArgumentException("Specified element is out of bounds: (" + i + " , " + i2 + ")");
        }
        this.data[(i * this.numCols) + i2] = f;
    }

    @Override // org.ejml.data.FMatrix
    public void unsafe_set(int i, int i2, float f) {
        this.data[(i * this.numCols) + i2] = f;
    }

    public void add(int i, int i2, float f) {
        if (i2 < 0 || i2 >= this.numCols || i < 0 || i >= this.numRows) {
            throw new IllegalArgumentException("Specified element is out of bounds");
        }
        float[] fArr = this.data;
        int i3 = (i * this.numCols) + i2;
        fArr[i3] = fArr[i3] + f;
    }

    @Override // org.ejml.data.FMatrix
    public float get(int i, int i2) {
        if (i2 < 0 || i2 >= this.numCols || i < 0 || i >= this.numRows) {
            throw new IllegalArgumentException("Specified element is out of bounds: " + i + " " + i2);
        }
        return this.data[(i * this.numCols) + i2];
    }

    @Override // org.ejml.data.FMatrix
    public float unsafe_get(int i, int i2) {
        return this.data[(i * this.numCols) + i2];
    }

    @Override // org.ejml.data.FMatrixD1
    public int getIndex(int i, int i2) {
        return (i * this.numCols) + i2;
    }

    public boolean isInBounds(int i, int i2) {
        return i2 >= 0 && i2 < this.numCols && i >= 0 && i < this.numRows;
    }

    @Override // org.ejml.data.FMatrix
    public int getNumElements() {
        return this.numRows * this.numCols;
    }

    public void set(int i, int i2, boolean z, float... fArr) {
        reshape(i, i2);
        int i3 = i * i2;
        if (i3 > this.data.length) {
            throw new IllegalArgumentException("The length of this matrix's data array is too small.");
        }
        if (z) {
            System.arraycopy(fArr, 0, this.data, 0, i3);
            return;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = 0;
            while (i6 < i2) {
                this.data[i4] = fArr[(i6 * i) + i5];
                i6++;
                i4++;
            }
        }
    }

    public void zero() {
        Arrays.fill(this.data, 0, getNumElements(), 0.0f);
    }

    @Override // org.ejml.data.Matrix
    public FMatrixRMaj copy() {
        return new FMatrixRMaj(this);
    }

    @Override // org.ejml.data.Matrix
    public void set(Matrix matrix) {
        FMatrix fMatrix = (FMatrix) matrix;
        reshape(matrix.getNumRows(), matrix.getNumCols());
        if (matrix instanceof FMatrixRMaj) {
            System.arraycopy(((FMatrixRMaj) fMatrix).data, 0, this.data, 0, this.numRows * this.numCols);
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.numRows; i2++) {
            int i3 = 0;
            while (i3 < this.numCols) {
                this.data[i] = fMatrix.get(i2, i3);
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
        return new FMatrixRMaj(this.numRows, this.numCols);
    }

    @Override // org.ejml.data.Matrix
    public MatrixType getType() {
        return MatrixType.FDRM;
    }
}
