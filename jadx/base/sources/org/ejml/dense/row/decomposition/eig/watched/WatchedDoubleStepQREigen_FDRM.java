package org.ejml.dense.row.decomposition.eig.watched;

import java.util.Random;
import org.ejml.UtilEjml;
import org.ejml.data.Complex_F32;
import org.ejml.data.FMatrixD1;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.MatrixFeatures_FDRM;
import org.ejml.dense.row.decomposition.eig.EigenvalueSmall_F32;
import org.ejml.dense.row.decomposition.p050qr.QrHelperFunctions_FDRM;

/* JADX INFO: loaded from: classes9.dex */
public class WatchedDoubleStepQREigen_FDRM {

    /* JADX INFO: renamed from: A */
    FMatrixRMaj f2573A;

    /* JADX INFO: renamed from: N */
    private int f2574N;

    /* JADX INFO: renamed from: Q */
    public FMatrixRMaj f2575Q;
    private FMatrixRMaj _temp;
    Complex_F32[] eigenvalues;
    private float gamma;
    int lastExceptional;
    int numEigen;
    int numExceptional;
    int[] numStepsFind;
    int steps;

    /* JADX INFO: renamed from: u */
    private FMatrixRMaj f2576u;
    private Random rand = new Random(9026);
    private EigenvalueSmall_F32 valueSmall = new EigenvalueSmall_F32();
    private float[] temp = new float[9];
    private boolean printHumps = false;
    boolean checkHessenberg = false;
    private boolean checkOrthogonal = false;
    private boolean checkUncountable = false;
    private boolean useStandardEq = false;
    private boolean useCareful2x2 = true;
    private boolean normalize = true;
    int exceptionalThreshold = 20;
    int maxIterations = 20 * 20;
    public boolean createR = true;

    public void incrementSteps() {
        this.steps++;
    }

    public void setQ(FMatrixRMaj fMatrixRMaj) {
        this.f2575Q = fMatrixRMaj;
    }

    private void addEigenvalue(float f) {
        int[] iArr = this.numStepsFind;
        int i = this.numEigen;
        iArr[i] = this.steps;
        this.eigenvalues[i].set(f, 0.0f);
        this.numEigen++;
        this.steps = 0;
        this.lastExceptional = 0;
    }

    private void addEigenvalue(float f, float f2) {
        int[] iArr = this.numStepsFind;
        int i = this.numEigen;
        iArr[i] = this.steps;
        this.eigenvalues[i].set(f, f2);
        this.numEigen++;
        this.steps = 0;
        this.lastExceptional = 0;
    }

    public void setChecks(boolean z, boolean z2, boolean z3) {
        this.checkHessenberg = z;
        this.checkOrthogonal = z2;
        this.checkUncountable = z3;
    }

    public boolean isZero(int i, int i2) {
        return Math.abs(this.f2573A.get(i, i2)) <= (UtilEjml.F_EPS * 0.5f) * (Math.abs(this.f2573A.get(i + (-1), i2)) + Math.abs(this.f2573A.get(i, i2 + 1)));
    }

    public void setup(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj.numRows != fMatrixRMaj.numCols) {
            throw new RuntimeException("Must be square");
        }
        if (this.f2574N != fMatrixRMaj.numRows) {
            this.f2574N = fMatrixRMaj.numRows;
            this.f2573A = fMatrixRMaj.copy();
            this.f2576u = new FMatrixRMaj(fMatrixRMaj.numRows, 1);
            this._temp = new FMatrixRMaj(fMatrixRMaj.numRows, 1);
            this.numStepsFind = new int[fMatrixRMaj.numRows];
        } else {
            this.f2573A.set((FMatrixD1) fMatrixRMaj);
            int[] iArr = this.numStepsFind;
            UtilEjml.memset(iArr, 0, iArr.length);
        }
        for (int i = 2; i < this.f2574N; i++) {
            for (int i2 = 0; i2 < i - 1; i2++) {
                this.f2573A.set(i, i2, 0.0f);
            }
        }
        this.eigenvalues = new Complex_F32[fMatrixRMaj.numRows];
        int i3 = 0;
        while (true) {
            Complex_F32[] complex_F32Arr = this.eigenvalues;
            if (i3 < complex_F32Arr.length) {
                complex_F32Arr[i3] = new Complex_F32();
                i3++;
            } else {
                this.numEigen = 0;
                this.lastExceptional = 0;
                this.numExceptional = 0;
                this.steps = 0;
                return;
            }
        }
    }

    public void exceptionalShift(int i, int i2) {
        if (this.printHumps) {
            System.out.println("Performing exceptional implicit float step");
        }
        float fAbs = Math.abs(this.f2573A.get(i2, i2));
        if (fAbs == 0.0f) {
            fAbs = 1.0f;
        }
        int i3 = this.numExceptional + 1;
        this.numExceptional = i3;
        float fPow = 1.0f - ((float) Math.pow(0.10000000149011612d, i3));
        float fNextFloat = fAbs * (fPow + ((1.0f - fPow) * 2.0f * (this.rand.nextFloat() - 0.5f)));
        if (this.rand.nextBoolean()) {
            fNextFloat = -fNextFloat;
        }
        performImplicitSingleStep(i, i2, fNextFloat);
        this.lastExceptional = this.steps;
    }

    public void implicitDoubleStep(int i, int i2) {
        float f;
        float f2;
        if (this.printHumps) {
            System.out.println("Performing implicit float step");
        }
        int i3 = i2 - 1;
        float f3 = this.f2573A.get(i3, i3);
        float f4 = this.f2573A.get(i3, i2);
        float f5 = this.f2573A.get(i2, i3);
        float f6 = this.f2573A.get(i2, i2);
        float f7 = this.f2573A.get(i, i);
        int i4 = i + 1;
        float f8 = this.f2573A.get(i4, i);
        float f9 = this.f2573A.get(i, i4);
        float f10 = this.f2573A.get(i4, i4);
        float f11 = this.f2573A.get(i + 2, i4);
        if (this.normalize) {
            float[] fArr = this.temp;
            fArr[0] = f7;
            int i5 = 1;
            fArr[1] = f8;
            fArr[2] = f9;
            fArr[3] = f10;
            fArr[4] = f11;
            fArr[5] = f3;
            fArr[6] = f6;
            fArr[7] = f4;
            fArr[8] = f5;
            float fAbs = Math.abs(f7);
            while (true) {
                float[] fArr2 = this.temp;
                if (i5 >= fArr2.length) {
                    break;
                }
                if (Math.abs(fArr2[i5]) > fAbs) {
                    fAbs = Math.abs(this.temp[i5]);
                }
                i5++;
            }
            f7 /= fAbs;
            f8 /= fAbs;
            f9 /= fAbs;
            f10 /= fAbs;
            f11 /= fAbs;
            f3 /= fAbs;
            f6 /= fAbs;
            f4 /= fAbs;
            f5 /= fAbs;
        }
        if (this.useStandardEq) {
            f = ((((f7 - f3) * (f7 - f6)) - (f5 * f4)) / f8) + f9;
            f2 = ((f7 + f10) - f3) - f6;
        } else {
            f = (((f7 - f3) * (f7 - f6)) - (f5 * f4)) + (f9 * f8);
            f2 = (((f7 + f10) - f3) - f6) * f8;
            f11 *= f8;
        }
        performImplicitDoubleStep(i, i2, f, f2, f11);
    }

    public void performImplicitDoubleStep(int i, int i2, float f, float f2) {
        float f3;
        float f4;
        float f5 = this.f2573A.get(i, i);
        int i3 = i + 1;
        float f6 = this.f2573A.get(i3, i);
        float f7 = this.f2573A.get(i, i3);
        float f8 = this.f2573A.get(i3, i3);
        float f9 = this.f2573A.get(i + 2, i3);
        float f10 = 2.0f * f;
        float f11 = (f * f) + (f2 * f2);
        if (this.useStandardEq) {
            f3 = ((((f5 * f5) - (f10 * f5)) + f11) / f6) + f7;
            f4 = (f5 + f8) - f10;
        } else {
            f3 = ((f5 * f5) - (f10 * f5)) + f11 + (f7 * f6);
            f4 = ((f5 + f8) - f10) * f6;
            f9 *= f6;
        }
        performImplicitDoubleStep(i, i2, f3, f4, f9);
    }

    private void performImplicitDoubleStep(int i, int i2, float f, float f2, float f3) {
        int i3;
        FMatrixRMaj fMatrixRMaj;
        FMatrixRMaj fMatrixRMaj2;
        if (!bulgeDoubleStepQn(i, f, f2, f3, 0.0f, false)) {
            return;
        }
        FMatrixRMaj fMatrixRMaj3 = this.f2575Q;
        if (fMatrixRMaj3 != null) {
            QrHelperFunctions_FDRM.rank1UpdateMultR(fMatrixRMaj3, this.f2576u.data, this.gamma, 0, i, i + 3, this._temp.data);
            i3 = i;
            if (this.checkOrthogonal && !MatrixFeatures_FDRM.isOrthogonal(this.f2575Q, UtilEjml.TEST_F32)) {
                this.f2576u.print();
                this.f2575Q.print();
                throw new RuntimeException("Bad");
            }
        } else {
            i3 = i;
        }
        if (this.printHumps) {
            System.out.println("Applied first Q matrix, it should be humped now. A = ");
            this.f2573A.print("%12.3fe");
            System.out.println("Pushing the hump off the matrix.");
        }
        while (true) {
            int i4 = i2 - 2;
            if (i3 < i4) {
                if (bulgeDoubleStepQn(i3) && (fMatrixRMaj2 = this.f2575Q) != null) {
                    QrHelperFunctions_FDRM.rank1UpdateMultR(fMatrixRMaj2, this.f2576u.data, this.gamma, 0, i3 + 1, i3 + 4, this._temp.data);
                    if (this.checkOrthogonal && !MatrixFeatures_FDRM.isOrthogonal(this.f2575Q, UtilEjml.TEST_F32)) {
                        throw new RuntimeException("Bad");
                    }
                }
                if (this.printHumps) {
                    System.out.println("i = " + i3 + " A = ");
                    this.f2573A.print("%12.3fe");
                }
                i3++;
            } else {
                if (this.printHumps) {
                    System.out.println("removing last bump");
                }
                if (i4 >= 0 && bulgeSingleStepQn(i4) && (fMatrixRMaj = this.f2575Q) != null) {
                    QrHelperFunctions_FDRM.rank1UpdateMultR(fMatrixRMaj, this.f2576u.data, this.gamma, 0, i2 - 1, i2 + 1, this._temp.data);
                    if (this.checkOrthogonal && !MatrixFeatures_FDRM.isOrthogonal(this.f2575Q, UtilEjml.TEST_F32)) {
                        throw new RuntimeException("Bad");
                    }
                }
                if (this.printHumps) {
                    System.out.println(" A = ");
                    this.f2573A.print("%12.3fe");
                }
                if (!this.checkHessenberg || MatrixFeatures_FDRM.isUpperTriangle(this.f2573A, 1, UtilEjml.TEST_F32)) {
                    return;
                }
                this.f2573A.print("%12.3fe");
                throw new RuntimeException("Bad matrix");
            }
        }
    }

    public void performImplicitSingleStep(int i, int i2, float f) {
        int i3;
        FMatrixRMaj fMatrixRMaj;
        if (createBulgeSingleStep(i, f)) {
            FMatrixRMaj fMatrixRMaj2 = this.f2575Q;
            if (fMatrixRMaj2 != null) {
                i3 = i;
                QrHelperFunctions_FDRM.rank1UpdateMultR(fMatrixRMaj2, this.f2576u.data, this.gamma, 0, i3, i + 2, this._temp.data);
                if (this.checkOrthogonal && !MatrixFeatures_FDRM.isOrthogonal(this.f2575Q, UtilEjml.TEST_F32)) {
                    throw new RuntimeException("Bad");
                }
            } else {
                i3 = i;
            }
            if (this.printHumps) {
                System.out.println("Applied first Q matrix, it should be humped now. A = ");
                this.f2573A.print("%12.3fe");
                System.out.println("Pushing the hump off the matrix.");
            }
            for (int i4 = i3; i4 < i2 - 1; i4++) {
                if (bulgeSingleStepQn(i4) && (fMatrixRMaj = this.f2575Q) != null) {
                    QrHelperFunctions_FDRM.rank1UpdateMultR(fMatrixRMaj, this.f2576u.data, this.gamma, 0, i4 + 1, i4 + 3, this._temp.data);
                    if (this.checkOrthogonal && !MatrixFeatures_FDRM.isOrthogonal(this.f2575Q, UtilEjml.TESTP_F32)) {
                        throw new RuntimeException("Bad");
                    }
                }
                if (this.printHumps) {
                    System.out.println("i = " + i4 + " A = ");
                    this.f2573A.print("%12.3fe");
                }
            }
            if (!this.checkHessenberg || MatrixFeatures_FDRM.isUpperTriangle(this.f2573A, 1, UtilEjml.TESTP_F32)) {
                return;
            }
            this.f2573A.print("%12.3fe");
            throw new RuntimeException("Bad matrix");
        }
    }

    public boolean createBulgeSingleStep(int i, float f) {
        return bulgeSingleStepQn(i, this.f2573A.get(i, i) - f, this.f2573A.get(i + 1, i), Math.abs(this.f2573A.get(i, i)) * UtilEjml.F_EPS, false);
    }

    public boolean bulgeDoubleStepQn(int i) {
        int i2 = i + 1;
        return bulgeDoubleStepQn(i2, this.f2573A.get(i2, i), this.f2573A.get(i + 2, i), this.f2573A.get(i + 3, i), Math.abs(this.f2573A.get(i, i)) * UtilEjml.F_EPS, true);
    }

    public boolean bulgeDoubleStepQn(int i, float f, float f2, float f3, float f4, boolean z) {
        float f5;
        float f6;
        float f7;
        float f8;
        if (this.normalize) {
            float fAbs = Math.abs(f);
            float fAbs2 = Math.abs(f2);
            float fAbs3 = Math.abs(f3);
            if (fAbs <= fAbs2) {
                fAbs = fAbs2;
            }
            if (fAbs3 <= fAbs) {
                fAbs3 = fAbs;
            }
            if (fAbs3 <= f4) {
                if (z) {
                    int i2 = i - 1;
                    this.f2573A.set(i, i2, 0.0f);
                    this.f2573A.set(i + 1, i2, 0.0f);
                    this.f2573A.set(i + 2, i2, 0.0f);
                }
                return false;
            }
            f5 = f / fAbs3;
            f6 = f2 / fAbs3;
            f7 = f3 / fAbs3;
            f8 = fAbs3;
        } else {
            f5 = f;
            f6 = f2;
            f7 = f3;
            f8 = 1.0f;
        }
        float fSqrt = (float) Math.sqrt((f5 * f5) + (f6 * f6) + (f7 * f7));
        if (f5 < 0.0f) {
            fSqrt = -fSqrt;
        }
        float f9 = fSqrt;
        float f10 = f5 + f9;
        this.f2576u.set(i, 0, 1.0f);
        int i3 = i + 1;
        this.f2576u.set(i3, 0, f6 / f10);
        int i4 = i + 2;
        this.f2576u.set(i4, 0, f7 / f10);
        this.gamma = f10 / f9;
        int i5 = i + 3;
        QrHelperFunctions_FDRM.rank1UpdateMultR(this.f2573A, this.f2576u.data, this.gamma, 0, i, i5, this._temp.data);
        if (z) {
            int i6 = i - 1;
            this.f2573A.set(i, i6, (-f8) * f9);
            this.f2573A.set(i3, i6, 0.0f);
            this.f2573A.set(i4, i6, 0.0f);
        }
        if (this.printHumps) {
            System.out.println("  After Q.   A =");
            this.f2573A.print();
        }
        QrHelperFunctions_FDRM.rank1UpdateMultL(this.f2573A, this.f2576u.data, this.gamma, 0, i, i5);
        if (this.checkUncountable && MatrixFeatures_FDRM.hasUncountable(this.f2573A)) {
            throw new RuntimeException("bad matrix");
        }
        return true;
    }

    public boolean bulgeSingleStepQn(int i) {
        int i2 = i + 1;
        return bulgeSingleStepQn(i2, this.f2573A.get(i2, i), this.f2573A.get(i + 2, i), Math.abs(this.f2573A.get(i, i)) * UtilEjml.F_EPS, true);
    }

    public boolean bulgeSingleStepQn(int i, float f, float f2, float f3, boolean z) {
        float f4;
        float f5;
        float f6;
        if (this.normalize) {
            float fAbs = Math.abs(f);
            if (fAbs < Math.abs(f2)) {
                fAbs = Math.abs(f2);
            }
            if (fAbs <= f3) {
                if (z) {
                    int i2 = i - 1;
                    this.f2573A.set(i, i2, 0.0f);
                    this.f2573A.set(i + 1, i2, 0.0f);
                }
                return false;
            }
            f4 = f / fAbs;
            f5 = f2 / fAbs;
            f6 = fAbs;
        } else {
            f4 = f;
            f5 = f2;
            f6 = 1.0f;
        }
        float fSqrt = (float) Math.sqrt((f4 * f4) + (f5 * f5));
        if (f4 < 0.0f) {
            fSqrt = -fSqrt;
        }
        float f7 = fSqrt;
        float f8 = f4 + f7;
        this.f2576u.set(i, 0, 1.0f);
        int i3 = i + 1;
        this.f2576u.set(i3, 0, f5 / f8);
        this.gamma = f8 / f7;
        int i4 = i + 2;
        QrHelperFunctions_FDRM.rank1UpdateMultR(this.f2573A, this.f2576u.data, this.gamma, 0, i, i4, this._temp.data);
        if (z) {
            int i5 = i - 1;
            this.f2573A.set(i, i5, (-f6) * f7);
            this.f2573A.set(i3, i5, 0.0f);
        }
        QrHelperFunctions_FDRM.rank1UpdateMultL(this.f2573A, this.f2576u.data, this.gamma, 0, i, i4);
        if (this.checkUncountable && MatrixFeatures_FDRM.hasUncountable(this.f2573A)) {
            throw new RuntimeException("bad matrix");
        }
        return true;
    }

    public void eigen2by2_scale(float f, float f2, float f3, float f4) {
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f4);
        float fAbs3 = Math.abs(f2);
        float fAbs4 = Math.abs(f3);
        if (fAbs <= fAbs2) {
            fAbs = fAbs2;
        }
        if (fAbs >= fAbs3) {
            fAbs3 = fAbs;
        }
        if (fAbs3 >= fAbs4) {
            fAbs4 = fAbs3;
        }
        if (fAbs4 == 0.0f) {
            this.valueSmall.value0.real = 0.0f;
            this.valueSmall.value0.imaginary = 0.0f;
            this.valueSmall.value1.real = 0.0f;
            this.valueSmall.value1.imaginary = 0.0f;
            return;
        }
        float f5 = f2 / fAbs4;
        float f6 = f3 / fAbs4;
        float f7 = f / fAbs4;
        float f8 = f4 / fAbs4;
        if (this.useCareful2x2) {
            this.valueSmall.value2x2(f7, f5, f6, f8);
        } else {
            this.valueSmall.value2x2_fast(f7, f5, f6, f8);
        }
        this.valueSmall.value0.real *= fAbs4;
        this.valueSmall.value0.imaginary *= fAbs4;
        this.valueSmall.value1.real *= fAbs4;
        this.valueSmall.value1.imaginary *= fAbs4;
    }

    public int getNumberOfEigenvalues() {
        return this.numEigen;
    }

    public Complex_F32[] getEigenvalues() {
        return this.eigenvalues;
    }

    public void addComputedEigen2x2(int i, int i2) {
        eigen2by2_scale(this.f2573A.get(i, i), this.f2573A.get(i, i2), this.f2573A.get(i2, i), this.f2573A.get(i2, i2));
        if (this.checkUncountable && (Float.isNaN(this.valueSmall.value0.real) || Float.isNaN(this.valueSmall.value1.real))) {
            throw new RuntimeException("Uncountable");
        }
        addEigenvalue(this.valueSmall.value0.real, this.valueSmall.value0.imaginary);
        addEigenvalue(this.valueSmall.value1.real, this.valueSmall.value1.imaginary);
    }

    public boolean isReal2x2(int i, int i2) {
        eigen2by2_scale(this.f2573A.get(i, i), this.f2573A.get(i, i2), this.f2573A.get(i2, i), this.f2573A.get(i2, i2));
        return this.valueSmall.value0.isReal();
    }

    public void addEigenAt(int i) {
        addEigenvalue(this.f2573A.get(i, i));
    }

    public void printSteps() {
        for (int i = 0; i < this.f2574N; i++) {
            System.out.println("Step[" + i + "] = " + this.numStepsFind[i]);
        }
    }
}
