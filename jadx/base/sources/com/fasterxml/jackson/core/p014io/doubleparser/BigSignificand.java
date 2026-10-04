package com.fasterxml.jackson.core.p014io.doubleparser;

import androidx.collection.SieveCacheKt;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/* JADX INFO: loaded from: classes5.dex */
class BigSignificand {
    private static final long LONG_MASK = 4294967295L;
    private int firstNonZeroInt;
    private final int numInts;

    /* JADX INFO: renamed from: x */
    private final int[] f825x;

    public BigSignificand(long j) {
        if (j <= 0 || j >= SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException("numBits=" + j);
        }
        int i = (((int) ((j + 63) >>> 6)) + 1) << 1;
        this.numInts = i;
        this.f825x = new int[i];
        this.firstNonZeroInt = i;
    }

    public void add(int i) {
        if (i == 0) {
            return;
        }
        long j = ((long) i) & LONG_MASK;
        int i2 = this.numInts;
        while (true) {
            i2--;
            if (j != 0) {
                long jM539x = (((long) m539x(i2)) & LONG_MASK) + j;
                m540x(i2, (int) jM539x);
                j = jM539x >>> 32;
            } else {
                this.firstNonZeroInt = Math.min(this.firstNonZeroInt, i2 + 1);
                return;
            }
        }
    }

    public void fma(int i, int i2) {
        long j = ((long) i) & LONG_MASK;
        long j2 = i2;
        int i3 = this.numInts;
        while (true) {
            i3--;
            if (i3 < this.firstNonZeroInt) {
                break;
            }
            long jM539x = ((((long) m539x(i3)) & LONG_MASK) * j) + j2;
            m540x(i3, (int) jM539x);
            j2 = jM539x >>> 32;
        }
        if (j2 != 0) {
            m540x(i3, (int) j2);
            this.firstNonZeroInt = i3;
        }
    }

    public BigInteger toBigInteger() {
        byte[] bArr = new byte[this.f825x.length << 2];
        IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).asIntBuffer();
        int i = 0;
        while (true) {
            int[] iArr = this.f825x;
            if (i < iArr.length) {
                intBufferAsIntBuffer.put(i, iArr[i]);
                i++;
            } else {
                return new BigInteger(bArr);
            }
        }
    }

    /* JADX INFO: renamed from: x */
    private void m540x(int i, int i2) {
        this.f825x[i] = i2;
    }

    /* JADX INFO: renamed from: x */
    private int m539x(int i) {
        return this.f825x[i];
    }
}
