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
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Prelude.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\u001a"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/Prelude;", "", "totalLen", "", "headersLength", "<init>", "(II)V", "getTotalLen", "()I", "getHeadersLength", "payloadLen", "getPayloadLen", "encode", "", "dest", "Laws/smithy/kotlin/runtime/io/SdkBufferedSink;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class Prelude {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int headersLength;
    private final int totalLen;

    public static /* synthetic */ Prelude copy$default(Prelude prelude, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = prelude.totalLen;
        }
        if ((i3 & 2) != 0) {
            i2 = prelude.headersLength;
        }
        return prelude.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTotalLen() {
        return this.totalLen;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getHeadersLength() {
        return this.headersLength;
    }

    public final Prelude copy(int totalLen, int headersLength) {
        return new Prelude(totalLen, headersLength);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Prelude)) {
            return false;
        }
        Prelude prelude = (Prelude) other;
        return this.totalLen == prelude.totalLen && this.headersLength == prelude.headersLength;
    }

    public int hashCode() {
        return (Integer.hashCode(this.totalLen) * 31) + Integer.hashCode(this.headersLength);
    }

    public String toString() {
        return "Prelude(totalLen=" + this.totalLen + ", headersLength=" + this.headersLength + ')';
    }

    public Prelude(int i, int i2) {
        this.totalLen = i;
        this.headersLength = i2;
    }

    public final int getHeadersLength() {
        return this.headersLength;
    }

    public final int getTotalLen() {
        return this.totalLen;
    }

    public final int getPayloadLen() {
        return ((this.totalLen - 12) - this.headersLength) - 4;
    }

    public final void encode(SdkBufferedSink dest) throws IOException {
        Intrinsics.checkNotNullParameter(dest, "dest");
        HashingSink hashingSink = new HashingSink(new Crc32(), dest);
        SdkBufferedSink sdkBufferedSinkBuffer = SdkIoKt.buffer(hashingSink);
        sdkBufferedSinkBuffer.writeInt(this.totalLen);
        sdkBufferedSinkBuffer.writeInt(this.headersLength);
        sdkBufferedSinkBuffer.emit();
        SdkBufferedSink.write$default(dest, hashingSink.digest(), 0, 0, 6, null);
    }

    /* JADX INFO: compiled from: Prelude.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/Prelude$Companion;", "", "<init>", "()V", "decode", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/Prelude;", FirebaseAnalytics.Param.SOURCE, "Laws/smithy/kotlin/runtime/io/SdkBufferedSource;", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Prelude decode(SdkBufferedSource source) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            if (!source.request(12L)) {
                throw new IllegalStateException("Invalid message prelude".toString());
            }
            HashingSource hashingSource = new HashingSource(new Crc32(), source);
            SdkBuffer sdkBuffer = new SdkBuffer();
            SdkSourceKt.readFully(hashingSource, sdkBuffer, 8L);
            byte[] byteArray = source.readByteArray(4L);
            byte[] bArrDigest = hashingSource.digest();
            int i = sdkBuffer.readInt();
            int i2 = sdkBuffer.readInt();
            if (i > 25165824) {
                throw new IllegalStateException(("Invalid Message size: " + i).toString());
            }
            if (i2 > 131072) {
                throw new IllegalStateException(("Invalid Header size: " + i2).toString());
            }
            if (!Arrays.equals(byteArray, bArrDigest)) {
                throw new IllegalStateException(("Prelude checksum mismatch; expected=0x" + HexKt.encodeToHex(byteArray) + "; calculated=0x" + HexKt.encodeToHex(bArrDigest)).toString());
            }
            return new Prelude(i, i2);
        }
    }
}
