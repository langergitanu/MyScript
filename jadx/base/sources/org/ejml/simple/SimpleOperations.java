package org.ejml.simple;

import java.io.PrintStream;
import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface SimpleOperations<T extends Matrix> {
    void changeSign(T t);

    double conditionP2(T t);

    double determinant(T t);

    void divide(T t, double d, T t2);

    double dot(T t, T t2);

    void elementDiv(T t, T t2, T t3);

    void elementExp(T t, T t2);

    void elementLog(T t, T t2);

    double elementMaxAbs(T t);

    void elementMult(T t, T t2, T t3);

    void elementPower(T t, double d, T t2);

    void elementPower(T t, T t2, T t3);

    double elementSum(T t);

    void extract(T t, int i, int i2, int i3, int i4, T t2, int i5, int i6);

    boolean hasUncountable(T t);

    boolean invert(T t, T t2);

    void kron(T t, T t2, T t3);

    void minus(T t, double d, T t2);

    void minus(T t, T t2, T t3);

    void mult(T t, T t2, T t3);

    double normF(T t);

    void plus(T t, double d, T t2);

    void plus(T t, double d, T t2, T t3);

    void plus(T t, T t2, T t3);

    void print(PrintStream printStream, Matrix matrix);

    void pseudoInverse(T t, T t2);

    void scale(T t, double d, T t2);

    void set(T t, double d);

    void setColumn(T t, int i, int i2, double... dArr);

    void setRow(T t, int i, int i2, double... dArr);

    boolean solve(T t, T t2, T t3);

    double trace(T t);

    void transpose(T t, T t2);

    void zero(T t);
}
