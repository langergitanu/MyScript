package org.ejml.simple.ops;

import java.io.PrintStream;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.data.Matrix;
import org.ejml.ops.MatrixIO;
import org.ejml.simple.ConvertToDenseException;
import org.ejml.simple.SimpleOperations;
import org.ejml.sparse.csc.CommonOps_DSCC;
import org.ejml.sparse.csc.MatrixFeatures_DSCC;
import org.ejml.sparse.csc.NormOps_DSCC;

/* JADX INFO: loaded from: classes9.dex */
public class SimpleOperations_SPARSE implements SimpleOperations<DMatrixSparseCSC> {
    @Override // org.ejml.simple.SimpleOperations
    public void transpose(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2) {
        CommonOps_DSCC.transpose(dMatrixSparseCSC, dMatrixSparseCSC2, null);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void mult(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3) {
        CommonOps_DSCC.mult(dMatrixSparseCSC, dMatrixSparseCSC2, dMatrixSparseCSC3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void kron(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void plus(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3) {
        CommonOps_DSCC.add(1.0d, dMatrixSparseCSC, 1.0d, dMatrixSparseCSC2, dMatrixSparseCSC3, null, null);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void minus(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3) {
        CommonOps_DSCC.add(1.0d, dMatrixSparseCSC, -1.0d, dMatrixSparseCSC2, dMatrixSparseCSC3, null, null);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void minus(DMatrixSparseCSC dMatrixSparseCSC, double d, DMatrixSparseCSC dMatrixSparseCSC2) {
        throw new ConvertToDenseException();
    }

    @Override // org.ejml.simple.SimpleOperations
    public void plus(DMatrixSparseCSC dMatrixSparseCSC, double d, DMatrixSparseCSC dMatrixSparseCSC2) {
        throw new ConvertToDenseException();
    }

    @Override // org.ejml.simple.SimpleOperations
    public void plus(DMatrixSparseCSC dMatrixSparseCSC, double d, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3) {
        CommonOps_DSCC.add(1.0d, dMatrixSparseCSC, d, dMatrixSparseCSC2, dMatrixSparseCSC3, null, null);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double dot(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2) {
        return CommonOps_DSCC.dotInnerColumns(dMatrixSparseCSC, 0, dMatrixSparseCSC2, 0, null, null);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void scale(DMatrixSparseCSC dMatrixSparseCSC, double d, DMatrixSparseCSC dMatrixSparseCSC2) {
        CommonOps_DSCC.scale(d, dMatrixSparseCSC, dMatrixSparseCSC2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void divide(DMatrixSparseCSC dMatrixSparseCSC, double d, DMatrixSparseCSC dMatrixSparseCSC2) {
        CommonOps_DSCC.divide(dMatrixSparseCSC, d, dMatrixSparseCSC2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public boolean invert(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void pseudoInverse(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public boolean solve(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void set(DMatrixSparseCSC dMatrixSparseCSC, double d) {
        throw new ConvertToDenseException();
    }

    @Override // org.ejml.simple.SimpleOperations
    public void zero(DMatrixSparseCSC dMatrixSparseCSC) {
        dMatrixSparseCSC.zero();
    }

    @Override // org.ejml.simple.SimpleOperations
    public double normF(DMatrixSparseCSC dMatrixSparseCSC) {
        return NormOps_DSCC.normF(dMatrixSparseCSC);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double conditionP2(DMatrixSparseCSC dMatrixSparseCSC) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public double determinant(DMatrixSparseCSC dMatrixSparseCSC) {
        return CommonOps_DSCC.det(dMatrixSparseCSC);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double trace(DMatrixSparseCSC dMatrixSparseCSC) {
        return CommonOps_DSCC.trace(dMatrixSparseCSC);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void setRow(DMatrixSparseCSC dMatrixSparseCSC, int i, int i2, double... dArr) {
        for (int i3 = 0; i3 < dArr.length; i3++) {
            dMatrixSparseCSC.set(i, i2 + i3, dArr[i3]);
        }
    }

    @Override // org.ejml.simple.SimpleOperations
    public void setColumn(DMatrixSparseCSC dMatrixSparseCSC, int i, int i2, double... dArr) {
        for (int i3 = 0; i3 < dArr.length; i3++) {
            dMatrixSparseCSC.set(i2 + i3, i, dArr[i3]);
        }
    }

    @Override // org.ejml.simple.SimpleOperations
    public void extract(DMatrixSparseCSC dMatrixSparseCSC, int i, int i2, int i3, int i4, DMatrixSparseCSC dMatrixSparseCSC2, int i5, int i6) {
        CommonOps_DSCC.extract(dMatrixSparseCSC, i, i2, i3, i4, dMatrixSparseCSC2, i5, i6);
    }

    @Override // org.ejml.simple.SimpleOperations
    public boolean hasUncountable(DMatrixSparseCSC dMatrixSparseCSC) {
        return MatrixFeatures_DSCC.hasUncountable(dMatrixSparseCSC);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void changeSign(DMatrixSparseCSC dMatrixSparseCSC) {
        CommonOps_DSCC.changeSign(dMatrixSparseCSC, dMatrixSparseCSC);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double elementMaxAbs(DMatrixSparseCSC dMatrixSparseCSC) {
        return CommonOps_DSCC.elementMaxAbs(dMatrixSparseCSC);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double elementSum(DMatrixSparseCSC dMatrixSparseCSC) {
        return CommonOps_DSCC.elementSum(dMatrixSparseCSC);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementMult(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3) {
        CommonOps_DSCC.elementMult(dMatrixSparseCSC, dMatrixSparseCSC2, dMatrixSparseCSC3, null, null);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementDiv(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3) {
        throw new ConvertToDenseException();
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementPower(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3) {
        throw new ConvertToDenseException();
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementPower(DMatrixSparseCSC dMatrixSparseCSC, double d, DMatrixSparseCSC dMatrixSparseCSC2) {
        throw new ConvertToDenseException();
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementExp(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2) {
        throw new ConvertToDenseException();
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementLog(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2) {
        throw new ConvertToDenseException();
    }

    @Override // org.ejml.simple.SimpleOperations
    public void print(PrintStream printStream, Matrix matrix) {
        MatrixIO.print(printStream, (DMatrixSparseCSC) matrix);
    }
}
