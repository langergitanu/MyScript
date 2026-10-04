package aws.smithy.kotlin.runtime.content;

import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ByteStream.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \r2\u00020\u0001:\u0004\u000e\u000f\u0010\rB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u0082\u0001\u0003\u0011\u0012\u0013¨\u0006\u0014"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/ByteStream;", "", "<init>", "()V", "", "contentLength", "Ljava/lang/Long;", "getContentLength", "()Ljava/lang/Long;", "", "isOneShot", "Z", "()Z", "Companion", "Buffer", "ChannelStream", "SourceStream", "Laws/smithy/kotlin/runtime/content/ByteStream$Buffer;", "Laws/smithy/kotlin/runtime/content/ByteStream$ChannelStream;", "Laws/smithy/kotlin/runtime/content/ByteStream$SourceStream;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class ByteStream {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Long contentLength;
    private final boolean isOneShot;

    public /* synthetic */ ByteStream(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ByteStream() {
        this.isOneShot = true;
    }

    public Long getContentLength() {
        return this.contentLength;
    }

    /* JADX INFO: renamed from: isOneShot, reason: from getter */
    public boolean getIsOneShot() {
        return this.isOneShot;
    }

    /* JADX INFO: compiled from: ByteStream.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0086D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n¨\u0006\u000b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/ByteStream$Buffer;", "Laws/smithy/kotlin/runtime/content/ByteStream;", "<init>", "()V", "", "bytes", "()[B", "", "isOneShot", "Z", "()Z", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class Buffer extends ByteStream {
        private final boolean isOneShot;

        /* JADX INFO: renamed from: bytes */
        public abstract byte[] getAsBytes();

        public Buffer() {
            super(null);
        }

        @Override // aws.smithy.kotlin.runtime.content.ByteStream
        /* JADX INFO: renamed from: isOneShot, reason: from getter */
        public final boolean getIsOneShot() {
            return this.isOneShot;
        }
    }

    /* JADX INFO: compiled from: ByteStream.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/ByteStream$ChannelStream;", "Laws/smithy/kotlin/runtime/content/ByteStream;", "<init>", "()V", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "readFrom", "()Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class ChannelStream extends ByteStream {
        public abstract SdkByteReadChannel readFrom();

        public ChannelStream() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: ByteStream.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/ByteStream$SourceStream;", "Laws/smithy/kotlin/runtime/content/ByteStream;", "<init>", "()V", "Laws/smithy/kotlin/runtime/io/SdkSource;", "readFrom", "()Laws/smithy/kotlin/runtime/io/SdkSource;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class SourceStream extends ByteStream {
        public abstract SdkSource readFrom();

        public SourceStream() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: ByteStream.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/ByteStream$Companion;", "", "<init>", "()V", "", "str", "Laws/smithy/kotlin/runtime/content/ByteStream;", "fromString", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/content/ByteStream;", "", "bytes", "fromBytes", "([B)Laws/smithy/kotlin/runtime/content/ByteStream;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ByteStream fromString(String str) {
            Intrinsics.checkNotNullParameter(str, "str");
            return new StringContent(str);
        }

        public final ByteStream fromBytes(byte[] bytes) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            return new ByteArrayContent(bytes);
        }
    }
}
