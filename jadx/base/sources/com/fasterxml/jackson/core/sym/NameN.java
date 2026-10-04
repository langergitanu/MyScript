package com.fasterxml.jackson.core.sym;

import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class NameN extends Name {

    /* JADX INFO: renamed from: q */
    private final int[] f841q;

    /* JADX INFO: renamed from: q1 */
    private final int f842q1;

    /* JADX INFO: renamed from: q2 */
    private final int f843q2;

    /* JADX INFO: renamed from: q3 */
    private final int f844q3;

    /* JADX INFO: renamed from: q4 */
    private final int f845q4;
    private final int qlen;

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2, int i3) {
        return false;
    }

    NameN(String str, int i, int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        super(str, i);
        this.f842q1 = i2;
        this.f843q2 = i3;
        this.f844q3 = i4;
        this.f845q4 = i5;
        this.f841q = iArr;
        this.qlen = i6;
    }

    public static NameN construct(String str, int i, int[] iArr, int i2) {
        if (i2 < 4) {
            throw new IllegalArgumentException();
        }
        return new NameN(str, i, iArr[0], iArr[1], iArr[2], iArr[3], i2 + (-4) > 0 ? Arrays.copyOfRange(iArr, 4, i2) : null, i2);
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i) {
        if (i != this.qlen || iArr[0] != this.f842q1 || iArr[1] != this.f843q2 || iArr[2] != this.f844q3 || iArr[3] != this.f845q4) {
            return false;
        }
        switch (i) {
            case 8:
                if (iArr[7] != this.f841q[3]) {
                }
            case 7:
                if (iArr[6] != this.f841q[2]) {
                }
            case 6:
                if (iArr[5] != this.f841q[1]) {
                }
            case 5:
                if (iArr[4] != this.f841q[0]) {
                }
            case 4:
                return true;
        }
        return false;
    }

    private final boolean _equals2(int[] iArr) {
        int i = this.qlen - 4;
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2 + 4] != this.f841q[i2]) {
                return false;
            }
        }
        return true;
    }
}
