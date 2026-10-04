package coil.decode;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import okio.Buffer;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Source;

/* JADX INFO: compiled from: FrameDelayRewritingSource.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\tH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m1599d2 = {"Lcoil/decode/FrameDelayRewritingSource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "<init>", "(Lokio/Source;)V", "buffer", "Lokio/Buffer;", "read", "", "sink", "byteCount", "indexOf", "bytes", "Lokio/ByteString;", "write", "request", "", "Companion", "coil-gif_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class FrameDelayRewritingSource extends ForwardingSource {
    private static final int DEFAULT_FRAME_DELAY = 10;
    private static final int FRAME_DELAY_START_MARKER_SIZE_BYTES = 4;
    private static final int MINIMUM_FRAME_DELAY = 2;
    private final Buffer buffer;
    private static final Companion Companion = new Companion(null);
    private static final ByteString FRAME_DELAY_START_MARKER = ByteString.INSTANCE.decodeHex("0021F904");

    public FrameDelayRewritingSource(Source source) {
        super(source);
        this.buffer = new Buffer();
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(Buffer sink, long byteCount) throws EOFException {
        request(byteCount);
        if (this.buffer.size() == 0) {
            return byteCount == 0 ? 0L : -1L;
        }
        long jWrite = 0;
        while (true) {
            long jIndexOf = indexOf(FRAME_DELAY_START_MARKER);
            if (jIndexOf == -1) {
                break;
            }
            jWrite += write(sink, jIndexOf + ((long) 4));
            if (request(5L) && this.buffer.getByte(4L) == 0 && (((UByte.m14517constructorimpl(this.buffer.getByte(2L)) & 255) << 8) | (UByte.m14517constructorimpl(this.buffer.getByte(1L)) & 255)) < 2) {
                sink.writeByte((int) this.buffer.getByte(0L));
                sink.writeByte(10);
                sink.writeByte(0);
                this.buffer.skip(3L);
            }
        }
        if (jWrite < byteCount) {
            jWrite += write(sink, byteCount - jWrite);
        }
        if (jWrite == 0) {
            return -1L;
        }
        return jWrite;
    }

    private final long indexOf(ByteString bytes) {
        long jIndexOf = -1;
        while (true) {
            jIndexOf = this.buffer.indexOf(bytes.getByte(0), jIndexOf + 1);
            if (jIndexOf == -1 || (request(bytes.size()) && this.buffer.rangeEquals(jIndexOf, bytes))) {
                break;
            }
        }
        return jIndexOf;
    }

    private final long write(Buffer sink, long byteCount) {
        return RangesKt.coerceAtLeast(this.buffer.read(sink, byteCount), 0L);
    }

    private final boolean request(long byteCount) {
        if (this.buffer.size() >= byteCount) {
            return true;
        }
        long size = byteCount - this.buffer.size();
        return super.read(this.buffer, size) == size;
    }

    /* JADX INFO: compiled from: FrameDelayRewritingSource.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcoil/decode/FrameDelayRewritingSource$Companion;", "", "<init>", "()V", "FRAME_DELAY_START_MARKER", "Lokio/ByteString;", "FRAME_DELAY_START_MARKER_SIZE_BYTES", "", "MINIMUM_FRAME_DELAY", "DEFAULT_FRAME_DELAY", "coil-gif_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
