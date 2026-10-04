package org.ejml.interfaces.linsol;

import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface ReducedRowEchelonForm_F64<T extends Matrix> extends ReducedRowEchelonForm<T> {
    void setTolerance(double d);
}
