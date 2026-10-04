package org.ejml.dense.row;

import java.util.Random;
import org.ejml.LinearSolverSafe;
import org.ejml.UtilEjml;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.factory.LinearSolverFactory_DDRM;
import org.ejml.dense.row.misc.UnrolledInverseFromMinor_DDRM;

/* JADX INFO: loaded from: classes9.dex */
public class CovarianceOps_DDRM {
    public static double TOL = UtilEjml.TESTP_F64;

    public static boolean isValidFast(DMatrixRMaj dMatrixRMaj) {
        return MatrixFeatures_DDRM.isDiagonalPositive(dMatrixRMaj);
    }

    public static int isValid(DMatrixRMaj dMatrixRMaj) {
        if (!MatrixFeatures_DDRM.isDiagonalPositive(dMatrixRMaj)) {
            return 1;
        }
        if (MatrixFeatures_DDRM.isSymmetric(dMatrixRMaj, TOL)) {
            return !MatrixFeatures_DDRM.isPositiveSemidefinite(dMatrixRMaj) ? 3 : 0;
        }
        return 2;
    }

    public static boolean invert(DMatrixRMaj dMatrixRMaj) {
        return invert(dMatrixRMaj, dMatrixRMaj);
    }

    public static boolean invert(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj.numCols <= 4) {
            if (dMatrixRMaj.numCols != dMatrixRMaj.numRows) {
                throw new IllegalArgumentException("Must be a square matrix.");
            }
            if (dMatrixRMaj.numCols >= 2) {
                UnrolledInverseFromMinor_DDRM.inv(dMatrixRMaj, dMatrixRMaj2);
                return true;
            }
            dMatrixRMaj2.data[0] = 1.0d / dMatrixRMaj2.data[0];
            return true;
        }
        LinearSolverSafe linearSolverSafe = new LinearSolverSafe(LinearSolverFactory_DDRM.symmPosDef(dMatrixRMaj.numRows));
        if (!linearSolverSafe.setA(dMatrixRMaj)) {
            return false;
        }
        linearSolverSafe.invert(dMatrixRMaj2);
        return true;
    }

    public static void randomVector(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, Random random) {
        new CovarianceRandomDraw_DDRM(random, dMatrixRMaj).next(dMatrixRMaj2);
    }
}
