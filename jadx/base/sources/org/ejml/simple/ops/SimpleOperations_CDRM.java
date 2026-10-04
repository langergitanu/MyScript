package org.ejml.simple.ops;

import java.io.PrintStream;
import org.ejml.data.CMatrixRMaj;
import org.ejml.data.Matrix;
import org.ejml.dense.row.CommonOps_CDRM;
import org.ejml.dense.row.MatrixFeatures_CDRM;
import org.ejml.dense.row.NormOps_CDRM;
import org.ejml.ops.MatrixIO;
import org.ejml.simple.SimpleOperations;

/* JADX INFO: loaded from: classes9.dex */
public class SimpleOperations_CDRM implements SimpleOperations<CMatrixRMaj> {
    @Override // org.ejml.simple.SimpleOperations
    public void transpose(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2) {
        CommonOps_CDRM.transpose(cMatrixRMaj, cMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void mult(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        CommonOps_CDRM.mult(cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void kron(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void plus(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        CommonOps_CDRM.add(cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void minus(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        CommonOps_CDRM.subtract(cMatrixRMaj, cMatrixRMaj2, cMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void minus(CMatrixRMaj cMatrixRMaj, double d, CMatrixRMaj cMatrixRMaj2) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void plus(CMatrixRMaj cMatrixRMaj, double d, CMatrixRMaj cMatrixRMaj2) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void plus(CMatrixRMaj cMatrixRMaj, double d, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public double dot(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void scale(CMatrixRMaj cMatrixRMaj, double d, CMatrixRMaj cMatrixRMaj2) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void divide(CMatrixRMaj cMatrixRMaj, double d, CMatrixRMaj cMatrixRMaj2) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public boolean invert(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2) {
        return CommonOps_CDRM.invert(cMatrixRMaj, cMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void pseudoInverse(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public boolean solve(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        return CommonOps_CDRM.solve(cMatrixRMaj, cMatrixRMaj3, cMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void set(CMatrixRMaj cMatrixRMaj, double d) {
        CommonOps_CDRM.fill(cMatrixRMaj, (float) d, 0.0f);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void zero(CMatrixRMaj cMatrixRMaj) {
        cMatrixRMaj.zero();
    }

    @Override // org.ejml.simple.SimpleOperations
    public double normF(CMatrixRMaj cMatrixRMaj) {
        return NormOps_CDRM.normF(cMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double conditionP2(CMatrixRMaj cMatrixRMaj) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public double determinant(CMatrixRMaj cMatrixRMaj) {
        return CommonOps_CDRM.det(cMatrixRMaj).real;
    }

    @Override // org.ejml.simple.SimpleOperations
    public double trace(CMatrixRMaj cMatrixRMaj) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void setRow(CMatrixRMaj cMatrixRMaj, int i, int i2, double... dArr) {
        for (int i3 = 0; i3 < dArr.length; i3++) {
            cMatrixRMaj.set(i, i2 + i3, (float) dArr[i3], 0.0f);
        }
    }

    @Override // org.ejml.simple.SimpleOperations
    public void setColumn(CMatrixRMaj cMatrixRMaj, int i, int i2, double... dArr) {
        for (int i3 = 0; i3 < dArr.length; i3++) {
            cMatrixRMaj.set(i2 + i3, i, (float) dArr[i3], 0.0f);
        }
    }

    @Override // org.ejml.simple.SimpleOperations
    public void extract(CMatrixRMaj cMatrixRMaj, int i, int i2, int i3, int i4, CMatrixRMaj cMatrixRMaj2, int i5, int i6) {
        CommonOps_CDRM.extract(cMatrixRMaj, i, i2, i3, i4, cMatrixRMaj2, i5, i6);
    }

    @Override // org.ejml.simple.SimpleOperations
    public boolean hasUncountable(CMatrixRMaj cMatrixRMaj) {
        return MatrixFeatures_CDRM.hasUncountable(cMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void changeSign(CMatrixRMaj cMatrixRMaj) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public double elementMaxAbs(CMatrixRMaj cMatrixRMaj) {
        return CommonOps_CDRM.elementMaxAbs(cMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double elementSum(CMatrixRMaj cMatrixRMaj) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementMult(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementDiv(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementPower(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementPower(CMatrixRMaj cMatrixRMaj, double d, CMatrixRMaj cMatrixRMaj2) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementExp(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementLog(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void print(PrintStream printStream, Matrix matrix) {
        MatrixIO.print(printStream, (CMatrixRMaj) matrix);
    }
}
