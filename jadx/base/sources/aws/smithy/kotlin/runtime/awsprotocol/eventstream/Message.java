package aws.smithy.kotlin.runtime.awsprotocol.eventstream;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.hashing.Crc32;
import aws.smithy.kotlin.runtime.p011io.HashingSink;
import aws.smithy.kotlin.runtime.p011io.HashingSource;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkBufferedSink;
import aws.smithy.kotlin.runtime.p011io.SdkBufferedSource;
import aws.smithy.kotlin.runtime.p011io.SdkIoKt;
import aws.smithy.kotlin.runtime.p011io.SdkSourceKt;
import aws.smithy.kotlin.runtime.text.encoding.HexKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Message.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J#\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/Message;", "", "headers", "", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/Header;", "payload", "", "<init>", "(Ljava/util/List;[B)V", "getHeaders", "()Ljava/util/List;", "getPayload", "()[B", "equals", "", "other", "hashCode", "", "encode", "", "dest", "Laws/smithy/kotlin/runtime/io/SdkBufferedSink;", "component1", "component2", "copy", "toString", "", "Companion", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class Message {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Header> headers;
    private final byte[] payload;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Message copy$default(Message message, List list, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            list = message.headers;
        }
        if ((i & 2) != 0) {
            bArr = message.payload;
        }
        return message.copy(list, bArr);
    }

    public final List<Header> component1() {
        return this.headers;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final byte[] getPayload() {
        return this.payload;
    }

    public final Message copy(List<Header> headers, byte[] payload) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(payload, "payload");
        return new Message(headers, payload);
    }

    public String toString() {
        return "Message(headers=" + this.headers + ", payload=" + Arrays.toString(this.payload) + ')';
    }

    public Message(List<Header> headers, byte[] payload) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.headers = headers;
        this.payload = payload;
    }

    /* JADX INFO: compiled from: Message.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/Message$Companion;", "", "<init>", "()V", "decode", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/Message;", FirebaseAnalytics.Param.SOURCE, "Laws/smithy/kotlin/runtime/io/SdkBufferedSource;", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Message decode(SdkBufferedSource source) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            SdkBufferedSource sdkBufferedSourcePeek = source.peek();
            try {
                int iM14594constructorimpl = UInt.m14594constructorimpl(sdkBufferedSourcePeek.readInt());
                sdkBufferedSourcePeek.close();
                if (Integer.compareUnsigned(iM14594constructorimpl, UInt.m14594constructorimpl(MessageKt.MAX_MESSAGE_SIZE)) > 0) {
                    throw new IllegalStateException(("Invalid Message size: " + ((Object) UInt.m14640toStringimpl(iM14594constructorimpl))).toString());
                }
                SdkBuffer sdkBuffer = new SdkBuffer();
                HashingSource hashingSource = new HashingSource(new Crc32(), source);
                SdkSourceKt.readFully(hashingSource, sdkBuffer, (((long) iM14594constructorimpl) & 4294967295L) - 4);
                byte[] bArrDigest = hashingSource.digest();
                SdkBuffer sdkBuffer2 = sdkBuffer;
                Prelude preludeDecode = Prelude.INSTANCE.decode(sdkBuffer2);
                int totalLen = preludeDecode.getTotalLen() - 16;
                if (!sdkBuffer.request(totalLen)) {
                    throw new IllegalStateException(("Invalid buffer, not enough remaining; have: " + sdkBuffer.getSize() + "; expected " + totalLen).toString());
                }
                MessageBuilder messageBuilder = new MessageBuilder();
                long size = 0;
                while (size < preludeDecode.getHeadersLength()) {
                    long size2 = sdkBuffer.getBuffer().getSize();
                    Header headerDecode = Header.INSTANCE.decode(sdkBuffer2);
                    size += size2 - sdkBuffer.getBuffer().getSize();
                    messageBuilder.addHeader(headerDecode);
                }
                if (size != preludeDecode.getHeadersLength()) {
                    throw new IllegalStateException(("Invalid Message: expected " + preludeDecode.getHeadersLength() + " header bytes; consumed " + size).toString());
                }
                messageBuilder.setPayload(sdkBuffer.readByteArray(preludeDecode.getPayloadLen()));
                byte[] byteArray = source.readByteArray(4L);
                if (!Arrays.equals(bArrDigest, byteArray)) {
                    throw new IllegalStateException(("Message checksum mismatch; expected=0x" + HexKt.encodeToHex(byteArray) + "; calculated=0x" + HexKt.encodeToHex(bArrDigest)).toString());
                }
                return messageBuilder.build();
            } catch (Throwable th) {
                try {
                    sdkBufferedSourcePeek.close();
                } catch (Throwable th2) {
                    ExceptionsKt.addSuppressed(th, th2);
                }
                throw th;
            }
        }
    }

    public final List<Header> getHeaders() {
        return this.headers;
    }

    public final byte[] getPayload() {
        return this.payload;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Message message = (Message) other;
        return Intrinsics.areEqual(this.headers, message.headers) && Arrays.equals(this.payload, message.payload);
    }

    public int hashCode() {
        return (this.headers.hashCode() * 31) + Arrays.hashCode(this.payload);
    }

    public final void encode(SdkBufferedSink dest) throws IOException {
        Intrinsics.checkNotNullParameter(dest, "dest");
        SdkBuffer sdkBuffer = new SdkBuffer();
        Iterator<T> it = this.headers.iterator();
        while (it.hasNext()) {
            ((Header) it.next()).encode(sdkBuffer);
        }
        long size = sdkBuffer.getSize();
        long length = ((long) 12) + size + ((long) this.payload.length) + ((long) 4);
        if (size >= 131072) {
            throw new IllegalStateException(("Invalid Headers length: " + size).toString());
        }
        if (length >= 25165824) {
            throw new IllegalStateException(("Invalid Message length: " + length).toString());
        }
        Prelude prelude = new Prelude((int) length, (int) size);
        HashingSink hashingSink = new HashingSink(new Crc32(), dest);
        SdkBufferedSink sdkBufferedSinkBuffer = SdkIoKt.buffer(hashingSink);
        prelude.encode(sdkBufferedSinkBuffer);
        sdkBufferedSinkBuffer.write(sdkBuffer, sdkBuffer.getSize());
        SdkBufferedSink.write$default(sdkBufferedSinkBuffer, this.payload, 0, 0, 6, null);
        sdkBufferedSinkBuffer.emit();
        SdkBufferedSink.write$default(dest, hashingSink.digest(), 0, 0, 6, null);
    }
}
