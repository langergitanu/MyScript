package org.ejml.ops;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import org.ejml.data.CMatrix;
import org.ejml.data.Complex_F32;
import org.ejml.data.Complex_F64;
import org.ejml.data.DMatrix;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.DMatrixSparseTriplet;
import org.ejml.data.FMatrix;
import org.ejml.data.FMatrixSparseTriplet;
import org.ejml.data.ReshapeMatrix;
import org.ejml.data.ZMatrix;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixIO {
    public static void saveBin(DMatrix dMatrix, String str) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(str));
        try {
            objectOutputStream.writeObject(dMatrix);
            objectOutputStream.flush();
            try {
                objectOutputStream.close();
            } finally {
            }
        } catch (Throwable th) {
            try {
                objectOutputStream.close();
                throw th;
            } finally {
            }
        }
    }

    public static <T extends DMatrix> T loadBin(String str) throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(str));
        try {
            T t = (T) objectInputStream.readObject();
            if (objectInputStream.available() != 0) {
                throw new RuntimeException("File not completely read?");
            }
            objectInputStream.close();
            return t;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveDenseCSV(DMatrix dMatrix, String str) throws IOException {
        PrintStream printStream = new PrintStream(str);
        printStream.println(dMatrix.getNumRows() + " " + dMatrix.getNumCols() + " real");
        for (int i = 0; i < dMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < dMatrix.getNumCols(); i2++) {
                printStream.print(dMatrix.get(i, i2) + " ");
            }
            printStream.println();
        }
        printStream.close();
    }

    public static void saveSparseCSV(DMatrixSparseTriplet dMatrixSparseTriplet, String str) throws IOException {
        PrintStream printStream = new PrintStream(str);
        printStream.println(dMatrixSparseTriplet.getNumRows() + " " + dMatrixSparseTriplet.getNumCols() + " " + dMatrixSparseTriplet.nz_length + " real");
        for (int i = 0; i < dMatrixSparseTriplet.nz_length; i++) {
            DMatrixSparseTriplet.Element element = dMatrixSparseTriplet.nz_data[i];
            printStream.println(element.row + " " + element.col + " " + element.value);
        }
        printStream.close();
    }

    public static void saveSparseCSV(FMatrixSparseTriplet fMatrixSparseTriplet, String str) throws IOException {
        PrintStream printStream = new PrintStream(str);
        printStream.println(fMatrixSparseTriplet.getNumRows() + " " + fMatrixSparseTriplet.getNumCols() + " " + fMatrixSparseTriplet.nz_length + " real");
        for (int i = 0; i < fMatrixSparseTriplet.nz_length; i++) {
            FMatrixSparseTriplet.Element element = fMatrixSparseTriplet.nz_data[i];
            printStream.println(element.row + " " + element.col + " " + element.value);
        }
        printStream.close();
    }

    public static <T extends DMatrix> T loadCSV(String str, boolean z) throws IOException {
        T t;
        FileInputStream fileInputStream = new FileInputStream(str);
        ReadMatrixCsv readMatrixCsv = new ReadMatrixCsv(fileInputStream);
        if (z) {
            t = (T) readMatrixCsv.read64();
        } else {
            t = (T) readMatrixCsv.read32();
        }
        fileInputStream.close();
        return t;
    }

    public static DMatrixRMaj loadCSV(String str, int i, int i2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        DMatrixRMaj ddrm = new ReadMatrixCsv(fileInputStream).readDDRM(i, i2);
        fileInputStream.close();
        return ddrm;
    }

    public static void print(PrintStream printStream, DMatrix dMatrix) {
        print(printStream, dMatrix, 6, 3);
    }

    public static void print(PrintStream printStream, DMatrix dMatrix, int i, int i2) {
        print(printStream, dMatrix, "%" + i + "." + i2 + "f");
    }

    public static void print(PrintStream printStream, DMatrix dMatrix, String str) {
        printStream.println("Type = " + (ReshapeMatrix.class.isAssignableFrom(dMatrix.getClass()) ? "dense64" : "dense64 fixed") + " real , numRows = " + dMatrix.getNumRows() + " , numCols = " + dMatrix.getNumCols());
        String str2 = str + " ";
        for (int i = 0; i < dMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < dMatrix.getNumCols(); i2++) {
                printStream.printf(str2, Double.valueOf(dMatrix.get(i, i2)));
            }
            printStream.println();
        }
    }

    public static void print(PrintStream printStream, FMatrix fMatrix) {
        print(printStream, fMatrix, 6, 3);
    }

    public static void print(PrintStream printStream, FMatrix fMatrix, int i, int i2) {
        print(printStream, fMatrix, "%" + i + "." + i2 + "f ");
    }

    public static void print(PrintStream printStream, FMatrix fMatrix, String str) {
        printStream.println("Type = " + fMatrix.getClass().getSimpleName() + " , numRows = " + fMatrix.getNumRows() + " , numCols = " + fMatrix.getNumCols());
        String str2 = str + " ";
        for (int i = 0; i < fMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < fMatrix.getNumCols(); i2++) {
                printStream.printf(str2, Float.valueOf(fMatrix.get(i, i2)));
            }
            printStream.println();
        }
    }

    public static void print(PrintStream printStream, DMatrix dMatrix, String str, int i, int i2, int i3, int i4) {
        printStream.println("Type = submatrix , rows " + i + " to " + i2 + "  columns " + i3 + " to " + i4);
        String str2 = str + " ";
        while (i < i2) {
            for (int i5 = i3; i5 < i4; i5++) {
                printStream.printf(str2, Double.valueOf(dMatrix.get(i, i5)));
            }
            printStream.println();
            i++;
        }
    }

    public static void print(PrintStream printStream, FMatrix fMatrix, String str, int i, int i2, int i3, int i4) {
        printStream.println("Type = submatrix , rows " + i + " to " + i2 + "  columns " + i3 + " to " + i4);
        String str2 = str + " ";
        while (i < i2) {
            for (int i5 = i3; i5 < i4; i5++) {
                printStream.printf(str2, Float.valueOf(fMatrix.get(i, i5)));
            }
            printStream.println();
            i++;
        }
    }

    public static void print(PrintStream printStream, ZMatrix zMatrix) {
        print(printStream, zMatrix, 6, 3);
    }

    public static void print(PrintStream printStream, CMatrix cMatrix) {
        print(printStream, cMatrix, 6, 3);
    }

    public static void print(PrintStream printStream, ZMatrix zMatrix, int i, int i2) {
        print(printStream, zMatrix, "%" + i + "." + i2 + "f + %" + i + "." + i2 + "fi");
    }

    public static void print(PrintStream printStream, CMatrix cMatrix, int i, int i2) {
        print(printStream, cMatrix, "%" + i + "." + i2 + "f + %" + i + "." + i2 + "fi");
    }

    public static void print(PrintStream printStream, ZMatrix zMatrix, String str) {
        printStream.println("Type = dense64 complex , numRows = " + zMatrix.getNumRows() + " , numCols = " + zMatrix.getNumCols());
        String str2 = str + " ";
        Complex_F64 complex_F64 = new Complex_F64();
        for (int i = 0; i < zMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < zMatrix.getNumCols(); i2++) {
                zMatrix.get(i, i2, complex_F64);
                printStream.printf(str2, Double.valueOf(complex_F64.real), Double.valueOf(complex_F64.imaginary));
                if (i2 < zMatrix.getNumCols() - 1) {
                    printStream.print(" , ");
                }
            }
            printStream.println();
        }
    }

    public static void print(PrintStream printStream, CMatrix cMatrix, String str) {
        printStream.println("Type = dense32 complex , numRows = " + cMatrix.getNumRows() + " , numCols = " + cMatrix.getNumCols());
        String str2 = str + " ";
        Complex_F32 complex_F32 = new Complex_F32();
        for (int i = 0; i < cMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < cMatrix.getNumCols(); i2++) {
                cMatrix.get(i, i2, complex_F32);
                printStream.printf(str2, Float.valueOf(complex_F32.real), Float.valueOf(complex_F32.imaginary));
                if (i2 < cMatrix.getNumCols() - 1) {
                    printStream.print(" , ");
                }
            }
            printStream.println();
        }
    }
}
