package aws.smithy.kotlin.runtime.p011io.internal;

import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkSink;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Sink;

/* JADX INFO: compiled from: Convert.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/internal/OkioSdkSink;", "Laws/smithy/kotlin/runtime/io/SdkSink;", "Lokio/Sink;", "delegate", "<init>", "(Lokio/Sink;)V", "", "close", "()V", "flush", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", FirebaseAnalytics.Param.SOURCE, "", "byteCount", "write", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;J)V", "Lokio/Sink;", "getDelegate$runtime_core", "()Lokio/Sink;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class OkioSdkSink implements SdkSink {
    private final Sink delegate;

    public OkioSdkSink(Sink delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: renamed from: getDelegate$runtime_core, reason: from getter */
    public final Sink getDelegate() {
        return this.delegate;
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSink, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSink
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSink
    public void write(SdkBuffer source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        this.delegate.write(ConvertKt.toOkio(source), byteCount);
    }
}
