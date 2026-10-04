package org.ejml.ops;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.UtilEjml;
import org.ejml.data.DMatrix;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixFeatures_D {
    public static boolean isEquals(DMatrix dMatrix, DMatrix dMatrix2) {
        if (dMatrix.getNumRows() != dMatrix2.getNumRows() || dMatrix.getNumCols() != dMatrix2.getNumCols()) {
            return false;
        }
        int numRows = dMatrix.getNumRows();
        int numCols = dMatrix.getNumCols();
        for (int i = 0; i < numRows; i++) {
            for (int i2 = 0; i2 < numCols; i2++) {
                if (dMatrix.unsafe_get(i, i2) != dMatrix2.unsafe_get(i, i2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isIdentical(DMatrix dMatrix, DMatrix dMatrix2, double d) {
        if (dMatrix.getNumRows() != dMatrix2.getNumRows() || dMatrix.getNumCols() != dMatrix2.getNumCols()) {
            return false;
        }
        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            throw new IllegalArgumentException("Tolerance must be greater than or equal to zero.");
        }
        int numRows = dMatrix.getNumRows();
        int numCols = dMatrix.getNumCols();
        for (int i = 0; i < numRows; i++) {
            int i2 = 0;
            while (i2 < numCols) {
                double d2 = d;
                if (!UtilEjml.isIdentical(dMatrix.unsafe_get(i, i2), dMatrix2.unsafe_get(i, i2), d2)) {
                    return false;
                }
                i2++;
                d = d2;
            }
        }
        return true;
    }
}
