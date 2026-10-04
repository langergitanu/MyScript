package com.google.common.cache;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes6.dex */
abstract class Striped64 extends Number {
    private static final long BASE_OFFSET;
    private static final long BUSY_OFFSET;
    private static final Unsafe UNSAFE;
    volatile transient long base;
    volatile transient int busy;
    volatile transient Cell[] cells;
    static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    static final Random rng = new Random();
    static final int NCPU = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: fn */
    abstract long mo745fn(long currentValue, long newValue);

    static final class Cell {
        private static final Unsafe UNSAFE;
        private static final long VALUE_OFFSET;

        /* JADX INFO: renamed from: p0 */
        volatile long f1001p0;

        /* JADX INFO: renamed from: p1 */
        volatile long f1002p1;

        /* JADX INFO: renamed from: p2 */
        volatile long f1003p2;

        /* JADX INFO: renamed from: p3 */
        volatile long f1004p3;

        /* JADX INFO: renamed from: p4 */
        volatile long f1005p4;

        /* JADX INFO: renamed from: p5 */
        volatile long f1006p5;

        /* JADX INFO: renamed from: p6 */
        volatile long f1007p6;

        /* JADX INFO: renamed from: q0 */
        volatile long f1008q0;

        /* JADX INFO: renamed from: q1 */
        volatile long f1009q1;

        /* JADX INFO: renamed from: q2 */
        volatile long f1010q2;

        /* JADX INFO: renamed from: q3 */
        volatile long f1011q3;

        /* JADX INFO: renamed from: q4 */
        volatile long f1012q4;

        /* JADX INFO: renamed from: q5 */
        volatile long f1013q5;

        /* JADX INFO: renamed from: q6 */
        volatile long f1014q6;
        volatile long value;

        Cell(long x) {
            this.value = x;
        }

        final boolean cas(long cmp, long val) {
            return UNSAFE.compareAndSwapLong(this, VALUE_OFFSET, cmp, val);
        }

        static {
            try {
                Unsafe unsafe = Striped64.getUnsafe();
                UNSAFE = unsafe;
                VALUE_OFFSET = unsafe.objectFieldOffset(Cell.class.getDeclaredField("value"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }
    }

    static {
        try {
            Unsafe unsafe = getUnsafe();
            UNSAFE = unsafe;
            BASE_OFFSET = unsafe.objectFieldOffset(Striped64.class.getDeclaredField(TtmlNode.RUBY_BASE));
            BUSY_OFFSET = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    Striped64() {
    }

    final boolean casBase(long cmp, long val) {
        return UNSAFE.compareAndSwapLong(this, BASE_OFFSET, cmp, val);
    }

    final boolean casBusy() {
        return UNSAFE.compareAndSwapInt(this, BUSY_OFFSET, 0, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ee A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void retryUpdate(long x, int[] hc, boolean wasUncontended) {
        int iNextInt;
        int[] iArr;
        boolean z;
        int length;
        boolean z2;
        int length2;
        if (hc == null) {
            iArr = new int[1];
            threadHashCode.set(iArr);
            iNextInt = rng.nextInt();
            if (iNextInt == 0) {
                iNextInt = 1;
            }
            iArr[0] = iNextInt;
        } else {
            iNextInt = hc[0];
            iArr = hc;
        }
        boolean z3 = false;
        int i = iNextInt;
        boolean z4 = wasUncontended;
        while (true) {
            Cell[] cellArr = this.cells;
            if (cellArr != null && (length = cellArr.length) > 0) {
                Cell cell = cellArr[(length - 1) & i];
                if (cell == null) {
                    if (this.busy == 0) {
                        Cell cell2 = new Cell(x);
                        if (this.busy == 0 && casBusy()) {
                            try {
                                Cell[] cellArr2 = this.cells;
                                if (cellArr2 == null || (length2 = cellArr2.length) <= 0) {
                                    z2 = false;
                                    if (!z2) {
                                        return;
                                    }
                                } else {
                                    int i2 = (length2 - 1) & i;
                                    if (cellArr2[i2] == null) {
                                        cellArr2[i2] = cell2;
                                        z2 = true;
                                    }
                                    if (!z2) {
                                    }
                                }
                            } finally {
                            }
                        }
                    }
                    z3 = false;
                } else if (z4) {
                    long j = cell.value;
                    if (cell.cas(j, mo745fn(j, x))) {
                        return;
                    }
                    if (length >= NCPU || this.cells != cellArr) {
                        z3 = false;
                    } else if (!z3) {
                        z3 = true;
                    } else if (this.busy == 0 && casBusy()) {
                        try {
                            if (this.cells == cellArr) {
                                Cell[] cellArr3 = new Cell[length << 1];
                                for (int i3 = 0; i3 < length; i3++) {
                                    cellArr3[i3] = cellArr[i3];
                                }
                                this.cells = cellArr3;
                            }
                            this.busy = 0;
                            z3 = false;
                        } finally {
                        }
                    }
                } else {
                    z4 = true;
                }
                int i4 = i ^ (i << 13);
                int i5 = i4 ^ (i4 >>> 17);
                i = i5 ^ (i5 << 5);
                iArr[0] = i;
            } else if (this.busy == 0 && this.cells == cellArr && casBusy()) {
                try {
                    if (this.cells == cellArr) {
                        Cell[] cellArr4 = new Cell[2];
                        cellArr4[i & 1] = new Cell(x);
                        this.cells = cellArr4;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        return;
                    }
                } finally {
                }
            } else {
                long j2 = this.base;
                if (casBase(j2, mo745fn(j2, x))) {
                    return;
                }
            }
        }
    }

    final void internalReset(long initialValue) {
        Cell[] cellArr = this.cells;
        this.base = initialValue;
        if (cellArr != null) {
            for (Cell cell : cellArr) {
                if (cell != null) {
                    cell.value = initialValue;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e) {
                throw new RuntimeException("Could not initialize intrinsics", e.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.cache.Striped64.1
                @Override // java.security.PrivilegedExceptionAction
                public Unsafe run() throws Exception {
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    throw new NoSuchFieldError("the Unsafe");
                }
            });
        }
    }
}
