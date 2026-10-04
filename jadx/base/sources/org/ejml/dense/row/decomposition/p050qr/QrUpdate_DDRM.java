package org.ejml.dense.row.decomposition.p050qr;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;

/* JADX INFO: loaded from: classes9.dex */
public class QrUpdate_DDRM {

    /* JADX INFO: renamed from: Q */
    private DMatrixRMaj f2633Q;

    /* JADX INFO: renamed from: Qm */
    private DMatrixRMaj f2634Qm;

    /* JADX INFO: renamed from: R */
    private DMatrixRMaj f2635R;
    private DMatrixRMaj U_tran;
    private boolean autoGrow;

    /* JADX INFO: renamed from: m */
    private int f2636m;
    private int m_m;
    private int maxCols;
    private int maxRows;

    /* JADX INFO: renamed from: n */
    private int f2637n;
    private double[] r_row;

    public QrUpdate_DDRM(int i, int i2) {
        this.autoGrow = false;
        declareInternalData(i, i2);
    }

    public QrUpdate_DDRM(int i, int i2, boolean z) {
        this.autoGrow = z;
        declareInternalData(i, i2);
    }

    public QrUpdate_DDRM() {
        this.autoGrow = true;
    }

    public void declareInternalData(int i, int i2) {
        this.maxRows = i;
        this.maxCols = i2;
        this.U_tran = new DMatrixRMaj(i, i);
        this.f2634Qm = new DMatrixRMaj(i, i);
        this.r_row = new double[i2];
    }

    public void addRow(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, double[] dArr, int i, boolean z) {
        setQR(dMatrixRMaj, dMatrixRMaj2, 1);
        this.m_m = this.f2636m + 1;
        int length = dMatrixRMaj.data.length;
        int i2 = this.m_m;
        if (length < i2 * i2) {
            throw new IllegalArgumentException("Q matrix does not have enough data to grow");
        }
        if (z && dMatrixRMaj2.data.length < this.m_m * this.f2637n) {
            throw new IllegalArgumentException("R matrix does not have enough data to grow");
        }
        if (z) {
            dMatrixRMaj2.reshape(this.m_m, this.f2637n, false);
        }
        DMatrixRMaj dMatrixRMaj3 = this.U_tran;
        int i3 = this.m_m;
        dMatrixRMaj3.reshape(i3, i3, false);
        applyFirstGivens(dArr);
        applyLaterGivens();
        updateInsertQ(i);
        this.f2635R = null;
        this.f2633Q = null;
    }

    public void deleteRow(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, int i, boolean z) {
        setQR(dMatrixRMaj, dMatrixRMaj2, 0);
        int i2 = this.f2636m;
        if (i2 - 1 < this.f2637n) {
            throw new IllegalArgumentException("Removing any row would make the system under determined.");
        }
        this.m_m = i2 - 1;
        this.U_tran.reshape(i2, i2, false);
        if (z) {
            dMatrixRMaj2.reshape(this.m_m, this.f2637n, false);
        }
        computeRemoveGivens(i);
        updateRemoveQ(i);
        updateRemoveR();
        this.f2635R = null;
        this.f2633Q = null;
    }

    private void setQR(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, int i) {
        if (dMatrixRMaj.numRows != dMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Q should be square.");
        }
        this.f2633Q = dMatrixRMaj;
        this.f2635R = dMatrixRMaj2;
        this.f2636m = dMatrixRMaj.numRows;
        int i2 = dMatrixRMaj2.numCols;
        this.f2637n = i2;
        int i3 = this.f2636m;
        if (i3 + i > this.maxRows || i2 > this.maxCols) {
            if (this.autoGrow) {
                declareInternalData(i3 + i, i2);
                return;
            }
            throw new IllegalArgumentException("Autogrow has been set to false and the maximum number of rows or columns has been exceeded.");
        }
    }

    private void updateInsertQ(int i) {
        this.f2634Qm.set((DMatrixD1) this.f2633Q);
        DMatrixRMaj dMatrixRMaj = this.f2633Q;
        int i2 = this.m_m;
        dMatrixRMaj.reshape(i2, i2, false);
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 0; i4 < this.m_m; i4++) {
                double d = 0.0d;
                for (int i5 = 0; i5 < this.f2636m; i5++) {
                    d += this.f2634Qm.data[(this.f2636m * i3) + i5] * this.U_tran.data[(this.m_m * i4) + i5 + 1];
                }
                this.f2633Q.data[(this.m_m * i3) + i4] = d;
            }
        }
        for (int i6 = 0; i6 < this.m_m; i6++) {
            this.f2633Q.data[(this.m_m * i) + i6] = this.U_tran.data[this.m_m * i6];
        }
        while (true) {
            i++;
            if (i >= this.m_m) {
                return;
            }
            for (int i7 = 0; i7 < this.m_m; i7++) {
                double d2 = 0.0d;
                for (int i8 = 0; i8 < this.f2636m; i8++) {
                    d2 += this.f2634Qm.data[((i - 1) * this.f2636m) + i8] * this.U_tran.data[(this.m_m * i7) + i8 + 1];
                }
                this.f2633Q.data[(this.m_m * i) + i7] = d2;
            }
        }
    }

    private void updateRemoveQ(int i) {
        this.f2634Qm.set((DMatrixD1) this.f2633Q);
        DMatrixRMaj dMatrixRMaj = this.f2633Q;
        int i2 = this.m_m;
        dMatrixRMaj.reshape(i2, i2, false);
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 1; i4 < this.f2636m; i4++) {
                double d = 0.0d;
                for (int i5 = 0; i5 < this.f2636m; i5++) {
                    d += this.f2634Qm.data[(this.f2636m * i3) + i5] * this.U_tran.data[(this.f2636m * i4) + i5];
                }
                this.f2633Q.data[((this.m_m * i3) + i4) - 1] = d;
            }
        }
        for (int i6 = i + 1; i6 < this.f2636m; i6++) {
            for (int i7 = 1; i7 < this.f2636m; i7++) {
                double d2 = 0.0d;
                for (int i8 = 0; i8 < this.f2636m; i8++) {
                    d2 += this.f2634Qm.data[(this.f2636m * i6) + i8] * this.U_tran.data[(this.f2636m * i7) + i8];
                }
                this.f2633Q.data[(((i6 - 1) * this.m_m) + i7) - 1] = d2;
            }
        }
    }

    private void updateRemoveR() {
        for (int i = 1; i < this.f2637n + 1; i++) {
            for (int i2 = 0; i2 < this.f2637n; i2++) {
                int i3 = i - 1;
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i4 = i3; i4 <= i2; i4++) {
                    d += this.U_tran.data[(this.f2636m * i) + i4] * this.f2635R.data[(this.f2637n * i4) + i2];
                }
                this.f2635R.data[(i3 * this.f2637n) + i2] = d;
            }
        }
    }

    private void applyFirstGivens(double[] dArr) {
        double d;
        double d2 = dArr[0];
        double d3 = this.f2635R.data[0];
        double dSqrt = (d2 * d2) + (d3 * d3);
        double d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (dSqrt != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            dSqrt = Math.sqrt(dSqrt);
            d = d2 / dSqrt;
            d4 = d3 / dSqrt;
        } else {
            d = 1.0d;
        }
        this.f2635R.data[0] = dSqrt;
        for (int i = 1; i < this.f2637n; i++) {
            double d5 = dArr[i];
            double d6 = this.f2635R.data[i];
            this.f2635R.data[i] = (d * d5) + (d4 * d6);
            this.r_row[i] = (d6 * d) - (d5 * d4);
        }
        CommonOps_DDRM.setIdentity(this.U_tran);
        this.U_tran.data[0] = d;
        this.U_tran.data[1] = d4;
        this.U_tran.data[this.m_m] = -d4;
        this.U_tran.data[this.m_m + 1] = d;
    }

    private void applyLaterGivens() {
        double d;
        int i = 1;
        while (i < this.f2637n) {
            double d2 = this.r_row[i];
            double d3 = this.f2635R.data[(this.f2637n * i) + i];
            double dSqrt = (d2 * d2) + (d3 * d3);
            double d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (dSqrt != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                dSqrt = Math.sqrt(dSqrt);
                d = d2 / dSqrt;
                d4 = d3 / dSqrt;
            } else {
                d = 1.0d;
            }
            this.f2635R.data[(this.f2637n * i) + i] = dSqrt;
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.f2637n; i3++) {
                double d5 = this.r_row[i3];
                double d6 = this.f2635R.data[(this.f2637n * i) + i3];
                this.f2635R.data[(this.f2637n * i) + i3] = (d * d5) + (d4 * d6);
                this.r_row[i3] = (d6 * d) - (d5 * d4);
            }
            for (int i4 = 0; i4 <= i2; i4++) {
                double d7 = this.U_tran.data[(this.m_m * i) + i4];
                double d8 = this.U_tran.data[(this.m_m * i2) + i4];
                this.U_tran.data[(this.m_m * i) + i4] = (d * d7) + (d4 * d8);
                this.U_tran.data[(this.m_m * i2) + i4] = (d8 * d) - (d7 * d4);
            }
            i = i2;
        }
    }

    private void computeRemoveGivens(int i) {
        double d;
        CommonOps_DDRM.setIdentity(this.U_tran);
        double[] dArr = this.f2633Q.data;
        int i2 = this.f2636m;
        double d2 = dArr[((i * i2) + i2) - 1];
        for (int i3 = i2 - 2; i3 >= 0; i3--) {
            double d3 = this.f2633Q.data[(this.f2636m * i) + i3];
            double dSqrt = (d3 * d3) + (d2 * d2);
            double d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (dSqrt != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                dSqrt = Math.sqrt(dSqrt);
                d = d3 / dSqrt;
                d4 = d2 / dSqrt;
            } else {
                d = 1.0d;
            }
            d2 = dSqrt;
            for (int i4 = i3; i4 < this.f2636m; i4++) {
                double d5 = this.U_tran.data[(this.f2636m * i3) + i4];
                int i5 = i3 + 1;
                double d6 = this.U_tran.data[(this.f2636m * i5) + i4];
                this.U_tran.data[(this.f2636m * i3) + i4] = (d * d5) + (d4 * d6);
                this.U_tran.data[(i5 * this.f2636m) + i4] = (d6 * d) - (d5 * d4);
            }
        }
    }

    public DMatrixRMaj getU_tran() {
        return this.U_tran;
    }
}
