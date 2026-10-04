package org.ejml.simple.ops;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.PrintStream;
import org.ejml.data.Matrix;
import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.CommonOps_ZDRM;
import org.ejml.dense.row.MatrixFeatures_ZDRM;
import org.ejml.dense.row.NormOps_ZDRM;
import org.ejml.ops.MatrixIO;
import org.ejml.simple.SimpleOperations;

/* JADX INFO: loaded from: classes9.dex */
public class SimpleOperations_ZDRM implements SimpleOperations<ZMatrixRMaj> {
    @Override // org.ejml.simple.SimpleOperations
    public void transpose(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2) {
        CommonOps_ZDRM.transpose(zMatrixRMaj, zMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void mult(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        CommonOps_ZDRM.mult(zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void kron(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void plus(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        CommonOps_ZDRM.add(zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void minus(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        CommonOps_ZDRM.subtract(zMatrixRMaj, zMatrixRMaj2, zMatrixRMaj3);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void minus(ZMatrixRMaj zMatrixRMaj, double d, ZMatrixRMaj zMatrixRMaj2) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void plus(ZMatrixRMaj zMatrixRMaj, double d, ZMatrixRMaj zMatrixRMaj2) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void plus(ZMatrixRMaj zMatrixRMaj, double d, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public double dot(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void scale(ZMatrixRMaj zMatrixRMaj, double d, ZMatrixRMaj zMatrixRMaj2) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void divide(ZMatrixRMaj zMatrixRMaj, double d, ZMatrixRMaj zMatrixRMaj2) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public boolean invert(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2) {
        return CommonOps_ZDRM.invert(zMatrixRMaj, zMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void pseudoInverse(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public boolean solve(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        return CommonOps_ZDRM.solve(zMatrixRMaj, zMatrixRMaj3, zMatrixRMaj2);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void set(ZMatrixRMaj zMatrixRMaj, double d) {
        CommonOps_ZDRM.fill(zMatrixRMaj, d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void zero(ZMatrixRMaj zMatrixRMaj) {
        zMatrixRMaj.zero();
    }

    @Override // org.ejml.simple.SimpleOperations
    public double normF(ZMatrixRMaj zMatrixRMaj) {
        return NormOps_ZDRM.normF(zMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double conditionP2(ZMatrixRMaj zMatrixRMaj) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public double determinant(ZMatrixRMaj zMatrixRMaj) {
        return CommonOps_ZDRM.det(zMatrixRMaj).real;
    }

    @Override // org.ejml.simple.SimpleOperations
    public double trace(ZMatrixRMaj zMatrixRMaj) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void setRow(ZMatrixRMaj zMatrixRMaj, int i, int i2, double... dArr) {
        for (int i3 = 0; i3 < dArr.length; i3++) {
            zMatrixRMaj.set(i, i2 + i3, dArr[i3], FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
    }

    @Override // org.ejml.simple.SimpleOperations
    public void setColumn(ZMatrixRMaj zMatrixRMaj, int i, int i2, double... dArr) {
        for (int i3 = 0; i3 < dArr.length; i3++) {
            zMatrixRMaj.set(i2 + i3, i, dArr[i3], FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
    }

    @Override // org.ejml.simple.SimpleOperations
    public void extract(ZMatrixRMaj zMatrixRMaj, int i, int i2, int i3, int i4, ZMatrixRMaj zMatrixRMaj2, int i5, int i6) {
        CommonOps_ZDRM.extract(zMatrixRMaj, i, i2, i3, i4, zMatrixRMaj2, i5, i6);
    }

    @Override // org.ejml.simple.SimpleOperations
    public boolean hasUncountable(ZMatrixRMaj zMatrixRMaj) {
        return MatrixFeatures_ZDRM.hasUncountable(zMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public void changeSign(ZMatrixRMaj zMatrixRMaj) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public double elementMaxAbs(ZMatrixRMaj zMatrixRMaj) {
        return CommonOps_ZDRM.elementMaxAbs(zMatrixRMaj);
    }

    @Override // org.ejml.simple.SimpleOperations
    public double elementSum(ZMatrixRMaj zMatrixRMaj) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementMult(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementDiv(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementPower(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementPower(ZMatrixRMaj zMatrixRMaj, double d, ZMatrixRMaj zMatrixRMaj2) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementExp(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void elementLog(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2) {
        throw new RuntimeException("Unsupported");
    }

    @Override // org.ejml.simple.SimpleOperations
    public void print(PrintStream printStream, Matrix matrix) {
        MatrixIO.print(printStream, (ZMatrixRMaj) matrix);
    }
}
