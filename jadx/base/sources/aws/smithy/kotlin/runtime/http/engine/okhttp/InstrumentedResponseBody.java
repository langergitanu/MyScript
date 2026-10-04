package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.telemetry.metrics.MonotonicCounter;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: compiled from: MetricsInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/okhttp/InstrumentedResponseBody;", "Lokhttp3/ResponseBody;", "delegate", "counter", "Laws/smithy/kotlin/runtime/telemetry/metrics/MonotonicCounter;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "<init>", "(Lokhttp3/ResponseBody;Laws/smithy/kotlin/runtime/telemetry/metrics/MonotonicCounter;Laws/smithy/kotlin/runtime/collections/Attributes;)V", "contentType", "Lokhttp3/MediaType;", "contentLength", "", FirebaseAnalytics.Param.SOURCE, "Lokio/BufferedSource;", "http-client-engine-okhttp"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InstrumentedResponseBody extends ResponseBody {
    private final Attributes attributes;
    private final MonotonicCounter counter;
    private final ResponseBody delegate;

    public InstrumentedResponseBody(ResponseBody delegate, MonotonicCounter counter, Attributes attributes) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(counter, "counter");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.delegate = delegate;
        this.counter = counter;
        this.attributes = attributes;
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: contentType */
    public MediaType getMediaType() {
        return this.delegate.getMediaType();
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: contentLength */
    public long getContentLength() {
        return this.delegate.getContentLength();
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: source */
    public BufferedSource getSource() {
        return Okio.buffer(new InstrumentedSource(this.delegate.getSource(), this.counter, this.attributes));
    }
}
