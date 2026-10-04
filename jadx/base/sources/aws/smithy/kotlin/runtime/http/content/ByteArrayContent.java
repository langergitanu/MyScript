package aws.smithy.kotlin.runtime.http.content;

import aws.smithy.kotlin.runtime.http.HttpBody;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ByteArrayContent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0002\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/content/ByteArrayContent;", "Laws/smithy/kotlin/runtime/http/HttpBody$Bytes;", "bytes", "", "<init>", "([B)V", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ByteArrayContent extends HttpBody.Bytes {
    private final byte[] bytes;
    private final long contentLength;

    public ByteArrayContent(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.bytes = bytes;
        this.contentLength = bytes.length;
    }

    @Override // aws.smithy.kotlin.runtime.http.HttpBody
    public Long getContentLength() {
        return Long.valueOf(this.contentLength);
    }

    @Override // aws.smithy.kotlin.runtime.http.HttpBody.Bytes
    /* JADX INFO: renamed from: bytes, reason: from getter */
    public byte[] getBytes() {
        return this.bytes;
    }
}
