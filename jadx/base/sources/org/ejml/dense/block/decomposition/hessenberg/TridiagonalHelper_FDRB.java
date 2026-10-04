package org.ejml.dense.block.decomposition.hessenberg;

import org.ejml.data.FSubmatrixD1;
import org.ejml.dense.block.VectorOps_FDRB;
import org.ejml.dense.block.decomposition.p045qr.BlockHouseHolder_FDRB;
import org.ejml.dense.row.CommonOps_FDRM;

/* JADX INFO: loaded from: classes9.dex */
public class TridiagonalHelper_FDRB {
    public static void tridiagUpperRow(int i, FSubmatrixD1 fSubmatrixD1, float[] fArr, FSubmatrixD1 fSubmatrixD12) {
        int iMin = Math.min(i, fSubmatrixD1.row1 - fSubmatrixD1.row0);
        if (iMin <= 1) {
            return;
        }
        int i2 = fSubmatrixD1.col1 - fSubmatrixD1.col0;
        int iMin2 = Math.min(i2 - 1, iMin);
        int iMin3 = Math.min(i2, iMin);
        int i3 = 0;
        while (i3 < iMin2) {
            BlockHouseHolder_FDRB.computeHouseHolderRow(i, fSubmatrixD1, fArr, i3);
            float f = fArr[fSubmatrixD1.row0 + i3];
            computeY(i, fSubmatrixD1, fSubmatrixD12, i3, f);
            computeRowOfV(i, fSubmatrixD1, fSubmatrixD12, i3, f);
            i3++;
            if (i3 < iMin3) {
                applyReflectorsToRow(i, fSubmatrixD1, fSubmatrixD12, i3);
            }
        }
    }

    public static void computeW_row(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, float[] fArr, int i2) {
        int i3 = fSubmatrixD1.row1 - fSubmatrixD1.row0;
        CommonOps_FDRM.fill(fSubmatrixD12.original, 0.0f);
        int i4 = i2 + 1;
        BlockHouseHolder_FDRB.scale_row(i, fSubmatrixD1, fSubmatrixD12, 0, 1, -fArr[i2]);
        int iMin = Math.min(i3, fSubmatrixD12.col1 - fSubmatrixD12.col0);
        int i5 = 1;
        while (i5 < iMin) {
            int i6 = i4 + 1;
            float f = -fArr[i4];
            int i7 = 0;
            while (i7 < i5) {
                int i8 = i7;
                VectorOps_FDRB.add_row(i, fSubmatrixD12, i5, 1.0f, fSubmatrixD12, i8, f * BlockHouseHolder_FDRB.innerProdRow(i, fSubmatrixD1, i5, fSubmatrixD1, i7, 1), fSubmatrixD12, i5, 1, fSubmatrixD1.col1 - fSubmatrixD1.col0);
                i7 = i8 + 1;
            }
            BlockHouseHolder_FDRB.add_row(i, fSubmatrixD1, i5, f, fSubmatrixD12, i5, 1.0f, fSubmatrixD12, i5, 1, fSubmatrixD1.col1 - fSubmatrixD1.col0);
            i5++;
            i4 = i6;
        }
    }

    public static void computeV_blockVector(int i, FSubmatrixD1 fSubmatrixD1, float[] fArr, FSubmatrixD1 fSubmatrixD12) {
        int iMin = Math.min(i, fSubmatrixD1.row1 - fSubmatrixD1.row0);
        if (iMin <= 1) {
            return;
        }
        int iMin2 = Math.min((fSubmatrixD1.col1 - fSubmatrixD1.col0) - 1, iMin);
        for (int i2 = 0; i2 < iMin2; i2++) {
            float f = fArr[fSubmatrixD1.row0 + i2];
            computeY(i, fSubmatrixD1, fSubmatrixD12, i2, f);
            computeRowOfV(i, fSubmatrixD1, fSubmatrixD12, i2, f);
        }
    }

    public static void applyReflectorsToRow(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, int i2) {
        int i3 = i;
        FSubmatrixD1 fSubmatrixD13 = fSubmatrixD12;
        int i4 = i2;
        int iMin = Math.min(i3, fSubmatrixD1.row1 - fSubmatrixD1.row0);
        float[] fArr = fSubmatrixD1.original.data;
        float[] fArr2 = fSubmatrixD13.original.data;
        int i5 = 0;
        while (i5 < i4) {
            int iMin2 = Math.min(i3, fSubmatrixD1.col1 - fSubmatrixD1.col0) * i5;
            int i6 = (fSubmatrixD1.original.numCols * fSubmatrixD1.row0) + (fSubmatrixD1.col0 * iMin) + iMin2 + i4;
            int i7 = (fSubmatrixD13.original.numCols * fSubmatrixD13.row0) + (fSubmatrixD13.col0 * iMin) + iMin2 + i4;
            int i8 = i5 + 1;
            float f = i8 == i4 ? 1.0f : fArr[i6];
            float f2 = fArr2[i7];
            float f3 = fSubmatrixD1.get(i5, i8);
            fSubmatrixD1.set(i5, i8, 1.0f);
            VectorOps_FDRB.add_row(i3, fSubmatrixD1, i4, 1.0f, fSubmatrixD13, i5, f, fSubmatrixD1, i2, i2, fSubmatrixD1.col1 - fSubmatrixD1.col0);
            i3 = i;
            i4 = i2;
            VectorOps_FDRB.add_row(i3, fSubmatrixD1, i4, 1.0f, fSubmatrixD1, i5, f2, fSubmatrixD1, i2, i2, fSubmatrixD1.col1 - fSubmatrixD1.col0);
            fSubmatrixD1.set(i5, i8, f3);
            fSubmatrixD13 = fSubmatrixD12;
            i5 = i8;
            iMin = iMin;
        }
    }

    public static void computeY(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, int i2, float f) {
        int i3 = i2;
        multA_u(i, fSubmatrixD1, fSubmatrixD12, i2);
        int i4 = 0;
        while (i4 < i3) {
            float fInnerProdRow = BlockHouseHolder_FDRB.innerProdRow(i, fSubmatrixD1, i3, fSubmatrixD12, i4, 1);
            float fInnerProdRow2 = BlockHouseHolder_FDRB.innerProdRow(i, fSubmatrixD1, i2, fSubmatrixD1, i4, 1);
            int i5 = i2 + 1;
            i3 = i2;
            int i6 = i4;
            VectorOps_FDRB.add_row(i, fSubmatrixD12, i3, 1.0f, fSubmatrixD1, i6, fInnerProdRow, fSubmatrixD12, i2, i5, fSubmatrixD1.col1 - fSubmatrixD1.col0);
            VectorOps_FDRB.add_row(i, fSubmatrixD12, i3, 1.0f, fSubmatrixD12, i6, fInnerProdRow2, fSubmatrixD12, i2, i5, fSubmatrixD1.col1 - fSubmatrixD1.col0);
            i4 = i6 + 1;
        }
        VectorOps_FDRB.scale_row(i, fSubmatrixD12, i2, -f, fSubmatrixD12, i2, i2 + 1, fSubmatrixD12.col1 - fSubmatrixD12.col0);
    }

    public static void multA_u(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, int i2) {
        int i3 = fSubmatrixD1.row1 - fSubmatrixD1.row0;
        int i4 = i2 + 1;
        while (i4 < i3) {
            int i5 = i;
            fSubmatrixD12.set(i2, i4, innerProdRowSymm(i5, fSubmatrixD1, i2, fSubmatrixD1, i4, 1));
            i4++;
            i = i5;
        }
    }

    public static float innerProdRowSymm(int i, FSubmatrixD1 fSubmatrixD1, int i2, FSubmatrixD1 fSubmatrixD12, int i3, int i4) {
        int i5 = i4 + i2;
        if (fSubmatrixD12.col0 + i5 >= fSubmatrixD12.col1) {
            return 0.0f;
        }
        if (i5 < i3) {
            return fSubmatrixD12.get(i5, i3) + VectorOps_FDRB.dot_row_col(i, fSubmatrixD1, i2, fSubmatrixD12, i3, i5 + 1, i3) + VectorOps_FDRB.dot_row(i, fSubmatrixD1, i2, fSubmatrixD12, i3, i3, fSubmatrixD1.col1 - fSubmatrixD1.col0);
        }
        return fSubmatrixD12.get(i3, i5) + VectorOps_FDRB.dot_row(i, fSubmatrixD1, i2, fSubmatrixD12, i3, i5 + 1, fSubmatrixD1.col1 - fSubmatrixD1.col0);
    }

    public static void computeRowOfV(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, int i2, float f) {
        float fInnerProdRow = BlockHouseHolder_FDRB.innerProdRow(i, fSubmatrixD1, i2, fSubmatrixD12, i2, 1);
        int i3 = i2 + 1;
        float f2 = fSubmatrixD1.get(i2, i3);
        fSubmatrixD1.set(i2, i3, 1.0f);
        VectorOps_FDRB.add_row(i, fSubmatrixD12, i2, 1.0f, fSubmatrixD1, i2, f * (-0.5f) * fInnerProdRow, fSubmatrixD12, i2, i3, fSubmatrixD1.col1 - fSubmatrixD1.col0);
        fSubmatrixD1.set(i2, i3, f2);
    }
}
