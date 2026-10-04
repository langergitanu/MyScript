package org.ejml.dense.block.decomposition.hessenberg;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DSubmatrixD1;
import org.ejml.dense.block.VectorOps_DDRB;
import org.ejml.dense.block.decomposition.p045qr.BlockHouseHolder_DDRB;
import org.ejml.dense.row.CommonOps_DDRM;

/* JADX INFO: loaded from: classes9.dex */
public class TridiagonalHelper_DDRB {
    public static void tridiagUpperRow(int i, DSubmatrixD1 dSubmatrixD1, double[] dArr, DSubmatrixD1 dSubmatrixD12) {
        int iMin = Math.min(i, dSubmatrixD1.row1 - dSubmatrixD1.row0);
        if (iMin <= 1) {
            return;
        }
        int i2 = dSubmatrixD1.col1 - dSubmatrixD1.col0;
        int iMin2 = Math.min(i2 - 1, iMin);
        int iMin3 = Math.min(i2, iMin);
        int i3 = 0;
        while (i3 < iMin2) {
            BlockHouseHolder_DDRB.computeHouseHolderRow(i, dSubmatrixD1, dArr, i3);
            double d = dArr[dSubmatrixD1.row0 + i3];
            int i4 = i;
            DSubmatrixD1 dSubmatrixD13 = dSubmatrixD1;
            DSubmatrixD1 dSubmatrixD14 = dSubmatrixD12;
            computeY(i4, dSubmatrixD13, dSubmatrixD14, i3, d);
            computeRowOfV(i4, dSubmatrixD13, dSubmatrixD14, i3, d);
            i3++;
            if (i3 < iMin3) {
                applyReflectorsToRow(i4, dSubmatrixD13, dSubmatrixD14, i3);
            }
            i = i4;
            dSubmatrixD1 = dSubmatrixD13;
            dSubmatrixD12 = dSubmatrixD14;
        }
    }

    public static void computeW_row(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, double[] dArr, int i2) {
        int i3 = dSubmatrixD1.row1 - dSubmatrixD1.row0;
        CommonOps_DDRM.fill(dSubmatrixD12.original, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        int i4 = i2 + 1;
        BlockHouseHolder_DDRB.scale_row(i, dSubmatrixD1, dSubmatrixD12, 0, 1, -dArr[i2]);
        int iMin = Math.min(i3, dSubmatrixD12.col1 - dSubmatrixD12.col0);
        int i5 = 1;
        while (i5 < iMin) {
            int i6 = i4 + 1;
            double d = -dArr[i4];
            int i7 = 0;
            while (i7 < i5) {
                int i8 = i7;
                VectorOps_DDRB.add_row(i, dSubmatrixD12, i5, 1.0d, dSubmatrixD12, i8, BlockHouseHolder_DDRB.innerProdRow(i, dSubmatrixD1, i5, dSubmatrixD1, i7, 1) * d, dSubmatrixD12, i5, 1, dSubmatrixD1.col1 - dSubmatrixD1.col0);
                i7 = i8 + 1;
                d = d;
            }
            BlockHouseHolder_DDRB.add_row(i, dSubmatrixD1, i5, d, dSubmatrixD12, i5, 1.0d, dSubmatrixD12, i5, 1, dSubmatrixD1.col1 - dSubmatrixD1.col0);
            i5++;
            i4 = i6;
        }
    }

    public static void computeV_blockVector(int i, DSubmatrixD1 dSubmatrixD1, double[] dArr, DSubmatrixD1 dSubmatrixD12) {
        int iMin = Math.min(i, dSubmatrixD1.row1 - dSubmatrixD1.row0);
        if (iMin <= 1) {
            return;
        }
        int iMin2 = Math.min((dSubmatrixD1.col1 - dSubmatrixD1.col0) - 1, iMin);
        for (int i2 = 0; i2 < iMin2; i2++) {
            double d = dArr[dSubmatrixD1.row0 + i2];
            computeY(i, dSubmatrixD1, dSubmatrixD12, i2, d);
            computeRowOfV(i, dSubmatrixD1, dSubmatrixD12, i2, d);
        }
    }

    public static void applyReflectorsToRow(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, int i2) {
        int i3 = i;
        DSubmatrixD1 dSubmatrixD13 = dSubmatrixD12;
        int i4 = i2;
        int iMin = Math.min(i3, dSubmatrixD1.row1 - dSubmatrixD1.row0);
        double[] dArr = dSubmatrixD1.original.data;
        double[] dArr2 = dSubmatrixD13.original.data;
        int i5 = 0;
        while (i5 < i4) {
            int iMin2 = Math.min(i3, dSubmatrixD1.col1 - dSubmatrixD1.col0) * i5;
            int i6 = (dSubmatrixD1.original.numCols * dSubmatrixD1.row0) + (dSubmatrixD1.col0 * iMin) + iMin2 + i4;
            int i7 = (dSubmatrixD13.original.numCols * dSubmatrixD13.row0) + (dSubmatrixD13.col0 * iMin) + iMin2 + i4;
            int i8 = i5 + 1;
            double d = i8 == i4 ? 1.0d : dArr[i6];
            double d2 = dArr2[i7];
            double d3 = dSubmatrixD1.get(i5, i8);
            dSubmatrixD1.set(i5, i8, 1.0d);
            VectorOps_DDRB.add_row(i3, dSubmatrixD1, i4, 1.0d, dSubmatrixD12, i5, d, dSubmatrixD1, i2, i2, dSubmatrixD1.col1 - dSubmatrixD1.col0);
            i3 = i;
            i4 = i2;
            VectorOps_DDRB.add_row(i3, dSubmatrixD1, i4, 1.0d, dSubmatrixD1, i5, d2, dSubmatrixD1, i2, i2, dSubmatrixD1.col1 - dSubmatrixD1.col0);
            dSubmatrixD1.set(i5, i8, d3);
            dSubmatrixD13 = dSubmatrixD12;
            i5 = i8;
            dArr = dArr;
            dArr2 = dArr2;
            iMin = iMin;
        }
    }

    public static void computeY(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, int i2, double d) {
        int i3 = i2;
        multA_u(i, dSubmatrixD1, dSubmatrixD12, i2);
        int i4 = 0;
        while (i4 < i3) {
            double dInnerProdRow = BlockHouseHolder_DDRB.innerProdRow(i, dSubmatrixD1, i3, dSubmatrixD12, i4, 1);
            double dInnerProdRow2 = BlockHouseHolder_DDRB.innerProdRow(i, dSubmatrixD1, i2, dSubmatrixD1, i4, 1);
            int i5 = i2 + 1;
            int i6 = i4;
            i3 = i2;
            VectorOps_DDRB.add_row(i, dSubmatrixD12, i3, 1.0d, dSubmatrixD1, i6, dInnerProdRow, dSubmatrixD12, i2, i5, dSubmatrixD1.col1 - dSubmatrixD1.col0);
            VectorOps_DDRB.add_row(i, dSubmatrixD12, i3, 1.0d, dSubmatrixD12, i6, dInnerProdRow2, dSubmatrixD12, i2, i5, dSubmatrixD1.col1 - dSubmatrixD1.col0);
            i4 = i6 + 1;
        }
        VectorOps_DDRB.scale_row(i, dSubmatrixD12, i2, -d, dSubmatrixD12, i2, i2 + 1, dSubmatrixD12.col1 - dSubmatrixD12.col0);
    }

    public static void multA_u(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, int i2) {
        int i3 = dSubmatrixD1.row1 - dSubmatrixD1.row0;
        int i4 = i2 + 1;
        while (i4 < i3) {
            int i5 = i;
            DSubmatrixD1 dSubmatrixD13 = dSubmatrixD1;
            dSubmatrixD12.set(i2, i4, innerProdRowSymm(i5, dSubmatrixD13, i2, dSubmatrixD1, i4, 1));
            i4++;
            i = i5;
            dSubmatrixD1 = dSubmatrixD13;
        }
    }

    public static double innerProdRowSymm(int i, DSubmatrixD1 dSubmatrixD1, int i2, DSubmatrixD1 dSubmatrixD12, int i3, int i4) {
        int i5 = i4 + i2;
        if (dSubmatrixD12.col0 + i5 >= dSubmatrixD12.col1) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        if (i5 < i3) {
            return dSubmatrixD12.get(i5, i3) + VectorOps_DDRB.dot_row_col(i, dSubmatrixD1, i2, dSubmatrixD12, i3, i5 + 1, i3) + VectorOps_DDRB.dot_row(i, dSubmatrixD1, i2, dSubmatrixD12, i3, i3, dSubmatrixD1.col1 - dSubmatrixD1.col0);
        }
        return dSubmatrixD12.get(i3, i5) + VectorOps_DDRB.dot_row(i, dSubmatrixD1, i2, dSubmatrixD12, i3, i5 + 1, dSubmatrixD1.col1 - dSubmatrixD1.col0);
    }

    public static void computeRowOfV(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, int i2, double d) {
        double dInnerProdRow = BlockHouseHolder_DDRB.innerProdRow(i, dSubmatrixD1, i2, dSubmatrixD12, i2, 1);
        int i3 = i2 + 1;
        double d2 = dSubmatrixD1.get(i2, i3);
        dSubmatrixD1.set(i2, i3, 1.0d);
        VectorOps_DDRB.add_row(i, dSubmatrixD12, i2, 1.0d, dSubmatrixD1, i2, (-0.5d) * d * dInnerProdRow, dSubmatrixD12, i2, i3, dSubmatrixD1.col1 - dSubmatrixD1.col0);
        dSubmatrixD1.set(i2, i3, d2);
    }
}
