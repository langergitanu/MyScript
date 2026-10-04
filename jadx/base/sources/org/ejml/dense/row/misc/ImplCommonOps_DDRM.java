package org.ejml.dense.row.misc;

import org.ejml.data.DMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class ImplCommonOps_DDRM {
    public static void extract(DMatrixRMaj dMatrixRMaj, int i, int i2, DMatrixRMaj dMatrixRMaj2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i5; i7++) {
            System.arraycopy(dMatrixRMaj.data, dMatrixRMaj.getIndex(i7 + i, i2), dMatrixRMaj2.data, dMatrixRMaj2.getIndex(i7 + i3, i4), i6);
        }
    }
}
