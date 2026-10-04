package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.content.ByteStream;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpBody.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/ByteStreamSourceHttpBody;", "Laws/smithy/kotlin/runtime/http/HttpBody$SourceContent;", "Laws/smithy/kotlin/runtime/http/ByteStreamHttpBody;", "stream", "Laws/smithy/kotlin/runtime/content/ByteStream$SourceStream;", "<init>", "(Laws/smithy/kotlin/runtime/content/ByteStream$SourceStream;)V", "getStream", "()Laws/smithy/kotlin/runtime/content/ByteStream$SourceStream;", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "Ljava/lang/Long;", "isOneShot", "", "()Z", "readFrom", "Laws/smithy/kotlin/runtime/io/SdkSource;", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class ByteStreamSourceHttpBody extends HttpBody.SourceContent implements ByteStreamHttpBody {
    private final Long contentLength;
    private final boolean isOneShot;
    private final ByteStream.SourceStream stream;

    public ByteStreamSourceHttpBody(ByteStream.SourceStream stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        this.stream = stream;
        this.contentLength = getStream().getContentLength();
        this.isOneShot = getStream().getIsOneShot();
    }

    @Override // aws.smithy.kotlin.runtime.http.ByteStreamHttpBody
    public ByteStream.SourceStream getStream() {
        return this.stream;
    }

    @Override // aws.smithy.kotlin.runtime.http.HttpBody
    public Long getContentLength() {
        return this.contentLength;
    }

    @Override // aws.smithy.kotlin.runtime.http.HttpBody
    /* JADX INFO: renamed from: isOneShot, reason: from getter */
    public boolean getIsOneShot() {
        return this.isOneShot;
    }

    @Override // aws.smithy.kotlin.runtime.http.HttpBody.SourceContent
    public SdkSource readFrom() {
        return getStream().readFrom();
    }
}
