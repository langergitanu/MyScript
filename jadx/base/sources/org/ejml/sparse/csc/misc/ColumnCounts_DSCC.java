package org.ejml.sparse.csc.misc;

import java.util.Arrays;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.data.IGrowArray;
import org.ejml.sparse.csc.CommonOps_DSCC;

/* JADX INFO: loaded from: classes9.dex */
public class ColumnCounts_DSCC {
    int ancestor;
    private boolean ata;
    int first;
    int head;
    int jleaf;

    /* JADX INFO: renamed from: m */
    int f2793m;
    int maxfirst;

    /* JADX INFO: renamed from: n */
    int f2794n;
    int next;
    int prevleaf;

    /* JADX INFO: renamed from: w */
    int[] f2795w;

    /* JADX INFO: renamed from: At */
    private DMatrixSparseCSC f2791At = new DMatrixSparseCSC(1, 1, 1);

    /* JADX INFO: renamed from: gw */
    IGrowArray f2792gw = new IGrowArray();

    public ColumnCounts_DSCC(boolean z) {
        this.ata = z;
    }

    void initialize(DMatrixSparseCSC dMatrixSparseCSC) {
        this.f2793m = dMatrixSparseCSC.numRows;
        int i = dMatrixSparseCSC.numCols;
        this.f2794n = i;
        int i2 = (i * 4) + (this.ata ? i + this.f2793m + 1 : 0);
        this.f2792gw.reshape(i2);
        this.f2795w = this.f2792gw.data;
        this.f2791At.reshape(dMatrixSparseCSC.numCols, dMatrixSparseCSC.numRows, dMatrixSparseCSC.nz_length);
        CommonOps_DSCC.transpose(dMatrixSparseCSC, this.f2791At, this.f2792gw);
        Arrays.fill(this.f2795w, 0, i2, -1);
        this.ancestor = 0;
        int i3 = this.f2794n;
        this.maxfirst = i3;
        this.prevleaf = i3 * 2;
        this.first = i3 * 3;
    }

    public void process(DMatrixSparseCSC dMatrixSparseCSC, int[] iArr, int[] iArr2, int[] iArr3) {
        if (iArr3.length < dMatrixSparseCSC.numCols) {
            throw new IllegalArgumentException("counts must be at least of length A.numCols");
        }
        initialize(dMatrixSparseCSC);
        findFirstDescendant(iArr, iArr2, iArr3);
        if (this.ata) {
            init_ata(iArr2);
        }
        for (int i = 0; i < this.f2794n; i++) {
            this.f2795w[this.ancestor + i] = i;
        }
        int[] iArr4 = this.f2791At.col_idx;
        int[] iArr5 = this.f2791At.nz_rows;
        for (int i2 = 0; i2 < this.f2794n; i2++) {
            int i3 = iArr2[i2];
            int i4 = iArr[i3];
            if (i4 != -1) {
                iArr3[i4] = iArr3[i4] - 1;
            }
            int iHEAD = HEAD(i2, i3);
            while (iHEAD != -1) {
                for (int i5 = iArr4[iHEAD]; i5 < iArr4[iHEAD + 1]; i5++) {
                    int iIsLeaf = isLeaf(iArr5[i5], i3);
                    int i6 = this.jleaf;
                    if (i6 >= 1) {
                        iArr3[i3] = iArr3[i3] + 1;
                    }
                    if (i6 == 2) {
                        iArr3[iIsLeaf] = iArr3[iIsLeaf] - 1;
                    }
                }
                iHEAD = NEXT(iHEAD);
            }
            int i7 = iArr[i3];
            if (i7 != -1) {
                this.f2795w[this.ancestor + i3] = i7;
            }
        }
        for (int i8 = 0; i8 < this.f2794n; i8++) {
            int i9 = iArr[i8];
            if (i9 != -1) {
                iArr3[i9] = iArr3[i9] + iArr3[i8];
            }
        }
    }

    void findFirstDescendant(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i = 0; i < this.f2794n; i++) {
            int i2 = iArr2[i];
            iArr3[i2] = this.f2795w[this.first + i2] == -1 ? 1 : 0;
            while (i2 != -1) {
                int[] iArr4 = this.f2795w;
                int i3 = this.first;
                if (iArr4[i3 + i2] == -1) {
                    iArr4[i3 + i2] = i;
                    i2 = iArr[i2];
                }
            }
        }
    }

    private int HEAD(int i, int i2) {
        return this.ata ? this.f2795w[this.head + i] : i2;
    }

    private int NEXT(int i) {
        if (this.ata) {
            return this.f2795w[this.next + i];
        }
        return -1;
    }

    private void init_ata(int[] iArr) {
        int i;
        int[] iArr2 = this.f2791At.col_idx;
        int[] iArr3 = this.f2791At.nz_rows;
        int i2 = this.f2794n;
        this.head = i2 * 4;
        this.next = (i2 * 5) + 1;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f2794n; i4++) {
            this.f2795w[iArr[i4]] = i4;
        }
        while (i3 < this.f2793m) {
            int iMin = this.f2794n;
            int i5 = iArr2[i3];
            while (true) {
                i = i3 + 1;
                if (i5 < iArr2[i]) {
                    iMin = Math.min(iMin, this.f2795w[iArr3[i5]]);
                    i5++;
                }
            }
            int[] iArr4 = this.f2795w;
            int i6 = this.next + i3;
            int i7 = this.head;
            iArr4[i6] = iArr4[i7 + iMin];
            iArr4[i7 + iMin] = i3;
            i3 = i;
        }
    }

    int isLeaf(int i, int i2) {
        this.jleaf = 0;
        if (i > i2) {
            int[] iArr = this.f2795w;
            int i3 = this.first;
            int i4 = iArr[i3 + i2];
            int i5 = this.maxfirst;
            if (i4 > iArr[i5 + i]) {
                iArr[i5 + i] = iArr[i3 + i2];
                int i6 = this.prevleaf;
                int i7 = iArr[i6 + i];
                iArr[i6 + i] = i2;
                if (i7 == -1) {
                    this.jleaf = 1;
                    return i;
                }
                this.jleaf = 2;
                int i8 = i7;
                while (true) {
                    int[] iArr2 = this.f2795w;
                    int i9 = this.ancestor;
                    if (i8 == iArr2[i9 + i8]) {
                        break;
                    }
                    i8 = iArr2[i9 + i8];
                }
                while (i7 != i8) {
                    int[] iArr3 = this.f2795w;
                    int i10 = this.ancestor;
                    int i11 = iArr3[i10 + i7];
                    iArr3[i10 + i7] = i8;
                    i7 = i11;
                }
                return i8;
            }
        }
        return -1;
    }

    int[] getW() {
        return this.f2795w;
    }
}
