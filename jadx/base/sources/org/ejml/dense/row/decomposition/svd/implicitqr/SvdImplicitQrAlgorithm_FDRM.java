package org.ejml.dense.row.decomposition.svd.implicitqr;

import java.util.Random;
import org.ejml.UtilEjml;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.decomposition.eig.EigenvalueSmall_F32;

/* JADX INFO: loaded from: classes9.dex */
public class SvdImplicitQrAlgorithm_FDRM {
    private static final int giveUpOnKnown = 10;

    /* JADX INFO: renamed from: N */
    protected int f2654N;

    /* JADX INFO: renamed from: Ut */
    protected FMatrixRMaj f2655Ut;

    /* JADX INFO: renamed from: Vt */
    protected FMatrixRMaj f2656Vt;
    float bulge;

    /* JADX INFO: renamed from: c */
    float f2657c;
    protected float[] diag;
    protected EigenvalueSmall_F32 eigenSmall;
    private int exceptionalThresh;
    private boolean fastValues;
    private boolean findingZeros;
    boolean followScript;
    private int maxIterations;
    protected float maxValue;
    protected int nextExceptional;
    protected int numExceptional;
    protected int numSplits;
    protected float[] off;
    protected Random rand;

    /* JADX INFO: renamed from: s */
    float f2658s;
    protected int[] splits;
    int steps;
    protected int totalSteps;
    private float[] values;

    /* JADX INFO: renamed from: x1 */
    protected int f2659x1;

    /* JADX INFO: renamed from: x2 */
    protected int f2660x2;

    public SvdImplicitQrAlgorithm_FDRM(boolean z) {
        this.rand = new Random(3434270L);
        this.eigenSmall = new EigenvalueSmall_F32();
        this.exceptionalThresh = 15;
        this.maxIterations = 15 * 100;
        this.fastValues = z;
    }

    public SvdImplicitQrAlgorithm_FDRM() {
        this.rand = new Random(3434270L);
        this.eigenSmall = new EigenvalueSmall_F32();
        this.exceptionalThresh = 15;
        this.maxIterations = 15 * 100;
        this.fastValues = false;
    }

    public FMatrixRMaj getUt() {
        return this.f2655Ut;
    }

    public void setUt(FMatrixRMaj fMatrixRMaj) {
        this.f2655Ut = fMatrixRMaj;
    }

    public FMatrixRMaj getVt() {
        return this.f2656Vt;
    }

    public void setVt(FMatrixRMaj fMatrixRMaj) {
        this.f2656Vt = fMatrixRMaj;
    }

    public void setMatrix(int i, int i2, float[] fArr, float[] fArr2) {
        initParam(i, i2);
        this.diag = fArr;
        this.off = fArr2;
        this.maxValue = Math.abs(fArr[0]);
        for (int i3 = 1; i3 < this.f2654N; i3++) {
            float fAbs = Math.abs(fArr[i3]);
            float fAbs2 = Math.abs(fArr2[i3 - 1]);
            if (fAbs > this.maxValue) {
                this.maxValue = Math.abs(fAbs);
            }
            if (fAbs2 > this.maxValue) {
                this.maxValue = Math.abs(fAbs2);
            }
        }
    }

    public float[] swapDiag(float[] fArr) {
        float[] fArr2 = this.diag;
        this.diag = fArr;
        return fArr2;
    }

    public float[] swapOff(float[] fArr) {
        float[] fArr2 = this.off;
        this.off = fArr;
        return fArr2;
    }

    public void setMaxValue(float f) {
        this.maxValue = f;
    }

    public void initParam(int i, int i2) {
        if (i2 > i) {
            throw new RuntimeException("Must be a square or tall matrix");
        }
        this.f2654N = i2;
        int[] iArr = this.splits;
        if (iArr == null || iArr.length < i2) {
            this.splits = new int[i2];
        }
        this.f2659x1 = 0;
        this.f2660x2 = i2 - 1;
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

    public boolean process(float[] fArr) {
        this.followScript = true;
        this.values = fArr;
        this.findingZeros = false;
        return _process();
    }

    public boolean _process() {
        if (this.maxValue == 0.0f) {
            return true;
        }
        while (true) {
            int i = this.f2660x2;
            if (i < 0) {
                break;
            }
            int i2 = this.steps;
            if (i2 > this.maxIterations) {
                return false;
            }
            int i3 = this.f2659x1;
            if (i3 == i) {
                resetSteps();
                if (!nextSplit()) {
                    break;
                }
            } else if (this.fastValues && i - i3 == 1) {
                resetSteps();
                eigenBB_2x2(this.f2659x1);
                int i4 = this.f2660x2;
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
                performImplicitSingleStep(computeBulgeScale(), 0.0f, false);
                return;
            }
        }
        float fComputeBulgeScale = computeBulgeScale();
        performImplicitSingleStep(fComputeBulgeScale, selectWilkinsonShift(fComputeBulgeScale), false);
    }

    private void performScriptedStep() {
        float fComputeBulgeScale = computeBulgeScale();
        if (this.steps > 10) {
            this.followScript = false;
        } else {
            float f = this.values[this.f2660x2] / fComputeBulgeScale;
            performImplicitSingleStep(fComputeBulgeScale, f * f, false);
        }
    }

    public void incrementSteps() {
        this.steps++;
        this.totalSteps++;
    }

    public boolean isOffZero(int i) {
        return Math.abs(this.off[i]) <= (Math.abs(this.diag[i]) + Math.abs(this.diag[i + 1])) * UtilEjml.F_EPS;
    }

    public boolean isDiagonalZero(int i) {
        return Math.abs(this.diag[i]) <= (Math.abs(this.diag[i + 1]) + Math.abs(this.off[i])) * UtilEjml.F_EPS;
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
        this.f2660x2 = iArr[i2];
        if (i2 > 0) {
            this.f2659x1 = iArr[i - 2] + 1;
        } else {
            this.f2659x1 = 0;
        }
        return true;
    }

    public void performImplicitSingleStep(float f, float f2, boolean z) {
        createBulge(this.f2659x1, f2, f, z);
        for (int i = this.f2659x1; i < this.f2660x2 - 1 && this.bulge != 0.0f; i++) {
            removeBulgeLeft(i, true);
            if (this.bulge == 0.0f) {
                break;
            }
            removeBulgeRight(i);
        }
        if (this.bulge != 0.0f) {
            removeBulgeLeft(this.f2660x2 - 1, false);
        }
        incrementSteps();
    }

    protected void updateRotator(FMatrixRMaj fMatrixRMaj, int i, int i2, float f, float f2) {
        int i3 = i * fMatrixRMaj.numCols;
        int i4 = i2 * fMatrixRMaj.numCols;
        int i5 = fMatrixRMaj.numCols + i3;
        while (i3 != i5) {
            float f3 = fMatrixRMaj.get(i3);
            float f4 = fMatrixRMaj.get(i4);
            fMatrixRMaj.set(i3, (f * f3) + (f2 * f4));
            fMatrixRMaj.set(i4, ((-f2) * f3) + (f4 * f));
            i3++;
            i4++;
        }
    }

    private float computeBulgeScale() {
        float[] fArr = this.diag;
        int i = this.f2659x1;
        return Math.max(Math.abs(fArr[i]), Math.abs(this.off[i]));
    }

    protected void createBulge(int i, float f, float f2, boolean z) {
        float[] fArr = this.diag;
        float f3 = fArr[i];
        float f4 = this.off[i];
        int i2 = i + 1;
        float f5 = fArr[i2];
        if (z) {
            double d = f;
            this.f2657c = (float) Math.cos(d);
            this.f2658s = (float) Math.sin(d);
        } else {
            float f6 = f3 / f2;
            float f7 = (f6 * f6) - f;
            float f8 = (f4 / f2) * f6;
            float fSqrt = (float) Math.sqrt((f7 * f7) + (f8 * f8));
            this.f2657c = f7 / fSqrt;
            this.f2658s = f8 / fSqrt;
        }
        float[] fArr2 = this.diag;
        float f9 = this.f2657c;
        float f10 = this.f2658s;
        fArr2[i] = (f3 * f9) + (f4 * f10);
        this.off[i] = (f4 * f9) - (f3 * f10);
        fArr2[i2] = f5 * f9;
        this.bulge = f5 * f10;
        FMatrixRMaj fMatrixRMaj = this.f2656Vt;
        if (fMatrixRMaj != null) {
            updateRotator(fMatrixRMaj, i, i2, f9, f10);
        }
    }

    protected void computeRotator(float f, float f2) {
        if (Math.abs(f) < Math.abs(f2)) {
            float f3 = f / f2;
            float fSqrt = (float) Math.sqrt((f3 * f3) + 1.0f);
            this.f2658s = 1.0f / fSqrt;
            this.f2657c = f3 / fSqrt;
            return;
        }
        float f4 = f2 / f;
        float fSqrt2 = (float) Math.sqrt((f4 * f4) + 1.0f);
        this.f2657c = 1.0f / fSqrt2;
        this.f2658s = f4 / fSqrt2;
    }

    protected void removeBulgeLeft(int i, boolean z) {
        float[] fArr = this.diag;
        float f = fArr[i];
        float f2 = this.off[i];
        int i2 = i + 1;
        float f3 = fArr[i2];
        computeRotator(f, this.bulge);
        float[] fArr2 = this.diag;
        float f4 = this.f2657c;
        float f5 = this.f2658s;
        fArr2[i] = (f * f4) + (this.bulge * f5);
        float[] fArr3 = this.off;
        fArr3[i] = (f4 * f2) + (f5 * f3);
        fArr2[i2] = (f3 * f4) - (f2 * f5);
        if (z) {
            float f6 = fArr3[i2];
            this.bulge = f5 * f6;
            fArr3[i2] = f6 * f4;
        }
        FMatrixRMaj fMatrixRMaj = this.f2655Ut;
        if (fMatrixRMaj != null) {
            updateRotator(fMatrixRMaj, i, i2, f4, f5);
        }
    }

    protected void removeBulgeRight(int i) {
        float[] fArr = this.off;
        float f = fArr[i];
        int i2 = i + 1;
        float f2 = this.diag[i2];
        float f3 = fArr[i2];
        computeRotator(f, this.bulge);
        float[] fArr2 = this.off;
        float f4 = this.f2657c;
        float f5 = this.bulge;
        float f6 = this.f2658s;
        fArr2[i] = (f * f4) + (f5 * f6);
        float[] fArr3 = this.diag;
        fArr3[i2] = (f2 * f4) + (f3 * f6);
        fArr2[i2] = ((-f2) * f6) + (f3 * f4);
        int i3 = i + 2;
        float f7 = fArr3[i3];
        fArr3[i3] = f7 * f4;
        this.bulge = f7 * f6;
        FMatrixRMaj fMatrixRMaj = this.f2656Vt;
        if (fMatrixRMaj != null) {
            updateRotator(fMatrixRMaj, i2, i3, f4, f6);
        }
    }

    public void setSubmatrix(int i, int i2) {
        this.f2659x1 = i;
        this.f2660x2 = i2;
    }

    public float selectWilkinsonShift(float f) {
        float f2;
        int i = this.f2660x2;
        if (i - this.f2659x1 > 1) {
            float[] fArr = this.diag;
            float f3 = fArr[i - 1] / f;
            float[] fArr2 = this.off;
            float f4 = fArr2[i - 2] / f;
            float f5 = fArr[i] / f;
            float f6 = fArr2[i - 1] / f;
            f2 = (f6 * f6) + (f5 * f5);
            this.eigenSmall.symm2x2_fast((f4 * f4) + (f3 * f3), f6 * f3, f2);
        } else {
            float[] fArr3 = this.diag;
            float f7 = fArr3[i - 1] / f;
            float f8 = this.off[i - 1] / f;
            float f9 = fArr3[i] / f;
            float f10 = (f9 * f9) + (f8 * f8);
            this.eigenSmall.symm2x2_fast(f7 * f7, f7 * f8, f10);
            f2 = f10;
        }
        return (Math.abs(this.eigenSmall.value0.real - f2) < Math.abs(this.eigenSmall.value1.real - f2) ? this.eigenSmall.value0 : this.eigenSmall.value1).real;
    }

    protected void eigenBB_2x2(int i) {
        float[] fArr = this.diag;
        float f = fArr[i];
        float f2 = this.off[i];
        int i2 = i + 1;
        float f3 = fArr[i2];
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f2);
        float fAbs3 = Math.abs(f3);
        if (fAbs <= fAbs2) {
            fAbs = fAbs2;
        }
        if (fAbs3 <= fAbs) {
            fAbs3 = fAbs;
        }
        if (fAbs3 == 0.0f) {
            return;
        }
        float f4 = f / fAbs3;
        float f5 = f2 / fAbs3;
        float f6 = f3 / fAbs3;
        this.eigenSmall.symm2x2_fast(f4 * f4, f4 * f5, (f5 * f5) + (f6 * f6));
        this.off[i] = 0.0f;
        this.diag[i] = ((float) Math.sqrt(this.eigenSmall.value0.real)) * fAbs3;
        this.diag[i2] = Math.signum(this.eigenSmall.value1.real) * fAbs3 * ((float) Math.sqrt(Math.abs(this.eigenSmall.value1.real)));
    }

    protected boolean checkForAndHandleZeros() {
        for (int i = this.f2660x2 - 1; i >= this.f2659x1; i--) {
            if (isOffZero(i)) {
                resetSteps();
                int[] iArr = this.splits;
                int i2 = this.numSplits;
                this.numSplits = i2 + 1;
                iArr[i2] = i;
                this.f2659x1 = i + 1;
                return true;
            }
        }
        for (int i3 = this.f2660x2 - 1; i3 >= this.f2659x1; i3--) {
            if (isDiagonalZero(i3)) {
                pushRight(i3);
                resetSteps();
                int[] iArr2 = this.splits;
                int i4 = this.numSplits;
                this.numSplits = i4 + 1;
                iArr2[i4] = i3;
                this.f2659x1 = i3 + 1;
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
        int i2 = (this.f2654N - 2) - i;
        for (int i3 = 0; i3 < i2 && this.bulge != 0.0f; i3++) {
            rotatorPushRight2(i, i3 + 2);
        }
    }

    private void rotatorPushRight(int i) {
        float f = this.off[i];
        int i2 = i + 1;
        float f2 = this.diag[i2];
        computeRotator(f2, -f);
        float[] fArr = this.off;
        fArr[i] = 0.0f;
        float[] fArr2 = this.diag;
        float f3 = this.f2657c;
        float f4 = this.f2658s;
        fArr2[i2] = (f2 * f3) - (f * f4);
        if (i + 2 < this.f2654N) {
            float f5 = fArr[i2];
            fArr[i2] = f5 * f3;
            this.bulge = f5 * f4;
        } else {
            this.bulge = 0.0f;
        }
        FMatrixRMaj fMatrixRMaj = this.f2655Ut;
        if (fMatrixRMaj != null) {
            updateRotator(fMatrixRMaj, i, i2, f3, f4);
        }
    }

    private void rotatorPushRight2(int i, int i2) {
        float f = this.bulge;
        int i3 = i + i2;
        float f2 = this.diag[i3];
        computeRotator(f2, -f);
        float[] fArr = this.diag;
        float f3 = this.f2657c;
        float f4 = this.f2658s;
        fArr[i3] = (f2 * f3) - (f * f4);
        if (i3 < this.f2654N - 1) {
            float[] fArr2 = this.off;
            float f5 = fArr2[i3];
            fArr2[i3] = f5 * f3;
            this.bulge = f5 * f4;
        }
        FMatrixRMaj fMatrixRMaj = this.f2655Ut;
        if (fMatrixRMaj != null) {
            updateRotator(fMatrixRMaj, i, i3, f3, f4);
        }
    }

    public void exceptionShift() {
        int i = this.numExceptional + 1;
        this.numExceptional = i;
        float f = i * 0.05f;
        if (f > 1.0f) {
            f = 1.0f;
        }
        performImplicitSingleStep(0.0f, UtilEjml.F_PI * 2.0f * (this.rand.nextFloat() - 0.5f) * f, true);
        this.nextExceptional = this.steps + this.exceptionalThresh;
    }

    public void printMatrix() {
        System.out.print("Off Diag[ ");
        for (int i = 0; i < this.f2654N - 1; i++) {
            System.out.printf("%5.2ff ", Float.valueOf(this.off[i]));
        }
        System.out.println();
        System.out.print("    Diag[ ");
        for (int i2 = 0; i2 < this.f2654N; i2++) {
            System.out.printf("%5.2ff ", Float.valueOf(this.diag[i2]));
        }
        System.out.println();
    }

    public int getNumberOfSingularValues() {
        return this.f2654N;
    }

    public float getSingularValue(int i) {
        return this.diag[i];
    }

    public void setFastValues(boolean z) {
        this.fastValues = z;
    }

    public float[] getSingularValues() {
        return this.diag;
    }

    public float[] getDiag() {
        return this.diag;
    }

    public float[] getOff() {
        return this.off;
    }

    public float getMaxValue() {
        return this.maxValue;
    }
}
