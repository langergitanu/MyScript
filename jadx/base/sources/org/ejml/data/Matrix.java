package org.ejml.data;

import java.io.Serializable;

/* JADX INFO: loaded from: classes9.dex */
public interface Matrix extends Serializable {
    <T extends Matrix> T copy();

    <T extends Matrix> T createLike();

    int getNumCols();

    int getNumRows();

    MatrixType getType();

    void print();

    void set(Matrix matrix);
}
