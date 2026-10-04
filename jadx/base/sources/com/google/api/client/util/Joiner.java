package com.google.api.client.util;

/* JADX INFO: loaded from: classes6.dex */
public final class Joiner {
    private final com.google.common.base.Joiner wrapped;

    /* JADX INFO: renamed from: on */
    public static Joiner m725on(char c) {
        return new Joiner(com.google.common.base.Joiner.m733on(c));
    }

    private Joiner(com.google.common.base.Joiner joiner) {
        this.wrapped = joiner;
    }

    public final String join(Iterable<?> iterable) {
        return this.wrapped.join(iterable);
    }
}
