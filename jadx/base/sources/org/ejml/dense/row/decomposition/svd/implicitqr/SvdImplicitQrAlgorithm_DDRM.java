package org.ejml.dense.row.decomposition.svd.implicitqr;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Random;
import org.ejml.UtilEjml;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.decomposition.eig.EigenvalueSmall_F64;

/* JADX INFO: loaded from: classes9.dex */
public class SvdImplicitQrAlgorithm_DDRM {
    private static final int giveUpOnKnown = 10;

    /* JADX INFO: renamed from: N */
    protected int f2647N;

    /* JADX INFO: renamed from: Ut */
    protected DMatrixRMaj f2648Ut;

    /* JADX INFO: renamed from: Vt */
    protected DMatrixRMaj f2649Vt;
    double bulge;

    /* JADX INFO: renamed from: c */
    double f2650c;
    protected double[] diag;
    protected EigenvalueSmall_F64 eigenSmall;
    private int exceptionalThresh;
    private boolean fastValues;
    private boolean findingZeros;
    boolean followScript;
    private int maxIterations;
    protected double maxValue;
    protected int nextExceptional;
    protected int numExceptional;
    protected int numSplits;
    protected double[] off;
    protected Random rand;

    /* JADX INFO: renamed from: s */
    double f2651s;
    protected int[] splits;
    int steps;
    protected int totalSteps;
    private double[] values;

    /* JADX INFO: renamed from: x1 */
    protected int f2652x1;

    /* JADX INFO: renamed from: x2 */
    protected int f2653x2;

    public SvdImplicitQrAlgorithm_DDRM(boolean z) {
        this.rand = new Random(3434270L);
        this.eigenSmall = new EigenvalueSmall_F64();
        this.exceptionalThresh = 15;
        this.maxIterations = 15 * 100;
        this.fastValues = z;
    }

    public SvdImplicitQrAlgorithm_DDRM() {
        this.rand = new Random(3434270L);
        this.eigenSmall = new EigenvalueSmall_F64();
        this.exceptionalThresh = 15;
        this.maxIterations = 15 * 100;
        this.fastValues = false;
    }

    public DMatrixRMaj getUt() {
        return this.f2648Ut;
    }

    public void setUt(DMatrixRMaj dMatrixRMaj) {
        this.f2648Ut = dMatrixRMaj;
    }

    public DMatrixRMaj getVt() {
        return this.f2649Vt;
    }

    public void setVt(DMatrixRMaj dMatrixRMaj) {
        this.f2649Vt = dMatrixRMaj;
    }

    public void setMatrix(int i, int i2, double[] dArr, double[] dArr2) {
        initParam(i, i2);
        this.diag = dArr;
        this.off = dArr2;
        this.maxValue = Math.abs(dArr[0]);
        for (int i3 = 1; i3 < this.f2647N; i3++) {
            double dAbs = Math.abs(dArr[i3]);
            double dAbs2 = Math.abs(dArr2[i3 - 1]);
            if (dAbs > this.maxValue) {
                this.maxValue = Math.abs(dAbs);
            }
            if (dAbs2 > this.maxValue) {
                this.maxValue = Math.abs(dAbs2);
            }
        }
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

    public void setMaxValue(double d) {
        this.maxValue = d;
    }

    public void initParam(int i, int i2) {
        if (i2 > i) {
            throw new RuntimeException("Must be a square or tall matrix");
        }
        this.f2647N = i2;
        int[] iArr = this.splits;
        if (iArr == null || iArr.length < i2) {
            this.splits = new int[i2];
        }
        this.f2652x1 = 0;
        this.f2653x2 = i2 - 1;
        this.steps = 0;
        this.totalSteps = 0;
        this.numSplits = 0;
        this.numExceptional = 0;
        this.nextExceptional = this.exceptionalThresh;
    }

    public boolean process() {
        this.followScript = false;
        this.findingZeros = true;
        return _process();
    }

    public boolean process(double[] dArr) {
        this.followScript = true;
        this.values = dArr;
        this.findingZeros = false;
        return _process();
    }

    public boolean _process() {
        if (this.maxValue == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return true;
        }
        while (true) {
            int i = this.f2653x2;
            if (i < 0) {
                break;
            }
            int i2 = this.steps;
            if (i2 > this.maxIterations) {
                return false;
            }
            int i3 = this.f2652x1;
            if (i3 == i) {
                resetSteps();
                if (!nextSplit()) {
                    break;
                }
            } else if (this.fastValues && i - i3 == 1) {
                resetSteps();
                eigenBB_2x2(this.f2652x1);
                int i4 = this.f2653x2;
                setSubmatrix(i4, i4);
            } else if (i2 >= this.nextExceptional) {
                exceptionShift();
            } else if (!checkForAndHandleZeros()) {
                if (this.followScript) {
                    performScriptedStep();
                } else {
                    performDynamicStep();
                }
            }
        }
        return true;
    }

    private void performDynamicStep() {
        if (this.findingZeros) {
            if (this.steps > 6) {
                this.findingZeros = false;
                return;
            } else {
                performImplicitSingleStep(computeBulgeScale(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false);
                return;
            }
        }
        double dComputeBulgeScale = computeBulgeScale();
        performImplicitSingleStep(dComputeBulgeScale, selectWilkinsonShift(dComputeBulgeScale), false);
    }

    private void performScriptedStep() {
        double dComputeBulgeScale = computeBulgeScale();
        if (this.steps > 10) {
            this.followScript = false;
        } else {
            double d = this.values[this.f2653x2] / dComputeBulgeScale;
            performImplicitSingleStep(dComputeBulgeScale, d * d, false);
        }
    }

    public void incrementSteps() {
        this.steps++;
        this.totalSteps++;
    }

    public boolean isOffZero(int i) {
        return Math.abs(this.off[i]) <= (Math.abs(this.diag[i]) + Math.abs(this.diag[i + 1])) * UtilEjml.EPS;
    }

    public boolean isDiagonalZero(int i) {
        return Math.abs(this.diag[i]) <= (Math.abs(this.diag[i + 1]) + Math.abs(this.off[i])) * UtilEjml.EPS;
    }

    public void resetSteps() {
        this.steps = 0;
        this.nextExceptional = this.exceptionalThresh;
        this.numExceptional = 0;
    }

    public boolean nextSplit() {
        int i = this.numSplits;
        if (i == 0) {
            return false;
        }
        int[] iArr = this.splits;
        int i2 = i - 1;
        this.numSplits = i2;
        this.f2653x2 = iArr[i2];
        if (i2 > 0) {
            this.f2652x1 = iArr[i - 2] + 1;
        } else {
            this.f2652x1 = 0;
        }
        return true;
    }

    public void performImplicitSingleStep(double d, double d2, boolean z) {
        createBulge(this.f2652x1, d2, d, z);
        for (int i = this.f2652x1; i < this.f2653x2 - 1 && this.bulge != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE; i++) {
            removeBulgeLeft(i, true);
            if (this.bulge == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                break;
            }
            removeBulgeRight(i);
        }
        if (this.bulge != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            removeBulgeLeft(this.f2653x2 - 1, false);
        }
        incrementSteps();
    }

    protected void updateRotator(DMatrixRMaj dMatrixRMaj, int i, int i2, double d, double d2) {
        int i3 = i * dMatrixRMaj.numCols;
        int i4 = dMatrixRMaj.numCols * i2;
        int i5 = dMatrixRMaj.numCols + i3;
        while (i3 != i5) {
            double d3 = dMatrixRMaj.get(i3);
            double d4 = dMatrixRMaj.get(i4);
            dMatrixRMaj.set(i3, (d * d3) + (d2 * d4));
            dMatrixRMaj.set(i4, ((-d2) * d3) + (d4 * d));
            i3++;
            i4++;
        }
    }

    private double computeBulgeScale() {
        double[] dArr = this.diag;
        int i = this.f2652x1;
        return Math.max(Math.abs(dArr[i]), Math.abs(this.off[i]));
    }

    protected void createBulge(int i, double d, double d2, boolean z) {
        double[] dArr = this.diag;
        double d3 = dArr[i];
        double d4 = this.off[i];
        int i2 = i + 1;
        double d5 = dArr[i2];
        if (z) {
            this.f2650c = Math.cos(d);
            this.f2651s = Math.sin(d);
        } else {
            double d6 = d3 / d2;
            double d7 = (d6 * d6) - d;
            double d8 = (d4 / d2) * d6;
            double dSqrt = Math.sqrt((d7 * d7) + (d8 * d8));
            this.f2650c = d7 / dSqrt;
            this.f2651s = d8 / dSqrt;
        }
        double[] dArr2 = this.diag;
        double d9 = this.f2650c;
        double d10 = this.f2651s;
        dArr2[i] = (d3 * d9) + (d4 * d10);
        this.off[i] = (d4 * d9) - (d3 * d10);
        dArr2[i2] = d5 * d9;
        this.bulge = d5 * d10;
        DMatrixRMaj dMatrixRMaj = this.f2649Vt;
        if (dMatrixRMaj != null) {
            updateRotator(dMatrixRMaj, i, i2, d9, d10);
        }
    }

    protected void computeRotator(double d, double d2) {
        if (Math.abs(d) < Math.abs(d2)) {
            double d3 = d / d2;
            double dSqrt = Math.sqrt((d3 * d3) + 1.0d);
            this.f2651s = 1.0d / dSqrt;
            this.f2650c = d3 / dSqrt;
            return;
        }
        double d4 = d2 / d;
        double dSqrt2 = Math.sqrt((d4 * d4) + 1.0d);
        this.f2650c = 1.0d / dSqrt2;
        this.f2651s = d4 / dSqrt2;
    }

    protected void removeBulgeLeft(int i, boolean z) {
        double[] dArr = this.diag;
        double d = dArr[i];
        double d2 = this.off[i];
        int i2 = i + 1;
        double d3 = dArr[i2];
        computeRotator(d, this.bulge);
        double[] dArr2 = this.diag;
        double d4 = this.f2650c;
        double d5 = this.f2651s;
        dArr2[i] = (d * d4) + (this.bulge * d5);
        double[] dArr3 = this.off;
        dArr3[i] = (d4 * d2) + (d5 * d3);
        dArr2[i2] = (d4 * d3) - (d2 * d5);
        if (z) {
            double d6 = dArr3[i2];
            this.bulge = d5 * d6;
            dArr3[i2] = d6 * d4;
        }
        DMatrixRMaj dMatrixRMaj = this.f2648Ut;
        if (dMatrixRMaj != null) {
            updateRotator(dMatrixRMaj, i, i2, d4, d5);
        }
    }

    protected void removeBulgeRight(int i) {
        double[] dArr = this.off;
        double d = dArr[i];
        int i2 = i + 1;
        double d2 = this.diag[i2];
        double d3 = dArr[i2];
        computeRotator(d, this.bulge);
        double[] dArr2 = this.off;
        double d4 = this.f2650c;
        double d5 = this.bulge;
        double d6 = this.f2651s;
        dArr2[i] = (d * d4) + (d5 * d6);
        double[] dArr3 = this.diag;
        dArr3[i2] = (d2 * d4) + (d3 * d6);
        dArr2[i2] = ((-d2) * d6) + (d3 * d4);
        int i3 = i + 2;
        double d7 = dArr3[i3];
        dArr3[i3] = d7 * d4;
        this.bulge = d7 * d6;
        DMatrixRMaj dMatrixRMaj = this.f2649Vt;
        if (dMatrixRMaj != null) {
            updateRotator(dMatrixRMaj, i2, i3, d4, d6);
        }
    }

    public void setSubmatrix(int i, int i2) {
        this.f2652x1 = i;
        this.f2653x2 = i2;
    }

    public double selectWilkinsonShift(double d) {
        double d2;
        int i = this.f2653x2;
        if (i - this.f2652x1 > 1) {
            double[] dArr = this.diag;
            double d3 = dArr[i - 1] / d;
            double[] dArr2 = this.off;
            double d4 = dArr2[i - 2] / d;
            double d5 = dArr[i] / d;
            double d6 = dArr2[i - 1] / d;
            d2 = (d6 * d6) + (d5 * d5);
            this.eigenSmall.symm2x2_fast((d4 * d4) + (d3 * d3), d6 * d3, d2);
        } else {
            double[] dArr3 = this.diag;
            double d7 = dArr3[i - 1] / d;
            double d8 = this.off[i - 1] / d;
            double d9 = dArr3[i] / d;
            double d10 = (d8 * d8) + (d9 * d9);
            this.eigenSmall.symm2x2_fast(d7 * d7, d7 * d8, d10);
            d2 = d10;
        }
        return (Math.abs(this.eigenSmall.value0.real - d2) < Math.abs(this.eigenSmall.value1.real - d2) ? this.eigenSmall.value0 : this.eigenSmall.value1).real;
    }

    protected void eigenBB_2x2(int i) {
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
            return;
        }
        double d4 = d / dAbs3;
        double d5 = d2 / dAbs3;
        double d6 = d3 / dAbs3;
        this.eigenSmall.symm2x2_fast(d4 * d4, d4 * d5, (d5 * d5) + (d6 * d6));
        this.off[i] = 0.0d;
        this.diag[i] = Math.sqrt(this.eigenSmall.value0.real) * dAbs3;
        this.diag[i2] = Math.signum(this.eigenSmall.value1.real) * dAbs3 * Math.sqrt(Math.abs(this.eigenSmall.value1.real));
    }

    protected boolean checkForAndHandleZeros() {
        for (int i = this.f2653x2 - 1; i >= this.f2652x1; i--) {
            if (isOffZero(i)) {
                resetSteps();
                int[] iArr = this.splits;
                int i2 = this.numSplits;
                this.numSplits = i2 + 1;
                iArr[i2] = i;
                this.f2652x1 = i + 1;
                return true;
            }
        }
        for (int i3 = this.f2653x2 - 1; i3 >= this.f2652x1; i3--) {
            if (isDiagonalZero(i3)) {
                pushRight(i3);
                resetSteps();
                int[] iArr2 = this.splits;
                int i4 = this.numSplits;
                this.numSplits = i4 + 1;
                iArr2[i4] = i3;
                this.f2652x1 = i3 + 1;
                return true;
            }
        }
        return false;
    }

    private void pushRight(int i) {
        if (isOffZero(i)) {
            return;
        }
        rotatorPushRight(i);
        int i2 = (this.f2647N - 2) - i;
        for (int i3 = 0; i3 < i2 && this.bulge != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE; i3++) {
            rotatorPushRight2(i, i3 + 2);
        }
    }

    private void rotatorPushRight(int i) {
        double d = this.off[i];
        int i2 = i + 1;
        double d2 = this.diag[i2];
        computeRotator(d2, -d);
        double[] dArr = this.off;
        dArr[i] = 0.0d;
        double[] dArr2 = this.diag;
        double d3 = this.f2650c;
        double d4 = this.f2651s;
        dArr2[i2] = (d2 * d3) - (d * d4);
        if (i + 2 < this.f2647N) {
            double d5 = dArr[i2];
            dArr[i2] = d5 * d3;
            this.bulge = d5 * d4;
        } else {
            this.bulge = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        DMatrixRMaj dMatrixRMaj = this.f2648Ut;
        if (dMatrixRMaj != null) {
            updateRotator(dMatrixRMaj, i, i2, d3, d4);
        }
    }

    private void rotatorPushRight2(int i, int i2) {
        double d = this.bulge;
        int i3 = i + i2;
        double d2 = this.diag[i3];
        computeRotator(d2, -d);
        double[] dArr = this.diag;
        double d3 = this.f2650c;
        double d4 = this.f2651s;
        dArr[i3] = (d2 * d3) - (d * d4);
        if (i3 < this.f2647N - 1) {
            double[] dArr2 = this.off;
            double d5 = dArr2[i3];
            dArr2[i3] = d5 * d3;
            this.bulge = d5 * d4;
        }
        DMatrixRMaj dMatrixRMaj = this.f2648Ut;
        if (dMatrixRMaj != null) {
            updateRotator(dMatrixRMaj, i, i3, d3, d4);
        }
    }

    public void exceptionShift() {
        int i = this.numExceptional + 1;
        this.numExceptional = i;
        double d = ((double) i) * 0.05d;
        if (d > 1.0d) {
            d = 1.0d;
        }
        performImplicitSingleStep(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, UtilEjml.f2394PI * 2.0d * (this.rand.nextDouble() - 0.5d) * d, true);
        this.nextExceptional = this.steps + this.exceptionalThresh;
    }

    public void printMatrix() {
        System.out.print("Off Diag[ ");
        for (int i = 0; i < this.f2647N - 1; i++) {
            System.out.printf("%5.2f ", Double.valueOf(this.off[i]));
        }
        System.out.println();
        System.out.print("    Diag[ ");
        for (int i2 = 0; i2 < this.f2647N; i2++) {
            System.out.printf("%5.2f ", Double.valueOf(this.diag[i2]));
        }
        System.out.println();
    }

    public int getNumberOfSingularValues() {
        return this.f2647N;
    }

    public double getSingularValue(int i) {
        return this.diag[i];
    }

    public void setFastValues(boolean z) {
        this.fastValues = z;
    }

    public double[] getSingularValues() {
        return this.diag;
    }

    public double[] getDiag() {
        return this.diag;
    }

    public double[] getOff() {
        return this.off;
    }

    public double getMaxValue() {
        return this.maxValue;
    }
}
