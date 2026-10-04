package org.ejml.interfaces.linsol;

import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public interface LinearSolverDense<T extends Matrix> extends LinearSolver<T, T> {
    void invert(T t);
}
