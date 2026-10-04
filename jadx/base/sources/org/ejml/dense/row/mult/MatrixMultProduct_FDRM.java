package org.ejml.dense.row.mult;

import org.ejml.data.FMatrix1Row;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixMultProduct_FDRM {
    public static void outer(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2) {
        for (int i = 0; i < fMatrix1Row.numRows; i++) {
            int i2 = (fMatrix1Row2.numCols * i) + i;
            int i3 = i;
            int i4 = i2;
            while (i3 < fMatrix1Row.numRows) {
                int i5 = fMatrix1Row.numCols * i;
                int i6 = fMatrix1Row.numCols * i3;
                int i7 = fMatrix1Row.numCols + i5;
                float f = 0.0f;
                while (i5 < i7) {
                    f += fMatrix1Row.data[i5] * fMatrix1Row.data[i6];
                    i5++;
                    i6++;
                }
                float[] fArr = fMatrix1Row2.data;
                fMatrix1Row2.data[i2] = f;
                fArr[i4] = f;
                i3++;
                i4 += fMatrix1Row2.numCols;
                i2++;
            }
        }
    }

    public static void inner_small(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2) {
        for (int i = 0; i < fMatrix1Row.numCols; i++) {
            for (int i2 = i; i2 < fMatrix1Row.numCols; i2++) {
                int i3 = (fMatrix1Row2.numCols * i) + i2;
                int i4 = (fMatrix1Row2.numCols * i2) + i;
                int i5 = (fMatrix1Row.numRows * fMatrix1Row.numCols) + i;
                float f = 0.0f;
                int i6 = i;
                int i7 = i2;
                while (i6 < i5) {
                    f += fMatrix1Row.data[i6] * fMatrix1Row.data[i7];
                    i6 += fMatrix1Row.numCols;
                    i7 += fMatrix1Row.numCols;
                }
                float[] fArr = fMatrix1Row2.data;
                fMatrix1Row2.data[i4] = f;
                fArr[i3] = f;
            }
        }
    }

    public static void inner_reorder(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2) {
        for (int i = 0; i < fMatrix1Row.numCols; i++) {
            int i2 = (fMatrix1Row2.numCols * i) + i;
            float f = fMatrix1Row.data[i];
            int i3 = i;
            while (i3 < fMatrix1Row.numCols) {
                fMatrix1Row2.data[i2] = fMatrix1Row.data[i3] * f;
                i3++;
                i2++;
            }
            for (int i4 = 1; i4 < fMatrix1Row.numRows; i4++) {
                int i5 = (fMatrix1Row2.numCols * i) + i;
                int i6 = (fMatrix1Row.numCols * i4) + i;
                float f2 = fMatrix1Row.data[i6];
                int i7 = i;
                while (i7 < fMatrix1Row.numCols) {
                    float[] fArr = fMatrix1Row2.data;
                    fArr[i5] = fArr[i5] + (fMatrix1Row.data[i6] * f2);
                    i7++;
                    i5++;
                    i6++;
                }
            }
            int i8 = (fMatrix1Row2.numCols * i) + i;
            int i9 = i;
            int i10 = i8;
            while (i9 < fMatrix1Row.numCols) {
                fMatrix1Row2.data[i8] = fMatrix1Row2.data[i10];
                i9++;
                i8 += fMatrix1Row2.numCols;
                i10++;
            }
        }
    }

    public static void inner_reorder_upper(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2) {
        for (int i = 0; i < fMatrix1Row.numCols; i++) {
            int i2 = (fMatrix1Row2.numCols * i) + i;
            float f = fMatrix1Row.data[i];
            int i3 = i;
            while (i3 < fMatrix1Row.numCols) {
                fMatrix1Row2.data[i2] = fMatrix1Row.data[i3] * f;
                i3++;
                i2++;
            }
            for (int i4 = 1; i4 < fMatrix1Row.numRows; i4++) {
                int i5 = (fMatrix1Row2.numCols * i) + i;
                int i6 = (fMatrix1Row.numCols * i4) + i;
                float f2 = fMatrix1Row.data[i6];
                int i7 = i;
                while (i7 < fMatrix1Row.numCols) {
                    float[] fArr = fMatrix1Row2.data;
                    fArr[i5] = fArr[i5] + (fMatrix1Row.data[i6] * f2);
                    i7++;
                    i5++;
                    i6++;
                }
            }
        }
    }
}
