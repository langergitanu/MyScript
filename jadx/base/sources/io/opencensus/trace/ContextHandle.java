package io.opencensus.trace;

/* JADX INFO: loaded from: classes8.dex */
public interface ContextHandle {
    ContextHandle attach();

    void detach(ContextHandle contextHandle);
}
