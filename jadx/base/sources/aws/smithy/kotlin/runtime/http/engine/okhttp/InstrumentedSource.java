package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.telemetry.metrics.MonotonicCounter;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: MetricsInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/okhttp/InstrumentedSource;", "Lokio/Source;", "delegate", "counter", "Laws/smithy/kotlin/runtime/telemetry/metrics/MonotonicCounter;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "<init>", "(Lokio/Source;Laws/smithy/kotlin/runtime/telemetry/metrics/MonotonicCounter;Laws/smithy/kotlin/runtime/collections/Attributes;)V", "timeout", "Lokio/Timeout;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "close", "", "http-client-engine-okhttp"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InstrumentedSource implements Source {
    private final Attributes attributes;
    private final MonotonicCounter counter;
    private final Source delegate;

    public InstrumentedSource(Source delegate, MonotonicCounter counter, Attributes attributes) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(counter, "counter");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.delegate = delegate;
        this.counter = counter;
        this.attributes = attributes;
    }

    @Override // okio.Source
    /* JADX INFO: renamed from: timeout */
    public Timeout getTimeout() {
        return this.delegate.getTimeout();
    }

    @Override // okio.Source
    public long read(Buffer sink, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j = this.delegate.read(sink, byteCount);
        if (j > 0) {
            MonotonicCounter.add$default(this.counter, j, this.attributes, null, 4, null);
        }
        return j;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }
}
