package org.ejml.dense.row;

import java.util.Arrays;
import org.ejml.EjmlParameters;
import org.ejml.LinearSolverSafe;
import org.ejml.data.CMatrixD1;
import org.ejml.data.CMatrixRMaj;
import org.ejml.data.Complex_F32;
import org.ejml.data.FMatrixD1;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.decompose.p047lu.LUDecompositionAlt_CDRM;
import org.ejml.dense.row.factory.LinearSolverFactory_CDRM;
import org.ejml.dense.row.misc.TransposeAlgs_CDRM;
import org.ejml.dense.row.mult.MatrixMatrixMult_CDRM;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class CommonOps_CDRM {
    public static CMatrixRMaj identity(int i) {
        CMatrixRMaj cMatrixRMaj = new CMatrixRMaj(i, i);
        for (int i2 = 0; i2 < i; i2++) {
            cMatrixRMaj.set(i2, i2, 1.0f, 0.0f);
        }
        return cMatrixRMaj;
    }

    public static CMatrixRMaj identity(int i, int i2) {
        CMatrixRMaj cMatrixRMaj = new CMatrixRMaj(i, i2);
        int iMin = Math.min(i, i2);
        for (int i3 = 0; i3 < iMin; i3++) {
            cMatrixRMaj.set(i3, i3, 1.0f, 0.0f);
        }
        return cMatrixRMaj;
    }

    public static CMatrixRMaj diag(float... fArr) {
        if (fArr.length % 2 == 1) {
            throw new IllegalArgumentException("must be an even number of arguments");
        }
        int length = fArr.length / 2;
        CMatrixRMaj cMatrixRMaj = new CMatrixRMaj(length, length);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            float f = fArr[i];
            i += 2;
            cMatrixRMaj.set(i2, i2, f, fArr[i3]);
        }
        return cMatrixRMaj;
    }

    public static void convert(FMatrixD1 fMatrixD1, CMatrixD1 cMatrixD1) {
        if (fMatrixD1.numCols != cMatrixD1.numCols || fMatrixD1.numRows != cMatrixD1.numRows) {
            throw new IllegalArgumentException("The matrices are not all the same dimension.");
        }
        Arrays.fill(cMatrixD1.data, 0, cMatrixD1.getDataLength(), 0.0f);
        int dataLength = cMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i += 2) {
            cMatrixD1.data[i] = fMatrixD1.data[i / 2];
        }
    }

    public static FMatrixRMaj stripReal(CMatrixD1 cMatrixD1, FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(cMatrixD1.numRows, cMatrixD1.numCols);
        } else if (cMatrixD1.numCols != fMatrixRMaj.numCols || cMatrixD1.numRows != fMatrixRMaj.numRows) {
            throw new IllegalArgumentException("The matrices are not all the same dimension.");
        }
        int dataLength = cMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i += 2) {
            fMatrixRMaj.data[i / 2] = cMatrixD1.data[i];
        }
        return fMatrixRMaj;
    }

    public static FMatrixRMaj stripImaginary(CMatrixD1 cMatrixD1, FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(cMatrixD1.numRows, cMatrixD1.numCols);
        } else if (cMatrixD1.numCols != fMatrixRMaj.numCols || cMatrixD1.numRows != fMatrixRMaj.numRows) {
            throw new IllegalArgumentException("The matrices are not all the same dimension.");
        }
        int dataLength = cMatrixD1.getDataLength();
        for (int i = 1; i < dataLength; i += 2) {
            fMatrixRMaj.data[i / 2] = cMatrixD1.data[i];
        }
        return fMatrixRMaj;
    }

    public static void magnitude(CMatrixD1 cMatrixD1, FMatrixD1 fMatrixD1) {
        if (cMatrixD1.numCols != fMatrixD1.numCols || cMatrixD1.numRows != fMatrixD1.numRows) {
            throw new IllegalArgumentException("The matrices are not all the same dimension.");
        }
        int dataLength = cMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i += 2) {
            float f = cMatrixD1.data[i];
            float f2 = cMatrixD1.data[i + 1];
            fMatrixD1.data[i / 2] = (float) Math.sqrt((f * f) + (f2 * f2));
        }
    }

    public static void conjugate(CMatrixD1 cMatrixD1, CMatrixD1 cMatrixD12) {
        if (cMatrixD1.numCols != cMatrixD12.numCols || cMatrixD1.numRows != cMatrixD12.numRows) {
            throw new IllegalArgumentException("The matrices are not all the same dimension.");
        }
        int dataLength = cMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i += 2) {
            cMatrixD12.data[i] = cMatrixD1.data[i];
            int i2 = i + 1;
            cMatrixD12.data[i2] = -cMatrixD1.data[i2];
        }
    }

    public static void fill(CMatrixD1 cMatrixD1, float f, float f2) {
        int dataLength = cMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i += 2) {
            cMatrixD1.data[i] = f;
            cMatrixD1.data[i + 1] = f2;
        }
    }

    public static void add(CMatrixD1 cMatrixD1, CMatrixD1 cMatrixD12, CMatrixD1 cMatrixD13) {
        if (cMatrixD1.numCols != cMatrixD12.numCols || cMatrixD1.numRows != cMatrixD12.numRows || cMatrixD1.numCols != cMatrixD13.numCols || cMatrixD1.numRows != cMatrixD13.numRows) {
            throw new IllegalArgumentException("The matrices are not all the same dimension.");
        }
        int dataLength = cMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i++) {
            cMatrixD13.data[i] = cMatrixD1.data[i] + cMatrixD12.data[i];
        }
    }

    public static void subtract(CMatrixD1 cMatrixD1, CMatrixD1 cMatrixD12, CMatrixD1 cMatrixD13) {
        if (cMatrixD1.numCols != cMatrixD12.numCols || cMatrixD1.numRows != cMatrixD12.numRows || cMatrixD1.numCols != cMatrixD13.numCols || cMatrixD1.numRows != cMatrixD13.numRows) {
            throw new IllegalArgumentException("The matrices are not all the same dimension.");
        }
        int dataLength = cMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i++) {
            cMatrixD13.data[i] = cMatrixD1.data[i] - cMatrixD12.data[i];
        }
    }

    public static void scale(float f, float f2, CMatrixD1 cMatrixD1) {
        int numElements = cMatrixD1.getNumElements() * 2;
        for (int i = 0; i < numElements; i += 2) {
            float f3 = cMatrixD1.data[i];
            int i2 = i + 1;
            float f4 = cMatrixD1.data[i2];
            cMatrixD1.data[i] = (f3 * f) - (f4 * f2);
            cMatrixD1.data[i2] = (f3 * f2) + (f4 * f);
        }
    }

    public static void mult(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj2.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH) {
            MatrixMatrixMult_CDRM.mult_reorder(cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
        } else {
            MatrixMatrixMult_CDRM.mult_small(cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
        }
    }

    public static void mult(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj2.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH) {
            MatrixMatrixMult_CDRM.mult_reorder(f, f2, cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
        } else {
            MatrixMatrixMult_CDRM.mult_small(f, f2, cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
        }
    }

    public static void multAdd(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj2.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
            MatrixMatrixMult_CDRM.multAdd_reorder(cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
        } else {
            MatrixMatrixMult_CDRM.multAdd_small(cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
        }
    }

    public static void multAdd(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj2.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH) {
            MatrixMatrixMult_CDRM.multAdd_reorder(f, f2, cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
        } else {
            MatrixMatrixMult_CDRM.multAdd_small(f, f2, cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
        }
    }

    public static void multTransA(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH || cMatrixRMaj2.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH) {
            MatrixMatrixMult_CDRM.multTransA_reorder(cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
        } else {
            MatrixMatrixMult_CDRM.multTransA_small(cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
        }
    }

    public static void multTransA(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH || cMatrixRMaj2.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH) {
            MatrixMatrixMult_CDRM.multTransA_reorder(f, f2, cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
        } else {
            MatrixMatrixMult_CDRM.multTransA_small(f, f2, cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
        }
    }

    public static void multTransB(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        MatrixMatrixMult_CDRM.multTransB(cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
    }

    public static void multTransB(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        MatrixMatrixMult_CDRM.multTransB(f, f2, cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
    }

    public static void multTransAB(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj.numCols >= EjmlParameters.CMULT_TRANAB_COLUMN_SWITCH) {
            MatrixMatrixMult_CDRM.multTransAB_aux(cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3, null);
        } else {
            MatrixMatrixMult_CDRM.multTransAB(cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
        }
    }

    public static void multTransAB(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj.numCols >= EjmlParameters.CMULT_TRANAB_COLUMN_SWITCH) {
            MatrixMatrixMult_CDRM.multTransAB_aux(f, f2, cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3, null);
        } else {
            MatrixMatrixMult_CDRM.multTransAB(f, f2, cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
        }
    }

    public static void multAddTransA(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH || cMatrixRMaj2.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH) {
            MatrixMatrixMult_CDRM.multAddTransA_reorder(cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
        } else {
            MatrixMatrixMult_CDRM.multAddTransA_small(cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
        }
    }

    public static void multAddTransA(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH || cMatrixRMaj2.numCols >= EjmlParameters.CMULT_COLUMN_SWITCH) {
            MatrixMatrixMult_CDRM.multAddTransA_reorder(f, f2, cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
        } else {
            MatrixMatrixMult_CDRM.multAddTransA_small(f, f2, cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
        }
    }

    public static void multAddTransB(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        MatrixMatrixMult_CDRM.multAddTransB(cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
    }

    public static void multAddTransB(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        MatrixMatrixMult_CDRM.multAddTransB(f, f2, cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
    }

    public static void multAddTransAB(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj.numCols >= EjmlParameters.CMULT_TRANAB_COLUMN_SWITCH) {
            MatrixMatrixMult_CDRM.multAddTransAB_aux(cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3, null);
        } else {
            MatrixMatrixMult_CDRM.multAddTransAB(cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
        }
    }

    public static void multAddTransAB(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj.numCols >= EjmlParameters.CMULT_TRANAB_COLUMN_SWITCH) {
            MatrixMatrixMult_CDRM.multAddTransAB_aux(f, f2, cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3, null);
        } else {
            MatrixMatrixMult_CDRM.multAddTransAB(f, f2, cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
        }
    }

    public static void transpose(CMatrixRMaj cMatrixRMaj) {
        if (cMatrixRMaj.numCols == cMatrixRMaj.numRows) {
            TransposeAlgs_CDRM.square(cMatrixRMaj);
            return;
        }
        CMatrixRMaj cMatrixRMaj2 = new CMatrixRMaj(cMatrixRMaj.numCols, cMatrixRMaj.numRows);
        transpose(cMatrixRMaj, cMatrixRMaj2);
        cMatrixRMaj.reshape(cMatrixRMaj2.numRows, cMatrixRMaj2.numCols);
        cMatrixRMaj.set(cMatrixRMaj2);
    }

    public static void transposeConjugate(CMatrixRMaj cMatrixRMaj) {
        if (cMatrixRMaj.numCols == cMatrixRMaj.numRows) {
            TransposeAlgs_CDRM.squareConjugate(cMatrixRMaj);
            return;
        }
        CMatrixRMaj cMatrixRMaj2 = new CMatrixRMaj(cMatrixRMaj.numCols, cMatrixRMaj.numRows);
        transposeConjugate(cMatrixRMaj, cMatrixRMaj2);
        cMatrixRMaj.reshape(cMatrixRMaj2.numRows, cMatrixRMaj2.numCols);
        cMatrixRMaj.set(cMatrixRMaj2);
    }

    public static CMatrixRMaj transpose(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2) {
        if (cMatrixRMaj2 == null) {
            cMatrixRMaj2 = new CMatrixRMaj(cMatrixRMaj.numCols, cMatrixRMaj.numRows);
        } else if (cMatrixRMaj.numCols != cMatrixRMaj2.numRows || cMatrixRMaj.numRows != cMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("Input and output shapes are not compatible");
        }
        TransposeAlgs_CDRM.standard(cMatrixRMaj, cMatrixRMaj2);
        return cMatrixRMaj2;
    }

    public static CMatrixRMaj transposeConjugate(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2) {
        if (cMatrixRMaj2 == null) {
            cMatrixRMaj2 = new CMatrixRMaj(cMatrixRMaj.numCols, cMatrixRMaj.numRows);
        } else if (cMatrixRMaj.numCols != cMatrixRMaj2.numRows || cMatrixRMaj.numRows != cMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("Input and output shapes are not compatible");
        }
        TransposeAlgs_CDRM.standardConjugate(cMatrixRMaj, cMatrixRMaj2);
        return cMatrixRMaj2;
    }

    public static boolean invert(CMatrixRMaj cMatrixRMaj) {
        LinearSolverDense<CMatrixRMaj> linearSolverDenseM1673lu = LinearSolverFactory_CDRM.m1673lu(cMatrixRMaj.numRows);
        if (!linearSolverDenseM1673lu.setA(cMatrixRMaj)) {
            return false;
        }
        linearSolverDenseM1673lu.invert(cMatrixRMaj);
        return true;
    }

    public static boolean invert(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2) {
        LinearSolverDense<CMatrixRMaj> linearSolverDenseM1673lu = LinearSolverFactory_CDRM.m1673lu(cMatrixRMaj.numRows);
        if (linearSolverDenseM1673lu.modifiesA()) {
            cMatrixRMaj = cMatrixRMaj.copy();
        }
        if (!linearSolverDenseM1673lu.setA(cMatrixRMaj)) {
            return false;
        }
        linearSolverDenseM1673lu.invert(cMatrixRMaj2);
        return true;
    }

    public static boolean solve(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        LinearSolverDense<CMatrixRMaj> linearSolverDenseM1674qr;
        if (cMatrixRMaj.numCols == cMatrixRMaj.numRows) {
            linearSolverDenseM1674qr = LinearSolverFactory_CDRM.m1673lu(cMatrixRMaj.numRows);
        } else {
            linearSolverDenseM1674qr = LinearSolverFactory_CDRM.m1674qr(cMatrixRMaj.numRows, cMatrixRMaj.numCols);
        }
        LinearSolverSafe linearSolverSafe = new LinearSolverSafe(linearSolverDenseM1674qr);
        if (!linearSolverSafe.setA(cMatrixRMaj)) {
            return false;
        }
        linearSolverSafe.solve(cMatrixRMaj2, cMatrixRMaj3);
        return true;
    }

    public static Complex_F32 det(CMatrixRMaj cMatrixRMaj) {
        LUDecompositionAlt_CDRM lUDecompositionAlt_CDRM = new LUDecompositionAlt_CDRM();
        if (lUDecompositionAlt_CDRM.inputModified()) {
            cMatrixRMaj = cMatrixRMaj.copy();
        }
        if (!lUDecompositionAlt_CDRM.decompose(cMatrixRMaj)) {
            return new Complex_F32();
        }
        return lUDecompositionAlt_CDRM.computeDeterminant();
    }

    public static void elementMultiply(CMatrixD1 cMatrixD1, float f, float f2, CMatrixD1 cMatrixD12) {
        if (cMatrixD1.numCols != cMatrixD12.numCols || cMatrixD1.numRows != cMatrixD12.numRows) {
            throw new IllegalArgumentException("The 'input' and 'output' matrices do not have compatible dimensions");
        }
        int dataLength = cMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i += 2) {
            float f3 = cMatrixD1.data[i];
            int i2 = i + 1;
            float f4 = cMatrixD1.data[i2];
            cMatrixD12.data[i] = (f3 * f) - (f4 * f2);
            cMatrixD12.data[i2] = (f3 * f2) + (f4 * f);
        }
    }

    public static void elementDivide(CMatrixD1 cMatrixD1, float f, float f2, CMatrixD1 cMatrixD12) {
        if (cMatrixD1.numCols != cMatrixD12.numCols || cMatrixD1.numRows != cMatrixD12.numRows) {
            throw new IllegalArgumentException("The 'input' and 'output' matrices do not have compatible dimensions");
        }
        float f3 = (f * f) + (f2 * f2);
        int dataLength = cMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i += 2) {
            float f4 = cMatrixD1.data[i];
            int i2 = i + 1;
            float f5 = cMatrixD1.data[i2];
            cMatrixD12.data[i] = ((f4 * f) + (f5 * f2)) / f3;
            cMatrixD12.data[i2] = ((f5 * f) - (f4 * f2)) / f3;
        }
    }

    public static void elementDivide(float f, float f2, CMatrixD1 cMatrixD1, CMatrixD1 cMatrixD12) {
        if (cMatrixD1.numCols != cMatrixD12.numCols || cMatrixD1.numRows != cMatrixD12.numRows) {
            throw new IllegalArgumentException("The 'input' and 'output' matrices do not have compatible dimensions");
        }
        int dataLength = cMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i += 2) {
            float f3 = cMatrixD1.data[i];
            int i2 = i + 1;
            float f4 = cMatrixD1.data[i2];
            float f5 = (f3 * f3) + (f4 * f4);
            cMatrixD12.data[i] = ((f * f3) + (f2 * f4)) / f5;
            cMatrixD12.data[i2] = ((f3 * f2) - (f4 * f)) / f5;
        }
    }

    public static float elementMinReal(CMatrixD1 cMatrixD1) {
        int dataLength = cMatrixD1.getDataLength();
        float f = cMatrixD1.data[0];
        for (int i = 2; i < dataLength; i += 2) {
            float f2 = cMatrixD1.data[i];
            if (f2 < f) {
                f = f2;
            }
        }
        return f;
    }

    public static float elementMinImaginary(CMatrixD1 cMatrixD1) {
        int dataLength = cMatrixD1.getDataLength();
        float f = cMatrixD1.data[1];
        for (int i = 3; i < dataLength; i += 2) {
            float f2 = cMatrixD1.data[i];
            if (f2 < f) {
                f = f2;
            }
        }
        return f;
    }

    public static float elementMaxReal(CMatrixD1 cMatrixD1) {
        int dataLength = cMatrixD1.getDataLength();
        float f = cMatrixD1.data[0];
        for (int i = 2; i < dataLength; i += 2) {
            float f2 = cMatrixD1.data[i];
            if (f2 > f) {
                f = f2;
            }
        }
        return f;
    }

    public static float elementMaxImaginary(CMatrixD1 cMatrixD1) {
        int dataLength = cMatrixD1.getDataLength();
        float f = cMatrixD1.data[1];
        for (int i = 3; i < dataLength; i += 2) {
            float f2 = cMatrixD1.data[i];
            if (f2 > f) {
                f = f2;
            }
        }
        return f;
    }

    public static float elementMaxMagnitude2(CMatrixD1 cMatrixD1) {
        int dataLength = cMatrixD1.getDataLength();
        float f = 0.0f;
        int i = 0;
        while (i < dataLength) {
            int i2 = i + 1;
            float f2 = cMatrixD1.data[i];
            i += 2;
            float f3 = cMatrixD1.data[i2];
            float f4 = (f2 * f2) + (f3 * f3);
            if (f4 > f) {
                f = f4;
            }
        }
        return f;
    }

    public static void setIdentity(CMatrixRMaj cMatrixRMaj) {
        int i = cMatrixRMaj.numRows < cMatrixRMaj.numCols ? cMatrixRMaj.numRows : cMatrixRMaj.numCols;
        int i2 = 0;
        Arrays.fill(cMatrixRMaj.data, 0, cMatrixRMaj.getDataLength(), 0.0f);
        int rowStride = cMatrixRMaj.getRowStride();
        int i3 = 0;
        while (i2 < i) {
            cMatrixRMaj.data[i3] = 1.0f;
            i2++;
            i3 += rowStride + 2;
        }
    }

    public static CMatrixRMaj extract(CMatrixRMaj cMatrixRMaj, int i, int i2, int i3, int i4) {
        if (i2 <= i || i < 0 || i2 > cMatrixRMaj.numRows) {
            throw new IllegalArgumentException("srcY1 <= srcY0 || srcY0 < 0 || srcY1 > src.numRows");
        }
        if (i4 <= i3 || i3 < 0 || i4 > cMatrixRMaj.numCols) {
            throw new IllegalArgumentException("srcX1 <= srcX0 || srcX0 < 0 || srcX1 > src.numCols");
        }
        CMatrixRMaj cMatrixRMaj2 = new CMatrixRMaj(i2 - i, i4 - i3);
        extract(cMatrixRMaj, i, i2, i3, i4, cMatrixRMaj2, 0, 0);
        return cMatrixRMaj2;
    }

    public static void extract(CMatrixRMaj cMatrixRMaj, int i, int i2, int i3, int i4, CMatrixRMaj cMatrixRMaj2, int i5, int i6) {
        int i7 = i2 - i;
        int i8 = (i4 - i3) * 2;
        for (int i9 = 0; i9 < i7; i9++) {
            System.arraycopy(cMatrixRMaj.data, cMatrixRMaj.getIndex(i9 + i, i3), cMatrixRMaj2.data, cMatrixRMaj2.getIndex(i9 + i5, i6), i8);
        }
    }

    public static CMatrixRMaj[] columnsToVector(CMatrixRMaj cMatrixRMaj, CMatrixRMaj[] cMatrixRMajArr) {
        if (cMatrixRMajArr == null || cMatrixRMajArr.length < cMatrixRMaj.numCols) {
            cMatrixRMajArr = new CMatrixRMaj[cMatrixRMaj.numCols];
        }
        for (int i = 0; i < cMatrixRMajArr.length; i++) {
            CMatrixRMaj cMatrixRMaj2 = cMatrixRMajArr[i];
            if (cMatrixRMaj2 == null) {
                cMatrixRMajArr[i] = new CMatrixRMaj(cMatrixRMaj.numRows, 1);
            } else {
                cMatrixRMaj2.reshape(cMatrixRMaj.numRows, 1);
            }
            CMatrixRMaj cMatrixRMaj3 = cMatrixRMajArr[i];
            int i2 = 0;
            for (int i3 = 0; i3 < cMatrixRMaj.numRows; i3++) {
                int index = cMatrixRMaj.getIndex(i3, i);
                cMatrixRMaj3.data[i2] = cMatrixRMaj.data[index];
                i2 += 2;
                cMatrixRMaj3.data[i2 + 1] = cMatrixRMaj.data[index + 1];
            }
        }
        return cMatrixRMajArr;
    }

    public static float elementMaxAbs(CMatrixRMaj cMatrixRMaj) {
        int dataLength = cMatrixRMaj.getDataLength();
        float f = 0.0f;
        for (int i = 0; i < dataLength; i += 2) {
            float f2 = cMatrixRMaj.data[i];
            float f3 = cMatrixRMaj.data[i + 1];
            float f4 = (f2 * f2) + (f3 * f3);
            if (f4 > f) {
                f = f4;
            }
        }
        return (float) Math.sqrt(f);
    }
}
