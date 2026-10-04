package com.google.common.util.concurrent;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes6.dex */
final class SneakyThrows<T extends Throwable> {
    static Error sneakyThrow(Throwable t) {
        throw new SneakyThrows().throwIt(t);
    }

    private Error throwIt(Throwable t) throws Throwable {
        throw t;
    }

    private SneakyThrows() {
    }
}
