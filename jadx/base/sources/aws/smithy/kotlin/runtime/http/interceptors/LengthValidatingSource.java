package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResponseLengthValidationInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/interceptors/LengthValidatingSource;", "Laws/smithy/kotlin/runtime/io/SdkSource;", FirebaseAnalytics.Param.SOURCE, "", "expectedContentLength", "<init>", "(Laws/smithy/kotlin/runtime/io/SdkSource;J)V", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "sink", "limit", "read", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;J)J", "", "close", "()V", "Laws/smithy/kotlin/runtime/io/SdkSource;", "J", "bytesReceived", "getBytesReceived", "()J", "setBytesReceived", "(J)V", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class LengthValidatingSource implements SdkSource {
    private long bytesReceived;
    private final long expectedContentLength;
    private final SdkSource source;

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSource, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public LengthValidatingSource(SdkSource source, long j) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.expectedContentLength = j;
    }

    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    public final void setBytesReceived(long j) {
        this.bytesReceived = j;
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSource
    public long read(SdkBuffer sink, long limit) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j = this.source.read(sink, limit);
        if (j != -1) {
            long j2 = this.bytesReceived;
            if (j2 <= this.expectedContentLength) {
                this.bytesReceived = j2 + j;
                return j;
            }
        }
        ResponseLengthValidationInterceptorKt.validateContentLength(this.expectedContentLength, Long.valueOf(this.bytesReceived));
        return j;
    }
}
