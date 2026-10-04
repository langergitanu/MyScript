package org.ejml.dense.row;

import java.util.Random;
import org.ejml.data.CMatrixD1;
import org.ejml.data.CMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class RandomMatrices_CDRM {
    public static CMatrixRMaj rectangle(int i, int i2, Random random) {
        return rectangle(i, i2, -1.0f, 1.0f, random);
    }

    public static CMatrixRMaj rectangle(int i, int i2, float f, float f2, Random random) {
        CMatrixRMaj cMatrixRMaj = new CMatrixRMaj(i, i2);
        fillUniform(cMatrixRMaj, f, f2, random);
        return cMatrixRMaj;
    }

    public static void fillUniform(CMatrixRMaj cMatrixRMaj, Random random) {
        fillUniform(cMatrixRMaj, 0.0f, 1.0f, random);
    }

    public static void fillUniform(CMatrixD1 cMatrixD1, float f, float f2, Random random) {
        float[] data = cMatrixD1.getData();
        int dataLength = cMatrixD1.getDataLength();
        float f3 = f2 - f;
        for (int i = 0; i < dataLength; i++) {
            data[i] = (random.nextFloat() * f3) + f;
        }
    }

    public static CMatrixRMaj hermitianPosDef(int i, Random random) {
        CMatrixRMaj cMatrixRMajRectangle = rectangle(i, 1, random);
        CMatrixRMaj cMatrixRMaj = new CMatrixRMaj(1, i);
        CMatrixRMaj cMatrixRMaj2 = new CMatrixRMaj(i, i);
        CommonOps_CDRM.transposeConjugate(cMatrixRMajRectangle, cMatrixRMaj);
        CommonOps_CDRM.mult(cMatrixRMajRectangle, cMatrixRMaj, cMatrixRMaj2);
        for (int i2 = 0; i2 < i; i2++) {
            float[] fArr = cMatrixRMaj2.data;
            int i3 = ((i2 * i) + i2) * 2;
            fArr[i3] = fArr[i3] + 1.0f;
        }
        return cMatrixRMaj2;
    }

    public static CMatrixRMaj hermitian(int i, float f, float f2, Random random) {
        CMatrixRMaj cMatrixRMaj = new CMatrixRMaj(i, i);
        fillHermitian(cMatrixRMaj, f, f2, random);
        return cMatrixRMaj;
    }

    public static void fillHermitian(CMatrixRMaj cMatrixRMaj, float f, float f2, Random random) {
        if (cMatrixRMaj.numRows != cMatrixRMaj.numCols) {
            throw new IllegalArgumentException("A must be a square matrix");
        }
        float f3 = f2 - f;
        int i = cMatrixRMaj.numRows;
        int i2 = 0;
        while (i2 < i) {
            cMatrixRMaj.set(i2, i2, (random.nextFloat() * f3) + f, 0.0f);
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < i; i4++) {
                float fNextFloat = (random.nextFloat() * f3) + f;
                float fNextFloat2 = (random.nextFloat() * f3) + f;
                cMatrixRMaj.set(i2, i4, fNextFloat, fNextFloat2);
                cMatrixRMaj.set(i4, i2, fNextFloat, -fNextFloat2);
            }
            i2 = i3;
        }
    }
}
