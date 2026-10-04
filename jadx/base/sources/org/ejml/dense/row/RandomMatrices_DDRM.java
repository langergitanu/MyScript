package org.ejml.dense.row;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Random;
import org.ejml.data.BMatrixRMaj;
import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.mult.SubmatrixOps_DDRM;
import org.ejml.dense.row.mult.VectorVectorMult_DDRM;

/* JADX INFO: loaded from: classes9.dex */
public class RandomMatrices_DDRM {
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0067, code lost:
    
        r0[r8] = r3;
        r8 = r8 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DMatrixRMaj[] span(int i, int i2, Random random) {
        if (i < i2) {
            throw new IllegalArgumentException("The number of vectors must be less than or equal to the dimension");
        }
        DMatrixRMaj[] dMatrixRMajArr = new DMatrixRMaj[i2];
        DMatrixRMaj dMatrixRMajRectangle = rectangle(i, 1, -1.0d, 1.0d, random);
        dMatrixRMajArr[0] = dMatrixRMajRectangle;
        NormOps_DDRM.normalizeF(dMatrixRMajRectangle);
        int i3 = 1;
        loop0: while (i3 < i2) {
            DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(i, 1);
            DMatrixRMaj dMatrixRMaj2 = null;
            int i4 = 0;
            while (true) {
                DMatrixRMaj dMatrixRMaj3 = dMatrixRMaj;
                if (i4 < i3) {
                    dMatrixRMaj = i4 == 0 ? rectangle(i, 1, -1.0d, 1.0d, random) : dMatrixRMaj2;
                    dMatrixRMaj3.set((DMatrixD1) dMatrixRMaj);
                    VectorVectorMult_DDRM.householder(-2.0d, dMatrixRMajArr[i4], dMatrixRMaj, dMatrixRMaj3);
                    CommonOps_DDRM.add(dMatrixRMaj, dMatrixRMaj3, dMatrixRMaj3);
                    CommonOps_DDRM.scale(0.5d, dMatrixRMaj3);
                    double dNormF = NormOps_DDRM.normF(dMatrixRMaj3);
                    if (dNormF == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || Double.isNaN(dNormF) || Double.isInfinite(dNormF)) {
                        break loop0;
                    }
                    CommonOps_DDRM.divide(dMatrixRMaj3, dNormF);
                    i4++;
                    dMatrixRMaj2 = dMatrixRMaj3;
                }
            }
            throw new RuntimeException("Failed sanity check");
        }
        return dMatrixRMajArr;
    }

    public static DMatrixRMaj insideSpan(DMatrixRMaj[] dMatrixRMajArr, double d, double d2, Random random) {
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(dMatrixRMajArr.length, 1);
        DMatrixRMaj dMatrixRMaj2 = new DMatrixRMaj(dMatrixRMajArr[0].getNumElements(), 1);
        for (DMatrixRMaj dMatrixRMaj3 : dMatrixRMajArr) {
            dMatrixRMaj2.set((DMatrixD1) dMatrixRMaj3);
            CommonOps_DDRM.scale((random.nextDouble() * (d2 - d)) + d, dMatrixRMaj2);
            CommonOps_DDRM.add(dMatrixRMaj, dMatrixRMaj2, dMatrixRMaj);
        }
        return dMatrixRMaj;
    }

    public static DMatrixRMaj orthogonal(int i, int i2, Random random) {
        if (i < i2) {
            throw new IllegalArgumentException("The number of rows must be more than or equal to the number of columns");
        }
        DMatrixRMaj[] dMatrixRMajArrSpan = span(i, i2, random);
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(i, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            SubmatrixOps_DDRM.setSubMatrix(dMatrixRMajArrSpan[i3], dMatrixRMaj, 0, 0, 0, i3, i, 1);
        }
        return dMatrixRMaj;
    }

    public static DMatrixRMaj diagonal(int i, double d, double d2, Random random) {
        return diagonal(i, i, d, d2, random);
    }

    public static DMatrixRMaj diagonal(int i, int i2, double d, double d2, Random random) {
        if (d2 < d) {
            throw new IllegalArgumentException("The max must be >= the min");
        }
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(i, i2);
        int iMin = Math.min(i, i2);
        double d3 = d2 - d;
        for (int i3 = 0; i3 < iMin; i3++) {
            dMatrixRMaj.set(i3, i3, (random.nextDouble() * d3) + d);
        }
        return dMatrixRMaj;
    }

    public static DMatrixRMaj singleValues(int i, int i2, Random random, double... dArr) {
        DMatrixRMaj dMatrixRMajOrthogonal = orthogonal(i, i, random);
        DMatrixRMaj dMatrixRMajOrthogonal2 = orthogonal(i2, i2, random);
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(i, i2);
        int iMin = Math.min(Math.min(i, i2), dArr.length);
        for (int i3 = 0; i3 < iMin; i3++) {
            dMatrixRMaj.set(i3, i3, dArr[i3]);
        }
        DMatrixRMaj dMatrixRMaj2 = new DMatrixRMaj(i, i2);
        CommonOps_DDRM.mult(dMatrixRMajOrthogonal, dMatrixRMaj, dMatrixRMaj2);
        CommonOps_DDRM.multTransB(dMatrixRMaj2, dMatrixRMajOrthogonal2, dMatrixRMaj);
        return dMatrixRMaj;
    }

    public static DMatrixRMaj symmetricWithEigenvalues(int i, Random random, double... dArr) {
        DMatrixRMaj dMatrixRMajOrthogonal = orthogonal(i, i, random);
        DMatrixRMaj dMatrixRMajDiag = CommonOps_DDRM.diag(dArr);
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(i, i);
        CommonOps_DDRM.mult(dMatrixRMajOrthogonal, dMatrixRMajDiag, dMatrixRMaj);
        CommonOps_DDRM.multTransB(dMatrixRMaj, dMatrixRMajOrthogonal, dMatrixRMajDiag);
        return dMatrixRMajDiag;
    }

    public static DMatrixRMaj rectangle(int i, int i2, Random random) {
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(i, i2);
        fillUniform(dMatrixRMaj, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d, random);
        return dMatrixRMaj;
    }

    public static BMatrixRMaj randomBinary(int i, int i2, Random random) {
        BMatrixRMaj bMatrixRMaj = new BMatrixRMaj(i, i2);
        setRandomB(bMatrixRMaj, random);
        return bMatrixRMaj;
    }

    public static void addUniform(DMatrixRMaj dMatrixRMaj, double d, double d2, Random random) {
        double[] data = dMatrixRMaj.getData();
        int numElements = dMatrixRMaj.getNumElements();
        double d3 = d2 - d;
        for (int i = 0; i < numElements; i++) {
            data[i] = data[i] + (random.nextDouble() * d3) + d;
        }
    }

    public static DMatrixRMaj rectangle(int i, int i2, double d, double d2, Random random) {
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(i, i2);
        fillUniform(dMatrixRMaj, d, d2, random);
        return dMatrixRMaj;
    }

    public static void fillUniform(DMatrixRMaj dMatrixRMaj, Random random) {
        fillUniform(dMatrixRMaj, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d, random);
    }

    public static void fillUniform(DMatrixD1 dMatrixD1, double d, double d2, Random random) {
        double[] data = dMatrixD1.getData();
        int numElements = dMatrixD1.getNumElements();
        double d3 = d2 - d;
        for (int i = 0; i < numElements; i++) {
            data[i] = (random.nextDouble() * d3) + d;
        }
    }

    public static void setRandomB(BMatrixRMaj bMatrixRMaj, Random random) {
        boolean[] zArr = bMatrixRMaj.data;
        int numElements = bMatrixRMaj.getNumElements();
        for (int i = 0; i < numElements; i++) {
            zArr[i] = random.nextBoolean();
        }
    }

    public static DMatrixRMaj rectangleGaussian(int i, int i2, double d, double d2, Random random) {
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(i, i2);
        fillGaussian(dMatrixRMaj, d, d2, random);
        return dMatrixRMaj;
    }

    public static void fillGaussian(DMatrixD1 dMatrixD1, double d, double d2, Random random) {
        double[] data = dMatrixD1.getData();
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            data[i] = (random.nextGaussian() * d2) + d;
        }
    }

    public static DMatrixRMaj symmetricPosDef(int i, Random random) {
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(i, 1);
        DMatrixRMaj dMatrixRMaj2 = new DMatrixRMaj(i, i);
        for (int i2 = 0; i2 < i; i2++) {
            dMatrixRMaj.set(i2, 0, random.nextDouble());
        }
        CommonOps_DDRM.multTransB(dMatrixRMaj, dMatrixRMaj, dMatrixRMaj2);
        for (int i3 = 0; i3 < i; i3++) {
            dMatrixRMaj2.add(i3, i3, 1.0d);
        }
        return dMatrixRMaj2;
    }

    public static DMatrixRMaj symmetric(int i, double d, double d2, Random random) {
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(i, i);
        symmetric(dMatrixRMaj, d, d2, random);
        return dMatrixRMaj;
    }

    public static void symmetric(DMatrixRMaj dMatrixRMaj, double d, double d2, Random random) {
        if (dMatrixRMaj.numRows != dMatrixRMaj.numCols) {
            throw new IllegalArgumentException("A must be a square matrix");
        }
        double d3 = d2 - d;
        int i = dMatrixRMaj.numRows;
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = i2; i3 < i; i3++) {
                double dNextDouble = (random.nextDouble() * d3) + d;
                dMatrixRMaj.set(i2, i3, dNextDouble);
                dMatrixRMaj.set(i3, i2, dNextDouble);
            }
        }
    }

    public static DMatrixRMaj triangularUpper(int i, int i2, double d, double d2, Random random) {
        if (i2 < 0) {
            throw new RuntimeException("hessenberg must be more than or equal to 0");
        }
        double d3 = d2 - d;
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(i, i);
        int i3 = 0;
        while (i3 < i) {
            for (int i4 = i3 <= i2 ? 0 : i3 - i2; i4 < i; i4++) {
                dMatrixRMaj.set(i3, i4, (random.nextDouble() * d3) + d);
            }
            i3++;
        }
        return dMatrixRMaj;
    }
}
