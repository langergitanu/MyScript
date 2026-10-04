package org.ejml.dense.row.decomposition.p050qr;

import org.ejml.data.FMatrixD1;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;

/* JADX INFO: loaded from: classes9.dex */
public class QrUpdate_FDRM {

    /* JADX INFO: renamed from: Q */
    private FMatrixRMaj f2638Q;

    /* JADX INFO: renamed from: Qm */
    private FMatrixRMaj f2639Qm;

    /* JADX INFO: renamed from: R */
    private FMatrixRMaj f2640R;
    private FMatrixRMaj U_tran;
    private boolean autoGrow;

    /* JADX INFO: renamed from: m */
    private int f2641m;
    private int m_m;
    private int maxCols;
    private int maxRows;

    /* JADX INFO: renamed from: n */
    private int f2642n;
    private float[] r_row;

    public QrUpdate_FDRM(int i, int i2) {
        this.autoGrow = false;
        declareInternalData(i, i2);
    }

    public QrUpdate_FDRM(int i, int i2, boolean z) {
        this.autoGrow = z;
        declareInternalData(i, i2);
    }

    public QrUpdate_FDRM() {
        this.autoGrow = true;
    }

    public void declareInternalData(int i, int i2) {
        this.maxRows = i;
        this.maxCols = i2;
        this.U_tran = new FMatrixRMaj(i, i);
        this.f2639Qm = new FMatrixRMaj(i, i);
        this.r_row = new float[i2];
    }

    public void addRow(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, float[] fArr, int i, boolean z) {
        setQR(fMatrixRMaj, fMatrixRMaj2, 1);
        this.m_m = this.f2641m + 1;
        int length = fMatrixRMaj.data.length;
        int i2 = this.m_m;
        if (length < i2 * i2) {
            throw new IllegalArgumentException("Q matrix does not have enough data to grow");
        }
        if (z && fMatrixRMaj2.data.length < this.m_m * this.f2642n) {
            throw new IllegalArgumentException("R matrix does not have enough data to grow");
        }
        if (z) {
            fMatrixRMaj2.reshape(this.m_m, this.f2642n, false);
        }
        FMatrixRMaj fMatrixRMaj3 = this.U_tran;
        int i3 = this.m_m;
        fMatrixRMaj3.reshape(i3, i3, false);
        applyFirstGivens(fArr);
        applyLaterGivens();
        updateInsertQ(i);
        this.f2640R = null;
        this.f2638Q = null;
    }

    public void deleteRow(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, int i, boolean z) {
        setQR(fMatrixRMaj, fMatrixRMaj2, 0);
        int i2 = this.f2641m;
        if (i2 - 1 < this.f2642n) {
            throw new IllegalArgumentException("Removing any row would make the system under determined.");
        }
        this.m_m = i2 - 1;
        this.U_tran.reshape(i2, i2, false);
        if (z) {
            fMatrixRMaj2.reshape(this.m_m, this.f2642n, false);
        }
        computeRemoveGivens(i);
        updateRemoveQ(i);
        updateRemoveR();
        this.f2640R = null;
        this.f2638Q = null;
    }

    private void setQR(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, int i) {
        if (fMatrixRMaj.numRows != fMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Q should be square.");
        }
        this.f2638Q = fMatrixRMaj;
        this.f2640R = fMatrixRMaj2;
        this.f2641m = fMatrixRMaj.numRows;
        int i2 = fMatrixRMaj2.numCols;
        this.f2642n = i2;
        int i3 = this.f2641m;
        if (i3 + i > this.maxRows || i2 > this.maxCols) {
            if (this.autoGrow) {
                declareInternalData(i3 + i, i2);
                return;
            }
            throw new IllegalArgumentException("Autogrow has been set to false and the maximum number of rows or columns has been exceeded.");
        }
    }

    private void updateInsertQ(int i) {
        this.f2639Qm.set((FMatrixD1) this.f2638Q);
        FMatrixRMaj fMatrixRMaj = this.f2638Q;
        int i2 = this.m_m;
        fMatrixRMaj.reshape(i2, i2, false);
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 0; i4 < this.m_m; i4++) {
                float f = 0.0f;
                for (int i5 = 0; i5 < this.f2641m; i5++) {
                    f += this.f2639Qm.data[(this.f2641m * i3) + i5] * this.U_tran.data[(this.m_m * i4) + i5 + 1];
                }
                this.f2638Q.data[(this.m_m * i3) + i4] = f;
            }
        }
        for (int i6 = 0; i6 < this.m_m; i6++) {
            this.f2638Q.data[(this.m_m * i) + i6] = this.U_tran.data[this.m_m * i6];
        }
        while (true) {
            i++;
            if (i >= this.m_m) {
                return;
            }
            for (int i7 = 0; i7 < this.m_m; i7++) {
                float f2 = 0.0f;
                for (int i8 = 0; i8 < this.f2641m; i8++) {
                    f2 += this.f2639Qm.data[((i - 1) * this.f2641m) + i8] * this.U_tran.data[(this.m_m * i7) + i8 + 1];
                }
                this.f2638Q.data[(this.m_m * i) + i7] = f2;
            }
        }
    }

    private void updateRemoveQ(int i) {
        this.f2639Qm.set((FMatrixD1) this.f2638Q);
        FMatrixRMaj fMatrixRMaj = this.f2638Q;
        int i2 = this.m_m;
        fMatrixRMaj.reshape(i2, i2, false);
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 1; i4 < this.f2641m; i4++) {
                float f = 0.0f;
                for (int i5 = 0; i5 < this.f2641m; i5++) {
                    f += this.f2639Qm.data[(this.f2641m * i3) + i5] * this.U_tran.data[(this.f2641m * i4) + i5];
                }
                this.f2638Q.data[((this.m_m * i3) + i4) - 1] = f;
            }
        }
        for (int i6 = i + 1; i6 < this.f2641m; i6++) {
            for (int i7 = 1; i7 < this.f2641m; i7++) {
                float f2 = 0.0f;
                for (int i8 = 0; i8 < this.f2641m; i8++) {
                    f2 += this.f2639Qm.data[(this.f2641m * i6) + i8] * this.U_tran.data[(this.f2641m * i7) + i8];
                }
                this.f2638Q.data[(((i6 - 1) * this.m_m) + i7) - 1] = f2;
            }
        }
    }

    private void updateRemoveR() {
        for (int i = 1; i < this.f2642n + 1; i++) {
            for (int i2 = 0; i2 < this.f2642n; i2++) {
                int i3 = i - 1;
                float f = 0.0f;
                for (int i4 = i3; i4 <= i2; i4++) {
                    f += this.U_tran.data[(this.f2641m * i) + i4] * this.f2640R.data[(this.f2642n * i4) + i2];
                }
                this.f2640R.data[(i3 * this.f2642n) + i2] = f;
            }
        }
    }

    private void applyFirstGivens(float[] fArr) {
        float f;
        float f2 = fArr[0];
        float f3 = this.f2640R.data[0];
        float fSqrt = (f2 * f2) + (f3 * f3);
        float f4 = 0.0f;
        if (fSqrt != 0.0f) {
            fSqrt = (float) Math.sqrt(fSqrt);
            f = f2 / fSqrt;
            f4 = f3 / fSqrt;
        } else {
            f = 1.0f;
        }
        this.f2640R.data[0] = fSqrt;
        for (int i = 1; i < this.f2642n; i++) {
            float f5 = fArr[i];
            float f6 = this.f2640R.data[i];
            this.f2640R.data[i] = (f * f5) + (f4 * f6);
            this.r_row[i] = (f6 * f) - (f5 * f4);
        }
        CommonOps_FDRM.setIdentity(this.U_tran);
        this.U_tran.data[0] = f;
        this.U_tran.data[1] = f4;
        this.U_tran.data[this.m_m] = -f4;
        this.U_tran.data[this.m_m + 1] = f;
    }

    private void applyLaterGivens() {
        float f;
        int i = 1;
        while (i < this.f2642n) {
            float f2 = this.r_row[i];
            float f3 = this.f2640R.data[(this.f2642n * i) + i];
            float fSqrt = (f2 * f2) + (f3 * f3);
            float f4 = 0.0f;
            if (fSqrt != 0.0f) {
                fSqrt = (float) Math.sqrt(fSqrt);
                f = f2 / fSqrt;
                f4 = f3 / fSqrt;
            } else {
                f = 1.0f;
            }
            this.f2640R.data[(this.f2642n * i) + i] = fSqrt;
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.f2642n; i3++) {
                float f5 = this.r_row[i3];
                float f6 = this.f2640R.data[(this.f2642n * i) + i3];
                this.f2640R.data[(this.f2642n * i) + i3] = (f * f5) + (f4 * f6);
                this.r_row[i3] = (f6 * f) - (f5 * f4);
            }
            for (int i4 = 0; i4 <= i2; i4++) {
                float f7 = this.U_tran.data[(this.m_m * i) + i4];
                float f8 = this.U_tran.data[(this.m_m * i2) + i4];
                this.U_tran.data[(this.m_m * i) + i4] = (f * f7) + (f4 * f8);
                this.U_tran.data[(this.m_m * i2) + i4] = (f8 * f) - (f7 * f4);
            }
            i = i2;
        }
    }

    private void computeRemoveGivens(int i) {
        float f;
        CommonOps_FDRM.setIdentity(this.U_tran);
        float[] fArr = this.f2638Q.data;
        int i2 = this.f2641m;
        float f2 = fArr[((i * i2) + i2) - 1];
        for (int i3 = i2 - 2; i3 >= 0; i3--) {
            float f3 = this.f2638Q.data[(this.f2641m * i) + i3];
            float fSqrt = (f3 * f3) + (f2 * f2);
            float f4 = 0.0f;
            if (fSqrt != 0.0f) {
                fSqrt = (float) Math.sqrt(fSqrt);
                f = f3 / fSqrt;
                f4 = f2 / fSqrt;
            } else {
                f = 1.0f;
            }
            f2 = fSqrt;
            for (int i4 = i3; i4 < this.f2641m; i4++) {
                float f5 = this.U_tran.data[(this.f2641m * i3) + i4];
                int i5 = i3 + 1;
                float f6 = this.U_tran.data[(this.f2641m * i5) + i4];
                this.U_tran.data[(this.f2641m * i3) + i4] = (f * f5) + (f4 * f6);
                this.U_tran.data[(i5 * this.f2641m) + i4] = (f6 * f) - (f5 * f4);
            }
        }
    }

    public FMatrixRMaj getU_tran() {
        return this.U_tran;
    }
}
