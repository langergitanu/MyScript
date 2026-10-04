package org.ejml.dense.row.decomposition.eig.symm;

import java.util.Random;
import org.ejml.UtilEjml;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.decomposition.eig.EigenvalueSmall_F32;

/* JADX INFO: loaded from: classes9.dex */
public class SymmetricQREigenHelper_FDRM {

    /* JADX INFO: renamed from: N */
    protected int f2558N;

    /* JADX INFO: renamed from: Q */
    protected FMatrixRMaj f2559Q;
    private float bulge;

    /* JADX INFO: renamed from: c */
    private float f2560c;

    /* JADX INFO: renamed from: c2 */
    private float f2561c2;

    /* JADX INFO: renamed from: cs */
    private float f2562cs;
    protected float[] diag;
    protected int lastExceptional;
    protected int numExceptional;
    protected int numSplits;
    protected float[] off;

    /* JADX INFO: renamed from: s */
    private float f2563s;

    /* JADX INFO: renamed from: s2 */
    private float f2564s2;
    protected int steps;

    /* JADX INFO: renamed from: x1 */
    protected int f2565x1;

    /* JADX INFO: renamed from: x2 */
    protected int f2566x2;
    protected Random rand = new Random(3434270);
    protected EigenvalueSmall_F32 eigenSmall = new EigenvalueSmall_F32();
    protected int[] splits = new int[1];

    public void printMatrix() {
        System.out.print("Off Diag[ ");
        for (int i = 0; i < this.f2558N - 1; i++) {
            System.out.printf("%5.2ff ", Float.valueOf(this.off[i]));
        }
        System.out.println();
        System.out.print("    Diag[ ");
        for (int i2 = 0; i2 < this.f2558N; i2++) {
            System.out.printf("%5.2ff ", Float.valueOf(this.diag[i2]));
        }
        System.out.println();
    }

    public void setQ(FMatrixRMaj fMatrixRMaj) {
        this.f2559Q = fMatrixRMaj;
    }

    public void incrementSteps() {
        this.steps++;
    }

    public void init(float[] fArr, float[] fArr2, int i) {
        reset(i);
        this.diag = fArr;
        this.off = fArr2;
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

    public void reset(int i) {
        this.f2558N = i;
        this.diag = null;
        this.off = null;
        if (this.splits.length < i) {
            this.splits = new int[i];
        }
        this.numSplits = 0;
        this.f2565x1 = 0;
        this.f2566x2 = i - 1;
        this.lastExceptional = 0;
        this.numExceptional = 0;
        this.steps = 0;
        this.f2559Q = null;
    }

    public float[] copyDiag(float[] fArr) {
        if (fArr == null || fArr.length < this.f2558N) {
            fArr = new float[this.f2558N];
        }
        System.arraycopy(this.diag, 0, fArr, 0, this.f2558N);
        return fArr;
    }

    public float[] copyOff(float[] fArr) {
        if (fArr == null || fArr.length < this.f2558N - 1) {
            fArr = new float[this.f2558N - 1];
        }
        System.arraycopy(this.off, 0, fArr, 0, this.f2558N - 1);
        return fArr;
    }

    public float[] copyEigenvalues(float[] fArr) {
        if (fArr == null || fArr.length < this.f2558N) {
            fArr = new float[this.f2558N];
        }
        System.arraycopy(this.diag, 0, fArr, 0, this.f2558N);
        return fArr;
    }

    public void setSubmatrix(int i, int i2) {
        this.f2565x1 = i;
        this.f2566x2 = i2;
    }

    protected boolean isZero(int i) {
        return Math.abs(this.off[i]) <= (Math.abs(this.diag[i]) + Math.abs(this.diag[i + 1])) * UtilEjml.F_EPS;
    }

    protected void performImplicitSingleStep(float f, boolean z) {
        int i;
        int i2 = this.f2566x2;
        int i3 = this.f2565x1;
        if (i2 - i3 == 1) {
            createBulge2by2(i3, f, z);
            return;
        }
        createBulge(i3, f, z);
        int i4 = this.f2565x1;
        while (true) {
            i = this.f2566x2;
            if (i4 >= i - 2 || this.bulge == 0.0f) {
                break;
            }
            removeBulge(i4);
            i4++;
        }
        if (this.bulge != 0.0f) {
            removeBulgeEnd(i - 2);
        }
    }

    protected void updateQ(int i, int i2, float f, float f2) {
        int i3 = this.f2558N;
        int i4 = i * i3;
        int i5 = i2 * i3;
        int i6 = i3 + i4;
        while (i4 < i6) {
            float f3 = this.f2559Q.data[i4];
            float f4 = this.f2559Q.data[i5];
            this.f2559Q.data[i4] = (f * f3) + (f2 * f4);
            this.f2559Q.data[i5] = ((-f2) * f3) + (f4 * f);
            i5++;
            i4++;
        }
    }

    protected void createBulge(int i, float f, boolean z) {
        float[] fArr = this.diag;
        float f2 = fArr[i];
        int i2 = i + 1;
        float f3 = fArr[i2];
        float[] fArr2 = this.off;
        float f4 = fArr2[i];
        float f5 = fArr2[i2];
        if (z) {
            double d = f;
            this.f2560c = (float) Math.cos(d);
            float fSin = (float) Math.sin(d);
            this.f2563s = fSin;
            float f6 = this.f2560c;
            this.f2561c2 = f6 * f6;
            this.f2564s2 = fSin * fSin;
            this.f2562cs = f6 * fSin;
        } else {
            computeRotation(f2 - f, f4);
        }
        float[] fArr3 = this.diag;
        float f7 = this.f2561c2;
        float f8 = this.f2562cs;
        float f9 = this.f2564s2;
        fArr3[i] = (f7 * f2) + (f8 * 2.0f * f4) + (f9 * f3);
        fArr3[i2] = ((f7 * f3) - ((2.0f * f8) * f4)) + (f9 * f2);
        float[] fArr4 = this.off;
        fArr4[i] = (f4 * (f7 - f9)) + (f8 * (f3 - f2));
        float f10 = this.f2560c;
        fArr4[i2] = f10 * f5;
        float f11 = this.f2563s;
        this.bulge = f5 * f11;
        if (this.f2559Q != null) {
            updateQ(i, i2, f10, f11);
        }
    }

    protected void createBulge2by2(int i, float f, boolean z) {
        float[] fArr = this.diag;
        float f2 = fArr[i];
        int i2 = i + 1;
        float f3 = fArr[i2];
        float f4 = this.off[i];
        if (z) {
            double d = f;
            this.f2560c = (float) Math.cos(d);
            float fSin = (float) Math.sin(d);
            this.f2563s = fSin;
            float f5 = this.f2560c;
            this.f2561c2 = f5 * f5;
            this.f2564s2 = fSin * fSin;
            this.f2562cs = f5 * fSin;
        } else {
            computeRotation(f2 - f, f4);
        }
        float[] fArr2 = this.diag;
        float f6 = this.f2561c2;
        float f7 = this.f2562cs;
        float f8 = this.f2564s2;
        fArr2[i] = (f6 * f2) + (f7 * 2.0f * f4) + (f8 * f3);
        fArr2[i2] = ((f6 * f3) - ((2.0f * f7) * f4)) + (f8 * f2);
        this.off[i] = (f4 * (f6 - f8)) + (f7 * (f3 - f2));
        if (this.f2559Q != null) {
            updateQ(i, i2, this.f2560c, this.f2563s);
        }
    }

    private void computeRotation(float f, float f2) {
        if (Math.abs(f2) > Math.abs(f)) {
            float f3 = f / f2;
            float f4 = f3 * f3;
            float f5 = f4 + 1.0f;
            float fSqrt = (float) Math.sqrt(f5);
            this.f2564s2 = 1.0f / f5;
            this.f2561c2 = f4 / f5;
            this.f2562cs = f3 / f5;
            this.f2563s = 1.0f / fSqrt;
            this.f2560c = f3 / fSqrt;
            return;
        }
        float f6 = f2 / f;
        float f7 = f6 * f6;
        float f8 = f7 + 1.0f;
        float fSqrt2 = (float) Math.sqrt(f8);
        this.f2561c2 = 1.0f / f8;
        this.f2564s2 = f7 / f8;
        this.f2562cs = f6 / f8;
        this.f2560c = 1.0f / fSqrt2;
        this.f2563s = f6 / fSqrt2;
    }

    protected void removeBulge(int i) {
        float[] fArr = this.diag;
        int i2 = i + 1;
        float f = fArr[i2];
        int i3 = i + 2;
        float f2 = fArr[i3];
        float[] fArr2 = this.off;
        float f3 = fArr2[i];
        float f4 = fArr2[i2];
        float f5 = fArr2[i3];
        computeRotation(f3, this.bulge);
        float[] fArr3 = this.diag;
        float f6 = this.f2561c2;
        float f7 = this.f2562cs;
        float f8 = this.f2564s2;
        fArr3[i2] = (f6 * f) + (f7 * 2.0f * f4) + (f8 * f2);
        fArr3[i3] = ((f6 * f2) - ((2.0f * f7) * f4)) + (f8 * f);
        float[] fArr4 = this.off;
        float f9 = this.f2560c;
        float f10 = this.f2563s;
        fArr4[i] = (f3 * f9) + (this.bulge * f10);
        fArr4[i2] = (f4 * (f6 - f8)) + (f7 * (f2 - f));
        fArr4[i3] = f9 * f5;
        this.bulge = f5 * f10;
        if (this.f2559Q != null) {
            updateQ(i2, i3, f9, f10);
        }
    }

    protected void removeBulgeEnd(int i) {
        float[] fArr = this.diag;
        int i2 = i + 1;
        float f = fArr[i2];
        float[] fArr2 = this.off;
        float f2 = fArr2[i];
        float f3 = fArr2[i2];
        int i3 = i + 2;
        float f4 = fArr[i3];
        computeRotation(f2, this.bulge);
        float[] fArr3 = this.diag;
        float f5 = this.f2561c2;
        float f6 = this.f2562cs;
        float f7 = this.f2564s2;
        fArr3[i2] = (f5 * f) + (f6 * 2.0f * f3) + (f7 * f4);
        fArr3[i3] = ((f5 * f4) - ((2.0f * f6) * f3)) + (f7 * f);
        float[] fArr4 = this.off;
        float f8 = this.f2560c;
        float f9 = this.f2563s;
        fArr4[i] = (f2 * f8) + (this.bulge * f9);
        fArr4[i2] = (f3 * (f5 - f7)) + (f6 * (f4 - f));
        if (this.f2559Q != null) {
            updateQ(i2, i3, f8, f9);
        }
    }

    protected void eigenvalue2by2(int i) {
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
            this.off[i] = 0.0f;
            float[] fArr2 = this.diag;
            fArr2[i] = 0.0f;
            fArr2[i2] = 0.0f;
            return;
        }
        this.eigenSmall.symm2x2_fast(f / fAbs3, f2 / fAbs3, f3 / fAbs3);
        this.off[i] = 0.0f;
        this.diag[i] = this.eigenSmall.value0.real * fAbs3;
        this.diag[i2] = fAbs3 * this.eigenSmall.value1.real;
    }

    public void exceptionalShift() {
        int i = this.numExceptional + 1;
        this.numExceptional = i;
        float f = i * 0.05f;
        if (f > 1.0f) {
            f = 1.0f;
        }
        performImplicitSingleStep((this.rand.nextFloat() - 0.5f) * 2.0f * f, true);
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
        this.f2566x2 = iArr[i2];
        if (i2 > 0) {
            this.f2565x1 = iArr[i - 2] + 1;
        } else {
            this.f2565x1 = 0;
        }
        return true;
    }

    public float computeShift() {
        int i = this.f2566x2;
        if (i - this.f2565x1 >= 1) {
            return computeWilkinsonShift();
        }
        return this.diag[i];
    }

    public float computeWilkinsonShift() {
        float f;
        float[] fArr = this.diag;
        int i = this.f2566x2;
        float f2 = fArr[i - 1];
        float f3 = this.off[i - 1];
        float f4 = fArr[i];
        float fAbs = Math.abs(f2);
        float fAbs2 = Math.abs(f3);
        float fAbs3 = Math.abs(f4);
        if (fAbs <= fAbs2) {
            fAbs = fAbs2;
        }
        if (fAbs3 <= fAbs) {
            fAbs3 = fAbs;
        }
        if (fAbs3 == 0.0f) {
            throw new RuntimeException("this should never happen");
        }
        float f5 = f4 / fAbs3;
        this.eigenSmall.symm2x2_fast(f2 / fAbs3, f3 / fAbs3, f5);
        if (Math.abs(this.eigenSmall.value0.real - f5) < Math.abs(this.eigenSmall.value1.real - f5)) {
            f = this.eigenSmall.value0.real;
        } else {
            f = this.eigenSmall.value1.real;
        }
        return fAbs3 * f;
    }

    public int getMatrixSize() {
        return this.f2558N;
    }

    public void resetSteps() {
        this.steps = 0;
        this.lastExceptional = 0;
    }
}
