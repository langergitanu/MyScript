package org.ejml.dense.row.misc;

import org.ejml.data.DMatrix;

/* JADX INFO: loaded from: classes9.dex */
public class ImplCommonOps_DDMA {
    public static void extract(DMatrix dMatrix, int i, int i2, DMatrix dMatrix2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i5; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                dMatrix2.set(i3 + i7, i4 + i8, dMatrix.get(i7 + i, i8 + i2));
            }
        }
    }
}
