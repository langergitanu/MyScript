package org.ejml.dense.block.decomposition.bidiagonal;

import org.ejml.data.DSubmatrixD1;
import org.ejml.dense.block.decomposition.p045qr.BlockHouseHolder_DDRB;

/* JADX INFO: loaded from: classes9.dex */
public class BidiagonalHelper_DDRB {
    public static boolean bidiagOuterBlocks(int i, DSubmatrixD1 dSubmatrixD1, double[] dArr, double[] dArr2) {
        int iMin = Math.min(Math.min(i, dSubmatrixD1.col1 - dSubmatrixD1.col0), Math.min(i, dSubmatrixD1.row1 - dSubmatrixD1.row0));
        int i2 = 0;
        while (i2 < iMin) {
            if (!BlockHouseHolder_DDRB.computeHouseHolderCol(i, dSubmatrixD1, dArr, i2)) {
                return false;
            }
            BlockHouseHolder_DDRB.rank1UpdateMultR_Col(i, dSubmatrixD1, i2, dArr[dSubmatrixD1.col0 + i2]);
            BlockHouseHolder_DDRB.rank1UpdateMultR_TopRow(i, dSubmatrixD1, i2, dArr[dSubmatrixD1.col0 + i2]);
            System.out.println("After column stuff");
            dSubmatrixD1.original.print();
            if (!BlockHouseHolder_DDRB.computeHouseHolderRow(i, dSubmatrixD1, dArr2, i2)) {
                return false;
            }
            int i3 = i2 + 1;
            int i4 = i;
            DSubmatrixD1 dSubmatrixD12 = dSubmatrixD1;
            BlockHouseHolder_DDRB.rank1UpdateMultL_Row(i4, dSubmatrixD12, i2, i3, dArr2[dSubmatrixD1.row0 + i2]);
            System.out.println("After update row");
            dSubmatrixD12.original.print();
            System.out.println("After row stuff");
            dSubmatrixD12.original.print();
            i = i4;
            dSubmatrixD1 = dSubmatrixD12;
            i2 = i3;
        }
        return true;
    }
}
