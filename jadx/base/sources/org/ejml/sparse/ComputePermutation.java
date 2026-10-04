package org.ejml.sparse;

import org.ejml.data.IGrowArray;
import org.ejml.data.Matrix;

/* JADX INFO: loaded from: classes9.dex */
public abstract class ComputePermutation<T extends Matrix> {
    protected IGrowArray pcol;
    protected IGrowArray prow;

    public abstract void process(T t);

    public ComputePermutation(boolean z, boolean z2) {
        if (z) {
            this.prow = new IGrowArray();
        }
        if (z2) {
            this.pcol = new IGrowArray();
        }
    }

    public IGrowArray getRow() {
        return this.prow;
    }

    public IGrowArray getColumn() {
        return this.pcol;
    }

    public boolean hasRowPermutation() {
        return this.prow != null;
    }

    public boolean hasColumnPermutation() {
        return this.pcol != null;
    }
}
