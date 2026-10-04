package org.ejml.sparse.csc.misc;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import org.ejml.data.DGrowArray;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.data.IGrowArray;

/* JADX INFO: loaded from: classes9.dex */
public class TriangularSolver_DSCC {
    public static void solveL(DMatrixSparseCSC dMatrixSparseCSC, double[] dArr) {
        int i = dMatrixSparseCSC.numCols;
        int i2 = 0;
        int i3 = dMatrixSparseCSC.col_idx[0];
        while (i2 < i) {
            int i4 = i2 + 1;
            int i5 = dMatrixSparseCSC.col_idx[i4];
            double d = dArr[i2] / dMatrixSparseCSC.nz_values[i3];
            dArr[i2] = d;
            while (true) {
                i3++;
                if (i3 < i5) {
                    int i6 = dMatrixSparseCSC.nz_rows[i3];
                    dArr[i6] = dArr[i6] - (dMatrixSparseCSC.nz_values[i3] * d);
                }
            }
            i3 = i5;
            i2 = i4;
        }
    }

    public static void solveTranL(DMatrixSparseCSC dMatrixSparseCSC, double[] dArr) {
        for (int i = dMatrixSparseCSC.numCols - 1; i >= 0; i--) {
            int i2 = dMatrixSparseCSC.col_idx[i];
            int i3 = dMatrixSparseCSC.col_idx[i + 1];
            for (int i4 = i2 + 1; i4 < i3; i4++) {
                dArr[i] = dArr[i] - (dMatrixSparseCSC.nz_values[i4] * dArr[dMatrixSparseCSC.nz_rows[i4]]);
            }
            dArr[i] = dArr[i] / dMatrixSparseCSC.nz_values[i2];
        }
    }

    public static void solveU(DMatrixSparseCSC dMatrixSparseCSC, double[] dArr) {
        int i = dMatrixSparseCSC.numCols;
        int i2 = dMatrixSparseCSC.col_idx[i];
        int i3 = i - 1;
        while (i3 >= 0) {
            int i4 = dMatrixSparseCSC.col_idx[i3];
            int i5 = i2 - 1;
            double d = dArr[i3] / dMatrixSparseCSC.nz_values[i5];
            dArr[i3] = d;
            for (int i6 = i4; i6 < i5; i6++) {
                int i7 = dMatrixSparseCSC.nz_rows[i6];
                dArr[i7] = dArr[i7] - (dMatrixSparseCSC.nz_values[i6] * d);
            }
            i3--;
            i2 = i4;
        }
    }

    public static void solve(DMatrixSparseCSC dMatrixSparseCSC, boolean z, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3, DGrowArray dGrowArray, IGrowArray iGrowArray, IGrowArray iGrowArray2) {
        double[] dArrAdjust = adjust(dGrowArray, dMatrixSparseCSC.numRows);
        IGrowArray iGrowArray3 = iGrowArray == null ? new IGrowArray() : iGrowArray;
        int[] iArrAdjust = adjust(iGrowArray3, dMatrixSparseCSC.numRows);
        dMatrixSparseCSC3.nz_length = 0;
        dMatrixSparseCSC3.col_idx[0] = 0;
        dMatrixSparseCSC3.indicesSorted = false;
        int i = 0;
        while (i < dMatrixSparseCSC2.numCols) {
            int iSolve = solve(dMatrixSparseCSC, z, dMatrixSparseCSC2, i, dArrAdjust, null, iGrowArray3, iGrowArray2);
            int i2 = dMatrixSparseCSC3.numRows - iSolve;
            if (dMatrixSparseCSC3.nz_values.length < dMatrixSparseCSC3.nz_length + i2) {
                dMatrixSparseCSC3.growMaxLength((dMatrixSparseCSC3.nz_length * 2) + i2, true);
            }
            while (iSolve < dMatrixSparseCSC3.numRows) {
                dMatrixSparseCSC3.nz_rows[dMatrixSparseCSC3.nz_length] = iArrAdjust[iSolve];
                dMatrixSparseCSC3.nz_values[dMatrixSparseCSC3.nz_length] = dArrAdjust[iArrAdjust[iSolve]];
                iSolve++;
                dMatrixSparseCSC3.nz_length++;
            }
            i++;
            dMatrixSparseCSC3.col_idx[i] = dMatrixSparseCSC3.nz_length;
        }
    }

    public static int solve(DMatrixSparseCSC dMatrixSparseCSC, boolean z, DMatrixSparseCSC dMatrixSparseCSC2, int i, double[] dArr, int[] iArr, IGrowArray iGrowArray, IGrowArray iGrowArray2) {
        int i2;
        int i3;
        int[] iArrAdjust = adjust(iGrowArray, dMatrixSparseCSC.numCols);
        int iSearchNzRowsInB = searchNzRowsInB(dMatrixSparseCSC, dMatrixSparseCSC2, i, iArr, iArrAdjust, iGrowArray2);
        for (int i4 = iSearchNzRowsInB; i4 < dMatrixSparseCSC.numCols; i4++) {
            dArr[iArrAdjust[i4]] = 0.0d;
        }
        int i5 = dMatrixSparseCSC2.col_idx[i + 1];
        for (int i6 = dMatrixSparseCSC2.col_idx[i]; i6 < i5; i6++) {
            dArr[dMatrixSparseCSC2.nz_rows[i6]] = dMatrixSparseCSC2.nz_values[i6];
        }
        for (int i7 = iSearchNzRowsInB; i7 < dMatrixSparseCSC.numRows; i7++) {
            int i8 = iArrAdjust[i7];
            int i9 = iArr != null ? iArr[i8] : i8;
            if (i9 >= 0) {
                if (z) {
                    dArr[i8] = dArr[i8] / dMatrixSparseCSC.nz_values[dMatrixSparseCSC.col_idx[i9]];
                    i2 = dMatrixSparseCSC.col_idx[i9] + 1;
                    i3 = dMatrixSparseCSC.col_idx[i9 + 1];
                } else {
                    dArr[i8] = dArr[i8] / dMatrixSparseCSC.nz_values[dMatrixSparseCSC.col_idx[r10] - 1];
                    i2 = dMatrixSparseCSC.col_idx[i9];
                    i3 = dMatrixSparseCSC.col_idx[i9 + 1] - 1;
                }
                while (i2 < i3) {
                    int i10 = dMatrixSparseCSC.nz_rows[i2];
                    dArr[i10] = dArr[i10] - (dMatrixSparseCSC.nz_values[i2] * dArr[i8]);
                    i2++;
                }
            }
        }
        return iSearchNzRowsInB;
    }

    public static int searchNzRowsInB(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, int i, int[] iArr, int[] iArr2, IGrowArray iGrowArray) {
        if (iArr2.length < dMatrixSparseCSC2.numRows) {
            throw new IllegalArgumentException("xi must be at least this long: " + dMatrixSparseCSC2.numRows);
        }
        int[] iArrAdjust = adjust(iGrowArray, dMatrixSparseCSC2.numRows * 2, dMatrixSparseCSC2.numRows);
        int i2 = dMatrixSparseCSC2.col_idx[i];
        int i3 = dMatrixSparseCSC2.col_idx[i + 1];
        int iSearchNzRowsInB_DFS = dMatrixSparseCSC.numRows;
        while (i2 < i3) {
            int i4 = dMatrixSparseCSC2.nz_rows[i2];
            DMatrixSparseCSC dMatrixSparseCSC3 = dMatrixSparseCSC;
            int[] iArr3 = iArr;
            int[] iArr4 = iArr2;
            if (iArrAdjust[i4] == 0) {
                iSearchNzRowsInB_DFS = searchNzRowsInB_DFS(i4, dMatrixSparseCSC3, iSearchNzRowsInB_DFS, iArr3, iArr4, iArrAdjust);
            }
            i2++;
            dMatrixSparseCSC = dMatrixSparseCSC3;
            iArr = iArr3;
            iArr2 = iArr4;
        }
        return iSearchNzRowsInB_DFS;
    }

    private static int searchNzRowsInB_DFS(int i, DMatrixSparseCSC dMatrixSparseCSC, int i2, int[] iArr, int[] iArr2, int[] iArr3) {
        int i3 = dMatrixSparseCSC.numRows;
        iArr2[0] = i;
        int i4 = 0;
        while (i4 >= 0) {
            int i5 = iArr2[i4];
            int i6 = iArr != null ? iArr[i5] : i5;
            boolean z = true;
            if (iArr3[i5] == 0) {
                iArr3[i5] = 1;
                iArr3[i3 + i4] = i6 < 0 ? 0 : dMatrixSparseCSC.col_idx[i6];
            }
            int i7 = i3 + i4;
            int i8 = iArr3[i7];
            int i9 = i6 < 0 ? 0 : dMatrixSparseCSC.col_idx[i6 + 1];
            while (true) {
                if (i8 >= i9) {
                    break;
                }
                int i10 = dMatrixSparseCSC.nz_rows[i8];
                if (iArr3[i10] == 0) {
                    iArr3[i7] = i8 + 1;
                    i4++;
                    iArr2[i4] = i10;
                    z = false;
                    break;
                }
                i8++;
            }
            if (z) {
                i4--;
                i2--;
                iArr2[i2] = i5;
            }
        }
        return i2;
    }

    public static void eliminationTree(DMatrixSparseCSC dMatrixSparseCSC, boolean z, int[] iArr, IGrowArray iGrowArray) {
        int i = dMatrixSparseCSC.numRows;
        int i2 = dMatrixSparseCSC.numCols;
        if (iArr.length < i2) {
            throw new IllegalArgumentException("parent must be of length N");
        }
        int i3 = 0;
        int[] iArrAdjust = adjust(iGrowArray, (z ? i : 0) + i2);
        if (z) {
            for (int i4 = 0; i4 < i; i4++) {
                iArrAdjust[i2 + i4] = -1;
            }
        }
        while (i3 < i2) {
            iArr[i3] = -1;
            iArrAdjust[i3] = -1;
            int i5 = i3 + 1;
            int i6 = dMatrixSparseCSC.col_idx[i5];
            for (int i7 = dMatrixSparseCSC.col_idx[i3]; i7 < i6; i7++) {
                int i8 = dMatrixSparseCSC.nz_rows[i7];
                int i9 = z ? iArrAdjust[i2 + i8] : i8;
                while (true) {
                    if (i9 == -1 || i9 >= i3) {
                        break;
                    }
                    int i10 = iArrAdjust[i9];
                    iArrAdjust[i9] = i3;
                    if (i10 == -1) {
                        iArr[i9] = i3;
                        break;
                    }
                    i9 = i10;
                }
                if (z) {
                    iArrAdjust[i8 + i2] = i3;
                }
            }
            i3 = i5;
        }
    }

    public static void postorder(int[] iArr, int i, int[] iArr2, IGrowArray iGrowArray) {
        if (iArr.length < i) {
            throw new IllegalArgumentException("parent must be at least of length N");
        }
        if (iArr2.length < i) {
            throw new IllegalArgumentException("post must be at least of length N");
        }
        int[] iArrAdjust = adjust(iGrowArray, i * 3);
        for (int i2 = 0; i2 < i; i2++) {
            iArrAdjust[i2] = -1;
        }
        for (int i3 = i - 1; i3 >= 0; i3--) {
            int i4 = iArr[i3];
            if (i4 != -1) {
                iArrAdjust[i + i3] = iArrAdjust[i4];
                iArrAdjust[iArr[i3]] = i3;
            }
        }
        int iPostorder_dfs = 0;
        for (int i5 = 0; i5 < i; i5++) {
            if (iArr[i5] == -1) {
                iPostorder_dfs = postorder_dfs(i5, iPostorder_dfs, iArrAdjust, iArr2, i);
            }
        }
    }

    protected static int postorder_dfs(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        int i4 = i3 * 2;
        iArr[i4] = i;
        int i5 = 0;
        while (i5 >= 0) {
            int i6 = iArr[i4 + i5];
            int i7 = iArr[i6];
            if (i7 == -1) {
                i5--;
                iArr2[i2] = i6;
                i2++;
            } else {
                iArr[i6] = iArr[i3 + i7];
                i5++;
                iArr[i4 + i5] = i7;
            }
        }
        return i2;
    }

    public static int searchNzRowsElim(DMatrixSparseCSC dMatrixSparseCSC, int i, int[] iArr, int[] iArr2, int[] iArr3) {
        int i2 = dMatrixSparseCSC.numCols;
        int i3 = dMatrixSparseCSC.col_idx[i + 1];
        iArr3[i] = (-iArr3[i]) - 2;
        for (int i4 = dMatrixSparseCSC.col_idx[i]; i4 < i3; i4++) {
            int i5 = dMatrixSparseCSC.nz_rows[i4];
            if (i5 <= i) {
                int i6 = 0;
                while (iArr3[i5] >= 0) {
                    iArr2[i6] = i5;
                    iArr3[i5] = (-iArr3[i5]) - 2;
                    i5 = iArr[i5];
                    i6++;
                }
                while (i6 > 0) {
                    i2--;
                    i6--;
                    iArr2[i2] = iArr2[i6];
                }
            }
        }
        for (int i7 = i2; i7 < dMatrixSparseCSC.numCols; i7++) {
            iArr3[iArr2[i7]] = (-iArr3[r1]) - 2;
        }
        iArr3[i] = (-iArr3[i]) - 2;
        return i2;
    }

    public static int[] adjust(IGrowArray iGrowArray, int i) {
        if (iGrowArray == null) {
            iGrowArray = new IGrowArray();
        }
        iGrowArray.reshape(i);
        return iGrowArray.data;
    }

    public static int[] adjust(IGrowArray iGrowArray, int i, int i2) {
        int[] iArrAdjust = adjust(iGrowArray, i);
        Arrays.fill(iArrAdjust, 0, i2, 0);
        return iArrAdjust;
    }

    public static int[] adjustClear(IGrowArray iGrowArray, int i) {
        return adjust(iGrowArray, i, i);
    }

    public static double[] adjust(DGrowArray dGrowArray, int i) {
        if (dGrowArray == null) {
            dGrowArray = new DGrowArray();
        }
        dGrowArray.reshape(i);
        return dGrowArray.data;
    }

    public static double qualityTriangular(DMatrixSparseCSC dMatrixSparseCSC) {
        int iMin = Math.min(dMatrixSparseCSC.numRows, dMatrixSparseCSC.numCols);
        double dUnsafe_get = dMatrixSparseCSC.unsafe_get(0, 0);
        for (int i = 1; i < iMin; i++) {
            dUnsafe_get = Math.max(dUnsafe_get, Math.abs(dMatrixSparseCSC.unsafe_get(i, i)));
        }
        if (dUnsafe_get == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double dUnsafe_get2 = 1.0d;
        for (int i2 = 0; i2 < iMin; i2++) {
            dUnsafe_get2 *= dMatrixSparseCSC.unsafe_get(i2, i2) / dUnsafe_get;
        }
        return Math.abs(dUnsafe_get2);
    }
}
