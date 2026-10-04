package aws.smithy.kotlin.runtime.awsprotocol.eventstream;

import aws.smithy.kotlin.runtime.InternalApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Message.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/MessageBuilder;", "", "<init>", "()V", "headers", "", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/Header;", "getHeaders", "()Ljava/util/List;", "payload", "", "getPayload", "()[B", "setPayload", "([B)V", "addHeader", "", "header", "name", "", "value", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue;", "build", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/Message;", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MessageBuilder {
    private final List<Header> headers = new ArrayList();
    private byte[] payload;

    public final List<Header> getHeaders() {
        return this.headers;
    }

    public final byte[] getPayload() {
        return this.payload;
    }

    public final void setPayload(byte[] bArr) {
        this.payload = bArr;
    }

    public final void addHeader(Header header) {
        Intrinsics.checkNotNullParameter(header, "header");
        this.headers.add(header);
    }

    public final void addHeader(String name, HeaderValue value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.headers.add(new Header(name, value));
    }

    public final Message build() {
        List<Header> list = this.headers;
        byte[] bArrEmptyByteArray = this.payload;
        if (bArrEmptyByteArray == null) {
            bArrEmptyByteArray = MessageKt.emptyByteArray();
        }
        return new Message(list, bArrEmptyByteArray);
    }
}
