package com.fasterxml.jackson.core.sym;

/* JADX INFO: loaded from: classes5.dex */
public final class Name2 extends Name {

    /* JADX INFO: renamed from: q1 */
    private final int f836q1;

    /* JADX INFO: renamed from: q2 */
    private final int f837q2;

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2, int i3) {
        return false;
    }

    Name2(String str, int i, int i2, int i3) {
        super(str, i);
        this.f836q1 = i2;
        this.f837q2 = i3;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2) {
        return i == this.f836q1 && i2 == this.f837q2;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i) {
        return i == 2 && iArr[0] == this.f836q1 && iArr[1] == this.f837q2;
    }
}
