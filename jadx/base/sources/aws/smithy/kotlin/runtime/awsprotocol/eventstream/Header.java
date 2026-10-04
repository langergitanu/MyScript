package aws.smithy.kotlin.runtime.awsprotocol.eventstream;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.p011io.SdkBufferedSink;
import aws.smithy.kotlin.runtime.p011io.SdkBufferedSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Header.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/Header;", "", "name", "", "value", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue;", "<init>", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue;)V", "getName", "()Ljava/lang/String;", "getValue", "()Laws/smithy/kotlin/runtime/awsprotocol/eventstream/HeaderValue;", "encode", "", "dest", "Laws/smithy/kotlin/runtime/io/SdkBufferedSink;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class Header {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String name;
    private final HeaderValue value;

    public static /* synthetic */ Header copy$default(Header header, String str, HeaderValue headerValue, int i, Object obj) {
        if ((i & 1) != 0) {
            str = header.name;
        }
        if ((i & 2) != 0) {
            headerValue = header.value;
        }
        return header.copy(str, headerValue);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final HeaderValue getValue() {
        return this.value;
    }

    public final Header copy(String name, HeaderValue value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return new Header(name, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Header)) {
            return false;
        }
        Header header = (Header) other;
        return Intrinsics.areEqual(this.name, header.name) && Intrinsics.areEqual(this.value, header.value);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "Header(name=" + this.name + ", value=" + this.value + ')';
    }

    public Header(String name, HeaderValue value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.name = name;
        this.value = value;
    }

    /* JADX INFO: compiled from: Header.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/eventstream/Header$Companion;", "", "<init>", "()V", "decode", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/Header;", FirebaseAnalytics.Param.SOURCE, "Laws/smithy/kotlin/runtime/io/SdkBufferedSource;", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Header decode(SdkBufferedSource source) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            if (!source.request(2L)) {
                throw new IllegalStateException("Invalid frame header; require at least 2 bytes".toString());
            }
            byte b = source.readByte();
            if (b <= 0) {
                throw new IllegalStateException(("Invalid header name length: " + ((int) b)).toString());
            }
            long j = b;
            if (!source.request(j)) {
                throw new IllegalStateException(("Not enough bytes to read header name; needed: " + ((int) b) + "; remaining: " + source.getBuffer().getSize()).toString());
            }
            return new Header(source.readUtf8(j), HeaderValue.INSTANCE.decode(source));
        }
    }

    public final String getName() {
        return this.name;
    }

    public final HeaderValue getValue() {
        return this.value;
    }

    public final void encode(SdkBufferedSink dest) throws IOException {
        Intrinsics.checkNotNullParameter(dest, "dest");
        byte[] bArrEncodeToByteArray = StringsKt.encodeToByteArray(this.name);
        if (bArrEncodeToByteArray.length >= 255) {
            throw new IllegalStateException("Header name too long".toString());
        }
        dest.writeByte((byte) bArrEncodeToByteArray.length);
        SdkBufferedSink.write$default(dest, bArrEncodeToByteArray, 0, 0, 6, null);
        this.value.encode(dest);
    }
}
