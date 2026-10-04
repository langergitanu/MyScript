package aws.smithy.kotlin.runtime.p011io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.p011io.internal.ConvertKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;

/* JADX INFO: compiled from: BufferedSinkAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0014\b \u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u00020\u0006H\u0096\u0080\u0004¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u000f\u0010\u0014J\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u000f\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\"H\u0016¢\u0006\u0004\b%\u0010$J\u0017\u0010&\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b(\u0010'J\u0017\u0010)\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0012H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0012H\u0016¢\u0006\u0004\b+\u0010*J\u000f\u0010,\u001a\u00020\u000eH\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u000eH\u0016¢\u0006\u0004\b.\u0010-J\u000f\u0010/\u001a\u00020\u000eH\u0016¢\u0006\u0004\b/\u0010-R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u00100\u001a\u0004\b1\u00102R\u0014\u00105\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00066"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/AbstractBufferedSinkAdapter;", "Laws/smithy/kotlin/runtime/io/SdkBufferedSink;", "Lokio/BufferedSink;", "delegate", "<init>", "(Lokio/BufferedSink;)V", "", "toString", "()Ljava/lang/String;", "", FirebaseAnalytics.Param.SOURCE, "", TypedValues.CycleType.S_WAVE_OFFSET, "limit", "", "write", "([BII)V", "Laws/smithy/kotlin/runtime/io/SdkSource;", "", "byteCount", "(Laws/smithy/kotlin/runtime/io/SdkSource;J)V", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;J)V", "writeAll", "(Laws/smithy/kotlin/runtime/io/SdkSource;)J", TypedValues.Custom.S_STRING, TtmlNode.START, "endExclusive", "writeUtf8", "(Ljava/lang/String;II)V", "", "x", "writeByte", "(B)V", "", "writeShort", "(S)V", "writeShortLe", "writeInt", "(I)V", "writeIntLe", "writeLong", "(J)V", "writeLongLe", "flush", "()V", "emit", "close", "Lokio/BufferedSink;", "getDelegate$runtime_core", "()Lokio/BufferedSink;", "getBuffer", "()Laws/smithy/kotlin/runtime/io/SdkBuffer;", "buffer", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class AbstractBufferedSinkAdapter implements SdkBufferedSink {
    private final BufferedSink delegate;

    public AbstractBufferedSinkAdapter(BufferedSink delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: renamed from: getDelegate$runtime_core, reason: from getter */
    public final BufferedSink getDelegate() {
        return this.delegate;
    }

    public String toString() {
        return this.delegate.toString();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public SdkBuffer getBuffer() {
        return ConvertKt.toSdk(this.delegate.getBuffer());
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void write(byte[] source, int offset, int limit) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        this.delegate.write(source, offset, limit);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void write(SdkSource source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        this.delegate.write(ConvertKt.toOkio(source), byteCount);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSink
    public void write(SdkBuffer source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.delegate.write(ConvertKt.toOkio(source), byteCount);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public long writeAll(SdkSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return this.delegate.writeAll(ConvertKt.toOkio(source));
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void writeUtf8(String string, int start, int endExclusive) throws IOException {
        Intrinsics.checkNotNullParameter(string, "string");
        this.delegate.writeUtf8(string, start, endExclusive);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void writeByte(byte x) throws IOException {
        this.delegate.writeByte(x);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void writeShort(short x) throws IOException {
        this.delegate.writeShort(x);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void writeShortLe(short x) throws IOException {
        this.delegate.writeShortLe(x);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void writeInt(int x) throws IOException {
        this.delegate.writeInt(x);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void writeIntLe(int x) throws IOException {
        this.delegate.writeIntLe(x);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void writeLong(long x) throws IOException {
        this.delegate.writeLong(x);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void writeLongLe(long x) throws IOException {
        this.delegate.writeLongLe(x);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink, aws.smithy.kotlin.runtime.p011io.SdkSink
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void emit() throws IOException {
        this.delegate.emit();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSink, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        this.delegate.close();
    }
}
