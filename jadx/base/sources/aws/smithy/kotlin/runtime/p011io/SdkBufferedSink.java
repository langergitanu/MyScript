package aws.smithy.kotlin.runtime.p011io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;

/* JADX INFO: compiled from: SdkBufferedSinkJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\fH&¢\u0006\u0004\b\t\u0010\u0010J+\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0005H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001bH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001bH&¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0005H&¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0005H&¢\u0006\u0004\b!\u0010 J\u0017\u0010\"\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\fH&¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\fH&¢\u0006\u0004\b$\u0010#J\u000f\u0010&\u001a\u00020%H&¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\bH&¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\bH&¢\u0006\u0004\b*\u0010)R\u0014\u0010.\u001a\u00020+8&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-\u0082\u0001\u0003/0+¨\u00061À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/SdkBufferedSink;", "Laws/smithy/kotlin/runtime/io/SdkSink;", "Ljava/nio/channels/WritableByteChannel;", "", FirebaseAnalytics.Param.SOURCE, "", TypedValues.CycleType.S_WAVE_OFFSET, "limit", "", "write", "([BII)V", "Laws/smithy/kotlin/runtime/io/SdkSource;", "", "writeAll", "(Laws/smithy/kotlin/runtime/io/SdkSource;)J", "byteCount", "(Laws/smithy/kotlin/runtime/io/SdkSource;J)V", "", TypedValues.Custom.S_STRING, TtmlNode.START, "endExclusive", "writeUtf8", "(Ljava/lang/String;II)V", "", "x", "writeByte", "(B)V", "", "writeShort", "(S)V", "writeShortLe", "writeInt", "(I)V", "writeIntLe", "writeLong", "(J)V", "writeLongLe", "Ljava/io/OutputStream;", "outputStream", "()Ljava/io/OutputStream;", "flush", "()V", "emit", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "getBuffer", "()Laws/smithy/kotlin/runtime/io/SdkBuffer;", "buffer", "Laws/smithy/kotlin/runtime/io/AbstractBufferedSinkAdapter;", "Laws/smithy/kotlin/runtime/io/BufferedSinkAdapter;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface SdkBufferedSink extends SdkSink, WritableByteChannel {
    void emit() throws IOException;

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSink
    void flush() throws IOException;

    SdkBuffer getBuffer();

    OutputStream outputStream();

    void write(SdkSource source, long byteCount) throws IOException;

    void write(byte[] source, int offset, int limit) throws IOException;

    long writeAll(SdkSource source) throws IOException;

    void writeByte(byte x) throws IOException;

    void writeInt(int x) throws IOException;

    void writeIntLe(int x) throws IOException;

    void writeLong(long x) throws IOException;

    void writeLongLe(long x) throws IOException;

    void writeShort(short x) throws IOException;

    void writeShortLe(short x) throws IOException;

    void writeUtf8(String string, int start, int endExclusive) throws IOException;

    static /* synthetic */ void write$default(SdkBufferedSink sdkBufferedSink, byte[] bArr, int i, int i2, int i3, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        sdkBufferedSink.write(bArr, i, i2);
    }

    /* JADX INFO: compiled from: SdkBufferedSinkJVM.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void writeUtf8$default(SdkBufferedSink sdkBufferedSink, String str, int i, int i2, int i3, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeUtf8");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        sdkBufferedSink.writeUtf8(str, i, i2);
    }
}
