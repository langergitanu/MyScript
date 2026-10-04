package aws.smithy.kotlin.runtime.content;

import aws.smithy.kotlin.runtime.content.ByteStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: StringContent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/StringContent;", "Laws/smithy/kotlin/runtime/content/ByteStream$Buffer;", "", "str", "<init>", "(Ljava/lang/String;)V", "", "bytes", "()[B", "asBytes", "[B", "", "contentLength", "J", "getContentLength", "()Ljava/lang/Long;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class StringContent extends ByteStream.Buffer {
    private final byte[] asBytes;
    private final long contentLength;

    public StringContent(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        this.asBytes = StringsKt.encodeToByteArray(str);
        this.contentLength = r3.length;
    }

    @Override // aws.smithy.kotlin.runtime.content.ByteStream
    public Long getContentLength() {
        return Long.valueOf(this.contentLength);
    }

    @Override // aws.smithy.kotlin.runtime.content.ByteStream.Buffer
    /* JADX INFO: renamed from: bytes, reason: from getter */
    public byte[] getAsBytes() {
        return this.asBytes;
    }
}
