package org.ejml.interfaces.linsol;

import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface ReducedRowEchelonForm<T extends Matrix> {
    void reduce(T t, int i);
}
