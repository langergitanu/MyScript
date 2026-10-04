package org.ejml.data;

/* JADX INFO: loaded from: classes9.dex */
public enum MatrixType {
    DDRM(true, true, 64),
    FDRM(true, true, 32),
    ZDRM(false, true, 64),
    CDRM(false, true, 32),
    DSCC(true, false, 64),
    FSCC(true, false, 32),
    ZSCC(false, false, 64),
    CSCC(false, false, 32),
    UNSPECIFIED(false, false, 0);

    int bits;
    boolean dense;
    boolean fixed;
    boolean real;

    MatrixType(boolean z, boolean z2, int i) {
        this(false, z, z2, i);
    }

    MatrixType(boolean z, boolean z2, boolean z3, int i) {
        this.real = z2;
        this.fixed = z;
        this.dense = z3;
        this.bits = i;
    }

    public boolean isFixed() {
        return this.fixed;
    }

    public boolean isDense() {
        return this.dense;
    }

    public int getBits() {
        return this.bits;
    }
}
