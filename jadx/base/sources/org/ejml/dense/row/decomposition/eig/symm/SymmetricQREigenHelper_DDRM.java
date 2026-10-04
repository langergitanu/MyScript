package org.ejml.dense.row.decomposition.eig.symm;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Random;
import org.ejml.UtilEjml;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.decomposition.eig.EigenvalueSmall_F64;

/* JADX INFO: loaded from: classes9.dex */
public class SymmetricQREigenHelper_DDRM {

    /* JADX INFO: renamed from: N */
    protected int f2549N;

    /* JADX INFO: renamed from: Q */
    protected DMatrixRMaj f2550Q;
    private double bulge;

    /* JADX INFO: renamed from: c */
    private double f2551c;

    /* JADX INFO: renamed from: c2 */
    private double f2552c2;

    /* JADX INFO: renamed from: cs */
    private double f2553cs;
    protected double[] diag;
    protected int lastExceptional;
    protected int numExceptional;
    protected int numSplits;
    protected double[] off;

    /* JADX INFO: renamed from: s */
    private double f2554s;

    /* JADX INFO: renamed from: s2 */
    private double f2555s2;
    protected int steps;

    /* JADX INFO: renamed from: x1 */
    protected int f2556x1;

    /* JADX INFO: renamed from: x2 */
    protected int f2557x2;
    protected Random rand = new Random(3434270);
    protected EigenvalueSmall_F64 eigenSmall = new EigenvalueSmall_F64();
    protected int[] splits = new int[1];

    public void printMatrix() {
        System.out.print("Off Diag[ ");
        for (int i = 0; i < this.f2549N - 1; i++) {
            System.out.printf("%5.2f ", Double.valueOf(this.off[i]));
        }
        System.out.println();
        System.out.print("    Diag[ ");
        for (int i2 = 0; i2 < this.f2549N; i2++) {
            System.out.printf("%5.2f ", Double.valueOf(this.diag[i2]));
        }
        System.out.println();
    }

    public void setQ(DMatrixRMaj dMatrixRMaj) {
        this.f2550Q = dMatrixRMaj;
    }

    public void incrementSteps() {
        this.steps++;
    }

    public void init(double[] dArr, double[] dArr2, int i) {
        reset(i);
        this.diag = dArr;
        this.off = dArr2;
    }

    public double[] swapDiag(double[] dArr) {
        double[] dArr2 = this.diag;
        this.diag = dArr;
        return dArr2;
    }

    public double[] swapOff(double[] dArr) {
        double[] dArr2 = this.off;
        this.off = dArr;
        return dArr2;
    }

    public void reset(int i) {
        this.f2549N = i;
        this.diag = null;
        this.off = null;
        if (this.splits.length < i) {
            this.splits = new int[i];
        }
        this.numSplits = 0;
        this.f2556x1 = 0;
        this.f2557x2 = i - 1;
        this.lastExceptional = 0;
        this.numExceptional = 0;
        this.steps = 0;
        this.f2550Q = null;
    }

    public double[] copyDiag(double[] dArr) {
        if (dArr == null || dArr.length < this.f2549N) {
            dArr = new double[this.f2549N];
        }
        System.arraycopy(this.diag, 0, dArr, 0, this.f2549N);
        return dArr;
    }

    public double[] copyOff(double[] dArr) {
        if (dArr == null || dArr.length < this.f2549N - 1) {
            dArr = new double[this.f2549N - 1];
        }
        System.arraycopy(this.off, 0, dArr, 0, this.f2549N - 1);
        return dArr;
    }

    public double[] copyEigenvalues(double[] dArr) {
        if (dArr == null || dArr.length < this.f2549N) {
            dArr = new double[this.f2549N];
        }
        System.arraycopy(this.diag, 0, dArr, 0, this.f2549N);
        return dArr;
    }

    public void setSubmatrix(int i, int i2) {
        this.f2556x1 = i;
        this.f2557x2 = i2;
    }

    protected boolean isZero(int i) {
        return Math.abs(this.off[i]) <= (Math.abs(this.diag[i]) + Math.abs(this.diag[i + 1])) * UtilEjml.EPS;
    }

    protected void performImplicitSingleStep(double d, boolean z) {
        int i;
        int i2 = this.f2557x2;
        int i3 = this.f2556x1;
        if (i2 - i3 == 1) {
            createBulge2by2(i3, d, z);
            return;
        }
        createBulge(i3, d, z);
        int i4 = this.f2556x1;
        while (true) {
            i = this.f2557x2;
            if (i4 >= i - 2 || this.bulge == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                break;
            }
            removeBulge(i4);
            i4++;
        }
        if (this.bulge != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            removeBulgeEnd(i - 2);
        }
    }

    protected void updateQ(int i, int i2, double d, double d2) {
        int i3 = this.f2549N;
        int i4 = i * i3;
        int i5 = i2 * i3;
        int i6 = i3 + i4;
        while (i4 < i6) {
            double d3 = this.f2550Q.data[i4];
            double d4 = this.f2550Q.data[i5];
            this.f2550Q.data[i4] = (d * d3) + (d2 * d4);
            this.f2550Q.data[i5] = ((-d2) * d3) + (d4 * d);
            i5++;
            i4++;
        }
    }

    protected void createBulge(int i, double d, boolean z) {
        int i2;
        double[] dArr = this.diag;
        double d2 = dArr[i];
        int i3 = i + 1;
        double d3 = dArr[i3];
        double[] dArr2 = this.off;
        double d4 = dArr2[i];
        double d5 = dArr2[i3];
        if (z) {
            this.f2551c = Math.cos(d);
            double dSin = Math.sin(d);
            this.f2554s = dSin;
            double d6 = this.f2551c;
            i2 = i3;
            this.f2552c2 = d6 * d6;
            this.f2555s2 = dSin * dSin;
            this.f2553cs = d6 * dSin;
        } else {
            i2 = i3;
            computeRotation(d2 - d, d4);
        }
        double[] dArr3 = this.diag;
        double d7 = this.f2552c2;
        double d8 = this.f2553cs;
        double d9 = (d7 * d2) + (d8 * 2.0d * d4);
        double d10 = this.f2555s2;
        dArr3[i] = d9 + (d10 * d3);
        dArr3[i2] = ((d7 * d3) - ((2.0d * d8) * d4)) + (d10 * d2);
        double[] dArr4 = this.off;
        dArr4[i] = (d4 * (d7 - d10)) + (d8 * (d3 - d2));
        double d11 = this.f2551c;
        dArr4[i2] = d11 * d5;
        double d12 = this.f2554s;
        this.bulge = d5 * d12;
        if (this.f2550Q != null) {
            updateQ(i, i2, d11, d12);
        }
    }

    protected void createBulge2by2(int i, double d, boolean z) {
        double[] dArr = this.diag;
        double d2 = dArr[i];
        int i2 = i + 1;
        double d3 = dArr[i2];
        double d4 = this.off[i];
        if (z) {
            this.f2551c = Math.cos(d);
            double dSin = Math.sin(d);
            this.f2554s = dSin;
            double d5 = this.f2551c;
            this.f2552c2 = d5 * d5;
            this.f2555s2 = dSin * dSin;
            this.f2553cs = d5 * dSin;
        } else {
            computeRotation(d2 - d, d4);
        }
        double[] dArr2 = this.diag;
        double d6 = this.f2552c2;
        double d7 = this.f2553cs;
        double d8 = this.f2555s2;
        dArr2[i] = (d6 * d2) + (d7 * 2.0d * d4) + (d8 * d3);
        dArr2[i2] = ((d6 * d3) - ((2.0d * d7) * d4)) + (d8 * d2);
        this.off[i] = (d4 * (d6 - d8)) + (d7 * (d3 - d2));
        if (this.f2550Q != null) {
            updateQ(i, i2, this.f2551c, this.f2554s);
        }
    }

    private void computeRotation(double d, double d2) {
        if (Math.abs(d2) > Math.abs(d)) {
            double d3 = d / d2;
            double d4 = d3 * d3;
            double d5 = d4 + 1.0d;
            double dSqrt = Math.sqrt(d5);
            this.f2555s2 = 1.0d / d5;
            this.f2552c2 = d4 / d5;
            this.f2553cs = d3 / d5;
            this.f2554s = 1.0d / dSqrt;
            this.f2551c = d3 / dSqrt;
            return;
        }
        double d6 = d2 / d;
        double d7 = d6 * d6;
        double d8 = d7 + 1.0d;
        double dSqrt2 = Math.sqrt(d8);
        this.f2552c2 = 1.0d / d8;
        this.f2555s2 = d7 / d8;
        this.f2553cs = d6 / d8;
        this.f2551c = 1.0d / dSqrt2;
        this.f2554s = d6 / dSqrt2;
    }

    protected void removeBulge(int i) {
        double[] dArr = this.diag;
        int i2 = i + 1;
        double d = dArr[i2];
        int i3 = i + 2;
        double d2 = dArr[i3];
        double[] dArr2 = this.off;
        double d3 = dArr2[i];
        double d4 = dArr2[i2];
        double d5 = dArr2[i3];
        computeRotation(d3, this.bulge);
        double[] dArr3 = this.diag;
        double d6 = this.f2552c2;
        double d7 = this.f2553cs;
        double d8 = (d6 * d) + (d7 * 2.0d * d4);
        double d9 = this.f2555s2;
        dArr3[i2] = d8 + (d9 * d2);
        dArr3[i3] = ((d6 * d2) - ((2.0d * d7) * d4)) + (d9 * d);
        double[] dArr4 = this.off;
        double d10 = this.f2551c;
        double d11 = this.f2554s;
        dArr4[i] = (d3 * d10) + (this.bulge * d11);
        dArr4[i2] = (d4 * (d6 - d9)) + ((d2 - d) * d7);
        dArr4[i3] = d10 * d5;
        this.bulge = d5 * d11;
        if (this.f2550Q != null) {
            updateQ(i2, i3, d10, d11);
        }
    }

    protected void removeBulgeEnd(int i) {
        double[] dArr = this.diag;
        int i2 = i + 1;
        double d = dArr[i2];
        double[] dArr2 = this.off;
        double d2 = dArr2[i];
        double d3 = dArr2[i2];
        int i3 = i + 2;
        double d4 = dArr[i3];
        computeRotation(d2, this.bulge);
        double[] dArr3 = this.diag;
        double d5 = this.f2552c2;
        double d6 = this.f2553cs;
        double d7 = (d5 * d) + (d6 * 2.0d * d3);
        double d8 = this.f2555s2;
        dArr3[i2] = d7 + (d8 * d4);
        dArr3[i3] = ((d5 * d4) - ((2.0d * d6) * d3)) + (d8 * d);
        double[] dArr4 = this.off;
        double d9 = this.f2551c;
        double d10 = this.f2554s;
        dArr4[i] = (d2 * d9) + (this.bulge * d10);
        dArr4[i2] = (d3 * (d5 - d8)) + (d6 * (d4 - d));
        if (this.f2550Q != null) {
            updateQ(i2, i3, d9, d10);
        }
    }

    protected void eigenvalue2by2(int i) {
        double[] dArr = this.diag;
        double d = dArr[i];
        double d2 = this.off[i];
        int i2 = i + 1;
        double d3 = dArr[i2];
        double dAbs = Math.abs(d);
        double dAbs2 = Math.abs(d2);
        double dAbs3 = Math.abs(d3);
        if (dAbs <= dAbs2) {
            dAbs = dAbs2;
        }
        if (dAbs3 <= dAbs) {
            dAbs3 = dAbs;
        }
        if (dAbs3 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.off[i] = 0.0d;
            double[] dArr2 = this.diag;
            dArr2[i] = 0.0d;
            dArr2[i2] = 0.0d;
            return;
        }
        this.eigenSmall.symm2x2_fast(d / dAbs3, d2 / dAbs3, d3 / dAbs3);
        this.off[i] = 0.0d;
        this.diag[i] = this.eigenSmall.value0.real * dAbs3;
        this.diag[i2] = dAbs3 * this.eigenSmall.value1.real;
    }

    public void exceptionalShift() {
        int i = this.numExceptional + 1;
        this.numExceptional = i;
        double d = ((double) i) * 0.05d;
        if (d > 1.0d) {
            d = 1.0d;
        }
        performImplicitSingleStep((this.rand.nextDouble() - 0.5d) * 2.0d * d, true);
        this.lastExceptional = this.steps;
    }

    public boolean nextSplit() {
        int i = this.numSplits;
        if (i == 0) {
            return false;
        }
        int[] iArr = this.splits;
        int i2 = i - 1;
        this.numSplits = i2;
        this.f2557x2 = iArr[i2];
        if (i2 > 0) {
            this.f2556x1 = iArr[i - 2] + 1;
        } else {
            this.f2556x1 = 0;
        }
        return true;
    }

    public double computeShift() {
        int i = this.f2557x2;
        if (i - this.f2556x1 >= 1) {
            return computeWilkinsonShift();
        }
        return this.diag[i];
    }

    public double computeWilkinsonShift() {
        double d;
        double[] dArr = this.diag;
        int i = this.f2557x2;
        double d2 = dArr[i - 1];
        double d3 = this.off[i - 1];
        double d4 = dArr[i];
        double dAbs = Math.abs(d2);
        double dAbs2 = Math.abs(d3);
        double dAbs3 = Math.abs(d4);
        if (dAbs <= dAbs2) {
            dAbs = dAbs2;
        }
        if (dAbs3 <= dAbs) {
            dAbs3 = dAbs;
        }
        if (dAbs3 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            throw new RuntimeException("this should never happen");
        }
        double d5 = d4 / dAbs3;
        this.eigenSmall.symm2x2_fast(d2 / dAbs3, d3 / dAbs3, d5);
        if (Math.abs(this.eigenSmall.value0.real - d5) < Math.abs(this.eigenSmall.value1.real - d5)) {
            d = this.eigenSmall.value0.real;
        } else {
            d = this.eigenSmall.value1.real;
        }
        return dAbs3 * d;
    }

    public int getMatrixSize() {
        return this.f2549N;
    }

    public void resetSteps() {
        this.steps = 0;
        this.lastExceptional = 0;
    }
}
