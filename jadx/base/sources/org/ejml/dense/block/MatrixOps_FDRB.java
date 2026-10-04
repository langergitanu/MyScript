package org.ejml.dense.block;

import java.util.Random;
import org.ejml.data.FMatrixRBlock;
import org.ejml.data.FMatrixRMaj;
import org.ejml.data.FSubmatrixD1;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.dense.row.MatrixFeatures_FDRM;
import org.ejml.dense.row.RandomMatrices_FDRM;
import org.ejml.ops.ConvertFMatrixStruct;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixOps_FDRB {
    public static void convert(FMatrixRMaj fMatrixRMaj, FMatrixRBlock fMatrixRBlock) {
        ConvertFMatrixStruct.convert(fMatrixRMaj, fMatrixRBlock);
    }

    public static void convertRowToBlock(int i, int i2, int i3, float[] fArr, float[] fArr2) {
        int iMin = Math.min(i3, i) * i2;
        if (fArr2.length < iMin) {
            throw new IllegalArgumentException("tmp must be at least " + iMin + " long ");
        }
        int i4 = 0;
        while (i4 < i) {
            int iMin2 = Math.min(i3, i - i4);
            int i5 = i4 * i2;
            System.arraycopy(fArr, i5, fArr2, 0, iMin2 * i2);
            int i6 = 0;
            while (i6 < i2) {
                int iMin3 = Math.min(i3, i2 - i6);
                int i7 = (iMin2 * i6) + i5;
                int i8 = i6;
                for (int i9 = 0; i9 < iMin2; i9++) {
                    System.arraycopy(fArr2, i8, fArr, i7, iMin3);
                    i7 += iMin3;
                    i8 += i2;
                }
                i6 += i3;
            }
            i4 += i3;
        }
    }

    public static FMatrixRMaj convert(FMatrixRBlock fMatrixRBlock, FMatrixRMaj fMatrixRMaj) {
        return ConvertFMatrixStruct.convert(fMatrixRBlock, fMatrixRMaj);
    }

    public static void convertBlockToRow(int i, int i2, int i3, float[] fArr, float[] fArr2) {
        int iMin = Math.min(i3, i) * i2;
        if (fArr2.length < iMin) {
            throw new IllegalArgumentException("tmp must be at least " + iMin + " long and not " + fArr2.length);
        }
        int i4 = 0;
        while (i4 < i) {
            int iMin2 = Math.min(i3, i - i4);
            int i5 = i4 * i2;
            System.arraycopy(fArr, i5, fArr2, 0, iMin2 * i2);
            int i6 = 0;
            while (i6 < i2) {
                int iMin3 = Math.min(i3, i2 - i6);
                int i7 = iMin2 * i6;
                int i8 = i5 + i6;
                for (int i9 = 0; i9 < iMin2; i9++) {
                    System.arraycopy(fArr2, i7, fArr, i8, iMin3);
                    i7 += iMin3;
                    i8 += i2;
                }
                i6 += i3;
            }
            i4 += i3;
        }
    }

    public static void convertTranSrc(FMatrixRMaj fMatrixRMaj, FMatrixRBlock fMatrixRBlock) {
        if (fMatrixRMaj.numRows != fMatrixRBlock.numCols || fMatrixRMaj.numCols != fMatrixRBlock.numRows) {
            throw new IllegalArgumentException("Incompatible matrix shapes.");
        }
        int i = 0;
        while (i < fMatrixRBlock.numRows) {
            int iMin = Math.min(fMatrixRBlock.blockLength, fMatrixRBlock.numRows - i);
            int i2 = 0;
            while (i2 < fMatrixRBlock.numCols) {
                int iMin2 = Math.min(fMatrixRBlock.blockLength, fMatrixRBlock.numCols - i2);
                int i3 = (fMatrixRBlock.numCols * i) + (iMin * i2);
                int i4 = (fMatrixRMaj.numCols * i2) + i;
                for (int i5 = 0; i5 < iMin2; i5++) {
                    int i6 = (fMatrixRMaj.numCols * i5) + i4;
                    int i7 = i3 + i5;
                    int i8 = 0;
                    while (i8 < iMin) {
                        fMatrixRBlock.data[i7] = fMatrixRMaj.data[i6];
                        i8++;
                        i7 += iMin2;
                        i6++;
                    }
                }
                i2 += fMatrixRBlock.blockLength;
            }
            i += fMatrixRBlock.blockLength;
        }
    }

    public static void mult(FMatrixRBlock fMatrixRBlock, FMatrixRBlock fMatrixRBlock2, FMatrixRBlock fMatrixRBlock3) {
        if (fMatrixRBlock.numCols != fMatrixRBlock2.numRows) {
            throw new IllegalArgumentException("Columns in A are incompatible with rows in B");
        }
        if (fMatrixRBlock.numRows != fMatrixRBlock3.numRows) {
            throw new IllegalArgumentException("Rows in A are incompatible with rows in C");
        }
        if (fMatrixRBlock2.numCols != fMatrixRBlock3.numCols) {
            throw new IllegalArgumentException("Columns in B are incompatible with columns in C");
        }
        if (fMatrixRBlock.blockLength != fMatrixRBlock2.blockLength || fMatrixRBlock.blockLength != fMatrixRBlock3.blockLength) {
            throw new IllegalArgumentException("Block lengths are not all the same.");
        }
        MatrixMult_FDRB.mult(fMatrixRBlock.blockLength, new FSubmatrixD1(fMatrixRBlock, 0, fMatrixRBlock.numRows, 0, fMatrixRBlock.numCols), new FSubmatrixD1(fMatrixRBlock2, 0, fMatrixRBlock2.numRows, 0, fMatrixRBlock2.numCols), new FSubmatrixD1(fMatrixRBlock3, 0, fMatrixRBlock3.numRows, 0, fMatrixRBlock3.numCols));
    }

    public static void multTransA(FMatrixRBlock fMatrixRBlock, FMatrixRBlock fMatrixRBlock2, FMatrixRBlock fMatrixRBlock3) {
        if (fMatrixRBlock.numRows != fMatrixRBlock2.numRows) {
            throw new IllegalArgumentException("Rows in A are incompatible with rows in B");
        }
        if (fMatrixRBlock.numCols != fMatrixRBlock3.numRows) {
            throw new IllegalArgumentException("Columns in A are incompatible with rows in C");
        }
        if (fMatrixRBlock2.numCols != fMatrixRBlock3.numCols) {
            throw new IllegalArgumentException("Columns in B are incompatible with columns in C");
        }
        if (fMatrixRBlock.blockLength != fMatrixRBlock2.blockLength || fMatrixRBlock.blockLength != fMatrixRBlock3.blockLength) {
            throw new IllegalArgumentException("Block lengths are not all the same.");
        }
        MatrixMult_FDRB.multTransA(fMatrixRBlock.blockLength, new FSubmatrixD1(fMatrixRBlock, 0, fMatrixRBlock.numRows, 0, fMatrixRBlock.numCols), new FSubmatrixD1(fMatrixRBlock2, 0, fMatrixRBlock2.numRows, 0, fMatrixRBlock2.numCols), new FSubmatrixD1(fMatrixRBlock3, 0, fMatrixRBlock3.numRows, 0, fMatrixRBlock3.numCols));
    }

    public static void multTransB(FMatrixRBlock fMatrixRBlock, FMatrixRBlock fMatrixRBlock2, FMatrixRBlock fMatrixRBlock3) {
        if (fMatrixRBlock.numCols != fMatrixRBlock2.numCols) {
            throw new IllegalArgumentException("Columns in A are incompatible with columns in B");
        }
        if (fMatrixRBlock.numRows != fMatrixRBlock3.numRows) {
            throw new IllegalArgumentException("Rows in A are incompatible with rows in C");
        }
        if (fMatrixRBlock2.numRows != fMatrixRBlock3.numCols) {
            throw new IllegalArgumentException("Rows in B are incompatible with columns in C");
        }
        if (fMatrixRBlock.blockLength != fMatrixRBlock2.blockLength || fMatrixRBlock.blockLength != fMatrixRBlock3.blockLength) {
            throw new IllegalArgumentException("Block lengths are not all the same.");
        }
        MatrixMult_FDRB.multTransB(fMatrixRBlock.blockLength, new FSubmatrixD1(fMatrixRBlock, 0, fMatrixRBlock.numRows, 0, fMatrixRBlock.numCols), new FSubmatrixD1(fMatrixRBlock2, 0, fMatrixRBlock2.numRows, 0, fMatrixRBlock2.numCols), new FSubmatrixD1(fMatrixRBlock3, 0, fMatrixRBlock3.numRows, 0, fMatrixRBlock3.numCols));
    }

    public static FMatrixRBlock transpose(FMatrixRBlock fMatrixRBlock, FMatrixRBlock fMatrixRBlock2) {
        if (fMatrixRBlock2 != null) {
            if (fMatrixRBlock.numRows != fMatrixRBlock2.numCols || fMatrixRBlock.numCols != fMatrixRBlock2.numRows) {
                throw new IllegalArgumentException("Incompatible dimensions.");
            }
            if (fMatrixRBlock.blockLength != fMatrixRBlock2.blockLength) {
                throw new IllegalArgumentException("Incompatible block size.");
            }
        } else {
            fMatrixRBlock2 = new FMatrixRBlock(fMatrixRBlock.numCols, fMatrixRBlock.numRows, fMatrixRBlock.blockLength);
        }
        FMatrixRBlock fMatrixRBlock3 = fMatrixRBlock2;
        int i = 0;
        while (i < fMatrixRBlock.numRows) {
            int iMin = Math.min(fMatrixRBlock.blockLength, fMatrixRBlock.numRows - i);
            int i2 = 0;
            while (i2 < fMatrixRBlock.numCols) {
                int iMin2 = Math.min(fMatrixRBlock.blockLength, fMatrixRBlock.numCols - i2);
                FMatrixRBlock fMatrixRBlock4 = fMatrixRBlock;
                transposeBlock(fMatrixRBlock4, fMatrixRBlock3, (fMatrixRBlock.numCols * i) + (iMin * i2), (fMatrixRBlock3.numCols * i2) + (iMin2 * i), iMin2, iMin);
                i2 += fMatrixRBlock4.blockLength;
                fMatrixRBlock = fMatrixRBlock4;
            }
            FMatrixRBlock fMatrixRBlock5 = fMatrixRBlock;
            i += fMatrixRBlock5.blockLength;
            fMatrixRBlock = fMatrixRBlock5;
        }
        return fMatrixRBlock3;
    }

    private static void transposeBlock(FMatrixRBlock fMatrixRBlock, FMatrixRBlock fMatrixRBlock2, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i2 + i5;
            int i7 = (i3 * i5) + i;
            int i8 = i7 + i3;
            while (i7 < i8) {
                fMatrixRBlock2.data[i6] = fMatrixRBlock.data[i7];
                i6 += i4;
                i7++;
            }
        }
    }

    public static FMatrixRBlock createRandom(int i, int i2, float f, float f2, Random random) {
        FMatrixRBlock fMatrixRBlock = new FMatrixRBlock(i, i2);
        RandomMatrices_FDRM.fillUniform(fMatrixRBlock, f, f2, random);
        return fMatrixRBlock;
    }

    public static FMatrixRBlock createRandom(int i, int i2, float f, float f2, Random random, int i3) {
        FMatrixRBlock fMatrixRBlock = new FMatrixRBlock(i, i2, i3);
        RandomMatrices_FDRM.fillUniform(fMatrixRBlock, f, f2, random);
        return fMatrixRBlock;
    }

    public static FMatrixRBlock convert(FMatrixRMaj fMatrixRMaj, int i) {
        FMatrixRBlock fMatrixRBlock = new FMatrixRBlock(fMatrixRMaj.numRows, fMatrixRMaj.numCols, i);
        convert(fMatrixRMaj, fMatrixRBlock);
        return fMatrixRBlock;
    }

    public static FMatrixRBlock convert(FMatrixRMaj fMatrixRMaj) {
        FMatrixRBlock fMatrixRBlock = new FMatrixRBlock(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        convert(fMatrixRMaj, fMatrixRBlock);
        return fMatrixRBlock;
    }

    public static boolean isEquals(FMatrixRBlock fMatrixRBlock, FMatrixRBlock fMatrixRBlock2) {
        if (fMatrixRBlock.blockLength != fMatrixRBlock2.blockLength) {
            return false;
        }
        return MatrixFeatures_FDRM.isEquals(fMatrixRBlock, fMatrixRBlock2);
    }

    public static boolean isEquals(FMatrixRBlock fMatrixRBlock, FMatrixRBlock fMatrixRBlock2, float f) {
        if (fMatrixRBlock.blockLength != fMatrixRBlock2.blockLength) {
            return false;
        }
        return MatrixFeatures_FDRM.isEquals(fMatrixRBlock, fMatrixRBlock2, f);
    }

    public static void zeroTriangle(boolean z, FMatrixRBlock fMatrixRBlock) {
        int i = fMatrixRBlock.blockLength;
        if (z) {
            for (int i2 = 0; i2 < fMatrixRBlock.numRows; i2 += i) {
                int iMin = Math.min(i, fMatrixRBlock.numRows - i2);
                for (int i3 = i2; i3 < fMatrixRBlock.numCols; i3 += i) {
                    int iMin2 = Math.min(i, fMatrixRBlock.numCols - i3);
                    int i4 = (fMatrixRBlock.numCols * i2) + (iMin * i3);
                    if (i3 == i2) {
                        int i5 = 0;
                        while (i5 < iMin) {
                            int i6 = i5 + 1;
                            for (int i7 = i6; i7 < iMin2; i7++) {
                                fMatrixRBlock.data[(iMin2 * i5) + i4 + i7] = 0.0f;
                            }
                            i5 = i6;
                        }
                    } else {
                        for (int i8 = 0; i8 < iMin; i8++) {
                            for (int i9 = 0; i9 < iMin2; i9++) {
                                fMatrixRBlock.data[(iMin2 * i8) + i4 + i9] = 0.0f;
                            }
                        }
                    }
                }
            }
            return;
        }
        for (int i10 = 0; i10 < fMatrixRBlock.numRows; i10 += i) {
            int iMin3 = Math.min(i, fMatrixRBlock.numRows - i10);
            for (int i11 = 0; i11 <= i10; i11 += i) {
                int iMin4 = Math.min(i, fMatrixRBlock.numCols - i11);
                int i12 = (fMatrixRBlock.numCols * i10) + (iMin3 * i11);
                if (i11 == i10) {
                    for (int i13 = 0; i13 < iMin3; i13++) {
                        int iMin5 = Math.min(i13, iMin4);
                        for (int i14 = 0; i14 < iMin5; i14++) {
                            fMatrixRBlock.data[(iMin4 * i13) + i12 + i14] = 0.0f;
                        }
                    }
                } else {
                    for (int i15 = 0; i15 < iMin3; i15++) {
                        for (int i16 = 0; i16 < iMin4; i16++) {
                            fMatrixRBlock.data[(iMin4 * i15) + i12 + i16] = 0.0f;
                        }
                    }
                }
            }
        }
    }

    public static void copyTriangle(boolean z, FMatrixRBlock fMatrixRBlock, FMatrixRBlock fMatrixRBlock2) {
        int i;
        int i2;
        if (fMatrixRBlock.blockLength != fMatrixRBlock2.blockLength) {
            throw new IllegalArgumentException("Block size is different");
        }
        if (fMatrixRBlock.numRows < fMatrixRBlock2.numRows) {
            throw new IllegalArgumentException("The src has fewer rows than dst");
        }
        if (fMatrixRBlock.numCols < fMatrixRBlock2.numCols) {
            throw new IllegalArgumentException("The src has fewer columns than dst");
        }
        int i3 = fMatrixRBlock.blockLength;
        int iMin = Math.min(fMatrixRBlock.numRows, fMatrixRBlock2.numRows);
        int iMin2 = Math.min(fMatrixRBlock.numCols, fMatrixRBlock2.numCols);
        if (z) {
            for (int i4 = 0; i4 < iMin; i4 += i3) {
                int iMin3 = Math.min(i3, fMatrixRBlock.numRows - i4);
                int iMin4 = Math.min(i3, fMatrixRBlock2.numRows - i4);
                int i5 = i4;
                while (i5 < iMin2) {
                    int iMin5 = Math.min(i3, fMatrixRBlock.numCols - i5);
                    int iMin6 = Math.min(i3, fMatrixRBlock2.numCols - i5);
                    int i6 = (fMatrixRBlock.numCols * i4) + (iMin3 * i5);
                    int i7 = (fMatrixRBlock2.numCols * i4) + (iMin4 * i5);
                    if (i5 == i4) {
                        for (int i8 = 0; i8 < iMin4; i8++) {
                            int i9 = i8;
                            while (i9 < iMin6) {
                                fMatrixRBlock2.data[i7 + (iMin6 * i8) + i9] = fMatrixRBlock.data[i6 + (iMin5 * i8) + i9];
                                i9++;
                                iMin2 = iMin2;
                            }
                        }
                        i2 = iMin2;
                    } else {
                        i2 = iMin2;
                        for (int i10 = 0; i10 < iMin4; i10++) {
                            System.arraycopy(fMatrixRBlock.data, (iMin5 * i10) + i6, fMatrixRBlock2.data, i7 + (iMin6 * i10), iMin6);
                        }
                    }
                    i5 += i3;
                    iMin2 = i2;
                }
            }
            return;
        }
        for (int i11 = 0; i11 < iMin; i11 += i3) {
            int iMin7 = Math.min(i3, fMatrixRBlock.numRows - i11);
            int iMin8 = Math.min(i3, fMatrixRBlock2.numRows - i11);
            int i12 = 0;
            while (i12 <= i11) {
                int iMin9 = Math.min(i3, fMatrixRBlock.numCols - i12);
                int iMin10 = Math.min(i3, fMatrixRBlock2.numCols - i12);
                int i13 = (fMatrixRBlock.numCols * i11) + (iMin7 * i12);
                int i14 = (fMatrixRBlock2.numCols * i11) + (iMin8 * i12);
                if (i12 == i11) {
                    int i15 = 0;
                    while (i15 < iMin8) {
                        int i16 = i15 + 1;
                        int iMin11 = Math.min(i16, iMin10);
                        int i17 = 0;
                        while (i17 < iMin11) {
                            fMatrixRBlock2.data[i14 + (iMin10 * i15) + i17] = fMatrixRBlock.data[i13 + (iMin9 * i15) + i17];
                            i17++;
                            i3 = i3;
                        }
                        i15 = i16;
                    }
                    i = i3;
                } else {
                    i = i3;
                    for (int i18 = 0; i18 < iMin8; i18++) {
                        System.arraycopy(fMatrixRBlock.data, (iMin9 * i18) + i13, fMatrixRBlock2.data, (iMin10 * i18) + i14, iMin10);
                    }
                }
                i12 += i;
                i3 = i;
            }
        }
    }

    public static void set(FMatrixRBlock fMatrixRBlock, float f) {
        CommonOps_FDRM.fill(fMatrixRBlock, f);
    }

    public static void setIdentity(FMatrixRBlock fMatrixRBlock) {
        int iMin = Math.min(fMatrixRBlock.numRows, fMatrixRBlock.numCols);
        CommonOps_FDRM.fill(fMatrixRBlock, 0.0f);
        int i = fMatrixRBlock.blockLength;
        for (int i2 = 0; i2 < iMin; i2 += i) {
            int iMin2 = Math.min(i, fMatrixRBlock.numRows - i2);
            int iMin3 = Math.min(i, fMatrixRBlock.numCols - i2);
            int i3 = (fMatrixRBlock.numCols * i2) + (iMin2 * i2);
            int iMin4 = Math.min(iMin2, iMin3);
            for (int i4 = 0; i4 < iMin4; i4++) {
                fMatrixRBlock.data[(i4 * iMin3) + i3 + i4] = 1.0f;
            }
        }
    }

    public static FMatrixRBlock identity(int i, int i2, int i3) {
        FMatrixRBlock fMatrixRBlock = new FMatrixRBlock(i, i2, i3);
        int iMin = Math.min(i, i2);
        int i4 = 0;
        while (i4 < iMin) {
            int iMin2 = Math.min(i3, fMatrixRBlock.numRows - i4);
            int iMin3 = Math.min(i3, fMatrixRBlock.numCols - i4);
            int i5 = (fMatrixRBlock.numCols * i4) + (iMin2 * i4);
            int iMin4 = Math.min(iMin2, iMin3);
            for (int i6 = 0; i6 < iMin4; i6++) {
                fMatrixRBlock.data[(i6 * iMin3) + i5 + i6] = 1.0f;
            }
            i4 += i3;
        }
        return fMatrixRBlock;
    }

    public static void checkIdenticalShape(FMatrixRBlock fMatrixRBlock, FMatrixRBlock fMatrixRBlock2) {
        if (fMatrixRBlock.blockLength != fMatrixRBlock2.blockLength) {
            throw new IllegalArgumentException("Block size is different");
        }
        if (fMatrixRBlock.numRows != fMatrixRBlock2.numRows) {
            throw new IllegalArgumentException("Number of rows is different");
        }
        if (fMatrixRBlock.numCols != fMatrixRBlock2.numCols) {
            throw new IllegalArgumentException("NUmber of columns is different");
        }
    }

    public static void extractAligned(FMatrixRBlock fMatrixRBlock, FMatrixRBlock fMatrixRBlock2) {
        FMatrixRBlock fMatrixRBlock3 = fMatrixRBlock;
        FMatrixRBlock fMatrixRBlock4 = fMatrixRBlock2;
        if (fMatrixRBlock3.blockLength != fMatrixRBlock4.blockLength) {
            throw new IllegalArgumentException("Block size is different");
        }
        if (fMatrixRBlock3.numRows < fMatrixRBlock4.numRows) {
            throw new IllegalArgumentException("The src has fewer rows than dst");
        }
        if (fMatrixRBlock3.numCols < fMatrixRBlock4.numCols) {
            throw new IllegalArgumentException("The src has fewer columns than dst");
        }
        int i = fMatrixRBlock3.blockLength;
        int iMin = Math.min(fMatrixRBlock3.numRows, fMatrixRBlock4.numRows);
        int iMin2 = Math.min(fMatrixRBlock3.numCols, fMatrixRBlock4.numCols);
        int i2 = 0;
        while (i2 < iMin) {
            int iMin3 = Math.min(i, fMatrixRBlock3.numRows - i2);
            int iMin4 = Math.min(i, fMatrixRBlock4.numRows - i2);
            int i3 = 0;
            while (i3 < iMin2) {
                int iMin5 = Math.min(i, fMatrixRBlock3.numCols - i3);
                int iMin6 = Math.min(i, fMatrixRBlock4.numCols - i3);
                int i4 = (fMatrixRBlock3.numCols * i2) + (iMin3 * i3);
                int i5 = (fMatrixRBlock4.numCols * i2) + (iMin4 * i3);
                int i6 = 0;
                while (i6 < iMin4) {
                    System.arraycopy(fMatrixRBlock3.data, i4 + (iMin5 * i6), fMatrixRBlock4.data, i5 + (iMin6 * i6), iMin6);
                    i6++;
                    fMatrixRBlock3 = fMatrixRBlock;
                    fMatrixRBlock4 = fMatrixRBlock2;
                }
                i3 += i;
                fMatrixRBlock3 = fMatrixRBlock;
                fMatrixRBlock4 = fMatrixRBlock2;
            }
            i2 += i;
            fMatrixRBlock3 = fMatrixRBlock;
            fMatrixRBlock4 = fMatrixRBlock2;
        }
    }

    public static boolean blockAligned(int i, FSubmatrixD1 fSubmatrixD1) {
        if (fSubmatrixD1.col0 % i != 0 || fSubmatrixD1.row0 % i != 0) {
            return false;
        }
        if (fSubmatrixD1.col1 % i == 0 || fSubmatrixD1.col1 == fSubmatrixD1.original.numCols) {
            return fSubmatrixD1.row1 % i == 0 || fSubmatrixD1.row1 == fSubmatrixD1.original.numRows;
        }
        return false;
    }
}
