package io.opencensus.trace;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes8.dex */
public interface ContextManager {
    ContextHandle currentContext();

    Span getValue(ContextHandle contextHandle);

    ContextHandle withValue(ContextHandle contextHandle, @Nullable Span span);
}
