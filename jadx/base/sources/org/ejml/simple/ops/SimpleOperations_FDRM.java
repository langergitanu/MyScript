package org.ejml.simple.ops;

import java.io.PrintStream;
import org.ejml.data.FMatrixRMaj;
import org.ejml.data.Matrix;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.dense.row.MatrixFeatures_FDRM;
import org.ejml.dense.row.NormOps_FDRM;
import org.ejml.dense.row.mult.VectorVectorMult_FDRM;
import org.ejml.ops.MatrixIO;
import org.ejml.simple.SimpleOperations;

/* JADX INFO: loaded from: classes9.dex */
public class SimpleOperations_FDRM implements SimpleOperations<FMatrixRMaj> {
    @Override // org.ejml.simple.SimpleOperations
    public void transpose(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        CommonOps_FDRM.transpose(fMatrixRMaj, fMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void mult(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, FMatrixRMaj fMatrixRMaj3) {
        CommonOps_FDRM.mult(fMatrixRMaj, fMatrixRMaj2, fMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void kron(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, FMatrixRMaj fMatrixRMaj3) {
        CommonOps_FDRM.kron(fMatrixRMaj, fMatrixRMaj2, fMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void plus(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, FMatrixRMaj fMatrixRMaj3) {
        CommonOps_FDRM.add(fMatrixRMaj, fMatrixRMaj2, fMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void minus(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, FMatrixRMaj fMatrixRMaj3) {
        CommonOps_FDRM.subtract(fMatrixRMaj, fMatrixRMaj2, fMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void minus(FMatrixRMaj fMatrixRMaj, double d, FMatrixRMaj fMatrixRMaj2) {
        CommonOps_FDRM.subtract(fMatrixRMaj, (float) d, fMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void plus(FMatrixRMaj fMatrixRMaj, double d, FMatrixRMaj fMatrixRMaj2) {
        CommonOps_FDRM.add(fMatrixRMaj, (float) d, fMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void plus(FMatrixRMaj fMatrixRMaj, double d, FMatrixRMaj fMatrixRMaj2, FMatrixRMaj fMatrixRMaj3) {
        CommonOps_FDRM.add(fMatrixRMaj, (float) d, fMatrixRMaj2, fMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double dot(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        return VectorVectorMult_FDRM.innerProd(fMatrixRMaj, fMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void scale(FMatrixRMaj fMatrixRMaj, double d, FMatrixRMaj fMatrixRMaj2) {
        CommonOps_FDRM.scale((float) d, fMatrixRMaj, fMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void divide(FMatrixRMaj fMatrixRMaj, double d, FMatrixRMaj fMatrixRMaj2) {
        CommonOps_FDRM.divide(fMatrixRMaj, (float) d, fMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public boolean invert(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        return CommonOps_FDRM.invert(fMatrixRMaj, fMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void pseudoInverse(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        CommonOps_FDRM.pinv(fMatrixRMaj, fMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public boolean solve(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, FMatrixRMaj fMatrixRMaj3) {
        return CommonOps_FDRM.solve(fMatrixRMaj, fMatrixRMaj3, fMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void set(FMatrixRMaj fMatrixRMaj, double d) {
        CommonOps_FDRM.fill(fMatrixRMaj, (float) d);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void zero(FMatrixRMaj fMatrixRMaj) {
        fMatrixRMaj.zero();
    }

    @Override // org.ejml.simple.SimpleOperations
    public double normF(FMatrixRMaj fMatrixRMaj) {
        return NormOps_FDRM.normF(fMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double conditionP2(FMatrixRMaj fMatrixRMaj) {
        return NormOps_FDRM.conditionP2(fMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double determinant(FMatrixRMaj fMatrixRMaj) {
        return CommonOps_FDRM.det(fMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double trace(FMatrixRMaj fMatrixRMaj) {
        return CommonOps_FDRM.trace(fMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void setRow(FMatrixRMaj fMatrixRMaj, int i, int i2, double... dArr) {
        for (int i3 = 0; i3 < dArr.length; i3++) {
            fMatrixRMaj.set(i, i2 + i3, (float) dArr[i3]);
        }
    }

    @Override // org.ejml.simple.SimpleOperations
    public void setColumn(FMatrixRMaj fMatrixRMaj, int i, int i2, double... dArr) {
        for (int i3 = 0; i3 < dArr.length; i3++) {
            fMatrixRMaj.set(i2 + i3, i, (float) dArr[i3]);
        }
    }

    @Override // org.ejml.simple.SimpleOperations
    public void extract(FMatrixRMaj fMatrixRMaj, int i, int i2, int i3, int i4, FMatrixRMaj fMatrixRMaj2, int i5, int i6) {
        CommonOps_FDRM.extract(fMatrixRMaj, i, i2, i3, i4, fMatrixRMaj2, i5, i6);
    }

    @Override // org.ejml.simple.SimpleOperations
    public boolean hasUncountable(FMatrixRMaj fMatrixRMaj) {
        return MatrixFeatures_FDRM.hasUncountable(fMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void changeSign(FMatrixRMaj fMatrixRMaj) {
        CommonOps_FDRM.changeSign(fMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double elementMaxAbs(FMatrixRMaj fMatrixRMaj) {
        return CommonOps_FDRM.elementMaxAbs(fMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double elementSum(FMatrixRMaj fMatrixRMaj) {
        return CommonOps_FDRM.elementSum(fMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementMult(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, FMatrixRMaj fMatrixRMaj3) {
        CommonOps_FDRM.elementMult(fMatrixRMaj, fMatrixRMaj2, fMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementDiv(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, FMatrixRMaj fMatrixRMaj3) {
        CommonOps_FDRM.elementDiv(fMatrixRMaj, fMatrixRMaj2, fMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementPower(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, FMatrixRMaj fMatrixRMaj3) {
        CommonOps_FDRM.elementPower(fMatrixRMaj, fMatrixRMaj2, fMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementPower(FMatrixRMaj fMatrixRMaj, double d, FMatrixRMaj fMatrixRMaj2) {
        CommonOps_FDRM.elementPower(fMatrixRMaj, (float) d, fMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementExp(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        CommonOps_FDRM.elementExp(fMatrixRMaj, fMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementLog(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        CommonOps_FDRM.elementLog(fMatrixRMaj, fMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void print(PrintStream printStream, Matrix matrix) {
        MatrixIO.print(printStream, (FMatrixRMaj) matrix);
    }
}
