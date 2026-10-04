package aws.smithy.kotlin.runtime.p011io;

import aws.smithy.kotlin.runtime.InternalApi;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GzipSdkSourceJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/GzipSdkSource;", "Laws/smithy/kotlin/runtime/io/SdkSource;", FirebaseAnalytics.Param.SOURCE, "<init>", "(Laws/smithy/kotlin/runtime/io/SdkSource;)V", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "sink", "", "limit", "read", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;J)J", "", "close", "()V", "Laws/smithy/kotlin/runtime/io/SdkSource;", "gzipBuffer", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "Ljava/util/zip/GZIPOutputStream;", "gzipOutputStream", "Ljava/util/zip/GZIPOutputStream;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GzipSdkSource implements SdkSource {
    private final SdkBuffer gzipBuffer;
    private final GZIPOutputStream gzipOutputStream;
    private final SdkSource source;

    public GzipSdkSource(SdkSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        SdkBuffer sdkBuffer = new SdkBuffer();
        this.gzipBuffer = sdkBuffer;
        this.gzipOutputStream = new GZIPOutputStream(sdkBuffer.outputStream(), true);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSource
    public long read(SdkBuffer sink, long limit) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (limit < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (limit == 0) {
            return 0L;
        }
        SdkBuffer sdkBuffer = new SdkBuffer();
        long j = this.source.read(sdkBuffer, limit);
        if (j == -1) {
            this.gzipOutputStream.close();
        }
        if (j == -1 && this.gzipBuffer.exhausted()) {
            return -1L;
        }
        if (j >= 0) {
            this.gzipOutputStream.write(sdkBuffer.readByteArray());
            this.gzipOutputStream.flush();
        }
        return this.gzipBuffer.read(sink, limit);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSource, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.gzipOutputStream.close();
        this.source.close();
    }
}
