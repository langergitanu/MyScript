package org.ejml.generic;

import java.util.Random;
import org.ejml.data.DMatrix;

/* JADX INFO: loaded from: classes9.dex */
public class GenericMatrixOps_F64 {
    public static boolean isEquivalent(DMatrix dMatrix, DMatrix dMatrix2, double d) {
        if (dMatrix.getNumRows() != dMatrix2.getNumRows() || dMatrix.getNumCols() != dMatrix2.getNumCols()) {
            return false;
        }
        for (int i = 0; i < dMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < dMatrix.getNumCols(); i2++) {
                if (Math.abs(dMatrix.get(i, i2) - dMatrix2.get(i, i2)) > d) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isIdentity(DMatrix dMatrix, double d) {
        for (int i = 0; i < dMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < dMatrix.getNumCols(); i2++) {
                if (i == i2) {
                    if (Math.abs(dMatrix.get(i, i2) - 1.0d) > d) {
                        return false;
                    }
                } else if (Math.abs(dMatrix.get(i, i2)) > d) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEquivalentTriangle(boolean z, DMatrix dMatrix, DMatrix dMatrix2, double d) {
        if (dMatrix.getNumRows() != dMatrix2.getNumRows() || dMatrix.getNumCols() != dMatrix2.getNumCols()) {
            return false;
        }
        if (z) {
            for (int i = 0; i < dMatrix.getNumRows(); i++) {
                for (int i2 = i; i2 < dMatrix.getNumCols(); i2++) {
                    if (Math.abs(dMatrix.get(i, i2) - dMatrix2.get(i, i2)) > d) {
                        return false;
                    }
                }
            }
            return true;
        }
        for (int i3 = 0; i3 < dMatrix.getNumCols(); i3++) {
            for (int i4 = i3; i4 < dMatrix.getNumRows(); i4++) {
                if (Math.abs(dMatrix.get(i4, i3) - dMatrix2.get(i4, i3)) > d) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void copy(DMatrix dMatrix, DMatrix dMatrix2) {
        int numCols = dMatrix.getNumCols();
        int numRows = dMatrix.getNumRows();
        for (int i = 0; i < numRows; i++) {
            for (int i2 = 0; i2 < numCols; i2++) {
                dMatrix2.set(i, i2, dMatrix.get(i, i2));
            }
        }
    }

    public static void setRandom(DMatrix dMatrix, double d, double d2, Random random) {
        for (int i = 0; i < dMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < dMatrix.getNumCols(); i2++) {
                dMatrix.set(i, i2, (random.nextDouble() * (d2 - d)) + d);
            }
        }
    }
}
