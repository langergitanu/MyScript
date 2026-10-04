package aws.smithy.kotlin.runtime.p011io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.p011io.internal.ConvertKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

/* JADX INFO: compiled from: SdkBufferJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007J\u0011\u0010\t\u001a\u00020\bH\u0096\u0080\u0004¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u00020\u000bH\u0096\u0080\u0004¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0082\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0013H\u0016¢\u0006\u0004\b!\u0010 J\u000f\u0010\"\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\"\u0010\rJ\u000f\u0010#\u001a\u00020\u000bH\u0016¢\u0006\u0004\b#\u0010\rJ\u0017\u0010&\u001a\u00020\u00132\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J'\u0010+\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bH\u0016¢\u0006\u0004\b+\u0010,J\u001f\u0010+\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0013H\u0016¢\u0006\u0004\b+\u0010-J\u0017\u0010+\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b+\u00100J\u000f\u00101\u001a\u00020(H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00101\u001a\u00020(2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b1\u00103J\u000f\u00104\u001a\u00020\bH\u0016¢\u0006\u0004\b4\u0010\nJ\u0017\u00104\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0001H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0010H\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b<\u0010\u0017J'\u0010>\u001a\u00020\u00152\u0006\u0010=\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bH\u0016¢\u0006\u0004\b>\u0010?J\u001f\u0010>\u001a\u00020\u00152\u0006\u0010=\u001a\u00020@2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b>\u0010AJ\u001f\u0010>\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b>\u0010BJ\u0017\u0010>\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020.H\u0016¢\u0006\u0004\b>\u00100J\u0017\u0010D\u001a\u00020\u00132\u0006\u0010=\u001a\u00020@H\u0016¢\u0006\u0004\bD\u0010EJ'\u0010I\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u000bH\u0016¢\u0006\u0004\bI\u0010JJ\u0017\u0010L\u001a\u00020\u00152\u0006\u0010K\u001a\u00020\u0018H\u0016¢\u0006\u0004\bL\u0010MJ\u0017\u0010N\u001a\u00020\u00152\u0006\u0010K\u001a\u00020\u001bH\u0016¢\u0006\u0004\bN\u0010OJ\u0017\u0010P\u001a\u00020\u00152\u0006\u0010K\u001a\u00020\u001bH\u0016¢\u0006\u0004\bP\u0010OJ\u0017\u0010Q\u001a\u00020\u00152\u0006\u0010K\u001a\u00020\u000bH\u0016¢\u0006\u0004\bQ\u0010RJ\u0017\u0010S\u001a\u00020\u00152\u0006\u0010K\u001a\u00020\u000bH\u0016¢\u0006\u0004\bS\u0010RJ\u0017\u0010T\u001a\u00020\u00152\u0006\u0010K\u001a\u00020\u0013H\u0016¢\u0006\u0004\bT\u0010\u0017J\u0017\u0010U\u001a\u00020\u00152\u0006\u0010K\u001a\u00020\u0013H\u0016¢\u0006\u0004\bU\u0010\u0017J\u000f\u0010V\u001a\u00020\u0015H\u0016¢\u0006\u0004\bV\u0010\u0004J\u000f\u0010W\u001a\u00020\u0015H\u0016¢\u0006\u0004\bW\u0010\u0004J\u000f\u0010X\u001a\u00020\u0015H\u0016¢\u0006\u0004\bX\u0010\u0004J\u000f\u0010Y\u001a\u00020\u0010H\u0016¢\u0006\u0004\bY\u00109J\u000f\u0010[\u001a\u00020ZH\u0016¢\u0006\u0004\b[\u0010\\J\u000f\u0010^\u001a\u00020]H\u0016¢\u0006\u0004\b^\u0010_R\u001a\u0010`\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\u0011\u0010e\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\bd\u0010 R\u0014\u0010\u0006\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bf\u0010g¨\u0006h"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/SdkBuffer;", "Laws/smithy/kotlin/runtime/io/SdkBufferedSource;", "Laws/smithy/kotlin/runtime/io/SdkBufferedSink;", "<init>", "()V", "Lokio/Buffer;", "buffer", "(Lokio/Buffer;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "byteCount", "", "skip", "(J)V", "", "readByte", "()B", "", "readShort", "()S", "readShortLe", "readLong", "()J", "readLongLe", "readInt", "readIntLe", "Laws/smithy/kotlin/runtime/io/SdkSink;", "sink", "readAll", "(Laws/smithy/kotlin/runtime/io/SdkSink;)J", "", TypedValues.CycleType.S_WAVE_OFFSET, "limit", "read", "([BII)I", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;J)J", "Ljava/nio/ByteBuffer;", "dst", "(Ljava/nio/ByteBuffer;)I", "readByteArray", "()[B", "(J)[B", "readUtf8", "(J)Ljava/lang/String;", "peek", "()Laws/smithy/kotlin/runtime/io/SdkBufferedSource;", "exhausted", "()Z", "request", "(J)Z", "require", FirebaseAnalytics.Param.SOURCE, "write", "([BII)V", "Laws/smithy/kotlin/runtime/io/SdkSource;", "(Laws/smithy/kotlin/runtime/io/SdkSource;J)V", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;J)V", "src", "writeAll", "(Laws/smithy/kotlin/runtime/io/SdkSource;)J", TypedValues.Custom.S_STRING, TtmlNode.START, "endExclusive", "writeUtf8", "(Ljava/lang/String;II)V", "x", "writeByte", "(B)V", "writeShort", "(S)V", "writeShortLe", "writeInt", "(I)V", "writeIntLe", "writeLong", "writeLongLe", "flush", "emit", "close", "isOpen", "Ljava/io/InputStream;", "inputStream", "()Ljava/io/InputStream;", "Ljava/io/OutputStream;", "outputStream", "()Ljava/io/OutputStream;", "inner", "Lokio/Buffer;", "getInner$runtime_core", "()Lokio/Buffer;", "getSize", "size", "getBuffer", "()Laws/smithy/kotlin/runtime/io/SdkBuffer;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkBuffer implements SdkBufferedSource, SdkBufferedSink {
    private final Buffer inner;

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public SdkBuffer getBuffer() {
        return this;
    }

    public SdkBuffer() {
        this(new Buffer());
    }

    /* JADX INFO: renamed from: getInner$runtime_core, reason: from getter */
    public final Buffer getInner() {
        return this.inner;
    }

    public SdkBuffer(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.inner = buffer;
    }

    public final long getSize() {
        return this.inner.size();
    }

    public String toString() {
        return this.inner.toString();
    }

    public int hashCode() {
        return this.inner.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SdkBuffer) {
            return Intrinsics.areEqual(this.inner, ((SdkBuffer) other).inner);
        }
        return false;
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public void skip(long byteCount) throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            getInner().skip(byteCount);
            Unit unit = Unit.INSTANCE;
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public byte readByte() throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            return getInner().readByte();
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public short readShort() throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            return getInner().readShort();
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public short readShortLe() throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            return getInner().readShortLe();
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public long readLong() throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            return getInner().readLong();
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public long readLongLe() throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            return getInner().readLongLe();
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public int readInt() throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            return getInner().readInt();
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public int readIntLe() throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            return getInner().readIntLe();
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer dst) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        return this.inner.read(dst);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public byte[] readByteArray() throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            return getInner().readByteArray();
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public byte[] readByteArray(long byteCount) throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            return getInner().readByteArray(byteCount);
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public String readUtf8() throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            return getInner().readUtf8();
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public String readUtf8(long byteCount) throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            return getInner().readUtf8(byteCount);
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public SdkBufferedSource peek() throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            return SdkIoKt.buffer(ConvertKt.toSdk(getInner().peek()));
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public boolean exhausted() throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            return getInner().exhausted();
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public boolean request(long byteCount) throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            return getInner().request(byteCount);
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public void require(long byteCount) throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            getInner().require(byteCount);
            Unit unit = Unit.INSTANCE;
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer src) {
        Intrinsics.checkNotNullParameter(src, "src");
        return this.inner.write(src);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void writeByte(byte x) throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            getInner().writeByte((int) x);
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void writeShort(short x) throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            getInner().writeShort((int) x);
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void writeShortLe(short x) throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            getInner().writeShortLe((int) x);
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void writeInt(int x) throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            getInner().writeInt(x);
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void writeIntLe(int x) throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            getInner().writeIntLe(x);
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void writeLong(long x) throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            getInner().writeLong(x);
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void writeLongLe(long x) throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            getInner().writeLongLe(x);
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink, aws.smithy.kotlin.runtime.p011io.SdkSink
    public void flush() throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            getInner().flush();
            Unit unit = Unit.INSTANCE;
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void emit() {
        this.inner.emit();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSource, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            SdkBuffer sdkBuffer = this;
            getInner().close();
            Unit unit = Unit.INSTANCE;
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.inner.isOpen();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public InputStream inputStream() {
        return this.inner.inputStream();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public OutputStream outputStream() {
        return this.inner.outputStream();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public long readAll(SdkSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            SdkBuffer sdkBuffer = this;
            return getInner().readAll(ConvertKt.toOkio(sink));
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public int read(byte[] sink, int offset, int limit) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            SdkBuffer sdkBuffer = this;
            return getInner().read(sink, offset, limit);
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSource
    public long read(SdkBuffer sink, long limit) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            SdkBuffer sdkBuffer = this;
            return getInner().read(sink.getInner(), limit);
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void write(byte[] source, int offset, int limit) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            SdkBuffer sdkBuffer = this;
            getInner().write(source, offset, limit);
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void write(SdkSource source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            SdkBuffer sdkBuffer = this;
            getInner().write(ConvertKt.toOkio(source), byteCount);
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSink
    public void write(SdkBuffer source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            SdkBuffer sdkBuffer = this;
            getInner().write(ConvertKt.toOkio(source), byteCount);
            Unit unit = Unit.INSTANCE;
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public long writeAll(SdkSource source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            SdkBuffer sdkBuffer = this;
            return getInner().writeAll(ConvertKt.toOkio(source));
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public void writeUtf8(String string, int start, int endExclusive) throws IOException {
        Intrinsics.checkNotNullParameter(string, "string");
        try {
            SdkBuffer sdkBuffer = this;
            getInner().writeUtf8(string, start, endExclusive);
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }
}
