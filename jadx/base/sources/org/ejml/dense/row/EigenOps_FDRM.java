package org.ejml.dense.row;

import org.ejml.UtilEjml;
import org.ejml.data.Complex_F32;
import org.ejml.data.FEigenpair;
import org.ejml.data.FMatrixD1;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.decomposition.eig.EigenPowerMethod_FDRM;
import org.ejml.dense.row.factory.LinearSolverFactory_FDRM;
import org.ejml.dense.row.mult.VectorVectorMult_FDRM;
import org.ejml.interfaces.decomposition.EigenDecomposition_F32;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class EigenOps_FDRM {
    public static float computeEigenValue(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        return VectorVectorMult_FDRM.innerProdA(fMatrixRMaj2, fMatrixRMaj, fMatrixRMaj2) / VectorVectorMult_FDRM.innerProd(fMatrixRMaj2, fMatrixRMaj2);
    }

    public static FEigenpair computeEigenVector(FMatrixRMaj fMatrixRMaj, float f) {
        int i;
        float f2;
        float fInnerProdA;
        if (fMatrixRMaj.numRows != fMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Must be a square matrix.");
        }
        FMatrixRMaj fMatrixRMaj2 = new FMatrixRMaj(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        int i2 = 1;
        FMatrixRMaj fMatrixRMaj3 = new FMatrixRMaj(fMatrixRMaj.numRows, 1);
        FMatrixRMaj fMatrixRMaj4 = new FMatrixRMaj(fMatrixRMaj.numRows, 1);
        CommonOps_FDRM.fill(fMatrixRMaj4, 1.0f);
        SpecializedOps_FDRM.addIdentity(fMatrixRMaj, fMatrixRMaj2, -f);
        float fNormPInf = NormOps_FDRM.normPInf(fMatrixRMaj) * UtilEjml.F_EPS;
        LinearSolverDense<FMatrixRMaj> linearSolverDenseLinear = LinearSolverFactory_FDRM.linear(fMatrixRMaj2.numRows);
        float f3 = f;
        float f4 = Float.MAX_VALUE;
        int i3 = 0;
        boolean z = false;
        while (i3 < 200) {
            if (linearSolverDenseLinear.setA(fMatrixRMaj2)) {
                linearSolverDenseLinear.solve(fMatrixRMaj4, fMatrixRMaj3);
                i = 0;
            } else {
                i = i2;
            }
            if (MatrixFeatures_FDRM.hasUncountable(fMatrixRMaj3)) {
                i = i2;
            }
            if (i == 0) {
                f2 = fNormPInf;
                fMatrixRMaj4.set((FMatrixD1) fMatrixRMaj3);
                NormOps_FDRM.normalizeF(fMatrixRMaj4);
                CommonOps_FDRM.mult(fMatrixRMaj2, fMatrixRMaj4, fMatrixRMaj3);
                float fNormPInf2 = NormOps_FDRM.normPInf(fMatrixRMaj3);
                if (fNormPInf2 - f4 > UtilEjml.F_EPS * 10.0f) {
                    fInnerProdA = ((float) Math.pow(i3 % 2 != 0 ? 1.0001f : 0.9999f, 1.0d)) * f;
                    f4 = Float.MAX_VALUE;
                    z = false;
                } else {
                    if (fNormPInf2 <= f2 || Math.abs(f4 - fNormPInf2) <= UtilEjml.F_EPS) {
                        return new FEigenpair(f3, fMatrixRMaj4);
                    }
                    f4 = fNormPInf2;
                    fInnerProdA = VectorVectorMult_FDRM.innerProdA(fMatrixRMaj4, fMatrixRMaj, fMatrixRMaj4);
                    z = true;
                }
                SpecializedOps_FDRM.addIdentity(fMatrixRMaj, fMatrixRMaj2, -fInnerProdA);
            } else if (!z) {
                f2 = fNormPInf;
                fInnerProdA = ((float) Math.pow(i3 % 2 != 0 ? 1.0001f : 0.9999f, (i3 / 2) + i2)) * f;
                SpecializedOps_FDRM.addIdentity(fMatrixRMaj, fMatrixRMaj2, -fInnerProdA);
            } else {
                return new FEigenpair(f3, fMatrixRMaj4);
            }
            f3 = fInnerProdA;
            i3++;
            fNormPInf = f2;
            i2 = 1;
        }
        return null;
    }

    public static FEigenpair dominantEigenpair(FMatrixRMaj fMatrixRMaj) {
        new EigenPowerMethod_FDRM(fMatrixRMaj.numRows).computeShiftInvert(fMatrixRMaj, 0.1f);
        return null;
    }

    public static float[] boundLargestEigenValue(FMatrixRMaj fMatrixRMaj, float[] fArr) {
        if (fMatrixRMaj.numRows != fMatrixRMaj.numCols) {
            throw new IllegalArgumentException("A must be a square matrix.");
        }
        int i = fMatrixRMaj.numRows;
        float f = Float.MAX_VALUE;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < i; i2++) {
            float f3 = 0.0f;
            for (int i3 = 0; i3 < i; i3++) {
                float f4 = fMatrixRMaj.get(i2, i3);
                if (f4 < 0.0f) {
                    throw new IllegalArgumentException("Matrix must be positive");
                }
                f3 += f4;
            }
            if (f3 < f) {
                f = f3;
            }
            if (f3 > f2) {
                f2 = f3;
            }
        }
        if (fArr == null) {
            fArr = new float[2];
        }
        fArr[0] = f;
        fArr[1] = f2;
        return fArr;
    }

    public static FMatrixRMaj createMatrixD(EigenDecomposition_F32 eigenDecomposition_F32) {
        int numberOfEigenvalues = eigenDecomposition_F32.getNumberOfEigenvalues();
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(numberOfEigenvalues, numberOfEigenvalues);
        for (int i = 0; i < numberOfEigenvalues; i++) {
            Complex_F32 eigenvalue = eigenDecomposition_F32.getEigenvalue(i);
            if (eigenvalue.isReal()) {
                fMatrixRMaj.set(i, i, eigenvalue.real);
            }
        }
        return fMatrixRMaj;
    }

    public static FMatrixRMaj createMatrixV(EigenDecomposition_F32<FMatrixRMaj> eigenDecomposition_F32) {
        FMatrixRMaj eigenVector;
        int numberOfEigenvalues = eigenDecomposition_F32.getNumberOfEigenvalues();
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(numberOfEigenvalues, numberOfEigenvalues);
        for (int i = 0; i < numberOfEigenvalues; i++) {
            if (eigenDecomposition_F32.getEigenvalue(i).isReal() && (eigenVector = eigenDecomposition_F32.getEigenVector(i)) != null) {
                for (int i2 = 0; i2 < numberOfEigenvalues; i2++) {
                    fMatrixRMaj.set(i2, i, eigenVector.get(i2, 0));
                }
            }
        }
        return fMatrixRMaj;
    }
}
