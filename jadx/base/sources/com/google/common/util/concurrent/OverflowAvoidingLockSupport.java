package com.google.common.util.concurrent;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes6.dex */
final class OverflowAvoidingLockSupport {
    static final long MAX_NANOSECONDS_THRESHOLD = 2147483647999999999L;

    private OverflowAvoidingLockSupport() {
    }

    static void parkNanos(Object blocker, long nanos) {
        LockSupport.parkNanos(blocker, Math.min(nanos, MAX_NANOSECONDS_THRESHOLD));
    }
}
