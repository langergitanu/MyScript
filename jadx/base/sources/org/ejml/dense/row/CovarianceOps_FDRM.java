package org.ejml.dense.row;

import java.util.Random;
import org.ejml.LinearSolverSafe;
import org.ejml.UtilEjml;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.factory.LinearSolverFactory_FDRM;
import org.ejml.dense.row.misc.UnrolledInverseFromMinor_FDRM;

/* JADX INFO: loaded from: classes9.dex */
public class CovarianceOps_FDRM {
    public static float TOL = UtilEjml.TESTP_F32;

    public static boolean isValidFast(FMatrixRMaj fMatrixRMaj) {
        return MatrixFeatures_FDRM.isDiagonalPositive(fMatrixRMaj);
    }

    public static int isValid(FMatrixRMaj fMatrixRMaj) {
        if (!MatrixFeatures_FDRM.isDiagonalPositive(fMatrixRMaj)) {
            return 1;
        }
        if (MatrixFeatures_FDRM.isSymmetric(fMatrixRMaj, TOL)) {
            return !MatrixFeatures_FDRM.isPositiveSemidefinite(fMatrixRMaj) ? 3 : 0;
        }
        return 2;
    }

    public static boolean invert(FMatrixRMaj fMatrixRMaj) {
        return invert(fMatrixRMaj, fMatrixRMaj);
    }

    public static boolean invert(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj.numCols <= 4) {
            if (fMatrixRMaj.numCols != fMatrixRMaj.numRows) {
                throw new IllegalArgumentException("Must be a square matrix.");
            }
            if (fMatrixRMaj.numCols >= 2) {
                UnrolledInverseFromMinor_FDRM.inv(fMatrixRMaj, fMatrixRMaj2);
                return true;
            }
            fMatrixRMaj2.data[0] = 1.0f / fMatrixRMaj2.data[0];
            return true;
        }
        LinearSolverSafe linearSolverSafe = new LinearSolverSafe(LinearSolverFactory_FDRM.symmPosDef(fMatrixRMaj.numRows));
        if (!linearSolverSafe.setA(fMatrixRMaj)) {
            return false;
        }
        linearSolverSafe.invert(fMatrixRMaj2);
        return true;
    }

    public static void randomVector(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, Random random) {
        new CovarianceRandomDraw_FDRM(random, fMatrixRMaj).next(fMatrixRMaj2);
    }
}
