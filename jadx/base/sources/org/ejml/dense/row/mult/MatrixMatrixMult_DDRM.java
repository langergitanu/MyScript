package org.ejml.dense.row.mult;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.MatrixDimensionException;
import org.ejml.data.DMatrix1Row;
import org.ejml.dense.row.CommonOps_DDRM;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixMatrixMult_DDRM {
    public static void mult_reorder(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numCols != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numRows != dMatrix1Row3.numRows || dMatrix1Row2.numCols != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (dMatrix1Row.numCols == 0 || dMatrix1Row.numRows == 0) {
            CommonOps_DDRM.fill(dMatrix1Row3, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            return;
        }
        int i = dMatrix1Row2.numRows * dMatrix1Row2.numCols;
        int i2 = 0;
        int i3 = 0;
        while (i2 < dMatrix1Row.numRows) {
            int i4 = dMatrix1Row.numCols * i2;
            int i5 = dMatrix1Row2.numCols;
            int i6 = i4 + 1;
            double d = dMatrix1Row.get(i4);
            int i7 = i3;
            int i8 = 0;
            while (i8 < i5) {
                dMatrix1Row3.set(i7, d * dMatrix1Row2.get(i8));
                i7++;
                i8++;
                i2 = i2;
            }
            int i9 = i2;
            while (i8 != i) {
                int i10 = dMatrix1Row2.numCols + i8;
                int i11 = i6 + 1;
                double d2 = dMatrix1Row.get(i6);
                int i12 = i3;
                while (i8 < i10) {
                    dMatrix1Row3.plus(i12, dMatrix1Row2.get(i8) * d2);
                    i12++;
                    i8++;
                }
                i6 = i11;
            }
            i3 += dMatrix1Row3.numCols;
            i2 = i9 + 1;
        }
    }

    public static void mult_small(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numCols != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numRows != dMatrix1Row3.numRows || dMatrix1Row2.numCols != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < dMatrix1Row.numRows; i3++) {
            int i4 = 0;
            while (i4 < dMatrix1Row2.numCols) {
                int i5 = dMatrix1Row2.numRows + i;
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i6 = i4;
                for (int i7 = i; i7 < i5; i7++) {
                    d += dMatrix1Row.get(i7) * dMatrix1Row2.get(i6);
                    i6 += dMatrix1Row2.numCols;
                }
                dMatrix1Row3.set(i2, d);
                i4++;
                i2++;
            }
            i += dMatrix1Row.numCols;
        }
    }

    public static void mult_aux(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3, double[] dArr) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numCols != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numRows != dMatrix1Row3.numRows || dMatrix1Row2.numCols != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (dArr == null) {
            dArr = new double[dMatrix1Row2.numRows];
        }
        for (int i = 0; i < dMatrix1Row2.numCols; i++) {
            for (int i2 = 0; i2 < dMatrix1Row2.numRows; i2++) {
                dArr[i2] = dMatrix1Row2.unsafe_get(i2, i);
            }
            int i3 = 0;
            for (int i4 = 0; i4 < dMatrix1Row.numRows; i4++) {
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i5 = 0;
                while (i5 < dMatrix1Row2.numRows) {
                    d += dMatrix1Row.get(i3) * dArr[i5];
                    i5++;
                    i3++;
                }
                dMatrix1Row3.set((dMatrix1Row3.numCols * i4) + i, d);
            }
        }
    }

    public static void multTransA_reorder(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numRows != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numCols != dMatrix1Row3.numRows || dMatrix1Row2.numCols != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (dMatrix1Row.numCols == 0 || dMatrix1Row.numRows == 0) {
            CommonOps_DDRM.fill(dMatrix1Row3, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            return;
        }
        for (int i = 0; i < dMatrix1Row.numCols; i++) {
            int i2 = dMatrix1Row3.numCols * i;
            double d = dMatrix1Row.get(i);
            int i3 = dMatrix1Row2.numCols;
            int i4 = 0;
            int i5 = i2;
            while (i4 < i3) {
                dMatrix1Row3.set(i5, dMatrix1Row2.get(i4) * d);
                i5++;
                i4++;
            }
            for (int i6 = 1; i6 < dMatrix1Row.numRows; i6++) {
                double dUnsafe_get = dMatrix1Row.unsafe_get(i6, i);
                int i7 = dMatrix1Row2.numCols + i4;
                int i8 = i2;
                while (i4 < i7) {
                    dMatrix1Row3.plus(i8, dMatrix1Row2.get(i4) * dUnsafe_get);
                    i8++;
                    i4++;
                }
            }
        }
    }

    public static void multTransA_small(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numRows != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numCols != dMatrix1Row3.numRows || dMatrix1Row2.numCols != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < dMatrix1Row.numCols; i2++) {
            int i3 = 0;
            while (i3 < dMatrix1Row2.numCols) {
                int i4 = (dMatrix1Row2.numRows * dMatrix1Row2.numCols) + i3;
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i5 = i2;
                int i6 = i3;
                while (i6 < i4) {
                    d += dMatrix1Row.get(i5) * dMatrix1Row2.get(i6);
                    i5 += dMatrix1Row.numCols;
                    i6 += dMatrix1Row2.numCols;
                }
                dMatrix1Row3.set(i, d);
                i3++;
                i++;
            }
        }
    }

    public static void multTransAB(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numRows != dMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numCols != dMatrix1Row3.numRows || dMatrix1Row2.numRows != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < dMatrix1Row.numCols; i2++) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < dMatrix1Row2.numRows) {
                int i5 = dMatrix1Row2.numCols + i4;
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i6 = i2;
                while (i4 < i5) {
                    d += dMatrix1Row.get(i6) * dMatrix1Row2.get(i4);
                    i6 += dMatrix1Row.numCols;
                    i4++;
                }
                dMatrix1Row3.set(i, d);
                i3++;
                i++;
            }
        }
    }

    public static void multTransAB_aux(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3, double[] dArr) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numRows != dMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numCols != dMatrix1Row3.numRows || dMatrix1Row2.numRows != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        double[] dArr2 = dArr == null ? new double[dMatrix1Row.numRows] : dArr;
        if (dMatrix1Row.numCols == 0 || dMatrix1Row.numRows == 0) {
            CommonOps_DDRM.fill(dMatrix1Row3, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < dMatrix1Row.numCols; i2++) {
            for (int i3 = 0; i3 < dMatrix1Row2.numCols; i3++) {
                dArr2[i3] = dMatrix1Row.unsafe_get(i3, i2);
            }
            int i4 = 0;
            while (i4 < dMatrix1Row2.numRows) {
                double dUnsafe_get = 0.0d;
                for (int i5 = 0; i5 < dMatrix1Row2.numCols; i5++) {
                    dUnsafe_get += dArr2[i5] * dMatrix1Row2.unsafe_get(i4, i5);
                }
                dMatrix1Row3.set(i, dUnsafe_get);
                i4++;
                i++;
            }
        }
    }

    public static void multTransB(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numCols != dMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numRows != dMatrix1Row3.numRows || dMatrix1Row2.numRows != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < dMatrix1Row.numRows; i3++) {
            int i4 = dMatrix1Row2.numCols + i;
            int i5 = 0;
            int i6 = 0;
            while (i5 < dMatrix1Row2.numRows) {
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i7 = i; i7 < i4; i7++) {
                    d += dMatrix1Row.get(i7) * dMatrix1Row2.get(i6);
                    i6++;
                }
                dMatrix1Row3.set(i2, d);
                i5++;
                i2++;
            }
            i += dMatrix1Row.numCols;
        }
    }

    public static void multAdd_reorder(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numCols != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numRows != dMatrix1Row3.numRows || dMatrix1Row2.numCols != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (dMatrix1Row.numCols == 0 || dMatrix1Row.numRows == 0) {
            return;
        }
        int i = dMatrix1Row2.numRows * dMatrix1Row2.numCols;
        int i2 = 0;
        int i3 = 0;
        while (i2 < dMatrix1Row.numRows) {
            int i4 = dMatrix1Row.numCols * i2;
            int i5 = dMatrix1Row2.numCols;
            int i6 = i4 + 1;
            double d = dMatrix1Row.get(i4);
            int i7 = i3;
            int i8 = 0;
            while (i8 < i5) {
                dMatrix1Row3.plus(i7, d * dMatrix1Row2.get(i8));
                i7++;
                i8++;
                i2 = i2;
            }
            int i9 = i2;
            while (i8 != i) {
                int i10 = dMatrix1Row2.numCols + i8;
                int i11 = i6 + 1;
                double d2 = dMatrix1Row.get(i6);
                int i12 = i3;
                while (i8 < i10) {
                    dMatrix1Row3.plus(i12, dMatrix1Row2.get(i8) * d2);
                    i12++;
                    i8++;
                }
                i6 = i11;
            }
            i3 += dMatrix1Row3.numCols;
            i2 = i9 + 1;
        }
    }

    public static void multAdd_small(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numCols != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numRows != dMatrix1Row3.numRows || dMatrix1Row2.numCols != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < dMatrix1Row.numRows; i3++) {
            int i4 = 0;
            while (i4 < dMatrix1Row2.numCols) {
                int i5 = dMatrix1Row2.numRows + i;
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i6 = i4;
                for (int i7 = i; i7 < i5; i7++) {
                    d += dMatrix1Row.get(i7) * dMatrix1Row2.get(i6);
                    i6 += dMatrix1Row2.numCols;
                }
                dMatrix1Row3.plus(i2, d);
                i4++;
                i2++;
            }
            i += dMatrix1Row.numCols;
        }
    }

    public static void multAdd_aux(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3, double[] dArr) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numCols != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numRows != dMatrix1Row3.numRows || dMatrix1Row2.numCols != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (dArr == null) {
            dArr = new double[dMatrix1Row2.numRows];
        }
        for (int i = 0; i < dMatrix1Row2.numCols; i++) {
            for (int i2 = 0; i2 < dMatrix1Row2.numRows; i2++) {
                dArr[i2] = dMatrix1Row2.unsafe_get(i2, i);
            }
            int i3 = 0;
            for (int i4 = 0; i4 < dMatrix1Row.numRows; i4++) {
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i5 = 0;
                while (i5 < dMatrix1Row2.numRows) {
                    d += dMatrix1Row.get(i3) * dArr[i5];
                    i5++;
                    i3++;
                }
                dMatrix1Row3.plus((dMatrix1Row3.numCols * i4) + i, d);
            }
        }
    }

    public static void multAddTransA_reorder(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numRows != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numCols != dMatrix1Row3.numRows || dMatrix1Row2.numCols != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (dMatrix1Row.numCols == 0 || dMatrix1Row.numRows == 0) {
            return;
        }
        for (int i = 0; i < dMatrix1Row.numCols; i++) {
            int i2 = dMatrix1Row3.numCols * i;
            double d = dMatrix1Row.get(i);
            int i3 = dMatrix1Row2.numCols;
            int i4 = 0;
            int i5 = i2;
            while (i4 < i3) {
                dMatrix1Row3.plus(i5, dMatrix1Row2.get(i4) * d);
                i5++;
                i4++;
            }
            for (int i6 = 1; i6 < dMatrix1Row.numRows; i6++) {
                double dUnsafe_get = dMatrix1Row.unsafe_get(i6, i);
                int i7 = dMatrix1Row2.numCols + i4;
                int i8 = i2;
                while (i4 < i7) {
                    dMatrix1Row3.plus(i8, dMatrix1Row2.get(i4) * dUnsafe_get);
                    i8++;
                    i4++;
                }
            }
        }
    }

    public static void multAddTransA_small(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numRows != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numCols != dMatrix1Row3.numRows || dMatrix1Row2.numCols != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < dMatrix1Row.numCols; i2++) {
            int i3 = 0;
            while (i3 < dMatrix1Row2.numCols) {
                int i4 = (dMatrix1Row2.numRows * dMatrix1Row2.numCols) + i3;
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i5 = i2;
                int i6 = i3;
                while (i6 < i4) {
                    d += dMatrix1Row.get(i5) * dMatrix1Row2.get(i6);
                    i5 += dMatrix1Row.numCols;
                    i6 += dMatrix1Row2.numCols;
                }
                dMatrix1Row3.plus(i, d);
                i3++;
                i++;
            }
        }
    }

    public static void multAddTransAB(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numRows != dMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numCols != dMatrix1Row3.numRows || dMatrix1Row2.numRows != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < dMatrix1Row.numCols; i2++) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < dMatrix1Row2.numRows) {
                int i5 = dMatrix1Row2.numCols + i4;
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i6 = i2;
                while (i4 < i5) {
                    d += dMatrix1Row.get(i6) * dMatrix1Row2.get(i4);
                    i6 += dMatrix1Row.numCols;
                    i4++;
                }
                dMatrix1Row3.plus(i, d);
                i3++;
                i++;
            }
        }
    }

    public static void multAddTransAB_aux(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3, double[] dArr) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numRows != dMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numCols != dMatrix1Row3.numRows || dMatrix1Row2.numRows != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (dArr == null) {
            dArr = new double[dMatrix1Row.numRows];
        }
        if (dMatrix1Row.numCols == 0 || dMatrix1Row.numRows == 0) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < dMatrix1Row.numCols; i2++) {
            for (int i3 = 0; i3 < dMatrix1Row2.numCols; i3++) {
                dArr[i3] = dMatrix1Row.unsafe_get(i3, i2);
            }
            int i4 = 0;
            while (i4 < dMatrix1Row2.numRows) {
                double dUnsafe_get = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i5 = 0; i5 < dMatrix1Row2.numCols; i5++) {
                    dUnsafe_get += dArr[i5] * dMatrix1Row2.unsafe_get(i4, i5);
                }
                dMatrix1Row3.plus(i, dUnsafe_get);
                i4++;
                i++;
            }
        }
    }

    public static void multAddTransB(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numCols != dMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numRows != dMatrix1Row3.numRows || dMatrix1Row2.numRows != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < dMatrix1Row.numRows; i3++) {
            int i4 = dMatrix1Row2.numCols + i;
            int i5 = 0;
            int i6 = 0;
            while (i5 < dMatrix1Row2.numRows) {
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i7 = i; i7 < i4; i7++) {
                    d += dMatrix1Row.get(i7) * dMatrix1Row2.get(i6);
                    i6++;
                }
                dMatrix1Row3.plus(i2, d);
                i5++;
                i2++;
            }
            i += dMatrix1Row.numCols;
        }
    }

    public static void mult_reorder(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numCols != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numRows != dMatrix1Row3.numRows || dMatrix1Row2.numCols != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (dMatrix1Row.numCols == 0 || dMatrix1Row.numRows == 0) {
            CommonOps_DDRM.fill(dMatrix1Row3, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            return;
        }
        int i = dMatrix1Row2.numRows * dMatrix1Row2.numCols;
        int i2 = 0;
        int i3 = 0;
        while (i2 < dMatrix1Row.numRows) {
            int i4 = dMatrix1Row.numCols * i2;
            int i5 = dMatrix1Row2.numCols;
            int i6 = i4 + 1;
            double d2 = dMatrix1Row.get(i4) * d;
            int i7 = i3;
            int i8 = 0;
            while (i8 < i5) {
                dMatrix1Row3.set(i7, d2 * dMatrix1Row2.get(i8));
                i7++;
                i8++;
                i2 = i2;
            }
            int i9 = i2;
            while (i8 != i) {
                int i10 = dMatrix1Row2.numCols + i8;
                int i11 = i6 + 1;
                double d3 = dMatrix1Row.get(i6) * d;
                int i12 = i3;
                while (i8 < i10) {
                    dMatrix1Row3.plus(i12, dMatrix1Row2.get(i8) * d3);
                    i12++;
                    i8++;
                }
                i6 = i11;
            }
            i3 += dMatrix1Row3.numCols;
            i2 = i9 + 1;
        }
    }

    public static void mult_small(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numCols != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numRows != dMatrix1Row3.numRows || dMatrix1Row2.numCols != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < dMatrix1Row.numRows; i3++) {
            int i4 = 0;
            while (i4 < dMatrix1Row2.numCols) {
                int i5 = dMatrix1Row2.numRows + i;
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i6 = i4;
                for (int i7 = i; i7 < i5; i7++) {
                    d2 += dMatrix1Row.get(i7) * dMatrix1Row2.get(i6);
                    i6 += dMatrix1Row2.numCols;
                }
                dMatrix1Row3.set(i2, d2 * d);
                i4++;
                i2++;
            }
            i += dMatrix1Row.numCols;
        }
    }

    public static void mult_aux(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3, double[] dArr) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numCols != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numRows != dMatrix1Row3.numRows || dMatrix1Row2.numCols != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        double[] dArr2 = dArr == null ? new double[dMatrix1Row2.numRows] : dArr;
        for (int i = 0; i < dMatrix1Row2.numCols; i++) {
            for (int i2 = 0; i2 < dMatrix1Row2.numRows; i2++) {
                dArr2[i2] = dMatrix1Row2.unsafe_get(i2, i);
            }
            int i3 = 0;
            for (int i4 = 0; i4 < dMatrix1Row.numRows; i4++) {
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i5 = 0;
                while (i5 < dMatrix1Row2.numRows) {
                    d2 += dMatrix1Row.get(i3) * dArr2[i5];
                    i5++;
                    i3++;
                }
                dMatrix1Row3.set((dMatrix1Row3.numCols * i4) + i, d2 * d);
            }
        }
    }

    public static void multTransA_reorder(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numRows != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numCols != dMatrix1Row3.numRows || dMatrix1Row2.numCols != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (dMatrix1Row.numCols == 0 || dMatrix1Row.numRows == 0) {
            CommonOps_DDRM.fill(dMatrix1Row3, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            return;
        }
        for (int i = 0; i < dMatrix1Row.numCols; i++) {
            int i2 = dMatrix1Row3.numCols * i;
            double d2 = dMatrix1Row.get(i) * d;
            int i3 = dMatrix1Row2.numCols;
            int i4 = 0;
            int i5 = i2;
            while (i4 < i3) {
                dMatrix1Row3.set(i5, dMatrix1Row2.get(i4) * d2);
                i5++;
                i4++;
            }
            for (int i6 = 1; i6 < dMatrix1Row.numRows; i6++) {
                double dUnsafe_get = dMatrix1Row.unsafe_get(i6, i) * d;
                int i7 = dMatrix1Row2.numCols + i4;
                int i8 = i2;
                while (i4 < i7) {
                    dMatrix1Row3.plus(i8, dMatrix1Row2.get(i4) * dUnsafe_get);
                    i8++;
                    i4++;
                }
            }
        }
    }

    public static void multTransA_small(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numRows != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numCols != dMatrix1Row3.numRows || dMatrix1Row2.numCols != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < dMatrix1Row.numCols; i2++) {
            int i3 = 0;
            while (i3 < dMatrix1Row2.numCols) {
                int i4 = (dMatrix1Row2.numRows * dMatrix1Row2.numCols) + i3;
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i5 = i2;
                int i6 = i3;
                while (i6 < i4) {
                    d2 += dMatrix1Row.get(i5) * dMatrix1Row2.get(i6);
                    i5 += dMatrix1Row.numCols;
                    i6 += dMatrix1Row2.numCols;
                }
                dMatrix1Row3.set(i, d2 * d);
                i3++;
                i++;
            }
        }
    }

    public static void multTransAB(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numRows != dMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numCols != dMatrix1Row3.numRows || dMatrix1Row2.numRows != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < dMatrix1Row.numCols; i2++) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < dMatrix1Row2.numRows) {
                int i5 = dMatrix1Row2.numCols + i4;
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i6 = i2;
                while (i4 < i5) {
                    d2 += dMatrix1Row.get(i6) * dMatrix1Row2.get(i4);
                    i6 += dMatrix1Row.numCols;
                    i4++;
                }
                dMatrix1Row3.set(i, d2 * d);
                i3++;
                i++;
            }
        }
    }

    public static void multTransAB_aux(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3, double[] dArr) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numRows != dMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numCols != dMatrix1Row3.numRows || dMatrix1Row2.numRows != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        double[] dArr2 = dArr == null ? new double[dMatrix1Row.numRows] : dArr;
        if (dMatrix1Row.numCols == 0 || dMatrix1Row.numRows == 0) {
            CommonOps_DDRM.fill(dMatrix1Row3, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < dMatrix1Row.numCols; i2++) {
            for (int i3 = 0; i3 < dMatrix1Row2.numCols; i3++) {
                dArr2[i3] = dMatrix1Row.unsafe_get(i3, i2);
            }
            int i4 = 0;
            while (i4 < dMatrix1Row2.numRows) {
                double dUnsafe_get = 0.0d;
                for (int i5 = 0; i5 < dMatrix1Row2.numCols; i5++) {
                    dUnsafe_get += dArr2[i5] * dMatrix1Row2.unsafe_get(i4, i5);
                }
                dMatrix1Row3.set(i, dUnsafe_get * d);
                i4++;
                i++;
            }
        }
    }

    public static void multTransB(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numCols != dMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numRows != dMatrix1Row3.numRows || dMatrix1Row2.numRows != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < dMatrix1Row.numRows; i3++) {
            int i4 = dMatrix1Row2.numCols + i;
            int i5 = 0;
            int i6 = 0;
            while (i5 < dMatrix1Row2.numRows) {
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i7 = i; i7 < i4; i7++) {
                    d2 += dMatrix1Row.get(i7) * dMatrix1Row2.get(i6);
                    i6++;
                }
                dMatrix1Row3.set(i2, d2 * d);
                i5++;
                i2++;
            }
            i += dMatrix1Row.numCols;
        }
    }

    public static void multAdd_reorder(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numCols != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numRows != dMatrix1Row3.numRows || dMatrix1Row2.numCols != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (dMatrix1Row.numCols == 0 || dMatrix1Row.numRows == 0) {
            return;
        }
        int i = dMatrix1Row2.numRows * dMatrix1Row2.numCols;
        int i2 = 0;
        int i3 = 0;
        while (i2 < dMatrix1Row.numRows) {
            int i4 = dMatrix1Row.numCols * i2;
            int i5 = dMatrix1Row2.numCols;
            int i6 = i4 + 1;
            double d2 = dMatrix1Row.get(i4) * d;
            int i7 = i3;
            int i8 = 0;
            while (i8 < i5) {
                dMatrix1Row3.plus(i7, d2 * dMatrix1Row2.get(i8));
                i7++;
                i8++;
                i2 = i2;
            }
            int i9 = i2;
            while (i8 != i) {
                int i10 = dMatrix1Row2.numCols + i8;
                int i11 = i6 + 1;
                double d3 = dMatrix1Row.get(i6) * d;
                int i12 = i3;
                while (i8 < i10) {
                    dMatrix1Row3.plus(i12, dMatrix1Row2.get(i8) * d3);
                    i12++;
                    i8++;
                }
                i6 = i11;
            }
            i3 += dMatrix1Row3.numCols;
            i2 = i9 + 1;
        }
    }

    public static void multAdd_small(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numCols != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numRows != dMatrix1Row3.numRows || dMatrix1Row2.numCols != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < dMatrix1Row.numRows; i3++) {
            int i4 = 0;
            while (i4 < dMatrix1Row2.numCols) {
                int i5 = dMatrix1Row2.numRows + i;
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i6 = i4;
                for (int i7 = i; i7 < i5; i7++) {
                    d2 += dMatrix1Row.get(i7) * dMatrix1Row2.get(i6);
                    i6 += dMatrix1Row2.numCols;
                }
                dMatrix1Row3.plus(i2, d2 * d);
                i4++;
                i2++;
            }
            i += dMatrix1Row.numCols;
        }
    }

    public static void multAdd_aux(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3, double[] dArr) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numCols != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numRows != dMatrix1Row3.numRows || dMatrix1Row2.numCols != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        double[] dArr2 = dArr == null ? new double[dMatrix1Row2.numRows] : dArr;
        for (int i = 0; i < dMatrix1Row2.numCols; i++) {
            for (int i2 = 0; i2 < dMatrix1Row2.numRows; i2++) {
                dArr2[i2] = dMatrix1Row2.unsafe_get(i2, i);
            }
            int i3 = 0;
            for (int i4 = 0; i4 < dMatrix1Row.numRows; i4++) {
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i5 = 0;
                while (i5 < dMatrix1Row2.numRows) {
                    d2 += dMatrix1Row.get(i3) * dArr2[i5];
                    i5++;
                    i3++;
                }
                dMatrix1Row3.plus((dMatrix1Row3.numCols * i4) + i, d2 * d);
            }
        }
    }

    public static void multAddTransA_reorder(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numRows != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numCols != dMatrix1Row3.numRows || dMatrix1Row2.numCols != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (dMatrix1Row.numCols == 0 || dMatrix1Row.numRows == 0) {
            return;
        }
        for (int i = 0; i < dMatrix1Row.numCols; i++) {
            int i2 = dMatrix1Row3.numCols * i;
            double d2 = dMatrix1Row.get(i) * d;
            int i3 = dMatrix1Row2.numCols;
            int i4 = 0;
            int i5 = i2;
            while (i4 < i3) {
                dMatrix1Row3.plus(i5, dMatrix1Row2.get(i4) * d2);
                i5++;
                i4++;
            }
            for (int i6 = 1; i6 < dMatrix1Row.numRows; i6++) {
                double dUnsafe_get = dMatrix1Row.unsafe_get(i6, i) * d;
                int i7 = dMatrix1Row2.numCols + i4;
                int i8 = i2;
                while (i4 < i7) {
                    dMatrix1Row3.plus(i8, dMatrix1Row2.get(i4) * dUnsafe_get);
                    i8++;
                    i4++;
                }
            }
        }
    }

    public static void multAddTransA_small(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numRows != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numCols != dMatrix1Row3.numRows || dMatrix1Row2.numCols != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < dMatrix1Row.numCols; i2++) {
            int i3 = 0;
            while (i3 < dMatrix1Row2.numCols) {
                int i4 = (dMatrix1Row2.numRows * dMatrix1Row2.numCols) + i3;
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i5 = i2;
                int i6 = i3;
                while (i6 < i4) {
                    d2 += dMatrix1Row.get(i5) * dMatrix1Row2.get(i6);
                    i5 += dMatrix1Row.numCols;
                    i6 += dMatrix1Row2.numCols;
                }
                dMatrix1Row3.plus(i, d2 * d);
                i3++;
                i++;
            }
        }
    }

    public static void multAddTransAB(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numRows != dMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numCols != dMatrix1Row3.numRows || dMatrix1Row2.numRows != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < dMatrix1Row.numCols; i2++) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < dMatrix1Row2.numRows) {
                int i5 = dMatrix1Row2.numCols + i4;
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i6 = i2;
                while (i4 < i5) {
                    d2 += dMatrix1Row.get(i6) * dMatrix1Row2.get(i4);
                    i6 += dMatrix1Row.numCols;
                    i4++;
                }
                dMatrix1Row3.plus(i, d2 * d);
                i3++;
                i++;
            }
        }
    }

    public static void multAddTransAB_aux(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3, double[] dArr) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numRows != dMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numCols != dMatrix1Row3.numRows || dMatrix1Row2.numRows != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        double[] dArr2 = dArr == null ? new double[dMatrix1Row.numRows] : dArr;
        if (dMatrix1Row.numCols == 0 || dMatrix1Row.numRows == 0) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < dMatrix1Row.numCols; i2++) {
            for (int i3 = 0; i3 < dMatrix1Row2.numCols; i3++) {
                dArr2[i3] = dMatrix1Row.unsafe_get(i3, i2);
            }
            int i4 = 0;
            while (i4 < dMatrix1Row2.numRows) {
                double dUnsafe_get = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i5 = 0; i5 < dMatrix1Row2.numCols; i5++) {
                    dUnsafe_get += dArr2[i5] * dMatrix1Row2.unsafe_get(i4, i5);
                }
                dMatrix1Row3.plus(i, dUnsafe_get * d);
                i4++;
                i++;
            }
        }
    }

    public static void multAddTransB(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row == dMatrix1Row3 || dMatrix1Row2 == dMatrix1Row3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (dMatrix1Row.numCols != dMatrix1Row2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (dMatrix1Row.numRows != dMatrix1Row3.numRows || dMatrix1Row2.numRows != dMatrix1Row3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < dMatrix1Row.numRows; i3++) {
            int i4 = dMatrix1Row2.numCols + i;
            int i5 = 0;
            int i6 = 0;
            while (i5 < dMatrix1Row2.numRows) {
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i7 = i; i7 < i4; i7++) {
                    d2 += dMatrix1Row.get(i7) * dMatrix1Row2.get(i6);
                    i6++;
                }
                dMatrix1Row3.plus(i2, d2 * d);
                i5++;
                i2++;
            }
            i += dMatrix1Row.numCols;
        }
    }
}
