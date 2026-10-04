package aws.smithy.kotlin.runtime.p011io;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;

/* JADX INFO: compiled from: BufferedSourceAdapterJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/BufferedSourceAdapter;", "Laws/smithy/kotlin/runtime/io/AbstractBufferedSourceAdapter;", "Laws/smithy/kotlin/runtime/io/SdkBufferedSource;", "Lokio/BufferedSource;", FirebaseAnalytics.Param.SOURCE, "<init>", "(Lokio/BufferedSource;)V", "Ljava/nio/ByteBuffer;", "dst", "", "read", "(Ljava/nio/ByteBuffer;)I", "", "isOpen", "()Z", "Ljava/io/InputStream;", "inputStream", "()Ljava/io/InputStream;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BufferedSourceAdapter extends AbstractBufferedSourceAdapter implements SdkBufferedSource {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedSourceAdapter(BufferedSource source) {
        super(source);
        Intrinsics.checkNotNullParameter(source, "source");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer dst) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        return getDelegate().read(dst);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return getDelegate().isOpen();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkBufferedSource
    public InputStream inputStream() {
        return getDelegate().inputStream();
    }
}
