package org.ejml.ops;

import java.util.Arrays;
import org.ejml.data.FMatrix;
import org.ejml.data.FMatrix2;
import org.ejml.data.FMatrix2x2;
import org.ejml.data.FMatrix3;
import org.ejml.data.FMatrix3x3;
import org.ejml.data.FMatrix4;
import org.ejml.data.FMatrix4x4;
import org.ejml.data.FMatrix5;
import org.ejml.data.FMatrix5x5;
import org.ejml.data.FMatrix6;
import org.ejml.data.FMatrix6x6;
import org.ejml.data.FMatrixRBlock;
import org.ejml.data.FMatrixRMaj;
import org.ejml.data.FMatrixSparseCSC;
import org.ejml.data.FMatrixSparseTriplet;

/* JADX INFO: loaded from: classes9.dex */
public class ConvertFMatrixStruct {
    public static void convert(FMatrix fMatrix, FMatrix fMatrix2) {
        if (fMatrix.getNumRows() != fMatrix2.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (fMatrix.getNumCols() != fMatrix2.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        for (int i = 0; i < fMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < fMatrix.getNumCols(); i2++) {
                fMatrix2.unsafe_set(i, i2, fMatrix.unsafe_get(i, i2));
            }
        }
    }

    public static FMatrixRMaj convert(FMatrix2x2 fMatrix2x2, FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(2, 2);
        }
        if (fMatrix2x2.getNumRows() != fMatrixRMaj.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (fMatrix2x2.getNumCols() != fMatrixRMaj.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        fMatrixRMaj.data[0] = fMatrix2x2.a11;
        fMatrixRMaj.data[1] = fMatrix2x2.a12;
        fMatrixRMaj.data[2] = fMatrix2x2.a21;
        fMatrixRMaj.data[3] = fMatrix2x2.a22;
        return fMatrixRMaj;
    }

    public static FMatrixRMaj convert(FMatrix3x3 fMatrix3x3, FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(3, 3);
        }
        if (fMatrix3x3.getNumRows() != fMatrixRMaj.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (fMatrix3x3.getNumCols() != fMatrixRMaj.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        fMatrixRMaj.data[0] = fMatrix3x3.a11;
        fMatrixRMaj.data[1] = fMatrix3x3.a12;
        fMatrixRMaj.data[2] = fMatrix3x3.a13;
        fMatrixRMaj.data[3] = fMatrix3x3.a21;
        fMatrixRMaj.data[4] = fMatrix3x3.a22;
        fMatrixRMaj.data[5] = fMatrix3x3.a23;
        fMatrixRMaj.data[6] = fMatrix3x3.a31;
        fMatrixRMaj.data[7] = fMatrix3x3.a32;
        fMatrixRMaj.data[8] = fMatrix3x3.a33;
        return fMatrixRMaj;
    }

    public static FMatrixRMaj convert(FMatrix4x4 fMatrix4x4, FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(4, 4);
        }
        if (fMatrix4x4.getNumRows() != fMatrixRMaj.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (fMatrix4x4.getNumCols() != fMatrixRMaj.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        fMatrixRMaj.data[0] = fMatrix4x4.a11;
        fMatrixRMaj.data[1] = fMatrix4x4.a12;
        fMatrixRMaj.data[2] = fMatrix4x4.a13;
        fMatrixRMaj.data[3] = fMatrix4x4.a14;
        fMatrixRMaj.data[4] = fMatrix4x4.a21;
        fMatrixRMaj.data[5] = fMatrix4x4.a22;
        fMatrixRMaj.data[6] = fMatrix4x4.a23;
        fMatrixRMaj.data[7] = fMatrix4x4.a24;
        fMatrixRMaj.data[8] = fMatrix4x4.a31;
        fMatrixRMaj.data[9] = fMatrix4x4.a32;
        fMatrixRMaj.data[10] = fMatrix4x4.a33;
        fMatrixRMaj.data[11] = fMatrix4x4.a34;
        fMatrixRMaj.data[12] = fMatrix4x4.a41;
        fMatrixRMaj.data[13] = fMatrix4x4.a42;
        fMatrixRMaj.data[14] = fMatrix4x4.a43;
        fMatrixRMaj.data[15] = fMatrix4x4.a44;
        return fMatrixRMaj;
    }

    public static FMatrixRMaj convert(FMatrix5x5 fMatrix5x5, FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(5, 5);
        }
        if (fMatrix5x5.getNumRows() != fMatrixRMaj.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (fMatrix5x5.getNumCols() != fMatrixRMaj.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        fMatrixRMaj.data[0] = fMatrix5x5.a11;
        fMatrixRMaj.data[1] = fMatrix5x5.a12;
        fMatrixRMaj.data[2] = fMatrix5x5.a13;
        fMatrixRMaj.data[3] = fMatrix5x5.a14;
        fMatrixRMaj.data[4] = fMatrix5x5.a15;
        fMatrixRMaj.data[5] = fMatrix5x5.a21;
        fMatrixRMaj.data[6] = fMatrix5x5.a22;
        fMatrixRMaj.data[7] = fMatrix5x5.a23;
        fMatrixRMaj.data[8] = fMatrix5x5.a24;
        fMatrixRMaj.data[9] = fMatrix5x5.a25;
        fMatrixRMaj.data[10] = fMatrix5x5.a31;
        fMatrixRMaj.data[11] = fMatrix5x5.a32;
        fMatrixRMaj.data[12] = fMatrix5x5.a33;
        fMatrixRMaj.data[13] = fMatrix5x5.a34;
        fMatrixRMaj.data[14] = fMatrix5x5.a35;
        fMatrixRMaj.data[15] = fMatrix5x5.a41;
        fMatrixRMaj.data[16] = fMatrix5x5.a42;
        fMatrixRMaj.data[17] = fMatrix5x5.a43;
        fMatrixRMaj.data[18] = fMatrix5x5.a44;
        fMatrixRMaj.data[19] = fMatrix5x5.a45;
        fMatrixRMaj.data[20] = fMatrix5x5.a51;
        fMatrixRMaj.data[21] = fMatrix5x5.a52;
        fMatrixRMaj.data[22] = fMatrix5x5.a53;
        fMatrixRMaj.data[23] = fMatrix5x5.a54;
        fMatrixRMaj.data[24] = fMatrix5x5.a55;
        return fMatrixRMaj;
    }

    public static FMatrixRMaj convert(FMatrix6x6 fMatrix6x6, FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(6, 6);
        }
        if (fMatrix6x6.getNumRows() != fMatrixRMaj.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (fMatrix6x6.getNumCols() != fMatrixRMaj.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        fMatrixRMaj.data[0] = fMatrix6x6.a11;
        fMatrixRMaj.data[1] = fMatrix6x6.a12;
        fMatrixRMaj.data[2] = fMatrix6x6.a13;
        fMatrixRMaj.data[3] = fMatrix6x6.a14;
        fMatrixRMaj.data[4] = fMatrix6x6.a15;
        fMatrixRMaj.data[5] = fMatrix6x6.a16;
        fMatrixRMaj.data[6] = fMatrix6x6.a21;
        fMatrixRMaj.data[7] = fMatrix6x6.a22;
        fMatrixRMaj.data[8] = fMatrix6x6.a23;
        fMatrixRMaj.data[9] = fMatrix6x6.a24;
        fMatrixRMaj.data[10] = fMatrix6x6.a25;
        fMatrixRMaj.data[11] = fMatrix6x6.a26;
        fMatrixRMaj.data[12] = fMatrix6x6.a31;
        fMatrixRMaj.data[13] = fMatrix6x6.a32;
        fMatrixRMaj.data[14] = fMatrix6x6.a33;
        fMatrixRMaj.data[15] = fMatrix6x6.a34;
        fMatrixRMaj.data[16] = fMatrix6x6.a35;
        fMatrixRMaj.data[17] = fMatrix6x6.a36;
        fMatrixRMaj.data[18] = fMatrix6x6.a41;
        fMatrixRMaj.data[19] = fMatrix6x6.a42;
        fMatrixRMaj.data[20] = fMatrix6x6.a43;
        fMatrixRMaj.data[21] = fMatrix6x6.a44;
        fMatrixRMaj.data[22] = fMatrix6x6.a45;
        fMatrixRMaj.data[23] = fMatrix6x6.a46;
        fMatrixRMaj.data[24] = fMatrix6x6.a51;
        fMatrixRMaj.data[25] = fMatrix6x6.a52;
        fMatrixRMaj.data[26] = fMatrix6x6.a53;
        fMatrixRMaj.data[27] = fMatrix6x6.a54;
        fMatrixRMaj.data[28] = fMatrix6x6.a55;
        fMatrixRMaj.data[29] = fMatrix6x6.a56;
        fMatrixRMaj.data[30] = fMatrix6x6.a61;
        fMatrixRMaj.data[31] = fMatrix6x6.a62;
        fMatrixRMaj.data[32] = fMatrix6x6.a63;
        fMatrixRMaj.data[33] = fMatrix6x6.a64;
        fMatrixRMaj.data[34] = fMatrix6x6.a65;
        fMatrixRMaj.data[35] = fMatrix6x6.a66;
        return fMatrixRMaj;
    }

    public static FMatrix2x2 convert(FMatrixRMaj fMatrixRMaj, FMatrix2x2 fMatrix2x2) {
        if (fMatrix2x2 == null) {
            fMatrix2x2 = new FMatrix2x2();
        }
        if (fMatrixRMaj.getNumRows() != fMatrix2x2.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (fMatrixRMaj.getNumCols() != fMatrix2x2.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        fMatrix2x2.a11 = fMatrixRMaj.data[0];
        fMatrix2x2.a12 = fMatrixRMaj.data[1];
        fMatrix2x2.a21 = fMatrixRMaj.data[2];
        fMatrix2x2.a22 = fMatrixRMaj.data[3];
        return fMatrix2x2;
    }

    public static FMatrix3x3 convert(FMatrixRMaj fMatrixRMaj, FMatrix3x3 fMatrix3x3) {
        if (fMatrix3x3 == null) {
            fMatrix3x3 = new FMatrix3x3();
        }
        if (fMatrixRMaj.getNumRows() != fMatrix3x3.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (fMatrixRMaj.getNumCols() != fMatrix3x3.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        fMatrix3x3.a11 = fMatrixRMaj.data[0];
        fMatrix3x3.a12 = fMatrixRMaj.data[1];
        fMatrix3x3.a13 = fMatrixRMaj.data[2];
        fMatrix3x3.a21 = fMatrixRMaj.data[3];
        fMatrix3x3.a22 = fMatrixRMaj.data[4];
        fMatrix3x3.a23 = fMatrixRMaj.data[5];
        fMatrix3x3.a31 = fMatrixRMaj.data[6];
        fMatrix3x3.a32 = fMatrixRMaj.data[7];
        fMatrix3x3.a33 = fMatrixRMaj.data[8];
        return fMatrix3x3;
    }

    public static FMatrix4x4 convert(FMatrixRMaj fMatrixRMaj, FMatrix4x4 fMatrix4x4) {
        if (fMatrix4x4 == null) {
            fMatrix4x4 = new FMatrix4x4();
        }
        if (fMatrixRMaj.getNumRows() != fMatrix4x4.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (fMatrixRMaj.getNumCols() != fMatrix4x4.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        fMatrix4x4.a11 = fMatrixRMaj.data[0];
        fMatrix4x4.a12 = fMatrixRMaj.data[1];
        fMatrix4x4.a13 = fMatrixRMaj.data[2];
        fMatrix4x4.a14 = fMatrixRMaj.data[3];
        fMatrix4x4.a21 = fMatrixRMaj.data[4];
        fMatrix4x4.a22 = fMatrixRMaj.data[5];
        fMatrix4x4.a23 = fMatrixRMaj.data[6];
        fMatrix4x4.a24 = fMatrixRMaj.data[7];
        fMatrix4x4.a31 = fMatrixRMaj.data[8];
        fMatrix4x4.a32 = fMatrixRMaj.data[9];
        fMatrix4x4.a33 = fMatrixRMaj.data[10];
        fMatrix4x4.a34 = fMatrixRMaj.data[11];
        fMatrix4x4.a41 = fMatrixRMaj.data[12];
        fMatrix4x4.a42 = fMatrixRMaj.data[13];
        fMatrix4x4.a43 = fMatrixRMaj.data[14];
        fMatrix4x4.a44 = fMatrixRMaj.data[15];
        return fMatrix4x4;
    }

    public static FMatrix5x5 convert(FMatrixRMaj fMatrixRMaj, FMatrix5x5 fMatrix5x5) {
        if (fMatrix5x5 == null) {
            fMatrix5x5 = new FMatrix5x5();
        }
        if (fMatrixRMaj.getNumRows() != fMatrix5x5.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (fMatrixRMaj.getNumCols() != fMatrix5x5.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        fMatrix5x5.a11 = fMatrixRMaj.data[0];
        fMatrix5x5.a12 = fMatrixRMaj.data[1];
        fMatrix5x5.a13 = fMatrixRMaj.data[2];
        fMatrix5x5.a14 = fMatrixRMaj.data[3];
        fMatrix5x5.a15 = fMatrixRMaj.data[4];
        fMatrix5x5.a21 = fMatrixRMaj.data[5];
        fMatrix5x5.a22 = fMatrixRMaj.data[6];
        fMatrix5x5.a23 = fMatrixRMaj.data[7];
        fMatrix5x5.a24 = fMatrixRMaj.data[8];
        fMatrix5x5.a25 = fMatrixRMaj.data[9];
        fMatrix5x5.a31 = fMatrixRMaj.data[10];
        fMatrix5x5.a32 = fMatrixRMaj.data[11];
        fMatrix5x5.a33 = fMatrixRMaj.data[12];
        fMatrix5x5.a34 = fMatrixRMaj.data[13];
        fMatrix5x5.a35 = fMatrixRMaj.data[14];
        fMatrix5x5.a41 = fMatrixRMaj.data[15];
        fMatrix5x5.a42 = fMatrixRMaj.data[16];
        fMatrix5x5.a43 = fMatrixRMaj.data[17];
        fMatrix5x5.a44 = fMatrixRMaj.data[18];
        fMatrix5x5.a45 = fMatrixRMaj.data[19];
        fMatrix5x5.a51 = fMatrixRMaj.data[20];
        fMatrix5x5.a52 = fMatrixRMaj.data[21];
        fMatrix5x5.a53 = fMatrixRMaj.data[22];
        fMatrix5x5.a54 = fMatrixRMaj.data[23];
        fMatrix5x5.a55 = fMatrixRMaj.data[24];
        return fMatrix5x5;
    }

    public static FMatrix6x6 convert(FMatrixRMaj fMatrixRMaj, FMatrix6x6 fMatrix6x6) {
        if (fMatrix6x6 == null) {
            fMatrix6x6 = new FMatrix6x6();
        }
        if (fMatrixRMaj.getNumRows() != fMatrix6x6.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (fMatrixRMaj.getNumCols() != fMatrix6x6.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        fMatrix6x6.a11 = fMatrixRMaj.data[0];
        fMatrix6x6.a12 = fMatrixRMaj.data[1];
        fMatrix6x6.a13 = fMatrixRMaj.data[2];
        fMatrix6x6.a14 = fMatrixRMaj.data[3];
        fMatrix6x6.a15 = fMatrixRMaj.data[4];
        fMatrix6x6.a16 = fMatrixRMaj.data[5];
        fMatrix6x6.a21 = fMatrixRMaj.data[6];
        fMatrix6x6.a22 = fMatrixRMaj.data[7];
        fMatrix6x6.a23 = fMatrixRMaj.data[8];
        fMatrix6x6.a24 = fMatrixRMaj.data[9];
        fMatrix6x6.a25 = fMatrixRMaj.data[10];
        fMatrix6x6.a26 = fMatrixRMaj.data[11];
        fMatrix6x6.a31 = fMatrixRMaj.data[12];
        fMatrix6x6.a32 = fMatrixRMaj.data[13];
        fMatrix6x6.a33 = fMatrixRMaj.data[14];
        fMatrix6x6.a34 = fMatrixRMaj.data[15];
        fMatrix6x6.a35 = fMatrixRMaj.data[16];
        fMatrix6x6.a36 = fMatrixRMaj.data[17];
        fMatrix6x6.a41 = fMatrixRMaj.data[18];
        fMatrix6x6.a42 = fMatrixRMaj.data[19];
        fMatrix6x6.a43 = fMatrixRMaj.data[20];
        fMatrix6x6.a44 = fMatrixRMaj.data[21];
        fMatrix6x6.a45 = fMatrixRMaj.data[22];
        fMatrix6x6.a46 = fMatrixRMaj.data[23];
        fMatrix6x6.a51 = fMatrixRMaj.data[24];
        fMatrix6x6.a52 = fMatrixRMaj.data[25];
        fMatrix6x6.a53 = fMatrixRMaj.data[26];
        fMatrix6x6.a54 = fMatrixRMaj.data[27];
        fMatrix6x6.a55 = fMatrixRMaj.data[28];
        fMatrix6x6.a56 = fMatrixRMaj.data[29];
        fMatrix6x6.a61 = fMatrixRMaj.data[30];
        fMatrix6x6.a62 = fMatrixRMaj.data[31];
        fMatrix6x6.a63 = fMatrixRMaj.data[32];
        fMatrix6x6.a64 = fMatrixRMaj.data[33];
        fMatrix6x6.a65 = fMatrixRMaj.data[34];
        fMatrix6x6.a66 = fMatrixRMaj.data[35];
        return fMatrix6x6;
    }

    public static FMatrixRMaj convert(FMatrix2 fMatrix2, FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(2, 1);
        }
        if (fMatrixRMaj.getNumRows() != 1 && fMatrixRMaj.getNumCols() != 1) {
            throw new IllegalArgumentException("One row or column must have a length of 1 for it to be a vector");
        }
        int iMax = Math.max(fMatrixRMaj.getNumRows(), fMatrixRMaj.getNumCols());
        if (iMax != 2) {
            throw new IllegalArgumentException("Length of input vector is not 2.  It is " + iMax);
        }
        fMatrixRMaj.data[0] = fMatrix2.f2418a1;
        fMatrixRMaj.data[1] = fMatrix2.f2419a2;
        return fMatrixRMaj;
    }

    public static FMatrixRMaj convert(FMatrix3 fMatrix3, FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(3, 1);
        }
        if (fMatrixRMaj.getNumRows() != 1 && fMatrixRMaj.getNumCols() != 1) {
            throw new IllegalArgumentException("One row or column must have a length of 1 for it to be a vector");
        }
        int iMax = Math.max(fMatrixRMaj.getNumRows(), fMatrixRMaj.getNumCols());
        if (iMax != 3) {
            throw new IllegalArgumentException("Length of input vector is not 3.  It is " + iMax);
        }
        fMatrixRMaj.data[0] = fMatrix3.f2420a1;
        fMatrixRMaj.data[1] = fMatrix3.f2421a2;
        fMatrixRMaj.data[2] = fMatrix3.f2422a3;
        return fMatrixRMaj;
    }

    public static FMatrixRMaj convert(FMatrix4 fMatrix4, FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(4, 1);
        }
        if (fMatrixRMaj.getNumRows() != 1 && fMatrixRMaj.getNumCols() != 1) {
            throw new IllegalArgumentException("One row or column must have a length of 1 for it to be a vector");
        }
        int iMax = Math.max(fMatrixRMaj.getNumRows(), fMatrixRMaj.getNumCols());
        if (iMax != 4) {
            throw new IllegalArgumentException("Length of input vector is not 4.  It is " + iMax);
        }
        fMatrixRMaj.data[0] = fMatrix4.f2423a1;
        fMatrixRMaj.data[1] = fMatrix4.f2424a2;
        fMatrixRMaj.data[2] = fMatrix4.f2425a3;
        fMatrixRMaj.data[3] = fMatrix4.f2426a4;
        return fMatrixRMaj;
    }

    public static FMatrixRMaj convert(FMatrix5 fMatrix5, FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(5, 1);
        }
        if (fMatrixRMaj.getNumRows() != 1 && fMatrixRMaj.getNumCols() != 1) {
            throw new IllegalArgumentException("One row or column must have a length of 1 for it to be a vector");
        }
        int iMax = Math.max(fMatrixRMaj.getNumRows(), fMatrixRMaj.getNumCols());
        if (iMax != 5) {
            throw new IllegalArgumentException("Length of input vector is not 5.  It is " + iMax);
        }
        fMatrixRMaj.data[0] = fMatrix5.f2427a1;
        fMatrixRMaj.data[1] = fMatrix5.f2428a2;
        fMatrixRMaj.data[2] = fMatrix5.f2429a3;
        fMatrixRMaj.data[3] = fMatrix5.f2430a4;
        fMatrixRMaj.data[4] = fMatrix5.f2431a5;
        return fMatrixRMaj;
    }

    public static FMatrixRMaj convert(FMatrix6 fMatrix6, FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(6, 1);
        }
        if (fMatrixRMaj.getNumRows() != 1 && fMatrixRMaj.getNumCols() != 1) {
            throw new IllegalArgumentException("One row or column must have a length of 1 for it to be a vector");
        }
        int iMax = Math.max(fMatrixRMaj.getNumRows(), fMatrixRMaj.getNumCols());
        if (iMax != 6) {
            throw new IllegalArgumentException("Length of input vector is not 6.  It is " + iMax);
        }
        fMatrixRMaj.data[0] = fMatrix6.f2432a1;
        fMatrixRMaj.data[1] = fMatrix6.f2433a2;
        fMatrixRMaj.data[2] = fMatrix6.f2434a3;
        fMatrixRMaj.data[3] = fMatrix6.f2435a4;
        fMatrixRMaj.data[4] = fMatrix6.f2436a5;
        fMatrixRMaj.data[5] = fMatrix6.f2437a6;
        return fMatrixRMaj;
    }

    public static FMatrix2 convert(FMatrixRMaj fMatrixRMaj, FMatrix2 fMatrix2) {
        if (fMatrix2 == null) {
            fMatrix2 = new FMatrix2();
        }
        if (fMatrixRMaj.getNumRows() != 1 && fMatrixRMaj.getNumCols() != 1) {
            throw new IllegalArgumentException("One row or column must have a length of 1 for it to be a vector");
        }
        int iMax = Math.max(fMatrixRMaj.getNumRows(), fMatrixRMaj.getNumCols());
        if (iMax != 2) {
            throw new IllegalArgumentException("Length of input vector is not 2.  It is " + iMax);
        }
        fMatrix2.f2418a1 = fMatrixRMaj.data[0];
        fMatrix2.f2419a2 = fMatrixRMaj.data[1];
        return fMatrix2;
    }

    public static FMatrix3 convert(FMatrixRMaj fMatrixRMaj, FMatrix3 fMatrix3) {
        if (fMatrix3 == null) {
            fMatrix3 = new FMatrix3();
        }
        if (fMatrixRMaj.getNumRows() != 1 && fMatrixRMaj.getNumCols() != 1) {
            throw new IllegalArgumentException("One row or column must have a length of 1 for it to be a vector");
        }
        int iMax = Math.max(fMatrixRMaj.getNumRows(), fMatrixRMaj.getNumCols());
        if (iMax != 3) {
            throw new IllegalArgumentException("Length of input vector is not 3.  It is " + iMax);
        }
        fMatrix3.f2420a1 = fMatrixRMaj.data[0];
        fMatrix3.f2421a2 = fMatrixRMaj.data[1];
        fMatrix3.f2422a3 = fMatrixRMaj.data[2];
        return fMatrix3;
    }

    public static FMatrix4 convert(FMatrixRMaj fMatrixRMaj, FMatrix4 fMatrix4) {
        if (fMatrix4 == null) {
            fMatrix4 = new FMatrix4();
        }
        if (fMatrixRMaj.getNumRows() != 1 && fMatrixRMaj.getNumCols() != 1) {
            throw new IllegalArgumentException("One row or column must have a length of 1 for it to be a vector");
        }
        int iMax = Math.max(fMatrixRMaj.getNumRows(), fMatrixRMaj.getNumCols());
        if (iMax != 4) {
            throw new IllegalArgumentException("Length of input vector is not 4.  It is " + iMax);
        }
        fMatrix4.f2423a1 = fMatrixRMaj.data[0];
        fMatrix4.f2424a2 = fMatrixRMaj.data[1];
        fMatrix4.f2425a3 = fMatrixRMaj.data[2];
        fMatrix4.f2426a4 = fMatrixRMaj.data[3];
        return fMatrix4;
    }

    public static FMatrix5 convert(FMatrixRMaj fMatrixRMaj, FMatrix5 fMatrix5) {
        if (fMatrix5 == null) {
            fMatrix5 = new FMatrix5();
        }
        if (fMatrixRMaj.getNumRows() != 1 && fMatrixRMaj.getNumCols() != 1) {
            throw new IllegalArgumentException("One row or column must have a length of 1 for it to be a vector");
        }
        int iMax = Math.max(fMatrixRMaj.getNumRows(), fMatrixRMaj.getNumCols());
        if (iMax != 5) {
            throw new IllegalArgumentException("Length of input vector is not 5.  It is " + iMax);
        }
        fMatrix5.f2427a1 = fMatrixRMaj.data[0];
        fMatrix5.f2428a2 = fMatrixRMaj.data[1];
        fMatrix5.f2429a3 = fMatrixRMaj.data[2];
        fMatrix5.f2430a4 = fMatrixRMaj.data[3];
        fMatrix5.f2431a5 = fMatrixRMaj.data[4];
        return fMatrix5;
    }

    public static FMatrix6 convert(FMatrixRMaj fMatrixRMaj, FMatrix6 fMatrix6) {
        if (fMatrix6 == null) {
            fMatrix6 = new FMatrix6();
        }
        if (fMatrixRMaj.getNumRows() != 1 && fMatrixRMaj.getNumCols() != 1) {
            throw new IllegalArgumentException("One row or column must have a length of 1 for it to be a vector");
        }
        int iMax = Math.max(fMatrixRMaj.getNumRows(), fMatrixRMaj.getNumCols());
        if (iMax != 6) {
            throw new IllegalArgumentException("Length of input vector is not 6.  It is " + iMax);
        }
        fMatrix6.f2432a1 = fMatrixRMaj.data[0];
        fMatrix6.f2433a2 = fMatrixRMaj.data[1];
        fMatrix6.f2434a3 = fMatrixRMaj.data[2];
        fMatrix6.f2435a4 = fMatrixRMaj.data[3];
        fMatrix6.f2436a5 = fMatrixRMaj.data[4];
        fMatrix6.f2437a6 = fMatrixRMaj.data[5];
        return fMatrix6;
    }

    public static void convert(FMatrixRMaj fMatrixRMaj, FMatrixRBlock fMatrixRBlock) {
        if (fMatrixRMaj.numRows != fMatrixRBlock.numRows || fMatrixRMaj.numCols != fMatrixRBlock.numCols) {
            throw new IllegalArgumentException("Must be the same size.");
        }
        int i = 0;
        while (i < fMatrixRBlock.numRows) {
            int iMin = Math.min(fMatrixRBlock.blockLength, fMatrixRBlock.numRows - i);
            int i2 = 0;
            while (i2 < fMatrixRBlock.numCols) {
                int iMin2 = Math.min(fMatrixRBlock.blockLength, fMatrixRBlock.numCols - i2);
                int i3 = (fMatrixRBlock.numCols * i) + (iMin * i2);
                int i4 = (fMatrixRBlock.numCols * i) + i2;
                for (int i5 = 0; i5 < iMin; i5++) {
                    System.arraycopy(fMatrixRMaj.data, i4, fMatrixRBlock.data, i3, iMin2);
                    i3 += iMin2;
                    i4 += fMatrixRBlock.numCols;
                }
                i2 += fMatrixRBlock.blockLength;
            }
            i += fMatrixRBlock.blockLength;
        }
    }

    public static FMatrixRMaj convert(FMatrixRBlock fMatrixRBlock, FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj != null) {
            if (fMatrixRMaj.numRows != fMatrixRBlock.numRows || fMatrixRMaj.numCols != fMatrixRBlock.numCols) {
                throw new IllegalArgumentException("Must be the same size.");
            }
        } else {
            fMatrixRMaj = new FMatrixRMaj(fMatrixRBlock.numRows, fMatrixRBlock.numCols);
        }
        int i = 0;
        while (i < fMatrixRBlock.numRows) {
            int iMin = Math.min(fMatrixRBlock.blockLength, fMatrixRBlock.numRows - i);
            int i2 = 0;
            while (i2 < fMatrixRBlock.numCols) {
                int iMin2 = Math.min(fMatrixRBlock.blockLength, fMatrixRBlock.numCols - i2);
                int i3 = (fMatrixRBlock.numCols * i) + (iMin * i2);
                int i4 = (fMatrixRMaj.numCols * i) + i2;
                for (int i5 = 0; i5 < iMin; i5++) {
                    System.arraycopy(fMatrixRBlock.data, i3, fMatrixRMaj.data, i4, iMin2);
                    i3 += iMin2;
                    i4 += fMatrixRMaj.numCols;
                }
                i2 += fMatrixRBlock.blockLength;
            }
            i += fMatrixRBlock.blockLength;
        }
        return fMatrixRMaj;
    }

    public static FMatrixSparseTriplet convert(FMatrix fMatrix, FMatrixSparseTriplet fMatrixSparseTriplet, float f) {
        if (fMatrixSparseTriplet == null) {
            fMatrixSparseTriplet = new FMatrixSparseTriplet(fMatrix.getNumRows(), fMatrix.getNumCols(), 1);
        } else {
            fMatrixSparseTriplet.reshape(fMatrix.getNumRows(), fMatrix.getNumCols());
        }
        for (int i = 0; i < fMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < fMatrix.getNumCols(); i2++) {
                float fUnsafe_get = fMatrix.unsafe_get(i, i2);
                if (Math.abs(fUnsafe_get) > f) {
                    fMatrixSparseTriplet.addItem(i, i2, fUnsafe_get);
                }
            }
        }
        return fMatrixSparseTriplet;
    }

    public static FMatrixSparseTriplet convert(FMatrixRMaj fMatrixRMaj, FMatrixSparseTriplet fMatrixSparseTriplet, float f) {
        if (fMatrixSparseTriplet == null) {
            fMatrixSparseTriplet = new FMatrixSparseTriplet(fMatrixRMaj.numRows, fMatrixRMaj.numCols, fMatrixRMaj.numRows * fMatrixRMaj.numCols);
        } else {
            fMatrixSparseTriplet.reshape(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        }
        int i = 0;
        for (int i2 = 0; i2 < fMatrixRMaj.numRows; i2++) {
            int i3 = 0;
            while (i3 < fMatrixRMaj.numCols) {
                int i4 = i + 1;
                float f2 = fMatrixRMaj.data[i];
                if (Math.abs(f2) > f) {
                    fMatrixSparseTriplet.addItem(i2, i3, f2);
                }
                i3++;
                i = i4;
            }
        }
        return fMatrixSparseTriplet;
    }

    public static FMatrixRMaj convert(FMatrixSparseTriplet fMatrixSparseTriplet, FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(fMatrixSparseTriplet.numRows, fMatrixSparseTriplet.numCols);
        } else {
            fMatrixRMaj.reshape(fMatrixSparseTriplet.numRows, fMatrixSparseTriplet.numCols);
            fMatrixRMaj.zero();
        }
        for (int i = 0; i < fMatrixSparseTriplet.nz_length; i++) {
            FMatrixSparseTriplet.Element element = fMatrixSparseTriplet.nz_data[i];
            fMatrixRMaj.unsafe_set(element.row, element.col, element.value);
        }
        return fMatrixRMaj;
    }

    public static FMatrixRMaj convert(FMatrixSparseCSC fMatrixSparseCSC, FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(fMatrixSparseCSC.numRows, fMatrixSparseCSC.numCols);
        } else {
            fMatrixRMaj.reshape(fMatrixSparseCSC.numRows, fMatrixSparseCSC.numCols);
            fMatrixRMaj.zero();
        }
        int i = fMatrixSparseCSC.col_idx[0];
        int i2 = 1;
        while (i2 <= fMatrixSparseCSC.numCols) {
            int i3 = fMatrixSparseCSC.col_idx[i2];
            while (i < i3) {
                fMatrixRMaj.unsafe_set(fMatrixSparseCSC.nz_rows[i], i2 - 1, fMatrixSparseCSC.nz_values[i]);
                i++;
            }
            i2++;
            i = i3;
        }
        return fMatrixRMaj;
    }

    public static FMatrixSparseCSC convert(FMatrixRMaj fMatrixRMaj, FMatrixSparseCSC fMatrixSparseCSC, float f) {
        int i = fMatrixRMaj.numRows * fMatrixRMaj.numCols;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (fMatrixRMaj.data[i3] != 0.0f) {
                i2++;
            }
        }
        if (fMatrixSparseCSC == null) {
            fMatrixSparseCSC = new FMatrixSparseCSC(fMatrixRMaj.numRows, fMatrixRMaj.numCols, i2);
        } else {
            fMatrixSparseCSC.reshape(fMatrixRMaj.numRows, fMatrixRMaj.numCols, i2);
        }
        fMatrixSparseCSC.nz_length = 0;
        fMatrixSparseCSC.col_idx[0] = 0;
        int i4 = 0;
        while (i4 < fMatrixRMaj.numCols) {
            for (int i5 = 0; i5 < fMatrixRMaj.numRows; i5++) {
                float f2 = fMatrixRMaj.data[(fMatrixRMaj.numCols * i5) + i4];
                if (Math.abs(f2) > f) {
                    fMatrixSparseCSC.nz_rows[fMatrixSparseCSC.nz_length] = i5;
                    fMatrixSparseCSC.nz_values[fMatrixSparseCSC.nz_length] = f2;
                    fMatrixSparseCSC.nz_length++;
                }
            }
            i4++;
            fMatrixSparseCSC.col_idx[i4] = fMatrixSparseCSC.nz_length;
        }
        return fMatrixSparseCSC;
    }

    public static FMatrixSparseCSC convert(FMatrixSparseTriplet fMatrixSparseTriplet, FMatrixSparseCSC fMatrixSparseCSC, int[] iArr) {
        if (fMatrixSparseCSC == null) {
            fMatrixSparseCSC = new FMatrixSparseCSC(fMatrixSparseTriplet.numRows, fMatrixSparseTriplet.numCols, fMatrixSparseTriplet.nz_length);
        } else {
            fMatrixSparseCSC.reshape(fMatrixSparseTriplet.numRows, fMatrixSparseTriplet.numCols, fMatrixSparseTriplet.nz_length);
        }
        if (iArr == null) {
            iArr = new int[fMatrixSparseTriplet.numCols];
        } else if (iArr.length >= fMatrixSparseTriplet.numCols) {
            Arrays.fill(iArr, 0, fMatrixSparseTriplet.numCols, 0);
        } else {
            throw new IllegalArgumentException("Length of hist must be at least numCols");
        }
        for (int i = 0; i < fMatrixSparseTriplet.nz_length; i++) {
            int i2 = fMatrixSparseTriplet.nz_data[i].col;
            iArr[i2] = iArr[i2] + 1;
        }
        fMatrixSparseCSC.colsum(iArr);
        for (int i3 = 0; i3 < fMatrixSparseTriplet.nz_length; i3++) {
            FMatrixSparseTriplet.Element element = fMatrixSparseTriplet.nz_data[i3];
            int i4 = element.col;
            int i5 = iArr[i4];
            iArr[i4] = i5 + 1;
            fMatrixSparseCSC.nz_rows[i5] = element.row;
            fMatrixSparseCSC.nz_values[i5] = element.value;
        }
        fMatrixSparseCSC.indicesSorted = false;
        return fMatrixSparseCSC;
    }

    public static FMatrixSparseCSC convert(FMatrixSparseTriplet fMatrixSparseTriplet, FMatrixSparseCSC fMatrixSparseCSC) {
        return convert(fMatrixSparseTriplet, fMatrixSparseCSC, (int[]) null);
    }

    public static FMatrixSparseTriplet convert(FMatrixSparseCSC fMatrixSparseCSC, FMatrixSparseTriplet fMatrixSparseTriplet) {
        if (fMatrixSparseTriplet == null) {
            fMatrixSparseTriplet = new FMatrixSparseTriplet(fMatrixSparseCSC.numRows, fMatrixSparseCSC.numCols, fMatrixSparseCSC.nz_length);
        } else {
            fMatrixSparseTriplet.reshape(fMatrixSparseCSC.numRows, fMatrixSparseCSC.numCols);
        }
        int i = 0;
        int i2 = fMatrixSparseCSC.col_idx[0];
        while (i < fMatrixSparseCSC.numCols) {
            int i3 = i + 1;
            int i4 = fMatrixSparseCSC.col_idx[i3];
            while (i2 < i4) {
                fMatrixSparseTriplet.addItem(fMatrixSparseCSC.nz_rows[i2], i, fMatrixSparseCSC.nz_values[i2]);
                i2++;
            }
            i2 = i4;
            i = i3;
        }
        return fMatrixSparseTriplet;
    }
}
