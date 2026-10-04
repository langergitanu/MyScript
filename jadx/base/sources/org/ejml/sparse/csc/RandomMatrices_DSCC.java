package org.ejml.sparse.csc;

import java.util.Arrays;
import java.util.Random;
import org.ejml.UtilEjml;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.data.DMatrixSparseTriplet;
import org.ejml.ops.ConvertDMatrixStruct;

/* JADX INFO: loaded from: classes9.dex */
public class RandomMatrices_DSCC {
    public static DMatrixSparseCSC rectangle(int i, int i2, int i3, double d, double d2, Random random) {
        int i4 = i2 * i;
        int iMin = Math.min(i4, i3);
        int[] iArrShuffled = UtilEjml.shuffled(i4, iMin, random);
        Arrays.sort(iArrShuffled, 0, iMin);
        DMatrixSparseCSC dMatrixSparseCSC = new DMatrixSparseCSC(i, i2, iMin);
        dMatrixSparseCSC.indicesSorted = true;
        int[] iArr = new int[i2];
        for (int i5 = 0; i5 < iMin; i5++) {
            int i6 = iArrShuffled[i5] / i;
            iArr[i6] = iArr[i6] + 1;
        }
        dMatrixSparseCSC.colsum(iArr);
        for (int i7 = 0; i7 < iMin; i7++) {
            dMatrixSparseCSC.nz_rows[i7] = iArrShuffled[i7] % i;
            dMatrixSparseCSC.nz_values[i7] = (random.nextDouble() * (d2 - d)) + d;
        }
        return dMatrixSparseCSC;
    }

    public static DMatrixSparseCSC rectangle(int i, int i2, int i3, Random random) {
        return rectangle(i, i2, i3, -1.0d, 1.0d, random);
    }

    public static DMatrixSparseCSC symmetric(int i, int i2, double d, double d2, Random random) {
        int i3 = ((i * i) + i) / 2;
        int[] iArr = new int[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = i5;
            while (i6 < i) {
                iArr[i4] = (i5 * i) + i6;
                i6++;
                i4++;
            }
        }
        UtilEjml.shuffle(iArr, i3, 0, i2, random);
        Arrays.sort(iArr, 0, i2);
        DMatrixSparseTriplet dMatrixSparseTriplet = new DMatrixSparseTriplet(i, i, i2 * 2);
        for (int i7 = 0; i7 < i2; i7++) {
            int i8 = iArr[i7];
            int i9 = i8 / i;
            int i10 = i8 % i;
            double dNextDouble = (random.nextDouble() * (d2 - d)) + d;
            if (i9 == i10) {
                dMatrixSparseTriplet.addItem(i9, i10, dNextDouble);
            } else {
                dMatrixSparseTriplet.addItem(i9, i10, dNextDouble);
                dMatrixSparseTriplet.addItem(i10, i9, dNextDouble);
            }
        }
        DMatrixSparseCSC dMatrixSparseCSC = new DMatrixSparseCSC(i, i, dMatrixSparseTriplet.nz_length);
        ConvertDMatrixStruct.convert(dMatrixSparseTriplet, dMatrixSparseCSC);
        return dMatrixSparseCSC;
    }

    public static DMatrixSparseCSC triangleLower(int i, int i2, int i3, double d, double d2, Random random) {
        int i4 = i - i2;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        int i5 = 0;
        int i6 = 0;
        while (i5 < i) {
            int i7 = i - 1;
            int i8 = i7 + i2;
            if (i5 < i8) {
                iArr[i5] = i6;
            }
            i6 += i5 < i2 ? i : (i7 - i5) + i2;
            if (i5 < i8) {
                iArr2[i5] = i6;
            }
            i5++;
        }
        int i9 = i6 + i4;
        int iMax = Math.max(i4, Math.min(i9, i3));
        int i10 = iMax - i4;
        int[] iArrShuffled = UtilEjml.shuffled(i9 - i4, i10, random);
        Arrays.sort(iArrShuffled, 0, i10);
        DMatrixSparseCSC dMatrixSparseCSC = new DMatrixSparseCSC(i, i, iMax);
        int[] iArr3 = new int[i];
        int i11 = 0;
        for (int i12 = 0; i12 < i; i12++) {
            if (i12 >= i2) {
                iArr3[i12] = iArr3[i12] + 1;
            }
            while (i11 < i10 && iArrShuffled[i11] < iArr2[i12]) {
                iArr3[i12] = iArr3[i12] + 1;
                i11++;
            }
        }
        dMatrixSparseCSC.colsum(iArr3);
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < i) {
            int i16 = i13 >= i2 ? (i13 - i2) + 1 : 0;
            if (i13 >= i2) {
                dMatrixSparseCSC.nz_rows[i14] = i13 - i2;
                int i17 = i14 + 1;
                dMatrixSparseCSC.nz_values[i14] = (random.nextDouble() * (d2 - d)) + d;
                i14 = i17;
            }
            while (i15 < i10) {
                int i18 = iArrShuffled[i15];
                if (i18 < iArr2[i13]) {
                    i15++;
                    dMatrixSparseCSC.nz_rows[i14] = (i18 - iArr[i13]) + i16;
                    int i19 = i14 + 1;
                    dMatrixSparseCSC.nz_values[i14] = (random.nextDouble() * (d2 - d)) + d;
                    i14 = i19;
                }
            }
            i13++;
        }
        return dMatrixSparseCSC;
    }

    public static DMatrixSparseCSC triangleUpper(int i, int i2, int i3, double d, double d2, Random random) {
        DMatrixSparseCSC dMatrixSparseCSCTriangleLower = triangleLower(i, i2, i3, d, d2, random);
        DMatrixSparseCSC dMatrixSparseCSCCreateLike = dMatrixSparseCSCTriangleLower.createLike();
        CommonOps_DSCC.transpose(dMatrixSparseCSCTriangleLower, dMatrixSparseCSCCreateLike, null);
        return dMatrixSparseCSCCreateLike;
    }

    public static int nonzero(int i, int i2, double d, double d2, Random random) {
        return (int) ((((double) (i * i2)) * ((random.nextDouble() * (d2 - d)) + d)) + 0.5d);
    }

    public static DMatrixSparseCSC triangle(boolean z, int i, double d, double d2, Random random) {
        int i2 = i - 1;
        int iNextDouble = ((int) (((double) ((i2 * i2) / 2)) * ((random.nextDouble() * (d2 - d)) + d))) + i;
        if (z) {
            return triangleUpper(i, 0, iNextDouble, -1.0d, 1.0d, random);
        }
        return triangleLower(i, 0, iNextDouble, -1.0d, 1.0d, random);
    }

    public static DMatrixSparseCSC symmetricPosDef(int i, int i2, Random random) {
        DMatrixSparseCSC dMatrixSparseCSCRectangle = rectangle(i, i, i2, random);
        for (int i3 = 0; i3 < i; i3++) {
            dMatrixSparseCSCRectangle.set(i3, i3, Math.max(0.5d, random.nextDouble()));
        }
        DMatrixSparseCSC dMatrixSparseCSC = new DMatrixSparseCSC(i, i, 0);
        CommonOps_DSCC.multTransB(dMatrixSparseCSCRectangle, dMatrixSparseCSCRectangle, dMatrixSparseCSC, null, null);
        return dMatrixSparseCSC;
    }

    public static void ensureNotSingular(DMatrixSparseCSC dMatrixSparseCSC, Random random) {
        int[] iArrShuffled = UtilEjml.shuffled(dMatrixSparseCSC.numRows, random);
        Arrays.sort(iArrShuffled);
        int iMin = Math.min(dMatrixSparseCSC.numCols, dMatrixSparseCSC.numRows);
        for (int i = 0; i < iMin; i++) {
            dMatrixSparseCSC.set(iArrShuffled[i], i, random.nextDouble() + 0.5d);
        }
    }
}
