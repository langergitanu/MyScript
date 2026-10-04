package org.ejml.data;

/* JADX INFO: loaded from: classes9.dex */
public interface FMatrixSparse extends FMatrix {
    boolean isAssigned(int i, int i2);

    void printNonZero();

    void remove(int i, int i2);

    void reshape(int i, int i2, int i3);

    void shrinkArrays();

    void zero();
}
