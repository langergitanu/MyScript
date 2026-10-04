package org.ejml.dense.row;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.UtilEjml;
import org.ejml.data.Complex_F64;
import org.ejml.data.DEigenpair;
import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.decomposition.eig.EigenPowerMethod_DDRM;
import org.ejml.dense.row.factory.LinearSolverFactory_DDRM;
import org.ejml.dense.row.mult.VectorVectorMult_DDRM;
import org.ejml.interfaces.decomposition.EigenDecomposition_F64;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class EigenOps_DDRM {
    public static double computeEigenValue(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        return VectorVectorMult_DDRM.innerProdA(dMatrixRMaj2, dMatrixRMaj, dMatrixRMaj2) / VectorVectorMult_DDRM.innerProd(dMatrixRMaj2, dMatrixRMaj2);
    }

    public static DEigenpair computeEigenVector(DMatrixRMaj dMatrixRMaj, double d) {
        boolean z;
        int i;
        if (dMatrixRMaj.numRows != dMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Must be a square matrix.");
        }
        DMatrixRMaj dMatrixRMaj2 = new DMatrixRMaj(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        DMatrixRMaj dMatrixRMaj3 = new DMatrixRMaj(dMatrixRMaj.numRows, 1);
        DMatrixRMaj dMatrixRMaj4 = new DMatrixRMaj(dMatrixRMaj.numRows, 1);
        CommonOps_DDRM.fill(dMatrixRMaj4, 1.0d);
        SpecializedOps_DDRM.addIdentity(dMatrixRMaj, dMatrixRMaj2, -d);
        double dNormPInf = NormOps_DDRM.normPInf(dMatrixRMaj) * UtilEjml.EPS;
        LinearSolverDense<DMatrixRMaj> linearSolverDenseLinear = LinearSolverFactory_DDRM.linear(dMatrixRMaj2.numRows);
        double dInnerProdA = d;
        int i2 = 0;
        double d2 = Double.MAX_VALUE;
        boolean z2 = false;
        while (i2 < 200) {
            if (linearSolverDenseLinear.setA(dMatrixRMaj2)) {
                linearSolverDenseLinear.solve(dMatrixRMaj4, dMatrixRMaj3);
                z = false;
            } else {
                z = true;
            }
            if (MatrixFeatures_DDRM.hasUncountable(dMatrixRMaj3)) {
                z = true;
            }
            if (!z) {
                i = i2;
                dMatrixRMaj4.set((DMatrixD1) dMatrixRMaj3);
                NormOps_DDRM.normalizeF(dMatrixRMaj4);
                CommonOps_DDRM.mult(dMatrixRMaj2, dMatrixRMaj4, dMatrixRMaj3);
                double dNormPInf2 = NormOps_DDRM.normPInf(dMatrixRMaj3);
                if (dNormPInf2 - d2 > UtilEjml.EPS * 10.0d) {
                    dInnerProdA = Math.pow(i % 2 == 0 ? 0.9999d : 1.0001d, 1.0d) * d;
                    d2 = Double.MAX_VALUE;
                    z2 = false;
                } else {
                    if (dNormPInf2 <= dNormPInf || Math.abs(d2 - dNormPInf2) <= UtilEjml.EPS) {
                        return new DEigenpair(dInnerProdA, dMatrixRMaj4);
                    }
                    dInnerProdA = VectorVectorMult_DDRM.innerProdA(dMatrixRMaj4, dMatrixRMaj, dMatrixRMaj4);
                    d2 = dNormPInf2;
                    z2 = true;
                }
                SpecializedOps_DDRM.addIdentity(dMatrixRMaj, dMatrixRMaj2, -dInnerProdA);
            } else if (!z2) {
                i = i2;
                dInnerProdA = Math.pow(i2 % 2 == 0 ? 0.9999d : 1.0001d, (i2 / 2) + 1) * d;
                SpecializedOps_DDRM.addIdentity(dMatrixRMaj, dMatrixRMaj2, -dInnerProdA);
            } else {
                return new DEigenpair(dInnerProdA, dMatrixRMaj4);
            }
            i2 = i + 1;
        }
        return null;
    }

    public static DEigenpair dominantEigenpair(DMatrixRMaj dMatrixRMaj) {
        new EigenPowerMethod_DDRM(dMatrixRMaj.numRows).computeShiftInvert(dMatrixRMaj, 0.1d);
        return null;
    }

    public static double[] boundLargestEigenValue(DMatrixRMaj dMatrixRMaj, double[] dArr) {
        if (dMatrixRMaj.numRows != dMatrixRMaj.numCols) {
            throw new IllegalArgumentException("A must be a square matrix.");
        }
        int i = dMatrixRMaj.numRows;
        double d = Double.MAX_VALUE;
        double d2 = 0.0d;
        for (int i2 = 0; i2 < i; i2++) {
            double d3 = 0.0d;
            for (int i3 = 0; i3 < i; i3++) {
                double d4 = dMatrixRMaj.get(i2, i3);
                if (d4 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    throw new IllegalArgumentException("Matrix must be positive");
                }
                d3 += d4;
            }
            if (d3 < d) {
                d = d3;
            }
            if (d3 > d2) {
                d2 = d3;
            }
        }
        double[] dArr2 = dArr == null ? new double[2] : dArr;
        dArr2[0] = d;
        dArr2[1] = d2;
        return dArr2;
    }

    public static DMatrixRMaj createMatrixD(EigenDecomposition_F64 eigenDecomposition_F64) {
        int numberOfEigenvalues = eigenDecomposition_F64.getNumberOfEigenvalues();
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(numberOfEigenvalues, numberOfEigenvalues);
        for (int i = 0; i < numberOfEigenvalues; i++) {
            Complex_F64 eigenvalue = eigenDecomposition_F64.getEigenvalue(i);
            if (eigenvalue.isReal()) {
                dMatrixRMaj.set(i, i, eigenvalue.real);
            }
        }
        return dMatrixRMaj;
    }

    public static DMatrixRMaj createMatrixV(EigenDecomposition_F64<DMatrixRMaj> eigenDecomposition_F64) {
        DMatrixRMaj eigenVector;
        int numberOfEigenvalues = eigenDecomposition_F64.getNumberOfEigenvalues();
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(numberOfEigenvalues, numberOfEigenvalues);
        for (int i = 0; i < numberOfEigenvalues; i++) {
            if (eigenDecomposition_F64.getEigenvalue(i).isReal() && (eigenVector = eigenDecomposition_F64.getEigenVector(i)) != null) {
                for (int i2 = 0; i2 < numberOfEigenvalues; i2++) {
                    dMatrixRMaj.set(i2, i, eigenVector.get(i2, 0));
                }
            }
        }
        return dMatrixRMaj;
    }
}
