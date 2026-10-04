package org.ejml.sparse.triplet;

import java.util.Random;
import org.ejml.data.DMatrixSparseTriplet;

/* JADX INFO: loaded from: classes9.dex */
public class RandomMatrices_DSTL {
    public static DMatrixSparseTriplet uniform(int i, int i2, int i3, double d, double d2, Random random) {
        int i4 = i2 * i;
        if (i4 < 0) {
            throw new IllegalArgumentException("matrix size is too large");
        }
        int iMin = Math.min(i4, i3);
        int[] iArr = new int[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            iArr[i5] = i5;
        }
        for (int i6 = 0; i6 < iMin; i6++) {
            int iNextInt = random.nextInt(i4);
            int i7 = iArr[iNextInt];
            iArr[iNextInt] = iArr[i6];
            iArr[i6] = i7;
        }
        DMatrixSparseTriplet dMatrixSparseTriplet = new DMatrixSparseTriplet(i, i2, iMin);
        for (int i8 = 0; i8 < iMin; i8++) {
            int i9 = iArr[i8];
            dMatrixSparseTriplet.addItem(i9 / i2, i9 % i2, (random.nextDouble() * (d2 - d)) + d);
        }
        return dMatrixSparseTriplet;
    }
}
