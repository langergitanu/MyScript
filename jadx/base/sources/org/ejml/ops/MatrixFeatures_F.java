package org.ejml.ops;

import org.ejml.UtilEjml;
import org.ejml.data.FMatrix;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixFeatures_F {
    public static boolean isEquals(FMatrix fMatrix, FMatrix fMatrix2) {
        if (fMatrix.getNumRows() != fMatrix2.getNumRows() || fMatrix.getNumCols() != fMatrix2.getNumCols()) {
            return false;
        }
        int numRows = fMatrix.getNumRows();
        int numCols = fMatrix.getNumCols();
        for (int i = 0; i < numRows; i++) {
            for (int i2 = 0; i2 < numCols; i2++) {
                if (fMatrix.unsafe_get(i, i2) != fMatrix2.unsafe_get(i, i2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isIdentical(FMatrix fMatrix, FMatrix fMatrix2, float f) {
        if (fMatrix.getNumRows() != fMatrix2.getNumRows() || fMatrix.getNumCols() != fMatrix2.getNumCols()) {
            return false;
        }
        if (f < 0.0f) {
            throw new IllegalArgumentException("Tolerance must be greater than or equal to zero.");
        }
        int numRows = fMatrix.getNumRows();
        int numCols = fMatrix.getNumCols();
        for (int i = 0; i < numRows; i++) {
            for (int i2 = 0; i2 < numCols; i2++) {
                if (!UtilEjml.isIdentical(fMatrix.unsafe_get(i, i2), fMatrix2.unsafe_get(i, i2), f)) {
                    return false;
                }
            }
        }
        return true;
    }
}
