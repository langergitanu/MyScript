package org.ejml.ops;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import org.ejml.data.DMatrix;
import org.ejml.data.DMatrix2;
import org.ejml.data.DMatrix2x2;
import org.ejml.data.DMatrix3;
import org.ejml.data.DMatrix3x3;
import org.ejml.data.DMatrix4;
import org.ejml.data.DMatrix4x4;
import org.ejml.data.DMatrix5;
import org.ejml.data.DMatrix5x5;
import org.ejml.data.DMatrix6;
import org.ejml.data.DMatrix6x6;
import org.ejml.data.DMatrixRBlock;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.data.DMatrixSparseTriplet;

/* JADX INFO: loaded from: classes9.dex */
public class ConvertDMatrixStruct {
    public static void convert(DMatrix dMatrix, DMatrix dMatrix2) {
        if (dMatrix.getNumRows() != dMatrix2.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (dMatrix.getNumCols() != dMatrix2.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        for (int i = 0; i < dMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < dMatrix.getNumCols(); i2++) {
                dMatrix2.unsafe_set(i, i2, dMatrix.unsafe_get(i, i2));
            }
        }
    }

    public static DMatrixRMaj convert(DMatrix2x2 dMatrix2x2, DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(2, 2);
        }
        if (dMatrix2x2.getNumRows() != dMatrixRMaj.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (dMatrix2x2.getNumCols() != dMatrixRMaj.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        dMatrixRMaj.data[0] = dMatrix2x2.a11;
        dMatrixRMaj.data[1] = dMatrix2x2.a12;
        dMatrixRMaj.data[2] = dMatrix2x2.a21;
        dMatrixRMaj.data[3] = dMatrix2x2.a22;
        return dMatrixRMaj;
    }

    public static DMatrixRMaj convert(DMatrix3x3 dMatrix3x3, DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(3, 3);
        }
        if (dMatrix3x3.getNumRows() != dMatrixRMaj.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (dMatrix3x3.getNumCols() != dMatrixRMaj.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        dMatrixRMaj.data[0] = dMatrix3x3.a11;
        dMatrixRMaj.data[1] = dMatrix3x3.a12;
        dMatrixRMaj.data[2] = dMatrix3x3.a13;
        dMatrixRMaj.data[3] = dMatrix3x3.a21;
        dMatrixRMaj.data[4] = dMatrix3x3.a22;
        dMatrixRMaj.data[5] = dMatrix3x3.a23;
        dMatrixRMaj.data[6] = dMatrix3x3.a31;
        dMatrixRMaj.data[7] = dMatrix3x3.a32;
        dMatrixRMaj.data[8] = dMatrix3x3.a33;
        return dMatrixRMaj;
    }

    public static DMatrixRMaj convert(DMatrix4x4 dMatrix4x4, DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(4, 4);
        }
        if (dMatrix4x4.getNumRows() != dMatrixRMaj.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (dMatrix4x4.getNumCols() != dMatrixRMaj.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        dMatrixRMaj.data[0] = dMatrix4x4.a11;
        dMatrixRMaj.data[1] = dMatrix4x4.a12;
        dMatrixRMaj.data[2] = dMatrix4x4.a13;
        dMatrixRMaj.data[3] = dMatrix4x4.a14;
        dMatrixRMaj.data[4] = dMatrix4x4.a21;
        dMatrixRMaj.data[5] = dMatrix4x4.a22;
        dMatrixRMaj.data[6] = dMatrix4x4.a23;
        dMatrixRMaj.data[7] = dMatrix4x4.a24;
        dMatrixRMaj.data[8] = dMatrix4x4.a31;
        dMatrixRMaj.data[9] = dMatrix4x4.a32;
        dMatrixRMaj.data[10] = dMatrix4x4.a33;
        dMatrixRMaj.data[11] = dMatrix4x4.a34;
        dMatrixRMaj.data[12] = dMatrix4x4.a41;
        dMatrixRMaj.data[13] = dMatrix4x4.a42;
        dMatrixRMaj.data[14] = dMatrix4x4.a43;
        dMatrixRMaj.data[15] = dMatrix4x4.a44;
        return dMatrixRMaj;
    }

    public static DMatrixRMaj convert(DMatrix5x5 dMatrix5x5, DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(5, 5);
        }
        if (dMatrix5x5.getNumRows() != dMatrixRMaj.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (dMatrix5x5.getNumCols() != dMatrixRMaj.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        dMatrixRMaj.data[0] = dMatrix5x5.a11;
        dMatrixRMaj.data[1] = dMatrix5x5.a12;
        dMatrixRMaj.data[2] = dMatrix5x5.a13;
        dMatrixRMaj.data[3] = dMatrix5x5.a14;
        dMatrixRMaj.data[4] = dMatrix5x5.a15;
        dMatrixRMaj.data[5] = dMatrix5x5.a21;
        dMatrixRMaj.data[6] = dMatrix5x5.a22;
        dMatrixRMaj.data[7] = dMatrix5x5.a23;
        dMatrixRMaj.data[8] = dMatrix5x5.a24;
        dMatrixRMaj.data[9] = dMatrix5x5.a25;
        dMatrixRMaj.data[10] = dMatrix5x5.a31;
        dMatrixRMaj.data[11] = dMatrix5x5.a32;
        dMatrixRMaj.data[12] = dMatrix5x5.a33;
        dMatrixRMaj.data[13] = dMatrix5x5.a34;
        dMatrixRMaj.data[14] = dMatrix5x5.a35;
        dMatrixRMaj.data[15] = dMatrix5x5.a41;
        dMatrixRMaj.data[16] = dMatrix5x5.a42;
        dMatrixRMaj.data[17] = dMatrix5x5.a43;
        dMatrixRMaj.data[18] = dMatrix5x5.a44;
        dMatrixRMaj.data[19] = dMatrix5x5.a45;
        dMatrixRMaj.data[20] = dMatrix5x5.a51;
        dMatrixRMaj.data[21] = dMatrix5x5.a52;
        dMatrixRMaj.data[22] = dMatrix5x5.a53;
        dMatrixRMaj.data[23] = dMatrix5x5.a54;
        dMatrixRMaj.data[24] = dMatrix5x5.a55;
        return dMatrixRMaj;
    }

    public static DMatrixRMaj convert(DMatrix6x6 dMatrix6x6, DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(6, 6);
        }
        if (dMatrix6x6.getNumRows() != dMatrixRMaj.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (dMatrix6x6.getNumCols() != dMatrixRMaj.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        dMatrixRMaj.data[0] = dMatrix6x6.a11;
        dMatrixRMaj.data[1] = dMatrix6x6.a12;
        dMatrixRMaj.data[2] = dMatrix6x6.a13;
        dMatrixRMaj.data[3] = dMatrix6x6.a14;
        dMatrixRMaj.data[4] = dMatrix6x6.a15;
        dMatrixRMaj.data[5] = dMatrix6x6.a16;
        dMatrixRMaj.data[6] = dMatrix6x6.a21;
        dMatrixRMaj.data[7] = dMatrix6x6.a22;
        dMatrixRMaj.data[8] = dMatrix6x6.a23;
        dMatrixRMaj.data[9] = dMatrix6x6.a24;
        dMatrixRMaj.data[10] = dMatrix6x6.a25;
        dMatrixRMaj.data[11] = dMatrix6x6.a26;
        dMatrixRMaj.data[12] = dMatrix6x6.a31;
        dMatrixRMaj.data[13] = dMatrix6x6.a32;
        dMatrixRMaj.data[14] = dMatrix6x6.a33;
        dMatrixRMaj.data[15] = dMatrix6x6.a34;
        dMatrixRMaj.data[16] = dMatrix6x6.a35;
        dMatrixRMaj.data[17] = dMatrix6x6.a36;
        dMatrixRMaj.data[18] = dMatrix6x6.a41;
        dMatrixRMaj.data[19] = dMatrix6x6.a42;
        dMatrixRMaj.data[20] = dMatrix6x6.a43;
        dMatrixRMaj.data[21] = dMatrix6x6.a44;
        dMatrixRMaj.data[22] = dMatrix6x6.a45;
        dMatrixRMaj.data[23] = dMatrix6x6.a46;
        dMatrixRMaj.data[24] = dMatrix6x6.a51;
        dMatrixRMaj.data[25] = dMatrix6x6.a52;
        dMatrixRMaj.data[26] = dMatrix6x6.a53;
        dMatrixRMaj.data[27] = dMatrix6x6.a54;
        dMatrixRMaj.data[28] = dMatrix6x6.a55;
        dMatrixRMaj.data[29] = dMatrix6x6.a56;
        dMatrixRMaj.data[30] = dMatrix6x6.a61;
        dMatrixRMaj.data[31] = dMatrix6x6.a62;
        dMatrixRMaj.data[32] = dMatrix6x6.a63;
        dMatrixRMaj.data[33] = dMatrix6x6.a64;
        dMatrixRMaj.data[34] = dMatrix6x6.a65;
        dMatrixRMaj.data[35] = dMatrix6x6.a66;
        return dMatrixRMaj;
    }

    public static DMatrix2x2 convert(DMatrixRMaj dMatrixRMaj, DMatrix2x2 dMatrix2x2) {
        if (dMatrix2x2 == null) {
            dMatrix2x2 = new DMatrix2x2();
        }
        if (dMatrixRMaj.getNumRows() != dMatrix2x2.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (dMatrixRMaj.getNumCols() != dMatrix2x2.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        dMatrix2x2.a11 = dMatrixRMaj.data[0];
        dMatrix2x2.a12 = dMatrixRMaj.data[1];
        dMatrix2x2.a21 = dMatrixRMaj.data[2];
        dMatrix2x2.a22 = dMatrixRMaj.data[3];
        return dMatrix2x2;
    }

    public static DMatrix3x3 convert(DMatrixRMaj dMatrixRMaj, DMatrix3x3 dMatrix3x3) {
        if (dMatrix3x3 == null) {
            dMatrix3x3 = new DMatrix3x3();
        }
        if (dMatrixRMaj.getNumRows() != dMatrix3x3.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (dMatrixRMaj.getNumCols() != dMatrix3x3.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        dMatrix3x3.a11 = dMatrixRMaj.data[0];
        dMatrix3x3.a12 = dMatrixRMaj.data[1];
        dMatrix3x3.a13 = dMatrixRMaj.data[2];
        dMatrix3x3.a21 = dMatrixRMaj.data[3];
        dMatrix3x3.a22 = dMatrixRMaj.data[4];
        dMatrix3x3.a23 = dMatrixRMaj.data[5];
        dMatrix3x3.a31 = dMatrixRMaj.data[6];
        dMatrix3x3.a32 = dMatrixRMaj.data[7];
        dMatrix3x3.a33 = dMatrixRMaj.data[8];
        return dMatrix3x3;
    }

    public static DMatrix4x4 convert(DMatrixRMaj dMatrixRMaj, DMatrix4x4 dMatrix4x4) {
        if (dMatrix4x4 == null) {
            dMatrix4x4 = new DMatrix4x4();
        }
        if (dMatrixRMaj.getNumRows() != dMatrix4x4.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (dMatrixRMaj.getNumCols() != dMatrix4x4.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        dMatrix4x4.a11 = dMatrixRMaj.data[0];
        dMatrix4x4.a12 = dMatrixRMaj.data[1];
        dMatrix4x4.a13 = dMatrixRMaj.data[2];
        dMatrix4x4.a14 = dMatrixRMaj.data[3];
        dMatrix4x4.a21 = dMatrixRMaj.data[4];
        dMatrix4x4.a22 = dMatrixRMaj.data[5];
        dMatrix4x4.a23 = dMatrixRMaj.data[6];
        dMatrix4x4.a24 = dMatrixRMaj.data[7];
        dMatrix4x4.a31 = dMatrixRMaj.data[8];
        dMatrix4x4.a32 = dMatrixRMaj.data[9];
        dMatrix4x4.a33 = dMatrixRMaj.data[10];
        dMatrix4x4.a34 = dMatrixRMaj.data[11];
        dMatrix4x4.a41 = dMatrixRMaj.data[12];
        dMatrix4x4.a42 = dMatrixRMaj.data[13];
        dMatrix4x4.a43 = dMatrixRMaj.data[14];
        dMatrix4x4.a44 = dMatrixRMaj.data[15];
        return dMatrix4x4;
    }

    public static DMatrix5x5 convert(DMatrixRMaj dMatrixRMaj, DMatrix5x5 dMatrix5x5) {
        if (dMatrix5x5 == null) {
            dMatrix5x5 = new DMatrix5x5();
        }
        if (dMatrixRMaj.getNumRows() != dMatrix5x5.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (dMatrixRMaj.getNumCols() != dMatrix5x5.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        dMatrix5x5.a11 = dMatrixRMaj.data[0];
        dMatrix5x5.a12 = dMatrixRMaj.data[1];
        dMatrix5x5.a13 = dMatrixRMaj.data[2];
        dMatrix5x5.a14 = dMatrixRMaj.data[3];
        dMatrix5x5.a15 = dMatrixRMaj.data[4];
        dMatrix5x5.a21 = dMatrixRMaj.data[5];
        dMatrix5x5.a22 = dMatrixRMaj.data[6];
        dMatrix5x5.a23 = dMatrixRMaj.data[7];
        dMatrix5x5.a24 = dMatrixRMaj.data[8];
        dMatrix5x5.a25 = dMatrixRMaj.data[9];
        dMatrix5x5.a31 = dMatrixRMaj.data[10];
        dMatrix5x5.a32 = dMatrixRMaj.data[11];
        dMatrix5x5.a33 = dMatrixRMaj.data[12];
        dMatrix5x5.a34 = dMatrixRMaj.data[13];
        dMatrix5x5.a35 = dMatrixRMaj.data[14];
        dMatrix5x5.a41 = dMatrixRMaj.data[15];
        dMatrix5x5.a42 = dMatrixRMaj.data[16];
        dMatrix5x5.a43 = dMatrixRMaj.data[17];
        dMatrix5x5.a44 = dMatrixRMaj.data[18];
        dMatrix5x5.a45 = dMatrixRMaj.data[19];
        dMatrix5x5.a51 = dMatrixRMaj.data[20];
        dMatrix5x5.a52 = dMatrixRMaj.data[21];
        dMatrix5x5.a53 = dMatrixRMaj.data[22];
        dMatrix5x5.a54 = dMatrixRMaj.data[23];
        dMatrix5x5.a55 = dMatrixRMaj.data[24];
        return dMatrix5x5;
    }

    public static DMatrix6x6 convert(DMatrixRMaj dMatrixRMaj, DMatrix6x6 dMatrix6x6) {
        if (dMatrix6x6 == null) {
            dMatrix6x6 = new DMatrix6x6();
        }
        if (dMatrixRMaj.getNumRows() != dMatrix6x6.getNumRows()) {
            throw new IllegalArgumentException("Number of rows do not match");
        }
        if (dMatrixRMaj.getNumCols() != dMatrix6x6.getNumCols()) {
            throw new IllegalArgumentException("Number of columns do not match");
        }
        dMatrix6x6.a11 = dMatrixRMaj.data[0];
        dMatrix6x6.a12 = dMatrixRMaj.data[1];
        dMatrix6x6.a13 = dMatrixRMaj.data[2];
        dMatrix6x6.a14 = dMatrixRMaj.data[3];
        dMatrix6x6.a15 = dMatrixRMaj.data[4];
        dMatrix6x6.a16 = dMatrixRMaj.data[5];
        dMatrix6x6.a21 = dMatrixRMaj.data[6];
        dMatrix6x6.a22 = dMatrixRMaj.data[7];
        dMatrix6x6.a23 = dMatrixRMaj.data[8];
        dMatrix6x6.a24 = dMatrixRMaj.data[9];
        dMatrix6x6.a25 = dMatrixRMaj.data[10];
        dMatrix6x6.a26 = dMatrixRMaj.data[11];
        dMatrix6x6.a31 = dMatrixRMaj.data[12];
        dMatrix6x6.a32 = dMatrixRMaj.data[13];
        dMatrix6x6.a33 = dMatrixRMaj.data[14];
        dMatrix6x6.a34 = dMatrixRMaj.data[15];
        dMatrix6x6.a35 = dMatrixRMaj.data[16];
        dMatrix6x6.a36 = dMatrixRMaj.data[17];
        dMatrix6x6.a41 = dMatrixRMaj.data[18];
        dMatrix6x6.a42 = dMatrixRMaj.data[19];
        dMatrix6x6.a43 = dMatrixRMaj.data[20];
        dMatrix6x6.a44 = dMatrixRMaj.data[21];
        dMatrix6x6.a45 = dMatrixRMaj.data[22];
        dMatrix6x6.a46 = dMatrixRMaj.data[23];
        dMatrix6x6.a51 = dMatrixRMaj.data[24];
        dMatrix6x6.a52 = dMatrixRMaj.data[25];
        dMatrix6x6.a53 = dMatrixRMaj.data[26];
        dMatrix6x6.a54 = dMatrixRMaj.data[27];
        dMatrix6x6.a55 = dMatrixRMaj.data[28];
        dMatrix6x6.a56 = dMatrixRMaj.data[29];
        dMatrix6x6.a61 = dMatrixRMaj.data[30];
        dMatrix6x6.a62 = dMatrixRMaj.data[31];
        dMatrix6x6.a63 = dMatrixRMaj.data[32];
        dMatrix6x6.a64 = dMatrixRMaj.data[33];
        dMatrix6x6.a65 = dMatrixRMaj.data[34];
        dMatrix6x6.a66 = dMatrixRMaj.data[35];
        return dMatrix6x6;
    }

    public static DMatrixRMaj convert(DMatrix2 dMatrix2, DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(2, 1);
        }
        if (dMatrixRMaj.getNumRows() != 1 && dMatrixRMaj.getNumCols() != 1) {
            throw new IllegalArgumentException("One row or column must have a length of 1 for it to be a vector");
        }
        int iMax = Math.max(dMatrixRMaj.getNumRows(), dMatrixRMaj.getNumCols());
        if (iMax != 2) {
            throw new IllegalArgumentException("Length of input vector is not 2.  It is " + iMax);
        }
        dMatrixRMaj.data[0] = dMatrix2.f2397a1;
        dMatrixRMaj.data[1] = dMatrix2.f2398a2;
        return dMatrixRMaj;
    }

    public static DMatrixRMaj convert(DMatrix3 dMatrix3, DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(3, 1);
        }
        if (dMatrixRMaj.getNumRows() != 1 && dMatrixRMaj.getNumCols() != 1) {
            throw new IllegalArgumentException("One row or column must have a length of 1 for it to be a vector");
        }
        int iMax = Math.max(dMatrixRMaj.getNumRows(), dMatrixRMaj.getNumCols());
        if (iMax != 3) {
            throw new IllegalArgumentException("Length of input vector is not 3.  It is " + iMax);
        }
        dMatrixRMaj.data[0] = dMatrix3.f2399a1;
        dMatrixRMaj.data[1] = dMatrix3.f2400a2;
        dMatrixRMaj.data[2] = dMatrix3.f2401a3;
        return dMatrixRMaj;
    }

    public static DMatrixRMaj convert(DMatrix4 dMatrix4, DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(4, 1);
        }
        if (dMatrixRMaj.getNumRows() != 1 && dMatrixRMaj.getNumCols() != 1) {
            throw new IllegalArgumentException("One row or column must have a length of 1 for it to be a vector");
        }
        int iMax = Math.max(dMatrixRMaj.getNumRows(), dMatrixRMaj.getNumCols());
        if (iMax != 4) {
            throw new IllegalArgumentException("Length of input vector is not 4.  It is " + iMax);
        }
        dMatrixRMaj.data[0] = dMatrix4.f2402a1;
        dMatrixRMaj.data[1] = dMatrix4.f2403a2;
        dMatrixRMaj.data[2] = dMatrix4.f2404a3;
        dMatrixRMaj.data[3] = dMatrix4.f2405a4;
        return dMatrixRMaj;
    }

    public static DMatrixRMaj convert(DMatrix5 dMatrix5, DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(5, 1);
        }
        if (dMatrixRMaj.getNumRows() != 1 && dMatrixRMaj.getNumCols() != 1) {
            throw new IllegalArgumentException("One row or column must have a length of 1 for it to be a vector");
        }
        int iMax = Math.max(dMatrixRMaj.getNumRows(), dMatrixRMaj.getNumCols());
        if (iMax != 5) {
            throw new IllegalArgumentException("Length of input vector is not 5.  It is " + iMax);
        }
        dMatrixRMaj.data[0] = dMatrix5.f2406a1;
        dMatrixRMaj.data[1] = dMatrix5.f2407a2;
        dMatrixRMaj.data[2] = dMatrix5.f2408a3;
        dMatrixRMaj.data[3] = dMatrix5.f2409a4;
        dMatrixRMaj.data[4] = dMatrix5.f2410a5;
        return dMatrixRMaj;
    }

    public static DMatrixRMaj convert(DMatrix6 dMatrix6, DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(6, 1);
        }
        if (dMatrixRMaj.getNumRows() != 1 && dMatrixRMaj.getNumCols() != 1) {
            throw new IllegalArgumentException("One row or column must have a length of 1 for it to be a vector");
        }
        int iMax = Math.max(dMatrixRMaj.getNumRows(), dMatrixRMaj.getNumCols());
        if (iMax != 6) {
            throw new IllegalArgumentException("Length of input vector is not 6.  It is " + iMax);
        }
        dMatrixRMaj.data[0] = dMatrix6.f2411a1;
        dMatrixRMaj.data[1] = dMatrix6.f2412a2;
        dMatrixRMaj.data[2] = dMatrix6.f2413a3;
        dMatrixRMaj.data[3] = dMatrix6.f2414a4;
        dMatrixRMaj.data[4] = dMatrix6.f2415a5;
        dMatrixRMaj.data[5] = dMatrix6.f2416a6;
        return dMatrixRMaj;
    }

    public static DMatrix2 convert(DMatrixRMaj dMatrixRMaj, DMatrix2 dMatrix2) {
        if (dMatrix2 == null) {
            dMatrix2 = new DMatrix2();
        }
        if (dMatrixRMaj.getNumRows() != 1 && dMatrixRMaj.getNumCols() != 1) {
            throw new IllegalArgumentException("One row or column must have a length of 1 for it to be a vector");
        }
        int iMax = Math.max(dMatrixRMaj.getNumRows(), dMatrixRMaj.getNumCols());
        if (iMax != 2) {
            throw new IllegalArgumentException("Length of input vector is not 2.  It is " + iMax);
        }
        dMatrix2.f2397a1 = dMatrixRMaj.data[0];
        dMatrix2.f2398a2 = dMatrixRMaj.data[1];
        return dMatrix2;
    }

    public static DMatrix3 convert(DMatrixRMaj dMatrixRMaj, DMatrix3 dMatrix3) {
        if (dMatrix3 == null) {
            dMatrix3 = new DMatrix3();
        }
        if (dMatrixRMaj.getNumRows() != 1 && dMatrixRMaj.getNumCols() != 1) {
            throw new IllegalArgumentException("One row or column must have a length of 1 for it to be a vector");
        }
        int iMax = Math.max(dMatrixRMaj.getNumRows(), dMatrixRMaj.getNumCols());
        if (iMax != 3) {
            throw new IllegalArgumentException("Length of input vector is not 3.  It is " + iMax);
        }
        dMatrix3.f2399a1 = dMatrixRMaj.data[0];
        dMatrix3.f2400a2 = dMatrixRMaj.data[1];
        dMatrix3.f2401a3 = dMatrixRMaj.data[2];
        return dMatrix3;
    }

    public static DMatrix4 convert(DMatrixRMaj dMatrixRMaj, DMatrix4 dMatrix4) {
        if (dMatrix4 == null) {
            dMatrix4 = new DMatrix4();
        }
        if (dMatrixRMaj.getNumRows() != 1 && dMatrixRMaj.getNumCols() != 1) {
            throw new IllegalArgumentException("One row or column must have a length of 1 for it to be a vector");
        }
        int iMax = Math.max(dMatrixRMaj.getNumRows(), dMatrixRMaj.getNumCols());
        if (iMax != 4) {
            throw new IllegalArgumentException("Length of input vector is not 4.  It is " + iMax);
        }
        dMatrix4.f2402a1 = dMatrixRMaj.data[0];
        dMatrix4.f2403a2 = dMatrixRMaj.data[1];
        dMatrix4.f2404a3 = dMatrixRMaj.data[2];
        dMatrix4.f2405a4 = dMatrixRMaj.data[3];
        return dMatrix4;
    }

    public static DMatrix5 convert(DMatrixRMaj dMatrixRMaj, DMatrix5 dMatrix5) {
        if (dMatrix5 == null) {
            dMatrix5 = new DMatrix5();
        }
        if (dMatrixRMaj.getNumRows() != 1 && dMatrixRMaj.getNumCols() != 1) {
            throw new IllegalArgumentException("One row or column must have a length of 1 for it to be a vector");
        }
        int iMax = Math.max(dMatrixRMaj.getNumRows(), dMatrixRMaj.getNumCols());
        if (iMax != 5) {
            throw new IllegalArgumentException("Length of input vector is not 5.  It is " + iMax);
        }
        dMatrix5.f2406a1 = dMatrixRMaj.data[0];
        dMatrix5.f2407a2 = dMatrixRMaj.data[1];
        dMatrix5.f2408a3 = dMatrixRMaj.data[2];
        dMatrix5.f2409a4 = dMatrixRMaj.data[3];
        dMatrix5.f2410a5 = dMatrixRMaj.data[4];
        return dMatrix5;
    }

    public static DMatrix6 convert(DMatrixRMaj dMatrixRMaj, DMatrix6 dMatrix6) {
        if (dMatrix6 == null) {
            dMatrix6 = new DMatrix6();
        }
        if (dMatrixRMaj.getNumRows() != 1 && dMatrixRMaj.getNumCols() != 1) {
            throw new IllegalArgumentException("One row or column must have a length of 1 for it to be a vector");
        }
        int iMax = Math.max(dMatrixRMaj.getNumRows(), dMatrixRMaj.getNumCols());
        if (iMax != 6) {
            throw new IllegalArgumentException("Length of input vector is not 6.  It is " + iMax);
        }
        dMatrix6.f2411a1 = dMatrixRMaj.data[0];
        dMatrix6.f2412a2 = dMatrixRMaj.data[1];
        dMatrix6.f2413a3 = dMatrixRMaj.data[2];
        dMatrix6.f2414a4 = dMatrixRMaj.data[3];
        dMatrix6.f2415a5 = dMatrixRMaj.data[4];
        dMatrix6.f2416a6 = dMatrixRMaj.data[5];
        return dMatrix6;
    }

    public static void convert(DMatrixRMaj dMatrixRMaj, DMatrixRBlock dMatrixRBlock) {
        if (dMatrixRMaj.numRows != dMatrixRBlock.numRows || dMatrixRMaj.numCols != dMatrixRBlock.numCols) {
            throw new IllegalArgumentException("Must be the same size.");
        }
        int i = 0;
        while (i < dMatrixRBlock.numRows) {
            int iMin = Math.min(dMatrixRBlock.blockLength, dMatrixRBlock.numRows - i);
            int i2 = 0;
            while (i2 < dMatrixRBlock.numCols) {
                int iMin2 = Math.min(dMatrixRBlock.blockLength, dMatrixRBlock.numCols - i2);
                int i3 = (dMatrixRBlock.numCols * i) + (iMin * i2);
                int i4 = (dMatrixRBlock.numCols * i) + i2;
                for (int i5 = 0; i5 < iMin; i5++) {
                    System.arraycopy(dMatrixRMaj.data, i4, dMatrixRBlock.data, i3, iMin2);
                    i3 += iMin2;
                    i4 += dMatrixRBlock.numCols;
                }
                i2 += dMatrixRBlock.blockLength;
            }
            i += dMatrixRBlock.blockLength;
        }
    }

    public static DMatrixRMaj convert(DMatrixRBlock dMatrixRBlock, DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj != null) {
            if (dMatrixRMaj.numRows != dMatrixRBlock.numRows || dMatrixRMaj.numCols != dMatrixRBlock.numCols) {
                throw new IllegalArgumentException("Must be the same size.");
            }
        } else {
            dMatrixRMaj = new DMatrixRMaj(dMatrixRBlock.numRows, dMatrixRBlock.numCols);
        }
        int i = 0;
        while (i < dMatrixRBlock.numRows) {
            int iMin = Math.min(dMatrixRBlock.blockLength, dMatrixRBlock.numRows - i);
            int i2 = 0;
            while (i2 < dMatrixRBlock.numCols) {
                int iMin2 = Math.min(dMatrixRBlock.blockLength, dMatrixRBlock.numCols - i2);
                int i3 = (dMatrixRBlock.numCols * i) + (iMin * i2);
                int i4 = (dMatrixRMaj.numCols * i) + i2;
                for (int i5 = 0; i5 < iMin; i5++) {
                    System.arraycopy(dMatrixRBlock.data, i3, dMatrixRMaj.data, i4, iMin2);
                    i3 += iMin2;
                    i4 += dMatrixRMaj.numCols;
                }
                i2 += dMatrixRBlock.blockLength;
            }
            i += dMatrixRBlock.blockLength;
        }
        return dMatrixRMaj;
    }

    public static DMatrixSparseTriplet convert(DMatrix dMatrix, DMatrixSparseTriplet dMatrixSparseTriplet, double d) {
        if (dMatrixSparseTriplet == null) {
            dMatrixSparseTriplet = new DMatrixSparseTriplet(dMatrix.getNumRows(), dMatrix.getNumCols(), 1);
        } else {
            dMatrixSparseTriplet.reshape(dMatrix.getNumRows(), dMatrix.getNumCols());
        }
        for (int i = 0; i < dMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < dMatrix.getNumCols(); i2++) {
                double dUnsafe_get = dMatrix.unsafe_get(i, i2);
                if (Math.abs(dUnsafe_get) > d) {
                    dMatrixSparseTriplet.addItem(i, i2, dUnsafe_get);
                }
            }
        }
        return dMatrixSparseTriplet;
    }

    public static DMatrixSparseTriplet convert(DMatrixRMaj dMatrixRMaj, DMatrixSparseTriplet dMatrixSparseTriplet, double d) {
        if (dMatrixSparseTriplet == null) {
            dMatrixSparseTriplet = new DMatrixSparseTriplet(dMatrixRMaj.numRows, dMatrixRMaj.numCols, dMatrixRMaj.numRows * dMatrixRMaj.numCols);
        } else {
            dMatrixSparseTriplet.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        }
        int i = 0;
        for (int i2 = 0; i2 < dMatrixRMaj.numRows; i2++) {
            int i3 = 0;
            while (i3 < dMatrixRMaj.numCols) {
                int i4 = i + 1;
                double d2 = dMatrixRMaj.data[i];
                if (Math.abs(d2) > d) {
                    dMatrixSparseTriplet.addItem(i2, i3, d2);
                }
                i3++;
                i = i4;
            }
        }
        return dMatrixSparseTriplet;
    }

    public static DMatrixRMaj convert(DMatrixSparseTriplet dMatrixSparseTriplet, DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(dMatrixSparseTriplet.numRows, dMatrixSparseTriplet.numCols);
        } else {
            dMatrixRMaj.reshape(dMatrixSparseTriplet.numRows, dMatrixSparseTriplet.numCols);
            dMatrixRMaj.zero();
        }
        for (int i = 0; i < dMatrixSparseTriplet.nz_length; i++) {
            DMatrixSparseTriplet.Element element = dMatrixSparseTriplet.nz_data[i];
            dMatrixRMaj.unsafe_set(element.row, element.col, element.value);
        }
        return dMatrixRMaj;
    }

    public static DMatrixRMaj convert(DMatrixSparseCSC dMatrixSparseCSC, DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(dMatrixSparseCSC.numRows, dMatrixSparseCSC.numCols);
        } else {
            dMatrixRMaj.reshape(dMatrixSparseCSC.numRows, dMatrixSparseCSC.numCols);
            dMatrixRMaj.zero();
        }
        int i = dMatrixSparseCSC.col_idx[0];
        int i2 = 1;
        while (i2 <= dMatrixSparseCSC.numCols) {
            int i3 = dMatrixSparseCSC.col_idx[i2];
            while (i < i3) {
                dMatrixRMaj.unsafe_set(dMatrixSparseCSC.nz_rows[i], i2 - 1, dMatrixSparseCSC.nz_values[i]);
                i++;
            }
            i2++;
            i = i3;
        }
        return dMatrixRMaj;
    }

    public static DMatrixSparseCSC convert(DMatrixRMaj dMatrixRMaj, DMatrixSparseCSC dMatrixSparseCSC, double d) {
        int i = dMatrixRMaj.numRows * dMatrixRMaj.numCols;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (dMatrixRMaj.data[i3] != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                i2++;
            }
        }
        if (dMatrixSparseCSC == null) {
            dMatrixSparseCSC = new DMatrixSparseCSC(dMatrixRMaj.numRows, dMatrixRMaj.numCols, i2);
        } else {
            dMatrixSparseCSC.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols, i2);
        }
        dMatrixSparseCSC.nz_length = 0;
        dMatrixSparseCSC.col_idx[0] = 0;
        int i4 = 0;
        while (i4 < dMatrixRMaj.numCols) {
            for (int i5 = 0; i5 < dMatrixRMaj.numRows; i5++) {
                double d2 = dMatrixRMaj.data[(dMatrixRMaj.numCols * i5) + i4];
                if (Math.abs(d2) > d) {
                    dMatrixSparseCSC.nz_rows[dMatrixSparseCSC.nz_length] = i5;
                    dMatrixSparseCSC.nz_values[dMatrixSparseCSC.nz_length] = d2;
                    dMatrixSparseCSC.nz_length++;
                }
            }
            i4++;
            dMatrixSparseCSC.col_idx[i4] = dMatrixSparseCSC.nz_length;
        }
        return dMatrixSparseCSC;
    }

    public static DMatrixSparseCSC convert(DMatrixSparseTriplet dMatrixSparseTriplet, DMatrixSparseCSC dMatrixSparseCSC, int[] iArr) {
        if (dMatrixSparseCSC == null) {
            dMatrixSparseCSC = new DMatrixSparseCSC(dMatrixSparseTriplet.numRows, dMatrixSparseTriplet.numCols, dMatrixSparseTriplet.nz_length);
        } else {
            dMatrixSparseCSC.reshape(dMatrixSparseTriplet.numRows, dMatrixSparseTriplet.numCols, dMatrixSparseTriplet.nz_length);
        }
        if (iArr == null) {
            iArr = new int[dMatrixSparseTriplet.numCols];
        } else if (iArr.length >= dMatrixSparseTriplet.numCols) {
            Arrays.fill(iArr, 0, dMatrixSparseTriplet.numCols, 0);
        } else {
            throw new IllegalArgumentException("Length of hist must be at least numCols");
        }
        for (int i = 0; i < dMatrixSparseTriplet.nz_length; i++) {
            int i2 = dMatrixSparseTriplet.nz_data[i].col;
            iArr[i2] = iArr[i2] + 1;
        }
        dMatrixSparseCSC.colsum(iArr);
        for (int i3 = 0; i3 < dMatrixSparseTriplet.nz_length; i3++) {
            DMatrixSparseTriplet.Element element = dMatrixSparseTriplet.nz_data[i3];
            int i4 = element.col;
            int i5 = iArr[i4];
            iArr[i4] = i5 + 1;
            dMatrixSparseCSC.nz_rows[i5] = element.row;
            dMatrixSparseCSC.nz_values[i5] = element.value;
        }
        dMatrixSparseCSC.indicesSorted = false;
        return dMatrixSparseCSC;
    }

    public static DMatrixSparseCSC convert(DMatrixSparseTriplet dMatrixSparseTriplet, DMatrixSparseCSC dMatrixSparseCSC) {
        return convert(dMatrixSparseTriplet, dMatrixSparseCSC, (int[]) null);
    }

    public static DMatrixSparseTriplet convert(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseTriplet dMatrixSparseTriplet) {
        if (dMatrixSparseTriplet == null) {
            dMatrixSparseTriplet = new DMatrixSparseTriplet(dMatrixSparseCSC.numRows, dMatrixSparseCSC.numCols, dMatrixSparseCSC.nz_length);
        } else {
            dMatrixSparseTriplet.reshape(dMatrixSparseCSC.numRows, dMatrixSparseCSC.numCols);
        }
        int i = 0;
        int i2 = dMatrixSparseCSC.col_idx[0];
        while (i < dMatrixSparseCSC.numCols) {
            int i3 = i + 1;
            int i4 = dMatrixSparseCSC.col_idx[i3];
            while (i2 < i4) {
                dMatrixSparseTriplet.addItem(dMatrixSparseCSC.nz_rows[i2], i, dMatrixSparseCSC.nz_values[i2]);
                i2++;
            }
            i2 = i4;
            i = i3;
        }
        return dMatrixSparseTriplet;
    }
}
