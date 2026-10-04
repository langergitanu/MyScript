package io.grpc;

import java.time.Duration;

/* JADX INFO: loaded from: classes8.dex */
final class TimeUtils {
    private TimeUtils() {
    }

    static long convertToNanos(Duration duration) {
        try {
            return duration.toNanos();
        } catch (ArithmeticException unused) {
            return duration.isNegative() ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
    }
}
