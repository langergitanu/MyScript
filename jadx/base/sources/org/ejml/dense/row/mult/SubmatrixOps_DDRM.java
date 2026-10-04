package org.ejml.dense.row.mult;

import org.ejml.data.DMatrix1Row;

/* JADX INFO: loaded from: classes9.dex */
public class SubmatrixOps_DDRM {
    public static void setSubMatrix(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, int i, int i2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i5; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                dMatrix1Row2.set(i7 + i3, i8 + i4, dMatrix1Row.get(i7 + i, i8 + i2));
            }
        }
    }
}
