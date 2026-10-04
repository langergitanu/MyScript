package aws.smithy.kotlin.runtime.p011io.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkSink;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

/* JADX INFO: compiled from: Observers.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/internal/SdkSinkObserver;", "Laws/smithy/kotlin/runtime/io/SdkSink;", "delegate", "<init>", "(Laws/smithy/kotlin/runtime/io/SdkSink;)V", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", FirebaseAnalytics.Param.SOURCE, "", "byteCount", "", "write", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;J)V", "", "data", "", TypedValues.CycleType.S_WAVE_OFFSET, "length", "observe", "([BII)V", "close", "()V", "flush", "Laws/smithy/kotlin/runtime/io/SdkSink;", "Lokio/Buffer$UnsafeCursor;", "cursor", "Lokio/Buffer$UnsafeCursor;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class SdkSinkObserver implements SdkSink {
    private final Buffer.UnsafeCursor cursor;
    private final SdkSink delegate;

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSink, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSink
    public void flush() throws IOException {
        this.delegate.flush();
    }

    public abstract void observe(byte[] data, int offset, int length);

    public SdkSinkObserver(SdkSink delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.cursor = new Buffer.UnsafeCursor();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSink
    public void write(SdkBuffer source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        ConvertKt.toOkio(source).readUnsafe(this.cursor);
        try {
            int iSeek = this.cursor.seek(0L);
            long j = byteCount;
            while (iSeek > 0 && j > 0) {
                int iMin = Math.min(iSeek, (int) j);
                byte[] bArr = this.cursor.data;
                if (bArr == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                observe(bArr, this.cursor.start, iMin);
                j -= (long) iMin;
                iSeek = this.cursor.next();
            }
            this.cursor.close();
            this.delegate.write(source, byteCount);
        } catch (Throwable th) {
            this.cursor.close();
            throw th;
        }
    }
}
