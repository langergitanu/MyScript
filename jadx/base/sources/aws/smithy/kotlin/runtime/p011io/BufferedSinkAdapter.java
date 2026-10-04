package aws.smithy.kotlin.runtime.p011io;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;

/* JADX INFO: compiled from: BufferedSinkAdapterJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/BufferedSinkAdapter;", "Laws/smithy/kotlin/runtime/io/AbstractBufferedSinkAdapter;", "Laws/smithy/kotlin/runtime/io/SdkBufferedSink;", "Lokio/BufferedSink;", "sink", "<init>", "(Lokio/BufferedSink;)V", "Ljava/nio/ByteBuffer;", "src", "", "write", "(Ljava/nio/ByteBuffer;)I", "", "isOpen", "()Z", "Ljava/io/OutputStream;", "outputStream", "()Ljava/io/OutputStream;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BufferedSinkAdapter extends AbstractBufferedSinkAdapter implements SdkBufferedSink {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedSinkAdapter(BufferedSink sink) {
        super(sink);
        Intrinsics.checkNotNullParameter(sink, "sink");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer src) {
        Intrinsics.checkNotNullParameter(src, "src");
        return getDelegate().write(src);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return getDelegate().isOpen();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSink
    public OutputStream outputStream() {
        return getDelegate().outputStream();
    }
}
