package org.ejml.dense.row.misc;

import org.ejml.data.DMatrix1Row;

/* JADX INFO: loaded from: classes9.dex */
public class TransposeAlgs_DDRM {
    public static void square(DMatrix1Row dMatrix1Row) {
        int i = dMatrix1Row.numCols;
        int i2 = 1;
        int i3 = 0;
        while (i3 < dMatrix1Row.numRows) {
            int i4 = i3 + 1;
            int i5 = (dMatrix1Row.numCols * i4) + i3;
            while (i2 < i) {
                double d = dMatrix1Row.data[i2];
                dMatrix1Row.data[i2] = dMatrix1Row.data[i5];
                dMatrix1Row.data[i5] = d;
                i2++;
                i5 += dMatrix1Row.numCols;
            }
            i2 += i3 + 2;
            i += dMatrix1Row.numCols;
            i3 = i4;
        }
    }

    public static void block(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, int i) {
        int i2 = 0;
        while (i2 < dMatrix1Row.numRows) {
            int iMin = Math.min(i, dMatrix1Row.numRows - i2);
            int i3 = dMatrix1Row.numCols * i2;
            int i4 = 0;
            int i5 = i2;
            while (i4 < dMatrix1Row.numCols) {
                int iMin2 = Math.min(i, dMatrix1Row.numCols - i4) + i3;
                while (i3 < iMin2) {
                    int i6 = i5 + iMin;
                    int i7 = i3;
                    for (int i8 = i5; i8 < i6; i8++) {
                        dMatrix1Row2.data[i8] = dMatrix1Row.data[i7];
                        i7 += dMatrix1Row.numCols;
                    }
                    i5 += dMatrix1Row2.numCols;
                    i3++;
                }
                i4 += i;
            }
            i2 += i;
        }
    }

    public static void standard(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2) {
        int i = 0;
        for (int i2 = 0; i2 < dMatrix1Row2.numRows; i2++) {
            int i3 = dMatrix1Row2.numCols + i;
            int i4 = i2;
            while (i < i3) {
                dMatrix1Row2.data[i] = dMatrix1Row.data[i4];
                i4 += dMatrix1Row.numCols;
                i++;
            }
        }
    }
}
