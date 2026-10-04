package org.ejml.dense.row;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import org.ejml.EjmlParameters;
import org.ejml.LinearSolverSafe;
import org.ejml.data.Complex_F64;
import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.ZMatrixD1;
import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.decompose.p047lu.LUDecompositionAlt_ZDRM;
import org.ejml.dense.row.factory.LinearSolverFactory_ZDRM;
import org.ejml.dense.row.misc.TransposeAlgs_ZDRM;
import org.ejml.dense.row.mult.MatrixMatrixMult_ZDRM;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class CommonOps_ZDRM {
    public static ZMatrixRMaj identity(int i) {
        ZMatrixRMaj zMatrixRMaj = new ZMatrixRMaj(i, i);
        for (int i2 = 0; i2 < i; i2++) {
            zMatrixRMaj.set(i2, i2, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
        return zMatrixRMaj;
    }

    public static ZMatrixRMaj identity(int i, int i2) {
        ZMatrixRMaj zMatrixRMaj = new ZMatrixRMaj(i, i2);
        int iMin = Math.min(i, i2);
        for (int i3 = 0; i3 < iMin; i3++) {
            zMatrixRMaj.set(i3, i3, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
        return zMatrixRMaj;
    }

    public static ZMatrixRMaj diag(double... dArr) {
        if (dArr.length % 2 == 1) {
            throw new IllegalArgumentException("must be an even number of arguments");
        }
        int length = dArr.length / 2;
        ZMatrixRMaj zMatrixRMaj = new ZMatrixRMaj(length, length);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            zMatrixRMaj.set(i, i, dArr[i2], dArr[i2 + 1]);
            i++;
            i2 += 2;
        }
        return zMatrixRMaj;
    }

    public static void convert(DMatrixD1 dMatrixD1, ZMatrixD1 zMatrixD1) {
        if (dMatrixD1.numCols != zMatrixD1.numCols || dMatrixD1.numRows != zMatrixD1.numRows) {
            throw new IllegalArgumentException("The matrices are not all the same dimension.");
        }
        Arrays.fill(zMatrixD1.data, 0, zMatrixD1.getDataLength(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        int dataLength = zMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i += 2) {
            zMatrixD1.data[i] = dMatrixD1.data[i / 2];
        }
    }

    public static DMatrixRMaj stripReal(ZMatrixD1 zMatrixD1, DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(zMatrixD1.numRows, zMatrixD1.numCols);
        } else if (zMatrixD1.numCols != dMatrixRMaj.numCols || zMatrixD1.numRows != dMatrixRMaj.numRows) {
            throw new IllegalArgumentException("The matrices are not all the same dimension.");
        }
        int dataLength = zMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i += 2) {
            dMatrixRMaj.data[i / 2] = zMatrixD1.data[i];
        }
        return dMatrixRMaj;
    }

    public static DMatrixRMaj stripImaginary(ZMatrixD1 zMatrixD1, DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(zMatrixD1.numRows, zMatrixD1.numCols);
        } else if (zMatrixD1.numCols != dMatrixRMaj.numCols || zMatrixD1.numRows != dMatrixRMaj.numRows) {
            throw new IllegalArgumentException("The matrices are not all the same dimension.");
        }
        int dataLength = zMatrixD1.getDataLength();
        for (int i = 1; i < dataLength; i += 2) {
            dMatrixRMaj.data[i / 2] = zMatrixD1.data[i];
        }
        return dMatrixRMaj;
    }

    public static void magnitude(ZMatrixD1 zMatrixD1, DMatrixD1 dMatrixD1) {
        if (zMatrixD1.numCols != dMatrixD1.numCols || zMatrixD1.numRows != dMatrixD1.numRows) {
            throw new IllegalArgumentException("The matrices are not all the same dimension.");
        }
        int dataLength = zMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i += 2) {
            double d = zMatrixD1.data[i];
            double d2 = zMatrixD1.data[i + 1];
            dMatrixD1.data[i / 2] = Math.sqrt((d * d) + (d2 * d2));
        }
    }

    public static void conjugate(ZMatrixD1 zMatrixD1, ZMatrixD1 zMatrixD12) {
        if (zMatrixD1.numCols != zMatrixD12.numCols || zMatrixD1.numRows != zMatrixD12.numRows) {
            throw new IllegalArgumentException("The matrices are not all the same dimension.");
        }
        int dataLength = zMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i += 2) {
            zMatrixD12.data[i] = zMatrixD1.data[i];
            int i2 = i + 1;
            zMatrixD12.data[i2] = -zMatrixD1.data[i2];
        }
    }

    public static void fill(ZMatrixD1 zMatrixD1, double d, double d2) {
        int dataLength = zMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i += 2) {
            zMatrixD1.data[i] = d;
            zMatrixD1.data[i + 1] = d2;
        }
    }

    public static void add(ZMatrixD1 zMatrixD1, ZMatrixD1 zMatrixD12, ZMatrixD1 zMatrixD13) {
        if (zMatrixD1.numCols != zMatrixD12.numCols || zMatrixD1.numRows != zMatrixD12.numRows || zMatrixD1.numCols != zMatrixD13.numCols || zMatrixD1.numRows != zMatrixD13.numRows) {
            throw new IllegalArgumentException("The matrices are not all the same dimension.");
        }
        int dataLength = zMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i++) {
            zMatrixD13.data[i] = zMatrixD1.data[i] + zMatrixD12.data[i];
        }
    }

    public static void subtract(ZMatrixD1 zMatrixD1, ZMatrixD1 zMatrixD12, ZMatrixD1 zMatrixD13) {
        if (zMatrixD1.numCols != zMatrixD12.numCols || zMatrixD1.numRows != zMatrixD12.numRows || zMatrixD1.numCols != zMatrixD13.numCols || zMatrixD1.numRows != zMatrixD13.numRows) {
            throw new IllegalArgumentException("The matrices are not all the same dimension.");
        }
        int dataLength = zMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i++) {
            zMatrixD13.data[i] = zMatrixD1.data[i] - zMatrixD12.data[i];
        }
    }

    public static void scale(double d, double d2, ZMatrixD1 zMatrixD1) {
        int numElements = zMatrixD1.getNumElements() * 2;
        for (int i = 0; i < numElements; i += 2) {
            double d3 = zMatrixD1.data[i];
            int i2 = i + 1;
            double d4 = zMatrixD1.data[i2];
            zMatrixD1.data[i] = (d3 * d) - (d4 * d2);
            zMatrixD1.data[i2] = (d3 * d2) + (d4 * d);
        }
    }

    public static void mult(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj2.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH) {
            MatrixMatrixMult_ZDRM.mult_reorder(zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
        } else {
            MatrixMatrixMult_ZDRM.mult_small(zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
        }
    }

    public static void mult(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj2.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH) {
            MatrixMatrixMult_ZDRM.mult_reorder(d, d2, zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
        } else {
            MatrixMatrixMult_ZDRM.mult_small(d, d2, zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
        }
    }

    public static void multAdd(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj2.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
            MatrixMatrixMult_ZDRM.multAdd_reorder(zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
        } else {
            MatrixMatrixMult_ZDRM.multAdd_small(zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
        }
    }

    public static void multAdd(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj2.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH) {
            MatrixMatrixMult_ZDRM.multAdd_reorder(d, d2, zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
        } else {
            MatrixMatrixMult_ZDRM.multAdd_small(d, d2, zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
        }
    }

    public static void multTransA(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH || zMatrixRMaj2.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH) {
            MatrixMatrixMult_ZDRM.multTransA_reorder(zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
        } else {
            MatrixMatrixMult_ZDRM.multTransA_small(zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
        }
    }

    public static void multTransA(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH || zMatrixRMaj2.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH) {
            MatrixMatrixMult_ZDRM.multTransA_reorder(d, d2, zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
        } else {
            MatrixMatrixMult_ZDRM.multTransA_small(d, d2, zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
        }
    }

    public static void multTransB(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        MatrixMatrixMult_ZDRM.multTransB(zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
    }

    public static void multTransB(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        MatrixMatrixMult_ZDRM.multTransB(d, d2, zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
    }

    public static void multTransAB(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj.numCols >= EjmlParameters.CMULT_TRANAB_COLUMN_SWITCH) {
            MatrixMatrixMult_ZDRM.multTransAB_aux(zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3, null);
        } else {
            MatrixMatrixMult_ZDRM.multTransAB(zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
        }
    }

    public static void multTransAB(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj.numCols >= EjmlParameters.CMULT_TRANAB_COLUMN_SWITCH) {
            MatrixMatrixMult_ZDRM.multTransAB_aux(d, d2, zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3, null);
        } else {
            MatrixMatrixMult_ZDRM.multTransAB(d, d2, zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
        }
    }

    public static void multAddTransA(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH || zMatrixRMaj2.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH) {
            MatrixMatrixMult_ZDRM.multAddTransA_reorder(zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
        } else {
            MatrixMatrixMult_ZDRM.multAddTransA_small(zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
        }
    }

    public static void multAddTransA(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH || zMatrixRMaj2.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH) {
            MatrixMatrixMult_ZDRM.multAddTransA_reorder(d, d2, zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
        } else {
            MatrixMatrixMult_ZDRM.multAddTransA_small(d, d2, zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
        }
    }

    public static void multAddTransB(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        MatrixMatrixMult_ZDRM.multAddTransB(zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
    }

    public static void multAddTransB(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        MatrixMatrixMult_ZDRM.multAddTransB(d, d2, zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
    }

    public static void multAddTransAB(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj.numCols >= EjmlParameters.CMULT_TRANAB_COLUMN_SWITCH) {
            MatrixMatrixMult_ZDRM.multAddTransAB_aux(zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3, null);
        } else {
            MatrixMatrixMult_ZDRM.multAddTransAB(zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
        }
    }

    public static void multAddTransAB(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj.numCols >= EjmlParameters.CMULT_TRANAB_COLUMN_SWITCH) {
            MatrixMatrixMult_ZDRM.multAddTransAB_aux(d, d2, zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3, null);
        } else {
            MatrixMatrixMult_ZDRM.multAddTransAB(d, d2, zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
        }
    }

    public static void transpose(ZMatrixRMaj zMatrixRMaj) {
        if (zMatrixRMaj.numCols == zMatrixRMaj.numRows) {
            TransposeAlgs_ZDRM.square(zMatrixRMaj);
            return;
        }
        ZMatrixRMaj zMatrixRMaj2 = new ZMatrixRMaj(zMatrixRMaj.numCols, zMatrixRMaj.numRows);
        transpose(zMatrixRMaj, zMatrixRMaj2);
        zMatrixRMaj.reshape(zMatrixRMaj2.numRows, zMatrixRMaj2.numCols);
        zMatrixRMaj.set(zMatrixRMaj2);
    }

    public static void transposeConjugate(ZMatrixRMaj zMatrixRMaj) {
        if (zMatrixRMaj.numCols == zMatrixRMaj.numRows) {
            TransposeAlgs_ZDRM.squareConjugate(zMatrixRMaj);
            return;
        }
        ZMatrixRMaj zMatrixRMaj2 = new ZMatrixRMaj(zMatrixRMaj.numCols, zMatrixRMaj.numRows);
        transposeConjugate(zMatrixRMaj, zMatrixRMaj2);
        zMatrixRMaj.reshape(zMatrixRMaj2.numRows, zMatrixRMaj2.numCols);
        zMatrixRMaj.set(zMatrixRMaj2);
    }

    public static ZMatrixRMaj transpose(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2) {
        if (zMatrixRMaj2 == null) {
            zMatrixRMaj2 = new ZMatrixRMaj(zMatrixRMaj.numCols, zMatrixRMaj.numRows);
        } else if (zMatrixRMaj.numCols != zMatrixRMaj2.numRows || zMatrixRMaj.numRows != zMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("Input and output shapes are not compatible");
        }
        TransposeAlgs_ZDRM.standard(zMatrixRMaj, zMatrixRMaj2);
        return zMatrixRMaj2;
    }

    public static ZMatrixRMaj transposeConjugate(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2) {
        if (zMatrixRMaj2 == null) {
            zMatrixRMaj2 = new ZMatrixRMaj(zMatrixRMaj.numCols, zMatrixRMaj.numRows);
        } else if (zMatrixRMaj.numCols != zMatrixRMaj2.numRows || zMatrixRMaj.numRows != zMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("Input and output shapes are not compatible");
        }
        TransposeAlgs_ZDRM.standardConjugate(zMatrixRMaj, zMatrixRMaj2);
        return zMatrixRMaj2;
    }

    public static boolean invert(ZMatrixRMaj zMatrixRMaj) {
        LinearSolverDense<ZMatrixRMaj> linearSolverDenseM1679lu = LinearSolverFactory_ZDRM.m1679lu(zMatrixRMaj.numRows);
        if (!linearSolverDenseM1679lu.setA(zMatrixRMaj)) {
            return false;
        }
        linearSolverDenseM1679lu.invert(zMatrixRMaj);
        return true;
    }

    public static boolean invert(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2) {
        LinearSolverDense<ZMatrixRMaj> linearSolverDenseM1679lu = LinearSolverFactory_ZDRM.m1679lu(zMatrixRMaj.numRows);
        if (linearSolverDenseM1679lu.modifiesA()) {
            zMatrixRMaj = zMatrixRMaj.copy();
        }
        if (!linearSolverDenseM1679lu.setA(zMatrixRMaj)) {
            return false;
        }
        linearSolverDenseM1679lu.invert(zMatrixRMaj2);
        return true;
    }

    public static boolean solve(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        LinearSolverDense<ZMatrixRMaj> linearSolverDenseM1680qr;
        if (zMatrixRMaj.numCols == zMatrixRMaj.numRows) {
            linearSolverDenseM1680qr = LinearSolverFactory_ZDRM.m1679lu(zMatrixRMaj.numRows);
        } else {
            linearSolverDenseM1680qr = LinearSolverFactory_ZDRM.m1680qr(zMatrixRMaj.numRows, zMatrixRMaj.numCols);
        }
        LinearSolverSafe linearSolverSafe = new LinearSolverSafe(linearSolverDenseM1680qr);
        if (!linearSolverSafe.setA(zMatrixRMaj)) {
            return false;
        }
        linearSolverSafe.solve(zMatrixRMaj2, zMatrixRMaj3);
        return true;
    }

    public static Complex_F64 det(ZMatrixRMaj zMatrixRMaj) {
        LUDecompositionAlt_ZDRM lUDecompositionAlt_ZDRM = new LUDecompositionAlt_ZDRM();
        if (lUDecompositionAlt_ZDRM.inputModified()) {
            zMatrixRMaj = zMatrixRMaj.copy();
        }
        if (!lUDecompositionAlt_ZDRM.decompose(zMatrixRMaj)) {
            return new Complex_F64();
        }
        return lUDecompositionAlt_ZDRM.computeDeterminant();
    }

    public static void elementMultiply(ZMatrixD1 zMatrixD1, double d, double d2, ZMatrixD1 zMatrixD12) {
        if (zMatrixD1.numCols != zMatrixD12.numCols || zMatrixD1.numRows != zMatrixD12.numRows) {
            throw new IllegalArgumentException("The 'input' and 'output' matrices do not have compatible dimensions");
        }
        int dataLength = zMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i += 2) {
            double d3 = zMatrixD1.data[i];
            int i2 = i + 1;
            double d4 = zMatrixD1.data[i2];
            zMatrixD12.data[i] = (d3 * d) - (d4 * d2);
            zMatrixD12.data[i2] = (d3 * d2) + (d4 * d);
        }
    }

    public static void elementDivide(ZMatrixD1 zMatrixD1, double d, double d2, ZMatrixD1 zMatrixD12) {
        if (zMatrixD1.numCols != zMatrixD12.numCols || zMatrixD1.numRows != zMatrixD12.numRows) {
            throw new IllegalArgumentException("The 'input' and 'output' matrices do not have compatible dimensions");
        }
        double d3 = (d * d) + (d2 * d2);
        int dataLength = zMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i += 2) {
            double d4 = zMatrixD1.data[i];
            int i2 = i + 1;
            double d5 = zMatrixD1.data[i2];
            zMatrixD12.data[i] = ((d4 * d) + (d5 * d2)) / d3;
            zMatrixD12.data[i2] = ((d5 * d) - (d4 * d2)) / d3;
        }
    }

    public static void elementDivide(double d, double d2, ZMatrixD1 zMatrixD1, ZMatrixD1 zMatrixD12) {
        if (zMatrixD1.numCols != zMatrixD12.numCols || zMatrixD1.numRows != zMatrixD12.numRows) {
            throw new IllegalArgumentException("The 'input' and 'output' matrices do not have compatible dimensions");
        }
        int dataLength = zMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i += 2) {
            double d3 = zMatrixD1.data[i];
            int i2 = i + 1;
            double d4 = zMatrixD1.data[i2];
            double d5 = (d3 * d3) + (d4 * d4);
            zMatrixD12.data[i] = ((d * d3) + (d2 * d4)) / d5;
            zMatrixD12.data[i2] = ((d3 * d2) - (d4 * d)) / d5;
        }
    }

    public static double elementMinReal(ZMatrixD1 zMatrixD1) {
        int dataLength = zMatrixD1.getDataLength();
        double d = zMatrixD1.data[0];
        for (int i = 2; i < dataLength; i += 2) {
            double d2 = zMatrixD1.data[i];
            if (d2 < d) {
                d = d2;
            }
        }
        return d;
    }

    public static double elementMinImaginary(ZMatrixD1 zMatrixD1) {
        int dataLength = zMatrixD1.getDataLength();
        double d = zMatrixD1.data[1];
        for (int i = 3; i < dataLength; i += 2) {
            double d2 = zMatrixD1.data[i];
            if (d2 < d) {
                d = d2;
            }
        }
        return d;
    }

    public static double elementMaxReal(ZMatrixD1 zMatrixD1) {
        int dataLength = zMatrixD1.getDataLength();
        double d = zMatrixD1.data[0];
        for (int i = 2; i < dataLength; i += 2) {
            double d2 = zMatrixD1.data[i];
            if (d2 > d) {
                d = d2;
            }
        }
        return d;
    }

    public static double elementMaxImaginary(ZMatrixD1 zMatrixD1) {
        int dataLength = zMatrixD1.getDataLength();
        double d = zMatrixD1.data[1];
        for (int i = 3; i < dataLength; i += 2) {
            double d2 = zMatrixD1.data[i];
            if (d2 > d) {
                d = d2;
            }
        }
        return d;
    }

    public static double elementMaxMagnitude2(ZMatrixD1 zMatrixD1) {
        int dataLength = zMatrixD1.getDataLength();
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i = 0;
        while (i < dataLength) {
            int i2 = i + 1;
            double d2 = zMatrixD1.data[i];
            i += 2;
            double d3 = zMatrixD1.data[i2];
            double d4 = (d2 * d2) + (d3 * d3);
            if (d4 > d) {
                d = d4;
            }
        }
        return d;
    }

    public static void setIdentity(ZMatrixRMaj zMatrixRMaj) {
        int i = zMatrixRMaj.numRows < zMatrixRMaj.numCols ? zMatrixRMaj.numRows : zMatrixRMaj.numCols;
        int i2 = 0;
        Arrays.fill(zMatrixRMaj.data, 0, zMatrixRMaj.getDataLength(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        int rowStride = zMatrixRMaj.getRowStride();
        int i3 = 0;
        while (i2 < i) {
            zMatrixRMaj.data[i3] = 1.0d;
            i2++;
            i3 += rowStride + 2;
        }
    }

    public static ZMatrixRMaj extract(ZMatrixRMaj zMatrixRMaj, int i, int i2, int i3, int i4) {
        if (i2 <= i || i < 0 || i2 > zMatrixRMaj.numRows) {
            throw new IllegalArgumentException("srcY1 <= srcY0 || srcY0 < 0 || srcY1 > src.numRows");
        }
        if (i4 <= i3 || i3 < 0 || i4 > zMatrixRMaj.numCols) {
            throw new IllegalArgumentException("srcX1 <= srcX0 || srcX0 < 0 || srcX1 > src.numCols");
        }
        ZMatrixRMaj zMatrixRMaj2 = new ZMatrixRMaj(i2 - i, i4 - i3);
        extract(zMatrixRMaj, i, i2, i3, i4, zMatrixRMaj2, 0, 0);
        return zMatrixRMaj2;
    }

    public static void extract(ZMatrixRMaj zMatrixRMaj, int i, int i2, int i3, int i4, ZMatrixRMaj zMatrixRMaj2, int i5, int i6) {
        int i7 = i2 - i;
        int i8 = (i4 - i3) * 2;
        for (int i9 = 0; i9 < i7; i9++) {
            System.arraycopy(zMatrixRMaj.data, zMatrixRMaj.getIndex(i9 + i, i3), zMatrixRMaj2.data, zMatrixRMaj2.getIndex(i9 + i5, i6), i8);
        }
    }

    public static ZMatrixRMaj[] columnsToVector(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj[] zMatrixRMajArr) {
        if (zMatrixRMajArr == null || zMatrixRMajArr.length < zMatrixRMaj.numCols) {
            zMatrixRMajArr = new ZMatrixRMaj[zMatrixRMaj.numCols];
        }
        for (int i = 0; i < zMatrixRMajArr.length; i++) {
            ZMatrixRMaj zMatrixRMaj2 = zMatrixRMajArr[i];
            if (zMatrixRMaj2 == null) {
                zMatrixRMajArr[i] = new ZMatrixRMaj(zMatrixRMaj.numRows, 1);
            } else {
                zMatrixRMaj2.reshape(zMatrixRMaj.numRows, 1);
            }
            ZMatrixRMaj zMatrixRMaj3 = zMatrixRMajArr[i];
            int i2 = 0;
            for (int i3 = 0; i3 < zMatrixRMaj.numRows; i3++) {
                int index = zMatrixRMaj.getIndex(i3, i);
                zMatrixRMaj3.data[i2] = zMatrixRMaj.data[index];
                i2 += 2;
                zMatrixRMaj3.data[i2 + 1] = zMatrixRMaj.data[index + 1];
            }
        }
        return zMatrixRMajArr;
    }

    public static double elementMaxAbs(ZMatrixRMaj zMatrixRMaj) {
        int dataLength = zMatrixRMaj.getDataLength();
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dataLength; i += 2) {
            double d2 = zMatrixRMaj.data[i];
            double d3 = zMatrixRMaj.data[i + 1];
            double d4 = (d2 * d2) + (d3 * d3);
            if (d4 > d) {
                d = d4;
            }
        }
        return Math.sqrt(d);
    }
}
