package org.ejml.generic;

import java.util.Random;
import org.ejml.data.FMatrix;

/* JADX INFO: loaded from: classes9.dex */
public class GenericMatrixOps_F32 {
    public static boolean isEquivalent(FMatrix fMatrix, FMatrix fMatrix2, float f) {
        if (fMatrix.getNumRows() != fMatrix2.getNumRows() || fMatrix.getNumCols() != fMatrix2.getNumCols()) {
            return false;
        }
        for (int i = 0; i < fMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < fMatrix.getNumCols(); i2++) {
                if (Math.abs(fMatrix.get(i, i2) - fMatrix2.get(i, i2)) > f) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isIdentity(FMatrix fMatrix, float f) {
        for (int i = 0; i < fMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < fMatrix.getNumCols(); i2++) {
                if (i == i2) {
                    if (Math.abs(fMatrix.get(i, i2) - 1.0f) > f) {
                        return false;
                    }
                } else if (Math.abs(fMatrix.get(i, i2)) > f) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEquivalentTriangle(boolean z, FMatrix fMatrix, FMatrix fMatrix2, float f) {
        if (fMatrix.getNumRows() != fMatrix2.getNumRows() || fMatrix.getNumCols() != fMatrix2.getNumCols()) {
            return false;
        }
        if (z) {
            for (int i = 0; i < fMatrix.getNumRows(); i++) {
                for (int i2 = i; i2 < fMatrix.getNumCols(); i2++) {
                    if (Math.abs(fMatrix.get(i, i2) - fMatrix2.get(i, i2)) > f) {
                        return false;
                    }
                }
            }
            return true;
        }
        for (int i3 = 0; i3 < fMatrix.getNumCols(); i3++) {
            for (int i4 = i3; i4 < fMatrix.getNumRows(); i4++) {
                if (Math.abs(fMatrix.get(i4, i3) - fMatrix2.get(i4, i3)) > f) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void copy(FMatrix fMatrix, FMatrix fMatrix2) {
        int numCols = fMatrix.getNumCols();
        int numRows = fMatrix.getNumRows();
        for (int i = 0; i < numRows; i++) {
            for (int i2 = 0; i2 < numCols; i2++) {
                fMatrix2.set(i, i2, fMatrix.get(i, i2));
            }
        }
    }

    public static void setRandom(FMatrix fMatrix, float f, float f2, Random random) {
        for (int i = 0; i < fMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < fMatrix.getNumCols(); i2++) {
                fMatrix.set(i, i2, (random.nextFloat() * (f2 - f)) + f);
            }
        }
    }
}
