package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes6.dex */
public interface AsyncCallable<V> {
    ListenableFuture<V> call() throws Exception;
}
