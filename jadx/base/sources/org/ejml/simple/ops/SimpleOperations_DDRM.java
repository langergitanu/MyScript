package org.ejml.simple.ops;

import java.io.PrintStream;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.Matrix;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.dense.row.MatrixFeatures_DDRM;
import org.ejml.dense.row.NormOps_DDRM;
import org.ejml.dense.row.mult.VectorVectorMult_DDRM;
import org.ejml.ops.MatrixIO;
import org.ejml.simple.SimpleOperations;

/* JADX INFO: loaded from: classes9.dex */
public class SimpleOperations_DDRM implements SimpleOperations<DMatrixRMaj> {
    @Override // org.ejml.simple.SimpleOperations
    public void transpose(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        CommonOps_DDRM.transpose(dMatrixRMaj, dMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void mult(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, DMatrixRMaj dMatrixRMaj3) {
        CommonOps_DDRM.mult(dMatrixRMaj, dMatrixRMaj2, dMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void kron(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, DMatrixRMaj dMatrixRMaj3) {
        CommonOps_DDRM.kron(dMatrixRMaj, dMatrixRMaj2, dMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void plus(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, DMatrixRMaj dMatrixRMaj3) {
        CommonOps_DDRM.add(dMatrixRMaj, dMatrixRMaj2, dMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void minus(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, DMatrixRMaj dMatrixRMaj3) {
        CommonOps_DDRM.subtract(dMatrixRMaj, dMatrixRMaj2, dMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void minus(DMatrixRMaj dMatrixRMaj, double d, DMatrixRMaj dMatrixRMaj2) {
        CommonOps_DDRM.subtract(dMatrixRMaj, d, dMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void plus(DMatrixRMaj dMatrixRMaj, double d, DMatrixRMaj dMatrixRMaj2) {
        CommonOps_DDRM.add(dMatrixRMaj, d, dMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void plus(DMatrixRMaj dMatrixRMaj, double d, DMatrixRMaj dMatrixRMaj2, DMatrixRMaj dMatrixRMaj3) {
        CommonOps_DDRM.add(dMatrixRMaj, d, dMatrixRMaj2, dMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double dot(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        return VectorVectorMult_DDRM.innerProd(dMatrixRMaj, dMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void scale(DMatrixRMaj dMatrixRMaj, double d, DMatrixRMaj dMatrixRMaj2) {
        CommonOps_DDRM.scale(d, dMatrixRMaj, dMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void divide(DMatrixRMaj dMatrixRMaj, double d, DMatrixRMaj dMatrixRMaj2) {
        CommonOps_DDRM.divide(dMatrixRMaj, d, dMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public boolean invert(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        return CommonOps_DDRM.invert(dMatrixRMaj, dMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void pseudoInverse(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        CommonOps_DDRM.pinv(dMatrixRMaj, dMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public boolean solve(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, DMatrixRMaj dMatrixRMaj3) {
        return CommonOps_DDRM.solve(dMatrixRMaj, dMatrixRMaj3, dMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void set(DMatrixRMaj dMatrixRMaj, double d) {
        CommonOps_DDRM.fill(dMatrixRMaj, d);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void zero(DMatrixRMaj dMatrixRMaj) {
        dMatrixRMaj.zero();
    }

    @Override // org.ejml.simple.SimpleOperations
    public double normF(DMatrixRMaj dMatrixRMaj) {
        return NormOps_DDRM.normF(dMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double conditionP2(DMatrixRMaj dMatrixRMaj) {
        return NormOps_DDRM.conditionP2(dMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double determinant(DMatrixRMaj dMatrixRMaj) {
        return CommonOps_DDRM.det(dMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double trace(DMatrixRMaj dMatrixRMaj) {
        return CommonOps_DDRM.trace(dMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void setRow(DMatrixRMaj dMatrixRMaj, int i, int i2, double... dArr) {
        for (int i3 = 0; i3 < dArr.length; i3++) {
            dMatrixRMaj.set(i, i2 + i3, dArr[i3]);
        }
    }

    @Override // org.ejml.simple.SimpleOperations
    public void setColumn(DMatrixRMaj dMatrixRMaj, int i, int i2, double... dArr) {
        for (int i3 = 0; i3 < dArr.length; i3++) {
            dMatrixRMaj.set(i2 + i3, i, dArr[i3]);
        }
    }

    @Override // org.ejml.simple.SimpleOperations
    public void extract(DMatrixRMaj dMatrixRMaj, int i, int i2, int i3, int i4, DMatrixRMaj dMatrixRMaj2, int i5, int i6) {
        CommonOps_DDRM.extract(dMatrixRMaj, i, i2, i3, i4, dMatrixRMaj2, i5, i6);
    }

    @Override // org.ejml.simple.SimpleOperations
    public boolean hasUncountable(DMatrixRMaj dMatrixRMaj) {
        return MatrixFeatures_DDRM.hasUncountable(dMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void changeSign(DMatrixRMaj dMatrixRMaj) {
        CommonOps_DDRM.changeSign(dMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double elementMaxAbs(DMatrixRMaj dMatrixRMaj) {
        return CommonOps_DDRM.elementMaxAbs(dMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double elementSum(DMatrixRMaj dMatrixRMaj) {
        return CommonOps_DDRM.elementSum(dMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementMult(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, DMatrixRMaj dMatrixRMaj3) {
        CommonOps_DDRM.elementMult(dMatrixRMaj, dMatrixRMaj2, dMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementDiv(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, DMatrixRMaj dMatrixRMaj3) {
        CommonOps_DDRM.elementDiv(dMatrixRMaj, dMatrixRMaj2, dMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementPower(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, DMatrixRMaj dMatrixRMaj3) {
        CommonOps_DDRM.elementPower(dMatrixRMaj, dMatrixRMaj2, dMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementPower(DMatrixRMaj dMatrixRMaj, double d, DMatrixRMaj dMatrixRMaj2) {
        CommonOps_DDRM.elementPower(dMatrixRMaj, d, dMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementExp(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        CommonOps_DDRM.elementExp(dMatrixRMaj, dMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementLog(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        CommonOps_DDRM.elementLog(dMatrixRMaj, dMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void print(PrintStream printStream, Matrix matrix) {
        MatrixIO.print(printStream, (DMatrixRMaj) matrix);
    }
}
