package org.ejml.dense.row.misc;

import org.ejml.data.FMatrix;

/* JADX INFO: loaded from: classes9.dex */
public class ImplCommonOps_FDMA {
    public static void extract(FMatrix fMatrix, int i, int i2, FMatrix fMatrix2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i5; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                fMatrix2.set(i3 + i7, i4 + i8, fMatrix.get(i7 + i, i8 + i2));
            }
        }
    }
}
