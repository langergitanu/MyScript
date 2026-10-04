package aws.smithy.kotlin.runtime.p011io.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

/* JADX INFO: compiled from: Observers.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/internal/SdkSourceObserver;", "Laws/smithy/kotlin/runtime/io/SdkSource;", "delegate", "<init>", "(Laws/smithy/kotlin/runtime/io/SdkSource;)V", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "sink", "", "limit", "read", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;J)J", "", "data", "", TypedValues.CycleType.S_WAVE_OFFSET, "length", "", "observe", "([BII)V", "close", "()V", "Laws/smithy/kotlin/runtime/io/SdkSource;", "Lokio/Buffer$UnsafeCursor;", "cursor", "Lokio/Buffer$UnsafeCursor;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class SdkSourceObserver implements SdkSource {
    private final Buffer.UnsafeCursor cursor;
    private final SdkSource delegate;

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSource, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public abstract void observe(byte[] data, int offset, int length);

    public SdkSourceObserver(SdkSource delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.cursor = new Buffer.UnsafeCursor();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSource
    public long read(SdkBuffer sink, long limit) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Buffer okio2 = ConvertKt.toOkio(sink);
        long j = this.delegate.read(sink, limit);
        if (j <= 0) {
            return j;
        }
        okio2.readUnsafe(this.cursor);
        try {
            int iSeek = this.cursor.seek(sink.getSize() - j);
            long j2 = j;
            while (j2 > 0 && iSeek > 0) {
                int iMin = Math.min(iSeek, (int) j2);
                byte[] bArr = this.cursor.data;
                if (bArr == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                observe(bArr, this.cursor.start, iMin);
                j2 -= (long) iMin;
                iSeek = this.cursor.next();
            }
            return j;
        } finally {
            this.cursor.close();
        }
    }
}
