package org.ejml;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.data.FMatrixRMaj;
import org.ejml.data.IGrowArray;
import org.ejml.ops.ConvertDMatrixStruct;

/* JADX INFO: loaded from: classes7.dex */
public class UtilEjml {
    public static String VERSION = "0.33";
    public static double EPS = Math.pow(2.0d, -52.0d);
    public static float F_EPS = (float) Math.pow(2.0d, -21.0d);

    /* JADX INFO: renamed from: PI */
    public static double f2394PI = 3.141592653589793d;
    public static double PI2 = 6.283185307179586d;
    public static double PId2 = 1.5707963267948966d;
    public static float F_PI = 3.1415927f;
    public static float F_PI2 = 6.2831855f;
    public static float F_PId2 = 1.5707964f;
    public static float TEST_F32 = 1.0E-4f;
    public static double TEST_F64 = 1.0E-8d;
    public static float TESTP_F32 = 1.0E-6f;
    public static double TESTP_F64 = 1.0E-12d;
    public static float TEST_F32_SQ = (float) Math.sqrt(1.0E-4f);
    public static double TEST_F64_SQ = Math.sqrt(TEST_F64);
    public static int maxInverseSize = 5;

    public static boolean isUncountable(double d) {
        return Double.isNaN(d) || Double.isInfinite(d);
    }

    public static boolean isUncountable(float f) {
        return Float.isNaN(f) || Float.isInfinite(f);
    }

    public static boolean isIdentical(double d, double d2, double d3) {
        if (d3 >= Math.abs(d - d2)) {
            return true;
        }
        if (Double.isNaN(d)) {
            return Double.isNaN(d2);
        }
        return Double.isInfinite(d) && d == d2;
    }

    public static boolean isIdentical(float f, float f2, float f3) {
        if (f3 >= Math.abs(f - f2)) {
            return true;
        }
        if (Float.isNaN(f)) {
            return Float.isNaN(f2);
        }
        return Float.isInfinite(f) && f == f2;
    }

    public static void memset(double[] dArr, double d, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            dArr[i2] = d;
        }
    }

    public static void memset(int[] iArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = i;
        }
    }

    public static <T> void setnull(T[] tArr) {
        for (int i = 0; i < tArr.length; i++) {
            tArr[i] = null;
        }
    }

    public static double max(double[] dArr, int i, int i2) {
        double d = dArr[i];
        int i3 = i2 + i;
        while (true) {
            i++;
            if (i >= i3) {
                return d;
            }
            double d2 = dArr[i];
            if (d2 > d) {
                d = d2;
            }
        }
    }

    public static float max(float[] fArr, int i, int i2) {
        float f = fArr[i];
        int i3 = i2 + i;
        while (true) {
            i++;
            if (i >= i3) {
                return f;
            }
            float f2 = fArr[i];
            if (f2 > f) {
                f = f2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static DMatrixRMaj parse_DDRM(String str, int i) {
        String[] strArrSplit = str.split("(\\s)+");
        boolean zIsEmpty = strArrSplit[0].isEmpty();
        int length = (strArrSplit.length - (zIsEmpty ? 1 : 0)) / i;
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(length, i);
        int i2 = 0;
        ?? r1 = zIsEmpty;
        while (i2 < length) {
            int i3 = 0;
            ?? r12 = r1;
            while (i3 < i) {
                int i4 = (r12 == true ? 1 : 0) + 1;
                dMatrixRMaj.set(i2, i3, Double.parseDouble(strArrSplit[r12 == true ? 1 : 0]));
                i3++;
                r12 = i4;
            }
            i2++;
            r1 = r12;
        }
        return dMatrixRMaj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public static FMatrixRMaj parse_FDRM(String str, int i) {
        String[] strArrSplit = str.split("(\\s)+");
        boolean zIsEmpty = strArrSplit[0].isEmpty();
        int length = (strArrSplit.length - (zIsEmpty ? 1 : 0)) / i;
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(length, i);
        int i2 = 0;
        ?? r1 = zIsEmpty;
        while (i2 < length) {
            int i3 = 0;
            ?? r12 = r1;
            while (i3 < i) {
                int i4 = (r12 == true ? 1 : 0) + 1;
                fMatrixRMaj.set(i2, i3, Float.parseFloat(strArrSplit[r12 == true ? 1 : 0]));
                i3++;
                r12 = i4;
            }
            i2++;
            r1 = r12;
        }
        return fMatrixRMaj;
    }

    public static Integer[] sortByIndex(final double[] dArr, int i) {
        Integer[] numArr = new Integer[i];
        for (int i2 = 0; i2 < i; i2++) {
            numArr[i2] = Integer.valueOf(i2);
        }
        Arrays.sort(numArr, new Comparator<Integer>() { // from class: org.ejml.UtilEjml.1
            @Override // java.util.Comparator
            public int compare(Integer num, Integer num2) {
                return Double.compare(dArr[num.intValue()], dArr[num2.intValue()]);
            }
        });
        return numArr;
    }

    public static DMatrixSparseCSC parse_DSCC(String str, int i) {
        return ConvertDMatrixStruct.convert(parse_DDRM(str, i), (DMatrixSparseCSC) null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public static int[] shuffled(int i, Random random) {
        return shuffled(i, i, random);
    }

    public static int[] shuffled(int i, int i2, Random random) {
        int[] iArr = new int[i];
        for (int i3 = 0; i3 < i; i3++) {
            iArr[i3] = i3;
        }
        shuffle(iArr, i, 0, i2, random);
        return iArr;
    }

    public static int[] shuffledSorted(int i, int i2, Random random) {
        int[] iArr = new int[i];
        for (int i3 = 0; i3 < i; i3++) {
            iArr[i3] = i3;
        }
        shuffle(iArr, i, 0, i2, random);
        Arrays.sort(iArr, 0, i2);
        return iArr;
    }

    public static void shuffle(int[] iArr, int i, int i2, int i3, Random random) {
        int i4 = i3 - i2;
        for (int i5 = 0; i5 < i4; i5++) {
            int iNextInt = random.nextInt(i - i5) + i5 + i2;
            int i6 = iArr[i5];
            iArr[i5] = iArr[iNextInt];
            iArr[iNextInt] = i6;
        }
    }

    public static int[] pivotVector(int[] iArr, int i, IGrowArray iGrowArray) {
        if (iGrowArray == null) {
            iGrowArray = new IGrowArray();
        }
        iGrowArray.reshape(i);
        System.arraycopy(iArr, 0, iGrowArray.data, 0, i);
        return iGrowArray.data;
    }

    public static int permutationSign(int[] iArr, int i, int[] iArr2) {
        System.arraycopy(iArr, 0, iArr2, 0, i);
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            while (true) {
                int i4 = iArr2[i3];
                if (i3 != i4) {
                    i2++;
                    iArr2[i3] = iArr2[i4];
                    iArr2[i4] = i4;
                }
            }
        }
        return i2 % 2 == 0 ? 1 : -1;
    }
}
