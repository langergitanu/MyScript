package org.ejml.sparse.triplet;

import org.ejml.data.DMatrixSparseTriplet;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixFeatures_DSTL {
    public static boolean isEquals(DMatrixSparseTriplet dMatrixSparseTriplet, DMatrixSparseTriplet dMatrixSparseTriplet2) {
        if (!isSameShape(dMatrixSparseTriplet, dMatrixSparseTriplet2)) {
            return false;
        }
        for (int i = 0; i < dMatrixSparseTriplet.nz_length; i++) {
            DMatrixSparseTriplet.Element element = dMatrixSparseTriplet.nz_data[i];
            DMatrixSparseTriplet.Element element2 = dMatrixSparseTriplet2.nz_data[dMatrixSparseTriplet2.nz_index(element.row, element.col)];
            if (element2 == null || element.value != element2.value) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEquals(DMatrixSparseTriplet dMatrixSparseTriplet, DMatrixSparseTriplet dMatrixSparseTriplet2, double d) {
        if (!isSameShape(dMatrixSparseTriplet, dMatrixSparseTriplet2)) {
            return false;
        }
        for (int i = 0; i < dMatrixSparseTriplet.nz_length; i++) {
            DMatrixSparseTriplet.Element element = dMatrixSparseTriplet.nz_data[i];
            DMatrixSparseTriplet.Element element2 = dMatrixSparseTriplet2.nz_data[dMatrixSparseTriplet2.nz_index(element.row, element.col)];
            if (element2 == null || Math.abs(element.value - element2.value) > d) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSameShape(DMatrixSparseTriplet dMatrixSparseTriplet, DMatrixSparseTriplet dMatrixSparseTriplet2) {
        return dMatrixSparseTriplet.numRows == dMatrixSparseTriplet2.numRows && dMatrixSparseTriplet.numCols == dMatrixSparseTriplet2.numCols && dMatrixSparseTriplet.nz_length == dMatrixSparseTriplet2.nz_length;
    }
}
