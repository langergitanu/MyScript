package org.ejml.dense.row.mult;

import org.ejml.data.FMatrix1Row;

/* JADX INFO: loaded from: classes9.dex */
public class SubmatrixOps_FDRM {
    public static void setSubMatrix(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, int i, int i2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i5; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                fMatrix1Row2.set(i7 + i3, i8 + i4, fMatrix1Row.get(i7 + i, i8 + i2));
            }
        }
    }
}
