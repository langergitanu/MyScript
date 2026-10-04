package com.dropbox.core.http;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import okio.BufferedSink;
import okio.Okio;

/* JADX INFO: loaded from: classes4.dex */
final class OkHttpUtil {
    OkHttpUtil() {
    }

    public static void assertNotSameThreadExecutor(ExecutorService executorService) {
        Thread threadCurrentThread = Thread.currentThread();
        try {
            if (threadCurrentThread.equals((Thread) executorService.submit(new Callable<Thread>() { // from class: com.dropbox.core.http.OkHttpUtil.1
                @Override // java.util.concurrent.Callable
                public Thread call() {
                    return Thread.currentThread();
                }
            }).get(2L, TimeUnit.MINUTES))) {
                throw new IllegalArgumentException("OkHttp dispatcher uses same-thread executor. This is not supported by the SDK and may result in dead-locks. Please configure your Dispatcher to use an ExecutorService that runs tasks on separate threads.");
            }
        } catch (InterruptedException e) {
            threadCurrentThread.interrupt();
            throw new IllegalArgumentException("Unable to verify OkHttp dispatcher executor.", e);
        } catch (Exception e2) {
            throw new IllegalArgumentException("Unable to verify OkHttp dispatcher executor.", e2);
        }
    }

    public static final class PipedStream implements Closeable {
        private static final int BUFFER_SIZE = 5242880;

        /* JADX INFO: renamed from: in */
        private final PipedInputStream f657in;
        private final PipedOutputStream out;

        public PipedStream() {
            PipedInputStream pipedInputStream = new PipedInputStream(BUFFER_SIZE);
            this.f657in = pipedInputStream;
            try {
                this.out = new PipedOutputStream(pipedInputStream);
            } catch (IOException unused) {
                throw new IllegalStateException("Unable to create piped stream for async upload request.");
            }
        }

        public OutputStream getOutputStream() {
            return this.out;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            try {
                this.out.close();
            } catch (IOException unused) {
            }
            try {
                this.f657in.close();
            } catch (IOException unused2) {
            }
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            bufferedSink.writeAll(Okio.source(this.f657in));
        }
    }
}
