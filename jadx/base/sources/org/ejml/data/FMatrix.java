package org.ejml.data;

/* JADX INFO: loaded from: classes9.dex */
public interface FMatrix extends Matrix {
    float get(int i, int i2);

    int getNumElements();

    void set(int i, int i2, float f);

    float unsafe_get(int i, int i2);

    void unsafe_set(int i, int i2, float f);
}
