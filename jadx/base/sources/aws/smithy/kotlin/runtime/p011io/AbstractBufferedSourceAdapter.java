package aws.smithy.kotlin.runtime.p011io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import aws.smithy.kotlin.runtime.p011io.internal.ConvertKt;
import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;

/* JADX INFO: compiled from: BuffereredSourceAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\b \u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010 \u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0015H\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010 \u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010#J\u000f\u0010$\u001a\u00020\u001dH\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010$\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010(\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010*J\u000f\u0010+\u001a\u00020\u0001H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020-2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b2\u0010\nJ\u000f\u00103\u001a\u00020\bH\u0016¢\u0006\u0004\b3\u00104R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u00105\u001a\u0004\b6\u00107R\u0014\u0010:\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006;"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/AbstractBufferedSourceAdapter;", "Laws/smithy/kotlin/runtime/io/SdkBufferedSource;", "Lokio/BufferedSource;", "delegate", "<init>", "(Lokio/BufferedSource;)V", "", "byteCount", "", "skip", "(J)V", "", "readByte", "()B", "", "readShort", "()S", "readShortLe", "readLong", "()J", "readLongLe", "", "readInt", "()I", "readIntLe", "Laws/smithy/kotlin/runtime/io/SdkSink;", "sink", "readAll", "(Laws/smithy/kotlin/runtime/io/SdkSink;)J", "", TypedValues.CycleType.S_WAVE_OFFSET, "limit", "read", "([BII)I", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;J)J", "readByteArray", "()[B", "(J)[B", "", "readUtf8", "()Ljava/lang/String;", "(J)Ljava/lang/String;", "peek", "()Laws/smithy/kotlin/runtime/io/SdkBufferedSource;", "", "exhausted", "()Z", "request", "(J)Z", "require", "close", "()V", "Lokio/BufferedSource;", "getDelegate$runtime_core", "()Lokio/BufferedSource;", "getBuffer", "()Laws/smithy/kotlin/runtime/io/SdkBuffer;", "buffer", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class AbstractBufferedSourceAdapter implements SdkBufferedSource {
    private final BufferedSource delegate;

    public AbstractBufferedSourceAdapter(BufferedSource delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: renamed from: getDelegate$runtime_core, reason: from getter */
    public final BufferedSource getDelegate() {
        return this.delegate;
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public SdkBuffer getBuffer() {
        return ConvertKt.toSdk(this.delegate.getBuffer());
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public void skip(long byteCount) throws IOException {
        try {
            this.delegate.skip(byteCount);
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
            return this.delegate.readByte();
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public short readShort() throws IOException {
        try {
            return this.delegate.readShort();
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public short readShortLe() throws IOException {
        try {
            return this.delegate.readShortLe();
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public long readLong() throws IOException {
        try {
            return this.delegate.readLong();
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public long readLongLe() throws IOException {
        try {
            return this.delegate.readLongLe();
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public int readInt() throws IOException {
        try {
            return this.delegate.readInt();
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public int readIntLe() throws IOException {
        try {
            return this.delegate.readIntLe();
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public long readAll(SdkSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            return this.delegate.readAll(ConvertKt.toOkio(sink));
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
            return this.delegate.read(sink, offset, limit);
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
            return this.delegate.read(ConvertKt.toOkio(sink), limit);
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public byte[] readByteArray() throws IOException {
        try {
            return this.delegate.readByteArray();
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public byte[] readByteArray(long byteCount) throws IOException {
        try {
            return this.delegate.readByteArray(byteCount);
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public String readUtf8() throws IOException {
        try {
            return this.delegate.readUtf8();
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public String readUtf8(long byteCount) throws IOException {
        try {
            return this.delegate.readUtf8(byteCount);
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public SdkBufferedSource peek() throws IOException {
        try {
            return SdkIoKt.buffer(ConvertKt.toSdk(this.delegate.peek()));
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public boolean exhausted() throws IOException {
        try {
            return this.delegate.exhausted();
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public boolean request(long byteCount) throws IOException {
        try {
            return this.delegate.request(byteCount);
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public void require(long byteCount) throws IOException {
        try {
            this.delegate.require(byteCount);
            Unit unit = Unit.INSTANCE;
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSource, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.delegate.close();
            Unit unit = Unit.INSTANCE;
        } catch (EOFException e) {
            throw new EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }
}
