package org.ejml.dense.block.decomposition.bidiagonal;

import org.ejml.data.FSubmatrixD1;
import org.ejml.dense.block.decomposition.p045qr.BlockHouseHolder_FDRB;

/* JADX INFO: loaded from: classes9.dex */
public class BidiagonalHelper_FDRB {
    public static boolean bidiagOuterBlocks(int i, FSubmatrixD1 fSubmatrixD1, float[] fArr, float[] fArr2) {
        int iMin = Math.min(Math.min(i, fSubmatrixD1.col1 - fSubmatrixD1.col0), Math.min(i, fSubmatrixD1.row1 - fSubmatrixD1.row0));
        int i2 = 0;
        while (i2 < iMin) {
            if (!BlockHouseHolder_FDRB.computeHouseHolderCol(i, fSubmatrixD1, fArr, i2)) {
                return false;
            }
            BlockHouseHolder_FDRB.rank1UpdateMultR_Col(i, fSubmatrixD1, i2, fArr[fSubmatrixD1.col0 + i2]);
            BlockHouseHolder_FDRB.rank1UpdateMultR_TopRow(i, fSubmatrixD1, i2, fArr[fSubmatrixD1.col0 + i2]);
            System.out.println("After column stuff");
            fSubmatrixD1.original.print();
            if (!BlockHouseHolder_FDRB.computeHouseHolderRow(i, fSubmatrixD1, fArr2, i2)) {
                return false;
            }
            int i3 = i2 + 1;
            BlockHouseHolder_FDRB.rank1UpdateMultL_Row(i, fSubmatrixD1, i2, i3, fArr2[fSubmatrixD1.row0 + i2]);
            System.out.println("After update row");
            fSubmatrixD1.original.print();
            System.out.println("After row stuff");
            fSubmatrixD1.original.print();
            i2 = i3;
        }
        return true;
    }
}
