package org.ejml.dense.row.misc;

import org.ejml.data.FMatrix1Row;

/* JADX INFO: loaded from: classes9.dex */
public class TransposeAlgs_FDRM {
    public static void square(FMatrix1Row fMatrix1Row) {
        int i = fMatrix1Row.numCols;
        int i2 = 1;
        int i3 = 0;
        while (i3 < fMatrix1Row.numRows) {
            int i4 = i3 + 1;
            int i5 = (fMatrix1Row.numCols * i4) + i3;
            while (i2 < i) {
                float f = fMatrix1Row.data[i2];
                fMatrix1Row.data[i2] = fMatrix1Row.data[i5];
                fMatrix1Row.data[i5] = f;
                i2++;
                i5 += fMatrix1Row.numCols;
            }
            i2 += i3 + 2;
            i += fMatrix1Row.numCols;
            i3 = i4;
        }
    }

    public static void block(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, int i) {
        int i2 = 0;
        while (i2 < fMatrix1Row.numRows) {
            int iMin = Math.min(i, fMatrix1Row.numRows - i2);
            int i3 = fMatrix1Row.numCols * i2;
            int i4 = 0;
            int i5 = i2;
            while (i4 < fMatrix1Row.numCols) {
                int iMin2 = Math.min(i, fMatrix1Row.numCols - i4) + i3;
                while (i3 < iMin2) {
                    int i6 = i5 + iMin;
                    int i7 = i3;
                    for (int i8 = i5; i8 < i6; i8++) {
                        fMatrix1Row2.data[i8] = fMatrix1Row.data[i7];
                        i7 += fMatrix1Row.numCols;
                    }
                    i5 += fMatrix1Row2.numCols;
                    i3++;
                }
                i4 += i;
            }
            i2 += i;
        }
    }

    public static void standard(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2) {
        int i = 0;
        for (int i2 = 0; i2 < fMatrix1Row2.numRows; i2++) {
            int i3 = fMatrix1Row2.numCols + i;
            int i4 = i2;
            while (i < i3) {
                fMatrix1Row2.data[i] = fMatrix1Row.data[i4];
                i4 += fMatrix1Row.numCols;
                i++;
            }
        }
    }
}
