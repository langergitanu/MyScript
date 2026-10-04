package org.ejml.dense.row.misc;

import org.ejml.data.DMatrix1Row;
import org.ejml.data.DMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class DeterminantFromMinor_DDRM {
    private boolean dirty;
    private int[] levelIndexes;
    private int[] levelRemoved;
    private double[] levelResults;
    private int minWidth;
    private int numOpen;
    private int[] open;
    private DMatrixRMaj tempMat;
    private int width;

    public DeterminantFromMinor_DDRM(int i) {
        this(i, 5);
    }

    public DeterminantFromMinor_DDRM(int i, int i2) {
        this.dirty = false;
        if (i2 > 5 || i2 < 2) {
            throw new IllegalArgumentException("No direct function for that width");
        }
        i2 = i < i2 ? i : i2;
        this.minWidth = i2;
        this.width = i;
        int i3 = i - (i2 - 2);
        this.levelResults = new double[i3];
        this.levelRemoved = new int[i3];
        this.levelIndexes = new int[i3];
        this.open = new int[i];
        int i4 = i2 - 1;
        this.tempMat = new DMatrixRMaj(i4, i4);
    }

    public double compute(DMatrix1Row dMatrix1Row) {
        if (this.width != dMatrix1Row.numCols || this.width != dMatrix1Row.numRows) {
            throw new RuntimeException("Unexpected matrix dimension");
        }
        initStructures();
        int i = 0;
        while (true) {
            int i2 = this.width;
            int i3 = i2 - i;
            int[] iArr = this.levelIndexes;
            int i4 = iArr[i];
            if (i4 != i3) {
                this.levelRemoved[i] = openRemove(i4);
                if (i3 == this.minWidth) {
                    createMinor(dMatrix1Row);
                    double dDet = dMatrix1Row.get((this.width * i) + this.levelRemoved[i]) * UnrolledDeterminantFromMinor_DDRM.det(this.tempMat);
                    if (i4 % 2 == 0) {
                        double[] dArr = this.levelResults;
                        dArr[i] = dArr[i] + dDet;
                    } else {
                        double[] dArr2 = this.levelResults;
                        dArr2[i] = dArr2[i] - dDet;
                    }
                    putIntoOpen(i);
                    int[] iArr2 = this.levelIndexes;
                    iArr2[i] = iArr2[i] + 1;
                } else {
                    i++;
                }
            } else {
                if (i == 0) {
                    return this.levelResults[0];
                }
                int i5 = i - 1;
                int i6 = iArr[i5];
                iArr[i5] = i6 + 1;
                double d = dMatrix1Row.get((i2 * i5) + this.levelRemoved[i5]);
                if (i6 % 2 == 0) {
                    double[] dArr3 = this.levelResults;
                    dArr3[i5] = dArr3[i5] + (d * dArr3[i]);
                } else {
                    double[] dArr4 = this.levelResults;
                    dArr4[i5] = dArr4[i5] - (d * dArr4[i]);
                }
                putIntoOpen(i5);
                this.levelResults[i] = 0.0d;
                this.levelIndexes[i] = 0;
                i--;
            }
        }
    }

    private void initStructures() {
        int i;
        int i2 = 0;
        while (true) {
            i = this.width;
            if (i2 >= i) {
                break;
            }
            this.open[i2] = i2;
            i2++;
        }
        this.numOpen = i;
        if (this.dirty) {
            int i3 = 0;
            while (true) {
                int[] iArr = this.levelIndexes;
                if (i3 >= iArr.length) {
                    break;
                }
                iArr[i3] = 0;
                this.levelResults[i3] = 0.0d;
                this.levelRemoved[i3] = 0;
                i3++;
            }
        }
        this.dirty = true;
    }

    private int openRemove(int i) {
        int[] iArr = this.open;
        int i2 = iArr[i];
        System.arraycopy(iArr, i + 1, iArr, i, (this.numOpen - i) - 1);
        this.numOpen--;
        return i2;
    }

    private void openAdd(int i, int i2) {
        for (int i3 = this.numOpen; i3 > i; i3--) {
            int[] iArr = this.open;
            iArr[i3] = iArr[i3 - 1];
        }
        this.numOpen++;
        this.open[i] = i2;
    }

    private void openAdd(int i) {
        int[] iArr = this.open;
        int i2 = this.numOpen;
        this.numOpen = i2 + 1;
        iArr[i2] = i;
    }

    private void putIntoOpen(int i) {
        for (int i2 = 0; i2 < this.numOpen; i2++) {
            int i3 = this.open[i2];
            int i4 = this.levelRemoved[i];
            if (i3 > i4) {
                openAdd(i2, i4);
                return;
            }
        }
        openAdd(this.levelRemoved[i]);
    }

    private void createMinor(DMatrix1Row dMatrix1Row) {
        int i = this.minWidth - 1;
        int i2 = this.width;
        int i3 = (i2 - i) * i2;
        for (int i4 = 0; i4 < this.numOpen; i4++) {
            int i5 = this.open[i4] + i3;
            int i6 = i4;
            for (int i7 = 0; i7 < i; i7++) {
                this.tempMat.set(i6, dMatrix1Row.get(i5));
                i6 += i;
                i5 += this.width;
            }
        }
    }
}
