package org.ejml.data;

/* JADX INFO: loaded from: classes9.dex */
public interface DMatrix extends Matrix {
    double get(int i, int i2);

    int getNumElements();

    void set(int i, int i2, double d);

    double unsafe_get(int i, int i2);

    void unsafe_set(int i, int i2, double d);
}
