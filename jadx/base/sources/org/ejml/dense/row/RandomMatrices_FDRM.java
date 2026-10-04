package org.ejml.dense.row;

import java.util.Random;
import org.ejml.data.BMatrixRMaj;
import org.ejml.data.FMatrixD1;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.mult.SubmatrixOps_FDRM;
import org.ejml.dense.row.mult.VectorVectorMult_FDRM;

/* JADX INFO: loaded from: classes9.dex */
public class RandomMatrices_FDRM {
    public static FMatrixRMaj[] span(int i, int i2, Random random) {
        if (i < i2) {
            throw new IllegalArgumentException("The number of vectors must be less than or equal to the dimension");
        }
        FMatrixRMaj[] fMatrixRMajArr = new FMatrixRMaj[i2];
        FMatrixRMaj fMatrixRMajRectangle = rectangle(i, 1, -1.0f, 1.0f, random);
        fMatrixRMajArr[0] = fMatrixRMajRectangle;
        NormOps_FDRM.normalizeF(fMatrixRMajRectangle);
        for (int i3 = 1; i3 < i2; i3++) {
            FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(i, 1);
            FMatrixRMaj fMatrixRMajRectangle2 = null;
            int i4 = 0;
            while (i4 < i3) {
                if (i4 == 0) {
                    fMatrixRMajRectangle2 = rectangle(i, 1, -1.0f, 1.0f, random);
                }
                fMatrixRMaj.set((FMatrixD1) fMatrixRMajRectangle2);
                VectorVectorMult_FDRM.householder(-2.0f, fMatrixRMajArr[i4], fMatrixRMajRectangle2, fMatrixRMaj);
                CommonOps_FDRM.add(fMatrixRMajRectangle2, fMatrixRMaj, fMatrixRMaj);
                CommonOps_FDRM.scale(0.5f, fMatrixRMaj);
                float fNormF = NormOps_FDRM.normF(fMatrixRMaj);
                if (fNormF == 0.0f || Float.isNaN(fNormF) || Float.isInfinite(fNormF)) {
                    throw new RuntimeException("Failed sanity check");
                }
                CommonOps_FDRM.divide(fMatrixRMaj, fNormF);
                i4++;
                FMatrixRMaj fMatrixRMaj2 = fMatrixRMajRectangle2;
                fMatrixRMajRectangle2 = fMatrixRMaj;
                fMatrixRMaj = fMatrixRMaj2;
            }
            fMatrixRMajArr[i3] = fMatrixRMajRectangle2;
        }
        return fMatrixRMajArr;
    }

    public static FMatrixRMaj insideSpan(FMatrixRMaj[] fMatrixRMajArr, float f, float f2, Random random) {
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(fMatrixRMajArr.length, 1);
        FMatrixRMaj fMatrixRMaj2 = new FMatrixRMaj(fMatrixRMajArr[0].getNumElements(), 1);
        for (FMatrixRMaj fMatrixRMaj3 : fMatrixRMajArr) {
            fMatrixRMaj2.set((FMatrixD1) fMatrixRMaj3);
            CommonOps_FDRM.scale((random.nextFloat() * (f2 - f)) + f, fMatrixRMaj2);
            CommonOps_FDRM.add(fMatrixRMaj, fMatrixRMaj2, fMatrixRMaj);
        }
        return fMatrixRMaj;
    }

    public static FMatrixRMaj orthogonal(int i, int i2, Random random) {
        if (i < i2) {
            throw new IllegalArgumentException("The number of rows must be more than or equal to the number of columns");
        }
        FMatrixRMaj[] fMatrixRMajArrSpan = span(i, i2, random);
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(i, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            SubmatrixOps_FDRM.setSubMatrix(fMatrixRMajArrSpan[i3], fMatrixRMaj, 0, 0, 0, i3, i, 1);
        }
        return fMatrixRMaj;
    }

    public static FMatrixRMaj diagonal(int i, float f, float f2, Random random) {
        return diagonal(i, i, f, f2, random);
    }

    public static FMatrixRMaj diagonal(int i, int i2, float f, float f2, Random random) {
        if (f2 < f) {
            throw new IllegalArgumentException("The max must be >= the min");
        }
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(i, i2);
        int iMin = Math.min(i, i2);
        float f3 = f2 - f;
        for (int i3 = 0; i3 < iMin; i3++) {
            fMatrixRMaj.set(i3, i3, (random.nextFloat() * f3) + f);
        }
        return fMatrixRMaj;
    }

    public static FMatrixRMaj singleValues(int i, int i2, Random random, float... fArr) {
        FMatrixRMaj fMatrixRMajOrthogonal = orthogonal(i, i, random);
        FMatrixRMaj fMatrixRMajOrthogonal2 = orthogonal(i2, i2, random);
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(i, i2);
        int iMin = Math.min(Math.min(i, i2), fArr.length);
        for (int i3 = 0; i3 < iMin; i3++) {
            fMatrixRMaj.set(i3, i3, fArr[i3]);
        }
        FMatrixRMaj fMatrixRMaj2 = new FMatrixRMaj(i, i2);
        CommonOps_FDRM.mult(fMatrixRMajOrthogonal, fMatrixRMaj, fMatrixRMaj2);
        CommonOps_FDRM.multTransB(fMatrixRMaj2, fMatrixRMajOrthogonal2, fMatrixRMaj);
        return fMatrixRMaj;
    }

    public static FMatrixRMaj symmetricWithEigenvalues(int i, Random random, float... fArr) {
        FMatrixRMaj fMatrixRMajOrthogonal = orthogonal(i, i, random);
        FMatrixRMaj fMatrixRMajDiag = CommonOps_FDRM.diag(fArr);
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(i, i);
        CommonOps_FDRM.mult(fMatrixRMajOrthogonal, fMatrixRMajDiag, fMatrixRMaj);
        CommonOps_FDRM.multTransB(fMatrixRMaj, fMatrixRMajOrthogonal, fMatrixRMajDiag);
        return fMatrixRMajDiag;
    }

    public static FMatrixRMaj rectangle(int i, int i2, Random random) {
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(i, i2);
        fillUniform(fMatrixRMaj, 0.0f, 1.0f, random);
        return fMatrixRMaj;
    }

    public static BMatrixRMaj randomBinary(int i, int i2, Random random) {
        BMatrixRMaj bMatrixRMaj = new BMatrixRMaj(i, i2);
        setRandomB(bMatrixRMaj, random);
        return bMatrixRMaj;
    }

    public static void addUniform(FMatrixRMaj fMatrixRMaj, float f, float f2, Random random) {
        float[] data = fMatrixRMaj.getData();
        int numElements = fMatrixRMaj.getNumElements();
        float f3 = f2 - f;
        for (int i = 0; i < numElements; i++) {
            data[i] = data[i] + (random.nextFloat() * f3) + f;
        }
    }

    public static FMatrixRMaj rectangle(int i, int i2, float f, float f2, Random random) {
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(i, i2);
        fillUniform(fMatrixRMaj, f, f2, random);
        return fMatrixRMaj;
    }

    public static void fillUniform(FMatrixRMaj fMatrixRMaj, Random random) {
        fillUniform(fMatrixRMaj, 0.0f, 1.0f, random);
    }

    public static void fillUniform(FMatrixD1 fMatrixD1, float f, float f2, Random random) {
        float[] data = fMatrixD1.getData();
        int numElements = fMatrixD1.getNumElements();
        float f3 = f2 - f;
        for (int i = 0; i < numElements; i++) {
            data[i] = (random.nextFloat() * f3) + f;
        }
    }

    public static void setRandomB(BMatrixRMaj bMatrixRMaj, Random random) {
        boolean[] zArr = bMatrixRMaj.data;
        int numElements = bMatrixRMaj.getNumElements();
        for (int i = 0; i < numElements; i++) {
            zArr[i] = random.nextBoolean();
        }
    }

    public static FMatrixRMaj rectangleGaussian(int i, int i2, float f, float f2, Random random) {
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(i, i2);
        fillGaussian(fMatrixRMaj, f, f2, random);
        return fMatrixRMaj;
    }

    public static void fillGaussian(FMatrixD1 fMatrixD1, float f, float f2, Random random) {
        float[] data = fMatrixD1.getData();
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            data[i] = (((float) random.nextGaussian()) * f2) + f;
        }
    }

    public static FMatrixRMaj symmetricPosDef(int i, Random random) {
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(i, 1);
        FMatrixRMaj fMatrixRMaj2 = new FMatrixRMaj(i, i);
        for (int i2 = 0; i2 < i; i2++) {
            fMatrixRMaj.set(i2, 0, random.nextFloat());
        }
        CommonOps_FDRM.multTransB(fMatrixRMaj, fMatrixRMaj, fMatrixRMaj2);
        for (int i3 = 0; i3 < i; i3++) {
            fMatrixRMaj2.add(i3, i3, 1.0f);
        }
        return fMatrixRMaj2;
    }

    public static FMatrixRMaj symmetric(int i, float f, float f2, Random random) {
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(i, i);
        symmetric(fMatrixRMaj, f, f2, random);
        return fMatrixRMaj;
    }

    public static void symmetric(FMatrixRMaj fMatrixRMaj, float f, float f2, Random random) {
        if (fMatrixRMaj.numRows != fMatrixRMaj.numCols) {
            throw new IllegalArgumentException("A must be a square matrix");
        }
        float f3 = f2 - f;
        int i = fMatrixRMaj.numRows;
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = i2; i3 < i; i3++) {
                float fNextFloat = (random.nextFloat() * f3) + f;
                fMatrixRMaj.set(i2, i3, fNextFloat);
                fMatrixRMaj.set(i3, i2, fNextFloat);
            }
        }
    }

    public static FMatrixRMaj triangularUpper(int i, int i2, float f, float f2, Random random) {
        if (i2 < 0) {
            throw new RuntimeException("hessenberg must be more than or equal to 0");
        }
        float f3 = f2 - f;
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(i, i);
        int i3 = 0;
        while (i3 < i) {
            for (int i4 = i3 <= i2 ? 0 : i3 - i2; i4 < i; i4++) {
                fMatrixRMaj.set(i3, i4, (random.nextFloat() * f3) + f);
            }
            i3++;
        }
        return fMatrixRMaj;
    }
}
