package aws.smithy.kotlin.runtime.content;

import aws.smithy.kotlin.runtime.content.ByteStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ByteArrayContent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/ByteArrayContent;", "Laws/smithy/kotlin/runtime/content/ByteStream$Buffer;", "", "bytes", "<init>", "([B)V", "()[B", "[B", "", "contentLength", "J", "getContentLength", "()Ljava/lang/Long;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ByteArrayContent extends ByteStream.Buffer {
    private final byte[] bytes;
    private final long contentLength;

    public ByteArrayContent(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.bytes = bytes;
        this.contentLength = bytes.length;
    }

    @Override // aws.smithy.kotlin.runtime.content.ByteStream
    public Long getContentLength() {
        return Long.valueOf(this.contentLength);
    }

    @Override // aws.smithy.kotlin.runtime.content.ByteStream.Buffer
    /* JADX INFO: renamed from: bytes, reason: from getter */
    public byte[] getAsBytes() {
        return this.bytes;
    }
}
