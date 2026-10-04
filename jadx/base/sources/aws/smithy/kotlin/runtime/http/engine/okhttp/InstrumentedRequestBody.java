package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.telemetry.metrics.MonotonicCounter;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;

/* JADX INFO: compiled from: MetricsInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/okhttp/InstrumentedRequestBody;", "Lokhttp3/RequestBody;", "delegate", "counter", "Laws/smithy/kotlin/runtime/telemetry/metrics/MonotonicCounter;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "<init>", "(Lokhttp3/RequestBody;Laws/smithy/kotlin/runtime/telemetry/metrics/MonotonicCounter;Laws/smithy/kotlin/runtime/collections/Attributes;)V", "contentType", "Lokhttp3/MediaType;", "isOneShot", "", "isDuplex", "contentLength", "", "writeTo", "", "sink", "Lokio/BufferedSink;", "http-client-engine-okhttp"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InstrumentedRequestBody extends RequestBody {
    private final Attributes attributes;
    private final MonotonicCounter counter;
    private final RequestBody delegate;

    public InstrumentedRequestBody(RequestBody delegate, MonotonicCounter counter, Attributes attributes) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(counter, "counter");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.delegate = delegate;
        this.counter = counter;
        this.attributes = attributes;
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: contentType */
    public MediaType getContentType() {
        return this.delegate.getContentType();
    }

    @Override // okhttp3.RequestBody
    public boolean isOneShot() {
        return this.delegate.isOneShot();
    }

    @Override // okhttp3.RequestBody
    public boolean isDuplex() {
        return this.delegate.isDuplex();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.delegate.contentLength();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        BufferedSink bufferedSinkBuffer = Okio.buffer(new InstrumentedSink(sink, this.counter, this.attributes));
        this.delegate.writeTo(bufferedSinkBuffer);
        if (bufferedSinkBuffer.isOpen()) {
            bufferedSinkBuffer.emit();
        }
    }
}
