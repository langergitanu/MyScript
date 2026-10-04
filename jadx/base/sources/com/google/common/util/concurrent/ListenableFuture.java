package com.google.common.util.concurrent;

import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import org.jspecify.annotations.NullMarked;

/* JADX INFO: loaded from: classes6.dex */
@DoNotMock("Use the methods in Futures (like immediateFuture) or SettableFuture")
@NullMarked
public interface ListenableFuture<V> extends Future<V> {
    void addListener(Runnable listener, Executor executor);
}
