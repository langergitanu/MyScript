package aws.smithy.kotlin.runtime.p011io.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkBufferedSource;
import aws.smithy.kotlin.runtime.p011io.SdkIoKt;
import aws.smithy.kotlin.runtime.p011io.SdkSink;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BufferOperations.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\u001a6\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\b\u0003H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\n\u001a\u00020\t*\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0080\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0014\u0010\r\u001a\u00020\f*\u00020\u0001H\u0080\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\u0010\u001a\u00020\u000f*\u00020\u0001H\u0080\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0014\u0010\u0012\u001a\u00020\u000f*\u00020\u0001H\u0080\b¢\u0006\u0004\b\u0012\u0010\u0011\u001a\u0014\u0010\u0013\u001a\u00020\u0007*\u00020\u0001H\u0080\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0007*\u00020\u0001H\u0080\b¢\u0006\u0004\b\u0015\u0010\u0014\u001a\u0014\u0010\u0017\u001a\u00020\u0016*\u00020\u0001H\u0080\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0014\u0010\u0019\u001a\u00020\u0016*\u00020\u0001H\u0080\b¢\u0006\u0004\b\u0019\u0010\u0018\u001a\u001c\u0010\u001c\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001aH\u0080\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a,\u0010!\u001a\u00020\u0016*\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0016H\u0080\b¢\u0006\u0004\b!\u0010\"\u001a$\u0010!\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u0007H\u0080\b¢\u0006\u0004\b!\u0010#\u001a\u0014\u0010$\u001a\u00020\u001e*\u00020\u0001H\u0080\b¢\u0006\u0004\b$\u0010%\u001a\u001c\u0010$\u001a\u00020\u001e*\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0080\b¢\u0006\u0004\b$\u0010&\u001a\u0014\u0010(\u001a\u00020'*\u00020\u0001H\u0080\b¢\u0006\u0004\b(\u0010)\u001a\u001c\u0010(\u001a\u00020'*\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0080\b¢\u0006\u0004\b(\u0010*\u001a\u0014\u0010,\u001a\u00020+*\u00020\u0001H\u0080\b¢\u0006\u0004\b,\u0010-\u001a\u0014\u0010/\u001a\u00020.*\u00020\u0001H\u0080\b¢\u0006\u0004\b/\u00100\u001a\u001c\u00101\u001a\u00020.*\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0080\b¢\u0006\u0004\b1\u00102\u001a\u001c\u00103\u001a\u00020\t*\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0080\b¢\u0006\u0004\b3\u0010\u000b\u001a,\u00105\u001a\u00020\t*\u00020\u00012\u0006\u00104\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0016H\u0080\b¢\u0006\u0004\b5\u00106\u001a$\u00105\u001a\u00020\t*\u00020\u00012\u0006\u00104\u001a\u0002072\u0006\u0010\b\u001a\u00020\u0007H\u0080\b¢\u0006\u0004\b5\u00108\u001a$\u00105\u001a\u00020\t*\u00020\u00012\u0006\u00104\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0080\b¢\u0006\u0004\b5\u00109\u001a\u001c\u0010:\u001a\u00020\u0007*\u00020\u00012\u0006\u00104\u001a\u000207H\u0080\b¢\u0006\u0004\b:\u0010;\u001a,\u0010?\u001a\u00020\t*\u00020\u00012\u0006\u0010<\u001a\u00020'2\u0006\u0010=\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\u0016H\u0080\b¢\u0006\u0004\b?\u0010@\u001a\u001c\u0010B\u001a\u00020\t*\u00020\u00012\u0006\u0010A\u001a\u00020\fH\u0080\b¢\u0006\u0004\bB\u0010C\u001a\u001c\u0010D\u001a\u00020\t*\u00020\u00012\u0006\u0010A\u001a\u00020\u000fH\u0080\b¢\u0006\u0004\bD\u0010E\u001a\u001c\u0010F\u001a\u00020\t*\u00020\u00012\u0006\u0010A\u001a\u00020\u000fH\u0080\b¢\u0006\u0004\bF\u0010E\u001a\u001c\u0010G\u001a\u00020\t*\u00020\u00012\u0006\u0010A\u001a\u00020\u0016H\u0080\b¢\u0006\u0004\bG\u0010H\u001a\u001c\u0010I\u001a\u00020\t*\u00020\u00012\u0006\u0010A\u001a\u00020\u0016H\u0080\b¢\u0006\u0004\bI\u0010H\u001a\u001c\u0010J\u001a\u00020\t*\u00020\u00012\u0006\u0010A\u001a\u00020\u0007H\u0080\b¢\u0006\u0004\bJ\u0010\u000b\u001a\u001c\u0010K\u001a\u00020\t*\u00020\u00012\u0006\u0010A\u001a\u00020\u0007H\u0080\b¢\u0006\u0004\bK\u0010\u000b\u001a\u0014\u0010L\u001a\u00020\t*\u00020\u0001H\u0080\b¢\u0006\u0004\bL\u0010M\u001a\u0014\u0010N\u001a\u00020\t*\u00020\u0001H\u0080\b¢\u0006\u0004\bN\u0010M\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006O"}, m1599d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "wrapOkio", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "byteCount", "", "commonSkip", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;J)V", "", "commonReadByte", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;)B", "", "commonReadShort", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;)S", "commonReadShortLe", "commonReadLong", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;)J", "commonReadLongLe", "", "commonReadInt", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;)I", "commonReadIntLe", "Laws/smithy/kotlin/runtime/io/SdkSink;", "sink", "commonReadAll", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;Laws/smithy/kotlin/runtime/io/SdkSink;)J", "", TypedValues.CycleType.S_WAVE_OFFSET, "limit", "commonRead", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;[BII)I", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;Laws/smithy/kotlin/runtime/io/SdkBuffer;J)J", "commonReadByteArray", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;)[B", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;J)[B", "", "commonReadUtf8", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;)Ljava/lang/String;", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;J)Ljava/lang/String;", "Laws/smithy/kotlin/runtime/io/SdkBufferedSource;", "commonPeek", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;)Laws/smithy/kotlin/runtime/io/SdkBufferedSource;", "", "commonExhausted", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;)Z", "commonRequest", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;J)Z", "commonRequire", FirebaseAnalytics.Param.SOURCE, "commonWrite", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;[BII)V", "Laws/smithy/kotlin/runtime/io/SdkSource;", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;Laws/smithy/kotlin/runtime/io/SdkSource;J)V", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;Laws/smithy/kotlin/runtime/io/SdkBuffer;J)V", "commonWriteAll", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;Laws/smithy/kotlin/runtime/io/SdkSource;)J", TypedValues.Custom.S_STRING, TtmlNode.START, "endExclusive", "commonWriteUtf8", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;Ljava/lang/String;II)V", "x", "commonWriteByte", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;B)V", "commonWriteShort", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;S)V", "commonWriteShortLe", "commonWriteInt", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;I)V", "commonWriteIntLe", "commonWriteLong", "commonWriteLongLe", "commonFlush", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;)V", "commonClose", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BufferOperationsKt {
    public static final <T> T wrapOkio(SdkBuffer sdkBuffer, Function1<? super SdkBuffer, ? extends T> block) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return block.invoke(sdkBuffer);
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final void commonSkip(SdkBuffer sdkBuffer, long j) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            sdkBuffer.getInner().skip(j);
            Unit unit = Unit.INSTANCE;
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final byte commonReadByte(SdkBuffer sdkBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            return sdkBuffer.getInner().readByte();
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final short commonReadShort(SdkBuffer sdkBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            return sdkBuffer.getInner().readShort();
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final short commonReadShortLe(SdkBuffer sdkBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            return sdkBuffer.getInner().readShortLe();
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final long commonReadLong(SdkBuffer sdkBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            return sdkBuffer.getInner().readLong();
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final long commonReadLongLe(SdkBuffer sdkBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            return sdkBuffer.getInner().readLongLe();
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final int commonReadInt(SdkBuffer sdkBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            return sdkBuffer.getInner().readInt();
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final int commonReadIntLe(SdkBuffer sdkBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            return sdkBuffer.getInner().readIntLe();
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final long commonReadAll(SdkBuffer sdkBuffer, SdkSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            return sdkBuffer.getInner().readAll(ConvertKt.toOkio(sink));
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final int commonRead(SdkBuffer sdkBuffer, byte[] sink, int i, int i2) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            return sdkBuffer.getInner().read(sink, i, i2);
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final long commonRead(SdkBuffer sdkBuffer, SdkBuffer sink, long j) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            return sdkBuffer.getInner().read(sink.getInner(), j);
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final byte[] commonReadByteArray(SdkBuffer sdkBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            return sdkBuffer.getInner().readByteArray();
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final byte[] commonReadByteArray(SdkBuffer sdkBuffer, long j) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            return sdkBuffer.getInner().readByteArray(j);
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final String commonReadUtf8(SdkBuffer sdkBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            return sdkBuffer.getInner().readUtf8();
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final String commonReadUtf8(SdkBuffer sdkBuffer, long j) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            return sdkBuffer.getInner().readUtf8(j);
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final SdkBufferedSource commonPeek(SdkBuffer sdkBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            return SdkIoKt.buffer(ConvertKt.toSdk(sdkBuffer.getInner().peek()));
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final boolean commonExhausted(SdkBuffer sdkBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            return sdkBuffer.getInner().exhausted();
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final boolean commonRequest(SdkBuffer sdkBuffer, long j) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            return sdkBuffer.getInner().request(j);
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final void commonRequire(SdkBuffer sdkBuffer, long j) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            sdkBuffer.getInner().require(j);
            Unit unit = Unit.INSTANCE;
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final void commonWrite(SdkBuffer sdkBuffer, byte[] source, int i, int i2) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            sdkBuffer.getInner().write(source, i, i2);
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final void commonWrite(SdkBuffer sdkBuffer, SdkSource source, long j) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            sdkBuffer.getInner().write(ConvertKt.toOkio(source), j);
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final void commonWrite(SdkBuffer sdkBuffer, SdkBuffer source, long j) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            sdkBuffer.getInner().write(ConvertKt.toOkio(source), j);
            Unit unit = Unit.INSTANCE;
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final long commonWriteAll(SdkBuffer sdkBuffer, SdkSource source) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            return sdkBuffer.getInner().writeAll(ConvertKt.toOkio(source));
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final void commonWriteUtf8(SdkBuffer sdkBuffer, String string, int i, int i2) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        try {
            sdkBuffer.getInner().writeUtf8(string, i, i2);
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final void commonWriteByte(SdkBuffer sdkBuffer, byte b) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            sdkBuffer.getInner().writeByte((int) b);
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final void commonWriteShort(SdkBuffer sdkBuffer, short s) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            sdkBuffer.getInner().writeShort((int) s);
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final void commonWriteShortLe(SdkBuffer sdkBuffer, short s) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            sdkBuffer.getInner().writeShortLe((int) s);
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final void commonWriteInt(SdkBuffer sdkBuffer, int i) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            sdkBuffer.getInner().writeInt(i);
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final void commonWriteIntLe(SdkBuffer sdkBuffer, int i) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            sdkBuffer.getInner().writeIntLe(i);
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final void commonWriteLong(SdkBuffer sdkBuffer, long j) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            sdkBuffer.getInner().writeLong(j);
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final void commonWriteLongLe(SdkBuffer sdkBuffer, long j) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            sdkBuffer.getInner().writeLongLe(j);
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final void commonFlush(SdkBuffer sdkBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            sdkBuffer.getInner().flush();
            Unit unit = Unit.INSTANCE;
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }

    public static final void commonClose(SdkBuffer sdkBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        try {
            sdkBuffer.getInner().close();
            Unit unit = Unit.INSTANCE;
        } catch (EOFException e) {
            throw new aws.smithy.kotlin.runtime.p011io.EOFException("Okio operation failed: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new IOException("Okio operation failed: " + e2.getMessage(), e2);
        }
    }
}
