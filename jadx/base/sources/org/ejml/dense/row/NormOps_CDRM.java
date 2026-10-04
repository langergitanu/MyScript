package org.ejml.dense.row;

import org.ejml.data.CMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class NormOps_CDRM {
    public static float normF(CMatrixRMaj cMatrixRMaj) {
        float fElementMaxAbs = CommonOps_CDRM.elementMaxAbs(cMatrixRMaj);
        float f = 0.0f;
        if (fElementMaxAbs == 0.0f) {
            return 0.0f;
        }
        int dataLength = cMatrixRMaj.getDataLength();
        for (int i = 0; i < dataLength; i += 2) {
            float f2 = cMatrixRMaj.data[i] / fElementMaxAbs;
            float f3 = cMatrixRMaj.data[i + 1] / fElementMaxAbs;
            f += (f2 * f2) + (f3 * f3);
        }
        return fElementMaxAbs * ((float) Math.sqrt(f));
    }
}
