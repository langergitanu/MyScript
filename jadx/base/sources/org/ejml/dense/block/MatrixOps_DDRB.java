package org.ejml.dense.block;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Random;
import org.ejml.data.DMatrixRBlock;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.DSubmatrixD1;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.dense.row.MatrixFeatures_DDRM;
import org.ejml.dense.row.RandomMatrices_DDRM;
import org.ejml.ops.ConvertDMatrixStruct;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixOps_DDRB {
    public static void convert(DMatrixRMaj dMatrixRMaj, DMatrixRBlock dMatrixRBlock) {
        ConvertDMatrixStruct.convert(dMatrixRMaj, dMatrixRBlock);
    }

    public static void convertRowToBlock(int i, int i2, int i3, double[] dArr, double[] dArr2) {
        int iMin = Math.min(i3, i) * i2;
        if (dArr2.length < iMin) {
            throw new IllegalArgumentException("tmp must be at least " + iMin + " long ");
        }
        int i4 = 0;
        while (i4 < i) {
            int iMin2 = Math.min(i3, i - i4);
            int i5 = i4 * i2;
            System.arraycopy(dArr, i5, dArr2, 0, iMin2 * i2);
            int i6 = 0;
            while (i6 < i2) {
                int iMin3 = Math.min(i3, i2 - i6);
                int i7 = (iMin2 * i6) + i5;
                int i8 = i6;
                for (int i9 = 0; i9 < iMin2; i9++) {
                    System.arraycopy(dArr2, i8, dArr, i7, iMin3);
                    i7 += iMin3;
                    i8 += i2;
                }
                i6 += i3;
            }
            i4 += i3;
        }
    }

    public static DMatrixRMaj convert(DMatrixRBlock dMatrixRBlock, DMatrixRMaj dMatrixRMaj) {
        return ConvertDMatrixStruct.convert(dMatrixRBlock, dMatrixRMaj);
    }

    public static void convertBlockToRow(int i, int i2, int i3, double[] dArr, double[] dArr2) {
        int iMin = Math.min(i3, i) * i2;
        if (dArr2.length < iMin) {
            throw new IllegalArgumentException("tmp must be at least " + iMin + " long and not " + dArr2.length);
        }
        int i4 = 0;
        while (i4 < i) {
            int iMin2 = Math.min(i3, i - i4);
            int i5 = i4 * i2;
            System.arraycopy(dArr, i5, dArr2, 0, iMin2 * i2);
            int i6 = 0;
            while (i6 < i2) {
                int iMin3 = Math.min(i3, i2 - i6);
                int i7 = iMin2 * i6;
                int i8 = i5 + i6;
                for (int i9 = 0; i9 < iMin2; i9++) {
                    System.arraycopy(dArr2, i7, dArr, i8, iMin3);
                    i7 += iMin3;
                    i8 += i2;
                }
                i6 += i3;
            }
            i4 += i3;
        }
    }

    public static void convertTranSrc(DMatrixRMaj dMatrixRMaj, DMatrixRBlock dMatrixRBlock) {
        if (dMatrixRMaj.numRows != dMatrixRBlock.numCols || dMatrixRMaj.numCols != dMatrixRBlock.numRows) {
            throw new IllegalArgumentException("Incompatible matrix shapes.");
        }
        int i = 0;
        while (i < dMatrixRBlock.numRows) {
            int iMin = Math.min(dMatrixRBlock.blockLength, dMatrixRBlock.numRows - i);
            int i2 = 0;
            while (i2 < dMatrixRBlock.numCols) {
                int iMin2 = Math.min(dMatrixRBlock.blockLength, dMatrixRBlock.numCols - i2);
                int i3 = (dMatrixRBlock.numCols * i) + (iMin * i2);
                int i4 = (dMatrixRMaj.numCols * i2) + i;
                for (int i5 = 0; i5 < iMin2; i5++) {
                    int i6 = (dMatrixRMaj.numCols * i5) + i4;
                    int i7 = i3 + i5;
                    int i8 = 0;
                    while (i8 < iMin) {
                        dMatrixRBlock.data[i7] = dMatrixRMaj.data[i6];
                        i8++;
                        i7 += iMin2;
                        i6++;
                    }
                }
                i2 += dMatrixRBlock.blockLength;
            }
            i += dMatrixRBlock.blockLength;
        }
    }

    public static void mult(DMatrixRBlock dMatrixRBlock, DMatrixRBlock dMatrixRBlock2, DMatrixRBlock dMatrixRBlock3) {
        if (dMatrixRBlock.numCols != dMatrixRBlock2.numRows) {
            throw new IllegalArgumentException("Columns in A are incompatible with rows in B");
        }
        if (dMatrixRBlock.numRows != dMatrixRBlock3.numRows) {
            throw new IllegalArgumentException("Rows in A are incompatible with rows in C");
        }
        if (dMatrixRBlock2.numCols != dMatrixRBlock3.numCols) {
            throw new IllegalArgumentException("Columns in B are incompatible with columns in C");
        }
        if (dMatrixRBlock.blockLength != dMatrixRBlock2.blockLength || dMatrixRBlock.blockLength != dMatrixRBlock3.blockLength) {
            throw new IllegalArgumentException("Block lengths are not all the same.");
        }
        MatrixMult_DDRB.mult(dMatrixRBlock.blockLength, new DSubmatrixD1(dMatrixRBlock, 0, dMatrixRBlock.numRows, 0, dMatrixRBlock.numCols), new DSubmatrixD1(dMatrixRBlock2, 0, dMatrixRBlock2.numRows, 0, dMatrixRBlock2.numCols), new DSubmatrixD1(dMatrixRBlock3, 0, dMatrixRBlock3.numRows, 0, dMatrixRBlock3.numCols));
    }

    public static void multTransA(DMatrixRBlock dMatrixRBlock, DMatrixRBlock dMatrixRBlock2, DMatrixRBlock dMatrixRBlock3) {
        if (dMatrixRBlock.numRows != dMatrixRBlock2.numRows) {
            throw new IllegalArgumentException("Rows in A are incompatible with rows in B");
        }
        if (dMatrixRBlock.numCols != dMatrixRBlock3.numRows) {
            throw new IllegalArgumentException("Columns in A are incompatible with rows in C");
        }
        if (dMatrixRBlock2.numCols != dMatrixRBlock3.numCols) {
            throw new IllegalArgumentException("Columns in B are incompatible with columns in C");
        }
        if (dMatrixRBlock.blockLength != dMatrixRBlock2.blockLength || dMatrixRBlock.blockLength != dMatrixRBlock3.blockLength) {
            throw new IllegalArgumentException("Block lengths are not all the same.");
        }
        MatrixMult_DDRB.multTransA(dMatrixRBlock.blockLength, new DSubmatrixD1(dMatrixRBlock, 0, dMatrixRBlock.numRows, 0, dMatrixRBlock.numCols), new DSubmatrixD1(dMatrixRBlock2, 0, dMatrixRBlock2.numRows, 0, dMatrixRBlock2.numCols), new DSubmatrixD1(dMatrixRBlock3, 0, dMatrixRBlock3.numRows, 0, dMatrixRBlock3.numCols));
    }

    public static void multTransB(DMatrixRBlock dMatrixRBlock, DMatrixRBlock dMatrixRBlock2, DMatrixRBlock dMatrixRBlock3) {
        if (dMatrixRBlock.numCols != dMatrixRBlock2.numCols) {
            throw new IllegalArgumentException("Columns in A are incompatible with columns in B");
        }
        if (dMatrixRBlock.numRows != dMatrixRBlock3.numRows) {
            throw new IllegalArgumentException("Rows in A are incompatible with rows in C");
        }
        if (dMatrixRBlock2.numRows != dMatrixRBlock3.numCols) {
            throw new IllegalArgumentException("Rows in B are incompatible with columns in C");
        }
        if (dMatrixRBlock.blockLength != dMatrixRBlock2.blockLength || dMatrixRBlock.blockLength != dMatrixRBlock3.blockLength) {
            throw new IllegalArgumentException("Block lengths are not all the same.");
        }
        MatrixMult_DDRB.multTransB(dMatrixRBlock.blockLength, new DSubmatrixD1(dMatrixRBlock, 0, dMatrixRBlock.numRows, 0, dMatrixRBlock.numCols), new DSubmatrixD1(dMatrixRBlock2, 0, dMatrixRBlock2.numRows, 0, dMatrixRBlock2.numCols), new DSubmatrixD1(dMatrixRBlock3, 0, dMatrixRBlock3.numRows, 0, dMatrixRBlock3.numCols));
    }

    public static DMatrixRBlock transpose(DMatrixRBlock dMatrixRBlock, DMatrixRBlock dMatrixRBlock2) {
        if (dMatrixRBlock2 != null) {
            if (dMatrixRBlock.numRows != dMatrixRBlock2.numCols || dMatrixRBlock.numCols != dMatrixRBlock2.numRows) {
                throw new IllegalArgumentException("Incompatible dimensions.");
            }
            if (dMatrixRBlock.blockLength != dMatrixRBlock2.blockLength) {
                throw new IllegalArgumentException("Incompatible block size.");
            }
        } else {
            dMatrixRBlock2 = new DMatrixRBlock(dMatrixRBlock.numCols, dMatrixRBlock.numRows, dMatrixRBlock.blockLength);
        }
        DMatrixRBlock dMatrixRBlock3 = dMatrixRBlock2;
        int i = 0;
        while (i < dMatrixRBlock.numRows) {
            int iMin = Math.min(dMatrixRBlock.blockLength, dMatrixRBlock.numRows - i);
            int i2 = 0;
            while (i2 < dMatrixRBlock.numCols) {
                int iMin2 = Math.min(dMatrixRBlock.blockLength, dMatrixRBlock.numCols - i2);
                DMatrixRBlock dMatrixRBlock4 = dMatrixRBlock;
                transposeBlock(dMatrixRBlock4, dMatrixRBlock3, (dMatrixRBlock.numCols * i) + (iMin * i2), (dMatrixRBlock3.numCols * i2) + (iMin2 * i), iMin2, iMin);
                i2 += dMatrixRBlock4.blockLength;
                dMatrixRBlock = dMatrixRBlock4;
            }
            DMatrixRBlock dMatrixRBlock5 = dMatrixRBlock;
            i += dMatrixRBlock5.blockLength;
            dMatrixRBlock = dMatrixRBlock5;
        }
        return dMatrixRBlock3;
    }

    private static void transposeBlock(DMatrixRBlock dMatrixRBlock, DMatrixRBlock dMatrixRBlock2, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i2 + i5;
            int i7 = (i3 * i5) + i;
            int i8 = i7 + i3;
            while (i7 < i8) {
                dMatrixRBlock2.data[i6] = dMatrixRBlock.data[i7];
                i6 += i4;
                i7++;
            }
        }
    }

    public static DMatrixRBlock createRandom(int i, int i2, double d, double d2, Random random) {
        DMatrixRBlock dMatrixRBlock = new DMatrixRBlock(i, i2);
        RandomMatrices_DDRM.fillUniform(dMatrixRBlock, d, d2, random);
        return dMatrixRBlock;
    }

    public static DMatrixRBlock createRandom(int i, int i2, double d, double d2, Random random, int i3) {
        DMatrixRBlock dMatrixRBlock = new DMatrixRBlock(i, i2, i3);
        RandomMatrices_DDRM.fillUniform(dMatrixRBlock, d, d2, random);
        return dMatrixRBlock;
    }

    public static DMatrixRBlock convert(DMatrixRMaj dMatrixRMaj, int i) {
        DMatrixRBlock dMatrixRBlock = new DMatrixRBlock(dMatrixRMaj.numRows, dMatrixRMaj.numCols, i);
        convert(dMatrixRMaj, dMatrixRBlock);
        return dMatrixRBlock;
    }

    public static DMatrixRBlock convert(DMatrixRMaj dMatrixRMaj) {
        DMatrixRBlock dMatrixRBlock = new DMatrixRBlock(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        convert(dMatrixRMaj, dMatrixRBlock);
        return dMatrixRBlock;
    }

    public static boolean isEquals(DMatrixRBlock dMatrixRBlock, DMatrixRBlock dMatrixRBlock2) {
        if (dMatrixRBlock.blockLength != dMatrixRBlock2.blockLength) {
            return false;
        }
        return MatrixFeatures_DDRM.isEquals(dMatrixRBlock, dMatrixRBlock2);
    }

    public static boolean isEquals(DMatrixRBlock dMatrixRBlock, DMatrixRBlock dMatrixRBlock2, double d) {
        if (dMatrixRBlock.blockLength != dMatrixRBlock2.blockLength) {
            return false;
        }
        return MatrixFeatures_DDRM.isEquals(dMatrixRBlock, dMatrixRBlock2, d);
    }

    public static void zeroTriangle(boolean z, DMatrixRBlock dMatrixRBlock) {
        int i = dMatrixRBlock.blockLength;
        if (z) {
            for (int i2 = 0; i2 < dMatrixRBlock.numRows; i2 += i) {
                int iMin = Math.min(i, dMatrixRBlock.numRows - i2);
                for (int i3 = i2; i3 < dMatrixRBlock.numCols; i3 += i) {
                    int iMin2 = Math.min(i, dMatrixRBlock.numCols - i3);
                    int i4 = (dMatrixRBlock.numCols * i2) + (iMin * i3);
                    if (i3 == i2) {
                        int i5 = 0;
                        while (i5 < iMin) {
                            int i6 = i5 + 1;
                            for (int i7 = i6; i7 < iMin2; i7++) {
                                dMatrixRBlock.data[(iMin2 * i5) + i4 + i7] = 0.0d;
                            }
                            i5 = i6;
                        }
                    } else {
                        for (int i8 = 0; i8 < iMin; i8++) {
                            for (int i9 = 0; i9 < iMin2; i9++) {
                                dMatrixRBlock.data[(iMin2 * i8) + i4 + i9] = 0.0d;
                            }
                        }
                    }
                }
            }
            return;
        }
        for (int i10 = 0; i10 < dMatrixRBlock.numRows; i10 += i) {
            int iMin3 = Math.min(i, dMatrixRBlock.numRows - i10);
            for (int i11 = 0; i11 <= i10; i11 += i) {
                int iMin4 = Math.min(i, dMatrixRBlock.numCols - i11);
                int i12 = (dMatrixRBlock.numCols * i10) + (iMin3 * i11);
                if (i11 == i10) {
                    for (int i13 = 0; i13 < iMin3; i13++) {
                        int iMin5 = Math.min(i13, iMin4);
                        for (int i14 = 0; i14 < iMin5; i14++) {
                            dMatrixRBlock.data[(iMin4 * i13) + i12 + i14] = 0.0d;
                        }
                    }
                } else {
                    for (int i15 = 0; i15 < iMin3; i15++) {
                        for (int i16 = 0; i16 < iMin4; i16++) {
                            dMatrixRBlock.data[(iMin4 * i15) + i12 + i16] = 0.0d;
                        }
                    }
                }
            }
        }
    }

    public static void copyTriangle(boolean z, DMatrixRBlock dMatrixRBlock, DMatrixRBlock dMatrixRBlock2) {
        int i;
        int i2;
        if (dMatrixRBlock.blockLength != dMatrixRBlock2.blockLength) {
            throw new IllegalArgumentException("Block size is different");
        }
        if (dMatrixRBlock.numRows < dMatrixRBlock2.numRows) {
            throw new IllegalArgumentException("The src has fewer rows than dst");
        }
        if (dMatrixRBlock.numCols < dMatrixRBlock2.numCols) {
            throw new IllegalArgumentException("The src has fewer columns than dst");
        }
        int i3 = dMatrixRBlock.blockLength;
        int iMin = Math.min(dMatrixRBlock.numRows, dMatrixRBlock2.numRows);
        int iMin2 = Math.min(dMatrixRBlock.numCols, dMatrixRBlock2.numCols);
        if (z) {
            for (int i4 = 0; i4 < iMin; i4 += i3) {
                int iMin3 = Math.min(i3, dMatrixRBlock.numRows - i4);
                int iMin4 = Math.min(i3, dMatrixRBlock2.numRows - i4);
                int i5 = i4;
                while (i5 < iMin2) {
                    int iMin5 = Math.min(i3, dMatrixRBlock.numCols - i5);
                    int iMin6 = Math.min(i3, dMatrixRBlock2.numCols - i5);
                    int i6 = (dMatrixRBlock.numCols * i4) + (iMin3 * i5);
                    int i7 = (dMatrixRBlock2.numCols * i4) + (iMin4 * i5);
                    if (i5 == i4) {
                        for (int i8 = 0; i8 < iMin4; i8++) {
                            int i9 = i8;
                            while (i9 < iMin6) {
                                dMatrixRBlock2.data[i7 + (iMin6 * i8) + i9] = dMatrixRBlock.data[i6 + (iMin5 * i8) + i9];
                                i9++;
                                iMin2 = iMin2;
                            }
                        }
                        i2 = iMin2;
                    } else {
                        i2 = iMin2;
                        for (int i10 = 0; i10 < iMin4; i10++) {
                            System.arraycopy(dMatrixRBlock.data, (iMin5 * i10) + i6, dMatrixRBlock2.data, i7 + (iMin6 * i10), iMin6);
                        }
                    }
                    i5 += i3;
                    iMin2 = i2;
                }
            }
            return;
        }
        for (int i11 = 0; i11 < iMin; i11 += i3) {
            int iMin7 = Math.min(i3, dMatrixRBlock.numRows - i11);
            int iMin8 = Math.min(i3, dMatrixRBlock2.numRows - i11);
            int i12 = 0;
            while (i12 <= i11) {
                int iMin9 = Math.min(i3, dMatrixRBlock.numCols - i12);
                int iMin10 = Math.min(i3, dMatrixRBlock2.numCols - i12);
                int i13 = (dMatrixRBlock.numCols * i11) + (iMin7 * i12);
                int i14 = (dMatrixRBlock2.numCols * i11) + (iMin8 * i12);
                if (i12 == i11) {
                    int i15 = 0;
                    while (i15 < iMin8) {
                        int i16 = i15 + 1;
                        int iMin11 = Math.min(i16, iMin10);
                        int i17 = 0;
                        while (i17 < iMin11) {
                            dMatrixRBlock2.data[i14 + (iMin10 * i15) + i17] = dMatrixRBlock.data[i13 + (iMin9 * i15) + i17];
                            i17++;
                            i3 = i3;
                        }
                        i15 = i16;
                    }
                    i = i3;
                } else {
                    i = i3;
                    for (int i18 = 0; i18 < iMin8; i18++) {
                        System.arraycopy(dMatrixRBlock.data, (iMin9 * i18) + i13, dMatrixRBlock2.data, (iMin10 * i18) + i14, iMin10);
                    }
                }
                i12 += i;
                i3 = i;
            }
        }
    }

    public static void set(DMatrixRBlock dMatrixRBlock, double d) {
        CommonOps_DDRM.fill(dMatrixRBlock, d);
    }

    public static void setIdentity(DMatrixRBlock dMatrixRBlock) {
        int iMin = Math.min(dMatrixRBlock.numRows, dMatrixRBlock.numCols);
        CommonOps_DDRM.fill(dMatrixRBlock, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        int i = dMatrixRBlock.blockLength;
        for (int i2 = 0; i2 < iMin; i2 += i) {
            int iMin2 = Math.min(i, dMatrixRBlock.numRows - i2);
            int iMin3 = Math.min(i, dMatrixRBlock.numCols - i2);
            int i3 = (dMatrixRBlock.numCols * i2) + (iMin2 * i2);
            int iMin4 = Math.min(iMin2, iMin3);
            for (int i4 = 0; i4 < iMin4; i4++) {
                dMatrixRBlock.data[(i4 * iMin3) + i3 + i4] = 1.0d;
            }
        }
    }

    public static DMatrixRBlock identity(int i, int i2, int i3) {
        DMatrixRBlock dMatrixRBlock = new DMatrixRBlock(i, i2, i3);
        int iMin = Math.min(i, i2);
        int i4 = 0;
        while (i4 < iMin) {
            int iMin2 = Math.min(i3, dMatrixRBlock.numRows - i4);
            int iMin3 = Math.min(i3, dMatrixRBlock.numCols - i4);
            int i5 = (dMatrixRBlock.numCols * i4) + (iMin2 * i4);
            int iMin4 = Math.min(iMin2, iMin3);
            for (int i6 = 0; i6 < iMin4; i6++) {
                dMatrixRBlock.data[(i6 * iMin3) + i5 + i6] = 1.0d;
            }
            i4 += i3;
        }
        return dMatrixRBlock;
    }

    public static void checkIdenticalShape(DMatrixRBlock dMatrixRBlock, DMatrixRBlock dMatrixRBlock2) {
        if (dMatrixRBlock.blockLength != dMatrixRBlock2.blockLength) {
            throw new IllegalArgumentException("Block size is different");
        }
        if (dMatrixRBlock.numRows != dMatrixRBlock2.numRows) {
            throw new IllegalArgumentException("Number of rows is different");
        }
        if (dMatrixRBlock.numCols != dMatrixRBlock2.numCols) {
            throw new IllegalArgumentException("NUmber of columns is different");
        }
    }

    public static void extractAligned(DMatrixRBlock dMatrixRBlock, DMatrixRBlock dMatrixRBlock2) {
        DMatrixRBlock dMatrixRBlock3 = dMatrixRBlock;
        DMatrixRBlock dMatrixRBlock4 = dMatrixRBlock2;
        if (dMatrixRBlock3.blockLength != dMatrixRBlock4.blockLength) {
            throw new IllegalArgumentException("Block size is different");
        }
        if (dMatrixRBlock3.numRows < dMatrixRBlock4.numRows) {
            throw new IllegalArgumentException("The src has fewer rows than dst");
        }
        if (dMatrixRBlock3.numCols < dMatrixRBlock4.numCols) {
            throw new IllegalArgumentException("The src has fewer columns than dst");
        }
        int i = dMatrixRBlock3.blockLength;
        int iMin = Math.min(dMatrixRBlock3.numRows, dMatrixRBlock4.numRows);
        int iMin2 = Math.min(dMatrixRBlock3.numCols, dMatrixRBlock4.numCols);
        int i2 = 0;
        while (i2 < iMin) {
            int iMin3 = Math.min(i, dMatrixRBlock3.numRows - i2);
            int iMin4 = Math.min(i, dMatrixRBlock4.numRows - i2);
            int i3 = 0;
            while (i3 < iMin2) {
                int iMin5 = Math.min(i, dMatrixRBlock3.numCols - i3);
                int iMin6 = Math.min(i, dMatrixRBlock4.numCols - i3);
                int i4 = (dMatrixRBlock3.numCols * i2) + (iMin3 * i3);
                int i5 = (dMatrixRBlock4.numCols * i2) + (iMin4 * i3);
                int i6 = 0;
                while (i6 < iMin4) {
                    System.arraycopy(dMatrixRBlock3.data, i4 + (iMin5 * i6), dMatrixRBlock4.data, i5 + (iMin6 * i6), iMin6);
                    i6++;
                    dMatrixRBlock3 = dMatrixRBlock;
                    dMatrixRBlock4 = dMatrixRBlock2;
                }
                i3 += i;
                dMatrixRBlock3 = dMatrixRBlock;
                dMatrixRBlock4 = dMatrixRBlock2;
            }
            i2 += i;
            dMatrixRBlock3 = dMatrixRBlock;
            dMatrixRBlock4 = dMatrixRBlock2;
        }
    }

    public static boolean blockAligned(int i, DSubmatrixD1 dSubmatrixD1) {
        if (dSubmatrixD1.col0 % i != 0 || dSubmatrixD1.row0 % i != 0) {
            return false;
        }
        if (dSubmatrixD1.col1 % i == 0 || dSubmatrixD1.col1 == dSubmatrixD1.original.numCols) {
            return dSubmatrixD1.row1 % i == 0 || dSubmatrixD1.row1 == dSubmatrixD1.original.numRows;
        }
        return false;
    }
}
