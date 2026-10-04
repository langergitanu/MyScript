package io.opencensus.trace;

import io.opencensus.common.Scope;
import io.opencensus.trace.unsafe.ContextHandleUtils;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes8.dex */
final class CurrentSpanUtils {
    private CurrentSpanUtils() {
    }

    @Nullable
    static Span getCurrentSpan() {
        return ContextHandleUtils.getValue(ContextHandleUtils.currentContext());
    }

    static Scope withSpan(Span span, boolean z) {
        return new ScopeInSpan(span, z);
    }

    static Runnable withSpan(Span span, boolean z, Runnable runnable) {
        return new RunnableInSpan(span, runnable, z);
    }

    static <C> Callable<C> withSpan(Span span, boolean z, Callable<C> callable) {
        return new CallableInSpan(span, callable, z);
    }

    private static final class ScopeInSpan implements Scope {
        private final boolean endSpan;
        private final ContextHandle origContext;
        private final Span span;

        private ScopeInSpan(Span span, boolean z) {
            this.span = span;
            this.endSpan = z;
            this.origContext = ContextHandleUtils.withValue(ContextHandleUtils.currentContext(), span).attach();
        }

        @Override // io.opencensus.common.Scope, io.opencensus.common.NonThrowingCloseable, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            ContextHandleUtils.currentContext().detach(this.origContext);
            if (this.endSpan) {
                this.span.end();
            }
        }
    }

    private static final class RunnableInSpan implements Runnable {
        private final boolean endSpan;
        private final Runnable runnable;
        private final Span span;

        private RunnableInSpan(Span span, Runnable runnable, boolean z) {
            this.span = span;
            this.runnable = runnable;
            this.endSpan = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ContextHandle contextHandleAttach = ContextHandleUtils.withValue(ContextHandleUtils.currentContext(), this.span).attach();
            try {
                this.runnable.run();
            } catch (Throwable th) {
                try {
                    CurrentSpanUtils.setErrorStatus(this.span, th);
                    if (th instanceof RuntimeException) {
                        throw ((RuntimeException) th);
                    }
                    if (th instanceof Error) {
                        throw ((Error) th);
                    }
                    throw new RuntimeException("unexpected", th);
                } finally {
                    ContextHandleUtils.currentContext().detach(contextHandleAttach);
                    if (this.endSpan) {
                        this.span.end();
                    }
                }
            }
        }
    }

    private static final class CallableInSpan<V> implements Callable<V> {
        private final Callable<V> callable;
        private final boolean endSpan;
        private final Span span;

        private CallableInSpan(Span span, Callable<V> callable, boolean z) {
            this.span = span;
            this.callable = callable;
            this.endSpan = z;
        }

        @Override // java.util.concurrent.Callable
        public V call() throws Exception {
            ContextHandle contextHandleAttach = ContextHandleUtils.withValue(ContextHandleUtils.currentContext(), this.span).attach();
            try {
                try {
                    try {
                        V vCall = this.callable.call();
                        ContextHandleUtils.currentContext().detach(contextHandleAttach);
                        if (this.endSpan) {
                            this.span.end();
                        }
                        return vCall;
                    } catch (Throwable th) {
                        CurrentSpanUtils.setErrorStatus(this.span, th);
                        if (th instanceof Error) {
                            throw th;
                        }
                        throw new RuntimeException("unexpected", th);
                    }
                } catch (Exception e) {
                    CurrentSpanUtils.setErrorStatus(this.span, e);
                    throw e;
                }
            } catch (Throwable th2) {
                ContextHandleUtils.currentContext().detach(contextHandleAttach);
                if (this.endSpan) {
                    this.span.end();
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setErrorStatus(Span span, Throwable th) {
        span.setStatus(Status.UNKNOWN.withDescription(th.getMessage() == null ? th.getClass().getSimpleName() : th.getMessage()));
    }
}
