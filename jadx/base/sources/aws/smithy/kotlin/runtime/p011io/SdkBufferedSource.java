package aws.smithy.kotlin.runtime.p011io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import kotlin.Metadata;

/* JADX INFO: compiled from: SdkBufferedSourceJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0003H&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H&¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H&¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u0012H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001aH&¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u001f\u0010!J\u000f\u0010#\u001a\u00020\"H&¢\u0006\u0004\b#\u0010$J\u0017\u0010#\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b#\u0010%J\u000f\u0010'\u001a\u00020&H&¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0000H&¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H&¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020+2\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b0\u0010\u0007R\u0014\u00104\u001a\u0002018&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103\u0082\u0001\u0003561¨\u00067À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/SdkBufferedSource;", "Laws/smithy/kotlin/runtime/io/SdkSource;", "Ljava/nio/channels/ReadableByteChannel;", "", "byteCount", "", "skip", "(J)V", "", "readByte", "()B", "", "readShort", "()S", "readShortLe", "readLong", "()J", "readLongLe", "", "readInt", "()I", "readIntLe", "Laws/smithy/kotlin/runtime/io/SdkSink;", "sink", "readAll", "(Laws/smithy/kotlin/runtime/io/SdkSink;)J", "", TypedValues.CycleType.S_WAVE_OFFSET, "limit", "read", "([BII)I", "readByteArray", "()[B", "(J)[B", "", "readUtf8", "()Ljava/lang/String;", "(J)Ljava/lang/String;", "Ljava/io/InputStream;", "inputStream", "()Ljava/io/InputStream;", "peek", "()Laws/smithy/kotlin/runtime/io/SdkBufferedSource;", "", "exhausted", "()Z", "request", "(J)Z", "require", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "getBuffer", "()Laws/smithy/kotlin/runtime/io/SdkBuffer;", "buffer", "Laws/smithy/kotlin/runtime/io/AbstractBufferedSourceAdapter;", "Laws/smithy/kotlin/runtime/io/BufferedSourceAdapter;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface SdkBufferedSource extends SdkSource, ReadableByteChannel {
    boolean exhausted();

    SdkBuffer getBuffer();

    InputStream inputStream();

    SdkBufferedSource peek();

    int read(byte[] sink, int offset, int limit) throws IOException;

    long readAll(SdkSink sink) throws IOException;

    byte readByte() throws IOException;

    byte[] readByteArray() throws IOException;

    byte[] readByteArray(long byteCount) throws IOException;

    int readInt() throws IOException;

    int readIntLe() throws IOException;

    long readLong() throws IOException;

    long readLongLe() throws IOException;

    short readShort() throws IOException;

    short readShortLe() throws IOException;

    String readUtf8() throws IOException;

    String readUtf8(long byteCount) throws IOException;

    boolean request(long byteCount) throws IOException;

    void require(long byteCount) throws IOException;

    void skip(long byteCount) throws IOException;

    static /* synthetic */ int read$default(SdkBufferedSource sdkBufferedSource, byte[] bArr, int i, int i2, int i3, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: read");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        return sdkBufferedSource.read(bArr, i, i2);
    }

    /* JADX INFO: compiled from: SdkBufferedSourceJVM.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }
}
