package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.telemetry.metrics.MonotonicCounter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.Sink;
import okio.Timeout;

/* JADX INFO: compiled from: MetricsInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\t\u0010\u0011\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/okhttp/InstrumentedSink;", "Lokio/Sink;", "delegate", "Lokio/BufferedSink;", "counter", "Laws/smithy/kotlin/runtime/telemetry/metrics/MonotonicCounter;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "<init>", "(Lokio/BufferedSink;Laws/smithy/kotlin/runtime/telemetry/metrics/MonotonicCounter;Laws/smithy/kotlin/runtime/collections/Attributes;)V", "write", "", FirebaseAnalytics.Param.SOURCE, "Lokio/Buffer;", "byteCount", "", "close", "flush", "timeout", "Lokio/Timeout;", "http-client-engine-okhttp"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InstrumentedSink implements Sink {
    private final Attributes attributes;
    private final MonotonicCounter counter;
    private final BufferedSink delegate;

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // okio.Sink
    /* JADX INFO: renamed from: timeout */
    public Timeout getTimeout() {
        return this.delegate.getTimeout();
    }

    public InstrumentedSink(BufferedSink delegate, MonotonicCounter counter, Attributes attributes) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(counter, "counter");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.delegate = delegate;
        this.counter = counter;
        this.attributes = attributes;
    }

    @Override // okio.Sink
    public void write(Buffer source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.delegate.write(source, byteCount);
        MonotonicCounter.add$default(this.counter, byteCount, this.attributes, null, 4, null);
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.emit();
        this.delegate.close();
    }
}
