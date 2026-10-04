package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.content.ByteStream;
import aws.smithy.kotlin.runtime.http.HttpBody;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpBody.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/ByteStreamBufferHttpBody;", "Laws/smithy/kotlin/runtime/http/HttpBody$Bytes;", "Laws/smithy/kotlin/runtime/http/ByteStreamHttpBody;", "stream", "Laws/smithy/kotlin/runtime/content/ByteStream$Buffer;", "<init>", "(Laws/smithy/kotlin/runtime/content/ByteStream$Buffer;)V", "getStream", "()Laws/smithy/kotlin/runtime/content/ByteStream$Buffer;", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "Ljava/lang/Long;", "bytes", "", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class ByteStreamBufferHttpBody extends HttpBody.Bytes implements ByteStreamHttpBody {
    private final Long contentLength;
    private final ByteStream.Buffer stream;

    public ByteStreamBufferHttpBody(ByteStream.Buffer stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        this.stream = stream;
        this.contentLength = getStream().getContentLength();
    }

    @Override // aws.smithy.kotlin.runtime.http.ByteStreamHttpBody
    public ByteStream.Buffer getStream() {
        return this.stream;
    }

    @Override // aws.smithy.kotlin.runtime.http.HttpBody
    public Long getContentLength() {
        return this.contentLength;
    }

    @Override // aws.smithy.kotlin.runtime.http.HttpBody.Bytes
    /* JADX INFO: renamed from: bytes */
    public byte[] getBytes() {
        return getStream().getAsBytes();
    }
}
