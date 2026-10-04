package org.ejml.dense.row.decomposition.eig.watched;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Random;
import org.ejml.UtilEjml;
import org.ejml.data.Complex_F64;
import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.MatrixFeatures_DDRM;
import org.ejml.dense.row.decomposition.eig.EigenvalueSmall_F64;
import org.ejml.dense.row.decomposition.p050qr.QrHelperFunctions_DDRM;

/* JADX INFO: loaded from: classes9.dex */
public class WatchedDoubleStepQREigen_DDRM {

    /* JADX INFO: renamed from: A */
    DMatrixRMaj f2569A;

    /* JADX INFO: renamed from: N */
    private int f2570N;

    /* JADX INFO: renamed from: Q */
    public DMatrixRMaj f2571Q;
    private DMatrixRMaj _temp;
    Complex_F64[] eigenvalues;
    private double gamma;
    int lastExceptional;
    int numEigen;
    int numExceptional;
    int[] numStepsFind;
    int steps;

    /* JADX INFO: renamed from: u */
    private DMatrixRMaj f2572u;
    private Random rand = new Random(9026);
    private EigenvalueSmall_F64 valueSmall = new EigenvalueSmall_F64();
    private double[] temp = new double[9];
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

    public void setQ(DMatrixRMaj dMatrixRMaj) {
        this.f2571Q = dMatrixRMaj;
    }

    private void addEigenvalue(double d) {
        int[] iArr = this.numStepsFind;
        int i = this.numEigen;
        iArr[i] = this.steps;
        this.eigenvalues[i].set(d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        this.numEigen++;
        this.steps = 0;
        this.lastExceptional = 0;
    }

    private void addEigenvalue(double d, double d2) {
        int[] iArr = this.numStepsFind;
        int i = this.numEigen;
        iArr[i] = this.steps;
        this.eigenvalues[i].set(d, d2);
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
        return Math.abs(this.f2569A.get(i, i2)) <= (UtilEjml.EPS * 0.5d) * (Math.abs(this.f2569A.get(i + (-1), i2)) + Math.abs(this.f2569A.get(i, i2 + 1)));
    }

    public void setup(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj.numRows != dMatrixRMaj.numCols) {
            throw new RuntimeException("Must be square");
        }
        if (this.f2570N != dMatrixRMaj.numRows) {
            this.f2570N = dMatrixRMaj.numRows;
            this.f2569A = dMatrixRMaj.copy();
            this.f2572u = new DMatrixRMaj(dMatrixRMaj.numRows, 1);
            this._temp = new DMatrixRMaj(dMatrixRMaj.numRows, 1);
            this.numStepsFind = new int[dMatrixRMaj.numRows];
        } else {
            this.f2569A.set((DMatrixD1) dMatrixRMaj);
            int[] iArr = this.numStepsFind;
            UtilEjml.memset(iArr, 0, iArr.length);
        }
        for (int i = 2; i < this.f2570N; i++) {
            for (int i2 = 0; i2 < i - 1; i2++) {
                this.f2569A.set(i, i2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            }
        }
        this.eigenvalues = new Complex_F64[dMatrixRMaj.numRows];
        int i3 = 0;
        while (true) {
            Complex_F64[] complex_F64Arr = this.eigenvalues;
            if (i3 < complex_F64Arr.length) {
                complex_F64Arr[i3] = new Complex_F64();
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
            System.out.println("Performing exceptional implicit double step");
        }
        double dAbs = Math.abs(this.f2569A.get(i2, i2));
        if (dAbs == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            dAbs = 1.0d;
        }
        int i3 = this.numExceptional + 1;
        this.numExceptional = i3;
        double dPow = 1.0d - Math.pow(0.1d, i3);
        double dNextDouble = dAbs * (dPow + ((1.0d - dPow) * 2.0d * (this.rand.nextDouble() - 0.5d)));
        if (this.rand.nextBoolean()) {
            dNextDouble = -dNextDouble;
        }
        performImplicitSingleStep(i, i2, dNextDouble);
        this.lastExceptional = this.steps;
    }

    public void implicitDoubleStep(int i, int i2) {
        double d;
        double d2;
        double d3;
        if (this.printHumps) {
            System.out.println("Performing implicit double step");
        }
        int i3 = i2 - 1;
        double d4 = this.f2569A.get(i3, i3);
        double d5 = this.f2569A.get(i3, i2);
        double d6 = this.f2569A.get(i2, i3);
        double d7 = this.f2569A.get(i2, i2);
        double d8 = this.f2569A.get(i, i);
        int i4 = i + 1;
        double d9 = this.f2569A.get(i4, i);
        double d10 = this.f2569A.get(i, i4);
        double d11 = this.f2569A.get(i4, i4);
        double d12 = this.f2569A.get(i + 2, i4);
        if (this.normalize) {
            double[] dArr = this.temp;
            dArr[0] = d8;
            dArr[1] = d9;
            dArr[2] = d10;
            dArr[3] = d11;
            dArr[4] = d12;
            dArr[5] = d4;
            dArr[6] = d7;
            dArr[7] = d5;
            dArr[8] = d6;
            double dAbs = Math.abs(d8);
            int i5 = 1;
            while (true) {
                double[] dArr2 = this.temp;
                d3 = d6;
                if (i5 >= dArr2.length) {
                    break;
                }
                if (Math.abs(dArr2[i5]) > dAbs) {
                    dAbs = Math.abs(this.temp[i5]);
                }
                i5++;
                d6 = d3;
            }
            d8 /= dAbs;
            d9 /= dAbs;
            d10 /= dAbs;
            d11 /= dAbs;
            d12 /= dAbs;
            d4 /= dAbs;
            d7 /= dAbs;
            d5 /= dAbs;
            d6 = d3 / dAbs;
        }
        if (this.useStandardEq) {
            d = ((((d8 - d4) * (d8 - d7)) - (d6 * d5)) / d9) + d10;
            d2 = ((d8 + d11) - d4) - d7;
        } else {
            d = (((d8 - d4) * (d8 - d7)) - (d6 * d5)) + (d10 * d9);
            d2 = (((d8 + d11) - d4) - d7) * d9;
            d12 *= d9;
        }
        performImplicitDoubleStep(i, i2, d, d2, d12);
    }

    public void performImplicitDoubleStep(int i, int i2, double d, double d2) {
        double d3;
        double d4;
        double d5 = this.f2569A.get(i, i);
        int i3 = i + 1;
        double d6 = this.f2569A.get(i3, i);
        double d7 = this.f2569A.get(i, i3);
        double d8 = this.f2569A.get(i3, i3);
        double d9 = this.f2569A.get(i + 2, i3);
        double d10 = 2.0d * d;
        double d11 = (d * d) + (d2 * d2);
        if (this.useStandardEq) {
            d3 = ((((d5 * d5) - (d10 * d5)) + d11) / d6) + d7;
            d4 = (d5 + d8) - d10;
        } else {
            d3 = ((d5 * d5) - (d10 * d5)) + d11 + (d7 * d6);
            d4 = ((d5 + d8) - d10) * d6;
            d9 *= d6;
        }
        double d12 = d3;
        performImplicitDoubleStep(i, i2, d12, d4, d9);
    }

    private void performImplicitDoubleStep(int i, int i2, double d, double d2, double d3) {
        DMatrixRMaj dMatrixRMaj;
        DMatrixRMaj dMatrixRMaj2;
        if (!bulgeDoubleStepQn(i, d, d2, d3, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false)) {
            return;
        }
        DMatrixRMaj dMatrixRMaj3 = this.f2571Q;
        if (dMatrixRMaj3 != null) {
            QrHelperFunctions_DDRM.rank1UpdateMultR(dMatrixRMaj3, this.f2572u.data, this.gamma, 0, i, i + 3, this._temp.data);
            if (this.checkOrthogonal && !MatrixFeatures_DDRM.isOrthogonal(this.f2571Q, UtilEjml.TEST_F64)) {
                this.f2572u.print();
                this.f2571Q.print();
                throw new RuntimeException("Bad");
            }
        }
        if (this.printHumps) {
            System.out.println("Applied first Q matrix, it should be humped now. A = ");
            this.f2569A.print("%12.3e");
            System.out.println("Pushing the hump off the matrix.");
        }
        while (true) {
            int i3 = i2 - 2;
            if (i < i3) {
                if (bulgeDoubleStepQn(i) && (dMatrixRMaj2 = this.f2571Q) != null) {
                    QrHelperFunctions_DDRM.rank1UpdateMultR(dMatrixRMaj2, this.f2572u.data, this.gamma, 0, i + 1, i + 4, this._temp.data);
                    if (this.checkOrthogonal && !MatrixFeatures_DDRM.isOrthogonal(this.f2571Q, UtilEjml.TEST_F64)) {
                        throw new RuntimeException("Bad");
                    }
                }
                if (this.printHumps) {
                    System.out.println("i = " + i + " A = ");
                    this.f2569A.print("%12.3e");
                }
                i++;
            } else {
                if (this.printHumps) {
                    System.out.println("removing last bump");
                }
                if (i3 >= 0 && bulgeSingleStepQn(i3) && (dMatrixRMaj = this.f2571Q) != null) {
                    QrHelperFunctions_DDRM.rank1UpdateMultR(dMatrixRMaj, this.f2572u.data, this.gamma, 0, i2 - 1, i2 + 1, this._temp.data);
                    if (this.checkOrthogonal && !MatrixFeatures_DDRM.isOrthogonal(this.f2571Q, UtilEjml.TEST_F64)) {
                        throw new RuntimeException("Bad");
                    }
                }
                if (this.printHumps) {
                    System.out.println(" A = ");
                    this.f2569A.print("%12.3e");
                }
                if (!this.checkHessenberg || MatrixFeatures_DDRM.isUpperTriangle(this.f2569A, 1, UtilEjml.TEST_F64)) {
                    return;
                }
                this.f2569A.print("%12.3e");
                throw new RuntimeException("Bad matrix");
            }
        }
    }

    public void performImplicitSingleStep(int i, int i2, double d) {
        int i3;
        DMatrixRMaj dMatrixRMaj;
        if (createBulgeSingleStep(i, d)) {
            DMatrixRMaj dMatrixRMaj2 = this.f2571Q;
            if (dMatrixRMaj2 != null) {
                i3 = i;
                QrHelperFunctions_DDRM.rank1UpdateMultR(dMatrixRMaj2, this.f2572u.data, this.gamma, 0, i3, i + 2, this._temp.data);
                if (this.checkOrthogonal && !MatrixFeatures_DDRM.isOrthogonal(this.f2571Q, UtilEjml.TEST_F64)) {
                    throw new RuntimeException("Bad");
                }
            } else {
                i3 = i;
            }
            if (this.printHumps) {
                System.out.println("Applied first Q matrix, it should be humped now. A = ");
                this.f2569A.print("%12.3e");
                System.out.println("Pushing the hump off the matrix.");
            }
            for (int i4 = i3; i4 < i2 - 1; i4++) {
                if (bulgeSingleStepQn(i4) && (dMatrixRMaj = this.f2571Q) != null) {
                    QrHelperFunctions_DDRM.rank1UpdateMultR(dMatrixRMaj, this.f2572u.data, this.gamma, 0, i4 + 1, i4 + 3, this._temp.data);
                    if (this.checkOrthogonal && !MatrixFeatures_DDRM.isOrthogonal(this.f2571Q, UtilEjml.TESTP_F64)) {
                        throw new RuntimeException("Bad");
                    }
                }
                if (this.printHumps) {
                    System.out.println("i = " + i4 + " A = ");
                    this.f2569A.print("%12.3e");
                }
            }
            if (!this.checkHessenberg || MatrixFeatures_DDRM.isUpperTriangle(this.f2569A, 1, UtilEjml.TESTP_F64)) {
                return;
            }
            this.f2569A.print("%12.3e");
            throw new RuntimeException("Bad matrix");
        }
    }

    public boolean createBulgeSingleStep(int i, double d) {
        return bulgeSingleStepQn(i, this.f2569A.get(i, i) - d, this.f2569A.get(i + 1, i), Math.abs(this.f2569A.get(i, i)) * UtilEjml.EPS, false);
    }

    public boolean bulgeDoubleStepQn(int i) {
        int i2 = i + 1;
        return bulgeDoubleStepQn(i2, this.f2569A.get(i2, i), this.f2569A.get(i + 2, i), this.f2569A.get(i + 3, i), UtilEjml.EPS * Math.abs(this.f2569A.get(i, i)), true);
    }

    public boolean bulgeDoubleStepQn(int i, double d, double d2, double d3, double d4, boolean z) {
        double d5;
        double d6;
        double d7;
        double dAbs;
        if (this.normalize) {
            double dAbs2 = Math.abs(d);
            double dAbs3 = Math.abs(d2);
            dAbs = Math.abs(d3);
            if (dAbs2 <= dAbs3) {
                dAbs2 = dAbs3;
            }
            if (dAbs <= dAbs2) {
                dAbs = dAbs2;
            }
            if (dAbs <= d4) {
                if (z) {
                    int i2 = i - 1;
                    this.f2569A.set(i, i2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                    this.f2569A.set(i + 1, i2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                    this.f2569A.set(i + 2, i2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                }
                return false;
            }
            d5 = d / dAbs;
            d6 = d2 / dAbs;
            d7 = d3 / dAbs;
        } else {
            d5 = d;
            d6 = d2;
            d7 = d3;
            dAbs = 1.0d;
        }
        double dSqrt = Math.sqrt((d5 * d5) + (d6 * d6) + (d7 * d7));
        if (d5 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            dSqrt = -dSqrt;
        }
        double d8 = d5 + dSqrt;
        this.f2572u.set(i, 0, 1.0d);
        int i3 = i + 1;
        this.f2572u.set(i3, 0, d6 / d8);
        int i4 = i + 2;
        this.f2572u.set(i4, 0, d7 / d8);
        this.gamma = d8 / dSqrt;
        int i5 = i + 3;
        QrHelperFunctions_DDRM.rank1UpdateMultR(this.f2569A, this.f2572u.data, this.gamma, 0, i, i5, this._temp.data);
        if (z) {
            int i6 = i - 1;
            this.f2569A.set(i, i6, (-dAbs) * dSqrt);
            this.f2569A.set(i3, i6, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            this.f2569A.set(i4, i6, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
        if (this.printHumps) {
            System.out.println("  After Q.   A =");
            this.f2569A.print();
        }
        QrHelperFunctions_DDRM.rank1UpdateMultL(this.f2569A, this.f2572u.data, this.gamma, 0, i, i5);
        if (this.checkUncountable && MatrixFeatures_DDRM.hasUncountable(this.f2569A)) {
            throw new RuntimeException("bad matrix");
        }
        return true;
    }

    public boolean bulgeSingleStepQn(int i) {
        int i2 = i + 1;
        return bulgeSingleStepQn(i2, this.f2569A.get(i2, i), this.f2569A.get(i + 2, i), UtilEjml.EPS * Math.abs(this.f2569A.get(i, i)), true);
    }

    public boolean bulgeSingleStepQn(int i, double d, double d2, double d3, boolean z) {
        double d4;
        double d5;
        double dAbs;
        if (this.normalize) {
            dAbs = Math.abs(d);
            if (dAbs < Math.abs(d2)) {
                dAbs = Math.abs(d2);
            }
            if (dAbs <= d3) {
                if (z) {
                    int i2 = i - 1;
                    this.f2569A.set(i, i2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                    this.f2569A.set(i + 1, i2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                }
                return false;
            }
            d4 = d / dAbs;
            d5 = d2 / dAbs;
        } else {
            d4 = d;
            d5 = d2;
            dAbs = 1.0d;
        }
        double d6 = d4;
        double dSqrt = Math.sqrt((d4 * d4) + (d5 * d5));
        if (d6 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            dSqrt = -dSqrt;
        }
        double d7 = d6 + dSqrt;
        this.f2572u.set(i, 0, 1.0d);
        int i3 = i + 1;
        this.f2572u.set(i3, 0, d5 / d7);
        this.gamma = d7 / dSqrt;
        double d8 = dAbs;
        int i4 = i + 2;
        QrHelperFunctions_DDRM.rank1UpdateMultR(this.f2569A, this.f2572u.data, this.gamma, 0, i, i4, this._temp.data);
        if (z) {
            int i5 = i - 1;
            this.f2569A.set(i, i5, (-d8) * dSqrt);
            this.f2569A.set(i3, i5, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
        QrHelperFunctions_DDRM.rank1UpdateMultL(this.f2569A, this.f2572u.data, this.gamma, 0, i, i4);
        if (this.checkUncountable && MatrixFeatures_DDRM.hasUncountable(this.f2569A)) {
            throw new RuntimeException("bad matrix");
        }
        return true;
    }

    public void eigen2by2_scale(double d, double d2, double d3, double d4) {
        double dAbs = Math.abs(d);
        double dAbs2 = Math.abs(d4);
        double dAbs3 = Math.abs(d2);
        double dAbs4 = Math.abs(d3);
        if (dAbs <= dAbs2) {
            dAbs = dAbs2;
        }
        if (dAbs >= dAbs3) {
            dAbs3 = dAbs;
        }
        if (dAbs3 >= dAbs4) {
            dAbs4 = dAbs3;
        }
        if (dAbs4 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.valueSmall.value0.real = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            this.valueSmall.value0.imaginary = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            this.valueSmall.value1.real = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            this.valueSmall.value1.imaginary = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            return;
        }
        double d5 = d2 / dAbs4;
        double d6 = d3 / dAbs4;
        double d7 = d / dAbs4;
        double d8 = d4 / dAbs4;
        if (this.useCareful2x2) {
            this.valueSmall.value2x2(d7, d5, d6, d8);
        } else {
            this.valueSmall.value2x2_fast(d7, d5, d6, d8);
        }
        this.valueSmall.value0.real *= dAbs4;
        this.valueSmall.value0.imaginary *= dAbs4;
        this.valueSmall.value1.real *= dAbs4;
        this.valueSmall.value1.imaginary *= dAbs4;
    }

    public int getNumberOfEigenvalues() {
        return this.numEigen;
    }

    public Complex_F64[] getEigenvalues() {
        return this.eigenvalues;
    }

    public void addComputedEigen2x2(int i, int i2) {
        eigen2by2_scale(this.f2569A.get(i, i), this.f2569A.get(i, i2), this.f2569A.get(i2, i), this.f2569A.get(i2, i2));
        if (this.checkUncountable && (Double.isNaN(this.valueSmall.value0.real) || Double.isNaN(this.valueSmall.value1.real))) {
            throw new RuntimeException("Uncountable");
        }
        addEigenvalue(this.valueSmall.value0.real, this.valueSmall.value0.imaginary);
        addEigenvalue(this.valueSmall.value1.real, this.valueSmall.value1.imaginary);
    }

    public boolean isReal2x2(int i, int i2) {
        eigen2by2_scale(this.f2569A.get(i, i), this.f2569A.get(i, i2), this.f2569A.get(i2, i), this.f2569A.get(i2, i2));
        return this.valueSmall.value0.isReal();
    }

    public void addEigenAt(int i) {
        addEigenvalue(this.f2569A.get(i, i));
    }

    public void printSteps() {
        for (int i = 0; i < this.f2570N; i++) {
            System.out.println("Step[" + i + "] = " + this.numStepsFind[i]);
        }
    }
}
