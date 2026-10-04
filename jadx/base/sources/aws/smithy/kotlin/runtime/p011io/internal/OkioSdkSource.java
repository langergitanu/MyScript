package aws.smithy.kotlin.runtime.p011io.internal;

import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Source;

/* JADX INFO: compiled from: Convert.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/internal/OkioSdkSource;", "Laws/smithy/kotlin/runtime/io/SdkSource;", "Lokio/Source;", "delegate", "<init>", "(Lokio/Source;)V", "", "close", "()V", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "sink", "", "limit", "read", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;J)J", "Lokio/Source;", "getDelegate$runtime_core", "()Lokio/Source;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class OkioSdkSource implements SdkSource {
    private final Source delegate;

    public OkioSdkSource(Source delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: renamed from: getDelegate$runtime_core, reason: from getter */
    public final Source getDelegate() {
        return this.delegate;
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSource, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSource
    public long read(SdkBuffer sink, long limit) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return this.delegate.read(ConvertKt.toOkio(sink), limit);
    }
}
