package org.ejml.sparse.csc.decomposition.p054qr;

import java.util.Arrays;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.data.IGrowArray;
import org.ejml.sparse.csc.misc.ColumnCounts_DSCC;
import org.ejml.sparse.csc.misc.TriangularSolver_DSCC;

/* JADX INFO: loaded from: classes9.dex */
public class QrStructuralCounts_DSCC {

    /* JADX INFO: renamed from: A */
    DMatrixSparseCSC f2777A;
    int head;

    /* JADX INFO: renamed from: m */
    int f2778m;

    /* JADX INFO: renamed from: m2 */
    int f2779m2;

    /* JADX INFO: renamed from: n */
    int f2780n;
    int next;
    int nque;
    int nz_in_R;
    int nz_in_V;
    int tail;
    int[] leftmost = new int[0];
    int[] pinv = new int[0];
    int[] parent = new int[0];
    int[] post = new int[0];
    IGrowArray gwork = new IGrowArray();
    int[] countsR = new int[0];
    ColumnCounts_DSCC columnCounts = new ColumnCounts_DSCC(true);

    public boolean process(DMatrixSparseCSC dMatrixSparseCSC) {
        init(dMatrixSparseCSC);
        TriangularSolver_DSCC.eliminationTree(dMatrixSparseCSC, true, this.parent, this.gwork);
        countNonZeroInR(this.parent);
        countNonZeroInV(this.parent);
        if (this.f2778m < this.f2780n) {
            for (int i = 0; i < this.f2778m; i++) {
                if (this.gwork.data[this.head + i] < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    void init(DMatrixSparseCSC dMatrixSparseCSC) {
        this.f2777A = dMatrixSparseCSC;
        this.f2778m = dMatrixSparseCSC.numRows;
        int i = dMatrixSparseCSC.numCols;
        this.f2780n = i;
        this.next = 0;
        int i2 = this.f2778m;
        this.head = i2;
        this.tail = i2 + i;
        this.nque = (i * 2) + i2;
        if (this.parent.length < i || this.leftmost.length < i2) {
            this.parent = new int[i];
            this.post = new int[i];
            this.pinv = new int[i2 + i];
            this.countsR = new int[i];
            this.leftmost = new int[i2];
        }
        this.gwork.reshape(i2 + (i * 3));
    }

    void countNonZeroInR(int[] iArr) {
        TriangularSolver_DSCC.postorder(iArr, this.f2780n, this.post, this.gwork);
        this.columnCounts.process(this.f2777A, iArr, this.post, this.countsR);
        this.nz_in_R = 0;
        for (int i = 0; i < this.f2780n; i++) {
            this.nz_in_R += this.countsR[i];
        }
        if (this.nz_in_R < 0) {
            throw new RuntimeException("Too many elements. Numerical overflow in R counts");
        }
    }

    void countNonZeroInV(int[] iArr) {
        int[] iArr2 = this.gwork.data;
        findMinElementIndexInRows(this.leftmost);
        createRowElementLinkedLists(this.leftmost, iArr2);
        countNonZeroUsingLinkedList(iArr, iArr2);
    }

    void countNonZeroUsingLinkedList(int[] iArr, int[] iArr2) {
        int i;
        Arrays.fill(this.pinv, 0, this.f2778m, -1);
        this.nz_in_V = 0;
        this.f2779m2 = this.f2778m;
        int i2 = 0;
        while (true) {
            i = this.f2780n;
            if (i2 >= i) {
                break;
            }
            int i3 = this.head;
            int i4 = iArr2[i3 + i2];
            int i5 = this.nz_in_V + 1;
            this.nz_in_V = i5;
            if (i4 < 0) {
                i4 = this.f2779m2;
                this.f2779m2 = i4 + 1;
            }
            this.pinv[i4] = i2;
            int i6 = this.nque;
            int i7 = i6 + i2;
            int i8 = iArr2[i7] - 1;
            iArr2[i7] = i8;
            if (i8 > 0) {
                this.nz_in_V = i5 + iArr2[i6 + i2];
                int i9 = iArr[i2];
                if (i9 != -1) {
                    if (iArr2[i6 + i9] == 0) {
                        int i10 = this.tail;
                        iArr2[i10 + i9] = iArr2[i10 + i2];
                    }
                    int i11 = this.next;
                    iArr2[iArr2[this.tail + i2] + i11] = iArr2[i3 + i9];
                    iArr2[i3 + i9] = iArr2[i11 + i4];
                    int i12 = i9 + i6;
                    iArr2[i12] = iArr2[i12] + iArr2[i6 + i2];
                }
            }
            i2++;
        }
        for (int i13 = 0; i13 < this.f2778m; i13++) {
            int[] iArr3 = this.pinv;
            if (iArr3[i13] < 0) {
                iArr3[i13] = i;
                i++;
            }
        }
        if (this.nz_in_V < 0) {
            throw new RuntimeException("Too many elements. Numerical overflow in V counts");
        }
    }

    void createRowElementLinkedLists(int[] iArr, int[] iArr2) {
        for (int i = 0; i < this.f2780n; i++) {
            iArr2[this.head + i] = -1;
            iArr2[this.tail + i] = -1;
            iArr2[this.nque + i] = 0;
        }
        for (int i2 = this.f2778m - 1; i2 >= 0; i2--) {
            int i3 = iArr[i2];
            if (i3 != -1) {
                int i4 = this.nque + i3;
                int i5 = iArr2[i4];
                iArr2[i4] = i5 + 1;
                if (i5 == 0) {
                    iArr2[this.tail + i3] = i2;
                }
                int i6 = this.next + i2;
                int i7 = this.head;
                iArr2[i6] = iArr2[i7 + i3];
                iArr2[i7 + i3] = i2;
            }
        }
    }

    void findMinElementIndexInRows(int[] iArr) {
        Arrays.fill(iArr, 0, this.f2778m, -1);
        for (int i = this.f2780n - 1; i >= 0; i--) {
            int i2 = this.f2777A.col_idx[i + 1];
            for (int i3 = this.f2777A.col_idx[i]; i3 < i2; i3++) {
                iArr[this.f2777A.nz_rows[i3]] = i;
            }
        }
    }

    public void setGwork(IGrowArray iGrowArray) {
        this.gwork = iGrowArray;
    }

    public int getFicticousRowCount() {
        return this.f2779m2;
    }

    public int[] getLeftMost() {
        return this.leftmost;
    }

    public int[] getParent() {
        return this.parent;
    }

    public int[] getPinv() {
        return this.pinv;
    }

    public int getM2() {
        return this.f2779m2;
    }
}
