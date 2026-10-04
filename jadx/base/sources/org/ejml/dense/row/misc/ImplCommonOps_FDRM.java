package org.ejml.dense.row.misc;

import org.ejml.data.FMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class ImplCommonOps_FDRM {
    public static void extract(FMatrixRMaj fMatrixRMaj, int i, int i2, FMatrixRMaj fMatrixRMaj2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i5; i7++) {
            System.arraycopy(fMatrixRMaj.data, fMatrixRMaj.getIndex(i7 + i, i2), fMatrixRMaj2.data, fMatrixRMaj2.getIndex(i7 + i3, i4), i6);
        }
    }
}
